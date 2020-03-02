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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
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
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.share.AddExperiencedModel;
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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0584a {
    private com.baidu.adp.lib.d.b<ImageView> dMn;
    private com.baidu.adp.lib.d.b<GifView> dMo;
    private com.baidu.adp.lib.d.b<TextView> dPb;
    private com.baidu.adp.lib.d.b<View> dPc;
    private com.baidu.adp.lib.d.b<LinearLayout> dPd;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPe;
    private LikeModel djU;
    private com.baidu.adp.lib.d.b<TbImageView> djc;
    private ar gQB;
    private VoiceManager gol;
    private com.baidu.tieba.frs.profession.permission.c grM;
    private com.baidu.tieba.f.b gso;
    public com.baidu.tbadk.core.util.aj hPy;
    private String iEe;
    private com.baidu.tieba.pb.pb.report.a iHA;
    public ap iHH;
    private com.baidu.tbadk.core.dialog.i iHI;
    private com.baidu.tbadk.core.dialog.k iHJ;
    private boolean iHK;
    private com.baidu.tieba.tbadkCore.data.f iHO;
    private com.baidu.tbadk.editortools.pb.g iHP;
    private com.baidu.tbadk.editortools.pb.e iHQ;
    private com.baidu.tieba.frs.profession.permission.c iHS;
    private EmotionImageData iHT;
    private com.baidu.adp.base.e iHW;
    private com.baidu.tbadk.core.view.d iHX;
    private BdUniqueId iHY;
    private Runnable iHZ;
    private PbActivity iHb;
    private com.baidu.tieba.pb.pb.main.b.b iHd;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iHs;
    private View iHt;
    int iHv;
    private ax iHy;
    private boolean iIG;
    private String iIP;
    private com.baidu.tbadk.core.data.p iIQ;
    private com.baidu.adp.widget.ImageView.a iIa;
    private String iIb;
    private TbRichTextMemeInfo iIc;
    private List<a> iIf;
    public String iIh;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a iIM = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bk(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clp();
            } else {
                com.baidu.tieba.pb.a.b.clo();
            }
        }
    };
    private boolean iHc = false;
    private boolean iHe = false;
    private boolean isPaused = false;
    private boolean ihT = false;
    private boolean iHf = true;
    private int iHg = 0;
    private com.baidu.tbadk.core.dialog.b iHh = null;
    private long fVg = -1;
    private long dDE = 0;
    private long iHi = 0;
    private long createTime = 0;
    private long dDw = 0;
    private boolean iHj = false;
    private com.baidu.tbadk.n.b iHk = null;
    private long iHl = 0;
    private boolean iHm = false;
    private long iHn = 0;
    private int gOe = 1;
    private String dyq = null;
    private boolean iHo = false;
    private boolean isFullScreen = false;
    private String iHp = "";
    private boolean iHq = true;
    private boolean iHr = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iHu = new int[2];
    private int iHw = -1;
    private int iHx = -1;
    private PbInterviewStatusView.a iHz = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iHD.qk(!PbFragment.this.iHq);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iEi != null && PbFragment.this.iEi.ayL()) {
                        PbFragment.this.cmN();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iEi = null;
    private com.baidu.tbadk.baseEditMark.a iHB = null;
    private ForumManageModel fKy = null;
    private com.baidu.tbadk.coreExtra.model.a dab = null;
    private com.baidu.tieba.pb.data.m iHC = null;
    private ShareSuccessReplyToServerModel gEu = null;
    private an iHD = null;
    private boolean iHE = false;
    private boolean iHF = false;
    private boolean iHG = false;
    private boolean edM = false;
    private boolean iHL = false;
    private boolean iHM = false;
    private boolean iHN = false;
    private boolean iHR = false;
    public boolean iHU = false;
    private com.baidu.tbadk.editortools.pb.c dyt = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOR() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOQ() {
            if (PbFragment.this.iHH == null || PbFragment.this.iHH.cqx() == null || !PbFragment.this.iHH.cqx().cUe()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZW);
            }
            PbFragment.this.showToast(PbFragment.this.iHH.cqx().cUg());
            if (PbFragment.this.iHQ != null && (PbFragment.this.iHQ.aPg() || PbFragment.this.iHQ.aPh())) {
                PbFragment.this.iHQ.a(false, PbFragment.this.iHH.cqA());
            }
            PbFragment.this.iHH.qw(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iHV = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOQ() {
            if (PbFragment.this.iHH == null || PbFragment.this.iHH.cqy() == null || !PbFragment.this.iHH.cqy().cUe()) {
                return !PbFragment.this.yN(com.baidu.tbadk.core.util.aj.cZX);
            }
            PbFragment.this.showToast(PbFragment.this.iHH.cqy().cUg());
            if (PbFragment.this.iHD != null && PbFragment.this.iHD.cpi() != null && PbFragment.this.iHD.cpi().cmn() != null && PbFragment.this.iHD.cpi().cmn().aPh()) {
                PbFragment.this.iHD.cpi().cmn().a(PbFragment.this.iHH.cqA());
            }
            PbFragment.this.iHH.qx(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean goY = false;
    private int iId = 0;
    private int iIe = -1;
    public int iIg = 0;
    private final a iIi = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iHD != null && PbFragment.this.iHD.cpi() != null) {
                s cpi = PbFragment.this.iHD.cpi();
                if (cpi.cml()) {
                    cpi.cmk();
                    return true;
                }
            }
            if (PbFragment.this.iHD != null && PbFragment.this.iHD.cqg()) {
                PbFragment.this.iHD.cqh();
                return true;
            }
            return false;
        }
    };
    private final x.a iIj = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iHD.showToast(str);
            }
        }
    };
    private final CustomMessageListener iIk = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iEi != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iHQ != null) {
                    PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                }
                PbFragment.this.iHD.cpk();
                PbFragment.this.iHD.cpY();
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iEi.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iHD != null && PbFragment.this.iEi != null) {
                    PbFragment.this.iHD.b(PbFragment.this.iEi.getPbData(), PbFragment.this.iEi.cnz(), PbFragment.this.iEi.cnW(), PbFragment.this.iHD.getSkinType());
                }
                if (PbFragment.this.iHD != null && PbFragment.this.iHD.cpB() != null) {
                    PbFragment.this.iHD.cpB().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iIl = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iHD != null) {
                    if (booleanValue) {
                        PbFragment.this.iHD.bWs();
                    } else {
                        PbFragment.this.iHD.bWr();
                    }
                }
            }
        }
    };
    private CustomMessageListener iIm = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iHQ != null) {
                    PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                }
                PbFragment.this.iHD.qr(false);
            }
        }
    };
    private CustomMessageListener iIn = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
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
    private CustomMessageListener iIo = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHD != null && PbFragment.this.iHD.cpB() != null) {
                PbFragment.this.iHD.cpB().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hty = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gpx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.cne();
            }
        }
    };
    private View.OnClickListener dzb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dyq);
        }
    };
    private CustomMessageListener iIp = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEi.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iEi.cnN() != null && PbFragment.this.iEi.cnN().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iHD.a(abVar.sendCount, PbFragment.this.iEi.getPbData(), PbFragment.this.iEi.cnz(), PbFragment.this.iEi.cnW());
                    }
                    if (pbData.ckw() != null && pbData.ckw().size() >= 1 && pbData.ckw().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.ckw().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEi.cny(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cLi = pbData.ckw().get(0).cLi();
                            if (cLi == null) {
                                cLi = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aBm = cLi.aBm();
                            if (aBm == null) {
                                aBm = new ArrayList<>();
                            }
                            aBm.add(0, aVar);
                            cLi.setTotal(abVar.sendCount + cLi.getTotal());
                            cLi.w(aBm);
                            pbData.ckw().get(0).a(cLi);
                            PbFragment.this.iHD.cpB().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gFB = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                PbFragment.this.FN((String) customResponsedMessage.getData());
                PbFragment.this.iEi.cnS();
                if (PbFragment.this.iHD.cpB() != null) {
                    PbFragment.this.iHD.o(PbFragment.this.iEi.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iIq = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.cqP()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iIr = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iHD != null) {
                PbFragment.this.iHD.dH(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iIs = false;
    private PraiseModel iIt = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void xq(String str) {
            PbFragment.this.iIs = false;
            if (PbFragment.this.iIt != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEi.getPbData();
                if (pbData.cku().aBZ().getIsLike() == 1) {
                    PbFragment.this.tI(0);
                } else {
                    PbFragment.this.tI(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.cku()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iIs = false;
            if (PbFragment.this.iIt != null && str != null) {
                if (AntiHelper.bb(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iIu = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pQ(boolean z) {
            PbFragment.this.pP(z);
            if (PbFragment.this.iHD.cqm() != null && z) {
                PbFragment.this.iHD.qk(false);
            }
            PbFragment.this.iHD.qm(z);
        }
    };
    private CustomMessageListener daf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().dnU != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().dnU, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.ckB().aCo() != null && PbFragment.this.ckB().aCo().getGodUserData() != null) {
                            PbFragment.this.ckB().aCo().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null) {
                            PbFragment.this.iEi.getPbData().cku().aCo().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h gnt = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iHb.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iIv = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iHD.bqr();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.yP(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.bME();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c dqK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cmw();
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
                        if (PbFragment.this.ct(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.c((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.iHD.cmu() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cy("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.clq() != null && PbFragment.this.clq().gQW != null) {
                                PbFragment.this.clq().gQW.onClick(view);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view.getTag();
                        }
                        if (sparseArray != null) {
                            PbFragment.this.c(sparseArray);
                        } else {
                            return false;
                        }
                    }
                }
                if (PbFragment.this.iHQ != null) {
                    PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                }
                PbFragment.this.iHD.cpk();
                PbFragment.this.iHD.cpY();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHY) {
                PbFragment.this.iHD.bqr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEi.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.ckH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iHX.showSuccessToast(PbFragment.this.iHW.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iHW.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cnb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iHW.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iHX.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHY) {
                PbFragment.this.iHD.bqr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iHX.showSuccessToast(PbFragment.this.iHW.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iHW.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iHX.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iHY) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iHD.bqr();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.kuG;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
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
                    PbFragment.this.iHD.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iIz = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iHD.cpl() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cmw();
            }
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.goY = true;
                }
            }
        }
    };
    public a.b isU = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bEl();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iEi.getPageData();
            int pageNum = PbFragment.this.iHD.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aBf()) {
                PbFragment.this.iHD.cpY();
                PbFragment.this.bEk();
                PbFragment.this.iHD.cpF();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iEi.yR(PbFragment.this.iHD.getPageNum());
                    if (PbFragment.this.iHd != null) {
                        PbFragment.this.iHd.showFloatingView();
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
    public final View.OnClickListener gqq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        /* JADX WARN: Removed duplicated region for block: B:632:0x1c89  */
        /* JADX WARN: Removed duplicated region for block: B:635:0x1cd0  */
        /* JADX WARN: Removed duplicated region for block: B:652:0x1ede  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            com.baidu.tieba.pb.data.e pbData;
            boolean z;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            int i;
            int i2;
            bo boVar;
            String[] strArr;
            boolean v;
            String name;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.iHD.cpU()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iEi.pV(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iHD.cpG();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coL()) {
                        if (view == PbFragment.this.iHD.iNK.dFK) {
                            if (PbFragment.this.iHD.qo(PbFragment.this.iEi.cnE())) {
                                PbFragment.this.bEk();
                                return;
                            }
                            PbFragment.this.iHf = false;
                            PbFragment.this.iHe = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iHb, PbFragment.this.iHD.iNK.dFK);
                            PbFragment.this.iHb.finish();
                        } else if (view != PbFragment.this.iHD.cpD() && (PbFragment.this.iHD.iNK.crc() == null || (view != PbFragment.this.iHD.iNK.crc().coK() && view != PbFragment.this.iHD.iNK.crc().coI()))) {
                            if (view == PbFragment.this.iHD.cqc()) {
                                if (PbFragment.this.iEi != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEi.getPbData().cku().aCn().getLink());
                                }
                            } else if (view != PbFragment.this.iHD.iNK.iTN) {
                                if (view == PbFragment.this.iHD.iNK.iTO) {
                                    if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                        ArrayList<PostData> ckw = PbFragment.this.iEi.getPbData().ckw();
                                        if ((ckw == null || ckw.size() <= 0) && PbFragment.this.iEi.cnz()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cy("tid", PbFragment.this.iEi.cny()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fid", PbFragment.this.iEi.getForumId()));
                                        if (!PbFragment.this.iHD.cqr()) {
                                            PbFragment.this.iHD.cpk();
                                        }
                                        PbFragment.this.cmF();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iHD.pF(true);
                                        PbFragment.this.iHD.cpk();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iHD.bWs();
                                            PbFragment.this.bEk();
                                            PbFragment.this.iHD.cpF();
                                            PbFragment.this.iEi.FU(PbFragment.this.cmR());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coH()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iHD.iNK.crc() != null && view == PbFragment.this.iHD.iNK.crc().coG()) {
                                            PbFragment.this.iHD.iNK.arU();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coE()) {
                                                if ((PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coN()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coF()) {
                                                        if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coO()) {
                                                            if (PbFragment.this.iHD.cqm() == view) {
                                                                if (PbFragment.this.iHD.cqm().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.iEi.getPbData();
                                                                    if (pbData2 != null && pbData2.cku() != null && pbData2.cku().aBU() != null) {
                                                                        String aBL = pbData2.cku().aBU().aBL();
                                                                        if (StringUtils.isNull(aBL)) {
                                                                            aBL = pbData2.cku().aBU().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cy("obj_id", aBL));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eD("c10725", null);
                                                                }
                                                                PbFragment.this.cmY();
                                                            } else if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coM()) {
                                                                if (PbFragment.this.iHD.iNK.crc() != null && view == PbFragment.this.iHD.iNK.crc().coJ()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iHD.b(PbFragment.this.iEi.getPbData(), PbFragment.this.iEi.cnz(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iHD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iHD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iHD.iNK.arU();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cy("tid", PbFragment.this.iEi.cny());
                                                                        anVar.cy("fid", PbFragment.this.iEi.getForumId());
                                                                        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.X("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                            PbFragment.this.iHD.cpY();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cLm() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.khr != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy = postData.khr.aGy();
                                                                                    aGy.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aGy.X("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aGy.X("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aGy);
                                                                                }
                                                                                String cny = PbFragment.this.iEi.cny();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.iEi.getPbData() != null) {
                                                                                    i3 = PbFragment.this.iEi.getPbData().ckG();
                                                                                }
                                                                                PbFragment.this.bEk();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a FS = PbFragment.this.FS(id);
                                                                                    if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && FS != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cny, id, "pb", true, null, true, null, i3, postData.crZ(), PbFragment.this.iEi.getPbData().getAnti(), false, postData.aCo().getIconInfo()).addBigImageData(FS.iEn, FS.iEo, FS.iEp, FS.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iEi.coh());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iEi.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iEi.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iEi.cnG());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a FS2 = PbFragment.this.FS(id);
                                                                                    if (postData != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && FS2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cny, id, "pb", true, null, false, null, i3, postData.crZ(), PbFragment.this.iEi.getPbData().getAnti(), false, postData.aCo().getIconInfo()).addBigImageData(FS2.iEn, FS2.iEo, FS2.iEp, FS2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iEi.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iEi.cnG());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iEi.coh());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iEi.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 3).cy("fid", PbFragment.this.iEi.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iEi != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cy("tid", PbFragment.this.iEi.cny());
                                                                        anVar2.cy("fid", PbFragment.this.iEi.getForumId());
                                                                        anVar2.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.X("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.khr != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy2 = postData2.khr.aGy();
                                                                                    aGy2.delete("obj_locate");
                                                                                    aGy2.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGy2);
                                                                                }
                                                                                if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                                    String cny2 = PbFragment.this.iEi.cny();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.iEi.getPbData() != null) {
                                                                                        i4 = PbFragment.this.iEi.getPbData().ckG();
                                                                                    }
                                                                                    PbActivity.a FS3 = PbFragment.this.FS(id2);
                                                                                    if (FS3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cny2, id2, "pb", true, null, false, null, i4, postData2.crZ(), PbFragment.this.iEi.getPbData().getAnti(), false, postData2.aCo().getIconInfo()).addBigImageData(FS3.iEn, FS3.iEo, FS3.iEp, FS3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iEi.coh());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iEi.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iEi.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iEi.cnG());
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
                                                                } else if (view.getId() == R.id.pb_post_reply) {
                                                                    if (PbFragment.this.iEi != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cy("tid", PbFragment.this.iEi.cny());
                                                                        anVar3.cy("fid", PbFragment.this.iEi.getForumId());
                                                                        anVar3.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.X("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.khr != null) {
                                                                                    com.baidu.tbadk.core.util.an aGy3 = postData3.khr.aGy();
                                                                                    aGy3.delete("obj_locate");
                                                                                    aGy3.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGy3);
                                                                                }
                                                                                if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.cmt().cph() != null && postData3.aCo() != null && postData3.cLa() != 1) {
                                                                                    if (PbFragment.this.cmt().cpi() != null) {
                                                                                        PbFragment.this.cmt().cpi().cmj();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.iEi.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.iEi.getPbData().cku());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cmt().cph().d(lVar);
                                                                                    PbFragment.this.cmt().cph().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aCo().getUserId(), "");
                                                                                    if (PbFragment.this.iHQ != null) {
                                                                                        PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
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
                                                                } else if (view != PbFragment.this.iHD.clL()) {
                                                                    if (view == PbFragment.this.iHD.iNK.crd()) {
                                                                        PbFragment.this.iHD.cpM();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aEu())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{boVar.aEu()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cy("tid", PbFragment.this.iEi.iJW));
                                                                                    }
                                                                                    if (PbFragment.this.iHJ == null) {
                                                                                        PbFragment.this.iHJ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iHJ.a(PbFragment.this.iIL);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cv(view);
                                                                                    if (!PbFragment.this.cv(view) || PbFragment.this.iIa == null || !PbFragment.this.iIa.isGif()) {
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
                                                                                        if (postData4.cLc() != null && postData4.cLc().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHJ);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hhz = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iEi.getPbData().ayL()) {
                                                                                        String ayK = PbFragment.this.iEi.getPbData().ayK();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ayK) && ayK.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHJ);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHJ);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hhz);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHJ);
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
                                                                                                    if (PbFragment.this.pL(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHJ);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHJ);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHJ);
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
                                                                                                    if (PbFragment.this.iEi.getPbData().ckG() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHJ);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHJ);
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
                                                                                            PbFragment.this.iHJ.az(arrayList);
                                                                                            PbFragment.this.iHI = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHJ);
                                                                                            PbFragment.this.iHI.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hhz);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iHJ.az(arrayList);
                                                                                    PbFragment.this.iHI = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHJ);
                                                                                    PbFragment.this.iHI.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iEi.getPbData().cku().getActUrl());
                                                                                if (PbFragment.this.iEi.getPbData().cku().aCY() != 1) {
                                                                                    if (PbFragment.this.iEi.getPbData().cku().aCY() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cy("fid", PbFragment.this.iEi.getPbData().getForumId()).cy("tid", PbFragment.this.iEi.getPbData().getThreadId()).cy("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iEi.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.iHD.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aFD().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iHD.cpk();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cmC() == 1 && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cy("fid", PbFragment.this.iEi.getPbData().getForumId()).cy("tid", PbFragment.this.iEi.getPbData().getThreadId()).cy("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cmC() == 1 && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cy("fid", PbFragment.this.iEi.getPbData().getForumId()).cy("tid", PbFragment.this.iEi.getPbData().getThreadId()).cy("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cmT();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cmU();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().ckM() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.iEi.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cy("fid", pbData3.getForumId()));
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{pbData3.ckM().ckW()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().ckM() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.iEi.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", pbData4.getForumId()));
                                                                                ba.aGG().b(PbFragment.this.getPageContext(), new String[]{pbData4.ckM().ckW()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iId >= 0) {
                                                                                if (PbFragment.this.iEi != null) {
                                                                                    PbFragment.this.iEi.coi();
                                                                                }
                                                                                if (PbFragment.this.iEi != null && PbFragment.this.iHD.cpB() != null) {
                                                                                    PbFragment.this.iHD.cpB().a(PbFragment.this.iEi.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iId = 0;
                                                                                if (PbFragment.this.iEi != null) {
                                                                                    PbFragment.this.iHD.getListView().setSelection(PbFragment.this.iEi.col());
                                                                                    PbFragment.this.iEi.cr(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cmz();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbFragment.this.c(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbFragment.this.iHD.getListView() != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iHD.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iHD.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aHK = PbFragment.this.iEi.getPbData().aHK();
                                                                                boolean z7 = PbFragment.this.iHD.cpj() != null && PbFragment.this.iHD.cpj().bim();
                                                                                boolean cpV = PbFragment.this.iHD.cpV();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aHK && PbFragment.this.iHD.cpj() != null && PbFragment.this.iHD.cpj().bcK() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iHD.cpj().cqM();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.iHD.cpj().bcK().getHeight() - PbFragment.this.iHD.cpj().cqM());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.FT("c13568");
                                                                                if ((PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCf() <= 0) || (cpV && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cmz();
                                                                                        if (PbFragment.this.iEi.getPbData().cku().aCo() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEi.iJW).cy("fid", PbFragment.this.iEi.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aHK) {
                                                                                        if (PbFragment.this.iHD.iOR != null && PbFragment.this.iHD.iOR.iPV != null && PbFragment.this.iHD.iOR.iPV.getView() != null) {
                                                                                            if (PbFragment.this.iHD.iOR.iPV.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cmJ();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.iHD.cpj() != null && PbFragment.this.iHD.cpj().bcK() != null) {
                                                                                                    i6 = PbFragment.this.iHD.cpj().bcK().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.iHD.iOR.iPV.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iHD.cps() != null) {
                                                                                        z9 = PbFragment.this.iHD.cps().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.iHD.iOR != null && PbFragment.this.iHD.iOR.iPV != null && PbFragment.this.iHD.iOR.iPV.getView() != null && PbFragment.this.iHD.iOR.iPV.getView().getParent() != null && PbFragment.this.iHD.iNK != null && PbFragment.this.iHD.iNK.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.iHD.iOR.iPV.getView().getTop() - PbFragment.this.iHD.iNK.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cpV) {
                                                                                        PbFragment.this.iHw = firstVisiblePosition;
                                                                                        PbFragment.this.iHx = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.iHD.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.iHD.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iHD.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iHw > 0) {
                                                                                        if (PbFragment.this.iHD.getListView().getChildAt(PbFragment.this.iHw) != null) {
                                                                                            PbFragment.this.iHD.getListView().smoothScrollToPosition(PbFragment.this.iHw, PbFragment.this.iHx, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHD.getListView().setSelectionFromTop(PbFragment.this.iHw, PbFragment.this.iHx + equipmentHeight);
                                                                                            PbFragment.this.iHD.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cmJ = PbFragment.this.cmJ();
                                                                                        if (PbFragment.this.cmI() != -1) {
                                                                                            cmJ--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cmJ < 0) {
                                                                                            i = PbFragment.this.iHD.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iHD.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cmJ;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aHK || PbFragment.this.iHD.cpj() == null) {
                                                                                            if (PbFragment.this.iHD.iNK != null && PbFragment.this.iHD.iNK.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.iHD.iNK.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.iHD.cpj().cqL();
                                                                                        }
                                                                                        if (PbFragment.this.iHD.iOR == null || PbFragment.this.iHD.iOR.iPV == null || PbFragment.this.iHD.iOR.iPV.getView() == null || PbFragment.this.iHD.iOR.iPV.getView().getParent() == null) {
                                                                                            PbFragment.this.iHD.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.iHD.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.iHD.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iHD.getListView().smoothScrollBy(PbFragment.this.iHD.iOR.iPV.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEi.iJW).cy("fid", PbFragment.this.iEi.getPbData().getForumId()).X("obj_locate", 2).cy("uid", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iEi.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iEi.coh() == 3) {
                                                                                    PbFragment.this.iHb.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iEi.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cy("tid", PbFragment.this.iEi.cny());
                                                                                anVar4.cy("fid", PbFragment.this.iEi.getForumId());
                                                                                anVar4.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iEi.coh() == 3 && PbFragment.this.clr() && PbFragment.this.iEi.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iEi.getPbData().ckN())) {
                                                                                    PbFragment.this.iHb.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aCt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cy("tid", bjVar.getId());
                                                                                anVar5.s("fid", bjVar.getFid());
                                                                                anVar5.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.iEi != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cy("tid", PbFragment.this.iEi.cny());
                                                                                anVar6.cy("fid", PbFragment.this.iEi.getForumId());
                                                                                anVar6.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.X("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.iEi.getPbData();
                                                                                if (PbFragment.this.iHC == null) {
                                                                                    PbFragment.this.iHC = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aGz();
                                                                                PbFragment.this.registerListener(PbFragment.this.iIB);
                                                                                PbFragment.this.iHC.D(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cy("fid", PbFragment.this.iEi.getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cy("obj_source", "PB_card").cy("tid", PbFragment.this.iEi.cny()).X("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aCt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).X("obj_locate", 9).s("obj_id", bjVar2.getFid()).cy("tid", bjVar2.getId()).X("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.djU != null) {
                                                                                    PbFragment.this.djU.eC(bjVar3.aCt(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cy("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).X("obj_locate", 11).s("obj_id", bjVar3.getFid()).cy("tid", bjVar3.getId()).X("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEi.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEi.cny(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iEi.getPbData().cku().aCI())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iHD.cpY();
                                                                SparseArray<Object> b3 = PbFragment.this.iHD.b(PbFragment.this.iEi.getPbData(), PbFragment.this.iEi.cnz(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEi.getPbData().getForum().getId(), PbFragment.this.iEi.getPbData().getForum().getName(), PbFragment.this.iEi.getPbData().cku().getId(), String.valueOf(PbFragment.this.iEi.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.v(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                                                            }
                                                            PbFragment.this.iHD.iNK.crb();
                                                        }
                                                    } else if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null) {
                                                        PbFragment.this.iHD.iNK.arU();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.FP(PbFragment.this.iEi.getPbData().cku().aCE());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iHD.cpY();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iEi.cnQ()));
                                                            return;
                                                        }
                                                        PbFragment.this.bEk();
                                                        PbFragment.this.iHD.cpF();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iEi.getPbData().iBD == null || PbFragment.this.iEi.getPbData().iBD.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iEi.getPbData().iBD.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.iEi.getPbData().iBD.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.iEi.getPbData().iBD.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iEi.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.iEi.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.iEi.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.iEi.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i10));
                                                                if (PbFragment.this.iEi.getPbData().iBD != null && PbFragment.this.iEi.getPbData().iBD.size() > i9) {
                                                                    i9 = PbFragment.this.iEi.getPbData().iBD.get(i9).sort_type.intValue();
                                                                }
                                                                boolean yW = PbFragment.this.iEi.yW(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iEi.cnQ()));
                                                                if (yW) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iHD.qf(true);
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
                                                PbFragment.this.iHD.cpY();
                                                if (PbFragment.this.clB().getPbData().iBE != 2) {
                                                    if (PbFragment.this.iEi.getPageData() != null) {
                                                        PbFragment.this.iHD.a(PbFragment.this.iEi.getPageData(), PbFragment.this.isU);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.iEi.getPbData()) != null) {
                                            bj cku = pbData.cku();
                                            if (cku != null && cku.aCo() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEi.iJW).cy("fid", pbData.getForumId()).X("obj_locate", 4).cy("uid", cku.aCo().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (cku != null) {
                                                if (cku.aBd()) {
                                                    i9 = 2;
                                                } else if (cku.aBe()) {
                                                    i9 = 3;
                                                } else if (cku.aEg()) {
                                                    i9 = 4;
                                                } else if (cku.aEh()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cy("tid", PbFragment.this.iEi.cny());
                                            anVar7.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cy("fid", PbFragment.this.iEi.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.X("obj_locate", 5);
                                            } else {
                                                anVar7.X("obj_locate", 6);
                                            }
                                            anVar7.X("obj_name", i9);
                                            anVar7.X("obj_type", 1);
                                            if (cku != null) {
                                                if (cku.aBd()) {
                                                    anVar7.X("obj_type", 10);
                                                } else if (cku.aBe()) {
                                                    anVar7.X("obj_type", 9);
                                                } else if (cku.aEh()) {
                                                    anVar7.X("obj_type", 8);
                                                } else if (cku.aEg()) {
                                                    anVar7.X("obj_type", 7);
                                                } else if (cku.isShareThread) {
                                                    anVar7.X("obj_type", 6);
                                                } else if (cku.threadType == 0) {
                                                    anVar7.X("obj_type", 1);
                                                } else if (cku.threadType == 40) {
                                                    anVar7.X("obj_type", 2);
                                                } else if (cku.threadType == 49) {
                                                    anVar7.X("obj_type", 3);
                                                } else if (cku.threadType == 54) {
                                                    anVar7.X("obj_type", 4);
                                                } else {
                                                    anVar7.X("obj_type", 5);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> ckw2 = PbFragment.this.iEi.getPbData().ckw();
                                                if ((ckw2 != null && ckw2.size() > 0) || !PbFragment.this.iEi.cnz()) {
                                                    PbFragment.this.iHD.cpY();
                                                    PbFragment.this.bEk();
                                                    if (pbData.ckM() != null && !StringUtils.isNull(pbData.ckM().aAG(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cy("fid", PbFragment.this.iEi.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), cku)) {
                                                        if (PbFragment.this.iHD != null) {
                                                            PbFragment.this.iHD.cqb();
                                                            PbFragment.this.iHD.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.iHD.showLoadingDialog();
                                                            PbFragment.this.iEi.coc().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.yP(i10);
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
                                        PbFragment.this.iHD.cpY();
                                        if (PbFragment.this.iHD.iNK.crc() != null && view == PbFragment.this.iHD.iNK.crc().coH() && !PbFragment.this.iHD.cqr()) {
                                            PbFragment.this.iHD.cpk();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bEk();
                                            PbFragment.this.iHD.cpF();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                v = PbFragment.this.iEi.v(true, PbFragment.this.cmR());
                                            } else {
                                                v = view.getId() == R.id.reply_title ? PbFragment.this.iEi.v(false, PbFragment.this.cmR()) : PbFragment.this.iEi.FU(PbFragment.this.cmR());
                                            }
                                            view.setTag(Boolean.valueOf(v));
                                            if (v) {
                                                PbFragment.this.iHD.pF(true);
                                                PbFragment.this.iHD.bWs();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iHD.qf(true);
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
                                    PbFragment.this.iHD.cpY();
                                    if (PbFragment.this.yO(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iEi.yX(PbFragment.this.iHD.cpK()) != null) {
                                        PbFragment.this.cmM();
                                        if (PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", PbFragment.this.iEi.iJW).cy("fid", PbFragment.this.iEi.getPbData().getForumId()).X("obj_locate", 3).cy("uid", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()));
                                        }
                                        if (PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null && PbFragment.this.iEi.getPbData().cku().aCo().getUserId() != null && PbFragment.this.iHB != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iEi.getPbData());
                                            bj cku2 = PbFragment.this.iEi.getPbData().cku();
                                            int i11 = 1;
                                            if (cku2.aBd()) {
                                                i11 = 2;
                                            } else if (cku2.aBe()) {
                                                i11 = 3;
                                            } else if (cku2.aEg()) {
                                                i11 = 4;
                                            } else if (cku2.aEh()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEi.iJW).X("obj_locate", 1).cy("obj_id", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()).X("obj_type", PbFragment.this.iHB.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i11));
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
                                if (PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aBb() && PbFragment.this.iEi.getPbData().cku().aCF() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iEi.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iEi.cls()) || PbFragment.this.iEi.getAppealInfo() == null) {
                                        PbFragment.this.iHb.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iEi.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iEi.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iHb.finish();
                                    return;
                                }
                                String cls = PbFragment.this.iEi.cls();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iEi.cnA() && cls != null && cls.equals(name)) {
                                    PbFragment.this.iHb.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iEi.getPbData() != null) {
                                if ((PbFragment.this.iEi.getPbData().ckG() == 1 || PbFragment.this.iEi.getPbData().ckG() == 3) && !PbFragment.this.fKy.cLO()) {
                                    PbFragment.this.iHD.cpY();
                                    int i12 = 0;
                                    if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coI()) {
                                        if (PbFragment.this.iHD.iNK.crc() == null || view != PbFragment.this.iHD.iNK.crc().coK()) {
                                            if (view == PbFragment.this.iHD.cpD()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.iEi.getPbData().cku().aCk() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.iEi.getPbData().cku().aCj() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iEi.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iEi.getPbData().cku().getId();
                                    PbFragment.this.iHD.cpC();
                                    PbFragment.this.fKy.b(id4, name2, id5, i12, PbFragment.this.iHD.cpE());
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
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.iHD.cpY();
                        PbFragment.this.bEk();
                        PbFragment.this.iHD.cpF();
                        PbFragment.this.iHD.showLoadingDialog();
                        if (PbFragment.this.iHD.cps() != null) {
                            PbFragment.this.iHD.cps().setVisibility(8);
                        }
                        PbFragment.this.iEi.yR(1);
                        if (PbFragment.this.iHd != null) {
                            PbFragment.this.iHd.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cmA = PbFragment.this.cmA();
                        if (!TextUtils.isEmpty(cmA)) {
                            ba.aGG().b(PbFragment.this.getPageContext(), new String[]{cmA});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cy("tid", PbFragment.this.iEi.cny());
                anVar8.cy("fid", PbFragment.this.iEi.getForumId());
                anVar8.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.X("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iHm) {
                    PbFragment.this.iHm = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.cmt().cph() != null && postData5.aCo() != null && postData5.cLa() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cmt().cpi() != null) {
                                PbFragment.this.cmt().cpi().cmj();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.iEi.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.iEi.getPbData().cku());
                            lVar2.f(postData5);
                            PbFragment.this.cmt().cph().d(lVar2);
                            PbFragment.this.cmt().cph().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aCo().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEi.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iHQ != null) {
                                PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEi.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEi.getPbData().getForumId());
                }
                anVar.cy("tid", PbFragment.this.iEi.cny());
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bEk();
            PbFragment.this.iHD.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.clB() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.clB().FX(postWriteCallBackData.getPostId());
                    PbFragment.this.iId = PbFragment.this.iHD.cpo();
                    PbFragment.this.iEi.cr(PbFragment.this.iId, PbFragment.this.iHD.cpp());
                }
                PbFragment.this.iHD.cpY();
                PbFragment.this.iHH.cqw();
                if (PbFragment.this.iHQ != null) {
                    PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                }
                PbFragment.this.iHD.cpg();
                PbFragment.this.iHD.qr(true);
                PbFragment.this.iEi.cnS();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iEi.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEi.getPbData();
                            if (pbData != null && pbData.cku() != null && pbData.cku().aCo() != null && (userId = pbData.cku().aCo().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iEi.cnJ()) {
                                PbFragment.this.iHD.cpF();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iEi.cnJ()) {
                            PbFragment.this.iHD.cpF();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iHD.o(PbFragment.this.iEi.getPbData());
                    }
                    if (PbFragment.this.iEi.cnD()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cy("tid", PbFragment.this.iEi.cny()));
                    }
                    PbFragment.this.cmD();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iHQ.aPg() || PbFragment.this.iHQ.aPh()) {
                    PbFragment.this.iHQ.a(false, postWriteCallBackData);
                }
                PbFragment.this.iHH.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hPy != null) {
                    PbFragment.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iIA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                    anVar.cy("fid", PbFragment.this.iEi.getPbData().getForumId());
                }
                if (PbFragment.this.iEi != null) {
                    anVar.cy("tid", PbFragment.this.iEi.cny());
                }
                anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iHH != null) {
                    PbFragment.this.iHH.cqv();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hPy != null) {
                    PbFragment.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iHH != null) {
                if (PbFragment.this.iHD != null && PbFragment.this.iHD.cpi() != null && PbFragment.this.iHD.cpi().cmn() != null && PbFragment.this.iHD.cpi().cmn().aPh()) {
                    PbFragment.this.iHD.cpi().cmn().a(postWriteCallBackData);
                }
                PbFragment.this.iHH.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cqu;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iHb.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iHD != null && (cqu = PbFragment.this.iHD.cqu()) != null && PbFragment.this.iHD.getListView() != null) {
                            PbFragment.this.iHD.getListView().removeHeaderView(cqu);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iIC = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mm;
            if (!z || eVar == null || eVar.ckE() != null || com.baidu.tbadk.core.util.v.getCount(eVar.ckw()) >= 1) {
                PbFragment.this.ihT = true;
                PbFragment.this.iHD.cpH();
                if (eVar == null || !eVar.ckA()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iHD.getView());
                }
                PbFragment.this.iHD.bWr();
                if (PbFragment.this.isFullScreen || PbFragment.this.iHD.cqr()) {
                    PbFragment.this.iHD.cqi();
                } else if (!PbFragment.this.iHD.cqf()) {
                    PbFragment.this.iHD.qr(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.edM = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iHD.getView());
                    PbFragment.this.iHD.cpQ();
                }
                if (z && eVar != null) {
                    bj cku = eVar.cku();
                    if (cku == null || !cku.aEi()) {
                        PbFragment.this.d(PbFragment.this.iHP);
                    } else {
                        cnk();
                    }
                    PbFragment.this.iHD.cpi().setPbData(eVar);
                    PbFragment.this.iHD.bgy();
                    if (cku != null && cku.aDv() != null) {
                        PbFragment.this.a(cku.aDv());
                    }
                    if (PbFragment.this.iHQ != null) {
                        PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.ckw() != null && eVar.ckw().size() >= 1 && eVar.ckw().get(0) != null) {
                        PbFragment.this.iEi.FW(eVar.ckw().get(0).getId());
                    } else if (eVar.ckE() != null) {
                        PbFragment.this.iEi.FW(eVar.ckE().getId());
                    }
                    if (PbFragment.this.iHQ != null) {
                        PbFragment.this.iHQ.a(eVar.getAnti());
                        PbFragment.this.iHQ.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.iHQ.setThreadData(cku);
                        PbFragment.this.iHQ.a(PbFragment.this.iEi.cnN(), PbFragment.this.iEi.cny(), PbFragment.this.iEi.coe());
                        if (cku != null) {
                            PbFragment.this.iHQ.gI(cku.aDG());
                        }
                    }
                    if (PbFragment.this.iHB != null) {
                        PbFragment.this.iHB.fm(eVar.ayL());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.ckS()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iHD.qq(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iHD.a(eVar, i2, i3, PbFragment.this.iEi.cnz(), i4, PbFragment.this.iEi.getIsFromMark());
                    PbFragment.this.iHD.d(eVar, PbFragment.this.iEi.cnz());
                    PbFragment.this.iHD.qn(PbFragment.this.iEi.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dyq = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dyq) && PbFragment.this.iHQ != null && PbFragment.this.iHQ.aOt() != null && (mm = PbFragment.this.iHQ.aOt().mm(6)) != null && !TextUtils.isEmpty(PbFragment.this.dyq)) {
                            ((View) mm).setOnClickListener(PbFragment.this.dzb);
                        }
                    }
                    if (PbFragment.this.iHL) {
                        PbFragment.this.iHL = false;
                        final int cmI = PbFragment.this.cmI();
                        if (!eVar.aHK()) {
                            PbFragment.this.iHD.ze(cmI);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cmI, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iHM) {
                        PbFragment.this.iHM = false;
                        final int cmI2 = PbFragment.this.cmI();
                        final boolean z2 = cmI2 != -1;
                        if (!z2) {
                            cmI2 = PbFragment.this.cmJ();
                        }
                        if (PbFragment.this.iHD != null) {
                            if (!eVar.aHK()) {
                                PbFragment.this.iHD.ze(cmI2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cmI2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iHD.setSelectionFromTop(cmI2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iHD.setSelectionFromTop(cmI2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iHD.qs(true);
                                PbFragment.this.iHD.qr(false);
                            }
                        }
                    } else if (PbFragment.this.iHN) {
                        PbFragment.this.iHN = false;
                        PbFragment.this.iHD.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iHD.cpL();
                    }
                    PbFragment.this.iEi.a(eVar.getForum(), PbFragment.this.iIq);
                    PbFragment.this.iEi.a(PbFragment.this.iIr);
                    if (PbFragment.this.hPy != null && cku != null && cku.aCo() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(cku.aCo());
                        PbFragment.this.hPy.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.edM && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iEi.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iEi.getAppealInfo().iBw)) {
                                    PbFragment.this.iHD.a(PbFragment.this.iEi.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iHD.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iHD.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iHD.cqi();
                            PbFragment.this.iHD.cpP();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iEi.cny());
                            jSONObject.put("fid", PbFragment.this.iEi.getForumId());
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
                        PbFragment.this.iHD.Gc("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                            arrayList = PbFragment.this.iEi.getPbData().ckw();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cLa() != 1)) {
                            PbFragment.this.iHD.Gc(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cnc()) {
                            PbFragment.this.iHD.Gd(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iHD.Gd(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iHD.endLoadData();
                }
                if (eVar != null && eVar.iBK && PbFragment.this.dDE == 0) {
                    PbFragment.this.dDE = System.currentTimeMillis() - PbFragment.this.fVg;
                }
                if (!PbFragment.this.clB().cnz() || PbFragment.this.clB().getPbData().getPage().aBl() != 0 || PbFragment.this.clB().cnZ()) {
                    PbFragment.this.iHR = true;
                    return;
                }
                return;
            }
            PbFragment.this.iEi.yR(1);
            if (PbFragment.this.iHd != null) {
                PbFragment.this.iHd.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cnk() {
            if (PbFragment.this.iEi != null) {
                if (PbFragment.this.iHQ == null || !PbFragment.this.iHQ.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iHQ = (com.baidu.tbadk.editortools.pb.e) dVar.dV(PbFragment.this.getContext());
                    PbFragment.this.iHQ.a(PbFragment.this.iHb.getPageContext());
                    PbFragment.this.iHQ.a(PbFragment.this.dyA);
                    PbFragment.this.iHQ.a(PbFragment.this.dyt);
                    PbFragment.this.iHQ.a(PbFragment.this.iHb.getPageContext(), PbFragment.this.iHb.getIntent() == null ? null : PbFragment.this.iHb.getIntent().getExtras());
                    PbFragment.this.iHQ.aOt().gB(true);
                    PbFragment.this.iHD.setEditorTools(PbFragment.this.iHQ.aOt());
                    if (!PbFragment.this.iEi.cnE()) {
                        PbFragment.this.iHQ.vl(PbFragment.this.iEi.cny());
                    }
                    if (PbFragment.this.iEi.cof()) {
                        PbFragment.this.iHQ.vk(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iHD != null) {
                        PbFragment.this.iHQ.vk(PbFragment.this.iHD.cpm());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.iHD.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aRl().aRm()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fVg : j;
                if (PbFragment.this.dDE == 0) {
                    PbFragment.this.dDE = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dDw, PbFragment.this.createTime, PbFragment.this.dDE, z2, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dDw = 0L;
                if (iVar != null) {
                    iVar.aRi();
                }
                if (z2) {
                    iVar.dDN = currentTimeMillis;
                    iVar.gT(true);
                }
                if (!z2 && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null) {
                    int threadType = PbFragment.this.iEi.getPbData().cku().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHp, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iHp, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dDP = currentTimeMillis;
                                iVar2.mL(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dDP = currentTimeMillis;
                        dVar.mL(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iID = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cmE();
            }
        }
    };
    private final a.InterfaceC0374a iIE = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iHD.cpH();
            if (z) {
                if (PbFragment.this.iHB != null) {
                    PbFragment.this.iHB.fm(z2);
                }
                PbFragment.this.iEi.pX(z2);
                if (PbFragment.this.iEi.ayL()) {
                    PbFragment.this.cmN();
                } else {
                    PbFragment.this.iHD.o(PbFragment.this.iEi.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iHB != null) {
                        if (PbFragment.this.iHB.ayO() != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null) {
                            MarkData ayO = PbFragment.this.iHB.ayO();
                            MetaData aCo = PbFragment.this.iEi.getPbData().cku().aCo();
                            if (ayO != null && aCo != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aCo.getUserId()) && !aCo.hadConcerned()) {
                                    PbFragment.this.b(aCo);
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
                    PbFragment.this.cmK();
                    return;
                }
                PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbFragment.this.showToast(PbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbFragment.this.yE(PbFragment.this.mLastScrollState) && PbFragment.this.yE(i)) {
                if (PbFragment.this.iHD != null) {
                    PbFragment.this.iHD.cpY();
                    if (PbFragment.this.iHQ != null && !PbFragment.this.iHD.cpl()) {
                        PbFragment.this.iHD.qp(PbFragment.this.iHQ.aOZ());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iHD.cpk();
                    }
                }
                if (!PbFragment.this.iHj) {
                    PbFragment.this.iHj = true;
                    if (PbFragment.this.iHD != null) {
                        PbFragment.this.iHD.cqe();
                    }
                }
            }
            if (PbFragment.this.iHD != null) {
                PbFragment.this.iHD.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHd != null) {
                PbFragment.this.iHd.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iHk == null) {
                PbFragment.this.iHk = new com.baidu.tbadk.n.b();
                PbFragment.this.iHk.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iHk.aRc();
            } else {
                PbFragment.this.iHk.aRb();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cKa().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> ckw;
            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null && PbFragment.this.iHD != null && PbFragment.this.iHD.cpB() != null) {
                PbFragment.this.iHD.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iHd != null) {
                    PbFragment.this.iHd.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iEi.cnV() && (ckw = PbFragment.this.iEi.getPbData().ckw()) != null && !ckw.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iHD.cpB().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.iEi.getPbData();
                    if (pbData != null) {
                        if (pbData.ckx() != null && pbData.ckx().hasData()) {
                            headerCount--;
                        }
                        if (pbData.cky() != null && pbData.cky().hasData()) {
                            headerCount--;
                        }
                        int size = ckw.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fKD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fKy.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.iEi.cnS();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.iVH != 1002 || bVar.eLF) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.iHD.a(1, dVar.mSuccess, dVar.kji, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fKy.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.iHD.a(PbFragment.this.fKy.getLoadDataMode(), gVar.mSuccess, gVar.kji, false);
                            PbFragment.this.iHD.aM(gVar.kjl);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.iHD.a(PbFragment.this.fKy.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c iIF = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c ebC = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cmS()) {
                PbFragment.this.iHb.finish();
            }
            if (!PbFragment.this.iEi.pW(true)) {
                PbFragment.this.iHD.cpI();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gIJ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iIG && PbFragment.this.cmS()) {
                PbFragment.this.cmU();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iEi.pV(false)) {
                    PbFragment.this.iHD.cpG();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iEi.getPbData() != null) {
                    PbFragment.this.iHD.cqd();
                }
                PbFragment.this.iIG = true;
            }
        }
    };
    private int iIH = 0;
    private final TbRichTextView.i dMx = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cpB;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iHD.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cy("tid", PbFragment.this.iEi.cny());
                anVar.cy("fid", PbFragment.this.iEi.getForumId());
                anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iEi.iFb.ckS()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTT() != null) {
                            ArrayList<TbRichTextImageInfo> aTT = tbRichTextView.getRichText().aTT();
                            int i4 = 0;
                            while (i4 < aTT.size()) {
                                if (aTT.get(i4) != null) {
                                    arrayList.add(aTT.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(aTT.get(i4).getSrc()) || str.equals(aTT.get(i4).aUl()) || str.equals(aTT.get(i4).aUi()) || str.equals(aTT.get(i4).aUk()) || str.equals(aTT.get(i4).aUo()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTT.get(i4).getSrc();
                                    imageUrlData.originalUrl = aTT.get(i4).getSrc();
                                    imageUrlData.isLongPic = aTT.get(i4).aUq();
                                    concurrentHashMap.put(aTT.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iEi.cnP(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iEi.getPbData().cku());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.iEq) {
                        TbRichText bj = PbFragment.this.bj(str, i);
                        if (bj != null && PbFragment.this.iIH >= 0 && PbFragment.this.iIH < bj.aTS().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bj.aTS().get(PbFragment.this.iIH));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iEn.size()) {
                                    break;
                                } else if (!aVar.iEn.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bj.getPostId() != 0 && (cpB = PbFragment.this.iHD.cpB()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cpB.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bj.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iEi.coe(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iEi.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iEo.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEp, aVar.lastId, PbFragment.this.iEi.cnP(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iEi.getPbData().cku());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iEn, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iEo.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iEp, aVar.iEn.get(0), PbFragment.this.iEi.cnP(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iEi.getPbData().cku());
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
                PbFragment.this.iHt = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iII = false;
    PostData hhz = null;
    private final b.a iIJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hhz != null) {
                if (i == 0) {
                    PbFragment.this.hhz.fv(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hhz = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hhz);
                }
            }
        }
    };
    private final b.a iIK = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iIa != null && !TextUtils.isEmpty(PbFragment.this.iIb)) {
                if (i == 0) {
                    if (PbFragment.this.iIc == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iIb));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iIb;
                        aVar.pkgId = PbFragment.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIc.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gQB == null) {
                            PbFragment.this.gQB = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gQB.j(PbFragment.this.iIb, PbFragment.this.iIa.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iIa = null;
                PbFragment.this.iIb = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
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
                if (PbFragment.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        PbFragment.this.iIa = ((TbImageView) view).getBdImage();
                        PbFragment.this.iIb = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iIa == null || TextUtils.isEmpty(PbFragment.this.iIb)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIc = null;
                        } else {
                            PbFragment.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iIa = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iIb = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iIc = null;
                            } else {
                                PbFragment.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iIa = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iIb = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iIc = null;
                        } else {
                            PbFragment.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iHD.a(PbFragment.this.iIK, PbFragment.this.iIa.isGif());
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
            PbFragment.this.hhz = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hhz == null) {
                return true;
            }
            if (PbFragment.this.hhz.cLa() != 1 || !PbFragment.this.cv(view)) {
                if (PbFragment.this.iHB != null) {
                    if (!PbFragment.this.iHB.ayL() || PbFragment.this.hhz.getId() == null || !PbFragment.this.hhz.getId().equals(PbFragment.this.iEi.aCx())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.clB().getPbData() != null && PbFragment.this.clB().getPbData().ckS();
                    if (PbFragment.this.hhz.cLa() != 1) {
                        if (PbFragment.this.iHJ == null) {
                            PbFragment.this.iHJ = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iHJ.a(PbFragment.this.iIL);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cv(view) && !z3;
                            boolean z5 = (!PbFragment.this.cv(view) || PbFragment.this.iIa == null || PbFragment.this.iIa.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iHJ));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iHJ));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iHJ);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hhz);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iHJ);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iHJ);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hhz);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iHJ);
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
                                    if ((PbFragment.this.pL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHJ);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHJ);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iHJ);
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
                                        if (PbFragment.this.iEi.getPbData().ckG() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iHJ);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iHJ);
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
                            PbFragment.this.iHJ.az(arrayList);
                            PbFragment.this.iHI = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iHJ);
                            PbFragment.this.iHI.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cy("tid", PbFragment.this.iEi.iJW).cy("fid", PbFragment.this.iEi.getForumId()).cy("uid", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()).cy("post_id", PbFragment.this.iEi.aOO()).X("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iHD.a(PbFragment.this.iIJ, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iHD.a(PbFragment.this.iIK, PbFragment.this.iIa.isGif());
            return true;
        }
    };
    private k.c iIL = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.iHI != null) {
                PbFragment.this.iHI.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.iIa != null && !TextUtils.isEmpty(PbFragment.this.iIb)) {
                        if (PbFragment.this.iIc == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iIb));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iIb;
                            aVar.pkgId = PbFragment.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iIc.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iIa = null;
                        PbFragment.this.iIb = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iIa != null && !TextUtils.isEmpty(PbFragment.this.iIb)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gQB == null) {
                                PbFragment.this.gQB = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gQB.j(PbFragment.this.iIb, PbFragment.this.iIa.getImageByte());
                            PbFragment.this.iIa = null;
                            PbFragment.this.iIb = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hhz != null) {
                        PbFragment.this.hhz.fv(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hhz = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cu(view);
                        if (PbFragment.this.iEi.getPbData().cku() != null && PbFragment.this.iEi.getPbData().cku().aCo() != null && PbFragment.this.iEi.getPbData().cku().aCo().getUserId() != null && PbFragment.this.iHB != null) {
                            int g = PbFragment.this.g(PbFragment.this.iEi.getPbData());
                            bj cku = PbFragment.this.iEi.getPbData().cku();
                            if (cku.aBd()) {
                                i2 = 2;
                            } else if (cku.aBe()) {
                                i2 = 3;
                            } else if (cku.aEg()) {
                                i2 = 4;
                            } else {
                                i2 = cku.aEh() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cy("tid", PbFragment.this.iEi.iJW).X("obj_locate", 2).cy("obj_id", PbFragment.this.iEi.getPbData().cku().aCo().getUserId()).X("obj_type", PbFragment.this.iHB.ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                        PbFragment.this.FP((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.b(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbFragment.this.iHD.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                PbFragment.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbFragment.this.iHD.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iHD.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a glL = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iEi.cnF()) {
                PbFragment.this.cmP();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gso.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0499a fRz = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int eLi = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2) && PbFragment.this.iHD != null && PbFragment.this.iHd != null) {
                PbFragment.this.iHd.lC(true);
                if (Math.abs(i2) > this.eLi) {
                    PbFragment.this.iHd.hideFloatingView();
                }
                if (PbFragment.this.cmS()) {
                    PbFragment.this.iHD.cpy();
                    PbFragment.this.iHD.cpz();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2) && PbFragment.this.iHD != null && PbFragment.this.iHd != null) {
                PbFragment.this.iHD.cqj();
                PbFragment.this.iHd.lC(false);
                PbFragment.this.iHd.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a iGj = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iHD.Ge(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iIN = -1;
    private int iIO = -1;

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

    public com.baidu.tbadk.editortools.pb.e cmo() {
        return this.iHQ;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.clf() != null) {
            String id = lVar.clf().getId();
            ArrayList<PostData> ckw = this.iEi.getPbData().ckw();
            int i = 0;
            while (true) {
                if (i >= ckw.size()) {
                    break;
                }
                PostData postData = ckw.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clj = lVar.clj();
                    postData.Cv(lVar.getTotalCount());
                    if (postData.cKX() != null && clj != null) {
                        Iterator<PostData> it = clj.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCo() != null && (metaData = postData.getUserMap().get(next.aCo().getUserId())) != null) {
                                next.a(metaData);
                                next.sO(true);
                                next.a(getPageContext(), this.iEi.FV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clj.size() != postData.cKX().size();
                        postData.cKX().clear();
                        postData.cKX().addAll(clj);
                        z = z2;
                    }
                    if (postData.cKT() != null) {
                        postData.cKU();
                    }
                }
            }
            if (!this.iEi.getIsFromMark() && z) {
                this.iHD.o(this.iEi.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m ckJ = this.iEi.getPbData().ckJ();
            if (ckJ != null && str.equals(ckJ.getAdId())) {
                if (ckJ.cKO() != null) {
                    ckJ.cKO().legoCard = null;
                }
                this.iEi.getPbData().ckK();
            }
            com.baidu.tieba.tbadkCore.data.m cnL = this.iEi.cnL();
            if (cnL != null && str.equals(cnL.getAdId())) {
                this.iEi.cnM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iHI != null && this.iHI.isShowing()) {
                this.iHI.dismiss();
                this.iHI = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iHI != null) {
                            PbFragment.this.iHI.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iHD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iHY);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iHY);
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
                kVar.az(arrayList);
                this.iHI = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iHI.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        bj cku;
        if (this.iEi != null && this.iEi.getPbData() != null && (cku = this.iEi.getPbData().cku()) != null) {
            if (i == 1) {
                PraiseData aBZ = cku.aBZ();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aBZ == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        cku.a(praiseData);
                    } else {
                        cku.aBZ().getUser().add(0, metaData);
                        cku.aBZ().setNum(cku.aBZ().getNum() + 1);
                        cku.aBZ().setIsLike(i);
                    }
                }
                if (cku.aBZ() != null) {
                    if (cku.aBZ().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(cku.aBZ().getNum());
                    }
                }
            } else if (cku.aBZ() != null) {
                cku.aBZ().setIsLike(i);
                cku.aBZ().setNum(cku.aBZ().getNum() - 1);
                ArrayList<MetaData> user = cku.aBZ().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            cku.aBZ().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (cku.aBZ().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = cku.aBZ().getNum() + "";
                }
            }
            if (this.iEi.cnz()) {
                this.iHD.cpB().notifyDataSetChanged();
            } else {
                this.iHD.p(this.iEi.getPbData());
            }
        }
    }

    public static PbFragment cmp() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iHb = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iEi.au(bundle);
        if (this.gol != null) {
            this.gol.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iHQ.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iHi = System.currentTimeMillis();
        this.iHW = getPageContext();
        final Intent intent = this.iHb.getIntent();
        if (intent != null) {
            this.fVg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iHp = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iHp)) {
                    this.iHp = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iHp)) {
                this.iHe = true;
            }
            this.iIN = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iIO = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iIP = intent.getStringExtra("key_manga_title");
            this.iHL = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iHM = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iHN = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cmS()) {
                this.iHb.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iIe = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iHy = new ax();
            this.iHy.R(intent);
            this.iIg = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iIg == 0) {
                this.iIg = intent.getIntExtra("key_start_from", 0);
            }
            this.iIh = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fVg = System.currentTimeMillis();
        }
        this.dDw = this.iHi - this.fVg;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.iHg = 0;
        at(bundle);
        if (this.iEi.getPbData() != null) {
            this.iEi.getPbData().FJ(this.source);
        }
        cms();
        if (intent != null && this.iHD != null) {
            this.iHD.iNI = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iHZ == null) {
                    this.iHZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iHD.Gg("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iHZ, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iEi.getPbData() != null) {
                this.iEi.FY(stringExtra);
            }
        }
        this.gol = new VoiceManager();
        this.gol.onCreate(getPageContext());
        initData(bundle);
        this.iHP = new com.baidu.tbadk.editortools.pb.g();
        d(this.iHP);
        this.iHQ = (com.baidu.tbadk.editortools.pb.e) this.iHP.dV(getActivity());
        this.iHQ.a(this.iHb.getPageContext());
        this.iHQ.a(this.dyA);
        this.iHQ.a(this.dyt);
        this.iHQ.a(this.iHb.getPageContext(), bundle);
        this.iHQ.aOt().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iHQ.aOt().gB(true);
        pK(true);
        this.iHQ.a(this.iEi.cnN(), this.iEi.cny(), this.iEi.coe());
        registerListener(this.iIm);
        if (!this.iEi.cnE()) {
            this.iHQ.vl(this.iEi.cny());
        }
        if (this.iEi.cof()) {
            this.iHQ.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iHD != null) {
            this.iHQ.vk(this.iHD.cpm());
        }
        registerListener(this.iIl);
        registerListener(this.iIn);
        registerListener(this.iIo);
        registerListener(this.gpA);
        registerListener(this.iIz);
        registerListener(this.iIk);
        this.iHO = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.kfT);
        this.iHO.cKH();
        registerListener(this.iIp);
        registerListener(this.daf);
        this.iEi.cnX();
        registerListener(this.iID);
        registerListener(this.gpH);
        if (this.iHD != null && this.iHD.cqn() != null && this.iHD.cqo() != null) {
            this.iHd = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iHD.cqn(), this.iHD.cqo(), this.iHD.cps());
            this.iHd.a(this.iIu);
        }
        if (this.iHc && this.iHD != null && this.iHD.cqo() != null) {
            this.iHD.cqo().setVisibility(8);
        }
        this.iHX = new com.baidu.tbadk.core.view.d();
        this.iHX.toastTime = 1000L;
        registerListener(this.iIy);
        registerListener(this.iIw);
        registerListener(this.iIx);
        registerListener(this.gFB);
        registerListener(this.gpx);
        registerResponsedEventListener(TipEvent.class, this.gnt);
        this.iHY = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iHY;
        userMuteAddAndDelCustomMessage.setTag(this.iHY);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iHY;
        userMuteCheckCustomMessage.setTag(this.iHY);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iEi.coc().a(this.iIv);
        this.iHH = new ap();
        if (this.iHQ.aOS() != null) {
            this.iHH.e(this.iHQ.aOS().getInputView());
        }
        this.iHQ.a(this.dyu);
        this.gEu = new ShareSuccessReplyToServerModel();
        a(this.iIi);
        this.hPy = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hPy.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cZW) {
                        PbFragment.this.iHQ.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cZX && PbFragment.this.iHD != null && PbFragment.this.iHD.cpi() != null && PbFragment.this.iHD.cpi().cmn() != null) {
                        PbFragment.this.iHD.cpi().cmn().aPo();
                    } else if (i == com.baidu.tbadk.core.util.aj.cZY) {
                        PbFragment.this.c(PbFragment.this.iHT);
                    }
                }
            }
        });
        this.iHA = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iHA.t(getUniqueId());
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        com.baidu.tbadk.core.business.a.aAa().co("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iHi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iEi != null) {
            gVar.setForumName(this.iEi.cls());
            if (this.iEi.getPbData() != null && this.iEi.getPbData().getForum() != null) {
                gVar.a(this.iEi.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iEi);
        }
    }

    public String cmq() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cmr() {
        return this.iHd;
    }

    private void pK(boolean z) {
        this.iHQ.gF(z);
        this.iHQ.gG(z);
        this.iHQ.gH(z);
    }

    private void cms() {
        this.djU = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gol != null) {
            this.gol.onStart(getPageContext());
        }
    }

    public an cmt() {
        return this.iHD;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clB() {
        return this.iEi;
    }

    public void FO(String str) {
        if (this.iEi != null && !StringUtils.isNull(str) && this.iHD != null) {
            this.iHD.qu(true);
            this.iEi.FO(str);
            this.iHo = true;
            this.iHD.cpY();
            this.iHD.cqi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.isPaused = false;
        } else {
            this.isPaused = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.iHg = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iHg == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.gol != null) {
            this.gol.onPause(getPageContext());
        }
        if (this.iHD != null) {
            this.iHD.onPause();
        }
        if (!this.iEi.cnE()) {
            this.iHQ.saveDraft(this.iEi.cny());
        }
        if (this.iEi != null) {
            this.iEi.cnY();
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
        MessageManager.getInstance().unRegisterListener(this.hty);
        bPW();
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iIx);
        MessageManager.getInstance().unRegisterListener(this.iIy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cmu() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.iEi.getPbData(), this.iEi.cnz(), this.iEi.cnW());
        return (a2 == null || a2.aCo() == null || a2.aCo().getGodUserData() == null || a2.aCo().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iHr) {
            this.iHr = false;
            cmY();
        }
        if (cmu()) {
            this.iHl = System.currentTimeMillis();
        } else {
            this.iHl = -1L;
        }
        if (this.iHD != null && this.iHD.getView() != null) {
            if (!this.ihT) {
                cmQ();
            } else {
                hideLoadingView(this.iHD.getView());
            }
            this.iHD.onResume();
        }
        if (this.iHg == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iHD != null) {
            noNetworkView = this.iHD.cpf();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.gol != null) {
            this.gol.onResume(getPageContext());
        }
        registerListener(this.hty);
        this.iHK = false;
        cmX();
        registerListener(this.iIw);
        registerListener(this.iIx);
        registerListener(this.iIy);
        if (this.goY) {
            cmP();
            this.goY = false;
        }
        cne();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iHD.qj(z);
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
        if (z && this.iHK) {
            this.iHD.cpG();
            this.iEi.pV(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iHl > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cy("obj_duration", (System.currentTimeMillis() - this.iHl) + ""));
            this.iHl = 0L;
        }
        if (cmt().cpi() != null) {
            cmt().cpi().onStop();
        }
        if (this.iHD.iNK != null && !this.iHD.iNK.cre()) {
            this.iHD.iNK.releaseResources();
        }
        if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().getForum() != null && this.iEi.getPbData().cku() != null) {
            com.baidu.tbadk.distribute.a.aOh().a(getPageContext().getPageActivity(), "pb", this.iEi.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEi.getPbData().cku().getId(), 0L));
        }
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("fid", this.iEi.getPbData().getForumId());
            anVar.cy("tid", this.iEi.cny());
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iHj && this.iHD != null) {
            this.iHj = true;
            this.iHD.cqe();
            a(false, (PostData) null);
        }
        if (this.iEi != null) {
            this.iEi.cancelLoadData();
            this.iEi.destory();
            if (this.iEi.cob() != null) {
                this.iEi.cob().onDestroy();
            }
        }
        if (this.iHQ != null) {
            this.iHQ.onDestroy();
        }
        if (this.fKy != null) {
            this.fKy.cancelLoadData();
        }
        if (this.djU != null) {
            this.djU.cKu();
        }
        if (this.iHD != null) {
            this.iHD.onDestroy();
            if (this.iHD.iNK != null) {
                this.iHD.iNK.releaseResources();
            }
        }
        if (this.iHk != null) {
            this.iHk.aRd();
        }
        if (this.iHd != null) {
            this.iHd.aWI();
        }
        super.onDestroy();
        if (this.gol != null) {
            this.gol.onDestory(getPageContext());
        }
        if (this.iHD != null) {
            this.iHD.cpY();
        }
        MessageManager.getInstance().unRegisterListener(this.iIw);
        MessageManager.getInstance().unRegisterListener(this.iIx);
        MessageManager.getInstance().unRegisterListener(this.iIy);
        MessageManager.getInstance().unRegisterListener(this.iHY);
        MessageManager.getInstance().unRegisterListener(this.iIz);
        MessageManager.getInstance().unRegisterListener(this.gpH);
        MessageManager.getInstance().unRegisterListener(this.gFB);
        MessageManager.getInstance().unRegisterListener(this.iIB);
        this.iHW = null;
        this.iHX = null;
        com.baidu.tieba.recapp.d.a.cDk().cDm();
        if (this.iHZ != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iHZ);
        }
        if (this.iHs != null) {
            this.iHs.cancelLoadData();
        }
        if (this.iHD != null && this.iHD.iNK != null) {
            this.iHD.iNK.crh();
        }
        if (this.gEu != null) {
            this.gEu.cancelLoadData();
        }
        this.iHH.onDestroy();
        if (this.iEi != null && this.iEi.cod() != null) {
            this.iEi.cod().onDestroy();
        }
        if (this.hPy != null) {
            this.hPy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cpB;
        ArrayList<PostData> clZ;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aJd() && this.iHD != null && (cpB = this.iHD.cpB()) != null && (clZ = cpB.clZ()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = clZ.iterator();
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
                        bVar.fMt = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cSK == 1 && !TextUtils.isEmpty(id)) {
                    next.cSK = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fMt = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iEi == null || this.iEi.getPbData() == null || this.iEi.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iEi.getPbData().getForum().getFirst_class();
                    str2 = this.iEi.getPbData().getForum().getSecond_class();
                    str = this.iEi.getPbData().getForum().getId();
                    str4 = this.iEi.cny();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aJg());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iHD.onChangeSkinType(i);
            if (this.iHQ != null && this.iHQ.aOt() != null) {
                this.iHQ.aOt().onChangeSkinType(i);
            }
            if (this.iHD.cpf() != null) {
                this.iHD.cpf().onChangeSkinType(getPageContext(), i);
            }
            this.iHH.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iHD = new an(this, this.gqq, this.dqK);
        this.gso = new com.baidu.tieba.f.b(getActivity());
        this.gso.a(iIM);
        this.gso.a(this.fRz);
        this.iHD.setOnScrollListener(this.mOnScrollListener);
        this.iHD.d(this.gIJ);
        this.iHD.setListPullRefreshListener(this.ebC);
        this.iHD.pw(com.baidu.tbadk.core.i.azO().isShowImages());
        this.iHD.setOnImageClickListener(this.dMx);
        this.iHD.b(this.mOnLongClickListener);
        this.iHD.g(this.glL);
        this.iHD.a(this.iIF);
        this.iHD.qj(this.mIsLogin);
        if (this.iHb.getIntent() != null) {
            this.iHD.qv(this.iHb.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iHD.cph().setFromForumId(this.iEi.getFromForumId());
        this.iHD.setEditorTools(this.iHQ.aOt());
        this.iHQ.vk(this.iHD.cpm());
        this.iHD.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iEi.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEi.getPbData().getForum().getId(), PbFragment.this.iEi.getPbData().getForum().getName(), PbFragment.this.iEi.getPbData().cku().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iHD.getView();
    }

    public void cmv() {
        if (this.iHD != null && this.iEi != null) {
            if ((this.iEi.getPbData() != null || this.iEi.getPbData().ckP() != null) && checkUpIsLogin() && this.iHD.cpB() != null && this.iHD.cpB().cme() != null) {
                this.iHD.cpB().cme().tX(this.iEi.cny());
            }
        }
    }

    public void cmw() {
        TiebaStatic.log("c12181");
        if (this.iHD != null && this.iEi != null) {
            if ((this.iHD == null || this.iHD.cpl()) && this.iEi.getPbData() != null && this.iEi.getPbData().ckP() != null) {
                com.baidu.tieba.pb.data.k ckP = this.iEi.getPbData().ckP();
                if (checkUpIsLogin()) {
                    if ((!ckP.clc() || ckP.aDK() != 2) && this.iHD.cpB() != null && this.iHD.cpB().cme() != null) {
                        this.iHD.cpB().cme().tX(this.iEi.cny());
                    }
                    if (System.currentTimeMillis() - this.iHn > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).rd(false);
                        this.iHn = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ct(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.kgu && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.azO().isShowImages()) {
                    return FR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iEi == null || this.iEi.getPbData() == null) {
                        return true;
                    }
                    if (cmt().cpi() != null) {
                        cmt().cpi().cmj();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.iEi.getPbData().getForum());
                    lVar.setThreadData(this.iEi.getPbData().cku());
                    lVar.f(postData);
                    cmt().cph().d(lVar);
                    cmt().cph().setPostId(postData.getId());
                    b(view, postData.aCo().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iHQ != null) {
                        this.iHD.qp(this.iHQ.aOZ());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cmx() {
        if (this.iHh == null) {
            this.iHh = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iHh.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iEe = PbFragment.this.iEe.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEe);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEi.cny(), PbFragment.this.iEe, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iEe = PbFragment.this.iEe.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEe);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iEi.cny(), PbFragment.this.iEe, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iEe = PbFragment.this.iEe.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iEe);
                        bVar.dismiss();
                    }
                }
            }).kb(R.style.dialog_ani_b2t).kc(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.iIC.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).cte(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iEi = this.iHb.clB();
        if (this.iEi.coa() != null) {
            this.iEi.coa().a(this.iGj);
        }
        if (this.iEi.cob() != null) {
            this.iEi.cob().b(this.iIj);
        }
        if (StringUtils.isNull(this.iEi.cny())) {
            this.iHb.finish();
        } else if ("from_tieba_kuang".equals(this.iHp) && this.iHp != null) {
            this.iEi.yY(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iHB = com.baidu.tbadk.baseEditMark.a.a(this.iHb);
        if (this.iHB != null) {
            this.iHB.a(this.iIE);
        }
        this.fKy = new ForumManageModel(this.iHb);
        this.fKy.setLoadDataCallBack(this.fKD);
        this.dab = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iIt.setUniqueId(getUniqueId());
        this.iIt.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iHD.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iHY;
        userMuteCheckCustomMessage.setTag(this.iHY);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cmy() {
        if (this.iEi == null || this.iEi.getPbData() == null) {
            return false;
        }
        bj cku = this.iEi.getPbData().cku();
        this.iEi.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cku);
    }

    public void cmz() {
        if (checkUpIsLogin() && this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().getForum() != null && !cmy()) {
            if (this.iEi.getPbData().ckS()) {
                this.iHD.bPx();
                return;
            }
            if (this.grM == null) {
                this.grM = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.grM.tP(0);
                this.grM.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lw(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lx(boolean z) {
                        if (z) {
                            PbFragment.this.iHD.bPx();
                        }
                    }
                });
            }
            this.grM.C(this.iEi.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEi.cny(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmA() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.iEi == null || (pbData = this.iEi.getPbData()) == null) {
            return null;
        }
        return pbData.ckF().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            if (eVar.cku().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cku().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cku().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmy() && cmB()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iHu);
                this.iHv = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iEi.getPbData() != null && this.iEi.getPbData().ckS()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iHb.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmt().getListView().smoothScrollBy((PbFragment.this.iHu[1] + PbFragment.this.iHv) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmt().cpi() != null) {
                            PbFragment.this.iHQ.aOt().setVisibility(8);
                            PbFragment.this.cmt().cpi().g(str, str2, PbFragment.this.cmt().cpm(), (PbFragment.this.iEi == null || PbFragment.this.iEi.getPbData() == null || PbFragment.this.iEi.getPbData().cku() == null || !PbFragment.this.iEi.getPbData().cku().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmn = PbFragment.this.cmt().cpi().cmn();
                            if (cmn != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                cmn.a(PbFragment.this.iEi.getPbData().getAnti());
                                cmn.setThreadData(PbFragment.this.iEi.getPbData().cku());
                            }
                            if (PbFragment.this.iHH.cqz() == null && PbFragment.this.cmt().cpi().cmn().aPw() != null) {
                                PbFragment.this.cmt().cpi().cmn().aPw().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHH != null && PbFragment.this.iHH.cqy() != null) {
                                            if (!PbFragment.this.iHH.cqy().cUf()) {
                                                PbFragment.this.iHH.qx(false);
                                            }
                                            PbFragment.this.iHH.cqy().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHH.f(PbFragment.this.cmt().cpi().cmn().aPw().getInputView());
                                PbFragment.this.cmt().cpi().cmn().a(PbFragment.this.iHV);
                            }
                        }
                        PbFragment.this.cmt().cqi();
                    }
                }, 0L);
                return;
            }
            if (this.iHS == null) {
                this.iHS = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iHS.tP(1);
                this.iHS.a(new AnonymousClass37(str, str2));
            }
            if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().getForum() != null) {
                this.iHS.C(this.iEi.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iEi.cny(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String iIY;
        final /* synthetic */ String iIZ;

        AnonymousClass37(String str, String str2) {
            this.iIY = str;
            this.iIZ = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmt().getListView().smoothScrollBy((PbFragment.this.iHu[1] + PbFragment.this.iHv) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmt().cpi() != null) {
                            PbFragment.this.iHQ.aOt().setVisibility(8);
                            PbFragment.this.cmt().cpi().g(AnonymousClass37.this.iIY, AnonymousClass37.this.iIZ, PbFragment.this.cmt().cpm(), (PbFragment.this.iEi == null || PbFragment.this.iEi.getPbData() == null || PbFragment.this.iEi.getPbData().cku() == null || !PbFragment.this.iEi.getPbData().cku().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmn = PbFragment.this.cmt().cpi().cmn();
                            if (cmn != null && PbFragment.this.iEi != null && PbFragment.this.iEi.getPbData() != null) {
                                cmn.a(PbFragment.this.iEi.getPbData().getAnti());
                                cmn.setThreadData(PbFragment.this.iEi.getPbData().cku());
                            }
                            if (PbFragment.this.iHH.cqz() == null && PbFragment.this.cmt().cpi().cmn().aPw() != null) {
                                PbFragment.this.cmt().cpi().cmn().aPw().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iHH != null && PbFragment.this.iHH.cqy() != null) {
                                            if (!PbFragment.this.iHH.cqy().cUf()) {
                                                PbFragment.this.iHH.qx(false);
                                            }
                                            PbFragment.this.iHH.cqy().tH(false);
                                        }
                                    }
                                });
                                PbFragment.this.iHH.f(PbFragment.this.cmt().cpi().cmn().aPw().getInputView());
                                PbFragment.this.cmt().cpi().cmn().a(PbFragment.this.iHV);
                            }
                        }
                        PbFragment.this.cmt().cqi();
                    }
                }, 0L);
            }
        }
    }

    public boolean cmB() {
        if ((this.iEi.getPbData() != null && this.iEi.getPbData().ckS()) || this.hPy == null || this.iEi.getPbData() == null || this.iEi.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPy.ks(this.iEi.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yN(int i) {
        if (this.hPy == null || this.iEi.getPbData() == null || this.iEi.getPbData().getAnti() == null) {
            return true;
        }
        return this.hPy.ax(this.iEi.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iEi != null && this.iEi.getPbData() != null && postData.cLa() != 1) {
            String cny = this.iEi.cny();
            String id = postData.getId();
            int ckG = this.iEi.getPbData() != null ? this.iEi.getPbData().ckG() : 0;
            PbActivity.a FS = FS(id);
            if (FS != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cny, id, "pb", true, null, false, null, ckG, postData.crZ(), this.iEi.getPbData().getAnti(), false, postData.aCo() != null ? postData.aCo().getIconInfo() : null).addBigImageData(FS.iEn, FS.iEo, FS.iEp, FS.index);
                addBigImageData.setKeyPageStartFrom(this.iEi.coh());
                addBigImageData.setFromFrsForumId(this.iEi.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iEi.getForumId());
                addBigImageData.setBjhData(this.iEi.cnG());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmC() {
        if (this.iEi.getPbData() == null || this.iEi.getPbData().cku() == null) {
            return -1;
        }
        return this.iEi.getPbData().cku().aCY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        if (this.iEi != null && this.iEi.iFb != null && this.iEi.iFb.cku() != null) {
            bj cku = this.iEi.iFb.cku();
            cku.mRecomAbTag = this.iEi.cos();
            cku.mRecomWeight = this.iEi.coq();
            cku.mRecomSource = this.iEi.cor();
            cku.mRecomExtra = this.iEi.cot();
            if (cku.getFid() == 0) {
                cku.setFid(com.baidu.adp.lib.f.b.toLong(this.iEi.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cku, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Iw(this.iEi.getForumId()) && this.iEi.getPbData() != null && this.iEi.getPbData().getForum() != null) {
            if (this.iEi.getPbData().getForum().isLike() == 1) {
                this.iEi.cod().ev(this.iEi.getForumId(), this.iEi.cny());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iEi == null || this.iEi.getPbData() == null) {
            return false;
        }
        return ((this.iEi.getPbData().ckG() != 0) || this.iEi.getPbData().cku() == null || this.iEi.getPbData().cku().aCo() == null || TextUtils.equals(this.iEi.getPbData().cku().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean pM(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iEi == null || this.iEi.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEi.getPbData();
        bj cku = pbData.cku();
        if (cku != null) {
            if (cku.aBd() || cku.aBe()) {
                return false;
            }
            if (cku.aEg() || cku.aEh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.ckG() != 0) {
                return pbData.ckG() != 3;
            }
            List<bf> ckN = pbData.ckN();
            if (com.baidu.tbadk.core.util.v.getCount(ckN) > 0) {
                for (bf bfVar : ckN) {
                    if (bfVar != null && (wVar = bfVar.cQP) != null && wVar.cOJ && !wVar.cOK && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pN(boolean z) {
        if (z || this.iEi == null || this.iEi.getPbData() == null) {
            return false;
        }
        return ((this.iEi.getPbData().getForum() != null && this.iEi.getPbData().getForum().isBlockBawuDelete) || this.iEi.getPbData().ckG() == 0 || this.iEi.getPbData().ckG() == 3) ? false : true;
    }

    public void cmF() {
        com.baidu.tieba.pb.data.e pbData;
        bj cku;
        if (this.iEi != null && this.iEi.getPbData() != null && (cku = (pbData = this.iEi.getPbData()).cku()) != null && cku.aCo() != null) {
            this.iHD.cpg();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cku.aCo().getUserId());
            z zVar = new z();
            int ckG = this.iEi.getPbData().ckG();
            if (ckG == 1 || ckG == 3) {
                zVar.iMb = true;
                zVar.iMa = true;
                zVar.iMg = cku.aCj() == 1;
                zVar.iMf = cku.aCk() == 1;
            } else {
                zVar.iMb = false;
                zVar.iMa = false;
            }
            if (ckG == 1002 && !equals) {
                zVar.iMh = true;
            }
            zVar.iLY = pM(equals);
            zVar.iMc = cmG();
            zVar.iLZ = pN(equals);
            zVar.hW = this.iEi.cnz();
            zVar.iLV = true;
            zVar.iLU = pL(equals);
            zVar.iLT = equals && this.iHD.cpN();
            zVar.iMe = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iMd = true;
            zVar.isHostOnly = this.iEi.getHostMode();
            zVar.iLX = true;
            if (cku.aCF() == null) {
                zVar.iLW = true;
            } else {
                zVar.iLW = false;
            }
            if (pbData.ckS()) {
                zVar.iLV = false;
                zVar.iLX = false;
                zVar.iLW = false;
                zVar.iMa = false;
                zVar.iMb = false;
            }
            this.iHD.iNK.a(zVar);
        }
    }

    private boolean cmG() {
        if (this.iEi != null && this.iEi.cnz()) {
            return this.iEi.getPageData() == null || this.iEi.getPageData().aBl() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cmH() {
        return this.iIC;
    }

    public int cmI() {
        if (cmt() == null || cmt().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmt().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Ag == com.baidu.tieba.pb.data.j.iCE) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmJ() {
        if (cmt() == null || cmt().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmt().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kgt) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cmP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        if (this.iEi != null && this.iEi.iFb != null && this.iEi.iFb.cku() != null) {
            bj cku = this.iEi.iFb.cku();
            cku.mRecomAbTag = this.iEi.cos();
            cku.mRecomWeight = this.iEi.coq();
            cku.mRecomSource = this.iEi.cor();
            cku.mRecomExtra = this.iEi.cot();
            if (cku.getFid() == 0) {
                cku.setFid(com.baidu.adp.lib.f.b.toLong(this.iEi.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cku, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sR(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sS(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fG(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dab.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iEi.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aEC();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iHD.cpH();
        this.iEi.pX(z);
        if (this.iHB != null) {
            this.iHB.fm(z);
            if (markData != null) {
                this.iHB.a(markData);
            }
        }
        if (this.iEi.ayL()) {
            cmN();
        } else {
            this.iHD.o(this.iEi.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yE(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().ckS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iEi.cny(), str);
            bj cku = this.iEi.getPbData().cku();
            if (cku.aBd()) {
                format = format + "&channelid=33833";
            } else if (cku.aEf()) {
                format = format + "&channelid=33842";
            } else if (cku.aBe()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iHA.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.iEi.cnE()) {
                    antiData.setBlock_forum_name(this.iEi.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iEi.getPbData().getForum().getId());
                    antiData.setUser_name(this.iEi.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iEi.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cmt() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            vq(str);
        } else {
            this.iHD.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kji) ? bVar.kji : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sS(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fG(true);
                aVar.b(getPageContext());
                aVar.aEC();
            } else {
                this.iHD.a(0, bVar.mSuccess, bVar.kji, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fXX == 1) {
                    ArrayList<PostData> ckw = this.iEi.getPbData().ckw();
                    int size = ckw.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckw.get(i).getId())) {
                            i++;
                        } else {
                            ckw.remove(i);
                            break;
                        }
                    }
                    this.iEi.getPbData().cku().jJ(this.iEi.getPbData().cku().aCf() - 1);
                    this.iHD.o(this.iEi.getPbData());
                } else if (bVar.fXX == 0) {
                    cmL();
                } else if (bVar.fXX == 2) {
                    ArrayList<PostData> ckw2 = this.iEi.getPbData().ckw();
                    int size2 = ckw2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckw2.get(i2).cKX().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckw2.get(i2).cKX().get(i3).getId())) {
                                i3++;
                            } else {
                                ckw2.get(i2).cKX().remove(i3);
                                ckw2.get(i2).cKZ();
                                z2 = true;
                                break;
                            }
                        }
                        ckw2.get(i2).Jb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iHD.o(this.iEi.getPbData());
                    }
                    a(bVar, this.iHD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iHD.a(this.fKy.getLoadDataMode(), gVar.mSuccess, gVar.kji, false);
            if (gVar.mSuccess) {
                this.iHE = true;
                if (i == 2 || i == 3) {
                    this.iHF = true;
                    this.iHG = false;
                } else if (i == 4 || i == 5) {
                    this.iHF = false;
                    this.iHG = true;
                }
                if (i == 2) {
                    this.iEi.getPbData().cku().jM(1);
                    this.iEi.setIsGood(1);
                } else if (i == 3) {
                    this.iEi.getPbData().cku().jM(0);
                    this.iEi.setIsGood(0);
                } else if (i == 4) {
                    this.iEi.getPbData().cku().jL(1);
                    this.iEi.yQ(1);
                } else if (i == 5) {
                    this.iEi.getPbData().cku().jL(0);
                    this.iEi.yQ(0);
                }
                this.iHD.c(this.iEi.getPbData(), this.iEi.cnz());
            }
        }
    }

    private void cmL() {
        if (this.iEi.cnA() || this.iEi.cnC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iEi.cny());
            PbActivity pbActivity = this.iHb;
            PbActivity pbActivity2 = this.iHb;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iEi.cny()));
        if (cmO()) {
            this.iHb.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clO() {
        this.iHb.clO();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckD;
        boolean z = false;
        if (this.iHD != null) {
            this.iHD.cpY();
        }
        if (this.iEi != null && this.iEi.getPbData() != null && !this.iEi.getPbData().ckS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iEi.getPbData().cku().getId();
            if (this.iEi.isShareThread() && this.iEi.getPbData().cku().cTQ != null) {
                historyMessage.threadName = this.iEi.getPbData().cku().cTQ.showText;
            } else {
                historyMessage.threadName = this.iEi.getPbData().cku().getTitle();
            }
            if (this.iEi.isShareThread() && !clr()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iEi.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckw = this.iEi.getPbData().ckw();
            int cpJ = this.iHD != null ? this.iHD.cpJ() : 0;
            if (ckw != null && cpJ >= 0 && cpJ < ckw.size()) {
                historyMessage.postID = ckw.get(cpJ).getId();
            }
            historyMessage.isHostOnly = this.iEi.getHostMode();
            historyMessage.isSquence = this.iEi.cnz();
            historyMessage.isShareThread = this.iEi.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iHQ != null) {
            this.iHQ.onDestroy();
        }
        if (this.iHf && cmt() != null) {
            cmt().cqs();
        }
        if (this.iEi != null && (this.iEi.cnA() || this.iEi.cnC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iEi.cny());
            if (this.iHE) {
                if (this.iHG) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iEi.bxQ());
                }
                if (this.iHF) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iEi.getIsGood());
                }
            }
            if (this.iEi.getPbData() != null && System.currentTimeMillis() - this.iHi >= 40000 && (ckD = this.iEi.getPbData().ckD()) != null && !com.baidu.tbadk.core.util.v.isEmpty(ckD.getDataList())) {
                intent.putExtra("guess_like_data", ckD);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iIe);
            }
            PbActivity pbActivity = this.iHb;
            PbActivity pbActivity2 = this.iHb;
            pbActivity.setResult(-1, intent);
        }
        if (cmO()) {
            if (this.iEi != null && this.iHD != null && this.iHD.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.iEi.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.ckA() && !this.iHo && pbData.iBF == null) {
                        ah coQ = ah.coQ();
                        com.baidu.tieba.pb.data.e cnH = this.iEi.cnH();
                        Parcelable onSaveInstanceState = this.iHD.getListView().onSaveInstanceState();
                        boolean cnz = this.iEi.cnz();
                        boolean hostMode = this.iEi.getHostMode();
                        if (this.iHD.cps() != null && this.iHD.cps().getVisibility() == 0) {
                            z = true;
                        }
                        coQ.a(cnH, onSaveInstanceState, cnz, hostMode, z);
                        if (this.iId >= 0 || this.iEi.coj() != null) {
                            ah.coQ().n(this.iEi.coj());
                            ah.coQ().m(this.iEi.cok());
                            ah.coQ().za(this.iEi.col());
                        }
                    }
                }
            } else {
                ah.coQ().reset();
            }
            clO();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iHD == null || !this.iHD.zg(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yO(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iHb;
        if (i == 0) {
            this.iHD.cpg();
            this.iHD.cpi().cmj();
            this.iHD.qr(false);
        }
        this.iHD.cpk();
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
                        this.iHQ.resetData();
                        this.iHQ.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iHQ.b(writeData);
                        com.baidu.tbadk.editortools.l mp = this.iHQ.aOt().mp(6);
                        if (mp != null && mp.dwA != null) {
                            mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iHb;
                        if (i == -1) {
                            this.iHQ.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iHD.cpi() != null && this.iHD.cpi().cmn() != null) {
                            com.baidu.tbadk.editortools.pb.h cmn = this.iHD.cpi().cmn();
                            cmn.setThreadData(this.iEi.getPbData().cku());
                            cmn.b(writeData);
                            cmn.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mp2 = cmn.aOt().mp(6);
                            if (mp2 != null && mp2.dwA != null) {
                                mp2.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iHb;
                            if (i == -1) {
                                cmn.aPo();
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
        this.iHQ.onActivityResult(i, i2, intent);
        if (this.iHs != null) {
            this.iHs.onActivityResult(i, i2, intent);
        }
        if (cmt().cpi() != null) {
            cmt().cpi().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cmM();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.coQ().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iEi != null) {
                                PbFragment.this.iEi.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCa().A(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iEi != null) {
                        b(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aj(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.cCa().A(getPageContext());
                        cmE();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gEu != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gEu.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aLK() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55.1
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
                    this.iHD.pB(false);
                    if (this.iEi.getPbData() != null && this.iEi.getPbData().cku() != null && this.iEi.getPbData().cku().aCI() != null) {
                        this.iEi.getPbData().cku().aCI().setStatus(2);
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
                        this.iHT = emotionImageData;
                        if (yN(com.baidu.tbadk.core.util.aj.cZY)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iHt != null) {
                        this.iHD.cB(this.iHt);
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
            if (this.iHs == null) {
                this.iHs = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iHb);
                this.iHs.b(this.dyt);
                this.iHs.c(this.dyA);
            }
            this.iHs.a(emotionImageData, clB(), clB().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmM() {
        MarkData yX;
        if (this.iHB != null) {
            if (this.iEi.getPbData() != null && this.iEi.getPbData().ckS()) {
                yX = this.iEi.yX(0);
            } else {
                yX = this.iEi.yX(this.iHD.cpK());
            }
            if (yX != null) {
                if (!yX.isApp() || (yX = this.iEi.yX(this.iHD.cpK() + 1)) != null) {
                    this.iHD.cpF();
                    this.iHB.a(yX);
                    if (!this.iHB.ayL()) {
                        this.iHB.ayN();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iHB.ayM();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        com.baidu.tieba.pb.data.e pbData = this.iEi.getPbData();
        this.iEi.pX(true);
        if (this.iHB != null) {
            pbData.FI(this.iHB.ayK());
        }
        this.iHD.o(pbData);
    }

    private boolean cmO() {
        if (this.iEi == null) {
            return true;
        }
        if (this.iEi.getPbData() == null || !this.iEi.getPbData().ckS()) {
            if (this.iEi.ayL()) {
                final MarkData cnR = this.iEi.cnR();
                if (cnR == null || !this.iEi.getIsFromMark()) {
                    return true;
                }
                final MarkData yX = this.iEi.yX(this.iHD.cpJ());
                if (yX == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cnR);
                    this.iHb.setResult(-1, intent);
                    return true;
                } else if (yX.getPostId() == null || yX.getPostId().equals(cnR.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cnR);
                    this.iHb.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sS(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iHB != null) {
                                if (PbFragment.this.iHB.ayL()) {
                                    PbFragment.this.iHB.ayM();
                                    PbFragment.this.iHB.fm(false);
                                }
                                PbFragment.this.iHB.a(yX);
                                PbFragment.this.iHB.fm(true);
                                PbFragment.this.iHB.ayN();
                            }
                            cnR.setPostId(yX.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnR);
                            PbFragment.this.iHb.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clO();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cnR);
                            PbFragment.this.iHb.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.clO();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iHD != null && PbFragment.this.iHD.getView() != null) {
                                PbFragment.this.iHD.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", cnR);
                                PbFragment.this.iHb.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.clO();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aEC();
                    return false;
                }
            } else if (this.iEi.getPbData() == null || this.iEi.getPbData().ckw() == null || this.iEi.getPbData().ckw().size() <= 0 || !this.iEi.getIsFromMark()) {
                return true;
            } else {
                this.iHb.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iHD == null) {
            return null;
        }
        return this.iHD.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUz() {
        if (this.iHD == null) {
            return 0;
        }
        return this.iHD.cpW();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUA() {
        if (this.dMn == null) {
            this.dMn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUM */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.i.azO().isShowImages()) {
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
        return this.dMn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUB() {
        if (this.dPb == null) {
            this.dPb = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUC() {
        if (this.dMo == null) {
            this.dMo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGZ */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.am.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.i.azO().isShowImages()) {
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
                    gifView.aPO();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMo;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUD() {
        if (this.dPc == null) {
            this.dPc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnl */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cw */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cx */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cMh();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cy */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.dPc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUF() {
        this.dPe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnm */
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
        return this.dPe;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIi() {
        if (this.djc == null) {
            this.djc = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iHm = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str, boolean z) {
        if (as.Gh(str) && this.iEi != null && this.iEi.cny() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").X("obj_param1", 1).cy("post_id", this.iEi.cny()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dvD = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqB().c(getPageContext(), str);
        }
        this.iHm = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqB().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iHm = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iHD != null && this.iHD.cqn() != null && rect.top <= this.iHD.cqn().getHeight()) {
            rect.top += this.iHD.cqn().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.iEi.getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTS().get(this.iIH)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iEn = new ArrayList<>();
                aVar.iEo = new ConcurrentHashMap<>();
                if (!tbRichTextData.aTY().aUj()) {
                    aVar.iEq = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.iEn.add(b2);
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
                    imageUrlData.postId = bj.getPostId();
                    imageUrlData.mIsReserver = this.iEi.cnP();
                    imageUrlData.mIsSeeHost = this.iEi.getHostMode();
                    aVar.iEo.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.cku() != null) {
                            aVar.threadId = pbData.cku().getId();
                        }
                        aVar.iEp = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iEq = true;
                int size = pbData.ckw().size();
                this.iII = false;
                aVar.index = -1;
                int a2 = pbData.ckB() != null ? a(pbData.ckB().cLc(), bj, i, i, aVar.iEn, aVar.iEo) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ckw().get(i2);
                    if (postData.getId() == null || pbData.ckB() == null || pbData.ckB().getId() == null || !postData.getId().equals(pbData.ckB().getId())) {
                        a2 = a(postData.cLc(), bj, a2, i, aVar.iEn, aVar.iEo);
                    }
                }
                if (aVar.iEn.size() > 0) {
                    aVar.lastId = aVar.iEn.get(aVar.iEn.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.cku() != null) {
                        aVar.threadId = pbData.cku().getId();
                    }
                    aVar.iEp = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return null;
        }
        return tbRichTextData.aTY().aUo();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return 0L;
        }
        return tbRichTextData.aTY().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return false;
        }
        return tbRichTextData.aTY().aUp();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aTY() == null) {
            return false;
        }
        return tbRichTextData.aTY().aUq();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aTY;
        String str;
        if (tbRichText == tbRichText2) {
            this.iII = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTS().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTS().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aTY().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aTY().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aTY().aUj()) {
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
                        String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (aTY = tbRichTextData.aTY()) != null) {
                                String aUl = aTY.aUl();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aTY.aUm();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aUl;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iEi.cny(), -1L);
                                imageUrlData.mIsReserver = this.iEi.cnP();
                                imageUrlData.mIsSeeHost = this.iEi.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iII) {
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

    protected void k(PostData postData) {
        PostData ckB;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iEi.aCx())) {
                z = true;
            }
            MarkData l = this.iEi.l(postData);
            if (this.iEi.getPbData() != null && this.iEi.getPbData().ckS() && (ckB = ckB()) != null) {
                l = this.iEi.l(ckB);
            }
            if (l != null) {
                this.iHD.cpF();
                if (this.iHB != null) {
                    this.iHB.a(l);
                    if (!z) {
                        this.iHB.ayN();
                    } else {
                        this.iHB.ayM();
                    }
                }
            }
        }
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bj(String str, int i) {
        TbRichText tbRichText = null;
        if (this.iEi == null || this.iEi.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.iEi.getPbData();
        if (pbData.ckB() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckB());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ckw = pbData.ckw();
            c(pbData, ckw);
            return c(ckw, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.ckF() != null && eVar.ckF().iCS != null && (list = eVar.ckF().iCS) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTS;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLc = arrayList.get(i2).cLc();
            if (cLc != null && (aTS = cLc.aTS()) != null) {
                int size = aTS.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTS.get(i4) != null && aTS.get(i4).getType() == 8) {
                        i3++;
                        if (aTS.get(i4).aTY().aUl().equals(str) || aTS.get(i4).aTY().aUm().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTS.get(i4).aTY().getWidth() * equipmentDensity;
                            int height = aTS.get(i4).aTY().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iIH = i4;
                            return cLc;
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
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.iEe = str;
            if (this.iHh == null) {
                cmx();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iHh.getItemView(1).setVisibility(8);
            } else {
                this.iHh.getItemView(1).setVisibility(0);
            }
            this.iHh.aED();
            this.iHm = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmP() {
        hideNetRefreshView(this.iHD.getView());
        cmQ();
        if (this.iEi.cnK()) {
            this.iHD.cpF();
        }
        this.iHD.cpQ();
    }

    private void cmQ() {
        showLoadingView(this.iHD.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iHD.cqn().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEk() {
        if (this.gol != null) {
            this.gol.stopPlay();
        }
        if (this.iHb != null) {
            this.iHb.bEk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cmC(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUE() {
        if (this.dPd == null) {
            this.dPd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnn */
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
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.dPd;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bEl() {
        if (this.iHb != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.iHb.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iHb.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bCY() {
        if (this.iEi == null || this.iEi.getPbData() == null) {
            return null;
        }
        return this.iEi.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.iOV)).intValue();
            if (intValue == an.iOW) {
                if (!this.fKy.cLO()) {
                    this.iHD.cpC();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fKy.Jg(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.fKy.a(this.iEi.getPbData().getForum().getId(), this.iEi.getPbData().getForum().getName(), this.iEi.getPbData().cku().getId(), str, intValue3, intValue2, booleanValue, this.iEi.getPbData().cku().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.iOX || intValue == an.iOZ) {
                if (this.iEi.coa() != null) {
                    this.iEi.coa().yI(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.iOX) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iHY);
        userMuteAddAndDelCustomMessage.setTag(this.iHY);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean FR(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0584a
    public void pO(boolean z) {
        this.iHK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmR() {
        ArrayList<PostData> ckw;
        int count;
        if (this.iEi == null || this.iEi.getPbData() == null || this.iEi.getPbData().ckw() == null || (count = com.baidu.tbadk.core.util.v.getCount((ckw = this.iEi.getPbData().ckw()))) == 0) {
            return "";
        }
        if (this.iEi.cnP()) {
            Iterator<PostData> it = ckw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLa() == 1) {
                    return next.getId();
                }
            }
        }
        int cpJ = this.iHD.cpJ();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckw, cpJ);
        if (postData == null || postData.aCo() == null) {
            return "";
        }
        if (this.iEi.FV(postData.aCo().getUserId())) {
            return postData.getId();
        }
        for (int i = cpJ - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckw, i);
            if (postData2 == null || postData2.aCo() == null || postData2.aCo().getUserId() == null) {
                break;
            } else if (this.iEi.FV(postData2.aCo().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cpJ + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckw, i2);
            if (postData3 == null || postData3.aCo() == null || postData3.aCo().getUserId() == null) {
                return "";
            }
            if (this.iEi.FV(postData3.aCo().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        this.iHm = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a FS(String str) {
        String str2;
        if (this.iEi.getPbData() == null || this.iEi.getPbData().ckw() == null || this.iEi.getPbData().ckw().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iEi.getPbData().ckw().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iEi.getPbData().ckw().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iEi.getPbData().ckw().get(i);
        if (postData.cLc() == null || postData.cLc().aTS() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLc().aTS().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aTY() != null) {
                    str2 = next.aTY().aUl();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cmS() {
        return (!this.iHc && this.iIN == -1 && this.iIO == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iIQ = pVar;
            this.iHc = true;
            this.iHD.cpt();
            this.iHD.Gf(this.iIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmT() {
        if (this.iIQ != null) {
            if (this.iIN == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iIQ.getCartoonId(), this.iIN, 0)));
                this.iHb.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (this.iIQ != null) {
            if (this.iIO == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iIQ.getCartoonId(), this.iIO, 0)));
                this.iHb.finish();
            }
        }
    }

    public int cmV() {
        return this.iIN;
    }

    public int cmW() {
        return this.iIO;
    }

    private void bPW() {
        if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().cku() != null && this.iEi.getPbData().cku().aBb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cmX() {
        if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().cku() != null && this.iEi.getPbData().cku().aBb()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cmY() {
        if (this.isPaused) {
            this.iHr = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iEi.getPbData() != null && this.iEi.getPbData().cku() != null && this.iEi.getPbData().cku().aBU() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iEi.getPbData().cku().aBU().getThreadId(), this.iEi.getPbData().cku().aBU().getTaskId(), this.iEi.getPbData().cku().aBU().getForumId(), this.iEi.getPbData().cku().aBU().getForumName(), this.iEi.getPbData().cku().aCj(), this.iEi.getPbData().cku().aCk())));
            this.iHe = true;
            this.iHb.finish();
        }
    }

    public String cmZ() {
        return this.iHp;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cna() {
        return this.iHz;
    }

    public void pP(boolean z) {
        this.iHq = z;
    }

    public boolean aEc() {
        if (this.iEi != null) {
            return this.iEi.cnA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sS(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iHW).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iHW.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iHW).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iHW != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHW.getPageActivity());
            aVar.sS(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iHW).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iHD.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iHW.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sS(this.iHW.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iHD.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.81
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iHW).aEC();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.Gh(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.gOe) {
            this.gOe = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iHD != null) {
                this.iHD.onConfigurationChanged(configuration);
            }
            if (this.iHI != null) {
                this.iHI.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cnc() {
        if (this.iEi != null) {
            return this.iEi.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.iEi.getPbData().ckF().iCS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cKX().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cKX().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cKX().remove(i2);
                    list.get(i).cKZ();
                    z = true;
                    break;
                }
            }
            list.get(i).Jb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.iEi.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.clf().getId();
        List<PostData> list = this.iEi.getPbData().ckF().iCS;
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
                ArrayList<PostData> clj = lVar.clj();
                postData.Cv(lVar.getTotalCount());
                if (postData.cKX() != null) {
                    postData.cKX().clear();
                    postData.cKX().addAll(clj);
                }
            }
        }
        if (!this.iEi.getIsFromMark()) {
            this.iHD.o(this.iEi.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a clq() {
        return this.iHb.clq();
    }

    public boolean clr() {
        if (this.iEi == null) {
            return false;
        }
        return this.iEi.clr();
    }

    public void cnd() {
        if (this.iHD != null) {
            this.iHD.cpg();
            bEl();
        }
    }

    public PostData ckB() {
        return this.iHD.b(this.iEi.iFb, this.iEi.cnz());
    }

    public void onBackPressed() {
        if (this.iIf != null && !this.iIf.isEmpty()) {
            int size = this.iIf.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iIf.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iIf == null) {
                this.iIf = new ArrayList();
            }
            if (!this.iIf.contains(aVar)) {
                this.iIf.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iIf == null) {
                this.iIf = new ArrayList();
            }
            if (!this.iIf.contains(aVar)) {
                this.iIf.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iIf != null) {
            this.iIf.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cne() {
        if (this.iEi != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iEi.cny())) {
            com.baidu.tbadk.BdToken.c.axz().o(com.baidu.tbadk.BdToken.b.cGL, com.baidu.adp.lib.f.b.toLong(this.iEi.cny(), 0L));
        }
    }

    public ax cnf() {
        return this.iHy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.iEi != null && this.iEi.getPbData() != null && this.iEi.getPbData().cku() != null && this.iEi.getPbData().cku().aEi()) {
            bj cku = this.iEi.getPbData().cku();
            int i = 0;
            if (cku.aBd()) {
                i = 1;
            } else if (cku.aBe()) {
                i = 2;
            } else if (cku.aEg()) {
                i = 3;
            } else if (cku.aEh()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.X("obj_source", 4);
            anVar.X("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cng() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnh() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cni() {
        return this.iHb;
    }
}
