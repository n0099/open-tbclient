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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0857a {
    private at eLv;
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private com.baidu.adp.lib.d.b<TextView> fZS;
    private com.baidu.adp.lib.d.b<View> fZT;
    private com.baidu.adp.lib.d.b<LinearLayout> fZU;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZV;
    private com.baidu.tieba.tbadkCore.data.e fgI;
    private com.baidu.tbadk.core.message.a fgY;
    private com.baidu.adp.lib.d.b<TbImageView> fof;
    private LikeModel fpO;
    private com.baidu.tieba.callfans.a iwL;
    private VoiceManager jfh;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private com.baidu.tieba.f.b jkd;
    public com.baidu.tbadk.core.util.al kON;
    public ar kSQ;
    private String lIT;
    private PbActivity lMD;
    private com.baidu.tieba.pb.pb.main.b.b lMG;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lMW;
    private View lMX;
    int lMZ;
    private com.baidu.adp.base.f lNC;
    private com.baidu.tbadk.core.view.c lND;
    private BdUniqueId lNE;
    private Runnable lNF;
    private com.baidu.adp.widget.ImageView.a lNG;
    private String lNH;
    private TbRichTextMemeInfo lNI;
    private List<a> lNL;
    public String lNN;
    private bi lNc;
    private com.baidu.tieba.pb.pb.report.a lNh;
    private com.baidu.tbadk.core.dialog.i lNo;
    private com.baidu.tbadk.core.dialog.k lNp;
    private boolean lNq;
    private com.baidu.tieba.tbadkCore.data.f lNu;
    private com.baidu.tbadk.editortools.pb.g lNv;
    private com.baidu.tbadk.editortools.pb.e lNw;
    private com.baidu.tieba.frs.profession.permission.c lNy;
    private EmotionImageData lNz;
    private com.baidu.tbadk.core.data.s lOA;
    private boolean lOq;
    private String lOz;
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
    private static final b.a lOw = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dnM();
            } else {
                com.baidu.tieba.pb.a.b.dnL();
            }
        }
    };
    boolean lME = true;
    private boolean lMF = false;
    private boolean lMH = false;
    private boolean isPaused = false;
    private boolean liC = false;
    private boolean lMI = true;
    private int lMJ = 0;
    private com.baidu.tbadk.core.dialog.b lMK = null;
    private long iHN = -1;
    private long fLQ = 0;
    private long lML = 0;
    private long createTime = 0;
    private long fLH = 0;
    private boolean lMM = false;
    private com.baidu.tbadk.n.b lMN = null;
    private long lMO = 0;
    private boolean lMP = false;
    private long lMQ = 0;
    private int jLX = 1;
    private String fGe = null;
    private boolean lMR = false;
    private boolean isFullScreen = false;
    private boolean lMS = false;
    private String lMT = "";
    private boolean lMU = true;
    private boolean lMV = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lMY = new int[2];
    private int lNa = -1;
    private int lNb = -1;
    public BdUniqueId lNd = BdUniqueId.gen();
    private boolean lNe = false;
    private boolean lNf = com.baidu.tbadk.a.d.bmG();
    private PbInterviewStatusView.a lNg = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lNk.vs(!PbFragment.this.lMU);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.bny()) {
                        PbFragment.this.dpi();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lIX = null;
    private com.baidu.tbadk.baseEditMark.a lNi = null;
    private ForumManageModel ggJ = null;
    private com.baidu.tbadk.coreExtra.model.a fcZ = null;
    private com.baidu.tieba.pb.data.q lNj = null;
    private ShareSuccessReplyToServerModel jBj = null;
    private ap lNk = null;
    private boolean lNl = false;
    private boolean lNm = false;
    private boolean lNn = false;
    private boolean gnZ = false;
    private boolean lNr = false;
    private boolean lNs = false;
    private boolean lNt = false;
    private boolean lNx = false;
    public boolean lNA = false;
    private com.baidu.tbadk.editortools.pb.c fGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bFo() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFn() {
            if (PbFragment.this.kSQ == null || PbFragment.this.kSQ.dtj() == null || !PbFragment.this.kSQ.dtj().dXT()) {
                return !PbFragment.this.GV(com.baidu.tbadk.core.util.al.fcU);
            }
            PbFragment.this.showToast(PbFragment.this.kSQ.dtj().dXV());
            if (PbFragment.this.lNw != null && (PbFragment.this.lNw.bFE() || PbFragment.this.lNw.bFF())) {
                PbFragment.this.lNw.a(false, PbFragment.this.kSQ.dtm());
            }
            PbFragment.this.kSQ.vF(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lNB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFn() {
            if (PbFragment.this.kSQ == null || PbFragment.this.kSQ.dtk() == null || !PbFragment.this.kSQ.dtk().dXT()) {
                return !PbFragment.this.GV(com.baidu.tbadk.core.util.al.fcV);
            }
            PbFragment.this.showToast(PbFragment.this.kSQ.dtk().dXV());
            if (PbFragment.this.lNk != null && PbFragment.this.lNk.drN() != null && PbFragment.this.lNk.drN().doJ() != null && PbFragment.this.lNk.drN().doJ().bFF()) {
                PbFragment.this.lNk.drN().doJ().a(PbFragment.this.kSQ.dtm());
            }
            PbFragment.this.kSQ.vG(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jfV = false;
    private int lNJ = 0;
    private int lNK = -1;
    public int lNM = 0;
    private final a lNO = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lNk != null && PbFragment.this.lNk.drN() != null) {
                r drN = PbFragment.this.lNk.drN();
                if (drN.doH()) {
                    drN.doG();
                    return true;
                }
            }
            if (PbFragment.this.lNk != null && PbFragment.this.lNk.dsO()) {
                PbFragment.this.lNk.dsP();
                return true;
            }
            return false;
        }
    };
    private final ab.a lNP = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lNk.showToast(str);
            }
        }
    };
    private final CustomMessageListener lNQ = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lIX != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lNw != null) {
                    PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                }
                PbFragment.this.lNk.drP();
                PbFragment.this.lNk.dsH();
            }
        }
    };
    CustomMessageListener jgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lIX.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lNk != null && PbFragment.this.lIX != null) {
                    PbFragment.this.lNk.b(PbFragment.this.lIX.getPbData(), PbFragment.this.lIX.dpZ(), PbFragment.this.lIX.dqx(), PbFragment.this.lNk.getSkinType());
                }
                if (PbFragment.this.lNk != null && PbFragment.this.lNk.dsh() != null) {
                    PbFragment.this.lNk.dsh().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lNR = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lNk != null) {
                    if (booleanValue) {
                        PbFragment.this.lNk.dsk();
                    } else {
                        PbFragment.this.lNk.dsl();
                    }
                }
            }
        }
    };
    private CustomMessageListener lNS = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lNw != null) {
                    PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                }
                PbFragment.this.lNk.vz(false);
            }
        }
    };
    private CustomMessageListener lNT = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lNU = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNk != null && PbFragment.this.lNk.dsh() != null) {
                PbFragment.this.lNk.dsh().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener jgK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.dpA();
            }
        }
    };
    private View.OnClickListener fGR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fGe);
        }
    };
    private CustomMessageListener lNV = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                az.a aVar = new az.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIX.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lIX.dqo() != null && PbFragment.this.lIX.dqo().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.lNk.a(ahVar.sendCount, PbFragment.this.lIX.getPbData(), PbFragment.this.lIX.dpZ(), PbFragment.this.lIX.dqx());
                    }
                    if (pbData.dmH() != null && pbData.dmH().size() >= 1 && pbData.dmH().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dmH().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIX.dpX(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            az dPm = pbData.dmH().get(0).dPm();
                            if (dPm == null) {
                                dPm = new az();
                            }
                            ArrayList<az.a> bqi = dPm.bqi();
                            if (bqi == null) {
                                bqi = new ArrayList<>();
                            }
                            bqi.add(0, aVar);
                            dPm.setTotal(ahVar.sendCount + dPm.getTotal());
                            dPm.D(bqi);
                            pbData.dmH().get(0).a(dPm);
                            PbFragment.this.lNk.dsh().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lNW = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                PbFragment.this.lIX.getPbData().dmZ();
                PbFragment.this.lIX.dqt();
                if (PbFragment.this.lNk.dsh() != null) {
                    PbFragment.this.lNk.s(PbFragment.this.lIX.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.o oVar;
            if (customResponsedMessage != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.PH(str);
                PbFragment.this.lIX.dqt();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lIX.getPbData().dmH() != null) {
                    ArrayList<PostData> dmH = PbFragment.this.lIX.getPbData().dmH();
                    Iterator<PostData> it = dmH.iterator();
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
                        dmH.remove(oVar);
                        if (PbFragment.this.lNk.dsh() != null && PbFragment.this.lNk.dsh().getDataList() != null) {
                            PbFragment.this.lNk.dsh().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lNk.getListView() != null && PbFragment.this.lNk.getListView().getData() != null) {
                            PbFragment.this.lNk.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lNk.dsh() != null) {
                            PbFragment.this.lNk.dsh().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lNk.dsh() != null) {
                    PbFragment.this.lNk.s(PbFragment.this.lIX.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lNX = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dtC()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lNY = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ai(List<String> list) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list) && PbFragment.this.lNk != null) {
                PbFragment.this.lNk.fp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lNZ = false;
    private PraiseModel lOa = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void FN(String str) {
            PbFragment.this.lNZ = false;
            if (PbFragment.this.lOa != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIX.getPbData();
                if (pbData.dmF().brc().getIsLike() == 1) {
                    PbFragment.this.Br(0);
                } else {
                    PbFragment.this.Br(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dmF()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lNZ = false;
            if (PbFragment.this.lOa != null && str != null) {
                if (AntiHelper.bP(i, str)) {
                    AntiHelper.bs(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lOb = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void uV(boolean z) {
            PbFragment.this.uT(z);
            if (PbFragment.this.lNk.dsU() != null && z) {
                PbFragment.this.lNk.vs(false);
            }
            PbFragment.this.lNk.vu(z);
        }
    };
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().fuV != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().fuV, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dmO().brr() != null && PbFragment.this.dmO().brr().getGodUserData() != null) {
                            PbFragment.this.dmO().brr().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null) {
                            PbFragment.this.lIX.getPbData().dmF().brr().setHadConcerned(updateAttentionMessage.isAttention());
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
            if (tipEvent.pageId > 0 && PbFragment.this.lMD.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lOc = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lNk.cnj();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.GY(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cQn();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fyb = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.doS();
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
                        if (PbFragment.this.lNk.doQ() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dX("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dnN() != null && PbFragment.this.dnN().iOE != null) {
                                PbFragment.this.dnN().iOE.onClick(view);
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
                if (PbFragment.this.lNw != null) {
                    PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                }
                PbFragment.this.lNk.drP();
                PbFragment.this.lNk.dsH();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lOd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNE) {
                PbFragment.this.lNk.cnj();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIX.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dmV().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lND.showSuccessToast(PbFragment.this.lNC.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lNC.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.DW(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dpw();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lNC.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lND.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lOe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNE) {
                PbFragment.this.lNk.cnj();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lND.showSuccessToast(PbFragment.this.lNC.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lNC.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lND.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lOf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNE) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lNk.cnj();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nET;
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
                    PbFragment.this.lNk.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lOg = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNk.drQ() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.doS();
            }
        }
    };
    private CustomMessageListener jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.jfV = true;
                }
            }
        }
    };
    public a.b ltH = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cFB();
            com.baidu.tbadk.core.data.ax pageData = PbFragment.this.lIX.getPageData();
            int pageNum = PbFragment.this.lNk.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bqb()) {
                PbFragment.this.lNk.dsH();
                PbFragment.this.cFA();
                PbFragment.this.lNk.dso();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lIX.Hc(PbFragment.this.lNk.getPageNum());
                    if (PbFragment.this.lMG != null) {
                        PbFragment.this.lMG.showFloatingView();
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
    private k.c lOh = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lNo != null) {
                PbFragment.this.lNo.dismiss();
            }
            PbFragment.this.GU(i);
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
                    if (com.baidu.tbadk.a.d.bmR() || com.baidu.tbadk.a.d.bmS()) {
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
                    if (com.baidu.tbadk.a.d.bmR() || com.baidu.tbadk.a.d.bmS()) {
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
                    if (PbFragment.this.lNG != null && !TextUtils.isEmpty(PbFragment.this.lNH)) {
                        if (PbFragment.this.lNI == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lNH));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lNH;
                            aVar.pkgId = PbFragment.this.lNI.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lNI.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lNG = null;
                        PbFragment.this.lNH = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lNG != null && !TextUtils.isEmpty(PbFragment.this.lNH)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eLv == null) {
                                PbFragment.this.eLv = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eLv.p(PbFragment.this.lNH, PbFragment.this.lNG.getImageByte());
                            PbFragment.this.lNG = null;
                            PbFragment.this.lNH = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.kmq != null) {
                        PbFragment.this.kmq.gV(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.kmq = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").an("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dG(view);
                        if (PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null && PbFragment.this.lIX.getPbData().dmF().brr().getUserId() != null && PbFragment.this.lNi != null) {
                            int h = PbFragment.this.h(PbFragment.this.lIX.getPbData());
                            bz dmF = PbFragment.this.lIX.getPbData().dmF();
                            if (dmF.bpY()) {
                                i2 = 2;
                            } else if (dmF.bpZ()) {
                                i2 = 3;
                            } else if (dmF.btp()) {
                                i2 = 4;
                            } else {
                                i2 = dmF.btq() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dX("tid", PbFragment.this.lIX.lQv).an("obj_locate", 2).dX("obj_id", PbFragment.this.lIX.getPbData().dmF().brr().getUserId()).an("obj_type", PbFragment.this.lNi.bny() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
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
                        PbFragment.this.PJ((String) tag);
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
                        PbFragment.this.lNk.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.lNk.dN(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lNk.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.btl() != null) {
                            PbFragment.this.d(postData.btl());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lOi = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            PbFragment.this.lNk.dsH();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lIX == null || PbFragment.this.lIX.isLoading) {
                    return false;
                }
                PbFragment.this.cFA();
                PbFragment.this.lNk.dso();
                if (PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().lFQ != null && PbFragment.this.lIX.getPbData().lFQ.size() > i) {
                    int intValue = PbFragment.this.lIX.getPbData().lFQ.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dX("tid", PbFragment.this.lIX.dpY()).dX("fid", PbFragment.this.lIX.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Ha(intValue)));
                    if (PbFragment.this.lIX.Hh(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lNk.vn(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Ha(int i) {
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
    public final View.OnClickListener jhV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.lNk.dsD()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lIX.vb(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lNk.dsp();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().dro()) {
                        if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drp()) {
                            if (view == PbFragment.this.lNk.lUp.fOs) {
                                if (PbFragment.this.lNk.vw(PbFragment.this.lIX.dqf())) {
                                    PbFragment.this.cFA();
                                    return;
                                }
                                PbFragment.this.lMI = false;
                                PbFragment.this.lMH = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lMD, PbFragment.this.lNk.lUp.fOs);
                                PbFragment.this.lMD.finish();
                            } else if (view != PbFragment.this.lNk.dsm() && (PbFragment.this.lNk.lUp.dtP() == null || (view != PbFragment.this.lNk.lUp.dtP().drn() && view != PbFragment.this.lNk.lUp.dtP().drl()))) {
                                if (view == PbFragment.this.lNk.dsL()) {
                                    if (PbFragment.this.lIX != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIX.getPbData().dmF().brq().getLink());
                                    }
                                } else if (view != PbFragment.this.lNk.lUp.maQ) {
                                    if (view == PbFragment.this.lNk.lUp.jvO) {
                                        if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                            ArrayList<PostData> dmH = PbFragment.this.lIX.getPbData().dmH();
                                            if ((dmH == null || dmH.size() <= 0) && PbFragment.this.lIX.dpZ()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dX("tid", PbFragment.this.lIX.dpX()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", PbFragment.this.lIX.getForumId()));
                                            if (!PbFragment.this.lNk.dsZ()) {
                                                PbFragment.this.lNk.drP();
                                            }
                                            PbFragment.this.dpa();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lNk.uI(true);
                                            PbFragment.this.lNk.drP();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lNk.dsk();
                                                PbFragment.this.cFA();
                                                PbFragment.this.lNk.dso();
                                                PbFragment.this.lIX.PO(PbFragment.this.dpm());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drk()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lNk.lUp.dtP() != null && view == PbFragment.this.lNk.lUp.dtP().drj()) {
                                                PbFragment.this.lNk.lUp.bet();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.GZ(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drh()) {
                                                    if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drr()) {
                                                        if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().dri()) {
                                                            if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drs()) {
                                                                if (PbFragment.this.lNk.dsU() == view) {
                                                                    if (PbFragment.this.lNk.dsU().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lIX.getPbData();
                                                                        if (pbData2 != null && pbData2.dmF() != null && pbData2.dmF().bqX() != null) {
                                                                            String bqN = pbData2.dmF().bqX().bqN();
                                                                            if (StringUtils.isNull(bqN)) {
                                                                                bqN = pbData2.dmF().bqX().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dX("obj_id", bqN));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gs("c10725", null);
                                                                    }
                                                                    PbFragment.this.dpt();
                                                                } else if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drq()) {
                                                                    if (PbFragment.this.lNk.lUp.dtP() != null && view == PbFragment.this.lNk.lUp.dtP().drm()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lNk.b(PbFragment.this.lIX.getPbData(), PbFragment.this.lIX.dpZ(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lNk.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lNk.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lNk.lUp.bet();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dX("tid", PbFragment.this.lIX.dpX());
                                                                            aqVar.dX("fid", PbFragment.this.lIX.getForumId());
                                                                            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.an("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                PbFragment.this.lNk.dsH();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dPq() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.nsp != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwn = postData.nsp.bwn();
                                                                                        bwn.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bwn.an("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bwn.an("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bwn);
                                                                                    }
                                                                                    String dpX = PbFragment.this.lIX.dpX();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lIX.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lIX.getPbData().dmU();
                                                                                    }
                                                                                    PbFragment.this.cFA();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a PM = PbFragment.this.PM(id);
                                                                                        if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PM != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpX, id, "pb", true, null, true, null, i3, postData.duP(), PbFragment.this.lIX.getPbData().getAnti(), false, postData.brr().getIconInfo()).addBigImageData(PM.lJk, PM.eMr, PM.eMp, PM.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lIX.dqI());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lIX.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lIX.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lIX.dqh());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a PM2 = PbFragment.this.PM(id);
                                                                                        if (postData != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PM2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpX, id, "pb", true, null, false, str2, i3, postData.duP(), PbFragment.this.lIX.getPbData().getAnti(), false, postData.brr().getIconInfo()).addBigImageData(PM2.lJk, PM2.eMr, PM2.eMp, PM2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lIX.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lIX.dqh());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lIX.dqI());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lIX.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 3).dX("fid", PbFragment.this.lIX.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lIX != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dX("tid", PbFragment.this.lIX.dpX());
                                                                            aqVar2.dX("fid", PbFragment.this.lIX.getForumId());
                                                                            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.an("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nsp != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwn2 = postData3.nsp.bwn();
                                                                                        bwn2.delete("obj_locate");
                                                                                        bwn2.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bwn2);
                                                                                    }
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                        String dpX2 = PbFragment.this.lIX.dpX();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lIX.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lIX.getPbData().dmU();
                                                                                        }
                                                                                        PbActivity.a PM3 = PbFragment.this.PM(id2);
                                                                                        if (PM3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpX2, id2, "pb", true, null, false, null, i4, postData3.duP(), PbFragment.this.lIX.getPbData().getAnti(), false, postData3.brr().getIconInfo()).addBigImageData(PM3.lJk, PM3.eMr, PM3.eMp, PM3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lIX.dqI());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lIX.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lIX.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lIX.dqh());
                                                                                            if (PbFragment.this.lIX.getPbData().dno() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lIX.getPbData().dno().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lIX.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lIX.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lIX.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lIX.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lIX.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lIX.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lIX.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lIX.getPbData().getForum().getUser_level());
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
                                                                        if (PbFragment.this.lIX != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dX("tid", PbFragment.this.lIX.dpX());
                                                                                aqVar3.dX("fid", PbFragment.this.lIX.getForumId());
                                                                                aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.an("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nsp != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwn3 = postData4.nsp.bwn();
                                                                                        bwn3.delete("obj_locate");
                                                                                        bwn3.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bwn3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", PbFragment.this.lIX.dpY()).dX("fid", PbFragment.this.lIX.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.doP().drM() != null && postData4.brr() != null && postData4.dPe() != 1) {
                                                                                        if (PbFragment.this.doP().drN() != null) {
                                                                                            PbFragment.this.doP().drN().doF();
                                                                                        }
                                                                                        if (PbFragment.this.lNf && postData4.dPb() != null && postData4.dPb().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lIX.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lIX.getPbData().dmF());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.doP().drM().d(pVar);
                                                                                            PbFragment.this.doP().drM().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.brr().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lNw != null) {
                                                                                                PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
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
                                                                        if (view != PbFragment.this.lNk.dog()) {
                                                                            if (view == PbFragment.this.lNk.lUp.dtQ()) {
                                                                                PbFragment.this.lNk.dsv();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (ceVar = (ce) view.getTag()) != null && !StringUtils.isNull(ceVar.btM())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        be.bwv().b(PbFragment.this.getPageContext(), new String[]{ceVar.btM()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dX("tid", PbFragment.this.lIX.lQv));
                                                                                            }
                                                                                            if (PbFragment.this.lNp == null) {
                                                                                                PbFragment.this.lNp = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lNp.a(PbFragment.this.lOh);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dI(view);
                                                                                            if (!PbFragment.this.dI(view) || PbFragment.this.lNG == null || !PbFragment.this.lNG.isGif()) {
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
                                                                                                if (postData5.dPg() != null && postData5.dPg().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lNp);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eXH.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.kmq = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lIX.getPbData().bny()) {
                                                                                                String bnx = PbFragment.this.lIX.getPbData().bnx();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bnx) && bnx.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lNp);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lNp);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.kmq);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eXH.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lNp);
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
                                                                                                            gVar.eXH.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar5);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.uP(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNp);
                                                                                                                gVar6.eXH.setTag(str3);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNp);
                                                                                                                gVar2.eXH.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lNp);
                                                                                                            gVar8.eXH.setTag(sparseArray9);
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
                                                                                                            if (PbFragment.this.lIX.getPbData().dmU() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNp);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNp);
                                                                                                            }
                                                                                                            gVar2.eXH.setTag(sparseArray10);
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar7 != null) {
                                                                                                            arrayList.add(gVar7);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lNp.bB(arrayList);
                                                                                                    PbFragment.this.lNo = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNp);
                                                                                                    PbFragment.this.lNo.SY();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.kmq);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eXH.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lNp.bB(arrayList);
                                                                                            PbFragment.this.lNo = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNp);
                                                                                            PbFragment.this.lNo.SY();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lIX.getPbData().dmF().getActUrl());
                                                                                        if (PbFragment.this.lIX.getPbData().dmF().bse() != 1) {
                                                                                            if (PbFragment.this.lIX.getPbData().dmF().bse() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dX("fid", PbFragment.this.lIX.getPbData().getForumId()).dX("tid", PbFragment.this.lIX.getPbData().getThreadId()).dX("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lIX.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lNk.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bvr().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lNk.drP();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.doY() == 1 && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dX("fid", PbFragment.this.lIX.getPbData().getForumId()).dX("tid", PbFragment.this.lIX.getPbData().getThreadId()).dX("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.doY() == 1 && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dX("fid", PbFragment.this.lIX.getPbData().getForumId()).dX("tid", PbFragment.this.lIX.getPbData().getThreadId()).dX("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dpo();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dpp();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dnb() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lIX.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dX("fid", pbData3.getForumId()));
                                                                                        be.bwv().b(PbFragment.this.getPageContext(), new String[]{pbData3.dnb().dnp()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dnb() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lIX.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dX("fid", pbData4.getForumId()));
                                                                                        be.bwv().b(PbFragment.this.getPageContext(), new String[]{pbData4.dnb().dnp()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lNJ >= 0) {
                                                                                        if (PbFragment.this.lIX != null) {
                                                                                            PbFragment.this.lIX.dqJ();
                                                                                        }
                                                                                        if (PbFragment.this.lIX != null && PbFragment.this.lNk.dsh() != null) {
                                                                                            PbFragment.this.lNk.dsh().a(PbFragment.this.lIX.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lNJ = 0;
                                                                                        if (PbFragment.this.lIX != null) {
                                                                                            PbFragment.this.lNk.getListView().setSelection(PbFragment.this.lIX.dqM());
                                                                                            PbFragment.this.lIX.dc(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.GZ(8);
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
                                                                                    if (PbFragment.this.lNk.getListView() != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lNk.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lNk.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dnf = PbFragment.this.lIX.getPbData().dnf();
                                                                                        boolean z8 = PbFragment.this.lNk.drO() != null && PbFragment.this.lNk.drO().isVertical();
                                                                                        boolean dsE = PbFragment.this.lNk.dsE();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (dnf && PbFragment.this.lNk.drO() != null && PbFragment.this.lNk.drO().bUW() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lNk.drO().dtz();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lNk.drO().bUW().getHeight() - PbFragment.this.lNk.drO().dtz());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.PN("c13568");
                                                                                        if ((PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().bri() <= 0) || (dsE && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.doV();
                                                                                                if (PbFragment.this.lIX.getPbData().dmF().brr() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIX.lQv).dX("fid", PbFragment.this.lIX.getPbData().getForumId()).an("obj_locate", 2).dX("uid", PbFragment.this.lIX.getPbData().dmF().brr().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dnf) {
                                                                                                if (PbFragment.this.lNk.lVA != null && PbFragment.this.lNk.lVA.lWI != null && PbFragment.this.lNk.lVA.lWI.getView() != null) {
                                                                                                    if (PbFragment.this.lNk.lVA.lWI.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dpe();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lNk.drO() != null && PbFragment.this.lNk.drO().bUW() != null) {
                                                                                                            i5 = PbFragment.this.lNk.drO().bUW().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lNk.lVA.lWI.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lNk.drY() != null) {
                                                                                                z10 = PbFragment.this.lNk.drY().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lNk.lVA != null && PbFragment.this.lNk.lVA.lWI != null && PbFragment.this.lNk.lVA.lWI.getView() != null && PbFragment.this.lNk.lVA.lWI.getView().getParent() != null && PbFragment.this.lNk.lUp != null && PbFragment.this.lNk.lUp.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lNk.lVA.lWI.getView().getTop() - PbFragment.this.lNk.lUp.mNavigationBar.getBottom() < PbFragment.this.lNk.lVA.lWI.lTP.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dsE) {
                                                                                                PbFragment.this.lNa = firstVisiblePosition;
                                                                                                PbFragment.this.lNb = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lNk.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lNa > 0) {
                                                                                                if (PbFragment.this.lNk.getListView().getChildAt(PbFragment.this.lNa) != null) {
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollToPosition(PbFragment.this.lNa, PbFragment.this.lNb, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lNk.getListView().setSelectionFromTop(PbFragment.this.lNa, PbFragment.this.lNb + equipmentHeight);
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dpe = PbFragment.this.dpe();
                                                                                                if (PbFragment.this.dpd() != -1) {
                                                                                                    dpe--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dpe < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.x.getCount(PbFragment.this.lNk.getListView().getData()) - 1) + PbFragment.this.lNk.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dpe;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!dnf || PbFragment.this.lNk.drO() == null) ? (PbFragment.this.lNk.lUp == null || PbFragment.this.lNk.lUp.mNavigationBar == null) ? dimens : (PbFragment.this.lNk.lUp.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lNk.drO().dty() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lNk.lVA == null || PbFragment.this.lNk.lVA.lWI == null || PbFragment.this.lNk.lVA.lWI.getView() == null || PbFragment.this.lNk.lVA.lWI.getView().getParent() == null) {
                                                                                                    PbFragment.this.lNk.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lNk.getListView().smoothScrollBy(PbFragment.this.lNk.lVA.lWI.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIX.lQv).dX("fid", PbFragment.this.lIX.getPbData().getForumId()).an("obj_locate", 2).dX("uid", PbFragment.this.lIX.getPbData().dmF().brr().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.lIX.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lIX.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lIX.dnP()) || PbFragment.this.lIX.getAppealInfo() == null) {
                                                                                                PbFragment.this.lMD.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lIX.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lIX.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lMD.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dnP = PbFragment.this.lIX.dnP();
                                                                                        if (PbFragment.this.lIX.dqa() && dnP != null && dnP.equals(name)) {
                                                                                            PbFragment.this.lMD.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lIX.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dX("tid", PbFragment.this.lIX.dpX());
                                                                                        aqVar4.dX("fid", PbFragment.this.lIX.getForumId());
                                                                                        aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lIX.getPbData().dmF() != null) {
                                                                                            aqVar4.dX(IntentConfig.NID, PbFragment.this.lIX.getPbData().dmF().bpP());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar = (bz) view.getTag();
                                                                                        if (PbFragment.this.lIX.dqI() == 3 && PbFragment.this.dnO() && PbFragment.this.lIX.getPbData() != null && com.baidu.tbadk.core.util.x.isEmpty(PbFragment.this.lIX.getPbData().dnc())) {
                                                                                            PbFragment.this.lMD.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar.brv(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dX("tid", bzVar.getId());
                                                                                        aqVar5.w("fid", bzVar.getFid());
                                                                                        aqVar5.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dX(IntentConfig.NID, bzVar.bpP());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lIX != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dX("tid", PbFragment.this.lIX.dpX());
                                                                                        aqVar6.dX("fid", PbFragment.this.lIX.getForumId());
                                                                                        aqVar6.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.an("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lIX.getPbData();
                                                                                        if (PbFragment.this.lNj == null) {
                                                                                            PbFragment.this.lNj = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").w("forum_id", j2).bwo();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lOl);
                                                                                        PbFragment.this.lNj.I(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dX("fid", PbFragment.this.lIX.getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dX("obj_source", "PB_card").dX("tid", PbFragment.this.lIX.dpX()).an("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar2 = (bz) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar2.brv(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 9).an("obj_locate", 9).w("obj_id", bzVar2.getFid()).dX("tid", bzVar2.getId()).an("thread_type", bzVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bz) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bz bzVar3 = (bz) view.getTag();
                                                                                        if (PbFragment.this.fpO != null) {
                                                                                            PbFragment.this.fpO.gr(bzVar3.brv(), String.valueOf(bzVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).an("obj_locate", 11).w("obj_id", bzVar3.getFid()).dX("tid", bzVar3.getId()).an("thread_type", bzVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                    aqVar7.dX("tid", PbFragment.this.lIX.dpX());
                                                                                    aqVar7.dX("fid", PbFragment.this.lIX.getForumId());
                                                                                    aqVar7.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    aqVar7.an("obj_locate", 7);
                                                                                    TiebaStatic.log(aqVar7);
                                                                                    PbFragment.this.lME = false;
                                                                                    PbFragment.this.dH(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIX.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIX.dpX(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lIX.getPbData().dmF().brL())));
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
                                                                            if (PbFragment.this.lNp == null) {
                                                                                PbFragment.this.lNp = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lNp.a(PbFragment.this.lOh);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dnW().getPbData() != null && PbFragment.this.dnW().getPbData().dni();
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
                                                                                if (postData6.btl() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.btl().hasAgree && postData6.bsV() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lNp);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eXH.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lNp);
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
                                                                                        gVar10.eXH.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar10);
                                                                                    } else {
                                                                                        if ((PbFragment.this.uP(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNp);
                                                                                            gVar11.eXH.setTag(str);
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
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNp);
                                                                                            gVar12.eXH.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lNp);
                                                                                        gVar3.eXH.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.lIX.getPbData().dmU() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNp);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNp);
                                                                                            }
                                                                                            gVar12.eXH.setTag(sparseArray15);
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
                                                                                PbFragment.this.lNp.bB(arrayList2);
                                                                                PbFragment.this.lNo = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNp);
                                                                                PbFragment.this.lNo.SY();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lNk.dsH();
                                                                    SparseArray<Object> b3 = PbFragment.this.lNk.b(PbFragment.this.lIX.getPbData(), PbFragment.this.lIX.dpZ(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIX.getPbData().getForum().getId(), PbFragment.this.lIX.getPbData().getForum().getName(), PbFragment.this.lIX.getPbData().dmF().getId(), String.valueOf(PbFragment.this.lIX.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.lNk.lUp.dtO();
                                                            }
                                                        } else if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null) {
                                                            PbFragment.this.lNk.lUp.bet();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.PJ(PbFragment.this.lIX.getPbData().dmF().brH());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lNk.dsH();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lIX.dqr()));
                                                                return;
                                                            }
                                                            PbFragment.this.cFA();
                                                            PbFragment.this.lNk.dso();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lIX.getPbData().lFQ == null || PbFragment.this.lIX.getPbData().lFQ.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lIX.getPbData().lFQ.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lIX.getPbData().lFQ.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lIX.getPbData().lFQ.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lIX.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lIX.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lIX.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lIX.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i9));
                                                                    if (PbFragment.this.lIX.getPbData().lFQ != null && PbFragment.this.lIX.getPbData().lFQ.size() > i8) {
                                                                        i8 = PbFragment.this.lIX.getPbData().lFQ.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean Hh = PbFragment.this.lIX.Hh(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lIX.dqr()));
                                                                    if (Hh) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lNk.vn(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.SY();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lNk.dsH();
                                                    if (PbFragment.this.dnW().getPbData().lFR != 2) {
                                                        if (PbFragment.this.lIX.getPageData() != null) {
                                                            PbFragment.this.lNk.a(PbFragment.this.lIX.getPageData(), PbFragment.this.ltH);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lIX.getPbData()) != null) {
                                                bz dmF = pbData.dmF();
                                                if (dmF != null && dmF.brr() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIX.lQv).dX("fid", pbData.getForumId()).an("obj_locate", 4).dX("uid", dmF.brr().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (dmF != null) {
                                                    if (dmF.bpY()) {
                                                        i8 = 2;
                                                    } else if (dmF.bpZ()) {
                                                        i8 = 3;
                                                    } else if (dmF.btp()) {
                                                        i8 = 4;
                                                    } else if (dmF.btq()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar8.dX("tid", PbFragment.this.lIX.dpX());
                                                aqVar8.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar8.dX("fid", PbFragment.this.lIX.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar8.an("obj_locate", 5);
                                                } else {
                                                    aqVar8.an("obj_locate", 6);
                                                }
                                                aqVar8.an("obj_name", i8);
                                                aqVar8.an("obj_type", 1);
                                                if (dmF != null) {
                                                    if (dmF.bpY()) {
                                                        aqVar8.an("obj_type", 10);
                                                    } else if (dmF.bpZ()) {
                                                        aqVar8.an("obj_type", 9);
                                                    } else if (dmF.btq()) {
                                                        aqVar8.an("obj_type", 8);
                                                    } else if (dmF.btp()) {
                                                        aqVar8.an("obj_type", 7);
                                                    } else if (dmF.isShareThread) {
                                                        aqVar8.an("obj_type", 6);
                                                    } else if (dmF.threadType == 0) {
                                                        aqVar8.an("obj_type", 1);
                                                    } else if (dmF.threadType == 40) {
                                                        aqVar8.an("obj_type", 2);
                                                    } else if (dmF.threadType == 49) {
                                                        aqVar8.an("obj_type", 3);
                                                    } else if (dmF.threadType == 54) {
                                                        aqVar8.an("obj_type", 4);
                                                    } else {
                                                        aqVar8.an("obj_type", 5);
                                                    }
                                                    aqVar8.an(IntentConfig.CARD_TYPE, dmF.btt());
                                                    aqVar8.dX(IntentConfig.RECOM_SOURCE, dmF.mRecomSource);
                                                    aqVar8.dX("ab_tag", dmF.mRecomAbTag);
                                                    aqVar8.dX("weight", dmF.mRecomWeight);
                                                    aqVar8.dX("extra", dmF.mRecomExtra);
                                                    aqVar8.dX(IntentConfig.NID, dmF.bpP());
                                                    if (dmF.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(dmF.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar8.dX("obj_param6", dmF.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar8.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dpE() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dpE(), aqVar8);
                                                }
                                                TiebaStatic.log(aqVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dmH2 = PbFragment.this.lIX.getPbData().dmH();
                                                    if ((dmH2 != null && dmH2.size() > 0) || !PbFragment.this.lIX.dpZ()) {
                                                        PbFragment.this.lNk.dsH();
                                                        PbFragment.this.cFA();
                                                        if (pbData.dnb() != null && !StringUtils.isNull(pbData.dnb().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dX("fid", PbFragment.this.lIX.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dmF)) {
                                                            if (PbFragment.this.lNk != null) {
                                                                PbFragment.this.lNk.dsK();
                                                                PbFragment.this.lNk.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lNk.showLoadingDialog();
                                                                PbFragment.this.lIX.dqD().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i9 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i9 = 1;
                                                                }
                                                                PbFragment.this.GY(i9);
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
                                            PbFragment.this.lNk.dsH();
                                            if (PbFragment.this.lNk.lUp.dtP() != null && view == PbFragment.this.lNk.lUp.dtP().drk() && !PbFragment.this.lNk.dsZ()) {
                                                PbFragment.this.lNk.drP();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cFA();
                                                PbFragment.this.lNk.dso();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lIX.C(true, PbFragment.this.dpm());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lIX.C(false, PbFragment.this.dpm()) : PbFragment.this.lIX.PO(PbFragment.this.dpm());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.lNk.uI(true);
                                                    PbFragment.this.lNk.dsk();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lNk.vn(true);
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
                                        PbFragment.this.lNk.dsH();
                                        if (PbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lIX.Hi(PbFragment.this.lNk.dst()) != null) {
                                            PbFragment.this.dph();
                                            if (PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIX.lQv).dX("fid", PbFragment.this.lIX.getPbData().getForumId()).an("obj_locate", 3).dX("uid", PbFragment.this.lIX.getPbData().dmF().brr().getUserId()));
                                            }
                                            if (PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null && PbFragment.this.lIX.getPbData().dmF().brr().getUserId() != null && PbFragment.this.lNi != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lIX.getPbData());
                                                bz dmF2 = PbFragment.this.lIX.getPbData().dmF();
                                                int i10 = 1;
                                                if (dmF2.bpY()) {
                                                    i10 = 2;
                                                } else if (dmF2.bpZ()) {
                                                    i10 = 3;
                                                } else if (dmF2.btp()) {
                                                    i10 = 4;
                                                } else if (dmF2.btq()) {
                                                    i10 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dX("tid", PbFragment.this.lIX.lQv).an("obj_locate", 1).dX("obj_id", PbFragment.this.lIX.getPbData().dmF().brr().getUserId()).an("obj_type", PbFragment.this.lNi.bny() ? 0 : 1).an("obj_source", h).an("obj_param1", i10));
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
                                    if (PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().bpW() && PbFragment.this.lIX.getPbData().dmF().brI() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.lIX.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lIX.dnP()) || PbFragment.this.lIX.getAppealInfo() == null) {
                                            PbFragment.this.lMD.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lIX.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lIX.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lMD.finish();
                                        return;
                                    }
                                    String dnP2 = PbFragment.this.lIX.dnP();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lIX.dqa() && dnP2 != null && dnP2.equals(name2)) {
                                        PbFragment.this.lMD.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lIX.getPbData() != null && !PbFragment.this.ggJ.dPZ()) {
                                    PbFragment.this.lNk.dsH();
                                    int i11 = 0;
                                    if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drl()) {
                                        if (PbFragment.this.lNk.lUp.dtP() == null || view != PbFragment.this.lNk.lUp.dtP().drn()) {
                                            if (view == PbFragment.this.lNk.dsm()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lIX.getPbData().dmF().brn() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lIX.getPbData().dmF().brm() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lIX.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lIX.getPbData().dmF().getId();
                                    PbFragment.this.lNk.dsj();
                                    PbFragment.this.ggJ.c(id4, name3, id5, i11, PbFragment.this.lNk.dsn());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lNk.lUp.dtO();
                            if (PbFragment.this.lIX != null) {
                                PbFragment.this.iwL.setThreadId(PbFragment.this.lIX.dpX());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lIX == null || !PbFragment.this.lIX.isPrivacy()) {
                                PbFragment.this.iwL.cux();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dnW() != null && PbFragment.this.dnW().getPbData() != null && PbFragment.this.dnW().getPbData().getThreadId() != null && PbFragment.this.dnW().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dnW() != null && PbFragment.this.dnW().getPbData() != null) {
                                    PbFragment.this.iwL.l(3, i12, PbFragment.this.dnW().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dnW() != null && PbFragment.this.dnW().getPbData() != null) {
                                    PbFragment.this.iwL.l(3, 3, PbFragment.this.dnW().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lNk.dsH();
                        PbFragment.this.cFA();
                        PbFragment.this.lNk.dso();
                        PbFragment.this.lNk.showLoadingDialog();
                        if (PbFragment.this.lNk.drY() != null) {
                            PbFragment.this.lNk.drY().setVisibility(8);
                        }
                        PbFragment.this.lIX.Hc(1);
                        if (PbFragment.this.lMG != null) {
                            PbFragment.this.lMG.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String doW = PbFragment.this.doW();
                        if (!TextUtils.isEmpty(doW)) {
                            be.bwv().b(PbFragment.this.getPageContext(), new String[]{doW});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar9 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar9.dX("tid", PbFragment.this.lIX.dpX());
                aqVar9.dX("fid", PbFragment.this.lIX.getForumId());
                aqVar9.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar9.an("obj_locate", 1);
                TiebaStatic.log(aqVar9);
                if (PbFragment.this.lMP) {
                    PbFragment.this.lMP = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.doP().drM() != null && postData7.brr() != null && postData7.dPe() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.doP().drN() != null) {
                                PbFragment.this.doP().drN().doF();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lIX.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lIX.getPbData().dmF());
                            pVar2.g(postData7);
                            PbFragment.this.doP().drM().d(pVar2);
                            PbFragment.this.doP().drM().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.brr().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lIX.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lNw != null) {
                                PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lOj = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lIX != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lIX.lQv)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lIX.getPbData() != null) {
                    aqVar.dX("fid", PbFragment.this.lIX.getPbData().getForumId());
                }
                aqVar.dX("tid", PbFragment.this.lIX.dpX());
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cFA();
            PbFragment.this.lNk.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lIX.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIX.getPbData();
                            if (pbData != null && pbData.dmF() != null && pbData.dmF().brr() != null && (userId = pbData.dmF().brr().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lIX.dqk()) {
                                PbFragment.this.lNk.dso();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lIX.dqk()) {
                            PbFragment.this.lNk.dso();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lNk.s(PbFragment.this.lIX.getPbData());
                    }
                    if (PbFragment.this.lIX.dqe()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dX("tid", PbFragment.this.lIX.dpX()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uO(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lNw.bFE() || PbFragment.this.lNw.bFF()) {
                    PbFragment.this.lNw.a(false, postWriteCallBackData);
                }
                PbFragment.this.kSQ.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kON != null) {
                    PbFragment.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Bo(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).btY();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lOk = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                    aqVar.dX("fid", PbFragment.this.lIX.getPbData().getForumId());
                }
                if (PbFragment.this.lIX != null) {
                    aqVar.dX("tid", PbFragment.this.lIX.dpX());
                }
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.kSQ != null) {
                    PbFragment.this.kSQ.dth();
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
                if (PbFragment.this.kON != null) {
                    PbFragment.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Bo(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).btY();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kSQ != null) {
                if (PbFragment.this.lNk != null && PbFragment.this.lNk.drN() != null && PbFragment.this.lNk.drN().doJ() != null && PbFragment.this.lNk.drN().doJ().bFF()) {
                    PbFragment.this.lNk.drN().doJ().a(postWriteCallBackData);
                }
                PbFragment.this.kSQ.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lOl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dtc;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lMD.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lNk != null && (dtc = PbFragment.this.lNk.dtc()) != null && PbFragment.this.lNk.getListView() != null) {
                            PbFragment.this.lNk.getListView().removeHeaderView(dtc);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lOm = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h ss;
            if (!z || fVar == null || fVar.dmS() != null || com.baidu.tbadk.core.util.x.getCount(fVar.dmH()) >= 1) {
                PbFragment.this.liC = true;
                PbFragment.this.lNk.dsq();
                if (fVar == null || !fVar.dmN()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lNk.getView());
                }
                PbFragment.this.lNk.dsl();
                if (PbFragment.this.isFullScreen || PbFragment.this.lNk.dsZ()) {
                    PbFragment.this.lNk.dsQ();
                } else if (!PbFragment.this.lNk.dsN()) {
                    PbFragment.this.lNk.vz(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.gnZ = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lNk.getView());
                    PbFragment.this.lNk.dsz();
                }
                if (z && fVar != null) {
                    bz dmF = fVar.dmF();
                    if (dmF == null || !dmF.bqa()) {
                        PbFragment.this.d(PbFragment.this.lNv);
                    } else {
                        dpG();
                    }
                    PbFragment.this.lNk.drN().setPbData(fVar);
                    PbFragment.this.lNk.caZ();
                    if (dmF != null && dmF.bsE() != null) {
                        PbFragment.this.a(dmF.bsE());
                    }
                    if (PbFragment.this.lNw != null) {
                        PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dmH() != null && fVar.dmH().size() >= 1 && fVar.dmH().get(0) != null) {
                        PbFragment.this.lIX.PQ(fVar.dmH().get(0).getId());
                    } else if (fVar.dmS() != null) {
                        PbFragment.this.lIX.PQ(fVar.dmS().getId());
                    }
                    if (PbFragment.this.lNw != null) {
                        PbFragment.this.lNw.a(fVar.getAnti());
                        PbFragment.this.lNw.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lNw.setThreadData(dmF);
                        PbFragment.this.lNw.a(PbFragment.this.lIX.dqo(), PbFragment.this.lIX.dpX(), PbFragment.this.lIX.dqF());
                        if (dmF != null) {
                            PbFragment.this.lNw.kZ(dmF.bsR());
                        }
                    }
                    if (PbFragment.this.lNi != null) {
                        PbFragment.this.lNi.jc(fVar.bny());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dni()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lNk.vy(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lNk.a(fVar, i2, i3, PbFragment.this.lIX.dpZ(), i4, PbFragment.this.lIX.getIsFromMark());
                    PbFragment.this.lNk.d(fVar, PbFragment.this.lIX.dpZ());
                    PbFragment.this.lNk.vv(PbFragment.this.lIX.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fGe = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fGe) && PbFragment.this.lNw != null && PbFragment.this.lNw.bEJ() != null && (ss = PbFragment.this.lNw.bEJ().ss(6)) != null && !TextUtils.isEmpty(PbFragment.this.fGe)) {
                            ((View) ss).setOnClickListener(PbFragment.this.fGR);
                        }
                    }
                    if (PbFragment.this.lNr) {
                        PbFragment.this.lNr = false;
                        final int dpd = PbFragment.this.dpd();
                        if (!fVar.dnf()) {
                            PbFragment.this.lNk.Hp(dpd);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dpd, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lNs) {
                        PbFragment.this.lNs = false;
                        final int dpd2 = PbFragment.this.dpd();
                        final boolean z2 = dpd2 != -1;
                        if (!z2) {
                            dpd2 = PbFragment.this.dpe();
                        }
                        if (PbFragment.this.lNk != null) {
                            if (!fVar.dnf()) {
                                PbFragment.this.lNk.Hp(dpd2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dpd2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lNk.setSelectionFromTop(dpd2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lNk.setSelectionFromTop(dpd2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lNk.vA(true);
                                PbFragment.this.lNk.vz(false);
                            }
                        }
                    } else if (PbFragment.this.lNt) {
                        PbFragment.this.lNt = false;
                        PbFragment.this.lNk.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lNk.dsu();
                    }
                    PbFragment.this.lIX.a(fVar.getForum(), PbFragment.this.lNX);
                    PbFragment.this.lIX.a(PbFragment.this.lNY);
                    if (PbFragment.this.kON != null && dmF != null && dmF.brr() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dmF.brr());
                        PbFragment.this.kON.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.gnZ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lIX.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lIX.getAppealInfo().lFI)) {
                                    PbFragment.this.lNk.a(PbFragment.this.lIX.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lNk.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lNk.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lNk.dsQ();
                            PbFragment.this.lNk.dsy();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lIX.dpX());
                            jSONObject.put("fid", PbFragment.this.lIX.getForumId());
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
                        PbFragment.this.lNk.PW("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                            arrayList = PbFragment.this.lIX.getPbData().dmH();
                        }
                        if (com.baidu.tbadk.core.util.x.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.x.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dPe() != 1)) {
                            PbFragment.this.lNk.PW(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dpx()) {
                                PbFragment.this.lNk.PX(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lNk.PX(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lNk.s(PbFragment.this.lIX.getPbData());
                        }
                    }
                    PbFragment.this.lNk.endLoadData();
                }
                if (fVar != null && fVar.lFX && PbFragment.this.fLQ == 0) {
                    PbFragment.this.fLQ = System.currentTimeMillis() - PbFragment.this.iHN;
                }
                if (!PbFragment.this.dnW().dpZ() || PbFragment.this.dnW().getPbData().getPage().bqh() != 0 || PbFragment.this.dnW().dqA()) {
                    PbFragment.this.lNx = true;
                    return;
                }
                return;
            }
            PbFragment.this.lIX.Hc(1);
            if (PbFragment.this.lMG != null) {
                PbFragment.this.lMG.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dpG() {
            if (PbFragment.this.lIX != null) {
                if (PbFragment.this.lNw == null || !PbFragment.this.lNw.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lNw = (com.baidu.tbadk.editortools.pb.e) dVar.fj(PbFragment.this.getContext());
                    PbFragment.this.lNw.a(PbFragment.this.lMD.getPageContext());
                    PbFragment.this.lNw.a(PbFragment.this.fGo);
                    PbFragment.this.lNw.a(PbFragment.this.fGh);
                    PbFragment.this.lNw.a(PbFragment.this.lMD.getPageContext(), PbFragment.this.lMD.getIntent() == null ? null : PbFragment.this.lMD.getIntent().getExtras());
                    PbFragment.this.lNw.bEJ().kO(true);
                    PbFragment.this.lNk.setEditorTools(PbFragment.this.lNw.bEJ());
                    if (!PbFragment.this.lIX.dqf()) {
                        PbFragment.this.lNw.DR(PbFragment.this.lIX.dpX());
                    }
                    if (PbFragment.this.lIX.dqG()) {
                        PbFragment.this.lNw.DP(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lNk != null) {
                        PbFragment.this.lNw.DP(PbFragment.this.lNk.drR());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lNk.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bHG().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iHN : j;
                if (PbFragment.this.fLQ == 0) {
                    PbFragment.this.fLQ = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fLH, PbFragment.this.createTime, PbFragment.this.fLQ, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fLH = 0L;
                if (hVar != null) {
                    hVar.bHD();
                }
                if (z2) {
                    hVar.fLZ = currentTimeMillis;
                    hVar.ln(true);
                }
                if (!z2 && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null) {
                    int threadType = PbFragment.this.lIX.getPbData().dmF().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.lMT, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.lMT, "from_frs")) {
                                com.baidu.tbadk.n.h hVar2 = new com.baidu.tbadk.n.h();
                                hVar2.setSubType(1000);
                                hVar2.fMb = currentTimeMillis;
                                hVar2.sV(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fMb = currentTimeMillis;
                        dVar.sV(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lOn = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.doZ();
            }
        }
    };
    private final a.InterfaceC0574a lOo = new a.InterfaceC0574a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
        public void g(boolean z, boolean z2, String str) {
            PbFragment.this.lNk.dsq();
            if (z) {
                if (PbFragment.this.lNi != null) {
                    PbFragment.this.lNi.jc(z2);
                }
                PbFragment.this.lIX.vd(z2);
                if (PbFragment.this.lIX.bny()) {
                    PbFragment.this.dpi();
                } else {
                    PbFragment.this.lNk.s(PbFragment.this.lIX.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lNi != null) {
                        if (PbFragment.this.lNi.bnB() != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lIX.getPbData().dmF() != null && PbFragment.this.lIX.getPbData().dmF().brr() != null) {
                            MarkData bnB = PbFragment.this.lNi.bnB();
                            MetaData brr = PbFragment.this.lIX.getPbData().dmF().brr();
                            if (bnB != null && brr != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), brr.getUserId()) && !brr.hadConcerned()) {
                                    PbFragment.this.b(brr);
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
                    PbFragment.this.dpf();
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
            if (!PbFragment.this.GL(PbFragment.this.mLastScrollState) && PbFragment.this.GL(i)) {
                if (PbFragment.this.lNk != null) {
                    PbFragment.this.lNk.dsH();
                    if (PbFragment.this.lNw != null && !PbFragment.this.lNk.drQ()) {
                        PbFragment.this.lNk.vx(PbFragment.this.lNw.bFx());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lNk.drP();
                    }
                }
                if (!PbFragment.this.lMM) {
                    PbFragment.this.lMM = true;
                }
            }
            if (PbFragment.this.lNk != null) {
                PbFragment.this.lNk.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lMG != null) {
                PbFragment.this.lMG.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lMN == null) {
                PbFragment.this.lMN = new com.baidu.tbadk.n.b();
                PbFragment.this.lMN.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lMN.bHz();
            } else {
                PbFragment.this.lMN.bHy();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dNY().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dmH;
            if (PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null && PbFragment.this.lNk != null && PbFragment.this.lNk.dsh() != null) {
                PbFragment.this.lNk.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lMG != null) {
                    PbFragment.this.lMG.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lIX.dqw() && (dmH = PbFragment.this.lIX.getPbData().dmH()) != null && !dmH.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lNk.dsh().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIX.getPbData();
                    if (pbData != null) {
                        if (pbData.dmI() != null && pbData.dmI().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dmJ() != null && pbData.dmJ().hasData()) {
                            headerCount--;
                        }
                        int size = dmH.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.e iwQ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.ggJ.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lIX.dqt();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.mcN != 1002 || bVar.hli) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lNk.a(1, dVar.mSuccess, dVar.nut, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.ggJ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lNk.a(PbFragment.this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nut, false);
                            PbFragment.this.lNk.bf(gVar.nuw);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lNk.a(PbFragment.this.ggJ.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lOp = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c glJ = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dpn()) {
                PbFragment.this.lMD.finish();
            }
            if (!PbFragment.this.lIX.vc(true)) {
                PbFragment.this.lNk.dsr();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lOr = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lOq && PbFragment.this.dpn()) {
                PbFragment.this.dpp();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lNe && PbFragment.this.lNk != null && PbFragment.this.lNk.dte() && PbFragment.this.lIX != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dX("tid", PbFragment.this.lIX.dpX());
                    aqVar.dX("fid", PbFragment.this.lIX.getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lIX.dqa()) {
                        if (!PbFragment.this.lIX.dqd()) {
                            if (PbFragment.this.lIX.dqc()) {
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
                    PbFragment.this.lNe = true;
                }
                if (PbFragment.this.lIX.vb(false)) {
                    PbFragment.this.lNk.dsp();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lIX.getPbData() != null) {
                    PbFragment.this.lNk.dsM();
                }
                PbFragment.this.lOq = true;
            }
        }
    };
    private int lOs = 0;
    private final TbRichTextView.i fWO = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dsh;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lNk.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dX("tid", PbFragment.this.lIX.dpX());
                aqVar.dX("fid", PbFragment.this.lIX.getForumId());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lIX.lKe.dni()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bKY() != null) {
                            ArrayList<TbRichTextImageInfo> bKY = tbRichTextView.getRichText().bKY();
                            int i4 = 0;
                            while (i4 < bKY.size()) {
                                if (bKY.get(i4) != null) {
                                    arrayList.add(bKY.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bKY.get(i4).getSrc()) || str.equals(bKY.get(i4).bLq()) || str.equals(bKY.get(i4).bLn()) || str.equals(bKY.get(i4).bLp()) || str.equals(bKY.get(i4).bLt()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bKY.get(i4).getSrc();
                                    imageUrlData.originalUrl = bKY.get(i4).getSrc();
                                    imageUrlData.isLongPic = bKY.get(i4).bLv();
                                    concurrentHashMap.put(bKY.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.f(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).ot(i3).ji(false).jj(PbFragment.this.lIX.dqq()).d(concurrentHashMap).jk(true).jl(false).jm(PbFragment.this.dpx()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lIX != null) {
                            aVar.AI(PbFragment.this.lIX.getFromForumId());
                            if (PbFragment.this.lIX.getPbData() != null) {
                                aVar.s(PbFragment.this.lIX.getPbData().dmF());
                            }
                        }
                        ImageViewerConfig eS = aVar.eS(PbFragment.this.getPageContext().getPageActivity());
                        eS.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lJl) {
                        TbRichText bG = PbFragment.this.bG(str, i);
                        if (bG != null && PbFragment.this.lOs >= 0 && PbFragment.this.lOs < bG.bKX().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bG.bKX().get(PbFragment.this.lOs));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lJk.size()) {
                                    break;
                                } else if (!aVar2.lJk.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bG.getPostId() != 0 && (dsh = PbFragment.this.lNk.dsh()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dsh.getDataList();
                                if (com.baidu.tbadk.core.util.x.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bG.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bG.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIX.dqF(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lIX.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eMr.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.f(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).AD(aVar2.forumName).AE(aVar2.forumId).AF(aVar2.threadId).ji(aVar2.eMp).jk(true).AG(aVar2.lastId).jj(PbFragment.this.lIX.dqq()).d(concurrentHashMap2).jl(false).jm(PbFragment.this.dpx()).AH(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lIX != null) {
                                aVar3.AI(PbFragment.this.lIX.getFromForumId());
                                if (PbFragment.this.lIX.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lIX.getPbData().dmF());
                                }
                            }
                            ImageViewerConfig eS2 = aVar3.eS(PbFragment.this.getPageContext().getPageActivity());
                            eS2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.x.getItem(aVar2.lJk, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eMr.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).AD(aVar2.forumName).AE(aVar2.forumId).AF(aVar2.threadId).ji(aVar2.eMp).jk(true).AG(aVar2.lJk.get(0)).jj(PbFragment.this.lIX.dqq()).d(concurrentHashMap3).jl(false).jm(PbFragment.this.dpx()).AH(aVar2.postId).jn(false);
                    if (PbFragment.this.lIX != null) {
                        aVar4.AI(PbFragment.this.lIX.getFromForumId());
                        if (PbFragment.this.lIX.getPbData() != null) {
                            aVar4.s(PbFragment.this.lIX.getPbData().dmF());
                        }
                    }
                    ImageViewerConfig eS3 = aVar4.eS(PbFragment.this.getPageContext().getPageActivity());
                    eS3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eS3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lMX = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lOt = false;
    PostData kmq = null;
    private final b.InterfaceC0578b lOu = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kmq != null) {
                if (i == 0) {
                    PbFragment.this.kmq.gV(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.kmq = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.kmq);
                }
            }
        }
    };
    private final b.InterfaceC0578b lOv = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lNG != null && !TextUtils.isEmpty(PbFragment.this.lNH)) {
                if (i == 0) {
                    if (PbFragment.this.lNI == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lNH));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lNH;
                        aVar.pkgId = PbFragment.this.lNI.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lNI.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eLv == null) {
                            PbFragment.this.eLv = new at(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eLv.p(PbFragment.this.lNH, PbFragment.this.lNG.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lNG = null;
                PbFragment.this.lNH = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lME = true;
            return PbFragment.this.dH(view);
        }
    };
    private final NoNetworkView.a jct = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lIX.dqg()) {
                PbFragment.this.dpk();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.jkd.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0727a iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int hkO = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            if (aA(i2) && PbFragment.this.lNk != null && PbFragment.this.lMG != null) {
                PbFragment.this.lMG.qL(true);
                if (Math.abs(i2) > this.hkO) {
                    PbFragment.this.lMG.hideFloatingView();
                }
                if (PbFragment.this.dpn()) {
                    PbFragment.this.lNk.dse();
                    PbFragment.this.lNk.dsf();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            if (aA(i2) && PbFragment.this.lNk != null && PbFragment.this.lMG != null) {
                PbFragment.this.lNk.dsR();
                PbFragment.this.lMG.qL(false);
                PbFragment.this.lMG.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }

        private boolean aA(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a lLH = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lNk.PY(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lOx = -1;
    private int lOy = -1;

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

    public com.baidu.tbadk.editortools.pb.e doK() {
        return this.lNw;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dny() != null) {
            String id = pVar.dny().getId();
            ArrayList<PostData> dmH = this.lIX.getPbData().dmH();
            int i = 0;
            while (true) {
                if (i >= dmH.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmH.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnG = pVar.dnG();
                    postData.KQ(pVar.getTotalCount());
                    if (postData.dPb() == null || dnG == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnG.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.brr() != null && (metaData = postData.getUserMap().get(next.brr().getUserId())) != null) {
                                next.a(metaData);
                                next.yh(true);
                                next.a(getPageContext(), this.lIX.PP(metaData.getUserId()));
                            }
                        }
                        z = dnG.size() != postData.dPb().size();
                        if (postData.dPb() != null && postData.dPb().size() < 2) {
                            postData.dPb().clear();
                            postData.dPb().addAll(dnG);
                        }
                    }
                    if (postData.dOX() != null) {
                        postData.dOY();
                    }
                }
            }
            if (!this.lIX.getIsFromMark() && z) {
                this.lNk.s(this.lIX.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PH(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o dmX = this.lIX.getPbData().dmX();
            if (dmX != null && str.equals(dmX.getAdId())) {
                if (dmX.dOS() != null) {
                    dmX.dOS().legoCard = null;
                }
                this.lIX.getPbData().dmY();
            }
            com.baidu.tieba.tbadkCore.data.o dqm = this.lIX.dqm();
            if (dqm != null && str.equals(dqm.getAdId())) {
                this.lIX.dqn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lNo != null && this.lNo.isShowing()) {
                this.lNo.dismiss();
                this.lNo = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lNo != null) {
                            PbFragment.this.lNo.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lNk.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lNE);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lNE);
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
                this.lNo = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lNo.SY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(int i) {
        bz dmF;
        if (this.lIX != null && this.lIX.getPbData() != null && (dmF = this.lIX.getPbData().dmF()) != null) {
            if (i == 1) {
                PraiseData brc = dmF.brc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (brc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dmF.a(praiseData);
                    } else {
                        dmF.brc().getUser().add(0, metaData);
                        dmF.brc().setNum(dmF.brc().getNum() + 1);
                        dmF.brc().setIsLike(i);
                    }
                }
                if (dmF.brc() != null) {
                    if (dmF.brc().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(dmF.brc().getNum());
                    }
                }
            } else if (dmF.brc() != null) {
                dmF.brc().setIsLike(i);
                dmF.brc().setNum(dmF.brc().getNum() - 1);
                ArrayList<MetaData> user = dmF.brc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dmF.brc().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dmF.brc().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dmF.brc().getNum() + "";
                }
            }
            if (this.lIX.dpZ()) {
                this.lNk.dsh().notifyDataSetChanged();
            } else {
                this.lNk.t(this.lIX.getPbData());
            }
        }
    }

    public static PbFragment doL() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lMD = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lIX.aD(bundle);
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lNw.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lML = System.currentTimeMillis();
        this.lNC = getPageContext();
        final Intent intent = this.lMD.getIntent();
        if (intent != null) {
            this.iHN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lMT = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lMT)) {
                    this.lMT = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lMT)) {
                this.lMH = true;
            }
            this.lOx = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lOy = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lOz = intent.getStringExtra("key_manga_title");
            this.lNr = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lNs = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lNt = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dpn()) {
                this.lMD.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lNK = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lNc = new bi();
            this.lNc.D(intent);
            this.lNM = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lNM == 0) {
                this.lNM = intent.getIntExtra("key_start_from", 0);
            }
            this.lNN = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iHN = System.currentTimeMillis();
        }
        this.fLH = this.lML - this.iHN;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lMJ = 0;
        aC(bundle);
        if (this.lIX.getPbData() != null) {
            this.lIX.getPbData().PB(this.source);
        }
        doO();
        if (intent != null && this.lNk != null) {
            this.lNk.lUn = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lNF == null) {
                    this.lNF = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lNk.Qa("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.lNF, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lIX.getPbData() != null) {
                this.lIX.PS(stringExtra);
            }
        }
        this.jfh = new VoiceManager();
        this.jfh.onCreate(getPageContext());
        initData(bundle);
        this.lNv = new com.baidu.tbadk.editortools.pb.g();
        d(this.lNv);
        this.lNw = (com.baidu.tbadk.editortools.pb.e) this.lNv.fj(getActivity());
        this.lNw.a(this.lMD.getPageContext());
        this.lNw.a(this.fGo);
        this.lNw.a(this.fGh);
        this.lNw.setFrom(1);
        this.lNw.a(this.lMD.getPageContext(), bundle);
        this.lNw.bEJ().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lNw.bEJ().kO(true);
        uN(true);
        this.lNw.a(this.lIX.dqo(), this.lIX.dpX(), this.lIX.dqF());
        registerListener(this.lNS);
        if (!this.lIX.dqf()) {
            this.lNw.DR(this.lIX.dpX());
        }
        if (this.lIX.dqG()) {
            this.lNw.DP(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lNk != null) {
            this.lNw.DP(this.lNk.drR());
        }
        registerListener(this.lNR);
        registerListener(this.lNT);
        registerListener(this.lNU);
        registerListener(this.jgO);
        registerListener(this.lOg);
        registerListener(this.lNQ);
        this.lNu = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nqQ);
        this.lNu.dOH();
        registerListener(this.lNV);
        registerListener(this.fdd);
        this.lIX.dqy();
        registerListener(this.lOn);
        registerListener(this.jgW);
        registerListener(this.lOj);
        if (this.lNk != null && this.lNk.dsV() != null && this.lNk.dsW() != null) {
            this.lMG = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lNk.dsV(), this.lNk.dsW(), this.lNk.drY());
            this.lMG.a(this.lOb);
        }
        if (this.lMF && this.lNk != null && this.lNk.dsW() != null) {
            this.lNk.dsW().setVisibility(8);
        }
        this.lND = new com.baidu.tbadk.core.view.c();
        this.lND.toastTime = 1000L;
        registerListener(this.lOf);
        registerListener(this.lOd);
        registerListener(this.lOe);
        registerListener(this.jom);
        registerListener(this.jgK);
        this.lNW.setSelfListener(true);
        this.lNW.setTag(this.lMD.getUniqueId());
        this.lNW.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lNW);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lNE = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lNE;
        userMuteAddAndDelCustomMessage.setTag(this.lNE);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lNE;
        userMuteCheckCustomMessage.setTag(this.lNE);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lIX.dqD().a(this.lOc);
        this.kSQ = new ar();
        if (this.lNw.bFp() != null) {
            this.kSQ.f(this.lNw.bFp().getInputView());
        }
        this.lNw.a(this.fGi);
        this.jBj = new ShareSuccessReplyToServerModel();
        a(this.lNO);
        this.kON = new com.baidu.tbadk.core.util.al(getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.al.fcU) {
                        PbFragment.this.lNw.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.al.fcV && PbFragment.this.lNk != null && PbFragment.this.lNk.drN() != null && PbFragment.this.lNk.drN().doJ() != null) {
                        PbFragment.this.lNk.drN().doJ().bFN();
                    } else if (i == com.baidu.tbadk.core.util.al.fcW) {
                        PbFragment.this.c(PbFragment.this.lNz);
                    }
                }
            }
        });
        this.lNh = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lNh.w(getUniqueId());
        com.baidu.tieba.s.c.dNY().z(getUniqueId());
        com.baidu.tbadk.core.business.b.boJ().dJ("3", "");
        this.iwL = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lML;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lIX != null) {
            gVar.setForumName(this.lIX.dnP());
            if (this.lIX.getPbData() != null && this.lIX.getPbData().getForum() != null) {
                gVar.a(this.lIX.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lIX);
        }
    }

    public String doM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b doN() {
        return this.lMG;
    }

    private void uN(boolean z) {
        this.lNw.kW(z);
        this.lNw.kX(z);
        this.lNw.kY(z);
    }

    private void doO() {
        this.fpO = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    public ap doP() {
        return this.lNk;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dnW() {
        return this.lIX;
    }

    public void PI(String str) {
        if (this.lIX != null && !StringUtils.isNull(str) && this.lNk != null) {
            this.lNk.vC(true);
            this.lIX.PI(str);
            this.lMR = true;
            this.lNk.dsH();
            this.lNk.dsQ();
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
        this.lMJ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lMJ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        if (this.lNk != null) {
            this.lNk.onPause();
        }
        if (!this.lIX.dqf()) {
            this.lNw.DQ(this.lIX.dpX());
        }
        if (this.lIX != null) {
            this.lIX.dqz();
        }
        com.baidu.tbadk.BdToken.c.bkU().blf();
        MessageManager.getInstance().unRegisterListener(this.jtD);
        cUE();
        MessageManager.getInstance().unRegisterListener(this.lOd);
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean doQ() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lIX.getPbData(), this.lIX.dpZ(), this.lIX.dqx());
        return (a2 == null || a2.brr() == null || a2.brr().getGodUserData() == null || a2.brr().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lMV) {
            this.lMV = false;
            dpt();
        }
        if (doQ()) {
            this.lMO = System.currentTimeMillis();
        } else {
            this.lMO = -1L;
        }
        if (this.lNk != null && this.lNk.getView() != null) {
            if (!this.liC) {
                dpl();
            } else {
                hideLoadingView(this.lNk.getView());
            }
            this.lNk.onResume();
        }
        if (this.lMJ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lNk != null) {
            noNetworkView = this.lNk.drK();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        registerListener(this.jtD);
        this.lNq = false;
        dps();
        registerListener(this.lOd);
        registerListener(this.lOe);
        registerListener(this.lOf);
        if (this.jfV) {
            dpk();
            this.jfV = false;
        }
        dpA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lNk.vr(z);
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
        if (z && this.lNq) {
            this.lNk.dsp();
            this.lIX.vb(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lMO > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dX("obj_duration", (System.currentTimeMillis() - this.lMO) + ""));
            this.lMO = 0L;
        }
        if (doP().drN() != null) {
            doP().drN().onStop();
        }
        if (this.lNk.lUp != null && !this.lNk.lUp.dtR()) {
            this.lNk.lUp.dcR();
        }
        if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().getForum() != null && this.lIX.getPbData().dmF() != null) {
            com.baidu.tbadk.distribute.a.bEw().b(getPageContext().getPageActivity(), "pb", this.lIX.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIX.getPbData().dmF().getId(), 0L));
        }
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dNY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lNd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dNY().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("fid", this.lIX.getPbData().getForumId());
            aqVar.dX("tid", this.lIX.dpX());
            aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lMM && this.lNk != null) {
            this.lMM = true;
            a(false, (PostData) null);
        }
        if (this.lIX != null) {
            this.lIX.cancelLoadData();
            this.lIX.destory();
            if (this.lIX.dqC() != null) {
                this.lIX.dqC().onDestroy();
            }
        }
        if (this.lNw != null) {
            this.lNw.onDestroy();
        }
        if (this.ggJ != null) {
            this.ggJ.cancelLoadData();
        }
        if (this.fpO != null) {
            this.fpO.dOu();
        }
        if (this.lNk != null) {
            this.lNk.onDestroy();
            if (this.lNk.lUp != null) {
                this.lNk.lUp.dcR();
            }
        }
        if (this.lMN != null) {
            this.lMN.bHA();
        }
        if (this.lMG != null) {
            this.lMG.cHs();
        }
        super.onDestroy();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        if (this.lNk != null) {
            this.lNk.dsH();
        }
        MessageManager.getInstance().unRegisterListener(this.lOd);
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.lNE);
        MessageManager.getInstance().unRegisterListener(this.lOg);
        MessageManager.getInstance().unRegisterListener(this.jgW);
        MessageManager.getInstance().unRegisterListener(this.jom);
        MessageManager.getInstance().unRegisterListener(this.lOl);
        MessageManager.getInstance().unRegisterListener(this.lNW);
        this.lNC = null;
        this.lND = null;
        com.baidu.tieba.recapp.c.a.dFO().dFR();
        if (this.lNF != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lNF);
        }
        if (this.lMW != null) {
            this.lMW.cancelLoadData();
        }
        if (this.lNk != null && this.lNk.lUp != null) {
            this.lNk.lUp.dtV();
        }
        if (this.jBj != null) {
            this.jBj.cancelLoadData();
        }
        this.kSQ.onDestroy();
        if (this.lIX != null && this.lIX.dqE() != null) {
            this.lIX.dqE().onDestroy();
        }
        if (this.kON != null) {
            this.kON.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dsh;
        ArrayList<PostData> dou;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bzz() && this.lNk != null && (dsh = this.lNk.dsh()) != null && (dou = dsh.dou()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dou.iterator();
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
                        bVar.izb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eUv == 1 && !TextUtils.isEmpty(id)) {
                    next.eUv = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.izb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lIX == null || this.lIX.getPbData() == null || this.lIX.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lIX.getPbData().getForum().getFirst_class();
                    str3 = this.lIX.getPbData().getForum().getSecond_class();
                    String id2 = this.lIX.getPbData().getForum().getId();
                    str = this.lIX.dpX();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.s.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bzC());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lNk.onChangeSkinType(i);
            if (this.lNw != null && this.lNw.bEJ() != null) {
                this.lNw.bEJ().onChangeSkinType(i);
            }
            if (this.lNk.drK() != null) {
                this.lNk.drK().onChangeSkinType(getPageContext(), i);
            }
            this.kSQ.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ao.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cFA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lNk = new ap(this, this.jhV, this.fyb);
        this.jkd = new com.baidu.tieba.f.b(getActivity());
        this.jkd.a(lOw);
        this.jkd.a(this.iEb);
        this.lNk.setOnScrollListener(this.mOnScrollListener);
        this.lNk.d(this.lOr);
        this.lNk.setListPullRefreshListener(this.glJ);
        this.lNk.uz(com.baidu.tbadk.core.k.bov().isShowImages());
        this.lNk.setOnImageClickListener(this.fWO);
        this.lNk.b(this.mOnLongClickListener);
        this.lNk.g(this.jct);
        this.lNk.a(this.lOp);
        this.lNk.vr(this.mIsLogin);
        if (this.lMD.getIntent() != null) {
            this.lNk.vD(this.lMD.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lNk.drM().setFromForumId(this.lIX.getFromForumId());
        this.lNk.setEditorTools(this.lNw.bEJ());
        this.lNw.DP(this.lNk.drR());
        this.lNk.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lIX.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIX.getPbData().getForum().getId(), PbFragment.this.lIX.getPbData().getForum().getName(), PbFragment.this.lIX.getPbData().dmF().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lNk.vE(this.lIX.dqc());
        this.lNk.Hj(this.lIX.dqI());
        return this.lNk.getView();
    }

    public void doR() {
        if (this.lNk != null && this.lIX != null) {
            if ((this.lIX.getPbData() != null || this.lIX.getPbData().dne() != null) && checkUpIsLogin() && this.lNk.dsh() != null && this.lNk.dsh().doz() != null) {
                this.lNk.dsh().doz().Cy(this.lIX.dpX());
            }
        }
    }

    public void doS() {
        TiebaStatic.log("c12181");
        if (this.lNk != null && this.lIX != null) {
            if ((this.lNk == null || this.lNk.drQ()) && this.lIX.getPbData() != null && this.lIX.getPbData().dne() != null) {
                com.baidu.tieba.pb.data.o dne = this.lIX.getPbData().dne();
                if (checkUpIsLogin()) {
                    if ((!dne.dnA() || dne.bsV() != 2) && this.lNk.dsh() != null && this.lNk.dsh().doz() != null) {
                        this.lNk.dsh().doz().Cy(this.lIX.dpX());
                    }
                    if (System.currentTimeMillis() - this.lMQ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wn(false);
                        this.lMQ = System.currentTimeMillis();
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
                if (postData.getType() != PostData.eTd && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bov().isShowImages()) {
                    return PL(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lIX == null || this.lIX.getPbData() == null) {
                        return true;
                    }
                    if (doP().drN() != null) {
                        doP().drN().doF();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lIX.getPbData().getForum());
                    pVar.setThreadData(this.lIX.getPbData().dmF());
                    pVar.g(postData);
                    doP().drM().d(pVar);
                    doP().drM().setPostId(postData.getId());
                    a(view, postData.brr().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lNw != null) {
                        this.lNk.vx(this.lNw.bFx());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void doT() {
        if (this.lMK == null) {
            this.lMK = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lMK.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lIT = PbFragment.this.lIT.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIT);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lIX.dpX(), PbFragment.this.lIT, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lIT = PbFragment.this.lIT.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIT);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lIX.dpX(), PbFragment.this.lIT, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lIT = PbFragment.this.lIT.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIT);
                        bVar.dismiss();
                    }
                }
            }).pg(b.a.BOTTOM_TO_TOP).ph(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lOm.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).dvX(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lIX = this.lMD.dnW();
        if (this.lIX.dqB() != null) {
            this.lIX.dqB().a(this.lLH);
        }
        if (this.lIX.dqC() != null) {
            this.lIX.dqC().b(this.lNP);
        }
        if (StringUtils.isNull(this.lIX.dpX())) {
            this.lMD.finish();
        } else if ("from_tieba_kuang".equals(this.lMT) && this.lMT != null) {
            this.lIX.Hj(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lNi = com.baidu.tbadk.baseEditMark.a.a(this.lMD);
        if (this.lNi != null) {
            this.lNi.a(this.lOo);
        }
        this.ggJ = new ForumManageModel(this.lMD);
        this.ggJ.setLoadDataCallBack(this.iwQ);
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lOa.setUniqueId(getUniqueId());
        this.lOa.registerListener();
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lNk.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lNE;
        userMuteCheckCustomMessage.setTag(this.lNE);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14000").dX("tid", this.lIX.lQv).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Hx(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lME ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean doU() {
        if (this.lIX == null || this.lIX.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lIX.getPbData().dmF()) || AntiHelper.a(getPageContext(), this.lIX.getPbData().getAnti());
    }

    public void doV() {
        if (checkUpIsLogin() && this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().getForum() != null && !doU()) {
            if (this.lIX.getPbData().dni()) {
                this.lNk.cUf();
                return;
            }
            if (this.jjD == null) {
                this.jjD = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jjD.BA(0);
                this.jjD.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qG(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qH(boolean z) {
                        if (z) {
                            if (PbFragment.this.lNw != null && PbFragment.this.lNw.bEJ() != null) {
                                PbFragment.this.lNw.bEJ().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lNk.cUf();
                        }
                    }
                });
            }
            this.jjD.H(this.lIX.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIX.dpX(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doW() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lIX == null || (pbData = this.lIX.getPbData()) == null) {
            return null;
        }
        return pbData.dmT().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            if (fVar.dmF().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmF().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmF().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !doU() && doX()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lMY);
                this.lMZ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (doP().drN() != null && postData != null) {
                String str3 = "";
                if (postData.dPg() != null) {
                    str3 = postData.dPg().toString();
                }
                doP().drN().PG(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.brr().getName_show(), str3));
            }
            if (this.lIX.getPbData() != null && this.lIX.getPbData().dni()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lMD.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.doP().getListView().smoothScrollBy((PbFragment.this.lMY[1] + PbFragment.this.lMZ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.doP().drN() != null) {
                            PbFragment.this.lNw.bEJ().setVisibility(8);
                            PbFragment.this.doP().drN().j(str, str2, PbFragment.this.doP().drR(), (PbFragment.this.lIX == null || PbFragment.this.lIX.getPbData() == null || PbFragment.this.lIX.getPbData().dmF() == null || !PbFragment.this.lIX.getPbData().dmF().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doJ = PbFragment.this.doP().drN().doJ();
                            if (doJ != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                doJ.a(PbFragment.this.lIX.getPbData().getAnti());
                                doJ.setThreadData(PbFragment.this.lIX.getPbData().dmF());
                            }
                            if (PbFragment.this.kSQ.dtl() == null && PbFragment.this.doP().drN().doJ().bFV() != null) {
                                PbFragment.this.doP().drN().doJ().bFV().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kSQ != null && PbFragment.this.kSQ.dtk() != null) {
                                            if (!PbFragment.this.kSQ.dtk().dXU()) {
                                                PbFragment.this.kSQ.vG(false);
                                            }
                                            PbFragment.this.kSQ.dtk().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kSQ.g(PbFragment.this.doP().drN().doJ().bFV().getInputView());
                                PbFragment.this.doP().drN().doJ().a(PbFragment.this.lNB);
                            }
                        }
                        PbFragment.this.doP().dsQ();
                    }
                }, 0L);
                return;
            }
            if (this.lNy == null) {
                this.lNy = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lNy.BA(1);
                this.lNy.a(new AnonymousClass39(str, str2));
            }
            if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().getForum() != null) {
                this.lNy.H(this.lIX.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIX.dpX(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lOG;
        final /* synthetic */ String lOH;

        AnonymousClass39(String str, String str2) {
            this.lOG = str;
            this.lOH = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qG(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qH(boolean z) {
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
                        PbFragment.this.doP().getListView().smoothScrollBy((PbFragment.this.lMY[1] + PbFragment.this.lMZ) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.doP().drN() != null) {
                            PbFragment.this.lNw.bEJ().setVisibility(8);
                            PbFragment.this.doP().drN().j(AnonymousClass39.this.lOG, AnonymousClass39.this.lOH, PbFragment.this.doP().drR(), (PbFragment.this.lIX == null || PbFragment.this.lIX.getPbData() == null || PbFragment.this.lIX.getPbData().dmF() == null || !PbFragment.this.lIX.getPbData().dmF().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doJ = PbFragment.this.doP().drN().doJ();
                            if (doJ != null && PbFragment.this.lIX != null && PbFragment.this.lIX.getPbData() != null) {
                                doJ.a(PbFragment.this.lIX.getPbData().getAnti());
                                doJ.setThreadData(PbFragment.this.lIX.getPbData().dmF());
                            }
                            if (PbFragment.this.kSQ.dtl() == null && PbFragment.this.doP().drN().doJ().bFV() != null) {
                                PbFragment.this.doP().drN().doJ().bFV().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kSQ != null && PbFragment.this.kSQ.dtk() != null) {
                                            if (!PbFragment.this.kSQ.dtk().dXU()) {
                                                PbFragment.this.kSQ.vG(false);
                                            }
                                            PbFragment.this.kSQ.dtk().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kSQ.g(PbFragment.this.doP().drN().doJ().bFV().getInputView());
                                PbFragment.this.doP().drN().doJ().a(PbFragment.this.lNB);
                            }
                        }
                        PbFragment.this.doP().dsQ();
                    }
                }, 0L);
            }
        }
    }

    public boolean doX() {
        if ((this.lIX.getPbData() != null && this.lIX.getPbData().dni()) || this.kON == null || this.lIX.getPbData() == null || this.lIX.getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.pZ(this.lIX.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean GV(int i) {
        if (this.kON == null || this.lIX.getPbData() == null || this.lIX.getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.aN(this.lIX.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lIX != null && this.lIX.getPbData() != null && postData.dPe() != 1) {
            String dpX = this.lIX.dpX();
            String id = postData.getId();
            int i = 0;
            if (this.lIX.getPbData() != null) {
                i = this.lIX.getPbData().dmU();
            }
            PbActivity.a PM = PM(id);
            if (PM != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dpX, id, "pb", true, null, false, null, i, postData.duP(), this.lIX.getPbData().getAnti(), false, postData.brr() != null ? postData.brr().getIconInfo() : null).addBigImageData(PM.lJk, PM.eMr, PM.eMp, PM.index);
                addBigImageData.setKeyPageStartFrom(this.lIX.dqI());
                addBigImageData.setFromFrsForumId(this.lIX.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lIX.getForumId());
                addBigImageData.setBjhData(this.lIX.dqh());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doY() {
        if (this.lIX.getPbData() == null || this.lIX.getPbData().dmF() == null) {
            return -1;
        }
        return this.lIX.getPbData().dmF().bse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dnW() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dnW().PR(postWriteCallBackData.getPostId());
            this.lNJ = this.lNk.drT();
            this.lIX.dc(this.lNJ, this.lNk.drU());
        }
        this.lNk.dsH();
        this.kSQ.dti();
        if (this.lNw != null) {
            this.lNk.vx(this.lNw.bFx());
        }
        this.lNk.drL();
        this.lNk.vz(true);
        this.lIX.dqt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(boolean z) {
        if (this.lIX != null && this.lIX.lKe != null && this.lIX.lKe.dmF() != null) {
            bz dmF = this.lIX.lKe.dmF();
            dmF.mRecomAbTag = this.lIX.dqT();
            dmF.mRecomWeight = this.lIX.dqR();
            dmF.mRecomSource = this.lIX.dqS();
            dmF.mRecomExtra = this.lIX.dqU();
            if (dmF.getFid() == 0) {
                dmF.setFid(com.baidu.adp.lib.f.b.toLong(this.lIX.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmF, "c13563");
            TbPageTag fw = com.baidu.tbadk.pageInfo.c.fw(getContext());
            if (fw != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fw.locatePage)) {
                a2.dX("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dX("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fw != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fw.locatePage)) {
                a2.dX("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.an("reply_type", 1);
                if (z) {
                    a2.an("obj_type", 2);
                } else {
                    a2.an("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c ft = com.baidu.tbadk.pageExtra.d.ft(getContext());
                if (ft != null) {
                    a2.dX("obj_cur_page", ft.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                    a2.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doZ() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Sy(this.lIX.getForumId()) && this.lIX.getPbData() != null && this.lIX.getPbData().getForum() != null) {
            if (this.lIX.getPbData().getForum().isLike() == 1) {
                this.lIX.dqE().gk(this.lIX.getForumId(), this.lIX.dpX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uP(boolean z) {
        if (this.lIX == null || this.lIX.getPbData() == null) {
            return false;
        }
        return ((this.lIX.getPbData().dmU() != 0) || this.lIX.getPbData().dmF() == null || this.lIX.getPbData().dmF().brr() == null || TextUtils.equals(this.lIX.getPbData().dmF().brr().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uQ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lIX == null || this.lIX.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lIX.getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            bz dmF = pbData.dmF();
            if (dmF != null) {
                if (dmF.bpY() || dmF.bpZ()) {
                    return false;
                }
                if (dmF.btp() || dmF.btq()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dmU() != 0) {
                    return pbData.dmU() != 3;
                }
                List<bv> dnc = pbData.dnc();
                if (com.baidu.tbadk.core.util.x.getCount(dnc) > 0) {
                    for (bv bvVar : dnc) {
                        if (bvVar != null && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uR(boolean z) {
        if (z || this.lIX == null || this.lIX.getPbData() == null) {
            return false;
        }
        return ((this.lIX.getPbData().getForum() != null && this.lIX.getPbData().getForum().isBlockBawuDelete) || this.lIX.getPbData().dmU() == 0 || this.lIX.getPbData().dmU() == 3) ? false : true;
    }

    public void dpa() {
        com.baidu.tieba.pb.data.f pbData;
        bz dmF;
        boolean z = true;
        if (this.lIX != null && this.lIX.getPbData() != null && (dmF = (pbData = this.lIX.getPbData()).dmF()) != null && dmF.brr() != null) {
            this.lNk.drL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmF.brr().getUserId());
            ad adVar = new ad();
            int dmU = this.lIX.getPbData().dmU();
            if (dmU == 1 || dmU == 3) {
                adVar.lSD = true;
                adVar.lSJ = dmF.brm() == 1;
            } else {
                adVar.lSD = false;
            }
            if (GW(dmU)) {
                adVar.lSE = true;
                adVar.lSI = dmF.brn() == 1;
            } else {
                adVar.lSE = false;
            }
            if (dmU == 1002 && !equals) {
                adVar.lSK = true;
            }
            adVar.lSB = uQ(equals);
            adVar.lSF = dpb();
            adVar.lSC = uR(equals);
            adVar.FF = this.lIX.dpZ();
            adVar.lSy = true;
            adVar.lSx = uP(equals);
            adVar.lSw = equals && this.lNk.dsw();
            adVar.lSH = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lSG = true;
            adVar.isHostOnly = this.lIX.getHostMode();
            adVar.lSA = true;
            if (dmF.brI() == null) {
                adVar.lSz = true;
            } else {
                adVar.lSz = false;
            }
            if (pbData.dni()) {
                adVar.lSy = false;
                adVar.lSA = false;
                adVar.lSz = false;
                adVar.lSD = false;
                adVar.lSE = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dni()) {
                z = false;
            }
            adVar.lSL = z;
            this.lNk.lUp.a(adVar);
        }
    }

    private boolean dpb() {
        if (this.lIX != null && this.lIX.dpZ()) {
            return this.lIX.getPageData() == null || this.lIX.getPageData().bqh() != 0;
        }
        return false;
    }

    public boolean GW(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lIX.getPbData().getUserData() == null || (forumToolAuth = this.lIX.getPbData().getUserData().getForumToolAuth()) == null) {
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
    public PbModel.a dpc() {
        return this.lOm;
    }

    public int dpd() {
        if (doP() == null || doP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = doP().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) nVar).Ws == com.baidu.tieba.pb.data.n.lHi) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpe() {
        if (doP() == null || doP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = doP().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nru) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dpk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpf() {
        if (this.lIX != null && this.lIX.lKe != null && this.lIX.lKe.dmF() != null) {
            bz dmF = this.lIX.lKe.dmF();
            dmF.mRecomAbTag = this.lIX.dqT();
            dmF.mRecomWeight = this.lIX.dqR();
            dmF.mRecomSource = this.lIX.dqS();
            dmF.mRecomExtra = this.lIX.dqU();
            dmF.eWD = this.lIX.dqf();
            if (dmF.getFid() == 0) {
                dmF.setFid(com.baidu.adp.lib.f.b.toLong(this.lIX.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmF, "c13562");
            TbPageTag fw = com.baidu.tbadk.pageInfo.c.fw(getContext());
            if (fw != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(fw.locatePage)) {
                a2.dX("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dX("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (fw != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(fw.locatePage)) {
                a2.dX("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.Bn(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bo(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jH(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.fcZ.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lIX.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).btY();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lNk.dsq();
        this.lIX.vd(z);
        if (this.lNi != null) {
            this.lNi.jc(z);
            if (markData != null) {
                this.lNi.a(markData);
            }
        }
        if (this.lIX.bny()) {
            dpi();
        } else {
            this.lNk.s(this.lIX.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GL(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ(String str) {
        if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().dni()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lIX.dpX(), str);
            bz dmF = this.lIX.getPbData().dmF();
            if (dmF.bpY()) {
                format = format + "&channelid=33833";
            } else if (dmF.bto()) {
                format = format + "&channelid=33842";
            } else if (dmF.bpZ()) {
                format = format + "&channelid=33840";
            }
            PK(format);
            return;
        }
        this.lNh.Qk(str);
    }

    private void PK(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lIX.dqf()) {
                    antiData.setBlock_forum_name(this.lIX.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lIX.getPbData().getForum().getId());
                    antiData.setUser_name(this.lIX.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lIX.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (doP() != null) {
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
        if (AntiHelper.bP(i, str)) {
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
            DW(str);
        } else {
            this.lNk.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.nut) ? bVar.nut : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bo(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jH(true);
                aVar.b(getPageContext());
                aVar.btY();
            } else {
                this.lNk.a(0, bVar.mSuccess, bVar.nut, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iMd == 1) {
                    ArrayList<PostData> dmH = this.lIX.getPbData().dmH();
                    int size = dmH.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmH.get(i).getId())) {
                            i++;
                        } else {
                            dmH.remove(i);
                            break;
                        }
                    }
                    this.lIX.getPbData().dmF().oN(this.lIX.getPbData().dmF().bri() - 1);
                    this.lNk.s(this.lIX.getPbData());
                } else if (bVar.iMd == 0) {
                    dpg();
                } else if (bVar.iMd == 2) {
                    ArrayList<PostData> dmH2 = this.lIX.getPbData().dmH();
                    int size2 = dmH2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmH2.get(i2).dPb().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmH2.get(i2).dPb().get(i3).getId())) {
                                i3++;
                            } else {
                                dmH2.get(i2).dPb().remove(i3);
                                dmH2.get(i2).dPd();
                                z2 = true;
                                break;
                            }
                        }
                        dmH2.get(i2).To(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lNk.s(this.lIX.getPbData());
                    }
                    a(bVar, this.lNk);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lNk.a(this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nut, false);
            if (gVar.mSuccess) {
                this.lNl = true;
                if (i == 2 || i == 3) {
                    this.lNm = true;
                    this.lNn = false;
                } else if (i == 4 || i == 5) {
                    this.lNm = false;
                    this.lNn = true;
                }
                if (i == 2) {
                    this.lIX.getPbData().dmF().oQ(1);
                    this.lIX.setIsGood(1);
                } else if (i == 3) {
                    this.lIX.getPbData().dmF().oQ(0);
                    this.lIX.setIsGood(0);
                } else if (i == 4) {
                    this.lIX.getPbData().dmF().oP(1);
                    this.lIX.Hb(1);
                } else if (i == 5) {
                    this.lIX.getPbData().dmF().oP(0);
                    this.lIX.Hb(0);
                }
                this.lNk.c(this.lIX.getPbData(), this.lIX.dpZ());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.nut)) {
                string = gVar.nut;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dpg() {
        if (this.lIX.dqa() || this.lIX.dqc()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lIX.dpX());
            PbActivity pbActivity = this.lMD;
            PbActivity pbActivity2 = this.lMD;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lIX.dpX()));
        if (dpj()) {
            this.lMD.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dok() {
        this.lMD.dok();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dmR;
        boolean z = false;
        if (this.lNk != null) {
            this.lNk.dsH();
        }
        if (this.lIX != null && this.lIX.getPbData() != null && !this.lIX.getPbData().dni()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lIX.getPbData().dmF().getId();
            if (this.lIX.isShareThread() && this.lIX.getPbData().dmF().eVB != null) {
                historyMessage.threadName = this.lIX.getPbData().dmF().eVB.showText;
            } else {
                historyMessage.threadName = this.lIX.getPbData().dmF().getTitle();
            }
            if (this.lIX.isShareThread() && !dnO()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lIX.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmH = this.lIX.getPbData().dmH();
            int dss = this.lNk != null ? this.lNk.dss() : 0;
            if (dmH != null && dss >= 0 && dss < dmH.size()) {
                historyMessage.postID = dmH.get(dss).getId();
            }
            historyMessage.isHostOnly = this.lIX.getHostMode();
            historyMessage.isSquence = this.lIX.dpZ();
            historyMessage.isShareThread = this.lIX.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lNw != null) {
            this.lNw.onDestroy();
        }
        if (this.lMI && doP() != null) {
            doP().dta();
        }
        if (this.lIX != null && (this.lIX.dqa() || this.lIX.dqc())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lIX.dpX());
            if (this.lNl) {
                if (this.lNn) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lIX.cxO());
                }
                if (this.lNm) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lIX.getIsGood());
                }
            }
            if (this.lIX.getPbData() != null && System.currentTimeMillis() - this.lML >= 40000 && (dmR = this.lIX.getPbData().dmR()) != null && !com.baidu.tbadk.core.util.x.isEmpty(dmR.getDataList())) {
                intent.putExtra("guess_like_data", dmR);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lNK);
            }
            PbActivity pbActivity = this.lMD;
            PbActivity pbActivity2 = this.lMD;
            pbActivity.setResult(-1, intent);
        }
        if (dpj()) {
            if (this.lIX != null && this.lNk != null && this.lNk.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lIX.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dmN() && !this.lMR && pbData.lFS == null) {
                        aj drw = aj.drw();
                        com.baidu.tieba.pb.data.f dqi = this.lIX.dqi();
                        Parcelable onSaveInstanceState = this.lNk.getListView().onSaveInstanceState();
                        boolean dpZ = this.lIX.dpZ();
                        boolean hostMode = this.lIX.getHostMode();
                        if (this.lNk.drY() != null && this.lNk.drY().getVisibility() == 0) {
                            z = true;
                        }
                        drw.a(dqi, onSaveInstanceState, dpZ, hostMode, z);
                        if (this.lNJ >= 0 || this.lIX.dqK() != null) {
                            aj.drw().q(this.lIX.dqK());
                            aj.drw().p(this.lIX.dqL());
                            aj.drw().Hl(this.lIX.dqM());
                        }
                    }
                }
            } else {
                aj.drw().reset();
            }
            dok();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lNk == null || !this.lNk.Hr(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lMD;
        if (i == 0) {
            this.lNk.drL();
            this.lNk.drN().doF();
            this.lNk.vz(false);
        }
        this.lNk.drP();
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
                        this.lNw.resetData();
                        this.lNw.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lNw.c(writeData);
                        com.baidu.tbadk.editortools.m sv = this.lNw.bEJ().sv(6);
                        if (sv != null && sv.fDH != null) {
                            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lMD;
                        if (i == -1) {
                            this.lNw.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lNk.drN() != null && this.lNk.drN().doJ() != null) {
                            com.baidu.tbadk.editortools.pb.h doJ = this.lNk.drN().doJ();
                            doJ.setThreadData(this.lIX.getPbData().dmF());
                            doJ.c(writeData);
                            doJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m sv2 = doJ.bEJ().sv(6);
                            if (sv2 != null && sv2.fDH != null) {
                                sv2.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lMD;
                            if (i == -1) {
                                doJ.bFN();
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
        this.lNw.onActivityResult(i, i2, intent);
        if (this.lMW != null) {
            this.lMW.onActivityResult(i, i2, intent);
        }
        if (doP().drN() != null) {
            doP().drN().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dph();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.drw().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lIX != null) {
                                PbFragment.this.lIX.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dEB().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lIX != null) {
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
                        aqVar.dX("tid", intent.getStringExtra("tid"));
                        aqVar.dX("post_id", intent.getStringExtra("pid"));
                        aqVar.an("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dEB().E(getPageContext());
                        doZ();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jBj != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jBj.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bCh() {
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
                    this.lNk.uE(false);
                    if (this.lIX.getPbData() != null && this.lIX.getPbData().dmF() != null && this.lIX.getPbData().dmF().brL() != null) {
                        this.lIX.getPbData().dmF().brL().setStatus(2);
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
                        this.lNz = emotionImageData;
                        if (GV(com.baidu.tbadk.core.util.al.fcW)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lMX != null) {
                        this.lNk.dO(this.lMX);
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
            if (this.lMW == null) {
                this.lMW = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lMD);
                this.lMW.b(this.fGh);
                this.lMW.c(this.fGo);
            }
            this.lMW.a(emotionImageData, dnW(), dnW().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dph() {
        MarkData Hi;
        if (this.lNi != null) {
            if (this.lIX.getPbData() != null && this.lIX.getPbData().dni()) {
                Hi = this.lIX.Hi(0);
            } else {
                Hi = this.lIX.Hi(this.lNk.dst());
            }
            if (Hi != null) {
                if (!Hi.isApp() || (Hi = this.lIX.Hi(this.lNk.dst() + 1)) != null) {
                    this.lNk.dso();
                    this.lNi.a(Hi);
                    if (!this.lNi.bny()) {
                        this.lNi.bnA();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lNi.bnz();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpi() {
        com.baidu.tieba.pb.data.f pbData = this.lIX.getPbData();
        this.lIX.vd(true);
        if (this.lNi != null) {
            pbData.PA(this.lNi.bnx());
        }
        this.lNk.s(pbData);
    }

    private boolean dpj() {
        if (this.lIX == null) {
            return true;
        }
        if (this.lIX.getPbData() == null || !this.lIX.getPbData().dni()) {
            if (this.lIX.bny()) {
                final MarkData dqs = this.lIX.dqs();
                if (dqs == null || !this.lIX.getIsFromMark()) {
                    return true;
                }
                final MarkData Hi = this.lIX.Hi(this.lNk.dss());
                if (Hi == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqs);
                    this.lMD.setResult(-1, intent);
                    return true;
                } else if (Hi.getPostId() == null || Hi.getPostId().equals(dqs.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqs);
                    this.lMD.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Bo(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lNi != null) {
                                if (PbFragment.this.lNi.bny()) {
                                    PbFragment.this.lNi.bnz();
                                    PbFragment.this.lNi.jc(false);
                                }
                                PbFragment.this.lNi.a(Hi);
                                PbFragment.this.lNi.jc(true);
                                PbFragment.this.lNi.bnA();
                            }
                            dqs.setPostId(Hi.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqs);
                            PbFragment.this.lMD.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dok();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqs);
                            PbFragment.this.lMD.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dok();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lNk != null && PbFragment.this.lNk.getView() != null) {
                                PbFragment.this.lNk.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dqs);
                                PbFragment.this.lMD.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dok();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.btY();
                    return false;
                }
            } else if (this.lIX.getPbData() == null || this.lIX.getPbData().dmH() == null || this.lIX.getPbData().dmH().size() <= 0 || !this.lIX.getIsFromMark()) {
                return true;
            } else {
                this.lMD.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lNk == null) {
            return null;
        }
        return this.lNk.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLF() {
        if (this.lNk == null) {
            return 0;
        }
        return this.lNk.dsF();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLG() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLS */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bov().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bov().isShowImages()) {
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
        return this.fWD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bLH() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLI() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czF */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bov().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bov().isShowImages()) {
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
                    gifView.bGo();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fWE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bLJ() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpH */
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
                    ((PlayVoiceBntNew) view).cfr();
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
        return this.fZT;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bLL() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpI */
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
        return this.fZV;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bym() {
        if (this.fof == null) {
            this.fof = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fof;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lMP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.Qb(str) && this.lIX != null && this.lIX.dpX() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").an("obj_param1", 1).dX("post_id", this.lIX.dpX()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fCE = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.dtn().f(getPageContext(), str);
        }
        this.lMP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dtn().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lMP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lNk != null && this.lNk.dsV() != null && rect.top <= this.lNk.dsV().getHeight()) {
            rect.top += this.lNk.dsV().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lIX.getPbData();
            TbRichText bG = bG(str, i);
            if (bG != null && (tbRichTextData = bG.bKX().get(this.lOs)) != null) {
                aVar.postId = String.valueOf(bG.getPostId());
                aVar.lJk = new ArrayList<>();
                aVar.eMr = new ConcurrentHashMap<>();
                if (!tbRichTextData.bLd().bLo()) {
                    aVar.lJl = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lJk.add(c2);
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
                    imageUrlData.mIsReserver = this.lIX.dqq();
                    imageUrlData.mIsSeeHost = this.lIX.getHostMode();
                    aVar.eMr.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmF() != null) {
                            aVar.threadId = pbData.dmF().getId();
                        }
                        aVar.eMp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lJl = true;
                int size = pbData.dmH().size();
                this.lOt = false;
                aVar.index = -1;
                int a2 = pbData.dmO() != null ? a(pbData.dmO().dPg(), bG, i, i, aVar.lJk, aVar.eMr) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmH().get(i2);
                    if (postData.getId() == null || pbData.dmO() == null || pbData.dmO().getId() == null || !postData.getId().equals(pbData.dmO().getId())) {
                        a2 = a(postData.dPg(), bG, a2, i, aVar.lJk, aVar.eMr);
                    }
                }
                if (aVar.lJk.size() > 0) {
                    aVar.lastId = aVar.lJk.get(aVar.lJk.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmF() != null) {
                        aVar.threadId = pbData.dmF().getId();
                    }
                    aVar.eMp = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return null;
        }
        return tbRichTextData.bLd().bLt();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return 0L;
        }
        return tbRichTextData.bLd().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return false;
        }
        return tbRichTextData.bLd().bLu();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLd() == null) {
            return false;
        }
        return tbRichTextData.bLd().bLv();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bLd;
        String str;
        if (tbRichText == tbRichText2) {
            this.lOt = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bKX().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bKX().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bLd().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bLd().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bLd().bLo()) {
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
                            if (tbRichTextData != null && (bLd = tbRichTextData.bLd()) != null) {
                                String bLq = bLd.bLq();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bLd.bLr();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bLq;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lIX.dpX(), -1L);
                                imageUrlData.mIsReserver = this.lIX.dqq();
                                imageUrlData.mIsSeeHost = this.lIX.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lOt) {
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
        PostData dmO;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lIX.brz())) {
                z = true;
            }
            MarkData o = this.lIX.o(postData);
            if (this.lIX.getPbData() != null && this.lIX.getPbData().dni() && (dmO = dmO()) != null) {
                o = this.lIX.o(dmO);
            }
            if (o != null) {
                this.lNk.dso();
                if (this.lNi != null) {
                    this.lNi.a(o);
                    if (!z) {
                        this.lNi.bnA();
                    } else {
                        this.lNi.bnz();
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
        if (this.lNk != null) {
            if (this.lNk.dpP()) {
                return true;
            }
            this.lNk.dtd();
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
                    this.lNG = ((TbImageView) view).getBdImage();
                    this.lNH = ((TbImageView) view).getUrl();
                    if (this.lNG == null || TextUtils.isEmpty(this.lNH)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNI = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lNG = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lNH = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lNI = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lNG = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lNH = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNI = null;
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
                    this.lNk.a(this.lOv, this.lNG.isGif());
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
        this.kmq = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kmq == null) {
            return true;
        }
        if (this.kmq.dPe() == 1 && dI(view)) {
            this.lNk.a(this.lOv, this.lNG.isGif());
            return true;
        } else if (this.lNi == null) {
            return true;
        } else {
            if (!this.lNi.bny() || this.kmq.getId() == null || !this.kmq.getId().equals(this.lIX.brz())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dnW().getPbData() != null && dnW().getPbData().dni();
            if (this.kmq.dPe() == 1) {
                if (!z3) {
                    this.lNk.a(this.lOu, z, false);
                }
                return true;
            }
            if (this.lNp == null) {
                this.lNp = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lNp.a(this.lOh);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dI(view) && !z3;
                boolean z5 = (!dI(view) || this.lNG == null || this.lNG.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lNp));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lNp));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lNp);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.kmq);
                    gVar2.eXH.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lNp);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lNp);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.kmq);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eXH.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lNf) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lNp);
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
                        gVar3.eXH.setTag(sparseArray5);
                        arrayList.add(gVar3);
                    } else {
                        if ((uP(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lNp);
                            gVar4.eXH.setTag(str);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lNp);
                            gVar6.eXH.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lNp);
                        gVar5.eXH.setTag(sparseArray6);
                    } else if (z10) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        if (this.lIX.getPbData().dmU() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lNp);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lNp);
                        }
                        gVar6.eXH.setTag(sparseArray7);
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                }
                if (com.baidu.tbadk.a.d.bmU()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kmq.btl(), sparseArray2, this.lNp), this.lME));
                    this.lNp.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kmq));
                } else {
                    list = arrayList;
                }
                this.lNp.k(list, true);
                this.lNo = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lNp);
                this.lNo.SY();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dX("tid", this.lIX.lQv).dX("fid", this.lIX.getForumId()).dX("uid", this.lIX.getPbData().dmF().brr().getUserId()).dX("post_id", this.lIX.bFl()).an("obj_source", z2 ? 2 : 1));
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
        if (this.lIX == null || this.lIX.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lIX.getPbData();
        if (pbData.dmO() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dmO());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmH = pbData.dmH();
            c(pbData, dmH);
            return c(dmH, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c ft;
        int i = 1;
        if (agreeData != null) {
            if (this.fgY == null) {
                this.fgY = new com.baidu.tbadk.core.message.a();
            }
            if (this.fgI == null) {
                this.fgI = new com.baidu.tieba.tbadkCore.data.e();
                this.fgI.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 5;
            dVar.eOF = 8;
            dVar.eOE = 2;
            if (dnW() != null) {
                dVar.eOD = dnW().dqI();
            }
            dVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eOG = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eOG = 1;
                        i = 0;
                    }
                }
                ft = com.baidu.tbadk.pageExtra.d.ft(getContext());
                if (ft != null) {
                    agreeData.objSource = ft.getCurrentPageKey();
                }
                this.fgY.a(agreeData, i, getUniqueId(), false);
                this.fgY.a(agreeData, this.fgI);
                if (this.lIX == null && this.lIX.getPbData() != null) {
                    this.fgY.a(dpE(), dVar, agreeData, this.lIX.getPbData().dmF());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eOG = 1;
            }
            i = 0;
            ft = com.baidu.tbadk.pageExtra.d.ft(getContext());
            if (ft != null) {
            }
            this.fgY.a(agreeData, i, getUniqueId(), false);
            this.fgY.a(agreeData, this.fgI);
            if (this.lIX == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dmT() != null && fVar.dmT().lHx != null && (list = fVar.dmT().lHx) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bKX;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPg = arrayList.get(i2).dPg();
            if (dPg != null && (bKX = dPg.bKX()) != null) {
                int size = bKX.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bKX.get(i4) != null && bKX.get(i4).getType() == 8) {
                        i3++;
                        if (bKX.get(i4).bLd().bLq().equals(str) || bKX.get(i4).bLd().bLr().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bKX.get(i4).bLd().getWidth() * equipmentDensity;
                            int height = bKX.get(i4).bLd().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lOs = i4;
                            return dPg;
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
            this.lIT = str;
            if (this.lMK == null) {
                doT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lMK.getItemView(1).setVisibility(8);
            } else {
                this.lMK.getItemView(1).setVisibility(0);
            }
            this.lMK.bua();
            this.lMP = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jfh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpk() {
        hideNetRefreshView(this.lNk.getView());
        dpl();
        if (this.lIX.dql()) {
            this.lNk.dso();
        }
        this.lNk.dsz();
    }

    private void dpl() {
        showLoadingView(this.lNk.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lNk.dsV().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFA() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
        if (this.lMD != null) {
            this.lMD.cFA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, doY(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLK() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpJ */
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
        return this.fZU;
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

    public void cFB() {
        if (this.lMD != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lMD.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lMD.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cDZ() {
        if (this.lIX == null || this.lIX.getPbData() == null) {
            return null;
        }
        return this.lIX.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.lVE)).intValue();
            if (intValue == ap.lVF) {
                if (!this.ggJ.dPZ()) {
                    this.lNk.dsj();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.ggJ.TC(com.baidu.tbadk.core.util.at.S(jSONArray));
                    }
                    this.ggJ.a(this.lIX.getPbData().getForum().getId(), this.lIX.getPbData().getForum().getName(), this.lIX.getPbData().dmF().getId(), str, intValue3, intValue2, booleanValue, this.lIX.getPbData().dmF().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.lVG || intValue == ap.lVI) {
                if (this.lIX.dqB() != null) {
                    this.lIX.dqB().GQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.lVG) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lNE);
        userMuteAddAndDelCustomMessage.setTag(this.lNE);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean PL(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0857a
    public void uS(boolean z) {
        this.lNq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpm() {
        ArrayList<PostData> dmH;
        int count;
        if (this.lIX == null || this.lIX.getPbData() == null || this.lIX.getPbData().dmH() == null || (count = com.baidu.tbadk.core.util.x.getCount((dmH = this.lIX.getPbData().dmH()))) == 0) {
            return "";
        }
        if (this.lIX.dqq()) {
            Iterator<PostData> it = dmH.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPe() == 1) {
                    return next.getId();
                }
            }
        }
        int dss = this.lNk.dss();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(dmH, dss);
        if (postData == null || postData.brr() == null) {
            return "";
        }
        if (this.lIX.PP(postData.brr().getUserId())) {
            return postData.getId();
        }
        for (int i = dss - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(dmH, i);
            if (postData2 == null || postData2.brr() == null || postData2.brr().getUserId() == null) {
                break;
            } else if (this.lIX.PP(postData2.brr().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dss + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(dmH, i2);
            if (postData3 == null || postData3.brr() == null || postData3.brr().getUserId() == null) {
                return "";
            }
            if (this.lIX.PP(postData3.brr().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        this.lMP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a PM(String str) {
        String str2;
        if (this.lIX.getPbData() == null || this.lIX.getPbData().dmH() == null || this.lIX.getPbData().dmH().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lIX.getPbData().dmH().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lIX.getPbData().dmH().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lIX.getPbData().dmH().get(i);
        if (postData.dPg() == null || postData.dPg().bKX() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPg().bKX().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bLd() != null) {
                    str2 = next.bLd().bLq();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dpn() {
        return (!this.lMF && this.lOx == -1 && this.lOy == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lOA = sVar;
            this.lMF = true;
            this.lNk.drZ();
            this.lNk.PZ(this.lOz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpo() {
        if (this.lOA != null) {
            if (this.lOx == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lOA.getCartoonId(), this.lOx, 0)));
                this.lMD.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpp() {
        if (this.lOA != null) {
            if (this.lOy == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lOA.getCartoonId(), this.lOy, 0)));
                this.lMD.finish();
            }
        }
    }

    public int dpq() {
        return this.lOx;
    }

    public int dpr() {
        return this.lOy;
    }

    private void cUE() {
        if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().dmF() != null && this.lIX.getPbData().dmF().bpW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dps() {
        if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().dmF() != null && this.lIX.getPbData().dmF().bpW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dpt() {
        if (this.isPaused) {
            this.lMV = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lIX.getPbData() != null && this.lIX.getPbData().dmF() != null && this.lIX.getPbData().dmF().bqX() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lIX.getPbData().dmF().bqX().getThreadId(), this.lIX.getPbData().dmF().bqX().getTaskId(), this.lIX.getPbData().dmF().bqX().getForumId(), this.lIX.getPbData().dmF().bqX().getForumName(), this.lIX.getPbData().dmF().brm(), this.lIX.getPbData().dmF().brn())));
            this.lMH = true;
            this.lMD.finish();
        }
    }

    public String dpu() {
        return this.lMT;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dpv() {
        return this.lNg;
    }

    public void uT(boolean z) {
        this.lMU = z;
    }

    public boolean boW() {
        if (this.lIX != null) {
            return this.lIX.dqa();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bo(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lNC).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lNC.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lNC).btY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lNC != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNC.getPageActivity());
            aVar.Bo(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lNC).btY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lNk.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNC.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bo(this.lNC.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bo(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lNk.showLoadingDialog();
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
        aVar.b(this.lNC).btY();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.Qb(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jLX) {
            this.jLX = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lNk != null) {
                this.lNk.onConfigurationChanged(configuration);
            }
            if (this.lNo != null) {
                this.lNo.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dpx() {
        if (this.lIX != null) {
            return this.lIX.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lIX.getPbData().dmT().lHx;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPb().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPb().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPb().remove(i2);
                    list.get(i).dPd();
                    z = true;
                    break;
                }
            }
            list.get(i).To(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lIX.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dny().getId();
        List<PostData> list = this.lIX.getPbData().dmT().lHx;
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
                ArrayList<PostData> dnG = pVar.dnG();
                postData.KQ(pVar.getTotalCount());
                if (postData.dPb() != null) {
                    postData.dPb().clear();
                    postData.dPb().addAll(dnG);
                }
            }
        }
        if (!this.lIX.getIsFromMark()) {
            this.lNk.s(this.lIX.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dnN() {
        return this.lMD.dnN();
    }

    public boolean dnO() {
        if (this.lIX == null) {
            return false;
        }
        return this.lIX.dnO();
    }

    public void uU(boolean z) {
        this.lMS = z;
    }

    public boolean dpy() {
        return this.lMS;
    }

    public void dpz() {
        if (this.lNk != null) {
            this.lNk.drL();
            cFB();
        }
    }

    public PostData dmO() {
        return this.lNk.b(this.lIX.lKe, this.lIX.dpZ());
    }

    public void onBackPressed() {
        if (this.lNL != null && !this.lNL.isEmpty()) {
            int size = this.lNL.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lNL.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lNL == null) {
                this.lNL = new ArrayList();
            }
            if (!this.lNL.contains(aVar)) {
                this.lNL.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lNL == null) {
                this.lNL = new ArrayList();
            }
            if (!this.lNL.contains(aVar)) {
                this.lNL.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lNL != null) {
            this.lNL.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.af.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpA() {
        if (this.lIX != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lIX.dpX())) {
            com.baidu.tbadk.BdToken.c.bkU().p(com.baidu.tbadk.BdToken.b.eEL, com.baidu.adp.lib.f.b.toLong(this.lIX.dpX(), 0L));
        }
    }

    public bi dpB() {
        return this.lNc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PN(String str) {
        if (this.lIX != null && this.lIX.getPbData() != null && this.lIX.getPbData().dmF() != null && this.lIX.getPbData().dmF().bqa()) {
            bz dmF = this.lIX.getPbData().dmF();
            int i = 0;
            if (dmF.bpY()) {
                i = 1;
            } else if (dmF.bpZ()) {
                i = 2;
            } else if (dmF.btp()) {
                i = 3;
            } else if (dmF.btq()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.an("obj_source", 4);
            aqVar.an("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(final int i) {
        com.baidu.tbadk.util.ac.a(new com.baidu.tbadk.util.ab<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: boq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.doY(), i2, PbFragment.this.lIX);
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
    public PbFragment dpC() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpD() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpE() {
        return this.lMD;
    }
}
