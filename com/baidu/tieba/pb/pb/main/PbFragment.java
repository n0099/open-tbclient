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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0824a {
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
    private String lIU;
    private PbActivity lME;
    private com.baidu.tieba.pb.pb.main.b.b lMH;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lMX;
    private View lMY;
    private EmotionImageData lNA;
    private com.baidu.adp.base.f lND;
    private com.baidu.tbadk.core.view.c lNE;
    private BdUniqueId lNF;
    private Runnable lNG;
    private com.baidu.adp.widget.ImageView.a lNH;
    private String lNI;
    private TbRichTextMemeInfo lNJ;
    private List<a> lNM;
    public String lNO;
    int lNa;
    private bi lNd;
    private com.baidu.tieba.pb.pb.report.a lNi;
    private com.baidu.tbadk.core.dialog.i lNp;
    private com.baidu.tbadk.core.dialog.k lNq;
    private boolean lNr;
    private com.baidu.tieba.tbadkCore.data.f lNv;
    private com.baidu.tbadk.editortools.pb.g lNw;
    private com.baidu.tbadk.editortools.pb.e lNx;
    private com.baidu.tieba.frs.profession.permission.c lNz;
    private String lOA;
    private com.baidu.tbadk.core.data.s lOB;
    private boolean lOr;
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
    private static final b.a lOx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cZ(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dnL();
            } else {
                com.baidu.tieba.pb.a.b.dnK();
            }
        }
    };
    boolean lMF = true;
    private boolean lMG = false;
    private boolean lMI = false;
    private boolean isPaused = false;
    private boolean liC = false;
    private boolean lMJ = true;
    private int lMK = 0;
    private com.baidu.tbadk.core.dialog.b lML = null;
    private long iHN = -1;
    private long fLQ = 0;
    private long lMM = 0;
    private long createTime = 0;
    private long fLH = 0;
    private boolean lMN = false;
    private com.baidu.tbadk.n.b lMO = null;
    private long lMP = 0;
    private boolean lMQ = false;
    private long lMR = 0;
    private int jLX = 1;
    private String fGe = null;
    private boolean lMS = false;
    private boolean isFullScreen = false;
    private boolean lMT = false;
    private String lMU = "";
    private boolean lMV = true;
    private boolean lMW = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lMZ = new int[2];
    private int lNb = -1;
    private int lNc = -1;
    public BdUniqueId lNe = BdUniqueId.gen();
    private boolean lNf = false;
    private boolean lNg = com.baidu.tbadk.a.d.bmF();
    private PbInterviewStatusView.a lNh = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lNl.vs(!PbFragment.this.lMV);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.bnx()) {
                        PbFragment.this.dph();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lIY = null;
    private com.baidu.tbadk.baseEditMark.a lNj = null;
    private ForumManageModel ggJ = null;
    private com.baidu.tbadk.coreExtra.model.a fcZ = null;
    private com.baidu.tieba.pb.data.q lNk = null;
    private ShareSuccessReplyToServerModel jBj = null;
    private ap lNl = null;
    private boolean lNm = false;
    private boolean lNn = false;
    private boolean lNo = false;
    private boolean gnZ = false;
    private boolean lNs = false;
    private boolean lNt = false;
    private boolean lNu = false;
    private boolean lNy = false;
    public boolean lNB = false;
    private com.baidu.tbadk.editortools.pb.c fGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bFn() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (PbFragment.this.kSQ == null || PbFragment.this.kSQ.dti() == null || !PbFragment.this.kSQ.dti().dXS()) {
                return !PbFragment.this.GV(com.baidu.tbadk.core.util.al.fcU);
            }
            PbFragment.this.showToast(PbFragment.this.kSQ.dti().dXU());
            if (PbFragment.this.lNx != null && (PbFragment.this.lNx.bFD() || PbFragment.this.lNx.bFE())) {
                PbFragment.this.lNx.a(false, PbFragment.this.kSQ.dtl());
            }
            PbFragment.this.kSQ.vF(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lNC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (PbFragment.this.kSQ == null || PbFragment.this.kSQ.dtj() == null || !PbFragment.this.kSQ.dtj().dXS()) {
                return !PbFragment.this.GV(com.baidu.tbadk.core.util.al.fcV);
            }
            PbFragment.this.showToast(PbFragment.this.kSQ.dtj().dXU());
            if (PbFragment.this.lNl != null && PbFragment.this.lNl.drM() != null && PbFragment.this.lNl.drM().doI() != null && PbFragment.this.lNl.drM().doI().bFE()) {
                PbFragment.this.lNl.drM().doI().a(PbFragment.this.kSQ.dtl());
            }
            PbFragment.this.kSQ.vG(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jfV = false;
    private int lNK = 0;
    private int lNL = -1;
    public int lNN = 0;
    private final a lNP = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lNl != null && PbFragment.this.lNl.drM() != null) {
                r drM = PbFragment.this.lNl.drM();
                if (drM.doG()) {
                    drM.doF();
                    return true;
                }
            }
            if (PbFragment.this.lNl != null && PbFragment.this.lNl.dsN()) {
                PbFragment.this.lNl.dsO();
                return true;
            }
            return false;
        }
    };
    private final ab.a lNQ = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void ai(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lNl.showToast(str);
            }
        }
    };
    private final CustomMessageListener lNR = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lIY != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lNx != null) {
                    PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                }
                PbFragment.this.lNl.drO();
                PbFragment.this.lNl.dsG();
            }
        }
    };
    CustomMessageListener jgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lIY.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lNl != null && PbFragment.this.lIY != null) {
                    PbFragment.this.lNl.b(PbFragment.this.lIY.getPbData(), PbFragment.this.lIY.dpY(), PbFragment.this.lIY.dqw(), PbFragment.this.lNl.getSkinType());
                }
                if (PbFragment.this.lNl != null && PbFragment.this.lNl.dsg() != null) {
                    PbFragment.this.lNl.dsg().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lNS = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lNl != null) {
                    if (booleanValue) {
                        PbFragment.this.lNl.dsj();
                    } else {
                        PbFragment.this.lNl.dsk();
                    }
                }
            }
        }
    };
    private CustomMessageListener lNT = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lNx != null) {
                    PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                }
                PbFragment.this.lNl.vz(false);
            }
        }
    };
    private CustomMessageListener lNU = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lNV = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNl != null && PbFragment.this.lNl.dsg() != null) {
                PbFragment.this.lNl.dsg().notifyDataSetChanged();
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
                PbFragment.this.dpz();
            }
        }
    };
    private View.OnClickListener fGR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fGe);
        }
    };
    private CustomMessageListener lNW = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ah)) {
                com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) customResponsedMessage.getData();
                az.a aVar = new az.a();
                aVar.giftId = ahVar.id;
                aVar.giftName = ahVar.name;
                aVar.thumbnailUrl = ahVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIY.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lIY.dqn() != null && PbFragment.this.lIY.dqn().getUserIdLong() == ahVar.toUserId) {
                        PbFragment.this.lNl.a(ahVar.sendCount, PbFragment.this.lIY.getPbData(), PbFragment.this.lIY.dpY(), PbFragment.this.lIY.dqw());
                    }
                    if (pbData.dmG() != null && pbData.dmG().size() >= 1 && pbData.dmG().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dmG().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIY.dpW(), 0L);
                        if (j == ahVar.postId && j2 == ahVar.threadId) {
                            az dPl = pbData.dmG().get(0).dPl();
                            if (dPl == null) {
                                dPl = new az();
                            }
                            ArrayList<az.a> bqh = dPl.bqh();
                            if (bqh == null) {
                                bqh = new ArrayList<>();
                            }
                            bqh.add(0, aVar);
                            dPl.setTotal(ahVar.sendCount + dPl.getTotal());
                            dPl.D(bqh);
                            pbData.dmG().get(0).a(dPl);
                            PbFragment.this.lNl.dsg().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lNX = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                PbFragment.this.lIY.getPbData().dmY();
                PbFragment.this.lIY.dqs();
                if (PbFragment.this.lNl.dsg() != null) {
                    PbFragment.this.lNl.s(PbFragment.this.lIY.getPbData());
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
            if (customResponsedMessage != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.PI(str);
                PbFragment.this.lIY.dqs();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lIY.getPbData().dmG() != null) {
                    ArrayList<PostData> dmG = PbFragment.this.lIY.getPbData().dmG();
                    Iterator<PostData> it = dmG.iterator();
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
                        dmG.remove(oVar);
                        if (PbFragment.this.lNl.dsg() != null && PbFragment.this.lNl.dsg().getDataList() != null) {
                            PbFragment.this.lNl.dsg().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lNl.getListView() != null && PbFragment.this.lNl.getListView().getData() != null) {
                            PbFragment.this.lNl.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lNl.dsg() != null) {
                            PbFragment.this.lNl.dsg().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lNl.dsg() != null) {
                    PbFragment.this.lNl.s(PbFragment.this.lIY.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lNY = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dtB()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lNZ = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void ai(List<String> list) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list) && PbFragment.this.lNl != null) {
                PbFragment.this.lNl.fp(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lOa = false;
    private PraiseModel lOb = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void FO(String str) {
            PbFragment.this.lOa = false;
            if (PbFragment.this.lOb != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIY.getPbData();
                if (pbData.dmE().brb().getIsLike() == 1) {
                    PbFragment.this.Br(0);
                } else {
                    PbFragment.this.Br(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dmE()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lOa = false;
            if (PbFragment.this.lOb != null && str != null) {
                if (AntiHelper.bP(i, str)) {
                    AntiHelper.bs(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lOc = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void uV(boolean z) {
            PbFragment.this.uT(z);
            if (PbFragment.this.lNl.dsT() != null && z) {
                PbFragment.this.lNl.vs(false);
            }
            PbFragment.this.lNl.vu(z);
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
                        if (PbFragment.this.dmN().brq() != null && PbFragment.this.dmN().brq().getGodUserData() != null) {
                            PbFragment.this.dmN().brq().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null) {
                            PbFragment.this.lIY.getPbData().dmE().brq().setHadConcerned(updateAttentionMessage.isAttention());
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
            if (tipEvent.pageId > 0 && PbFragment.this.lME.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lOd = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lNl.cni();
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
                    com.baidu.tieba.k.a.cQm();
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
                PbFragment.this.doR();
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
                        if (PbFragment.this.lNl.doP() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dX("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dnM() != null && PbFragment.this.dnM().iOE != null) {
                                PbFragment.this.dnM().iOE.onClick(view);
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
                if (PbFragment.this.lNx != null) {
                    PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                }
                PbFragment.this.lNl.drO();
                PbFragment.this.lNl.dsG();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lOe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNF) {
                PbFragment.this.lNl.cni();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIY.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dmU().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lNE.showSuccessToast(PbFragment.this.lND.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lND.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.DX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dpv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lND.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lNE.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lOf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNF) {
                PbFragment.this.lNl.cni();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lNE.showSuccessToast(PbFragment.this.lND.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lND.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lNE.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lOg = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lNF) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lNl.cni();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nEU;
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
                    PbFragment.this.lNl.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lOh = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNl.drP() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.doR();
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
            PbFragment.this.cFA();
            com.baidu.tbadk.core.data.ax pageData = PbFragment.this.lIY.getPageData();
            int pageNum = PbFragment.this.lNl.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bqa()) {
                PbFragment.this.lNl.dsG();
                PbFragment.this.cFz();
                PbFragment.this.lNl.dsn();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lIY.Hc(PbFragment.this.lNl.getPageNum());
                    if (PbFragment.this.lMH != null) {
                        PbFragment.this.lMH.showFloatingView();
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
    private k.c lOi = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lNp != null) {
                PbFragment.this.lNp.dismiss();
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
                    if (com.baidu.tbadk.a.d.bmQ() || com.baidu.tbadk.a.d.bmR()) {
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
                    if (com.baidu.tbadk.a.d.bmQ() || com.baidu.tbadk.a.d.bmR()) {
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
                    if (PbFragment.this.lNH != null && !TextUtils.isEmpty(PbFragment.this.lNI)) {
                        if (PbFragment.this.lNJ == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lNI));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lNI;
                            aVar.pkgId = PbFragment.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lNJ.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lNH = null;
                        PbFragment.this.lNI = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lNH != null && !TextUtils.isEmpty(PbFragment.this.lNI)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eLv == null) {
                                PbFragment.this.eLv = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eLv.p(PbFragment.this.lNI, PbFragment.this.lNH.getImageByte());
                            PbFragment.this.lNH = null;
                            PbFragment.this.lNI = null;
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
                        if (PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null && PbFragment.this.lIY.getPbData().dmE().brq().getUserId() != null && PbFragment.this.lNj != null) {
                            int h = PbFragment.this.h(PbFragment.this.lIY.getPbData());
                            bz dmE = PbFragment.this.lIY.getPbData().dmE();
                            if (dmE.bpX()) {
                                i2 = 2;
                            } else if (dmE.bpY()) {
                                i2 = 3;
                            } else if (dmE.bto()) {
                                i2 = 4;
                            } else {
                                i2 = dmE.btp() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dX("tid", PbFragment.this.lIY.lQw).an("obj_locate", 2).dX("obj_id", PbFragment.this.lIY.getPbData().dmE().brq().getUserId()).an("obj_type", PbFragment.this.lNj.bnx() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
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
                        PbFragment.this.PK((String) tag);
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
                        PbFragment.this.lNl.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.lNl.dN(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lNl.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.btk() != null) {
                            PbFragment.this.d(postData.btk());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lOj = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            PbFragment.this.lNl.dsG();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lIY == null || PbFragment.this.lIY.isLoading) {
                    return false;
                }
                PbFragment.this.cFz();
                PbFragment.this.lNl.dsn();
                if (PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().lFR != null && PbFragment.this.lIY.getPbData().lFR.size() > i) {
                    int intValue = PbFragment.this.lIY.getPbData().lFR.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dX("tid", PbFragment.this.lIY.dpX()).dX("fid", PbFragment.this.lIY.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).an("obj_type", Ha(intValue)));
                    if (PbFragment.this.lIY.Hh(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lNl.vn(true);
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
                    if (view == PbFragment.this.lNl.dsC()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lIY.vb(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lNl.dso();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drn()) {
                        if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().dro()) {
                            if (view == PbFragment.this.lNl.lUq.fOs) {
                                if (PbFragment.this.lNl.vw(PbFragment.this.lIY.dqe())) {
                                    PbFragment.this.cFz();
                                    return;
                                }
                                PbFragment.this.lMJ = false;
                                PbFragment.this.lMI = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lME, PbFragment.this.lNl.lUq.fOs);
                                PbFragment.this.lME.finish();
                            } else if (view != PbFragment.this.lNl.dsl() && (PbFragment.this.lNl.lUq.dtO() == null || (view != PbFragment.this.lNl.lUq.dtO().drm() && view != PbFragment.this.lNl.lUq.dtO().drk()))) {
                                if (view == PbFragment.this.lNl.dsK()) {
                                    if (PbFragment.this.lIY != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIY.getPbData().dmE().brp().getLink());
                                    }
                                } else if (view != PbFragment.this.lNl.lUq.maR) {
                                    if (view == PbFragment.this.lNl.lUq.jvO) {
                                        if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                            ArrayList<PostData> dmG = PbFragment.this.lIY.getPbData().dmG();
                                            if ((dmG == null || dmG.size() <= 0) && PbFragment.this.lIY.dpY()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dX("tid", PbFragment.this.lIY.dpW()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", PbFragment.this.lIY.getForumId()));
                                            if (!PbFragment.this.lNl.dsY()) {
                                                PbFragment.this.lNl.drO();
                                            }
                                            PbFragment.this.doZ();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lNl.uI(true);
                                            PbFragment.this.lNl.drO();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lNl.dsj();
                                                PbFragment.this.cFz();
                                                PbFragment.this.lNl.dsn();
                                                PbFragment.this.lIY.PP(PbFragment.this.dpl());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drj()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lNl.lUq.dtO() != null && view == PbFragment.this.lNl.lUq.dtO().dri()) {
                                                PbFragment.this.lNl.lUq.bes();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.GZ(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drg()) {
                                                    if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drq()) {
                                                        if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drh()) {
                                                            if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drr()) {
                                                                if (PbFragment.this.lNl.dsT() == view) {
                                                                    if (PbFragment.this.lNl.dsT().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lIY.getPbData();
                                                                        if (pbData2 != null && pbData2.dmE() != null && pbData2.dmE().bqW() != null) {
                                                                            String bqM = pbData2.dmE().bqW().bqM();
                                                                            if (StringUtils.isNull(bqM)) {
                                                                                bqM = pbData2.dmE().bqW().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dX("obj_id", bqM));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gs("c10725", null);
                                                                    }
                                                                    PbFragment.this.dps();
                                                                } else if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drp()) {
                                                                    if (PbFragment.this.lNl.lUq.dtO() != null && view == PbFragment.this.lNl.lUq.dtO().drl()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lNl.b(PbFragment.this.lIY.getPbData(), PbFragment.this.lIY.dpY(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lNl.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lNl.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lNl.lUq.bes();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dX("tid", PbFragment.this.lIY.dpW());
                                                                            aqVar.dX("fid", PbFragment.this.lIY.getForumId());
                                                                            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.an("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                PbFragment.this.lNl.dsG();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dPp() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.nsq != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwm = postData.nsq.bwm();
                                                                                        bwm.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bwm.an("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bwm.an("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bwm);
                                                                                    }
                                                                                    String dpW = PbFragment.this.lIY.dpW();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lIY.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lIY.getPbData().dmT();
                                                                                    }
                                                                                    PbFragment.this.cFz();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a PN = PbFragment.this.PN(id);
                                                                                        if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PN != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpW, id, "pb", true, null, true, null, i3, postData.duO(), PbFragment.this.lIY.getPbData().getAnti(), false, postData.brq().getIconInfo()).addBigImageData(PN.lJl, PN.eMr, PN.eMp, PN.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lIY.dqH());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lIY.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lIY.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lIY.dqg());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a PN2 = PbFragment.this.PN(id);
                                                                                        if (postData != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PN2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpW, id, "pb", true, null, false, str2, i3, postData.duO(), PbFragment.this.lIY.getPbData().getAnti(), false, postData.brq().getIconInfo()).addBigImageData(PN2.lJl, PN2.eMr, PN2.eMp, PN2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lIY.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lIY.dqg());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lIY.dqH());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lIY.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").an("obj_locate", 3).dX("fid", PbFragment.this.lIY.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lIY != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dX("tid", PbFragment.this.lIY.dpW());
                                                                            aqVar2.dX("fid", PbFragment.this.lIY.getForumId());
                                                                            aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.an("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nsq != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwm2 = postData3.nsq.bwm();
                                                                                        bwm2.delete("obj_locate");
                                                                                        bwm2.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bwm2);
                                                                                    }
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                        String dpW2 = PbFragment.this.lIY.dpW();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lIY.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lIY.getPbData().dmT();
                                                                                        }
                                                                                        PbActivity.a PN3 = PbFragment.this.PN(id2);
                                                                                        if (PN3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dpW2, id2, "pb", true, null, false, null, i4, postData3.duO(), PbFragment.this.lIY.getPbData().getAnti(), false, postData3.brq().getIconInfo()).addBigImageData(PN3.lJl, PN3.eMr, PN3.eMp, PN3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lIY.dqH());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lIY.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lIY.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lIY.dqg());
                                                                                            if (PbFragment.this.lIY.getPbData().dnn() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lIY.getPbData().dnn().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lIY.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lIY.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lIY.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lIY.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lIY.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lIY.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lIY.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lIY.getPbData().getForum().getUser_level());
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
                                                                        if (PbFragment.this.lIY != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dX("tid", PbFragment.this.lIY.dpW());
                                                                                aqVar3.dX("fid", PbFragment.this.lIY.getForumId());
                                                                                aqVar3.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.an("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nsq != null) {
                                                                                        com.baidu.tbadk.core.util.aq bwm3 = postData4.nsq.bwm();
                                                                                        bwm3.delete("obj_locate");
                                                                                        bwm3.an("obj_locate", 8);
                                                                                        TiebaStatic.log(bwm3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dX("tid", PbFragment.this.lIY.dpX()).dX("fid", PbFragment.this.lIY.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData4.getId()).an("obj_source", 1).an("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.doO().drL() != null && postData4.brq() != null && postData4.dPd() != 1) {
                                                                                        if (PbFragment.this.doO().drM() != null) {
                                                                                            PbFragment.this.doO().drM().doE();
                                                                                        }
                                                                                        if (PbFragment.this.lNg && postData4.dPa() != null && postData4.dPa().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lIY.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lIY.getPbData().dmE());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.doO().drL().d(pVar);
                                                                                            PbFragment.this.doO().drL().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.brq().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lNx != null) {
                                                                                                PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
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
                                                                        if (view != PbFragment.this.lNl.dof()) {
                                                                            if (view == PbFragment.this.lNl.lUq.dtP()) {
                                                                                PbFragment.this.lNl.dsu();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (ceVar = (ce) view.getTag()) != null && !StringUtils.isNull(ceVar.btL())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        be.bwu().b(PbFragment.this.getPageContext(), new String[]{ceVar.btL()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dX("tid", PbFragment.this.lIY.lQw));
                                                                                            }
                                                                                            if (PbFragment.this.lNq == null) {
                                                                                                PbFragment.this.lNq = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lNq.a(PbFragment.this.lOi);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dI(view);
                                                                                            if (!PbFragment.this.dI(view) || PbFragment.this.lNH == null || !PbFragment.this.lNH.isGif()) {
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
                                                                                                if (postData5.dPf() != null && postData5.dPf().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lNq);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eXH.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.kmq = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lIY.getPbData().bnx()) {
                                                                                                String bnw = PbFragment.this.lIY.getPbData().bnw();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bnw) && bnw.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lNq);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lNq);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.kmq);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eXH.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lNq);
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
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNq);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNq);
                                                                                                                gVar2.eXH.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lNq);
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
                                                                                                            if (PbFragment.this.lIY.getPbData().dmT() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNq);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNq);
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
                                                                                                    PbFragment.this.lNq.bB(arrayList);
                                                                                                    PbFragment.this.lNp = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNq);
                                                                                                    PbFragment.this.lNp.SY();
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
                                                                                            PbFragment.this.lNq.bB(arrayList);
                                                                                            PbFragment.this.lNp = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNq);
                                                                                            PbFragment.this.lNp.SY();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lIY.getPbData().dmE().getActUrl());
                                                                                        if (PbFragment.this.lIY.getPbData().dmE().bsd() != 1) {
                                                                                            if (PbFragment.this.lIY.getPbData().dmE().bsd() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dX("fid", PbFragment.this.lIY.getPbData().getForumId()).dX("tid", PbFragment.this.lIY.getPbData().getThreadId()).dX("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lIY.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lNl.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bvq().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lNl.drO();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.doX() == 1 && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dX("fid", PbFragment.this.lIY.getPbData().getForumId()).dX("tid", PbFragment.this.lIY.getPbData().getThreadId()).dX("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.doX() == 1 && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dX("fid", PbFragment.this.lIY.getPbData().getForumId()).dX("tid", PbFragment.this.lIY.getPbData().getThreadId()).dX("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dpn();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dpo();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dna() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lIY.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dX("fid", pbData3.getForumId()));
                                                                                        be.bwu().b(PbFragment.this.getPageContext(), new String[]{pbData3.dna().dno()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dna() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lIY.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dX("fid", pbData4.getForumId()));
                                                                                        be.bwu().b(PbFragment.this.getPageContext(), new String[]{pbData4.dna().dno()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lNK >= 0) {
                                                                                        if (PbFragment.this.lIY != null) {
                                                                                            PbFragment.this.lIY.dqI();
                                                                                        }
                                                                                        if (PbFragment.this.lIY != null && PbFragment.this.lNl.dsg() != null) {
                                                                                            PbFragment.this.lNl.dsg().a(PbFragment.this.lIY.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lNK = 0;
                                                                                        if (PbFragment.this.lIY != null) {
                                                                                            PbFragment.this.lNl.getListView().setSelection(PbFragment.this.lIY.dqL());
                                                                                            PbFragment.this.lIY.dc(0, 0);
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
                                                                                    if (PbFragment.this.lNl.getListView() != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lNl.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lNl.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dne = PbFragment.this.lIY.getPbData().dne();
                                                                                        boolean z8 = PbFragment.this.lNl.drN() != null && PbFragment.this.lNl.drN().isVertical();
                                                                                        boolean dsD = PbFragment.this.lNl.dsD();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (dne && PbFragment.this.lNl.drN() != null && PbFragment.this.lNl.drN().bUV() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lNl.drN().dty();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lNl.drN().bUV().getHeight() - PbFragment.this.lNl.drN().dty());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.PO("c13568");
                                                                                        if ((PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brh() <= 0) || (dsD && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.doU();
                                                                                                if (PbFragment.this.lIY.getPbData().dmE().brq() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIY.lQw).dX("fid", PbFragment.this.lIY.getPbData().getForumId()).an("obj_locate", 2).dX("uid", PbFragment.this.lIY.getPbData().dmE().brq().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dne) {
                                                                                                if (PbFragment.this.lNl.lVB != null && PbFragment.this.lNl.lVB.lWJ != null && PbFragment.this.lNl.lVB.lWJ.getView() != null) {
                                                                                                    if (PbFragment.this.lNl.lVB.lWJ.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dpd();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lNl.drN() != null && PbFragment.this.lNl.drN().bUV() != null) {
                                                                                                            i5 = PbFragment.this.lNl.drN().bUV().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lNl.lVB.lWJ.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lNl.drX() != null) {
                                                                                                z10 = PbFragment.this.lNl.drX().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lNl.lVB != null && PbFragment.this.lNl.lVB.lWJ != null && PbFragment.this.lNl.lVB.lWJ.getView() != null && PbFragment.this.lNl.lVB.lWJ.getView().getParent() != null && PbFragment.this.lNl.lUq != null && PbFragment.this.lNl.lUq.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lNl.lVB.lWJ.getView().getTop() - PbFragment.this.lNl.lUq.mNavigationBar.getBottom() < PbFragment.this.lNl.lVB.lWJ.lTQ.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dsD) {
                                                                                                PbFragment.this.lNb = firstVisiblePosition;
                                                                                                PbFragment.this.lNc = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lNl.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lNb > 0) {
                                                                                                if (PbFragment.this.lNl.getListView().getChildAt(PbFragment.this.lNb) != null) {
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollToPosition(PbFragment.this.lNb, PbFragment.this.lNc, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lNl.getListView().setSelectionFromTop(PbFragment.this.lNb, PbFragment.this.lNc + equipmentHeight);
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dpd = PbFragment.this.dpd();
                                                                                                if (PbFragment.this.dpc() != -1) {
                                                                                                    dpd--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dpd < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.x.getCount(PbFragment.this.lNl.getListView().getData()) - 1) + PbFragment.this.lNl.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dpd;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!dne || PbFragment.this.lNl.drN() == null) ? (PbFragment.this.lNl.lUq == null || PbFragment.this.lNl.lUq.mNavigationBar == null) ? dimens : (PbFragment.this.lNl.lUq.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lNl.drN().dtx() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lNl.lVB == null || PbFragment.this.lNl.lVB.lWJ == null || PbFragment.this.lNl.lVB.lWJ.getView() == null || PbFragment.this.lNl.lVB.lWJ.getView().getParent() == null) {
                                                                                                    PbFragment.this.lNl.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lNl.getListView().smoothScrollBy(PbFragment.this.lNl.lVB.lWJ.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIY.lQw).dX("fid", PbFragment.this.lIY.getPbData().getForumId()).an("obj_locate", 2).dX("uid", PbFragment.this.lIY.getPbData().dmE().brq().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.lIY.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lIY.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lIY.dnO()) || PbFragment.this.lIY.getAppealInfo() == null) {
                                                                                                PbFragment.this.lME.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lIY.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lIY.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lME.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dnO = PbFragment.this.lIY.dnO();
                                                                                        if (PbFragment.this.lIY.dpZ() && dnO != null && dnO.equals(name)) {
                                                                                            PbFragment.this.lME.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lIY.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dX("tid", PbFragment.this.lIY.dpW());
                                                                                        aqVar4.dX("fid", PbFragment.this.lIY.getForumId());
                                                                                        aqVar4.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lIY.getPbData().dmE() != null) {
                                                                                            aqVar4.dX(IntentConfig.NID, PbFragment.this.lIY.getPbData().dmE().bpO());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar = (bz) view.getTag();
                                                                                        if (PbFragment.this.lIY.dqH() == 3 && PbFragment.this.dnN() && PbFragment.this.lIY.getPbData() != null && com.baidu.tbadk.core.util.x.isEmpty(PbFragment.this.lIY.getPbData().dnb())) {
                                                                                            PbFragment.this.lME.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar.bru(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dX("tid", bzVar.getId());
                                                                                        aqVar5.w("fid", bzVar.getFid());
                                                                                        aqVar5.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dX(IntentConfig.NID, bzVar.bpO());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lIY != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dX("tid", PbFragment.this.lIY.dpW());
                                                                                        aqVar6.dX("fid", PbFragment.this.lIY.getForumId());
                                                                                        aqVar6.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.an("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lIY.getPbData();
                                                                                        if (PbFragment.this.lNk == null) {
                                                                                            PbFragment.this.lNk = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").w("forum_id", j2).bwn();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lOm);
                                                                                        PbFragment.this.lNk.I(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dX("fid", PbFragment.this.lIY.getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dX("obj_source", "PB_card").dX("tid", PbFragment.this.lIY.dpW()).an("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bz) {
                                                                                        bz bzVar2 = (bz) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bzVar2.bru(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                                            PbFragment.this.fpO.gr(bzVar3.bru(), String.valueOf(bzVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dX("page_type", PageStayDurationConstants.PageName.PB).an("obj_isad", 1).an("obj_floor", 1).an("obj_adlocate", 10).an("obj_locate", 11).w("obj_id", bzVar3.getFid()).dX("tid", bzVar3.getId()).an("thread_type", bzVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                    aqVar7.dX("tid", PbFragment.this.lIY.dpW());
                                                                                    aqVar7.dX("fid", PbFragment.this.lIY.getForumId());
                                                                                    aqVar7.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    aqVar7.an("obj_locate", 7);
                                                                                    TiebaStatic.log(aqVar7);
                                                                                    PbFragment.this.lMF = false;
                                                                                    PbFragment.this.dH(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIY.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIY.dpW(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lIY.getPbData().dmE().brK())));
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
                                                                            if (PbFragment.this.lNq == null) {
                                                                                PbFragment.this.lNq = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lNq.a(PbFragment.this.lOi);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dnV().getPbData() != null && PbFragment.this.dnV().getPbData().dnh();
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
                                                                                if (postData6.btk() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.btk().hasAgree && postData6.bsU() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lNq);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eXH.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lNq);
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
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNq);
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
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNq);
                                                                                            gVar12.eXH.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lNq);
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
                                                                                            if (PbFragment.this.lIY.getPbData().dmT() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lNq);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lNq);
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
                                                                                PbFragment.this.lNq.bB(arrayList2);
                                                                                PbFragment.this.lNp = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lNq);
                                                                                PbFragment.this.lNp.SY();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lNl.dsG();
                                                                    SparseArray<Object> b3 = PbFragment.this.lNl.b(PbFragment.this.lIY.getPbData(), PbFragment.this.lIY.dpY(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIY.getPbData().getForum().getId(), PbFragment.this.lIY.getPbData().getForum().getName(), PbFragment.this.lIY.getPbData().dmE().getId(), String.valueOf(PbFragment.this.lIY.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.lNl.lUq.dtN();
                                                            }
                                                        } else if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null) {
                                                            PbFragment.this.lNl.lUq.bes();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.PK(PbFragment.this.lIY.getPbData().dmE().brG());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lNl.dsG();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lIY.dqq()));
                                                                return;
                                                            }
                                                            PbFragment.this.cFz();
                                                            PbFragment.this.lNl.dsn();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lIY.getPbData().lFR == null || PbFragment.this.lIY.getPbData().lFR.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lIY.getPbData().lFR.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lIY.getPbData().lFR.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lIY.getPbData().lFR.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lIY.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lIY.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lIY.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lIY.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i9));
                                                                    if (PbFragment.this.lIY.getPbData().lFR != null && PbFragment.this.lIY.getPbData().lFR.size() > i8) {
                                                                        i8 = PbFragment.this.lIY.getPbData().lFR.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean Hh = PbFragment.this.lIY.Hh(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lIY.dqq()));
                                                                    if (Hh) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lNl.vn(true);
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
                                                    PbFragment.this.lNl.dsG();
                                                    if (PbFragment.this.dnV().getPbData().lFS != 2) {
                                                        if (PbFragment.this.lIY.getPageData() != null) {
                                                            PbFragment.this.lNl.a(PbFragment.this.lIY.getPageData(), PbFragment.this.ltH);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lIY.getPbData()) != null) {
                                                bz dmE = pbData.dmE();
                                                if (dmE != null && dmE.brq() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIY.lQw).dX("fid", pbData.getForumId()).an("obj_locate", 4).dX("uid", dmE.brq().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (dmE != null) {
                                                    if (dmE.bpX()) {
                                                        i8 = 2;
                                                    } else if (dmE.bpY()) {
                                                        i8 = 3;
                                                    } else if (dmE.bto()) {
                                                        i8 = 4;
                                                    } else if (dmE.btp()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar8.dX("tid", PbFragment.this.lIY.dpW());
                                                aqVar8.dX("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar8.dX("fid", PbFragment.this.lIY.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar8.an("obj_locate", 5);
                                                } else {
                                                    aqVar8.an("obj_locate", 6);
                                                }
                                                aqVar8.an("obj_name", i8);
                                                aqVar8.an("obj_type", 1);
                                                if (dmE != null) {
                                                    if (dmE.bpX()) {
                                                        aqVar8.an("obj_type", 10);
                                                    } else if (dmE.bpY()) {
                                                        aqVar8.an("obj_type", 9);
                                                    } else if (dmE.btp()) {
                                                        aqVar8.an("obj_type", 8);
                                                    } else if (dmE.bto()) {
                                                        aqVar8.an("obj_type", 7);
                                                    } else if (dmE.isShareThread) {
                                                        aqVar8.an("obj_type", 6);
                                                    } else if (dmE.threadType == 0) {
                                                        aqVar8.an("obj_type", 1);
                                                    } else if (dmE.threadType == 40) {
                                                        aqVar8.an("obj_type", 2);
                                                    } else if (dmE.threadType == 49) {
                                                        aqVar8.an("obj_type", 3);
                                                    } else if (dmE.threadType == 54) {
                                                        aqVar8.an("obj_type", 4);
                                                    } else {
                                                        aqVar8.an("obj_type", 5);
                                                    }
                                                    aqVar8.an(IntentConfig.CARD_TYPE, dmE.bts());
                                                    aqVar8.dX(IntentConfig.RECOM_SOURCE, dmE.mRecomSource);
                                                    aqVar8.dX("ab_tag", dmE.mRecomAbTag);
                                                    aqVar8.dX("weight", dmE.mRecomWeight);
                                                    aqVar8.dX("extra", dmE.mRecomExtra);
                                                    aqVar8.dX(IntentConfig.NID, dmE.bpO());
                                                    if (dmE.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(dmE.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar8.dX("obj_param6", dmE.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar8.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dpD() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dpD(), aqVar8);
                                                }
                                                TiebaStatic.log(aqVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dmG2 = PbFragment.this.lIY.getPbData().dmG();
                                                    if ((dmG2 != null && dmG2.size() > 0) || !PbFragment.this.lIY.dpY()) {
                                                        PbFragment.this.lNl.dsG();
                                                        PbFragment.this.cFz();
                                                        if (pbData.dna() != null && !StringUtils.isNull(pbData.dna().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dX("fid", PbFragment.this.lIY.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dmE)) {
                                                            if (PbFragment.this.lNl != null) {
                                                                PbFragment.this.lNl.dsJ();
                                                                PbFragment.this.lNl.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lNl.showLoadingDialog();
                                                                PbFragment.this.lIY.dqC().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                            PbFragment.this.lNl.dsG();
                                            if (PbFragment.this.lNl.lUq.dtO() != null && view == PbFragment.this.lNl.lUq.dtO().drj() && !PbFragment.this.lNl.dsY()) {
                                                PbFragment.this.lNl.drO();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cFz();
                                                PbFragment.this.lNl.dsn();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    C = PbFragment.this.lIY.C(true, PbFragment.this.dpl());
                                                } else {
                                                    C = view.getId() == R.id.reply_title ? PbFragment.this.lIY.C(false, PbFragment.this.dpl()) : PbFragment.this.lIY.PP(PbFragment.this.dpl());
                                                }
                                                view.setTag(Boolean.valueOf(C));
                                                if (C) {
                                                    PbFragment.this.lNl.uI(true);
                                                    PbFragment.this.lNl.dsj();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lNl.vn(true);
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
                                        PbFragment.this.lNl.dsG();
                                        if (PbFragment.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lIY.Hi(PbFragment.this.lNl.dss()) != null) {
                                            PbFragment.this.dpg();
                                            if (PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dX("tid", PbFragment.this.lIY.lQw).dX("fid", PbFragment.this.lIY.getPbData().getForumId()).an("obj_locate", 3).dX("uid", PbFragment.this.lIY.getPbData().dmE().brq().getUserId()));
                                            }
                                            if (PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null && PbFragment.this.lIY.getPbData().dmE().brq().getUserId() != null && PbFragment.this.lNj != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lIY.getPbData());
                                                bz dmE2 = PbFragment.this.lIY.getPbData().dmE();
                                                int i10 = 1;
                                                if (dmE2.bpX()) {
                                                    i10 = 2;
                                                } else if (dmE2.bpY()) {
                                                    i10 = 3;
                                                } else if (dmE2.bto()) {
                                                    i10 = 4;
                                                } else if (dmE2.btp()) {
                                                    i10 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dX("tid", PbFragment.this.lIY.lQw).an("obj_locate", 1).dX("obj_id", PbFragment.this.lIY.getPbData().dmE().brq().getUserId()).an("obj_type", PbFragment.this.lNj.bnx() ? 0 : 1).an("obj_source", h).an("obj_param1", i10));
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
                                    if (PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().bpV() && PbFragment.this.lIY.getPbData().dmE().brH() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.lIY.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lIY.dnO()) || PbFragment.this.lIY.getAppealInfo() == null) {
                                            PbFragment.this.lME.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lIY.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lIY.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lME.finish();
                                        return;
                                    }
                                    String dnO2 = PbFragment.this.lIY.dnO();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lIY.dpZ() && dnO2 != null && dnO2.equals(name2)) {
                                        PbFragment.this.lME.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lIY.getPbData() != null && !PbFragment.this.ggJ.dPY()) {
                                    PbFragment.this.lNl.dsG();
                                    int i11 = 0;
                                    if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drk()) {
                                        if (PbFragment.this.lNl.lUq.dtO() == null || view != PbFragment.this.lNl.lUq.dtO().drm()) {
                                            if (view == PbFragment.this.lNl.dsl()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lIY.getPbData().dmE().brm() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lIY.getPbData().dmE().brl() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lIY.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lIY.getPbData().dmE().getId();
                                    PbFragment.this.lNl.dsi();
                                    PbFragment.this.ggJ.c(id4, name3, id5, i11, PbFragment.this.lNl.dsm());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lNl.lUq.dtN();
                            if (PbFragment.this.lIY != null) {
                                PbFragment.this.iwL.setThreadId(PbFragment.this.lIY.dpW());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lIY == null || !PbFragment.this.lIY.isPrivacy()) {
                                PbFragment.this.iwL.cuw();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dnV() != null && PbFragment.this.dnV().getPbData() != null && PbFragment.this.dnV().getPbData().getThreadId() != null && PbFragment.this.dnV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dnV() != null && PbFragment.this.dnV().getPbData() != null) {
                                    PbFragment.this.iwL.l(3, i12, PbFragment.this.dnV().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dnV() != null && PbFragment.this.dnV().getPbData() != null) {
                                    PbFragment.this.iwL.l(3, 3, PbFragment.this.dnV().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lNl.dsG();
                        PbFragment.this.cFz();
                        PbFragment.this.lNl.dsn();
                        PbFragment.this.lNl.showLoadingDialog();
                        if (PbFragment.this.lNl.drX() != null) {
                            PbFragment.this.lNl.drX().setVisibility(8);
                        }
                        PbFragment.this.lIY.Hc(1);
                        if (PbFragment.this.lMH != null) {
                            PbFragment.this.lMH.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String doV = PbFragment.this.doV();
                        if (!TextUtils.isEmpty(doV)) {
                            be.bwu().b(PbFragment.this.getPageContext(), new String[]{doV});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar9 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar9.dX("tid", PbFragment.this.lIY.dpW());
                aqVar9.dX("fid", PbFragment.this.lIY.getForumId());
                aqVar9.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar9.an("obj_locate", 1);
                TiebaStatic.log(aqVar9);
                if (PbFragment.this.lMQ) {
                    PbFragment.this.lMQ = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.doO().drL() != null && postData7.brq() != null && postData7.dPd() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.doO().drM() != null) {
                                PbFragment.this.doO().drM().doE();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lIY.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lIY.getPbData().dmE());
                            pVar2.g(postData7);
                            PbFragment.this.doO().drL().d(pVar2);
                            PbFragment.this.doO().drL().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.brq().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lIY.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lNx != null) {
                                PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lOk = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lIY != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lIY.lQw)) {
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
                if (PbFragment.this.lIY.getPbData() != null) {
                    aqVar.dX("fid", PbFragment.this.lIY.getPbData().getForumId());
                }
                aqVar.dX("tid", PbFragment.this.lIY.dpW());
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cFz();
            PbFragment.this.lNl.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lIY.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIY.getPbData();
                            if (pbData != null && pbData.dmE() != null && pbData.dmE().brq() != null && (userId = pbData.dmE().brq().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lIY.dqj()) {
                                PbFragment.this.lNl.dsn();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lIY.dqj()) {
                            PbFragment.this.lNl.dsn();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lNl.s(PbFragment.this.lIY.getPbData());
                    }
                    if (PbFragment.this.lIY.dqd()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dX("tid", PbFragment.this.lIY.dpW()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uO(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lNx.bFD() || PbFragment.this.lNx.bFE()) {
                    PbFragment.this.lNx.a(false, postWriteCallBackData);
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
                    aVar.Bp(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).btX();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lOl = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                    aqVar.dX("fid", PbFragment.this.lIY.getPbData().getForumId());
                }
                if (PbFragment.this.lIY != null) {
                    aqVar.dX("tid", PbFragment.this.lIY.dpW());
                }
                aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.kSQ != null) {
                    PbFragment.this.kSQ.dtg();
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
                    aVar.Bp(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(PbFragment.this.getPageContext()).btX();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kSQ != null) {
                if (PbFragment.this.lNl != null && PbFragment.this.lNl.drM() != null && PbFragment.this.lNl.drM().doI() != null && PbFragment.this.lNl.drM().doI().bFE()) {
                    PbFragment.this.lNl.drM().doI().a(postWriteCallBackData);
                }
                PbFragment.this.kSQ.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lOm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dtb;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lME.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lNl != null && (dtb = PbFragment.this.lNl.dtb()) != null && PbFragment.this.lNl.getListView() != null) {
                            PbFragment.this.lNl.getListView().removeHeaderView(dtb);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lOn = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h ss;
            if (!z || fVar == null || fVar.dmR() != null || com.baidu.tbadk.core.util.x.getCount(fVar.dmG()) >= 1) {
                PbFragment.this.liC = true;
                PbFragment.this.lNl.dsp();
                if (fVar == null || !fVar.dmM()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lNl.getView());
                }
                PbFragment.this.lNl.dsk();
                if (PbFragment.this.isFullScreen || PbFragment.this.lNl.dsY()) {
                    PbFragment.this.lNl.dsP();
                } else if (!PbFragment.this.lNl.dsM()) {
                    PbFragment.this.lNl.vz(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.gnZ = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lNl.getView());
                    PbFragment.this.lNl.dsy();
                }
                if (z && fVar != null) {
                    bz dmE = fVar.dmE();
                    if (dmE == null || !dmE.bpZ()) {
                        PbFragment.this.d(PbFragment.this.lNw);
                    } else {
                        dpF();
                    }
                    PbFragment.this.lNl.drM().setPbData(fVar);
                    PbFragment.this.lNl.caY();
                    if (dmE != null && dmE.bsD() != null) {
                        PbFragment.this.a(dmE.bsD());
                    }
                    if (PbFragment.this.lNx != null) {
                        PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dmG() != null && fVar.dmG().size() >= 1 && fVar.dmG().get(0) != null) {
                        PbFragment.this.lIY.PR(fVar.dmG().get(0).getId());
                    } else if (fVar.dmR() != null) {
                        PbFragment.this.lIY.PR(fVar.dmR().getId());
                    }
                    if (PbFragment.this.lNx != null) {
                        PbFragment.this.lNx.a(fVar.getAnti());
                        PbFragment.this.lNx.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lNx.setThreadData(dmE);
                        PbFragment.this.lNx.a(PbFragment.this.lIY.dqn(), PbFragment.this.lIY.dpW(), PbFragment.this.lIY.dqE());
                        if (dmE != null) {
                            PbFragment.this.lNx.kZ(dmE.bsQ());
                        }
                    }
                    if (PbFragment.this.lNj != null) {
                        PbFragment.this.lNj.jc(fVar.bnx());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dnh()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lNl.vy(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lNl.a(fVar, i2, i3, PbFragment.this.lIY.dpY(), i4, PbFragment.this.lIY.getIsFromMark());
                    PbFragment.this.lNl.d(fVar, PbFragment.this.lIY.dpY());
                    PbFragment.this.lNl.vv(PbFragment.this.lIY.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fGe = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fGe) && PbFragment.this.lNx != null && PbFragment.this.lNx.bEI() != null && (ss = PbFragment.this.lNx.bEI().ss(6)) != null && !TextUtils.isEmpty(PbFragment.this.fGe)) {
                            ((View) ss).setOnClickListener(PbFragment.this.fGR);
                        }
                    }
                    if (PbFragment.this.lNs) {
                        PbFragment.this.lNs = false;
                        final int dpc = PbFragment.this.dpc();
                        if (!fVar.dne()) {
                            PbFragment.this.lNl.Hp(dpc);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dpc, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lNt) {
                        PbFragment.this.lNt = false;
                        final int dpc2 = PbFragment.this.dpc();
                        final boolean z2 = dpc2 != -1;
                        if (!z2) {
                            dpc2 = PbFragment.this.dpd();
                        }
                        if (PbFragment.this.lNl != null) {
                            if (!fVar.dne()) {
                                PbFragment.this.lNl.Hp(dpc2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dpc2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lNl.setSelectionFromTop(dpc2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lNl.setSelectionFromTop(dpc2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lNl.vA(true);
                                PbFragment.this.lNl.vz(false);
                            }
                        }
                    } else if (PbFragment.this.lNu) {
                        PbFragment.this.lNu = false;
                        PbFragment.this.lNl.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lNl.dst();
                    }
                    PbFragment.this.lIY.a(fVar.getForum(), PbFragment.this.lNY);
                    PbFragment.this.lIY.a(PbFragment.this.lNZ);
                    if (PbFragment.this.kON != null && dmE != null && dmE.brq() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dmE.brq());
                        PbFragment.this.kON.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.gnZ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lIY.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lIY.getAppealInfo().lFJ)) {
                                    PbFragment.this.lNl.a(PbFragment.this.lIY.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lNl.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lNl.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lNl.dsP();
                            PbFragment.this.lNl.dsx();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lIY.dpW());
                            jSONObject.put("fid", PbFragment.this.lIY.getForumId());
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
                        PbFragment.this.lNl.PX("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                            arrayList = PbFragment.this.lIY.getPbData().dmG();
                        }
                        if (com.baidu.tbadk.core.util.x.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.x.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dPd() != 1)) {
                            PbFragment.this.lNl.PX(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dpw()) {
                                PbFragment.this.lNl.PY(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lNl.PY(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lNl.s(PbFragment.this.lIY.getPbData());
                        }
                    }
                    PbFragment.this.lNl.endLoadData();
                }
                if (fVar != null && fVar.lFY && PbFragment.this.fLQ == 0) {
                    PbFragment.this.fLQ = System.currentTimeMillis() - PbFragment.this.iHN;
                }
                if (!PbFragment.this.dnV().dpY() || PbFragment.this.dnV().getPbData().getPage().bqg() != 0 || PbFragment.this.dnV().dqz()) {
                    PbFragment.this.lNy = true;
                    return;
                }
                return;
            }
            PbFragment.this.lIY.Hc(1);
            if (PbFragment.this.lMH != null) {
                PbFragment.this.lMH.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dpF() {
            if (PbFragment.this.lIY != null) {
                if (PbFragment.this.lNx == null || !PbFragment.this.lNx.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lNx = (com.baidu.tbadk.editortools.pb.e) dVar.fj(PbFragment.this.getContext());
                    PbFragment.this.lNx.a(PbFragment.this.lME.getPageContext());
                    PbFragment.this.lNx.a(PbFragment.this.fGo);
                    PbFragment.this.lNx.a(PbFragment.this.fGh);
                    PbFragment.this.lNx.a(PbFragment.this.lME.getPageContext(), PbFragment.this.lME.getIntent() == null ? null : PbFragment.this.lME.getIntent().getExtras());
                    PbFragment.this.lNx.bEI().kO(true);
                    PbFragment.this.lNl.setEditorTools(PbFragment.this.lNx.bEI());
                    if (!PbFragment.this.lIY.dqe()) {
                        PbFragment.this.lNx.DS(PbFragment.this.lIY.dpW());
                    }
                    if (PbFragment.this.lIY.dqF()) {
                        PbFragment.this.lNx.DQ(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lNl != null) {
                        PbFragment.this.lNx.DQ(PbFragment.this.lNl.drQ());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lNl.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bHF().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iHN : j;
                if (PbFragment.this.fLQ == 0) {
                    PbFragment.this.fLQ = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fLH, PbFragment.this.createTime, PbFragment.this.fLQ, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fLH = 0L;
                if (hVar != null) {
                    hVar.bHC();
                }
                if (z2) {
                    hVar.fLZ = currentTimeMillis;
                    hVar.ln(true);
                }
                if (!z2 && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null) {
                    int threadType = PbFragment.this.lIY.getPbData().dmE().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.lMU, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.lMU, "from_frs")) {
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
    private CustomMessageListener lOo = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.doY();
            }
        }
    };
    private final a.InterfaceC0574a lOp = new a.InterfaceC0574a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
        public void g(boolean z, boolean z2, String str) {
            PbFragment.this.lNl.dsp();
            if (z) {
                if (PbFragment.this.lNj != null) {
                    PbFragment.this.lNj.jc(z2);
                }
                PbFragment.this.lIY.vd(z2);
                if (PbFragment.this.lIY.bnx()) {
                    PbFragment.this.dph();
                } else {
                    PbFragment.this.lNl.s(PbFragment.this.lIY.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lNj != null) {
                        if (PbFragment.this.lNj.bnA() != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lIY.getPbData().dmE() != null && PbFragment.this.lIY.getPbData().dmE().brq() != null) {
                            MarkData bnA = PbFragment.this.lNj.bnA();
                            MetaData brq = PbFragment.this.lIY.getPbData().dmE().brq();
                            if (bnA != null && brq != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), brq.getUserId()) && !brq.hadConcerned()) {
                                    PbFragment.this.b(brq);
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
                    PbFragment.this.dpe();
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
                if (PbFragment.this.lNl != null) {
                    PbFragment.this.lNl.dsG();
                    if (PbFragment.this.lNx != null && !PbFragment.this.lNl.drP()) {
                        PbFragment.this.lNl.vx(PbFragment.this.lNx.bFw());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lNl.drO();
                    }
                }
                if (!PbFragment.this.lMN) {
                    PbFragment.this.lMN = true;
                }
            }
            if (PbFragment.this.lNl != null) {
                PbFragment.this.lNl.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lMH != null) {
                PbFragment.this.lMH.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lMO == null) {
                PbFragment.this.lMO = new com.baidu.tbadk.n.b();
                PbFragment.this.lMO.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lMO.bHy();
            } else {
                PbFragment.this.lMO.bHx();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dNX().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dmG;
            if (PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null && PbFragment.this.lNl != null && PbFragment.this.lNl.dsg() != null) {
                PbFragment.this.lNl.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lMH != null) {
                    PbFragment.this.lMH.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lIY.dqv() && (dmG = PbFragment.this.lIY.getPbData().dmG()) != null && !dmG.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lNl.dsg().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lIY.getPbData();
                    if (pbData != null) {
                        if (pbData.dmH() != null && pbData.dmH().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dmI() != null && pbData.dmI().hasData()) {
                            headerCount--;
                        }
                        int size = dmG.size();
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
                            PbFragment.this.lIY.dqs();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.mcO != 1002 || bVar.hli) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lNl.a(1, dVar.mSuccess, dVar.nuu, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.ggJ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lNl.a(PbFragment.this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nuu, false);
                            PbFragment.this.lNl.bf(gVar.nux);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lNl.a(PbFragment.this.ggJ.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lOq = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c glJ = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dpm()) {
                PbFragment.this.lME.finish();
            }
            if (!PbFragment.this.lIY.vc(true)) {
                PbFragment.this.lNl.dsq();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lOs = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lOr && PbFragment.this.dpm()) {
                PbFragment.this.dpo();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lNf && PbFragment.this.lNl != null && PbFragment.this.lNl.dtd() && PbFragment.this.lIY != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dX("tid", PbFragment.this.lIY.dpW());
                    aqVar.dX("fid", PbFragment.this.lIY.getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lIY.dpZ()) {
                        if (!PbFragment.this.lIY.dqc()) {
                            if (PbFragment.this.lIY.dqb()) {
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
                    PbFragment.this.lNf = true;
                }
                if (PbFragment.this.lIY.vb(false)) {
                    PbFragment.this.lNl.dso();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lIY.getPbData() != null) {
                    PbFragment.this.lNl.dsL();
                }
                PbFragment.this.lOr = true;
            }
        }
    };
    private int lOt = 0;
    private final TbRichTextView.i fWO = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dsg;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lNl.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dX("tid", PbFragment.this.lIY.dpW());
                aqVar.dX("fid", PbFragment.this.lIY.getForumId());
                aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.an("obj_locate", 3);
                aqVar.an("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lIY.lKf.dnh()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bKX() != null) {
                            ArrayList<TbRichTextImageInfo> bKX = tbRichTextView.getRichText().bKX();
                            int i4 = 0;
                            while (i4 < bKX.size()) {
                                if (bKX.get(i4) != null) {
                                    arrayList.add(bKX.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bKX.get(i4).getSrc()) || str.equals(bKX.get(i4).bLp()) || str.equals(bKX.get(i4).bLm()) || str.equals(bKX.get(i4).bLo()) || str.equals(bKX.get(i4).bLs()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bKX.get(i4).getSrc();
                                    imageUrlData.originalUrl = bKX.get(i4).getSrc();
                                    imageUrlData.isLongPic = bKX.get(i4).bLu();
                                    concurrentHashMap.put(bKX.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.f(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).ot(i3).ji(false).jj(PbFragment.this.lIY.dqp()).d(concurrentHashMap).jk(true).jl(false).jm(PbFragment.this.dpw()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lIY != null) {
                            aVar.AJ(PbFragment.this.lIY.getFromForumId());
                            if (PbFragment.this.lIY.getPbData() != null) {
                                aVar.s(PbFragment.this.lIY.getPbData().dmE());
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
                    if (aVar2.lJm) {
                        TbRichText bG = PbFragment.this.bG(str, i);
                        if (bG != null && PbFragment.this.lOt >= 0 && PbFragment.this.lOt < bG.bKW().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bG.bKW().get(PbFragment.this.lOt));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lJl.size()) {
                                    break;
                                } else if (!aVar2.lJl.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bG.getPostId() != 0 && (dsg = PbFragment.this.lNl.dsg()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dsg.getDataList();
                                if (com.baidu.tbadk.core.util.x.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bG.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bG.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lIY.dqE(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lIY.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
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
                            aVar3.x(arrayList2).AE(aVar2.forumName).AF(aVar2.forumId).AG(aVar2.threadId).ji(aVar2.eMp).jk(true).AH(aVar2.lastId).jj(PbFragment.this.lIY.dqp()).d(concurrentHashMap2).jl(false).jm(PbFragment.this.dpw()).AI(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lIY != null) {
                                aVar3.AJ(PbFragment.this.lIY.getFromForumId());
                                if (PbFragment.this.lIY.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lIY.getPbData().dmE());
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
                    arrayList3.add(com.baidu.tbadk.core.util.x.getItem(aVar2.lJl, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eMr.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).AE(aVar2.forumName).AF(aVar2.forumId).AG(aVar2.threadId).ji(aVar2.eMp).jk(true).AH(aVar2.lJl.get(0)).jj(PbFragment.this.lIY.dqp()).d(concurrentHashMap3).jl(false).jm(PbFragment.this.dpw()).AI(aVar2.postId).jn(false);
                    if (PbFragment.this.lIY != null) {
                        aVar4.AJ(PbFragment.this.lIY.getFromForumId());
                        if (PbFragment.this.lIY.getPbData() != null) {
                            aVar4.s(PbFragment.this.lIY.getPbData().dmE());
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
                PbFragment.this.lMY = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lOu = false;
    PostData kmq = null;
    private final b.InterfaceC0578b lOv = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
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
    private final b.InterfaceC0578b lOw = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lNH != null && !TextUtils.isEmpty(PbFragment.this.lNI)) {
                if (i == 0) {
                    if (PbFragment.this.lNJ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lNI));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lNI;
                        aVar.pkgId = PbFragment.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lNJ.memeInfo.pck_id;
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
                        PbFragment.this.eLv.p(PbFragment.this.lNI, PbFragment.this.lNH.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lNH = null;
                PbFragment.this.lNI = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lMF = true;
            return PbFragment.this.dH(view);
        }
    };
    private final NoNetworkView.a jct = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lIY.dqf()) {
                PbFragment.this.dpj();
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
            if (aA(i2) && PbFragment.this.lNl != null && PbFragment.this.lMH != null) {
                PbFragment.this.lMH.qL(true);
                if (Math.abs(i2) > this.hkO) {
                    PbFragment.this.lMH.hideFloatingView();
                }
                if (PbFragment.this.dpm()) {
                    PbFragment.this.lNl.dsd();
                    PbFragment.this.lNl.dse();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            if (aA(i2) && PbFragment.this.lNl != null && PbFragment.this.lMH != null) {
                PbFragment.this.lNl.dsQ();
                PbFragment.this.lMH.qL(false);
                PbFragment.this.lMH.showFloatingView();
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
    private final n.a lLI = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lNl.PZ(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lOy = -1;
    private int lOz = -1;

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

    public com.baidu.tbadk.editortools.pb.e doJ() {
        return this.lNx;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dnx() != null) {
            String id = pVar.dnx().getId();
            ArrayList<PostData> dmG = this.lIY.getPbData().dmG();
            int i = 0;
            while (true) {
                if (i >= dmG.size()) {
                    z = true;
                    break;
                }
                PostData postData = dmG.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dnF = pVar.dnF();
                    postData.KQ(pVar.getTotalCount());
                    if (postData.dPa() == null || dnF == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dnF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.brq() != null && (metaData = postData.getUserMap().get(next.brq().getUserId())) != null) {
                                next.a(metaData);
                                next.yh(true);
                                next.a(getPageContext(), this.lIY.PQ(metaData.getUserId()));
                            }
                        }
                        z = dnF.size() != postData.dPa().size();
                        if (postData.dPa() != null && postData.dPa().size() < 2) {
                            postData.dPa().clear();
                            postData.dPa().addAll(dnF);
                        }
                    }
                    if (postData.dOW() != null) {
                        postData.dOX();
                    }
                }
            }
            if (!this.lIY.getIsFromMark() && z) {
                this.lNl.s(this.lIY.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PI(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o dmW = this.lIY.getPbData().dmW();
            if (dmW != null && str.equals(dmW.getAdId())) {
                if (dmW.dOR() != null) {
                    dmW.dOR().legoCard = null;
                }
                this.lIY.getPbData().dmX();
            }
            com.baidu.tieba.tbadkCore.data.o dql = this.lIY.dql();
            if (dql != null && str.equals(dql.getAdId())) {
                this.lIY.dqm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lNp != null && this.lNp.isShowing()) {
                this.lNp.dismiss();
                this.lNp = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lNp != null) {
                            PbFragment.this.lNp.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lNl.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lNF);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lNF);
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
                this.lNp = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lNp.SY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(int i) {
        bz dmE;
        if (this.lIY != null && this.lIY.getPbData() != null && (dmE = this.lIY.getPbData().dmE()) != null) {
            if (i == 1) {
                PraiseData brb = dmE.brb();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (brb == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dmE.a(praiseData);
                    } else {
                        dmE.brb().getUser().add(0, metaData);
                        dmE.brb().setNum(dmE.brb().getNum() + 1);
                        dmE.brb().setIsLike(i);
                    }
                }
                if (dmE.brb() != null) {
                    if (dmE.brb().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(dmE.brb().getNum());
                    }
                }
            } else if (dmE.brb() != null) {
                dmE.brb().setIsLike(i);
                dmE.brb().setNum(dmE.brb().getNum() - 1);
                ArrayList<MetaData> user = dmE.brb().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dmE.brb().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dmE.brb().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dmE.brb().getNum() + "";
                }
            }
            if (this.lIY.dpY()) {
                this.lNl.dsg().notifyDataSetChanged();
            } else {
                this.lNl.t(this.lIY.getPbData());
            }
        }
    }

    public static PbFragment doK() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lME = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lIY.aD(bundle);
        if (this.jfh != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lNx.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lMM = System.currentTimeMillis();
        this.lND = getPageContext();
        final Intent intent = this.lME.getIntent();
        if (intent != null) {
            this.iHN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lMU = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lMU)) {
                    this.lMU = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lMU)) {
                this.lMI = true;
            }
            this.lOy = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lOz = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lOA = intent.getStringExtra("key_manga_title");
            this.lNs = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lNt = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lNu = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dpm()) {
                this.lME.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lNL = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lNd = new bi();
            this.lNd.D(intent);
            this.lNN = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lNN == 0) {
                this.lNN = intent.getIntExtra("key_start_from", 0);
            }
            this.lNO = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iHN = System.currentTimeMillis();
        }
        this.fLH = this.lMM - this.iHN;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lMK = 0;
        aC(bundle);
        if (this.lIY.getPbData() != null) {
            this.lIY.getPbData().PC(this.source);
        }
        doN();
        if (intent != null && this.lNl != null) {
            this.lNl.lUo = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lNG == null) {
                    this.lNG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lNl.Qb("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.lNG, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lIY.getPbData() != null) {
                this.lIY.PT(stringExtra);
            }
        }
        this.jfh = new VoiceManager();
        this.jfh.onCreate(getPageContext());
        initData(bundle);
        this.lNw = new com.baidu.tbadk.editortools.pb.g();
        d(this.lNw);
        this.lNx = (com.baidu.tbadk.editortools.pb.e) this.lNw.fj(getActivity());
        this.lNx.a(this.lME.getPageContext());
        this.lNx.a(this.fGo);
        this.lNx.a(this.fGh);
        this.lNx.setFrom(1);
        this.lNx.a(this.lME.getPageContext(), bundle);
        this.lNx.bEI().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lNx.bEI().kO(true);
        uN(true);
        this.lNx.a(this.lIY.dqn(), this.lIY.dpW(), this.lIY.dqE());
        registerListener(this.lNT);
        if (!this.lIY.dqe()) {
            this.lNx.DS(this.lIY.dpW());
        }
        if (this.lIY.dqF()) {
            this.lNx.DQ(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lNl != null) {
            this.lNx.DQ(this.lNl.drQ());
        }
        registerListener(this.lNS);
        registerListener(this.lNU);
        registerListener(this.lNV);
        registerListener(this.jgO);
        registerListener(this.lOh);
        registerListener(this.lNR);
        this.lNv = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nqR);
        this.lNv.dOG();
        registerListener(this.lNW);
        registerListener(this.fdd);
        this.lIY.dqx();
        registerListener(this.lOo);
        registerListener(this.jgW);
        registerListener(this.lOk);
        if (this.lNl != null && this.lNl.dsU() != null && this.lNl.dsV() != null) {
            this.lMH = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lNl.dsU(), this.lNl.dsV(), this.lNl.drX());
            this.lMH.a(this.lOc);
        }
        if (this.lMG && this.lNl != null && this.lNl.dsV() != null) {
            this.lNl.dsV().setVisibility(8);
        }
        this.lNE = new com.baidu.tbadk.core.view.c();
        this.lNE.toastTime = 1000L;
        registerListener(this.lOg);
        registerListener(this.lOe);
        registerListener(this.lOf);
        registerListener(this.jom);
        registerListener(this.jgK);
        this.lNX.setSelfListener(true);
        this.lNX.setTag(this.lME.getUniqueId());
        this.lNX.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lNX);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lNF = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lNF;
        userMuteAddAndDelCustomMessage.setTag(this.lNF);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lNF;
        userMuteCheckCustomMessage.setTag(this.lNF);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lIY.dqC().a(this.lOd);
        this.kSQ = new ar();
        if (this.lNx.bFo() != null) {
            this.kSQ.f(this.lNx.bFo().getInputView());
        }
        this.lNx.a(this.fGi);
        this.jBj = new ShareSuccessReplyToServerModel();
        a(this.lNP);
        this.kON = new com.baidu.tbadk.core.util.al(getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.al.fcU) {
                        PbFragment.this.lNx.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.al.fcV && PbFragment.this.lNl != null && PbFragment.this.lNl.drM() != null && PbFragment.this.lNl.drM().doI() != null) {
                        PbFragment.this.lNl.drM().doI().bFM();
                    } else if (i == com.baidu.tbadk.core.util.al.fcW) {
                        PbFragment.this.c(PbFragment.this.lNA);
                    }
                }
            }
        });
        this.lNi = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lNi.w(getUniqueId());
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
        com.baidu.tbadk.core.business.b.boI().dJ("3", "");
        this.iwL = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lMM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lIY != null) {
            gVar.setForumName(this.lIY.dnO());
            if (this.lIY.getPbData() != null && this.lIY.getPbData().getForum() != null) {
                gVar.a(this.lIY.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lIY);
        }
    }

    public String doL() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b doM() {
        return this.lMH;
    }

    private void uN(boolean z) {
        this.lNx.kW(z);
        this.lNx.kX(z);
        this.lNx.kY(z);
    }

    private void doN() {
        this.fpO = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    public ap doO() {
        return this.lNl;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dnV() {
        return this.lIY;
    }

    public void PJ(String str) {
        if (this.lIY != null && !StringUtils.isNull(str) && this.lNl != null) {
            this.lNl.vC(true);
            this.lIY.PJ(str);
            this.lMS = true;
            this.lNl.dsG();
            this.lNl.dsP();
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
        this.lMK = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lMK == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        if (this.lNl != null) {
            this.lNl.onPause();
        }
        if (!this.lIY.dqe()) {
            this.lNx.DR(this.lIY.dpW());
        }
        if (this.lIY != null) {
            this.lIY.dqy();
        }
        com.baidu.tbadk.BdToken.c.bkT().ble();
        MessageManager.getInstance().unRegisterListener(this.jtD);
        cUD();
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.lOg);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean doP() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lIY.getPbData(), this.lIY.dpY(), this.lIY.dqw());
        return (a2 == null || a2.brq() == null || a2.brq().getGodUserData() == null || a2.brq().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lMW) {
            this.lMW = false;
            dps();
        }
        if (doP()) {
            this.lMP = System.currentTimeMillis();
        } else {
            this.lMP = -1L;
        }
        if (this.lNl != null && this.lNl.getView() != null) {
            if (!this.liC) {
                dpk();
            } else {
                hideLoadingView(this.lNl.getView());
            }
            this.lNl.onResume();
        }
        if (this.lMK == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lNl != null) {
            noNetworkView = this.lNl.drJ();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        registerListener(this.jtD);
        this.lNr = false;
        dpr();
        registerListener(this.lOe);
        registerListener(this.lOf);
        registerListener(this.lOg);
        if (this.jfV) {
            dpj();
            this.jfV = false;
        }
        dpz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lNl.vr(z);
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
        if (z && this.lNr) {
            this.lNl.dso();
            this.lIY.vb(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lMP > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dX("obj_duration", (System.currentTimeMillis() - this.lMP) + ""));
            this.lMP = 0L;
        }
        if (doO().drM() != null) {
            doO().drM().onStop();
        }
        if (this.lNl.lUq != null && !this.lNl.lUq.dtQ()) {
            this.lNl.lUq.dcQ();
        }
        if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().getForum() != null && this.lIY.getPbData().dmE() != null) {
            com.baidu.tbadk.distribute.a.bEv().b(getPageContext().getPageActivity(), "pb", this.lIY.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIY.getPbData().dmE().getId(), 0L));
        }
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lNe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("fid", this.lIY.getPbData().getForumId());
            aqVar.dX("tid", this.lIY.dpW());
            aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lMN && this.lNl != null) {
            this.lMN = true;
            a(false, (PostData) null);
        }
        if (this.lIY != null) {
            this.lIY.cancelLoadData();
            this.lIY.destory();
            if (this.lIY.dqB() != null) {
                this.lIY.dqB().onDestroy();
            }
        }
        if (this.lNx != null) {
            this.lNx.onDestroy();
        }
        if (this.ggJ != null) {
            this.ggJ.cancelLoadData();
        }
        if (this.fpO != null) {
            this.fpO.dOt();
        }
        if (this.lNl != null) {
            this.lNl.onDestroy();
            if (this.lNl.lUq != null) {
                this.lNl.lUq.dcQ();
            }
        }
        if (this.lMO != null) {
            this.lMO.bHz();
        }
        if (this.lMH != null) {
            this.lMH.cHr();
        }
        super.onDestroy();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        if (this.lNl != null) {
            this.lNl.dsG();
        }
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.lOg);
        MessageManager.getInstance().unRegisterListener(this.lNF);
        MessageManager.getInstance().unRegisterListener(this.lOh);
        MessageManager.getInstance().unRegisterListener(this.jgW);
        MessageManager.getInstance().unRegisterListener(this.jom);
        MessageManager.getInstance().unRegisterListener(this.lOm);
        MessageManager.getInstance().unRegisterListener(this.lNX);
        this.lND = null;
        this.lNE = null;
        com.baidu.tieba.recapp.c.a.dFN().dFQ();
        if (this.lNG != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lNG);
        }
        if (this.lMX != null) {
            this.lMX.cancelLoadData();
        }
        if (this.lNl != null && this.lNl.lUq != null) {
            this.lNl.lUq.dtU();
        }
        if (this.jBj != null) {
            this.jBj.cancelLoadData();
        }
        this.kSQ.onDestroy();
        if (this.lIY != null && this.lIY.dqD() != null) {
            this.lIY.dqD().onDestroy();
        }
        if (this.kON != null) {
            this.kON.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dsg;
        ArrayList<PostData> dot;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bzy() && this.lNl != null && (dsg = this.lNl.dsg()) != null && (dot = dsg.dot()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dot.iterator();
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
                if (this.lIY == null || this.lIY.getPbData() == null || this.lIY.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lIY.getPbData().getForum().getFirst_class();
                    str3 = this.lIY.getPbData().getForum().getSecond_class();
                    String id2 = this.lIY.getPbData().getForum().getId();
                    str = this.lIY.dpW();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.s.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bzB());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lNl.onChangeSkinType(i);
            if (this.lNx != null && this.lNx.bEI() != null) {
                this.lNx.bEI().onChangeSkinType(i);
            }
            if (this.lNl.drJ() != null) {
                this.lNl.drJ().onChangeSkinType(getPageContext(), i);
            }
            this.kSQ.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ao.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cFz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lNl = new ap(this, this.jhV, this.fyb);
        this.jkd = new com.baidu.tieba.f.b(getActivity());
        this.jkd.a(lOx);
        this.jkd.a(this.iEb);
        this.lNl.setOnScrollListener(this.mOnScrollListener);
        this.lNl.d(this.lOs);
        this.lNl.setListPullRefreshListener(this.glJ);
        this.lNl.uz(com.baidu.tbadk.core.k.bou().isShowImages());
        this.lNl.setOnImageClickListener(this.fWO);
        this.lNl.b(this.mOnLongClickListener);
        this.lNl.g(this.jct);
        this.lNl.a(this.lOq);
        this.lNl.vr(this.mIsLogin);
        if (this.lME.getIntent() != null) {
            this.lNl.vD(this.lME.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lNl.drL().setFromForumId(this.lIY.getFromForumId());
        this.lNl.setEditorTools(this.lNx.bEI());
        this.lNx.DQ(this.lNl.drQ());
        this.lNl.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lIY.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIY.getPbData().getForum().getId(), PbFragment.this.lIY.getPbData().getForum().getName(), PbFragment.this.lIY.getPbData().dmE().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lNl.vE(this.lIY.dqb());
        this.lNl.Hj(this.lIY.dqH());
        return this.lNl.getView();
    }

    public void doQ() {
        if (this.lNl != null && this.lIY != null) {
            if ((this.lIY.getPbData() != null || this.lIY.getPbData().dnd() != null) && checkUpIsLogin() && this.lNl.dsg() != null && this.lNl.dsg().doy() != null) {
                this.lNl.dsg().doy().Cz(this.lIY.dpW());
            }
        }
    }

    public void doR() {
        TiebaStatic.log("c12181");
        if (this.lNl != null && this.lIY != null) {
            if ((this.lNl == null || this.lNl.drP()) && this.lIY.getPbData() != null && this.lIY.getPbData().dnd() != null) {
                com.baidu.tieba.pb.data.o dnd = this.lIY.getPbData().dnd();
                if (checkUpIsLogin()) {
                    if ((!dnd.dnz() || dnd.bsU() != 2) && this.lNl.dsg() != null && this.lNl.dsg().doy() != null) {
                        this.lNl.dsg().doy().Cz(this.lIY.dpW());
                    }
                    if (System.currentTimeMillis() - this.lMR > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wn(false);
                        this.lMR = System.currentTimeMillis();
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
                if (postData.getType() != PostData.eTd && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bou().isShowImages()) {
                    return PM(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lIY == null || this.lIY.getPbData() == null) {
                        return true;
                    }
                    if (doO().drM() != null) {
                        doO().drM().doE();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lIY.getPbData().getForum());
                    pVar.setThreadData(this.lIY.getPbData().dmE());
                    pVar.g(postData);
                    doO().drL().d(pVar);
                    doO().drL().setPostId(postData.getId());
                    a(view, postData.brq().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lNx != null) {
                        this.lNl.vx(this.lNx.bFw());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void doS() {
        if (this.lML == null) {
            this.lML = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lML.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lIU = PbFragment.this.lIU.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIU);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lIY.dpW(), PbFragment.this.lIU, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lIU = PbFragment.this.lIU.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIU);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lIY.dpW(), PbFragment.this.lIU, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lIU = PbFragment.this.lIU.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lIU);
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
        this.lOn.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).dvW(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lIY = this.lME.dnV();
        if (this.lIY.dqA() != null) {
            this.lIY.dqA().a(this.lLI);
        }
        if (this.lIY.dqB() != null) {
            this.lIY.dqB().b(this.lNQ);
        }
        if (StringUtils.isNull(this.lIY.dpW())) {
            this.lME.finish();
        } else if ("from_tieba_kuang".equals(this.lMU) && this.lMU != null) {
            this.lIY.Hj(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lNj = com.baidu.tbadk.baseEditMark.a.a(this.lME);
        if (this.lNj != null) {
            this.lNj.a(this.lOp);
        }
        this.ggJ = new ForumManageModel(this.lME);
        this.ggJ.setLoadDataCallBack(this.iwQ);
        this.fcZ = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lOb.setUniqueId(getUniqueId());
        this.lOb.registerListener();
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lNl.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lNF;
        userMuteCheckCustomMessage.setTag(this.lNF);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c14000").dX("tid", this.lIY.lQw).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Hx(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lMF ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean doT() {
        if (this.lIY == null || this.lIY.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lIY.getPbData().dmE()) || AntiHelper.a(getPageContext(), this.lIY.getPbData().getAnti());
    }

    public void doU() {
        if (checkUpIsLogin() && this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().getForum() != null && !doT()) {
            if (this.lIY.getPbData().dnh()) {
                this.lNl.cUe();
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
                            if (PbFragment.this.lNx != null && PbFragment.this.lNx.bEI() != null) {
                                PbFragment.this.lNx.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lNl.cUe();
                        }
                    }
                });
            }
            this.jjD.H(this.lIY.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIY.dpW(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doV() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lIY == null || (pbData = this.lIY.getPbData()) == null) {
            return null;
        }
        return pbData.dmS().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            if (fVar.dmE().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmE().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmE().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !doT() && doW()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lMZ);
                this.lNa = ((View) view.getParent()).getMeasuredHeight();
            }
            if (doO().drM() != null && postData != null) {
                String str3 = "";
                if (postData.dPf() != null) {
                    str3 = postData.dPf().toString();
                }
                doO().drM().PH(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.brq().getName_show(), str3));
            }
            if (this.lIY.getPbData() != null && this.lIY.getPbData().dnh()) {
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lME.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.doO().getListView().smoothScrollBy((PbFragment.this.lMZ[1] + PbFragment.this.lNa) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.doO().drM() != null) {
                            PbFragment.this.lNx.bEI().setVisibility(8);
                            PbFragment.this.doO().drM().j(str, str2, PbFragment.this.doO().drQ(), (PbFragment.this.lIY == null || PbFragment.this.lIY.getPbData() == null || PbFragment.this.lIY.getPbData().dmE() == null || !PbFragment.this.lIY.getPbData().dmE().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doI = PbFragment.this.doO().drM().doI();
                            if (doI != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                doI.a(PbFragment.this.lIY.getPbData().getAnti());
                                doI.setThreadData(PbFragment.this.lIY.getPbData().dmE());
                            }
                            if (PbFragment.this.kSQ.dtk() == null && PbFragment.this.doO().drM().doI().bFU() != null) {
                                PbFragment.this.doO().drM().doI().bFU().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kSQ != null && PbFragment.this.kSQ.dtj() != null) {
                                            if (!PbFragment.this.kSQ.dtj().dXT()) {
                                                PbFragment.this.kSQ.vG(false);
                                            }
                                            PbFragment.this.kSQ.dtj().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kSQ.g(PbFragment.this.doO().drM().doI().bFU().getInputView());
                                PbFragment.this.doO().drM().doI().a(PbFragment.this.lNC);
                            }
                        }
                        PbFragment.this.doO().dsP();
                    }
                }, 0L);
                return;
            }
            if (this.lNz == null) {
                this.lNz = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lNz.BA(1);
                this.lNz.a(new AnonymousClass39(str, str2));
            }
            if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().getForum() != null) {
                this.lNz.H(this.lIY.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lIY.dpW(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lOH;
        final /* synthetic */ String lOI;

        AnonymousClass39(String str, String str2) {
            this.lOH = str;
            this.lOI = str2;
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
                        PbFragment.this.doO().getListView().smoothScrollBy((PbFragment.this.lMZ[1] + PbFragment.this.lNa) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.doO().drM() != null) {
                            PbFragment.this.lNx.bEI().setVisibility(8);
                            PbFragment.this.doO().drM().j(AnonymousClass39.this.lOH, AnonymousClass39.this.lOI, PbFragment.this.doO().drQ(), (PbFragment.this.lIY == null || PbFragment.this.lIY.getPbData() == null || PbFragment.this.lIY.getPbData().dmE() == null || !PbFragment.this.lIY.getPbData().dmE().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h doI = PbFragment.this.doO().drM().doI();
                            if (doI != null && PbFragment.this.lIY != null && PbFragment.this.lIY.getPbData() != null) {
                                doI.a(PbFragment.this.lIY.getPbData().getAnti());
                                doI.setThreadData(PbFragment.this.lIY.getPbData().dmE());
                            }
                            if (PbFragment.this.kSQ.dtk() == null && PbFragment.this.doO().drM().doI().bFU() != null) {
                                PbFragment.this.doO().drM().doI().bFU().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kSQ != null && PbFragment.this.kSQ.dtj() != null) {
                                            if (!PbFragment.this.kSQ.dtj().dXT()) {
                                                PbFragment.this.kSQ.vG(false);
                                            }
                                            PbFragment.this.kSQ.dtj().zc(false);
                                        }
                                    }
                                });
                                PbFragment.this.kSQ.g(PbFragment.this.doO().drM().doI().bFU().getInputView());
                                PbFragment.this.doO().drM().doI().a(PbFragment.this.lNC);
                            }
                        }
                        PbFragment.this.doO().dsP();
                    }
                }, 0L);
            }
        }
    }

    public boolean doW() {
        if ((this.lIY.getPbData() != null && this.lIY.getPbData().dnh()) || this.kON == null || this.lIY.getPbData() == null || this.lIY.getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.pZ(this.lIY.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean GV(int i) {
        if (this.kON == null || this.lIY.getPbData() == null || this.lIY.getPbData().getAnti() == null) {
            return true;
        }
        return this.kON.aN(this.lIY.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lIY != null && this.lIY.getPbData() != null && postData.dPd() != 1) {
            String dpW = this.lIY.dpW();
            String id = postData.getId();
            int i = 0;
            if (this.lIY.getPbData() != null) {
                i = this.lIY.getPbData().dmT();
            }
            PbActivity.a PN = PN(id);
            if (PN != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dpW, id, "pb", true, null, false, null, i, postData.duO(), this.lIY.getPbData().getAnti(), false, postData.brq() != null ? postData.brq().getIconInfo() : null).addBigImageData(PN.lJl, PN.eMr, PN.eMp, PN.index);
                addBigImageData.setKeyPageStartFrom(this.lIY.dqH());
                addBigImageData.setFromFrsForumId(this.lIY.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lIY.getForumId());
                addBigImageData.setBjhData(this.lIY.dqg());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doX() {
        if (this.lIY.getPbData() == null || this.lIY.getPbData().dmE() == null) {
            return -1;
        }
        return this.lIY.getPbData().dmE().bsd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dnV() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dnV().PS(postWriteCallBackData.getPostId());
            this.lNK = this.lNl.drS();
            this.lIY.dc(this.lNK, this.lNl.drT());
        }
        this.lNl.dsG();
        this.kSQ.dth();
        if (this.lNx != null) {
            this.lNl.vx(this.lNx.bFw());
        }
        this.lNl.drK();
        this.lNl.vz(true);
        this.lIY.dqs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO(boolean z) {
        if (this.lIY != null && this.lIY.lKf != null && this.lIY.lKf.dmE() != null) {
            bz dmE = this.lIY.lKf.dmE();
            dmE.mRecomAbTag = this.lIY.dqS();
            dmE.mRecomWeight = this.lIY.dqQ();
            dmE.mRecomSource = this.lIY.dqR();
            dmE.mRecomExtra = this.lIY.dqT();
            if (dmE.getFid() == 0) {
                dmE.setFid(com.baidu.adp.lib.f.b.toLong(this.lIY.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmE, "c13563");
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
                if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                    a2.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doY() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Sz(this.lIY.getForumId()) && this.lIY.getPbData() != null && this.lIY.getPbData().getForum() != null) {
            if (this.lIY.getPbData().getForum().isLike() == 1) {
                this.lIY.dqD().gk(this.lIY.getForumId(), this.lIY.dpW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uP(boolean z) {
        if (this.lIY == null || this.lIY.getPbData() == null) {
            return false;
        }
        return ((this.lIY.getPbData().dmT() != 0) || this.lIY.getPbData().dmE() == null || this.lIY.getPbData().dmE().brq() == null || TextUtils.equals(this.lIY.getPbData().dmE().brq().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uQ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.lIY == null || this.lIY.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lIY.getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            bz dmE = pbData.dmE();
            if (dmE != null) {
                if (dmE.bpX() || dmE.bpY()) {
                    return false;
                }
                if (dmE.bto() || dmE.btp()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dmT() != 0) {
                    return pbData.dmT() != 3;
                }
                List<bv> dnb = pbData.dnb();
                if (com.baidu.tbadk.core.util.x.getCount(dnb) > 0) {
                    for (bv bvVar : dnb) {
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
        if (z || this.lIY == null || this.lIY.getPbData() == null) {
            return false;
        }
        return ((this.lIY.getPbData().getForum() != null && this.lIY.getPbData().getForum().isBlockBawuDelete) || this.lIY.getPbData().dmT() == 0 || this.lIY.getPbData().dmT() == 3) ? false : true;
    }

    public void doZ() {
        com.baidu.tieba.pb.data.f pbData;
        bz dmE;
        boolean z = true;
        if (this.lIY != null && this.lIY.getPbData() != null && (dmE = (pbData = this.lIY.getPbData()).dmE()) != null && dmE.brq() != null) {
            this.lNl.drK();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmE.brq().getUserId());
            ad adVar = new ad();
            int dmT = this.lIY.getPbData().dmT();
            if (dmT == 1 || dmT == 3) {
                adVar.lSE = true;
                adVar.lSK = dmE.brl() == 1;
            } else {
                adVar.lSE = false;
            }
            if (GW(dmT)) {
                adVar.lSF = true;
                adVar.lSJ = dmE.brm() == 1;
            } else {
                adVar.lSF = false;
            }
            if (dmT == 1002 && !equals) {
                adVar.lSL = true;
            }
            adVar.lSC = uQ(equals);
            adVar.lSG = dpa();
            adVar.lSD = uR(equals);
            adVar.FF = this.lIY.dpY();
            adVar.lSz = true;
            adVar.lSy = uP(equals);
            adVar.lSx = equals && this.lNl.dsv();
            adVar.lSI = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lSH = true;
            adVar.isHostOnly = this.lIY.getHostMode();
            adVar.lSB = true;
            if (dmE.brH() == null) {
                adVar.lSA = true;
            } else {
                adVar.lSA = false;
            }
            if (pbData.dnh()) {
                adVar.lSz = false;
                adVar.lSB = false;
                adVar.lSA = false;
                adVar.lSE = false;
                adVar.lSF = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dnh()) {
                z = false;
            }
            adVar.lSM = z;
            this.lNl.lUq.a(adVar);
        }
    }

    private boolean dpa() {
        if (this.lIY != null && this.lIY.dpY()) {
            return this.lIY.getPageData() == null || this.lIY.getPageData().bqg() != 0;
        }
        return false;
    }

    public boolean GW(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lIY.getPbData().getUserData() == null || (forumToolAuth = this.lIY.getPbData().getUserData().getForumToolAuth()) == null) {
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
    public PbModel.a dpb() {
        return this.lOn;
    }

    public int dpc() {
        if (doO() == null || doO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = doO().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) nVar).Ws == com.baidu.tieba.pb.data.n.lHj) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpd() {
        if (doO() == null || doO().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = doO().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nrv) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dpj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpe() {
        if (this.lIY != null && this.lIY.lKf != null && this.lIY.lKf.dmE() != null) {
            bz dmE = this.lIY.lKf.dmE();
            dmE.mRecomAbTag = this.lIY.dqS();
            dmE.mRecomWeight = this.lIY.dqQ();
            dmE.mRecomSource = this.lIY.dqR();
            dmE.mRecomExtra = this.lIY.dqT();
            dmE.eWD = this.lIY.dqe();
            if (dmE.getFid() == 0) {
                dmE.setFid(com.baidu.adp.lib.f.b.toLong(this.lIY.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dmE, "c13562");
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
            aVar.Bo(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bp(getResources().getString(R.string.mark_like));
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
                    PbFragment.this.fcZ.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lIY.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).btX();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lNl.dsp();
        this.lIY.vd(z);
        if (this.lNj != null) {
            this.lNj.jc(z);
            if (markData != null) {
                this.lNj.a(markData);
            }
        }
        if (this.lIY.bnx()) {
            dph();
        } else {
            this.lNl.s(this.lIY.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GL(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PK(String str) {
        if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().dnh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lIY.dpW(), str);
            bz dmE = this.lIY.getPbData().dmE();
            if (dmE.bpX()) {
                format = format + "&channelid=33833";
            } else if (dmE.btn()) {
                format = format + "&channelid=33842";
            } else if (dmE.bpY()) {
                format = format + "&channelid=33840";
            }
            PL(format);
            return;
        }
        this.lNi.Ql(str);
    }

    private void PL(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lIY.dqe()) {
                    antiData.setBlock_forum_name(this.lIY.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lIY.getPbData().getForum().getId());
                    antiData.setUser_name(this.lIY.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lIY.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (doO() != null) {
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
            DX(str);
        } else {
            this.lNl.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.nuu) ? bVar.nuu : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Bp(string);
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
                aVar.btX();
            } else {
                this.lNl.a(0, bVar.mSuccess, bVar.nuu, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iMd == 1) {
                    ArrayList<PostData> dmG = this.lIY.getPbData().dmG();
                    int size = dmG.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dmG.get(i).getId())) {
                            i++;
                        } else {
                            dmG.remove(i);
                            break;
                        }
                    }
                    this.lIY.getPbData().dmE().oN(this.lIY.getPbData().dmE().brh() - 1);
                    this.lNl.s(this.lIY.getPbData());
                } else if (bVar.iMd == 0) {
                    dpf();
                } else if (bVar.iMd == 2) {
                    ArrayList<PostData> dmG2 = this.lIY.getPbData().dmG();
                    int size2 = dmG2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dmG2.get(i2).dPa().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dmG2.get(i2).dPa().get(i3).getId())) {
                                i3++;
                            } else {
                                dmG2.get(i2).dPa().remove(i3);
                                dmG2.get(i2).dPc();
                                z2 = true;
                                break;
                            }
                        }
                        dmG2.get(i2).Tp(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lNl.s(this.lIY.getPbData());
                    }
                    a(bVar, this.lNl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lNl.a(this.ggJ.getLoadDataMode(), gVar.mSuccess, gVar.nuu, false);
            if (gVar.mSuccess) {
                this.lNm = true;
                if (i == 2 || i == 3) {
                    this.lNn = true;
                    this.lNo = false;
                } else if (i == 4 || i == 5) {
                    this.lNn = false;
                    this.lNo = true;
                }
                if (i == 2) {
                    this.lIY.getPbData().dmE().oQ(1);
                    this.lIY.setIsGood(1);
                } else if (i == 3) {
                    this.lIY.getPbData().dmE().oQ(0);
                    this.lIY.setIsGood(0);
                } else if (i == 4) {
                    this.lIY.getPbData().dmE().oP(1);
                    this.lIY.Hb(1);
                } else if (i == 5) {
                    this.lIY.getPbData().dmE().oP(0);
                    this.lIY.Hb(0);
                }
                this.lNl.c(this.lIY.getPbData(), this.lIY.dpY());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.nuu)) {
                string = gVar.nuu;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dpf() {
        if (this.lIY.dpZ() || this.lIY.dqb()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lIY.dpW());
            PbActivity pbActivity = this.lME;
            PbActivity pbActivity2 = this.lME;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lIY.dpW()));
        if (dpi()) {
            this.lME.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doj() {
        this.lME.doj();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dmQ;
        boolean z = false;
        if (this.lNl != null) {
            this.lNl.dsG();
        }
        if (this.lIY != null && this.lIY.getPbData() != null && !this.lIY.getPbData().dnh()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lIY.getPbData().dmE().getId();
            if (this.lIY.isShareThread() && this.lIY.getPbData().dmE().eVB != null) {
                historyMessage.threadName = this.lIY.getPbData().dmE().eVB.showText;
            } else {
                historyMessage.threadName = this.lIY.getPbData().dmE().getTitle();
            }
            if (this.lIY.isShareThread() && !dnN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lIY.getPbData().getForum().getName();
            }
            ArrayList<PostData> dmG = this.lIY.getPbData().dmG();
            int dsr = this.lNl != null ? this.lNl.dsr() : 0;
            if (dmG != null && dsr >= 0 && dsr < dmG.size()) {
                historyMessage.postID = dmG.get(dsr).getId();
            }
            historyMessage.isHostOnly = this.lIY.getHostMode();
            historyMessage.isSquence = this.lIY.dpY();
            historyMessage.isShareThread = this.lIY.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lNx != null) {
            this.lNx.onDestroy();
        }
        if (this.lMJ && doO() != null) {
            doO().dsZ();
        }
        if (this.lIY != null && (this.lIY.dpZ() || this.lIY.dqb())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lIY.dpW());
            if (this.lNm) {
                if (this.lNo) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lIY.cxN());
                }
                if (this.lNn) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lIY.getIsGood());
                }
            }
            if (this.lIY.getPbData() != null && System.currentTimeMillis() - this.lMM >= 40000 && (dmQ = this.lIY.getPbData().dmQ()) != null && !com.baidu.tbadk.core.util.x.isEmpty(dmQ.getDataList())) {
                intent.putExtra("guess_like_data", dmQ);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lNL);
            }
            PbActivity pbActivity = this.lME;
            PbActivity pbActivity2 = this.lME;
            pbActivity.setResult(-1, intent);
        }
        if (dpi()) {
            if (this.lIY != null && this.lNl != null && this.lNl.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lIY.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dmM() && !this.lMS && pbData.lFT == null) {
                        aj drv = aj.drv();
                        com.baidu.tieba.pb.data.f dqh = this.lIY.dqh();
                        Parcelable onSaveInstanceState = this.lNl.getListView().onSaveInstanceState();
                        boolean dpY = this.lIY.dpY();
                        boolean hostMode = this.lIY.getHostMode();
                        if (this.lNl.drX() != null && this.lNl.drX().getVisibility() == 0) {
                            z = true;
                        }
                        drv.a(dqh, onSaveInstanceState, dpY, hostMode, z);
                        if (this.lNK >= 0 || this.lIY.dqJ() != null) {
                            aj.drv().q(this.lIY.dqJ());
                            aj.drv().p(this.lIY.dqK());
                            aj.drv().Hl(this.lIY.dqL());
                        }
                    }
                }
            } else {
                aj.drv().reset();
            }
            doj();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lNl == null || !this.lNl.Hr(i)) ? false : true;
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
        PbActivity pbActivity = this.lME;
        if (i == 0) {
            this.lNl.drK();
            this.lNl.drM().doE();
            this.lNl.vz(false);
        }
        this.lNl.drO();
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
                        this.lNx.resetData();
                        this.lNx.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lNx.c(writeData);
                        com.baidu.tbadk.editortools.m sv = this.lNx.bEI().sv(6);
                        if (sv != null && sv.fDH != null) {
                            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lME;
                        if (i == -1) {
                            this.lNx.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lNl.drM() != null && this.lNl.drM().doI() != null) {
                            com.baidu.tbadk.editortools.pb.h doI = this.lNl.drM().doI();
                            doI.setThreadData(this.lIY.getPbData().dmE());
                            doI.c(writeData);
                            doI.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m sv2 = doI.bEI().sv(6);
                            if (sv2 != null && sv2.fDH != null) {
                                sv2.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lME;
                            if (i == -1) {
                                doI.bFM();
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
        this.lNx.onActivityResult(i, i2, intent);
        if (this.lMX != null) {
            this.lMX.onActivityResult(i, i2, intent);
        }
        if (doO().drM() != null) {
            doO().drM().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dpg();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.drv().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lIY != null) {
                                PbFragment.this.lIY.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dEA().E(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lIY != null) {
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
                        com.baidu.tieba.o.a.dEA().E(getPageContext());
                        doY();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jBj != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jBj.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bCg() {
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
                    this.lNl.uE(false);
                    if (this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null && this.lIY.getPbData().dmE().brK() != null) {
                        this.lIY.getPbData().dmE().brK().setStatus(2);
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
                        this.lNA = emotionImageData;
                        if (GV(com.baidu.tbadk.core.util.al.fcW)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lMY != null) {
                        this.lNl.dO(this.lMY);
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
            if (this.lMX == null) {
                this.lMX = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lME);
                this.lMX.b(this.fGh);
                this.lMX.c(this.fGo);
            }
            this.lMX.a(emotionImageData, dnV(), dnV().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpg() {
        MarkData Hi;
        if (this.lNj != null) {
            if (this.lIY.getPbData() != null && this.lIY.getPbData().dnh()) {
                Hi = this.lIY.Hi(0);
            } else {
                Hi = this.lIY.Hi(this.lNl.dss());
            }
            if (Hi != null) {
                if (!Hi.isApp() || (Hi = this.lIY.Hi(this.lNl.dss() + 1)) != null) {
                    this.lNl.dsn();
                    this.lNj.a(Hi);
                    if (!this.lNj.bnx()) {
                        this.lNj.bnz();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lNj.bny();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dph() {
        com.baidu.tieba.pb.data.f pbData = this.lIY.getPbData();
        this.lIY.vd(true);
        if (this.lNj != null) {
            pbData.PB(this.lNj.bnw());
        }
        this.lNl.s(pbData);
    }

    private boolean dpi() {
        if (this.lIY == null) {
            return true;
        }
        if (this.lIY.getPbData() == null || !this.lIY.getPbData().dnh()) {
            if (this.lIY.bnx()) {
                final MarkData dqr = this.lIY.dqr();
                if (dqr == null || !this.lIY.getIsFromMark()) {
                    return true;
                }
                final MarkData Hi = this.lIY.Hi(this.lNl.dsr());
                if (Hi == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dqr);
                    this.lME.setResult(-1, intent);
                    return true;
                } else if (Hi.getPostId() == null || Hi.getPostId().equals(dqr.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dqr);
                    this.lME.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Bp(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lNj != null) {
                                if (PbFragment.this.lNj.bnx()) {
                                    PbFragment.this.lNj.bny();
                                    PbFragment.this.lNj.jc(false);
                                }
                                PbFragment.this.lNj.a(Hi);
                                PbFragment.this.lNj.jc(true);
                                PbFragment.this.lNj.bnz();
                            }
                            dqr.setPostId(Hi.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqr);
                            PbFragment.this.lME.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.doj();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dqr);
                            PbFragment.this.lME.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.doj();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lNl != null && PbFragment.this.lNl.getView() != null) {
                                PbFragment.this.lNl.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dqr);
                                PbFragment.this.lME.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.doj();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.btX();
                    return false;
                }
            } else if (this.lIY.getPbData() == null || this.lIY.getPbData().dmG() == null || this.lIY.getPbData().dmG().size() <= 0 || !this.lIY.getIsFromMark()) {
                return true;
            } else {
                this.lME.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lNl == null) {
            return null;
        }
        return this.lNl.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLE() {
        if (this.lNl == null) {
            return 0;
        }
        return this.lNl.dsE();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLF() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
    public com.baidu.adp.lib.d.b<TextView> bLG() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLH() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czE */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
                    gifView.bGn();
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
    public com.baidu.adp.lib.d.b<View> bLI() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpG */
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
                    ((PlayVoiceBntNew) view).cfq();
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
    public com.baidu.adp.lib.d.b<RelativeLayout> bLK() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpH */
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
    public com.baidu.adp.lib.d.b<TbImageView> byl() {
        if (this.fof == null) {
            this.fof = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fof;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lMQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.Qc(str) && this.lIY != null && this.lIY.dpW() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").an("obj_param1", 1).dX("post_id", this.lIY.dpW()));
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
            au.dtm().f(getPageContext(), str);
        }
        this.lMQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        au.dtm().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lMQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lNl != null && this.lNl.dsU() != null && rect.top <= this.lNl.dsU().getHeight()) {
            rect.top += this.lNl.dsU().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lIY.getPbData();
            TbRichText bG = bG(str, i);
            if (bG != null && (tbRichTextData = bG.bKW().get(this.lOt)) != null) {
                aVar.postId = String.valueOf(bG.getPostId());
                aVar.lJl = new ArrayList<>();
                aVar.eMr = new ConcurrentHashMap<>();
                if (!tbRichTextData.bLc().bLn()) {
                    aVar.lJm = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lJl.add(c2);
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
                    imageUrlData.mIsReserver = this.lIY.dqp();
                    imageUrlData.mIsSeeHost = this.lIY.getHostMode();
                    aVar.eMr.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dmE() != null) {
                            aVar.threadId = pbData.dmE().getId();
                        }
                        aVar.eMp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lJm = true;
                int size = pbData.dmG().size();
                this.lOu = false;
                aVar.index = -1;
                int a2 = pbData.dmN() != null ? a(pbData.dmN().dPf(), bG, i, i, aVar.lJl, aVar.eMr) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dmG().get(i2);
                    if (postData.getId() == null || pbData.dmN() == null || pbData.dmN().getId() == null || !postData.getId().equals(pbData.dmN().getId())) {
                        a2 = a(postData.dPf(), bG, a2, i, aVar.lJl, aVar.eMr);
                    }
                }
                if (aVar.lJl.size() > 0) {
                    aVar.lastId = aVar.lJl.get(aVar.lJl.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dmE() != null) {
                        aVar.threadId = pbData.dmE().getId();
                    }
                    aVar.eMp = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return null;
        }
        return tbRichTextData.bLc().bLs();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return 0L;
        }
        return tbRichTextData.bLc().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return false;
        }
        return tbRichTextData.bLc().bLt();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bLc() == null) {
            return false;
        }
        return tbRichTextData.bLc().bLu();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bLc;
        String str;
        if (tbRichText == tbRichText2) {
            this.lOu = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bKW().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bKW().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bLc().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bLc().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bLc().bLn()) {
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
                            if (tbRichTextData != null && (bLc = tbRichTextData.bLc()) != null) {
                                String bLp = bLc.bLp();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bLc.bLq();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bLp;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lIY.dpW(), -1L);
                                imageUrlData.mIsReserver = this.lIY.dqp();
                                imageUrlData.mIsSeeHost = this.lIY.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lOu) {
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
        PostData dmN;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lIY.bry())) {
                z = true;
            }
            MarkData o = this.lIY.o(postData);
            if (this.lIY.getPbData() != null && this.lIY.getPbData().dnh() && (dmN = dmN()) != null) {
                o = this.lIY.o(dmN);
            }
            if (o != null) {
                this.lNl.dsn();
                if (this.lNj != null) {
                    this.lNj.a(o);
                    if (!z) {
                        this.lNj.bnz();
                    } else {
                        this.lNj.bny();
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
        if (this.lNl != null) {
            if (this.lNl.dpO()) {
                return true;
            }
            this.lNl.dtc();
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
                    this.lNH = ((TbImageView) view).getBdImage();
                    this.lNI = ((TbImageView) view).getUrl();
                    if (this.lNH == null || TextUtils.isEmpty(this.lNI)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNJ = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lNH = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lNI = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lNJ = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lNH = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lNI = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNJ = null;
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
                    this.lNl.a(this.lOw, this.lNH.isGif());
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
        if (this.kmq.dPd() == 1 && dI(view)) {
            this.lNl.a(this.lOw, this.lNH.isGif());
            return true;
        } else if (this.lNj == null) {
            return true;
        } else {
            if (!this.lNj.bnx() || this.kmq.getId() == null || !this.kmq.getId().equals(this.lIY.bry())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dnV().getPbData() != null && dnV().getPbData().dnh();
            if (this.kmq.dPd() == 1) {
                if (!z3) {
                    this.lNl.a(this.lOv, z, false);
                }
                return true;
            }
            if (this.lNq == null) {
                this.lNq = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lNq.a(this.lOi);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dI(view) && !z3;
                boolean z5 = (!dI(view) || this.lNH == null || this.lNH.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lNq));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lNq));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lNq);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.kmq);
                    gVar2.eXH.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lNq);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lNq);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.kmq);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eXH.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lNg) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lNq);
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
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lNq);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lNq);
                            gVar6.eXH.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lNq);
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
                        if (this.lIY.getPbData().dmT() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lNq);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lNq);
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
                if (com.baidu.tbadk.a.d.bmT()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kmq.btk(), sparseArray2, this.lNq), this.lMF));
                    this.lNq.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kmq));
                } else {
                    list = arrayList;
                }
                this.lNq.k(list, true);
                this.lNp = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lNq);
                this.lNp.SY();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dX("tid", this.lIY.lQw).dX("fid", this.lIY.getForumId()).dX("uid", this.lIY.getPbData().dmE().brq().getUserId()).dX("post_id", this.lIY.bFk()).an("obj_source", z2 ? 2 : 1));
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
        if (this.lIY == null || this.lIY.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lIY.getPbData();
        if (pbData.dmN() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dmN());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dmG = pbData.dmG();
            c(pbData, dmG);
            return c(dmG, str, i);
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
            if (dnV() != null) {
                dVar.eOD = dnV().dqH();
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
                if (this.lIY == null && this.lIY.getPbData() != null) {
                    this.fgY.a(dpD(), dVar, agreeData, this.lIY.getPbData().dmE());
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
            if (this.lIY == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dmS() != null && fVar.dmS().lHy != null && (list = fVar.dmS().lHy) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bKW;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dPf = arrayList.get(i2).dPf();
            if (dPf != null && (bKW = dPf.bKW()) != null) {
                int size = bKW.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bKW.get(i4) != null && bKW.get(i4).getType() == 8) {
                        i3++;
                        if (bKW.get(i4).bLc().bLp().equals(str) || bKW.get(i4).bLc().bLq().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bKW.get(i4).bLc().getWidth() * equipmentDensity;
                            int height = bKW.get(i4).bLc().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lOt = i4;
                            return dPf;
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
            this.lIU = str;
            if (this.lML == null) {
                doS();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lML.getItemView(1).setVisibility(8);
            } else {
                this.lML.getItemView(1).setVisibility(0);
            }
            this.lML.btZ();
            this.lMQ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jfh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpj() {
        hideNetRefreshView(this.lNl.getView());
        dpk();
        if (this.lIY.dqk()) {
            this.lNl.dsn();
        }
        this.lNl.dsy();
    }

    private void dpk() {
        showLoadingView(this.lNl.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lNl.dsU().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFz() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
        if (this.lME != null) {
            this.lME.cFz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GY(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, doX(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLJ() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpI */
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

    public void cFA() {
        if (this.lME != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lME.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lME.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cDY() {
        if (this.lIY == null || this.lIY.getPbData() == null) {
            return null;
        }
        return this.lIY.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.lVF)).intValue();
            if (intValue == ap.lVG) {
                if (!this.ggJ.dPY()) {
                    this.lNl.dsi();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.ggJ.TD(com.baidu.tbadk.core.util.at.S(jSONArray));
                    }
                    this.ggJ.a(this.lIY.getPbData().getForum().getId(), this.lIY.getPbData().getForum().getName(), this.lIY.getPbData().dmE().getId(), str, intValue3, intValue2, booleanValue, this.lIY.getPbData().dmE().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.lVH || intValue == ap.lVJ) {
                if (this.lIY.dqA() != null) {
                    this.lIY.dqA().GQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.lVH) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lNF);
        userMuteAddAndDelCustomMessage.setTag(this.lNF);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean PM(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0824a
    public void uS(boolean z) {
        this.lNr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dpl() {
        ArrayList<PostData> dmG;
        int count;
        if (this.lIY == null || this.lIY.getPbData() == null || this.lIY.getPbData().dmG() == null || (count = com.baidu.tbadk.core.util.x.getCount((dmG = this.lIY.getPbData().dmG()))) == 0) {
            return "";
        }
        if (this.lIY.dqp()) {
            Iterator<PostData> it = dmG.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dPd() == 1) {
                    return next.getId();
                }
            }
        }
        int dsr = this.lNl.dsr();
        PostData postData = (PostData) com.baidu.tbadk.core.util.x.getItem(dmG, dsr);
        if (postData == null || postData.brq() == null) {
            return "";
        }
        if (this.lIY.PQ(postData.brq().getUserId())) {
            return postData.getId();
        }
        for (int i = dsr - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.x.getItem(dmG, i);
            if (postData2 == null || postData2.brq() == null || postData2.brq().getUserId() == null) {
                break;
            } else if (this.lIY.PQ(postData2.brq().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dsr + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.x.getItem(dmG, i2);
            if (postData3 == null || postData3.brq() == null || postData3.brq().getUserId() == null) {
                return "";
            }
            if (this.lIY.PQ(postData3.brq().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aJ(Context context, String str) {
        this.lMQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a PN(String str) {
        String str2;
        if (this.lIY.getPbData() == null || this.lIY.getPbData().dmG() == null || this.lIY.getPbData().dmG().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lIY.getPbData().dmG().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lIY.getPbData().dmG().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lIY.getPbData().dmG().get(i);
        if (postData.dPf() == null || postData.dPf().bKW() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dPf().bKW().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bLc() != null) {
                    str2 = next.bLc().bLp();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dpm() {
        return (!this.lMG && this.lOy == -1 && this.lOz == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.s sVar) {
        if (sVar != null) {
            this.lOB = sVar;
            this.lMG = true;
            this.lNl.drY();
            this.lNl.Qa(this.lOA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpn() {
        if (this.lOB != null) {
            if (this.lOy == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lOB.getCartoonId(), this.lOy, 0)));
                this.lME.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpo() {
        if (this.lOB != null) {
            if (this.lOz == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lOB.getCartoonId(), this.lOz, 0)));
                this.lME.finish();
            }
        }
    }

    public int dpp() {
        return this.lOy;
    }

    public int dpq() {
        return this.lOz;
    }

    private void cUD() {
        if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null && this.lIY.getPbData().dmE().bpV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dpr() {
        if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null && this.lIY.getPbData().dmE().bpV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dps() {
        if (this.isPaused) {
            this.lMW = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null && this.lIY.getPbData().dmE().bqW() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lIY.getPbData().dmE().bqW().getThreadId(), this.lIY.getPbData().dmE().bqW().getTaskId(), this.lIY.getPbData().dmE().bqW().getForumId(), this.lIY.getPbData().dmE().bqW().getForumName(), this.lIY.getPbData().dmE().brl(), this.lIY.getPbData().dmE().brm())));
            this.lMI = true;
            this.lME.finish();
        }
    }

    public String dpt() {
        return this.lMU;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dpu() {
        return this.lNh;
    }

    public void uT(boolean z) {
        this.lMV = z;
    }

    public boolean boV() {
        if (this.lIY != null) {
            return this.lIY.dpZ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bp(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lND).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lND.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lND).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lND != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lND.getPageActivity());
            aVar.Bp(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lND).btX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lNl.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lND.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bp(this.lND.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bp(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lNl.showLoadingDialog();
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
        aVar.b(this.lND).btX();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.Qc(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
            if (this.lNl != null) {
                this.lNl.onConfigurationChanged(configuration);
            }
            if (this.lNp != null) {
                this.lNp.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dpw() {
        if (this.lIY != null) {
            return this.lIY.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lIY.getPbData().dmS().lHy;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dPa().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dPa().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dPa().remove(i2);
                    list.get(i).dPc();
                    z = true;
                    break;
                }
            }
            list.get(i).Tp(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lIY.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dnx().getId();
        List<PostData> list = this.lIY.getPbData().dmS().lHy;
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
                ArrayList<PostData> dnF = pVar.dnF();
                postData.KQ(pVar.getTotalCount());
                if (postData.dPa() != null) {
                    postData.dPa().clear();
                    postData.dPa().addAll(dnF);
                }
            }
        }
        if (!this.lIY.getIsFromMark()) {
            this.lNl.s(this.lIY.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dnM() {
        return this.lME.dnM();
    }

    public boolean dnN() {
        if (this.lIY == null) {
            return false;
        }
        return this.lIY.dnN();
    }

    public void uU(boolean z) {
        this.lMT = z;
    }

    public boolean dpx() {
        return this.lMT;
    }

    public void dpy() {
        if (this.lNl != null) {
            this.lNl.drK();
            cFA();
        }
    }

    public PostData dmN() {
        return this.lNl.b(this.lIY.lKf, this.lIY.dpY());
    }

    public void onBackPressed() {
        if (this.lNM != null && !this.lNM.isEmpty()) {
            int size = this.lNM.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lNM.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lNM == null) {
                this.lNM = new ArrayList();
            }
            if (!this.lNM.contains(aVar)) {
                this.lNM.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lNM == null) {
                this.lNM = new ArrayList();
            }
            if (!this.lNM.contains(aVar)) {
                this.lNM.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lNM != null) {
            this.lNM.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.af.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpz() {
        if (this.lIY != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lIY.dpW())) {
            com.baidu.tbadk.BdToken.c.bkT().p(com.baidu.tbadk.BdToken.b.eEL, com.baidu.adp.lib.f.b.toLong(this.lIY.dpW(), 0L));
        }
    }

    public bi dpA() {
        return this.lNd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PO(String str) {
        if (this.lIY != null && this.lIY.getPbData() != null && this.lIY.getPbData().dmE() != null && this.lIY.getPbData().dmE().bpZ()) {
            bz dmE = this.lIY.getPbData().dmE();
            int i = 0;
            if (dmE.bpX()) {
                i = 1;
            } else if (dmE.bpY()) {
                i = 2;
            } else if (dmE.bto()) {
                i = 3;
            } else if (dmE.btp()) {
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
            /* renamed from: bop */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.doX(), i2, PbFragment.this.lIY);
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
    public PbFragment dpB() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dpC() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dpD() {
        return this.lME;
    }
}
