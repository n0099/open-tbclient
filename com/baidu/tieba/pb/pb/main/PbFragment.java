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
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
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
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.o;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0714a {
    private az dEN;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    private com.baidu.adp.lib.d.b<TextView> eOC;
    private com.baidu.adp.lib.d.b<View> eOD;
    private com.baidu.adp.lib.d.b<LinearLayout> eOE;
    private com.baidu.adp.lib.d.b<RelativeLayout> eOF;
    private com.baidu.adp.lib.d.b<TbImageView> efk;
    private LikeModel egK;
    private com.baidu.tieba.callfans.a gRZ;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private com.baidu.tieba.f.b hEm;
    private VoiceManager hzJ;
    public com.baidu.tbadk.core.util.ak jhL;
    private String kbB;
    private PbActivity keN;
    private com.baidu.tieba.pb.pb.main.b.b keP;
    private com.baidu.tieba.tbadkCore.data.f kfB;
    private com.baidu.tbadk.editortools.pb.g kfC;
    private com.baidu.tbadk.editortools.pb.e kfD;
    private com.baidu.tieba.frs.profession.permission.c kfF;
    private EmotionImageData kfG;
    private com.baidu.adp.base.e kfJ;
    private com.baidu.tbadk.core.view.c kfK;
    private BdUniqueId kfL;
    private Runnable kfM;
    private com.baidu.adp.widget.ImageView.a kfN;
    private String kfO;
    private TbRichTextMemeInfo kfP;
    private List<a> kfS;
    public String kfU;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kfe;
    private View kff;
    int kfh;
    private bd kfk;
    private com.baidu.tieba.pb.pb.report.a kfn;
    public ax kfu;
    private com.baidu.tbadk.core.dialog.i kfv;
    private com.baidu.tbadk.core.dialog.k kfw;
    private boolean kfx;
    private String kgE;
    private com.baidu.tbadk.core.data.r kgF;
    private boolean kgu;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a kgB = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.f.b.a
        public void ce(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cHS();
            } else {
                com.baidu.tieba.pb.a.b.cHR();
            }
        }
    };
    private boolean keO = false;
    private boolean keQ = false;
    private boolean bjF = false;
    private boolean jBc = false;
    private boolean keR = true;
    private int keS = 0;
    private com.baidu.tbadk.core.dialog.b keT = null;
    private long hcE = -1;
    private long eAY = 0;
    private long keU = 0;
    private long createTime = 0;
    private long eAO = 0;
    private boolean keV = false;
    private com.baidu.tbadk.n.b keW = null;
    private long keX = 0;
    private boolean keY = false;
    private long keZ = 0;
    private int ico = 1;
    private String evB = null;
    private boolean kfa = false;
    private boolean isFullScreen = false;
    private String kfb = "";
    private boolean kfc = true;
    private boolean kfd = false;
    private String source = "";
    private int mSkinType = 3;
    int[] kfg = new int[2];
    private int kfi = -1;
    private int kfj = -1;
    public BdUniqueId kfl = BdUniqueId.gen();
    private PbInterviewStatusView.a kfm = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.kfq.sh(!PbFragment.this.kfc);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kbF != null && PbFragment.this.kbF.aOo()) {
                        PbFragment.this.cJn();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kbF = null;
    private com.baidu.tbadk.baseEditMark.a kfo = null;
    private ForumManageModel gRX = null;
    private com.baidu.tbadk.coreExtra.model.a dUB = null;
    private com.baidu.tieba.pb.data.o kfp = null;
    private ShareSuccessReplyToServerModel hRN = null;
    private av kfq = null;
    private boolean kfr = false;
    private boolean kfs = false;
    private boolean kft = false;
    private boolean fdc = false;
    private boolean kfy = false;
    private boolean kfz = false;
    private boolean kfA = false;
    private boolean kfE = false;
    public boolean kfH = false;
    private com.baidu.tbadk.editortools.pb.c evE = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bfz() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b evF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bfy() {
            if (PbFragment.this.kfu == null || PbFragment.this.kfu.cNa() == null || !PbFragment.this.kfu.cNa().dqK()) {
                return !PbFragment.this.Bj(com.baidu.tbadk.core.util.ak.dUw);
            }
            PbFragment.this.showToast(PbFragment.this.kfu.cNa().dqM());
            if (PbFragment.this.kfD != null && (PbFragment.this.kfD.bfP() || PbFragment.this.kfD.bfQ())) {
                PbFragment.this.kfD.a(false, PbFragment.this.kfu.cNd());
            }
            PbFragment.this.kfu.st(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b kfI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bfy() {
            if (PbFragment.this.kfu == null || PbFragment.this.kfu.cNb() == null || !PbFragment.this.kfu.cNb().dqK()) {
                return !PbFragment.this.Bj(com.baidu.tbadk.core.util.ak.dUx);
            }
            PbFragment.this.showToast(PbFragment.this.kfu.cNb().dqM());
            if (PbFragment.this.kfq != null && PbFragment.this.kfq.cLL() != null && PbFragment.this.kfq.cLL().cIO() != null && PbFragment.this.kfq.cLL().cIO().bfQ()) {
                PbFragment.this.kfq.cLL().cIO().a(PbFragment.this.kfu.cNd());
            }
            PbFragment.this.kfu.su(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean hAx = false;
    private int kfQ = 0;
    private int kfR = -1;
    public int kfT = 0;
    private final a kfV = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.kfq != null && PbFragment.this.kfq.cLL() != null) {
                t cLL = PbFragment.this.kfq.cLL();
                if (cLL.cIM()) {
                    cLL.cIL();
                    return true;
                }
            }
            if (PbFragment.this.kfq != null && PbFragment.this.kfq.cMJ()) {
                PbFragment.this.kfq.cMK();
                return true;
            }
            return false;
        }
    };
    private final ae.a kfW = new ae.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void aX(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ae.a
        public void m(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.kfq.showToast(str);
            }
        }
    };
    private final CustomMessageListener kfX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kbF != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.kfD != null) {
                    PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                }
                PbFragment.this.kfq.cLN();
                PbFragment.this.kfq.cMB();
            }
        }
    };
    CustomMessageListener hBj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbFragment.this.kbF.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbFragment.this.kfq != null && PbFragment.this.kbF != null) {
                    PbFragment.this.kfq.b(PbFragment.this.kbF.getPbData(), PbFragment.this.kbF.cKb(), PbFragment.this.kbF.cKy(), PbFragment.this.kfq.getSkinType());
                }
                if (PbFragment.this.kfq != null && PbFragment.this.kfq.cMe() != null) {
                    PbFragment.this.kfq.cMe().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener kfY = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.kfq != null) {
                    if (booleanValue) {
                        PbFragment.this.kfq.crG();
                    } else {
                        PbFragment.this.kfq.crF();
                    }
                }
            }
        }
    };
    private CustomMessageListener kfZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.kfD != null) {
                    PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                }
                PbFragment.this.kfq.so(false);
            }
        }
    };
    private CustomMessageListener kga = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.n) eVar.getData());
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
    private CustomMessageListener kgb = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kfq != null && PbFragment.this.kfq.cMe() != null) {
                PbFragment.this.kfq.cMe().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener iLF = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener hBf = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bjF) {
                PbFragment.this.cJE();
            }
        }
    };
    private View.OnClickListener ewn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.evB);
        }
    };
    private CustomMessageListener kgc = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ae)) {
                com.baidu.tbadk.core.data.ae aeVar = (com.baidu.tbadk.core.data.ae) customResponsedMessage.getData();
                av.a aVar = new av.a();
                aVar.giftId = aeVar.id;
                aVar.giftName = aeVar.name;
                aVar.thumbnailUrl = aeVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.kbF.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kbF.cKp() != null && PbFragment.this.kbF.cKp().getUserIdLong() == aeVar.toUserId) {
                        PbFragment.this.kfq.a(aeVar.sendCount, PbFragment.this.kbF.getPbData(), PbFragment.this.kbF.cKb(), PbFragment.this.kbF.cKy());
                    }
                    if (pbData.cGP() != null && pbData.cGP().size() >= 1 && pbData.cGP().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.cGP().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kbF.cJZ(), 0L);
                        if (j == aeVar.postId && j2 == aeVar.threadId) {
                            com.baidu.tbadk.core.data.av dig = pbData.cGP().get(0).dig();
                            if (dig == null) {
                                dig = new com.baidu.tbadk.core.data.av();
                            }
                            ArrayList<av.a> aRh = dig.aRh();
                            if (aRh == null) {
                                aRh = new ArrayList<>();
                            }
                            aRh.add(0, aVar);
                            dig.setTotal(aeVar.sendCount + dig.getTotal());
                            dig.w(aRh);
                            pbData.cGP().get(0).a(dig);
                            PbFragment.this.kfq.cMe().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.JM(str);
                PbFragment.this.kbF.cKu();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kbF.getPbData().cGP() != null) {
                    ArrayList<PostData> cGP = PbFragment.this.kbF.getPbData().cGP();
                    Iterator<PostData> it = cGP.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            nVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof com.baidu.tieba.tbadkCore.data.n) && str.equals(((com.baidu.tieba.tbadkCore.data.n) next).getAdId())) {
                            nVar = (com.baidu.tieba.tbadkCore.data.n) next;
                            break;
                        }
                    }
                    if (nVar != null) {
                        cGP.remove(nVar);
                        if (PbFragment.this.kfq.cMe() != null && PbFragment.this.kfq.cMe().getDataList() != null) {
                            PbFragment.this.kfq.cMe().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.kfq.getListView() != null && PbFragment.this.kfq.getListView().getData() != null) {
                            PbFragment.this.kfq.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.kfq.cMe() != null) {
                            PbFragment.this.kfq.cMe().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.kfq.cMe() != null) {
                    PbFragment.this.kfq.s(PbFragment.this.kbF.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a kgd = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cNt()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a kge = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aX(List<String> list) {
            if (!com.baidu.tbadk.core.util.w.isEmpty(list) && PbFragment.this.kfq != null) {
                PbFragment.this.kfq.eo(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean kgf = false;
    private PraiseModel kgg = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void AG(String str) {
            PbFragment.this.kgf = false;
            if (PbFragment.this.kgg != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.kbF.getPbData();
                if (pbData.cGN().aSa().getIsLike() == 1) {
                    PbFragment.this.vx(0);
                } else {
                    PbFragment.this.vx(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cGN()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.kgf = false;
            if (PbFragment.this.kgg != null && str != null) {
                if (AntiHelper.bA(i, str)) {
                    AntiHelper.aX(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a kgh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void rM(boolean z) {
            PbFragment.this.rL(z);
            if (PbFragment.this.kfq.cMP() != null && z) {
                PbFragment.this.kfq.sh(false);
            }
            PbFragment.this.kfq.sj(z);
        }
    };
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().els != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().els, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.cGW().aSp() != null && PbFragment.this.cGW().aSp().getGodUserData() != null) {
                            PbFragment.this.cGW().aSp().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null) {
                            PbFragment.this.kbF.getPbData().cGN().aSp().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h hyP = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.keN.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a kgi = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.kfq.bJm();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Bl(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.chw();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c eor = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cIX();
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
                        if (PbFragment.this.cC(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.kfq.cIV() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10630").dk("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.cHT() != null && PbFragment.this.cHT().hjK != null) {
                                PbFragment.this.cHT().hjK.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.d(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.kfD != null) {
                    PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                }
                PbFragment.this.kfq.cLN();
                PbFragment.this.kfq.cMB();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener kgj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kfL) {
                PbFragment.this.kfq.bJm();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.kbF.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cHd().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kfK.showSuccessToast(PbFragment.this.kfJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.kfJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.yH(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cJB();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ar.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.kfJ.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.kfK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kgk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kfL) {
                PbFragment.this.kfq.bJm();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.kfK.showSuccessToast(PbFragment.this.kfJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ar.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.kfJ.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.kfK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kgl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.kfL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.kfq.bJm();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.lUh;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.ar.isEmpty(str)) {
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
                    PbFragment.this.kfq.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener kgm = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kfq.cLO() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cIX();
            }
        }
    };
    private CustomMessageListener hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.hAx = true;
                }
            }
        }
    };
    public a.b jMp = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bYx();
            com.baidu.tbadk.core.data.at pageData = PbFragment.this.kbF.getPageData();
            int pageNum = PbFragment.this.kfq.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aRa()) {
                PbFragment.this.kfq.cMB();
                PbFragment.this.bYw();
                PbFragment.this.kfq.cMi();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kbF.Bp(PbFragment.this.kfq.getPageNum());
                    if (PbFragment.this.keP != null) {
                        PbFragment.this.keP.showFloatingView();
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
    public final View.OnClickListener hCn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        /* JADX WARN: Removed duplicated region for block: B:664:0x1dff  */
        /* JADX WARN: Removed duplicated region for block: B:667:0x1e46  */
        /* JADX WARN: Removed duplicated region for block: B:684:0x2054  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            String name;
            int i;
            int i2;
            bz bzVar;
            String[] strArr;
            com.baidu.tieba.pb.data.e pbData;
            boolean y;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.kfq.cMx()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kbF.rR(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.kfq.cMj();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLn()) {
                        if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLo()) {
                            if (view == PbFragment.this.kfq.klZ.eDr) {
                                if (PbFragment.this.kfq.sl(PbFragment.this.kbF.cKg())) {
                                    PbFragment.this.bYw();
                                    return;
                                }
                                PbFragment.this.keR = false;
                                PbFragment.this.keQ = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.keN, PbFragment.this.kfq.klZ.eDr);
                                PbFragment.this.keN.finish();
                            } else if (view != PbFragment.this.kfq.cMg() && (PbFragment.this.kfq.klZ.cNG() == null || (view != PbFragment.this.kfq.klZ.cNG().cLm() && view != PbFragment.this.kfq.klZ.cNG().cLk()))) {
                                if (view == PbFragment.this.kfq.cMF()) {
                                    if (PbFragment.this.kbF != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbF.getPbData().cGN().aSo().getLink());
                                    }
                                } else if (view != PbFragment.this.kfq.klZ.kst) {
                                    if (view == PbFragment.this.kfq.klZ.ksu) {
                                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                            ArrayList<PostData> cGP = PbFragment.this.kbF.getPbData().cGP();
                                            if ((cGP == null || cGP.size() <= 0) && PbFragment.this.kbF.cKb()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12378").dk("tid", PbFragment.this.kbF.cJZ()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fid", PbFragment.this.kbF.getForumId()));
                                            if (!PbFragment.this.kfq.cMU()) {
                                                PbFragment.this.kfq.cLN();
                                            }
                                            PbFragment.this.cJf();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.kfq.rA(true);
                                            PbFragment.this.kfq.cLN();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.kfq.crG();
                                                PbFragment.this.bYw();
                                                PbFragment.this.kfq.cMi();
                                                PbFragment.this.kbF.JT(PbFragment.this.cJr());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLj()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.kfq.klZ.cNG() != null && view == PbFragment.this.kfq.klZ.cNG().cLi()) {
                                                PbFragment.this.kfq.klZ.aFg();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Bm(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLg()) {
                                                    if ((PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLq()) && view.getId() != R.id.pb_sort) {
                                                        if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLh()) {
                                                            if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLr()) {
                                                                if (PbFragment.this.kfq.cMP() == view) {
                                                                    if (PbFragment.this.kfq.cMP().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.kbF.getPbData();
                                                                        if (pbData2 != null && pbData2.cGN() != null && pbData2.cGN().aRV() != null) {
                                                                            String aRL = pbData2.cGN().aRV().aRL();
                                                                            if (StringUtils.isNull(aRL)) {
                                                                                aRL = pbData2.cGN().aRV().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11107").dk("obj_id", aRL));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.fy("c10725", null);
                                                                    }
                                                                    PbFragment.this.cJy();
                                                                } else if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLp()) {
                                                                    if (PbFragment.this.kfq.klZ.cNG() != null && view == PbFragment.this.kfq.klZ.cNG().cLl()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.kfq.b(PbFragment.this.kbF.getPbData(), PbFragment.this.kbF.cKb(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.kfq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.kfq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.kfq.klZ.aFg();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13398");
                                                                            aoVar.dk("tid", PbFragment.this.kbF.cJZ());
                                                                            aoVar.dk("fid", PbFragment.this.kbF.getForumId());
                                                                            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aoVar.ag("obj_locate", 4);
                                                                            TiebaStatic.log(aoVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                PbFragment.this.kfq.cMB();
                                                                                SparseArray sparseArray = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                                View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dik() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12630"));
                                                                                    }
                                                                                    if (postData.lGI != null) {
                                                                                        com.baidu.tbadk.core.util.ao aWM = postData.lGI.aWM();
                                                                                        aWM.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            aWM.ag("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            aWM.ag("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(aWM);
                                                                                    }
                                                                                    String cJZ = PbFragment.this.kbF.cJZ();
                                                                                    String id = postData.getId();
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kbF.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kbF.getPbData().cHc();
                                                                                    }
                                                                                    PbFragment.this.bYw();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a JR = PbFragment.this.JR(id);
                                                                                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && JR != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ, id, "pb", true, null, true, null, i3, postData.cOE(), PbFragment.this.kbF.getPbData().getAnti(), false, postData.aSp().getIconInfo()).addBigImageData(JR.kbN, JR.kbO, JR.kbP, JR.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kbF.cKJ());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kbF.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kbF.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kbF.cKi());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a JR2 = PbFragment.this.JR(id);
                                                                                        if (postData != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && JR2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ, id, "pb", true, null, false, null, i3, postData.cOE(), PbFragment.this.kbF.getPbData().getAnti(), false, postData.aSp().getIconInfo()).addBigImageData(JR2.kbN, JR2.kbO, JR2.kbP, JR2.index);
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kbF.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kbF.cKi());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kbF.cKJ());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kbF.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10517").ag("obj_locate", 3).dk("fid", PbFragment.this.kbF.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kbF != null) {
                                                                            com.baidu.tbadk.core.util.ao aoVar2 = new com.baidu.tbadk.core.util.ao("c13398");
                                                                            aoVar2.dk("tid", PbFragment.this.kbF.cJZ());
                                                                            aoVar2.dk("fid", PbFragment.this.kbF.getForumId());
                                                                            aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aoVar2.ag("obj_locate", 5);
                                                                            TiebaStatic.log(aoVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                    if (postData2.lGI != null) {
                                                                                        com.baidu.tbadk.core.util.ao aWM2 = postData2.lGI.aWM();
                                                                                        aWM2.delete("obj_locate");
                                                                                        aWM2.ag("obj_locate", 8);
                                                                                        TiebaStatic.log(aWM2);
                                                                                    }
                                                                                    if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                        String cJZ2 = PbFragment.this.kbF.cJZ();
                                                                                        String id2 = postData2.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kbF.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kbF.getPbData().cHc();
                                                                                        }
                                                                                        PbActivity.a JR3 = PbFragment.this.JR(id2);
                                                                                        if (JR3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ2, id2, "pb", true, null, false, null, i4, postData2.cOE(), PbFragment.this.kbF.getPbData().getAnti(), false, postData2.aSp().getIconInfo()).addBigImageData(JR3.kbN, JR3.kbO, JR3.kbP, JR3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kbF.cKJ());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kbF.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kbF.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kbF.cKi());
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
                                                                    } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img) {
                                                                        if (PbFragment.this.kbF != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ao aoVar3 = new com.baidu.tbadk.core.util.ao("c13398");
                                                                                aoVar3.dk("tid", PbFragment.this.kbF.cJZ());
                                                                                aoVar3.dk("fid", PbFragment.this.kbF.getForumId());
                                                                                aoVar3.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aoVar3.ag("obj_locate", 6);
                                                                                TiebaStatic.log(aoVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData3.lGI != null) {
                                                                                        com.baidu.tbadk.core.util.ao aWM3 = postData3.lGI.aWM();
                                                                                        aWM3.delete("obj_locate");
                                                                                        aWM3.ag("obj_locate", 8);
                                                                                        TiebaStatic.log(aWM3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13700").dk("tid", PbFragment.this.kbF.cKa()).dk("fid", PbFragment.this.kbF.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).dk("post_id", postData3.getId()).ag("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.cIU().cLK() != null && postData3.aSp() != null && postData3.dhY() != 1) {
                                                                                        if (PbFragment.this.cIU().cLL() != null) {
                                                                                            PbFragment.this.cIU().cLL().cIK();
                                                                                        }
                                                                                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                                                                                        nVar.a(PbFragment.this.kbF.getPbData().getForum());
                                                                                        nVar.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                                                                                        nVar.g(postData3);
                                                                                        PbFragment.this.cIU().cLK().d(nVar);
                                                                                        PbFragment.this.cIU().cLK().setPostId(postData3.getId());
                                                                                        PbFragment.this.b(view, postData3.aSp().getUserId(), "");
                                                                                        if (PbFragment.this.kfD != null) {
                                                                                            PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
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
                                                                    } else if (view != PbFragment.this.kfq.cIo()) {
                                                                        if (view == PbFragment.this.kfq.klZ.cNH()) {
                                                                            PbFragment.this.kfq.cMp();
                                                                        } else {
                                                                            int id3 = view.getId();
                                                                            if (id3 == R.id.pb_u9_text_view) {
                                                                                if (PbFragment.this.checkUpIsLogin() && (bzVar = (bz) view.getTag()) != null && !StringUtils.isNull(bzVar.aUF())) {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                    bc.aWU().b(PbFragment.this.getPageContext(), new String[]{bzVar.aUF()});
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                if (PbFragment.this.checkUpIsLogin()) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11740"));
                                                                                    if (view != null && view.getTag() != null) {
                                                                                        SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                        PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                        if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12006").dk("tid", PbFragment.this.kbF.kig));
                                                                                        }
                                                                                        if (PbFragment.this.kfw == null) {
                                                                                            PbFragment.this.kfw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                            PbFragment.this.kfw.a(PbFragment.this.kgA);
                                                                                        }
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        PbFragment.this.cE(view);
                                                                                        if (!PbFragment.this.cE(view) || PbFragment.this.kfN == null || !PbFragment.this.kfN.isGif()) {
                                                                                        }
                                                                                        boolean z2 = false;
                                                                                        boolean z3 = false;
                                                                                        boolean z4 = false;
                                                                                        boolean z5 = false;
                                                                                        boolean z6 = false;
                                                                                        String str = null;
                                                                                        if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                            ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                            z2 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                            z3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                            z4 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                            z5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                            z6 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                        }
                                                                                        if (sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                            str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                        }
                                                                                        if (postData4 != null) {
                                                                                            if (postData4.dia() != null && postData4.dia().toString().length() > 0) {
                                                                                                com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kfw);
                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                                gVar4.mTextView.setTag(sparseArray5);
                                                                                                arrayList.add(gVar4);
                                                                                            }
                                                                                            PbFragment.this.izC = postData4;
                                                                                        }
                                                                                        if (PbFragment.this.kbF.getPbData().aOo()) {
                                                                                            String aOn = PbFragment.this.kbF.getPbData().aOn();
                                                                                            if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(aOn) && aOn.equals(postData4.getId())) {
                                                                                                z = true;
                                                                                                if (!z) {
                                                                                                    gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kfw);
                                                                                                } else {
                                                                                                    gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kfw);
                                                                                                }
                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                sparseArray6.put(R.id.tag_clip_board, PbFragment.this.izC);
                                                                                                sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                                gVar.mTextView.setTag(sparseArray6);
                                                                                                arrayList.add(gVar);
                                                                                                if (PbFragment.this.mIsLogin) {
                                                                                                    if (!z4 && z3) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kfw);
                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                        sparseArray7.put(R.id.tag_user_mute_visible, true);
                                                                                                        sparseArray7.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                        sparseArray7.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                        sparseArray7.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                        sparseArray7.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                        sparseArray7.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                        sparseArray7.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                        sparseArray7.put(R.id.tag_del_post_is_self, sparseArray4.get(R.id.tag_del_post_is_self));
                                                                                                        sparseArray7.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        sparseArray7.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                        gVar.mTextView.setTag(sparseArray7);
                                                                                                        arrayList.add(gVar5);
                                                                                                    } else {
                                                                                                        if (PbFragment.this.rH(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kfw);
                                                                                                            gVar6.mTextView.setTag(str);
                                                                                                            arrayList.add(gVar6);
                                                                                                        }
                                                                                                    }
                                                                                                    if (z4) {
                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                        sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                        sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                        sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                        sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                        sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                        if (z5) {
                                                                                                            sparseArray8.put(R.id.tag_user_mute_visible, true);
                                                                                                            sparseArray8.put(R.id.tag_is_mem, sparseArray4.get(R.id.tag_is_mem));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_userid, sparseArray4.get(R.id.tag_user_mute_mute_userid));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_username, sparseArray4.get(R.id.tag_user_mute_mute_username));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_mute_nameshow, sparseArray4.get(R.id.tag_user_mute_mute_nameshow));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_post_id, sparseArray4.get(R.id.tag_user_mute_post_id));
                                                                                                            sparseArray8.put(R.id.tag_user_mute_thread_id, sparseArray4.get(R.id.tag_user_mute_thread_id));
                                                                                                        } else {
                                                                                                            sparseArray8.put(R.id.tag_user_mute_visible, false);
                                                                                                        }
                                                                                                        if (z6) {
                                                                                                            sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                            sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                            sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                            gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kfw);
                                                                                                            gVar2.mTextView.setTag(sparseArray8);
                                                                                                        } else {
                                                                                                            sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                            gVar2 = null;
                                                                                                        }
                                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kfw);
                                                                                                        gVar3.mTextView.setTag(sparseArray8);
                                                                                                    } else if (!z6) {
                                                                                                        gVar2 = null;
                                                                                                        gVar3 = null;
                                                                                                    } else {
                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                        sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                        sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                        sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                        sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                                        sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        if (PbFragment.this.kbF.getPbData().cHc() == 1002 && !z2) {
                                                                                                            gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kfw);
                                                                                                        } else {
                                                                                                            gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kfw);
                                                                                                        }
                                                                                                        gVar2.mTextView.setTag(sparseArray9);
                                                                                                        gVar3 = null;
                                                                                                    }
                                                                                                    if (gVar2 != null) {
                                                                                                        arrayList.add(gVar2);
                                                                                                    }
                                                                                                    if (gVar3 != null) {
                                                                                                        arrayList.add(gVar3);
                                                                                                    }
                                                                                                }
                                                                                                PbFragment.this.kfw.aL(arrayList);
                                                                                                PbFragment.this.kfv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kfw);
                                                                                                PbFragment.this.kfv.showDialog();
                                                                                            }
                                                                                        }
                                                                                        z = false;
                                                                                        if (!z) {
                                                                                        }
                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                        sparseArray62.put(R.id.tag_clip_board, PbFragment.this.izC);
                                                                                        sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                        gVar.mTextView.setTag(sparseArray62);
                                                                                        arrayList.add(gVar);
                                                                                        if (PbFragment.this.mIsLogin) {
                                                                                        }
                                                                                        PbFragment.this.kfw.aL(arrayList);
                                                                                        PbFragment.this.kfv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kfw);
                                                                                        PbFragment.this.kfv.showDialog();
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.pb_act_btn) {
                                                                                if (PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().getActUrl() != null) {
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kbF.getPbData().cGN().getActUrl());
                                                                                    if (PbFragment.this.kbF.getPbData().cGN().aTc() != 1) {
                                                                                        if (PbFragment.this.kbF.getPbData().cGN().aTc() == 2) {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                    }
                                                                                }
                                                                            } else if (id3 == R.id.lottery_tail) {
                                                                                if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                    String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10912").dk("fid", PbFragment.this.kbF.getPbData().getForumId()).dk("tid", PbFragment.this.kbF.getPbData().getThreadId()).dk("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                    if (PbFragment.this.kbF.getPbData().getThreadId().equals(str2)) {
                                                                                        PbFragment.this.kfq.setSelection(0);
                                                                                    } else {
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                    }
                                                                                }
                                                                            } else if (id3 == R.id.pb_item_tail_content) {
                                                                                if (be.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                    String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("tail_link", "");
                                                                                    if (!StringUtils.isNull(string2)) {
                                                                                        TiebaStatic.log("c10056");
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                    }
                                                                                    PbFragment.this.kfq.cLN();
                                                                                }
                                                                            } else if (id3 == R.id.join_vote_tv) {
                                                                                if (view != null) {
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                    if (PbFragment.this.cJd() == 1 && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10397").dk("fid", PbFragment.this.kbF.getPbData().getForumId()).dk("tid", PbFragment.this.kbF.getPbData().getThreadId()).dk("uid", currentAccount));
                                                                                    }
                                                                                }
                                                                            } else if (id3 == R.id.look_all_tv) {
                                                                                if (view != null) {
                                                                                    String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                    if (PbFragment.this.cJd() == 1 && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10507").dk("fid", PbFragment.this.kbF.getPbData().getForumId()).dk("tid", PbFragment.this.kbF.getPbData().getThreadId()).dk("uid", currentAccount2));
                                                                                    }
                                                                                }
                                                                            } else if (id3 == R.id.manga_prev_btn) {
                                                                                PbFragment.this.cJt();
                                                                            } else if (id3 == R.id.manga_next_btn) {
                                                                                PbFragment.this.cJu();
                                                                            } else if (id3 == R.id.yule_head_img_img) {
                                                                                if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cHi() != null) {
                                                                                    com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.kbF.getPbData();
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11679").dk("fid", pbData3.getForumId()));
                                                                                    bc.aWU().b(PbFragment.this.getPageContext(), new String[]{pbData3.cHi().cHu()});
                                                                                }
                                                                            } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cHi() != null) {
                                                                                    com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.kbF.getPbData();
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11678").dk("fid", pbData4.getForumId()));
                                                                                    bc.aWU().b(PbFragment.this.getPageContext(), new String[]{pbData4.cHi().cHu()});
                                                                                }
                                                                            } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                if (PbFragment.this.kfQ >= 0) {
                                                                                    if (PbFragment.this.kbF != null) {
                                                                                        PbFragment.this.kbF.cKK();
                                                                                    }
                                                                                    if (PbFragment.this.kbF != null && PbFragment.this.kfq.cMe() != null) {
                                                                                        PbFragment.this.kfq.cMe().a(PbFragment.this.kbF.getPbData(), false);
                                                                                    }
                                                                                    PbFragment.this.kfQ = 0;
                                                                                    if (PbFragment.this.kbF != null) {
                                                                                        PbFragment.this.kfq.getListView().setSelection(PbFragment.this.kbF.cKN());
                                                                                        PbFragment.this.kbF.cJ(0, 0);
                                                                                    }
                                                                                }
                                                                            } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                    TiebaStatic.log("c12640");
                                                                                }
                                                                            } else if (id3 == R.id.thread_info_commont_container) {
                                                                                if (PbFragment.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                    PbFragment.this.Bm(8);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                SparseArray sparseArray10 = null;
                                                                                if (view.getTag() instanceof SparseArray) {
                                                                                    sparseArray10 = (SparseArray) view.getTag();
                                                                                }
                                                                                if (sparseArray10 != null) {
                                                                                    PbFragment.this.d(sparseArray10);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                if (PbFragment.this.kfq.getListView() != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                    int firstVisiblePosition = PbFragment.this.kfq.getListView().getFirstVisiblePosition();
                                                                                    View childAt = PbFragment.this.kfq.getListView().getChildAt(0);
                                                                                    int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                    boolean cHm = PbFragment.this.kbF.getPbData().cHm();
                                                                                    boolean z7 = PbFragment.this.kfq.cLM() != null && PbFragment.this.kfq.cLM().bAr();
                                                                                    boolean cMy = PbFragment.this.kfq.cMy();
                                                                                    boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                    int i5 = 0;
                                                                                    if (cHm && PbFragment.this.kfq.cLM() != null && PbFragment.this.kfq.cLM().bua() != null) {
                                                                                        int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.kfq.cLM().cNq();
                                                                                        z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.kfq.cLM().bua().getHeight() - PbFragment.this.kfq.cLM().cNq());
                                                                                        i5 = equipmentWidth;
                                                                                    }
                                                                                    PbFragment.this.JS("c13568");
                                                                                    if ((PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSg() <= 0) || (cMy && z8)) {
                                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                                            PbFragment.this.cJa();
                                                                                            if (PbFragment.this.kbF.getPbData().cGN().aSp() != null) {
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13402").dk("tid", PbFragment.this.kbF.kig).dk("fid", PbFragment.this.kbF.getPbData().getForumId()).ag("obj_locate", 2).dk("uid", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()));
                                                                                            }
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        boolean z9 = false;
                                                                                        int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                        if (cHm) {
                                                                                            if (PbFragment.this.kfq.knj != null && PbFragment.this.kfq.knj.kon != null && PbFragment.this.kfq.knj.kon.getView() != null) {
                                                                                                if (PbFragment.this.kfq.knj.kon.getView().getParent() == null) {
                                                                                                    z9 = firstVisiblePosition >= PbFragment.this.cJj();
                                                                                                } else {
                                                                                                    int i6 = 0;
                                                                                                    if (PbFragment.this.kfq.cLM() != null && PbFragment.this.kfq.cLM().bua() != null) {
                                                                                                        i6 = PbFragment.this.kfq.cLM().bua().getBottom();
                                                                                                    }
                                                                                                    z9 = PbFragment.this.kfq.knj.kon.getView().getTop() <= i6;
                                                                                                }
                                                                                            }
                                                                                        } else if (PbFragment.this.kfq.cLV() != null) {
                                                                                            z9 = PbFragment.this.kfq.cLV().getVisibility() == 0;
                                                                                            if (!z9 && PbFragment.this.kfq.knj != null && PbFragment.this.kfq.knj.kon != null && PbFragment.this.kfq.knj.kon.getView() != null && PbFragment.this.kfq.knj.kon.getView().getParent() != null && PbFragment.this.kfq.klZ != null && PbFragment.this.kfq.klZ.mNavigationBar != null) {
                                                                                                z9 = PbFragment.this.kfq.knj.kon.getView().getTop() - PbFragment.this.kfq.klZ.mNavigationBar.getBottom() < 10;
                                                                                            }
                                                                                        }
                                                                                        if (z9 || cMy) {
                                                                                            PbFragment.this.kfi = firstVisiblePosition;
                                                                                            PbFragment.this.kfj = top2;
                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                                PbFragment.this.kfq.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                PbFragment.this.kfq.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                            } else {
                                                                                                PbFragment.this.kfq.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                            }
                                                                                        } else if (PbFragment.this.kfi > 0) {
                                                                                            if (PbFragment.this.kfq.getListView().getChildAt(PbFragment.this.kfi) != null) {
                                                                                                PbFragment.this.kfq.getListView().smoothScrollToPosition(PbFragment.this.kfi, PbFragment.this.kfj, 200);
                                                                                            } else {
                                                                                                PbFragment.this.kfq.getListView().setSelectionFromTop(PbFragment.this.kfi, PbFragment.this.kfj + equipmentHeight);
                                                                                                PbFragment.this.kfq.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                            }
                                                                                        } else {
                                                                                            int cJj = PbFragment.this.cJj();
                                                                                            if (PbFragment.this.cJi() != -1) {
                                                                                                cJj--;
                                                                                            }
                                                                                            int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                            if (cJj < 0) {
                                                                                                i = PbFragment.this.kfq.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.w.getCount(PbFragment.this.kfq.getListView().getData()) - 1);
                                                                                                i2 = 0;
                                                                                            } else {
                                                                                                i = cJj;
                                                                                                i2 = dimens;
                                                                                            }
                                                                                            if (z7) {
                                                                                                i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                            } else if (!cHm || PbFragment.this.kfq.cLM() == null) {
                                                                                                if (PbFragment.this.kfq.klZ != null && PbFragment.this.kfq.klZ.mNavigationBar != null) {
                                                                                                    i2 += PbFragment.this.kfq.klZ.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                }
                                                                                            } else {
                                                                                                i2 += PbFragment.this.kfq.cLM().cNp();
                                                                                            }
                                                                                            if (PbFragment.this.kfq.knj == null || PbFragment.this.kfq.knj.kon == null || PbFragment.this.kfq.knj.kon.getView() == null || PbFragment.this.kfq.knj.kon.getView().getParent() == null) {
                                                                                                PbFragment.this.kfq.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                PbFragment.this.kfq.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                            } else if (!z7) {
                                                                                                PbFragment.this.kfq.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                            } else {
                                                                                                PbFragment.this.kfq.getListView().smoothScrollBy(PbFragment.this.kfq.knj.kon.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13402").dk("tid", PbFragment.this.kbF.kig).dk("fid", PbFragment.this.kbF.getPbData().getForumId()).ag("obj_locate", 2).dk("uid", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()));
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ar.isEmpty(PbFragment.this.kbF.getPbData().getForum().getName())) {
                                                                                    if (PbFragment.this.kbF.getErrorNo() == 4) {
                                                                                        if (!StringUtils.isNull(PbFragment.this.kbF.cHV()) || PbFragment.this.kbF.getAppealInfo() == null) {
                                                                                            PbFragment.this.keN.finish();
                                                                                            return;
                                                                                        }
                                                                                        name = PbFragment.this.kbF.getAppealInfo().forumName;
                                                                                    } else {
                                                                                        name = PbFragment.this.kbF.getPbData().getForum().getName();
                                                                                    }
                                                                                    if (StringUtils.isNull(name)) {
                                                                                        PbFragment.this.keN.finish();
                                                                                        return;
                                                                                    }
                                                                                    String cHV = PbFragment.this.kbF.cHV();
                                                                                    if (PbFragment.this.kbF.cKc() && cHV != null && cHV.equals(name)) {
                                                                                        PbFragment.this.keN.finish();
                                                                                    } else {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kbF.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                    }
                                                                                    com.baidu.tbadk.core.util.ao aoVar4 = new com.baidu.tbadk.core.util.ao("c13401");
                                                                                    aoVar4.dk("tid", PbFragment.this.kbF.cJZ());
                                                                                    aoVar4.dk("fid", PbFragment.this.kbF.getForumId());
                                                                                    aoVar4.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    if (PbFragment.this.kbF.getPbData().cGN() != null) {
                                                                                        aoVar4.dk("nid", PbFragment.this.kbF.getPbData().cGN().getNid());
                                                                                    }
                                                                                    TiebaStatic.log(aoVar4);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                if (view.getTag() instanceof bu) {
                                                                                    bu buVar = (bu) view.getTag();
                                                                                    if (PbFragment.this.kbF.cKJ() == 3 && PbFragment.this.cHU() && PbFragment.this.kbF.getPbData() != null && com.baidu.tbadk.core.util.w.isEmpty(PbFragment.this.kbF.getPbData().cHj())) {
                                                                                        PbFragment.this.keN.finish();
                                                                                    } else {
                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(buVar.aSt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                    }
                                                                                    com.baidu.tbadk.core.util.ao aoVar5 = new com.baidu.tbadk.core.util.ao("c13399");
                                                                                    aoVar5.dk("tid", buVar.getId());
                                                                                    aoVar5.s("fid", buVar.getFid());
                                                                                    aoVar5.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    aoVar5.dk("nid", buVar.getNid());
                                                                                    TiebaStatic.log(aoVar5);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                if (PbFragment.this.kbF != null) {
                                                                                    com.baidu.tbadk.core.util.ao aoVar6 = new com.baidu.tbadk.core.util.ao("c13398");
                                                                                    aoVar6.dk("tid", PbFragment.this.kbF.cJZ());
                                                                                    aoVar6.dk("fid", PbFragment.this.kbF.getForumId());
                                                                                    aoVar6.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    aoVar6.ag("obj_locate", 2);
                                                                                    TiebaStatic.log(aoVar6);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.pb_thread_post_button) {
                                                                                if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                                                                    com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.kbF.getPbData();
                                                                                    if (PbFragment.this.kfp == null) {
                                                                                        PbFragment.this.kfp = new com.baidu.tieba.pb.data.o(PbFragment.this.getPageContext());
                                                                                    }
                                                                                    long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                    long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                    new com.baidu.tbadk.core.util.ao("c13446").s("forum_id", j2).aWN();
                                                                                    PbFragment.this.registerListener(PbFragment.this.kgp);
                                                                                    PbFragment.this.kfp.G(j, j2);
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
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13274").dk("fid", PbFragment.this.kbF.getForumId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).dk("obj_source", "PB_card").dk("tid", PbFragment.this.kbF.cJZ()).ag("obj_param1", smartApp.is_game.intValue()));
                                                                                }
                                                                            } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                if (view.getTag() instanceof bu) {
                                                                                    bu buVar2 = (bu) view.getTag();
                                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(buVar2.aSt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg2.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("common_click").dk("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 9).ag("obj_locate", 9).s("obj_id", buVar2.getFid()).dk("tid", buVar2.getId()).ag("thread_type", buVar2.getThreadType()));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                if ((view.getTag() instanceof bu) && PbFragment.this.checkUpIsLogin()) {
                                                                                    bu buVar3 = (bu) view.getTag();
                                                                                    if (PbFragment.this.egK != null) {
                                                                                        PbFragment.this.egK.fx(buVar3.aSt(), String.valueOf(buVar3.getFid()));
                                                                                    }
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("common_click").dk("page_type", PageStayDurationConstants.PageName.PB).ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_adlocate", 10).ag("obj_locate", 11).s("obj_id", buVar3.getFid()).dk("tid", buVar3.getId()).ag("thread_type", buVar3.getThreadType()));
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kbF.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kbF.cJZ(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kbF.getPbData().cGN().aSK())));
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.kfq.cMB();
                                                                    SparseArray<Object> b3 = PbFragment.this.kfq.b(PbFragment.this.kbF.getPbData(), PbFragment.this.kbF.cKb(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbF.getPbData().getForum().getId(), PbFragment.this.kbF.getPbData().getForum().getName(), PbFragment.this.kbF.getPbData().cGN().getId(), String.valueOf(PbFragment.this.kbF.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    com.baidu.tbadk.core.util.an.y(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 0).ag("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.SET_NIGHT_MODE).ag("obj_type", 1).ag("obj_source", 1));
                                                                }
                                                                PbFragment.this.kfq.klZ.cNF();
                                                            }
                                                        } else if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null) {
                                                            PbFragment.this.kfq.klZ.aFg();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13062"));
                                                            PbFragment.this.JO(PbFragment.this.kbF.getPbData().cGN().aSG());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.kfq.cMB();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kbF.cKs()));
                                                                return;
                                                            }
                                                            PbFragment.this.bYw();
                                                            PbFragment.this.kfq.cMi();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kbF.getPbData().jYL == null || PbFragment.this.kbF.getPbData().jYL.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kbF.getPbData().jYL.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kbF.getPbData().jYL.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kbF.getPbData().jYL.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kbF.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kbF.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kbF.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kbF.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i10));
                                                                    if (PbFragment.this.kbF.getPbData().jYL != null && PbFragment.this.kbF.getPbData().jYL.size() > i9) {
                                                                        i9 = PbFragment.this.kbF.getPbData().jYL.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Bu = PbFragment.this.kbF.Bu(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kbF.cKs()));
                                                                    if (Bu) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.kfq.sc(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.showDialog();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.kfq.cMB();
                                                    if (PbFragment.this.cIe().getPbData().jYM != 2) {
                                                        if (PbFragment.this.kbF.getPageData() != null) {
                                                            PbFragment.this.kfq.a(PbFragment.this.kbF.getPageData(), PbFragment.this.jMp);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kbF.getPbData()) != null) {
                                                bu cGN = pbData.cGN();
                                                if (cGN != null && cGN.aSp() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13402").dk("tid", PbFragment.this.kbF.kig).dk("fid", pbData.getForumId()).ag("obj_locate", 4).dk("uid", cGN.aSp().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (cGN != null) {
                                                    if (cGN.aQX()) {
                                                        i9 = 2;
                                                    } else if (cGN.aQY()) {
                                                        i9 = 3;
                                                    } else if (cGN.aUl()) {
                                                        i9 = 4;
                                                    } else if (cGN.aUm()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ao aoVar7 = new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aoVar7.dk("tid", PbFragment.this.kbF.cJZ());
                                                aoVar7.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                                aoVar7.dk("fid", PbFragment.this.kbF.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aoVar7.ag("obj_locate", 5);
                                                } else {
                                                    aoVar7.ag("obj_locate", 6);
                                                }
                                                aoVar7.ag("obj_name", i9);
                                                aoVar7.ag("obj_type", 1);
                                                if (cGN != null) {
                                                    if (cGN.aQX()) {
                                                        aoVar7.ag("obj_type", 10);
                                                    } else if (cGN.aQY()) {
                                                        aoVar7.ag("obj_type", 9);
                                                    } else if (cGN.aUm()) {
                                                        aoVar7.ag("obj_type", 8);
                                                    } else if (cGN.aUl()) {
                                                        aoVar7.ag("obj_type", 7);
                                                    } else if (cGN.isShareThread) {
                                                        aoVar7.ag("obj_type", 6);
                                                    } else if (cGN.threadType == 0) {
                                                        aoVar7.ag("obj_type", 1);
                                                    } else if (cGN.threadType == 40) {
                                                        aoVar7.ag("obj_type", 2);
                                                    } else if (cGN.threadType == 49) {
                                                        aoVar7.ag("obj_type", 3);
                                                    } else if (cGN.threadType == 54) {
                                                        aoVar7.ag("obj_type", 4);
                                                    } else {
                                                        aoVar7.ag("obj_type", 5);
                                                    }
                                                    aoVar7.ag(IntentConfig.CARD_TYPE, cGN.aUp());
                                                    aoVar7.dk(IntentConfig.RECOM_SOURCE, cGN.mRecomSource);
                                                    aoVar7.dk("ab_tag", cGN.mRecomAbTag);
                                                    aoVar7.dk("weight", cGN.mRecomWeight);
                                                    aoVar7.dk("extra", cGN.mRecomExtra);
                                                    aoVar7.dk("nid", cGN.getNid());
                                                    if (cGN.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.ar.isEmpty(cGN.getBaijiahaoData().oriUgcVid)) {
                                                        aoVar7.dk("obj_param6", cGN.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aoVar7.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.cJI() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.cJI(), aoVar7);
                                                }
                                                TiebaStatic.log(aoVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> cGP2 = PbFragment.this.kbF.getPbData().cGP();
                                                    if ((cGP2 != null && cGP2.size() > 0) || !PbFragment.this.kbF.cKb()) {
                                                        PbFragment.this.kfq.cMB();
                                                        PbFragment.this.bYw();
                                                        if (pbData.cHi() != null && !StringUtils.isNull(pbData.cHi().aQl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11678").dk("fid", PbFragment.this.kbF.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), cGN)) {
                                                            if (PbFragment.this.kfq != null) {
                                                                PbFragment.this.kfq.cME();
                                                                PbFragment.this.kfq.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.kfq.showLoadingDialog();
                                                                PbFragment.this.kbF.cKE().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.Bl(i10);
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
                                            PbFragment.this.kfq.cMB();
                                            if (PbFragment.this.kfq.klZ.cNG() != null && view == PbFragment.this.kfq.klZ.cNG().cLj() && !PbFragment.this.kfq.cMU()) {
                                                PbFragment.this.kfq.cLN();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.bYw();
                                                PbFragment.this.kfq.cMi();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    y = PbFragment.this.kbF.y(true, PbFragment.this.cJr());
                                                } else {
                                                    y = view.getId() == R.id.reply_title ? PbFragment.this.kbF.y(false, PbFragment.this.cJr()) : PbFragment.this.kbF.JT(PbFragment.this.cJr());
                                                }
                                                view.setTag(Boolean.valueOf(y));
                                                if (y) {
                                                    PbFragment.this.kfq.rA(true);
                                                    PbFragment.this.kfq.crG();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.kfq.sc(true);
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
                                        PbFragment.this.kfq.cMB();
                                        if (PbFragment.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kbF.Bv(PbFragment.this.kfq.cMn()) != null) {
                                            PbFragment.this.cJm();
                                            if (PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13402").dk("tid", PbFragment.this.kbF.kig).dk("fid", PbFragment.this.kbF.getPbData().getForumId()).ag("obj_locate", 3).dk("uid", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()));
                                            }
                                            if (PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null && PbFragment.this.kbF.getPbData().cGN().aSp().getUserId() != null && PbFragment.this.kfo != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kbF.getPbData());
                                                bu cGN2 = PbFragment.this.kbF.getPbData().cGN();
                                                int i11 = 1;
                                                if (cGN2.aQX()) {
                                                    i11 = 2;
                                                } else if (cGN2.aQY()) {
                                                    i11 = 3;
                                                } else if (cGN2.aUl()) {
                                                    i11 = 4;
                                                } else if (cGN2.aUm()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12526").dk("tid", PbFragment.this.kbF.kig).ag("obj_locate", 1).dk("obj_id", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()).ag("obj_type", PbFragment.this.kfo.aOo() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i11));
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
                                    if (PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aQV() && PbFragment.this.kbF.getPbData().cGN().aSH() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11922"));
                                    }
                                    if (PbFragment.this.kbF.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kbF.cHV()) || PbFragment.this.kbF.getAppealInfo() == null) {
                                            PbFragment.this.keN.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kbF.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kbF.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.keN.finish();
                                        return;
                                    }
                                    String cHV2 = PbFragment.this.kbF.cHV();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kbF.cKc() && cHV2 != null && cHV2.equals(name2)) {
                                        PbFragment.this.keN.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kbF.getPbData() != null) {
                                    if ((PbFragment.this.kbF.getPbData().cHc() == 1 || PbFragment.this.kbF.getPbData().cHc() == 3) && !PbFragment.this.gRX.diL()) {
                                        PbFragment.this.kfq.cMB();
                                        int i12 = 0;
                                        if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLk()) {
                                            if (PbFragment.this.kfq.klZ.cNG() == null || view != PbFragment.this.kfq.klZ.cNG().cLm()) {
                                                if (view == PbFragment.this.kfq.cMg()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kbF.getPbData().cGN().aSl() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kbF.getPbData().cGN().aSk() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kbF.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kbF.getPbData().cGN().getId();
                                        PbFragment.this.kfq.cMf();
                                        PbFragment.this.gRX.b(id4, name3, id5, i12, PbFragment.this.kfq.cMh());
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.kfq.klZ.cNF();
                            if (PbFragment.this.kbF != null) {
                                PbFragment.this.gRZ.setThreadId(PbFragment.this.kbF.cJZ());
                            }
                            if (PbFragment.this.kbF == null || !PbFragment.this.kbF.isPrivacy()) {
                                PbFragment.this.gRZ.bNV();
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.kfq.cMB();
                        PbFragment.this.bYw();
                        PbFragment.this.kfq.cMi();
                        PbFragment.this.kfq.showLoadingDialog();
                        if (PbFragment.this.kfq.cLV() != null) {
                            PbFragment.this.kfq.cLV().setVisibility(8);
                        }
                        PbFragment.this.kbF.Bp(1);
                        if (PbFragment.this.keP != null) {
                            PbFragment.this.keP.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cJb = PbFragment.this.cJb();
                        if (!TextUtils.isEmpty(cJb)) {
                            bc.aWU().b(PbFragment.this.getPageContext(), new String[]{cJb});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ao aoVar8 = new com.baidu.tbadk.core.util.ao("c13398");
                aoVar8.dk("tid", PbFragment.this.kbF.cJZ());
                aoVar8.dk("fid", PbFragment.this.kbF.getForumId());
                aoVar8.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar8.ag("obj_locate", 1);
                TiebaStatic.log(aoVar8);
                if (PbFragment.this.keY) {
                    PbFragment.this.keY = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.cIU().cLK() != null && postData5.aSp() != null && postData5.dhY() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cIU().cLL() != null) {
                                PbFragment.this.cIU().cLL().cIK();
                            }
                            com.baidu.tieba.pb.data.n nVar2 = new com.baidu.tieba.pb.data.n();
                            nVar2.a(PbFragment.this.kbF.getPbData().getForum());
                            nVar2.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                            nVar2.g(postData5);
                            PbFragment.this.cIU().cLK().d(nVar2);
                            PbFragment.this.cIU().cLK().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aSp().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kbF.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.kfD != null) {
                                PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                            }
                        }
                    }
                }
            }
        }
    };
    public SortSwitchButton.a kgn = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean va(int i) {
            PbFragment.this.kfq.cMB();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kbF == null || PbFragment.this.kbF.isLoading) {
                    return false;
                }
                PbFragment.this.bYw();
                PbFragment.this.kfq.cMi();
                if (PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().jYL != null && PbFragment.this.kbF.getPbData().jYL.size() > i) {
                    int intValue = PbFragment.this.kbF.getPbData().jYL.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13699").dk("tid", PbFragment.this.kbF.cKa()).dk("fid", PbFragment.this.kbF.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", Bn(intValue)));
                    if (PbFragment.this.kbF.Bu(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.kfq.sc(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Bn(int i) {
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
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13268");
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kbF.getPbData() != null) {
                    aoVar.dk("fid", PbFragment.this.kbF.getPbData().getForumId());
                }
                aoVar.dk("tid", PbFragment.this.kbF.cJZ());
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            PbFragment.this.bYw();
            PbFragment.this.kfq.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.cIe() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.cIe().JW(postWriteCallBackData.getPostId());
                    PbFragment.this.kfQ = PbFragment.this.kfq.cLR();
                    PbFragment.this.kbF.cJ(PbFragment.this.kfQ, PbFragment.this.kfq.cLS());
                }
                PbFragment.this.kfq.cMB();
                PbFragment.this.kfu.cMZ();
                if (PbFragment.this.kfD != null) {
                    PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                }
                PbFragment.this.kfq.cLJ();
                PbFragment.this.kfq.so(true);
                PbFragment.this.kbF.cKu();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.kbF.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.kbF.getPbData();
                            if (pbData != null && pbData.cGN() != null && pbData.cGN().aSp() != null && (userId = pbData.cGN().aSp().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kbF.cKl()) {
                                PbFragment.this.kfq.cMi();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kbF.cKl()) {
                            PbFragment.this.kfq.cMi();
                        }
                    } else if (floor != null) {
                        PbFragment.this.kfq.s(PbFragment.this.kbF.getPbData());
                    }
                    if (PbFragment.this.kbF.cKf()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10369").dk("tid", PbFragment.this.kbF.cJZ()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.rG(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.kfD.bfP() || PbFragment.this.kfD.bfQ()) {
                    PbFragment.this.kfD.a(false, postWriteCallBackData);
                }
                PbFragment.this.kfu.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.jhL != null) {
                    PbFragment.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.we(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.we(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13746").ag("obj_locate", 1).ag("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).aUN();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13745").ag("obj_locate", 1).ag("obj_type", 2));
            } else if (adVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d kgo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13268");
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                    aoVar.dk("fid", PbFragment.this.kbF.getPbData().getForumId());
                }
                if (PbFragment.this.kbF != null) {
                    aoVar.dk("tid", PbFragment.this.kbF.cJZ());
                }
                aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aoVar);
            }
            if (z) {
                if (PbFragment.this.kfu != null) {
                    PbFragment.this.kfu.cMY();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.jhL != null) {
                    PbFragment.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.ar.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.we(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.we(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(PbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13746").ag("obj_locate", 1).ag("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).aUN();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13745").ag("obj_locate", 1).ag("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kfu != null) {
                if (PbFragment.this.kfq != null && PbFragment.this.kfq.cLL() != null && PbFragment.this.kfq.cLL().cIO() != null && PbFragment.this.kfq.cLL().cIO().bfQ()) {
                    PbFragment.this.kfq.cLL().cIO().a(postWriteCallBackData);
                }
                PbFragment.this.kfu.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kgp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cMX;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.keN.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.kfq != null && (cMX = PbFragment.this.kfq.cMX()) != null && PbFragment.this.kfq.getListView() != null) {
                            PbFragment.this.kfq.getListView().removeHeaderView(cMX);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a kgq = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g ny;
            if (!z || eVar == null || eVar.cHa() != null || com.baidu.tbadk.core.util.w.getCount(eVar.cGP()) >= 1) {
                PbFragment.this.jBc = true;
                PbFragment.this.kfq.cMk();
                if (eVar == null || !eVar.cGV()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.kfq.getView());
                }
                PbFragment.this.kfq.crF();
                if (PbFragment.this.isFullScreen || PbFragment.this.kfq.cMU()) {
                    PbFragment.this.kfq.cML();
                } else if (!PbFragment.this.kfq.cMI()) {
                    PbFragment.this.kfq.so(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.fdc = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.kfq.getView());
                    PbFragment.this.kfq.cMt();
                }
                if (z && eVar != null) {
                    bu cGN = eVar.cGN();
                    if (cGN == null || !cGN.aQZ()) {
                        PbFragment.this.d(PbFragment.this.kfC);
                    } else {
                        cJK();
                    }
                    PbFragment.this.kfq.cLL().setPbData(eVar);
                    PbFragment.this.kfq.byJ();
                    if (cGN != null && cGN.aTA() != null) {
                        PbFragment.this.a(cGN.aTA());
                    }
                    if (PbFragment.this.kfD != null) {
                        PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.cGP() != null && eVar.cGP().size() >= 1 && eVar.cGP().get(0) != null) {
                        PbFragment.this.kbF.JV(eVar.cGP().get(0).getId());
                    } else if (eVar.cHa() != null) {
                        PbFragment.this.kbF.JV(eVar.cHa().getId());
                    }
                    if (PbFragment.this.kfD != null) {
                        PbFragment.this.kfD.a(eVar.getAnti());
                        PbFragment.this.kfD.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.kfD.setThreadData(cGN);
                        PbFragment.this.kfD.a(PbFragment.this.kbF.cKp(), PbFragment.this.kbF.cJZ(), PbFragment.this.kbF.cKG());
                        if (cGN != null) {
                            PbFragment.this.kfD.im(cGN.aTM());
                        }
                    }
                    if (PbFragment.this.kfo != null) {
                        PbFragment.this.kfo.gJ(eVar.aOo());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cHp()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.kfq.sn(PbFragment.this.mIsFromCDN);
                    PbFragment.this.kfq.a(eVar, i2, i3, PbFragment.this.kbF.cKb(), i4, PbFragment.this.kbF.getIsFromMark());
                    PbFragment.this.kfq.d(eVar, PbFragment.this.kbF.cKb());
                    PbFragment.this.kfq.sk(PbFragment.this.kbF.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.evB = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.evB) && PbFragment.this.kfD != null && PbFragment.this.kfD.bfa() != null && (ny = PbFragment.this.kfD.bfa().ny(6)) != null && !TextUtils.isEmpty(PbFragment.this.evB)) {
                            ((View) ny).setOnClickListener(PbFragment.this.ewn);
                        }
                    }
                    if (PbFragment.this.kfy) {
                        PbFragment.this.kfy = false;
                        final int cJi = PbFragment.this.cJi();
                        if (!eVar.cHm()) {
                            PbFragment.this.kfq.BC(cJi);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cJi, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.kfz) {
                        PbFragment.this.kfz = false;
                        final int cJi2 = PbFragment.this.cJi();
                        final boolean z2 = cJi2 != -1;
                        if (!z2) {
                            cJi2 = PbFragment.this.cJj();
                        }
                        if (PbFragment.this.kfq != null) {
                            if (!eVar.cHm()) {
                                PbFragment.this.kfq.BC(cJi2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cJi2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.kfq.setSelectionFromTop(cJi2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.kfq.setSelectionFromTop(cJi2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.kfq.sp(true);
                                PbFragment.this.kfq.so(false);
                            }
                        }
                    } else if (PbFragment.this.kfA) {
                        PbFragment.this.kfA = false;
                        PbFragment.this.kfq.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.kfq.cMo();
                    }
                    PbFragment.this.kbF.a(eVar.getForum(), PbFragment.this.kgd);
                    PbFragment.this.kbF.a(PbFragment.this.kge);
                    if (PbFragment.this.jhL != null && cGN != null && cGN.aSp() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cGN.aSp());
                        PbFragment.this.jhL.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fdc && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kbF.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kbF.getAppealInfo().jYE)) {
                                    PbFragment.this.kfq.a(PbFragment.this.kbF.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.kfq.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.kfq.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.kfq.cML();
                            PbFragment.this.kfq.cMs();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kbF.cJZ());
                            jSONObject.put("fid", PbFragment.this.kbF.getForumId());
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
                        PbFragment.this.kfq.Kb("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                            arrayList = PbFragment.this.kbF.getPbData().cGP();
                        }
                        if (com.baidu.tbadk.core.util.w.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.w.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dhY() != 1)) {
                            PbFragment.this.kfq.Kb(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.cJC()) {
                                PbFragment.this.kfq.Kc(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.kfq.Kc(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.kfq.s(PbFragment.this.kbF.getPbData());
                        }
                    }
                    PbFragment.this.kfq.endLoadData();
                }
                if (eVar != null && eVar.jYS && PbFragment.this.eAY == 0) {
                    PbFragment.this.eAY = System.currentTimeMillis() - PbFragment.this.hcE;
                }
                if (!PbFragment.this.cIe().cKb() || PbFragment.this.cIe().getPbData().getPage().aRg() != 0 || PbFragment.this.cIe().cKB()) {
                    PbFragment.this.kfE = true;
                    return;
                }
                return;
            }
            PbFragment.this.kbF.Bp(1);
            if (PbFragment.this.keP != null) {
                PbFragment.this.keP.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cJK() {
            if (PbFragment.this.kbF != null) {
                if (PbFragment.this.kfD == null || !PbFragment.this.kfD.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.kfD = (com.baidu.tbadk.editortools.pb.e) dVar.dO(PbFragment.this.getContext());
                    PbFragment.this.kfD.a(PbFragment.this.keN.getPageContext());
                    PbFragment.this.kfD.a(PbFragment.this.evL);
                    PbFragment.this.kfD.a(PbFragment.this.evE);
                    PbFragment.this.kfD.a(PbFragment.this.keN.getPageContext(), PbFragment.this.keN.getIntent() == null ? null : PbFragment.this.keN.getIntent().getExtras());
                    PbFragment.this.kfD.bfa().m32if(true);
                    PbFragment.this.kfq.setEditorTools(PbFragment.this.kfD.bfa());
                    if (!PbFragment.this.kbF.cKg()) {
                        PbFragment.this.kfD.yC(PbFragment.this.kbF.cJZ());
                    }
                    if (PbFragment.this.kbF.cKH()) {
                        PbFragment.this.kfD.yA(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.kfq != null) {
                        PbFragment.this.kfD.yA(PbFragment.this.kfq.cLP());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.kfq.s(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bhP().bhQ()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hcE : j;
                if (PbFragment.this.eAY == 0) {
                    PbFragment.this.eAY = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.eAO, PbFragment.this.createTime, PbFragment.this.eAY, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.eAO = 0L;
                if (iVar != null) {
                    iVar.bhM();
                }
                if (z2) {
                    iVar.eBh = currentTimeMillis;
                    iVar.ix(true);
                }
                if (!z2 && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null) {
                    int threadType = PbFragment.this.kbF.getPbData().cGN().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ar.equals(PbFragment.this.kfb, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ar.equals(PbFragment.this.kfb, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.eBj = currentTimeMillis;
                                iVar2.nX(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.eBj = currentTimeMillis;
                        dVar.nX(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener kgr = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cJe();
            }
        }
    };
    private final a.InterfaceC0477a kgs = new a.InterfaceC0477a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0477a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.kfq.cMk();
            if (z) {
                if (PbFragment.this.kfo != null) {
                    PbFragment.this.kfo.gJ(z2);
                }
                PbFragment.this.kbF.rT(z2);
                if (PbFragment.this.kbF.aOo()) {
                    PbFragment.this.cJn();
                } else {
                    PbFragment.this.kfq.s(PbFragment.this.kbF.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.kfo != null) {
                        if (PbFragment.this.kfo.aOr() != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null) {
                            MarkData aOr = PbFragment.this.kfo.aOr();
                            MetaData aSp = PbFragment.this.kbF.getPbData().cGN().aSp();
                            if (aOr != null && aSp != null) {
                                if (!com.baidu.tbadk.core.util.ar.equals(TbadkCoreApplication.getCurrentAccount(), aSp.getUserId()) && !aSp.hadConcerned()) {
                                    PbFragment.this.b(aSp);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    PbFragment.this.cJk();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.Bb(PbFragment.this.mLastScrollState) && PbFragment.this.Bb(i)) {
                if (PbFragment.this.kfq != null) {
                    PbFragment.this.kfq.cMB();
                    if (PbFragment.this.kfD != null && !PbFragment.this.kfq.cLO()) {
                        PbFragment.this.kfq.sm(PbFragment.this.kfD.bfI());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.kfq.cLN();
                    }
                }
                if (!PbFragment.this.keV) {
                    PbFragment.this.keV = true;
                    if (PbFragment.this.kfq != null) {
                        PbFragment.this.kfq.cMH();
                    }
                }
            }
            if (PbFragment.this.kfq != null) {
                PbFragment.this.kfq.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.keP != null) {
                PbFragment.this.keP.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.keW == null) {
                PbFragment.this.keW = new com.baidu.tbadk.n.b();
                PbFragment.this.keW.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.keW.bhG();
            } else {
                PbFragment.this.keW.bhF();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dgX().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> cGP;
            if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null && PbFragment.this.kfq != null && PbFragment.this.kfq.cMe() != null) {
                PbFragment.this.kfq.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.keP != null) {
                    PbFragment.this.keP.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kbF.cKx() && (cGP = PbFragment.this.kbF.getPbData().cGP()) != null && !cGP.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.kfq.cMe().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.kbF.getPbData();
                    if (pbData != null) {
                        if (pbData.cGQ() != null && pbData.cGQ().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cGR() != null && pbData.cGR().hasData()) {
                            headerCount--;
                        }
                        int size = cGP.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d gSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gRX.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kbF.cKu();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.kun != 1002 || bVar.fPZ) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.kfq.a(1, dVar.Pv, dVar.lIA, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gRX.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.kfq.a(PbFragment.this.gRX.getLoadDataMode(), gVar.Pv, gVar.lIA, false);
                            PbFragment.this.kfq.aQ(gVar.lID);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.kfq.a(PbFragment.this.gRX.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c kgt = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
    };
    private final f.c faS = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cJs()) {
                PbFragment.this.keN.finish();
            }
            if (!PbFragment.this.kbF.rS(true)) {
                PbFragment.this.kfq.cMl();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e kgv = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.kgu && PbFragment.this.cJs()) {
                PbFragment.this.cJu();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.kbF.rR(false)) {
                    PbFragment.this.kfq.cMj();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kbF.getPbData() != null) {
                    PbFragment.this.kfq.cMG();
                }
                PbFragment.this.kgu = true;
            }
        }
    };
    private int kgw = 0;
    private final TbRichTextView.i eLw = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g cMe;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.kfq.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13398");
                aoVar.dk("tid", PbFragment.this.kbF.cJZ());
                aoVar.dk("fid", PbFragment.this.kbF.getForumId());
                aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                aoVar.ag("obj_locate", 3);
                aoVar.ag("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aoVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kbF.kcE.cHp()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bkP() != null) {
                            ArrayList<TbRichTextImageInfo> bkP = tbRichTextView.getRichText().bkP();
                            int i4 = 0;
                            while (i4 < bkP.size()) {
                                if (bkP.get(i4) != null) {
                                    arrayList.add(bkP.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bkP.get(i4).getSrc()) || str.equals(bkP.get(i4).blj()) || str.equals(bkP.get(i4).blg()) || str.equals(bkP.get(i4).bli()) || str.equals(bkP.get(i4).blm()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bkP.get(i4).getSrc();
                                    imageUrlData.originalUrl = bkP.get(i4).getSrc();
                                    imageUrlData.isLongPic = bkP.get(i4).blo();
                                    concurrentHashMap.put(bkP.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.kbF.cKr(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.kbQ) {
                        TbRichText bt = PbFragment.this.bt(str, i);
                        if (bt != null && PbFragment.this.kgw >= 0 && PbFragment.this.kgw < bt.bkO().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.f.c(bt.bkO().get(PbFragment.this.kgw));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.kbN.size()) {
                                    break;
                                } else if (!aVar.kbN.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bt.getPostId() != 0 && (cMe = PbFragment.this.kfq.cMe()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = cMe.getDataList();
                                if (com.baidu.tbadk.core.util.w.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bt.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bt.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kbF.cKG(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kbF.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.w.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.kbO.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.kbP, aVar.lastId, PbFragment.this.kbF.cKr(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.w.getItem(aVar.kbN, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.w.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.kbO.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.kbP, aVar.kbN.get(0), PbFragment.this.kbF.cKr(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                    }
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.kff = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean kgx = false;
    PostData izC = null;
    private final b.a kgy = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.izC != null) {
                if (i == 0) {
                    PbFragment.this.izC.fp(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.izC = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.izC);
                }
            }
        }
    };
    private final b.a kgz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kfN != null && !TextUtils.isEmpty(PbFragment.this.kfO)) {
                if (i == 0) {
                    if (PbFragment.this.kfP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kfO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.kfO;
                        aVar.pkgId = PbFragment.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kfP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.dEN == null) {
                            PbFragment.this.dEN = new az(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.dEN.j(PbFragment.this.kfO, PbFragment.this.kfN.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.kfN = null;
                PbFragment.this.kfO = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a5 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f8  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            SparseArray sparseArray;
            if (!PbFragment.this.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbFragment.this.cE(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.kfN = ((TbImageView) view).getBdImage();
                        PbFragment.this.kfO = ((TbImageView) view).getUrl();
                        if (PbFragment.this.kfN == null || TextUtils.isEmpty(PbFragment.this.kfO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.kfP = null;
                        } else {
                            PbFragment.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.kfN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.kfO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.kfP = null;
                            } else {
                                PbFragment.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.kfN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.kfO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.kfP = null;
                        } else {
                            PbFragment.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.kfq.a(PbFragment.this.kgz, PbFragment.this.kfN.isGif());
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
            PbFragment.this.izC = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.izC == null) {
                return true;
            }
            if (PbFragment.this.izC.dhY() != 1 || !PbFragment.this.cE(view)) {
                if (PbFragment.this.kfo != null) {
                    if (!PbFragment.this.kfo.aOo() || PbFragment.this.izC.getId() == null || !PbFragment.this.izC.getId().equals(PbFragment.this.kbF.aSx())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.cIe().getPbData() != null && PbFragment.this.cIe().getPbData().cHp();
                    if (PbFragment.this.izC.dhY() != 1) {
                        if (PbFragment.this.kfw == null) {
                            PbFragment.this.kfw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.kfw.a(PbFragment.this.kgA);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cE(view) && !z3;
                            boolean z5 = (!PbFragment.this.cE(view) || PbFragment.this.kfN == null || PbFragment.this.kfN.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.kfw));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.kfw));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.kfw);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.izC);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.kfw);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.kfw);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.izC);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.kfw);
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
                                    gVar4.mTextView.setTag(sparseArray5);
                                    arrayList.add(gVar4);
                                } else {
                                    if ((PbFragment.this.rH(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.kfw);
                                        gVar5.mTextView.setTag(str);
                                        arrayList.add(gVar5);
                                    }
                                }
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kfw);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.kfw);
                                    gVar.mTextView.setTag(sparseArray6);
                                } else {
                                    if (z10) {
                                        SparseArray sparseArray7 = new SparseArray();
                                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                        if (PbFragment.this.kbF.getPbData().cHc() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.kfw);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.kfw);
                                        }
                                        gVar6.mTextView.setTag(sparseArray7);
                                    }
                                    gVar = null;
                                }
                                if (gVar6 != null) {
                                    arrayList.add(gVar6);
                                }
                                if (gVar != null) {
                                    arrayList.add(gVar);
                                }
                            }
                            PbFragment.this.kfw.aL(arrayList);
                            PbFragment.this.kfv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.kfw);
                            PbFragment.this.kfv.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13272").dk("tid", PbFragment.this.kbF.kig).dk("fid", PbFragment.this.kbF.getForumId()).dk("uid", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()).dk("post_id", PbFragment.this.kbF.bfw()).ag("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.kfq.a(PbFragment.this.kgy, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.kfq.a(PbFragment.this.kgz, PbFragment.this.kfN.isGif());
            return true;
        }
    };
    private k.c kgA = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.kfv != null) {
                PbFragment.this.kfv.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.kfN != null && !TextUtils.isEmpty(PbFragment.this.kfO)) {
                        if (PbFragment.this.kfP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.kfO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.kfO;
                            aVar.pkgId = PbFragment.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.kfP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.kfN = null;
                        PbFragment.this.kfO = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.kfN != null && !TextUtils.isEmpty(PbFragment.this.kfO)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.dEN == null) {
                                PbFragment.this.dEN = new az(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.dEN.j(PbFragment.this.kfO, PbFragment.this.kfN.getImageByte());
                            PbFragment.this.kfN = null;
                            PbFragment.this.kfO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.izC != null) {
                        PbFragment.this.izC.fp(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.izC = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11739").ag("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cD(view);
                        if (PbFragment.this.kbF.getPbData().cGN() != null && PbFragment.this.kbF.getPbData().cGN().aSp() != null && PbFragment.this.kbF.getPbData().cGN().aSp().getUserId() != null && PbFragment.this.kfo != null) {
                            int h = PbFragment.this.h(PbFragment.this.kbF.getPbData());
                            bu cGN = PbFragment.this.kbF.getPbData().cGN();
                            if (cGN.aQX()) {
                                i2 = 2;
                            } else if (cGN.aQY()) {
                                i2 = 3;
                            } else if (cGN.aUl()) {
                                i2 = 4;
                            } else {
                                i2 = cGN.aUm() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12526").dk("tid", PbFragment.this.kbF.kig).ag("obj_locate", 2).dk("obj_id", PbFragment.this.kbF.getPbData().cGN().aSp().getUserId()).ag("obj_type", PbFragment.this.kfo.aOo() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13079"));
                        PbFragment.this.JO((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11739").ag("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.kfq.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.kfq.cJ(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.kfq.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a hwW = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bjF && z && !PbFragment.this.kbF.cKh()) {
                PbFragment.this.cJp();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.hEm.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0614a gZb = new a.InterfaceC0614a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        final int fPD = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void D(int i, int i2) {
            if (af(i2) && PbFragment.this.kfq != null && PbFragment.this.keP != null) {
                PbFragment.this.keP.nq(true);
                if (Math.abs(i2) > this.fPD) {
                    PbFragment.this.keP.hideFloatingView();
                }
                if (PbFragment.this.cJs()) {
                    PbFragment.this.kfq.cMb();
                    PbFragment.this.kfq.cMc();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void E(int i, int i2) {
            if (af(i2) && PbFragment.this.kfq != null && PbFragment.this.keP != null) {
                PbFragment.this.kfq.cMM();
                PbFragment.this.keP.nq(false);
                PbFragment.this.keP.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void bO(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void F(int i, int i2) {
        }

        private boolean af(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final o.a kdR = new o.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        @Override // com.baidu.tieba.pb.pb.main.o.a
        public void n(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.kfq.Kd(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int kgC = -1;
    private int kgD = -1;

    /* loaded from: classes9.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes9.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e cIP() {
        return this.kfD;
    }

    public void b(com.baidu.tieba.pb.data.n nVar) {
        MetaData metaData;
        boolean z = true;
        if (nVar.cHI() != null) {
            String id = nVar.cHI().getId();
            ArrayList<PostData> cGP = this.kbF.getPbData().cGP();
            int i = 0;
            while (true) {
                if (i >= cGP.size()) {
                    break;
                }
                PostData postData = cGP.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cHM = nVar.cHM();
                    postData.EV(nVar.getTotalCount());
                    if (postData.dhV() != null && cHM != null) {
                        Iterator<PostData> it = cHM.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aSp() != null && (metaData = postData.getUserMap().get(next.aSp().getUserId())) != null) {
                                next.a(metaData);
                                next.uJ(true);
                                next.a(getPageContext(), this.kbF.JU(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cHM.size() != postData.dhV().size();
                        postData.dhV().clear();
                        postData.dhV().addAll(cHM);
                        z = z2;
                    }
                    if (postData.dhR() != null) {
                        postData.dhS();
                    }
                }
            }
            if (!this.kbF.getIsFromMark() && z) {
                this.kfq.s(this.kbF.getPbData());
            }
            if (z) {
                c(nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n cHf = this.kbF.getPbData().cHf();
            if (cHf != null && str.equals(cHf.getAdId())) {
                if (cHf.dhM() != null) {
                    cHf.dhM().legoCard = null;
                }
                this.kbF.getPbData().cHg();
            }
            com.baidu.tieba.tbadkCore.data.n cKn = this.kbF.cKn();
            if (cKn != null && str.equals(cKn.getAdId())) {
                this.kbF.cKo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kfv != null && this.kfv.isShowing()) {
                this.kfv.dismiss();
                this.kfv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.kfv != null) {
                            PbFragment.this.kfv.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.kfq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.kfL);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.kfL);
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
                kVar.aL(arrayList);
                this.kfv = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.kfv.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(int i) {
        bu cGN;
        if (this.kbF != null && this.kbF.getPbData() != null && (cGN = this.kbF.getPbData().cGN()) != null) {
            if (i == 1) {
                PraiseData aSa = cGN.aSa();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aSa == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cGN.a(praiseData);
                    } else {
                        cGN.aSa().getUser().add(0, metaData);
                        cGN.aSa().setNum(cGN.aSa().getNum() + 1);
                        cGN.aSa().setIsLike(i);
                    }
                }
                if (cGN.aSa() != null) {
                    if (cGN.aSa().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.ar.numFormatOver10000(cGN.aSa().getNum());
                    }
                }
            } else if (cGN.aSa() != null) {
                cGN.aSa().setIsLike(i);
                cGN.aSa().setNum(cGN.aSa().getNum() - 1);
                ArrayList<MetaData> user = cGN.aSa().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cGN.aSa().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cGN.aSa().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cGN.aSa().getNum() + "";
                }
            }
            if (this.kbF.cKb()) {
                this.kfq.cMe().notifyDataSetChanged();
            } else {
                this.kfq.t(this.kbF.getPbData());
            }
        }
    }

    public static PbFragment cIQ() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.keN = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kbF.aC(bundle);
        if (this.hzJ != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.kfD.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.keU = System.currentTimeMillis();
        this.kfJ = getPageContext();
        final Intent intent = this.keN.getIntent();
        if (intent != null) {
            this.hcE = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.kfb = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.kfb)) {
                    this.kfb = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.kfb)) {
                this.keQ = true;
            }
            this.kgC = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.kgD = intent.getIntExtra("key_manga_next_chapter", -1);
            this.kgE = intent.getStringExtra("key_manga_title");
            this.kfy = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.kfz = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.kfA = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cJs()) {
                this.keN.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ar.isEmpty(this.source) ? "" : this.source;
            this.kfR = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.kfk = new bd();
            this.kfk.A(intent);
            this.kfT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.kfT == 0) {
                this.kfT = intent.getIntExtra("key_start_from", 0);
            }
            this.kfU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hcE = System.currentTimeMillis();
        }
        this.eAO = this.keU - this.hcE;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.keS = 0;
        aB(bundle);
        if (this.kbF.getPbData() != null) {
            this.kbF.getPbData().JG(this.source);
        }
        cIT();
        if (intent != null && this.kfq != null) {
            this.kfq.klX = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.kfM == null) {
                    this.kfM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.kfq.Kf(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.kfM, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kbF.getPbData() != null) {
                this.kbF.JX(stringExtra);
            }
        }
        this.hzJ = new VoiceManager();
        this.hzJ.onCreate(getPageContext());
        initData(bundle);
        this.kfC = new com.baidu.tbadk.editortools.pb.g();
        d(this.kfC);
        this.kfD = (com.baidu.tbadk.editortools.pb.e) this.kfC.dO(getActivity());
        this.kfD.a(this.keN.getPageContext());
        this.kfD.a(this.evL);
        this.kfD.a(this.evE);
        this.kfD.a(this.keN.getPageContext(), bundle);
        this.kfD.bfa().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.kfD.bfa().m32if(true);
        rF(true);
        this.kfD.a(this.kbF.cKp(), this.kbF.cJZ(), this.kbF.cKG());
        registerListener(this.kfZ);
        if (!this.kbF.cKg()) {
            this.kfD.yC(this.kbF.cJZ());
        }
        if (this.kbF.cKH()) {
            this.kfD.yA(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.kfq != null) {
            this.kfD.yA(this.kfq.cLP());
        }
        registerListener(this.kfY);
        registerListener(this.kga);
        registerListener(this.kgb);
        registerListener(this.hBj);
        registerListener(this.kgm);
        registerListener(this.kfX);
        this.kfB = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.lFl);
        this.kfB.dhE();
        registerListener(this.kgc);
        registerListener(this.dUF);
        this.kbF.cKz();
        registerListener(this.kgr);
        registerListener(this.hBr);
        if (this.kfq != null && this.kfq.cMQ() != null && this.kfq.cMR() != null) {
            this.keP = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.kfq.cMQ(), this.kfq.cMR(), this.kfq.cLV());
            this.keP.a(this.kgh);
        }
        if (this.keO && this.kfq != null && this.kfq.cMR() != null) {
            this.kfq.cMR().setVisibility(8);
        }
        this.kfK = new com.baidu.tbadk.core.view.c();
        this.kfK.toastTime = 1000L;
        registerListener(this.kgl);
        registerListener(this.kgj);
        registerListener(this.kgk);
        registerListener(this.hSY);
        registerListener(this.hBf);
        registerResponsedEventListener(TipEvent.class, this.hyP);
        this.kfL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kfL;
        userMuteAddAndDelCustomMessage.setTag(this.kfL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kfL;
        userMuteCheckCustomMessage.setTag(this.kfL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kbF.cKE().a(this.kgi);
        this.kfu = new ax();
        if (this.kfD.bfA() != null) {
            this.kfu.e(this.kfD.bfA().getInputView());
        }
        this.kfD.a(this.evF);
        this.hRN = new ShareSuccessReplyToServerModel();
        a(this.kfV);
        this.jhL = new com.baidu.tbadk.core.util.ak(getPageContext());
        this.jhL.a(new ak.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.ak.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.ak.dUw) {
                        PbFragment.this.kfD.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.ak.dUx && PbFragment.this.kfq != null && PbFragment.this.kfq.cLL() != null && PbFragment.this.kfq.cLL().cIO() != null) {
                        PbFragment.this.kfq.cLL().cIO().bfX();
                    } else if (i == com.baidu.tbadk.core.util.ak.dUy) {
                        PbFragment.this.c(PbFragment.this.kfG);
                    }
                }
            }
        });
        this.kfn = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.kfn.w(getUniqueId());
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
        com.baidu.tbadk.core.business.a.aPM().da("3", "");
        this.gRZ = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.keU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kbF != null) {
            gVar.setForumName(this.kbF.cHV());
            if (this.kbF.getPbData() != null && this.kbF.getPbData().getForum() != null) {
                gVar.a(this.kbF.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kbF);
        }
    }

    public String cIR() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cIS() {
        return this.keP;
    }

    private void rF(boolean z) {
        this.kfD.ij(z);
        this.kfD.ik(z);
        this.kfD.il(z);
    }

    private void cIT() {
        this.egK = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    public av cIU() {
        return this.kfq;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cIe() {
        return this.kbF;
    }

    public void JN(String str) {
        if (this.kbF != null && !StringUtils.isNull(str) && this.kfq != null) {
            this.kfq.sr(true);
            this.kbF.JN(str);
            this.kfa = true;
            this.kfq.cMB();
            this.kfq.cML();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bjF = false;
        } else {
            this.bjF = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.keS = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.keS == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
        if (this.kfq != null) {
            this.kfq.onPause();
        }
        if (!this.kbF.cKg()) {
            this.kfD.yB(this.kbF.cJZ());
        }
        if (this.kbF != null) {
            this.kbF.cKA();
        }
        com.baidu.tbadk.BdToken.c.aMo().aMy();
        MessageManager.getInstance().unRegisterListener(this.iLF);
        cli();
        MessageManager.getInstance().unRegisterListener(this.kgj);
        MessageManager.getInstance().unRegisterListener(this.kgk);
        MessageManager.getInstance().unRegisterListener(this.kgl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cIV() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.kbF.getPbData(), this.kbF.cKb(), this.kbF.cKy());
        return (a2 == null || a2.aSp() == null || a2.aSp().getGodUserData() == null || a2.aSp().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bjF = false;
        super.onResume();
        if (this.kfd) {
            this.kfd = false;
            cJy();
        }
        if (cIV()) {
            this.keX = System.currentTimeMillis();
        } else {
            this.keX = -1L;
        }
        if (this.kfq != null && this.kfq.getView() != null) {
            if (!this.jBc) {
                cJq();
            } else {
                hideLoadingView(this.kfq.getView());
            }
            this.kfq.onResume();
        }
        if (this.keS == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.kfq != null) {
            noNetworkView = this.kfq.cLI();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        registerListener(this.iLF);
        this.kfx = false;
        cJx();
        registerListener(this.kgj);
        registerListener(this.kgk);
        registerListener(this.kgl);
        if (this.hAx) {
            cJp();
            this.hAx = false;
        }
        cJE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.kfq.sg(z);
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
        if (z && this.kfx) {
            this.kfq.cMj();
            this.kbF.rR(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.keX > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10804").dk("obj_duration", (System.currentTimeMillis() - this.keX) + ""));
            this.keX = 0L;
        }
        if (cIU().cLL() != null) {
            cIU().cLL().onStop();
        }
        if (this.kfq.klZ != null && !this.kfq.klZ.cNI()) {
            this.kfq.klZ.releaseResources();
        }
        if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().getForum() != null && this.kbF.getPbData().cGN() != null) {
            com.baidu.tbadk.distribute.a.beN().b(getPageContext().getPageActivity(), "pb", this.kbF.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kbF.getPbData().cGN().getId(), 0L));
        }
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dgX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        MessageManager.getInstance().unRegisterListener(this.kfl);
        if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13266");
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("fid", this.kbF.getPbData().getForumId());
            aoVar.dk("tid", this.kbF.cJZ());
            aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aoVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.keV && this.kfq != null) {
            this.keV = true;
            this.kfq.cMH();
            a(false, (PostData) null);
        }
        if (this.kbF != null) {
            this.kbF.cancelLoadData();
            this.kbF.destory();
            if (this.kbF.cKD() != null) {
                this.kbF.cKD().onDestroy();
            }
        }
        if (this.kfD != null) {
            this.kfD.onDestroy();
        }
        if (this.gRX != null) {
            this.gRX.cancelLoadData();
        }
        if (this.egK != null) {
            this.egK.dhr();
        }
        if (this.kfq != null) {
            this.kfq.onDestroy();
            if (this.kfq.klZ != null) {
                this.kfq.klZ.releaseResources();
            }
        }
        if (this.keW != null) {
            this.keW.bhH();
        }
        if (this.keP != null) {
            this.keP.bnE();
        }
        super.onDestroy();
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
        if (this.kfq != null) {
            this.kfq.cMB();
        }
        MessageManager.getInstance().unRegisterListener(this.kgj);
        MessageManager.getInstance().unRegisterListener(this.kgk);
        MessageManager.getInstance().unRegisterListener(this.kgl);
        MessageManager.getInstance().unRegisterListener(this.kfL);
        MessageManager.getInstance().unRegisterListener(this.kgm);
        MessageManager.getInstance().unRegisterListener(this.hBr);
        MessageManager.getInstance().unRegisterListener(this.hSY);
        MessageManager.getInstance().unRegisterListener(this.kgp);
        this.kfJ = null;
        this.kfK = null;
        com.baidu.tieba.recapp.d.a.cZF().cZH();
        if (this.kfM != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kfM);
        }
        if (this.kfe != null) {
            this.kfe.cancelLoadData();
        }
        if (this.kfq != null && this.kfq.klZ != null) {
            this.kfq.klZ.cNL();
        }
        if (this.hRN != null) {
            this.hRN.cancelLoadData();
        }
        this.kfu.onDestroy();
        if (this.kbF != null && this.kbF.cKF() != null) {
            this.kbF.cKF().onDestroy();
        }
        if (this.jhL != null) {
            this.jhL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g cMe;
        ArrayList<PostData> cIA;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aZP() && this.kfq != null && (cMe = this.kfq.cMe()) != null && (cIA = cMe.cIA()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cIA.iterator();
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
                        bVar.gUb = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.dMR == 1 && !TextUtils.isEmpty(id)) {
                    next.dMR = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.gUb = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kbF == null || this.kbF.getPbData() == null || this.kbF.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kbF.getPbData().getForum().getFirst_class();
                    str2 = this.kbF.getPbData().getForum().getSecond_class();
                    str = this.kbF.getPbData().getForum().getId();
                    str4 = this.kbF.cJZ();
                }
                com.baidu.tieba.recapp.r.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aZS());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.kfq.onChangeSkinType(i);
            if (this.kfD != null && this.kfD.bfa() != null) {
                this.kfD.bfa().onChangeSkinType(i);
            }
            if (this.kfq.cLI() != null) {
                this.kfq.cLI().onChangeSkinType(getPageContext(), i);
            }
            this.kfu.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.an.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kfq = new av(this, this.hCn, this.eor);
        this.hEm = new com.baidu.tieba.f.b(getActivity());
        this.hEm.a(kgB);
        this.hEm.a(this.gZb);
        this.kfq.setOnScrollListener(this.mOnScrollListener);
        this.kfq.d(this.kgv);
        this.kfq.setListPullRefreshListener(this.faS);
        this.kfq.rr(com.baidu.tbadk.core.k.aPA().isShowImages());
        this.kfq.setOnImageClickListener(this.eLw);
        this.kfq.b(this.mOnLongClickListener);
        this.kfq.g(this.hwW);
        this.kfq.a(this.kgt);
        this.kfq.sg(this.mIsLogin);
        if (this.keN.getIntent() != null) {
            this.kfq.ss(this.keN.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.kfq.cLK().setFromForumId(this.kbF.getFromForumId());
        this.kfq.setEditorTools(this.kfD.bfa());
        this.kfD.yA(this.kfq.cLP());
        this.kfq.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kbF.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbF.getPbData().getForum().getId(), PbFragment.this.kbF.getPbData().getForum().getName(), PbFragment.this.kbF.getPbData().cGN().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.kfq.getView();
    }

    public void cIW() {
        if (this.kfq != null && this.kbF != null) {
            if ((this.kbF.getPbData() != null || this.kbF.getPbData().cHl() != null) && checkUpIsLogin() && this.kfq.cMe() != null && this.kfq.cMe().cIF() != null) {
                this.kfq.cMe().cIF().xl(this.kbF.cJZ());
            }
        }
    }

    public void cIX() {
        TiebaStatic.log("c12181");
        if (this.kfq != null && this.kbF != null) {
            if ((this.kfq == null || this.kfq.cLO()) && this.kbF.getPbData() != null && this.kbF.getPbData().cHl() != null) {
                com.baidu.tieba.pb.data.m cHl = this.kbF.getPbData().cHl();
                if (checkUpIsLogin()) {
                    if ((!cHl.cHF() || cHl.aTQ() != 2) && this.kfq.cMe() != null && this.kfq.cMe().cIF() != null) {
                        this.kfq.cMe().cIF().xl(this.kbF.cJZ());
                    }
                    if (System.currentTimeMillis() - this.keZ > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).sZ(false);
                        this.keZ = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.dLC && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.aPA().isShowImages()) {
                    return JQ(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kbF == null || this.kbF.getPbData() == null) {
                        return true;
                    }
                    if (cIU().cLL() != null) {
                        cIU().cLL().cIK();
                    }
                    com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n();
                    nVar.a(this.kbF.getPbData().getForum());
                    nVar.setThreadData(this.kbF.getPbData().cGN());
                    nVar.g(postData);
                    cIU().cLK().d(nVar);
                    cIU().cLK().setPostId(postData.getId());
                    b(view, postData.aSp().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.kfD != null) {
                        this.kfq.sm(this.kfD.bfI());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cIY() {
        if (this.keT == null) {
            this.keT = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.keT.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kbB = PbFragment.this.kbB.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbB);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kbF.cJZ(), PbFragment.this.kbB, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kbB = PbFragment.this.kbB.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbB);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kbF.cJZ(), PbFragment.this.kbB, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kbB = PbFragment.this.kbB.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kbB);
                        bVar.dismiss();
                    }
                }
            }).kY(R.style.dialog_ani_b2t).kZ(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.kgq.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cPI(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.kbF = this.keN.cIe();
        if (this.kbF.cKC() != null) {
            this.kbF.cKC().a(this.kdR);
        }
        if (this.kbF.cKD() != null) {
            this.kbF.cKD().b(this.kfW);
        }
        if (StringUtils.isNull(this.kbF.cJZ())) {
            this.keN.finish();
        } else if ("from_tieba_kuang".equals(this.kfb) && this.kfb != null) {
            this.kbF.Bw(6);
        }
    }

    private void initData(Bundle bundle) {
        this.kfo = com.baidu.tbadk.baseEditMark.a.a(this.keN);
        if (this.kfo != null) {
            this.kfo.a(this.kgs);
        }
        this.gRX = new ForumManageModel(this.keN);
        this.gRX.setLoadDataCallBack(this.gSe);
        this.dUB = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.kgg.setUniqueId(getUniqueId());
        this.kgg.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kfq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kfL;
        userMuteCheckCustomMessage.setTag(this.kfL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cIZ() {
        if (this.kbF == null || this.kbF.getPbData() == null) {
            return false;
        }
        bu cGN = this.kbF.getPbData().cGN();
        this.kbF.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cGN);
    }

    public void cJa() {
        if (checkUpIsLogin() && this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().getForum() != null && !cIZ()) {
            if (this.kbF.getPbData().cHp()) {
                this.kfq.ckJ();
                return;
            }
            if (this.hDN == null) {
                this.hDN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hDN.vG(0);
                this.hDN.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nl(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void nm(boolean z) {
                        if (z) {
                            PbFragment.this.kfq.ckJ();
                        }
                    }
                });
            }
            this.hDN.D(this.kbF.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kbF.cJZ(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cJb() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.kbF == null || (pbData = this.kbF.getPbData()) == null) {
            return null;
        }
        return pbData.cHb().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            if (eVar.cGN().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cGN().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cGN().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cIZ() && cJc()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kfg);
                this.kfh = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.kbF.getPbData() != null && this.kbF.getPbData().cHp()) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.keN.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cIU().getListView().smoothScrollBy((PbFragment.this.kfg[1] + PbFragment.this.kfh) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cIU().cLL() != null) {
                            PbFragment.this.kfD.bfa().setVisibility(8);
                            PbFragment.this.cIU().cLL().g(str, str2, PbFragment.this.cIU().cLP(), (PbFragment.this.kbF == null || PbFragment.this.kbF.getPbData() == null || PbFragment.this.kbF.getPbData().cGN() == null || !PbFragment.this.kbF.getPbData().cGN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cIO = PbFragment.this.cIU().cLL().cIO();
                            if (cIO != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                cIO.a(PbFragment.this.kbF.getPbData().getAnti());
                                cIO.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                            }
                            if (PbFragment.this.kfu.cNc() == null && PbFragment.this.cIU().cLL().cIO().bgf() != null) {
                                PbFragment.this.cIU().cLL().cIO().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kfu != null && PbFragment.this.kfu.cNb() != null) {
                                            if (!PbFragment.this.kfu.cNb().dqL()) {
                                                PbFragment.this.kfu.su(false);
                                            }
                                            PbFragment.this.kfu.cNb().vF(false);
                                        }
                                    }
                                });
                                PbFragment.this.kfu.f(PbFragment.this.cIU().cLL().cIO().bgf().getInputView());
                                PbFragment.this.cIU().cLL().cIO().a(PbFragment.this.kfI);
                            }
                        }
                        PbFragment.this.cIU().cML();
                    }
                }, 0L);
                return;
            }
            if (this.kfF == null) {
                this.kfF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kfF.vG(1);
                this.kfF.a(new AnonymousClass38(str, str2));
            }
            if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().getForum() != null) {
                this.kfF.D(this.kbF.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kbF.cJZ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$38  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass38 implements c.a {
        final /* synthetic */ String kgN;
        final /* synthetic */ String kgO;

        AnonymousClass38(String str, String str2) {
            this.kgN = str;
            this.kgO = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nm(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cIU().getListView().smoothScrollBy((PbFragment.this.kfg[1] + PbFragment.this.kfh) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cIU().cLL() != null) {
                            PbFragment.this.kfD.bfa().setVisibility(8);
                            PbFragment.this.cIU().cLL().g(AnonymousClass38.this.kgN, AnonymousClass38.this.kgO, PbFragment.this.cIU().cLP(), (PbFragment.this.kbF == null || PbFragment.this.kbF.getPbData() == null || PbFragment.this.kbF.getPbData().cGN() == null || !PbFragment.this.kbF.getPbData().cGN().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cIO = PbFragment.this.cIU().cLL().cIO();
                            if (cIO != null && PbFragment.this.kbF != null && PbFragment.this.kbF.getPbData() != null) {
                                cIO.a(PbFragment.this.kbF.getPbData().getAnti());
                                cIO.setThreadData(PbFragment.this.kbF.getPbData().cGN());
                            }
                            if (PbFragment.this.kfu.cNc() == null && PbFragment.this.cIU().cLL().cIO().bgf() != null) {
                                PbFragment.this.cIU().cLL().cIO().bgf().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kfu != null && PbFragment.this.kfu.cNb() != null) {
                                            if (!PbFragment.this.kfu.cNb().dqL()) {
                                                PbFragment.this.kfu.su(false);
                                            }
                                            PbFragment.this.kfu.cNb().vF(false);
                                        }
                                    }
                                });
                                PbFragment.this.kfu.f(PbFragment.this.cIU().cLL().cIO().bgf().getInputView());
                                PbFragment.this.cIU().cLL().cIO().a(PbFragment.this.kfI);
                            }
                        }
                        PbFragment.this.cIU().cML();
                    }
                }, 0L);
            }
        }
    }

    public boolean cJc() {
        if ((this.kbF.getPbData() != null && this.kbF.getPbData().cHp()) || this.jhL == null || this.kbF.getPbData() == null || this.kbF.getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.lp(this.kbF.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Bj(int i) {
        if (this.jhL == null || this.kbF.getPbData() == null || this.kbF.getPbData().getAnti() == null) {
            return true;
        }
        return this.jhL.aF(this.kbF.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.kbF != null && this.kbF.getPbData() != null && postData.dhY() != 1) {
            String cJZ = this.kbF.cJZ();
            String id = postData.getId();
            int cHc = this.kbF.getPbData() != null ? this.kbF.getPbData().cHc() : 0;
            PbActivity.a JR = JR(id);
            if (JR != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cJZ, id, "pb", true, null, false, null, cHc, postData.cOE(), this.kbF.getPbData().getAnti(), false, postData.aSp() != null ? postData.aSp().getIconInfo() : null).addBigImageData(JR.kbN, JR.kbO, JR.kbP, JR.index);
                addBigImageData.setKeyPageStartFrom(this.kbF.cKJ());
                addBigImageData.setFromFrsForumId(this.kbF.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kbF.getForumId());
                addBigImageData.setBjhData(this.kbF.cKi());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cJd() {
        if (this.kbF.getPbData() == null || this.kbF.getPbData().cGN() == null) {
            return -1;
        }
        return this.kbF.getPbData().cGN().aTc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rG(boolean z) {
        if (this.kbF != null && this.kbF.kcE != null && this.kbF.kcE.cGN() != null) {
            bu cGN = this.kbF.kcE.cGN();
            cGN.mRecomAbTag = this.kbF.cKU();
            cGN.mRecomWeight = this.kbF.cKS();
            cGN.mRecomSource = this.kbF.cKT();
            cGN.mRecomExtra = this.kbF.cKV();
            if (cGN.getFid() == 0) {
                cGN.setFid(com.baidu.adp.lib.f.b.toLong(this.kbF.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGN, "c13563");
            if (a2 != null) {
                a2.ag("reply_type", 1);
                if (z) {
                    a2.ag("obj_type", 2);
                } else {
                    a2.ag("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJe() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Mr(this.kbF.getForumId()) && this.kbF.getPbData() != null && this.kbF.getPbData().getForum() != null) {
            if (this.kbF.getPbData().getForum().isLike() == 1) {
                this.kbF.cKF().fq(this.kbF.getForumId(), this.kbF.cJZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH(boolean z) {
        if (this.kbF == null || this.kbF.getPbData() == null) {
            return false;
        }
        return ((this.kbF.getPbData().cHc() != 0) || this.kbF.getPbData().cGN() == null || this.kbF.getPbData().cGN().aSp() == null || TextUtils.equals(this.kbF.getPbData().cGN().aSp().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean rI(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.z zVar;
        if (this.kbF == null || this.kbF.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.kbF.getPbData();
        bu cGN = pbData.cGN();
        if (cGN != null) {
            if (cGN.aQX() || cGN.aQY()) {
                return false;
            }
            if (cGN.aUl() || cGN.aUm()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cHc() != 0) {
                return pbData.cHc() != 3;
            }
            List<bq> cHj = pbData.cHj();
            if (com.baidu.tbadk.core.util.w.getCount(cHj) > 0) {
                for (bq bqVar : cHj) {
                    if (bqVar != null && (zVar = bqVar.dKO) != null && zVar.dIC && !zVar.dID && (zVar.type == 1 || zVar.type == 2)) {
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

    private boolean rJ(boolean z) {
        if (z || this.kbF == null || this.kbF.getPbData() == null) {
            return false;
        }
        return ((this.kbF.getPbData().getForum() != null && this.kbF.getPbData().getForum().isBlockBawuDelete) || this.kbF.getPbData().cHc() == 0 || this.kbF.getPbData().cHc() == 3) ? false : true;
    }

    public void cJf() {
        com.baidu.tieba.pb.data.e pbData;
        bu cGN;
        boolean z = true;
        if (this.kbF != null && this.kbF.getPbData() != null && (cGN = (pbData = this.kbF.getPbData()).cGN()) != null && cGN.aSp() != null) {
            this.kfq.cLJ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cGN.aSp().getUserId());
            ag agVar = new ag();
            int cHc = this.kbF.getPbData().cHc();
            if (cHc == 1 || cHc == 3) {
                agVar.kkl = true;
                agVar.kkk = true;
                agVar.kkq = cGN.aSk() == 1;
                agVar.kkp = cGN.aSl() == 1;
            } else {
                agVar.kkl = false;
                agVar.kkk = false;
            }
            if (cHc == 1002 && !equals) {
                agVar.kkr = true;
            }
            agVar.kki = rI(equals);
            agVar.kkm = cJg();
            agVar.kkj = rJ(equals);
            agVar.Ef = this.kbF.cKb();
            agVar.kkf = true;
            agVar.kke = rH(equals);
            agVar.kkd = equals && this.kfq.cMq();
            agVar.kko = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.kkn = true;
            agVar.isHostOnly = this.kbF.getHostMode();
            agVar.kkh = true;
            if (cGN.aSH() == null) {
                agVar.kkg = true;
            } else {
                agVar.kkg = false;
            }
            if (pbData.cHp()) {
                agVar.kkf = false;
                agVar.kkh = false;
                agVar.kkg = false;
                agVar.kkk = false;
                agVar.kkl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cHp()) {
                z = false;
            }
            agVar.kks = z;
            this.kfq.klZ.a(agVar);
        }
    }

    private boolean cJg() {
        if (this.kbF != null && this.kbF.cKb()) {
            return this.kbF.getPageData() == null || this.kbF.getPageData().aRg() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
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
    public PbModel.a cJh() {
        return this.kgq;
    }

    public int cJi() {
        if (cIU() == null || cIU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cIU().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.l) && ((com.baidu.tieba.pb.data.l) qVar).Un == com.baidu.tieba.pb.data.l.jZZ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cJj() {
        if (cIU() == null || cIU().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cIU().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.lFM) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cJp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJk() {
        if (this.kbF != null && this.kbF.kcE != null && this.kbF.kcE.cGN() != null) {
            bu cGN = this.kbF.kcE.cGN();
            cGN.mRecomAbTag = this.kbF.cKU();
            cGN.mRecomWeight = this.kbF.cKS();
            cGN.mRecomSource = this.kbF.cKT();
            cGN.mRecomExtra = this.kbF.cKV();
            if (cGN.getFid() == 0) {
                cGN.setFid(com.baidu.adp.lib.f.b.toLong(this.kbF.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ao a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cGN, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.wd(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.we(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.hf(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12528").dk("obj_id", metaData.getUserId()).ag("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12528").dk("obj_id", metaData.getUserId()).ag("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dUB.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kbF.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aUN();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.kfq.cMk();
        this.kbF.rT(z);
        if (this.kfo != null) {
            this.kfo.gJ(z);
            if (markData != null) {
                this.kfo.a(markData);
            }
        }
        if (this.kbF.aOo()) {
            cJn();
        } else {
            this.kfq.s(this.kbF.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bb(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO(String str) {
        if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().cHp()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kbF.cJZ(), str);
            bu cGN = this.kbF.getPbData().cGN();
            if (cGN.aQX()) {
                format = format + "&channelid=33833";
            } else if (cGN.aUk()) {
                format = format + "&channelid=33842";
            } else if (cGN.aQY()) {
                format = format + "&channelid=33840";
            }
            JP(format);
            return;
        }
        this.kfn.Kp(str);
    }

    private void JP(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kbF.cKg()) {
                    antiData.setBlock_forum_name(this.kbF.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kbF.getPbData().getForum().getId());
                    antiData.setUser_name(this.kbF.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kbF.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cIU() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bA(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            yH(str);
        } else {
            this.kfq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.lIA) ? bVar.lIA : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.we(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.hf(true);
                aVar.b(getPageContext());
                aVar.aUN();
            } else {
                this.kfq.a(0, bVar.Pv, bVar.lIA, z);
            }
            if (bVar.Pv) {
                if (bVar.hhf == 1) {
                    ArrayList<PostData> cGP = this.kbF.getPbData().cGP();
                    int size = cGP.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cGP.get(i).getId())) {
                            i++;
                        } else {
                            cGP.remove(i);
                            break;
                        }
                    }
                    this.kbF.getPbData().cGN().kG(this.kbF.getPbData().cGN().aSg() - 1);
                    this.kfq.s(this.kbF.getPbData());
                } else if (bVar.hhf == 0) {
                    cJl();
                } else if (bVar.hhf == 2) {
                    ArrayList<PostData> cGP2 = this.kbF.getPbData().cGP();
                    int size2 = cGP2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cGP2.get(i2).dhV().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cGP2.get(i2).dhV().get(i3).getId())) {
                                i3++;
                            } else {
                                cGP2.get(i2).dhV().remove(i3);
                                cGP2.get(i2).dhX();
                                z2 = true;
                                break;
                            }
                        }
                        cGP2.get(i2).Nf(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.kfq.s(this.kbF.getPbData());
                    }
                    a(bVar, this.kfq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.kfq.a(this.gRX.getLoadDataMode(), gVar.Pv, gVar.lIA, false);
            if (gVar.Pv) {
                this.kfr = true;
                if (i == 2 || i == 3) {
                    this.kfs = true;
                    this.kft = false;
                } else if (i == 4 || i == 5) {
                    this.kfs = false;
                    this.kft = true;
                }
                if (i == 2) {
                    this.kbF.getPbData().cGN().kJ(1);
                    this.kbF.setIsGood(1);
                } else if (i == 3) {
                    this.kbF.getPbData().cGN().kJ(0);
                    this.kbF.setIsGood(0);
                } else if (i == 4) {
                    this.kbF.getPbData().cGN().kI(1);
                    this.kbF.Bo(1);
                } else if (i == 5) {
                    this.kbF.getPbData().cGN().kI(0);
                    this.kbF.Bo(0);
                }
                this.kfq.c(this.kbF.getPbData(), this.kbF.cKb());
            }
        }
    }

    private void cJl() {
        if (this.kbF.cKc() || this.kbF.cKe()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kbF.cJZ());
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kbF.cJZ()));
        if (cJo()) {
            this.keN.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIr() {
        this.keN.cIr();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cGZ;
        boolean z = false;
        if (this.kfq != null) {
            this.kfq.cMB();
        }
        if (this.kbF != null && this.kbF.getPbData() != null && !this.kbF.getPbData().cHp()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kbF.getPbData().cGN().getId();
            if (this.kbF.isShareThread() && this.kbF.getPbData().cGN().dNX != null) {
                historyMessage.threadName = this.kbF.getPbData().cGN().dNX.showText;
            } else {
                historyMessage.threadName = this.kbF.getPbData().cGN().getTitle();
            }
            if (this.kbF.isShareThread() && !cHU()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kbF.getPbData().getForum().getName();
            }
            ArrayList<PostData> cGP = this.kbF.getPbData().cGP();
            int cMm = this.kfq != null ? this.kfq.cMm() : 0;
            if (cGP != null && cMm >= 0 && cMm < cGP.size()) {
                historyMessage.postID = cGP.get(cMm).getId();
            }
            historyMessage.isHostOnly = this.kbF.getHostMode();
            historyMessage.isSquence = this.kbF.cKb();
            historyMessage.isShareThread = this.kbF.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kfD != null) {
            this.kfD.onDestroy();
        }
        if (this.keR && cIU() != null) {
            cIU().cMV();
        }
        if (this.kbF != null && (this.kbF.cKc() || this.kbF.cKe())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kbF.cJZ());
            if (this.kfr) {
                if (this.kft) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kbF.bRk());
                }
                if (this.kfs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kbF.getIsGood());
                }
            }
            if (this.kbF.getPbData() != null && System.currentTimeMillis() - this.keU >= 40000 && (cGZ = this.kbF.getPbData().cGZ()) != null && !com.baidu.tbadk.core.util.w.isEmpty(cGZ.getDataList())) {
                intent.putExtra("guess_like_data", cGZ);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.kfR);
            }
            PbActivity pbActivity = this.keN;
            PbActivity pbActivity2 = this.keN;
            pbActivity.setResult(-1, intent);
        }
        if (cJo()) {
            if (this.kbF != null && this.kfq != null && this.kfq.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.kbF.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.cGV() && !this.kfa && pbData.jYN == null) {
                        ao cLt = ao.cLt();
                        com.baidu.tieba.pb.data.e cKj = this.kbF.cKj();
                        Parcelable onSaveInstanceState = this.kfq.getListView().onSaveInstanceState();
                        boolean cKb = this.kbF.cKb();
                        boolean hostMode = this.kbF.getHostMode();
                        if (this.kfq.cLV() != null && this.kfq.cLV().getVisibility() == 0) {
                            z = true;
                        }
                        cLt.a(cKj, onSaveInstanceState, cKb, hostMode, z);
                        if (this.kfQ >= 0 || this.kbF.cKL() != null) {
                            ao.cLt().q(this.kbF.cKL());
                            ao.cLt().p(this.kbF.cKM());
                            ao.cLt().By(this.kbF.cKN());
                        }
                    }
                }
            } else {
                ao.cLt().reset();
            }
            cIr();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.kfq == null || !this.kfq.BE(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bk(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.keN;
        if (i == 0) {
            this.kfq.cLJ();
            this.kfq.cLL().cIK();
            this.kfq.so(false);
        }
        this.kfq.cLN();
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
                        this.kfD.resetData();
                        this.kfD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kfD.b(writeData);
                        com.baidu.tbadk.editortools.l nB = this.kfD.bfa().nB(6);
                        if (nB != null && nB.etH != null) {
                            nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.keN;
                        if (i == -1) {
                            this.kfD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kfq.cLL() != null && this.kfq.cLL().cIO() != null) {
                            com.baidu.tbadk.editortools.pb.h cIO = this.kfq.cLL().cIO();
                            cIO.setThreadData(this.kbF.getPbData().cGN());
                            cIO.b(writeData);
                            cIO.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l nB2 = cIO.bfa().nB(6);
                            if (nB2 != null && nB2.etH != null) {
                                nB2.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.keN;
                            if (i == -1) {
                                cIO.bfX();
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

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kfD.onActivityResult(i, i2, intent);
        if (this.kfe != null) {
            this.kfe.onActivityResult(i, i2, intent);
        }
        if (cIU().cLL() != null) {
            cIU().cLL().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cJm();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ao.cLt().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kbF != null) {
                                PbFragment.this.kbF.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cYy().G(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kbF != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cYy().G(getPageContext());
                        cJe();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.hRN != null && shareItem != null && shareItem.linkUrl != null) {
                            this.hRN.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bcu() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57.1
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
                    this.kfq.rw(false);
                    if (this.kbF.getPbData() != null && this.kbF.getPbData().cGN() != null && this.kbF.getPbData().cGN().aSK() != null) {
                        this.kbF.getPbData().cGN().aSK().setStatus(2);
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
                        this.kfG = emotionImageData;
                        if (Bj(com.baidu.tbadk.core.util.ak.dUy)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.kff != null) {
                        this.kfq.cK(this.kff);
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
            if (this.kfe == null) {
                this.kfe = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.keN);
                this.kfe.b(this.evE);
                this.kfe.c(this.evL);
            }
            this.kfe.a(emotionImageData, cIe(), cIe().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJm() {
        MarkData Bv;
        if (this.kfo != null) {
            if (this.kbF.getPbData() != null && this.kbF.getPbData().cHp()) {
                Bv = this.kbF.Bv(0);
            } else {
                Bv = this.kbF.Bv(this.kfq.cMn());
            }
            if (Bv != null) {
                if (!Bv.isApp() || (Bv = this.kbF.Bv(this.kfq.cMn() + 1)) != null) {
                    this.kfq.cMi();
                    this.kfo.a(Bv);
                    if (!this.kfo.aOo()) {
                        this.kfo.aOq();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.kfo.aOp();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJn() {
        com.baidu.tieba.pb.data.e pbData = this.kbF.getPbData();
        this.kbF.rT(true);
        if (this.kfo != null) {
            pbData.JF(this.kfo.aOn());
        }
        this.kfq.s(pbData);
    }

    private boolean cJo() {
        if (this.kbF == null) {
            return true;
        }
        if (this.kbF.getPbData() == null || !this.kbF.getPbData().cHp()) {
            if (this.kbF.aOo()) {
                final MarkData cKt = this.kbF.cKt();
                if (cKt == null || !this.kbF.getIsFromMark()) {
                    return true;
                }
                final MarkData Bv = this.kbF.Bv(this.kfq.cMm());
                if (Bv == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cKt);
                    this.keN.setResult(-1, intent);
                    return true;
                } else if (Bv.getPostId() == null || Bv.getPostId().equals(cKt.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cKt);
                    this.keN.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.we(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.kfo != null) {
                                if (PbFragment.this.kfo.aOo()) {
                                    PbFragment.this.kfo.aOp();
                                    PbFragment.this.kfo.gJ(false);
                                }
                                PbFragment.this.kfo.a(Bv);
                                PbFragment.this.kfo.gJ(true);
                                PbFragment.this.kfo.aOq();
                            }
                            cKt.setPostId(Bv.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKt);
                            PbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cIr();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cKt);
                            PbFragment.this.keN.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cIr();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.kfq != null && PbFragment.this.kfq.getView() != null) {
                                PbFragment.this.kfq.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cKt);
                                PbFragment.this.keN.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cIr();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aUN();
                    return false;
                }
            } else if (this.kbF.getPbData() == null || this.kbF.getPbData().cGP() == null || this.kbF.getPbData().cGP().size() <= 0 || !this.kbF.getIsFromMark()) {
                return true;
            } else {
                this.keN.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.kfq == null) {
            return null;
        }
        return this.kfq.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bly() {
        if (this.kfq == null) {
            return 0;
        }
        return this.kfq.cMz();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> blz() {
        if (this.eLl == null) {
            this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: blL */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.an.getDrawable(R.color.common_color_10220));
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
                /* renamed from: a */
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
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
                /* renamed from: c */
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
        return this.eLl;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> blA() {
        if (this.eOC == null) {
            this.eOC = TbRichTextView.v(getPageContext().getPageActivity(), 8);
        }
        return this.eOC;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> blB() {
        if (this.eLm == null) {
            this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bST */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.an.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
                    gifView.bgx();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eLm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> blC() {
        if (this.eOD == null) {
            this.eOD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJL */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bCn();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cH */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eOD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> blE() {
        this.eOF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cJM */
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
        return this.eOF;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (this.efk == null) {
            this.efk = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.efk;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void al(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (ba.Kg(str) && this.kbF != null && this.kbF.cJZ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11664").ag("obj_param1", 1).dk("post_id", this.kbF.cJZ()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.esJ = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            ba.cNe().d(getPageContext(), str);
        }
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        ba.cNe().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.keY = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.kfq != null && this.kfq.cMQ() != null && rect.top <= this.kfq.cMQ().getHeight()) {
            rect.top += this.kfq.cMQ().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.kbF.getPbData();
            TbRichText bt = bt(str, i);
            if (bt != null && (tbRichTextData = bt.bkO().get(this.kgw)) != null) {
                aVar.postId = String.valueOf(bt.getPostId());
                aVar.kbN = new ArrayList<>();
                aVar.kbO = new ConcurrentHashMap<>();
                if (!tbRichTextData.bkU().blh()) {
                    aVar.kbQ = false;
                    String c2 = com.baidu.tieba.pb.data.f.c(tbRichTextData);
                    aVar.kbN.add(c2);
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
                    imageUrlData.postId = bt.getPostId();
                    imageUrlData.mIsReserver = this.kbF.cKr();
                    imageUrlData.mIsSeeHost = this.kbF.getHostMode();
                    aVar.kbO.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cGN() != null) {
                            aVar.threadId = pbData.cGN().getId();
                        }
                        aVar.kbP = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kbQ = true;
                int size = pbData.cGP().size();
                this.kgx = false;
                aVar.index = -1;
                int a2 = pbData.cGW() != null ? a(pbData.cGW().dia(), bt, i, i, aVar.kbN, aVar.kbO) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.cGP().get(i2);
                    if (postData.getId() == null || pbData.cGW() == null || pbData.cGW().getId() == null || !postData.getId().equals(pbData.cGW().getId())) {
                        a2 = a(postData.dia(), bt, a2, i, aVar.kbN, aVar.kbO);
                    }
                }
                if (aVar.kbN.size() > 0) {
                    aVar.lastId = aVar.kbN.get(aVar.kbN.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cGN() != null) {
                        aVar.threadId = pbData.cGN().getId();
                    }
                    aVar.kbP = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return null;
        }
        return tbRichTextData.bkU().blm();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return 0L;
        }
        return tbRichTextData.bkU().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return false;
        }
        return tbRichTextData.bkU().bln();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bkU() == null) {
            return false;
        }
        return tbRichTextData.bkU().blo();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bkU;
        String str;
        if (tbRichText == tbRichText2) {
            this.kgx = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bkO().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bkO().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bkU().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bkU().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bkU().blh()) {
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
                        String c2 = com.baidu.tieba.pb.data.f.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (bkU = tbRichTextData.bkU()) != null) {
                                String blj = bkU.blj();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bkU.blk();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = blj;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kbF.cJZ(), -1L);
                                imageUrlData.mIsReserver = this.kbF.cKr();
                                imageUrlData.mIsSeeHost = this.kbF.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.kgx) {
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

    protected void n(PostData postData) {
        PostData cGW;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kbF.aSx())) {
                z = true;
            }
            MarkData o = this.kbF.o(postData);
            if (this.kbF.getPbData() != null && this.kbF.getPbData().cHp() && (cGW = cGW()) != null) {
                o = this.kbF.o(cGW);
            }
            if (o != null) {
                this.kfq.cMi();
                if (this.kfo != null) {
                    this.kfo.a(o);
                    if (!z) {
                        this.kfo.aOq();
                    } else {
                        this.kfo.aOp();
                    }
                }
            }
        }
    }

    public boolean cE(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bt(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kbF == null || this.kbF.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.kbF.getPbData();
        if (pbData.cGW() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.cGW());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> cGP = pbData.cGP();
            c(pbData, cGP);
            return c(cGP, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cHb() != null && eVar.cHb().kao != null && (list = eVar.cHb().kao) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bkO;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dia = arrayList.get(i2).dia();
            if (dia != null && (bkO = dia.bkO()) != null) {
                int size = bkO.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bkO.get(i4) != null && bkO.get(i4).getType() == 8) {
                        i3++;
                        if (bkO.get(i4).bkU().blj().equals(str) || bkO.get(i4).bkU().blk().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bkO.get(i4).bkU().getWidth() * equipmentDensity;
                            int height = bkO.get(i4).bkU().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.kgw = i4;
                            return dia;
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

    @Override // com.baidu.tbadk.widget.richText.i
    public void s(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kbB = str;
            if (this.keT == null) {
                cIY();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.keT.getItemView(1).setVisibility(8);
            } else {
                this.keT.getItemView(1).setVisibility(0);
            }
            this.keT.aUO();
            this.keY = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hzJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJp() {
        hideNetRefreshView(this.kfq.getView());
        cJq();
        if (this.kbF.cKm()) {
            this.kfq.cMi();
        }
        this.kfq.cMt();
    }

    private void cJq() {
        showLoadingView(this.kfq.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.kfq.cMQ().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        if (this.hzJ != null) {
            this.hzJ.stopPlay();
        }
        if (this.keN != null) {
            this.keN.bYw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cJd(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> blD() {
        if (this.eOE == null) {
            this.eOE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cJN */
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
        return this.eOE;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bYx() {
        if (this.keN != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.keN.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.keN.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bXd() {
        if (this.kbF == null || this.kbF.getPbData() == null) {
            return null;
        }
        return this.kbF.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(av.knn)).intValue();
            if (intValue == av.kno) {
                if (!this.gRX.diL()) {
                    this.kfq.cMf();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gRX.Nj(com.baidu.tbadk.core.util.ar.O(jSONArray));
                    }
                    this.gRX.a(this.kbF.getPbData().getForum().getId(), this.kbF.getPbData().getForum().getName(), this.kbF.getPbData().cGN().getId(), str, intValue3, intValue2, booleanValue, this.kbF.getPbData().cGN().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == av.knp || intValue == av.knr) {
                if (this.kbF.cKC() != null) {
                    this.kbF.cKC().Bf(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == av.knp) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kfL);
        userMuteAddAndDelCustomMessage.setTag(this.kfL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean JQ(String str) {
        if (!StringUtils.isNull(str) && be.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0714a
    public void rK(boolean z) {
        this.kfx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cJr() {
        ArrayList<PostData> cGP;
        int count;
        if (this.kbF == null || this.kbF.getPbData() == null || this.kbF.getPbData().cGP() == null || (count = com.baidu.tbadk.core.util.w.getCount((cGP = this.kbF.getPbData().cGP()))) == 0) {
            return "";
        }
        if (this.kbF.cKr()) {
            Iterator<PostData> it = cGP.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dhY() == 1) {
                    return next.getId();
                }
            }
        }
        int cMm = this.kfq.cMm();
        PostData postData = (PostData) com.baidu.tbadk.core.util.w.getItem(cGP, cMm);
        if (postData == null || postData.aSp() == null) {
            return "";
        }
        if (this.kbF.JU(postData.aSp().getUserId())) {
            return postData.getId();
        }
        for (int i = cMm - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.w.getItem(cGP, i);
            if (postData2 == null || postData2.aSp() == null || postData2.aSp().getUserId() == null) {
                break;
            } else if (this.kbF.JU(postData2.aSp().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cMm + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.w.getItem(cGP, i2);
            if (postData3 == null || postData3.aSp() == null || postData3.aSp().getUserId() == null) {
                return "";
            }
            if (this.kbF.JU(postData3.aSp().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
        this.keY = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a JR(String str) {
        String str2;
        if (this.kbF.getPbData() == null || this.kbF.getPbData().cGP() == null || this.kbF.getPbData().cGP().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kbF.getPbData().cGP().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kbF.getPbData().cGP().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kbF.getPbData().cGP().get(i);
        if (postData.dia() == null || postData.dia().bkO() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dia().bkO().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bkU() != null) {
                    str2 = next.bkU().blj();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cJs() {
        return (!this.keO && this.kgC == -1 && this.kgD == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.kgF = rVar;
            this.keO = true;
            this.kfq.cLW();
            this.kfq.Ke(this.kgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJt() {
        if (this.kgF != null) {
            if (this.kgC == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                be.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kgF.getCartoonId(), this.kgC, 0)));
                this.keN.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJu() {
        if (this.kgF != null) {
            if (this.kgD == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                be.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.kgF.getCartoonId(), this.kgD, 0)));
                this.keN.finish();
            }
        }
    }

    public int cJv() {
        return this.kgC;
    }

    public int cJw() {
        return this.kgD;
    }

    private void cli() {
        if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().cGN() != null && this.kbF.getPbData().cGN().aQV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cJx() {
        if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().cGN() != null && this.kbF.getPbData().cGN().aQV()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cJy() {
        if (this.bjF) {
            this.kfd = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kbF.getPbData() != null && this.kbF.getPbData().cGN() != null && this.kbF.getPbData().cGN().aRV() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kbF.getPbData().cGN().aRV().getThreadId(), this.kbF.getPbData().cGN().aRV().getTaskId(), this.kbF.getPbData().cGN().aRV().getForumId(), this.kbF.getPbData().cGN().aRV().getForumName(), this.kbF.getPbData().cGN().aSk(), this.kbF.getPbData().cGN().aSl())));
            this.keQ = true;
            this.keN.finish();
        }
    }

    public String cJz() {
        return this.kfb;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cJA() {
        return this.kfm;
    }

    public void rL(boolean z) {
        this.kfc = z;
    }

    public boolean aUi() {
        if (this.kbF != null) {
            return this.kbF.cKc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.we(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.kfJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.kfJ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kfJ).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kfJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kfJ.getPageActivity());
            aVar.we(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kfJ).aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kfq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kfJ.getPageActivity());
        if (com.baidu.tbadk.core.util.ar.isEmpty(str)) {
            aVar.we(this.kfJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.we(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.kfq.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kfJ).aUN();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (ba.Kg(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.an.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.ico) {
            this.ico = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.kfq != null) {
                this.kfq.onConfigurationChanged(configuration);
            }
            if (this.kfv != null) {
                this.kfv.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cJC() {
        if (this.kbF != null) {
            return this.kbF.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, av avVar) {
        boolean z;
        List<PostData> list = this.kbF.getPbData().cHb().kao;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dhV().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dhV().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dhV().remove(i2);
                    list.get(i).dhX();
                    z = true;
                    break;
                }
            }
            list.get(i).Nf(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            avVar.s(this.kbF.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.n nVar) {
        String id = nVar.cHI().getId();
        List<PostData> list = this.kbF.getPbData().cHb().kao;
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
                ArrayList<PostData> cHM = nVar.cHM();
                postData.EV(nVar.getTotalCount());
                if (postData.dhV() != null) {
                    postData.dhV().clear();
                    postData.dhV().addAll(cHM);
                }
            }
        }
        if (!this.kbF.getIsFromMark()) {
            this.kfq.s(this.kbF.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a cHT() {
        return this.keN.cHT();
    }

    public boolean cHU() {
        if (this.kbF == null) {
            return false;
        }
        return this.kbF.cHU();
    }

    public void cJD() {
        if (this.kfq != null) {
            this.kfq.cLJ();
            bYx();
        }
    }

    public PostData cGW() {
        return this.kfq.b(this.kbF.kcE, this.kbF.cKb());
    }

    public void onBackPressed() {
        if (this.kfS != null && !this.kfS.isEmpty()) {
            int size = this.kfS.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.kfS.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.kfS == null) {
                this.kfS = new ArrayList();
            }
            if (!this.kfS.contains(aVar)) {
                this.kfS.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.kfS == null) {
                this.kfS = new ArrayList();
            }
            if (!this.kfS.contains(aVar)) {
                this.kfS.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.kfS != null) {
            this.kfS.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ae.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJE() {
        if (this.kbF != null && !com.baidu.tbadk.core.util.ar.isEmpty(this.kbF.cJZ())) {
            com.baidu.tbadk.BdToken.c.aMo().p(com.baidu.tbadk.BdToken.b.dyB, com.baidu.adp.lib.f.b.toLong(this.kbF.cJZ(), 0L));
        }
    }

    public bd cJF() {
        return this.kfk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JS(String str) {
        if (this.kbF != null && this.kbF.getPbData() != null && this.kbF.getPbData().cGN() != null && this.kbF.getPbData().cGN().aQZ()) {
            bu cGN = this.kbF.getPbData().cGN();
            int i = 0;
            if (cGN.aQX()) {
                i = 1;
            } else if (cGN.aQY()) {
                i = 2;
            } else if (cGN.aUl()) {
                i = 3;
            } else if (cGN.aUm()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao(str);
            aoVar.ag("obj_source", 4);
            aoVar.ag("obj_type", i);
            TiebaStatic.log(aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(final int i) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: aPv */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.cJd(), i2, PbFragment.this.kbF);
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.84
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13833");
        aoVar.ag("obj_locate", 1);
        if (i == 3) {
            aoVar.ag("obj_type", 1);
        } else if (i == 8) {
            aoVar.ag("obj_type", 2);
        }
        TiebaStatic.log(aoVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cJG() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cJH() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cJI() {
        return this.keN;
    }
}
