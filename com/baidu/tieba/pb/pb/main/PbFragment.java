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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bg;
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
import com.baidu.tieba.pb.pb.main.ai;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.q;
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
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0792a {
    private com.baidu.tieba.tbadkCore.data.e eCG;
    private com.baidu.tbadk.core.message.a eCW;
    private com.baidu.adp.lib.d.b<TbImageView> eJH;
    private LikeModel eLp;
    private bd eii;
    private com.baidu.adp.lib.d.b<ImageView> fry;
    private com.baidu.adp.lib.d.b<GifView> frz;
    private com.baidu.adp.lib.d.b<TextView> fuR;
    private com.baidu.adp.lib.d.b<View> fuS;
    private com.baidu.adp.lib.d.b<LinearLayout> fuT;
    private com.baidu.adp.lib.d.b<RelativeLayout> fuU;
    private com.baidu.tieba.callfans.a hGy;
    private VoiceManager ioV;
    private com.baidu.tieba.f.b itR;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private String kXo;
    public com.baidu.tbadk.core.util.am kdd;
    public bb khj;
    private PbActivity laM;
    private com.baidu.tieba.pb.pb.main.b.b laO;
    private com.baidu.tieba.tbadkCore.data.f lbB;
    private com.baidu.tbadk.editortools.pb.g lbC;
    private com.baidu.tbadk.editortools.pb.e lbD;
    private com.baidu.tieba.frs.profession.permission.c lbF;
    private EmotionImageData lbG;
    private com.baidu.adp.base.e lbJ;
    private com.baidu.tbadk.core.view.c lbK;
    private BdUniqueId lbL;
    private Runnable lbM;
    private com.baidu.adp.widget.ImageView.a lbN;
    private String lbO;
    private TbRichTextMemeInfo lbP;
    private List<a> lbS;
    public String lbU;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lbe;
    private View lbf;
    int lbh;
    private bf lbk;
    private com.baidu.tieba.pb.pb.report.a lbo;
    private com.baidu.tbadk.core.dialog.i lbv;
    private com.baidu.tbadk.core.dialog.k lbw;
    private boolean lbx;
    private String lcG;
    private com.baidu.tbadk.core.data.r lcH;
    private boolean lcx;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lcD = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cu(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.ddE();
            } else {
                com.baidu.tieba.pb.a.b.ddD();
            }
        }
    };
    private boolean laN = false;
    private boolean laP = false;
    private boolean bwE = false;
    private boolean kwW = false;
    private boolean laQ = true;
    private int laR = 0;
    private com.baidu.tbadk.core.dialog.b laS = null;
    private long hRt = -1;
    private long fgW = 0;
    private long laT = 0;
    private long createTime = 0;
    private long fgM = 0;
    private boolean laU = false;
    private com.baidu.tbadk.n.b laV = null;
    private long laW = 0;
    private boolean laX = false;
    private long laY = 0;
    private int iSP = 1;
    private String fbv = null;
    private boolean laZ = false;
    private boolean isFullScreen = false;
    private boolean lba = false;
    private String lbb = "";
    private boolean lbc = true;
    private boolean lbd = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lbg = new int[2];
    private int lbi = -1;
    private int lbj = -1;
    public BdUniqueId lbl = BdUniqueId.gen();
    private boolean lbm = false;
    private boolean kYN = com.baidu.tbadk.a.d.bdC();
    private PbInterviewStatusView.a lbn = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lbr.ul(!PbFragment.this.lbc);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.bec()) {
                        PbFragment.this.deZ();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel kXs = null;
    private com.baidu.tbadk.baseEditMark.a lbp = null;
    private ForumManageModel hGw = null;
    private com.baidu.tbadk.coreExtra.model.a ezg = null;
    private com.baidu.tieba.pb.data.q lbq = null;
    private ShareSuccessReplyToServerModel iId = null;
    private az lbr = null;
    private boolean lbs = false;
    private boolean lbt = false;
    private boolean lbu = false;
    private boolean fIF = false;
    private boolean lby = false;
    private boolean lbz = false;
    private boolean lbA = false;
    private boolean lbE = false;
    public boolean lbH = false;
    private com.baidu.tbadk.editortools.pb.c fby = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bvK() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fbz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (PbFragment.this.khj == null || PbFragment.this.khj.diS() == null || !PbFragment.this.khj.diS().dNl()) {
                return !PbFragment.this.Fj(com.baidu.tbadk.core.util.am.ezb);
            }
            PbFragment.this.showToast(PbFragment.this.khj.diS().dNn());
            if (PbFragment.this.lbD != null && (PbFragment.this.lbD.bwa() || PbFragment.this.lbD.bwb())) {
                PbFragment.this.lbD.a(false, PbFragment.this.khj.diV());
            }
            PbFragment.this.khj.uy(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lbI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (PbFragment.this.khj == null || PbFragment.this.khj.diT() == null || !PbFragment.this.khj.diT().dNl()) {
                return !PbFragment.this.Fj(com.baidu.tbadk.core.util.am.ezc);
            }
            PbFragment.this.showToast(PbFragment.this.khj.diT().dNn());
            if (PbFragment.this.lbr != null && PbFragment.this.lbr.dhB() != null && PbFragment.this.lbr.dhB().deA() != null && PbFragment.this.lbr.dhB().deA().bwb()) {
                PbFragment.this.lbr.dhB().deA().a(PbFragment.this.khj.diV());
            }
            PbFragment.this.khj.uz(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean ipK = false;
    private int lbQ = 0;
    private int lbR = -1;
    public int lbT = 0;
    private final a lbV = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lbr != null && PbFragment.this.lbr.dhB() != null) {
                v dhB = PbFragment.this.lbr.dhB();
                if (dhB.dey()) {
                    dhB.dex();
                    return true;
                }
            }
            if (PbFragment.this.lbr != null && PbFragment.this.lbr.diz()) {
                PbFragment.this.lbr.diA();
                return true;
            }
            return false;
        }
    };
    private final ai.a lbW = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void bk(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lbr.showToast(str);
            }
        }
    };
    private final CustomMessageListener lbX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.kXs != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lbD != null) {
                    PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                }
                PbFragment.this.lbr.dhD();
                PbFragment.this.lbr.dir();
            }
        }
    };
    CustomMessageListener iqB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.kXs.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.lbr != null && PbFragment.this.kXs != null) {
                    PbFragment.this.lbr.b(PbFragment.this.kXs.getPbData(), PbFragment.this.kXs.dfQ(), PbFragment.this.kXs.dgn(), PbFragment.this.lbr.getSkinType());
                }
                if (PbFragment.this.lbr != null && PbFragment.this.lbr.dhU() != null) {
                    PbFragment.this.lbr.dhU().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lbY = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lbr != null) {
                    if (booleanValue) {
                        PbFragment.this.lbr.cNM();
                    } else {
                        PbFragment.this.lbr.cNL();
                    }
                }
            }
        }
    };
    private CustomMessageListener lbZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lbD != null) {
                    PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                }
                PbFragment.this.lbr.us(false);
            }
        }
    };
    private CustomMessageListener lca = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lcb = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lbr != null && PbFragment.this.lbr.dhU() != null) {
                PbFragment.this.lbr.dhU().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jEs = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iqx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bwE) {
                PbFragment.this.dfr();
            }
        }
    };
    private View.OnClickListener fch = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fbv);
        }
    };
    private CustomMessageListener lcc = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kXs.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.kXs.dge() != null && PbFragment.this.kXs.dge().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.lbr.a(agVar.sendCount, PbFragment.this.kXs.getPbData(), PbFragment.this.kXs.dfQ(), PbFragment.this.kXs.dgn());
                    }
                    if (pbData.dcC() != null && pbData.dcC().size() >= 1 && pbData.dcC().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dcC().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.kXs.dfO(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dEx = pbData.dcC().get(0).dEx();
                            if (dEx == null) {
                                dEx = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> bgZ = dEx.bgZ();
                            if (bgZ == null) {
                                bgZ = new ArrayList<>();
                            }
                            bgZ.add(0, aVar);
                            dEx.setTotal(agVar.sendCount + dEx.getTotal());
                            dEx.D(bgZ);
                            pbData.dcC().get(0).a(dEx);
                            PbFragment.this.lbr.dhU().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lcd = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                PbFragment.this.kXs.getPbData().dcU();
                PbFragment.this.kXs.dgj();
                if (PbFragment.this.lbr.dhU() != null) {
                    PbFragment.this.lbr.s(PbFragment.this.kXs.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.OJ(str);
                PbFragment.this.kXs.dgj();
                if (!TextUtils.isEmpty(str) && PbFragment.this.kXs.getPbData().dcC() != null) {
                    ArrayList<PostData> dcC = PbFragment.this.kXs.getPbData().dcC();
                    Iterator<PostData> it = dcC.iterator();
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
                        dcC.remove(nVar);
                        if (PbFragment.this.lbr.dhU() != null && PbFragment.this.lbr.dhU().getDataList() != null) {
                            PbFragment.this.lbr.dhU().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.lbr.getListView() != null && PbFragment.this.lbr.getListView().getData() != null) {
                            PbFragment.this.lbr.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.lbr.dhU() != null) {
                            PbFragment.this.lbr.dhU().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lbr.dhU() != null) {
                    PbFragment.this.lbr.s(PbFragment.this.kXs.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lce = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.djl()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lcf = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void bk(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lbr != null) {
                PbFragment.this.lbr.eN(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lcg = false;
    private PraiseModel lch = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void EU(String str) {
            PbFragment.this.lcg = false;
            if (PbFragment.this.lch != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kXs.getPbData();
                if (pbData.dcA().bhS().getIsLike() == 1) {
                    PbFragment.this.zn(0);
                } else {
                    PbFragment.this.zn(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dcA()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lcg = false;
            if (PbFragment.this.lch != null && str != null) {
                if (AntiHelper.bM(i, str)) {
                    AntiHelper.bk(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lci = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void tP(boolean z) {
            PbFragment.this.tN(z);
            if (PbFragment.this.lbr.diF() != null && z) {
                PbFragment.this.lbr.ul(false);
            }
            PbFragment.this.lbr.un(z);
        }
    };
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().eQq != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().eQq, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dcJ().bih() != null && PbFragment.this.dcJ().bih().getGodUserData() != null) {
                            PbFragment.this.dcJ().bih().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null) {
                            PbFragment.this.kXs.getPbData().dcA().bih().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h inZ = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.laM.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lcj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lbr.cbz();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.Fl(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cCx();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c eTx = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.deJ();
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
                        if (PbFragment.this.cZ(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lbr.deH() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dK("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.ddF() != null && PbFragment.this.ddF().hYm != null) {
                                PbFragment.this.ddF().hYm.onClick(view);
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
                if (PbFragment.this.lbD != null) {
                    PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                }
                PbFragment.this.lbr.dhD();
                PbFragment.this.lbr.dir();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lck = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lbL) {
                PbFragment.this.lbr.cbz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.kXs.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dcQ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lbK.showSuccessToast(PbFragment.this.lbJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lbJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Dm(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dfn();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lbJ.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lbK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lcl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lbL) {
                PbFragment.this.lbr.cbz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lbK.showSuccessToast(PbFragment.this.lbJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lbJ.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lbK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lcm = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lbL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lbr.cbz();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.mTb;
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
                    PbFragment.this.lbr.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lcn = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lbr.dhE() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.deJ();
            }
        }
    };
    private CustomMessageListener iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.ipK = true;
                }
            }
        }
    };
    public a.b kId = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.ctd();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.kXs.getPageData();
            int pageNum = PbFragment.this.lbr.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bgS()) {
                PbFragment.this.lbr.dir();
                PbFragment.this.ctc();
                PbFragment.this.lbr.dhY();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.kXs.Fp(PbFragment.this.lbr.getPageNum());
                    if (PbFragment.this.laO != null) {
                        PbFragment.this.laO.showFloatingView();
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
    private k.c lco = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lbv != null) {
                PbFragment.this.lbv.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.lbN != null && !TextUtils.isEmpty(PbFragment.this.lbO)) {
                        if (PbFragment.this.lbP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lbO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lbO;
                            aVar.pkgId = PbFragment.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lbP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lbN = null;
                        PbFragment.this.lbO = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lbN != null && !TextUtils.isEmpty(PbFragment.this.lbO)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eii == null) {
                                PbFragment.this.eii = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eii.j(PbFragment.this.lbO, PbFragment.this.lbN.getImageByte());
                            PbFragment.this.lbN = null;
                            PbFragment.this.lbO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jsr != null) {
                        PbFragment.this.jsr.fS(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jsr = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").aj("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.da(view);
                        if (PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null && PbFragment.this.kXs.getPbData().dcA().bih().getUserId() != null && PbFragment.this.lbp != null) {
                            int h = PbFragment.this.h(PbFragment.this.kXs.getPbData());
                            bw dcA = PbFragment.this.kXs.getPbData().dcA();
                            if (dcA.bgP()) {
                                i2 = 2;
                            } else if (dcA.bgQ()) {
                                i2 = 3;
                            } else if (dcA.bkc()) {
                                i2 = 4;
                            } else {
                                i2 = dcA.bkd() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dK("tid", PbFragment.this.kXs.leE).aj("obj_locate", 2).dK("obj_id", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()).aj("obj_type", PbFragment.this.lbp.bec() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i2));
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
                        PbFragment.this.OL((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").aj("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.lbr.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                PbFragment.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.lbr.dg(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lbr.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bjY() != null) {
                            PbFragment.this.d(postData.bjY());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public SortSwitchButton.a lcp = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yQ(int i) {
            PbFragment.this.lbr.dir();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.kXs == null || PbFragment.this.kXs.isLoading) {
                    return false;
                }
                PbFragment.this.ctc();
                PbFragment.this.lbr.dhY();
                if (PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().kUy != null && PbFragment.this.kXs.getPbData().kUy.size() > i) {
                    int intValue = PbFragment.this.kXs.getPbData().kUy.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dK("tid", PbFragment.this.kXs.dfP()).dK("fid", PbFragment.this.kXs.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).aj("obj_type", Fn(intValue)));
                    if (PbFragment.this.kXs.Fu(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lbr.ug(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int Fn(int i) {
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
    public final View.OnClickListener irI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        /* JADX WARN: Removed duplicated region for block: B:787:0x22e3  */
        /* JADX WARN: Removed duplicated region for block: B:790:0x2327  */
        /* JADX WARN: Removed duplicated region for block: B:807:0x2500  */
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
            cb cbVar;
            SparseArray sparseArray;
            boolean z2;
            String str;
            com.baidu.tbadk.core.dialog.g gVar4;
            String[] strArr;
            com.baidu.tieba.pb.data.f pbData;
            boolean z3;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.lbr.din()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.kXs.tV(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lbr.dhZ();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhd()) {
                        if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhe()) {
                            if (view == PbFragment.this.lbr.lix.fjs) {
                                if (PbFragment.this.lbr.up(PbFragment.this.kXs.dfV())) {
                                    PbFragment.this.ctc();
                                    return;
                                }
                                PbFragment.this.laQ = false;
                                PbFragment.this.laP = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.laM, PbFragment.this.lbr.lix.fjs);
                                PbFragment.this.laM.finish();
                            } else if (view != PbFragment.this.lbr.dhW() && (PbFragment.this.lbr.lix.djy() == null || (view != PbFragment.this.lbr.lix.djy().dhc() && view != PbFragment.this.lbr.lix.djy().dha()))) {
                                if (view == PbFragment.this.lbr.div()) {
                                    if (PbFragment.this.kXs != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXs.getPbData().dcA().big().getLink());
                                    }
                                } else if (view != PbFragment.this.lbr.lix.loS) {
                                    if (view == PbFragment.this.lbr.lix.loT) {
                                        if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                            ArrayList<PostData> dcC = PbFragment.this.kXs.getPbData().dcC();
                                            if ((dcC == null || dcC.size() <= 0) && PbFragment.this.kXs.dfQ()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dK("tid", PbFragment.this.kXs.dfO()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", PbFragment.this.kXs.getForumId()));
                                            if (!PbFragment.this.lbr.diK()) {
                                                PbFragment.this.lbr.dhD();
                                            }
                                            PbFragment.this.deR();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lbr.tC(true);
                                            PbFragment.this.lbr.dhD();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lbr.cNM();
                                                PbFragment.this.ctc();
                                                PbFragment.this.lbr.dhY();
                                                PbFragment.this.kXs.OQ(PbFragment.this.dfd());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dgZ()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lbr.lix.djy() != null && view == PbFragment.this.lbr.lix.djy().dgY()) {
                                                PbFragment.this.lbr.lix.aVi();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.Fm(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dgW()) {
                                                    if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhg()) {
                                                        if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dgX()) {
                                                            if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhh()) {
                                                                if (PbFragment.this.lbr.diF() == view) {
                                                                    if (PbFragment.this.lbr.diF().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.kXs.getPbData();
                                                                        if (pbData2 != null && pbData2.dcA() != null && pbData2.dcA().bhN() != null) {
                                                                            String bhD = pbData2.dcA().bhN().bhD();
                                                                            if (StringUtils.isNull(bhD)) {
                                                                                bhD = pbData2.dcA().bhN().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dK("obj_id", bhD));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gl("c10725", null);
                                                                    }
                                                                    PbFragment.this.dfk();
                                                                } else if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhf()) {
                                                                    if (PbFragment.this.lbr.lix.djy() != null && view == PbFragment.this.lbr.lix.djy().dhb()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lbr.b(PbFragment.this.kXs.getPbData(), PbFragment.this.kXs.dfQ(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lbr.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lbr.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lbr.lix.aVi();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dK("tid", PbFragment.this.kXs.dfO());
                                                                            aqVar.dK("fid", PbFragment.this.kXs.getForumId());
                                                                            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.aj("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                PbFragment.this.lbr.dir();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dEB() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mFc != null) {
                                                                                        com.baidu.tbadk.core.util.aq bmQ = postData.mFc.bmQ();
                                                                                        bmQ.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bmQ.aj("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bmQ.aj("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bmQ);
                                                                                    }
                                                                                    String dfO = PbFragment.this.kXs.dfO();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.kXs.getPbData() != null) {
                                                                                        i3 = PbFragment.this.kXs.getPbData().dcP();
                                                                                    }
                                                                                    PbFragment.this.ctc();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a OO = PbFragment.this.OO(id);
                                                                                        if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && OO != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dfO, id, "pb", true, null, true, null, i3, postData.dkx(), PbFragment.this.kXs.getPbData().getAnti(), false, postData.bih().getIconInfo()).addBigImageData(OO.kXA, OO.eje, OO.ejc, OO.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.kXs.dgy());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.kXs.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.kXs.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.kXs.dfX());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a OO2 = PbFragment.this.OO(id);
                                                                                        if (postData != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && OO2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dfO, id, "pb", true, null, false, str2, i3, postData.dkx(), PbFragment.this.kXs.getPbData().getAnti(), false, postData.bih().getIconInfo()).addBigImageData(OO2.kXA, OO2.eje, OO2.ejc, OO2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.kXs.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.kXs.dfX());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.kXs.dgy());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.kXs.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").aj("obj_locate", 3).dK("fid", PbFragment.this.kXs.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.kXs != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dK("tid", PbFragment.this.kXs.dfO());
                                                                            aqVar2.dK("fid", PbFragment.this.kXs.getForumId());
                                                                            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.aj("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mFc != null) {
                                                                                        com.baidu.tbadk.core.util.aq bmQ2 = postData3.mFc.bmQ();
                                                                                        bmQ2.delete("obj_locate");
                                                                                        bmQ2.aj("obj_locate", 8);
                                                                                        TiebaStatic.log(bmQ2);
                                                                                    }
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                        String dfO2 = PbFragment.this.kXs.dfO();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.kXs.getPbData() != null) {
                                                                                            i4 = PbFragment.this.kXs.getPbData().dcP();
                                                                                        }
                                                                                        PbActivity.a OO3 = PbFragment.this.OO(id2);
                                                                                        if (OO3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dfO2, id2, "pb", true, null, false, null, i4, postData3.dkx(), PbFragment.this.kXs.getPbData().getAnti(), false, postData3.bih().getIconInfo()).addBigImageData(OO3.kXA, OO3.eje, OO3.ejc, OO3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.kXs.dgy());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.kXs.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.kXs.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.kXs.dfX());
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
                                                                        if (PbFragment.this.kXs != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dK("tid", PbFragment.this.kXs.dfO());
                                                                                aqVar3.dK("fid", PbFragment.this.kXs.getForumId());
                                                                                aqVar3.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.aj("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mFc != null) {
                                                                                        com.baidu.tbadk.core.util.aq bmQ3 = postData4.mFc.bmQ();
                                                                                        bmQ3.delete("obj_locate");
                                                                                        bmQ3.aj("obj_locate", 8);
                                                                                        TiebaStatic.log(bmQ3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dK("tid", PbFragment.this.kXs.dfP()).dK("fid", PbFragment.this.kXs.getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData4.getId()).aj("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.deG().dhA() != null && postData4.bih() != null && postData4.dEp() != 1) {
                                                                                        if (PbFragment.this.deG().dhB() != null) {
                                                                                            PbFragment.this.deG().dhB().dew();
                                                                                        }
                                                                                        if ((PbFragment.this.kYN || com.baidu.tbadk.a.d.bds()) && postData4.dEm() != null && postData4.dEm().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bdt()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.kXs.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.kXs.getPbData().dcA());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.deG().dhA().d(pVar);
                                                                                            PbFragment.this.deG().dhA().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bih().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lbD != null) {
                                                                                                PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
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
                                                                        if (view != PbFragment.this.lbr.dea()) {
                                                                            if (view == PbFragment.this.lbr.lix.djz()) {
                                                                                PbFragment.this.lbr.dif();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cbVar = (cb) view.getTag()) != null && !StringUtils.isNull(cbVar.bkx())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.be.bmY().b(PbFragment.this.getPageContext(), new String[]{cbVar.bkx()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dK("tid", PbFragment.this.kXs.leE));
                                                                                            }
                                                                                            if (PbFragment.this.lbw == null) {
                                                                                                PbFragment.this.lbw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lbw.a(PbFragment.this.lco);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.db(view);
                                                                                            if (!PbFragment.this.db(view) || PbFragment.this.lbN == null || !PbFragment.this.lbN.isGif()) {
                                                                                            }
                                                                                            boolean z4 = false;
                                                                                            boolean z5 = false;
                                                                                            boolean z6 = false;
                                                                                            boolean z7 = false;
                                                                                            boolean z8 = false;
                                                                                            String str3 = null;
                                                                                            if (sparseArray5.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                                ((Boolean) sparseArray5.get(R.id.tag_is_subpb)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                                z4 = ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z5 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                                z6 = ((Boolean) sparseArray5.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                                z7 = ((Boolean) sparseArray5.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                                z8 = ((Boolean) sparseArray5.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            }
                                                                                            if (sparseArray5.get(R.id.tag_forbid_user_post_id) instanceof String) {
                                                                                                str3 = (String) sparseArray5.get(R.id.tag_forbid_user_post_id);
                                                                                            }
                                                                                            if (postData5 != null) {
                                                                                                if (postData5.dEr() != null && postData5.dEr().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lbw);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jsr = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.kXs.getPbData().bec()) {
                                                                                                String beb = PbFragment.this.kXs.getPbData().beb();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(beb) && beb.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lbw);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lbw);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jsr);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z6 && z5) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lbw);
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
                                                                                                            gVar.mTextView.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar6);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.tJ(z4) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
                                                                                                                gVar7.mTextView.setTag(str3);
                                                                                                                arrayList.add(gVar7);
                                                                                                            }
                                                                                                        }
                                                                                                        if (z6) {
                                                                                                            SparseArray sparseArray9 = new SparseArray();
                                                                                                            sparseArray9.put(R.id.tag_should_manage_visible, true);
                                                                                                            sparseArray9.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name, sparseArray5.get(R.id.tag_forbid_user_name));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_name_show, sparseArray5.get(R.id.tag_forbid_user_name_show));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_portrait, sparseArray5.get(R.id.tag_forbid_user_portrait));
                                                                                                            sparseArray9.put(R.id.tag_forbid_user_post_id, str3);
                                                                                                            if (z7) {
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
                                                                                                            if (z8) {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                                sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lbw);
                                                                                                            gVar3.mTextView.setTag(sparseArray9);
                                                                                                        } else if (!z8) {
                                                                                                            gVar2 = null;
                                                                                                            gVar3 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.kXs.getPbData().dcP() == 1002 && !z4) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
                                                                                                            }
                                                                                                            gVar2.mTextView.setTag(sparseArray10);
                                                                                                            gVar3 = null;
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar3 != null) {
                                                                                                            arrayList.add(gVar3);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lbw.ba(arrayList);
                                                                                                    PbFragment.this.lbv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lbw);
                                                                                                    PbFragment.this.lbv.Pd();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jsr);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lbw.ba(arrayList);
                                                                                            PbFragment.this.lbv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lbw);
                                                                                            PbFragment.this.lbv.Pd();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.kXs.getPbData().dcA().getActUrl());
                                                                                        if (PbFragment.this.kXs.getPbData().dcA().biU() != 1) {
                                                                                            if (PbFragment.this.kXs.getPbData().dcA().biU() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dK("fid", PbFragment.this.kXs.getPbData().getForumId()).dK("tid", PbFragment.this.kXs.getPbData().getThreadId()).dK("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.kXs.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lbr.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.blO().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lbr.dhD();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.deP() == 1 && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dK("fid", PbFragment.this.kXs.getPbData().getForumId()).dK("tid", PbFragment.this.kXs.getPbData().getThreadId()).dK("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.deP() == 1 && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dK("fid", PbFragment.this.kXs.getPbData().getForumId()).dK("tid", PbFragment.this.kXs.getPbData().getThreadId()).dK("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dff();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dfg();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcW() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.kXs.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dK("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bmY().b(PbFragment.this.getPageContext(), new String[]{pbData3.dcW().ddi()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcW() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.kXs.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dK("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.bmY().b(PbFragment.this.getPageContext(), new String[]{pbData4.dcW().ddi()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lbQ >= 0) {
                                                                                        if (PbFragment.this.kXs != null) {
                                                                                            PbFragment.this.kXs.dgz();
                                                                                        }
                                                                                        if (PbFragment.this.kXs != null && PbFragment.this.lbr.dhU() != null) {
                                                                                            PbFragment.this.lbr.dhU().a(PbFragment.this.kXs.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lbQ = 0;
                                                                                        if (PbFragment.this.kXs != null) {
                                                                                            PbFragment.this.lbr.getListView().setSelection(PbFragment.this.kXs.dgC());
                                                                                            PbFragment.this.kXs.cX(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.Fm(8);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                                    SparseArray sparseArray11 = null;
                                                                                    if (view.getTag() instanceof SparseArray) {
                                                                                        sparseArray11 = (SparseArray) view.getTag();
                                                                                    }
                                                                                    if (sparseArray11 != null) {
                                                                                        PbFragment.this.d(sparseArray11);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                                    if (PbFragment.this.lbr.getListView() != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lbr.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lbr.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dda = PbFragment.this.kXs.getPbData().dda();
                                                                                        boolean z9 = PbFragment.this.lbr.dhC() != null && PbFragment.this.lbr.dhC().bRF();
                                                                                        boolean dio = PbFragment.this.lbr.dio();
                                                                                        boolean z10 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (dda && PbFragment.this.lbr.dhC() != null && PbFragment.this.lbr.dhC().bKm() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lbr.dhC().dji();
                                                                                            z10 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.lbr.dhC().bKm().getHeight() - PbFragment.this.lbr.dhC().dji());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.OP("c13568");
                                                                                        if ((PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bhY() <= 0) || (dio && z10)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.deM();
                                                                                                if (PbFragment.this.kXs.getPbData().dcA().bih() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dK("tid", PbFragment.this.kXs.leE).dK("fid", PbFragment.this.kXs.getPbData().getForumId()).aj("obj_locate", 2).dK("uid", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z11 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dda) {
                                                                                                if (PbFragment.this.lbr.ljH != null && PbFragment.this.lbr.ljH.lkM != null && PbFragment.this.lbr.ljH.lkM.getView() != null) {
                                                                                                    if (PbFragment.this.lbr.ljH.lkM.getView().getParent() == null) {
                                                                                                        z11 = firstVisiblePosition >= PbFragment.this.deV();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.lbr.dhC() != null && PbFragment.this.lbr.dhC().bKm() != null) {
                                                                                                            i6 = PbFragment.this.lbr.dhC().bKm().getBottom();
                                                                                                        }
                                                                                                        z11 = PbFragment.this.lbr.ljH.lkM.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lbr.dhL() != null) {
                                                                                                z11 = PbFragment.this.lbr.dhL().getVisibility() == 0;
                                                                                                if (!z11 && PbFragment.this.lbr.ljH != null && PbFragment.this.lbr.ljH.lkM != null && PbFragment.this.lbr.ljH.lkM.getView() != null && PbFragment.this.lbr.ljH.lkM.getView().getParent() != null && PbFragment.this.lbr.lix != null && PbFragment.this.lbr.lix.mNavigationBar != null) {
                                                                                                    z11 = PbFragment.this.lbr.ljH.lkM.getView().getTop() - PbFragment.this.lbr.lix.mNavigationBar.getBottom() < PbFragment.this.lbr.ljH.lkM.lhW.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z11 || dio) {
                                                                                                PbFragment.this.lbi = firstVisiblePosition;
                                                                                                PbFragment.this.lbj = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lbr.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lbi > 0) {
                                                                                                if (PbFragment.this.lbr.getListView().getChildAt(PbFragment.this.lbi) != null) {
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollToPosition(PbFragment.this.lbi, PbFragment.this.lbj, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lbr.getListView().setSelectionFromTop(PbFragment.this.lbi, PbFragment.this.lbj + equipmentHeight);
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int deV = PbFragment.this.deV();
                                                                                                if (PbFragment.this.deU() != -1) {
                                                                                                    deV--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (deV < 0) {
                                                                                                    i = PbFragment.this.lbr.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lbr.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = deV;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z9) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!dda || PbFragment.this.lbr.dhC() == null) {
                                                                                                    if (PbFragment.this.lbr.lix != null && PbFragment.this.lbr.lix.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.lbr.lix.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.lbr.dhC().djh();
                                                                                                }
                                                                                                if (PbFragment.this.lbr.ljH == null || PbFragment.this.lbr.ljH.lkM == null || PbFragment.this.lbr.ljH.lkM.getView() == null || PbFragment.this.lbr.ljH.lkM.getView().getParent() == null) {
                                                                                                    PbFragment.this.lbr.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z9) {
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lbr.getListView().smoothScrollBy(PbFragment.this.lbr.ljH.lkM.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dK("tid", PbFragment.this.kXs.leE).dK("fid", PbFragment.this.kXs.getPbData().getForumId()).aj("obj_locate", 2).dK("uid", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.kXs.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.kXs.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.kXs.ddH()) || PbFragment.this.kXs.getAppealInfo() == null) {
                                                                                                PbFragment.this.laM.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.kXs.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.kXs.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.laM.finish();
                                                                                            return;
                                                                                        }
                                                                                        String ddH = PbFragment.this.kXs.ddH();
                                                                                        if (PbFragment.this.kXs.dfR() && ddH != null && ddH.equals(name)) {
                                                                                            PbFragment.this.laM.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.kXs.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dK("tid", PbFragment.this.kXs.dfO());
                                                                                        aqVar4.dK("fid", PbFragment.this.kXs.getForumId());
                                                                                        aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.kXs.getPbData().dcA() != null) {
                                                                                            aqVar4.dK("nid", PbFragment.this.kXs.getPbData().dcA().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.kXs.dgy() == 3 && PbFragment.this.ddG() && PbFragment.this.kXs.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.kXs.getPbData().dcX())) {
                                                                                            PbFragment.this.laM.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar.bil(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dK("tid", bwVar.getId());
                                                                                        aqVar5.u("fid", bwVar.getFid());
                                                                                        aqVar5.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dK("nid", bwVar.getNid());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.kXs != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dK("tid", PbFragment.this.kXs.dfO());
                                                                                        aqVar6.dK("fid", PbFragment.this.kXs.getForumId());
                                                                                        aqVar6.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.aj("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.kXs.getPbData();
                                                                                        if (PbFragment.this.lbq == null) {
                                                                                            PbFragment.this.lbq = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").u("forum_id", j2).bmR();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lcs);
                                                                                        PbFragment.this.lbq.E(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dK("fid", PbFragment.this.kXs.getForumId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("obj_name", smartApp.name).u("obj_id", smartApp.swan_app_id.longValue()).dK("obj_source", "PB_card").dK("tid", PbFragment.this.kXs.dfO()).aj("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar2 = (bw) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar2.bil(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dK("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 9).aj("obj_locate", 9).u("obj_id", bwVar2.getFid()).dK("tid", bwVar2.getId()).aj("thread_type", bwVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bw) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bw bwVar3 = (bw) view.getTag();
                                                                                        if (PbFragment.this.eLp != null) {
                                                                                            PbFragment.this.eLp.gk(bwVar3.bil(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dK("page_type", PageStayDurationConstants.PageName.PB).aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_adlocate", 10).aj("obj_locate", 11).u("obj_id", bwVar3.getFid()).dK("tid", bwVar3.getId()).aj("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.kXs.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.kXs.dfO(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.kXs.getPbData().dcA().biC())));
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
                                                                            if (PbFragment.this.lbw == null) {
                                                                                PbFragment.this.lbw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lbw.a(PbFragment.this.lco);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z12 = PbFragment.this.ddQ().getPbData() != null && PbFragment.this.ddQ().getPbData().ddd();
                                                                            if (view != null && sparseArray != null) {
                                                                                boolean z13 = false;
                                                                                boolean z14 = false;
                                                                                boolean z15 = false;
                                                                                boolean z16 = false;
                                                                                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                                    z2 = false;
                                                                                } else {
                                                                                    z2 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z13 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                    z14 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                    z15 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                }
                                                                                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                    z16 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                }
                                                                                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                    str = null;
                                                                                } else {
                                                                                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                                                                                }
                                                                                if (postData6.bjY() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bjY().hasAgree && postData6.bjI() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lbw);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z14 && z13) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lbw);
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
                                                                                        gVar9.mTextView.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar9);
                                                                                    } else {
                                                                                        if ((PbFragment.this.tJ(z2) && TbadkCoreApplication.isLogin()) && !z12) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
                                                                                            gVar10.mTextView.setTag(str);
                                                                                            arrayList2.add(gVar10);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar11 = null;
                                                                                    if (z14) {
                                                                                        SparseArray sparseArray14 = new SparseArray();
                                                                                        sparseArray14.put(R.id.tag_should_manage_visible, true);
                                                                                        sparseArray14.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                                                        sparseArray14.put(R.id.tag_forbid_user_post_id, str);
                                                                                        if (z15) {
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
                                                                                        if (z16) {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray14.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray14.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray14.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lbw);
                                                                                        gVar4.mTextView.setTag(sparseArray14);
                                                                                    } else {
                                                                                        if (z16) {
                                                                                            SparseArray sparseArray15 = new SparseArray();
                                                                                            sparseArray15.put(R.id.tag_should_manage_visible, false);
                                                                                            sparseArray15.put(R.id.tag_user_mute_visible, false);
                                                                                            sparseArray15.put(R.id.tag_should_delete_visible, true);
                                                                                            sparseArray15.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                                                            sparseArray15.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                                                                                            sparseArray15.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                                            sparseArray15.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                                            if (PbFragment.this.kXs.getPbData().dcP() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
                                                                                            }
                                                                                            gVar11.mTextView.setTag(sparseArray15);
                                                                                        }
                                                                                        gVar4 = null;
                                                                                    }
                                                                                    if (gVar11 != null) {
                                                                                        arrayList2.add(gVar11);
                                                                                    }
                                                                                    if (gVar4 != null) {
                                                                                        arrayList2.add(gVar4);
                                                                                    }
                                                                                }
                                                                                PbFragment.this.lbw.ba(arrayList2);
                                                                                PbFragment.this.lbv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lbw);
                                                                                PbFragment.this.lbv.Pd();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lbr.dir();
                                                                    SparseArray<Object> b3 = PbFragment.this.lbr.b(PbFragment.this.kXs.getPbData(), PbFragment.this.kXs.dfQ(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXs.getPbData().getForum().getId(), PbFragment.this.kXs.getPbData().getForum().getName(), PbFragment.this.kXs.getPbData().dcA().getId(), String.valueOf(PbFragment.this.kXs.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    com.baidu.tbadk.core.util.ap.C(true, false);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 0).aj("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).aj("obj_type", 1).aj("obj_source", 1));
                                                                }
                                                                PbFragment.this.lbr.lix.djx();
                                                            }
                                                        } else if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null) {
                                                            PbFragment.this.lbr.lix.aVi();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.OL(PbFragment.this.kXs.getPbData().dcA().biy());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lbr.dir();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.kXs.dgh()));
                                                                return;
                                                            }
                                                            PbFragment.this.ctc();
                                                            PbFragment.this.lbr.dhY();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.kXs.getPbData().kUy == null || PbFragment.this.kXs.getPbData().kUy.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.kXs.getPbData().kUy.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.kXs.getPbData().kUy.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.kXs.getPbData().kUy.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.kXs.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.kXs.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.kXs.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.kXs.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").aj("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aj("obj_type", i10));
                                                                    if (PbFragment.this.kXs.getPbData().kUy != null && PbFragment.this.kXs.getPbData().kUy.size() > i9) {
                                                                        i9 = PbFragment.this.kXs.getPbData().kUy.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Fu = PbFragment.this.kXs.Fu(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.kXs.dgh()));
                                                                    if (Fu) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lbr.ug(true);
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
                                                    PbFragment.this.lbr.dir();
                                                    if (PbFragment.this.ddQ().getPbData().kUz != 2) {
                                                        if (PbFragment.this.kXs.getPageData() != null) {
                                                            PbFragment.this.lbr.a(PbFragment.this.kXs.getPageData(), PbFragment.this.kId);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.kXs.getPbData()) != null) {
                                                bw dcA = pbData.dcA();
                                                if (dcA != null && dcA.bih() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dK("tid", PbFragment.this.kXs.leE).dK("fid", pbData.getForumId()).aj("obj_locate", 4).dK("uid", dcA.bih().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dcA != null) {
                                                    if (dcA.bgP()) {
                                                        i9 = 2;
                                                    } else if (dcA.bgQ()) {
                                                        i9 = 3;
                                                    } else if (dcA.bkc()) {
                                                        i9 = 4;
                                                    } else if (dcA.bkd()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dK("tid", PbFragment.this.kXs.dfO());
                                                aqVar7.dK("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dK("fid", PbFragment.this.kXs.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.aj("obj_locate", 5);
                                                } else {
                                                    aqVar7.aj("obj_locate", 6);
                                                }
                                                aqVar7.aj("obj_name", i9);
                                                aqVar7.aj("obj_type", 1);
                                                if (dcA != null) {
                                                    if (dcA.bgP()) {
                                                        aqVar7.aj("obj_type", 10);
                                                    } else if (dcA.bgQ()) {
                                                        aqVar7.aj("obj_type", 9);
                                                    } else if (dcA.bkd()) {
                                                        aqVar7.aj("obj_type", 8);
                                                    } else if (dcA.bkc()) {
                                                        aqVar7.aj("obj_type", 7);
                                                    } else if (dcA.isShareThread) {
                                                        aqVar7.aj("obj_type", 6);
                                                    } else if (dcA.threadType == 0) {
                                                        aqVar7.aj("obj_type", 1);
                                                    } else if (dcA.threadType == 40) {
                                                        aqVar7.aj("obj_type", 2);
                                                    } else if (dcA.threadType == 49) {
                                                        aqVar7.aj("obj_type", 3);
                                                    } else if (dcA.threadType == 54) {
                                                        aqVar7.aj("obj_type", 4);
                                                    } else {
                                                        aqVar7.aj("obj_type", 5);
                                                    }
                                                    aqVar7.aj(IntentConfig.CARD_TYPE, dcA.bkg());
                                                    aqVar7.dK(IntentConfig.RECOM_SOURCE, dcA.mRecomSource);
                                                    aqVar7.dK("ab_tag", dcA.mRecomAbTag);
                                                    aqVar7.dK("weight", dcA.mRecomWeight);
                                                    aqVar7.dK("extra", dcA.mRecomExtra);
                                                    aqVar7.dK("nid", dcA.getNid());
                                                    if (dcA.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(dcA.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dK("obj_param6", dcA.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dfv() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dfv(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dcC2 = PbFragment.this.kXs.getPbData().dcC();
                                                    if ((dcC2 != null && dcC2.size() > 0) || !PbFragment.this.kXs.dfQ()) {
                                                        PbFragment.this.lbr.dir();
                                                        PbFragment.this.ctc();
                                                        if (pbData.dcW() != null && !StringUtils.isNull(pbData.dcW().bgd(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dK("fid", PbFragment.this.kXs.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dcA)) {
                                                            if (PbFragment.this.lbr != null) {
                                                                PbFragment.this.lbr.diu();
                                                                PbFragment.this.lbr.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lbr.showLoadingDialog();
                                                                PbFragment.this.kXs.dgt().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.Fl(i10);
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
                                            PbFragment.this.lbr.dir();
                                            if (PbFragment.this.lbr.lix.djy() != null && view == PbFragment.this.lbr.lix.djy().dgZ() && !PbFragment.this.lbr.diK()) {
                                                PbFragment.this.lbr.dhD();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.ctc();
                                                PbFragment.this.lbr.dhY();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    z3 = PbFragment.this.kXs.z(true, PbFragment.this.dfd());
                                                } else {
                                                    z3 = view.getId() == R.id.reply_title ? PbFragment.this.kXs.z(false, PbFragment.this.dfd()) : PbFragment.this.kXs.OQ(PbFragment.this.dfd());
                                                }
                                                view.setTag(Boolean.valueOf(z3));
                                                if (z3) {
                                                    PbFragment.this.lbr.tC(true);
                                                    PbFragment.this.lbr.cNM();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lbr.ug(true);
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
                                        PbFragment.this.lbr.dir();
                                        if (PbFragment.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.kXs.Fv(PbFragment.this.lbr.did()) != null) {
                                            PbFragment.this.deY();
                                            if (PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dK("tid", PbFragment.this.kXs.leE).dK("fid", PbFragment.this.kXs.getPbData().getForumId()).aj("obj_locate", 3).dK("uid", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()));
                                            }
                                            if (PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null && PbFragment.this.kXs.getPbData().dcA().bih().getUserId() != null && PbFragment.this.lbp != null) {
                                                int h = PbFragment.this.h(PbFragment.this.kXs.getPbData());
                                                bw dcA2 = PbFragment.this.kXs.getPbData().dcA();
                                                int i11 = 1;
                                                if (dcA2.bgP()) {
                                                    i11 = 2;
                                                } else if (dcA2.bgQ()) {
                                                    i11 = 3;
                                                } else if (dcA2.bkc()) {
                                                    i11 = 4;
                                                } else if (dcA2.bkd()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dK("tid", PbFragment.this.kXs.leE).aj("obj_locate", 1).dK("obj_id", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()).aj("obj_type", PbFragment.this.lbp.bec() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i11));
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
                                    if (PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bgN() && PbFragment.this.kXs.getPbData().dcA().biz() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.kXs.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.kXs.ddH()) || PbFragment.this.kXs.getAppealInfo() == null) {
                                            PbFragment.this.laM.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.kXs.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.kXs.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.laM.finish();
                                        return;
                                    }
                                    String ddH2 = PbFragment.this.kXs.ddH();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.kXs.dfR() && ddH2 != null && ddH2.equals(name2)) {
                                        PbFragment.this.laM.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.kXs.getPbData() != null) {
                                    if ((PbFragment.this.kXs.getPbData().dcP() == 1 || PbFragment.this.kXs.getPbData().dcP() == 3) && !PbFragment.this.hGw.dFa()) {
                                        PbFragment.this.lbr.dir();
                                        int i12 = 0;
                                        if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dha()) {
                                            if (PbFragment.this.lbr.lix.djy() == null || view != PbFragment.this.lbr.lix.djy().dhc()) {
                                                if (view == PbFragment.this.lbr.dhW()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.kXs.getPbData().dcA().bid() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.kXs.getPbData().dcA().bic() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.kXs.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.kXs.getPbData().dcA().getId();
                                        PbFragment.this.lbr.dhV();
                                        PbFragment.this.hGw.b(id4, name3, id5, i12, PbFragment.this.lbr.dhX());
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
                            PbFragment.this.lbr.lix.djx();
                            if (PbFragment.this.kXs != null) {
                                PbFragment.this.hGy.setThreadId(PbFragment.this.kXs.dfO());
                            }
                            int i13 = 1;
                            if (PbFragment.this.kXs == null || !PbFragment.this.kXs.isPrivacy()) {
                                PbFragment.this.hGy.cif();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.ddQ() != null && PbFragment.this.ddQ().getPbData() != null && PbFragment.this.ddQ().getPbData().getThreadId() != null && PbFragment.this.ddQ().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.ddQ() != null && PbFragment.this.ddQ().getPbData() != null) {
                                    PbFragment.this.hGy.k(3, i13, PbFragment.this.ddQ().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.ddQ() != null && PbFragment.this.ddQ().getPbData() != null) {
                                    PbFragment.this.hGy.k(3, 3, PbFragment.this.ddQ().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lbr.dir();
                        PbFragment.this.ctc();
                        PbFragment.this.lbr.dhY();
                        PbFragment.this.lbr.showLoadingDialog();
                        if (PbFragment.this.lbr.dhL() != null) {
                            PbFragment.this.lbr.dhL().setVisibility(8);
                        }
                        PbFragment.this.kXs.Fp(1);
                        if (PbFragment.this.laO != null) {
                            PbFragment.this.laO.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String deN = PbFragment.this.deN();
                        if (!TextUtils.isEmpty(deN)) {
                            com.baidu.tbadk.core.util.be.bmY().b(PbFragment.this.getPageContext(), new String[]{deN});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dK("tid", PbFragment.this.kXs.dfO());
                aqVar8.dK("fid", PbFragment.this.kXs.getForumId());
                aqVar8.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.aj("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.laX) {
                    PbFragment.this.laX = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.deG().dhA() != null && postData7.bih() != null && postData7.dEp() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.deG().dhB() != null) {
                                PbFragment.this.deG().dhB().dew();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.kXs.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.kXs.getPbData().dcA());
                            pVar2.g(postData7);
                            PbFragment.this.deG().dhA().d(pVar2);
                            PbFragment.this.deG().dhA().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bih().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kXs.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lbD != null) {
                                PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lcq = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.kXs != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.kXs.leE)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kXs.getPbData() != null) {
                    aqVar.dK("fid", PbFragment.this.kXs.getPbData().getForumId());
                }
                aqVar.dK("tid", PbFragment.this.kXs.dfO());
                aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.ctc();
            PbFragment.this.lbr.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.kXs.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.kXs.getPbData();
                            if (pbData != null && pbData.dcA() != null && pbData.dcA().bih() != null && (userId = pbData.dcA().bih().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.kXs.dga()) {
                                PbFragment.this.lbr.dhY();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.kXs.dga()) {
                            PbFragment.this.lbr.dhY();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lbr.s(PbFragment.this.kXs.getPbData());
                    }
                    if (PbFragment.this.kXs.dfU()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dK("tid", PbFragment.this.kXs.dfO()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.tI(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lbD.bwa() || PbFragment.this.lbD.bwb()) {
                    PbFragment.this.lbD.a(false, postWriteCallBackData);
                }
                PbFragment.this.khj.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kdd != null) {
                    PbFragment.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AH(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bkJ();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lcr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                    aqVar.dK("fid", PbFragment.this.kXs.getPbData().getForumId());
                }
                if (PbFragment.this.kXs != null) {
                    aqVar.dK("tid", PbFragment.this.kXs.dfO());
                }
                aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.khj != null) {
                    PbFragment.this.khj.diQ();
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
                if (PbFragment.this.kdd != null) {
                    PbFragment.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), PbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(PbFragment.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AH(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bkJ();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.khj != null) {
                if (PbFragment.this.lbr != null && PbFragment.this.lbr.dhB() != null && PbFragment.this.lbr.dhB().deA() != null && PbFragment.this.lbr.dhB().deA().bwb()) {
                    PbFragment.this.lbr.dhB().deA().a(postWriteCallBackData);
                }
                PbFragment.this.khj.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lcs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView diN;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.laM.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lbr != null && (diN = PbFragment.this.lbr.diN()) != null && PbFragment.this.lbr.getListView() != null) {
                            PbFragment.this.lbr.getListView().removeHeaderView(diN);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lct = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qM;
            if (!z || fVar == null || fVar.dcN() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dcC()) >= 1) {
                PbFragment.this.kwW = true;
                PbFragment.this.lbr.dia();
                if (fVar == null || !fVar.dcI()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lbr.getView());
                }
                PbFragment.this.lbr.cNL();
                if (PbFragment.this.isFullScreen || PbFragment.this.lbr.diK()) {
                    PbFragment.this.lbr.diB();
                } else if (!PbFragment.this.lbr.diy()) {
                    PbFragment.this.lbr.us(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fIF = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lbr.getView());
                    PbFragment.this.lbr.dij();
                }
                if (z && fVar != null) {
                    bw dcA = fVar.dcA();
                    if (dcA == null || !dcA.bgR()) {
                        PbFragment.this.d(PbFragment.this.lbC);
                    } else {
                        dfx();
                    }
                    PbFragment.this.lbr.dhB().setPbData(fVar);
                    PbFragment.this.lbr.bPU();
                    if (dcA != null && dcA.bjs() != null) {
                        PbFragment.this.a(dcA.bjs());
                    }
                    if (PbFragment.this.lbD != null) {
                        PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dcC() != null && fVar.dcC().size() >= 1 && fVar.dcC().get(0) != null) {
                        PbFragment.this.kXs.OS(fVar.dcC().get(0).getId());
                    } else if (fVar.dcN() != null) {
                        PbFragment.this.kXs.OS(fVar.dcN().getId());
                    }
                    if (PbFragment.this.lbD != null) {
                        PbFragment.this.lbD.a(fVar.getAnti());
                        PbFragment.this.lbD.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lbD.setThreadData(dcA);
                        PbFragment.this.lbD.a(PbFragment.this.kXs.dge(), PbFragment.this.kXs.dfO(), PbFragment.this.kXs.dgv());
                        if (dcA != null) {
                            PbFragment.this.lbD.jP(dcA.bjE());
                        }
                    }
                    if (PbFragment.this.lbp != null) {
                        PbFragment.this.lbp.hU(fVar.bec());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.ddd()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lbr.ur(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lbr.a(fVar, i2, i3, PbFragment.this.kXs.dfQ(), i4, PbFragment.this.kXs.getIsFromMark());
                    PbFragment.this.lbr.d(fVar, PbFragment.this.kXs.dfQ());
                    PbFragment.this.lbr.uo(PbFragment.this.kXs.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fbv = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fbv) && PbFragment.this.lbD != null && PbFragment.this.lbD.bvf() != null && (qM = PbFragment.this.lbD.bvf().qM(6)) != null && !TextUtils.isEmpty(PbFragment.this.fbv)) {
                            ((View) qM).setOnClickListener(PbFragment.this.fch);
                        }
                    }
                    if (PbFragment.this.lby) {
                        PbFragment.this.lby = false;
                        final int deU = PbFragment.this.deU();
                        if (!fVar.dda()) {
                            PbFragment.this.lbr.FC(deU);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(deU, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lbz) {
                        PbFragment.this.lbz = false;
                        final int deU2 = PbFragment.this.deU();
                        final boolean z2 = deU2 != -1;
                        if (!z2) {
                            deU2 = PbFragment.this.deV();
                        }
                        if (PbFragment.this.lbr != null) {
                            if (!fVar.dda()) {
                                PbFragment.this.lbr.FC(deU2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (deU2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lbr.setSelectionFromTop(deU2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lbr.setSelectionFromTop(deU2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lbr.ut(true);
                                PbFragment.this.lbr.us(false);
                            }
                        }
                    } else if (PbFragment.this.lbA) {
                        PbFragment.this.lbA = false;
                        PbFragment.this.lbr.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lbr.die();
                    }
                    PbFragment.this.kXs.a(fVar.getForum(), PbFragment.this.lce);
                    PbFragment.this.kXs.a(PbFragment.this.lcf);
                    if (PbFragment.this.kdd != null && dcA != null && dcA.bih() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dcA.bih());
                        PbFragment.this.kdd.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fIF && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.kXs.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.kXs.getAppealInfo().kUq)) {
                                    PbFragment.this.lbr.a(PbFragment.this.kXs.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lbr.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lbr.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lbr.diB();
                            PbFragment.this.lbr.dii();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.kXs.dfO());
                            jSONObject.put("fid", PbFragment.this.kXs.getForumId());
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
                        PbFragment.this.lbr.OY("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                            arrayList = PbFragment.this.kXs.getPbData().dcC();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dEp() != 1)) {
                            PbFragment.this.lbr.OY(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dfo()) {
                                PbFragment.this.lbr.OZ(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lbr.OZ(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lbr.s(PbFragment.this.kXs.getPbData());
                        }
                    }
                    PbFragment.this.lbr.endLoadData();
                }
                if (fVar != null && fVar.kUF && PbFragment.this.fgW == 0) {
                    PbFragment.this.fgW = System.currentTimeMillis() - PbFragment.this.hRt;
                }
                if (!PbFragment.this.ddQ().dfQ() || PbFragment.this.ddQ().getPbData().getPage().bgY() != 0 || PbFragment.this.ddQ().dgq()) {
                    PbFragment.this.lbE = true;
                    return;
                }
                return;
            }
            PbFragment.this.kXs.Fp(1);
            if (PbFragment.this.laO != null) {
                PbFragment.this.laO.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dfx() {
            if (PbFragment.this.kXs != null) {
                if (PbFragment.this.lbD == null || !PbFragment.this.lbD.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lbD = (com.baidu.tbadk.editortools.pb.e) dVar.ei(PbFragment.this.getContext());
                    PbFragment.this.lbD.a(PbFragment.this.laM.getPageContext());
                    PbFragment.this.lbD.a(PbFragment.this.fbF);
                    PbFragment.this.lbD.a(PbFragment.this.fby);
                    PbFragment.this.lbD.a(PbFragment.this.laM.getPageContext(), PbFragment.this.laM.getIntent() == null ? null : PbFragment.this.laM.getIntent().getExtras());
                    PbFragment.this.lbD.bvf().jF(true);
                    PbFragment.this.lbr.setEditorTools(PbFragment.this.lbD.bvf());
                    if (!PbFragment.this.kXs.dfV()) {
                        PbFragment.this.lbD.Dh(PbFragment.this.kXs.dfO());
                    }
                    if (PbFragment.this.kXs.dgw()) {
                        PbFragment.this.lbD.Df(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lbr != null) {
                        PbFragment.this.lbD.Df(PbFragment.this.lbr.dhF());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lbr.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.byc().byd()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.hRt : j;
                if (PbFragment.this.fgW == 0) {
                    PbFragment.this.fgW = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.fgM, PbFragment.this.createTime, PbFragment.this.fgW, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fgM = 0L;
                if (iVar != null) {
                    iVar.bxZ();
                }
                if (z2) {
                    iVar.fhf = currentTimeMillis;
                    iVar.kb(true);
                }
                if (!z2 && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null) {
                    int threadType = PbFragment.this.kXs.getPbData().dcA().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.lbb, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.lbb, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.fhh = currentTimeMillis;
                                iVar2.rp(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fhh = currentTimeMillis;
                        dVar.rp(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lcu = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.deQ();
            }
        }
    };
    private final a.InterfaceC0547a lcv = new a.InterfaceC0547a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0547a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.lbr.dia();
            if (z) {
                if (PbFragment.this.lbp != null) {
                    PbFragment.this.lbp.hU(z2);
                }
                PbFragment.this.kXs.tX(z2);
                if (PbFragment.this.kXs.bec()) {
                    PbFragment.this.deZ();
                } else {
                    PbFragment.this.lbr.s(PbFragment.this.kXs.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lbp != null) {
                        if (PbFragment.this.lbp.bef() != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.kXs.getPbData().dcA() != null && PbFragment.this.kXs.getPbData().dcA().bih() != null) {
                            MarkData bef = PbFragment.this.lbp.bef();
                            MetaData bih = PbFragment.this.kXs.getPbData().dcA().bih();
                            if (bef != null && bih != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), bih.getUserId()) && !bih.hadConcerned()) {
                                    PbFragment.this.b(bih);
                                } else {
                                    PbFragment.this.showToast(R.string.add_mark_on_pb);
                                    if (com.baidu.tbadk.coreExtra.c.a.w(PbFragment.this.getContext(), 0)) {
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
                    PbFragment.this.deW();
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
            if (!PbFragment.this.Fa(PbFragment.this.mLastScrollState) && PbFragment.this.Fa(i)) {
                if (PbFragment.this.lbr != null) {
                    PbFragment.this.lbr.dir();
                    if (PbFragment.this.lbD != null && !PbFragment.this.lbr.dhE()) {
                        PbFragment.this.lbr.uq(PbFragment.this.lbD.bvT());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lbr.dhD();
                    }
                }
                if (!PbFragment.this.laU) {
                    PbFragment.this.laU = true;
                    if (PbFragment.this.lbr != null) {
                        PbFragment.this.lbr.dix();
                    }
                }
            }
            if (PbFragment.this.lbr != null) {
                PbFragment.this.lbr.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.laO != null) {
                PbFragment.this.laO.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.laV == null) {
                PbFragment.this.laV = new com.baidu.tbadk.n.b();
                PbFragment.this.laV.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.laV.bxT();
            } else {
                PbFragment.this.laV.bxS();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dDn().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dcC;
            if (PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null && PbFragment.this.lbr != null && PbFragment.this.lbr.dhU() != null) {
                PbFragment.this.lbr.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.laO != null) {
                    PbFragment.this.laO.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.kXs.dgm() && (dcC = PbFragment.this.kXs.getPbData().dcC()) != null && !dcC.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lbr.dhU().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.kXs.getPbData();
                    if (pbData != null) {
                        if (pbData.dcD() != null && pbData.dcD().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dcE() != null && pbData.dcE().hasData()) {
                            headerCount--;
                        }
                        int size = dcC.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hGD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hGw.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.kXs.dgj();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lqP != 1002 || bVar.gyX) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lbr.a(1, dVar.QO, dVar.mGW, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hGw.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lbr.a(PbFragment.this.hGw.getLoadDataMode(), gVar.QO, gVar.mGW, false);
                            PbFragment.this.lbr.aZ(gVar.mGZ);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lbr.a(PbFragment.this.hGw.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lcw = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fGo = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dfe()) {
                PbFragment.this.laM.finish();
            }
            if (!PbFragment.this.kXs.tW(true)) {
                PbFragment.this.lbr.dib();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lcy = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lcx && PbFragment.this.dfe()) {
                PbFragment.this.dfg();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lbm && PbFragment.this.lbr != null && PbFragment.this.lbr.diP() && PbFragment.this.kXs != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dK("tid", PbFragment.this.kXs.dfO());
                    aqVar.dK("fid", PbFragment.this.kXs.getForumId());
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    PbFragment.this.lbm = true;
                }
                if (PbFragment.this.kXs.tV(false)) {
                    PbFragment.this.lbr.dhZ();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.kXs.getPbData() != null) {
                    PbFragment.this.lbr.diw();
                }
                PbFragment.this.lcx = true;
            }
        }
    };
    private int lcz = 0;
    private final TbRichTextView.i frJ = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dhU;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lbr.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dK("tid", PbFragment.this.kXs.dfO());
                aqVar.dK("fid", PbFragment.this.kXs.getForumId());
                aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.aj("obj_locate", 3);
                aqVar.aj("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.kXs.kYp.ddd()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bBr() != null) {
                            ArrayList<TbRichTextImageInfo> bBr = tbRichTextView.getRichText().bBr();
                            int i4 = 0;
                            while (i4 < bBr.size()) {
                                if (bBr.get(i4) != null) {
                                    arrayList.add(bBr.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bBr.get(i4).getSrc()) || str.equals(bBr.get(i4).bBM()) || str.equals(bBr.get(i4).bBJ()) || str.equals(bBr.get(i4).bBL()) || str.equals(bBr.get(i4).bBP()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bBr.get(i4).getSrc();
                                    imageUrlData.originalUrl = bBr.get(i4).getSrc();
                                    imageUrlData.isLongPic = bBr.get(i4).bBR();
                                    concurrentHashMap.put(bBr.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).nu(i3).ib(false).ic(PbFragment.this.kXs.dgg()).a(concurrentHashMap).id(true).ie(false).m36if(PbFragment.this.dfo()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.kXs != null) {
                            aVar.Ac(PbFragment.this.kXs.getFromForumId());
                            if (PbFragment.this.kXs.getPbData() != null) {
                                aVar.s(PbFragment.this.kXs.getPbData().dcA());
                            }
                        }
                        ImageViewerConfig dU = aVar.dU(PbFragment.this.getPageContext().getPageActivity());
                        dU.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.kXB) {
                        TbRichText bw = PbFragment.this.bw(str, i);
                        if (bw != null && PbFragment.this.lcz >= 0 && PbFragment.this.lcz < bw.bBq().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bw.bBq().get(PbFragment.this.lcz));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.kXA.size()) {
                                    break;
                                } else if (!aVar2.kXA.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bw.getPostId() != 0 && (dhU = PbFragment.this.lbr.dhU()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dhU.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bw.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bw.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.kXs.dgv(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.kXs.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eje.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).zX(aVar2.forumName).zY(aVar2.forumId).zZ(aVar2.threadId).ib(aVar2.ejc).id(true).Aa(aVar2.lastId).ic(PbFragment.this.kXs.dgg()).a(concurrentHashMap2).ie(false).m36if(PbFragment.this.dfo()).Ab(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.kXs != null) {
                                aVar3.Ac(PbFragment.this.kXs.getFromForumId());
                                if (PbFragment.this.kXs.getPbData() != null) {
                                    aVar3.s(PbFragment.this.kXs.getPbData().dcA());
                                }
                            }
                            ImageViewerConfig dU2 = aVar3.dU(PbFragment.this.getPageContext().getPageActivity());
                            dU2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.kXA, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eje.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).zX(aVar2.forumName).zY(aVar2.forumId).zZ(aVar2.threadId).ib(aVar2.ejc).id(true).Aa(aVar2.kXA.get(0)).ic(PbFragment.this.kXs.dgg()).a(concurrentHashMap3).ie(false).m36if(PbFragment.this.dfo()).Ab(aVar2.postId).ig(false);
                    if (PbFragment.this.kXs != null) {
                        aVar4.Ac(PbFragment.this.kXs.getFromForumId());
                        if (PbFragment.this.kXs.getPbData() != null) {
                            aVar4.s(PbFragment.this.kXs.getPbData().dcA());
                        }
                    }
                    ImageViewerConfig dU3 = aVar4.dU(PbFragment.this.getPageContext().getPageActivity());
                    dU3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lbf = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lcA = false;
    PostData jsr = null;
    private final b.InterfaceC0550b lcB = new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jsr != null) {
                if (i == 0) {
                    PbFragment.this.jsr.fS(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jsr = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jsr);
                }
            }
        }
    };
    private final b.InterfaceC0550b lcC = new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lbN != null && !TextUtils.isEmpty(PbFragment.this.lbO)) {
                if (i == 0) {
                    if (PbFragment.this.lbP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lbO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lbO;
                        aVar.pkgId = PbFragment.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lbP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eii == null) {
                            PbFragment.this.eii = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eii.j(PbFragment.this.lbO, PbFragment.this.lbN.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lbN = null;
                PbFragment.this.lbO = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0214  */
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
            if (PbFragment.this.isAdded()) {
                if (PbFragment.this.lbr != null) {
                    if (!PbFragment.this.lbr.dfG()) {
                        PbFragment.this.lbr.diO();
                    } else {
                        return true;
                    }
                }
                SparseArray sparseArray2 = null;
                try {
                    sparseArray2 = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray2 == null) {
                    if (PbFragment.this.db(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.lbN = ((TbImageView) view).getBdImage();
                            PbFragment.this.lbO = ((TbImageView) view).getUrl();
                            if (PbFragment.this.lbN == null || TextUtils.isEmpty(PbFragment.this.lbO)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lbP = null;
                            } else {
                                PbFragment.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.lbN = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.lbO = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.lbP = null;
                                } else {
                                    PbFragment.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.lbN = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.lbO = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lbP = null;
                            } else {
                                PbFragment.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.lbr.a(PbFragment.this.lcC, PbFragment.this.lbN.isGif());
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
                PbFragment.this.jsr = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.jsr == null) {
                    return true;
                }
                if (PbFragment.this.jsr.dEp() != 1 || !PbFragment.this.db(view)) {
                    if (PbFragment.this.lbp != null) {
                        if (!PbFragment.this.lbp.bec() || PbFragment.this.jsr.getId() == null || !PbFragment.this.jsr.getId().equals(PbFragment.this.kXs.bip())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.ddQ().getPbData() != null && PbFragment.this.ddQ().getPbData().ddd();
                        if (PbFragment.this.jsr.dEp() != 1) {
                            if (PbFragment.this.lbw == null) {
                                PbFragment.this.lbw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.lbw.a(PbFragment.this.lco);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.db(view) && !z3;
                                boolean z5 = (!PbFragment.this.db(view) || PbFragment.this.lbN == null || PbFragment.this.lbN.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.lbw));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.lbw));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lbw);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.jsr);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lbw);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lbw);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.jsr);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.kYN) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lbw);
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
                                        if ((PbFragment.this.tJ(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lbw);
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
                                            if (PbFragment.this.kXs.getPbData().dcP() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lbw);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lbw);
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
                                PbFragment.this.lbw.ba(arrayList);
                                PbFragment.this.lbv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lbw);
                                PbFragment.this.lbv.Pd();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dK("tid", PbFragment.this.kXs.leE).dK("fid", PbFragment.this.kXs.getForumId()).dK("uid", PbFragment.this.kXs.getPbData().dcA().bih().getUserId()).dK("post_id", PbFragment.this.kXs.bvH()).aj("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.lbr.a(PbFragment.this.lcB, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.lbr.a(PbFragment.this.lcC, PbFragment.this.lbN.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a ime = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bwE && z && !PbFragment.this.kXs.dfW()) {
                PbFragment.this.dfb();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.itR.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0689a hNF = new a.InterfaceC0689a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gyD = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void H(int i, int i2) {
            if (ar(i2) && PbFragment.this.lbr != null && PbFragment.this.laO != null) {
                PbFragment.this.laO.pm(true);
                if (Math.abs(i2) > this.gyD) {
                    PbFragment.this.laO.hideFloatingView();
                }
                if (PbFragment.this.dfe()) {
                    PbFragment.this.lbr.dhR();
                    PbFragment.this.lbr.dhS();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void I(int i, int i2) {
            if (ar(i2) && PbFragment.this.lbr != null && PbFragment.this.laO != null) {
                PbFragment.this.lbr.diC();
                PbFragment.this.laO.pm(false);
                PbFragment.this.laO.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void J(int i, int i2) {
        }

        private boolean ar(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a kZP = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lbr.Pa(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lcE = -1;
    private int lcF = -1;

    /* loaded from: classes22.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes22.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes22.dex */
    public interface c {
    }

    public com.baidu.tbadk.editortools.pb.e deB() {
        return this.lbD;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.ddq() != null) {
            String id = pVar.ddq().getId();
            ArrayList<PostData> dcC = this.kXs.getPbData().dcC();
            int i = 0;
            while (true) {
                if (i >= dcC.size()) {
                    z = true;
                    break;
                }
                PostData postData = dcC.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> ddy = pVar.ddy();
                    postData.IX(pVar.getTotalCount());
                    if (postData.dEm() == null || ddy == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = ddy.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bih() != null && (metaData = postData.getUserMap().get(next.bih().getUserId())) != null) {
                                next.a(metaData);
                                next.wU(true);
                                next.a(getPageContext(), this.kXs.OR(metaData.getUserId()));
                            }
                        }
                        z = ddy.size() != postData.dEm().size();
                        if (postData.dEm() != null && postData.dEm().size() < 2) {
                            postData.dEm().clear();
                            postData.dEm().addAll(ddy);
                        }
                    }
                    if (postData.dEi() != null) {
                        postData.dEj();
                    }
                }
            }
            if (!this.kXs.getIsFromMark() && z) {
                this.lbr.s(this.kXs.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n dcS = this.kXs.getPbData().dcS();
            if (dcS != null && str.equals(dcS.getAdId())) {
                if (dcS.dEd() != null) {
                    dcS.dEd().legoCard = null;
                }
                this.kXs.getPbData().dcT();
            }
            com.baidu.tieba.tbadkCore.data.n dgc = this.kXs.dgc();
            if (dgc != null && str.equals(dgc.getAdId())) {
                this.kXs.dgd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lbv != null && this.lbv.isShowing()) {
                this.lbv.dismiss();
                this.lbv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lbv != null) {
                            PbFragment.this.lbv.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lbr.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lbL);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lbL);
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
                kVar.ba(arrayList);
                this.lbv = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lbv.Pd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn(int i) {
        bw dcA;
        if (this.kXs != null && this.kXs.getPbData() != null && (dcA = this.kXs.getPbData().dcA()) != null) {
            if (i == 1) {
                PraiseData bhS = dcA.bhS();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bhS == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dcA.a(praiseData);
                    } else {
                        dcA.bhS().getUser().add(0, metaData);
                        dcA.bhS().setNum(dcA.bhS().getNum() + 1);
                        dcA.bhS().setIsLike(i);
                    }
                }
                if (dcA.bhS() != null) {
                    if (dcA.bhS().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(dcA.bhS().getNum());
                    }
                }
            } else if (dcA.bhS() != null) {
                dcA.bhS().setIsLike(i);
                dcA.bhS().setNum(dcA.bhS().getNum() - 1);
                ArrayList<MetaData> user = dcA.bhS().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dcA.bhS().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dcA.bhS().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dcA.bhS().getNum() + "";
                }
            }
            if (this.kXs.dfQ()) {
                this.lbr.dhU().notifyDataSetChanged();
            } else {
                this.lbr.t(this.kXs.getPbData());
            }
        }
    }

    public static PbFragment deC() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.laM = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kXs.aC(bundle);
        if (this.ioV != null) {
            this.ioV.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lbD.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.laT = System.currentTimeMillis();
        this.lbJ = getPageContext();
        final Intent intent = this.laM.getIntent();
        if (intent != null) {
            this.hRt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lbb = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lbb)) {
                    this.lbb = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lbb)) {
                this.laP = true;
            }
            this.lcE = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lcF = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lcG = intent.getStringExtra("key_manga_title");
            this.lby = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lbz = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lbA = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dfe()) {
                this.laM.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lbR = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lbk = new bf();
            this.lbk.C(intent);
            this.lbT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lbT == 0) {
                this.lbT = intent.getIntExtra("key_start_from", 0);
            }
            this.lbU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.hRt = System.currentTimeMillis();
        }
        this.fgM = this.laT - this.hRt;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.laR = 0;
        aB(bundle);
        if (this.kXs.getPbData() != null) {
            this.kXs.getPbData().OD(this.source);
        }
        deF();
        if (intent != null && this.lbr != null) {
            this.lbr.liv = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lbM == null) {
                    this.lbM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lbr.Pc(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.lbM, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.kXs.getPbData() != null) {
                this.kXs.OU(stringExtra);
            }
        }
        this.ioV = new VoiceManager();
        this.ioV.onCreate(getPageContext());
        initData(bundle);
        this.lbC = new com.baidu.tbadk.editortools.pb.g();
        d(this.lbC);
        this.lbD = (com.baidu.tbadk.editortools.pb.e) this.lbC.ei(getActivity());
        this.lbD.a(this.laM.getPageContext());
        this.lbD.a(this.fbF);
        this.lbD.a(this.fby);
        this.lbD.setFrom(1);
        this.lbD.a(this.laM.getPageContext(), bundle);
        this.lbD.bvf().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lbD.bvf().jF(true);
        tH(true);
        this.lbD.a(this.kXs.dge(), this.kXs.dfO(), this.kXs.dgv());
        registerListener(this.lbZ);
        if (!this.kXs.dfV()) {
            this.lbD.Dh(this.kXs.dfO());
        }
        if (this.kXs.dgw()) {
            this.lbD.Df(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lbr != null) {
            this.lbD.Df(this.lbr.dhF());
        }
        registerListener(this.lbY);
        registerListener(this.lca);
        registerListener(this.lcb);
        registerListener(this.iqB);
        registerListener(this.lcn);
        registerListener(this.lbX);
        this.lbB = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.mDH);
        this.lbB.dDV();
        registerListener(this.lcc);
        registerListener(this.ezk);
        this.kXs.dgo();
        registerListener(this.lcu);
        registerListener(this.iqJ);
        registerListener(this.lcq);
        if (this.lbr != null && this.lbr.diG() != null && this.lbr.diH() != null) {
            this.laO = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lbr.diG(), this.lbr.diH(), this.lbr.dhL());
            this.laO.a(this.lci);
        }
        if (this.laN && this.lbr != null && this.lbr.diH() != null) {
            this.lbr.diH().setVisibility(8);
        }
        this.lbK = new com.baidu.tbadk.core.view.c();
        this.lbK.toastTime = 1000L;
        registerListener(this.lcm);
        registerListener(this.lck);
        registerListener(this.lcl);
        registerListener(this.iJx);
        registerListener(this.iqx);
        this.lcd.setSelfListener(true);
        this.lcd.setTag(this.laM.getUniqueId());
        this.lcd.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lcd);
        registerResponsedEventListener(TipEvent.class, this.inZ);
        this.lbL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lbL;
        userMuteAddAndDelCustomMessage.setTag(this.lbL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lbL;
        userMuteCheckCustomMessage.setTag(this.lbL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kXs.dgt().a(this.lcj);
        this.khj = new bb();
        if (this.lbD.bvL() != null) {
            this.khj.e(this.lbD.bvL().getInputView());
        }
        this.lbD.a(this.fbz);
        this.iId = new ShareSuccessReplyToServerModel();
        a(this.lbV);
        this.kdd = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kdd.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.ezb) {
                        PbFragment.this.lbD.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.ezc && PbFragment.this.lbr != null && PbFragment.this.lbr.dhB() != null && PbFragment.this.lbr.dhB().deA() != null) {
                        PbFragment.this.lbr.dhB().deA().bwj();
                    } else if (i == com.baidu.tbadk.core.util.am.ezd) {
                        PbFragment.this.c(PbFragment.this.lbG);
                    }
                }
            }
        });
        this.lbo = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lbo.w(getUniqueId());
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bfA().dy("3", "");
        this.hGy = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.laT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.kXs != null) {
            gVar.setForumName(this.kXs.ddH());
            if (this.kXs.getPbData() != null && this.kXs.getPbData().getForum() != null) {
                gVar.a(this.kXs.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.kXs);
        }
    }

    public String deD() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b deE() {
        return this.laO;
    }

    private void tH(boolean z) {
        this.lbD.jM(z);
        this.lbD.jN(z);
        this.lbD.jO(z);
    }

    private void deF() {
        this.eLp = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    public az deG() {
        return this.lbr;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel ddQ() {
        return this.kXs;
    }

    public void OK(String str) {
        if (this.kXs != null && !StringUtils.isNull(str) && this.lbr != null) {
            this.lbr.uv(true);
            this.kXs.OK(str);
            this.laZ = true;
            this.lbr.dir();
            this.lbr.diB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bwE = false;
        } else {
            this.bwE = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.laR = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.laR == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
        if (this.lbr != null) {
            this.lbr.onPause();
        }
        if (!this.kXs.dfV()) {
            this.lbD.Dg(this.kXs.dfO());
        }
        if (this.kXs != null) {
            this.kXs.dgp();
        }
        com.baidu.tbadk.BdToken.c.bbM().bbX();
        MessageManager.getInstance().unRegisterListener(this.jEs);
        cGT();
        MessageManager.getInstance().unRegisterListener(this.lck);
        MessageManager.getInstance().unRegisterListener(this.lcl);
        MessageManager.getInstance().unRegisterListener(this.lcm);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean deH() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.kXs.getPbData(), this.kXs.dfQ(), this.kXs.dgn());
        return (a2 == null || a2.bih() == null || a2.bih().getGodUserData() == null || a2.bih().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bwE = false;
        super.onResume();
        if (this.lbd) {
            this.lbd = false;
            dfk();
        }
        if (deH()) {
            this.laW = System.currentTimeMillis();
        } else {
            this.laW = -1L;
        }
        if (this.lbr != null && this.lbr.getView() != null) {
            if (!this.kwW) {
                dfc();
            } else {
                hideLoadingView(this.lbr.getView());
            }
            this.lbr.onResume();
        }
        if (this.laR == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lbr != null) {
            noNetworkView = this.lbr.dhy();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        registerListener(this.jEs);
        this.lbx = false;
        dfj();
        registerListener(this.lck);
        registerListener(this.lcl);
        registerListener(this.lcm);
        if (this.ipK) {
            dfb();
            this.ipK = false;
        }
        dfr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lbr.uk(z);
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
        if (z && this.lbx) {
            this.lbr.dhZ();
            this.kXs.tV(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.laW > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dK("obj_duration", (System.currentTimeMillis() - this.laW) + ""));
            this.laW = 0L;
        }
        if (deG().dhB() != null) {
            deG().dhB().onStop();
        }
        if (this.lbr.lix != null && !this.lbr.lix.djA()) {
            this.lbr.lix.releaseResources();
        }
        if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().getForum() != null && this.kXs.getPbData().dcA() != null) {
            com.baidu.tbadk.distribute.a.buS().b(getPageContext().getPageActivity(), "pb", this.kXs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kXs.getPbData().dcA().getId(), 0L));
        }
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lbl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dK("fid", this.kXs.getPbData().getForumId());
            aqVar.dK("tid", this.kXs.dfO());
            aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.laU && this.lbr != null) {
            this.laU = true;
            this.lbr.dix();
            a(false, (PostData) null);
        }
        if (this.kXs != null) {
            this.kXs.cancelLoadData();
            this.kXs.destory();
            if (this.kXs.dgs() != null) {
                this.kXs.dgs().onDestroy();
            }
        }
        if (this.lbD != null) {
            this.lbD.onDestroy();
        }
        if (this.hGw != null) {
            this.hGw.cancelLoadData();
        }
        if (this.eLp != null) {
            this.eLp.dDI();
        }
        if (this.lbr != null) {
            this.lbr.onDestroy();
            if (this.lbr.lix != null) {
                this.lbr.lix.releaseResources();
            }
        }
        if (this.laV != null) {
            this.laV.bxU();
        }
        if (this.laO != null) {
            this.laO.cuU();
        }
        super.onDestroy();
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        if (this.lbr != null) {
            this.lbr.dir();
        }
        MessageManager.getInstance().unRegisterListener(this.lck);
        MessageManager.getInstance().unRegisterListener(this.lcl);
        MessageManager.getInstance().unRegisterListener(this.lcm);
        MessageManager.getInstance().unRegisterListener(this.lbL);
        MessageManager.getInstance().unRegisterListener(this.lcn);
        MessageManager.getInstance().unRegisterListener(this.iqJ);
        MessageManager.getInstance().unRegisterListener(this.iJx);
        MessageManager.getInstance().unRegisterListener(this.lcs);
        MessageManager.getInstance().unRegisterListener(this.lcd);
        this.lbJ = null;
        this.lbK = null;
        com.baidu.tieba.recapp.d.a.dvt().dvw();
        if (this.lbM != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lbM);
        }
        if (this.lbe != null) {
            this.lbe.cancelLoadData();
        }
        if (this.lbr != null && this.lbr.lix != null) {
            this.lbr.lix.djD();
        }
        if (this.iId != null) {
            this.iId.cancelLoadData();
        }
        this.khj.onDestroy();
        if (this.kXs != null && this.kXs.dgu() != null) {
            this.kXs.dgu().onDestroy();
        }
        if (this.kdd != null) {
            this.kdd.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dhU;
        ArrayList<PostData> dem;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bpW() && this.lbr != null && (dhU = this.lbr.dhU()) != null && (dem = dhU.dem()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dem.iterator();
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
                        bVar.hIz = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eqR == 1 && !TextUtils.isEmpty(id)) {
                    next.eqR = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.hIz = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.kXs == null || this.kXs.getPbData() == null || this.kXs.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.kXs.getPbData().getForum().getFirst_class();
                    str2 = this.kXs.getPbData().getForum().getSecond_class();
                    str = this.kXs.getPbData().getForum().getId();
                    str4 = this.kXs.dfO();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bpZ());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lbr.onChangeSkinType(i);
            if (this.lbD != null && this.lbD.bvf() != null) {
                this.lbD.bvf().onChangeSkinType(i);
            }
            if (this.lbr.dhy() != null) {
                this.lbr.dhy().onChangeSkinType(getPageContext(), i);
            }
            this.khj.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            ctc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lbr = new az(this, this.irI, this.eTx);
        this.itR = new com.baidu.tieba.f.b(getActivity());
        this.itR.a(lcD);
        this.itR.a(this.hNF);
        this.lbr.setOnScrollListener(this.mOnScrollListener);
        this.lbr.d(this.lcy);
        this.lbr.setListPullRefreshListener(this.fGo);
        this.lbr.tt(com.baidu.tbadk.core.k.bfo().isShowImages());
        this.lbr.setOnImageClickListener(this.frJ);
        this.lbr.b(this.mOnLongClickListener);
        this.lbr.g(this.ime);
        this.lbr.a(this.lcw);
        this.lbr.uk(this.mIsLogin);
        if (this.laM.getIntent() != null) {
            this.lbr.uw(this.laM.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lbr.dhA().setFromForumId(this.kXs.getFromForumId());
        this.lbr.setEditorTools(this.lbD.bvf());
        this.lbD.Df(this.lbr.dhF());
        this.lbr.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.kXs.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXs.getPbData().getForum().getId(), PbFragment.this.kXs.getPbData().getForum().getName(), PbFragment.this.kXs.getPbData().dcA().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lbr.ux(this.kXs.dfT());
        this.lbr.Fw(this.kXs.dgy());
        return this.lbr.getView();
    }

    public void deI() {
        if (this.lbr != null && this.kXs != null) {
            if ((this.kXs.getPbData() != null || this.kXs.getPbData().dcZ() != null) && checkUpIsLogin() && this.lbr.dhU() != null && this.lbr.dhU().der() != null) {
                this.lbr.dhU().der().BN(this.kXs.dfO());
            }
        }
    }

    public void deJ() {
        TiebaStatic.log("c12181");
        if (this.lbr != null && this.kXs != null) {
            if ((this.lbr == null || this.lbr.dhE()) && this.kXs.getPbData() != null && this.kXs.getPbData().dcZ() != null) {
                com.baidu.tieba.pb.data.o dcZ = this.kXs.getPbData().dcZ();
                if (checkUpIsLogin()) {
                    if ((!dcZ.dds() || dcZ.bjI() != 2) && this.lbr.dhU() != null && this.lbr.dhU().der() != null) {
                        this.lbr.dhU().der().BN(this.kXs.dfO());
                    }
                    if (System.currentTimeMillis() - this.laY > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).vf(false);
                        this.laY = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cZ(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.epC && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bfo().isShowImages()) {
                    return ON(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.kXs == null || this.kXs.getPbData() == null) {
                        return true;
                    }
                    if (deG().dhB() != null) {
                        deG().dhB().dew();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.kXs.getPbData().getForum());
                    pVar.setThreadData(this.kXs.getPbData().dcA());
                    pVar.g(postData);
                    deG().dhA().d(pVar);
                    deG().dhA().setPostId(postData.getId());
                    a(view, postData.bih().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lbD != null) {
                        this.lbr.uq(this.lbD.bvT());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void deK() {
        if (this.laS == null) {
            this.laS = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.laS.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.kXo = PbFragment.this.kXo.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXo);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kXs.dfO(), PbFragment.this.kXo, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.kXo = PbFragment.this.kXo.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXo);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.kXs.dfO(), PbFragment.this.kXo, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.kXo = PbFragment.this.kXo.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.kXo);
                        bVar.dismiss();
                    }
                }
            }).oh(b.a.BOTTOM_TO_TOP).oi(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lct.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).dlD(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.kXs = this.laM.ddQ();
        if (this.kXs.dgr() != null) {
            this.kXs.dgr().a(this.kZP);
        }
        if (this.kXs.dgs() != null) {
            this.kXs.dgs().b(this.lbW);
        }
        if (StringUtils.isNull(this.kXs.dfO())) {
            this.laM.finish();
        } else if ("from_tieba_kuang".equals(this.lbb) && this.lbb != null) {
            this.kXs.Fw(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lbp = com.baidu.tbadk.baseEditMark.a.a(this.laM);
        if (this.lbp != null) {
            this.lbp.a(this.lcv);
        }
        this.hGw = new ForumManageModel(this.laM);
        this.hGw.setLoadDataCallBack(this.hGD);
        this.ezg = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lch.setUniqueId(getUniqueId());
        this.lch.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lbr.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lbL;
        userMuteCheckCustomMessage.setTag(this.lbL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean deL() {
        if (this.kXs == null || this.kXs.getPbData() == null) {
            return false;
        }
        bw dcA = this.kXs.getPbData().dcA();
        this.kXs.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dcA);
    }

    public void deM() {
        if (checkUpIsLogin() && this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().getForum() != null && !deL()) {
            if (this.kXs.getPbData().ddd()) {
                this.lbr.cGu();
                return;
            }
            if (this.itr == null) {
                this.itr = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.itr.zw(0);
                this.itr.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void ph(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pi(boolean z) {
                        if (z) {
                            if (PbFragment.this.lbD != null && PbFragment.this.lbD.bvf() != null) {
                                PbFragment.this.lbD.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lbr.cGu();
                        }
                    }
                });
            }
            this.itr.D(this.kXs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kXs.dfO(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String deN() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.kXs == null || (pbData = this.kXs.getPbData()) == null) {
            return null;
        }
        return pbData.dcO().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            if (fVar.dcA().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dcA().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dcA().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !deL() && deO()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lbg);
                this.lbh = ((View) view.getParent()).getMeasuredHeight();
            }
            if (deG().dhB() != null && postData != null) {
                String str3 = "";
                if (postData.dEr() != null) {
                    str3 = postData.dEr().toString();
                }
                deG().dhB().OI(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bih().getName_show(), str3));
            }
            if (this.kXs.getPbData() != null && this.kXs.getPbData().ddd()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.laM.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.deG().getListView().smoothScrollBy((PbFragment.this.lbg[1] + PbFragment.this.lbh) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.deG().dhB() != null) {
                            PbFragment.this.lbD.bvf().setVisibility(8);
                            PbFragment.this.deG().dhB().h(str, str2, PbFragment.this.deG().dhF(), (PbFragment.this.kXs == null || PbFragment.this.kXs.getPbData() == null || PbFragment.this.kXs.getPbData().dcA() == null || !PbFragment.this.kXs.getPbData().dcA().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h deA = PbFragment.this.deG().dhB().deA();
                            if (deA != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                deA.a(PbFragment.this.kXs.getPbData().getAnti());
                                deA.setThreadData(PbFragment.this.kXs.getPbData().dcA());
                            }
                            if (PbFragment.this.khj.diU() == null && PbFragment.this.deG().dhB().deA().bwr() != null) {
                                PbFragment.this.deG().dhB().deA().bwr().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.khj != null && PbFragment.this.khj.diT() != null) {
                                            if (!PbFragment.this.khj.diT().dNm()) {
                                                PbFragment.this.khj.uz(false);
                                            }
                                            PbFragment.this.khj.diT().xQ(false);
                                        }
                                    }
                                });
                                PbFragment.this.khj.f(PbFragment.this.deG().dhB().deA().bwr().getInputView());
                                PbFragment.this.deG().dhB().deA().a(PbFragment.this.lbI);
                            }
                        }
                        PbFragment.this.deG().diB();
                    }
                }, 0L);
                return;
            }
            if (this.lbF == null) {
                this.lbF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lbF.zw(1);
                this.lbF.a(new AnonymousClass39(str, str2));
            }
            if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().getForum() != null) {
                this.lbF.D(this.kXs.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.kXs.dfO(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lcN;
        final /* synthetic */ String lcO;

        AnonymousClass39(String str, String str2) {
            this.lcN = str;
            this.lcO = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ph(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pi(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                        }
                        PbFragment.this.deG().getListView().smoothScrollBy((PbFragment.this.lbg[1] + PbFragment.this.lbh) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.deG().dhB() != null) {
                            PbFragment.this.lbD.bvf().setVisibility(8);
                            PbFragment.this.deG().dhB().h(AnonymousClass39.this.lcN, AnonymousClass39.this.lcO, PbFragment.this.deG().dhF(), (PbFragment.this.kXs == null || PbFragment.this.kXs.getPbData() == null || PbFragment.this.kXs.getPbData().dcA() == null || !PbFragment.this.kXs.getPbData().dcA().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h deA = PbFragment.this.deG().dhB().deA();
                            if (deA != null && PbFragment.this.kXs != null && PbFragment.this.kXs.getPbData() != null) {
                                deA.a(PbFragment.this.kXs.getPbData().getAnti());
                                deA.setThreadData(PbFragment.this.kXs.getPbData().dcA());
                            }
                            if (PbFragment.this.khj.diU() == null && PbFragment.this.deG().dhB().deA().bwr() != null) {
                                PbFragment.this.deG().dhB().deA().bwr().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.khj != null && PbFragment.this.khj.diT() != null) {
                                            if (!PbFragment.this.khj.diT().dNm()) {
                                                PbFragment.this.khj.uz(false);
                                            }
                                            PbFragment.this.khj.diT().xQ(false);
                                        }
                                    }
                                });
                                PbFragment.this.khj.f(PbFragment.this.deG().dhB().deA().bwr().getInputView());
                                PbFragment.this.deG().dhB().deA().a(PbFragment.this.lbI);
                            }
                        }
                        PbFragment.this.deG().diB();
                    }
                }, 0L);
            }
        }
    }

    public boolean deO() {
        if ((this.kXs.getPbData() != null && this.kXs.getPbData().ddd()) || this.kdd == null || this.kXs.getPbData() == null || this.kXs.getPbData().getAnti() == null) {
            return true;
        }
        return this.kdd.oy(this.kXs.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean Fj(int i) {
        if (this.kdd == null || this.kXs.getPbData() == null || this.kXs.getPbData().getAnti() == null) {
            return true;
        }
        return this.kdd.aM(this.kXs.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.kXs != null && this.kXs.getPbData() != null && postData.dEp() != 1) {
            String dfO = this.kXs.dfO();
            String id = postData.getId();
            int i = 0;
            if (this.kXs.getPbData() != null) {
                i = this.kXs.getPbData().dcP();
            }
            PbActivity.a OO = OO(id);
            if (OO != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dfO, id, "pb", true, null, false, null, i, postData.dkx(), this.kXs.getPbData().getAnti(), false, postData.bih() != null ? postData.bih().getIconInfo() : null).addBigImageData(OO.kXA, OO.eje, OO.ejc, OO.index);
                addBigImageData.setKeyPageStartFrom(this.kXs.dgy());
                addBigImageData.setFromFrsForumId(this.kXs.getFromForumId());
                addBigImageData.setKeyFromForumId(this.kXs.getForumId());
                addBigImageData.setBjhData(this.kXs.dfX());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int deP() {
        if (this.kXs.getPbData() == null || this.kXs.getPbData().dcA() == null) {
            return -1;
        }
        return this.kXs.getPbData().dcA().biU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && ddQ() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            ddQ().OT(postWriteCallBackData.getPostId());
            this.lbQ = this.lbr.dhH();
            this.kXs.cX(this.lbQ, this.lbr.dhI());
        }
        this.lbr.dir();
        this.khj.diR();
        if (this.lbD != null) {
            this.lbr.uq(this.lbD.bvT());
        }
        this.lbr.dhz();
        this.lbr.us(true);
        this.kXs.dgj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(boolean z) {
        if (this.kXs != null && this.kXs.kYp != null && this.kXs.kYp.dcA() != null) {
            bw dcA = this.kXs.kYp.dcA();
            dcA.mRecomAbTag = this.kXs.dgJ();
            dcA.mRecomWeight = this.kXs.dgH();
            dcA.mRecomSource = this.kXs.dgI();
            dcA.mRecomExtra = this.kXs.dgK();
            if (dcA.getFid() == 0) {
                dcA.setFid(com.baidu.adp.lib.f.b.toLong(this.kXs.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dcA, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dK("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dK("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dK("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.aj("reply_type", 1);
                if (z) {
                    a2.aj("obj_type", 2);
                } else {
                    a2.aj("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deQ() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Rl(this.kXs.getForumId()) && this.kXs.getPbData() != null && this.kXs.getPbData().getForum() != null) {
            if (this.kXs.getPbData().getForum().isLike() == 1) {
                this.kXs.dgu().gd(this.kXs.getForumId(), this.kXs.dfO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tJ(boolean z) {
        if (this.kXs == null || this.kXs.getPbData() == null) {
            return false;
        }
        return ((this.kXs.getPbData().dcP() != 0) || this.kXs.getPbData().dcA() == null || this.kXs.getPbData().dcA().bih() == null || TextUtils.equals(this.kXs.getPbData().dcA().bih().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean tK(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.kXs == null || this.kXs.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.kXs.getPbData();
        bw dcA = pbData.dcA();
        if (dcA != null) {
            if (dcA.bgP() || dcA.bgQ()) {
                return false;
            }
            if (dcA.bkc() || dcA.bkd()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dcP() != 0) {
                return pbData.dcP() != 3;
            }
            List<bs> dcX = pbData.dcX();
            if (com.baidu.tbadk.core.util.y.getCount(dcX) > 0) {
                for (bs bsVar : dcX) {
                    if (bsVar != null && (abVar = bsVar.eoN) != null && abVar.emw && !abVar.emx && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean tL(boolean z) {
        if (z || this.kXs == null || this.kXs.getPbData() == null) {
            return false;
        }
        return ((this.kXs.getPbData().getForum() != null && this.kXs.getPbData().getForum().isBlockBawuDelete) || this.kXs.getPbData().dcP() == 0 || this.kXs.getPbData().dcP() == 3) ? false : true;
    }

    public void deR() {
        com.baidu.tieba.pb.data.f pbData;
        bw dcA;
        boolean z = true;
        if (this.kXs != null && this.kXs.getPbData() != null && (dcA = (pbData = this.kXs.getPbData()).dcA()) != null && dcA.bih() != null) {
            this.lbr.dhz();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dcA.bih().getUserId());
            ak akVar = new ak();
            int dcP = this.kXs.getPbData().dcP();
            if (dcP == 1 || dcP == 3) {
                akVar.lgL = true;
                akVar.lgK = true;
                akVar.lgQ = dcA.bic() == 1;
                akVar.lgP = dcA.bid() == 1;
            } else {
                akVar.lgL = false;
                akVar.lgK = false;
            }
            if (dcP == 1002 && !equals) {
                akVar.lgR = true;
            }
            akVar.lgI = tK(equals);
            akVar.lgM = deS();
            akVar.lgJ = tL(equals);
            akVar.Fc = this.kXs.dfQ();
            akVar.lgF = true;
            akVar.lgE = tJ(equals);
            akVar.lgD = equals && this.lbr.dig();
            akVar.lgO = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lgN = true;
            akVar.isHostOnly = this.kXs.getHostMode();
            akVar.lgH = true;
            if (dcA.biz() == null) {
                akVar.lgG = true;
            } else {
                akVar.lgG = false;
            }
            if (pbData.ddd()) {
                akVar.lgF = false;
                akVar.lgH = false;
                akVar.lgG = false;
                akVar.lgK = false;
                akVar.lgL = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.ddd()) {
                z = false;
            }
            akVar.lgS = z;
            this.lbr.lix.a(akVar);
        }
    }

    private boolean deS() {
        if (this.kXs != null && this.kXs.dfQ()) {
            return this.kXs.getPageData() == null || this.kXs.getPageData().bgY() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(View view) {
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
    public PbModel.a deT() {
        return this.lct;
    }

    public int deU() {
        if (deG() == null || deG().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = deG().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Vv == com.baidu.tieba.pb.data.n.kVO) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int deV() {
        if (deG() == null || deG().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = deG().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.mEh) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dfb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deW() {
        if (this.kXs != null && this.kXs.kYp != null && this.kXs.kYp.dcA() != null) {
            bw dcA = this.kXs.kYp.dcA();
            dcA.mRecomAbTag = this.kXs.dgJ();
            dcA.mRecomWeight = this.kXs.dgH();
            dcA.mRecomSource = this.kXs.dgI();
            dcA.mRecomExtra = this.kXs.dgK();
            if (dcA.getFid() == 0) {
                dcA.setFid(com.baidu.adp.lib.f.b.toLong(this.kXs.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dcA, "c13562");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dK("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dK("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dK("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
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
            aVar.AG(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AH(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iz(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dK("obj_id", metaData.getUserId()).aj("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dK("obj_id", metaData.getUserId()).aj("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.ezg.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.kXs.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bkJ();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lbr.dia();
        this.kXs.tX(z);
        if (this.lbp != null) {
            this.lbp.hU(z);
            if (markData != null) {
                this.lbp.a(markData);
            }
        }
        if (this.kXs.bec()) {
            deZ();
        } else {
            this.lbr.s(this.kXs.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fa(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OL(String str) {
        if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().ddd()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kXs.dfO(), str);
            bw dcA = this.kXs.getPbData().dcA();
            if (dcA.bgP()) {
                format = format + "&channelid=33833";
            } else if (dcA.bkb()) {
                format = format + "&channelid=33842";
            } else if (dcA.bgQ()) {
                format = format + "&channelid=33840";
            }
            OM(format);
            return;
        }
        this.lbo.Pm(str);
    }

    private void OM(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.kXs.dfV()) {
                    antiData.setBlock_forum_name(this.kXs.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.kXs.getPbData().getForum().getId());
                    antiData.setUser_name(this.kXs.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.kXs.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (deG() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
                } else {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bM(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            Dm(str);
        } else {
            this.lbr.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mGW) ? bVar.mGW : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AH(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.iz(true);
                aVar.b(getPageContext());
                aVar.bkJ();
            } else {
                this.lbr.a(0, bVar.QO, bVar.mGW, z);
            }
            if (bVar.QO) {
                if (bVar.hVJ == 1) {
                    ArrayList<PostData> dcC = this.kXs.getPbData().dcC();
                    int size = dcC.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dcC.get(i).getId())) {
                            i++;
                        } else {
                            dcC.remove(i);
                            break;
                        }
                    }
                    this.kXs.getPbData().dcA().nO(this.kXs.getPbData().dcA().bhY() - 1);
                    this.lbr.s(this.kXs.getPbData());
                } else if (bVar.hVJ == 0) {
                    deX();
                } else if (bVar.hVJ == 2) {
                    ArrayList<PostData> dcC2 = this.kXs.getPbData().dcC();
                    int size2 = dcC2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dcC2.get(i2).dEm().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dcC2.get(i2).dEm().get(i3).getId())) {
                                i3++;
                            } else {
                                dcC2.get(i2).dEm().remove(i3);
                                dcC2.get(i2).dEo();
                                z2 = true;
                                break;
                            }
                        }
                        dcC2.get(i2).Sb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lbr.s(this.kXs.getPbData());
                    }
                    a(bVar, this.lbr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.lbr.a(this.hGw.getLoadDataMode(), gVar.QO, gVar.mGW, false);
            if (gVar.QO) {
                this.lbs = true;
                if (i == 2 || i == 3) {
                    this.lbt = true;
                    this.lbu = false;
                } else if (i == 4 || i == 5) {
                    this.lbt = false;
                    this.lbu = true;
                }
                if (i == 2) {
                    this.kXs.getPbData().dcA().nR(1);
                    this.kXs.setIsGood(1);
                } else if (i == 3) {
                    this.kXs.getPbData().dcA().nR(0);
                    this.kXs.setIsGood(0);
                } else if (i == 4) {
                    this.kXs.getPbData().dcA().nQ(1);
                    this.kXs.Fo(1);
                } else if (i == 5) {
                    this.kXs.getPbData().dcA().nQ(0);
                    this.kXs.Fo(0);
                }
                this.lbr.c(this.kXs.getPbData(), this.kXs.dfQ());
            }
        }
    }

    private void deX() {
        if (this.kXs.dfR() || this.kXs.dfT()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.kXs.dfO());
            PbActivity pbActivity = this.laM;
            PbActivity pbActivity2 = this.laM;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.kXs.dfO()));
        if (dfa()) {
            this.laM.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ded() {
        this.laM.ded();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dcM;
        boolean z = false;
        if (this.lbr != null) {
            this.lbr.dir();
        }
        if (this.kXs != null && this.kXs.getPbData() != null && !this.kXs.getPbData().ddd()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.kXs.getPbData().dcA().getId();
            if (this.kXs.isShareThread() && this.kXs.getPbData().dcA().erY != null) {
                historyMessage.threadName = this.kXs.getPbData().dcA().erY.showText;
            } else {
                historyMessage.threadName = this.kXs.getPbData().dcA().getTitle();
            }
            if (this.kXs.isShareThread() && !ddG()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.kXs.getPbData().getForum().getName();
            }
            ArrayList<PostData> dcC = this.kXs.getPbData().dcC();
            int dic = this.lbr != null ? this.lbr.dic() : 0;
            if (dcC != null && dic >= 0 && dic < dcC.size()) {
                historyMessage.postID = dcC.get(dic).getId();
            }
            historyMessage.isHostOnly = this.kXs.getHostMode();
            historyMessage.isSquence = this.kXs.dfQ();
            historyMessage.isShareThread = this.kXs.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lbD != null) {
            this.lbD.onDestroy();
        }
        if (this.laQ && deG() != null) {
            deG().diL();
        }
        if (this.kXs != null && (this.kXs.dfR() || this.kXs.dfT())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.kXs.dfO());
            if (this.lbs) {
                if (this.lbu) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.kXs.clu());
                }
                if (this.lbt) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.kXs.getIsGood());
                }
            }
            if (this.kXs.getPbData() != null && System.currentTimeMillis() - this.laT >= 40000 && (dcM = this.kXs.getPbData().dcM()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dcM.getDataList())) {
                intent.putExtra("guess_like_data", dcM);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lbR);
            }
            PbActivity pbActivity = this.laM;
            PbActivity pbActivity2 = this.laM;
            pbActivity.setResult(-1, intent);
        }
        if (dfa()) {
            if (this.kXs != null && this.lbr != null && this.lbr.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.kXs.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dcI() && !this.laZ && pbData.kUA == null) {
                        as dhj = as.dhj();
                        com.baidu.tieba.pb.data.f dfY = this.kXs.dfY();
                        Parcelable onSaveInstanceState = this.lbr.getListView().onSaveInstanceState();
                        boolean dfQ = this.kXs.dfQ();
                        boolean hostMode = this.kXs.getHostMode();
                        if (this.lbr.dhL() != null && this.lbr.dhL().getVisibility() == 0) {
                            z = true;
                        }
                        dhj.a(dfY, onSaveInstanceState, dfQ, hostMode, z);
                        if (this.lbQ >= 0 || this.kXs.dgA() != null) {
                            as.dhj().q(this.kXs.dgA());
                            as.dhj().p(this.kXs.dgB());
                            as.dhj().Fy(this.kXs.dgC());
                        }
                    }
                }
            } else {
                as.dhj().reset();
            }
            ded();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lbr == null || !this.lbr.FE(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.laM;
        if (i == 0) {
            this.lbr.dhz();
            this.lbr.dhB().dew();
            this.lbr.us(false);
        }
        this.lbr.dhD();
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
                        this.lbD.resetData();
                        this.lbD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lbD.b(writeData);
                        com.baidu.tbadk.editortools.m qP = this.lbD.bvf().qP(6);
                        if (qP != null && qP.eYZ != null) {
                            qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.laM;
                        if (i == -1) {
                            this.lbD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lbr.dhB() != null && this.lbr.dhB().deA() != null) {
                            com.baidu.tbadk.editortools.pb.h deA = this.lbr.dhB().deA();
                            deA.setThreadData(this.kXs.getPbData().dcA());
                            deA.b(writeData);
                            deA.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qP2 = deA.bvf().qP(6);
                            if (qP2 != null && qP2.eYZ != null) {
                                qP2.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.laM;
                            if (i == -1) {
                                deA.bwj();
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
        this.lbD.onActivityResult(i, i2, intent);
        if (this.lbe != null) {
            this.lbe.onActivityResult(i, i2, intent);
        }
        if (deG().dhB() != null) {
            deG().dhB().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    deY();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.dhj().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.kXs != null) {
                                PbFragment.this.kXs.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.duk().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.kXs != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (intent != null) {
                        aqVar.dK("tid", intent.getStringExtra("tid"));
                        aqVar.dK("post_id", intent.getStringExtra("pid"));
                        aqVar.aj("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.duk().F(getPageContext());
                        deQ();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.iId != null && shareItem != null && shareItem.linkUrl != null) {
                            this.iId.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bsD() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60.1
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
                    this.lbr.ty(false);
                    if (this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null && this.kXs.getPbData().dcA().biC() != null) {
                        this.kXs.getPbData().dcA().biC().setStatus(2);
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
                        this.lbG = emotionImageData;
                        if (Fj(com.baidu.tbadk.core.util.am.ezd)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lbf != null) {
                        this.lbr.dh(this.lbf);
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
            if (this.lbe == null) {
                this.lbe = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.laM);
                this.lbe.b(this.fby);
                this.lbe.c(this.fbF);
            }
            this.lbe.a(emotionImageData, ddQ(), ddQ().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deY() {
        MarkData Fv;
        if (this.lbp != null) {
            if (this.kXs.getPbData() != null && this.kXs.getPbData().ddd()) {
                Fv = this.kXs.Fv(0);
            } else {
                Fv = this.kXs.Fv(this.lbr.did());
            }
            if (Fv != null) {
                if (!Fv.isApp() || (Fv = this.kXs.Fv(this.lbr.did() + 1)) != null) {
                    this.lbr.dhY();
                    this.lbp.a(Fv);
                    if (!this.lbp.bec()) {
                        this.lbp.bee();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lbp.bed();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deZ() {
        com.baidu.tieba.pb.data.f pbData = this.kXs.getPbData();
        this.kXs.tX(true);
        if (this.lbp != null) {
            pbData.OC(this.lbp.beb());
        }
        this.lbr.s(pbData);
    }

    private boolean dfa() {
        if (this.kXs == null) {
            return true;
        }
        if (this.kXs.getPbData() == null || !this.kXs.getPbData().ddd()) {
            if (this.kXs.bec()) {
                final MarkData dgi = this.kXs.dgi();
                if (dgi == null || !this.kXs.getIsFromMark()) {
                    return true;
                }
                final MarkData Fv = this.kXs.Fv(this.lbr.dic());
                if (Fv == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dgi);
                    this.laM.setResult(-1, intent);
                    return true;
                } else if (Fv.getPostId() == null || Fv.getPostId().equals(dgi.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dgi);
                    this.laM.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.AH(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lbp != null) {
                                if (PbFragment.this.lbp.bec()) {
                                    PbFragment.this.lbp.bed();
                                    PbFragment.this.lbp.hU(false);
                                }
                                PbFragment.this.lbp.a(Fv);
                                PbFragment.this.lbp.hU(true);
                                PbFragment.this.lbp.bee();
                            }
                            dgi.setPostId(Fv.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dgi);
                            PbFragment.this.laM.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.ded();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dgi);
                            PbFragment.this.laM.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.ded();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lbr != null && PbFragment.this.lbr.getView() != null) {
                                PbFragment.this.lbr.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dgi);
                                PbFragment.this.laM.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.ded();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bkJ();
                    return false;
                }
            } else if (this.kXs.getPbData() == null || this.kXs.getPbData().dcC() == null || this.kXs.getPbData().dcC().size() <= 0 || !this.kXs.getIsFromMark()) {
                return true;
            } else {
                this.laM.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.lbr == null) {
            return null;
        }
        return this.lbr.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bCb() {
        if (this.lbr == null) {
            return 0;
        }
        return this.lbr.dip();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bCc() {
        if (this.fry == null) {
            this.fry = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bCo */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bfo().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
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
        return this.fry;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bCd() {
        if (this.fuR == null) {
            this.fuR = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fuR;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bCe() {
        if (this.frz == null) {
            this.frz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnk */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bfo().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bfo().isShowImages()) {
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
                    gifView.bwJ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.frz;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bCf() {
        if (this.fuS == null) {
            this.fuS = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfy */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dc */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dd */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bTK();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: de */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fuS;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bCh() {
        this.fuU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dfz */
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
        return this.fuU;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> boI() {
        if (this.eJH == null) {
            this.eJH = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eJH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.Pd(str) && this.kXs != null && this.kXs.dfO() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").aj("obj_param1", 1).dK("post_id", this.kXs.dfO()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.eXY = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.diW().f(getPageContext(), str);
        }
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        be.diW().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.laX = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.lbr != null && this.lbr.diG() != null && rect.top <= this.lbr.diG().getHeight()) {
            rect.top += this.lbr.diG().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.kXs.getPbData();
            TbRichText bw = bw(str, i);
            if (bw != null && (tbRichTextData = bw.bBq().get(this.lcz)) != null) {
                aVar.postId = String.valueOf(bw.getPostId());
                aVar.kXA = new ArrayList<>();
                aVar.eje = new ConcurrentHashMap<>();
                if (!tbRichTextData.bBw().bBK()) {
                    aVar.kXB = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.kXA.add(c2);
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
                    imageUrlData.postId = bw.getPostId();
                    imageUrlData.mIsReserver = this.kXs.dgg();
                    imageUrlData.mIsSeeHost = this.kXs.getHostMode();
                    aVar.eje.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dcA() != null) {
                            aVar.threadId = pbData.dcA().getId();
                        }
                        aVar.ejc = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.kXB = true;
                int size = pbData.dcC().size();
                this.lcA = false;
                aVar.index = -1;
                int a2 = pbData.dcJ() != null ? a(pbData.dcJ().dEr(), bw, i, i, aVar.kXA, aVar.eje) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dcC().get(i2);
                    if (postData.getId() == null || pbData.dcJ() == null || pbData.dcJ().getId() == null || !postData.getId().equals(pbData.dcJ().getId())) {
                        a2 = a(postData.dEr(), bw, a2, i, aVar.kXA, aVar.eje);
                    }
                }
                if (aVar.kXA.size() > 0) {
                    aVar.lastId = aVar.kXA.get(aVar.kXA.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dcA() != null) {
                        aVar.threadId = pbData.dcA().getId();
                    }
                    aVar.ejc = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bBw() == null) {
            return null;
        }
        return tbRichTextData.bBw().bBP();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bBw() == null) {
            return 0L;
        }
        return tbRichTextData.bBw().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bBw() == null) {
            return false;
        }
        return tbRichTextData.bBw().bBQ();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bBw() == null) {
            return false;
        }
        return tbRichTextData.bBw().bBR();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bBw;
        String str;
        if (tbRichText == tbRichText2) {
            this.lcA = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bBq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bBq().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bBw().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bBw().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bBw().bBK()) {
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
                        String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                        if (!TextUtils.isEmpty(c2)) {
                            arrayList.add(c2);
                            if (tbRichTextData != null && (bBw = tbRichTextData.bBw()) != null) {
                                String bBM = bBw.bBM();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bBw.bBN();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bBM;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.kXs.dfO(), -1L);
                                imageUrlData.mIsReserver = this.kXs.dgg();
                                imageUrlData.mIsSeeHost = this.kXs.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lcA) {
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
        PostData dcJ;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kXs.bip())) {
                z = true;
            }
            MarkData o = this.kXs.o(postData);
            if (this.kXs.getPbData() != null && this.kXs.getPbData().ddd() && (dcJ = dcJ()) != null) {
                o = this.kXs.o(dcJ);
            }
            if (o != null) {
                this.lbr.dhY();
                if (this.lbp != null) {
                    this.lbp.a(o);
                    if (!z) {
                        this.lbp.bee();
                    } else {
                        this.lbp.bed();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(postData, false);
        }
    }

    public boolean db(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bw(String str, int i) {
        TbRichText tbRichText = null;
        if (this.kXs == null || this.kXs.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.kXs.getPbData();
        if (pbData.dcJ() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dcJ());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dcC = pbData.dcC();
            c(pbData, dcC);
            return c(dcC, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eCW == null) {
                this.eCW = new com.baidu.tbadk.core.message.a();
            }
            if (this.eCG == null) {
                this.eCG = new com.baidu.tieba.tbadkCore.data.e();
                this.eCG.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ela = 5;
            cVar.elg = 8;
            cVar.elf = 2;
            if (ddQ() != null) {
                cVar.ele = ddQ().dgy();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.elh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.elh = 1;
                        i = 0;
                    }
                }
                this.eCW.a(agreeData, i, getUniqueId(), false);
                this.eCW.a(agreeData, this.eCG);
                if (this.kXs == null && this.kXs.getPbData() != null) {
                    this.eCW.a(dfv(), cVar, agreeData, this.kXs.getPbData().dcA());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.elh = 1;
            }
            i = 0;
            this.eCW.a(agreeData, i, getUniqueId(), false);
            this.eCW.a(agreeData, this.eCG);
            if (this.kXs == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dcO() != null && fVar.dcO().kWd != null && (list = fVar.dcO().kWd) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bBq;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dEr = arrayList.get(i2).dEr();
            if (dEr != null && (bBq = dEr.bBq()) != null) {
                int size = bBq.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bBq.get(i4) != null && bBq.get(i4).getType() == 8) {
                        i3++;
                        if (bBq.get(i4).bBw().bBM().equals(str) || bBq.get(i4).bBw().bBN().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bBq.get(i4).bBw().getWidth() * equipmentDensity;
                            int height = bBq.get(i4).bBw().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lcz = i4;
                            return dEr;
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
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kXo = str;
            if (this.laS == null) {
                deK();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.laS.getItemView(1).setVisibility(8);
            } else {
                this.laS.getItemView(1).setVisibility(0);
            }
            this.laS.bkL();
            this.laX = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ioV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfb() {
        hideNetRefreshView(this.lbr.getView());
        dfc();
        if (this.kXs.dgb()) {
            this.lbr.dhY();
        }
        this.lbr.dij();
    }

    private void dfc() {
        showLoadingView(this.lbr.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lbr.diG().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctc() {
        if (this.ioV != null) {
            this.ioV.stopPlay();
        }
        if (this.laM != null) {
            this.laM.ctc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fl(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, deP(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bCg() {
        if (this.fuT == null) {
            this.fuT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfA */
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
        return this.fuT;
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

    public void ctd() {
        if (this.laM != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.laM.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.laM.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData crF() {
        if (this.kXs == null || this.kXs.getPbData() == null) {
            return null;
        }
        return this.kXs.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.ljL)).intValue();
            if (intValue == az.ljM) {
                if (!this.hGw.dFa()) {
                    this.lbr.dhV();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hGw.Sd(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hGw.a(this.kXs.getPbData().getForum().getId(), this.kXs.getPbData().getForum().getName(), this.kXs.getPbData().dcA().getId(), str, intValue3, intValue2, booleanValue, this.kXs.getPbData().dcA().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.ljN || intValue == az.ljP) {
                if (this.kXs.dgr() != null) {
                    this.kXs.dgr().Ff(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.ljN) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lbL);
        userMuteAddAndDelCustomMessage.setTag(this.lbL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean ON(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0792a
    public void tM(boolean z) {
        this.lbx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dfd() {
        ArrayList<PostData> dcC;
        int count;
        if (this.kXs == null || this.kXs.getPbData() == null || this.kXs.getPbData().dcC() == null || (count = com.baidu.tbadk.core.util.y.getCount((dcC = this.kXs.getPbData().dcC()))) == 0) {
            return "";
        }
        if (this.kXs.dgg()) {
            Iterator<PostData> it = dcC.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dEp() == 1) {
                    return next.getId();
                }
            }
        }
        int dic = this.lbr.dic();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, dic);
        if (postData == null || postData.bih() == null) {
            return "";
        }
        if (this.kXs.OR(postData.bih().getUserId())) {
            return postData.getId();
        }
        for (int i = dic - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, i);
            if (postData2 == null || postData2.bih() == null || postData2.bih().getUserId() == null) {
                break;
            } else if (this.kXs.OR(postData2.bih().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dic + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dcC, i2);
            if (postData3 == null || postData3.bih() == null || postData3.bih().getUserId() == null) {
                return "";
            }
            if (this.kXs.OR(postData3.bih().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
        this.laX = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a OO(String str) {
        String str2;
        if (this.kXs.getPbData() == null || this.kXs.getPbData().dcC() == null || this.kXs.getPbData().dcC().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.kXs.getPbData().dcC().size()) {
                i = 0;
                break;
            } else if (str.equals(this.kXs.getPbData().dcC().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.kXs.getPbData().dcC().get(i);
        if (postData.dEr() == null || postData.dEr().bBq() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dEr().bBq().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bBw() != null) {
                    str2 = next.bBw().bBM();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dfe() {
        return (!this.laN && this.lcE == -1 && this.lcF == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.lcH = rVar;
            this.laN = true;
            this.lbr.dhM();
            this.lbr.Pb(this.lcG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dff() {
        if (this.lcH != null) {
            if (this.lcE == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lcH.getCartoonId(), this.lcE, 0)));
                this.laM.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfg() {
        if (this.lcH != null) {
            if (this.lcF == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lcH.getCartoonId(), this.lcF, 0)));
                this.laM.finish();
            }
        }
    }

    public int dfh() {
        return this.lcE;
    }

    public int dfi() {
        return this.lcF;
    }

    private void cGT() {
        if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null && this.kXs.getPbData().dcA().bgN()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dfj() {
        if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null && this.kXs.getPbData().dcA().bgN()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dfk() {
        if (this.bwE) {
            this.lbd = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null && this.kXs.getPbData().dcA().bhN() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kXs.getPbData().dcA().bhN().getThreadId(), this.kXs.getPbData().dcA().bhN().getTaskId(), this.kXs.getPbData().dcA().bhN().getForumId(), this.kXs.getPbData().dcA().bhN().getForumName(), this.kXs.getPbData().dcA().bic(), this.kXs.getPbData().dcA().bid())));
            this.laP = true;
            this.laM.finish();
        }
    }

    public String dfl() {
        return this.lbb;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dfm() {
        return this.lbn;
    }

    public void tN(boolean z) {
        this.lbc = z;
    }

    public boolean bfP() {
        if (this.kXs != null) {
            return this.kXs.dfR();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AH(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lbJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lbJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lbJ).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lbJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lbJ.getPageActivity());
            aVar.AH(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lbJ).bkJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lbr.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lbJ.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.AH(this.lbJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AH(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lbr.showLoadingDialog();
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
        aVar.b(this.lbJ).bkJ();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.Pd(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.iSP) {
            this.iSP = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lbr != null) {
                this.lbr.onConfigurationChanged(configuration);
            }
            if (this.lbv != null) {
                this.lbv.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dfo() {
        if (this.kXs != null) {
            return this.kXs.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.kXs.getPbData().dcO().kWd;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dEm().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dEm().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dEm().remove(i2);
                    list.get(i).dEo();
                    z = true;
                    break;
                }
            }
            list.get(i).Sb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.kXs.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.ddq().getId();
        List<PostData> list = this.kXs.getPbData().dcO().kWd;
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
                ArrayList<PostData> ddy = pVar.ddy();
                postData.IX(pVar.getTotalCount());
                if (postData.dEm() != null) {
                    postData.dEm().clear();
                    postData.dEm().addAll(ddy);
                }
            }
        }
        if (!this.kXs.getIsFromMark()) {
            this.lbr.s(this.kXs.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a ddF() {
        return this.laM.ddF();
    }

    public boolean ddG() {
        if (this.kXs == null) {
            return false;
        }
        return this.kXs.ddG();
    }

    public void tO(boolean z) {
        this.lba = z;
    }

    public boolean dfp() {
        return this.lba;
    }

    public void dfq() {
        if (this.lbr != null) {
            this.lbr.dhz();
            ctd();
        }
    }

    public PostData dcJ() {
        return this.lbr.b(this.kXs.kYp, this.kXs.dfQ());
    }

    public void onBackPressed() {
        if (this.lbS != null && !this.lbS.isEmpty()) {
            int size = this.lbS.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lbS.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lbS == null) {
                this.lbS = new ArrayList();
            }
            if (!this.lbS.contains(aVar)) {
                this.lbS.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lbS == null) {
                this.lbS = new ArrayList();
            }
            if (!this.lbS.contains(aVar)) {
                this.lbS.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lbS != null) {
            this.lbS.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfr() {
        if (this.kXs != null && !com.baidu.tbadk.core.util.at.isEmpty(this.kXs.dfO())) {
            com.baidu.tbadk.BdToken.c.bbM().q(com.baidu.tbadk.BdToken.b.ebN, com.baidu.adp.lib.f.b.toLong(this.kXs.dfO(), 0L));
        }
    }

    public bf dfs() {
        return this.lbk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OP(String str) {
        if (this.kXs != null && this.kXs.getPbData() != null && this.kXs.getPbData().dcA() != null && this.kXs.getPbData().dcA().bgR()) {
            bw dcA = this.kXs.getPbData().dcA();
            int i = 0;
            if (dcA.bgP()) {
                i = 1;
            } else if (dcA.bgQ()) {
                i = 2;
            } else if (dcA.bkc()) {
                i = 3;
            } else if (dcA.bkd()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.aj("obj_source", 4);
            aqVar.aj("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(final int i) {
        com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bfj */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.deP(), i2, PbFragment.this.kXs);
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.86
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.ae(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(PbFragment.this.getContext(), i, shareItem, false));
            }
        });
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13833");
        aqVar.aj("obj_locate", 1);
        if (i == 3) {
            aqVar.aj("obj_type", 1);
        } else if (i == 8) {
            aqVar.aj("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dft() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dfu() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dfv() {
        return this.laM;
    }
}
