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
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProviders;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ForumToolPerm;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0850a {
    private at eKr;
    private com.baidu.adp.lib.d.b<ImageView> fVL;
    private com.baidu.adp.lib.d.b<GifView> fVM;
    private com.baidu.adp.lib.d.b<TextView> fZb;
    private com.baidu.adp.lib.d.b<View> fZc;
    private com.baidu.adp.lib.d.b<LinearLayout> fZd;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZe;
    private com.baidu.tieba.tbadkCore.data.e ffO;
    private com.baidu.tbadk.core.message.a fge;
    private com.baidu.adp.lib.d.b<TbImageView> fnn;
    private LikeModel foW;
    private com.baidu.tieba.callfans.a izJ;
    private VoiceManager jie;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    private com.baidu.tieba.f.b jna;
    public com.baidu.tbadk.core.util.am kUB;
    public ar kYE;
    private String lPu;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lTD;
    private View lTE;
    private View lTF;
    private View lTG;
    private View lTH;
    int lTJ;
    private bk lTM;
    private com.baidu.tieba.pb.pb.report.a lTR;
    private com.baidu.tbadk.core.dialog.i lTY;
    private com.baidu.tbadk.core.dialog.k lTZ;
    private PbActivity lTk;
    private com.baidu.tieba.pb.pb.main.b.b lTn;
    private boolean lUa;
    private com.baidu.tieba.tbadkCore.data.f lUe;
    private com.baidu.tbadk.editortools.pb.g lUf;
    private com.baidu.tbadk.editortools.pb.e lUg;
    private com.baidu.tieba.frs.profession.permission.c lUi;
    private EmotionImageData lUj;
    private com.baidu.adp.base.f lUm;
    private com.baidu.tbadk.core.view.c lUn;
    private BdUniqueId lUo;
    private Runnable lUp;
    private com.baidu.adp.widget.ImageView.a lUq;
    private String lUr;
    private TbRichTextMemeInfo lUs;
    private List<a> lUv;
    public String lUx;
    private boolean lVa;
    private String lVj;
    private com.baidu.tbadk.core.data.t lVk;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lVg = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmw();
            } else {
                com.baidu.tieba.pb.a.b.dmv();
            }
        }
    };
    boolean lTl = true;
    private boolean lTm = false;
    private boolean lTo = false;
    private boolean isPaused = false;
    private boolean lot = false;
    private boolean lTp = true;
    private int lTq = 0;
    private com.baidu.tbadk.core.dialog.b lTr = null;
    private long iKN = -1;
    private long fKU = 0;
    private long lTs = 0;
    private long createTime = 0;
    private long fKL = 0;
    private boolean lTt = false;
    private com.baidu.tbadk.n.b lTu = null;
    private long lTv = 0;
    private boolean lTw = false;
    private long lTx = 0;
    private int jOS = 1;
    private String fFk = null;
    private boolean lTy = false;
    private boolean isFullScreen = false;
    private boolean lTz = false;
    private String lTA = "";
    private boolean lTB = true;
    private boolean lTC = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lTI = new int[2];
    private int lTK = -1;
    private int lTL = -1;
    public BdUniqueId lTN = BdUniqueId.gen();
    private boolean lTO = false;
    private boolean lTP = com.baidu.tbadk.a.d.bja();
    private PbInterviewStatusView.a lTQ = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lTU.vD(!PbFragment.this.lTB);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.bkb()) {
                        PbFragment.this.dnU();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lPy = null;
    private com.baidu.tbadk.baseEditMark.a lTS = null;
    private ForumManageModel gfY = null;
    private com.baidu.tbadk.coreExtra.model.a fce = null;
    private com.baidu.tieba.pb.data.r lTT = null;
    private ShareSuccessReplyToServerModel jEg = null;
    private ap lTU = null;
    private boolean lTV = false;
    private boolean lTW = false;
    private boolean lTX = false;
    private boolean gnW = false;
    private boolean lUb = false;
    private boolean lUc = false;
    private boolean lUd = false;
    private boolean lUh = false;
    public boolean lUk = false;
    private com.baidu.tbadk.editortools.pb.c fFn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBP() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fFo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (PbFragment.this.kYE == null || PbFragment.this.kYE.drV() == null || !PbFragment.this.kYE.drV().dWF()) {
                return !PbFragment.this.FL(com.baidu.tbadk.core.util.am.fbZ);
            }
            PbFragment.this.showToast(PbFragment.this.kYE.drV().dWH());
            if (PbFragment.this.lUg != null && (PbFragment.this.lUg.bCf() || PbFragment.this.lUg.bCg())) {
                PbFragment.this.lUg.a(false, PbFragment.this.kYE.drY());
            }
            PbFragment.this.kYE.vQ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lUl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (PbFragment.this.kYE == null || PbFragment.this.kYE.drW() == null || !PbFragment.this.kYE.drW().dWF()) {
                return !PbFragment.this.FL(com.baidu.tbadk.core.util.am.fca);
            }
            PbFragment.this.showToast(PbFragment.this.kYE.drW().dWH());
            if (PbFragment.this.lTU != null && PbFragment.this.lTU.dqz() != null && PbFragment.this.lTU.dqz().dnv() != null && PbFragment.this.lTU.dqz().dnv().bCg()) {
                PbFragment.this.lTU.dqz().dnv().a(PbFragment.this.kYE.drY());
            }
            PbFragment.this.kYE.vR(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jiS = false;
    private int lUt = 0;
    private int lUu = -1;
    public int lUw = 0;
    private final a lUy = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lTU != null && PbFragment.this.lTU.dqz() != null) {
                r dqz = PbFragment.this.lTU.dqz();
                if (dqz.dnt()) {
                    dqz.dnr();
                    return true;
                }
            }
            if (PbFragment.this.lTU != null && PbFragment.this.lTU.drA()) {
                PbFragment.this.lTU.drB();
                return true;
            }
            return false;
        }
    };
    private final ab.a lUz = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lTU.showToast(str);
            }
        }
    };
    private final CustomMessageListener lUA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lPy != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lUg != null) {
                    PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                }
                PbFragment.this.lTU.dqB();
                PbFragment.this.lTU.drt();
            }
        }
    };
    CustomMessageListener jjL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lPy.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lTU != null && PbFragment.this.lPy != null) {
                    PbFragment.this.lTU.b(PbFragment.this.lPy.getPbData(), PbFragment.this.lPy.doL(), PbFragment.this.lPy.dpj(), PbFragment.this.lTU.getSkinType());
                }
                if (PbFragment.this.lTU != null && PbFragment.this.lTU.dqT() != null) {
                    PbFragment.this.lTU.dqT().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lUB = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lTU != null) {
                    if (booleanValue) {
                        PbFragment.this.lTU.dqW();
                    } else {
                        PbFragment.this.lTU.dqX();
                    }
                }
            }
        }
    };
    private CustomMessageListener lUC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lUg != null) {
                    PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                }
                PbFragment.this.lTU.vK(false);
            }
        }
    };
    private CustomMessageListener lUD = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.q) eVar.getData());
                        return;
                    case 1:
                        PbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            PbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener lUE = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lTU != null && PbFragment.this.lTU.dqT() != null) {
                PbFragment.this.lTU.dqT().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jwA = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener jjH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.dom();
            }
        }
    };
    private View.OnClickListener fFW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fFk);
        }
    };
    private CustomMessageListener lUF = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ai)) {
                com.baidu.tbadk.core.data.ai aiVar = (com.baidu.tbadk.core.data.ai) customResponsedMessage.getData();
                bb.a aVar = new bb.a();
                aVar.giftId = aiVar.id;
                aVar.giftName = aiVar.name;
                aVar.thumbnailUrl = aiVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lPy.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lPy.dpa() != null && PbFragment.this.lPy.dpa().getUserIdLong() == aiVar.toUserId) {
                        PbFragment.this.lTU.a(aiVar.sendCount, PbFragment.this.lPy.getPbData(), PbFragment.this.lPy.doL(), PbFragment.this.lPy.dpj());
                    }
                    if (pbData.dlr() != null && pbData.dlr().size() >= 1 && pbData.dlr().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dlr().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lPy.doJ(), 0L);
                        if (j == aiVar.postId && j2 == aiVar.threadId) {
                            bb dNW = pbData.dlr().get(0).dNW();
                            if (dNW == null) {
                                dNW = new bb();
                            }
                            ArrayList<bb.a> bmJ = dNW.bmJ();
                            if (bmJ == null) {
                                bmJ = new ArrayList<>();
                            }
                            bmJ.add(0, aVar);
                            dNW.setTotal(aiVar.sendCount + dNW.getTotal());
                            dNW.y(bmJ);
                            pbData.dlr().get(0).a(dNW);
                            PbFragment.this.lTU.dqT().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lUG = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                PbFragment.this.lPy.getPbData().dlJ();
                PbFragment.this.lPy.dpf();
                if (PbFragment.this.lTU.dqT() != null) {
                    PbFragment.this.lTU.s(PbFragment.this.lPy.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.o oVar;
            if (customResponsedMessage != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Py(str);
                PbFragment.this.lPy.dpf();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lPy.getPbData().dlr() != null) {
                    ArrayList<PostData> dlr = PbFragment.this.lPy.getPbData().dlr();
                    Iterator<PostData> it = dlr.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            oVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof com.baidu.tieba.tbadkCore.data.o) && str.equals(((com.baidu.tieba.tbadkCore.data.o) next).getAdId())) {
                            oVar = (com.baidu.tieba.tbadkCore.data.o) next;
                            break;
                        }
                    }
                    if (oVar != null) {
                        dlr.remove(oVar);
                        if (PbFragment.this.lTU.dqT() != null && PbFragment.this.lTU.dqT().getDataList() != null) {
                            PbFragment.this.lTU.dqT().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lTU.getListView() != null && PbFragment.this.lTU.getListView().getData() != null) {
                            PbFragment.this.lTU.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lTU.dqT() != null) {
                            PbFragment.this.lTU.dqT().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lTU.dqT() != null) {
                    PbFragment.this.lTU.s(PbFragment.this.lPy.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lUH = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dso()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lUI = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lTU != null) {
                PbFragment.this.lTU.fn(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lUJ = false;
    private PraiseModel lUK = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Fi(String str) {
            PbFragment.this.lUJ = false;
            if (PbFragment.this.lUK != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lPy.getPbData();
                if (pbData.dlp().bnD().getIsLike() == 1) {
                    PbFragment.this.zW(0);
                } else {
                    PbFragment.this.zW(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dlp()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lUJ = false;
            if (PbFragment.this.lUK != null && str != null) {
                if (AntiHelper.bX(i, str)) {
                    AntiHelper.bq(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lUL = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void vg(boolean z) {
            PbFragment.this.ve(z);
            if (PbFragment.this.lTU.drG() != null && z) {
                PbFragment.this.lTU.vD(false);
            }
            PbFragment.this.lTU.vF(z);
        }
    };
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().fud != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().fud, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dly().bnS() != null && PbFragment.this.dly().bnS().getGodUserData() != null) {
                            PbFragment.this.dly().bnS().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null) {
                            PbFragment.this.lPy.getPbData().dlp().bnS().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTipsEventListener = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.lTk.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lUM = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lTU.ckD();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.FO(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cOG();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fxj = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dnE();
            }
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        if (PbFragment.this.dC(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.e((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lTU.dnC() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dmx() != null && PbFragment.this.dmx().iRC != null) {
                                PbFragment.this.dmx().iRC.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.e(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.lUg != null) {
                    PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                }
                PbFragment.this.lTU.dqB();
                PbFragment.this.lTU.drt();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lUN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lUo) {
                PbFragment.this.lTU.ckD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lPy.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlF().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lUn.showSuccessToast(PbFragment.this.lUm.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lUm.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Dh(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.doi();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lUm.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lUn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lUO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lUo) {
                PbFragment.this.lTU.ckD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lUn.showSuccessToast(PbFragment.this.lUm.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lUm.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lUn.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lUP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lUo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lTU.ckD();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nME;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    PbFragment.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbFragment.this.lTU.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lUQ = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lTU.dqC() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dnE();
            }
        }
    };
    private CustomMessageListener jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.jiS = true;
                }
            }
        }
    };
    public a.b lzw = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cDi();
            az pageData = PbFragment.this.lPy.getPageData();
            int pageNum = PbFragment.this.lTU.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bmC()) {
                PbFragment.this.lTU.drt();
                PbFragment.this.cDh();
                PbFragment.this.lTU.dra();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lPy.FS(PbFragment.this.lTU.getPageNum());
                    if (PbFragment.this.lTn != null) {
                        PbFragment.this.lTn.showFloatingView();
                    }
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbFragment.this.showToast(R.string.pb_page_error);
            }
        }
    };
    private k.c lUR = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lTY != null) {
                PbFragment.this.lTY.dismiss();
            }
            PbFragment.this.FK(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.dD(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.dD(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.bjl() || com.baidu.tbadk.a.d.bjm()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            PbFragment.this.dD(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    if (view5 != null) {
                        AgreeView agreeView2 = (AgreeView) view5;
                        PbFragment.this.dD(view5);
                        if (agreeView2.getImgDisagree() != null) {
                            agreeView2.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.bjl() || com.baidu.tbadk.a.d.bjm()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        if (view6 != null) {
                            PbFragment.this.dD(view6);
                            AgreeView agreeView3 = (AgreeView) view6;
                            if (agreeView3.getImgAgree() != null) {
                                agreeView3.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    if (view7 != null) {
                        PbFragment.this.dD(view7);
                        AgreeView agreeView4 = (AgreeView) view7;
                        if (agreeView4.getImgAgree() != null) {
                            agreeView4.getImgAgree().performClick();
                            return;
                        }
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (PbFragment.this.lUq != null && !TextUtils.isEmpty(PbFragment.this.lUr)) {
                        if (PbFragment.this.lUs == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lUr));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lUr;
                            aVar.pkgId = PbFragment.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lUs.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lUq = null;
                        PbFragment.this.lUr = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lUq != null && !TextUtils.isEmpty(PbFragment.this.lUr)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eKr == null) {
                                PbFragment.this.eKr = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eKr.o(PbFragment.this.lUr, PbFragment.this.lUq.getImageByte());
                            PbFragment.this.lUq = null;
                            PbFragment.this.lUr = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.ksi != null) {
                        PbFragment.this.ksi.gV(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.ksi = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").aq("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dE(view);
                        if (PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null && PbFragment.this.lPy.getPbData().dlp().bnS().getUserId() != null && PbFragment.this.lTS != null) {
                            int h = PbFragment.this.h(PbFragment.this.lPy.getPbData());
                            cb dlp = PbFragment.this.lPy.getPbData().dlp();
                            if (dlp.bmz()) {
                                i2 = 2;
                            } else if (dlp.bmA()) {
                                i2 = 3;
                            } else if (dlp.bpP()) {
                                i2 = 4;
                            } else {
                                i2 = dlp.bpQ() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lPy.lXe).aq("obj_locate", 2).dR("obj_id", PbFragment.this.lPy.getPbData().dlp().bnS().getUserId()).aq("obj_type", PbFragment.this.lTS.bkb() ? 0 : 1).aq("obj_source", h).aq("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13079"));
                        PbFragment.this.PA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").aq("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.d(sparseArray4);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.lTU.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null) {
                        boolean booleanValue = ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray6.put(R.id.tag_from, 1);
                                sparseArray6.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.d(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.lTU.dL(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lTU.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpL() != null) {
                            PbFragment.this.d(postData.bpL());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lUS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zq(int i) {
            PbFragment.this.lTU.drt();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lPy == null || PbFragment.this.lPy.isLoading) {
                    return false;
                }
                PbFragment.this.cDh();
                PbFragment.this.lTU.dra();
                if (PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().lMo != null && PbFragment.this.lPy.getPbData().lMo.size() > i) {
                    int intValue = PbFragment.this.lPy.getPbData().lMo.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", PbFragment.this.lPy.doK()).dR("fid", PbFragment.this.lPy.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).aq("obj_type", FQ(intValue)));
                    if (PbFragment.this.lPy.FX(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lTU.vy(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int FQ(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    public final View.OnClickListener jkS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:835:0x24f2  */
        /* JADX WARN: Removed duplicated region for block: B:838:0x2536  */
        /* JADX WARN: Removed duplicated region for block: B:855:0x2710  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            String name;
            int i;
            int i2;
            int fixedNavHeight;
            cg cgVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar3;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean J;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.lTU.drp()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lPy.vm(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lTU.drb();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dqa()) {
                        if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dqb()) {
                            if (view == PbFragment.this.lTU.mbb.fNw) {
                                if (PbFragment.this.lTU.vH(PbFragment.this.lPy.doR())) {
                                    PbFragment.this.cDh();
                                    return;
                                }
                                PbFragment.this.lTp = false;
                                PbFragment.this.lTo = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lTk, PbFragment.this.lTU.mbb.fNw);
                                PbFragment.this.lTk.finish();
                            } else if (view != PbFragment.this.lTU.dqY() && (PbFragment.this.lTU.mbb.dsB() == null || (view != PbFragment.this.lTU.mbb.dsB().dpZ() && view != PbFragment.this.lTU.mbb.dsB().dpX()))) {
                                if (view == PbFragment.this.lTU.drx()) {
                                    if (PbFragment.this.lPy != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPy.getPbData().dlp().bnR().getLink());
                                    }
                                } else if (view != PbFragment.this.lTU.mbb.mhF) {
                                    if (view == PbFragment.this.lTU.mbb.jyL) {
                                        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                                            if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                ArrayList<PostData> dlr = PbFragment.this.lPy.getPbData().dlr();
                                                if ((dlr == null || dlr.size() <= 0) && PbFragment.this.lPy.doL()) {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", PbFragment.this.lPy.doJ()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.lPy.getForumId()));
                                                if (!PbFragment.this.lTU.drL()) {
                                                    PbFragment.this.lTU.dqB();
                                                }
                                                PbFragment.this.dnM();
                                            } else {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lTU.uS(true);
                                            PbFragment.this.lTU.dqB();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lTU.dqW();
                                                PbFragment.this.cDh();
                                                PbFragment.this.lTU.dra();
                                                PbFragment.this.lPy.PF(PbFragment.this.dnY());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dpW()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lTU.mbb.dsB() != null && view == PbFragment.this.lTU.mbb.dsB().dpV()) {
                                                PbFragment.this.lTU.mbb.baP();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.FP(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dpT()) {
                                                    if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dqd()) {
                                                        if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dpU()) {
                                                            if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dqe()) {
                                                                if (PbFragment.this.lTU.drG() == view) {
                                                                    if (PbFragment.this.lTU.drG().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lPy.getPbData();
                                                                        if (pbData2 != null && pbData2.dlp() != null && pbData2.dlp().bny() != null) {
                                                                            String bno = pbData2.dlp().bny().bno();
                                                                            if (StringUtils.isNull(bno)) {
                                                                                bno = pbData2.dlp().bny().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dR("obj_id", bno));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gz("c10725", null);
                                                                    }
                                                                    PbFragment.this.dof();
                                                                } else if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dqc()) {
                                                                    if (PbFragment.this.lTU.mbb.dsB() != null && view == PbFragment.this.lTU.mbb.dsB().dpY()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lTU.b(PbFragment.this.lPy.getPbData(), PbFragment.this.lPy.doL(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lTU.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lTU.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lTU.mbb.baP();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dR("tid", PbFragment.this.lPy.doJ());
                                                                            arVar.dR("fid", PbFragment.this.lPy.getForumId());
                                                                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.aq("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (view.getId() == R.id.pb_floor_reply_more && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                            PbFragment.this.lTF = view;
                                                                            return;
                                                                        } else if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                PbFragment.this.lTU.drt();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dOa() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.nzY != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsQ = postData.nzY.bsQ();
                                                                                        bsQ.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bsQ.aq("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bsQ.aq("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bsQ);
                                                                                    }
                                                                                    String doJ = PbFragment.this.lPy.doJ();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lPy.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lPy.getPbData().dlE();
                                                                                    }
                                                                                    PbFragment.this.cDh();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a PD = PbFragment.this.PD(id);
                                                                                        if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PD != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doJ, id, "pb", true, null, true, null, i3, postData.dtB(), PbFragment.this.lPy.getPbData().getAnti(), false, postData.bnS().getIconInfo()).addBigImageData(PD.lPM, PD.eLn, PD.eLl, PD.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lPy.dpu());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lPy.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lPy.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lPy.doT());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a PD2 = PbFragment.this.PD(id);
                                                                                        if (postData != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PD2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doJ, id, "pb", true, null, false, str2, i3, postData.dtB(), PbFragment.this.lPy.getPbData().getAnti(), false, postData.bnS().getIconInfo()).addBigImageData(PD2.lPM, PD2.eLn, PD2.eLl, PD2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lPy.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lPy.doT());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lPy.dpu());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lPy.getFromForumId());
                                                                                            if (PbFragment.this.lTU != null) {
                                                                                                addBigImageData2.setMainPostMaskVisibly(PbFragment.this.lTU.b(PbFragment.this.lPy.lQH, PbFragment.this.lPy.doL()).nzP || postData.nzP);
                                                                                            }
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData2));
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").aq("obj_locate", 3).dR("fid", PbFragment.this.lPy.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lPy != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dR("tid", PbFragment.this.lPy.doJ());
                                                                            arVar2.dR("fid", PbFragment.this.lPy.getForumId());
                                                                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.aq("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (view.getId() == R.id.pb_post_reply_count && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                                PbFragment.this.lTF = view;
                                                                                return;
                                                                            } else if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nzY != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsQ2 = postData3.nzY.bsQ();
                                                                                        bsQ2.delete("obj_locate");
                                                                                        bsQ2.aq("obj_locate", 8);
                                                                                        TiebaStatic.log(bsQ2);
                                                                                    }
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                        String doJ2 = PbFragment.this.lPy.doJ();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lPy.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lPy.getPbData().dlE();
                                                                                        }
                                                                                        PbActivity.a PD3 = PbFragment.this.PD(id2);
                                                                                        if (PD3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doJ2, id2, "pb", true, null, false, null, i4, postData3.dtB(), PbFragment.this.lPy.getPbData().getAnti(), false, postData3.bnS().getIconInfo()).addBigImageData(PD3.lPM, PD3.eLn, PD3.eLl, PD3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lPy.dpu());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lPy.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lPy.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lPy.doT());
                                                                                            if (PbFragment.this.lPy.getPbData().dlY() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lPy.getPbData().dlY().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lPy.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lPy.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lPy.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lPy.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lPy.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lPy.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lPy.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lPy.getPbData().getForum().getUser_level());
                                                                                            }
                                                                                            if (PbFragment.this.lTU != null) {
                                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.lTU.b(PbFragment.this.lPy.lQH, PbFragment.this.lPy.doL()).nzP || postData3.nzP);
                                                                                            }
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData3));
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
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                        if (PbFragment.this.lPy != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dR("tid", PbFragment.this.lPy.doJ());
                                                                                arVar3.dR("fid", PbFragment.this.lPy.getForumId());
                                                                                arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.aq("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (view.getId() == R.id.post_info_commont_img) {
                                                                                if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                    PbFragment.this.lTG = view;
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.lTG = view;
                                                                                return;
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nzY != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsQ3 = postData4.nzY.bsQ();
                                                                                        bsQ3.delete("obj_locate");
                                                                                        bsQ3.aq("obj_locate", 8);
                                                                                        TiebaStatic.log(bsQ3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", PbFragment.this.lPy.doK()).dR("fid", PbFragment.this.lPy.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).aq("obj_source", 1).aq("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.dnB().dqy() != null && postData4.bnS() != null && postData4.dNO() != 1) {
                                                                                        if (PbFragment.this.dnB().dqz() != null) {
                                                                                            PbFragment.this.dnB().dqz().dnq();
                                                                                        }
                                                                                        if (PbFragment.this.lTP && postData4.dNL() != null && postData4.dNL().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                                                                                            qVar.a(PbFragment.this.lPy.getPbData().getForum());
                                                                                            qVar.setThreadData(PbFragment.this.lPy.getPbData().dlp());
                                                                                            qVar.g(postData4);
                                                                                            PbFragment.this.dnB().dqy().d(qVar);
                                                                                            PbFragment.this.dnB().dqy().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bnS().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lUg != null) {
                                                                                                PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                                                                                            }
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
                                                                    } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                        if (view != PbFragment.this.lTU.dmQ()) {
                                                                            if (view == PbFragment.this.lTU.mbb.dsC()) {
                                                                                PbFragment.this.lTU.drh();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cgVar = (cg) view.getTag()) != null && !StringUtils.isNull(cgVar.bqm())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        bf.bsY().b(PbFragment.this.getPageContext(), new String[]{cgVar.bqm()});
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData5 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dR("tid", PbFragment.this.lPy.lXe));
                                                                                            }
                                                                                            if (PbFragment.this.lTZ == null) {
                                                                                                PbFragment.this.lTZ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lTZ.a(PbFragment.this.lUR);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dG(view);
                                                                                            if (!PbFragment.this.dG(view) || PbFragment.this.lUq == null || !PbFragment.this.lUq.isGif()) {
                                                                                            }
                                                                                            boolean z3 = false;
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            String str3 = null;
                                                                                            if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                                z3 = ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z4 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                                z5 = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z6 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                                z7 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                                str3 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData5 != null) {
                                                                                                if (postData5.dNQ() != null && postData5.dNQ().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lTZ);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eWK.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.ksi = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lPy.getPbData().bkb()) {
                                                                                                String bka = PbFragment.this.lPy.getPbData().bka();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bka) && bka.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lTZ);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lTZ);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.ksi);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eWK.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lTZ);
                                                                                                            SparseArray sparseArray8 = new SparseArray();
                                                                                                            sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                            sparseArray8.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            sparseArray8.put(R.id.tag_del_post_is_self, sparseArray5.get(R.id.tag_del_post_is_self));
                                                                                                            sparseArray8.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            sparseArray8.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray8.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            gVar.eWK.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar5);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.va(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lTZ);
                                                                                                                gVar6.eWK.setTag(str3);
                                                                                                                arrayList.add(gVar6);
                                                                                                            }
                                                                                                        }
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = null;
                                                                                                        if (z5) {
                                                                                                            SparseArray sparseArray9 = new SparseArray();
                                                                                                            sparseArray9.put(R.id.tag_should_manage_visible, true);
                                                                                                            sparseArray9.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name, sparseArray5.get(R.id.tag_forbid_user_name));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name_show, sparseArray5.get(R.id.tag_forbid_user_name_show));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_portrait, sparseArray5.get(R.id.tag_forbid_user_portrait));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str3);
                                                                                                            if (z6) {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_is_mem, sparseArray5.get(R.id.tag_is_mem));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_userid, sparseArray5.get(R.id.tag_user_mute_mute_userid));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_username, sparseArray5.get(R.id.tag_user_mute_mute_username));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_mute_nameshow, sparseArray5.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_post_id, sparseArray5.get(R.id.tag_user_mute_post_id));
                                                                                                                sparseArray9.put(R.id.tag_user_mute_thread_id, sparseArray5.get(R.id.tag_user_mute_thread_id));
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                            }
                                                                                                            if (z7) {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lTZ);
                                                                                                                gVar2.eWK.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lTZ);
                                                                                                            gVar8.eWK.setTag(sparseArray9);
                                                                                                            gVar7 = gVar8;
                                                                                                        } else if (!z7) {
                                                                                                            gVar2 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.lPy.getPbData().dlE() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lTZ);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lTZ);
                                                                                                            }
                                                                                                            gVar2.eWK.setTag(sparseArray10);
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar7 != null) {
                                                                                                            arrayList.add(gVar7);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lTZ.bw(arrayList);
                                                                                                    PbFragment.this.lTY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lTZ);
                                                                                                    PbFragment.this.lTY.QH();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.ksi);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eWK.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lTZ.bw(arrayList);
                                                                                            PbFragment.this.lTY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lTZ);
                                                                                            PbFragment.this.lTY.QH();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lPy.getPbData().dlp().getActUrl());
                                                                                        if (PbFragment.this.lPy.getPbData().dlp().boE() != 1) {
                                                                                            if (PbFragment.this.lPy.getPbData().dlp().boE() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dR("fid", PbFragment.this.lPy.getPbData().getForumId()).dR("tid", PbFragment.this.lPy.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lPy.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lTU.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bh.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.brR().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lTU.dqB();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dnK() == 1 && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dR("fid", PbFragment.this.lPy.getPbData().getForumId()).dR("tid", PbFragment.this.lPy.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dnK() == 1 && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dR("fid", PbFragment.this.lPy.getPbData().getForumId()).dR("tid", PbFragment.this.lPy.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.doa();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dob();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlL() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lPy.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dR("fid", pbData3.getForumId()));
                                                                                        bf.bsY().b(PbFragment.this.getPageContext(), new String[]{pbData3.dlL().dlZ()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlL() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lPy.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", pbData4.getForumId()));
                                                                                        bf.bsY().b(PbFragment.this.getPageContext(), new String[]{pbData4.dlL().dlZ()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lUt >= 0) {
                                                                                        if (PbFragment.this.lPy != null) {
                                                                                            PbFragment.this.lPy.dpv();
                                                                                        }
                                                                                        if (PbFragment.this.lPy != null && PbFragment.this.lTU.dqT() != null) {
                                                                                            PbFragment.this.lTU.dqT().a(PbFragment.this.lPy.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lUt = 0;
                                                                                        if (PbFragment.this.lPy != null) {
                                                                                            PbFragment.this.lTU.getListView().setSelection(PbFragment.this.lPy.dpy());
                                                                                            PbFragment.this.lPy.da(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.FP(8);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                    SparseArray sparseArray11 = null;
                                                                                    if (view.getTag() instanceof SparseArray) {
                                                                                        sparseArray11 = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray11 != null) {
                                                                                        PbFragment.this.e(sparseArray11);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                    if (PbFragment.this.lTU.getListView() != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lTU.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lTU.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dlP = PbFragment.this.lPy.getPbData().dlP();
                                                                                        boolean z8 = PbFragment.this.lTU.dqA() != null && PbFragment.this.lTU.dqA().isVertical();
                                                                                        boolean drq = PbFragment.this.lTU.drq();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (dlP && PbFragment.this.lTU.dqA() != null && PbFragment.this.lTU.dqA().getContainerView() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lTU.dqA().dsl();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lTU.dqA().getContainerView().getHeight() - PbFragment.this.lTU.dqA().dsl());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.PE("c13568");
                                                                                        if ((PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnJ() <= 0) || (drq && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dnH();
                                                                                                if (PbFragment.this.lPy.getPbData().dlp().bnS() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lPy.lXe).dR("fid", PbFragment.this.lPy.getPbData().getForumId()).aq("obj_locate", 2).dR("uid", PbFragment.this.lPy.getPbData().dlp().bnS().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dlP) {
                                                                                                if (PbFragment.this.lTU.mcm != null && PbFragment.this.lTU.mcm.mdu != null && PbFragment.this.lTU.mcm.mdu.getView() != null) {
                                                                                                    if (PbFragment.this.lTU.mcm.mdu.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dnQ();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lTU.dqA() != null && PbFragment.this.lTU.dqA().getContainerView() != null) {
                                                                                                            i5 = PbFragment.this.lTU.dqA().getContainerView().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lTU.mcm.mdu.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lTU.dqK() != null) {
                                                                                                z10 = PbFragment.this.lTU.dqK().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lTU.mcm != null && PbFragment.this.lTU.mcm.mdu != null && PbFragment.this.lTU.mcm.mdu.getView() != null && PbFragment.this.lTU.mcm.mdu.getView().getParent() != null && PbFragment.this.lTU.mbb != null && PbFragment.this.lTU.mbb.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lTU.mcm.mdu.getView().getTop() - PbFragment.this.lTU.mbb.mNavigationBar.getBottom() < PbFragment.this.lTU.mcm.mdu.maB.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || drq) {
                                                                                                PbFragment.this.lTK = firstVisiblePosition;
                                                                                                PbFragment.this.lTL = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lTU.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lTK > 0) {
                                                                                                if (PbFragment.this.lTU.getListView().getChildAt(PbFragment.this.lTK) != null) {
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollToPosition(PbFragment.this.lTK, PbFragment.this.lTL, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lTU.getListView().setSelectionFromTop(PbFragment.this.lTK, PbFragment.this.lTL + equipmentHeight);
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dnQ = PbFragment.this.dnQ();
                                                                                                if (PbFragment.this.dnP() != -1) {
                                                                                                    dnQ--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dnQ < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lTU.getListView().getData()) - 1) + PbFragment.this.lTU.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dnQ;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!dlP || PbFragment.this.lTU.dqA() == null) ? (PbFragment.this.lTU.mbb == null || PbFragment.this.lTU.mbb.mNavigationBar == null) ? dimens : (PbFragment.this.lTU.mbb.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lTU.dqA().dsk() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lTU.mcm == null || PbFragment.this.lTU.mcm.mdu == null || PbFragment.this.lTU.mcm.mdu.getView() == null || PbFragment.this.lTU.mcm.mdu.getView().getParent() == null) {
                                                                                                    PbFragment.this.lTU.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lTU.getListView().smoothScrollBy(PbFragment.this.lTU.mcm.mdu.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lPy.lXe).dR("fid", PbFragment.this.lPy.getPbData().getForumId()).aq("obj_locate", 2).dR("uid", PbFragment.this.lPy.getPbData().dlp().bnS().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lPy.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lPy.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lPy.dmz()) || PbFragment.this.lPy.getAppealInfo() == null) {
                                                                                                PbFragment.this.lTk.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lPy.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lPy.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lTk.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dmz = PbFragment.this.lPy.dmz();
                                                                                        if (PbFragment.this.lPy.doM() && dmz != null && dmz.equals(name)) {
                                                                                            PbFragment.this.lTk.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lPy.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dR("tid", PbFragment.this.lPy.doJ());
                                                                                        arVar4.dR("fid", PbFragment.this.lPy.getForumId());
                                                                                        arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lPy.getPbData().dlp() != null) {
                                                                                            arVar4.dR(IntentConfig.NID, PbFragment.this.lPy.getPbData().dlp().bmq());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof cb) {
                                                                                        cb cbVar = (cb) view.getTag();
                                                                                        if (PbFragment.this.lPy.dpu() == 3 && PbFragment.this.dmy() && PbFragment.this.lPy.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lPy.getPbData().dlM())) {
                                                                                            PbFragment.this.lTk.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(cbVar.bnW(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c13399");
                                                                                        arVar5.dR("tid", cbVar.getId());
                                                                                        arVar5.v("fid", cbVar.getFid());
                                                                                        arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar5.dR(IntentConfig.NID, cbVar.bmq());
                                                                                        TiebaStatic.log(arVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lPy != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dR("tid", PbFragment.this.lPy.doJ());
                                                                                        arVar6.dR("fid", PbFragment.this.lPy.getForumId());
                                                                                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.aq("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lPy.getPbData();
                                                                                        if (PbFragment.this.lTT == null) {
                                                                                            PbFragment.this.lTT = new com.baidu.tieba.pb.data.r(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").v("forum_id", j2).bsR();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lUV);
                                                                                        PbFragment.this.lTT.M(j, j2);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_video_thread_smart_app_layout) {
                                                                                    if (view.getTag() instanceof SmartApp) {
                                                                                        SmartApp smartApp = (SmartApp) view.getTag();
                                                                                        if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                            if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), smartApp.h5_url);
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dR("fid", PbFragment.this.lPy.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).v("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.lPy.doJ()).aq("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof cb) {
                                                                                        cb cbVar2 = (cb) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(cbVar2.bnW(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_adlocate", 9).aq("obj_locate", 9).v("obj_id", cbVar2.getFid()).dR("tid", cbVar2.getId()).aq("thread_type", cbVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof cb) && PbFragment.this.checkUpIsLogin()) {
                                                                                        cb cbVar3 = (cb) view.getTag();
                                                                                        if (PbFragment.this.foW != null) {
                                                                                            PbFragment.this.foW.gy(cbVar3.bnW(), String.valueOf(cbVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_adlocate", 10).aq("obj_locate", 11).v("obj_id", cbVar3.getFid()).dR("tid", cbVar3.getId()).aq("thread_type", cbVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                    arVar7.dR("tid", PbFragment.this.lPy.doJ());
                                                                                    arVar7.dR("fid", PbFragment.this.lPy.getForumId());
                                                                                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    arVar7.aq("obj_locate", 7);
                                                                                    TiebaStatic.log(arVar7);
                                                                                    PbFragment.this.lTl = false;
                                                                                    PbFragment.this.dF(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lPy.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lPy.doJ(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lPy.getPbData().dlp().bom())));
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            sparseArray = (SparseArray) view.getTag();
                                                                        } catch (ClassCastException e) {
                                                                            e.printStackTrace();
                                                                            sparseArray = null;
                                                                        }
                                                                        PostData postData6 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                        if (postData6 != null) {
                                                                            if (PbFragment.this.lTZ == null) {
                                                                                PbFragment.this.lTZ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lTZ.a(PbFragment.this.lUR);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dmG().getPbData() != null && PbFragment.this.dmG().getPbData().dlS();
                                                                            if (view != null && sparseArray != null) {
                                                                                boolean z12 = false;
                                                                                boolean z13 = false;
                                                                                boolean z14 = false;
                                                                                boolean z15 = false;
                                                                                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                                    z2 = false;
                                                                                } else {
                                                                                    z2 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z12 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                    z13 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z14 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                    z15 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                }
                                                                                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                                                                                }
                                                                                if (postData6.bpL() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bpL().hasAgree && postData6.bpv() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lTZ);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eWK.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lTZ);
                                                                                        SparseArray sparseArray13 = new SparseArray();
                                                                                        sparseArray13.put(R.id.tag_user_mute_visible, true);
                                                                                        sparseArray13.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                        sparseArray13.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                        sparseArray13.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                        sparseArray13.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        sparseArray13.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                                                                                        sparseArray13.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                        sparseArray13.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                        sparseArray13.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        gVar10.eWK.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar10);
                                                                                    } else {
                                                                                        if ((PbFragment.this.va(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lTZ);
                                                                                            gVar11.eWK.setTag(str);
                                                                                            arrayList2.add(gVar11);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar12 = null;
                                                                                    if (z13) {
                                                                                        SparseArray sparseArray14 = new SparseArray();
                                                                                        sparseArray14.put(R.id.tag_should_manage_visible, true);
                                                                                        sparseArray14.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_post_id, str);
                                                                                        if (z14) {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, true);
                                                                                            sparseArray14.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                                            sparseArray14.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                                            sparseArray14.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                                            sparseArray14.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_user_mute_visible, false);
                                                                                        }
                                                                                        if (z15) {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray14.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray14.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lTZ);
                                                                                            gVar12.eWK.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lTZ);
                                                                                        gVar3.eWK.setTag(sparseArray14);
                                                                                    } else {
                                                                                        if (z15) {
                                                                                            SparseArray sparseArray15 = new SparseArray();
                                                                                            sparseArray15.put(R.id.tag_should_manage_visible, false);
                                                                                            sparseArray15.put(R.id.tag_user_mute_visible, false);
                                                                                            sparseArray15.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray15.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                            sparseArray15.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray15.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray15.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            if (PbFragment.this.lPy.getPbData().dlE() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lTZ);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lTZ);
                                                                                            }
                                                                                            gVar12.eWK.setTag(sparseArray15);
                                                                                        }
                                                                                        gVar3 = null;
                                                                                    }
                                                                                    if (gVar12 != null) {
                                                                                        arrayList2.add(gVar12);
                                                                                    }
                                                                                    if (gVar3 != null) {
                                                                                        arrayList2.add(gVar3);
                                                                                    }
                                                                                }
                                                                                PbFragment.this.lTZ.bw(arrayList2);
                                                                                PbFragment.this.lTY = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lTZ);
                                                                                PbFragment.this.lTY.QH();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lTU.drt();
                                                                    SparseArray<Object> b3 = PbFragment.this.lTU.b(PbFragment.this.lPy.getPbData(), PbFragment.this.lPy.doL(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPy.getPbData().getForum().getId(), PbFragment.this.lPy.getPbData().getForum().getName(), PbFragment.this.lPy.getPbData().dlp().getId(), String.valueOf(PbFragment.this.lPy.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    PbFragment.this.showToast(R.string.network_not_available);
                                                                    return;
                                                                }
                                                            } else {
                                                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                if (skinType == 1) {
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    com.baidu.tbadk.core.util.ap.B(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).aq("obj_type", 0).aq("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).aq("obj_type", 1).aq("obj_source", 1));
                                                                }
                                                                PbFragment.this.lTU.mbb.dsA();
                                                            }
                                                        } else if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null) {
                                                            PbFragment.this.lTU.mbb.baP();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.PA(PbFragment.this.lPy.getPbData().dlp().boi());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lTU.drt();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lPy.dpd()));
                                                                return;
                                                            }
                                                            PbFragment.this.cDh();
                                                            PbFragment.this.lTU.dra();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lPy.getPbData().lMo == null || PbFragment.this.lPy.getPbData().lMo.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lPy.getPbData().lMo.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lPy.getPbData().lMo.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lPy.getPbData().lMo.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lPy.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lPy.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lPy.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lPy.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").aq("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aq("obj_type", i9));
                                                                    if (PbFragment.this.lPy.getPbData().lMo != null && PbFragment.this.lPy.getPbData().lMo.size() > i8) {
                                                                        i8 = PbFragment.this.lPy.getPbData().lMo.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean FX = PbFragment.this.lPy.FX(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lPy.dpd()));
                                                                    if (FX) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lTU.vy(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.QH();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lTU.drt();
                                                    if (PbFragment.this.dmG().getPbData().lMp != 2) {
                                                        if (PbFragment.this.lPy.getPageData() != null) {
                                                            PbFragment.this.lTU.a(PbFragment.this.lPy.getPageData(), PbFragment.this.lzw);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lPy.getPbData()) != null) {
                                                cb dlp = pbData.dlp();
                                                if (dlp != null && dlp.bnS() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lPy.lXe).dR("fid", pbData.getForumId()).aq("obj_locate", 4).dR("uid", dlp.bnS().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (dlp != null) {
                                                    if (dlp.bmz()) {
                                                        i8 = 2;
                                                    } else if (dlp.bmA()) {
                                                        i8 = 3;
                                                    } else if (dlp.bpP()) {
                                                        i8 = 4;
                                                    } else if (dlp.bpQ()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar8.dR("tid", PbFragment.this.lPy.doJ());
                                                arVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar8.dR("fid", PbFragment.this.lPy.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar8.aq("obj_locate", 5);
                                                } else {
                                                    arVar8.aq("obj_locate", 6);
                                                }
                                                arVar8.aq("obj_name", i8);
                                                arVar8.aq("obj_type", 1);
                                                if (dlp != null) {
                                                    if (dlp.bmz()) {
                                                        arVar8.aq("obj_type", 10);
                                                    } else if (dlp.bmA()) {
                                                        arVar8.aq("obj_type", 9);
                                                    } else if (dlp.bpQ()) {
                                                        arVar8.aq("obj_type", 8);
                                                    } else if (dlp.bpP()) {
                                                        arVar8.aq("obj_type", 7);
                                                    } else if (dlp.isShareThread) {
                                                        arVar8.aq("obj_type", 6);
                                                    } else if (dlp.threadType == 0) {
                                                        arVar8.aq("obj_type", 1);
                                                    } else if (dlp.threadType == 40) {
                                                        arVar8.aq("obj_type", 2);
                                                    } else if (dlp.threadType == 49) {
                                                        arVar8.aq("obj_type", 3);
                                                    } else if (dlp.threadType == 54) {
                                                        arVar8.aq("obj_type", 4);
                                                    } else {
                                                        arVar8.aq("obj_type", 5);
                                                    }
                                                    arVar8.aq(IntentConfig.CARD_TYPE, dlp.bpT());
                                                    arVar8.dR(IntentConfig.RECOM_SOURCE, dlp.mRecomSource);
                                                    arVar8.dR("ab_tag", dlp.mRecomAbTag);
                                                    arVar8.dR("weight", dlp.mRecomWeight);
                                                    arVar8.dR("extra", dlp.mRecomExtra);
                                                    arVar8.dR(IntentConfig.NID, dlp.bmq());
                                                    if (dlp.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dlp.getBaijiahaoData().oriUgcVid)) {
                                                        arVar8.dR("obj_param6", dlp.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar8.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.doq() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.doq(), arVar8);
                                                }
                                                TiebaStatic.log(arVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dlr2 = PbFragment.this.lPy.getPbData().dlr();
                                                    if ((dlr2 != null && dlr2.size() > 0) || !PbFragment.this.lPy.doL()) {
                                                        PbFragment.this.lTU.drt();
                                                        PbFragment.this.cDh();
                                                        if (pbData.dlL() != null && !StringUtils.isNull(pbData.dlL().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", PbFragment.this.lPy.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dlp)) {
                                                            if (PbFragment.this.lTU != null) {
                                                                PbFragment.this.lTU.drw();
                                                                PbFragment.this.lTU.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lTU.showLoadingDialog();
                                                                PbFragment.this.lPy.dpp().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i9 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i9 = 1;
                                                                }
                                                                PbFragment.this.FO(i9);
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lTU.drt();
                                            if (PbFragment.this.lTU.mbb.dsB() != null && view == PbFragment.this.lTU.mbb.dsB().dpW() && !PbFragment.this.lTU.drL()) {
                                                PbFragment.this.lTU.dqB();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cDh();
                                                PbFragment.this.lTU.dra();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    J = PbFragment.this.lPy.J(true, PbFragment.this.dnY());
                                                } else {
                                                    J = view.getId() == R.id.reply_title ? PbFragment.this.lPy.J(false, PbFragment.this.dnY()) : PbFragment.this.lPy.PF(PbFragment.this.dnY());
                                                }
                                                view.setTag(Boolean.valueOf(J));
                                                if (J) {
                                                    PbFragment.this.lTU.uS(true);
                                                    PbFragment.this.lTU.dqW();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lTU.vy(true);
                                                }
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.lTU.drt();
                                        if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                            if (PbFragment.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lPy.FY(PbFragment.this.lTU.drf()) != null) {
                                                PbFragment.this.dnT();
                                                if (PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lPy.lXe).dR("fid", PbFragment.this.lPy.getPbData().getForumId()).aq("obj_locate", 3).dR("uid", PbFragment.this.lPy.getPbData().dlp().bnS().getUserId()));
                                                }
                                                if (PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null && PbFragment.this.lPy.getPbData().dlp().bnS().getUserId() != null && PbFragment.this.lTS != null) {
                                                    int h = PbFragment.this.h(PbFragment.this.lPy.getPbData());
                                                    cb dlp2 = PbFragment.this.lPy.getPbData().dlp();
                                                    int i10 = 1;
                                                    if (dlp2.bmz()) {
                                                        i10 = 2;
                                                    } else if (dlp2.bmA()) {
                                                        i10 = 3;
                                                    } else if (dlp2.bpP()) {
                                                        i10 = 4;
                                                    } else if (dlp2.bpQ()) {
                                                        i10 = 5;
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lPy.lXe).aq("obj_locate", 1).dR("obj_id", PbFragment.this.lPy.getPbData().dlp().bnS().getUserId()).aq("obj_type", PbFragment.this.lTS.bkb() ? 0 : 1).aq("obj_source", h).aq("obj_param1", i10));
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.lTH = view;
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bmx() && PbFragment.this.lPy.getPbData().dlp().boj() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lPy.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lPy.dmz()) || PbFragment.this.lPy.getAppealInfo() == null) {
                                            PbFragment.this.lTk.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lPy.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lPy.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lTk.finish();
                                        return;
                                    }
                                    String dmz2 = PbFragment.this.lPy.dmz();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lPy.doM() && dmz2 != null && dmz2.equals(name2)) {
                                        PbFragment.this.lTk.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lPy.getPbData() != null && !PbFragment.this.gfY.dOJ()) {
                                    PbFragment.this.lTU.drt();
                                    int i11 = 0;
                                    if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dpX()) {
                                        if (PbFragment.this.lTU.mbb.dsB() == null || view != PbFragment.this.lTU.mbb.dsB().dpZ()) {
                                            if (view == PbFragment.this.lTU.dqY()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lPy.getPbData().dlp().bnO() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lPy.getPbData().dlp().bnN() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lPy.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lPy.getPbData().dlp().getId();
                                    PbFragment.this.lTU.dqV();
                                    PbFragment.this.gfY.c(id4, name3, id5, i11, PbFragment.this.lTU.dqZ());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lTU.mbb.dsA();
                            if (PbFragment.this.lPy != null) {
                                PbFragment.this.izJ.setThreadId(PbFragment.this.lPy.doJ());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lPy == null || !PbFragment.this.lPy.isPrivacy()) {
                                PbFragment.this.izJ.csc();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dmG() != null && PbFragment.this.dmG().getPbData() != null && PbFragment.this.dmG().getPbData().getThreadId() != null && PbFragment.this.dmG().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dmG() != null && PbFragment.this.dmG().getPbData() != null) {
                                    PbFragment.this.izJ.k(3, i12, PbFragment.this.dmG().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dmG() != null && PbFragment.this.dmG().getPbData() != null) {
                                    PbFragment.this.izJ.k(3, 3, PbFragment.this.dmG().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lTU.drt();
                        PbFragment.this.cDh();
                        PbFragment.this.lTU.dra();
                        PbFragment.this.lTU.showLoadingDialog();
                        if (PbFragment.this.lTU.dqK() != null) {
                            PbFragment.this.lTU.dqK().setVisibility(8);
                        }
                        PbFragment.this.lPy.FS(1);
                        if (PbFragment.this.lTn != null) {
                            PbFragment.this.lTn.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dnI = PbFragment.this.dnI();
                        if (!TextUtils.isEmpty(dnI)) {
                            bf.bsY().b(PbFragment.this.getPageContext(), new String[]{dnI});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar9 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar9.dR("tid", PbFragment.this.lPy.doJ());
                arVar9.dR("fid", PbFragment.this.lPy.getForumId());
                arVar9.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar9.aq("obj_locate", 1);
                TiebaStatic.log(arVar9);
                if (PbFragment.this.lTw) {
                    PbFragment.this.lTw = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.dnB().dqy() != null && postData7.bnS() != null && postData7.dNO() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dnB().dqz() != null) {
                                PbFragment.this.dnB().dqz().dnq();
                            }
                            com.baidu.tieba.pb.data.q qVar2 = new com.baidu.tieba.pb.data.q();
                            qVar2.a(PbFragment.this.lPy.getPbData().getForum());
                            qVar2.setThreadData(PbFragment.this.lPy.getPbData().dlp());
                            qVar2.g(postData7);
                            PbFragment.this.dnB().dqy().d(qVar2);
                            PbFragment.this.dnB().dqy().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bnS().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lPy.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lUg != null) {
                                PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lUT = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lPy != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lPy.lXe)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lPy.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lPy.getPbData().getForumId());
                }
                arVar.dR("tid", PbFragment.this.lPy.doJ());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cDh();
            PbFragment.this.lTU.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                PbFragment.this.g(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.lPy.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lPy.getPbData();
                            if (pbData != null && pbData.dlp() != null && pbData.dlp().bnS() != null && (userId = pbData.dlp().bnS().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lPy.doW()) {
                                PbFragment.this.lTU.dra();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lPy.doW()) {
                            PbFragment.this.lTU.dra();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lTU.s(PbFragment.this.lPy.getPbData());
                    }
                    if (PbFragment.this.lPy.doQ()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dR("tid", PbFragment.this.lPy.doJ()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lUg.bCf() || PbFragment.this.lUg.bCg()) {
                    PbFragment.this.lUg.a(false, postWriteCallBackData);
                }
                PbFragment.this.kYE.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kUB != null) {
                    PbFragment.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AB(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lUU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lPy.getPbData().getForumId());
                }
                if (PbFragment.this.lPy != null) {
                    arVar.dR("tid", PbFragment.this.lPy.doJ());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kYE != null) {
                    PbFragment.this.kYE.drT();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(PbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.kUB != null) {
                    PbFragment.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AB(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kYE != null) {
                if (PbFragment.this.lTU != null && PbFragment.this.lTU.dqz() != null && PbFragment.this.lTU.dqz().dnv() != null && PbFragment.this.lTU.dqz().dnv().bCg()) {
                    PbFragment.this.lTU.dqz().dnv().a(postWriteCallBackData);
                }
                PbFragment.this.kYE.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lUV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView drO;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lTk.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lTU != null && (drO = PbFragment.this.lTU.drO()) != null && PbFragment.this.lTU.getListView() != null) {
                            PbFragment.this.lTU.getListView().removeHeaderView(drO);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lUW = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qS;
            if (!z || fVar == null || fVar.dlC() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dlr()) >= 1) {
                PbFragment.this.lot = true;
                PbFragment.this.lTU.drc();
                if (fVar == null || !fVar.dlx()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lTU.getView());
                }
                PbFragment.this.lTU.dqX();
                if (PbFragment.this.isFullScreen || PbFragment.this.lTU.drL()) {
                    PbFragment.this.lTU.drC();
                } else if (!PbFragment.this.lTU.drz()) {
                    PbFragment.this.lTU.vK(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.gnW = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lTU.getView());
                    PbFragment.this.lTU.drl();
                }
                if (z && fVar != null) {
                    cb dlp = fVar.dlp();
                    if (dlp == null || !dlp.bmB()) {
                        PbFragment.this.d(PbFragment.this.lUf);
                    } else {
                        dos();
                    }
                    PbFragment.this.lTU.dqz().setPbData(fVar);
                    PbFragment.this.lTU.bYu();
                    if (dlp != null && dlp.bpe() != null) {
                        PbFragment.this.a(dlp.bpe());
                    }
                    if (PbFragment.this.lUg != null) {
                        PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dlr() != null && fVar.dlr().size() >= 1 && fVar.dlr().get(0) != null) {
                        PbFragment.this.lPy.PH(fVar.dlr().get(0).getId());
                    } else if (fVar.dlC() != null) {
                        PbFragment.this.lPy.PH(fVar.dlC().getId());
                    }
                    if (PbFragment.this.lUg != null) {
                        PbFragment.this.lUg.a(fVar.getAnti());
                        PbFragment.this.lUg.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lUg.setThreadData(dlp);
                        PbFragment.this.lUg.a(PbFragment.this.lPy.dpa(), PbFragment.this.lPy.doJ(), PbFragment.this.lPy.dpr());
                        if (dlp != null) {
                            PbFragment.this.lUg.kY(dlp.bpr());
                        }
                    }
                    if (PbFragment.this.lTS != null) {
                        PbFragment.this.lTS.ja(fVar.bkb());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dlS()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lTU.vJ(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lTU.a(fVar, i2, i3, PbFragment.this.lPy.doL(), i4, PbFragment.this.lPy.getIsFromMark());
                    PbFragment.this.lTU.d(fVar, PbFragment.this.lPy.doL());
                    PbFragment.this.lTU.vG(PbFragment.this.lPy.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fFk = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fFk) && PbFragment.this.lUg != null && PbFragment.this.lUg.bBk() != null && (qS = PbFragment.this.lUg.bBk().qS(6)) != null && !TextUtils.isEmpty(PbFragment.this.fFk)) {
                            ((View) qS).setOnClickListener(PbFragment.this.fFW);
                        }
                    }
                    if (PbFragment.this.lUb) {
                        PbFragment.this.lUb = false;
                        final int dnP = PbFragment.this.dnP();
                        if (!fVar.dlP()) {
                            PbFragment.this.lTU.Gf(dnP);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dnP, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lUc) {
                        PbFragment.this.lUc = false;
                        final int dnP2 = PbFragment.this.dnP();
                        final boolean z2 = dnP2 != -1;
                        if (!z2) {
                            dnP2 = PbFragment.this.dnQ();
                        }
                        if (PbFragment.this.lTU != null) {
                            if (!fVar.dlP()) {
                                PbFragment.this.lTU.Gf(dnP2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dnP2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lTU.setSelectionFromTop(dnP2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lTU.setSelectionFromTop(dnP2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lTU.vL(true);
                                PbFragment.this.lTU.vK(false);
                            }
                        }
                    } else if (PbFragment.this.lUd) {
                        PbFragment.this.lUd = false;
                        PbFragment.this.lTU.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lTU.drg();
                    }
                    PbFragment.this.lPy.a(fVar.getForum(), PbFragment.this.lUH);
                    PbFragment.this.lPy.a(PbFragment.this.lUI);
                    if (PbFragment.this.kUB != null && dlp != null && dlp.bnS() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dlp.bnS());
                        PbFragment.this.kUB.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.gnW && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lPy.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lPy.getAppealInfo().lMg)) {
                                    PbFragment.this.lTU.a(PbFragment.this.lPy.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lTU.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lTU.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lTU.drC();
                            PbFragment.this.lTU.drk();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lPy.doJ());
                            jSONObject.put("fid", PbFragment.this.lPy.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                        lVar.setOpType("2");
                        lVar.start();
                    }
                    if (i == -1) {
                        PbFragment.this.lTU.PN("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                            arrayList = PbFragment.this.lPy.getPbData().dlr();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dNO() != 1)) {
                            PbFragment.this.lTU.PN(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.doj()) {
                                PbFragment.this.lTU.PO(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lTU.PO(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lTU.s(PbFragment.this.lPy.getPbData());
                        }
                    }
                    PbFragment.this.lTU.endLoadData();
                }
                if (fVar != null && fVar.lMv && PbFragment.this.fKU == 0) {
                    PbFragment.this.fKU = System.currentTimeMillis() - PbFragment.this.iKN;
                }
                if (!PbFragment.this.dmG().doL() || PbFragment.this.dmG().getPbData().getPage().bmI() != 0 || PbFragment.this.dmG().dpm()) {
                    PbFragment.this.lUh = true;
                    return;
                }
                return;
            }
            PbFragment.this.lPy.FS(1);
            if (PbFragment.this.lTn != null) {
                PbFragment.this.lTn.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dos() {
            if (PbFragment.this.lPy != null) {
                if (PbFragment.this.lUg == null || !PbFragment.this.lUg.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lUg = (com.baidu.tbadk.editortools.pb.e) dVar.ff(PbFragment.this.getContext());
                    PbFragment.this.lUg.a(PbFragment.this.lTk.getPageContext());
                    PbFragment.this.lUg.a(PbFragment.this.fFv);
                    PbFragment.this.lUg.a(PbFragment.this.fFn);
                    PbFragment.this.lUg.a(PbFragment.this.lTk.getPageContext(), PbFragment.this.lTk.getIntent() == null ? null : PbFragment.this.lTk.getIntent().getExtras());
                    PbFragment.this.lUg.bBk().kN(true);
                    PbFragment.this.lTU.setEditorTools(PbFragment.this.lUg.bBk());
                    if (!PbFragment.this.lPy.doR()) {
                        PbFragment.this.lUg.Dc(PbFragment.this.lPy.doJ());
                    }
                    if (PbFragment.this.lPy.dps()) {
                        PbFragment.this.lUg.Da(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lTU != null) {
                        PbFragment.this.lUg.Da(PbFragment.this.lTU.dqD());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lTU.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bEk().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iKN : j;
                if (PbFragment.this.fKU == 0) {
                    PbFragment.this.fKU = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fKL, PbFragment.this.createTime, PbFragment.this.fKU, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fKL = 0L;
                if (hVar != null) {
                    hVar.bEh();
                }
                if (z2) {
                    hVar.fLd = currentTimeMillis;
                    hVar.lm(true);
                }
                if (!z2 && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null) {
                    int threadType = PbFragment.this.lPy.getPbData().dlp().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.lTA, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.lTA, "from_frs")) {
                                com.baidu.tbadk.n.h hVar2 = new com.baidu.tbadk.n.h();
                                hVar2.setSubType(1000);
                                hVar2.fLf = currentTimeMillis;
                                hVar2.rw(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fLf = currentTimeMillis;
                        dVar.rw(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lUX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dnL();
            }
        }
    };
    private final a.InterfaceC0560a lUY = new a.InterfaceC0560a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0560a
        public void e(boolean z, boolean z2, String str) {
            PbFragment.this.lTU.drc();
            if (z) {
                if (PbFragment.this.lTS != null) {
                    PbFragment.this.lTS.ja(z2);
                }
                PbFragment.this.lPy.vo(z2);
                if (PbFragment.this.lPy.bkb()) {
                    PbFragment.this.dnU();
                } else {
                    PbFragment.this.lTU.s(PbFragment.this.lPy.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lTS != null) {
                        if (PbFragment.this.lTS.bke() != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lPy.getPbData().dlp() != null && PbFragment.this.lPy.getPbData().dlp().bnS() != null) {
                            MarkData bke = PbFragment.this.lTS.bke();
                            MetaData bnS = PbFragment.this.lPy.getPbData().dlp().bnS();
                            if (bke != null && bnS != null) {
                                if (!com.baidu.tbadk.core.util.au.equals(TbadkCoreApplication.getCurrentAccount(), bnS.getUserId()) && !bnS.hadConcerned()) {
                                    PbFragment.this.b(bnS);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                    if (com.baidu.tbadk.coreExtra.c.a.G(PbFragment.this.getContext(), 0)) {
                                        com.baidu.tbadk.coreExtra.c.a.a(PbFragment.this.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.dnR();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.FB(PbFragment.this.mLastScrollState) && PbFragment.this.FB(i)) {
                if (PbFragment.this.lTU != null) {
                    PbFragment.this.lTU.drt();
                    if (PbFragment.this.lUg != null && !PbFragment.this.lTU.dqC()) {
                        PbFragment.this.lTU.vI(PbFragment.this.lUg.bBY());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lTU.dqB();
                    }
                }
                if (!PbFragment.this.lTt) {
                    PbFragment.this.lTt = true;
                }
            }
            if (PbFragment.this.lTU != null) {
                PbFragment.this.lTU.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lTn != null) {
                PbFragment.this.lTn.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lTu == null) {
                PbFragment.this.lTu = new com.baidu.tbadk.n.b();
                PbFragment.this.lTu.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lTu.bEd();
            } else {
                PbFragment.this.lTu.bEc();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dMH().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dlr;
            if (PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null && PbFragment.this.lTU != null && PbFragment.this.lTU.dqT() != null) {
                PbFragment.this.lTU.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lTn != null) {
                    PbFragment.this.lTn.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lPy.dpi() && (dlr = PbFragment.this.lPy.getPbData().dlr()) != null && !dlr.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lTU.dqT().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lPy.getPbData();
                    if (pbData != null) {
                        if (pbData.dls() != null && pbData.dls().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dlt() != null && pbData.dlt().hasData()) {
                            headerCount--;
                        }
                        int size = dlr.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.e izO = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gfY.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lPy.dpf();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.mjE != 1002 || bVar.hmO) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lTU.a(1, dVar.mSuccess, dVar.nCc, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gfY.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lTU.a(PbFragment.this.gfY.getLoadDataMode(), gVar.mSuccess, gVar.nCc, false);
                            PbFragment.this.lTU.aZ(gVar.nCf);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lTU.a(PbFragment.this.gfY.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lUZ = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c glh = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dnZ()) {
                PbFragment.this.lTk.finish();
            }
            if (!PbFragment.this.lPy.vn(true)) {
                PbFragment.this.lTU.drd();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lVb = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lVa && PbFragment.this.dnZ()) {
                PbFragment.this.dob();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lTO && PbFragment.this.lTU != null && PbFragment.this.lTU.drQ() && PbFragment.this.lPy != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dR("tid", PbFragment.this.lPy.doJ());
                    arVar.dR("fid", PbFragment.this.lPy.getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lPy.doM()) {
                        if (!PbFragment.this.lPy.doP()) {
                            if (PbFragment.this.lPy.doO()) {
                                i = 1;
                            }
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 4;
                    }
                    arVar.aq("obj_type", i);
                    TiebaStatic.log(arVar);
                    PbFragment.this.lTO = true;
                }
                if (PbFragment.this.lPy.vm(false)) {
                    PbFragment.this.lTU.drb();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lPy.getPbData() != null) {
                    PbFragment.this.lTU.dry();
                }
                PbFragment.this.lVa = true;
            }
        }
    };
    private int lVc = 0;
    private final TbRichTextView.i fVW = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dqT;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lTU.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dR("tid", PbFragment.this.lPy.doJ());
                arVar.dR("fid", PbFragment.this.lPy.getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.aq("obj_locate", 3);
                arVar.aq("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lPy.lQH.dlS()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bHE() != null) {
                            ArrayList<TbRichTextImageInfo> bHE = tbRichTextView.getRichText().bHE();
                            int i4 = 0;
                            while (i4 < bHE.size()) {
                                if (bHE.get(i4) != null) {
                                    arrayList.add(bHE.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bHE.get(i4).getSrc()) || str.equals(bHE.get(i4).bHW()) || str.equals(bHE.get(i4).bHT()) || str.equals(bHE.get(i4).bHV()) || str.equals(bHE.get(i4).bHZ()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bHE.get(i4).getSrc();
                                    imageUrlData.originalUrl = bHE.get(i4).getSrc();
                                    imageUrlData.isLongPic = bHE.get(i4).bIb();
                                    concurrentHashMap.put(bHE.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.f(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.s(arrayList).mR(i3).jg(false).jh(PbFragment.this.lPy.dpc()).d(concurrentHashMap).ji(true).jj(false).jk(PbFragment.this.doj()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lPy != null) {
                            aVar.zV(PbFragment.this.lPy.getFromForumId());
                            if (PbFragment.this.lPy.getPbData() != null) {
                                aVar.s(PbFragment.this.lPy.getPbData().dlp());
                            }
                        }
                        ImageViewerConfig eO = aVar.eO(PbFragment.this.getPageContext().getPageActivity());
                        eO.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lPN) {
                        TbRichText bH = PbFragment.this.bH(str, i);
                        if (bH != null && PbFragment.this.lVc >= 0 && PbFragment.this.lVc < bH.bHD().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bH.bHD().get(PbFragment.this.lVc));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lPM.size()) {
                                    break;
                                } else if (!aVar2.lPM.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bH.getPostId() != 0 && (dqT = PbFragment.this.lTU.dqT()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dqT.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bH.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bH.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lPy.dpr(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lPy.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eLn.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.f(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.s(arrayList2).zQ(aVar2.forumName).zR(aVar2.forumId).zS(aVar2.threadId).jg(aVar2.eLl).ji(true).zT(aVar2.lastId).jh(PbFragment.this.lPy.dpc()).d(concurrentHashMap2).jj(false).jk(PbFragment.this.doj()).zU(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lPy != null) {
                                aVar3.zV(PbFragment.this.lPy.getFromForumId());
                                if (PbFragment.this.lPy.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lPy.getPbData().dlp());
                                }
                            }
                            ImageViewerConfig eO2 = aVar3.eO(PbFragment.this.getPageContext().getPageActivity());
                            eO2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lPM, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eLn.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.s(arrayList3).zQ(aVar2.forumName).zR(aVar2.forumId).zS(aVar2.threadId).jg(aVar2.eLl).ji(true).zT(aVar2.lPM.get(0)).jh(PbFragment.this.lPy.dpc()).d(concurrentHashMap3).jj(false).jk(PbFragment.this.doj()).zU(aVar2.postId).jl(false);
                    if (PbFragment.this.lPy != null) {
                        aVar4.zV(PbFragment.this.lPy.getFromForumId());
                        if (PbFragment.this.lPy.getPbData() != null) {
                            aVar4.s(PbFragment.this.lPy.getPbData().dlp());
                        }
                    }
                    ImageViewerConfig eO3 = aVar4.eO(PbFragment.this.getPageContext().getPageActivity());
                    eO3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lTE = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lVd = false;
    PostData ksi = null;
    private final b.InterfaceC0564b lVe = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.ksi != null) {
                if (i == 0) {
                    PbFragment.this.ksi.gV(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.ksi = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.ksi);
                }
            }
        }
    };
    private final b.InterfaceC0564b lVf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lUq != null && !TextUtils.isEmpty(PbFragment.this.lUr)) {
                if (i == 0) {
                    if (PbFragment.this.lUs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lUr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lUr;
                        aVar.pkgId = PbFragment.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lUs.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eKr == null) {
                            PbFragment.this.eKr = new at(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eKr.o(PbFragment.this.lUr, PbFragment.this.lUq.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lUq = null;
                PbFragment.this.lUr = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lTl = true;
            return PbFragment.this.dF(view);
        }
    };
    private final NoNetworkView.a jfq = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lPy.doS()) {
                PbFragment.this.dnW();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.jna.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0717a iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int hmu = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            if (aH(i2) && PbFragment.this.lTU != null && PbFragment.this.lTn != null) {
                PbFragment.this.lTn.qR(true);
                if (Math.abs(i2) > this.hmu) {
                    PbFragment.this.lTn.hideFloatingView();
                }
                if (PbFragment.this.dnZ()) {
                    PbFragment.this.lTU.dqQ();
                    PbFragment.this.lTU.dqR();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            if (aH(i2) && PbFragment.this.lTU != null && PbFragment.this.lTn != null) {
                PbFragment.this.lTU.drD();
                PbFragment.this.lTn.qR(false);
                PbFragment.this.lTn.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }

        private boolean aH(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a lSo = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lTU.PP(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lVh = -1;
    private int lVi = -1;

    /* loaded from: classes2.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e dnw() {
        return this.lUg;
    }

    public void b(com.baidu.tieba.pb.data.q qVar) {
        boolean z;
        MetaData metaData;
        if (qVar.dmh() != null) {
            String id = qVar.dmh().getId();
            ArrayList<PostData> dlr = this.lPy.getPbData().dlr();
            int i = 0;
            while (true) {
                if (i >= dlr.size()) {
                    z = true;
                    break;
                }
                PostData postData = dlr.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dmq = qVar.dmq();
                    postData.JI(qVar.getTotalCount());
                    if (postData.dNL() == null || dmq == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dmq.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnS() != null && (metaData = postData.getUserMap().get(next.bnS().getUserId())) != null) {
                                next.a(metaData);
                                next.yv(true);
                                next.a(getPageContext(), this.lPy.PG(metaData.getUserId()));
                            }
                        }
                        z = dmq.size() != postData.dNL().size();
                        if (postData.dNL() != null && postData.dNL().size() < 2) {
                            postData.dNL().clear();
                            postData.dNL().addAll(dmq);
                        }
                    }
                    if (postData.dNH() != null) {
                        postData.dNI();
                    }
                }
            }
            if (!this.lPy.getIsFromMark() && z) {
                this.lTU.s(this.lPy.getPbData());
            }
            if (z) {
                c(qVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o dlH = this.lPy.getPbData().dlH();
            if (dlH != null && str.equals(dlH.getAdId())) {
                if (dlH.dNC() != null) {
                    dlH.dNC().legoCard = null;
                }
                this.lPy.getPbData().dlI();
            }
            com.baidu.tieba.tbadkCore.data.o doY = this.lPy.doY();
            if (doY != null && str.equals(doY.getAdId())) {
                this.lPy.doZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lTY != null && this.lTY.isShowing()) {
                this.lTY.dismiss();
                this.lTY = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lTY != null) {
                            PbFragment.this.lTY.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lTU.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lUo);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lUo);
                            PbFragment.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(0, getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getResources().getString(R.string.mute), kVar));
                }
                kVar.bw(arrayList);
                this.lTY = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lTY.QH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(int i) {
        cb dlp;
        if (this.lPy != null && this.lPy.getPbData() != null && (dlp = this.lPy.getPbData().dlp()) != null) {
            if (i == 1) {
                PraiseData bnD = dlp.bnD();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bnD == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dlp.a(praiseData);
                    } else {
                        dlp.bnD().getUser().add(0, metaData);
                        dlp.bnD().setNum(dlp.bnD().getNum() + 1);
                        dlp.bnD().setIsLike(i);
                    }
                }
                if (dlp.bnD() != null) {
                    if (dlp.bnD().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dlp.bnD().getNum());
                    }
                }
            } else if (dlp.bnD() != null) {
                dlp.bnD().setIsLike(i);
                dlp.bnD().setNum(dlp.bnD().getNum() - 1);
                ArrayList<MetaData> user = dlp.bnD().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dlp.bnD().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dlp.bnD().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dlp.bnD().getNum() + "";
                }
            }
            if (this.lPy.doL()) {
                this.lTU.dqT().notifyDataSetChanged();
            } else {
                this.lTU.t(this.lPy.getPbData());
            }
        }
    }

    public static PbFragment dnx() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lTk = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lPy.aD(bundle);
        if (this.jie != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lUg.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lTs = System.currentTimeMillis();
        this.lUm = getPageContext();
        final Intent intent = this.lTk.getIntent();
        if (intent != null) {
            this.iKN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lTA = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lTA)) {
                    this.lTA = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lTA)) {
                this.lTo = true;
            }
            this.lVh = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lVi = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lVj = intent.getStringExtra("key_manga_title");
            this.lUb = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lUc = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lUd = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dnZ()) {
                this.lTk.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.lUu = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lTM = new bk();
            this.lTM.D(intent);
            this.lUw = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lUw == 0) {
                this.lUw = intent.getIntExtra("key_start_from", 0);
            }
            this.lUx = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iKN = System.currentTimeMillis();
        }
        this.fKL = this.lTs - this.iKN;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lTq = 0;
        aC(bundle);
        if (this.lPy.getPbData() != null) {
            this.lPy.getPbData().Ps(this.source);
        }
        dnA();
        if (intent != null && this.lTU != null) {
            this.lTU.maZ = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lUp == null) {
                    this.lUp = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lTU.PR("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lUp, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lPy.getPbData() != null) {
                this.lPy.PJ(stringExtra);
            }
        }
        this.jie = new VoiceManager();
        this.jie.onCreate(getPageContext());
        initData(bundle);
        this.lUf = new com.baidu.tbadk.editortools.pb.g();
        d(this.lUf);
        this.lUg = (com.baidu.tbadk.editortools.pb.e) this.lUf.ff(getActivity());
        this.lUg.a(this.lTk.getPageContext());
        this.lUg.a(this.fFv);
        this.lUg.a(this.fFn);
        this.lUg.setFrom(1);
        this.lUg.a(this.lTk.getPageContext(), bundle);
        this.lUg.bBk().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lUg.bBk().kN(true);
        uY(true);
        this.lUg.a(this.lPy.dpa(), this.lPy.doJ(), this.lPy.dpr());
        registerListener(this.lUC);
        if (!this.lPy.doR()) {
            this.lUg.Dc(this.lPy.doJ());
        }
        if (this.lPy.dps()) {
            this.lUg.Da(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lTU != null) {
            this.lUg.Da(this.lTU.dqD());
        }
        registerListener(this.lUB);
        registerListener(this.lUD);
        registerListener(this.lUE);
        registerListener(this.jjL);
        registerListener(this.lUQ);
        registerListener(this.lUA);
        this.lUe = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nyx);
        this.lUe.dNq();
        registerListener(this.lUF);
        registerListener(this.fci);
        this.lPy.dpk();
        registerListener(this.lUX);
        registerListener(this.jjT);
        registerListener(this.lUT);
        if (this.lTU != null && this.lTU.drH() != null && this.lTU.drI() != null) {
            this.lTn = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lTU.drH(), this.lTU.drI(), this.lTU.dqK());
            this.lTn.a(this.lUL);
        }
        if (this.lTm && this.lTU != null && this.lTU.drI() != null) {
            this.lTU.drI().setVisibility(8);
        }
        this.lUn = new com.baidu.tbadk.core.view.c();
        this.lUn.toastTime = 1000L;
        registerListener(this.lUP);
        registerListener(this.lUN);
        registerListener(this.lUO);
        registerListener(this.jrj);
        registerListener(this.jjH);
        this.lUG.setSelfListener(true);
        this.lUG.setTag(this.lTk.getUniqueId());
        this.lUG.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lUG);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lUo = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lUo;
        userMuteAddAndDelCustomMessage.setTag(this.lUo);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lUo;
        userMuteCheckCustomMessage.setTag(this.lUo);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lPy.dpp().a(this.lUM);
        this.kYE = new ar();
        if (this.lUg.bBQ() != null) {
            this.kYE.f(this.lUg.bBQ().getInputView());
        }
        this.lUg.a(this.fFo);
        this.jEg = new ShareSuccessReplyToServerModel();
        a(this.lUy);
        this.kUB = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kUB.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.fbZ) {
                        PbFragment.this.lUg.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.fca && PbFragment.this.lTU != null && PbFragment.this.lTU.dqz() != null && PbFragment.this.lTU.dqz().dnv() != null) {
                        PbFragment.this.lTU.dqz().dnv().bCp();
                    } else if (i == com.baidu.tbadk.core.util.am.fcb) {
                        PbFragment.this.c(PbFragment.this.lUj);
                    }
                }
            }
        });
        this.lTR = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lTR.y(getUniqueId());
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        com.baidu.tbadk.core.business.b.blj().dC("3", "");
        this.izJ = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lTs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lPy != null) {
            gVar.setForumName(this.lPy.dmz());
            if (this.lPy.getPbData() != null && this.lPy.getPbData().getForum() != null) {
                gVar.a(this.lPy.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lPy);
        }
    }

    public String dny() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dnz() {
        return this.lTn;
    }

    private void uY(boolean z) {
        this.lUg.kV(z);
        this.lUg.kW(z);
        this.lUg.kX(z);
    }

    private void dnA() {
        this.foW = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    public ap dnB() {
        return this.lTU;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmG() {
        return this.lPy;
    }

    public void Pz(String str) {
        if (this.lPy != null && !StringUtils.isNull(str) && this.lTU != null) {
            this.lTU.vN(true);
            this.lPy.Pz(str);
            this.lTy = true;
            this.lTU.drt();
            this.lTU.drC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.isPaused = false;
        } else {
            this.isPaused = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.lTq = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lTq == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
        if (this.lTU != null) {
            this.lTU.onPause();
        }
        if (!this.lPy.doR()) {
            this.lUg.Db(this.lPy.doJ());
        }
        if (this.lPy != null) {
            this.lPy.dpl();
        }
        com.baidu.tbadk.BdToken.c.bhp().bhA();
        MessageManager.getInstance().unRegisterListener(this.jwA);
        cSZ();
        MessageManager.getInstance().unRegisterListener(this.lUN);
        MessageManager.getInstance().unRegisterListener(this.lUO);
        MessageManager.getInstance().unRegisterListener(this.lUP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dnC() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lPy.getPbData(), this.lPy.doL(), this.lPy.dpj());
        return (a2 == null || a2.bnS() == null || a2.bnS().getGodUserData() == null || a2.bnS().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lTC) {
            this.lTC = false;
            dof();
        }
        if (dnC()) {
            this.lTv = System.currentTimeMillis();
        } else {
            this.lTv = -1L;
        }
        if (this.lTU != null && this.lTU.getView() != null) {
            if (!this.lot) {
                dnX();
            } else {
                hideLoadingView(this.lTU.getView());
            }
            this.lTU.onResume();
        }
        if (this.lTq == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lTU != null) {
            noNetworkView = this.lTU.dqw();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        registerListener(this.jwA);
        this.lUa = false;
        doe();
        registerListener(this.lUN);
        registerListener(this.lUO);
        registerListener(this.lUP);
        if (this.jiS) {
            dnW();
            this.jiS = false;
        }
        dom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lTU.vC(z);
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
        if (z && this.lUa) {
            this.lTU.drb();
            this.lPy.vm(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lTv > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dR("obj_duration", (System.currentTimeMillis() - this.lTv) + ""));
            this.lTv = 0L;
        }
        if (dnB().dqz() != null) {
            dnB().dqz().onStop();
        }
        if (this.lTU.mbb != null && !this.lTU.mbb.dsD()) {
            this.lTU.mbb.dbn();
        }
        if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().getForum() != null && this.lPy.getPbData().dlp() != null) {
            com.baidu.tbadk.distribute.a.bAX().b(getPageContext().getPageActivity(), "pb", this.lPy.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lPy.getPbData().dlp().getId(), 0L));
        }
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lTN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", this.lPy.getPbData().getForumId());
            arVar.dR("tid", this.lPy.doJ());
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lTt && this.lTU != null) {
            this.lTt = true;
            a(false, (PostData) null);
        }
        if (this.lPy != null) {
            this.lPy.cancelLoadData();
            this.lPy.destory();
            if (this.lPy.dpo() != null) {
                this.lPy.dpo().onDestroy();
            }
        }
        if (this.lUg != null) {
            this.lUg.onDestroy();
        }
        if (this.gfY != null) {
            this.gfY.cancelLoadData();
        }
        if (this.foW != null) {
            this.foW.dNd();
        }
        if (this.lTU != null) {
            this.lTU.onDestroy();
            if (this.lTU.mbb != null) {
                this.lTU.mbb.dbn();
            }
        }
        if (this.lTu != null) {
            this.lTu.bEe();
        }
        if (this.lTn != null) {
            this.lTn.cEZ();
        }
        super.onDestroy();
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        if (this.lTU != null) {
            this.lTU.drt();
        }
        MessageManager.getInstance().unRegisterListener(this.lUN);
        MessageManager.getInstance().unRegisterListener(this.lUO);
        MessageManager.getInstance().unRegisterListener(this.lUP);
        MessageManager.getInstance().unRegisterListener(this.lUo);
        MessageManager.getInstance().unRegisterListener(this.lUQ);
        MessageManager.getInstance().unRegisterListener(this.jjT);
        MessageManager.getInstance().unRegisterListener(this.jrj);
        MessageManager.getInstance().unRegisterListener(this.lUV);
        MessageManager.getInstance().unRegisterListener(this.lUG);
        this.lUm = null;
        this.lUn = null;
        com.baidu.tieba.recapp.c.a.dEu().dEx();
        if (this.lUp != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lUp);
        }
        if (this.lTD != null) {
            this.lTD.cancelLoadData();
        }
        if (this.lTU != null && this.lTU.mbb != null) {
            this.lTU.mbb.dsH();
        }
        if (this.jEg != null) {
            this.jEg.cancelLoadData();
        }
        this.kYE.onDestroy();
        if (this.lPy != null && this.lPy.dpq() != null) {
            this.lPy.dpq().onDestroy();
        }
        if (this.kUB != null) {
            this.kUB.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dqT;
        ArrayList<PostData> dne;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bwb() && this.lTU != null && (dqT = this.lTU.dqT()) != null && (dne = dqT.dne()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dne.iterator();
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
                        bVar.iCb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eTx == 1 && !TextUtils.isEmpty(id)) {
                    next.eTx = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.iCb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lPy == null || this.lPy.getPbData() == null || this.lPy.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lPy.getPbData().getForum().getFirst_class();
                    str3 = this.lPy.getPbData().getForum().getSecond_class();
                    String id2 = this.lPy.getPbData().getForum().getId();
                    str = this.lPy.doJ();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.t.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bwe());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lTU.onChangeSkinType(i);
            if (this.lUg != null && this.lUg.bBk() != null) {
                this.lUg.bBk().onChangeSkinType(i);
            }
            if (this.lTU.dqw() != null) {
                this.lTU.dqw().onChangeSkinType(getPageContext(), i);
            }
            this.kYE.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cDh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lTU = new ap(this, this.jkS, this.fxj);
        this.jna = new com.baidu.tieba.f.b(getActivity());
        this.jna.a(lVg);
        this.jna.a(this.iHb);
        this.lTU.setOnScrollListener(this.mOnScrollListener);
        this.lTU.d(this.lVb);
        this.lTU.setListPullRefreshListener(this.glh);
        this.lTU.uJ(com.baidu.tbadk.core.k.bkV().isShowImages());
        this.lTU.setOnImageClickListener(this.fVW);
        this.lTU.b(this.mOnLongClickListener);
        this.lTU.g(this.jfq);
        this.lTU.a(this.lUZ);
        this.lTU.vC(this.mIsLogin);
        if (this.lTk.getIntent() != null) {
            this.lTU.vO(this.lTk.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lTU.dqy().setFromForumId(this.lPy.getFromForumId());
        this.lTU.setEditorTools(this.lUg.bBk());
        this.lUg.Da(this.lTU.dqD());
        this.lTU.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lPy.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPy.getPbData().getForum().getId(), PbFragment.this.lPy.getPbData().getForum().getName(), PbFragment.this.lPy.getPbData().dlp().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lTU.vP(this.lPy.doO());
        this.lTU.FZ(this.lPy.dpu());
        return this.lTU.getView();
    }

    public void dnD() {
        if (this.lTU != null && this.lPy != null) {
            if ((this.lPy.getPbData() != null || this.lPy.getPbData().dlO() != null) && checkUpIsLogin() && this.lTU.dqT() != null && this.lTU.dqT().dnj() != null) {
                this.lTU.dqT().dnj().BL(this.lPy.doJ());
            }
        }
    }

    public void dnE() {
        TiebaStatic.log("c12181");
        if (this.lTU != null && this.lPy != null) {
            if ((this.lTU == null || this.lTU.dqC()) && this.lPy.getPbData() != null && this.lPy.getPbData().dlO() != null) {
                com.baidu.tieba.pb.data.p dlO = this.lPy.getPbData().dlO();
                if (checkUpIsLogin()) {
                    if ((!dlO.dmj() || dlO.bpv() != 2) && this.lTU.dqT() != null && this.lTU.dqT().dnj() != null) {
                        this.lTU.dqT().dnj().BL(this.lPy.doJ());
                    }
                    if (System.currentTimeMillis() - this.lTx > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wA(false);
                        this.lTx = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eSf && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkV().isShowImages()) {
                    return PC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lPy == null || this.lPy.getPbData() == null) {
                        return true;
                    }
                    if (dnB().dqz() != null) {
                        dnB().dqz().dnq();
                    }
                    com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                    qVar.a(this.lPy.getPbData().getForum());
                    qVar.setThreadData(this.lPy.getPbData().dlp());
                    qVar.g(postData);
                    dnB().dqy().d(qVar);
                    dnB().dqy().setPostId(postData.getId());
                    a(view, postData.bnS().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lUg != null) {
                        this.lTU.vI(this.lUg.bBY());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dnF() {
        if (this.lTr == null) {
            this.lTr = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lTr.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lPu = PbFragment.this.lPu.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPu);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lPy.doJ(), PbFragment.this.lPu, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lPu = PbFragment.this.lPu.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPu);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lPy.doJ(), PbFragment.this.lPu, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lPu = PbFragment.this.lPu.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lPu);
                        bVar.dismiss();
                    }
                }
            }).nE(b.a.BOTTOM_TO_TOP).nF(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lUW.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).duH(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lPy = this.lTk.dmG();
        if (this.lPy.dpn() != null) {
            this.lPy.dpn().a(this.lSo);
        }
        if (this.lPy.dpo() != null) {
            this.lPy.dpo().b(this.lUz);
        }
        if (StringUtils.isNull(this.lPy.doJ())) {
            this.lTk.finish();
        } else if ("from_tieba_kuang".equals(this.lTA) && this.lTA != null) {
            this.lPy.FZ(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lTS = com.baidu.tbadk.baseEditMark.a.a(this.lTk);
        if (this.lTS != null) {
            this.lTS.a(this.lUY);
        }
        this.gfY = new ForumManageModel(this.lTk);
        this.gfY.setLoadDataCallBack(this.izO);
        this.fce = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lUK.setUniqueId(getUniqueId());
        this.lUK.registerListener();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lTU.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lUo;
        userMuteCheckCustomMessage.setTag(this.lUo);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14000").dR("tid", this.lPy.lXe).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gn(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lTl ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dnG() {
        if (this.lPy == null || this.lPy.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lPy.getPbData().dlp()) || AntiHelper.a(getPageContext(), this.lPy.getPbData().getAnti());
    }

    public void dnH() {
        if (checkUpIsLogin() && this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().getForum() != null && !dnG()) {
            if (this.lPy.getPbData().dlS()) {
                this.lTU.cSA();
                return;
            }
            if (this.jmA == null) {
                this.jmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jmA.Af(0);
                this.jmA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (PbFragment.this.lUg != null && PbFragment.this.lUg.bBk() != null) {
                                PbFragment.this.lUg.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lTU.cSA();
                        }
                    }
                });
            }
            this.jmA.G(this.lPy.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lPy.doJ(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnI() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lPy == null || (pbData = this.lPy.getPbData()) == null) {
            return null;
        }
        return pbData.dlD().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            if (fVar.dlp().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dlp().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dlp().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnG() && dnJ()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lTI);
                this.lTJ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dnB().dqz() != null && postData != null) {
                String str3 = "";
                if (postData.dNQ() != null) {
                    str3 = postData.dNQ().toString();
                }
                dnB().dqz().Px(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnS().getName_show(), str3));
            }
            if (this.lPy.getPbData() != null && this.lPy.getPbData().dlS()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lTk.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dnB().getListView().smoothScrollBy((PbFragment.this.lTI[1] + PbFragment.this.lTJ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnB().dqz() != null) {
                            PbFragment.this.lUg.bBk().setVisibility(8);
                            PbFragment.this.dnB().dqz().j(str, str2, PbFragment.this.dnB().dqD(), (PbFragment.this.lPy == null || PbFragment.this.lPy.getPbData() == null || PbFragment.this.lPy.getPbData().dlp() == null || !PbFragment.this.lPy.getPbData().dlp().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnv = PbFragment.this.dnB().dqz().dnv();
                            if (dnv != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                dnv.a(PbFragment.this.lPy.getPbData().getAnti());
                                dnv.setThreadData(PbFragment.this.lPy.getPbData().dlp());
                            }
                            if (PbFragment.this.kYE.drX() == null && PbFragment.this.dnB().dqz().dnv().bCx() != null) {
                                PbFragment.this.dnB().dqz().dnv().bCx().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kYE != null && PbFragment.this.kYE.drW() != null) {
                                            if (!PbFragment.this.kYE.drW().dWG()) {
                                                PbFragment.this.kYE.vR(false);
                                            }
                                            PbFragment.this.kYE.drW().zt(false);
                                        }
                                    }
                                });
                                PbFragment.this.kYE.g(PbFragment.this.dnB().dqz().dnv().bCx().getInputView());
                                PbFragment.this.dnB().dqz().dnv().a(PbFragment.this.lUl);
                            }
                        }
                        PbFragment.this.dnB().drC();
                    }
                }, 0L);
                return;
            }
            if (this.lUi == null) {
                this.lUi = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lUi.Af(1);
                this.lUi.a(new AnonymousClass39(str, str2));
            }
            if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().getForum() != null) {
                this.lUi.G(this.lPy.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lPy.doJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lVp;
        final /* synthetic */ String lVq;

        AnonymousClass39(String str, String str2) {
            this.lVp = str;
            this.lVq = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        }
                        PbFragment.this.dnB().getListView().smoothScrollBy((PbFragment.this.lTI[1] + PbFragment.this.lTJ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnB().dqz() != null) {
                            PbFragment.this.lUg.bBk().setVisibility(8);
                            PbFragment.this.dnB().dqz().j(AnonymousClass39.this.lVp, AnonymousClass39.this.lVq, PbFragment.this.dnB().dqD(), (PbFragment.this.lPy == null || PbFragment.this.lPy.getPbData() == null || PbFragment.this.lPy.getPbData().dlp() == null || !PbFragment.this.lPy.getPbData().dlp().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnv = PbFragment.this.dnB().dqz().dnv();
                            if (dnv != null && PbFragment.this.lPy != null && PbFragment.this.lPy.getPbData() != null) {
                                dnv.a(PbFragment.this.lPy.getPbData().getAnti());
                                dnv.setThreadData(PbFragment.this.lPy.getPbData().dlp());
                            }
                            if (PbFragment.this.kYE.drX() == null && PbFragment.this.dnB().dqz().dnv().bCx() != null) {
                                PbFragment.this.dnB().dqz().dnv().bCx().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kYE != null && PbFragment.this.kYE.drW() != null) {
                                            if (!PbFragment.this.kYE.drW().dWG()) {
                                                PbFragment.this.kYE.vR(false);
                                            }
                                            PbFragment.this.kYE.drW().zt(false);
                                        }
                                    }
                                });
                                PbFragment.this.kYE.g(PbFragment.this.dnB().dqz().dnv().bCx().getInputView());
                                PbFragment.this.dnB().dqz().dnv().a(PbFragment.this.lUl);
                            }
                        }
                        PbFragment.this.dnB().drC();
                    }
                }, 0L);
            }
        }
    }

    public boolean dnJ() {
        if ((this.lPy.getPbData() != null && this.lPy.getPbData().dlS()) || this.kUB == null || this.lPy.getPbData() == null || this.lPy.getPbData().getAnti() == null) {
            return true;
        }
        return this.kUB.oy(this.lPy.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean FL(int i) {
        if (this.kUB == null || this.lPy.getPbData() == null || this.lPy.getPbData().getAnti() == null) {
            return true;
        }
        return this.kUB.aK(this.lPy.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lPy != null && this.lPy.getPbData() != null && postData.dNO() != 1) {
            String doJ = this.lPy.doJ();
            String id = postData.getId();
            int i = 0;
            if (this.lPy.getPbData() != null) {
                i = this.lPy.getPbData().dlE();
            }
            PbActivity.a PD = PD(id);
            if (PD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(doJ, id, "pb", true, null, false, null, i, postData.dtB(), this.lPy.getPbData().getAnti(), false, postData.bnS() != null ? postData.bnS().getIconInfo() : null).addBigImageData(PD.lPM, PD.eLn, PD.eLl, PD.index);
                addBigImageData.setKeyPageStartFrom(this.lPy.dpu());
                addBigImageData.setFromFrsForumId(this.lPy.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lPy.getForumId());
                addBigImageData.setBjhData(this.lPy.doT());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnK() {
        if (this.lPy.getPbData() == null || this.lPy.getPbData().dlp() == null) {
            return -1;
        }
        return this.lPy.getPbData().dlp().boE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dmG() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dmG().PI(postWriteCallBackData.getPostId());
            this.lUt = this.lTU.dqF();
            this.lPy.da(this.lUt, this.lTU.dqG());
        }
        this.lTU.drt();
        this.kYE.drU();
        if (this.lUg != null) {
            this.lTU.vI(this.lUg.bBY());
        }
        this.lTU.dqx();
        this.lTU.vK(true);
        this.lPy.dpf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (this.lPy != null && this.lPy.lQH != null && this.lPy.lQH.dlp() != null) {
            cb dlp = this.lPy.lQH.dlp();
            dlp.mRecomAbTag = this.lPy.dpF();
            dlp.mRecomWeight = this.lPy.dpD();
            dlp.mRecomSource = this.lPy.dpE();
            dlp.mRecomExtra = this.lPy.dpG();
            if (dlp.getFid() == 0) {
                dlp.setFid(com.baidu.adp.lib.f.b.toLong(this.lPy.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlp, "c13563");
            TbPageTag fs = com.baidu.tbadk.pageInfo.c.fs(getContext());
            if (fs != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fs.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fs != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fs.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.aq("reply_type", 1);
                if (z) {
                    a2.aq("obj_type", 2);
                } else {
                    a2.aq("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fp = com.baidu.tbadk.pageExtra.d.fp(getContext());
                if (fp != null) {
                    a2.dR("obj_cur_page", fp.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                    a2.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.SG(this.lPy.getForumId()) && this.lPy.getPbData() != null && this.lPy.getPbData().getForum() != null) {
            if (this.lPy.getPbData().getForum().isLike() == 1) {
                this.lPy.dpq().gr(this.lPy.getForumId(), this.lPy.doJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.lPy == null || this.lPy.getPbData() == null) {
            return false;
        }
        return ((this.lPy.getPbData().dlE() != 0) || this.lPy.getPbData().dlp() == null || this.lPy.getPbData().dlp().bnS() == null || TextUtils.equals(this.lPy.getPbData().dlp().bnS().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean vb(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ad adVar;
        if (this.lPy == null || this.lPy.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
        cb dlp = pbData.dlp();
        if (dlp != null) {
            if (dlp.bmz() || dlp.bmA()) {
                return false;
            }
            if (dlp.bpP() || dlp.bpQ()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dlp == null || dlp.bnS() == null || !dlp.bnS().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlE() != 0) {
                    return pbData.dlE() != 3;
                }
                List<bx> dlM = pbData.dlM();
                if (com.baidu.tbadk.core.util.y.getCount(dlM) > 0) {
                    for (bx bxVar : dlM) {
                        if (bxVar != null && (adVar = bxVar.eRn) != null && adVar.eOX && !adVar.eOY && (adVar.type == 1 || adVar.type == 2)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                return z2;
            }
            return false;
        }
        return false;
    }

    private boolean vc(boolean z) {
        if (z || this.lPy == null || this.lPy.getPbData() == null) {
            return false;
        }
        if (this.lPy.getPbData().getForum() == null || !this.lPy.getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
            return ((pbData.dlp() != null && pbData.dlp().bnS() != null && pbData.dlp().bnS().isForumBusinessAccount() && !com.baidu.tieba.frs.au.isOn()) || this.lPy.getPbData().dlE() == 0 || this.lPy.getPbData().dlE() == 3) ? false : true;
        }
        return false;
    }

    public void dnM() {
        com.baidu.tieba.pb.data.f pbData;
        cb dlp;
        boolean z = true;
        if (this.lPy != null && this.lPy.getPbData() != null && (dlp = (pbData = this.lPy.getPbData()).dlp()) != null && dlp.bnS() != null) {
            this.lTU.dqx();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dlp.bnS().getUserId());
            ad adVar = new ad();
            int dlE = this.lPy.getPbData().dlE();
            if (dlE == 1 || dlE == 3) {
                adVar.lZm = true;
                adVar.lZs = dlp.bnN() == 1;
            } else {
                adVar.lZm = false;
            }
            if (FM(dlE)) {
                adVar.lZn = true;
                adVar.lZr = dlp.bnO() == 1;
            } else {
                adVar.lZn = false;
            }
            if (dlE == 1002 && !equals) {
                adVar.lZt = true;
            }
            adVar.lZk = vb(equals);
            adVar.lZo = dnN();
            adVar.lZl = vc(equals);
            adVar.Ha = this.lPy.doL();
            adVar.lZh = true;
            adVar.lZg = va(equals);
            adVar.lZf = equals && this.lTU.dri();
            adVar.lZq = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lZp = true;
            adVar.isHostOnly = this.lPy.getHostMode();
            adVar.lZj = true;
            if (dlp.boj() == null) {
                adVar.lZi = true;
            } else {
                adVar.lZi = false;
            }
            if (pbData.dlS()) {
                adVar.lZh = false;
                adVar.lZj = false;
                adVar.lZi = false;
                adVar.lZm = false;
                adVar.lZn = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlS()) {
                z = false;
            }
            adVar.lZu = z;
            if (this.lTU != null) {
                PostData b2 = this.lTU.b(this.lPy.lQH, this.lPy.doL());
                adVar.eWQ = b2 != null ? b2.nzP : false;
            }
            this.lTU.mbb.a(adVar);
        }
    }

    private boolean dnN() {
        if (this.lPy != null && this.lPy.doL()) {
            return this.lPy.getPageData() == null || this.lPy.getPageData().bmI() != 0;
        }
        return false;
    }

    public boolean FM(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lPy.getPbData().getUserData() == null || (forumToolAuth = this.lPy.getPbData().getUserData().getForumToolAuth()) == null) {
            return false;
        }
        for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
            ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
            if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dnO() {
        return this.lUW;
    }

    public int dnP() {
        if (dnB() == null || dnB().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnB().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.o) && ((com.baidu.tieba.pb.data.o) nVar).XG == com.baidu.tieba.pb.data.o.lNI) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnQ() {
        if (dnB() == null || dnB().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnB().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nzd) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dnW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnR() {
        if (this.lPy != null && this.lPy.lQH != null && this.lPy.lQH.dlp() != null) {
            cb dlp = this.lPy.lQH.dlp();
            dlp.mRecomAbTag = this.lPy.dpF();
            dlp.mRecomWeight = this.lPy.dpD();
            dlp.mRecomSource = this.lPy.dpE();
            dlp.mRecomExtra = this.lPy.dpG();
            dlp.eVF = this.lPy.doR();
            if (dlp.getFid() == 0) {
                dlp.setFid(com.baidu.adp.lib.f.b.toLong(this.lPy.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlp, "c13562");
            TbPageTag fs = com.baidu.tbadk.pageInfo.c.fs(getContext());
            if (fs != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fs.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fs != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fs.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.AA(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AB(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jF(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).aq("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).aq("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.fce.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lPy.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bqz();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lTU.drc();
        this.lPy.vo(z);
        if (this.lTS != null) {
            this.lTS.ja(z);
            if (markData != null) {
                this.lTS.a(markData);
            }
        }
        if (this.lPy.bkb()) {
            dnU();
        } else {
            this.lTU.s(this.lPy.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FB(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PA(String str) {
        if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().dlS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lPy.doJ(), str);
            cb dlp = this.lPy.getPbData().dlp();
            if (dlp.bmz()) {
                format = format + "&channelid=33833";
            } else if (dlp.bpO()) {
                format = format + "&channelid=33842";
            } else if (dlp.bmA()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.lTR.Qb(str);
    }

    private void PB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lPy.doR()) {
                    antiData.setBlock_forum_name(this.lPy.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lPy.getPbData().getForum().getId());
                    antiData.setUser_name(this.lPy.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lPy.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dnB() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            Dh(str);
        } else {
            this.lTU.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.nCc) ? bVar.nCc : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AB(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jF(true);
                aVar.b(getPageContext());
                aVar.bqz();
            } else {
                this.lTU.a(0, bVar.mSuccess, bVar.nCc, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iPc == 1) {
                    ArrayList<PostData> dlr = this.lPy.getPbData().dlr();
                    int size = dlr.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dlr.get(i).getId())) {
                            i++;
                        } else {
                            dlr.remove(i);
                            break;
                        }
                    }
                    this.lPy.getPbData().dlp().nl(this.lPy.getPbData().dlp().bnJ() - 1);
                    this.lTU.s(this.lPy.getPbData());
                } else if (bVar.iPc == 0) {
                    dnS();
                } else if (bVar.iPc == 2) {
                    ArrayList<PostData> dlr2 = this.lPy.getPbData().dlr();
                    int size2 = dlr2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dlr2.get(i2).dNL().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dlr2.get(i2).dNL().get(i3).getId())) {
                                i3++;
                            } else {
                                dlr2.get(i2).dNL().remove(i3);
                                dlr2.get(i2).dNN();
                                z2 = true;
                                break;
                            }
                        }
                        dlr2.get(i2).Tx(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lTU.s(this.lPy.getPbData());
                    }
                    a(bVar, this.lTU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lTU.a(this.gfY.getLoadDataMode(), gVar.mSuccess, gVar.nCc, false);
            if (gVar.mSuccess) {
                this.lTV = true;
                if (i == 2 || i == 3) {
                    this.lTW = true;
                    this.lTX = false;
                } else if (i == 4 || i == 5) {
                    this.lTW = false;
                    this.lTX = true;
                }
                if (i == 2) {
                    this.lPy.getPbData().dlp().no(1);
                    this.lPy.setIsGood(1);
                } else if (i == 3) {
                    this.lPy.getPbData().dlp().no(0);
                    this.lPy.setIsGood(0);
                } else if (i == 4) {
                    this.lPy.getPbData().dlp().nn(1);
                    this.lPy.FR(1);
                } else if (i == 5) {
                    this.lPy.getPbData().dlp().nn(0);
                    this.lPy.FR(0);
                }
                this.lTU.c(this.lPy.getPbData(), this.lPy.doL());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.nCc)) {
                string = gVar.nCc;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dnS() {
        if (this.lPy.doM() || this.lPy.doO()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lPy.doJ());
            PbActivity pbActivity = this.lTk;
            PbActivity pbActivity2 = this.lTk;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lPy.doJ()));
        if (dnV()) {
            this.lTk.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmU() {
        this.lTk.dmU();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dlB;
        boolean z = false;
        if (this.lTU != null) {
            this.lTU.drt();
        }
        if (this.lPy != null && this.lPy.getPbData() != null && !this.lPy.getPbData().dlS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lPy.getPbData().dlp().getId();
            if (this.lPy.isShareThread() && this.lPy.getPbData().dlp().eUD != null) {
                historyMessage.threadName = this.lPy.getPbData().dlp().eUD.showText;
            } else {
                historyMessage.threadName = this.lPy.getPbData().dlp().getTitle();
            }
            if (this.lPy.isShareThread() && !dmy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lPy.getPbData().getForum().getName();
            }
            ArrayList<PostData> dlr = this.lPy.getPbData().dlr();
            int dre = this.lTU != null ? this.lTU.dre() : 0;
            if (dlr != null && dre >= 0 && dre < dlr.size()) {
                historyMessage.postID = dlr.get(dre).getId();
            }
            historyMessage.isHostOnly = this.lPy.getHostMode();
            historyMessage.isSquence = this.lPy.doL();
            historyMessage.isShareThread = this.lPy.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lUg != null) {
            this.lUg.onDestroy();
        }
        if (this.lTp && dnB() != null) {
            dnB().drM();
        }
        if (this.lPy != null && (this.lPy.doM() || this.lPy.doO())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lPy.doJ());
            if (this.lTV) {
                if (this.lTX) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lPy.cvv());
                }
                if (this.lTW) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lPy.getIsGood());
                }
            }
            if (this.lPy.getPbData() != null && System.currentTimeMillis() - this.lTs >= 40000 && (dlB = this.lPy.getPbData().dlB()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dlB.getDataList())) {
                intent.putExtra("guess_like_data", dlB);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lUu);
            }
            PbActivity pbActivity = this.lTk;
            PbActivity pbActivity2 = this.lTk;
            pbActivity.setResult(-1, intent);
        }
        if (dnV()) {
            if (this.lPy != null && this.lTU != null && this.lTU.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dlx() && !this.lTy && pbData.lMq == null) {
                        aj dqi = aj.dqi();
                        com.baidu.tieba.pb.data.f doU = this.lPy.doU();
                        Parcelable onSaveInstanceState = this.lTU.getListView().onSaveInstanceState();
                        boolean doL = this.lPy.doL();
                        boolean hostMode = this.lPy.getHostMode();
                        if (this.lTU.dqK() != null && this.lTU.dqK().getVisibility() == 0) {
                            z = true;
                        }
                        dqi.a(doU, onSaveInstanceState, doL, hostMode, z);
                        if (this.lUt >= 0 || this.lPy.dpw() != null) {
                            aj.dqi().q(this.lPy.dpw());
                            aj.dqi().p(this.lPy.dpx());
                            aj.dqi().Gb(this.lPy.dpy());
                        }
                    }
                }
            } else {
                aj.dqi().reset();
            }
            dmU();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lTU == null || !this.lTU.Gh(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FN(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lTk;
        if (i == 0) {
            this.lTU.dqx();
            this.lTU.dqz().dnq();
            this.lTU.vK(false);
        }
        this.lTU.dqB();
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
                        this.lUg.resetData();
                        this.lUg.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lUg.c(writeData);
                        com.baidu.tbadk.editortools.m qV = this.lUg.bBk().qV(6);
                        if (qV != null && qV.fCN != null) {
                            qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lTk;
                        if (i == -1) {
                            this.lUg.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lTU.dqz() != null && this.lTU.dqz().dnv() != null) {
                            com.baidu.tbadk.editortools.pb.h dnv = this.lTU.dqz().dnv();
                            dnv.setThreadData(this.lPy.getPbData().dlp());
                            dnv.c(writeData);
                            dnv.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qV2 = dnv.bBk().qV(6);
                            if (qV2 != null && qV2.fCN != null) {
                                qV2.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lTk;
                            if (i == -1) {
                                dnv.bCp();
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lUg.onActivityResult(i, i2, intent);
        if (this.lTD != null) {
            this.lTD.onActivityResult(i, i2, intent);
        }
        if (dnB().dqz() != null) {
            dnB().dqz().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnT();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.dqi().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lPy != null) {
                                PbFragment.this.lPy.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dDg().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lPy != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    T(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        arVar.dR("tid", intent.getStringExtra("tid"));
                        arVar.dR("post_id", intent.getStringExtra("pid"));
                        arVar.aq("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(arVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dDg().I(getPageContext());
                        dnL();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jEg != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jEg.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void byI() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbFragment.this.getPageContext(), customDialogData).show();
                                        }
                                    }, 1000L);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                    this.lTU.uO(false);
                    if (this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null && this.lPy.getPbData().dlp().bom() != null) {
                        this.lPy.getPbData().dlp().bom().setStatus(2);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SELECT_LIKE_FORUM /* 25012 */:
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                    return;
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lUj = emotionImageData;
                        if (FL(com.baidu.tbadk.core.util.am.fcb)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lTE != null) {
                        this.lTU.dM(this.lTE);
                        return;
                    }
                    return;
                case 25055:
                    if (this.lTF != null) {
                        this.lTF.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lTG != null) {
                        this.lTG.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (this.lTU != null && this.lTU.drS() != null) {
                        this.lTU.drS().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lTH != null) {
                        this.lTH.performClick();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.lTD == null) {
                this.lTD = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lTk);
                this.lTD.b(this.fFn);
                this.lTD.c(this.fFv);
            }
            this.lTD.a(emotionImageData, dmG(), dmG().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnT() {
        MarkData FY;
        if (this.lTS != null) {
            if (this.lPy.getPbData() != null && this.lPy.getPbData().dlS()) {
                FY = this.lPy.FY(0);
            } else {
                FY = this.lPy.FY(this.lTU.drf());
            }
            if (FY != null) {
                if (!FY.isApp() || (FY = this.lPy.FY(this.lTU.drf() + 1)) != null) {
                    this.lTU.dra();
                    this.lTS.a(FY);
                    if (!this.lTS.bkb()) {
                        this.lTS.bkd();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lTS.bkc();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnU() {
        com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
        this.lPy.vo(true);
        if (this.lTS != null) {
            pbData.Pr(this.lTS.bka());
        }
        this.lTU.s(pbData);
    }

    private boolean dnV() {
        if (this.lPy == null) {
            return true;
        }
        if (this.lPy.getPbData() == null || !this.lPy.getPbData().dlS()) {
            if (this.lPy.bkb()) {
                final MarkData dpe = this.lPy.dpe();
                if (dpe == null || !this.lPy.getIsFromMark()) {
                    return true;
                }
                final MarkData FY = this.lPy.FY(this.lTU.dre());
                if (FY == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dpe);
                    this.lTk.setResult(-1, intent);
                    return true;
                } else if (FY.getPostId() == null || FY.getPostId().equals(dpe.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dpe);
                    this.lTk.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.AB(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lTS != null) {
                                if (PbFragment.this.lTS.bkb()) {
                                    PbFragment.this.lTS.bkc();
                                    PbFragment.this.lTS.ja(false);
                                }
                                PbFragment.this.lTS.a(FY);
                                PbFragment.this.lTS.ja(true);
                                PbFragment.this.lTS.bkd();
                            }
                            dpe.setPostId(FY.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dpe);
                            PbFragment.this.lTk.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmU();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dpe);
                            PbFragment.this.lTk.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmU();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lTU != null && PbFragment.this.lTU.getView() != null) {
                                PbFragment.this.lTU.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dpe);
                                PbFragment.this.lTk.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dmU();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bqz();
                    return false;
                }
            } else if (this.lPy.getPbData() == null || this.lPy.getPbData().dlr() == null || this.lPy.getPbData().dlr().size() <= 0 || !this.lPy.getIsFromMark()) {
                return true;
            } else {
                this.lTk.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lTU == null) {
            return null;
        }
        return this.lTU.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIk() {
        if (this.lTU == null) {
            return 0;
        }
        return this.lTU.drr();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIl() {
        if (this.fVL == null) {
            this.fVL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIx */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkV().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fVL;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIm() {
        if (this.fZb == null) {
            this.fZb = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIn() {
        if (this.fVM == null) {
            this.fVM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cxm */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkV().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.ap.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.bCQ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fVM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIo() {
        if (this.fZc == null) {
            this.fZc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dot */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dH */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dI */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccH();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fZc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIq() {
        this.fZe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dou */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.fZe;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (this.fnn == null) {
            this.fnn = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fnn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.PS(str) && this.lPy != null && this.lPy.doJ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").aq("obj_param1", 1).dR("post_id", this.lPy.doJ()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fBL = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.drZ().h(getPageContext(), str);
        }
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        au.drZ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lTU != null && this.lTU.drH() != null && rect.top <= this.lTU.drH().getHeight()) {
            rect.top += this.lTU.drH().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
            TbRichText bH = bH(str, i);
            if (bH != null && (tbRichTextData = bH.bHD().get(this.lVc)) != null) {
                aVar.postId = String.valueOf(bH.getPostId());
                aVar.lPM = new ArrayList<>();
                aVar.eLn = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHJ().bHU()) {
                    aVar.lPN = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lPM.add(c2);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                        imageUrlData.urlType = 38;
                    } else {
                        imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                    }
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalUrl = d(tbRichTextData);
                    imageUrlData.originalSize = e(tbRichTextData);
                    imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                    imageUrlData.isLongPic = g(tbRichTextData);
                    imageUrlData.postId = bH.getPostId();
                    imageUrlData.mIsReserver = this.lPy.dpc();
                    imageUrlData.mIsSeeHost = this.lPy.getHostMode();
                    aVar.eLn.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dlp() != null) {
                            aVar.threadId = pbData.dlp().getId();
                        }
                        aVar.eLl = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lPN = true;
                int size = pbData.dlr().size();
                this.lVd = false;
                aVar.index = -1;
                int a2 = pbData.dly() != null ? a(pbData.dly().dNQ(), bH, i, i, aVar.lPM, aVar.eLn) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dlr().get(i2);
                    if (postData.getId() == null || pbData.dly() == null || pbData.dly().getId() == null || !postData.getId().equals(pbData.dly().getId())) {
                        a2 = a(postData.dNQ(), bH, a2, i, aVar.lPM, aVar.eLn);
                    }
                }
                if (aVar.lPM.size() > 0) {
                    aVar.lastId = aVar.lPM.get(aVar.lPM.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dlp() != null) {
                        aVar.threadId = pbData.dlp().getId();
                    }
                    aVar.eLl = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return null;
        }
        return tbRichTextData.bHJ().bHZ();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return 0L;
        }
        return tbRichTextData.bHJ().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return false;
        }
        return tbRichTextData.bHJ().bIa();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHJ() == null) {
            return false;
        }
        return tbRichTextData.bHJ().bIb();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bHJ;
        String str;
        if (tbRichText == tbRichText2) {
            this.lVd = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bHD().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bHD().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bHJ().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bHJ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bHJ().bHU()) {
                        if (tbRichText == tbRichText2 && i8 <= i2) {
                            i3 = i8;
                            i4 = i7 - 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    } else if (tbRichTextData.getType() == 20) {
                        i3 = i8;
                        i4 = i7;
                    } else {
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (bHJ = tbRichTextData.bHJ()) != null) {
                                String bHW = bHJ.bHW();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bHJ.bHX();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bHW;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lPy.doJ(), -1L);
                                imageUrlData.mIsReserver = this.lPy.dpc();
                                imageUrlData.mIsSeeHost = this.lPy.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lVd) {
                            i3 = i8;
                            i4 = i7 + 1;
                        }
                        i3 = i8;
                        i4 = i7;
                    }
                }
                i6++;
                i5 = i3;
                i7 = i4;
            }
            return i7;
        }
        return i;
    }

    protected void n(PostData postData) {
        PostData dly;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lPy.boa())) {
                z = true;
            }
            MarkData o = this.lPy.o(postData);
            if (this.lPy.getPbData() != null && this.lPy.getPbData().dlS() && (dly = dly()) != null) {
                o = this.lPy.o(dly);
            }
            if (o != null) {
                this.lTU.dra();
                if (this.lTS != null) {
                    this.lTS.a(o);
                    if (!z) {
                        this.lTS.bkd();
                    } else {
                        this.lTS.bkc();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dF(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (!isAdded()) {
            return true;
        }
        if (this.lTU != null) {
            if (this.lTU.doB()) {
                return true;
            }
            this.lTU.drP();
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dG(view)) {
                if (view instanceof TbImageView) {
                    this.lUq = ((TbImageView) view).getBdImage();
                    this.lUr = ((TbImageView) view).getUrl();
                    if (this.lUq == null || TextUtils.isEmpty(this.lUr)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lUs = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lUq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lUr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lUs = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lUq = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lUr = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lUs = null;
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else {
                    this.lTU.a(this.lVf, this.lUq.isGif());
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
        this.ksi = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.ksi == null) {
            return true;
        }
        if (this.ksi.dNO() == 1 && dG(view)) {
            this.lTU.a(this.lVf, this.lUq.isGif());
            return true;
        } else if (this.lTS == null) {
            return true;
        } else {
            if (!this.lTS.bkb() || this.ksi.getId() == null || !this.ksi.getId().equals(this.lPy.boa())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dmG().getPbData() != null && dmG().getPbData().dlS();
            if (this.ksi.dNO() == 1) {
                if (!z3) {
                    this.lTU.a(this.lVe, z, false);
                }
                return true;
            }
            if (this.lTZ == null) {
                this.lTZ = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lTZ.a(this.lUR);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dG(view) && !z3;
                boolean z5 = (!dG(view) || this.lUq == null || this.lUq.isGif()) ? false : true;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                String str = null;
                if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                }
                if (z4) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lTZ));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lTZ));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lTZ);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.ksi);
                    gVar2.eWK.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lTZ);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lTZ);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.ksi);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eWK.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lTP) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lTZ);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_user_mute_visible, true);
                        sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                        sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                        sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                        sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                        sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                        sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        gVar3.eWK.setTag(sparseArray5);
                        arrayList.add(gVar3);
                    } else {
                        if ((va(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lTZ);
                            gVar4.eWK.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    com.baidu.tbadk.core.dialog.g gVar5 = null;
                    com.baidu.tbadk.core.dialog.g gVar6 = null;
                    if (z8) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.tag_should_manage_visible, true);
                        sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                        sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                        sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                        if (z9) {
                            sparseArray6.put(R.id.tag_user_mute_visible, true);
                            sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                            sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                            sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                            sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                            sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray6.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z10) {
                            sparseArray6.put(R.id.tag_should_delete_visible, true);
                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lTZ);
                            gVar6.eWK.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lTZ);
                        gVar5.eWK.setTag(sparseArray6);
                    } else if (z10) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        if (this.lPy.getPbData().dlE() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lTZ);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lTZ);
                        }
                        gVar6.eWK.setTag(sparseArray7);
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                }
                if (com.baidu.tbadk.a.d.bjo()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.ksi.bpL(), sparseArray2, this.lTZ), this.lTl));
                    this.lTZ.a(com.baidu.tieba.pb.pb.main.d.a.t(this.ksi));
                } else {
                    list = arrayList;
                }
                this.lTZ.k(list, true);
                this.lTY = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lTZ);
                this.lTY.QH();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dR("tid", this.lPy.lXe).dR("fid", this.lPy.getForumId()).dR("uid", this.lPy.getPbData().dlp().bnS().getUserId()).dR("post_id", this.lPy.bBM()).aq("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lPy == null || this.lPy.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lPy.getPbData();
        if (pbData.dly() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dly());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dlr = pbData.dlr();
            c(pbData, dlr);
            return c(dlr, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c fp;
        int i = 1;
        if (agreeData != null) {
            if (this.fge == null) {
                this.fge = new com.baidu.tbadk.core.message.a();
            }
            if (this.ffO == null) {
                this.ffO = new com.baidu.tieba.tbadkCore.data.e();
                this.ffO.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 5;
            eVar.eNH = 8;
            eVar.eNG = 2;
            if (dmG() != null) {
                eVar.eNF = dmG().dpu();
            }
            eVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eNI = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eNI = 1;
                        i = 0;
                    }
                }
                fp = com.baidu.tbadk.pageExtra.d.fp(getContext());
                if (fp != null) {
                    agreeData.objSource = fp.getCurrentPageKey();
                }
                this.fge.a(agreeData, i, getUniqueId(), false);
                this.fge.a(agreeData, this.ffO);
                if (this.lPy == null && this.lPy.getPbData() != null) {
                    this.fge.a(doq(), eVar, agreeData, this.lPy.getPbData().dlp());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eNI = 1;
            }
            i = 0;
            fp = com.baidu.tbadk.pageExtra.d.fp(getContext());
            if (fp != null) {
            }
            this.fge.a(agreeData, i, getUniqueId(), false);
            this.fge.a(agreeData, this.ffO);
            if (this.lPy == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dlD() != null && fVar.dlD().lNY != null && (list = fVar.dlD().lNY) != null && arrayList != null) {
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

    private TbRichText c(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> bHD;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dNQ = arrayList.get(i2).dNQ();
            if (dNQ != null && (bHD = dNQ.bHD()) != null) {
                int size = bHD.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bHD.get(i4) != null && bHD.get(i4).getType() == 8) {
                        i3++;
                        if (bHD.get(i4).bHJ().bHW().equals(str) || bHD.get(i4).bHJ().bHX().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bHD.get(i4).bHJ().getWidth() * equipmentDensity;
                            int height = bHD.get(i4).bHJ().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lVc = i4;
                            return dNQ;
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

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.lPu = str;
            if (this.lTr == null) {
                dnF();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lTr.getItemView(1).setVisibility(8);
            } else {
                this.lTr.getItemView(1).setVisibility(0);
            }
            this.lTr.bqB();
            this.lTw = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jie;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnW() {
        hideNetRefreshView(this.lTU.getView());
        dnX();
        if (this.lPy.doX()) {
            this.lTU.dra();
        }
        this.lTU.drl();
    }

    private void dnX() {
        showLoadingView(this.lTU.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lTU.drH().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDh() {
        if (this.jie != null) {
            this.jie.stopPlay();
        }
        if (this.lTk != null) {
            this.lTk.cDh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dnK(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIp() {
        if (this.fZd == null) {
            this.fZd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dov */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fZd;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void cDi() {
        if (this.lTk != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lTk.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lTk.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cBF() {
        if (this.lPy == null || this.lPy.getPbData() == null) {
            return null;
        }
        return this.lPy.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.mcq)).intValue();
            if (intValue == ap.mcr) {
                if (!this.gfY.dOJ()) {
                    this.lTU.dqV();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gfY.TL(com.baidu.tbadk.core.util.au.R(jSONArray));
                    }
                    this.gfY.a(this.lPy.getPbData().getForum().getId(), this.lPy.getPbData().getForum().getName(), this.lPy.getPbData().dlp().getId(), str, intValue3, intValue2, booleanValue, this.lPy.getPbData().dlp().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.mcs || intValue == ap.mcu) {
                if (this.lPy.dpn() != null) {
                    this.lPy.dpn().FG(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.mcs) {
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
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lUo);
        userMuteAddAndDelCustomMessage.setTag(this.lUo);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean PC(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0850a
    public void vd(boolean z) {
        this.lUa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnY() {
        ArrayList<PostData> dlr;
        int count;
        if (this.lPy == null || this.lPy.getPbData() == null || this.lPy.getPbData().dlr() == null || (count = com.baidu.tbadk.core.util.y.getCount((dlr = this.lPy.getPbData().dlr()))) == 0) {
            return "";
        }
        if (this.lPy.dpc()) {
            Iterator<PostData> it = dlr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNO() == 1) {
                    return next.getId();
                }
            }
        }
        int dre = this.lTU.dre();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dlr, dre);
        if (postData == null || postData.bnS() == null) {
            return "";
        }
        if (this.lPy.PG(postData.bnS().getUserId())) {
            return postData.getId();
        }
        for (int i = dre - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dlr, i);
            if (postData2 == null || postData2.bnS() == null || postData2.bnS().getUserId() == null) {
                break;
            } else if (this.lPy.PG(postData2.bnS().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dre + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dlr, i2);
            if (postData3 == null || postData3.bnS() == null || postData3.bnS().getUserId() == null) {
                return "";
            }
            if (this.lPy.PG(postData3.bnS().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        this.lTw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a PD(String str) {
        String str2;
        if (this.lPy.getPbData() == null || this.lPy.getPbData().dlr() == null || this.lPy.getPbData().dlr().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lPy.getPbData().dlr().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lPy.getPbData().dlr().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lPy.getPbData().dlr().get(i);
        if (postData.dNQ() == null || postData.dNQ().bHD() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dNQ().bHD().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bHJ() != null) {
                    str2 = next.bHJ().bHW();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dnZ() {
        return (!this.lTm && this.lVh == -1 && this.lVi == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null) {
            this.lVk = tVar;
            this.lTm = true;
            this.lTU.dqL();
            this.lTU.PQ(this.lVj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doa() {
        if (this.lVk != null) {
            if (this.lVh == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lVk.getCartoonId(), this.lVh, 0)));
                this.lTk.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dob() {
        if (this.lVk != null) {
            if (this.lVi == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lVk.getCartoonId(), this.lVi, 0)));
                this.lTk.finish();
            }
        }
    }

    public int doc() {
        return this.lVh;
    }

    public int dod() {
        return this.lVi;
    }

    private void cSZ() {
        if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null && this.lPy.getPbData().dlp().bmx()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void doe() {
        if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null && this.lPy.getPbData().dlp().bmx()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dof() {
        if (this.isPaused) {
            this.lTC = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null && this.lPy.getPbData().dlp().bny() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lPy.getPbData().dlp().bny().getThreadId(), this.lPy.getPbData().dlp().bny().getTaskId(), this.lPy.getPbData().dlp().bny().getForumId(), this.lPy.getPbData().dlp().bny().getForumName(), this.lPy.getPbData().dlp().bnN(), this.lPy.getPbData().dlp().bnO())));
            this.lTo = true;
            this.lTk.finish();
        }
    }

    public String dog() {
        return this.lTA;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a doh() {
        return this.lTQ;
    }

    public void ve(boolean z) {
        this.lTB = z;
    }

    public boolean blw() {
        if (this.lPy != null) {
            return this.lPy.doM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AB(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lUm).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lUm.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lUm).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lUm != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lUm.getPageActivity());
            aVar.AB(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lUm).bqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lTU.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lUm.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.AB(this.lUm.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AB(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lTU.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.84
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lUm).bqz();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.PS(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
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

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.jOS) {
            this.jOS = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lTU != null) {
                this.lTU.onConfigurationChanged(configuration);
            }
            if (this.lTY != null) {
                this.lTY.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean doj() {
        if (this.lPy != null) {
            return this.lPy.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lPy.getPbData().dlD().lNY;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNL().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNL().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNL().remove(i2);
                    list.get(i).dNN();
                    z = true;
                    break;
                }
            }
            list.get(i).Tx(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lPy.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.q qVar) {
        String id = qVar.dmh().getId();
        List<PostData> list = this.lPy.getPbData().dlD().lNY;
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
                ArrayList<PostData> dmq = qVar.dmq();
                postData.JI(qVar.getTotalCount());
                if (postData.dNL() != null) {
                    postData.dNL().clear();
                    postData.dNL().addAll(dmq);
                }
            }
        }
        if (!this.lPy.getIsFromMark()) {
            this.lTU.s(this.lPy.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dmx() {
        return this.lTk.dmx();
    }

    public boolean dmy() {
        if (this.lPy == null) {
            return false;
        }
        return this.lPy.dmy();
    }

    public void vf(boolean z) {
        this.lTz = z;
    }

    public boolean dok() {
        return this.lTz;
    }

    public void dol() {
        if (this.lTU != null) {
            this.lTU.dqx();
            cDi();
        }
    }

    public PostData dly() {
        return this.lTU.b(this.lPy.lQH, this.lPy.doL());
    }

    public void onBackPressed() {
        if (this.lUv != null && !this.lUv.isEmpty()) {
            int size = this.lUv.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lUv.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lUv == null) {
                this.lUv = new ArrayList();
            }
            if (!this.lUv.contains(aVar)) {
                this.lUv.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lUv == null) {
                this.lUv = new ArrayList();
            }
            if (!this.lUv.contains(aVar)) {
                this.lUv.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lUv != null) {
            this.lUv.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.ag.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dom() {
        if (this.lPy != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lPy.doJ())) {
            com.baidu.tbadk.BdToken.c.bhp().q(com.baidu.tbadk.BdToken.b.eDG, com.baidu.adp.lib.f.b.toLong(this.lPy.doJ(), 0L));
        }
    }

    public bk don() {
        return this.lTM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PE(String str) {
        if (this.lPy != null && this.lPy.getPbData() != null && this.lPy.getPbData().dlp() != null && this.lPy.getPbData().dlp().bmB()) {
            cb dlp = this.lPy.getPbData().dlp();
            int i = 0;
            if (dlp.bmz()) {
                i = 1;
            } else if (dlp.bmA()) {
                i = 2;
            } else if (dlp.bpP()) {
                i = 3;
            } else if (dlp.bpQ()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(str);
            arVar.aq("obj_source", 4);
            arVar.aq("obj_type", i);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(final int i) {
        com.baidu.tbadk.util.af.a(new com.baidu.tbadk.util.ae<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dnK(), i2, PbFragment.this.lPy);
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.ae(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13833");
        arVar.aq("obj_locate", 1);
        if (i == 3) {
            arVar.aq("obj_type", 1);
        } else if (i == 8) {
            arVar.aq("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment doo() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dop() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doq() {
        return this.lTk;
    }
}
