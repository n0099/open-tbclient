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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.ce;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0840a {
    private at eGK;
    private com.baidu.adp.lib.d.b<ImageView> fRW;
    private com.baidu.adp.lib.d.b<GifView> fRX;
    private com.baidu.adp.lib.d.b<TextView> fVl;
    private com.baidu.adp.lib.d.b<View> fVm;
    private com.baidu.adp.lib.d.b<LinearLayout> fVn;
    private com.baidu.adp.lib.d.b<RelativeLayout> fVo;
    private com.baidu.tieba.tbadkCore.data.e fbZ;
    private com.baidu.tbadk.core.message.a fcq;
    private com.baidu.adp.lib.d.b<TbImageView> fjw;
    private LikeModel fle;
    private com.baidu.tieba.callfans.a ise;
    private VoiceManager jaA;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private com.baidu.tieba.f.b jfv;
    public com.baidu.tbadk.core.util.al kKi;
    public ar kOl;
    private String lEo;
    private PbActivity lHZ;
    private com.baidu.tieba.pb.pb.report.a lID;
    private com.baidu.tbadk.core.dialog.i lIK;
    private com.baidu.tbadk.core.dialog.k lIL;
    private boolean lIM;
    private com.baidu.tieba.tbadkCore.data.f lIQ;
    private com.baidu.tbadk.editortools.pb.g lIR;
    private com.baidu.tbadk.editortools.pb.e lIS;
    private com.baidu.tieba.frs.profession.permission.c lIU;
    private EmotionImageData lIV;
    private com.baidu.adp.base.f lIY;
    private com.baidu.tbadk.core.view.c lIZ;
    private com.baidu.tieba.pb.pb.main.b.b lIc;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lIs;
    private View lIt;
    int lIv;
    private bi lIy;
    private boolean lJM;
    private String lJV;
    private com.baidu.tbadk.core.data.s lJW;
    private BdUniqueId lJa;
    private Runnable lJb;
    private com.baidu.adp.widget.ImageView.a lJc;
    private String lJd;
    private TbRichTextMemeInfo lJe;
    private List<a> lJh;
    public String lJj;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lJS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cV(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.djT();
            } else {
                com.baidu.tieba.pb.a.b.djS();
            }
        }
    };
    boolean lIa = true;
    private boolean lIb = false;
    private boolean lId = false;
    private boolean isPaused = false;
    private boolean ldW = false;
    private boolean lIe = true;
    private int lIf = 0;
    private com.baidu.tbadk.core.dialog.b lIg = null;
    private long iDg = -1;
    private long fHj = 0;
    private long lIh = 0;
    private long createTime = 0;
    private long fHa = 0;
    private boolean lIi = false;
    private com.baidu.tbadk.n.b lIj = null;
    private long lIk = 0;
    private boolean lIl = false;
    private long lIm = 0;
    private int jHr = 1;
    private String fBw = null;
    private boolean lIn = false;
    private boolean isFullScreen = false;
    private boolean lIo = false;
    private String lIp = "";
    private boolean lIq = true;
    private boolean lIr = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lIu = new int[2];
    private int lIw = -1;
    private int lIx = -1;
    public BdUniqueId lIz = BdUniqueId.gen();
    private boolean lIA = false;
    private boolean lIB = com.baidu.tbadk.a.d.biM();
    private PbInterviewStatusView.a lIC = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lIG.vo(!PbFragment.this.lIq);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.bjE()) {
                        PbFragment.this.dlp();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lEs = null;
    private com.baidu.tbadk.baseEditMark.a lIE = null;
    private ForumManageModel gca = null;
    private com.baidu.tbadk.coreExtra.model.a eYq = null;
    private com.baidu.tieba.pb.data.q lIF = null;
    private ShareSuccessReplyToServerModel jwD = null;
    private ap lIG = null;
    private boolean lIH = false;
    private boolean lII = false;
    private boolean lIJ = false;
    private boolean gjs = false;
    private boolean lIN = false;
    private boolean lIO = false;
    private boolean lIP = false;
    private boolean lIT = false;
    public boolean lIW = false;
    private com.baidu.tbadk.editortools.pb.c fBz = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBu() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fBA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (PbFragment.this.kOl == null || PbFragment.this.kOl.dpr() == null || !PbFragment.this.kOl.dpr().dUb()) {
                return !PbFragment.this.Fp(com.baidu.tbadk.core.util.al.eYl);
            }
            PbFragment.this.showToast(PbFragment.this.kOl.dpr().dUd());
            if (PbFragment.this.lIS != null && (PbFragment.this.lIS.bBK() || PbFragment.this.lIS.bBL())) {
                PbFragment.this.lIS.a(false, PbFragment.this.kOl.dpu());
            }
            PbFragment.this.kOl.vB(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lIX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (PbFragment.this.kOl == null || PbFragment.this.kOl.dps() == null || !PbFragment.this.kOl.dps().dUb()) {
                return !PbFragment.this.Fp(com.baidu.tbadk.core.util.al.eYm);
            }
            PbFragment.this.showToast(PbFragment.this.kOl.dps().dUd());
            if (PbFragment.this.lIG != null && PbFragment.this.lIG.dnV() != null && PbFragment.this.lIG.dnV().dkQ() != null && PbFragment.this.lIG.dnV().dkQ().bBL()) {
                PbFragment.this.lIG.dnV().dkQ().a(PbFragment.this.kOl.dpu());
            }
            PbFragment.this.kOl.vC(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jbo = false;
    private int lJf = 0;
    private int lJg = -1;
    public int lJi = 0;
    private final a lJk = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lIG != null && PbFragment.this.lIG.dnV() != null) {
                r dnV = PbFragment.this.lIG.dnV();
                if (dnV.dkO()) {
                    dnV.dkN();
                    return true;
                }
            }
            if (PbFragment.this.lIG != null && PbFragment.this.lIG.doW()) {
                PbFragment.this.lIG.doX();
                return true;
            }
            return false;
        }
    };
    private final ab.a lJl = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lIG.showToast(str);
            }
        }
    };
    private final CustomMessageListener lJm = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lEs != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lIS != null) {
                    PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                }
                PbFragment.this.lIG.dnX();
                PbFragment.this.lIG.doP();
            }
        }
    };
    CustomMessageListener jch = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lEs.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lIG != null && PbFragment.this.lEs != null) {
                    PbFragment.this.lIG.b(PbFragment.this.lEs.getPbData(), PbFragment.this.lEs.dmg(), PbFragment.this.lEs.dmE(), PbFragment.this.lIG.getSkinType());
                }
                if (PbFragment.this.lIG != null && PbFragment.this.lIG.dop() != null) {
                    PbFragment.this.lIG.dop().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lJn = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lIG != null) {
                    if (booleanValue) {
                        PbFragment.this.lIG.dos();
                    } else {
                        PbFragment.this.lIG.dot();
                    }
                }
            }
        }
    };
    private CustomMessageListener lJo = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lIS != null) {
                    PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                }
                PbFragment.this.lIG.vv(false);
            }
        }
    };
    private CustomMessageListener lJp = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.p) eVar.getData());
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
    private CustomMessageListener lJq = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lIG != null && PbFragment.this.lIG.dop() != null) {
                PbFragment.this.lIG.dop().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener joX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener jcd = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.dlH();
            }
        }
    };
    private View.OnClickListener fCk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fBw);
        }
    };
    private CustomMessageListener lJr = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                az.a aVar = new az.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lEs.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lEs.dmv() != null && PbFragment.this.lEs.dmv().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.lIG.a(ahVar.sendCount, PbFragment.this.lEs.getPbData(), PbFragment.this.lEs.dmg(), PbFragment.this.lEs.dmE());
                    }
                    if (pbData.diP() != null && pbData.diP().size() >= 1 && pbData.diP().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.diP().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lEs.dme(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            az dLu = pbData.diP().get(0).dLu();
                            if (dLu == null) {
                                dLu = new az();
                            }
                            ArrayList<az.a> bmo = dLu.bmo();
                            if (bmo == null) {
                                bmo = new ArrayList<>();
                            }
                            bmo.add(0, aVar);
                            dLu.setTotal(ahVar.sendCount + dLu.getTotal());
                            dLu.y(bmo);
                            pbData.diP().get(0).a(dLu);
                            PbFragment.this.lIG.dop().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lJs = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                PbFragment.this.lEs.getPbData().djh();
                PbFragment.this.lEs.dmA();
                if (PbFragment.this.lIG.dop() != null) {
                    PbFragment.this.lIG.s(PbFragment.this.lEs.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.o oVar;
            if (customResponsedMessage != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Oz(str);
                PbFragment.this.lEs.dmA();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lEs.getPbData().diP() != null) {
                    ArrayList<PostData> diP = PbFragment.this.lEs.getPbData().diP();
                    Iterator<PostData> it = diP.iterator();
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
                        diP.remove(oVar);
                        if (PbFragment.this.lIG.dop() != null && PbFragment.this.lIG.dop().getDataList() != null) {
                            PbFragment.this.lIG.dop().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lIG.getListView() != null && PbFragment.this.lIG.getListView().getData() != null) {
                            PbFragment.this.lIG.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lIG.dop() != null) {
                            PbFragment.this.lIG.dop().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lIG.dop() != null) {
                    PbFragment.this.lIG.s(PbFragment.this.lEs.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lJt = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dpK()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lJu = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ai(List<String> list) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list) && PbFragment.this.lIG != null) {
                PbFragment.this.lIG.fp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lJv = false;
    private PraiseModel lJw = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void EC(String str) {
            PbFragment.this.lJv = false;
            if (PbFragment.this.lJw != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lEs.getPbData();
                if (pbData.diN().bni().getIsLike() == 1) {
                    PbFragment.this.zL(0);
                } else {
                    PbFragment.this.zL(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.diN()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lJv = false;
            if (PbFragment.this.lJw != null && str != null) {
                if (AntiHelper.bQ(i, str)) {
                    AntiHelper.bs(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lJx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void uR(boolean z) {
            PbFragment.this.uP(z);
            if (PbFragment.this.lIG.dpc() != null && z) {
                PbFragment.this.lIG.vo(false);
            }
            PbFragment.this.lIG.vq(z);
        }
    };
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().fqk != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().fqk, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.diW().bnx() != null && PbFragment.this.diW().bnx().getGodUserData() != null) {
                            PbFragment.this.diW().bnx().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null) {
                            PbFragment.this.lEs.getPbData().diN().bnx().setHadConcerned(updateAttentionMessage.isAttention());
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
            if (tipEvent.pageId > 0 && PbFragment.this.lHZ.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lJy = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lIG.cjr();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Fs(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cMv();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ftt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dkZ();
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
                        if (PbFragment.this.dE(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.g((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lIG.dkX() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dW("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.djU() != null && PbFragment.this.djU().iJX != null) {
                                PbFragment.this.djU().iJX.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.g(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.lIS != null) {
                    PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                }
                PbFragment.this.lIG.dnX();
                PbFragment.this.lIG.doP();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lJz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lJa) {
                PbFragment.this.lIG.cjr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lEs.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.djd().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIZ.showSuccessToast(PbFragment.this.lIY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lIY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.CL(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dlD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lIY.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lIZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lJA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lJa) {
                PbFragment.this.lIG.cjr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lIZ.showSuccessToast(PbFragment.this.lIY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lIY.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lIZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lJB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lJa) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lIG.cjr();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nAo;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
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
                    PbFragment.this.lIG.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lJC = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lIG.dnY() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dkZ();
            }
        }
    };
    private CustomMessageListener jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.jbo = true;
                }
            }
        }
    };
    public a.b lpb = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cBJ();
            com.baidu.tbadk.core.data.ax pageData = PbFragment.this.lEs.getPageData();
            int pageNum = PbFragment.this.lIG.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bmh()) {
                PbFragment.this.lIG.doP();
                PbFragment.this.cBI();
                PbFragment.this.lIG.dow();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lEs.Fw(PbFragment.this.lIG.getPageNum());
                    if (PbFragment.this.lIc != null) {
                        PbFragment.this.lIc.showFloatingView();
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
    private k.c lJD = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lIK != null) {
                PbFragment.this.lIK.dismiss();
            }
            PbFragment.this.Fo(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    PbFragment.this.dF(view2);
                    view2.performClick();
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    PbFragment.this.dF(view3);
                    view3.performClick();
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.biX() || com.baidu.tbadk.a.d.biY()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        PbFragment.this.dF(view4);
                        ((AgreeView) view4).getImgDisagree().performClick();
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    PbFragment.this.dF(view5);
                    ((AgreeView) view5).getImgDisagree().performClick();
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (com.baidu.tbadk.a.d.biX() || com.baidu.tbadk.a.d.biY()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        PbFragment.this.dF(view6);
                        ((AgreeView) view6).getImgAgree().performClick();
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    PbFragment.this.dF(view7);
                    ((AgreeView) view7).getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (PbFragment.this.lJc != null && !TextUtils.isEmpty(PbFragment.this.lJd)) {
                        if (PbFragment.this.lJe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lJd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lJd;
                            aVar.pkgId = PbFragment.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lJe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lJc = null;
                        PbFragment.this.lJd = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lJc != null && !TextUtils.isEmpty(PbFragment.this.lJd)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eGK == null) {
                                PbFragment.this.eGK = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eGK.p(PbFragment.this.lJd, PbFragment.this.lJc.getImageByte());
                            PbFragment.this.lJc = null;
                            PbFragment.this.lJd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.khK != null) {
                        PbFragment.this.khK.gT(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.khK = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").an("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dG(view);
                        if (PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null && PbFragment.this.lEs.getPbData().diN().bnx().getUserId() != null && PbFragment.this.lIE != null) {
                            int h = PbFragment.this.h(PbFragment.this.lEs.getPbData());
                            bz diN = PbFragment.this.lEs.getPbData().diN();
                            if (diN.bme()) {
                                i2 = 2;
                            } else if (diN.bmf()) {
                                i2 = 3;
                            } else if (diN.bpv()) {
                                i2 = 4;
                            } else {
                                i2 = diN.bpw() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dW("tid", PbFragment.this.lEs.lLR).an("obj_locate", 2).dW("obj_id", PbFragment.this.lEs.getPbData().diN().bnx().getUserId()).an("obj_type", PbFragment.this.lIE.bjE() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13079"));
                        PbFragment.this.OB((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").an("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.f(sparseArray4);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.lIG.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                PbFragment.this.f(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.lIG.dN(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lIG.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpr() != null) {
                            PbFragment.this.d(postData.bpr());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lJE = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zf(int i) {
            PbFragment.this.lIG.doP();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lEs == null || PbFragment.this.lEs.isLoading) {
                    return false;
                }
                PbFragment.this.cBI();
                PbFragment.this.lIG.dow();
                if (PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().lBl != null && PbFragment.this.lEs.getPbData().lBl.size() > i) {
                    int intValue = PbFragment.this.lEs.getPbData().lBl.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dW("tid", PbFragment.this.lEs.dmf()).dW("fid", PbFragment.this.lEs.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Fu(intValue)));
                    if (PbFragment.this.lEs.FB(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lIG.vj(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Fu(int i) {
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
    public final View.OnClickListener jdo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:790:0x2008  */
        /* JADX WARN: Removed duplicated region for block: B:793:0x2044  */
        /* JADX WARN: Removed duplicated region for block: B:810:0x2208  */
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
            ce ceVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar3;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean C;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.lIG.doL()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lEs.uX(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lIG.dox();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnw()) {
                        if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnx()) {
                            if (view == PbFragment.this.lIG.lPL.fJL) {
                                if (PbFragment.this.lIG.vs(PbFragment.this.lEs.dmm())) {
                                    PbFragment.this.cBI();
                                    return;
                                }
                                PbFragment.this.lIe = false;
                                PbFragment.this.lId = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lHZ, PbFragment.this.lIG.lPL.fJL);
                                PbFragment.this.lHZ.finish();
                            } else if (view != PbFragment.this.lIG.dou() && (PbFragment.this.lIG.lPL.dpX() == null || (view != PbFragment.this.lIG.lPL.dpX().dnv() && view != PbFragment.this.lIG.lPL.dpX().dnt()))) {
                                if (view == PbFragment.this.lIG.doT()) {
                                    if (PbFragment.this.lEs != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEs.getPbData().diN().bnw().getLink());
                                    }
                                } else if (view != PbFragment.this.lIG.lPL.lWj) {
                                    if (view == PbFragment.this.lIG.lPL.jri) {
                                        if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                            ArrayList<PostData> diP = PbFragment.this.lEs.getPbData().diP();
                                            if ((diP == null || diP.size() <= 0) && PbFragment.this.lEs.dmg()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dW("tid", PbFragment.this.lEs.dme()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", PbFragment.this.lEs.getForumId()));
                                            if (!PbFragment.this.lIG.dph()) {
                                                PbFragment.this.lIG.dnX();
                                            }
                                            PbFragment.this.dlh();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lIG.uE(true);
                                            PbFragment.this.lIG.dnX();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lIG.dos();
                                                PbFragment.this.cBI();
                                                PbFragment.this.lIG.dow();
                                                PbFragment.this.lEs.OG(PbFragment.this.dlt());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnr()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lIG.lPL.dpX() != null && view == PbFragment.this.lIG.lPL.dpX().dnq()) {
                                                PbFragment.this.lIG.lPL.baz();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Ft(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dno()) {
                                                    if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnz()) {
                                                        if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnp()) {
                                                            if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnA()) {
                                                                if (PbFragment.this.lIG.dpc() == view) {
                                                                    if (PbFragment.this.lIG.dpc().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lEs.getPbData();
                                                                        if (pbData2 != null && pbData2.diN() != null && pbData2.diN().bnd() != null) {
                                                                            String bmT = pbData2.diN().bnd().bmT();
                                                                            if (StringUtils.isNull(bmT)) {
                                                                                bmT = pbData2.diN().bnd().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dW("obj_id", bmT));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gr("c10725", null);
                                                                    }
                                                                    PbFragment.this.dlA();
                                                                } else if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dny()) {
                                                                    if (PbFragment.this.lIG.lPL.dpX() != null && view == PbFragment.this.lIG.lPL.dpX().dnu()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lIG.b(PbFragment.this.lEs.getPbData(), PbFragment.this.lEs.dmg(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lIG.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lIG.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lIG.lPL.baz();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dW("tid", PbFragment.this.lEs.dme());
                                                                            aqVar.dW("fid", PbFragment.this.lEs.getForumId());
                                                                            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.an("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                PbFragment.this.lIG.doP();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dLy() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.nnI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bst = postData.nnI.bst();
                                                                                        bst.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bst.an("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bst.an("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bst);
                                                                                    }
                                                                                    String dme = PbFragment.this.lEs.dme();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lEs.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lEs.getPbData().djc();
                                                                                    }
                                                                                    PbFragment.this.cBI();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a OE = PbFragment.this.OE(id);
                                                                                        if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && OE != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dme, id, "pb", true, null, true, null, i3, postData.dqX(), PbFragment.this.lEs.getPbData().getAnti(), false, postData.bnx().getIconInfo()).addBigImageData(OE.lEG, OE.eHG, OE.eHE, OE.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lEs.dmP());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lEs.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lEs.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lEs.dmo());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a OE2 = PbFragment.this.OE(id);
                                                                                        if (postData != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && OE2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dme, id, "pb", true, null, false, str2, i3, postData.dqX(), PbFragment.this.lEs.getPbData().getAnti(), false, postData.bnx().getIconInfo()).addBigImageData(OE2.lEG, OE2.eHG, OE2.eHE, OE2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lEs.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lEs.dmo());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lEs.dmP());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lEs.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 3).dW("fid", PbFragment.this.lEs.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lEs != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dW("tid", PbFragment.this.lEs.dme());
                                                                            aqVar2.dW("fid", PbFragment.this.lEs.getForumId());
                                                                            aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.an("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nnI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bst2 = postData3.nnI.bst();
                                                                                        bst2.delete("obj_locate");
                                                                                        bst2.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bst2);
                                                                                    }
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                        String dme2 = PbFragment.this.lEs.dme();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lEs.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lEs.getPbData().djc();
                                                                                        }
                                                                                        PbActivity.a OE3 = PbFragment.this.OE(id2);
                                                                                        if (OE3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dme2, id2, "pb", true, null, false, null, i4, postData3.dqX(), PbFragment.this.lEs.getPbData().getAnti(), false, postData3.bnx().getIconInfo()).addBigImageData(OE3.lEG, OE3.eHG, OE3.eHE, OE3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lEs.dmP());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lEs.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lEs.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lEs.dmo());
                                                                                            if (PbFragment.this.lEs.getPbData().djw() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lEs.getPbData().djw().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lEs.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lEs.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lEs.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lEs.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lEs.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lEs.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lEs.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lEs.getPbData().getForum().getUser_level());
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
                                                                        if (PbFragment.this.lEs != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dW("tid", PbFragment.this.lEs.dme());
                                                                                aqVar3.dW("fid", PbFragment.this.lEs.getForumId());
                                                                                aqVar3.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.an("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nnI != null) {
                                                                                        com.baidu.tbadk.core.util.aq bst3 = postData4.nnI.bst();
                                                                                        bst3.delete("obj_locate");
                                                                                        bst3.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bst3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dW("tid", PbFragment.this.lEs.dmf()).dW("fid", PbFragment.this.lEs.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.dkW().dnU() != null && postData4.bnx() != null && postData4.dLm() != 1) {
                                                                                        if (PbFragment.this.dkW().dnV() != null) {
                                                                                            PbFragment.this.dkW().dnV().dkM();
                                                                                        }
                                                                                        if (PbFragment.this.lIB && postData4.dLj() != null && postData4.dLj().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lEs.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lEs.getPbData().diN());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.dkW().dnU().d(pVar);
                                                                                            PbFragment.this.dkW().dnU().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bnx().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lIS != null) {
                                                                                                PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
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
                                                                        if (view != PbFragment.this.lIG.dkn()) {
                                                                            if (view == PbFragment.this.lIG.lPL.dpY()) {
                                                                                PbFragment.this.lIG.doD();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (ceVar = (ce) view.getTag()) != null && !StringUtils.isNull(ceVar.bpS())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        be.bsB().b(PbFragment.this.getPageContext(), new String[]{ceVar.bpS()});
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData5 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dW("tid", PbFragment.this.lEs.lLR));
                                                                                            }
                                                                                            if (PbFragment.this.lIL == null) {
                                                                                                PbFragment.this.lIL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lIL.a(PbFragment.this.lJD);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dI(view);
                                                                                            if (!PbFragment.this.dI(view) || PbFragment.this.lJc == null || !PbFragment.this.lJc.isGif()) {
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
                                                                                                if (postData5.dLo() != null && postData5.dLo().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lIL);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eSW.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.khK = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lEs.getPbData().bjE()) {
                                                                                                String bjD = PbFragment.this.lEs.getPbData().bjD();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bjD) && bjD.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lIL);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lIL);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.khK);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eSW.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lIL);
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
                                                                                                            gVar.eSW.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar5);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.uL(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIL);
                                                                                                                gVar6.eSW.setTag(str3);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIL);
                                                                                                                gVar2.eSW.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lIL);
                                                                                                            gVar8.eSW.setTag(sparseArray9);
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
                                                                                                            if (PbFragment.this.lEs.getPbData().djc() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIL);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIL);
                                                                                                            }
                                                                                                            gVar2.eSW.setTag(sparseArray10);
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar7 != null) {
                                                                                                            arrayList.add(gVar7);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lIL.bB(arrayList);
                                                                                                    PbFragment.this.lIK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIL);
                                                                                                    PbFragment.this.lIK.Pd();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.khK);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eSW.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lIL.bB(arrayList);
                                                                                            PbFragment.this.lIK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIL);
                                                                                            PbFragment.this.lIK.Pd();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lEs.getPbData().diN().getActUrl());
                                                                                        if (PbFragment.this.lEs.getPbData().diN().bok() != 1) {
                                                                                            if (PbFragment.this.lEs.getPbData().diN().bok() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dW("fid", PbFragment.this.lEs.getPbData().getForumId()).dW("tid", PbFragment.this.lEs.getPbData().getThreadId()).dW("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lEs.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lIG.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.brx().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lIG.dnX();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dlf() == 1 && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dW("fid", PbFragment.this.lEs.getPbData().getForumId()).dW("tid", PbFragment.this.lEs.getPbData().getThreadId()).dW("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dlf() == 1 && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dW("fid", PbFragment.this.lEs.getPbData().getForumId()).dW("tid", PbFragment.this.lEs.getPbData().getThreadId()).dW("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dlv();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dlw();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().djj() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lEs.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dW("fid", pbData3.getForumId()));
                                                                                        be.bsB().b(PbFragment.this.getPageContext(), new String[]{pbData3.djj().djx()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().djj() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lEs.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dW("fid", pbData4.getForumId()));
                                                                                        be.bsB().b(PbFragment.this.getPageContext(), new String[]{pbData4.djj().djx()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lJf >= 0) {
                                                                                        if (PbFragment.this.lEs != null) {
                                                                                            PbFragment.this.lEs.dmQ();
                                                                                        }
                                                                                        if (PbFragment.this.lEs != null && PbFragment.this.lIG.dop() != null) {
                                                                                            PbFragment.this.lIG.dop().a(PbFragment.this.lEs.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lJf = 0;
                                                                                        if (PbFragment.this.lEs != null) {
                                                                                            PbFragment.this.lIG.getListView().setSelection(PbFragment.this.lEs.dmT());
                                                                                            PbFragment.this.lEs.dc(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.Ft(8);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                    SparseArray sparseArray11 = null;
                                                                                    if (view.getTag() instanceof SparseArray) {
                                                                                        sparseArray11 = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray11 != null) {
                                                                                        PbFragment.this.g(sparseArray11);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                    if (PbFragment.this.lIG.getListView() != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lIG.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lIG.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean djn = PbFragment.this.lEs.getPbData().djn();
                                                                                        boolean z8 = PbFragment.this.lIG.dnW() != null && PbFragment.this.lIG.dnW().isVertical();
                                                                                        boolean doM = PbFragment.this.lIG.doM();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (djn && PbFragment.this.lIG.dnW() != null && PbFragment.this.lIG.dnW().bRe() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lIG.dnW().dpH();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lIG.dnW().bRe().getHeight() - PbFragment.this.lIG.dnW().dpH());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.OF("c13568");
                                                                                        if ((PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bno() <= 0) || (doM && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dlc();
                                                                                                if (PbFragment.this.lEs.getPbData().diN().bnx() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dW("tid", PbFragment.this.lEs.lLR).dW("fid", PbFragment.this.lEs.getPbData().getForumId()).an("obj_locate", 2).dW("uid", PbFragment.this.lEs.getPbData().diN().bnx().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (djn) {
                                                                                                if (PbFragment.this.lIG.lQW != null && PbFragment.this.lIG.lQW.lSe != null && PbFragment.this.lIG.lQW.lSe.getView() != null) {
                                                                                                    if (PbFragment.this.lIG.lQW.lSe.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dll();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lIG.dnW() != null && PbFragment.this.lIG.dnW().bRe() != null) {
                                                                                                            i5 = PbFragment.this.lIG.dnW().bRe().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lIG.lQW.lSe.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lIG.dog() != null) {
                                                                                                z10 = PbFragment.this.lIG.dog().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lIG.lQW != null && PbFragment.this.lIG.lQW.lSe != null && PbFragment.this.lIG.lQW.lSe.getView() != null && PbFragment.this.lIG.lQW.lSe.getView().getParent() != null && PbFragment.this.lIG.lPL != null && PbFragment.this.lIG.lPL.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lIG.lQW.lSe.getView().getTop() - PbFragment.this.lIG.lPL.mNavigationBar.getBottom() < PbFragment.this.lIG.lQW.lSe.lPl.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || doM) {
                                                                                                PbFragment.this.lIw = firstVisiblePosition;
                                                                                                PbFragment.this.lIx = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lIG.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lIw > 0) {
                                                                                                if (PbFragment.this.lIG.getListView().getChildAt(PbFragment.this.lIw) != null) {
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollToPosition(PbFragment.this.lIw, PbFragment.this.lIx, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lIG.getListView().setSelectionFromTop(PbFragment.this.lIw, PbFragment.this.lIx + equipmentHeight);
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dll = PbFragment.this.dll();
                                                                                                if (PbFragment.this.dlk() != -1) {
                                                                                                    dll--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dll < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.x.getCount(PbFragment.this.lIG.getListView().getData()) - 1) + PbFragment.this.lIG.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dll;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!djn || PbFragment.this.lIG.dnW() == null) ? (PbFragment.this.lIG.lPL == null || PbFragment.this.lIG.lPL.mNavigationBar == null) ? dimens : (PbFragment.this.lIG.lPL.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lIG.dnW().dpG() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lIG.lQW == null || PbFragment.this.lIG.lQW.lSe == null || PbFragment.this.lIG.lQW.lSe.getView() == null || PbFragment.this.lIG.lQW.lSe.getView().getParent() == null) {
                                                                                                    PbFragment.this.lIG.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lIG.getListView().smoothScrollBy(PbFragment.this.lIG.lQW.lSe.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dW("tid", PbFragment.this.lEs.lLR).dW("fid", PbFragment.this.lEs.getPbData().getForumId()).an("obj_locate", 2).dW("uid", PbFragment.this.lEs.getPbData().diN().bnx().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.lEs.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lEs.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lEs.djW()) || PbFragment.this.lEs.getAppealInfo() == null) {
                                                                                                PbFragment.this.lHZ.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lEs.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lEs.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lHZ.finish();
                                                                                            return;
                                                                                        }
                                                                                        String djW = PbFragment.this.lEs.djW();
                                                                                        if (PbFragment.this.lEs.dmh() && djW != null && djW.equals(name)) {
                                                                                            PbFragment.this.lHZ.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lEs.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dW("tid", PbFragment.this.lEs.dme());
                                                                                        aqVar4.dW("fid", PbFragment.this.lEs.getForumId());
                                                                                        aqVar4.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lEs.getPbData().diN() != null) {
                                                                                            aqVar4.dW(IntentConfig.NID, PbFragment.this.lEs.getPbData().diN().blV());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar = (bz) view.getTag();
                                                                                        if (PbFragment.this.lEs.dmP() == 3 && PbFragment.this.djV() && PbFragment.this.lEs.getPbData() != null && com.baidu.tbadk.core.util.x.isEmpty(PbFragment.this.lEs.getPbData().djk())) {
                                                                                            PbFragment.this.lHZ.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar.bnB(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dW("tid", bzVar.getId());
                                                                                        aqVar5.w("fid", bzVar.getFid());
                                                                                        aqVar5.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dW(IntentConfig.NID, bzVar.blV());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lEs != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dW("tid", PbFragment.this.lEs.dme());
                                                                                        aqVar6.dW("fid", PbFragment.this.lEs.getForumId());
                                                                                        aqVar6.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.an("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lEs.getPbData();
                                                                                        if (PbFragment.this.lIF == null) {
                                                                                            PbFragment.this.lIF = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").w("forum_id", j2).bsu();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lJH);
                                                                                        PbFragment.this.lIF.I(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dW("fid", PbFragment.this.lEs.getForumId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dW("obj_source", "PB_card").dW("tid", PbFragment.this.lEs.dme()).an("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar2 = (bz) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar2.bnB(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dW("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 9).an("obj_locate", 9).w("obj_id", bzVar2.getFid()).dW("tid", bzVar2.getId()).an("thread_type", bzVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bz) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bz bzVar3 = (bz) view.getTag();
                                                                                        if (PbFragment.this.fle != null) {
                                                                                            PbFragment.this.fle.gq(bzVar3.bnB(), String.valueOf(bzVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dW("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).an("obj_locate", 11).w("obj_id", bzVar3.getFid()).dW("tid", bzVar3.getId()).an("thread_type", bzVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                    aqVar7.dW("tid", PbFragment.this.lEs.dme());
                                                                                    aqVar7.dW("fid", PbFragment.this.lEs.getForumId());
                                                                                    aqVar7.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    aqVar7.an("obj_locate", 7);
                                                                                    TiebaStatic.log(aqVar7);
                                                                                    PbFragment.this.lIa = false;
                                                                                    PbFragment.this.dH(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lEs.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lEs.dme(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lEs.getPbData().diN().bnR())));
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
                                                                            if (PbFragment.this.lIL == null) {
                                                                                PbFragment.this.lIL = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lIL.a(PbFragment.this.lJD);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dkd().getPbData() != null && PbFragment.this.dkd().getPbData().djq();
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
                                                                                if (postData6.bpr() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bpr().hasAgree && postData6.bpb() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lIL);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eSW.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lIL);
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
                                                                                        gVar10.eSW.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar10);
                                                                                    } else {
                                                                                        if ((PbFragment.this.uL(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIL);
                                                                                            gVar11.eSW.setTag(str);
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
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIL);
                                                                                            gVar12.eSW.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lIL);
                                                                                        gVar3.eSW.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.lEs.getPbData().djc() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lIL);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lIL);
                                                                                            }
                                                                                            gVar12.eSW.setTag(sparseArray15);
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
                                                                                PbFragment.this.lIL.bB(arrayList2);
                                                                                PbFragment.this.lIK = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lIL);
                                                                                PbFragment.this.lIK.Pd();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lIG.doP();
                                                                    SparseArray<Object> b3 = PbFragment.this.lIG.b(PbFragment.this.lEs.getPbData(), PbFragment.this.lEs.dmg(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEs.getPbData().getForum().getId(), PbFragment.this.lEs.getPbData().getForum().getName(), PbFragment.this.lEs.getPbData().diN().getId(), String.valueOf(PbFragment.this.lEs.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    com.baidu.tbadk.core.util.ao.C(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).an("obj_type", 0).an("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).an("obj_type", 1).an("obj_source", 1));
                                                                }
                                                                PbFragment.this.lIG.lPL.dpW();
                                                            }
                                                        } else if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null) {
                                                            PbFragment.this.lIG.lPL.baz();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.OB(PbFragment.this.lEs.getPbData().diN().bnN());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lIG.doP();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lEs.dmy()));
                                                                return;
                                                            }
                                                            PbFragment.this.cBI();
                                                            PbFragment.this.lIG.dow();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lEs.getPbData().lBl == null || PbFragment.this.lEs.getPbData().lBl.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lEs.getPbData().lBl.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lEs.getPbData().lBl.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lEs.getPbData().lBl.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lEs.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lEs.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lEs.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lEs.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i9));
                                                                    if (PbFragment.this.lEs.getPbData().lBl != null && PbFragment.this.lEs.getPbData().lBl.size() > i8) {
                                                                        i8 = PbFragment.this.lEs.getPbData().lBl.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean FB = PbFragment.this.lEs.FB(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lEs.dmy()));
                                                                    if (FB) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lIG.vj(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.Pd();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lIG.doP();
                                                    if (PbFragment.this.dkd().getPbData().lBm != 2) {
                                                        if (PbFragment.this.lEs.getPageData() != null) {
                                                            PbFragment.this.lIG.a(PbFragment.this.lEs.getPageData(), PbFragment.this.lpb);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lEs.getPbData()) != null) {
                                                bz diN = pbData.diN();
                                                if (diN != null && diN.bnx() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dW("tid", PbFragment.this.lEs.lLR).dW("fid", pbData.getForumId()).an("obj_locate", 4).dW("uid", diN.bnx().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (diN != null) {
                                                    if (diN.bme()) {
                                                        i8 = 2;
                                                    } else if (diN.bmf()) {
                                                        i8 = 3;
                                                    } else if (diN.bpv()) {
                                                        i8 = 4;
                                                    } else if (diN.bpw()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar8.dW("tid", PbFragment.this.lEs.dme());
                                                aqVar8.dW("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar8.dW("fid", PbFragment.this.lEs.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar8.an("obj_locate", 5);
                                                } else {
                                                    aqVar8.an("obj_locate", 6);
                                                }
                                                aqVar8.an("obj_name", i8);
                                                aqVar8.an("obj_type", 1);
                                                if (diN != null) {
                                                    if (diN.bme()) {
                                                        aqVar8.an("obj_type", 10);
                                                    } else if (diN.bmf()) {
                                                        aqVar8.an("obj_type", 9);
                                                    } else if (diN.bpw()) {
                                                        aqVar8.an("obj_type", 8);
                                                    } else if (diN.bpv()) {
                                                        aqVar8.an("obj_type", 7);
                                                    } else if (diN.isShareThread) {
                                                        aqVar8.an("obj_type", 6);
                                                    } else if (diN.threadType == 0) {
                                                        aqVar8.an("obj_type", 1);
                                                    } else if (diN.threadType == 40) {
                                                        aqVar8.an("obj_type", 2);
                                                    } else if (diN.threadType == 49) {
                                                        aqVar8.an("obj_type", 3);
                                                    } else if (diN.threadType == 54) {
                                                        aqVar8.an("obj_type", 4);
                                                    } else {
                                                        aqVar8.an("obj_type", 5);
                                                    }
                                                    aqVar8.an(IntentConfig.CARD_TYPE, diN.bpz());
                                                    aqVar8.dW(IntentConfig.RECOM_SOURCE, diN.mRecomSource);
                                                    aqVar8.dW("ab_tag", diN.mRecomAbTag);
                                                    aqVar8.dW("weight", diN.mRecomWeight);
                                                    aqVar8.dW("extra", diN.mRecomExtra);
                                                    aqVar8.dW(IntentConfig.NID, diN.blV());
                                                    if (diN.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(diN.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar8.dW("obj_param6", diN.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar8.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dlL() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dlL(), aqVar8);
                                                }
                                                TiebaStatic.log(aqVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> diP2 = PbFragment.this.lEs.getPbData().diP();
                                                    if ((diP2 != null && diP2.size() > 0) || !PbFragment.this.lEs.dmg()) {
                                                        PbFragment.this.lIG.doP();
                                                        PbFragment.this.cBI();
                                                        if (pbData.djj() != null && !StringUtils.isNull(pbData.djj().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dW("fid", PbFragment.this.lEs.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), diN)) {
                                                            if (PbFragment.this.lIG != null) {
                                                                PbFragment.this.lIG.doS();
                                                                PbFragment.this.lIG.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lIG.showLoadingDialog();
                                                                PbFragment.this.lEs.dmK().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i9 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i9 = 1;
                                                                }
                                                                PbFragment.this.Fs(i9);
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
                                            PbFragment.this.lIG.doP();
                                            if (PbFragment.this.lIG.lPL.dpX() != null && view == PbFragment.this.lIG.lPL.dpX().dnr() && !PbFragment.this.lIG.dph()) {
                                                PbFragment.this.lIG.dnX();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cBI();
                                                PbFragment.this.lIG.dow();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lEs.C(true, PbFragment.this.dlt());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lEs.C(false, PbFragment.this.dlt()) : PbFragment.this.lEs.OG(PbFragment.this.dlt());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.lIG.uE(true);
                                                    PbFragment.this.lIG.dos();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lIG.vj(true);
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
                                        PbFragment.this.lIG.doP();
                                        if (PbFragment.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lEs.FC(PbFragment.this.lIG.doB()) != null) {
                                            PbFragment.this.dlo();
                                            if (PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dW("tid", PbFragment.this.lEs.lLR).dW("fid", PbFragment.this.lEs.getPbData().getForumId()).an("obj_locate", 3).dW("uid", PbFragment.this.lEs.getPbData().diN().bnx().getUserId()));
                                            }
                                            if (PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null && PbFragment.this.lEs.getPbData().diN().bnx().getUserId() != null && PbFragment.this.lIE != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lEs.getPbData());
                                                bz diN2 = PbFragment.this.lEs.getPbData().diN();
                                                int i10 = 1;
                                                if (diN2.bme()) {
                                                    i10 = 2;
                                                } else if (diN2.bmf()) {
                                                    i10 = 3;
                                                } else if (diN2.bpv()) {
                                                    i10 = 4;
                                                } else if (diN2.bpw()) {
                                                    i10 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dW("tid", PbFragment.this.lEs.lLR).an("obj_locate", 1).dW("obj_id", PbFragment.this.lEs.getPbData().diN().bnx().getUserId()).an("obj_type", PbFragment.this.lIE.bjE() ? 0 : 1).an("obj_source", h).an("obj_param1", i10));
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bmc() && PbFragment.this.lEs.getPbData().diN().bnO() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.lEs.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lEs.djW()) || PbFragment.this.lEs.getAppealInfo() == null) {
                                            PbFragment.this.lHZ.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lEs.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lEs.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lHZ.finish();
                                        return;
                                    }
                                    String djW2 = PbFragment.this.lEs.djW();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lEs.dmh() && djW2 != null && djW2.equals(name2)) {
                                        PbFragment.this.lHZ.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lEs.getPbData() != null && !PbFragment.this.gca.dMh()) {
                                    PbFragment.this.lIG.doP();
                                    int i11 = 0;
                                    if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnt()) {
                                        if (PbFragment.this.lIG.lPL.dpX() == null || view != PbFragment.this.lIG.lPL.dpX().dnv()) {
                                            if (view == PbFragment.this.lIG.dou()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lEs.getPbData().diN().bnt() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lEs.getPbData().diN().bns() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lEs.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lEs.getPbData().diN().getId();
                                    PbFragment.this.lIG.dor();
                                    PbFragment.this.gca.c(id4, name3, id5, i11, PbFragment.this.lIG.dov());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lIG.lPL.dpW();
                            if (PbFragment.this.lEs != null) {
                                PbFragment.this.ise.setThreadId(PbFragment.this.lEs.dme());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lEs == null || !PbFragment.this.lEs.isPrivacy()) {
                                PbFragment.this.ise.cqF();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dkd() != null && PbFragment.this.dkd().getPbData() != null && PbFragment.this.dkd().getPbData().getThreadId() != null && PbFragment.this.dkd().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dkd() != null && PbFragment.this.dkd().getPbData() != null) {
                                    PbFragment.this.ise.l(3, i12, PbFragment.this.dkd().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dkd() != null && PbFragment.this.dkd().getPbData() != null) {
                                    PbFragment.this.ise.l(3, 3, PbFragment.this.dkd().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lIG.doP();
                        PbFragment.this.cBI();
                        PbFragment.this.lIG.dow();
                        PbFragment.this.lIG.showLoadingDialog();
                        if (PbFragment.this.lIG.dog() != null) {
                            PbFragment.this.lIG.dog().setVisibility(8);
                        }
                        PbFragment.this.lEs.Fw(1);
                        if (PbFragment.this.lIc != null) {
                            PbFragment.this.lIc.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dld = PbFragment.this.dld();
                        if (!TextUtils.isEmpty(dld)) {
                            be.bsB().b(PbFragment.this.getPageContext(), new String[]{dld});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar9 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar9.dW("tid", PbFragment.this.lEs.dme());
                aqVar9.dW("fid", PbFragment.this.lEs.getForumId());
                aqVar9.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar9.an("obj_locate", 1);
                TiebaStatic.log(aqVar9);
                if (PbFragment.this.lIl) {
                    PbFragment.this.lIl = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.dkW().dnU() != null && postData7.bnx() != null && postData7.dLm() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dkW().dnV() != null) {
                                PbFragment.this.dkW().dnV().dkM();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lEs.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lEs.getPbData().diN());
                            pVar2.g(postData7);
                            PbFragment.this.dkW().dnU().d(pVar2);
                            PbFragment.this.dkW().dnU().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bnx().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lEs.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lIS != null) {
                                PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lJF = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lEs != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lEs.lLR)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lEs.getPbData() != null) {
                    aqVar.dW("fid", PbFragment.this.lEs.getPbData().getForumId());
                }
                aqVar.dW("tid", PbFragment.this.lEs.dme());
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cBI();
            PbFragment.this.lIG.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lEs.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lEs.getPbData();
                            if (pbData != null && pbData.diN() != null && pbData.diN().bnx() != null && (userId = pbData.diN().bnx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lEs.dmr()) {
                                PbFragment.this.lIG.dow();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lEs.dmr()) {
                            PbFragment.this.lIG.dow();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lIG.s(PbFragment.this.lEs.getPbData());
                    }
                    if (PbFragment.this.lEs.dml()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dW("tid", PbFragment.this.lEs.dme()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uK(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lIS.bBK() || PbFragment.this.lIS.bBL()) {
                    PbFragment.this.lIS.a(false, postWriteCallBackData);
                }
                PbFragment.this.kOl.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kKi != null) {
                    PbFragment.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqe();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lJG = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                    aqVar.dW("fid", PbFragment.this.lEs.getPbData().getForumId());
                }
                if (PbFragment.this.lEs != null) {
                    aqVar.dW("tid", PbFragment.this.lEs.dme());
                }
                aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.kOl != null) {
                    PbFragment.this.kOl.dpp();
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
                if (PbFragment.this.kKi != null) {
                    PbFragment.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqe();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kOl != null) {
                if (PbFragment.this.lIG != null && PbFragment.this.lIG.dnV() != null && PbFragment.this.lIG.dnV().dkQ() != null && PbFragment.this.lIG.dnV().dkQ().bBL()) {
                    PbFragment.this.lIG.dnV().dkQ().a(postWriteCallBackData);
                }
                PbFragment.this.kOl.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lJH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dpk;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lHZ.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lIG != null && (dpk = PbFragment.this.lIG.dpk()) != null && PbFragment.this.lIG.getListView() != null) {
                            PbFragment.this.lIG.getListView().removeHeaderView(dpk);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lJI = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qM;
            if (!z || fVar == null || fVar.dja() != null || com.baidu.tbadk.core.util.x.getCount(fVar.diP()) >= 1) {
                PbFragment.this.ldW = true;
                PbFragment.this.lIG.doy();
                if (fVar == null || !fVar.diV()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lIG.getView());
                }
                PbFragment.this.lIG.dot();
                if (PbFragment.this.isFullScreen || PbFragment.this.lIG.dph()) {
                    PbFragment.this.lIG.doY();
                } else if (!PbFragment.this.lIG.doV()) {
                    PbFragment.this.lIG.vv(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.gjs = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lIG.getView());
                    PbFragment.this.lIG.doH();
                }
                if (z && fVar != null) {
                    bz diN = fVar.diN();
                    if (diN == null || !diN.bmg()) {
                        PbFragment.this.d(PbFragment.this.lIR);
                    } else {
                        dlN();
                    }
                    PbFragment.this.lIG.dnV().setPbData(fVar);
                    PbFragment.this.lIG.bXh();
                    if (diN != null && diN.boK() != null) {
                        PbFragment.this.a(diN.boK());
                    }
                    if (PbFragment.this.lIS != null) {
                        PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.diP() != null && fVar.diP().size() >= 1 && fVar.diP().get(0) != null) {
                        PbFragment.this.lEs.OI(fVar.diP().get(0).getId());
                    } else if (fVar.dja() != null) {
                        PbFragment.this.lEs.OI(fVar.dja().getId());
                    }
                    if (PbFragment.this.lIS != null) {
                        PbFragment.this.lIS.a(fVar.getAnti());
                        PbFragment.this.lIS.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lIS.setThreadData(diN);
                        PbFragment.this.lIS.a(PbFragment.this.lEs.dmv(), PbFragment.this.lEs.dme(), PbFragment.this.lEs.dmM());
                        if (diN != null) {
                            PbFragment.this.lIS.kV(diN.boX());
                        }
                    }
                    if (PbFragment.this.lIE != null) {
                        PbFragment.this.lIE.iY(fVar.bjE());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.djq()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lIG.vu(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lIG.a(fVar, i2, i3, PbFragment.this.lEs.dmg(), i4, PbFragment.this.lEs.getIsFromMark());
                    PbFragment.this.lIG.d(fVar, PbFragment.this.lEs.dmg());
                    PbFragment.this.lIG.vr(PbFragment.this.lEs.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fBw = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fBw) && PbFragment.this.lIS != null && PbFragment.this.lIS.bAP() != null && (qM = PbFragment.this.lIS.bAP().qM(6)) != null && !TextUtils.isEmpty(PbFragment.this.fBw)) {
                            ((View) qM).setOnClickListener(PbFragment.this.fCk);
                        }
                    }
                    if (PbFragment.this.lIN) {
                        PbFragment.this.lIN = false;
                        final int dlk = PbFragment.this.dlk();
                        if (!fVar.djn()) {
                            PbFragment.this.lIG.FJ(dlk);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dlk, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lIO) {
                        PbFragment.this.lIO = false;
                        final int dlk2 = PbFragment.this.dlk();
                        final boolean z2 = dlk2 != -1;
                        if (!z2) {
                            dlk2 = PbFragment.this.dll();
                        }
                        if (PbFragment.this.lIG != null) {
                            if (!fVar.djn()) {
                                PbFragment.this.lIG.FJ(dlk2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dlk2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lIG.setSelectionFromTop(dlk2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lIG.setSelectionFromTop(dlk2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lIG.vw(true);
                                PbFragment.this.lIG.vv(false);
                            }
                        }
                    } else if (PbFragment.this.lIP) {
                        PbFragment.this.lIP = false;
                        PbFragment.this.lIG.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lIG.doC();
                    }
                    PbFragment.this.lEs.a(fVar.getForum(), PbFragment.this.lJt);
                    PbFragment.this.lEs.a(PbFragment.this.lJu);
                    if (PbFragment.this.kKi != null && diN != null && diN.bnx() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(diN.bnx());
                        PbFragment.this.kKi.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.gjs && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lEs.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lEs.getAppealInfo().lBd)) {
                                    PbFragment.this.lIG.a(PbFragment.this.lEs.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lIG.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lIG.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lIG.doY();
                            PbFragment.this.lIG.doG();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lEs.dme());
                            jSONObject.put("fid", PbFragment.this.lEs.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbFragment.this.lIG.OO("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                            arrayList = PbFragment.this.lEs.getPbData().diP();
                        }
                        if (com.baidu.tbadk.core.util.x.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.x.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dLm() != 1)) {
                            PbFragment.this.lIG.OO(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dlE()) {
                                PbFragment.this.lIG.OP(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lIG.OP(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lIG.s(PbFragment.this.lEs.getPbData());
                        }
                    }
                    PbFragment.this.lIG.endLoadData();
                }
                if (fVar != null && fVar.lBs && PbFragment.this.fHj == 0) {
                    PbFragment.this.fHj = System.currentTimeMillis() - PbFragment.this.iDg;
                }
                if (!PbFragment.this.dkd().dmg() || PbFragment.this.dkd().getPbData().getPage().bmn() != 0 || PbFragment.this.dkd().dmH()) {
                    PbFragment.this.lIT = true;
                    return;
                }
                return;
            }
            PbFragment.this.lEs.Fw(1);
            if (PbFragment.this.lIc != null) {
                PbFragment.this.lIc.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dlN() {
            if (PbFragment.this.lEs != null) {
                if (PbFragment.this.lIS == null || !PbFragment.this.lIS.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lIS = (com.baidu.tbadk.editortools.pb.e) dVar.fh(PbFragment.this.getContext());
                    PbFragment.this.lIS.a(PbFragment.this.lHZ.getPageContext());
                    PbFragment.this.lIS.a(PbFragment.this.fBH);
                    PbFragment.this.lIS.a(PbFragment.this.fBz);
                    PbFragment.this.lIS.a(PbFragment.this.lHZ.getPageContext(), PbFragment.this.lHZ.getIntent() == null ? null : PbFragment.this.lHZ.getIntent().getExtras());
                    PbFragment.this.lIS.bAP().kK(true);
                    PbFragment.this.lIG.setEditorTools(PbFragment.this.lIS.bAP());
                    if (!PbFragment.this.lEs.dmm()) {
                        PbFragment.this.lIS.CG(PbFragment.this.lEs.dme());
                    }
                    if (PbFragment.this.lEs.dmN()) {
                        PbFragment.this.lIS.CE(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lIG != null) {
                        PbFragment.this.lIS.CE(PbFragment.this.lIG.dnZ());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lIG.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bDO().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iDg : j;
                if (PbFragment.this.fHj == 0) {
                    PbFragment.this.fHj = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fHa, PbFragment.this.createTime, PbFragment.this.fHj, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fHa = 0L;
                if (hVar != null) {
                    hVar.bDL();
                }
                if (z2) {
                    hVar.fHs = currentTimeMillis;
                    hVar.lj(true);
                }
                if (!z2 && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null) {
                    int threadType = PbFragment.this.lEs.getPbData().diN().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.lIp, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.lIp, "from_frs")) {
                                com.baidu.tbadk.n.h hVar2 = new com.baidu.tbadk.n.h();
                                hVar2.setSubType(1000);
                                hVar2.fHu = currentTimeMillis;
                                hVar2.rp(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fHu = currentTimeMillis;
                        dVar.rp(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lJJ = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dlg();
            }
        }
    };
    private final a.InterfaceC0557a lJK = new a.InterfaceC0557a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0557a
        public void g(boolean z, boolean z2, String str) {
            PbFragment.this.lIG.doy();
            if (z) {
                if (PbFragment.this.lIE != null) {
                    PbFragment.this.lIE.iY(z2);
                }
                PbFragment.this.lEs.uZ(z2);
                if (PbFragment.this.lEs.bjE()) {
                    PbFragment.this.dlp();
                } else {
                    PbFragment.this.lIG.s(PbFragment.this.lEs.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lIE != null) {
                        if (PbFragment.this.lIE.bjH() != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lEs.getPbData().diN() != null && PbFragment.this.lEs.getPbData().diN().bnx() != null) {
                            MarkData bjH = PbFragment.this.lIE.bjH();
                            MetaData bnx = PbFragment.this.lEs.getPbData().diN().bnx();
                            if (bjH != null && bnx != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), bnx.getUserId()) && !bnx.hadConcerned()) {
                                    PbFragment.this.b(bnx);
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
                    PbFragment.this.dlm();
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
            if (!PbFragment.this.Ff(PbFragment.this.mLastScrollState) && PbFragment.this.Ff(i)) {
                if (PbFragment.this.lIG != null) {
                    PbFragment.this.lIG.doP();
                    if (PbFragment.this.lIS != null && !PbFragment.this.lIG.dnY()) {
                        PbFragment.this.lIG.vt(PbFragment.this.lIS.bBD());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lIG.dnX();
                    }
                }
                if (!PbFragment.this.lIi) {
                    PbFragment.this.lIi = true;
                }
            }
            if (PbFragment.this.lIG != null) {
                PbFragment.this.lIG.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lIc != null) {
                PbFragment.this.lIc.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lIj == null) {
                PbFragment.this.lIj = new com.baidu.tbadk.n.b();
                PbFragment.this.lIj.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lIj.bDH();
            } else {
                PbFragment.this.lIj.bDG();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dKg().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> diP;
            if (PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null && PbFragment.this.lIG != null && PbFragment.this.lIG.dop() != null) {
                PbFragment.this.lIG.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lIc != null) {
                    PbFragment.this.lIc.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lEs.dmD() && (diP = PbFragment.this.lEs.getPbData().diP()) != null && !diP.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lIG.dop().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lEs.getPbData();
                    if (pbData != null) {
                        if (pbData.diQ() != null && pbData.diQ().hasData()) {
                            headerCount--;
                        }
                        if (pbData.diR() != null && pbData.diR().hasData()) {
                            headerCount--;
                        }
                        int size = diP.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.e isj = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gca.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lEs.dmA();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lYg != 1002 || bVar.hgB) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lIG.a(1, dVar.mSuccess, dVar.npN, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gca.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lIG.a(PbFragment.this.gca.getLoadDataMode(), gVar.mSuccess, gVar.npN, false);
                            PbFragment.this.lIG.ba(gVar.npQ);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lIG.a(PbFragment.this.gca.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lJL = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c ghb = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dlu()) {
                PbFragment.this.lHZ.finish();
            }
            if (!PbFragment.this.lEs.uY(true)) {
                PbFragment.this.lIG.doz();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lJN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lJM && PbFragment.this.dlu()) {
                PbFragment.this.dlw();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lIA && PbFragment.this.lIG != null && PbFragment.this.lIG.dpm() && PbFragment.this.lEs != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dW("tid", PbFragment.this.lEs.dme());
                    aqVar.dW("fid", PbFragment.this.lEs.getForumId());
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lEs.dmh()) {
                        if (!PbFragment.this.lEs.dmk()) {
                            if (PbFragment.this.lEs.dmj()) {
                                i = 1;
                            }
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 4;
                    }
                    aqVar.an("obj_type", i);
                    TiebaStatic.log(aqVar);
                    PbFragment.this.lIA = true;
                }
                if (PbFragment.this.lEs.uX(false)) {
                    PbFragment.this.lIG.dox();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lEs.getPbData() != null) {
                    PbFragment.this.lIG.doU();
                }
                PbFragment.this.lJM = true;
            }
        }
    };
    private int lJO = 0;
    private final TbRichTextView.i fSh = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dop;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lIG.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dW("tid", PbFragment.this.lEs.dme());
                aqVar.dW("fid", PbFragment.this.lEs.getForumId());
                aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lEs.lFA.djq()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bHg() != null) {
                            ArrayList<TbRichTextImageInfo> bHg = tbRichTextView.getRichText().bHg();
                            int i4 = 0;
                            while (i4 < bHg.size()) {
                                if (bHg.get(i4) != null) {
                                    arrayList.add(bHg.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bHg.get(i4).getSrc()) || str.equals(bHg.get(i4).bHy()) || str.equals(bHg.get(i4).bHv()) || str.equals(bHg.get(i4).bHx()) || str.equals(bHg.get(i4).bHB()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bHg.get(i4).getSrc();
                                    imageUrlData.originalUrl = bHg.get(i4).getSrc();
                                    imageUrlData.isLongPic = bHg.get(i4).bHD();
                                    concurrentHashMap.put(bHg.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.f(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.s(arrayList).mN(i3).je(false).jf(PbFragment.this.lEs.dmx()).d(concurrentHashMap).jg(true).jh(false).ji(PbFragment.this.dlE()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lEs != null) {
                            aVar.zx(PbFragment.this.lEs.getFromForumId());
                            if (PbFragment.this.lEs.getPbData() != null) {
                                aVar.s(PbFragment.this.lEs.getPbData().diN());
                            }
                        }
                        ImageViewerConfig eQ = aVar.eQ(PbFragment.this.getPageContext().getPageActivity());
                        eQ.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lEH) {
                        TbRichText bG = PbFragment.this.bG(str, i);
                        if (bG != null && PbFragment.this.lJO >= 0 && PbFragment.this.lJO < bG.bHf().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bG.bHf().get(PbFragment.this.lJO));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lEG.size()) {
                                    break;
                                } else if (!aVar2.lEG.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bG.getPostId() != 0 && (dop = PbFragment.this.lIG.dop()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dop.getDataList();
                                if (com.baidu.tbadk.core.util.x.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bG.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bG.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lEs.dmM(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lEs.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eHG.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.f(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.s(arrayList2).zs(aVar2.forumName).zt(aVar2.forumId).zu(aVar2.threadId).je(aVar2.eHE).jg(true).zv(aVar2.lastId).jf(PbFragment.this.lEs.dmx()).d(concurrentHashMap2).jh(false).ji(PbFragment.this.dlE()).zw(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lEs != null) {
                                aVar3.zx(PbFragment.this.lEs.getFromForumId());
                                if (PbFragment.this.lEs.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lEs.getPbData().diN());
                                }
                            }
                            ImageViewerConfig eQ2 = aVar3.eQ(PbFragment.this.getPageContext().getPageActivity());
                            eQ2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.x.getItem(aVar2.lEG, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eHG.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.s(arrayList3).zs(aVar2.forumName).zt(aVar2.forumId).zu(aVar2.threadId).je(aVar2.eHE).jg(true).zv(aVar2.lEG.get(0)).jf(PbFragment.this.lEs.dmx()).d(concurrentHashMap3).jh(false).ji(PbFragment.this.dlE()).zw(aVar2.postId).jj(false);
                    if (PbFragment.this.lEs != null) {
                        aVar4.zx(PbFragment.this.lEs.getFromForumId());
                        if (PbFragment.this.lEs.getPbData() != null) {
                            aVar4.s(PbFragment.this.lEs.getPbData().diN());
                        }
                    }
                    ImageViewerConfig eQ3 = aVar4.eQ(PbFragment.this.getPageContext().getPageActivity());
                    eQ3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lIt = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lJP = false;
    PostData khK = null;
    private final b.InterfaceC0561b lJQ = new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.khK != null) {
                if (i == 0) {
                    PbFragment.this.khK.gT(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.khK = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.khK);
                }
            }
        }
    };
    private final b.InterfaceC0561b lJR = new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lJc != null && !TextUtils.isEmpty(PbFragment.this.lJd)) {
                if (i == 0) {
                    if (PbFragment.this.lJe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lJd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lJd;
                        aVar.pkgId = PbFragment.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lJe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eGK == null) {
                            PbFragment.this.eGK = new at(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eGK.p(PbFragment.this.lJd, PbFragment.this.lJc.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lJc = null;
                PbFragment.this.lJd = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lIa = true;
            return PbFragment.this.dH(view);
        }
    };
    private final NoNetworkView.a iXM = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lEs.dmn()) {
                PbFragment.this.dlr();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.jfv.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0710a izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int hgh = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (aA(i2) && PbFragment.this.lIG != null && PbFragment.this.lIc != null) {
                PbFragment.this.lIc.qH(true);
                if (Math.abs(i2) > this.hgh) {
                    PbFragment.this.lIc.hideFloatingView();
                }
                if (PbFragment.this.dlu()) {
                    PbFragment.this.lIG.dom();
                    PbFragment.this.lIG.don();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (aA(i2) && PbFragment.this.lIG != null && PbFragment.this.lIc != null) {
                PbFragment.this.lIG.doZ();
                PbFragment.this.lIc.qH(false);
                PbFragment.this.lIc.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }

        private boolean aA(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a lHd = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lIG.OQ(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lJT = -1;
    private int lJU = -1;

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

    public com.baidu.tbadk.editortools.pb.e dkR() {
        return this.lIS;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.djF() != null) {
            String id = pVar.djF().getId();
            ArrayList<PostData> diP = this.lEs.getPbData().diP();
            int i = 0;
            while (true) {
                if (i >= diP.size()) {
                    z = true;
                    break;
                }
                PostData postData = diP.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> djN = pVar.djN();
                    postData.Jj(pVar.getTotalCount());
                    if (postData.dLj() == null || djN == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = djN.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnx() != null && (metaData = postData.getUserMap().get(next.bnx().getUserId())) != null) {
                                next.a(metaData);
                                next.yd(true);
                                next.a(getPageContext(), this.lEs.OH(metaData.getUserId()));
                            }
                        }
                        z = djN.size() != postData.dLj().size();
                        if (postData.dLj() != null && postData.dLj().size() < 2) {
                            postData.dLj().clear();
                            postData.dLj().addAll(djN);
                        }
                    }
                    if (postData.dLf() != null) {
                        postData.dLg();
                    }
                }
            }
            if (!this.lEs.getIsFromMark() && z) {
                this.lIG.s(this.lEs.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oz(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o djf = this.lEs.getPbData().djf();
            if (djf != null && str.equals(djf.getAdId())) {
                if (djf.dLa() != null) {
                    djf.dLa().legoCard = null;
                }
                this.lEs.getPbData().djg();
            }
            com.baidu.tieba.tbadkCore.data.o dmt = this.lEs.dmt();
            if (dmt != null && str.equals(dmt.getAdId())) {
                this.lEs.dmu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lIK != null && this.lIK.isShowing()) {
                this.lIK.dismiss();
                this.lIK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lIK != null) {
                            PbFragment.this.lIK.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lIG.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lJa);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lJa);
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
                kVar.bB(arrayList);
                this.lIK = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lIK.Pd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(int i) {
        bz diN;
        if (this.lEs != null && this.lEs.getPbData() != null && (diN = this.lEs.getPbData().diN()) != null) {
            if (i == 1) {
                PraiseData bni = diN.bni();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bni == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        diN.a(praiseData);
                    } else {
                        diN.bni().getUser().add(0, metaData);
                        diN.bni().setNum(diN.bni().getNum() + 1);
                        diN.bni().setIsLike(i);
                    }
                }
                if (diN.bni() != null) {
                    if (diN.bni().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(diN.bni().getNum());
                    }
                }
            } else if (diN.bni() != null) {
                diN.bni().setIsLike(i);
                diN.bni().setNum(diN.bni().getNum() - 1);
                ArrayList<MetaData> user = diN.bni().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            diN.bni().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (diN.bni().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = diN.bni().getNum() + "";
                }
            }
            if (this.lEs.dmg()) {
                this.lIG.dop().notifyDataSetChanged();
            } else {
                this.lIG.t(this.lEs.getPbData());
            }
        }
    }

    public static PbFragment dkS() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lHZ = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lEs.aD(bundle);
        if (this.jaA != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lIS.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lIh = System.currentTimeMillis();
        this.lIY = getPageContext();
        final Intent intent = this.lHZ.getIntent();
        if (intent != null) {
            this.iDg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lIp = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lIp)) {
                    this.lIp = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lIp)) {
                this.lId = true;
            }
            this.lJT = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lJU = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lJV = intent.getStringExtra("key_manga_title");
            this.lIN = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lIO = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lIP = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dlu()) {
                this.lHZ.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lJg = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lIy = new bi();
            this.lIy.D(intent);
            this.lJi = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lJi == 0) {
                this.lJi = intent.getIntExtra("key_start_from", 0);
            }
            this.lJj = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iDg = System.currentTimeMillis();
        }
        this.fHa = this.lIh - this.iDg;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lIf = 0;
        aC(bundle);
        if (this.lEs.getPbData() != null) {
            this.lEs.getPbData().Ot(this.source);
        }
        dkV();
        if (intent != null && this.lIG != null) {
            this.lIG.lPJ = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lJb == null) {
                    this.lJb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lIG.OS("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.lJb, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lEs.getPbData() != null) {
                this.lEs.OK(stringExtra);
            }
        }
        this.jaA = new VoiceManager();
        this.jaA.onCreate(getPageContext());
        initData(bundle);
        this.lIR = new com.baidu.tbadk.editortools.pb.g();
        d(this.lIR);
        this.lIS = (com.baidu.tbadk.editortools.pb.e) this.lIR.fh(getActivity());
        this.lIS.a(this.lHZ.getPageContext());
        this.lIS.a(this.fBH);
        this.lIS.a(this.fBz);
        this.lIS.setFrom(1);
        this.lIS.a(this.lHZ.getPageContext(), bundle);
        this.lIS.bAP().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lIS.bAP().kK(true);
        uJ(true);
        this.lIS.a(this.lEs.dmv(), this.lEs.dme(), this.lEs.dmM());
        registerListener(this.lJo);
        if (!this.lEs.dmm()) {
            this.lIS.CG(this.lEs.dme());
        }
        if (this.lEs.dmN()) {
            this.lIS.CE(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lIG != null) {
            this.lIS.CE(this.lIG.dnZ());
        }
        registerListener(this.lJn);
        registerListener(this.lJp);
        registerListener(this.lJq);
        registerListener(this.jch);
        registerListener(this.lJC);
        registerListener(this.lJm);
        this.lIQ = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nmj);
        this.lIQ.dKP();
        registerListener(this.lJr);
        registerListener(this.eYu);
        this.lEs.dmF();
        registerListener(this.lJJ);
        registerListener(this.jcp);
        registerListener(this.lJF);
        if (this.lIG != null && this.lIG.dpd() != null && this.lIG.dpe() != null) {
            this.lIc = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lIG.dpd(), this.lIG.dpe(), this.lIG.dog());
            this.lIc.a(this.lJx);
        }
        if (this.lIb && this.lIG != null && this.lIG.dpe() != null) {
            this.lIG.dpe().setVisibility(8);
        }
        this.lIZ = new com.baidu.tbadk.core.view.c();
        this.lIZ.toastTime = 1000L;
        registerListener(this.lJB);
        registerListener(this.lJz);
        registerListener(this.lJA);
        registerListener(this.jjF);
        registerListener(this.jcd);
        this.lJs.setSelfListener(true);
        this.lJs.setTag(this.lHZ.getUniqueId());
        this.lJs.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lJs);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lJa = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lJa;
        userMuteAddAndDelCustomMessage.setTag(this.lJa);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lJa;
        userMuteCheckCustomMessage.setTag(this.lJa);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lEs.dmK().a(this.lJy);
        this.kOl = new ar();
        if (this.lIS.bBv() != null) {
            this.kOl.f(this.lIS.bBv().getInputView());
        }
        this.lIS.a(this.fBA);
        this.jwD = new ShareSuccessReplyToServerModel();
        a(this.lJk);
        this.kKi = new com.baidu.tbadk.core.util.al(getPageContext());
        this.kKi.a(new al.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.al.eYl) {
                        PbFragment.this.lIS.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.al.eYm && PbFragment.this.lIG != null && PbFragment.this.lIG.dnV() != null && PbFragment.this.lIG.dnV().dkQ() != null) {
                        PbFragment.this.lIG.dnV().dkQ().bBU();
                    } else if (i == com.baidu.tbadk.core.util.al.eYn) {
                        PbFragment.this.c(PbFragment.this.lIV);
                    }
                }
            }
        });
        this.lID = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lID.w(getUniqueId());
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        com.baidu.tbadk.core.business.b.bkP().dI("3", "");
        this.ise = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lIh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lEs != null) {
            gVar.setForumName(this.lEs.djW());
            if (this.lEs.getPbData() != null && this.lEs.getPbData().getForum() != null) {
                gVar.a(this.lEs.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lEs);
        }
    }

    public String dkT() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dkU() {
        return this.lIc;
    }

    private void uJ(boolean z) {
        this.lIS.kS(z);
        this.lIS.kT(z);
        this.lIS.kU(z);
    }

    private void dkV() {
        this.fle = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    public ap dkW() {
        return this.lIG;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dkd() {
        return this.lEs;
    }

    public void OA(String str) {
        if (this.lEs != null && !StringUtils.isNull(str) && this.lIG != null) {
            this.lIG.vy(true);
            this.lEs.OA(str);
            this.lIn = true;
            this.lIG.doP();
            this.lIG.doY();
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
        this.lIf = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lIf == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
        if (this.lIG != null) {
            this.lIG.onPause();
        }
        if (!this.lEs.dmm()) {
            this.lIS.CF(this.lEs.dme());
        }
        if (this.lEs != null) {
            this.lEs.dmG();
        }
        com.baidu.tbadk.BdToken.c.bha().bhl();
        MessageManager.getInstance().unRegisterListener(this.joX);
        cQM();
        MessageManager.getInstance().unRegisterListener(this.lJz);
        MessageManager.getInstance().unRegisterListener(this.lJA);
        MessageManager.getInstance().unRegisterListener(this.lJB);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dkX() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lEs.getPbData(), this.lEs.dmg(), this.lEs.dmE());
        return (a2 == null || a2.bnx() == null || a2.bnx().getGodUserData() == null || a2.bnx().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lIr) {
            this.lIr = false;
            dlA();
        }
        if (dkX()) {
            this.lIk = System.currentTimeMillis();
        } else {
            this.lIk = -1L;
        }
        if (this.lIG != null && this.lIG.getView() != null) {
            if (!this.ldW) {
                dls();
            } else {
                hideLoadingView(this.lIG.getView());
            }
            this.lIG.onResume();
        }
        if (this.lIf == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lIG != null) {
            noNetworkView = this.lIG.dnS();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
        registerListener(this.joX);
        this.lIM = false;
        dlz();
        registerListener(this.lJz);
        registerListener(this.lJA);
        registerListener(this.lJB);
        if (this.jbo) {
            dlr();
            this.jbo = false;
        }
        dlH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lIG.vn(z);
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
        if (z && this.lIM) {
            this.lIG.dox();
            this.lEs.uX(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lIk > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dW("obj_duration", (System.currentTimeMillis() - this.lIk) + ""));
            this.lIk = 0L;
        }
        if (dkW().dnV() != null) {
            dkW().dnV().onStop();
        }
        if (this.lIG.lPL != null && !this.lIG.lPL.dpZ()) {
            this.lIG.lPL.cYZ();
        }
        if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().getForum() != null && this.lEs.getPbData().diN() != null) {
            com.baidu.tbadk.distribute.a.bAC().b(getPageContext().getPageActivity(), "pb", this.lEs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lEs.getPbData().diN().getId(), 0L));
        }
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lIz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("fid", this.lEs.getPbData().getForumId());
            aqVar.dW("tid", this.lEs.dme());
            aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lIi && this.lIG != null) {
            this.lIi = true;
            a(false, (PostData) null);
        }
        if (this.lEs != null) {
            this.lEs.cancelLoadData();
            this.lEs.destory();
            if (this.lEs.dmJ() != null) {
                this.lEs.dmJ().onDestroy();
            }
        }
        if (this.lIS != null) {
            this.lIS.onDestroy();
        }
        if (this.gca != null) {
            this.gca.cancelLoadData();
        }
        if (this.fle != null) {
            this.fle.dKC();
        }
        if (this.lIG != null) {
            this.lIG.onDestroy();
            if (this.lIG.lPL != null) {
                this.lIG.lPL.cYZ();
            }
        }
        if (this.lIj != null) {
            this.lIj.bDI();
        }
        if (this.lIc != null) {
            this.lIc.cDA();
        }
        super.onDestroy();
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
        if (this.lIG != null) {
            this.lIG.doP();
        }
        MessageManager.getInstance().unRegisterListener(this.lJz);
        MessageManager.getInstance().unRegisterListener(this.lJA);
        MessageManager.getInstance().unRegisterListener(this.lJB);
        MessageManager.getInstance().unRegisterListener(this.lJa);
        MessageManager.getInstance().unRegisterListener(this.lJC);
        MessageManager.getInstance().unRegisterListener(this.jcp);
        MessageManager.getInstance().unRegisterListener(this.jjF);
        MessageManager.getInstance().unRegisterListener(this.lJH);
        MessageManager.getInstance().unRegisterListener(this.lJs);
        this.lIY = null;
        this.lIZ = null;
        com.baidu.tieba.recapp.c.a.dBW().dBZ();
        if (this.lJb != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lJb);
        }
        if (this.lIs != null) {
            this.lIs.cancelLoadData();
        }
        if (this.lIG != null && this.lIG.lPL != null) {
            this.lIG.lPL.dqd();
        }
        if (this.jwD != null) {
            this.jwD.cancelLoadData();
        }
        this.kOl.onDestroy();
        if (this.lEs != null && this.lEs.dmL() != null) {
            this.lEs.dmL().onDestroy();
        }
        if (this.kKi != null) {
            this.kKi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dop;
        ArrayList<PostData> dkB;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bvF() && this.lIG != null && (dop = this.lIG.dop()) != null && (dkB = dop.dkB()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dkB.iterator();
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
                        bVar.iuu = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ePK == 1 && !TextUtils.isEmpty(id)) {
                    next.ePK = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.iuu = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lEs == null || this.lEs.getPbData() == null || this.lEs.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lEs.getPbData().getForum().getFirst_class();
                    str3 = this.lEs.getPbData().getForum().getSecond_class();
                    String id2 = this.lEs.getPbData().getForum().getId();
                    str = this.lEs.dme();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.s.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bvI());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lIG.onChangeSkinType(i);
            if (this.lIS != null && this.lIS.bAP() != null) {
                this.lIS.bAP().onChangeSkinType(i);
            }
            if (this.lIG.dnS() != null) {
                this.lIG.dnS().onChangeSkinType(getPageContext(), i);
            }
            this.kOl.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ao.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cBI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lIG = new ap(this, this.jdo, this.ftt);
        this.jfv = new com.baidu.tieba.f.b(getActivity());
        this.jfv.a(lJS);
        this.jfv.a(this.izu);
        this.lIG.setOnScrollListener(this.mOnScrollListener);
        this.lIG.d(this.lJN);
        this.lIG.setListPullRefreshListener(this.ghb);
        this.lIG.uv(com.baidu.tbadk.core.k.bkB().isShowImages());
        this.lIG.setOnImageClickListener(this.fSh);
        this.lIG.b(this.mOnLongClickListener);
        this.lIG.g(this.iXM);
        this.lIG.a(this.lJL);
        this.lIG.vn(this.mIsLogin);
        if (this.lHZ.getIntent() != null) {
            this.lIG.vz(this.lHZ.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lIG.dnU().setFromForumId(this.lEs.getFromForumId());
        this.lIG.setEditorTools(this.lIS.bAP());
        this.lIS.CE(this.lIG.dnZ());
        this.lIG.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lEs.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEs.getPbData().getForum().getId(), PbFragment.this.lEs.getPbData().getForum().getName(), PbFragment.this.lEs.getPbData().diN().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lIG.vA(this.lEs.dmj());
        this.lIG.FD(this.lEs.dmP());
        return this.lIG.getView();
    }

    public void dkY() {
        if (this.lIG != null && this.lEs != null) {
            if ((this.lEs.getPbData() != null || this.lEs.getPbData().djm() != null) && checkUpIsLogin() && this.lIG.dop() != null && this.lIG.dop().dkG() != null) {
                this.lIG.dop().dkG().Bn(this.lEs.dme());
            }
        }
    }

    public void dkZ() {
        TiebaStatic.log("c12181");
        if (this.lIG != null && this.lEs != null) {
            if ((this.lIG == null || this.lIG.dnY()) && this.lEs.getPbData() != null && this.lEs.getPbData().djm() != null) {
                com.baidu.tieba.pb.data.o djm = this.lEs.getPbData().djm();
                if (checkUpIsLogin()) {
                    if ((!djm.djH() || djm.bpb() != 2) && this.lIG.dop() != null && this.lIG.dop().dkG() != null) {
                        this.lIG.dop().dkG().Bn(this.lEs.dme());
                    }
                    if (System.currentTimeMillis() - this.lIm > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wj(false);
                        this.lIm = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dE(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eOs && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkB().isShowImages()) {
                    return OD(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lEs == null || this.lEs.getPbData() == null) {
                        return true;
                    }
                    if (dkW().dnV() != null) {
                        dkW().dnV().dkM();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lEs.getPbData().getForum());
                    pVar.setThreadData(this.lEs.getPbData().diN());
                    pVar.g(postData);
                    dkW().dnU().d(pVar);
                    dkW().dnU().setPostId(postData.getId());
                    a(view, postData.bnx().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lIS != null) {
                        this.lIG.vt(this.lIS.bBD());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dla() {
        if (this.lIg == null) {
            this.lIg = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lIg.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lEo = PbFragment.this.lEo.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEo);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lEs.dme(), PbFragment.this.lEo, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lEo = PbFragment.this.lEo.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEo);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lEs.dme(), PbFragment.this.lEo, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lEo = PbFragment.this.lEo.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lEo);
                        bVar.dismiss();
                    }
                }
            }).nA(b.a.BOTTOM_TO_TOP).nB(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lJI.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).dsf(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lEs = this.lHZ.dkd();
        if (this.lEs.dmI() != null) {
            this.lEs.dmI().a(this.lHd);
        }
        if (this.lEs.dmJ() != null) {
            this.lEs.dmJ().b(this.lJl);
        }
        if (StringUtils.isNull(this.lEs.dme())) {
            this.lHZ.finish();
        } else if ("from_tieba_kuang".equals(this.lIp) && this.lIp != null) {
            this.lEs.FD(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lIE = com.baidu.tbadk.baseEditMark.a.a(this.lHZ);
        if (this.lIE != null) {
            this.lIE.a(this.lJK);
        }
        this.gca = new ForumManageModel(this.lHZ);
        this.gca.setLoadDataCallBack(this.isj);
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lJw.setUniqueId(getUniqueId());
        this.lJw.registerListener();
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lIG.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lJa;
        userMuteCheckCustomMessage.setTag(this.lJa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14000").dW("tid", this.lEs.lLR).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.FR(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lIa ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dlb() {
        if (this.lEs == null || this.lEs.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lEs.getPbData().diN()) || AntiHelper.a(getPageContext(), this.lEs.getPbData().getAnti());
    }

    public void dlc() {
        if (checkUpIsLogin() && this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().getForum() != null && !dlb()) {
            if (this.lEs.getPbData().djq()) {
                this.lIG.cQn();
                return;
            }
            if (this.jeV == null) {
                this.jeV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jeV.zU(0);
                this.jeV.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qD(boolean z) {
                        if (z) {
                            if (PbFragment.this.lIS != null && PbFragment.this.lIS.bAP() != null) {
                                PbFragment.this.lIS.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lIG.cQn();
                        }
                    }
                });
            }
            this.jeV.H(this.lEs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lEs.dme(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dld() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lEs == null || (pbData = this.lEs.getPbData()) == null) {
            return null;
        }
        return pbData.djb().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            if (fVar.diN().getThreadType() == 0) {
                return 1;
            }
            if (fVar.diN().getThreadType() == 54) {
                return 2;
            }
            if (fVar.diN().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dlb() && dle()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lIu);
                this.lIv = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dkW().dnV() != null && postData != null) {
                String str3 = "";
                if (postData.dLo() != null) {
                    str3 = postData.dLo().toString();
                }
                dkW().dnV().Oy(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnx().getName_show(), str3));
            }
            if (this.lEs.getPbData() != null && this.lEs.getPbData().djq()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lHZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dkW().getListView().smoothScrollBy((PbFragment.this.lIu[1] + PbFragment.this.lIv) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dkW().dnV() != null) {
                            PbFragment.this.lIS.bAP().setVisibility(8);
                            PbFragment.this.dkW().dnV().j(str, str2, PbFragment.this.dkW().dnZ(), (PbFragment.this.lEs == null || PbFragment.this.lEs.getPbData() == null || PbFragment.this.lEs.getPbData().diN() == null || !PbFragment.this.lEs.getPbData().diN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkQ = PbFragment.this.dkW().dnV().dkQ();
                            if (dkQ != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                dkQ.a(PbFragment.this.lEs.getPbData().getAnti());
                                dkQ.setThreadData(PbFragment.this.lEs.getPbData().diN());
                            }
                            if (PbFragment.this.kOl.dpt() == null && PbFragment.this.dkW().dnV().dkQ().bCc() != null) {
                                PbFragment.this.dkW().dnV().dkQ().bCc().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kOl != null && PbFragment.this.kOl.dps() != null) {
                                            if (!PbFragment.this.kOl.dps().dUc()) {
                                                PbFragment.this.kOl.vC(false);
                                            }
                                            PbFragment.this.kOl.dps().yY(false);
                                        }
                                    }
                                });
                                PbFragment.this.kOl.g(PbFragment.this.dkW().dnV().dkQ().bCc().getInputView());
                                PbFragment.this.dkW().dnV().dkQ().a(PbFragment.this.lIX);
                            }
                        }
                        PbFragment.this.dkW().doY();
                    }
                }, 0L);
                return;
            }
            if (this.lIU == null) {
                this.lIU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lIU.zU(1);
                this.lIU.a(new AnonymousClass39(str, str2));
            }
            if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().getForum() != null) {
                this.lIU.H(this.lEs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lEs.dme(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lKc;
        final /* synthetic */ String lKd;

        AnonymousClass39(String str, String str2) {
            this.lKc = str;
            this.lKd = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qD(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        }
                        PbFragment.this.dkW().getListView().smoothScrollBy((PbFragment.this.lIu[1] + PbFragment.this.lIv) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dkW().dnV() != null) {
                            PbFragment.this.lIS.bAP().setVisibility(8);
                            PbFragment.this.dkW().dnV().j(AnonymousClass39.this.lKc, AnonymousClass39.this.lKd, PbFragment.this.dkW().dnZ(), (PbFragment.this.lEs == null || PbFragment.this.lEs.getPbData() == null || PbFragment.this.lEs.getPbData().diN() == null || !PbFragment.this.lEs.getPbData().diN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkQ = PbFragment.this.dkW().dnV().dkQ();
                            if (dkQ != null && PbFragment.this.lEs != null && PbFragment.this.lEs.getPbData() != null) {
                                dkQ.a(PbFragment.this.lEs.getPbData().getAnti());
                                dkQ.setThreadData(PbFragment.this.lEs.getPbData().diN());
                            }
                            if (PbFragment.this.kOl.dpt() == null && PbFragment.this.dkW().dnV().dkQ().bCc() != null) {
                                PbFragment.this.dkW().dnV().dkQ().bCc().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kOl != null && PbFragment.this.kOl.dps() != null) {
                                            if (!PbFragment.this.kOl.dps().dUc()) {
                                                PbFragment.this.kOl.vC(false);
                                            }
                                            PbFragment.this.kOl.dps().yY(false);
                                        }
                                    }
                                });
                                PbFragment.this.kOl.g(PbFragment.this.dkW().dnV().dkQ().bCc().getInputView());
                                PbFragment.this.dkW().dnV().dkQ().a(PbFragment.this.lIX);
                            }
                        }
                        PbFragment.this.dkW().doY();
                    }
                }, 0L);
            }
        }
    }

    public boolean dle() {
        if ((this.lEs.getPbData() != null && this.lEs.getPbData().djq()) || this.kKi == null || this.lEs.getPbData() == null || this.lEs.getPbData().getAnti() == null) {
            return true;
        }
        return this.kKi.os(this.lEs.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Fp(int i) {
        if (this.kKi == null || this.lEs.getPbData() == null || this.lEs.getPbData().getAnti() == null) {
            return true;
        }
        return this.kKi.aN(this.lEs.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lEs != null && this.lEs.getPbData() != null && postData.dLm() != 1) {
            String dme = this.lEs.dme();
            String id = postData.getId();
            int i = 0;
            if (this.lEs.getPbData() != null) {
                i = this.lEs.getPbData().djc();
            }
            PbActivity.a OE = OE(id);
            if (OE != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dme, id, "pb", true, null, false, null, i, postData.dqX(), this.lEs.getPbData().getAnti(), false, postData.bnx() != null ? postData.bnx().getIconInfo() : null).addBigImageData(OE.lEG, OE.eHG, OE.eHE, OE.index);
                addBigImageData.setKeyPageStartFrom(this.lEs.dmP());
                addBigImageData.setFromFrsForumId(this.lEs.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lEs.getForumId());
                addBigImageData.setBjhData(this.lEs.dmo());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dlf() {
        if (this.lEs.getPbData() == null || this.lEs.getPbData().diN() == null) {
            return -1;
        }
        return this.lEs.getPbData().diN().bok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dkd() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dkd().OJ(postWriteCallBackData.getPostId());
            this.lJf = this.lIG.dob();
            this.lEs.dc(this.lJf, this.lIG.doc());
        }
        this.lIG.doP();
        this.kOl.dpq();
        if (this.lIS != null) {
            this.lIG.vt(this.lIS.bBD());
        }
        this.lIG.dnT();
        this.lIG.vv(true);
        this.lEs.dmA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uK(boolean z) {
        if (this.lEs != null && this.lEs.lFA != null && this.lEs.lFA.diN() != null) {
            bz diN = this.lEs.lFA.diN();
            diN.mRecomAbTag = this.lEs.dna();
            diN.mRecomWeight = this.lEs.dmY();
            diN.mRecomSource = this.lEs.dmZ();
            diN.mRecomExtra = this.lEs.dnb();
            if (diN.getFid() == 0) {
                diN.setFid(com.baidu.adp.lib.f.b.toLong(this.lEs.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), diN, "c13563");
            TbPageTag fu = com.baidu.tbadk.pageInfo.c.fu(getContext());
            if (fu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fu.locatePage)) {
                a2.dW("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dW("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fu.locatePage)) {
                a2.dW("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.an("reply_type", 1);
                if (z) {
                    a2.an("obj_type", 2);
                } else {
                    a2.an("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fr = com.baidu.tbadk.pageExtra.d.fr(getContext());
                if (fr != null) {
                    a2.dW("obj_cur_page", fr.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                    a2.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlg() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Rq(this.lEs.getForumId()) && this.lEs.getPbData() != null && this.lEs.getPbData().getForum() != null) {
            if (this.lEs.getPbData().getForum().isLike() == 1) {
                this.lEs.dmL().gj(this.lEs.getForumId(), this.lEs.dme());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uL(boolean z) {
        if (this.lEs == null || this.lEs.getPbData() == null) {
            return false;
        }
        return ((this.lEs.getPbData().djc() != 0) || this.lEs.getPbData().diN() == null || this.lEs.getPbData().diN().bnx() == null || TextUtils.equals(this.lEs.getPbData().diN().bnx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uM(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lEs == null || this.lEs.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lEs.getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            bz diN = pbData.diN();
            if (diN != null) {
                if (diN.bme() || diN.bmf()) {
                    return false;
                }
                if (diN.bpv() || diN.bpw()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.djc() != 0) {
                    return pbData.djc() != 3;
                }
                List<bv> djk = pbData.djk();
                if (com.baidu.tbadk.core.util.x.getCount(djk) > 0) {
                    for (bv bvVar : djk) {
                        if (bvVar != null && (acVar = bvVar.eNA) != null && acVar.eLk && !acVar.eLl && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uN(boolean z) {
        if (z || this.lEs == null || this.lEs.getPbData() == null) {
            return false;
        }
        return ((this.lEs.getPbData().getForum() != null && this.lEs.getPbData().getForum().isBlockBawuDelete) || this.lEs.getPbData().djc() == 0 || this.lEs.getPbData().djc() == 3) ? false : true;
    }

    public void dlh() {
        com.baidu.tieba.pb.data.f pbData;
        bz diN;
        boolean z = true;
        if (this.lEs != null && this.lEs.getPbData() != null && (diN = (pbData = this.lEs.getPbData()).diN()) != null && diN.bnx() != null) {
            this.lIG.dnT();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), diN.bnx().getUserId());
            ad adVar = new ad();
            int djc = this.lEs.getPbData().djc();
            if (djc == 1 || djc == 3) {
                adVar.lNZ = true;
                adVar.lOf = diN.bns() == 1;
            } else {
                adVar.lNZ = false;
            }
            if (Fq(djc)) {
                adVar.lOa = true;
                adVar.lOe = diN.bnt() == 1;
            } else {
                adVar.lOa = false;
            }
            if (djc == 1002 && !equals) {
                adVar.lOg = true;
            }
            adVar.lNX = uM(equals);
            adVar.lOb = dli();
            adVar.lNY = uN(equals);
            adVar.FD = this.lEs.dmg();
            adVar.lNU = true;
            adVar.lNT = uL(equals);
            adVar.lNS = equals && this.lIG.doE();
            adVar.lOd = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lOc = true;
            adVar.isHostOnly = this.lEs.getHostMode();
            adVar.lNW = true;
            if (diN.bnO() == null) {
                adVar.lNV = true;
            } else {
                adVar.lNV = false;
            }
            if (pbData.djq()) {
                adVar.lNU = false;
                adVar.lNW = false;
                adVar.lNV = false;
                adVar.lNZ = false;
                adVar.lOa = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.djq()) {
                z = false;
            }
            adVar.lOh = z;
            this.lIG.lPL.a(adVar);
        }
    }

    private boolean dli() {
        if (this.lEs != null && this.lEs.dmg()) {
            return this.lEs.getPageData() == null || this.lEs.getPageData().bmn() != 0;
        }
        return false;
    }

    public boolean Fq(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lEs.getPbData().getUserData() == null || (forumToolAuth = this.lEs.getPbData().getUserData().getForumToolAuth()) == null) {
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
    public void dG(View view) {
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
    public PbModel.a dlj() {
        return this.lJI;
    }

    public int dlk() {
        if (dkW() == null || dkW().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dkW().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) nVar).Wq == com.baidu.tieba.pb.data.n.lCD) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dll() {
        if (dkW() == null || dkW().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dkW().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nmN) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dlr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlm() {
        if (this.lEs != null && this.lEs.lFA != null && this.lEs.lFA.diN() != null) {
            bz diN = this.lEs.lFA.diN();
            diN.mRecomAbTag = this.lEs.dna();
            diN.mRecomWeight = this.lEs.dmY();
            diN.mRecomSource = this.lEs.dmZ();
            diN.mRecomExtra = this.lEs.dnb();
            diN.eRS = this.lEs.dmm();
            if (diN.getFid() == 0) {
                diN.setFid(com.baidu.adp.lib.f.b.toLong(this.lEs.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), diN, "c13562");
            TbPageTag fu = com.baidu.tbadk.pageInfo.c.fu(getContext());
            if (fu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fu.locatePage)) {
                a2.dW("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dW("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fu.locatePage)) {
                a2.dW("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.Ac(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Ad(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jD(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dW("obj_id", metaData.getUserId()).an("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dW("obj_id", metaData.getUserId()).an("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eYq.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lEs.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bqe();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lIG.doy();
        this.lEs.uZ(z);
        if (this.lIE != null) {
            this.lIE.iY(z);
            if (markData != null) {
                this.lIE.a(markData);
            }
        }
        if (this.lEs.bjE()) {
            dlp();
        } else {
            this.lIG.s(this.lEs.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ff(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB(String str) {
        if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().djq()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lEs.dme(), str);
            bz diN = this.lEs.getPbData().diN();
            if (diN.bme()) {
                format = format + "&channelid=33833";
            } else if (diN.bpu()) {
                format = format + "&channelid=33842";
            } else if (diN.bmf()) {
                format = format + "&channelid=33840";
            }
            OC(format);
            return;
        }
        this.lID.Pc(str);
    }

    private void OC(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lEs.dmm()) {
                    antiData.setBlock_forum_name(this.lEs.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lEs.getPbData().getForum().getId());
                    antiData.setUser_name(this.lEs.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lEs.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dkW() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bQ(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            CL(str);
        } else {
            this.lIG.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.npN) ? bVar.npN : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Ad(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jD(true);
                aVar.b(getPageContext());
                aVar.bqe();
            } else {
                this.lIG.a(0, bVar.mSuccess, bVar.npN, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iHw == 1) {
                    ArrayList<PostData> diP = this.lEs.getPbData().diP();
                    int size = diP.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(diP.get(i).getId())) {
                            i++;
                        } else {
                            diP.remove(i);
                            break;
                        }
                    }
                    this.lEs.getPbData().diN().nh(this.lEs.getPbData().diN().bno() - 1);
                    this.lIG.s(this.lEs.getPbData());
                } else if (bVar.iHw == 0) {
                    dln();
                } else if (bVar.iHw == 2) {
                    ArrayList<PostData> diP2 = this.lEs.getPbData().diP();
                    int size2 = diP2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= diP2.get(i2).dLj().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(diP2.get(i2).dLj().get(i3).getId())) {
                                i3++;
                            } else {
                                diP2.get(i2).dLj().remove(i3);
                                diP2.get(i2).dLl();
                                z2 = true;
                                break;
                            }
                        }
                        diP2.get(i2).Sg(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lIG.s(this.lEs.getPbData());
                    }
                    a(bVar, this.lIG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lIG.a(this.gca.getLoadDataMode(), gVar.mSuccess, gVar.npN, false);
            if (gVar.mSuccess) {
                this.lIH = true;
                if (i == 2 || i == 3) {
                    this.lII = true;
                    this.lIJ = false;
                } else if (i == 4 || i == 5) {
                    this.lII = false;
                    this.lIJ = true;
                }
                if (i == 2) {
                    this.lEs.getPbData().diN().nk(1);
                    this.lEs.setIsGood(1);
                } else if (i == 3) {
                    this.lEs.getPbData().diN().nk(0);
                    this.lEs.setIsGood(0);
                } else if (i == 4) {
                    this.lEs.getPbData().diN().nj(1);
                    this.lEs.Fv(1);
                } else if (i == 5) {
                    this.lEs.getPbData().diN().nj(0);
                    this.lEs.Fv(0);
                }
                this.lIG.c(this.lEs.getPbData(), this.lEs.dmg());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.npN)) {
                string = gVar.npN;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dln() {
        if (this.lEs.dmh() || this.lEs.dmj()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lEs.dme());
            PbActivity pbActivity = this.lHZ;
            PbActivity pbActivity2 = this.lHZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lEs.dme()));
        if (dlq()) {
            this.lHZ.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkr() {
        this.lHZ.dkr();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData diZ;
        boolean z = false;
        if (this.lIG != null) {
            this.lIG.doP();
        }
        if (this.lEs != null && this.lEs.getPbData() != null && !this.lEs.getPbData().djq()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lEs.getPbData().diN().getId();
            if (this.lEs.isShareThread() && this.lEs.getPbData().diN().eQQ != null) {
                historyMessage.threadName = this.lEs.getPbData().diN().eQQ.showText;
            } else {
                historyMessage.threadName = this.lEs.getPbData().diN().getTitle();
            }
            if (this.lEs.isShareThread() && !djV()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lEs.getPbData().getForum().getName();
            }
            ArrayList<PostData> diP = this.lEs.getPbData().diP();
            int doA = this.lIG != null ? this.lIG.doA() : 0;
            if (diP != null && doA >= 0 && doA < diP.size()) {
                historyMessage.postID = diP.get(doA).getId();
            }
            historyMessage.isHostOnly = this.lEs.getHostMode();
            historyMessage.isSquence = this.lEs.dmg();
            historyMessage.isShareThread = this.lEs.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lIS != null) {
            this.lIS.onDestroy();
        }
        if (this.lIe && dkW() != null) {
            dkW().dpi();
        }
        if (this.lEs != null && (this.lEs.dmh() || this.lEs.dmj())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lEs.dme());
            if (this.lIH) {
                if (this.lIJ) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lEs.ctW());
                }
                if (this.lII) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lEs.getIsGood());
                }
            }
            if (this.lEs.getPbData() != null && System.currentTimeMillis() - this.lIh >= 40000 && (diZ = this.lEs.getPbData().diZ()) != null && !com.baidu.tbadk.core.util.x.isEmpty(diZ.getDataList())) {
                intent.putExtra("guess_like_data", diZ);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lJg);
            }
            PbActivity pbActivity = this.lHZ;
            PbActivity pbActivity2 = this.lHZ;
            pbActivity.setResult(-1, intent);
        }
        if (dlq()) {
            if (this.lEs != null && this.lIG != null && this.lIG.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lEs.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.diV() && !this.lIn && pbData.lBn == null) {
                        aj dnE = aj.dnE();
                        com.baidu.tieba.pb.data.f dmp = this.lEs.dmp();
                        Parcelable onSaveInstanceState = this.lIG.getListView().onSaveInstanceState();
                        boolean dmg = this.lEs.dmg();
                        boolean hostMode = this.lEs.getHostMode();
                        if (this.lIG.dog() != null && this.lIG.dog().getVisibility() == 0) {
                            z = true;
                        }
                        dnE.a(dmp, onSaveInstanceState, dmg, hostMode, z);
                        if (this.lJf >= 0 || this.lEs.dmR() != null) {
                            aj.dnE().q(this.lEs.dmR());
                            aj.dnE().p(this.lEs.dmS());
                            aj.dnE().FF(this.lEs.dmT());
                        }
                    }
                }
            } else {
                aj.dnE().reset();
            }
            dkr();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lIG == null || !this.lIG.FL(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fr(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lHZ;
        if (i == 0) {
            this.lIG.dnT();
            this.lIG.dnV().dkM();
            this.lIG.vv(false);
        }
        this.lIG.dnX();
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
                        this.lIS.resetData();
                        this.lIS.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lIS.c(writeData);
                        com.baidu.tbadk.editortools.m qP = this.lIS.bAP().qP(6);
                        if (qP != null && qP.fyZ != null) {
                            qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lHZ;
                        if (i == -1) {
                            this.lIS.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lIG.dnV() != null && this.lIG.dnV().dkQ() != null) {
                            com.baidu.tbadk.editortools.pb.h dkQ = this.lIG.dnV().dkQ();
                            dkQ.setThreadData(this.lEs.getPbData().diN());
                            dkQ.c(writeData);
                            dkQ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qP2 = dkQ.bAP().qP(6);
                            if (qP2 != null && qP2.fyZ != null) {
                                qP2.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lHZ;
                            if (i == -1) {
                                dkQ.bBU();
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
        this.lIS.onActivityResult(i, i2, intent);
        if (this.lIs != null) {
            this.lIs.onActivityResult(i, i2, intent);
        }
        if (dkW().dnV() != null) {
            dkW().dnV().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dlo();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.dnE().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lEs != null) {
                                PbFragment.this.lEs.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dAJ().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lEs != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    T(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        aqVar.dW("tid", intent.getStringExtra("tid"));
                        aqVar.dW("post_id", intent.getStringExtra("pid"));
                        aqVar.an("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dAJ().E(getPageContext());
                        dlg();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jwD != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jwD.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void byn() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
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
                    this.lIG.uA(false);
                    if (this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null && this.lEs.getPbData().diN().bnR() != null) {
                        this.lEs.getPbData().diN().bnR().setStatus(2);
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
                        this.lIV = emotionImageData;
                        if (Fp(com.baidu.tbadk.core.util.al.eYn)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lIt != null) {
                        this.lIG.dO(this.lIt);
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
            if (this.lIs == null) {
                this.lIs = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lHZ);
                this.lIs.b(this.fBz);
                this.lIs.c(this.fBH);
            }
            this.lIs.a(emotionImageData, dkd(), dkd().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlo() {
        MarkData FC;
        if (this.lIE != null) {
            if (this.lEs.getPbData() != null && this.lEs.getPbData().djq()) {
                FC = this.lEs.FC(0);
            } else {
                FC = this.lEs.FC(this.lIG.doB());
            }
            if (FC != null) {
                if (!FC.isApp() || (FC = this.lEs.FC(this.lIG.doB() + 1)) != null) {
                    this.lIG.dow();
                    this.lIE.a(FC);
                    if (!this.lIE.bjE()) {
                        this.lIE.bjG();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lIE.bjF();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlp() {
        com.baidu.tieba.pb.data.f pbData = this.lEs.getPbData();
        this.lEs.uZ(true);
        if (this.lIE != null) {
            pbData.Os(this.lIE.bjD());
        }
        this.lIG.s(pbData);
    }

    private boolean dlq() {
        if (this.lEs == null) {
            return true;
        }
        if (this.lEs.getPbData() == null || !this.lEs.getPbData().djq()) {
            if (this.lEs.bjE()) {
                final MarkData dmz = this.lEs.dmz();
                if (dmz == null || !this.lEs.getIsFromMark()) {
                    return true;
                }
                final MarkData FC = this.lEs.FC(this.lIG.doA());
                if (FC == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dmz);
                    this.lHZ.setResult(-1, intent);
                    return true;
                } else if (FC.getPostId() == null || FC.getPostId().equals(dmz.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dmz);
                    this.lHZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Ad(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lIE != null) {
                                if (PbFragment.this.lIE.bjE()) {
                                    PbFragment.this.lIE.bjF();
                                    PbFragment.this.lIE.iY(false);
                                }
                                PbFragment.this.lIE.a(FC);
                                PbFragment.this.lIE.iY(true);
                                PbFragment.this.lIE.bjG();
                            }
                            dmz.setPostId(FC.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dmz);
                            PbFragment.this.lHZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dkr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dmz);
                            PbFragment.this.lHZ.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dkr();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lIG != null && PbFragment.this.lIG.getView() != null) {
                                PbFragment.this.lIG.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dmz);
                                PbFragment.this.lHZ.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dkr();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bqe();
                    return false;
                }
            } else if (this.lEs.getPbData() == null || this.lEs.getPbData().diP() == null || this.lEs.getPbData().diP().size() <= 0 || !this.lEs.getIsFromMark()) {
                return true;
            } else {
                this.lHZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lIG == null) {
            return null;
        }
        return this.lIG.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bHN() {
        if (this.lIG == null) {
            return 0;
        }
        return this.lIG.doN();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bHO() {
        if (this.fRW == null) {
            this.fRW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIa */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkB().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.ao.getDrawable(R.color.common_color_10220));
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
                /* renamed from: c */
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
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
                /* renamed from: e */
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
        return this.fRW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bHP() {
        if (this.fVl == null) {
            this.fVl = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fVl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bHQ() {
        if (this.fRX == null) {
            this.fRX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cvN */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkB().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.ao.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
                    gifView.bCv();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fRX;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bHR() {
        if (this.fVm == null) {
            this.fVm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlO */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dK */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cbz();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dL */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fVm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bHT() {
        this.fVo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dlP */
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
        return this.fVo;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bus() {
        if (this.fjw == null) {
            this.fjw = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fjw;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.OT(str) && this.lEs != null && this.lEs.dme() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").an("obj_param1", 1).dW("post_id", this.lEs.dme()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fxW = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.dpv().f(getPageContext(), str);
        }
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dpv().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lIl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lIG != null && this.lIG.dpd() != null && rect.top <= this.lIG.dpd().getHeight()) {
            rect.top += this.lIG.dpd().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lEs.getPbData();
            TbRichText bG = bG(str, i);
            if (bG != null && (tbRichTextData = bG.bHf().get(this.lJO)) != null) {
                aVar.postId = String.valueOf(bG.getPostId());
                aVar.lEG = new ArrayList<>();
                aVar.eHG = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHl().bHw()) {
                    aVar.lEH = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lEG.add(c2);
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
                    imageUrlData.postId = bG.getPostId();
                    imageUrlData.mIsReserver = this.lEs.dmx();
                    imageUrlData.mIsSeeHost = this.lEs.getHostMode();
                    aVar.eHG.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.diN() != null) {
                            aVar.threadId = pbData.diN().getId();
                        }
                        aVar.eHE = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lEH = true;
                int size = pbData.diP().size();
                this.lJP = false;
                aVar.index = -1;
                int a2 = pbData.diW() != null ? a(pbData.diW().dLo(), bG, i, i, aVar.lEG, aVar.eHG) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.diP().get(i2);
                    if (postData.getId() == null || pbData.diW() == null || pbData.diW().getId() == null || !postData.getId().equals(pbData.diW().getId())) {
                        a2 = a(postData.dLo(), bG, a2, i, aVar.lEG, aVar.eHG);
                    }
                }
                if (aVar.lEG.size() > 0) {
                    aVar.lastId = aVar.lEG.get(aVar.lEG.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.diN() != null) {
                        aVar.threadId = pbData.diN().getId();
                    }
                    aVar.eHE = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return null;
        }
        return tbRichTextData.bHl().bHB();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return 0L;
        }
        return tbRichTextData.bHl().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return false;
        }
        return tbRichTextData.bHl().bHC();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHl() == null) {
            return false;
        }
        return tbRichTextData.bHl().bHD();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bHl;
        String str;
        if (tbRichText == tbRichText2) {
            this.lJP = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bHf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bHf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bHl().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bHl().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bHl().bHw()) {
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
                            if (tbRichTextData != null && (bHl = tbRichTextData.bHl()) != null) {
                                String bHy = bHl.bHy();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bHl.bHz();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bHy;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lEs.dme(), -1L);
                                imageUrlData.mIsReserver = this.lEs.dmx();
                                imageUrlData.mIsSeeHost = this.lEs.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lJP) {
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
        PostData diW;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lEs.bnF())) {
                z = true;
            }
            MarkData o = this.lEs.o(postData);
            if (this.lEs.getPbData() != null && this.lEs.getPbData().djq() && (diW = diW()) != null) {
                o = this.lEs.o(diW);
            }
            if (o != null) {
                this.lIG.dow();
                if (this.lIE != null) {
                    this.lIE.a(o);
                    if (!z) {
                        this.lIE.bjG();
                    } else {
                        this.lIE.bjF();
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
    public boolean dH(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (!isAdded()) {
            return true;
        }
        if (this.lIG != null) {
            if (this.lIG.dlW()) {
                return true;
            }
            this.lIG.dpl();
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dI(view)) {
                if (view instanceof TbImageView) {
                    this.lJc = ((TbImageView) view).getBdImage();
                    this.lJd = ((TbImageView) view).getUrl();
                    if (this.lJc == null || TextUtils.isEmpty(this.lJd)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lJe = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lJc = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lJd = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lJe = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lJc = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lJd = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lJe = null;
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
                    this.lIG.a(this.lJR, this.lJc.isGif());
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
        this.khK = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.khK == null) {
            return true;
        }
        if (this.khK.dLm() == 1 && dI(view)) {
            this.lIG.a(this.lJR, this.lJc.isGif());
            return true;
        } else if (this.lIE == null) {
            return true;
        } else {
            if (!this.lIE.bjE() || this.khK.getId() == null || !this.khK.getId().equals(this.lEs.bnF())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dkd().getPbData() != null && dkd().getPbData().djq();
            if (this.khK.dLm() == 1) {
                if (!z3) {
                    this.lIG.a(this.lJQ, z, false);
                }
                return true;
            }
            if (this.lIL == null) {
                this.lIL = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lIL.a(this.lJD);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dI(view) && !z3;
                boolean z5 = (!dI(view) || this.lJc == null || this.lJc.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lIL));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lIL));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lIL);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.khK);
                    gVar2.eSW.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lIL);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lIL);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.khK);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eSW.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lIB) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lIL);
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
                        gVar3.eSW.setTag(sparseArray5);
                        arrayList.add(gVar3);
                    } else {
                        if ((uL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lIL);
                            gVar4.eSW.setTag(str);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lIL);
                            gVar6.eSW.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lIL);
                        gVar5.eSW.setTag(sparseArray6);
                    } else if (z10) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        if (this.lEs.getPbData().djc() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lIL);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lIL);
                        }
                        gVar6.eSW.setTag(sparseArray7);
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                }
                if (com.baidu.tbadk.a.d.bja()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.khK.bpr(), sparseArray2, this.lIL), this.lIa));
                    this.lIL.a(com.baidu.tieba.pb.pb.main.d.a.t(this.khK));
                } else {
                    list = arrayList;
                }
                this.lIL.k(list, true);
                this.lIK = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lIL);
                this.lIK.Pd();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dW("tid", this.lEs.lLR).dW("fid", this.lEs.getForumId()).dW("uid", this.lEs.getPbData().diN().bnx().getUserId()).dW("post_id", this.lEs.bBr()).an("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean dI(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bG(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lEs == null || this.lEs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lEs.getPbData();
        if (pbData.diW() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.diW());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> diP = pbData.diP();
            c(pbData, diP);
            return c(diP, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c fr;
        int i = 1;
        if (agreeData != null) {
            if (this.fcq == null) {
                this.fcq = new com.baidu.tbadk.core.message.a();
            }
            if (this.fbZ == null) {
                this.fbZ = new com.baidu.tieba.tbadkCore.data.e();
                this.fbZ.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 5;
            dVar.eJU = 8;
            dVar.eJT = 2;
            if (dkd() != null) {
                dVar.eJS = dkd().dmP();
            }
            dVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eJV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eJV = 1;
                        i = 0;
                    }
                }
                fr = com.baidu.tbadk.pageExtra.d.fr(getContext());
                if (fr != null) {
                    agreeData.objSource = fr.getCurrentPageKey();
                }
                this.fcq.a(agreeData, i, getUniqueId(), false);
                this.fcq.a(agreeData, this.fbZ);
                if (this.lEs == null && this.lEs.getPbData() != null) {
                    this.fcq.a(dlL(), dVar, agreeData, this.lEs.getPbData().diN());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eJV = 1;
            }
            i = 0;
            fr = com.baidu.tbadk.pageExtra.d.fr(getContext());
            if (fr != null) {
            }
            this.fcq.a(agreeData, i, getUniqueId(), false);
            this.fcq.a(agreeData, this.fbZ);
            if (this.lEs == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.djb() != null && fVar.djb().lCS != null && (list = fVar.djb().lCS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bHf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dLo = arrayList.get(i2).dLo();
            if (dLo != null && (bHf = dLo.bHf()) != null) {
                int size = bHf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bHf.get(i4) != null && bHf.get(i4).getType() == 8) {
                        i3++;
                        if (bHf.get(i4).bHl().bHy().equals(str) || bHf.get(i4).bHl().bHz().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bHf.get(i4).bHl().getWidth() * equipmentDensity;
                            int height = bHf.get(i4).bHl().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lJO = i4;
                            return dLo;
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
            this.lEo = str;
            if (this.lIg == null) {
                dla();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lIg.getItemView(1).setVisibility(8);
            } else {
                this.lIg.getItemView(1).setVisibility(0);
            }
            this.lIg.bqg();
            this.lIl = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jaA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlr() {
        hideNetRefreshView(this.lIG.getView());
        dls();
        if (this.lEs.dms()) {
            this.lIG.dow();
        }
        this.lIG.doH();
    }

    private void dls() {
        showLoadingView(this.lIG.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lIG.dpd().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBI() {
        if (this.jaA != null) {
            this.jaA.stopPlay();
        }
        if (this.lHZ != null) {
            this.lHZ.cBI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dlf(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bHS() {
        if (this.fVn == null) {
            this.fVn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlQ */
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
        return this.fVn;
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

    public void cBJ() {
        if (this.lHZ != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lHZ.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lHZ.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cAh() {
        if (this.lEs == null || this.lEs.getPbData() == null) {
            return null;
        }
        return this.lEs.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.lRa)).intValue();
            if (intValue == ap.lRb) {
                if (!this.gca.dMh()) {
                    this.lIG.dor();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gca.Su(com.baidu.tbadk.core.util.at.S(jSONArray));
                    }
                    this.gca.a(this.lEs.getPbData().getForum().getId(), this.lEs.getPbData().getForum().getName(), this.lEs.getPbData().diN().getId(), str, intValue3, intValue2, booleanValue, this.lEs.getPbData().diN().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.lRc || intValue == ap.lRe) {
                if (this.lEs.dmI() != null) {
                    this.lEs.dmI().Fk(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.lRc) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lJa);
        userMuteAddAndDelCustomMessage.setTag(this.lJa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean OD(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0840a
    public void uO(boolean z) {
        this.lIM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dlt() {
        ArrayList<PostData> diP;
        int count;
        if (this.lEs == null || this.lEs.getPbData() == null || this.lEs.getPbData().diP() == null || (count = com.baidu.tbadk.core.util.x.getCount((diP = this.lEs.getPbData().diP()))) == 0) {
            return "";
        }
        if (this.lEs.dmx()) {
            Iterator<PostData> it = diP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dLm() == 1) {
                    return next.getId();
                }
            }
        }
        int doA = this.lIG.doA();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(diP, doA);
        if (postData == null || postData.bnx() == null) {
            return "";
        }
        if (this.lEs.OH(postData.bnx().getUserId())) {
            return postData.getId();
        }
        for (int i = doA - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(diP, i);
            if (postData2 == null || postData2.bnx() == null || postData2.bnx().getUserId() == null) {
                break;
            } else if (this.lEs.OH(postData2.bnx().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = doA + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(diP, i2);
            if (postData3 == null || postData3.bnx() == null || postData3.bnx().getUserId() == null) {
                return "";
            }
            if (this.lEs.OH(postData3.bnx().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        this.lIl = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a OE(String str) {
        String str2;
        if (this.lEs.getPbData() == null || this.lEs.getPbData().diP() == null || this.lEs.getPbData().diP().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lEs.getPbData().diP().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lEs.getPbData().diP().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lEs.getPbData().diP().get(i);
        if (postData.dLo() == null || postData.dLo().bHf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dLo().bHf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bHl() != null) {
                    str2 = next.bHl().bHy();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dlu() {
        return (!this.lIb && this.lJT == -1 && this.lJU == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lJW = sVar;
            this.lIb = true;
            this.lIG.doh();
            this.lIG.OR(this.lJV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlv() {
        if (this.lJW != null) {
            if (this.lJT == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJW.getCartoonId(), this.lJT, 0)));
                this.lHZ.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlw() {
        if (this.lJW != null) {
            if (this.lJU == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lJW.getCartoonId(), this.lJU, 0)));
                this.lHZ.finish();
            }
        }
    }

    public int dlx() {
        return this.lJT;
    }

    public int dly() {
        return this.lJU;
    }

    private void cQM() {
        if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null && this.lEs.getPbData().diN().bmc()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dlz() {
        if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null && this.lEs.getPbData().diN().bmc()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dlA() {
        if (this.isPaused) {
            this.lIr = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null && this.lEs.getPbData().diN().bnd() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lEs.getPbData().diN().bnd().getThreadId(), this.lEs.getPbData().diN().bnd().getTaskId(), this.lEs.getPbData().diN().bnd().getForumId(), this.lEs.getPbData().diN().bnd().getForumName(), this.lEs.getPbData().diN().bns(), this.lEs.getPbData().diN().bnt())));
            this.lId = true;
            this.lHZ.finish();
        }
    }

    public String dlB() {
        return this.lIp;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dlC() {
        return this.lIC;
    }

    public void uP(boolean z) {
        this.lIq = z;
    }

    public boolean blc() {
        if (this.lEs != null) {
            return this.lEs.dmh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Ad(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lIY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lIY.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lIY).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lIY != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIY.getPageActivity());
            aVar.Ad(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lIY).bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lIG.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIY.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Ad(this.lIY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ad(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lIG.showLoadingDialog();
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
        aVar.b(this.lIY).bqe();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.OT(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jHr) {
            this.jHr = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lIG != null) {
                this.lIG.onConfigurationChanged(configuration);
            }
            if (this.lIK != null) {
                this.lIK.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dlE() {
        if (this.lEs != null) {
            return this.lEs.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lEs.getPbData().djb().lCS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dLj().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dLj().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dLj().remove(i2);
                    list.get(i).dLl();
                    z = true;
                    break;
                }
            }
            list.get(i).Sg(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lEs.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.djF().getId();
        List<PostData> list = this.lEs.getPbData().djb().lCS;
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
                ArrayList<PostData> djN = pVar.djN();
                postData.Jj(pVar.getTotalCount());
                if (postData.dLj() != null) {
                    postData.dLj().clear();
                    postData.dLj().addAll(djN);
                }
            }
        }
        if (!this.lEs.getIsFromMark()) {
            this.lIG.s(this.lEs.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a djU() {
        return this.lHZ.djU();
    }

    public boolean djV() {
        if (this.lEs == null) {
            return false;
        }
        return this.lEs.djV();
    }

    public void uQ(boolean z) {
        this.lIo = z;
    }

    public boolean dlF() {
        return this.lIo;
    }

    public void dlG() {
        if (this.lIG != null) {
            this.lIG.dnT();
            cBJ();
        }
    }

    public PostData diW() {
        return this.lIG.b(this.lEs.lFA, this.lEs.dmg());
    }

    public void onBackPressed() {
        if (this.lJh != null && !this.lJh.isEmpty()) {
            int size = this.lJh.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lJh.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lJh == null) {
                this.lJh = new ArrayList();
            }
            if (!this.lJh.contains(aVar)) {
                this.lJh.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lJh == null) {
                this.lJh = new ArrayList();
            }
            if (!this.lJh.contains(aVar)) {
                this.lJh.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lJh != null) {
            this.lJh.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.af.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlH() {
        if (this.lEs != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lEs.dme())) {
            com.baidu.tbadk.BdToken.c.bha().p(com.baidu.tbadk.BdToken.b.ezZ, com.baidu.adp.lib.f.b.toLong(this.lEs.dme(), 0L));
        }
    }

    public bi dlI() {
        return this.lIy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OF(String str) {
        if (this.lEs != null && this.lEs.getPbData() != null && this.lEs.getPbData().diN() != null && this.lEs.getPbData().diN().bmg()) {
            bz diN = this.lEs.getPbData().diN();
            int i = 0;
            if (diN.bme()) {
                i = 1;
            } else if (diN.bmf()) {
                i = 2;
            } else if (diN.bpv()) {
                i = 3;
            } else if (diN.bpw()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.an("obj_source", 4);
            aqVar.an("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(final int i) {
        com.baidu.tbadk.util.ac.a(new com.baidu.tbadk.util.ab<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bkw */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dlf(), i2, PbFragment.this.lEs);
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.ae(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13833");
        aqVar.an("obj_locate", 1);
        if (i == 3) {
            aqVar.an("obj_type", 1);
        } else if (i == 8) {
            aqVar.an("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dlJ() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dlK() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dlL() {
        return this.lHZ;
    }
}
