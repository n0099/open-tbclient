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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0843a {
    private at eIQ;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private com.baidu.adp.lib.d.b<TextView> fXB;
    private com.baidu.adp.lib.d.b<View> fXC;
    private com.baidu.adp.lib.d.b<LinearLayout> fXD;
    private com.baidu.adp.lib.d.b<RelativeLayout> fXE;
    private com.baidu.tbadk.core.message.a feF;
    private com.baidu.tieba.tbadkCore.data.e fep;
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private LikeModel fnw;
    private com.baidu.tieba.callfans.a ixM;
    private VoiceManager jgg;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private com.baidu.tieba.f.b jlc;
    public com.baidu.tbadk.core.util.am kSl;
    public ar kWo;
    private String lNd;
    private PbActivity lQT;
    private com.baidu.tieba.pb.pb.main.b.b lQW;
    private com.baidu.tieba.pb.pb.report.a lRA;
    private com.baidu.tbadk.core.dialog.i lRH;
    private com.baidu.tbadk.core.dialog.k lRI;
    private boolean lRJ;
    private com.baidu.tieba.tbadkCore.data.f lRN;
    private com.baidu.tbadk.editortools.pb.g lRO;
    private com.baidu.tbadk.editortools.pb.e lRP;
    private com.baidu.tieba.frs.profession.permission.c lRR;
    private EmotionImageData lRS;
    private com.baidu.adp.base.f lRV;
    private com.baidu.tbadk.core.view.c lRW;
    private BdUniqueId lRX;
    private Runnable lRY;
    private com.baidu.adp.widget.ImageView.a lRZ;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lRm;
    private View lRn;
    private View lRo;
    private View lRp;
    private View lRq;
    int lRs;
    private bk lRv;
    private boolean lSJ;
    private String lSS;
    private com.baidu.tbadk.core.data.t lST;
    private String lSa;
    private TbRichTextMemeInfo lSb;
    private List<a> lSe;
    public String lSg;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lSP = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmg();
            } else {
                com.baidu.tieba.pb.a.b.dmf();
            }
        }
    };
    boolean lQU = true;
    private boolean lQV = false;
    private boolean lQX = false;
    private boolean isPaused = false;
    private boolean llZ = false;
    private boolean lQY = true;
    private int lQZ = 0;
    private com.baidu.tbadk.core.dialog.b lRa = null;
    private long iIQ = -1;
    private long fJu = 0;
    private long lRb = 0;
    private long createTime = 0;
    private long fJl = 0;
    private boolean lRc = false;
    private com.baidu.tbadk.n.b lRd = null;
    private long lRe = 0;
    private boolean lRf = false;
    private long lRg = 0;
    private int jMV = 1;
    private String fDL = null;
    private boolean lRh = false;
    private boolean isFullScreen = false;
    private boolean lRi = false;
    private String lRj = "";
    private boolean lRk = true;
    private boolean lRl = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lRr = new int[2];
    private int lRt = -1;
    private int lRu = -1;
    public BdUniqueId lRw = BdUniqueId.gen();
    private boolean lRx = false;
    private boolean lRy = com.baidu.tbadk.a.d.biY();
    private PbInterviewStatusView.a lRz = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lRD.vD(!PbFragment.this.lRk);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.bjZ()) {
                        PbFragment.this.dnE();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lNh = null;
    private com.baidu.tbadk.baseEditMark.a lRB = null;
    private ForumManageModel geq = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private com.baidu.tieba.pb.data.r lRC = null;
    private ShareSuccessReplyToServerModel jCj = null;
    private ap lRD = null;
    private boolean lRE = false;
    private boolean lRF = false;
    private boolean lRG = false;
    private boolean glZ = false;
    private boolean lRK = false;
    private boolean lRL = false;
    private boolean lRM = false;
    private boolean lRQ = false;
    public boolean lRT = false;
    private com.baidu.tbadk.editortools.pb.c fDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBM() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (PbFragment.this.kWo == null || PbFragment.this.kWo.drF() == null || !PbFragment.this.kWo.drF().dWp()) {
                return !PbFragment.this.FI(com.baidu.tbadk.core.util.am.faA);
            }
            PbFragment.this.showToast(PbFragment.this.kWo.drF().dWr());
            if (PbFragment.this.lRP != null && (PbFragment.this.lRP.bCc() || PbFragment.this.lRP.bCd())) {
                PbFragment.this.lRP.a(false, PbFragment.this.kWo.drI());
            }
            PbFragment.this.kWo.vQ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lRU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (PbFragment.this.kWo == null || PbFragment.this.kWo.drG() == null || !PbFragment.this.kWo.drG().dWp()) {
                return !PbFragment.this.FI(com.baidu.tbadk.core.util.am.faB);
            }
            PbFragment.this.showToast(PbFragment.this.kWo.drG().dWr());
            if (PbFragment.this.lRD != null && PbFragment.this.lRD.dqj() != null && PbFragment.this.lRD.dqj().dne() != null && PbFragment.this.lRD.dqj().dne().bCd()) {
                PbFragment.this.lRD.dqj().dne().a(PbFragment.this.kWo.drI());
            }
            PbFragment.this.kWo.vR(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jgU = false;
    private int lSc = 0;
    private int lSd = -1;
    public int lSf = 0;
    private final a lSh = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lRD != null && PbFragment.this.lRD.dqj() != null) {
                r dqj = PbFragment.this.lRD.dqj();
                if (dqj.dnc()) {
                    dqj.dnb();
                    return true;
                }
            }
            if (PbFragment.this.lRD != null && PbFragment.this.lRD.drk()) {
                PbFragment.this.lRD.drl();
                return true;
            }
            return false;
        }
    };
    private final ab.a lSi = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lRD.showToast(str);
            }
        }
    };
    private final CustomMessageListener lSj = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNh != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lRP != null) {
                    PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                }
                PbFragment.this.lRD.dql();
                PbFragment.this.lRD.drd();
            }
        }
    };
    CustomMessageListener jhN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lNh.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lRD != null && PbFragment.this.lNh != null) {
                    PbFragment.this.lRD.b(PbFragment.this.lNh.getPbData(), PbFragment.this.lNh.dov(), PbFragment.this.lNh.doT(), PbFragment.this.lRD.getSkinType());
                }
                if (PbFragment.this.lRD != null && PbFragment.this.lRD.dqD() != null) {
                    PbFragment.this.lRD.dqD().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lSk = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lRD != null) {
                    if (booleanValue) {
                        PbFragment.this.lRD.dqG();
                    } else {
                        PbFragment.this.lRD.dqH();
                    }
                }
            }
        }
    };
    private CustomMessageListener lSl = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lRP != null) {
                    PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                }
                PbFragment.this.lRD.vK(false);
            }
        }
    };
    private CustomMessageListener lSm = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lSn = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lRD != null && PbFragment.this.lRD.dqD() != null) {
                PbFragment.this.lRD.dqD().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener juD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener jhJ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.dnW();
            }
        }
    };
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fDL);
        }
    };
    private CustomMessageListener lSo = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ai)) {
                com.baidu.tbadk.core.data.ai aiVar = (com.baidu.tbadk.core.data.ai) customResponsedMessage.getData();
                bb.a aVar = new bb.a();
                aVar.giftId = aiVar.id;
                aVar.giftName = aiVar.name;
                aVar.thumbnailUrl = aiVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNh.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lNh.doK() != null && PbFragment.this.lNh.doK().getUserIdLong() == aiVar.toUserId) {
                        PbFragment.this.lRD.a(aiVar.sendCount, PbFragment.this.lNh.getPbData(), PbFragment.this.lNh.dov(), PbFragment.this.lNh.doT());
                    }
                    if (pbData.dlb() != null && pbData.dlb().size() >= 1 && pbData.dlb().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dlb().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNh.dot(), 0L);
                        if (j == aiVar.postId && j2 == aiVar.threadId) {
                            bb dNF = pbData.dlb().get(0).dNF();
                            if (dNF == null) {
                                dNF = new bb();
                            }
                            ArrayList<bb.a> bmH = dNF.bmH();
                            if (bmH == null) {
                                bmH = new ArrayList<>();
                            }
                            bmH.add(0, aVar);
                            dNF.setTotal(aiVar.sendCount + dNF.getTotal());
                            dNF.y(bmH);
                            pbData.dlb().get(0).a(dNF);
                            PbFragment.this.lRD.dqD().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lSp = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                PbFragment.this.lNh.getPbData().dlt();
                PbFragment.this.lNh.doP();
                if (PbFragment.this.lRD.dqD() != null) {
                    PbFragment.this.lRD.s(PbFragment.this.lNh.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.o oVar;
            if (customResponsedMessage != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Pr(str);
                PbFragment.this.lNh.doP();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lNh.getPbData().dlb() != null) {
                    ArrayList<PostData> dlb = PbFragment.this.lNh.getPbData().dlb();
                    Iterator<PostData> it = dlb.iterator();
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
                        dlb.remove(oVar);
                        if (PbFragment.this.lRD.dqD() != null && PbFragment.this.lRD.dqD().getDataList() != null) {
                            PbFragment.this.lRD.dqD().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lRD.getListView() != null && PbFragment.this.lRD.getListView().getData() != null) {
                            PbFragment.this.lRD.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lRD.dqD() != null) {
                            PbFragment.this.lRD.dqD().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lRD.dqD() != null) {
                    PbFragment.this.lRD.s(PbFragment.this.lNh.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lSq = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.drY()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lSr = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lRD != null) {
                PbFragment.this.lRD.fn(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lSs = false;
    private PraiseModel lSt = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Fa(String str) {
            PbFragment.this.lSs = false;
            if (PbFragment.this.lSt != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNh.getPbData();
                if (pbData.dkZ().bnB().getIsLike() == 1) {
                    PbFragment.this.zV(0);
                } else {
                    PbFragment.this.zV(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dkZ()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lSs = false;
            if (PbFragment.this.lSt != null && str != null) {
                if (AntiHelper.bX(i, str)) {
                    AntiHelper.br(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lSu = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void vg(boolean z) {
            PbFragment.this.ve(z);
            if (PbFragment.this.lRD.drq() != null && z) {
                PbFragment.this.lRD.vD(false);
            }
            PbFragment.this.lRD.vF(z);
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().fsD != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().fsD, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dli().bnQ() != null && PbFragment.this.dli().bnQ().getGodUserData() != null) {
                            PbFragment.this.dli().bnQ().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null) {
                            PbFragment.this.lNh.getPbData().dkZ().bnQ().setHadConcerned(updateAttentionMessage.isAttention());
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
            if (tipEvent.pageId > 0 && PbFragment.this.lQT.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lSv = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lRD.ckq();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.FL(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.k.a.cOs();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fvK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dnn();
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
                            PbFragment.this.g((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.lRD.dnl() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dmh() != null && PbFragment.this.dmh().iPF != null) {
                                PbFragment.this.dmh().iPF.onClick(view);
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
                if (PbFragment.this.lRP != null) {
                    PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                }
                PbFragment.this.lRD.dql();
                PbFragment.this.lRD.drd();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lSw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lRX) {
                PbFragment.this.lRD.ckq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNh.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlp().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lRW.showSuccessToast(PbFragment.this.lRV.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lRV.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Dc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dnS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lRV.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lRW.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lSx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lRX) {
                PbFragment.this.lRD.ckq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lRW.showSuccessToast(PbFragment.this.lRV.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lRV.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lRW.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lSy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lRX) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lRD.ckq();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nJZ;
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
                    PbFragment.this.lRD.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lSz = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lRD.dqm() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dnn();
            }
        }
    };
    private CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.jgU = true;
                }
            }
        }
    };
    public a.b lxf = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cCV();
            az pageData = PbFragment.this.lNh.getPageData();
            int pageNum = PbFragment.this.lRD.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bmA()) {
                PbFragment.this.lRD.drd();
                PbFragment.this.cCU();
                PbFragment.this.lRD.dqK();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lNh.FP(PbFragment.this.lRD.getPageNum());
                    if (PbFragment.this.lQW != null) {
                        PbFragment.this.lQW.showFloatingView();
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
    private k.c lSA = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lRH != null) {
                PbFragment.this.lRH.dismiss();
            }
            PbFragment.this.FH(i);
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
                    if (com.baidu.tbadk.a.d.bjj() || com.baidu.tbadk.a.d.bjk()) {
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
                    if (com.baidu.tbadk.a.d.bjj() || com.baidu.tbadk.a.d.bjk()) {
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
                    if (PbFragment.this.lRZ != null && !TextUtils.isEmpty(PbFragment.this.lSa)) {
                        if (PbFragment.this.lSb == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lSa));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lSa;
                            aVar.pkgId = PbFragment.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lSb.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lRZ = null;
                        PbFragment.this.lSa = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lRZ != null && !TextUtils.isEmpty(PbFragment.this.lSa)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eIQ == null) {
                                PbFragment.this.eIQ = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eIQ.p(PbFragment.this.lSa, PbFragment.this.lRZ.getImageByte());
                            PbFragment.this.lRZ = null;
                            PbFragment.this.lSa = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.kpS != null) {
                        PbFragment.this.kpS.gW(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.kpS = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").ap("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dE(view);
                        if (PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId() != null && PbFragment.this.lRB != null) {
                            int h = PbFragment.this.h(PbFragment.this.lNh.getPbData());
                            cb dkZ = PbFragment.this.lNh.getPbData().dkZ();
                            if (dkZ.bmx()) {
                                i2 = 2;
                            } else if (dkZ.bmy()) {
                                i2 = 3;
                            } else if (dkZ.bpN()) {
                                i2 = 4;
                            } else {
                                i2 = dkZ.bpO() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lNh.lUN).ap("obj_locate", 2).dR("obj_id", PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId()).ap("obj_type", PbFragment.this.lRB.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i2));
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
                        PbFragment.this.Pt((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").ap("obj_locate", 4));
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
                        PbFragment.this.lRD.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.lRD.dL(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lRD.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpJ() != null) {
                            PbFragment.this.d(postData.bpJ());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    public SortSwitchButton.a lSB = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            PbFragment.this.lRD.drd();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lNh == null || PbFragment.this.lNh.isLoading) {
                    return false;
                }
                PbFragment.this.cCU();
                PbFragment.this.lRD.dqK();
                if (PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().lJY != null && PbFragment.this.lNh.getPbData().lJY.size() > i) {
                    int intValue = PbFragment.this.lNh.getPbData().lJY.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", PbFragment.this.lNh.dou()).dR("fid", PbFragment.this.lNh.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_type", FN(intValue)));
                    if (PbFragment.this.lNh.FU(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lRD.vy(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int FN(int i) {
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
    public final View.OnClickListener jiV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.lRD.dqZ()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lNh.vm(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lRD.dqL();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpK()) {
                        if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpL()) {
                            if (view == PbFragment.this.lRD.lYH.fLW) {
                                if (PbFragment.this.lRD.vH(PbFragment.this.lNh.doB())) {
                                    PbFragment.this.cCU();
                                    return;
                                }
                                PbFragment.this.lQY = false;
                                PbFragment.this.lQX = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lQT, PbFragment.this.lRD.lYH.fLW);
                                PbFragment.this.lQT.finish();
                            } else if (view != PbFragment.this.lRD.dqI() && (PbFragment.this.lRD.lYH.dsl() == null || (view != PbFragment.this.lRD.lYH.dsl().dpJ() && view != PbFragment.this.lRD.lYH.dsl().dpH()))) {
                                if (view == PbFragment.this.lRD.drh()) {
                                    if (PbFragment.this.lNh != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNh.getPbData().dkZ().bnP().getLink());
                                    }
                                } else if (view != PbFragment.this.lRD.lYH.mfo) {
                                    if (view == PbFragment.this.lRD.lYH.jwO) {
                                        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                                            if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                ArrayList<PostData> dlb = PbFragment.this.lNh.getPbData().dlb();
                                                if ((dlb == null || dlb.size() <= 0) && PbFragment.this.lNh.dov()) {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", PbFragment.this.lNh.dot()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.lNh.getForumId()));
                                                if (!PbFragment.this.lRD.drv()) {
                                                    PbFragment.this.lRD.dql();
                                                }
                                                PbFragment.this.dnw();
                                            } else {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lRD.uS(true);
                                            PbFragment.this.lRD.dql();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lRD.dqG();
                                                PbFragment.this.cCU();
                                                PbFragment.this.lRD.dqK();
                                                PbFragment.this.lNh.Py(PbFragment.this.dnI());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpG()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lRD.lYH.dsl() != null && view == PbFragment.this.lRD.lYH.dsl().dpF()) {
                                                PbFragment.this.lRD.lYH.baM();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.FM(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpD()) {
                                                    if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpN()) {
                                                        if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpE()) {
                                                            if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpO()) {
                                                                if (PbFragment.this.lRD.drq() == view) {
                                                                    if (PbFragment.this.lRD.drq().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lNh.getPbData();
                                                                        if (pbData2 != null && pbData2.dkZ() != null && pbData2.dkZ().bnw() != null) {
                                                                            String bnm = pbData2.dkZ().bnw().bnm();
                                                                            if (StringUtils.isNull(bnm)) {
                                                                                bnm = pbData2.dkZ().bnw().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dR("obj_id", bnm));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gx("c10725", null);
                                                                    }
                                                                    PbFragment.this.dnP();
                                                                } else if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpM()) {
                                                                    if (PbFragment.this.lRD.lYH.dsl() != null && view == PbFragment.this.lRD.lYH.dsl().dpI()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lRD.b(PbFragment.this.lNh.getPbData(), PbFragment.this.lNh.dov(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lRD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lRD.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lRD.lYH.baM();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dR("tid", PbFragment.this.lNh.dot());
                                                                            arVar.dR("fid", PbFragment.this.lNh.getForumId());
                                                                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.ap("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (view.getId() == R.id.pb_floor_reply_more && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                            PbFragment.this.lRo = view;
                                                                            return;
                                                                        } else if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                PbFragment.this.lRD.drd();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dNJ() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.nxt != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN = postData.nxt.bsN();
                                                                                        bsN.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bsN.ap("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bsN.ap("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bsN);
                                                                                    }
                                                                                    String dot = PbFragment.this.lNh.dot();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lNh.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lNh.getPbData().dlo();
                                                                                    }
                                                                                    PbFragment.this.cCU();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Pw = PbFragment.this.Pw(id);
                                                                                        if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && Pw != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dot, id, "pb", true, null, true, null, i3, postData.dtl(), PbFragment.this.lNh.getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Pw.lNv, Pw.eJM, Pw.eJK, Pw.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lNh.dpe());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lNh.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lNh.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lNh.doD());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Pw2 = PbFragment.this.Pw(id);
                                                                                        if (postData != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && Pw2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dot, id, "pb", true, null, false, str2, i3, postData.dtl(), PbFragment.this.lNh.getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Pw2.lNv, Pw2.eJM, Pw2.eJK, Pw2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lNh.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lNh.doD());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lNh.dpe());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lNh.getFromForumId());
                                                                                            if (PbFragment.this.lRD != null) {
                                                                                                addBigImageData2.setMainPostMaskVisibly(PbFragment.this.lRD.b(PbFragment.this.lNh.lOq, PbFragment.this.lNh.dov()).nxk || postData.nxk);
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 3).dR("fid", PbFragment.this.lNh.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lNh != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dR("tid", PbFragment.this.lNh.dot());
                                                                            arVar2.dR("fid", PbFragment.this.lNh.getForumId());
                                                                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.ap("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (view.getId() == R.id.pb_post_reply_count && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                                PbFragment.this.lRo = view;
                                                                                return;
                                                                            } else if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nxt != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN2 = postData3.nxt.bsN();
                                                                                        bsN2.delete("obj_locate");
                                                                                        bsN2.ap("obj_locate", 8);
                                                                                        TiebaStatic.log(bsN2);
                                                                                    }
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                        String dot2 = PbFragment.this.lNh.dot();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lNh.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lNh.getPbData().dlo();
                                                                                        }
                                                                                        PbActivity.a Pw3 = PbFragment.this.Pw(id2);
                                                                                        if (Pw3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dot2, id2, "pb", true, null, false, null, i4, postData3.dtl(), PbFragment.this.lNh.getPbData().getAnti(), false, postData3.bnQ().getIconInfo()).addBigImageData(Pw3.lNv, Pw3.eJM, Pw3.eJK, Pw3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lNh.dpe());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lNh.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lNh.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lNh.doD());
                                                                                            if (PbFragment.this.lNh.getPbData().dlI() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lNh.getPbData().dlI().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lNh.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lNh.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lNh.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lNh.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lNh.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lNh.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lNh.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lNh.getPbData().getForum().getUser_level());
                                                                                            }
                                                                                            if (PbFragment.this.lRD != null) {
                                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.lRD.b(PbFragment.this.lNh.lOq, PbFragment.this.lNh.dov()).nxk || postData3.nxk);
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
                                                                        if (PbFragment.this.lNh != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dR("tid", PbFragment.this.lNh.dot());
                                                                                arVar3.dR("fid", PbFragment.this.lNh.getForumId());
                                                                                arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.ap("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (view.getId() == R.id.post_info_commont_img) {
                                                                                if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                    PbFragment.this.lRp = view;
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.lRp = view;
                                                                                return;
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nxt != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN3 = postData4.nxt.bsN();
                                                                                        bsN3.delete("obj_locate");
                                                                                        bsN3.ap("obj_locate", 8);
                                                                                        TiebaStatic.log(bsN3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", PbFragment.this.lNh.dou()).dR("fid", PbFragment.this.lNh.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ap("obj_source", 1).ap("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.dnk().dqi() != null && postData4.bnQ() != null && postData4.dNx() != 1) {
                                                                                        if (PbFragment.this.dnk().dqj() != null) {
                                                                                            PbFragment.this.dnk().dqj().dna();
                                                                                        }
                                                                                        if (PbFragment.this.lRy && postData4.dNu() != null && postData4.dNu().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                                                                                            qVar.a(PbFragment.this.lNh.getPbData().getForum());
                                                                                            qVar.setThreadData(PbFragment.this.lNh.getPbData().dkZ());
                                                                                            qVar.g(postData4);
                                                                                            PbFragment.this.dnk().dqi().d(qVar);
                                                                                            PbFragment.this.dnk().dqi().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bnQ().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lRP != null) {
                                                                                                PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
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
                                                                        if (view != PbFragment.this.lRD.dmA()) {
                                                                            if (view == PbFragment.this.lRD.lYH.dsm()) {
                                                                                PbFragment.this.lRD.dqR();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cgVar = (cg) view.getTag()) != null && !StringUtils.isNull(cgVar.bqk())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        bf.bsV().b(PbFragment.this.getPageContext(), new String[]{cgVar.bqk()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dR("tid", PbFragment.this.lNh.lUN));
                                                                                            }
                                                                                            if (PbFragment.this.lRI == null) {
                                                                                                PbFragment.this.lRI = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lRI.a(PbFragment.this.lSA);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dG(view);
                                                                                            if (!PbFragment.this.dG(view) || PbFragment.this.lRZ == null || !PbFragment.this.lRZ.isGif()) {
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
                                                                                                if (postData5.dNz() != null && postData5.dNz().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lRI);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eVl.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.kpS = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lNh.getPbData().bjZ()) {
                                                                                                String bjY = PbFragment.this.lNh.getPbData().bjY();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bjY) && bjY.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lRI);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lRI);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.kpS);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eVl.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lRI);
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
                                                                                                            gVar.eVl.setTag(sparseArray8);
                                                                                                            arrayList.add(gVar5);
                                                                                                        } else {
                                                                                                            if (PbFragment.this.va(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRI);
                                                                                                                gVar6.eVl.setTag(str3);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRI);
                                                                                                                gVar2.eVl.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lRI);
                                                                                                            gVar8.eVl.setTag(sparseArray9);
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
                                                                                                            if (PbFragment.this.lNh.getPbData().dlo() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRI);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRI);
                                                                                                            }
                                                                                                            gVar2.eVl.setTag(sparseArray10);
                                                                                                        }
                                                                                                        if (gVar2 != null) {
                                                                                                            arrayList.add(gVar2);
                                                                                                        }
                                                                                                        if (gVar7 != null) {
                                                                                                            arrayList.add(gVar7);
                                                                                                        }
                                                                                                    }
                                                                                                    PbFragment.this.lRI.bw(arrayList);
                                                                                                    PbFragment.this.lRH = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRI);
                                                                                                    PbFragment.this.lRH.QE();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.kpS);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eVl.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lRI.bw(arrayList);
                                                                                            PbFragment.this.lRH = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRI);
                                                                                            PbFragment.this.lRH.QE();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lNh.getPbData().dkZ().getActUrl());
                                                                                        if (PbFragment.this.lNh.getPbData().dkZ().boC() != 1) {
                                                                                            if (PbFragment.this.lNh.getPbData().dkZ().boC() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dR("fid", PbFragment.this.lNh.getPbData().getForumId()).dR("tid", PbFragment.this.lNh.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lNh.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lRD.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bh.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.lRD.dql();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dnu() == 1 && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dR("fid", PbFragment.this.lNh.getPbData().getForumId()).dR("tid", PbFragment.this.lNh.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dnu() == 1 && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dR("fid", PbFragment.this.lNh.getPbData().getForumId()).dR("tid", PbFragment.this.lNh.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dnK();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dnL();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dlv() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lNh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dR("fid", pbData3.getForumId()));
                                                                                        bf.bsV().b(PbFragment.this.getPageContext(), new String[]{pbData3.dlv().dlJ()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dlv() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lNh.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", pbData4.getForumId()));
                                                                                        bf.bsV().b(PbFragment.this.getPageContext(), new String[]{pbData4.dlv().dlJ()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lSc >= 0) {
                                                                                        if (PbFragment.this.lNh != null) {
                                                                                            PbFragment.this.lNh.dpf();
                                                                                        }
                                                                                        if (PbFragment.this.lNh != null && PbFragment.this.lRD.dqD() != null) {
                                                                                            PbFragment.this.lRD.dqD().a(PbFragment.this.lNh.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lSc = 0;
                                                                                        if (PbFragment.this.lNh != null) {
                                                                                            PbFragment.this.lRD.getListView().setSelection(PbFragment.this.lNh.dpi());
                                                                                            PbFragment.this.lNh.cZ(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.FM(8);
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
                                                                                    if (PbFragment.this.lRD.getListView() != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lRD.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lRD.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dlz = PbFragment.this.lNh.getPbData().dlz();
                                                                                        boolean z8 = PbFragment.this.lRD.dqk() != null && PbFragment.this.lRD.dqk().isVertical();
                                                                                        boolean dra = PbFragment.this.lRD.dra();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (dlz && PbFragment.this.lRD.dqk() != null && PbFragment.this.lRD.dqk().getContainerView() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lRD.dqk().drV();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lRD.dqk().getContainerView().getHeight() - PbFragment.this.lRD.dqk().drV());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.Px("c13568");
                                                                                        if ((PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnH() <= 0) || (dra && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dnq();
                                                                                                if (PbFragment.this.lNh.getPbData().dkZ().bnQ() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNh.lUN).dR("fid", PbFragment.this.lNh.getPbData().getForumId()).ap("obj_locate", 2).dR("uid", PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dlz) {
                                                                                                if (PbFragment.this.lRD.lZS != null && PbFragment.this.lRD.lZS.mbd != null && PbFragment.this.lRD.lZS.mbd.getView() != null) {
                                                                                                    if (PbFragment.this.lRD.lZS.mbd.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dnA();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lRD.dqk() != null && PbFragment.this.lRD.dqk().getContainerView() != null) {
                                                                                                            i5 = PbFragment.this.lRD.dqk().getContainerView().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lRD.lZS.mbd.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lRD.dqu() != null) {
                                                                                                z10 = PbFragment.this.lRD.dqu().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lRD.lZS != null && PbFragment.this.lRD.lZS.mbd != null && PbFragment.this.lRD.lZS.mbd.getView() != null && PbFragment.this.lRD.lZS.mbd.getView().getParent() != null && PbFragment.this.lRD.lYH != null && PbFragment.this.lRD.lYH.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lRD.lZS.mbd.getView().getTop() - PbFragment.this.lRD.lYH.mNavigationBar.getBottom() < PbFragment.this.lRD.lZS.mbd.lYh.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dra) {
                                                                                                PbFragment.this.lRt = firstVisiblePosition;
                                                                                                PbFragment.this.lRu = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lRD.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lRt > 0) {
                                                                                                if (PbFragment.this.lRD.getListView().getChildAt(PbFragment.this.lRt) != null) {
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollToPosition(PbFragment.this.lRt, PbFragment.this.lRu, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lRD.getListView().setSelectionFromTop(PbFragment.this.lRt, PbFragment.this.lRu + equipmentHeight);
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dnA = PbFragment.this.dnA();
                                                                                                if (PbFragment.this.dnz() != -1) {
                                                                                                    dnA--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dnA < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lRD.getListView().getData()) - 1) + PbFragment.this.lRD.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dnA;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!dlz || PbFragment.this.lRD.dqk() == null) ? (PbFragment.this.lRD.lYH == null || PbFragment.this.lRD.lYH.mNavigationBar == null) ? dimens : (PbFragment.this.lRD.lYH.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lRD.dqk().drU() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lRD.lZS == null || PbFragment.this.lRD.lZS.mbd == null || PbFragment.this.lRD.lZS.mbd.getView() == null || PbFragment.this.lRD.lZS.mbd.getView().getParent() == null) {
                                                                                                    PbFragment.this.lRD.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lRD.getListView().smoothScrollBy(PbFragment.this.lRD.lZS.mbd.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNh.lUN).dR("fid", PbFragment.this.lNh.getPbData().getForumId()).ap("obj_locate", 2).dR("uid", PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lNh.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lNh.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lNh.dmj()) || PbFragment.this.lNh.getAppealInfo() == null) {
                                                                                                PbFragment.this.lQT.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lNh.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lNh.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lQT.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dmj = PbFragment.this.lNh.dmj();
                                                                                        if (PbFragment.this.lNh.dow() && dmj != null && dmj.equals(name)) {
                                                                                            PbFragment.this.lQT.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lNh.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dR("tid", PbFragment.this.lNh.dot());
                                                                                        arVar4.dR("fid", PbFragment.this.lNh.getForumId());
                                                                                        arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lNh.getPbData().dkZ() != null) {
                                                                                            arVar4.dR(IntentConfig.NID, PbFragment.this.lNh.getPbData().dkZ().bmo());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof cb) {
                                                                                        cb cbVar = (cb) view.getTag();
                                                                                        if (PbFragment.this.lNh.dpe() == 3 && PbFragment.this.dmi() && PbFragment.this.lNh.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lNh.getPbData().dlw())) {
                                                                                            PbFragment.this.lQT.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(cbVar.bnU(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c13399");
                                                                                        arVar5.dR("tid", cbVar.getId());
                                                                                        arVar5.v("fid", cbVar.getFid());
                                                                                        arVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar5.dR(IntentConfig.NID, cbVar.bmo());
                                                                                        TiebaStatic.log(arVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lNh != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dR("tid", PbFragment.this.lNh.dot());
                                                                                        arVar6.dR("fid", PbFragment.this.lNh.getForumId());
                                                                                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.ap("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lNh.getPbData();
                                                                                        if (PbFragment.this.lRC == null) {
                                                                                            PbFragment.this.lRC = new com.baidu.tieba.pb.data.r(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").v("forum_id", j2).bsO();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lSE);
                                                                                        PbFragment.this.lRC.M(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dR("fid", PbFragment.this.lNh.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).v("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.lNh.dot()).ap("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof cb) {
                                                                                        cb cbVar2 = (cb) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(cbVar2.bnU(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 9).ap("obj_locate", 9).v("obj_id", cbVar2.getFid()).dR("tid", cbVar2.getId()).ap("thread_type", cbVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof cb) && PbFragment.this.checkUpIsLogin()) {
                                                                                        cb cbVar3 = (cb) view.getTag();
                                                                                        if (PbFragment.this.fnw != null) {
                                                                                            PbFragment.this.fnw.gw(cbVar3.bnU(), String.valueOf(cbVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 10).ap("obj_locate", 11).v("obj_id", cbVar3.getFid()).dR("tid", cbVar3.getId()).ap("thread_type", cbVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                    arVar7.dR("tid", PbFragment.this.lNh.dot());
                                                                                    arVar7.dR("fid", PbFragment.this.lNh.getForumId());
                                                                                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    arVar7.ap("obj_locate", 7);
                                                                                    TiebaStatic.log(arVar7);
                                                                                    PbFragment.this.lQU = false;
                                                                                    PbFragment.this.dF(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNh.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNh.dot(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lNh.getPbData().dkZ().bok())));
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
                                                                            if (PbFragment.this.lRI == null) {
                                                                                PbFragment.this.lRI = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lRI.a(PbFragment.this.lSA);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dmq().getPbData() != null && PbFragment.this.dmq().getPbData().dlC();
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
                                                                                if (postData6.bpJ() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bpJ().hasAgree && postData6.bpt() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lRI);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eVl.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lRI);
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
                                                                                        gVar10.eVl.setTag(sparseArray13);
                                                                                        arrayList2.add(gVar10);
                                                                                    } else {
                                                                                        if ((PbFragment.this.va(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRI);
                                                                                            gVar11.eVl.setTag(str);
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
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRI);
                                                                                            gVar12.eVl.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lRI);
                                                                                        gVar3.eVl.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.lNh.getPbData().dlo() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRI);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRI);
                                                                                            }
                                                                                            gVar12.eVl.setTag(sparseArray15);
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
                                                                                PbFragment.this.lRI.bw(arrayList2);
                                                                                PbFragment.this.lRH = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRI);
                                                                                PbFragment.this.lRH.QE();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lRD.drd();
                                                                    SparseArray<Object> b3 = PbFragment.this.lRD.b(PbFragment.this.lNh.getPbData(), PbFragment.this.lNh.dov(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNh.getPbData().getForum().getId(), PbFragment.this.lNh.getPbData().getForum().getName(), PbFragment.this.lNh.getPbData().dkZ().getId(), String.valueOf(PbFragment.this.lNh.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 0).ap("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).ap("obj_type", 1).ap("obj_source", 1));
                                                                }
                                                                PbFragment.this.lRD.lYH.dsk();
                                                            }
                                                        } else if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null) {
                                                            PbFragment.this.lRD.lYH.baM();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.Pt(PbFragment.this.lNh.getPbData().dkZ().bog());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lRD.drd();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lNh.doN()));
                                                                return;
                                                            }
                                                            PbFragment.this.cCU();
                                                            PbFragment.this.lRD.dqK();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lNh.getPbData().lJY == null || PbFragment.this.lNh.getPbData().lJY.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lNh.getPbData().lJY.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lNh.getPbData().lJY.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lNh.getPbData().lJY.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lNh.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lNh.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lNh.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lNh.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").ap("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ap("obj_type", i9));
                                                                    if (PbFragment.this.lNh.getPbData().lJY != null && PbFragment.this.lNh.getPbData().lJY.size() > i8) {
                                                                        i8 = PbFragment.this.lNh.getPbData().lJY.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean FU = PbFragment.this.lNh.FU(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lNh.doN()));
                                                                    if (FU) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lRD.vy(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.QE();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.lRD.drd();
                                                    if (PbFragment.this.dmq().getPbData().lJZ != 2) {
                                                        if (PbFragment.this.lNh.getPageData() != null) {
                                                            PbFragment.this.lRD.a(PbFragment.this.lNh.getPageData(), PbFragment.this.lxf);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lNh.getPbData()) != null) {
                                                cb dkZ = pbData.dkZ();
                                                if (dkZ != null && dkZ.bnQ() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNh.lUN).dR("fid", pbData.getForumId()).ap("obj_locate", 4).dR("uid", dkZ.bnQ().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (dkZ != null) {
                                                    if (dkZ.bmx()) {
                                                        i8 = 2;
                                                    } else if (dkZ.bmy()) {
                                                        i8 = 3;
                                                    } else if (dkZ.bpN()) {
                                                        i8 = 4;
                                                    } else if (dkZ.bpO()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar8.dR("tid", PbFragment.this.lNh.dot());
                                                arVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar8.dR("fid", PbFragment.this.lNh.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar8.ap("obj_locate", 5);
                                                } else {
                                                    arVar8.ap("obj_locate", 6);
                                                }
                                                arVar8.ap("obj_name", i8);
                                                arVar8.ap("obj_type", 1);
                                                if (dkZ != null) {
                                                    if (dkZ.bmx()) {
                                                        arVar8.ap("obj_type", 10);
                                                    } else if (dkZ.bmy()) {
                                                        arVar8.ap("obj_type", 9);
                                                    } else if (dkZ.bpO()) {
                                                        arVar8.ap("obj_type", 8);
                                                    } else if (dkZ.bpN()) {
                                                        arVar8.ap("obj_type", 7);
                                                    } else if (dkZ.isShareThread) {
                                                        arVar8.ap("obj_type", 6);
                                                    } else if (dkZ.threadType == 0) {
                                                        arVar8.ap("obj_type", 1);
                                                    } else if (dkZ.threadType == 40) {
                                                        arVar8.ap("obj_type", 2);
                                                    } else if (dkZ.threadType == 49) {
                                                        arVar8.ap("obj_type", 3);
                                                    } else if (dkZ.threadType == 54) {
                                                        arVar8.ap("obj_type", 4);
                                                    } else {
                                                        arVar8.ap("obj_type", 5);
                                                    }
                                                    arVar8.ap(IntentConfig.CARD_TYPE, dkZ.bpR());
                                                    arVar8.dR(IntentConfig.RECOM_SOURCE, dkZ.mRecomSource);
                                                    arVar8.dR("ab_tag", dkZ.mRecomAbTag);
                                                    arVar8.dR("weight", dkZ.mRecomWeight);
                                                    arVar8.dR("extra", dkZ.mRecomExtra);
                                                    arVar8.dR(IntentConfig.NID, dkZ.bmo());
                                                    if (dkZ.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dkZ.getBaijiahaoData().oriUgcVid)) {
                                                        arVar8.dR("obj_param6", dkZ.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar8.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.doa() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.doa(), arVar8);
                                                }
                                                TiebaStatic.log(arVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dlb2 = PbFragment.this.lNh.getPbData().dlb();
                                                    if ((dlb2 != null && dlb2.size() > 0) || !PbFragment.this.lNh.dov()) {
                                                        PbFragment.this.lRD.drd();
                                                        PbFragment.this.cCU();
                                                        if (pbData.dlv() != null && !StringUtils.isNull(pbData.dlv().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", PbFragment.this.lNh.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dkZ)) {
                                                            if (PbFragment.this.lRD != null) {
                                                                PbFragment.this.lRD.drg();
                                                                PbFragment.this.lRD.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lRD.showLoadingDialog();
                                                                PbFragment.this.lNh.doZ().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i9 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i9 = 1;
                                                                }
                                                                PbFragment.this.FL(i9);
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
                                            PbFragment.this.lRD.drd();
                                            if (PbFragment.this.lRD.lYH.dsl() != null && view == PbFragment.this.lRD.lYH.dsl().dpG() && !PbFragment.this.lRD.drv()) {
                                                PbFragment.this.lRD.dql();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cCU();
                                                PbFragment.this.lRD.dqK();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    J = PbFragment.this.lNh.J(true, PbFragment.this.dnI());
                                                } else {
                                                    J = view.getId() == R.id.reply_title ? PbFragment.this.lNh.J(false, PbFragment.this.dnI()) : PbFragment.this.lNh.Py(PbFragment.this.dnI());
                                                }
                                                view.setTag(Boolean.valueOf(J));
                                                if (J) {
                                                    PbFragment.this.lRD.uS(true);
                                                    PbFragment.this.lRD.dqG();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lRD.vy(true);
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
                                        PbFragment.this.lRD.drd();
                                        if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                            if (PbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lNh.FV(PbFragment.this.lRD.dqP()) != null) {
                                                PbFragment.this.dnD();
                                                if (PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNh.lUN).dR("fid", PbFragment.this.lNh.getPbData().getForumId()).ap("obj_locate", 3).dR("uid", PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId()));
                                                }
                                                if (PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId() != null && PbFragment.this.lRB != null) {
                                                    int h = PbFragment.this.h(PbFragment.this.lNh.getPbData());
                                                    cb dkZ2 = PbFragment.this.lNh.getPbData().dkZ();
                                                    int i10 = 1;
                                                    if (dkZ2.bmx()) {
                                                        i10 = 2;
                                                    } else if (dkZ2.bmy()) {
                                                        i10 = 3;
                                                    } else if (dkZ2.bpN()) {
                                                        i10 = 4;
                                                    } else if (dkZ2.bpO()) {
                                                        i10 = 5;
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lNh.lUN).ap("obj_locate", 1).dR("obj_id", PbFragment.this.lNh.getPbData().dkZ().bnQ().getUserId()).ap("obj_type", PbFragment.this.lRB.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i10));
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.lRq = view;
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bmv() && PbFragment.this.lNh.getPbData().dkZ().boh() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lNh.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lNh.dmj()) || PbFragment.this.lNh.getAppealInfo() == null) {
                                            PbFragment.this.lQT.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lNh.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lNh.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lQT.finish();
                                        return;
                                    }
                                    String dmj2 = PbFragment.this.lNh.dmj();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lNh.dow() && dmj2 != null && dmj2.equals(name2)) {
                                        PbFragment.this.lQT.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lNh.getPbData() != null && !PbFragment.this.geq.dOs()) {
                                    PbFragment.this.lRD.drd();
                                    int i11 = 0;
                                    if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpH()) {
                                        if (PbFragment.this.lRD.lYH.dsl() == null || view != PbFragment.this.lRD.lYH.dsl().dpJ()) {
                                            if (view == PbFragment.this.lRD.dqI()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lNh.getPbData().dkZ().bnM() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lNh.getPbData().dkZ().bnL() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lNh.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lNh.getPbData().dkZ().getId();
                                    PbFragment.this.lRD.dqF();
                                    PbFragment.this.geq.c(id4, name3, id5, i11, PbFragment.this.lRD.dqJ());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lRD.lYH.dsk();
                            if (PbFragment.this.lNh != null) {
                                PbFragment.this.ixM.setThreadId(PbFragment.this.lNh.dot());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lNh == null || !PbFragment.this.lNh.isPrivacy()) {
                                PbFragment.this.ixM.crP();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dmq() != null && PbFragment.this.dmq().getPbData() != null && PbFragment.this.dmq().getPbData().getThreadId() != null && PbFragment.this.dmq().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dmq() != null && PbFragment.this.dmq().getPbData() != null) {
                                    PbFragment.this.ixM.k(3, i12, PbFragment.this.dmq().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dmq() != null && PbFragment.this.dmq().getPbData() != null) {
                                    PbFragment.this.ixM.k(3, 3, PbFragment.this.dmq().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lRD.drd();
                        PbFragment.this.cCU();
                        PbFragment.this.lRD.dqK();
                        PbFragment.this.lRD.showLoadingDialog();
                        if (PbFragment.this.lRD.dqu() != null) {
                            PbFragment.this.lRD.dqu().setVisibility(8);
                        }
                        PbFragment.this.lNh.FP(1);
                        if (PbFragment.this.lQW != null) {
                            PbFragment.this.lQW.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dnr = PbFragment.this.dnr();
                        if (!TextUtils.isEmpty(dnr)) {
                            bf.bsV().b(PbFragment.this.getPageContext(), new String[]{dnr});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar9 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar9.dR("tid", PbFragment.this.lNh.dot());
                arVar9.dR("fid", PbFragment.this.lNh.getForumId());
                arVar9.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar9.ap("obj_locate", 1);
                TiebaStatic.log(arVar9);
                if (PbFragment.this.lRf) {
                    PbFragment.this.lRf = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.dnk().dqi() != null && postData7.bnQ() != null && postData7.dNx() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dnk().dqj() != null) {
                                PbFragment.this.dnk().dqj().dna();
                            }
                            com.baidu.tieba.pb.data.q qVar2 = new com.baidu.tieba.pb.data.q();
                            qVar2.a(PbFragment.this.lNh.getPbData().getForum());
                            qVar2.setThreadData(PbFragment.this.lNh.getPbData().dkZ());
                            qVar2.g(postData7);
                            PbFragment.this.dnk().dqi().d(qVar2);
                            PbFragment.this.dnk().dqi().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bnQ().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lNh.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lRP != null) {
                                PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lSC = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lNh != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lNh.lUN)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lNh.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lNh.getPbData().getForumId());
                }
                arVar.dR("tid", PbFragment.this.lNh.dot());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cCU();
            PbFragment.this.lRD.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lNh.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNh.getPbData();
                            if (pbData != null && pbData.dkZ() != null && pbData.dkZ().bnQ() != null && (userId = pbData.dkZ().bnQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lNh.doG()) {
                                PbFragment.this.lRD.dqK();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lNh.doG()) {
                            PbFragment.this.lRD.dqK();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lRD.s(PbFragment.this.lNh.getPbData());
                    }
                    if (PbFragment.this.lNh.doA()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dR("tid", PbFragment.this.lNh.dot()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lRP.bCc() || PbFragment.this.lRP.bCd()) {
                    PbFragment.this.lRP.a(false, postWriteCallBackData);
                }
                PbFragment.this.kWo.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kSl != null) {
                    PbFragment.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Au(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d lSD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lNh.getPbData().getForumId());
                }
                if (PbFragment.this.lNh != null) {
                    arVar.dR("tid", PbFragment.this.lNh.dot());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kWo != null) {
                    PbFragment.this.kWo.drD();
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
                if (PbFragment.this.kSl != null) {
                    PbFragment.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
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
                    aVar.Au(PbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kWo != null) {
                if (PbFragment.this.lRD != null && PbFragment.this.lRD.dqj() != null && PbFragment.this.lRD.dqj().dne() != null && PbFragment.this.lRD.dqj().dne().bCd()) {
                    PbFragment.this.lRD.dqj().dne().a(postWriteCallBackData);
                }
                PbFragment.this.kWo.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lSE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dry;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lQT.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lRD != null && (dry = PbFragment.this.lRD.dry()) != null && PbFragment.this.lRD.getListView() != null) {
                            PbFragment.this.lRD.getListView().removeHeaderView(dry);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lSF = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qR;
            if (!z || fVar == null || fVar.dlm() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dlb()) >= 1) {
                PbFragment.this.llZ = true;
                PbFragment.this.lRD.dqM();
                if (fVar == null || !fVar.dlh()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lRD.getView());
                }
                PbFragment.this.lRD.dqH();
                if (PbFragment.this.isFullScreen || PbFragment.this.lRD.drv()) {
                    PbFragment.this.lRD.drm();
                } else if (!PbFragment.this.lRD.drj()) {
                    PbFragment.this.lRD.vK(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.glZ = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lRD.getView());
                    PbFragment.this.lRD.dqV();
                }
                if (z && fVar != null) {
                    cb dkZ = fVar.dkZ();
                    if (dkZ == null || !dkZ.bmz()) {
                        PbFragment.this.d(PbFragment.this.lRO);
                    } else {
                        doc();
                    }
                    PbFragment.this.lRD.dqj().setPbData(fVar);
                    PbFragment.this.lRD.bYh();
                    if (dkZ != null && dkZ.bpc() != null) {
                        PbFragment.this.a(dkZ.bpc());
                    }
                    if (PbFragment.this.lRP != null) {
                        PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dlb() != null && fVar.dlb().size() >= 1 && fVar.dlb().get(0) != null) {
                        PbFragment.this.lNh.PA(fVar.dlb().get(0).getId());
                    } else if (fVar.dlm() != null) {
                        PbFragment.this.lNh.PA(fVar.dlm().getId());
                    }
                    if (PbFragment.this.lRP != null) {
                        PbFragment.this.lRP.a(fVar.getAnti());
                        PbFragment.this.lRP.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lRP.setThreadData(dkZ);
                        PbFragment.this.lRP.a(PbFragment.this.lNh.doK(), PbFragment.this.lNh.dot(), PbFragment.this.lNh.dpb());
                        if (dkZ != null) {
                            PbFragment.this.lRP.kY(dkZ.bpp());
                        }
                    }
                    if (PbFragment.this.lRB != null) {
                        PbFragment.this.lRB.ja(fVar.bjZ());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dlC()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lRD.vJ(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lRD.a(fVar, i2, i3, PbFragment.this.lNh.dov(), i4, PbFragment.this.lNh.getIsFromMark());
                    PbFragment.this.lRD.d(fVar, PbFragment.this.lNh.dov());
                    PbFragment.this.lRD.vG(PbFragment.this.lNh.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fDL = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fDL) && PbFragment.this.lRP != null && PbFragment.this.lRP.bBh() != null && (qR = PbFragment.this.lRP.bBh().qR(6)) != null && !TextUtils.isEmpty(PbFragment.this.fDL)) {
                            ((View) qR).setOnClickListener(PbFragment.this.fEx);
                        }
                    }
                    if (PbFragment.this.lRK) {
                        PbFragment.this.lRK = false;
                        final int dnz = PbFragment.this.dnz();
                        if (!fVar.dlz()) {
                            PbFragment.this.lRD.Gc(dnz);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dnz, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lRL) {
                        PbFragment.this.lRL = false;
                        final int dnz2 = PbFragment.this.dnz();
                        final boolean z2 = dnz2 != -1;
                        if (!z2) {
                            dnz2 = PbFragment.this.dnA();
                        }
                        if (PbFragment.this.lRD != null) {
                            if (!fVar.dlz()) {
                                PbFragment.this.lRD.Gc(dnz2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dnz2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lRD.setSelectionFromTop(dnz2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lRD.setSelectionFromTop(dnz2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lRD.vL(true);
                                PbFragment.this.lRD.vK(false);
                            }
                        }
                    } else if (PbFragment.this.lRM) {
                        PbFragment.this.lRM = false;
                        PbFragment.this.lRD.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lRD.dqQ();
                    }
                    PbFragment.this.lNh.a(fVar.getForum(), PbFragment.this.lSq);
                    PbFragment.this.lNh.a(PbFragment.this.lSr);
                    if (PbFragment.this.kSl != null && dkZ != null && dkZ.bnQ() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dkZ.bnQ());
                        PbFragment.this.kSl.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.glZ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lNh.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lNh.getAppealInfo().lJQ)) {
                                    PbFragment.this.lRD.a(PbFragment.this.lNh.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lRD.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lRD.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lRD.drm();
                            PbFragment.this.lRD.dqU();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lNh.dot());
                            jSONObject.put("fid", PbFragment.this.lNh.getForumId());
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
                        PbFragment.this.lRD.PG("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                            arrayList = PbFragment.this.lNh.getPbData().dlb();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dNx() != 1)) {
                            PbFragment.this.lRD.PG(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dnT()) {
                                PbFragment.this.lRD.PH(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lRD.PH(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lRD.s(PbFragment.this.lNh.getPbData());
                        }
                    }
                    PbFragment.this.lRD.endLoadData();
                }
                if (fVar != null && fVar.lKf && PbFragment.this.fJu == 0) {
                    PbFragment.this.fJu = System.currentTimeMillis() - PbFragment.this.iIQ;
                }
                if (!PbFragment.this.dmq().dov() || PbFragment.this.dmq().getPbData().getPage().bmG() != 0 || PbFragment.this.dmq().doW()) {
                    PbFragment.this.lRQ = true;
                    return;
                }
                return;
            }
            PbFragment.this.lNh.FP(1);
            if (PbFragment.this.lQW != null) {
                PbFragment.this.lQW.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void doc() {
            if (PbFragment.this.lNh != null) {
                if (PbFragment.this.lRP == null || !PbFragment.this.lRP.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lRP = (com.baidu.tbadk.editortools.pb.e) dVar.fg(PbFragment.this.getContext());
                    PbFragment.this.lRP.a(PbFragment.this.lQT.getPageContext());
                    PbFragment.this.lRP.a(PbFragment.this.fDW);
                    PbFragment.this.lRP.a(PbFragment.this.fDO);
                    PbFragment.this.lRP.a(PbFragment.this.lQT.getPageContext(), PbFragment.this.lQT.getIntent() == null ? null : PbFragment.this.lQT.getIntent().getExtras());
                    PbFragment.this.lRP.bBh().kN(true);
                    PbFragment.this.lRD.setEditorTools(PbFragment.this.lRP.bBh());
                    if (!PbFragment.this.lNh.doB()) {
                        PbFragment.this.lRP.CX(PbFragment.this.lNh.dot());
                    }
                    if (PbFragment.this.lNh.dpc()) {
                        PbFragment.this.lRP.CV(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lRD != null) {
                        PbFragment.this.lRP.CV(PbFragment.this.lRD.dqn());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lRD.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iIQ : j;
                if (PbFragment.this.fJu == 0) {
                    PbFragment.this.fJu = currentTimeMillis;
                }
                com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, PbFragment.this.fJl, PbFragment.this.createTime, PbFragment.this.fJu, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fJl = 0L;
                if (hVar != null) {
                    hVar.bEd();
                }
                if (z2) {
                    hVar.fJD = currentTimeMillis;
                    hVar.lm(true);
                }
                if (!z2 && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null) {
                    int threadType = PbFragment.this.lNh.getPbData().dkZ().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.lRj, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.lRj, "from_frs")) {
                                com.baidu.tbadk.n.h hVar2 = new com.baidu.tbadk.n.h();
                                hVar2.setSubType(1000);
                                hVar2.fJF = currentTimeMillis;
                                hVar2.ru(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fJF = currentTimeMillis;
                        dVar.ru(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener lSG = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dnv();
            }
        }
    };
    private final a.InterfaceC0554a lSH = new a.InterfaceC0554a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
        public void g(boolean z, boolean z2, String str) {
            PbFragment.this.lRD.dqM();
            if (z) {
                if (PbFragment.this.lRB != null) {
                    PbFragment.this.lRB.ja(z2);
                }
                PbFragment.this.lNh.vo(z2);
                if (PbFragment.this.lNh.bjZ()) {
                    PbFragment.this.dnE();
                } else {
                    PbFragment.this.lRD.s(PbFragment.this.lNh.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lRB != null) {
                        if (PbFragment.this.lRB.bkc() != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lNh.getPbData().dkZ() != null && PbFragment.this.lNh.getPbData().dkZ().bnQ() != null) {
                            MarkData bkc = PbFragment.this.lRB.bkc();
                            MetaData bnQ = PbFragment.this.lNh.getPbData().dkZ().bnQ();
                            if (bkc != null && bnQ != null) {
                                if (!com.baidu.tbadk.core.util.au.equals(TbadkCoreApplication.getCurrentAccount(), bnQ.getUserId()) && !bnQ.hadConcerned()) {
                                    PbFragment.this.b(bnQ);
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
                    PbFragment.this.dnB();
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
            if (!PbFragment.this.Fy(PbFragment.this.mLastScrollState) && PbFragment.this.Fy(i)) {
                if (PbFragment.this.lRD != null) {
                    PbFragment.this.lRD.drd();
                    if (PbFragment.this.lRP != null && !PbFragment.this.lRD.dqm()) {
                        PbFragment.this.lRD.vI(PbFragment.this.lRP.bBV());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lRD.dql();
                    }
                }
                if (!PbFragment.this.lRc) {
                    PbFragment.this.lRc = true;
                }
            }
            if (PbFragment.this.lRD != null) {
                PbFragment.this.lRD.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lQW != null) {
                PbFragment.this.lQW.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lRd == null) {
                PbFragment.this.lRd = new com.baidu.tbadk.n.b();
                PbFragment.this.lRd.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lRd.bDZ();
            } else {
                PbFragment.this.lRd.bDY();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dMr().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dlb;
            if (PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null && PbFragment.this.lRD != null && PbFragment.this.lRD.dqD() != null) {
                PbFragment.this.lRD.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lQW != null) {
                    PbFragment.this.lQW.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lNh.doS() && (dlb = PbFragment.this.lNh.getPbData().dlb()) != null && !dlb.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lRD.dqD().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNh.getPbData();
                    if (pbData != null) {
                        if (pbData.dlc() != null && pbData.dlc().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dld() != null && pbData.dld().hasData()) {
                            headerCount--;
                        }
                        int size = dlb.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.e ixR = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.geq.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lNh.doP();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.mhl != 1002 || bVar.hkR) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lRD.a(1, dVar.mSuccess, dVar.nzx, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.geq.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lRD.a(PbFragment.this.geq.getLoadDataMode(), gVar.mSuccess, gVar.nzx, false);
                            PbFragment.this.lRD.aZ(gVar.nzA);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lRD.a(PbFragment.this.geq.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lSI = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c gjq = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dnJ()) {
                PbFragment.this.lQT.finish();
            }
            if (!PbFragment.this.lNh.vn(true)) {
                PbFragment.this.lRD.dqN();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lSK = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lSJ && PbFragment.this.dnJ()) {
                PbFragment.this.dnL();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lRx && PbFragment.this.lRD != null && PbFragment.this.lRD.drA() && PbFragment.this.lNh != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dR("tid", PbFragment.this.lNh.dot());
                    arVar.dR("fid", PbFragment.this.lNh.getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lNh.dow()) {
                        if (!PbFragment.this.lNh.doz()) {
                            if (PbFragment.this.lNh.doy()) {
                                i = 1;
                            }
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 4;
                    }
                    arVar.ap("obj_type", i);
                    TiebaStatic.log(arVar);
                    PbFragment.this.lRx = true;
                }
                if (PbFragment.this.lNh.vm(false)) {
                    PbFragment.this.lRD.dqL();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lNh.getPbData() != null) {
                    PbFragment.this.lRD.dri();
                }
                PbFragment.this.lSJ = true;
            }
        }
    };
    private int lSL = 0;
    private final TbRichTextView.i fUw = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dqD;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lRD.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dR("tid", PbFragment.this.lNh.dot());
                arVar.dR("fid", PbFragment.this.lNh.getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.ap("obj_locate", 3);
                arVar.ap("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lNh.lOq.dlC()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bHA() != null) {
                            ArrayList<TbRichTextImageInfo> bHA = tbRichTextView.getRichText().bHA();
                            int i4 = 0;
                            while (i4 < bHA.size()) {
                                if (bHA.get(i4) != null) {
                                    arrayList.add(bHA.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bHA.get(i4).getSrc()) || str.equals(bHA.get(i4).bHS()) || str.equals(bHA.get(i4).bHP()) || str.equals(bHA.get(i4).bHR()) || str.equals(bHA.get(i4).bHV()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bHA.get(i4).getSrc();
                                    imageUrlData.originalUrl = bHA.get(i4).getSrc();
                                    imageUrlData.isLongPic = bHA.get(i4).bHX();
                                    concurrentHashMap.put(bHA.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.f(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.s(arrayList).mQ(i3).jg(false).jh(PbFragment.this.lNh.doM()).d(concurrentHashMap).ji(true).jj(false).jk(PbFragment.this.dnT()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lNh != null) {
                            aVar.zO(PbFragment.this.lNh.getFromForumId());
                            if (PbFragment.this.lNh.getPbData() != null) {
                                aVar.s(PbFragment.this.lNh.getPbData().dkZ());
                            }
                        }
                        ImageViewerConfig eP = aVar.eP(PbFragment.this.getPageContext().getPageActivity());
                        eP.getIntent().putExtra("from", "pb");
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar2 = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar2);
                    if (aVar2.lNw) {
                        TbRichText bH = PbFragment.this.bH(str, i);
                        if (bH != null && PbFragment.this.lSL >= 0 && PbFragment.this.lSL < bH.bHz().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bH.bHz().get(PbFragment.this.lSL));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lNv.size()) {
                                    break;
                                } else if (!aVar2.lNv.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bH.getPostId() != 0 && (dqD = PbFragment.this.lRD.dqD()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dqD.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bH.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bH.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNh.dpb(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lNh.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.eJM.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.f(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.s(arrayList2).zJ(aVar2.forumName).zK(aVar2.forumId).zL(aVar2.threadId).jg(aVar2.eJK).ji(true).zM(aVar2.lastId).jh(PbFragment.this.lNh.doM()).d(concurrentHashMap2).jj(false).jk(PbFragment.this.dnT()).zN(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lNh != null) {
                                aVar3.zO(PbFragment.this.lNh.getFromForumId());
                                if (PbFragment.this.lNh.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lNh.getPbData().dkZ());
                                }
                            }
                            ImageViewerConfig eP2 = aVar3.eP(PbFragment.this.getPageContext().getPageActivity());
                            eP2.getIntent().putExtra("from", "pb");
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lNv, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eJM.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.s(arrayList3).zJ(aVar2.forumName).zK(aVar2.forumId).zL(aVar2.threadId).jg(aVar2.eJK).ji(true).zM(aVar2.lNv.get(0)).jh(PbFragment.this.lNh.doM()).d(concurrentHashMap3).jj(false).jk(PbFragment.this.dnT()).zN(aVar2.postId).jl(false);
                    if (PbFragment.this.lNh != null) {
                        aVar4.zO(PbFragment.this.lNh.getFromForumId());
                        if (PbFragment.this.lNh.getPbData() != null) {
                            aVar4.s(PbFragment.this.lNh.getPbData().dkZ());
                        }
                    }
                    ImageViewerConfig eP3 = aVar4.eP(PbFragment.this.getPageContext().getPageActivity());
                    eP3.getIntent().putExtra("from", "pb");
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                    return;
                }
                TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                boolean isGif = ((TbImageView) view).isGif();
                if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbFragment.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                }
                PbFragment.this.lRn = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lSM = false;
    PostData kpS = null;
    private final b.InterfaceC0558b lSN = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kpS != null) {
                if (i == 0) {
                    PbFragment.this.kpS.gW(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.kpS = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.kpS);
                }
            }
        }
    };
    private final b.InterfaceC0558b lSO = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lRZ != null && !TextUtils.isEmpty(PbFragment.this.lSa)) {
                if (i == 0) {
                    if (PbFragment.this.lSb == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lSa));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lSa;
                        aVar.pkgId = PbFragment.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lSb.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.eIQ == null) {
                            PbFragment.this.eIQ = new at(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.eIQ.p(PbFragment.this.lSa, PbFragment.this.lRZ.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lRZ = null;
                PbFragment.this.lSa = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lQU = true;
            return PbFragment.this.dF(view);
        }
    };
    private final NoNetworkView.a jdt = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lNh.doC()) {
                PbFragment.this.dnG();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.jlc.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0710a iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int hkx = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (aD(i2) && PbFragment.this.lRD != null && PbFragment.this.lQW != null) {
                PbFragment.this.lQW.qR(true);
                if (Math.abs(i2) > this.hkx) {
                    PbFragment.this.lQW.hideFloatingView();
                }
                if (PbFragment.this.dnJ()) {
                    PbFragment.this.lRD.dqA();
                    PbFragment.this.lRD.dqB();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (aD(i2) && PbFragment.this.lRD != null && PbFragment.this.lQW != null) {
                PbFragment.this.lRD.drn();
                PbFragment.this.lQW.qR(false);
                PbFragment.this.lQW.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }

        private boolean aD(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a lPX = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lRD.PI(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lSQ = -1;
    private int lSR = -1;

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

    public com.baidu.tbadk.editortools.pb.e dnf() {
        return this.lRP;
    }

    public void b(com.baidu.tieba.pb.data.q qVar) {
        boolean z;
        MetaData metaData;
        if (qVar.dlR() != null) {
            String id = qVar.dlR().getId();
            ArrayList<PostData> dlb = this.lNh.getPbData().dlb();
            int i = 0;
            while (true) {
                if (i >= dlb.size()) {
                    z = true;
                    break;
                }
                PostData postData = dlb.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dma = qVar.dma();
                    postData.JD(qVar.getTotalCount());
                    if (postData.dNu() == null || dma == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dma.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnQ() != null && (metaData = postData.getUserMap().get(next.bnQ().getUserId())) != null) {
                                next.a(metaData);
                                next.yw(true);
                                next.a(getPageContext(), this.lNh.Pz(metaData.getUserId()));
                            }
                        }
                        z = dma.size() != postData.dNu().size();
                        if (postData.dNu() != null && postData.dNu().size() < 2) {
                            postData.dNu().clear();
                            postData.dNu().addAll(dma);
                        }
                    }
                    if (postData.dNq() != null) {
                        postData.dNr();
                    }
                }
            }
            if (!this.lNh.getIsFromMark() && z) {
                this.lRD.s(this.lNh.getPbData());
            }
            if (z) {
                c(qVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o dlr = this.lNh.getPbData().dlr();
            if (dlr != null && str.equals(dlr.getAdId())) {
                if (dlr.dNl() != null) {
                    dlr.dNl().legoCard = null;
                }
                this.lNh.getPbData().dls();
            }
            com.baidu.tieba.tbadkCore.data.o doI = this.lNh.doI();
            if (doI != null && str.equals(doI.getAdId())) {
                this.lNh.doJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lRH != null && this.lRH.isShowing()) {
                this.lRH.dismiss();
                this.lRH = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lRH != null) {
                            PbFragment.this.lRH.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lRD.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lRX);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lRX);
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
                this.lRH = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lRH.QE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        cb dkZ;
        if (this.lNh != null && this.lNh.getPbData() != null && (dkZ = this.lNh.getPbData().dkZ()) != null) {
            if (i == 1) {
                PraiseData bnB = dkZ.bnB();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bnB == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dkZ.a(praiseData);
                    } else {
                        dkZ.bnB().getUser().add(0, metaData);
                        dkZ.bnB().setNum(dkZ.bnB().getNum() + 1);
                        dkZ.bnB().setIsLike(i);
                    }
                }
                if (dkZ.bnB() != null) {
                    if (dkZ.bnB().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dkZ.bnB().getNum());
                    }
                }
            } else if (dkZ.bnB() != null) {
                dkZ.bnB().setIsLike(i);
                dkZ.bnB().setNum(dkZ.bnB().getNum() - 1);
                ArrayList<MetaData> user = dkZ.bnB().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dkZ.bnB().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dkZ.bnB().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dkZ.bnB().getNum() + "";
                }
            }
            if (this.lNh.dov()) {
                this.lRD.dqD().notifyDataSetChanged();
            } else {
                this.lRD.t(this.lNh.getPbData());
            }
        }
    }

    public static PbFragment dng() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lQT = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lNh.aD(bundle);
        if (this.jgg != null) {
            this.jgg.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lRP.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lRb = System.currentTimeMillis();
        this.lRV = getPageContext();
        final Intent intent = this.lQT.getIntent();
        if (intent != null) {
            this.iIQ = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lRj = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lRj)) {
                    this.lRj = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lRj)) {
                this.lQX = true;
            }
            this.lSQ = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lSR = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lSS = intent.getStringExtra("key_manga_title");
            this.lRK = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lRL = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lRM = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dnJ()) {
                this.lQT.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.lSd = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lRv = new bk();
            this.lRv.D(intent);
            this.lSf = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lSf == 0) {
                this.lSf = intent.getIntExtra("key_start_from", 0);
            }
            this.lSg = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iIQ = System.currentTimeMillis();
        }
        this.fJl = this.lRb - this.iIQ;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lQZ = 0;
        aC(bundle);
        if (this.lNh.getPbData() != null) {
            this.lNh.getPbData().Pl(this.source);
        }
        dnj();
        if (intent != null && this.lRD != null) {
            this.lRD.lYF = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lRY == null) {
                    this.lRY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lRD.PK("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lRY, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lNh.getPbData() != null) {
                this.lNh.PC(stringExtra);
            }
        }
        this.jgg = new VoiceManager();
        this.jgg.onCreate(getPageContext());
        initData(bundle);
        this.lRO = new com.baidu.tbadk.editortools.pb.g();
        d(this.lRO);
        this.lRP = (com.baidu.tbadk.editortools.pb.e) this.lRO.fg(getActivity());
        this.lRP.a(this.lQT.getPageContext());
        this.lRP.a(this.fDW);
        this.lRP.a(this.fDO);
        this.lRP.setFrom(1);
        this.lRP.a(this.lQT.getPageContext(), bundle);
        this.lRP.bBh().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lRP.bBh().kN(true);
        uY(true);
        this.lRP.a(this.lNh.doK(), this.lNh.dot(), this.lNh.dpb());
        registerListener(this.lSl);
        if (!this.lNh.doB()) {
            this.lRP.CX(this.lNh.dot());
        }
        if (this.lNh.dpc()) {
            this.lRP.CV(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lRD != null) {
            this.lRP.CV(this.lRD.dqn());
        }
        registerListener(this.lSk);
        registerListener(this.lSm);
        registerListener(this.lSn);
        registerListener(this.jhN);
        registerListener(this.lSz);
        registerListener(this.lSj);
        this.lRN = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nvT);
        this.lRN.dNa();
        registerListener(this.lSo);
        registerListener(this.faJ);
        this.lNh.doU();
        registerListener(this.lSG);
        registerListener(this.jhV);
        registerListener(this.lSC);
        if (this.lRD != null && this.lRD.drr() != null && this.lRD.drs() != null) {
            this.lQW = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lRD.drr(), this.lRD.drs(), this.lRD.dqu());
            this.lQW.a(this.lSu);
        }
        if (this.lQV && this.lRD != null && this.lRD.drs() != null) {
            this.lRD.drs().setVisibility(8);
        }
        this.lRW = new com.baidu.tbadk.core.view.c();
        this.lRW.toastTime = 1000L;
        registerListener(this.lSy);
        registerListener(this.lSw);
        registerListener(this.lSx);
        registerListener(this.jpm);
        registerListener(this.jhJ);
        this.lSp.setSelfListener(true);
        this.lSp.setTag(this.lQT.getUniqueId());
        this.lSp.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lSp);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lRX = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lRX;
        userMuteAddAndDelCustomMessage.setTag(this.lRX);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lRX;
        userMuteCheckCustomMessage.setTag(this.lRX);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lNh.doZ().a(this.lSv);
        this.kWo = new ar();
        if (this.lRP.bBN() != null) {
            this.kWo.f(this.lRP.bBN().getInputView());
        }
        this.lRP.a(this.fDP);
        this.jCj = new ShareSuccessReplyToServerModel();
        a(this.lSh);
        this.kSl = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kSl.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.faA) {
                        PbFragment.this.lRP.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.faB && PbFragment.this.lRD != null && PbFragment.this.lRD.dqj() != null && PbFragment.this.lRD.dqj().dne() != null) {
                        PbFragment.this.lRD.dqj().dne().bCm();
                    } else if (i == com.baidu.tbadk.core.util.am.faC) {
                        PbFragment.this.c(PbFragment.this.lRS);
                    }
                }
            }
        });
        this.lRA = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lRA.x(getUniqueId());
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        com.baidu.tbadk.core.business.b.blh().dC("3", "");
        this.ixM = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lRb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lNh != null) {
            gVar.setForumName(this.lNh.dmj());
            if (this.lNh.getPbData() != null && this.lNh.getPbData().getForum() != null) {
                gVar.a(this.lNh.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lNh);
        }
    }

    public String dnh() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dni() {
        return this.lQW;
    }

    private void uY(boolean z) {
        this.lRP.kV(z);
        this.lRP.kW(z);
        this.lRP.kX(z);
    }

    private void dnj() {
        this.fnw = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jgg != null) {
            this.jgg.onStart(getPageContext());
        }
    }

    public ap dnk() {
        return this.lRD;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmq() {
        return this.lNh;
    }

    public void Ps(String str) {
        if (this.lNh != null && !StringUtils.isNull(str) && this.lRD != null) {
            this.lRD.vN(true);
            this.lNh.Ps(str);
            this.lRh = true;
            this.lRD.drd();
            this.lRD.drm();
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
        this.lQZ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lQZ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jgg != null) {
            this.jgg.onPause(getPageContext());
        }
        if (this.lRD != null) {
            this.lRD.onPause();
        }
        if (!this.lNh.doB()) {
            this.lRP.CW(this.lNh.dot());
        }
        if (this.lNh != null) {
            this.lNh.doV();
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        MessageManager.getInstance().unRegisterListener(this.juD);
        cSL();
        MessageManager.getInstance().unRegisterListener(this.lSw);
        MessageManager.getInstance().unRegisterListener(this.lSx);
        MessageManager.getInstance().unRegisterListener(this.lSy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dnl() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lNh.getPbData(), this.lNh.dov(), this.lNh.doT());
        return (a2 == null || a2.bnQ() == null || a2.bnQ().getGodUserData() == null || a2.bnQ().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lRl) {
            this.lRl = false;
            dnP();
        }
        if (dnl()) {
            this.lRe = System.currentTimeMillis();
        } else {
            this.lRe = -1L;
        }
        if (this.lRD != null && this.lRD.getView() != null) {
            if (!this.llZ) {
                dnH();
            } else {
                hideLoadingView(this.lRD.getView());
            }
            this.lRD.onResume();
        }
        if (this.lQZ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lRD != null) {
            noNetworkView = this.lRD.dqg();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jgg != null) {
            this.jgg.onResume(getPageContext());
        }
        registerListener(this.juD);
        this.lRJ = false;
        dnO();
        registerListener(this.lSw);
        registerListener(this.lSx);
        registerListener(this.lSy);
        if (this.jgU) {
            dnG();
            this.jgU = false;
        }
        dnW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lRD.vC(z);
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
        if (z && this.lRJ) {
            this.lRD.dqL();
            this.lNh.vm(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lRe > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dR("obj_duration", (System.currentTimeMillis() - this.lRe) + ""));
            this.lRe = 0L;
        }
        if (dnk().dqj() != null) {
            dnk().dqj().onStop();
        }
        if (this.lRD.lYH != null && !this.lRD.lYH.dsn()) {
            this.lRD.lYH.daX();
        }
        if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().getForum() != null && this.lNh.getPbData().dkZ() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "pb", this.lNh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNh.getPbData().dkZ().getId(), 0L));
        }
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lRw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", this.lNh.getPbData().getForumId());
            arVar.dR("tid", this.lNh.dot());
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lRc && this.lRD != null) {
            this.lRc = true;
            a(false, (PostData) null);
        }
        if (this.lNh != null) {
            this.lNh.cancelLoadData();
            this.lNh.destory();
            if (this.lNh.doY() != null) {
                this.lNh.doY().onDestroy();
            }
        }
        if (this.lRP != null) {
            this.lRP.onDestroy();
        }
        if (this.geq != null) {
            this.geq.cancelLoadData();
        }
        if (this.fnw != null) {
            this.fnw.dMN();
        }
        if (this.lRD != null) {
            this.lRD.onDestroy();
            if (this.lRD.lYH != null) {
                this.lRD.lYH.daX();
            }
        }
        if (this.lRd != null) {
            this.lRd.bEa();
        }
        if (this.lQW != null) {
            this.lQW.cEM();
        }
        super.onDestroy();
        if (this.jgg != null) {
            this.jgg.onDestory(getPageContext());
        }
        if (this.lRD != null) {
            this.lRD.drd();
        }
        MessageManager.getInstance().unRegisterListener(this.lSw);
        MessageManager.getInstance().unRegisterListener(this.lSx);
        MessageManager.getInstance().unRegisterListener(this.lSy);
        MessageManager.getInstance().unRegisterListener(this.lRX);
        MessageManager.getInstance().unRegisterListener(this.lSz);
        MessageManager.getInstance().unRegisterListener(this.jhV);
        MessageManager.getInstance().unRegisterListener(this.jpm);
        MessageManager.getInstance().unRegisterListener(this.lSE);
        MessageManager.getInstance().unRegisterListener(this.lSp);
        this.lRV = null;
        this.lRW = null;
        com.baidu.tieba.recapp.c.a.dEe().dEh();
        if (this.lRY != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lRY);
        }
        if (this.lRm != null) {
            this.lRm.cancelLoadData();
        }
        if (this.lRD != null && this.lRD.lYH != null) {
            this.lRD.lYH.dsr();
        }
        if (this.jCj != null) {
            this.jCj.cancelLoadData();
        }
        this.kWo.onDestroy();
        if (this.lNh != null && this.lNh.dpa() != null) {
            this.lNh.dpa().onDestroy();
        }
        if (this.kSl != null) {
            this.kSl.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dqD;
        ArrayList<PostData> dmO;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bvY() && this.lRD != null && (dqD = this.lRD.dqD()) != null && (dmO = dqD.dmO()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dmO.iterator();
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
                        bVar.iAe = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eRW == 1 && !TextUtils.isEmpty(id)) {
                    next.eRW = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.iAe = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lNh == null || this.lNh.getPbData() == null || this.lNh.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lNh.getPbData().getForum().getFirst_class();
                    str3 = this.lNh.getPbData().getForum().getSecond_class();
                    String id2 = this.lNh.getPbData().getForum().getId();
                    str = this.lNh.dot();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.s.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bwb());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lRD.onChangeSkinType(i);
            if (this.lRP != null && this.lRP.bBh() != null) {
                this.lRP.bBh().onChangeSkinType(i);
            }
            if (this.lRD.dqg() != null) {
                this.lRD.dqg().onChangeSkinType(getPageContext(), i);
            }
            this.kWo.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cCU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lRD = new ap(this, this.jiV, this.fvK);
        this.jlc = new com.baidu.tieba.f.b(getActivity());
        this.jlc.a(lSP);
        this.jlc.a(this.iFe);
        this.lRD.setOnScrollListener(this.mOnScrollListener);
        this.lRD.d(this.lSK);
        this.lRD.setListPullRefreshListener(this.gjq);
        this.lRD.uJ(com.baidu.tbadk.core.k.bkT().isShowImages());
        this.lRD.setOnImageClickListener(this.fUw);
        this.lRD.b(this.mOnLongClickListener);
        this.lRD.g(this.jdt);
        this.lRD.a(this.lSI);
        this.lRD.vC(this.mIsLogin);
        if (this.lQT.getIntent() != null) {
            this.lRD.vO(this.lQT.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lRD.dqi().setFromForumId(this.lNh.getFromForumId());
        this.lRD.setEditorTools(this.lRP.bBh());
        this.lRP.CV(this.lRD.dqn());
        this.lRD.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lNh.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNh.getPbData().getForum().getId(), PbFragment.this.lNh.getPbData().getForum().getName(), PbFragment.this.lNh.getPbData().dkZ().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lRD.vP(this.lNh.doy());
        this.lRD.FW(this.lNh.dpe());
        return this.lRD.getView();
    }

    public void dnm() {
        if (this.lRD != null && this.lNh != null) {
            if ((this.lNh.getPbData() != null || this.lNh.getPbData().dly() != null) && checkUpIsLogin() && this.lRD.dqD() != null && this.lRD.dqD().dmT() != null) {
                this.lRD.dqD().dmT().BE(this.lNh.dot());
            }
        }
    }

    public void dnn() {
        TiebaStatic.log("c12181");
        if (this.lRD != null && this.lNh != null) {
            if ((this.lRD == null || this.lRD.dqm()) && this.lNh.getPbData() != null && this.lNh.getPbData().dly() != null) {
                com.baidu.tieba.pb.data.p dly = this.lNh.getPbData().dly();
                if (checkUpIsLogin()) {
                    if ((!dly.dlT() || dly.bpt() != 2) && this.lRD.dqD() != null && this.lRD.dqD().dmT() != null) {
                        this.lRD.dqD().dmT().BE(this.lNh.dot());
                    }
                    if (System.currentTimeMillis() - this.lRg > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wA(false);
                        this.lRg = System.currentTimeMillis();
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
                if (postData.getType() != PostData.eQE && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkT().isShowImages()) {
                    return Pv(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lNh == null || this.lNh.getPbData() == null) {
                        return true;
                    }
                    if (dnk().dqj() != null) {
                        dnk().dqj().dna();
                    }
                    com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                    qVar.a(this.lNh.getPbData().getForum());
                    qVar.setThreadData(this.lNh.getPbData().dkZ());
                    qVar.g(postData);
                    dnk().dqi().d(qVar);
                    dnk().dqi().setPostId(postData.getId());
                    a(view, postData.bnQ().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lRP != null) {
                        this.lRD.vI(this.lRP.bBV());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dno() {
        if (this.lRa == null) {
            this.lRa = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lRa.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lNd = PbFragment.this.lNd.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNd);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lNh.dot(), PbFragment.this.lNd, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lNd = PbFragment.this.lNd.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNd);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lNh.dot(), PbFragment.this.lNd, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lNd = PbFragment.this.lNd.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNd);
                        bVar.dismiss();
                    }
                }
            }).nD(b.a.BOTTOM_TO_TOP).nE(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.lSF.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).dur(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lNh = this.lQT.dmq();
        if (this.lNh.doX() != null) {
            this.lNh.doX().a(this.lPX);
        }
        if (this.lNh.doY() != null) {
            this.lNh.doY().b(this.lSi);
        }
        if (StringUtils.isNull(this.lNh.dot())) {
            this.lQT.finish();
        } else if ("from_tieba_kuang".equals(this.lRj) && this.lRj != null) {
            this.lNh.FW(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lRB = com.baidu.tbadk.baseEditMark.a.a(this.lQT);
        if (this.lRB != null) {
            this.lRB.a(this.lSH);
        }
        this.geq = new ForumManageModel(this.lQT);
        this.geq.setLoadDataCallBack(this.ixR);
        this.faF = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lSt.setUniqueId(getUniqueId());
        this.lSt.registerListener();
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lRD.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lRX;
        userMuteCheckCustomMessage.setTag(this.lRX);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14000").dR("tid", this.lNh.lUN).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gk(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lQU ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dnp() {
        if (this.lNh == null || this.lNh.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lNh.getPbData().dkZ()) || AntiHelper.a(getPageContext(), this.lNh.getPbData().getAnti());
    }

    public void dnq() {
        if (checkUpIsLogin() && this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().getForum() != null && !dnp()) {
            if (this.lNh.getPbData().dlC()) {
                this.lRD.cSm();
                return;
            }
            if (this.jkC == null) {
                this.jkC = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jkC.Ae(0);
                this.jkC.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (PbFragment.this.lRP != null && PbFragment.this.lRP.bBh() != null) {
                                PbFragment.this.lRP.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lRD.cSm();
                        }
                    }
                });
            }
            this.jkC.G(this.lNh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNh.dot(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnr() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lNh == null || (pbData = this.lNh.getPbData()) == null) {
            return null;
        }
        return pbData.dln().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            if (fVar.dkZ().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dkZ().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dkZ().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnp() && dnt()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lRr);
                this.lRs = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dnk().dqj() != null && postData != null) {
                String str3 = "";
                if (postData.dNz() != null) {
                    str3 = postData.dNz().toString();
                }
                dnk().dqj().Pq(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnQ().getName_show(), str3));
            }
            if (this.lNh.getPbData() != null && this.lNh.getPbData().dlC()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lQT.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dnk().getListView().smoothScrollBy((PbFragment.this.lRr[1] + PbFragment.this.lRs) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnk().dqj() != null) {
                            PbFragment.this.lRP.bBh().setVisibility(8);
                            PbFragment.this.dnk().dqj().j(str, str2, PbFragment.this.dnk().dqn(), (PbFragment.this.lNh == null || PbFragment.this.lNh.getPbData() == null || PbFragment.this.lNh.getPbData().dkZ() == null || !PbFragment.this.lNh.getPbData().dkZ().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dne = PbFragment.this.dnk().dqj().dne();
                            if (dne != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                dne.a(PbFragment.this.lNh.getPbData().getAnti());
                                dne.setThreadData(PbFragment.this.lNh.getPbData().dkZ());
                            }
                            if (PbFragment.this.kWo.drH() == null && PbFragment.this.dnk().dqj().dne().bCu() != null) {
                                PbFragment.this.dnk().dqj().dne().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kWo != null && PbFragment.this.kWo.drG() != null) {
                                            if (!PbFragment.this.kWo.drG().dWq()) {
                                                PbFragment.this.kWo.vR(false);
                                            }
                                            PbFragment.this.kWo.drG().zu(false);
                                        }
                                    }
                                });
                                PbFragment.this.kWo.g(PbFragment.this.dnk().dqj().dne().bCu().getInputView());
                                PbFragment.this.dnk().dqj().dne().a(PbFragment.this.lRU);
                            }
                        }
                        PbFragment.this.dnk().drm();
                    }
                }, 0L);
                return;
            }
            if (this.lRR == null) {
                this.lRR = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lRR.Ae(1);
                this.lRR.a(new AnonymousClass39(str, str2));
            }
            if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().getForum() != null) {
                this.lRR.G(this.lNh.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNh.dot(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lSY;
        final /* synthetic */ String lSZ;

        AnonymousClass39(String str, String str2) {
            this.lSY = str;
            this.lSZ = str2;
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
                        PbFragment.this.dnk().getListView().smoothScrollBy((PbFragment.this.lRr[1] + PbFragment.this.lRs) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnk().dqj() != null) {
                            PbFragment.this.lRP.bBh().setVisibility(8);
                            PbFragment.this.dnk().dqj().j(AnonymousClass39.this.lSY, AnonymousClass39.this.lSZ, PbFragment.this.dnk().dqn(), (PbFragment.this.lNh == null || PbFragment.this.lNh.getPbData() == null || PbFragment.this.lNh.getPbData().dkZ() == null || !PbFragment.this.lNh.getPbData().dkZ().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dne = PbFragment.this.dnk().dqj().dne();
                            if (dne != null && PbFragment.this.lNh != null && PbFragment.this.lNh.getPbData() != null) {
                                dne.a(PbFragment.this.lNh.getPbData().getAnti());
                                dne.setThreadData(PbFragment.this.lNh.getPbData().dkZ());
                            }
                            if (PbFragment.this.kWo.drH() == null && PbFragment.this.dnk().dqj().dne().bCu() != null) {
                                PbFragment.this.dnk().dqj().dne().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kWo != null && PbFragment.this.kWo.drG() != null) {
                                            if (!PbFragment.this.kWo.drG().dWq()) {
                                                PbFragment.this.kWo.vR(false);
                                            }
                                            PbFragment.this.kWo.drG().zu(false);
                                        }
                                    }
                                });
                                PbFragment.this.kWo.g(PbFragment.this.dnk().dqj().dne().bCu().getInputView());
                                PbFragment.this.dnk().dqj().dne().a(PbFragment.this.lRU);
                            }
                        }
                        PbFragment.this.dnk().drm();
                    }
                }, 0L);
            }
        }
    }

    public boolean dnt() {
        if ((this.lNh.getPbData() != null && this.lNh.getPbData().dlC()) || this.kSl == null || this.lNh.getPbData() == null || this.lNh.getPbData().getAnti() == null) {
            return true;
        }
        return this.kSl.ox(this.lNh.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean FI(int i) {
        if (this.kSl == null || this.lNh.getPbData() == null || this.lNh.getPbData().getAnti() == null) {
            return true;
        }
        return this.kSl.aK(this.lNh.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lNh != null && this.lNh.getPbData() != null && postData.dNx() != 1) {
            String dot = this.lNh.dot();
            String id = postData.getId();
            int i = 0;
            if (this.lNh.getPbData() != null) {
                i = this.lNh.getPbData().dlo();
            }
            PbActivity.a Pw = Pw(id);
            if (Pw != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dot, id, "pb", true, null, false, null, i, postData.dtl(), this.lNh.getPbData().getAnti(), false, postData.bnQ() != null ? postData.bnQ().getIconInfo() : null).addBigImageData(Pw.lNv, Pw.eJM, Pw.eJK, Pw.index);
                addBigImageData.setKeyPageStartFrom(this.lNh.dpe());
                addBigImageData.setFromFrsForumId(this.lNh.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lNh.getForumId());
                addBigImageData.setBjhData(this.lNh.doD());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnu() {
        if (this.lNh.getPbData() == null || this.lNh.getPbData().dkZ() == null) {
            return -1;
        }
        return this.lNh.getPbData().dkZ().boC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dmq() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dmq().PB(postWriteCallBackData.getPostId());
            this.lSc = this.lRD.dqp();
            this.lNh.cZ(this.lSc, this.lRD.dqq());
        }
        this.lRD.drd();
        this.kWo.drE();
        if (this.lRP != null) {
            this.lRD.vI(this.lRP.bBV());
        }
        this.lRD.dqh();
        this.lRD.vK(true);
        this.lNh.doP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (this.lNh != null && this.lNh.lOq != null && this.lNh.lOq.dkZ() != null) {
            cb dkZ = this.lNh.lOq.dkZ();
            dkZ.mRecomAbTag = this.lNh.dpp();
            dkZ.mRecomWeight = this.lNh.dpn();
            dkZ.mRecomSource = this.lNh.dpo();
            dkZ.mRecomExtra = this.lNh.dpq();
            if (dkZ.getFid() == 0) {
                dkZ.setFid(com.baidu.adp.lib.f.b.toLong(this.lNh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dkZ, "c13563");
            TbPageTag ft = com.baidu.tbadk.pageInfo.c.ft(getContext());
            if (ft != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(ft.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (ft != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(ft.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.ap("reply_type", 1);
                if (z) {
                    a2.ap("obj_type", 2);
                } else {
                    a2.ap("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
                if (fq != null) {
                    a2.dR("obj_cur_page", fq.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                    a2.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnv() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.So(this.lNh.getForumId()) && this.lNh.getPbData() != null && this.lNh.getPbData().getForum() != null) {
            if (this.lNh.getPbData().getForum().isLike() == 1) {
                this.lNh.dpa().gp(this.lNh.getForumId(), this.lNh.dot());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.lNh == null || this.lNh.getPbData() == null) {
            return false;
        }
        return ((this.lNh.getPbData().dlo() != 0) || this.lNh.getPbData().dkZ() == null || this.lNh.getPbData().dkZ().bnQ() == null || TextUtils.equals(this.lNh.getPbData().dkZ().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean vb(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ad adVar;
        if (this.lNh == null || this.lNh.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
        cb dkZ = pbData.dkZ();
        if (dkZ != null) {
            if (dkZ.bmx() || dkZ.bmy()) {
                return false;
            }
            if (dkZ.bpN() || dkZ.bpO()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dkZ == null || dkZ.bnQ() == null || !dkZ.bnQ().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlo() != 0) {
                    return pbData.dlo() != 3;
                }
                List<bx> dlw = pbData.dlw();
                if (com.baidu.tbadk.core.util.y.getCount(dlw) > 0) {
                    for (bx bxVar : dlw) {
                        if (bxVar != null && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
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
        if (z || this.lNh == null || this.lNh.getPbData() == null) {
            return false;
        }
        if (this.lNh.getPbData().getForum() == null || !this.lNh.getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
            return ((pbData.dkZ() != null && pbData.dkZ().bnQ() != null && pbData.dkZ().bnQ().isForumBusinessAccount() && !com.baidu.tieba.frs.au.isOn()) || this.lNh.getPbData().dlo() == 0 || this.lNh.getPbData().dlo() == 3) ? false : true;
        }
        return false;
    }

    public void dnw() {
        com.baidu.tieba.pb.data.f pbData;
        cb dkZ;
        boolean z = true;
        if (this.lNh != null && this.lNh.getPbData() != null && (dkZ = (pbData = this.lNh.getPbData()).dkZ()) != null && dkZ.bnQ() != null) {
            this.lRD.dqh();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dkZ.bnQ().getUserId());
            ad adVar = new ad();
            int dlo = this.lNh.getPbData().dlo();
            if (dlo == 1 || dlo == 3) {
                adVar.lWV = true;
                adVar.lXb = dkZ.bnL() == 1;
            } else {
                adVar.lWV = false;
            }
            if (FJ(dlo)) {
                adVar.lWW = true;
                adVar.lXa = dkZ.bnM() == 1;
            } else {
                adVar.lWW = false;
            }
            if (dlo == 1002 && !equals) {
                adVar.lXc = true;
            }
            adVar.lWT = vb(equals);
            adVar.lWX = dnx();
            adVar.lWU = vc(equals);
            adVar.FD = this.lNh.dov();
            adVar.lWQ = true;
            adVar.lWP = va(equals);
            adVar.lWO = equals && this.lRD.dqS();
            adVar.lWZ = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lWY = true;
            adVar.isHostOnly = this.lNh.getHostMode();
            adVar.lWS = true;
            if (dkZ.boh() == null) {
                adVar.lWR = true;
            } else {
                adVar.lWR = false;
            }
            if (pbData.dlC()) {
                adVar.lWQ = false;
                adVar.lWS = false;
                adVar.lWR = false;
                adVar.lWV = false;
                adVar.lWW = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlC()) {
                z = false;
            }
            adVar.lXd = z;
            if (this.lRD != null) {
                PostData b2 = this.lRD.b(this.lNh.lOq, this.lNh.dov());
                adVar.eVr = b2 != null ? b2.nxk : false;
            }
            this.lRD.lYH.a(adVar);
        }
    }

    private boolean dnx() {
        if (this.lNh != null && this.lNh.dov()) {
            return this.lNh.getPageData() == null || this.lNh.getPageData().bmG() != 0;
        }
        return false;
    }

    public boolean FJ(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lNh.getPbData().getUserData() == null || (forumToolAuth = this.lNh.getPbData().getUserData().getForumToolAuth()) == null) {
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
    public PbModel.a dny() {
        return this.lSF;
    }

    public int dnz() {
        if (dnk() == null || dnk().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnk().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.o) && ((com.baidu.tieba.pb.data.o) nVar).Wm == com.baidu.tieba.pb.data.o.lLr) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnA() {
        if (dnk() == null || dnk().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnk().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nwy) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dnG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnB() {
        if (this.lNh != null && this.lNh.lOq != null && this.lNh.lOq.dkZ() != null) {
            cb dkZ = this.lNh.lOq.dkZ();
            dkZ.mRecomAbTag = this.lNh.dpp();
            dkZ.mRecomWeight = this.lNh.dpn();
            dkZ.mRecomSource = this.lNh.dpo();
            dkZ.mRecomExtra = this.lNh.dpq();
            dkZ.eUg = this.lNh.doB();
            if (dkZ.getFid() == 0) {
                dkZ.setFid(com.baidu.adp.lib.f.b.toLong(this.lNh.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dkZ, "c13562");
            TbPageTag ft = com.baidu.tbadk.pageInfo.c.ft(getContext());
            if (ft != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(ft.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (ft != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(ft.locatePage)) {
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
            aVar.At(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Au(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jF(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.faF.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lNh.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bqx();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lRD.dqM();
        this.lNh.vo(z);
        if (this.lRB != null) {
            this.lRB.ja(z);
            if (markData != null) {
                this.lRB.a(markData);
            }
        }
        if (this.lNh.bjZ()) {
            dnE();
        } else {
            this.lRD.s(this.lNh.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fy(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pt(String str) {
        if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().dlC()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lNh.dot(), str);
            cb dkZ = this.lNh.getPbData().dkZ();
            if (dkZ.bmx()) {
                format = format + "&channelid=33833";
            } else if (dkZ.bpM()) {
                format = format + "&channelid=33842";
            } else if (dkZ.bmy()) {
                format = format + "&channelid=33840";
            }
            Pu(format);
            return;
        }
        this.lRA.PU(str);
    }

    private void Pu(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lNh.doB()) {
                    antiData.setBlock_forum_name(this.lNh.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lNh.getPbData().getForum().getId());
                    antiData.setUser_name(this.lNh.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lNh.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dnk() != null) {
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
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            Dc(str);
        } else {
            this.lRD.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.nzx) ? bVar.nzx : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.Au(string);
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
                aVar.bqx();
            } else {
                this.lRD.a(0, bVar.mSuccess, bVar.nzx, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iNf == 1) {
                    ArrayList<PostData> dlb = this.lNh.getPbData().dlb();
                    int size = dlb.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dlb.get(i).getId())) {
                            i++;
                        } else {
                            dlb.remove(i);
                            break;
                        }
                    }
                    this.lNh.getPbData().dkZ().nk(this.lNh.getPbData().dkZ().bnH() - 1);
                    this.lRD.s(this.lNh.getPbData());
                } else if (bVar.iNf == 0) {
                    dnC();
                } else if (bVar.iNf == 2) {
                    ArrayList<PostData> dlb2 = this.lNh.getPbData().dlb();
                    int size2 = dlb2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dlb2.get(i2).dNu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dlb2.get(i2).dNu().get(i3).getId())) {
                                i3++;
                            } else {
                                dlb2.get(i2).dNu().remove(i3);
                                dlb2.get(i2).dNw();
                                z2 = true;
                                break;
                            }
                        }
                        dlb2.get(i2).Te(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lRD.s(this.lNh.getPbData());
                    }
                    a(bVar, this.lRD);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lRD.a(this.geq.getLoadDataMode(), gVar.mSuccess, gVar.nzx, false);
            if (gVar.mSuccess) {
                this.lRE = true;
                if (i == 2 || i == 3) {
                    this.lRF = true;
                    this.lRG = false;
                } else if (i == 4 || i == 5) {
                    this.lRF = false;
                    this.lRG = true;
                }
                if (i == 2) {
                    this.lNh.getPbData().dkZ().nn(1);
                    this.lNh.setIsGood(1);
                } else if (i == 3) {
                    this.lNh.getPbData().dkZ().nn(0);
                    this.lNh.setIsGood(0);
                } else if (i == 4) {
                    this.lNh.getPbData().dkZ().nm(1);
                    this.lNh.FO(1);
                } else if (i == 5) {
                    this.lNh.getPbData().dkZ().nm(0);
                    this.lNh.FO(0);
                }
                this.lRD.c(this.lNh.getPbData(), this.lNh.dov());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.nzx)) {
                string = gVar.nzx;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dnC() {
        if (this.lNh.dow() || this.lNh.doy()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lNh.dot());
            PbActivity pbActivity = this.lQT;
            PbActivity pbActivity2 = this.lQT;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lNh.dot()));
        if (dnF()) {
            this.lQT.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmE() {
        this.lQT.dmE();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dll;
        boolean z = false;
        if (this.lRD != null) {
            this.lRD.drd();
        }
        if (this.lNh != null && this.lNh.getPbData() != null && !this.lNh.getPbData().dlC()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lNh.getPbData().dkZ().getId();
            if (this.lNh.isShareThread() && this.lNh.getPbData().dkZ().eTc != null) {
                historyMessage.threadName = this.lNh.getPbData().dkZ().eTc.showText;
            } else {
                historyMessage.threadName = this.lNh.getPbData().dkZ().getTitle();
            }
            if (this.lNh.isShareThread() && !dmi()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lNh.getPbData().getForum().getName();
            }
            ArrayList<PostData> dlb = this.lNh.getPbData().dlb();
            int dqO = this.lRD != null ? this.lRD.dqO() : 0;
            if (dlb != null && dqO >= 0 && dqO < dlb.size()) {
                historyMessage.postID = dlb.get(dqO).getId();
            }
            historyMessage.isHostOnly = this.lNh.getHostMode();
            historyMessage.isSquence = this.lNh.dov();
            historyMessage.isShareThread = this.lNh.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lRP != null) {
            this.lRP.onDestroy();
        }
        if (this.lQY && dnk() != null) {
            dnk().drw();
        }
        if (this.lNh != null && (this.lNh.dow() || this.lNh.doy())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lNh.dot());
            if (this.lRE) {
                if (this.lRG) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lNh.cvi());
                }
                if (this.lRF) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lNh.getIsGood());
                }
            }
            if (this.lNh.getPbData() != null && System.currentTimeMillis() - this.lRb >= 40000 && (dll = this.lNh.getPbData().dll()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dll.getDataList())) {
                intent.putExtra("guess_like_data", dll);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lSd);
            }
            PbActivity pbActivity = this.lQT;
            PbActivity pbActivity2 = this.lQT;
            pbActivity.setResult(-1, intent);
        }
        if (dnF()) {
            if (this.lNh != null && this.lRD != null && this.lRD.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dlh() && !this.lRh && pbData.lKa == null) {
                        aj dpS = aj.dpS();
                        com.baidu.tieba.pb.data.f doE = this.lNh.doE();
                        Parcelable onSaveInstanceState = this.lRD.getListView().onSaveInstanceState();
                        boolean dov = this.lNh.dov();
                        boolean hostMode = this.lNh.getHostMode();
                        if (this.lRD.dqu() != null && this.lRD.dqu().getVisibility() == 0) {
                            z = true;
                        }
                        dpS.a(doE, onSaveInstanceState, dov, hostMode, z);
                        if (this.lSc >= 0 || this.lNh.dpg() != null) {
                            aj.dpS().q(this.lNh.dpg());
                            aj.dpS().p(this.lNh.dph());
                            aj.dpS().FY(this.lNh.dpi());
                        }
                    }
                }
            } else {
                aj.dpS().reset();
            }
            dmE();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lRD == null || !this.lRD.Ge(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lQT;
        if (i == 0) {
            this.lRD.dqh();
            this.lRD.dqj().dna();
            this.lRD.vK(false);
        }
        this.lRD.dql();
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
                        this.lRP.resetData();
                        this.lRP.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lRP.c(writeData);
                        com.baidu.tbadk.editortools.m qU = this.lRP.bBh().qU(6);
                        if (qU != null && qU.fBo != null) {
                            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lQT;
                        if (i == -1) {
                            this.lRP.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lRD.dqj() != null && this.lRD.dqj().dne() != null) {
                            com.baidu.tbadk.editortools.pb.h dne = this.lRD.dqj().dne();
                            dne.setThreadData(this.lNh.getPbData().dkZ());
                            dne.c(writeData);
                            dne.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qU2 = dne.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lQT;
                            if (i == -1) {
                                dne.bCm();
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
        this.lRP.onActivityResult(i, i2, intent);
        if (this.lRm != null) {
            this.lRm.onActivityResult(i, i2, intent);
        }
        if (dnk().dqj() != null) {
            dnk().dqj().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnD();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.dpS().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lNh != null) {
                                PbFragment.this.lNh.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dCR().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lNh != null) {
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
                        arVar.ap("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(arVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dCR().I(getPageContext());
                        dnv();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jCj != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jCj.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void byF() {
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
                    this.lRD.uO(false);
                    if (this.lNh.getPbData() != null && this.lNh.getPbData().dkZ() != null && this.lNh.getPbData().dkZ().bok() != null) {
                        this.lNh.getPbData().dkZ().bok().setStatus(2);
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
                        this.lRS = emotionImageData;
                        if (FI(com.baidu.tbadk.core.util.am.faC)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lRn != null) {
                        this.lRD.dM(this.lRn);
                        return;
                    }
                    return;
                case 25055:
                    if (this.lRo != null) {
                        this.lRo.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lRp != null) {
                        this.lRp.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (this.lRD != null && this.lRD.drC() != null) {
                        this.lRD.drC().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lRq != null) {
                        this.lRq.performClick();
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
            if (this.lRm == null) {
                this.lRm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lQT);
                this.lRm.b(this.fDO);
                this.lRm.c(this.fDW);
            }
            this.lRm.a(emotionImageData, dmq(), dmq().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnD() {
        MarkData FV;
        if (this.lRB != null) {
            if (this.lNh.getPbData() != null && this.lNh.getPbData().dlC()) {
                FV = this.lNh.FV(0);
            } else {
                FV = this.lNh.FV(this.lRD.dqP());
            }
            if (FV != null) {
                if (!FV.isApp() || (FV = this.lNh.FV(this.lRD.dqP() + 1)) != null) {
                    this.lRD.dqK();
                    this.lRB.a(FV);
                    if (!this.lRB.bjZ()) {
                        this.lRB.bkb();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lRB.bka();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnE() {
        com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
        this.lNh.vo(true);
        if (this.lRB != null) {
            pbData.Pk(this.lRB.bjY());
        }
        this.lRD.s(pbData);
    }

    private boolean dnF() {
        if (this.lNh == null) {
            return true;
        }
        if (this.lNh.getPbData() == null || !this.lNh.getPbData().dlC()) {
            if (this.lNh.bjZ()) {
                final MarkData doO = this.lNh.doO();
                if (doO == null || !this.lNh.getIsFromMark()) {
                    return true;
                }
                final MarkData FV = this.lNh.FV(this.lRD.dqO());
                if (FV == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", doO);
                    this.lQT.setResult(-1, intent);
                    return true;
                } else if (FV.getPostId() == null || FV.getPostId().equals(doO.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", doO);
                    this.lQT.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Au(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lRB != null) {
                                if (PbFragment.this.lRB.bjZ()) {
                                    PbFragment.this.lRB.bka();
                                    PbFragment.this.lRB.ja(false);
                                }
                                PbFragment.this.lRB.a(FV);
                                PbFragment.this.lRB.ja(true);
                                PbFragment.this.lRB.bkb();
                            }
                            doO.setPostId(FV.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doO);
                            PbFragment.this.lQT.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmE();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doO);
                            PbFragment.this.lQT.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmE();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lRD != null && PbFragment.this.lRD.getView() != null) {
                                PbFragment.this.lRD.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", doO);
                                PbFragment.this.lQT.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dmE();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bqx();
                    return false;
                }
            } else if (this.lNh.getPbData() == null || this.lNh.getPbData().dlb() == null || this.lNh.getPbData().dlb().size() <= 0 || !this.lNh.getIsFromMark()) {
                return true;
            } else {
                this.lQT.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lRD == null) {
            return null;
        }
        return this.lRD.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        if (this.lRD == null) {
            return 0;
        }
        return this.lRD.drb();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIh() {
        if (this.fUl == null) {
            this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
        return this.fUl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIi() {
        if (this.fXB == null) {
            this.fXB = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fXB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIj() {
        if (this.fUm == null) {
            this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwZ */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                    gifView.bCN();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fUm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIk() {
        if (this.fXC == null) {
            this.fXC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dod */
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
                    ((PlayVoiceBntNew) view).ccu();
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
        return this.fXC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIm() {
        this.fXE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: doe */
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
        return this.fXE;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.PL(str) && this.lNh != null && this.lNh.dot() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").ap("obj_param1", 1).dR("post_id", this.lNh.dot()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fAm = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            au.drJ().h(getPageContext(), str);
        }
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        au.drJ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lRf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lRD != null && this.lRD.drr() != null && rect.top <= this.lRD.drr().getHeight()) {
            rect.top += this.lRD.drr().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
            TbRichText bH = bH(str, i);
            if (bH != null && (tbRichTextData = bH.bHz().get(this.lSL)) != null) {
                aVar.postId = String.valueOf(bH.getPostId());
                aVar.lNv = new ArrayList<>();
                aVar.eJM = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHF().bHQ()) {
                    aVar.lNw = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lNv.add(c2);
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
                    imageUrlData.mIsReserver = this.lNh.doM();
                    imageUrlData.mIsSeeHost = this.lNh.getHostMode();
                    aVar.eJM.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dkZ() != null) {
                            aVar.threadId = pbData.dkZ().getId();
                        }
                        aVar.eJK = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lNw = true;
                int size = pbData.dlb().size();
                this.lSM = false;
                aVar.index = -1;
                int a2 = pbData.dli() != null ? a(pbData.dli().dNz(), bH, i, i, aVar.lNv, aVar.eJM) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dlb().get(i2);
                    if (postData.getId() == null || pbData.dli() == null || pbData.dli().getId() == null || !postData.getId().equals(pbData.dli().getId())) {
                        a2 = a(postData.dNz(), bH, a2, i, aVar.lNv, aVar.eJM);
                    }
                }
                if (aVar.lNv.size() > 0) {
                    aVar.lastId = aVar.lNv.get(aVar.lNv.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dkZ() != null) {
                        aVar.threadId = pbData.dkZ().getId();
                    }
                    aVar.eJK = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHF() == null) {
            return null;
        }
        return tbRichTextData.bHF().bHV();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHF() == null) {
            return 0L;
        }
        return tbRichTextData.bHF().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHF() == null) {
            return false;
        }
        return tbRichTextData.bHF().bHW();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bHF() == null) {
            return false;
        }
        return tbRichTextData.bHF().bHX();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bHF;
        String str;
        if (tbRichText == tbRichText2) {
            this.lSM = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bHz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bHz().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bHF().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bHF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bHF().bHQ()) {
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
                            if (tbRichTextData != null && (bHF = tbRichTextData.bHF()) != null) {
                                String bHS = bHF.bHS();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bHF.bHT();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bHS;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lNh.dot(), -1L);
                                imageUrlData.mIsReserver = this.lNh.doM();
                                imageUrlData.mIsSeeHost = this.lNh.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lSM) {
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
        PostData dli;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lNh.bnY())) {
                z = true;
            }
            MarkData o = this.lNh.o(postData);
            if (this.lNh.getPbData() != null && this.lNh.getPbData().dlC() && (dli = dli()) != null) {
                o = this.lNh.o(dli);
            }
            if (o != null) {
                this.lRD.dqK();
                if (this.lRB != null) {
                    this.lRB.a(o);
                    if (!z) {
                        this.lRB.bkb();
                    } else {
                        this.lRB.bka();
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
        if (this.lRD != null) {
            if (this.lRD.dol()) {
                return true;
            }
            this.lRD.drz();
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
                    this.lRZ = ((TbImageView) view).getBdImage();
                    this.lSa = ((TbImageView) view).getUrl();
                    if (this.lRZ == null || TextUtils.isEmpty(this.lSa)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSb = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lRZ = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lSa = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lSb = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lRZ = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lSa = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSb = null;
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
                    this.lRD.a(this.lSO, this.lRZ.isGif());
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
        this.kpS = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kpS == null) {
            return true;
        }
        if (this.kpS.dNx() == 1 && dG(view)) {
            this.lRD.a(this.lSO, this.lRZ.isGif());
            return true;
        } else if (this.lRB == null) {
            return true;
        } else {
            if (!this.lRB.bjZ() || this.kpS.getId() == null || !this.kpS.getId().equals(this.lNh.bnY())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dmq().getPbData() != null && dmq().getPbData().dlC();
            if (this.kpS.dNx() == 1) {
                if (!z3) {
                    this.lRD.a(this.lSN, z, false);
                }
                return true;
            }
            if (this.lRI == null) {
                this.lRI = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lRI.a(this.lSA);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dG(view) && !z3;
                boolean z5 = (!dG(view) || this.lRZ == null || this.lRZ.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lRI));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lRI));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lRI);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.kpS);
                    gVar2.eVl.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lRI);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lRI);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.kpS);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eVl.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lRy) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lRI);
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
                        gVar3.eVl.setTag(sparseArray5);
                        arrayList.add(gVar3);
                    } else {
                        if ((va(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lRI);
                            gVar4.eVl.setTag(str);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lRI);
                            gVar6.eVl.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lRI);
                        gVar5.eVl.setTag(sparseArray6);
                    } else if (z10) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_should_manage_visible, false);
                        sparseArray7.put(R.id.tag_user_mute_visible, false);
                        sparseArray7.put(R.id.tag_should_delete_visible, true);
                        sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        if (this.lNh.getPbData().dlo() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lRI);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lRI);
                        }
                        gVar6.eVl.setTag(sparseArray7);
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                }
                if (com.baidu.tbadk.a.d.bjm()) {
                    list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kpS.bpJ(), sparseArray2, this.lRI), this.lQU));
                    this.lRI.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kpS));
                } else {
                    list = arrayList;
                }
                this.lRI.k(list, true);
                this.lRH = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lRI);
                this.lRH.QE();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dR("tid", this.lNh.lUN).dR("fid", this.lNh.getForumId()).dR("uid", this.lNh.getPbData().dkZ().bnQ().getUserId()).dR("post_id", this.lNh.bBJ()).ap("obj_source", z2 ? 2 : 1));
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

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lNh == null || this.lNh.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lNh.getPbData();
        if (pbData.dli() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dli());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dlb = pbData.dlb();
            c(pbData, dlb);
            return c(dlb, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c fq;
        int i = 1;
        if (agreeData != null) {
            if (this.feF == null) {
                this.feF = new com.baidu.tbadk.core.message.a();
            }
            if (this.fep == null) {
                this.fep = new com.baidu.tieba.tbadkCore.data.e();
                this.fep.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 5;
            eVar.eMg = 8;
            eVar.eMf = 2;
            if (dmq() != null) {
                eVar.eMe = dmq().dpe();
            }
            eVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eMh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eMh = 1;
                        i = 0;
                    }
                }
                fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
                if (fq != null) {
                    agreeData.objSource = fq.getCurrentPageKey();
                }
                this.feF.a(agreeData, i, getUniqueId(), false);
                this.feF.a(agreeData, this.fep);
                if (this.lNh == null && this.lNh.getPbData() != null) {
                    this.feF.a(doa(), eVar, agreeData, this.lNh.getPbData().dkZ());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eMh = 1;
            }
            i = 0;
            fq = com.baidu.tbadk.pageExtra.d.fq(getContext());
            if (fq != null) {
            }
            this.feF.a(agreeData, i, getUniqueId(), false);
            this.feF.a(agreeData, this.fep);
            if (this.lNh == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dln() != null && fVar.dln().lLH != null && (list = fVar.dln().lLH) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bHz;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dNz = arrayList.get(i2).dNz();
            if (dNz != null && (bHz = dNz.bHz()) != null) {
                int size = bHz.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bHz.get(i4) != null && bHz.get(i4).getType() == 8) {
                        i3++;
                        if (bHz.get(i4).bHF().bHS().equals(str) || bHz.get(i4).bHF().bHT().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bHz.get(i4).bHF().getWidth() * equipmentDensity;
                            int height = bHz.get(i4).bHF().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.lSL = i4;
                            return dNz;
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
            this.lNd = str;
            if (this.lRa == null) {
                dno();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lRa.getItemView(1).setVisibility(8);
            } else {
                this.lRa.getItemView(1).setVisibility(0);
            }
            this.lRa.bqz();
            this.lRf = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnG() {
        hideNetRefreshView(this.lRD.getView());
        dnH();
        if (this.lNh.doH()) {
            this.lRD.dqK();
        }
        this.lRD.dqV();
    }

    private void dnH() {
        showLoadingView(this.lRD.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lRD.drr().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCU() {
        if (this.jgg != null) {
            this.jgg.stopPlay();
        }
        if (this.lQT != null) {
            this.lQT.cCU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dnu(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        if (this.fXD == null) {
            this.fXD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dof */
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
        return this.fXD;
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

    public void cCV() {
        if (this.lQT != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lQT.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lQT.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cBs() {
        if (this.lNh == null || this.lNh.getPbData() == null) {
            return null;
        }
        return this.lNh.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.lZW)).intValue();
            if (intValue == ap.lZX) {
                if (!this.geq.dOs()) {
                    this.lRD.dqF();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.geq.Ts(com.baidu.tbadk.core.util.au.R(jSONArray));
                    }
                    this.geq.a(this.lNh.getPbData().getForum().getId(), this.lNh.getPbData().getForum().getName(), this.lNh.getPbData().dkZ().getId(), str, intValue3, intValue2, booleanValue, this.lNh.getPbData().dkZ().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.lZY || intValue == ap.maa) {
                if (this.lNh.doX() != null) {
                    this.lNh.doX().FD(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.lZY) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lRX);
        userMuteAddAndDelCustomMessage.setTag(this.lRX);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Pv(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0843a
    public void vd(boolean z) {
        this.lRJ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnI() {
        ArrayList<PostData> dlb;
        int count;
        if (this.lNh == null || this.lNh.getPbData() == null || this.lNh.getPbData().dlb() == null || (count = com.baidu.tbadk.core.util.y.getCount((dlb = this.lNh.getPbData().dlb()))) == 0) {
            return "";
        }
        if (this.lNh.doM()) {
            Iterator<PostData> it = dlb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNx() == 1) {
                    return next.getId();
                }
            }
        }
        int dqO = this.lRD.dqO();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dlb, dqO);
        if (postData == null || postData.bnQ() == null) {
            return "";
        }
        if (this.lNh.Pz(postData.bnQ().getUserId())) {
            return postData.getId();
        }
        for (int i = dqO - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dlb, i);
            if (postData2 == null || postData2.bnQ() == null || postData2.bnQ().getUserId() == null) {
                break;
            } else if (this.lNh.Pz(postData2.bnQ().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dqO + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dlb, i2);
            if (postData3 == null || postData3.bnQ() == null || postData3.bnQ().getUserId() == null) {
                return "";
            }
            if (this.lNh.Pz(postData3.bnQ().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        this.lRf = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Pw(String str) {
        String str2;
        if (this.lNh.getPbData() == null || this.lNh.getPbData().dlb() == null || this.lNh.getPbData().dlb().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lNh.getPbData().dlb().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lNh.getPbData().dlb().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lNh.getPbData().dlb().get(i);
        if (postData.dNz() == null || postData.dNz().bHz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dNz().bHz().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bHF() != null) {
                    str2 = next.bHF().bHS();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dnJ() {
        return (!this.lQV && this.lSQ == -1 && this.lSR == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null) {
            this.lST = tVar;
            this.lQV = true;
            this.lRD.dqv();
            this.lRD.PJ(this.lSS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnK() {
        if (this.lST != null) {
            if (this.lSQ == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lST.getCartoonId(), this.lSQ, 0)));
                this.lQT.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        if (this.lST != null) {
            if (this.lSR == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lST.getCartoonId(), this.lSR, 0)));
                this.lQT.finish();
            }
        }
    }

    public int dnM() {
        return this.lSQ;
    }

    public int dnN() {
        return this.lSR;
    }

    private void cSL() {
        if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().dkZ() != null && this.lNh.getPbData().dkZ().bmv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dnO() {
        if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().dkZ() != null && this.lNh.getPbData().dkZ().bmv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dnP() {
        if (this.isPaused) {
            this.lRl = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lNh.getPbData() != null && this.lNh.getPbData().dkZ() != null && this.lNh.getPbData().dkZ().bnw() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lNh.getPbData().dkZ().bnw().getThreadId(), this.lNh.getPbData().dkZ().bnw().getTaskId(), this.lNh.getPbData().dkZ().bnw().getForumId(), this.lNh.getPbData().dkZ().bnw().getForumName(), this.lNh.getPbData().dkZ().bnL(), this.lNh.getPbData().dkZ().bnM())));
            this.lQX = true;
            this.lQT.finish();
        }
    }

    public String dnQ() {
        return this.lRj;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dnR() {
        return this.lRz;
    }

    public void ve(boolean z) {
        this.lRk = z;
    }

    public boolean blu() {
        if (this.lNh != null) {
            return this.lNh.dow();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Au(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lRV).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lRV.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lRV).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lRV != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lRV.getPageActivity());
            aVar.Au(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lRV).bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lRD.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lRV.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Au(this.lRV.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Au(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lRD.showLoadingDialog();
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
        aVar.b(this.lRV).bqx();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.PL(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jMV) {
            this.jMV = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lRD != null) {
                this.lRD.onConfigurationChanged(configuration);
            }
            if (this.lRH != null) {
                this.lRH.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dnT() {
        if (this.lNh != null) {
            return this.lNh.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lNh.getPbData().dln().lLH;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNu().remove(i2);
                    list.get(i).dNw();
                    z = true;
                    break;
                }
            }
            list.get(i).Te(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lNh.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.q qVar) {
        String id = qVar.dlR().getId();
        List<PostData> list = this.lNh.getPbData().dln().lLH;
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
                ArrayList<PostData> dma = qVar.dma();
                postData.JD(qVar.getTotalCount());
                if (postData.dNu() != null) {
                    postData.dNu().clear();
                    postData.dNu().addAll(dma);
                }
            }
        }
        if (!this.lNh.getIsFromMark()) {
            this.lRD.s(this.lNh.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dmh() {
        return this.lQT.dmh();
    }

    public boolean dmi() {
        if (this.lNh == null) {
            return false;
        }
        return this.lNh.dmi();
    }

    public void vf(boolean z) {
        this.lRi = z;
    }

    public boolean dnU() {
        return this.lRi;
    }

    public void dnV() {
        if (this.lRD != null) {
            this.lRD.dqh();
            cCV();
        }
    }

    public PostData dli() {
        return this.lRD.b(this.lNh.lOq, this.lNh.dov());
    }

    public void onBackPressed() {
        if (this.lSe != null && !this.lSe.isEmpty()) {
            int size = this.lSe.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lSe.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lSe == null) {
                this.lSe = new ArrayList();
            }
            if (!this.lSe.contains(aVar)) {
                this.lSe.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lSe == null) {
                this.lSe = new ArrayList();
            }
            if (!this.lSe.contains(aVar)) {
                this.lSe.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lSe != null) {
            this.lSe.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.ag.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnW() {
        if (this.lNh != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lNh.dot())) {
            com.baidu.tbadk.BdToken.c.bhn().q(com.baidu.tbadk.BdToken.b.eCf, com.baidu.adp.lib.f.b.toLong(this.lNh.dot(), 0L));
        }
    }

    public bk dnX() {
        return this.lRv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px(String str) {
        if (this.lNh != null && this.lNh.getPbData() != null && this.lNh.getPbData().dkZ() != null && this.lNh.getPbData().dkZ().bmz()) {
            cb dkZ = this.lNh.getPbData().dkZ();
            int i = 0;
            if (dkZ.bmx()) {
                i = 1;
            } else if (dkZ.bmy()) {
                i = 2;
            } else if (dkZ.bpN()) {
                i = 3;
            } else if (dkZ.bpO()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(str);
            arVar.ap("obj_source", 4);
            arVar.ap("obj_type", i);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM(final int i) {
        com.baidu.tbadk.util.af.a(new com.baidu.tbadk.util.ae<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkO */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dnu(), i2, PbFragment.this.lNh);
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
        arVar.ap("obj_locate", 1);
        if (i == 3) {
            arVar.ap("obj_type", 1);
        } else if (i == 8) {
            arVar.ap("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dnY() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dnZ() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doa() {
        return this.lQT;
    }
}
