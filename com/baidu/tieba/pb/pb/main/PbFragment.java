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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.a, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0844a {
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
    private com.baidu.tieba.callfans.a iya;
    private VoiceManager jgu;
    private com.baidu.tieba.frs.profession.permission.c jkQ;
    private com.baidu.tieba.f.b jlq;
    public com.baidu.tbadk.core.util.am kSz;
    public ar kWC;
    private String lNs;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lRB;
    private View lRC;
    private View lRD;
    private View lRE;
    private View lRF;
    int lRH;
    private bk lRK;
    private com.baidu.tieba.pb.pb.report.a lRP;
    private com.baidu.tbadk.core.dialog.i lRW;
    private com.baidu.tbadk.core.dialog.k lRX;
    private boolean lRY;
    private PbActivity lRi;
    private com.baidu.tieba.pb.pb.main.b.b lRl;
    private boolean lSY;
    private com.baidu.tieba.tbadkCore.data.f lSc;
    private com.baidu.tbadk.editortools.pb.g lSd;
    private com.baidu.tbadk.editortools.pb.e lSe;
    private com.baidu.tieba.frs.profession.permission.c lSg;
    private EmotionImageData lSh;
    private com.baidu.adp.base.f lSk;
    private com.baidu.tbadk.core.view.c lSl;
    private BdUniqueId lSm;
    private Runnable lSn;
    private com.baidu.adp.widget.ImageView.a lSo;
    private String lSp;
    private TbRichTextMemeInfo lSq;
    private List<a> lSt;
    public String lSv;
    private String lTh;
    private com.baidu.tbadk.core.data.t lTi;
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
    private static final b.a lTe = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmn();
            } else {
                com.baidu.tieba.pb.a.b.dmm();
            }
        }
    };
    boolean lRj = true;
    private boolean lRk = false;
    private boolean lRm = false;
    private boolean isPaused = false;
    private boolean lmn = false;
    private boolean lRn = true;
    private int lRo = 0;
    private com.baidu.tbadk.core.dialog.b lRp = null;
    private long iJe = -1;
    private long fJu = 0;
    private long lRq = 0;
    private long createTime = 0;
    private long fJl = 0;
    private boolean lRr = false;
    private com.baidu.tbadk.n.b lRs = null;
    private long lRt = 0;
    private boolean lRu = false;
    private long lRv = 0;
    private int jNj = 1;
    private String fDL = null;
    private boolean lRw = false;
    private boolean isFullScreen = false;
    private boolean lRx = false;
    private String lRy = "";
    private boolean lRz = true;
    private boolean lRA = false;
    private String source = "";
    private int mSkinType = 3;
    int[] lRG = new int[2];
    private int lRI = -1;
    private int lRJ = -1;
    public BdUniqueId lRL = BdUniqueId.gen();
    private boolean lRM = false;
    private boolean lRN = com.baidu.tbadk.a.d.biY();
    private PbInterviewStatusView.a lRO = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.lRS.vD(!PbFragment.this.lRz);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.bjZ()) {
                        PbFragment.this.dnL();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lNw = null;
    private com.baidu.tbadk.baseEditMark.a lRQ = null;
    private ForumManageModel gev = null;
    private com.baidu.tbadk.coreExtra.model.a faF = null;
    private com.baidu.tieba.pb.data.r lRR = null;
    private ShareSuccessReplyToServerModel jCx = null;
    private ap lRS = null;
    private boolean lRT = false;
    private boolean lRU = false;
    private boolean lRV = false;
    private boolean gmn = false;
    private boolean lRZ = false;
    private boolean lSa = false;
    private boolean lSb = false;
    private boolean lSf = false;
    public boolean lSi = false;
    private com.baidu.tbadk.editortools.pb.c fDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBM() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (PbFragment.this.kWC == null || PbFragment.this.kWC.drM() == null || !PbFragment.this.kWC.drM().dWx()) {
                return !PbFragment.this.FI(com.baidu.tbadk.core.util.am.faA);
            }
            PbFragment.this.showToast(PbFragment.this.kWC.drM().dWz());
            if (PbFragment.this.lSe != null && (PbFragment.this.lSe.bCc() || PbFragment.this.lSe.bCd())) {
                PbFragment.this.lSe.a(false, PbFragment.this.kWC.drP());
            }
            PbFragment.this.kWC.vQ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lSj = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (PbFragment.this.kWC == null || PbFragment.this.kWC.drN() == null || !PbFragment.this.kWC.drN().dWx()) {
                return !PbFragment.this.FI(com.baidu.tbadk.core.util.am.faB);
            }
            PbFragment.this.showToast(PbFragment.this.kWC.drN().dWz());
            if (PbFragment.this.lRS != null && PbFragment.this.lRS.dqq() != null && PbFragment.this.lRS.dqq().dnl() != null && PbFragment.this.lRS.dqq().dnl().bCd()) {
                PbFragment.this.lRS.dqq().dnl().a(PbFragment.this.kWC.drP());
            }
            PbFragment.this.kWC.vR(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean jhi = false;
    private int lSr = 0;
    private int lSs = -1;
    public int lSu = 0;
    private final a lSw = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.lRS != null && PbFragment.this.lRS.dqq() != null) {
                r dqq = PbFragment.this.lRS.dqq();
                if (dqq.dnj()) {
                    dqq.dni();
                    return true;
                }
            }
            if (PbFragment.this.lRS != null && PbFragment.this.lRS.drr()) {
                PbFragment.this.lRS.drs();
                return true;
            }
            return false;
        }
    };
    private final ab.a lSx = new ab.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ab.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.lRS.showToast(str);
            }
        }
    };
    private final CustomMessageListener lSy = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lNw != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lSe != null) {
                    PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                }
                PbFragment.this.lRS.dqs();
                PbFragment.this.lRS.drk();
            }
        }
    };
    CustomMessageListener jib = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                PbFragment.this.lNw.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                if (PbFragment.this.lRS != null && PbFragment.this.lNw != null) {
                    PbFragment.this.lRS.b(PbFragment.this.lNw.getPbData(), PbFragment.this.lNw.doC(), PbFragment.this.lNw.dpa(), PbFragment.this.lRS.getSkinType());
                }
                if (PbFragment.this.lRS != null && PbFragment.this.lRS.dqK() != null) {
                    PbFragment.this.lRS.dqK().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener lSz = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.lRS != null) {
                    if (booleanValue) {
                        PbFragment.this.lRS.dqN();
                    } else {
                        PbFragment.this.lRS.dqO();
                    }
                }
            }
        }
    };
    private CustomMessageListener lSA = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lSe != null) {
                    PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                }
                PbFragment.this.lRS.vK(false);
            }
        }
    };
    private CustomMessageListener lSB = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener lSC = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lRS != null && PbFragment.this.lRS.dqK() != null) {
                PbFragment.this.lRS.dqK().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener juR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener jhX = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.dod();
            }
        }
    };
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fDL);
        }
    };
    private CustomMessageListener lSD = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ai)) {
                com.baidu.tbadk.core.data.ai aiVar = (com.baidu.tbadk.core.data.ai) customResponsedMessage.getData();
                bb.a aVar = new bb.a();
                aVar.giftId = aiVar.id;
                aVar.giftName = aiVar.name;
                aVar.thumbnailUrl = aiVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNw.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lNw.doR() != null && PbFragment.this.lNw.doR().getUserIdLong() == aiVar.toUserId) {
                        PbFragment.this.lRS.a(aiVar.sendCount, PbFragment.this.lNw.getPbData(), PbFragment.this.lNw.doC(), PbFragment.this.lNw.dpa());
                    }
                    if (pbData.dli() != null && pbData.dli().size() >= 1 && pbData.dli().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dli().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNw.doA(), 0L);
                        if (j == aiVar.postId && j2 == aiVar.threadId) {
                            bb dNN = pbData.dli().get(0).dNN();
                            if (dNN == null) {
                                dNN = new bb();
                            }
                            ArrayList<bb.a> bmH = dNN.bmH();
                            if (bmH == null) {
                                bmH = new ArrayList<>();
                            }
                            bmH.add(0, aVar);
                            dNN.setTotal(aiVar.sendCount + dNN.getTotal());
                            dNN.y(bmH);
                            pbData.dli().get(0).a(dNN);
                            PbFragment.this.lRS.dqK().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lSE = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                PbFragment.this.lNw.getPbData().dlA();
                PbFragment.this.lNw.doW();
                if (PbFragment.this.lRS.dqK() != null) {
                    PbFragment.this.lRS.s(PbFragment.this.lNw.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.o oVar;
            if (customResponsedMessage != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Ps(str);
                PbFragment.this.lNw.doW();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lNw.getPbData().dli() != null) {
                    ArrayList<PostData> dli = PbFragment.this.lNw.getPbData().dli();
                    Iterator<PostData> it = dli.iterator();
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
                        dli.remove(oVar);
                        if (PbFragment.this.lRS.dqK() != null && PbFragment.this.lRS.dqK().getDataList() != null) {
                            PbFragment.this.lRS.dqK().getDataList().remove(oVar);
                        }
                        if (PbFragment.this.lRS.getListView() != null && PbFragment.this.lRS.getListView().getData() != null) {
                            PbFragment.this.lRS.getListView().getData().remove(oVar);
                        }
                        if (PbFragment.this.lRS.dqK() != null) {
                            PbFragment.this.lRS.dqK().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.lRS.dqK() != null) {
                    PbFragment.this.lRS.s(PbFragment.this.lNw.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a lSF = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.dsf()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a lSG = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.lRS != null) {
                PbFragment.this.lRS.fn(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean lSH = false;
    private PraiseModel lSI = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void Fb(String str) {
            PbFragment.this.lSH = false;
            if (PbFragment.this.lSI != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNw.getPbData();
                if (pbData.dlg().bnB().getIsLike() == 1) {
                    PbFragment.this.zV(0);
                } else {
                    PbFragment.this.zV(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dlg()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.lSH = false;
            if (PbFragment.this.lSI != null && str != null) {
                if (AntiHelper.bX(i, str)) {
                    AntiHelper.bq(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a lSJ = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void vg(boolean z) {
            PbFragment.this.ve(z);
            if (PbFragment.this.lRS.drx() != null && z) {
                PbFragment.this.lRS.vD(false);
            }
            PbFragment.this.lRS.vF(z);
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
                        if (PbFragment.this.dlp().bnQ() != null && PbFragment.this.dlp().bnQ().getGodUserData() != null) {
                            PbFragment.this.dlp().bnQ().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null) {
                            PbFragment.this.lNw.getPbData().dlg().bnQ().setHadConcerned(updateAttentionMessage.isAttention());
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
            if (tipEvent.pageId > 0 && PbFragment.this.lRi.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a lSK = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.lRS.ckx();
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
                    com.baidu.tieba.k.a.cOz();
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
                PbFragment.this.dnv();
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
                        if (PbFragment.this.lRS.dnt() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.dmo() != null && PbFragment.this.dmo().iPT != null) {
                                PbFragment.this.dmo().iPT.onClick(view);
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
                if (PbFragment.this.lSe != null) {
                    PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                }
                PbFragment.this.lRS.dqs();
                PbFragment.this.lRS.drk();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener lSL = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lSm) {
                PbFragment.this.lRS.ckx();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNw.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlw().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lSl.showSuccessToast(PbFragment.this.lSk.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.lSk.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.Da(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dnZ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.lSk.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.lSl.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lSM = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lSm) {
                PbFragment.this.lRS.ckx();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.lSl.showSuccessToast(PbFragment.this.lSk.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.au.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.lSk.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.lSl.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lSN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lSm) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.lRS.ckx();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nKz;
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
                    PbFragment.this.lRS.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener lSO = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lRS.dqt() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dnv();
            }
        }
    };
    private CustomMessageListener jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.jhi = true;
                }
            }
        }
    };
    public a.b lxt = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cDc();
            az pageData = PbFragment.this.lNw.getPageData();
            int pageNum = PbFragment.this.lRS.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bmA()) {
                PbFragment.this.lRS.drk();
                PbFragment.this.cDb();
                PbFragment.this.lRS.dqR();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lNw.FP(PbFragment.this.lRS.getPageNum());
                    if (PbFragment.this.lRl != null) {
                        PbFragment.this.lRl.showFloatingView();
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
    private k.c lSP = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.lRW != null) {
                PbFragment.this.lRW.dismiss();
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
                    if (PbFragment.this.lSo != null && !TextUtils.isEmpty(PbFragment.this.lSp)) {
                        if (PbFragment.this.lSq == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lSp));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.lSp;
                            aVar.pkgId = PbFragment.this.lSq.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lSq.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lSo = null;
                        PbFragment.this.lSp = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lSo != null && !TextUtils.isEmpty(PbFragment.this.lSp)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.eIQ == null) {
                                PbFragment.this.eIQ = new at(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.eIQ.p(PbFragment.this.lSp, PbFragment.this.lSo.getImageByte());
                            PbFragment.this.lSo = null;
                            PbFragment.this.lSp = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.kqg != null) {
                        PbFragment.this.kqg.gW(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.kqg = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11739").ap("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dE(view);
                        if (PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null && PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId() != null && PbFragment.this.lRQ != null) {
                            int h = PbFragment.this.h(PbFragment.this.lNw.getPbData());
                            cb dlg = PbFragment.this.lNw.getPbData().dlg();
                            if (dlg.bmx()) {
                                i2 = 2;
                            } else if (dlg.bmy()) {
                                i2 = 3;
                            } else if (dlg.bpN()) {
                                i2 = 4;
                            } else {
                                i2 = dlg.bpO() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lNw.lVc).ap("obj_locate", 2).dR("obj_id", PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId()).ap("obj_type", PbFragment.this.lRQ.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i2));
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
                        PbFragment.this.Pu((String) tag);
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
                        PbFragment.this.lRS.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.lRS.dL(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.lRS.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
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
    public SortSwitchButton.a lSQ = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            PbFragment.this.lRS.drk();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lNw == null || PbFragment.this.lNw.isLoading) {
                    return false;
                }
                PbFragment.this.cDb();
                PbFragment.this.lRS.dqR();
                if (PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().lKm != null && PbFragment.this.lNw.getPbData().lKm.size() > i) {
                    int intValue = PbFragment.this.lNw.getPbData().lKm.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", PbFragment.this.lNw.doB()).dR("fid", PbFragment.this.lNw.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_type", FN(intValue)));
                    if (PbFragment.this.lNw.FU(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.lRS.vy(true);
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
    public final View.OnClickListener jjj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
                    if (view == PbFragment.this.lRS.drg()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lNw.vm(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.lRS.dqS();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpR()) {
                        if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpS()) {
                            if (view == PbFragment.this.lRS.lYW.fLW) {
                                if (PbFragment.this.lRS.vH(PbFragment.this.lNw.doI())) {
                                    PbFragment.this.cDb();
                                    return;
                                }
                                PbFragment.this.lRn = false;
                                PbFragment.this.lRm = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.lRi, PbFragment.this.lRS.lYW.fLW);
                                PbFragment.this.lRi.finish();
                            } else if (view != PbFragment.this.lRS.dqP() && (PbFragment.this.lRS.lYW.dss() == null || (view != PbFragment.this.lRS.lYW.dss().dpQ() && view != PbFragment.this.lRS.lYW.dss().dpO()))) {
                                if (view == PbFragment.this.lRS.dro()) {
                                    if (PbFragment.this.lNw != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNw.getPbData().dlg().bnP().getLink());
                                    }
                                } else if (view != PbFragment.this.lRS.lYW.mfD) {
                                    if (view == PbFragment.this.lRS.lYW.jxc) {
                                        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                                            if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                ArrayList<PostData> dli = PbFragment.this.lNw.getPbData().dli();
                                                if ((dli == null || dli.size() <= 0) && PbFragment.this.lNw.doC()) {
                                                    com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", PbFragment.this.lNw.doA()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.lNw.getForumId()));
                                                if (!PbFragment.this.lRS.drC()) {
                                                    PbFragment.this.lRS.dqs();
                                                }
                                                PbFragment.this.dnD();
                                            } else {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.lRS.uS(true);
                                            PbFragment.this.lRS.dqs();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.lRS.dqN();
                                                PbFragment.this.cDb();
                                                PbFragment.this.lRS.dqR();
                                                PbFragment.this.lNw.Pz(PbFragment.this.dnP());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpN()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.lRS.lYW.dss() != null && view == PbFragment.this.lRS.lYW.dss().dpM()) {
                                                PbFragment.this.lRS.lYW.baM();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.FM(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpK()) {
                                                    if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpU()) {
                                                        if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpL()) {
                                                            if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpV()) {
                                                                if (PbFragment.this.lRS.drx() == view) {
                                                                    if (PbFragment.this.lRS.drx().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lNw.getPbData();
                                                                        if (pbData2 != null && pbData2.dlg() != null && pbData2.dlg().bnw() != null) {
                                                                            String bnm = pbData2.dlg().bnw().bnm();
                                                                            if (StringUtils.isNull(bnm)) {
                                                                                bnm = pbData2.dlg().bnw().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11107").dR("obj_id", bnm));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gz("c10725", null);
                                                                    }
                                                                    PbFragment.this.dnW();
                                                                } else if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpT()) {
                                                                    if (PbFragment.this.lRS.lYW.dss() != null && view == PbFragment.this.lRS.lYW.dss().dpP()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.lRS.b(PbFragment.this.lNw.getPbData(), PbFragment.this.lNw.doC(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.lRS.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.lRS.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.lRS.lYW.baM();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar.dR("tid", PbFragment.this.lNw.doA());
                                                                            arVar.dR("fid", PbFragment.this.lNw.getForumId());
                                                                            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar.ap("obj_locate", 4);
                                                                            TiebaStatic.log(arVar);
                                                                        }
                                                                        if (view.getId() == R.id.pb_floor_reply_more && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                            PbFragment.this.lRD = view;
                                                                            return;
                                                                        } else if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                PbFragment.this.lRS.drk();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dNR() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                                                                                    }
                                                                                    if (postData.nxT != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN = postData.nxT.bsN();
                                                                                        bsN.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            bsN.ap("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            bsN.ap("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(bsN);
                                                                                    }
                                                                                    String doA = PbFragment.this.lNw.doA();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lNw.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lNw.getPbData().dlv();
                                                                                    }
                                                                                    PbFragment.this.cDb();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a Px = PbFragment.this.Px(id);
                                                                                        if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && Px != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doA, id, "pb", true, null, true, null, i3, postData.dts(), PbFragment.this.lNw.getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Px.lNK, Px.eJM, Px.eJK, Px.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lNw.dpl());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lNw.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lNw.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lNw.doK());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a Px2 = PbFragment.this.Px(id);
                                                                                        if (postData != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && Px2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doA, id, "pb", true, null, false, str2, i3, postData.dts(), PbFragment.this.lNw.getPbData().getAnti(), false, postData.bnQ().getIconInfo()).addBigImageData(Px2.lNK, Px2.eJM, Px2.eJK, Px2.index);
                                                                                            if (!com.baidu.tbadk.core.util.au.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lNw.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lNw.doK());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lNw.dpl());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lNw.getFromForumId());
                                                                                            if (PbFragment.this.lRS != null) {
                                                                                                addBigImageData2.setMainPostMaskVisibly(PbFragment.this.lRS.b(PbFragment.this.lNw.lOF, PbFragment.this.lNw.doC()).nxK || postData.nxK);
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 3).dR("fid", PbFragment.this.lNw.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lNw != null) {
                                                                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                            arVar2.dR("tid", PbFragment.this.lNw.doA());
                                                                            arVar2.dR("fid", PbFragment.this.lNw.getForumId());
                                                                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            arVar2.ap("obj_locate", 5);
                                                                            TiebaStatic.log(arVar2);
                                                                            if (view.getId() == R.id.pb_post_reply_count && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                                                                PbFragment.this.lRD = view;
                                                                                return;
                                                                            } else if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.nxT != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN2 = postData3.nxT.bsN();
                                                                                        bsN2.delete("obj_locate");
                                                                                        bsN2.ap("obj_locate", 8);
                                                                                        TiebaStatic.log(bsN2);
                                                                                    }
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                        String doA2 = PbFragment.this.lNw.doA();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lNw.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lNw.getPbData().dlv();
                                                                                        }
                                                                                        PbActivity.a Px3 = PbFragment.this.Px(id2);
                                                                                        if (Px3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(doA2, id2, "pb", true, null, false, null, i4, postData3.dts(), PbFragment.this.lNw.getPbData().getAnti(), false, postData3.bnQ().getIconInfo()).addBigImageData(Px3.lNK, Px3.eJM, Px3.eJK, Px3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lNw.dpl());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lNw.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lNw.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lNw.doK());
                                                                                            if (PbFragment.this.lNw.getPbData().dlP() != null) {
                                                                                                addBigImageData3.setHasForumRule(PbFragment.this.lNw.getPbData().dlP().has_forum_rule.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lNw.getPbData().getUserData() != null) {
                                                                                                addBigImageData3.setIsManager(PbFragment.this.lNw.getPbData().getUserData().getIs_manager());
                                                                                            }
                                                                                            if (PbFragment.this.lNw.getPbData().getForum().getDeletedReasonInfo() != null) {
                                                                                                addBigImageData3.setDeletedReasonInfoIsGrayCaleForum(PbFragment.this.lNw.getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                                addBigImageData3.setDeletedReasonInfoIsIsBoomGrow(PbFragment.this.lNw.getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                            }
                                                                                            if (PbFragment.this.lNw.getPbData().getForum() != null) {
                                                                                                addBigImageData3.setForumHeadUrl(PbFragment.this.lNw.getPbData().getForum().getImage_url());
                                                                                                addBigImageData3.setUserLevel(PbFragment.this.lNw.getPbData().getForum().getUser_level());
                                                                                            }
                                                                                            if (PbFragment.this.lRS != null) {
                                                                                                addBigImageData3.setMainPostMaskVisibly(PbFragment.this.lRS.b(PbFragment.this.lNw.lOF, PbFragment.this.lNw.doC()).nxK || postData3.nxK);
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
                                                                        if (PbFragment.this.lNw != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                arVar3.dR("tid", PbFragment.this.lNw.doA());
                                                                                arVar3.dR("fid", PbFragment.this.lNw.getForumId());
                                                                                arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                arVar3.ap("obj_locate", 6);
                                                                                TiebaStatic.log(arVar3);
                                                                            }
                                                                            if (view.getId() == R.id.post_info_commont_img) {
                                                                                if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                    PbFragment.this.lRE = view;
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                PbFragment.this.lRE = view;
                                                                                return;
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.nxT != null) {
                                                                                        com.baidu.tbadk.core.util.ar bsN3 = postData4.nxT.bsN();
                                                                                        bsN3.delete("obj_locate");
                                                                                        bsN3.ap("obj_locate", 8);
                                                                                        TiebaStatic.log(bsN3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", PbFragment.this.lNw.doB()).dR("fid", PbFragment.this.lNw.getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).ap("obj_source", 1).ap("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.dnr().dqp() != null && postData4.bnQ() != null && postData4.dNF() != 1) {
                                                                                        if (PbFragment.this.dnr().dqq() != null) {
                                                                                            PbFragment.this.dnr().dqq().dnh();
                                                                                        }
                                                                                        if (PbFragment.this.lRN && postData4.dNC() != null && postData4.dNC().size() != 0) {
                                                                                            PbFragment.this.a(postData4, true);
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                                                                                            qVar.a(PbFragment.this.lNw.getPbData().getForum());
                                                                                            qVar.setThreadData(PbFragment.this.lNw.getPbData().dlg());
                                                                                            qVar.g(postData4);
                                                                                            PbFragment.this.dnr().dqp().d(qVar);
                                                                                            PbFragment.this.dnr().dqp().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bnQ().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lSe != null) {
                                                                                                PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
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
                                                                        if (view != PbFragment.this.lRS.dmH()) {
                                                                            if (view == PbFragment.this.lRS.lYW.dst()) {
                                                                                PbFragment.this.lRS.dqY();
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12006").dR("tid", PbFragment.this.lNw.lVc));
                                                                                            }
                                                                                            if (PbFragment.this.lRX == null) {
                                                                                                PbFragment.this.lRX = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.lRX.a(PbFragment.this.lSP);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dG(view);
                                                                                            if (!PbFragment.this.dG(view) || PbFragment.this.lSo == null || !PbFragment.this.lSo.isGif()) {
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
                                                                                                if (postData5.dNH() != null && postData5.dNH().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.lRX);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar4.eVl.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar4);
                                                                                                }
                                                                                                PbFragment.this.kqg = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lNw.getPbData().bjZ()) {
                                                                                                String bjY = PbFragment.this.lNw.getPbData().bjY();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(bjY) && bjY.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.lRX);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.lRX);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.kqg);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.eVl.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lRX);
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
                                                                                                                com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRX);
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRX);
                                                                                                                gVar2.eVl.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lRX);
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
                                                                                                            if (PbFragment.this.lNw.getPbData().dlv() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRX);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRX);
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
                                                                                                    PbFragment.this.lRX.bw(arrayList);
                                                                                                    PbFragment.this.lRW = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRX);
                                                                                                    PbFragment.this.lRW.QE();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.kqg);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.eVl.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.lRX.bw(arrayList);
                                                                                            PbFragment.this.lRW = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRX);
                                                                                            PbFragment.this.lRW.QE();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lNw.getPbData().dlg().getActUrl());
                                                                                        if (PbFragment.this.lNw.getPbData().dlg().boC() != 1) {
                                                                                            if (PbFragment.this.lNw.getPbData().dlg().boC() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10912").dR("fid", PbFragment.this.lNw.getPbData().getForumId()).dR("tid", PbFragment.this.lNw.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lNw.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.lRS.setSelection(0);
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
                                                                                        PbFragment.this.lRS.dqs();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dnB() == 1 && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10397").dR("fid", PbFragment.this.lNw.getPbData().getForumId()).dR("tid", PbFragment.this.lNw.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dnB() == 1 && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10507").dR("fid", PbFragment.this.lNw.getPbData().getForumId()).dR("tid", PbFragment.this.lNw.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dnR();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dnS();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlC() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lNw.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11679").dR("fid", pbData3.getForumId()));
                                                                                        bf.bsV().b(PbFragment.this.getPageContext(), new String[]{pbData3.dlC().dlQ()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlC() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lNw.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", pbData4.getForumId()));
                                                                                        bf.bsV().b(PbFragment.this.getPageContext(), new String[]{pbData4.dlC().dlQ()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.lSr >= 0) {
                                                                                        if (PbFragment.this.lNw != null) {
                                                                                            PbFragment.this.lNw.dpm();
                                                                                        }
                                                                                        if (PbFragment.this.lNw != null && PbFragment.this.lRS.dqK() != null) {
                                                                                            PbFragment.this.lRS.dqK().a(PbFragment.this.lNw.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.lSr = 0;
                                                                                        if (PbFragment.this.lNw != null) {
                                                                                            PbFragment.this.lRS.getListView().setSelection(PbFragment.this.lNw.dpp());
                                                                                            PbFragment.this.lNw.da(0, 0);
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
                                                                                    if (PbFragment.this.lRS.getListView() != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.lRS.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.lRS.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean dlG = PbFragment.this.lNw.getPbData().dlG();
                                                                                        boolean z8 = PbFragment.this.lRS.dqr() != null && PbFragment.this.lRS.dqr().isVertical();
                                                                                        boolean drh = PbFragment.this.lRS.drh();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        if (dlG && PbFragment.this.lRS.dqr() != null && PbFragment.this.lRS.dqr().getContainerView() != null) {
                                                                                            i = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.lRS.dqr().dsc();
                                                                                            z9 = firstVisiblePosition == 0 && (top == i || top == PbFragment.this.lRS.dqr().getContainerView().getHeight() - PbFragment.this.lRS.dqr().dsc());
                                                                                        } else {
                                                                                            i = 0;
                                                                                        }
                                                                                        PbFragment.this.Py("c13568");
                                                                                        if ((PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnH() <= 0) || (drh && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dny();
                                                                                                if (PbFragment.this.lNw.getPbData().dlg().bnQ() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNw.lVc).dR("fid", PbFragment.this.lNw.getPbData().getForumId()).ap("obj_locate", 2).dR("uid", PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (dlG) {
                                                                                                if (PbFragment.this.lRS.mai != null && PbFragment.this.lRS.mai.mbs != null && PbFragment.this.lRS.mai.mbs.getView() != null) {
                                                                                                    if (PbFragment.this.lRS.mai.mbs.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dnH();
                                                                                                    } else {
                                                                                                        int i5 = 0;
                                                                                                        if (PbFragment.this.lRS.dqr() != null && PbFragment.this.lRS.dqr().getContainerView() != null) {
                                                                                                            i5 = PbFragment.this.lRS.dqr().getContainerView().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.lRS.mai.mbs.getView().getTop() <= i5;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.lRS.dqB() != null) {
                                                                                                z10 = PbFragment.this.lRS.dqB().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.lRS.mai != null && PbFragment.this.lRS.mai.mbs != null && PbFragment.this.lRS.mai.mbs.getView() != null && PbFragment.this.lRS.mai.mbs.getView().getParent() != null && PbFragment.this.lRS.lYW != null && PbFragment.this.lRS.lYW.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.lRS.mai.mbs.getView().getTop() - PbFragment.this.lRS.lYW.mNavigationBar.getBottom() < PbFragment.this.lRS.mai.mbs.lYw.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || drh) {
                                                                                                PbFragment.this.lRI = firstVisiblePosition;
                                                                                                PbFragment.this.lRJ = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.lRS.getListView().setSelectionFromTop(0, i - equipmentHeight);
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollToPosition(0, i, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.lRI > 0) {
                                                                                                if (PbFragment.this.lRS.getListView().getChildAt(PbFragment.this.lRI) != null) {
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollToPosition(PbFragment.this.lRI, PbFragment.this.lRJ, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lRS.getListView().setSelectionFromTop(PbFragment.this.lRI, PbFragment.this.lRJ + equipmentHeight);
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dnH = PbFragment.this.dnH();
                                                                                                if (PbFragment.this.dnG() != -1) {
                                                                                                    dnH--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dnH < 0) {
                                                                                                    dimens = 0;
                                                                                                    i2 = (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.lRS.getListView().getData()) - 1) + PbFragment.this.lRS.getListView().getHeaderViewsCount();
                                                                                                } else {
                                                                                                    i2 = dnH;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    fixedNavHeight = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) + dimens;
                                                                                                } else {
                                                                                                    fixedNavHeight = (!dlG || PbFragment.this.lRS.dqr() == null) ? (PbFragment.this.lRS.lYW == null || PbFragment.this.lRS.lYW.mNavigationBar == null) ? dimens : (PbFragment.this.lRS.lYW.mNavigationBar.getFixedNavHeight() - 10) + dimens : PbFragment.this.lRS.dqr().dsb() + dimens;
                                                                                                }
                                                                                                if (PbFragment.this.lRS.mai == null || PbFragment.this.lRS.mai.mbs == null || PbFragment.this.lRS.mai.mbs.getView() == null || PbFragment.this.lRS.mai.mbs.getView().getParent() == null) {
                                                                                                    PbFragment.this.lRS.getListView().setSelectionFromTop(i2, fixedNavHeight + equipmentHeight);
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollToPosition(i2, fixedNavHeight, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.lRS.getListView().smoothScrollBy(PbFragment.this.lRS.mai.mbs.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNw.lVc).dR("fid", PbFragment.this.lNw.getPbData().getForumId()).ap("obj_locate", 2).dR("uid", PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(PbFragment.this.lNw.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lNw.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lNw.dmq()) || PbFragment.this.lNw.getAppealInfo() == null) {
                                                                                                PbFragment.this.lRi.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lNw.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lNw.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.lRi.finish();
                                                                                            return;
                                                                                        }
                                                                                        String dmq = PbFragment.this.lNw.dmq();
                                                                                        if (PbFragment.this.lNw.doD() && dmq != null && dmq.equals(name)) {
                                                                                            PbFragment.this.lRi.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lNw.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13401");
                                                                                        arVar4.dR("tid", PbFragment.this.lNw.doA());
                                                                                        arVar4.dR("fid", PbFragment.this.lNw.getForumId());
                                                                                        arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lNw.getPbData().dlg() != null) {
                                                                                            arVar4.dR(IntentConfig.NID, PbFragment.this.lNw.getPbData().dlg().bmo());
                                                                                        }
                                                                                        TiebaStatic.log(arVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof cb) {
                                                                                        cb cbVar = (cb) view.getTag();
                                                                                        if (PbFragment.this.lNw.dpl() == 3 && PbFragment.this.dmp() && PbFragment.this.lNw.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lNw.getPbData().dlD())) {
                                                                                            PbFragment.this.lRi.finish();
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
                                                                                    if (PbFragment.this.lNw != null) {
                                                                                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                        arVar6.dR("tid", PbFragment.this.lNw.doA());
                                                                                        arVar6.dR("fid", PbFragment.this.lNw.getForumId());
                                                                                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        arVar6.ap("obj_locate", 2);
                                                                                        TiebaStatic.log(arVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lNw.getPbData();
                                                                                        if (PbFragment.this.lRR == null) {
                                                                                            PbFragment.this.lRR = new com.baidu.tieba.pb.data.r(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.ar("c13446").v("forum_id", j2).bsO();
                                                                                        PbFragment.this.registerListener(PbFragment.this.lST);
                                                                                        PbFragment.this.lRR.M(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13274").dR("fid", PbFragment.this.lNw.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).v("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.lNw.doA()).ap("obj_param1", smartApp.is_game.intValue()));
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
                                                                                            PbFragment.this.fnw.gy(cbVar3.bnU(), String.valueOf(cbVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_adlocate", 10).ap("obj_locate", 11).v("obj_id", cbVar3.getFid()).dR("tid", cbVar3.getId()).ap("thread_type", cbVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_floor_right_top_feedback || id3 == R.id.pb_post_op_more) {
                                                                                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                                                                                    arVar7.dR("tid", PbFragment.this.lNw.doA());
                                                                                    arVar7.dR("fid", PbFragment.this.lNw.getForumId());
                                                                                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    arVar7.ap("obj_locate", 7);
                                                                                    TiebaStatic.log(arVar7);
                                                                                    PbFragment.this.lRj = false;
                                                                                    PbFragment.this.dF(view);
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNw.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNw.doA(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lNw.getPbData().dlg().bok())));
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
                                                                            if (PbFragment.this.lRX == null) {
                                                                                PbFragment.this.lRX = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.lRX.a(PbFragment.this.lSP);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.dmx().getPbData() != null && PbFragment.this.dmx().getPbData().dlJ();
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
                                                                                    com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bpJ().hasAgree && postData6.bpt() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.lRX);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar9.eVl.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar9);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.lRX);
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
                                                                                            com.baidu.tbadk.core.dialog.g gVar11 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRX);
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
                                                                                            gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRX);
                                                                                            gVar12.eVl.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.lRX);
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
                                                                                            if (PbFragment.this.lNw.getPbData().dlv() == 1002 && !z2) {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.lRX);
                                                                                            } else {
                                                                                                gVar12 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.lRX);
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
                                                                                PbFragment.this.lRX.bw(arrayList2);
                                                                                PbFragment.this.lRW = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.lRX);
                                                                                PbFragment.this.lRW.QE();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.lRS.drk();
                                                                    SparseArray<Object> b3 = PbFragment.this.lRS.b(PbFragment.this.lNw.getPbData(), PbFragment.this.lNw.doC(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNw.getPbData().getForum().getId(), PbFragment.this.lNw.getPbData().getForum().getName(), PbFragment.this.lNw.getPbData().dlg().getId(), String.valueOf(PbFragment.this.lNw.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                PbFragment.this.lRS.lYW.dsr();
                                                            }
                                                        } else if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null) {
                                                            PbFragment.this.lRS.lYW.baM();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                                                            PbFragment.this.Pu(PbFragment.this.lNw.getPbData().dlg().bog());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.lRS.drk();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lNw.doU()));
                                                                return;
                                                            }
                                                            PbFragment.this.cDb();
                                                            PbFragment.this.lRS.dqR();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lNw.getPbData().lKm == null || PbFragment.this.lNw.getPbData().lKm.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lNw.getPbData().lKm.size()];
                                                                int i6 = 0;
                                                                while (true) {
                                                                    int i7 = i6;
                                                                    if (i7 >= PbFragment.this.lNw.getPbData().lKm.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i7] = PbFragment.this.lNw.getPbData().lKm.get(i7).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i6 = i7 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i8, View view3) {
                                                                    int i9 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lNw.getSortType() == 1 && i8 == 1) {
                                                                        i9 = 0;
                                                                    } else if (PbFragment.this.lNw.getSortType() == 2 && i8 == 0) {
                                                                        i9 = 1;
                                                                    } else if (PbFragment.this.lNw.getSortType() != 3 || i8 == 2) {
                                                                        i9 = (i8 != 2 || PbFragment.this.lNw.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12097").ap("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ap("obj_type", i9));
                                                                    if (PbFragment.this.lNw.getPbData().lKm != null && PbFragment.this.lNw.getPbData().lKm.size() > i8) {
                                                                        i8 = PbFragment.this.lNw.getPbData().lKm.get(i8).sort_type.intValue();
                                                                    }
                                                                    boolean FU = PbFragment.this.lNw.FU(i8);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lNw.doU()));
                                                                    if (FU) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.lRS.vy(true);
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
                                                    PbFragment.this.lRS.drk();
                                                    if (PbFragment.this.dmx().getPbData().lKn != 2) {
                                                        if (PbFragment.this.lNw.getPageData() != null) {
                                                            PbFragment.this.lRS.a(PbFragment.this.lNw.getPageData(), PbFragment.this.lxt);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lNw.getPbData()) != null) {
                                                cb dlg = pbData.dlg();
                                                if (dlg != null && dlg.bnQ() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNw.lVc).dR("fid", pbData.getForumId()).ap("obj_locate", 4).dR("uid", dlg.bnQ().getUserId()));
                                                }
                                                int i8 = 1;
                                                if (dlg != null) {
                                                    if (dlg.bmx()) {
                                                        i8 = 2;
                                                    } else if (dlg.bmy()) {
                                                        i8 = 3;
                                                    } else if (dlg.bpN()) {
                                                        i8 = 4;
                                                    } else if (dlg.bpO()) {
                                                        i8 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.ar arVar8 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                arVar8.dR("tid", PbFragment.this.lNw.doA());
                                                arVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                arVar8.dR("fid", PbFragment.this.lNw.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    arVar8.ap("obj_locate", 5);
                                                } else {
                                                    arVar8.ap("obj_locate", 6);
                                                }
                                                arVar8.ap("obj_name", i8);
                                                arVar8.ap("obj_type", 1);
                                                if (dlg != null) {
                                                    if (dlg.bmx()) {
                                                        arVar8.ap("obj_type", 10);
                                                    } else if (dlg.bmy()) {
                                                        arVar8.ap("obj_type", 9);
                                                    } else if (dlg.bpO()) {
                                                        arVar8.ap("obj_type", 8);
                                                    } else if (dlg.bpN()) {
                                                        arVar8.ap("obj_type", 7);
                                                    } else if (dlg.isShareThread) {
                                                        arVar8.ap("obj_type", 6);
                                                    } else if (dlg.threadType == 0) {
                                                        arVar8.ap("obj_type", 1);
                                                    } else if (dlg.threadType == 40) {
                                                        arVar8.ap("obj_type", 2);
                                                    } else if (dlg.threadType == 49) {
                                                        arVar8.ap("obj_type", 3);
                                                    } else if (dlg.threadType == 54) {
                                                        arVar8.ap("obj_type", 4);
                                                    } else {
                                                        arVar8.ap("obj_type", 5);
                                                    }
                                                    arVar8.ap(IntentConfig.CARD_TYPE, dlg.bpR());
                                                    arVar8.dR(IntentConfig.RECOM_SOURCE, dlg.mRecomSource);
                                                    arVar8.dR("ab_tag", dlg.mRecomAbTag);
                                                    arVar8.dR("weight", dlg.mRecomWeight);
                                                    arVar8.dR("extra", dlg.mRecomExtra);
                                                    arVar8.dR(IntentConfig.NID, dlg.bmo());
                                                    if (dlg.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.au.isEmpty(dlg.getBaijiahaoData().oriUgcVid)) {
                                                        arVar8.dR("obj_param6", dlg.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    arVar8.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.doh() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.doh(), arVar8);
                                                }
                                                TiebaStatic.log(arVar8);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dli2 = PbFragment.this.lNw.getPbData().dli();
                                                    if ((dli2 != null && dli2.size() > 0) || !PbFragment.this.lNw.doC()) {
                                                        PbFragment.this.lRS.drk();
                                                        PbFragment.this.cDb();
                                                        if (pbData.dlC() != null && !StringUtils.isNull(pbData.dlC().getImgUrl(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11678").dR("fid", PbFragment.this.lNw.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dlg)) {
                                                            if (PbFragment.this.lRS != null) {
                                                                PbFragment.this.lRS.drn();
                                                                PbFragment.this.lRS.x(pbData);
                                                            }
                                                            int i9 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.lRS.showLoadingDialog();
                                                                PbFragment.this.lNw.dpg().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
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
                                            PbFragment.this.lRS.drk();
                                            if (PbFragment.this.lRS.lYW.dss() != null && view == PbFragment.this.lRS.lYW.dss().dpN() && !PbFragment.this.lRS.drC()) {
                                                PbFragment.this.lRS.dqs();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cDb();
                                                PbFragment.this.lRS.dqR();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    J = PbFragment.this.lNw.J(true, PbFragment.this.dnP());
                                                } else {
                                                    J = view.getId() == R.id.reply_title ? PbFragment.this.lNw.J(false, PbFragment.this.dnP()) : PbFragment.this.lNw.Pz(PbFragment.this.dnP());
                                                }
                                                view.setTag(Boolean.valueOf(J));
                                                if (J) {
                                                    PbFragment.this.lRS.uS(true);
                                                    PbFragment.this.lRS.dqN();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.lRS.vy(true);
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
                                        PbFragment.this.lRS.drk();
                                        if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(PbFragment.this.getActivity(), "pb_shoucang"))) {
                                            if (PbFragment.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lNw.FV(PbFragment.this.lRS.dqW()) != null) {
                                                PbFragment.this.dnK();
                                                if (PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", PbFragment.this.lNw.lVc).dR("fid", PbFragment.this.lNw.getPbData().getForumId()).ap("obj_locate", 3).dR("uid", PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId()));
                                                }
                                                if (PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null && PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId() != null && PbFragment.this.lRQ != null) {
                                                    int h = PbFragment.this.h(PbFragment.this.lNw.getPbData());
                                                    cb dlg2 = PbFragment.this.lNw.getPbData().dlg();
                                                    int i10 = 1;
                                                    if (dlg2.bmx()) {
                                                        i10 = 2;
                                                    } else if (dlg2.bmy()) {
                                                        i10 = 3;
                                                    } else if (dlg2.bpN()) {
                                                        i10 = 4;
                                                    } else if (dlg2.bpO()) {
                                                        i10 = 5;
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", PbFragment.this.lNw.lVc).ap("obj_locate", 1).dR("obj_id", PbFragment.this.lNw.getPbData().dlg().bnQ().getUserId()).ap("obj_type", PbFragment.this.lRQ.bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i10));
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.lRF = view;
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bmv() && PbFragment.this.lNw.getPbData().dlg().boh() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11922"));
                                    }
                                    if (PbFragment.this.lNw.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lNw.dmq()) || PbFragment.this.lNw.getAppealInfo() == null) {
                                            PbFragment.this.lRi.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lNw.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lNw.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.lRi.finish();
                                        return;
                                    }
                                    String dmq2 = PbFragment.this.lNw.dmq();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lNw.doD() && dmq2 != null && dmq2.equals(name2)) {
                                        PbFragment.this.lRi.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lNw.getPbData() != null && !PbFragment.this.gev.dOA()) {
                                    PbFragment.this.lRS.drk();
                                    int i11 = 0;
                                    if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpO()) {
                                        if (PbFragment.this.lRS.lYW.dss() == null || view != PbFragment.this.lRS.lYW.dss().dpQ()) {
                                            if (view == PbFragment.this.lRS.dqP()) {
                                                i11 = 2;
                                            }
                                        } else if (PbFragment.this.lNw.getPbData().dlg().bnM() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbFragment.this.lNw.getPbData().dlg().bnL() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbFragment.this.lNw.getPbData().getForum();
                                    String name3 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.lNw.getPbData().dlg().getId();
                                    PbFragment.this.lRS.dqM();
                                    PbFragment.this.gev.c(id4, name3, id5, i11, PbFragment.this.lRS.dqQ());
                                } else {
                                    return;
                                }
                            } else {
                                PbFragment.this.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            PbFragment.this.lRS.lYW.dsr();
                            if (PbFragment.this.lNw != null) {
                                PbFragment.this.iya.setThreadId(PbFragment.this.lNw.doA());
                            }
                            int i12 = 1;
                            if (PbFragment.this.lNw == null || !PbFragment.this.lNw.isPrivacy()) {
                                PbFragment.this.iya.crW();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.dmx() != null && PbFragment.this.dmx().getPbData() != null && PbFragment.this.dmx().getPbData().getThreadId() != null && PbFragment.this.dmx().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i12 = 2;
                                }
                                if (PbFragment.this.dmx() != null && PbFragment.this.dmx().getPbData() != null) {
                                    PbFragment.this.iya.k(3, i12, PbFragment.this.dmx().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.dmx() != null && PbFragment.this.dmx().getPbData() != null) {
                                    PbFragment.this.iya.k(3, 3, PbFragment.this.dmx().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.lRS.drk();
                        PbFragment.this.cDb();
                        PbFragment.this.lRS.dqR();
                        PbFragment.this.lRS.showLoadingDialog();
                        if (PbFragment.this.lRS.dqB() != null) {
                            PbFragment.this.lRS.dqB().setVisibility(8);
                        }
                        PbFragment.this.lNw.FP(1);
                        if (PbFragment.this.lRl != null) {
                            PbFragment.this.lRl.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dnz = PbFragment.this.dnz();
                        if (!TextUtils.isEmpty(dnz)) {
                            bf.bsV().b(PbFragment.this.getPageContext(), new String[]{dnz});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar9 = new com.baidu.tbadk.core.util.ar("c13398");
                arVar9.dR("tid", PbFragment.this.lNw.doA());
                arVar9.dR("fid", PbFragment.this.lNw.getForumId());
                arVar9.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar9.ap("obj_locate", 1);
                TiebaStatic.log(arVar9);
                if (PbFragment.this.lRu) {
                    PbFragment.this.lRu = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.dnr().dqp() != null && postData7.bnQ() != null && postData7.dNF() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dnr().dqq() != null) {
                                PbFragment.this.dnr().dqq().dnh();
                            }
                            com.baidu.tieba.pb.data.q qVar2 = new com.baidu.tieba.pb.data.q();
                            qVar2.a(PbFragment.this.lNw.getPbData().getForum());
                            qVar2.setThreadData(PbFragment.this.lNw.getPbData().dlg());
                            qVar2.g(postData7);
                            PbFragment.this.dnr().dqp().d(qVar2);
                            PbFragment.this.dnr().dqp().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bnQ().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lNw.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lSe != null) {
                                PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lSR = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lNw != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lNw.lVc)) {
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
                if (PbFragment.this.lNw.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lNw.getPbData().getForumId());
                }
                arVar.dR("tid", PbFragment.this.lNw.doA());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            PbFragment.this.cDb();
            PbFragment.this.lRS.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lNw.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNw.getPbData();
                            if (pbData != null && pbData.dlg() != null && pbData.dlg().bnQ() != null && (userId = pbData.dlg().bnQ().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lNw.doN()) {
                                PbFragment.this.lRS.dqR();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lNw.doN()) {
                            PbFragment.this.lRS.dqR();
                        }
                    } else if (floor != null) {
                        PbFragment.this.lRS.s(PbFragment.this.lNw.getPbData());
                    }
                    if (PbFragment.this.lNw.doH()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10369").dR("tid", PbFragment.this.lNw.doA()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lSe.bCc() || PbFragment.this.lSe.bCd()) {
                    PbFragment.this.lSe.a(false, postWriteCallBackData);
                }
                PbFragment.this.kWC.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kSz != null) {
                    PbFragment.this.kSz.a(postWriteCallBackData.getReplyPrivacyTip());
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
    public NewWriteModel.d lSS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                    arVar.dR("fid", PbFragment.this.lNw.getPbData().getForumId());
                }
                if (PbFragment.this.lNw != null) {
                    arVar.dR("tid", PbFragment.this.lNw.doA());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (PbFragment.this.kWC != null) {
                    PbFragment.this.kWC.drK();
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
                if (PbFragment.this.kSz != null) {
                    PbFragment.this.kSz.a(postWriteCallBackData.getReplyPrivacyTip());
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
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kWC != null) {
                if (PbFragment.this.lRS != null && PbFragment.this.lRS.dqq() != null && PbFragment.this.lRS.dqq().dnl() != null && PbFragment.this.lRS.dqq().dnl().bCd()) {
                    PbFragment.this.lRS.dqq().dnl().a(postWriteCallBackData);
                }
                PbFragment.this.kWC.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lST = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView drF;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.lRi.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.lRS != null && (drF = PbFragment.this.lRS.drF()) != null && PbFragment.this.lRS.getListView() != null) {
                            PbFragment.this.lRS.getListView().removeHeaderView(drF);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a lSU = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qR;
            if (!z || fVar == null || fVar.dlt() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dli()) >= 1) {
                PbFragment.this.lmn = true;
                PbFragment.this.lRS.dqT();
                if (fVar == null || !fVar.dlo()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.lRS.getView());
                }
                PbFragment.this.lRS.dqO();
                if (PbFragment.this.isFullScreen || PbFragment.this.lRS.drC()) {
                    PbFragment.this.lRS.drt();
                } else if (!PbFragment.this.lRS.drq()) {
                    PbFragment.this.lRS.vK(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.gmn = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.lRS.getView());
                    PbFragment.this.lRS.drc();
                }
                if (z && fVar != null) {
                    cb dlg = fVar.dlg();
                    if (dlg == null || !dlg.bmz()) {
                        PbFragment.this.d(PbFragment.this.lSd);
                    } else {
                        doj();
                    }
                    PbFragment.this.lRS.dqq().setPbData(fVar);
                    PbFragment.this.lRS.bYo();
                    if (dlg != null && dlg.bpc() != null) {
                        PbFragment.this.a(dlg.bpc());
                    }
                    if (PbFragment.this.lSe != null) {
                        PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dli() != null && fVar.dli().size() >= 1 && fVar.dli().get(0) != null) {
                        PbFragment.this.lNw.PB(fVar.dli().get(0).getId());
                    } else if (fVar.dlt() != null) {
                        PbFragment.this.lNw.PB(fVar.dlt().getId());
                    }
                    if (PbFragment.this.lSe != null) {
                        PbFragment.this.lSe.a(fVar.getAnti());
                        PbFragment.this.lSe.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lSe.setThreadData(dlg);
                        PbFragment.this.lSe.a(PbFragment.this.lNw.doR(), PbFragment.this.lNw.doA(), PbFragment.this.lNw.dpi());
                        if (dlg != null) {
                            PbFragment.this.lSe.kY(dlg.bpp());
                        }
                    }
                    if (PbFragment.this.lRQ != null) {
                        PbFragment.this.lRQ.ja(fVar.bjZ());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.dlJ()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.lRS.vJ(PbFragment.this.mIsFromCDN);
                    PbFragment.this.lRS.a(fVar, i2, i3, PbFragment.this.lNw.doC(), i4, PbFragment.this.lNw.getIsFromMark());
                    PbFragment.this.lRS.d(fVar, PbFragment.this.lNw.doC());
                    PbFragment.this.lRS.vG(PbFragment.this.lNw.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fDL = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fDL) && PbFragment.this.lSe != null && PbFragment.this.lSe.bBh() != null && (qR = PbFragment.this.lSe.bBh().qR(6)) != null && !TextUtils.isEmpty(PbFragment.this.fDL)) {
                            ((View) qR).setOnClickListener(PbFragment.this.fEx);
                        }
                    }
                    if (PbFragment.this.lRZ) {
                        PbFragment.this.lRZ = false;
                        final int dnG = PbFragment.this.dnG();
                        if (!fVar.dlG()) {
                            PbFragment.this.lRS.Gc(dnG);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dnG, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.lSa) {
                        PbFragment.this.lSa = false;
                        final int dnG2 = PbFragment.this.dnG();
                        final boolean z2 = dnG2 != -1;
                        if (!z2) {
                            dnG2 = PbFragment.this.dnH();
                        }
                        if (PbFragment.this.lRS != null) {
                            if (!fVar.dlG()) {
                                PbFragment.this.lRS.Gc(dnG2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dnG2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.lRS.setSelectionFromTop(dnG2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.lRS.setSelectionFromTop(dnG2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.lRS.vL(true);
                                PbFragment.this.lRS.vK(false);
                            }
                        }
                    } else if (PbFragment.this.lSb) {
                        PbFragment.this.lSb = false;
                        PbFragment.this.lRS.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.lRS.dqX();
                    }
                    PbFragment.this.lNw.a(fVar.getForum(), PbFragment.this.lSF);
                    PbFragment.this.lNw.a(PbFragment.this.lSG);
                    if (PbFragment.this.kSz != null && dlg != null && dlg.bnQ() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dlg.bnQ());
                        PbFragment.this.kSz.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.gmn && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lNw.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lNw.getAppealInfo().lKe)) {
                                    PbFragment.this.lRS.a(PbFragment.this.lNw.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.lRS.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.lRS.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.lRS.drt();
                            PbFragment.this.lRS.drb();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lNw.doA());
                            jSONObject.put("fid", PbFragment.this.lNw.getForumId());
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
                        PbFragment.this.lRS.PH("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                            arrayList = PbFragment.this.lNw.getPbData().dli();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dNF() != 1)) {
                            PbFragment.this.lRS.PH(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.doa()) {
                                PbFragment.this.lRS.PI(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.lRS.PI(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.lRS.s(PbFragment.this.lNw.getPbData());
                        }
                    }
                    PbFragment.this.lRS.endLoadData();
                }
                if (fVar != null && fVar.lKt && PbFragment.this.fJu == 0) {
                    PbFragment.this.fJu = System.currentTimeMillis() - PbFragment.this.iJe;
                }
                if (!PbFragment.this.dmx().doC() || PbFragment.this.dmx().getPbData().getPage().bmG() != 0 || PbFragment.this.dmx().dpd()) {
                    PbFragment.this.lSf = true;
                    return;
                }
                return;
            }
            PbFragment.this.lNw.FP(1);
            if (PbFragment.this.lRl != null) {
                PbFragment.this.lRl.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void doj() {
            if (PbFragment.this.lNw != null) {
                if (PbFragment.this.lSe == null || !PbFragment.this.lSe.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lSe = (com.baidu.tbadk.editortools.pb.e) dVar.fg(PbFragment.this.getContext());
                    PbFragment.this.lSe.a(PbFragment.this.lRi.getPageContext());
                    PbFragment.this.lSe.a(PbFragment.this.fDW);
                    PbFragment.this.lSe.a(PbFragment.this.fDO);
                    PbFragment.this.lSe.a(PbFragment.this.lRi.getPageContext(), PbFragment.this.lRi.getIntent() == null ? null : PbFragment.this.lRi.getIntent().getExtras());
                    PbFragment.this.lSe.bBh().kN(true);
                    PbFragment.this.lRS.setEditorTools(PbFragment.this.lSe.bBh());
                    if (!PbFragment.this.lNw.doI()) {
                        PbFragment.this.lSe.CV(PbFragment.this.lNw.doA());
                    }
                    if (PbFragment.this.lNw.dpj()) {
                        PbFragment.this.lSe.CT(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.lRS != null) {
                        PbFragment.this.lSe.CT(PbFragment.this.lRS.dqu());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.lRS.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.iJe : j;
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
                if (!z2 && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null) {
                    int threadType = PbFragment.this.lNw.getPbData().dlg().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.au.equals(PbFragment.this.lRy, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.au.equals(PbFragment.this.lRy, "from_frs")) {
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
    private CustomMessageListener lSV = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dnC();
            }
        }
    };
    private final a.InterfaceC0554a lSW = new a.InterfaceC0554a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
        public void g(boolean z, boolean z2, String str) {
            PbFragment.this.lRS.dqT();
            if (z) {
                if (PbFragment.this.lRQ != null) {
                    PbFragment.this.lRQ.ja(z2);
                }
                PbFragment.this.lNw.vo(z2);
                if (PbFragment.this.lNw.bjZ()) {
                    PbFragment.this.dnL();
                } else {
                    PbFragment.this.lRS.s(PbFragment.this.lNw.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.lRQ != null) {
                        if (PbFragment.this.lRQ.bkc() != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lNw.getPbData().dlg() != null && PbFragment.this.lNw.getPbData().dlg().bnQ() != null) {
                            MarkData bkc = PbFragment.this.lRQ.bkc();
                            MetaData bnQ = PbFragment.this.lNw.getPbData().dlg().bnQ();
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
                    PbFragment.this.dnI();
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
                if (PbFragment.this.lRS != null) {
                    PbFragment.this.lRS.drk();
                    if (PbFragment.this.lSe != null && !PbFragment.this.lRS.dqt()) {
                        PbFragment.this.lRS.vI(PbFragment.this.lSe.bBV());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.lRS.dqs();
                    }
                }
                if (!PbFragment.this.lRr) {
                    PbFragment.this.lRr = true;
                }
            }
            if (PbFragment.this.lRS != null) {
                PbFragment.this.lRS.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lRl != null) {
                PbFragment.this.lRl.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.lRs == null) {
                PbFragment.this.lRs = new com.baidu.tbadk.n.b();
                PbFragment.this.lRs.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.lRs.bDZ();
            } else {
                PbFragment.this.lRs.bDY();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dMz().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dli;
            if (PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null && PbFragment.this.lRS != null && PbFragment.this.lRS.dqK() != null) {
                PbFragment.this.lRS.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.lRl != null) {
                    PbFragment.this.lRl.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lNw.doZ() && (dli = PbFragment.this.lNw.getPbData().dli()) != null && !dli.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.lRS.dqK().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lNw.getPbData();
                    if (pbData != null) {
                        if (pbData.dlj() != null && pbData.dlj().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dlk() != null && pbData.dlk().hasData()) {
                            headerCount--;
                        }
                        int size = dli.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.e iyf = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.gev.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lNw.doW();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.mhA != 1002 || bVar.hlf) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.lRS.a(1, dVar.mSuccess, dVar.nzX, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.gev.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.lRS.a(PbFragment.this.gev.getLoadDataMode(), gVar.mSuccess, gVar.nzX, false);
                            PbFragment.this.lRS.aZ(gVar.nAa);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.lRS.a(PbFragment.this.gev.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c lSX = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c gjE = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dnQ()) {
                PbFragment.this.lRi.finish();
            }
            if (!PbFragment.this.lNw.vn(true)) {
                PbFragment.this.lRS.dqU();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e lSZ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.lSY && PbFragment.this.dnQ()) {
                PbFragment.this.dnS();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.lRM && PbFragment.this.lRS != null && PbFragment.this.lRS.drH() && PbFragment.this.lNw != null) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13999");
                    arVar.dR("tid", PbFragment.this.lNw.doA());
                    arVar.dR("fid", PbFragment.this.lNw.getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (!PbFragment.this.lNw.doD()) {
                        if (!PbFragment.this.lNw.doG()) {
                            if (PbFragment.this.lNw.doF()) {
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
                    PbFragment.this.lRM = true;
                }
                if (PbFragment.this.lNw.vm(false)) {
                    PbFragment.this.lRS.dqS();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lNw.getPbData() != null) {
                    PbFragment.this.lRS.drp();
                }
                PbFragment.this.lSY = true;
            }
        }
    };
    private int lTa = 0;
    private final TbRichTextView.i fUw = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dqK;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.lRS.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                arVar.dR("tid", PbFragment.this.lNw.doA());
                arVar.dR("fid", PbFragment.this.lNw.getForumId());
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar.ap("obj_locate", 3);
                arVar.ap("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(arVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lNw.lOF.dlJ()) {
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
                        aVar.s(arrayList).mQ(i3).jg(false).jh(PbFragment.this.lNw.doT()).d(concurrentHashMap).ji(true).jj(false).jk(PbFragment.this.doa()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lNw != null) {
                            aVar.zO(PbFragment.this.lNw.getFromForumId());
                            if (PbFragment.this.lNw.getPbData() != null) {
                                aVar.s(PbFragment.this.lNw.getPbData().dlg());
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
                    if (aVar2.lNL) {
                        TbRichText bH = PbFragment.this.bH(str, i);
                        if (bH != null && PbFragment.this.lTa >= 0 && PbFragment.this.lTa < bH.bHz().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bH.bHz().get(PbFragment.this.lTa));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lNK.size()) {
                                    break;
                                } else if (!aVar2.lNK.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bH.getPostId() != 0 && (dqK = PbFragment.this.lRS.dqK()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.n> dataList = dqK.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.n> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.n next = it.next();
                                        if ((next instanceof PostData) && bH.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bH.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lNw.dpi(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lNw.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
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
                            aVar3.s(arrayList2).zJ(aVar2.forumName).zK(aVar2.forumId).zL(aVar2.threadId).jg(aVar2.eJK).ji(true).zM(aVar2.lastId).jh(PbFragment.this.lNw.doT()).d(concurrentHashMap2).jj(false).jk(PbFragment.this.doa()).zN(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lNw != null) {
                                aVar3.zO(PbFragment.this.lNw.getFromForumId());
                                if (PbFragment.this.lNw.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lNw.getPbData().dlg());
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
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lNK, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.eJM.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.s(arrayList3).zJ(aVar2.forumName).zK(aVar2.forumId).zL(aVar2.threadId).jg(aVar2.eJK).ji(true).zM(aVar2.lNK.get(0)).jh(PbFragment.this.lNw.doT()).d(concurrentHashMap3).jj(false).jk(PbFragment.this.doa()).zN(aVar2.postId).jl(false);
                    if (PbFragment.this.lNw != null) {
                        aVar4.zO(PbFragment.this.lNw.getFromForumId());
                        if (PbFragment.this.lNw.getPbData() != null) {
                            aVar4.s(PbFragment.this.lNw.getPbData().dlg());
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
                PbFragment.this.lRC = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lTb = false;
    PostData kqg = null;
    private final b.InterfaceC0558b lTc = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.kqg != null) {
                if (i == 0) {
                    PbFragment.this.kqg.gW(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.kqg = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.kqg);
                }
            }
        }
    };
    private final b.InterfaceC0558b lTd = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lSo != null && !TextUtils.isEmpty(PbFragment.this.lSp)) {
                if (i == 0) {
                    if (PbFragment.this.lSq == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.lSp));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.lSp;
                        aVar.pkgId = PbFragment.this.lSq.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lSq.memeInfo.pck_id;
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
                        PbFragment.this.eIQ.p(PbFragment.this.lSp, PbFragment.this.lSo.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lSo = null;
                PbFragment.this.lSp = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            PbFragment.this.lRj = true;
            return PbFragment.this.dF(view);
        }
    };
    private final NoNetworkView.a jdH = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.lNw.doJ()) {
                PbFragment.this.dnN();
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
            PbFragment.this.jlq.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0711a iFs = new a.InterfaceC0711a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int hkL = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void G(int i, int i2) {
            if (aD(i2) && PbFragment.this.lRS != null && PbFragment.this.lRl != null) {
                PbFragment.this.lRl.qR(true);
                if (Math.abs(i2) > this.hkL) {
                    PbFragment.this.lRl.hideFloatingView();
                }
                if (PbFragment.this.dnQ()) {
                    PbFragment.this.lRS.dqH();
                    PbFragment.this.lRS.dqI();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void H(int i, int i2) {
            if (aD(i2) && PbFragment.this.lRS != null && PbFragment.this.lRl != null) {
                PbFragment.this.lRS.dru();
                PbFragment.this.lRl.qR(false);
                PbFragment.this.lRl.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void I(int i, int i2) {
        }

        private boolean aD(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a lQm = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.lRS.PJ(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lTf = -1;
    private int lTg = -1;

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

    public com.baidu.tbadk.editortools.pb.e dnm() {
        return this.lSe;
    }

    public void b(com.baidu.tieba.pb.data.q qVar) {
        boolean z;
        MetaData metaData;
        if (qVar.dlY() != null) {
            String id = qVar.dlY().getId();
            ArrayList<PostData> dli = this.lNw.getPbData().dli();
            int i = 0;
            while (true) {
                if (i >= dli.size()) {
                    z = true;
                    break;
                }
                PostData postData = dli.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dmh = qVar.dmh();
                    postData.JD(qVar.getTotalCount());
                    if (postData.dNC() == null || dmh == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dmh.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnQ() != null && (metaData = postData.getUserMap().get(next.bnQ().getUserId())) != null) {
                                next.a(metaData);
                                next.yw(true);
                                next.a(getPageContext(), this.lNw.PA(metaData.getUserId()));
                            }
                        }
                        z = dmh.size() != postData.dNC().size();
                        if (postData.dNC() != null && postData.dNC().size() < 2) {
                            postData.dNC().clear();
                            postData.dNC().addAll(dmh);
                        }
                    }
                    if (postData.dNy() != null) {
                        postData.dNz();
                    }
                }
            }
            if (!this.lNw.getIsFromMark() && z) {
                this.lRS.s(this.lNw.getPbData());
            }
            if (z) {
                c(qVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ps(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.o dly = this.lNw.getPbData().dly();
            if (dly != null && str.equals(dly.getAdId())) {
                if (dly.dNt() != null) {
                    dly.dNt().legoCard = null;
                }
                this.lNw.getPbData().dlz();
            }
            com.baidu.tieba.tbadkCore.data.o doP = this.lNw.doP();
            if (doP != null && str.equals(doP.getAdId())) {
                this.lNw.doQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lRW != null && this.lRW.isShowing()) {
                this.lRW.dismiss();
                this.lRW = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.lRW != null) {
                            PbFragment.this.lRW.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.lRS.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lSm);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lSm);
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
                this.lRW = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.lRW.QE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        cb dlg;
        if (this.lNw != null && this.lNw.getPbData() != null && (dlg = this.lNw.getPbData().dlg()) != null) {
            if (i == 1) {
                PraiseData bnB = dlg.bnB();
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
                        dlg.a(praiseData);
                    } else {
                        dlg.bnB().getUser().add(0, metaData);
                        dlg.bnB().setNum(dlg.bnB().getNum() + 1);
                        dlg.bnB().setIsLike(i);
                    }
                }
                if (dlg.bnB() != null) {
                    if (dlg.bnB().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.au.numFormatOver10000(dlg.bnB().getNum());
                    }
                }
            } else if (dlg.bnB() != null) {
                dlg.bnB().setIsLike(i);
                dlg.bnB().setNum(dlg.bnB().getNum() - 1);
                ArrayList<MetaData> user = dlg.bnB().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dlg.bnB().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dlg.bnB().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dlg.bnB().getNum() + "";
                }
            }
            if (this.lNw.doC()) {
                this.lRS.dqK().notifyDataSetChanged();
            } else {
                this.lRS.t(this.lNw.getPbData());
            }
        }
    }

    public static PbFragment dnn() {
        return new PbFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lRi = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lNw.aD(bundle);
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lSe.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lRq = System.currentTimeMillis();
        this.lSk = getPageContext();
        final Intent intent = this.lRi.getIntent();
        if (intent != null) {
            this.iJe = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.lRy = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.lRy)) {
                    this.lRy = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.lRy)) {
                this.lRm = true;
            }
            this.lTf = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lTg = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lTh = intent.getStringExtra("key_manga_title");
            this.lRZ = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.lSa = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lSb = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dnQ()) {
                this.lRi.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.au.isEmpty(this.source) ? "" : this.source;
            this.lSs = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.lRK = new bk();
            this.lRK.D(intent);
            this.lSu = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lSu == 0) {
                this.lSu = intent.getIntExtra("key_start_from", 0);
            }
            this.lSv = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.iJe = System.currentTimeMillis();
        }
        this.fJl = this.lRq - this.iJe;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.lRo = 0;
        aC(bundle);
        if (this.lNw.getPbData() != null) {
            this.lNw.getPbData().Pm(this.source);
        }
        dnq();
        if (intent != null && this.lRS != null) {
            this.lRS.lYU = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lSn == null) {
                    this.lSn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.lRS.PL("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lSn, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lNw.getPbData() != null) {
                this.lNw.PD(stringExtra);
            }
        }
        this.jgu = new VoiceManager();
        this.jgu.onCreate(getPageContext());
        initData(bundle);
        this.lSd = new com.baidu.tbadk.editortools.pb.g();
        d(this.lSd);
        this.lSe = (com.baidu.tbadk.editortools.pb.e) this.lSd.fg(getActivity());
        this.lSe.a(this.lRi.getPageContext());
        this.lSe.a(this.fDW);
        this.lSe.a(this.fDO);
        this.lSe.setFrom(1);
        this.lSe.a(this.lRi.getPageContext(), bundle);
        this.lSe.bBh().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lSe.bBh().kN(true);
        uY(true);
        this.lSe.a(this.lNw.doR(), this.lNw.doA(), this.lNw.dpi());
        registerListener(this.lSA);
        if (!this.lNw.doI()) {
            this.lSe.CV(this.lNw.doA());
        }
        if (this.lNw.dpj()) {
            this.lSe.CT(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.lRS != null) {
            this.lSe.CT(this.lRS.dqu());
        }
        registerListener(this.lSz);
        registerListener(this.lSB);
        registerListener(this.lSC);
        registerListener(this.jib);
        registerListener(this.lSO);
        registerListener(this.lSy);
        this.lSc = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.nwt);
        this.lSc.dNi();
        registerListener(this.lSD);
        registerListener(this.faJ);
        this.lNw.dpb();
        registerListener(this.lSV);
        registerListener(this.jik);
        registerListener(this.lSR);
        if (this.lRS != null && this.lRS.dry() != null && this.lRS.drz() != null) {
            this.lRl = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.lRS.dry(), this.lRS.drz(), this.lRS.dqB());
            this.lRl.a(this.lSJ);
        }
        if (this.lRk && this.lRS != null && this.lRS.drz() != null) {
            this.lRS.drz().setVisibility(8);
        }
        this.lSl = new com.baidu.tbadk.core.view.c();
        this.lSl.toastTime = 1000L;
        registerListener(this.lSN);
        registerListener(this.lSL);
        registerListener(this.lSM);
        registerListener(this.jpA);
        registerListener(this.jhX);
        this.lSE.setSelfListener(true);
        this.lSE.setTag(this.lRi.getUniqueId());
        this.lSE.setPriority(-1);
        MessageManager.getInstance().registerListener(this.lSE);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        this.lSm = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lSm;
        userMuteAddAndDelCustomMessage.setTag(this.lSm);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lSm;
        userMuteCheckCustomMessage.setTag(this.lSm);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lNw.dpg().a(this.lSK);
        this.kWC = new ar();
        if (this.lSe.bBN() != null) {
            this.kWC.f(this.lSe.bBN().getInputView());
        }
        this.lSe.a(this.fDP);
        this.jCx = new ShareSuccessReplyToServerModel();
        a(this.lSw);
        this.kSz = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kSz.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.faA) {
                        PbFragment.this.lSe.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.faB && PbFragment.this.lRS != null && PbFragment.this.lRS.dqq() != null && PbFragment.this.lRS.dqq().dnl() != null) {
                        PbFragment.this.lRS.dqq().dnl().bCm();
                    } else if (i == com.baidu.tbadk.core.util.am.faC) {
                        PbFragment.this.c(PbFragment.this.lSh);
                    }
                }
            }
        });
        this.lRP = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.lRP.x(getUniqueId());
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        com.baidu.tbadk.core.business.b.blh().dC("3", "");
        this.iya = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.lRq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lNw != null) {
            gVar.setForumName(this.lNw.dmq());
            if (this.lNw.getPbData() != null && this.lNw.getPbData().getForum() != null) {
                gVar.a(this.lNw.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lNw);
        }
    }

    public String dno() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dnp() {
        return this.lRl;
    }

    private void uY(boolean z) {
        this.lSe.kV(z);
        this.lSe.kW(z);
        this.lSe.kX(z);
    }

    private void dnq() {
        this.fnw = new LikeModel(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    public ap dnr() {
        return this.lRS;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmx() {
        return this.lNw;
    }

    public void Pt(String str) {
        if (this.lNw != null && !StringUtils.isNull(str) && this.lRS != null) {
            this.lRS.vN(true);
            this.lNw.Pt(str);
            this.lRw = true;
            this.lRS.drk();
            this.lRS.drt();
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
        this.lRo = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.lRo == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
        if (this.lRS != null) {
            this.lRS.onPause();
        }
        if (!this.lNw.doI()) {
            this.lSe.CU(this.lNw.doA());
        }
        if (this.lNw != null) {
            this.lNw.dpc();
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        MessageManager.getInstance().unRegisterListener(this.juR);
        cSS();
        MessageManager.getInstance().unRegisterListener(this.lSL);
        MessageManager.getInstance().unRegisterListener(this.lSM);
        MessageManager.getInstance().unRegisterListener(this.lSN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dnt() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lNw.getPbData(), this.lNw.doC(), this.lNw.dpa());
        return (a2 == null || a2.bnQ() == null || a2.bnQ().getGodUserData() == null || a2.bnQ().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.lRA) {
            this.lRA = false;
            dnW();
        }
        if (dnt()) {
            this.lRt = System.currentTimeMillis();
        } else {
            this.lRt = -1L;
        }
        if (this.lRS != null && this.lRS.getView() != null) {
            if (!this.lmn) {
                dnO();
            } else {
                hideLoadingView(this.lRS.getView());
            }
            this.lRS.onResume();
        }
        if (this.lRo == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.lRS != null) {
            noNetworkView = this.lRS.dqn();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        registerListener(this.juR);
        this.lRY = false;
        dnV();
        registerListener(this.lSL);
        registerListener(this.lSM);
        registerListener(this.lSN);
        if (this.jhi) {
            dnN();
            this.jhi = false;
        }
        dod();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lRS.vC(z);
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
        if (z && this.lRY) {
            this.lRS.dqS();
            this.lNw.vm(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.lRt > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10804").dR("obj_duration", (System.currentTimeMillis() - this.lRt) + ""));
            this.lRt = 0L;
        }
        if (dnr().dqq() != null) {
            dnr().dqq().onStop();
        }
        if (this.lRS.lYW != null && !this.lRS.lYW.dsu()) {
            this.lRS.lYW.dbe();
        }
        if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().getForum() != null && this.lNw.getPbData().dlg() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "pb", this.lNw.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNw.getPbData().dlg().getId(), 0L));
        }
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.lRL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13266");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("fid", this.lNw.getPbData().getForumId());
            arVar.dR("tid", this.lNw.doA());
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(arVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.lRr && this.lRS != null) {
            this.lRr = true;
            a(false, (PostData) null);
        }
        if (this.lNw != null) {
            this.lNw.cancelLoadData();
            this.lNw.destory();
            if (this.lNw.dpf() != null) {
                this.lNw.dpf().onDestroy();
            }
        }
        if (this.lSe != null) {
            this.lSe.onDestroy();
        }
        if (this.gev != null) {
            this.gev.cancelLoadData();
        }
        if (this.fnw != null) {
            this.fnw.dMV();
        }
        if (this.lRS != null) {
            this.lRS.onDestroy();
            if (this.lRS.lYW != null) {
                this.lRS.lYW.dbe();
            }
        }
        if (this.lRs != null) {
            this.lRs.bEa();
        }
        if (this.lRl != null) {
            this.lRl.cET();
        }
        super.onDestroy();
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        if (this.lRS != null) {
            this.lRS.drk();
        }
        MessageManager.getInstance().unRegisterListener(this.lSL);
        MessageManager.getInstance().unRegisterListener(this.lSM);
        MessageManager.getInstance().unRegisterListener(this.lSN);
        MessageManager.getInstance().unRegisterListener(this.lSm);
        MessageManager.getInstance().unRegisterListener(this.lSO);
        MessageManager.getInstance().unRegisterListener(this.jik);
        MessageManager.getInstance().unRegisterListener(this.jpA);
        MessageManager.getInstance().unRegisterListener(this.lST);
        MessageManager.getInstance().unRegisterListener(this.lSE);
        this.lSk = null;
        this.lSl = null;
        com.baidu.tieba.recapp.c.a.dEm().dEp();
        if (this.lSn != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lSn);
        }
        if (this.lRB != null) {
            this.lRB.cancelLoadData();
        }
        if (this.lRS != null && this.lRS.lYW != null) {
            this.lRS.lYW.dsy();
        }
        if (this.jCx != null) {
            this.jCx.cancelLoadData();
        }
        this.kWC.onDestroy();
        if (this.lNw != null && this.lNw.dph() != null) {
            this.lNw.dph().onDestroy();
        }
        if (this.kSz != null) {
            this.kSz.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dqK;
        ArrayList<PostData> dmV;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bvY() && this.lRS != null && (dqK = this.lRS.dqK()) != null && (dmV = dqK.dmV()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = dmV.iterator();
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
                        bVar.iAs = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eRW == 1 && !TextUtils.isEmpty(id)) {
                    next.eRW = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.iAs = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lNw == null || this.lNw.getPbData() == null || this.lNw.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = this.lNw.getPbData().getForum().getFirst_class();
                    str3 = this.lNw.getPbData().getForum().getSecond_class();
                    String id2 = this.lNw.getPbData().getForum().getId();
                    str = this.lNw.doA();
                    str2 = id2;
                }
                com.baidu.tieba.recapp.t.sendPB(z, str4, str3, str2, str, arrayList, adAdSense.bwb());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.lRS.onChangeSkinType(i);
            if (this.lSe != null && this.lSe.bBh() != null) {
                this.lSe.bBh().onChangeSkinType(i);
            }
            if (this.lRS.dqn() != null) {
                this.lRS.dqn().onChangeSkinType(getPageContext(), i);
            }
            this.kWC.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.CAM_X0201));
            this.mSkinType = i;
            cDb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lRS = new ap(this, this.jjj, this.fvK);
        this.jlq = new com.baidu.tieba.f.b(getActivity());
        this.jlq.a(lTe);
        this.jlq.a(this.iFs);
        this.lRS.setOnScrollListener(this.mOnScrollListener);
        this.lRS.d(this.lSZ);
        this.lRS.setListPullRefreshListener(this.gjE);
        this.lRS.uJ(com.baidu.tbadk.core.k.bkT().isShowImages());
        this.lRS.setOnImageClickListener(this.fUw);
        this.lRS.b(this.mOnLongClickListener);
        this.lRS.g(this.jdH);
        this.lRS.a(this.lSX);
        this.lRS.vC(this.mIsLogin);
        if (this.lRi.getIntent() != null) {
            this.lRS.vO(this.lRi.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.lRS.dqp().setFromForumId(this.lNw.getFromForumId());
        this.lRS.setEditorTools(this.lSe.bBh());
        this.lSe.CT(this.lRS.dqu());
        this.lRS.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lNw.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNw.getPbData().getForum().getId(), PbFragment.this.lNw.getPbData().getForum().getName(), PbFragment.this.lNw.getPbData().dlg().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.lRS.vP(this.lNw.doF());
        this.lRS.FW(this.lNw.dpl());
        return this.lRS.getView();
    }

    public void dnu() {
        if (this.lRS != null && this.lNw != null) {
            if ((this.lNw.getPbData() != null || this.lNw.getPbData().dlF() != null) && checkUpIsLogin() && this.lRS.dqK() != null && this.lRS.dqK().dna() != null) {
                this.lRS.dqK().dna().BE(this.lNw.doA());
            }
        }
    }

    public void dnv() {
        TiebaStatic.log("c12181");
        if (this.lRS != null && this.lNw != null) {
            if ((this.lRS == null || this.lRS.dqt()) && this.lNw.getPbData() != null && this.lNw.getPbData().dlF() != null) {
                com.baidu.tieba.pb.data.p dlF = this.lNw.getPbData().dlF();
                if (checkUpIsLogin()) {
                    if ((!dlF.dma() || dlF.bpt() != 2) && this.lRS.dqK() != null && this.lRS.dqK().dna() != null) {
                        this.lRS.dqK().dna().BE(this.lNw.doA());
                    }
                    if (System.currentTimeMillis() - this.lRv > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).wA(false);
                        this.lRv = System.currentTimeMillis();
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
                    return Pw(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lNw == null || this.lNw.getPbData() == null) {
                        return true;
                    }
                    if (dnr().dqq() != null) {
                        dnr().dqq().dnh();
                    }
                    com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                    qVar.a(this.lNw.getPbData().getForum());
                    qVar.setThreadData(this.lNw.getPbData().dlg());
                    qVar.g(postData);
                    dnr().dqp().d(qVar);
                    dnr().dqp().setPostId(postData.getId());
                    a(view, postData.bnQ().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lSe != null) {
                        this.lRS.vI(this.lSe.bBV());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dnw() {
        if (this.lRp == null) {
            this.lRp = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lRp.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lNs = PbFragment.this.lNs.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNs);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lNw.doA(), PbFragment.this.lNs, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lNs = PbFragment.this.lNs.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNs);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lNw.doA(), PbFragment.this.lNs, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lNs = PbFragment.this.lNs.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lNs);
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
        this.lSU.a(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).duy(), "", 1);
    }

    private void aC(Bundle bundle) {
        this.lNw = this.lRi.dmx();
        if (this.lNw.dpe() != null) {
            this.lNw.dpe().a(this.lQm);
        }
        if (this.lNw.dpf() != null) {
            this.lNw.dpf().b(this.lSx);
        }
        if (StringUtils.isNull(this.lNw.doA())) {
            this.lRi.finish();
        } else if ("from_tieba_kuang".equals(this.lRy) && this.lRy != null) {
            this.lNw.FW(6);
        }
    }

    private void initData(Bundle bundle) {
        this.lRQ = com.baidu.tbadk.baseEditMark.a.a(this.lRi);
        if (this.lRQ != null) {
            this.lRQ.a(this.lSW);
        }
        this.gev = new ForumManageModel(this.lRi);
        this.gev.setLoadDataCallBack(this.iyf);
        this.faF = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.lSI.setUniqueId(getUniqueId());
        this.lSI.registerListener();
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lRS.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lSm;
        userMuteCheckCustomMessage.setTag(this.lSm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c14000").dR("tid", this.lNw.lVc).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gk(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lRj ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    private boolean dnx() {
        if (this.lNw == null || this.lNw.getPbData() == null) {
            return false;
        }
        return AntiHelper.b(getPageContext(), this.lNw.getPbData().dlg()) || AntiHelper.a(getPageContext(), this.lNw.getPbData().getAnti());
    }

    public void dny() {
        if (checkUpIsLogin() && this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().getForum() != null && !dnx()) {
            if (this.lNw.getPbData().dlJ()) {
                this.lRS.cSt();
                return;
            }
            if (this.jkQ == null) {
                this.jkQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jkQ.Ae(0);
                this.jkQ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (PbFragment.this.lSe != null && PbFragment.this.lSe.bBh() != null) {
                                PbFragment.this.lSe.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.lRS.cSt();
                        }
                    }
                });
            }
            this.jkQ.G(this.lNw.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNw.doA(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnz() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lNw == null || (pbData = this.lNw.getPbData()) == null) {
            return null;
        }
        return pbData.dlu().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            if (fVar.dlg().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dlg().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dlg().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnx() && dnA()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lRG);
                this.lRH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dnr().dqq() != null && postData != null) {
                String str3 = "";
                if (postData.dNH() != null) {
                    str3 = postData.dNH().toString();
                }
                dnr().dqq().Pr(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnQ().getName_show(), str3));
            }
            if (this.lNw.getPbData() != null && this.lNw.getPbData().dlJ()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.lRi.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dnr().getListView().smoothScrollBy((PbFragment.this.lRG[1] + PbFragment.this.lRH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnr().dqq() != null) {
                            PbFragment.this.lSe.bBh().setVisibility(8);
                            PbFragment.this.dnr().dqq().j(str, str2, PbFragment.this.dnr().dqu(), (PbFragment.this.lNw == null || PbFragment.this.lNw.getPbData() == null || PbFragment.this.lNw.getPbData().dlg() == null || !PbFragment.this.lNw.getPbData().dlg().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnl = PbFragment.this.dnr().dqq().dnl();
                            if (dnl != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                dnl.a(PbFragment.this.lNw.getPbData().getAnti());
                                dnl.setThreadData(PbFragment.this.lNw.getPbData().dlg());
                            }
                            if (PbFragment.this.kWC.drO() == null && PbFragment.this.dnr().dqq().dnl().bCu() != null) {
                                PbFragment.this.dnr().dqq().dnl().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kWC != null && PbFragment.this.kWC.drN() != null) {
                                            if (!PbFragment.this.kWC.drN().dWy()) {
                                                PbFragment.this.kWC.vR(false);
                                            }
                                            PbFragment.this.kWC.drN().zu(false);
                                        }
                                    }
                                });
                                PbFragment.this.kWC.g(PbFragment.this.dnr().dqq().dnl().bCu().getInputView());
                                PbFragment.this.dnr().dqq().dnl().a(PbFragment.this.lSj);
                            }
                        }
                        PbFragment.this.dnr().drt();
                    }
                }, 0L);
                return;
            }
            if (this.lSg == null) {
                this.lSg = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lSg.Ae(1);
                this.lSg.a(new AnonymousClass39(str, str2));
            }
            if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().getForum() != null) {
                this.lSg.G(this.lNw.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lNw.doA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lTn;
        final /* synthetic */ String lTo;

        AnonymousClass39(String str, String str2) {
            this.lTn = str;
            this.lTo = str2;
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
                        PbFragment.this.dnr().getListView().smoothScrollBy((PbFragment.this.lRG[1] + PbFragment.this.lRH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dnr().dqq() != null) {
                            PbFragment.this.lSe.bBh().setVisibility(8);
                            PbFragment.this.dnr().dqq().j(AnonymousClass39.this.lTn, AnonymousClass39.this.lTo, PbFragment.this.dnr().dqu(), (PbFragment.this.lNw == null || PbFragment.this.lNw.getPbData() == null || PbFragment.this.lNw.getPbData().dlg() == null || !PbFragment.this.lNw.getPbData().dlg().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnl = PbFragment.this.dnr().dqq().dnl();
                            if (dnl != null && PbFragment.this.lNw != null && PbFragment.this.lNw.getPbData() != null) {
                                dnl.a(PbFragment.this.lNw.getPbData().getAnti());
                                dnl.setThreadData(PbFragment.this.lNw.getPbData().dlg());
                            }
                            if (PbFragment.this.kWC.drO() == null && PbFragment.this.dnr().dqq().dnl().bCu() != null) {
                                PbFragment.this.dnr().dqq().dnl().bCu().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kWC != null && PbFragment.this.kWC.drN() != null) {
                                            if (!PbFragment.this.kWC.drN().dWy()) {
                                                PbFragment.this.kWC.vR(false);
                                            }
                                            PbFragment.this.kWC.drN().zu(false);
                                        }
                                    }
                                });
                                PbFragment.this.kWC.g(PbFragment.this.dnr().dqq().dnl().bCu().getInputView());
                                PbFragment.this.dnr().dqq().dnl().a(PbFragment.this.lSj);
                            }
                        }
                        PbFragment.this.dnr().drt();
                    }
                }, 0L);
            }
        }
    }

    public boolean dnA() {
        if ((this.lNw.getPbData() != null && this.lNw.getPbData().dlJ()) || this.kSz == null || this.lNw.getPbData() == null || this.lNw.getPbData().getAnti() == null) {
            return true;
        }
        return this.kSz.ox(this.lNw.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean FI(int i) {
        if (this.kSz == null || this.lNw.getPbData() == null || this.lNw.getPbData().getAnti() == null) {
            return true;
        }
        return this.kSz.aK(this.lNw.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lNw != null && this.lNw.getPbData() != null && postData.dNF() != 1) {
            String doA = this.lNw.doA();
            String id = postData.getId();
            int i = 0;
            if (this.lNw.getPbData() != null) {
                i = this.lNw.getPbData().dlv();
            }
            PbActivity.a Px = Px(id);
            if (Px != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(doA, id, "pb", true, null, false, null, i, postData.dts(), this.lNw.getPbData().getAnti(), false, postData.bnQ() != null ? postData.bnQ().getIconInfo() : null).addBigImageData(Px.lNK, Px.eJM, Px.eJK, Px.index);
                addBigImageData.setKeyPageStartFrom(this.lNw.dpl());
                addBigImageData.setFromFrsForumId(this.lNw.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lNw.getForumId());
                addBigImageData.setBjhData(this.lNw.doK());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnB() {
        if (this.lNw.getPbData() == null || this.lNw.getPbData().dlg() == null) {
            return -1;
        }
        return this.lNw.getPbData().dlg().boC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && dmx() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            dmx().PC(postWriteCallBackData.getPostId());
            this.lSr = this.lRS.dqw();
            this.lNw.da(this.lSr, this.lRS.dqx());
        }
        this.lRS.drk();
        this.kWC.drL();
        if (this.lSe != null) {
            this.lRS.vI(this.lSe.bBV());
        }
        this.lRS.dqo();
        this.lRS.vK(true);
        this.lNw.doW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (this.lNw != null && this.lNw.lOF != null && this.lNw.lOF.dlg() != null) {
            cb dlg = this.lNw.lOF.dlg();
            dlg.mRecomAbTag = this.lNw.dpw();
            dlg.mRecomWeight = this.lNw.dpu();
            dlg.mRecomSource = this.lNw.dpv();
            dlg.mRecomExtra = this.lNw.dpx();
            if (dlg.getFid() == 0) {
                dlg.setFid(com.baidu.adp.lib.f.b.toLong(this.lNw.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlg, "c13563");
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
    public void dnC() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.SA(this.lNw.getForumId()) && this.lNw.getPbData() != null && this.lNw.getPbData().getForum() != null) {
            if (this.lNw.getPbData().getForum().isLike() == 1) {
                this.lNw.dph().gr(this.lNw.getForumId(), this.lNw.doA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.lNw == null || this.lNw.getPbData() == null) {
            return false;
        }
        return ((this.lNw.getPbData().dlv() != 0) || this.lNw.getPbData().dlg() == null || this.lNw.getPbData().dlg().bnQ() == null || TextUtils.equals(this.lNw.getPbData().dlg().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean vb(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ad adVar;
        if (this.lNw == null || this.lNw.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
        cb dlg = pbData.dlg();
        if (dlg != null) {
            if (dlg.bmx() || dlg.bmy()) {
                return false;
            }
            if (dlg.bpN() || dlg.bpO()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dlg == null || dlg.bnQ() == null || !dlg.bnQ().isForumBusinessAccount() || com.baidu.tieba.frs.au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlv() != 0) {
                    return pbData.dlv() != 3;
                }
                List<bx> dlD = pbData.dlD();
                if (com.baidu.tbadk.core.util.y.getCount(dlD) > 0) {
                    for (bx bxVar : dlD) {
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
        if (z || this.lNw == null || this.lNw.getPbData() == null) {
            return false;
        }
        if (this.lNw.getPbData().getForum() == null || !this.lNw.getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
            return ((pbData.dlg() != null && pbData.dlg().bnQ() != null && pbData.dlg().bnQ().isForumBusinessAccount() && !com.baidu.tieba.frs.au.isOn()) || this.lNw.getPbData().dlv() == 0 || this.lNw.getPbData().dlv() == 3) ? false : true;
        }
        return false;
    }

    public void dnD() {
        com.baidu.tieba.pb.data.f pbData;
        cb dlg;
        boolean z = true;
        if (this.lNw != null && this.lNw.getPbData() != null && (dlg = (pbData = this.lNw.getPbData()).dlg()) != null && dlg.bnQ() != null) {
            this.lRS.dqo();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dlg.bnQ().getUserId());
            ad adVar = new ad();
            int dlv = this.lNw.getPbData().dlv();
            if (dlv == 1 || dlv == 3) {
                adVar.lXk = true;
                adVar.lXq = dlg.bnL() == 1;
            } else {
                adVar.lXk = false;
            }
            if (FJ(dlv)) {
                adVar.lXl = true;
                adVar.lXp = dlg.bnM() == 1;
            } else {
                adVar.lXl = false;
            }
            if (dlv == 1002 && !equals) {
                adVar.lXr = true;
            }
            adVar.lXi = vb(equals);
            adVar.lXm = dnE();
            adVar.lXj = vc(equals);
            adVar.FD = this.lNw.doC();
            adVar.lXf = true;
            adVar.lXe = va(equals);
            adVar.lXd = equals && this.lRS.dqZ();
            adVar.lXo = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lXn = true;
            adVar.isHostOnly = this.lNw.getHostMode();
            adVar.lXh = true;
            if (dlg.boh() == null) {
                adVar.lXg = true;
            } else {
                adVar.lXg = false;
            }
            if (pbData.dlJ()) {
                adVar.lXf = false;
                adVar.lXh = false;
                adVar.lXg = false;
                adVar.lXk = false;
                adVar.lXl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlJ()) {
                z = false;
            }
            adVar.lXs = z;
            if (this.lRS != null) {
                PostData b2 = this.lRS.b(this.lNw.lOF, this.lNw.doC());
                adVar.eVr = b2 != null ? b2.nxK : false;
            }
            this.lRS.lYW.a(adVar);
        }
    }

    private boolean dnE() {
        if (this.lNw != null && this.lNw.doC()) {
            return this.lNw.getPageData() == null || this.lNw.getPageData().bmG() != 0;
        }
        return false;
    }

    public boolean FJ(int i) {
        List<ForumToolPerm> forumToolAuth;
        if (i == 1) {
            return true;
        }
        if (this.lNw.getPbData().getUserData() == null || (forumToolAuth = this.lNw.getPbData().getUserData().getForumToolAuth()) == null) {
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
    public PbModel.a dnF() {
        return this.lSU;
    }

    public int dnG() {
        if (dnr() == null || dnr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnr().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof com.baidu.tieba.pb.data.o) && ((com.baidu.tieba.pb.data.o) nVar).Wm == com.baidu.tieba.pb.data.o.lLG) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnH() {
        if (dnr() == null || dnr().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dnr().getListView();
        List<com.baidu.adp.widget.ListView.n> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.n nVar = data.get(i);
            if ((nVar instanceof PostData) && nVar.getType() == PostData.nwY) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dnN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnI() {
        if (this.lNw != null && this.lNw.lOF != null && this.lNw.lOF.dlg() != null) {
            cb dlg = this.lNw.lOF.dlg();
            dlg.mRecomAbTag = this.lNw.dpw();
            dlg.mRecomWeight = this.lNw.dpu();
            dlg.mRecomSource = this.lNw.dpv();
            dlg.mRecomExtra = this.lNw.dpx();
            dlg.eUg = this.lNw.doI();
            if (dlg.getFid() == 0) {
                dlg.setFid(com.baidu.adp.lib.f.b.toLong(this.lNw.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlg, "c13562");
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
                    PbFragment.this.faF.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lNw.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bqx();
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.lRS.dqT();
        this.lNw.vo(z);
        if (this.lRQ != null) {
            this.lRQ.ja(z);
            if (markData != null) {
                this.lRQ.a(markData);
            }
        }
        if (this.lNw.bjZ()) {
            dnL();
        } else {
            this.lRS.s(this.lNw.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fy(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pu(String str) {
        if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().dlJ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lNw.doA(), str);
            cb dlg = this.lNw.getPbData().dlg();
            if (dlg.bmx()) {
                format = format + "&channelid=33833";
            } else if (dlg.bpM()) {
                format = format + "&channelid=33842";
            } else if (dlg.bmy()) {
                format = format + "&channelid=33840";
            }
            Pv(format);
            return;
        }
        this.lRP.PV(str);
    }

    private void Pv(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.lNw.doI()) {
                    antiData.setBlock_forum_name(this.lNw.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lNw.getPbData().getForum().getId());
                    antiData.setUser_name(this.lNw.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lNw.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dnr() != null) {
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
            Da(str);
        } else {
            this.lRS.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.nzX) ? bVar.nzX : getString(R.string.delete_fail);
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
                this.lRS.a(0, bVar.mSuccess, bVar.nzX, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iNt == 1) {
                    ArrayList<PostData> dli = this.lNw.getPbData().dli();
                    int size = dli.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dli.get(i).getId())) {
                            i++;
                        } else {
                            dli.remove(i);
                            break;
                        }
                    }
                    this.lNw.getPbData().dlg().nk(this.lNw.getPbData().dlg().bnH() - 1);
                    this.lRS.s(this.lNw.getPbData());
                } else if (bVar.iNt == 0) {
                    dnJ();
                } else if (bVar.iNt == 2) {
                    ArrayList<PostData> dli2 = this.lNw.getPbData().dli();
                    int size2 = dli2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dli2.get(i2).dNC().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dli2.get(i2).dNC().get(i3).getId())) {
                                i3++;
                            } else {
                                dli2.get(i2).dNC().remove(i3);
                                dli2.get(i2).dNE();
                                z2 = true;
                                break;
                            }
                        }
                        dli2.get(i2).Tq(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.lRS.s(this.lNw.getPbData());
                    }
                    a(bVar, this.lRS);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null) {
            this.lRS.a(this.gev.getLoadDataMode(), gVar.mSuccess, gVar.nzX, false);
            if (gVar.mSuccess) {
                this.lRT = true;
                if (i == 2 || i == 3) {
                    this.lRU = true;
                    this.lRV = false;
                } else if (i == 4 || i == 5) {
                    this.lRU = false;
                    this.lRV = true;
                }
                if (i == 2) {
                    this.lNw.getPbData().dlg().nn(1);
                    this.lNw.setIsGood(1);
                } else if (i == 3) {
                    this.lNw.getPbData().dlg().nn(0);
                    this.lNw.setIsGood(0);
                } else if (i == 4) {
                    this.lNw.getPbData().dlg().nm(1);
                    this.lNw.FO(1);
                } else if (i == 5) {
                    this.lNw.getPbData().dlg().nm(0);
                    this.lNw.FO(0);
                }
                this.lRS.c(this.lNw.getPbData(), this.lNw.doC());
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.nzX)) {
                string = gVar.nzX;
            } else {
                string = getString(R.string.operation_failed);
            }
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), string);
        }
    }

    private void dnJ() {
        if (this.lNw.doD() || this.lNw.doF()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lNw.doA());
            PbActivity pbActivity = this.lRi;
            PbActivity pbActivity2 = this.lRi;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lNw.doA()));
        if (dnM()) {
            this.lRi.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
        this.lRi.dmL();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dls;
        boolean z = false;
        if (this.lRS != null) {
            this.lRS.drk();
        }
        if (this.lNw != null && this.lNw.getPbData() != null && !this.lNw.getPbData().dlJ()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lNw.getPbData().dlg().getId();
            if (this.lNw.isShareThread() && this.lNw.getPbData().dlg().eTc != null) {
                historyMessage.threadName = this.lNw.getPbData().dlg().eTc.showText;
            } else {
                historyMessage.threadName = this.lNw.getPbData().dlg().getTitle();
            }
            if (this.lNw.isShareThread() && !dmp()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lNw.getPbData().getForum().getName();
            }
            ArrayList<PostData> dli = this.lNw.getPbData().dli();
            int dqV = this.lRS != null ? this.lRS.dqV() : 0;
            if (dli != null && dqV >= 0 && dqV < dli.size()) {
                historyMessage.postID = dli.get(dqV).getId();
            }
            historyMessage.isHostOnly = this.lNw.getHostMode();
            historyMessage.isSquence = this.lNw.doC();
            historyMessage.isShareThread = this.lNw.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lSe != null) {
            this.lSe.onDestroy();
        }
        if (this.lRn && dnr() != null) {
            dnr().drD();
        }
        if (this.lNw != null && (this.lNw.doD() || this.lNw.doF())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lNw.doA());
            if (this.lRT) {
                if (this.lRV) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lNw.cvp());
                }
                if (this.lRU) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lNw.getIsGood());
                }
            }
            if (this.lNw.getPbData() != null && System.currentTimeMillis() - this.lRq >= 40000 && (dls = this.lNw.getPbData().dls()) != null && !com.baidu.tbadk.core.util.y.isEmpty(dls.getDataList())) {
                intent.putExtra("guess_like_data", dls);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lSs);
            }
            PbActivity pbActivity = this.lRi;
            PbActivity pbActivity2 = this.lRi;
            pbActivity.setResult(-1, intent);
        }
        if (dnM()) {
            if (this.lNw != null && this.lRS != null && this.lRS.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dlo() && !this.lRw && pbData.lKo == null) {
                        aj dpZ = aj.dpZ();
                        com.baidu.tieba.pb.data.f doL = this.lNw.doL();
                        Parcelable onSaveInstanceState = this.lRS.getListView().onSaveInstanceState();
                        boolean doC = this.lNw.doC();
                        boolean hostMode = this.lNw.getHostMode();
                        if (this.lRS.dqB() != null && this.lRS.dqB().getVisibility() == 0) {
                            z = true;
                        }
                        dpZ.a(doL, onSaveInstanceState, doC, hostMode, z);
                        if (this.lSr >= 0 || this.lNw.dpn() != null) {
                            aj.dpZ().q(this.lNw.dpn());
                            aj.dpZ().p(this.lNw.dpo());
                            aj.dpZ().FY(this.lNw.dpp());
                        }
                    }
                }
            } else {
                aj.dpZ().reset();
            }
            dmL();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.lRS == null || !this.lRS.Ge(i)) ? false : true;
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
        PbActivity pbActivity = this.lRi;
        if (i == 0) {
            this.lRS.dqo();
            this.lRS.dqq().dnh();
            this.lRS.vK(false);
        }
        this.lRS.dqs();
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
                        this.lSe.resetData();
                        this.lSe.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lSe.c(writeData);
                        com.baidu.tbadk.editortools.m qU = this.lSe.bBh().qU(6);
                        if (qU != null && qU.fBo != null) {
                            qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lRi;
                        if (i == -1) {
                            this.lSe.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.lRS.dqq() != null && this.lRS.dqq().dnl() != null) {
                            com.baidu.tbadk.editortools.pb.h dnl = this.lRS.dqq().dnl();
                            dnl.setThreadData(this.lNw.getPbData().dlg());
                            dnl.c(writeData);
                            dnl.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m qU2 = dnl.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lRi;
                            if (i == -1) {
                                dnl.bCm();
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
        this.lSe.onActivityResult(i, i2, intent);
        if (this.lRB != null) {
            this.lRB.onActivityResult(i, i2, intent);
        }
        if (dnr().dqq() != null) {
            dnr().dqq().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnK();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.dpZ().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lNw != null) {
                                PbFragment.this.lNw.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dCY().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lNw != null) {
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
                        com.baidu.tieba.o.a.dCY().I(getPageContext());
                        dnC();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jCx != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jCx.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
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
                    this.lRS.uO(false);
                    if (this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null && this.lNw.getPbData().dlg().bok() != null) {
                        this.lNw.getPbData().dlg().bok().setStatus(2);
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
                        this.lSh = emotionImageData;
                        if (FI(com.baidu.tbadk.core.util.am.faC)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.lRC != null) {
                        this.lRS.dM(this.lRC);
                        return;
                    }
                    return;
                case 25055:
                    if (this.lRD != null) {
                        this.lRD.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lRE != null) {
                        this.lRE.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (this.lRS != null && this.lRS.drJ() != null) {
                        this.lRS.drJ().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lRF != null) {
                        this.lRF.performClick();
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
            if (this.lRB == null) {
                this.lRB = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lRi);
                this.lRB.b(this.fDO);
                this.lRB.c(this.fDW);
            }
            this.lRB.a(emotionImageData, dmx(), dmx().getPbData());
        }
    }

    private void T(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnK() {
        MarkData FV;
        if (this.lRQ != null) {
            if (this.lNw.getPbData() != null && this.lNw.getPbData().dlJ()) {
                FV = this.lNw.FV(0);
            } else {
                FV = this.lNw.FV(this.lRS.dqW());
            }
            if (FV != null) {
                if (!FV.isApp() || (FV = this.lNw.FV(this.lRS.dqW() + 1)) != null) {
                    this.lRS.dqR();
                    this.lRQ.a(FV);
                    if (!this.lRQ.bjZ()) {
                        this.lRQ.bkb();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.lRQ.bka();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
        this.lNw.vo(true);
        if (this.lRQ != null) {
            pbData.Pl(this.lRQ.bjY());
        }
        this.lRS.s(pbData);
    }

    private boolean dnM() {
        if (this.lNw == null) {
            return true;
        }
        if (this.lNw.getPbData() == null || !this.lNw.getPbData().dlJ()) {
            if (this.lNw.bjZ()) {
                final MarkData doV = this.lNw.doV();
                if (doV == null || !this.lNw.getIsFromMark()) {
                    return true;
                }
                final MarkData FV = this.lNw.FV(this.lRS.dqV());
                if (FV == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", doV);
                    this.lRi.setResult(-1, intent);
                    return true;
                } else if (FV.getPostId() == null || FV.getPostId().equals(doV.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", doV);
                    this.lRi.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Au(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.lRQ != null) {
                                if (PbFragment.this.lRQ.bjZ()) {
                                    PbFragment.this.lRQ.bka();
                                    PbFragment.this.lRQ.ja(false);
                                }
                                PbFragment.this.lRQ.a(FV);
                                PbFragment.this.lRQ.ja(true);
                                PbFragment.this.lRQ.bkb();
                            }
                            doV.setPostId(FV.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doV);
                            PbFragment.this.lRi.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmL();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", doV);
                            PbFragment.this.lRi.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.dmL();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.lRS != null && PbFragment.this.lRS.getView() != null) {
                                PbFragment.this.lRS.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", doV);
                                PbFragment.this.lRi.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.dmL();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bqx();
                    return false;
                }
            } else if (this.lNw.getPbData() == null || this.lNw.getPbData().dli() == null || this.lNw.getPbData().dli().size() <= 0 || !this.lNw.getIsFromMark()) {
                return true;
            } else {
                this.lRi.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.lRS == null) {
            return null;
        }
        return this.lRS.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        if (this.lRS == null) {
            return 0;
        }
        return this.lRS.dri();
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
                /* renamed from: cxg */
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
                /* renamed from: dok */
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
                    ((PlayVoiceBntNew) view).ccB();
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
            /* renamed from: dol */
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
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (au.PM(str) && this.lNw != null && this.lNw.doA() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").ap("obj_param1", 1).dR("post_id", this.lNw.doA()));
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
            au.drQ().h(getPageContext(), str);
        }
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        au.drQ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lRu = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Rect rect) {
        if (rect != null && this.lRS != null && this.lRS.dry() != null && rect.top <= this.lRS.dry().getHeight()) {
            rect.top += this.lRS.dry().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
            TbRichText bH = bH(str, i);
            if (bH != null && (tbRichTextData = bH.bHz().get(this.lTa)) != null) {
                aVar.postId = String.valueOf(bH.getPostId());
                aVar.lNK = new ArrayList<>();
                aVar.eJM = new ConcurrentHashMap<>();
                if (!tbRichTextData.bHF().bHQ()) {
                    aVar.lNL = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lNK.add(c2);
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
                    imageUrlData.mIsReserver = this.lNw.doT();
                    imageUrlData.mIsSeeHost = this.lNw.getHostMode();
                    aVar.eJM.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dlg() != null) {
                            aVar.threadId = pbData.dlg().getId();
                        }
                        aVar.eJK = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lNL = true;
                int size = pbData.dli().size();
                this.lTb = false;
                aVar.index = -1;
                int a2 = pbData.dlp() != null ? a(pbData.dlp().dNH(), bH, i, i, aVar.lNK, aVar.eJM) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dli().get(i2);
                    if (postData.getId() == null || pbData.dlp() == null || pbData.dlp().getId() == null || !postData.getId().equals(pbData.dlp().getId())) {
                        a2 = a(postData.dNH(), bH, a2, i, aVar.lNK, aVar.eJM);
                    }
                }
                if (aVar.lNK.size() > 0) {
                    aVar.lastId = aVar.lNK.get(aVar.lNK.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dlg() != null) {
                        aVar.threadId = pbData.dlg().getId();
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
            this.lTb = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lNw.doA(), -1L);
                                imageUrlData.mIsReserver = this.lNw.doT();
                                imageUrlData.mIsSeeHost = this.lNw.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lTb) {
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
        PostData dlp;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lNw.bnY())) {
                z = true;
            }
            MarkData o = this.lNw.o(postData);
            if (this.lNw.getPbData() != null && this.lNw.getPbData().dlJ() && (dlp = dlp()) != null) {
                o = this.lNw.o(dlp);
            }
            if (o != null) {
                this.lRS.dqR();
                if (this.lRQ != null) {
                    this.lRQ.a(o);
                    if (!z) {
                        this.lRQ.bkb();
                    } else {
                        this.lRQ.bka();
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
        if (this.lRS != null) {
            if (this.lRS.dos()) {
                return true;
            }
            this.lRS.drG();
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
                    this.lSo = ((TbImageView) view).getBdImage();
                    this.lSp = ((TbImageView) view).getUrl();
                    if (this.lSo == null || TextUtils.isEmpty(this.lSp)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSq = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lSo = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lSp = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lSq = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lSo = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lSp = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSq = null;
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
                    this.lRS.a(this.lTd, this.lSo.isGif());
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
        this.kqg = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kqg == null) {
            return true;
        }
        if (this.kqg.dNF() == 1 && dG(view)) {
            this.lRS.a(this.lTd, this.lSo.isGif());
            return true;
        } else if (this.lRQ == null) {
            return true;
        } else {
            if (!this.lRQ.bjZ() || this.kqg.getId() == null || !this.kqg.getId().equals(this.lNw.bnY())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = dmx().getPbData() != null && dmx().getPbData().dlJ();
            if (this.kqg.dNF() == 1) {
                if (!z3) {
                    this.lRS.a(this.lTc, z, false);
                }
                return true;
            }
            if (this.lRX == null) {
                this.lRX = new com.baidu.tbadk.core.dialog.k(getContext());
                this.lRX.a(this.lSP);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = dG(view) && !z3;
                boolean z5 = (!dG(view) || this.lSo == null || this.lSo.isGif()) ? false : true;
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
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.save_to_emotion), this.lRX));
                }
                if (z5) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.save_to_local), this.lRX));
                }
                if (!z4 && !z5) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, getString(R.string.copy), this.lRX);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.kqg);
                    gVar2.eVl.setTag(sparseArray3);
                    arrayList.add(gVar2);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.remove_mark), this.lRX);
                    } else {
                        gVar = new com.baidu.tbadk.core.dialog.g(4, getString(R.string.mark), this.lRX);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.kqg);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar.eVl.setTag(sparseArray4);
                    arrayList.add(gVar);
                }
                if (this.mIsLogin && !this.lRN) {
                    if (!z8 && z7) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.mute_option), this.lRX);
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
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, getString(R.string.report_text), this.lRX);
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
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lRX);
                            gVar6.eVl.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar5 = new com.baidu.tbadk.core.dialog.g(7, getString(R.string.bar_manager), this.lRX);
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
                        if (this.lNw.getPbData().dlv() == 1002 && !z6) {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.report_text), this.lRX);
                        } else {
                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, getString(R.string.delete), this.lRX);
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
                    list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kqg.bpJ(), sparseArray2, this.lRX), this.lRj));
                    this.lRX.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kqg));
                } else {
                    list = arrayList;
                }
                this.lRX.k(list, true);
                this.lRW = new com.baidu.tbadk.core.dialog.i(getPageContext(), this.lRX);
                this.lRW.QE();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13272").dR("tid", this.lNw.lVc).dR("fid", this.lNw.getForumId()).dR("uid", this.lNw.getPbData().dlg().bnQ().getUserId()).dR("post_id", this.lNw.bBJ()).ap("obj_source", z2 ? 2 : 1));
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
        if (this.lNw == null || this.lNw.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lNw.getPbData();
        if (pbData.dlp() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dlp());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dli = pbData.dli();
            c(pbData, dli);
            return c(dli, str, i);
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
            if (dmx() != null) {
                eVar.eMe = dmx().dpl();
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
                if (this.lNw == null && this.lNw.getPbData() != null) {
                    this.feF.a(doh(), eVar, agreeData, this.lNw.getPbData().dlg());
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
            if (this.lNw == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.dlu() != null && fVar.dlu().lLW != null && (list = fVar.dlu().lLW) != null && arrayList != null) {
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
            TbRichText dNH = arrayList.get(i2).dNH();
            if (dNH != null && (bHz = dNH.bHz()) != null) {
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
                            this.lTa = i4;
                            return dNH;
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
            this.lNs = str;
            if (this.lRp == null) {
                dnw();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lRp.getItemView(1).setVisibility(8);
            } else {
                this.lRp.getItemView(1).setVisibility(0);
            }
            this.lRp.bqz();
            this.lRu = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnN() {
        hideNetRefreshView(this.lRS.getView());
        dnO();
        if (this.lNw.doO()) {
            this.lRS.dqR();
        }
        this.lRS.drc();
    }

    private void dnO() {
        showLoadingView(this.lRS.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.lRS.dry().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        if (this.jgu != null) {
            this.jgu.stopPlay();
        }
        if (this.lRi != null) {
            this.lRi.cDb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL(int i) {
        com.baidu.tieba.pb.pb.main.d.b.a(this, dnB(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        if (this.fXD == null) {
            this.fXD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dom */
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

    public void cDc() {
        if (this.lRi != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.lRi.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lRi.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cBz() {
        if (this.lNw == null || this.lNw.getPbData() == null) {
            return null;
        }
        return this.lNw.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(ap.mam)).intValue();
            if (intValue == ap.man) {
                if (!this.gev.dOA()) {
                    this.lRS.dqM();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.gev.TE(com.baidu.tbadk.core.util.au.R(jSONArray));
                    }
                    this.gev.a(this.lNw.getPbData().getForum().getId(), this.lNw.getPbData().getForum().getName(), this.lNw.getPbData().dlg().getId(), str, intValue3, intValue2, booleanValue, this.lNw.getPbData().dlg().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == ap.mao || intValue == ap.mar) {
                if (this.lNw.dpe() != null) {
                    this.lNw.dpe().FD(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ap.mao) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lSm);
        userMuteAddAndDelCustomMessage.setTag(this.lSm);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Pw(String str) {
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0844a
    public void vd(boolean z) {
        this.lRY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnP() {
        ArrayList<PostData> dli;
        int count;
        if (this.lNw == null || this.lNw.getPbData() == null || this.lNw.getPbData().dli() == null || (count = com.baidu.tbadk.core.util.y.getCount((dli = this.lNw.getPbData().dli()))) == 0) {
            return "";
        }
        if (this.lNw.doT()) {
            Iterator<PostData> it = dli.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNF() == 1) {
                    return next.getId();
                }
            }
        }
        int dqV = this.lRS.dqV();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dli, dqV);
        if (postData == null || postData.bnQ() == null) {
            return "";
        }
        if (this.lNw.PA(postData.bnQ().getUserId())) {
            return postData.getId();
        }
        for (int i = dqV - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dli, i);
            if (postData2 == null || postData2.bnQ() == null || postData2.bnQ().getUserId() == null) {
                break;
            } else if (this.lNw.PA(postData2.bnQ().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dqV + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dli, i2);
            if (postData3 == null || postData3.bnQ() == null || postData3.bnQ().getUserId() == null) {
                return "";
            }
            if (this.lNw.PA(postData3.bnQ().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        this.lRu = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a Px(String str) {
        String str2;
        if (this.lNw.getPbData() == null || this.lNw.getPbData().dli() == null || this.lNw.getPbData().dli().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lNw.getPbData().dli().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lNw.getPbData().dli().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lNw.getPbData().dli().get(i);
        if (postData.dNH() == null || postData.dNH().bHz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dNH().bHz().iterator();
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

    public boolean dnQ() {
        return (!this.lRk && this.lTf == -1 && this.lTg == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null) {
            this.lTi = tVar;
            this.lRk = true;
            this.lRS.dqC();
            this.lRS.PK(this.lTh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnR() {
        if (this.lTi != null) {
            if (this.lTf == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lTi.getCartoonId(), this.lTf, 0)));
                this.lRi.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnS() {
        if (this.lTi != null) {
            if (this.lTg == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lTi.getCartoonId(), this.lTg, 0)));
                this.lRi.finish();
            }
        }
    }

    public int dnT() {
        return this.lTf;
    }

    public int dnU() {
        return this.lTg;
    }

    private void cSS() {
        if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null && this.lNw.getPbData().dlg().bmv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dnV() {
        if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null && this.lNw.getPbData().dlg().bmv()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dnW() {
        if (this.isPaused) {
            this.lRA = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null && this.lNw.getPbData().dlg().bnw() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lNw.getPbData().dlg().bnw().getThreadId(), this.lNw.getPbData().dlg().bnw().getTaskId(), this.lNw.getPbData().dlg().bnw().getForumId(), this.lNw.getPbData().dlg().bnw().getForumName(), this.lNw.getPbData().dlg().bnL(), this.lNw.getPbData().dlg().bnM())));
            this.lRm = true;
            this.lRi.finish();
        }
    }

    public String dnX() {
        return this.lRy;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dnY() {
        return this.lRO;
    }

    public void ve(boolean z) {
        this.lRz = z;
    }

    public boolean blu() {
        if (this.lNw != null) {
            return this.lNw.doD();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Au(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.lSk).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.lSk.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lSk).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lSk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lSk.getPageActivity());
            aVar.Au(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lSk).bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lRS.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lSk.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Au(this.lSk.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Au(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.lRS.showLoadingDialog();
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
        aVar.b(this.lSk).bqx();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (au.PM(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jNj) {
            this.jNj = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.lRS != null) {
                this.lRS.onConfigurationChanged(configuration);
            }
            if (this.lRW != null) {
                this.lRW.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean doa() {
        if (this.lNw != null) {
            return this.lNw.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, ap apVar) {
        boolean z;
        List<PostData> list = this.lNw.getPbData().dlu().lLW;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNC().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNC().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNC().remove(i2);
                    list.get(i).dNE();
                    z = true;
                    break;
                }
            }
            list.get(i).Tq(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            apVar.s(this.lNw.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.q qVar) {
        String id = qVar.dlY().getId();
        List<PostData> list = this.lNw.getPbData().dlu().lLW;
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
                ArrayList<PostData> dmh = qVar.dmh();
                postData.JD(qVar.getTotalCount());
                if (postData.dNC() != null) {
                    postData.dNC().clear();
                    postData.dNC().addAll(dmh);
                }
            }
        }
        if (!this.lNw.getIsFromMark()) {
            this.lRS.s(this.lNw.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a dmo() {
        return this.lRi.dmo();
    }

    public boolean dmp() {
        if (this.lNw == null) {
            return false;
        }
        return this.lNw.dmp();
    }

    public void vf(boolean z) {
        this.lRx = z;
    }

    public boolean dob() {
        return this.lRx;
    }

    public void doc() {
        if (this.lRS != null) {
            this.lRS.dqo();
            cDc();
        }
    }

    public PostData dlp() {
        return this.lRS.b(this.lNw.lOF, this.lNw.doC());
    }

    public void onBackPressed() {
        if (this.lSt != null && !this.lSt.isEmpty()) {
            int size = this.lSt.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lSt.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lSt == null) {
                this.lSt = new ArrayList();
            }
            if (!this.lSt.contains(aVar)) {
                this.lSt.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lSt == null) {
                this.lSt = new ArrayList();
            }
            if (!this.lSt.contains(aVar)) {
                this.lSt.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lSt != null) {
            this.lSt.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        com.baidu.tbadk.core.util.ag.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dod() {
        if (this.lNw != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lNw.doA())) {
            com.baidu.tbadk.BdToken.c.bhn().q(com.baidu.tbadk.BdToken.b.eCf, com.baidu.adp.lib.f.b.toLong(this.lNw.doA(), 0L));
        }
    }

    public bk doe() {
        return this.lRK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py(String str) {
        if (this.lNw != null && this.lNw.getPbData() != null && this.lNw.getPbData().dlg() != null && this.lNw.getPbData().dlg().bmz()) {
            cb dlg = this.lNw.getPbData().dlg();
            int i = 0;
            if (dlg.bmx()) {
                i = 1;
            } else if (dlg.bmy()) {
                i = 2;
            } else if (dlg.bpN()) {
                i = 3;
            } else if (dlg.bpO()) {
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
                return com.baidu.tieba.pb.pb.main.d.b.a(PbFragment.this.getContext(), PbFragment.this.dnB(), i2, PbFragment.this.lNw);
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
    public PbFragment dof() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dog() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doh() {
        return this.lRi;
    }
}
