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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.h, com.baidu.tieba.pb.videopb.b, a.InterfaceC0585a {
    private com.baidu.adp.lib.d.b<ImageView> dMQ;
    private com.baidu.adp.lib.d.b<GifView> dMR;
    private com.baidu.adp.lib.d.b<TextView> dPF;
    private com.baidu.adp.lib.d.b<View> dPG;
    private com.baidu.adp.lib.d.b<LinearLayout> dPH;
    private com.baidu.adp.lib.d.b<RelativeLayout> dPI;
    private com.baidu.adp.lib.d.b<TbImageView> djC;
    private LikeModel dku;
    private ar gRU;
    private VoiceManager gpi;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    private com.baidu.tieba.f.b gtf;
    public com.baidu.tbadk.core.util.aj hRk;
    private String iFR;
    private PbActivity iIO;
    private com.baidu.tieba.pb.pb.main.b.b iIQ;
    private com.baidu.tieba.tbadkCore.data.f iJB;
    private com.baidu.tbadk.editortools.pb.g iJC;
    private com.baidu.tbadk.editortools.pb.e iJD;
    private com.baidu.tieba.frs.profession.permission.c iJF;
    private EmotionImageData iJG;
    private com.baidu.adp.base.e iJJ;
    private com.baidu.tbadk.core.view.d iJK;
    private BdUniqueId iJL;
    private Runnable iJM;
    private com.baidu.adp.widget.ImageView.a iJN;
    private String iJO;
    private TbRichTextMemeInfo iJP;
    private List<a> iJS;
    public String iJU;
    private com.baidu.tieba.pb.pb.main.emotion.model.a iJf;
    private View iJg;
    int iJi;
    private ax iJl;
    private com.baidu.tieba.pb.pb.report.a iJn;
    public ap iJu;
    private com.baidu.tbadk.core.dialog.i iJv;
    private com.baidu.tbadk.core.dialog.k iJw;
    private boolean iJx;
    private String iKC;
    private com.baidu.tbadk.core.data.p iKD;
    private boolean iKt;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
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
    private static final b.a iKz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
        @Override // com.baidu.tieba.f.b.a
        public void bl(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.clL();
            } else {
                com.baidu.tieba.pb.a.b.clK();
            }
        }
    };
    private boolean iIP = false;
    private boolean iIR = false;
    private boolean isPaused = false;
    private boolean ijG = false;
    private boolean iIS = true;
    private int iIT = 0;
    private com.baidu.tbadk.core.dialog.b iIU = null;
    private long fWb = -1;
    private long dEh = 0;
    private long iIV = 0;
    private long createTime = 0;
    private long dDX = 0;
    private boolean iIW = false;
    private com.baidu.tbadk.n.b iIX = null;
    private long iIY = 0;
    private boolean iIZ = false;
    private long iJa = 0;
    private int gPx = 1;
    private String dyQ = null;
    private boolean iJb = false;
    private boolean isFullScreen = false;
    private String iJc = "";
    private boolean iJd = true;
    private boolean iJe = false;
    private String source = "";
    private int mSkinType = 3;
    int[] iJh = new int[2];
    private int iJj = -1;
    private int iJk = -1;
    private PbInterviewStatusView.a iJm = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.iJq.qq(!PbFragment.this.iJd);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.iFV != null && PbFragment.this.iFV.ayO()) {
                        PbFragment.this.cnj();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel iFV = null;
    private com.baidu.tbadk.baseEditMark.a iJo = null;
    private ForumManageModel fLt = null;
    private com.baidu.tbadk.coreExtra.model.a dap = null;
    private com.baidu.tieba.pb.data.m iJp = null;
    private ShareSuccessReplyToServerModel gFE = null;
    private an iJq = null;
    private boolean iJr = false;
    private boolean iJs = false;
    private boolean iJt = false;
    private boolean eep = false;
    private boolean iJy = false;
    private boolean iJz = false;
    private boolean iJA = false;
    private boolean iJE = false;
    public boolean iJH = false;
    private com.baidu.tbadk.editortools.pb.c dyT = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aOW() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b dyU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOV() {
            if (PbFragment.this.iJu == null || PbFragment.this.iJu.cqT() == null || !PbFragment.this.iJu.cqT().cUz()) {
                return !PbFragment.this.yV(com.baidu.tbadk.core.util.aj.dak);
            }
            PbFragment.this.showToast(PbFragment.this.iJu.cqT().cUB());
            if (PbFragment.this.iJD != null && (PbFragment.this.iJD.aPl() || PbFragment.this.iJD.aPm())) {
                PbFragment.this.iJD.a(false, PbFragment.this.iJu.cqW());
            }
            PbFragment.this.iJu.qC(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b iJI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aOV() {
            if (PbFragment.this.iJu == null || PbFragment.this.iJu.cqU() == null || !PbFragment.this.iJu.cqU().cUz()) {
                return !PbFragment.this.yV(com.baidu.tbadk.core.util.aj.dal);
            }
            PbFragment.this.showToast(PbFragment.this.iJu.cqU().cUB());
            if (PbFragment.this.iJq != null && PbFragment.this.iJq.cpE() != null && PbFragment.this.iJq.cpE().cmJ() != null && PbFragment.this.iJq.cpE().cmJ().aPm()) {
                PbFragment.this.iJq.cpE().cmJ().a(PbFragment.this.iJu.cqW());
            }
            PbFragment.this.iJu.qD(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean gpV = false;
    private int iJQ = 0;
    private int iJR = -1;
    public int iJT = 0;
    private final a iJV = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.iJq != null && PbFragment.this.iJq.cpE() != null) {
                s cpE = PbFragment.this.iJq.cpE();
                if (cpE.cmH()) {
                    cpE.cmG();
                    return true;
                }
            }
            if (PbFragment.this.iJq != null && PbFragment.this.iJq.cqC()) {
                PbFragment.this.iJq.cqD();
                return true;
            }
            return false;
        }
    };
    private final x.a iJW = new x.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void onSuccess(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.x.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.iJq.showToast(str);
            }
        }
    };
    private final CustomMessageListener iJX = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iFV != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.iJD != null) {
                    PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                }
                PbFragment.this.iJq.cpG();
                PbFragment.this.iJq.cqu();
            }
        }
    };
    CustomMessageListener gqx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.iFV.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.iJq != null && PbFragment.this.iFV != null) {
                    PbFragment.this.iJq.b(PbFragment.this.iFV.getPbData(), PbFragment.this.iFV.cnV(), PbFragment.this.iFV.cos(), PbFragment.this.iJq.getSkinType());
                }
                if (PbFragment.this.iJq != null && PbFragment.this.iJq.cpX() != null) {
                    PbFragment.this.iJq.cpX().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener iJY = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.iJq != null) {
                    if (booleanValue) {
                        PbFragment.this.iJq.bWL();
                    } else {
                        PbFragment.this.iJq.bWK();
                    }
                }
            }
        }
    };
    private CustomMessageListener iJZ = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.iJD != null) {
                    PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                }
                PbFragment.this.iJq.qx(false);
            }
        }
    };
    private CustomMessageListener iKa = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener iKb = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iJq != null && PbFragment.this.iJq.cpX() != null) {
                PbFragment.this.iJq.cpX().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener hvk = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener gqu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.isPaused) {
                PbFragment.this.cnA();
            }
        }
    };
    private View.OnClickListener dzB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.dyQ);
        }
    };
    private CustomMessageListener iKc = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ab)) {
                com.baidu.tbadk.core.data.ab abVar = (com.baidu.tbadk.core.data.ab) customResponsedMessage.getData();
                ar.a aVar = new ar.a();
                aVar.giftId = abVar.id;
                aVar.giftName = abVar.name;
                aVar.thumbnailUrl = abVar.thumbnailUrl;
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iFV.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.iFV.coj() != null && PbFragment.this.iFV.coj().getUserIdLong() == abVar.toUserId) {
                        PbFragment.this.iJq.a(abVar.sendCount, PbFragment.this.iFV.getPbData(), PbFragment.this.iFV.cnV(), PbFragment.this.iFV.cos());
                    }
                    if (pbData.ckR() != null && pbData.ckR().size() >= 1 && pbData.ckR().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.ckR().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.iFV.cnU(), 0L);
                        if (j == abVar.postId && j2 == abVar.threadId) {
                            com.baidu.tbadk.core.data.ar cLD = pbData.ckR().get(0).cLD();
                            if (cLD == null) {
                                cLD = new com.baidu.tbadk.core.data.ar();
                            }
                            ArrayList<ar.a> aBp = cLD.aBp();
                            if (aBp == null) {
                                aBp = new ArrayList<>();
                            }
                            aBp.add(0, aVar);
                            cLD.setTotal(abVar.sendCount + cLD.getTotal());
                            cLD.w(aBp);
                            pbData.ckR().get(0).a(cLD);
                            PbFragment.this.iJq.cpX().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                PbFragment.this.FN((String) customResponsedMessage.getData());
                PbFragment.this.iFV.coo();
                if (PbFragment.this.iJq.cpX() != null) {
                    PbFragment.this.iJq.o(PbFragment.this.iFV.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a iKd = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.crl()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a iKe = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onSuccess(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbFragment.this.iJq != null) {
                PbFragment.this.iJq.dH(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean iKf = false;
    private PraiseModel iKg = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void xr(String str) {
            PbFragment.this.iKf = false;
            if (PbFragment.this.iKg != null) {
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iFV.getPbData();
                if (pbData.ckP().aCc().getIsLike() == 1) {
                    PbFragment.this.tN(0);
                } else {
                    PbFragment.this.tN(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.ckP()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.iKf = false;
            if (PbFragment.this.iKg != null && str != null) {
                if (AntiHelper.bb(i, str)) {
                    AntiHelper.bn(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a iKh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void pW(boolean z) {
            PbFragment.this.pV(z);
            if (PbFragment.this.iJq.cqI() != null && z) {
                PbFragment.this.iJq.qq(false);
            }
            PbFragment.this.iJq.qs(z);
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().dow != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().dow, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.ckW().aCr() != null && PbFragment.this.ckW().aCr().getGodUserData() != null) {
                            PbFragment.this.ckW().aCr().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null) {
                            PbFragment.this.iFV.getPbData().ckP().aCr().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h goq = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.iIO.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a iKi = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.iJq.bqx();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.yX(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.bMT();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c drk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.cmS();
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
                        if (PbFragment.this.iJq.cmQ() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").cx("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.clM() != null && PbFragment.this.clM().gSp != null) {
                                PbFragment.this.clM().gSp.onClick(view);
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
                if (PbFragment.this.iJD != null) {
                    PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                }
                PbFragment.this.iJq.cpG();
                PbFragment.this.iJq.cqu();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener iKj = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iJL) {
                PbFragment.this.iJq.bqx();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = PbFragment.this.iFV.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.clc().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iJK.showSuccessToast(PbFragment.this.iJJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.iJJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.vq(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.cnx();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.iJJ.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.iJK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener iKk = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iJL) {
                PbFragment.this.iJq.bqx();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.iJK.showSuccessToast(PbFragment.this.iJJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.iJJ.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.iJK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener iKl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.iJL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.iJq.bqx();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.kww;
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
                    PbFragment.this.iJq.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener iKm = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.iJq.cpH() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.cmS();
            }
        }
    };
    private CustomMessageListener gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.gpV = true;
                }
            }
        }
    };
    public a.b iuG = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.bEv();
            com.baidu.tbadk.core.data.ap pageData = PbFragment.this.iFV.getPageData();
            int pageNum = PbFragment.this.iJq.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aBi()) {
                PbFragment.this.iJq.cqu();
                PbFragment.this.bEu();
                PbFragment.this.iJq.cqb();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.iFV.yZ(PbFragment.this.iJq.getPageNum());
                    if (PbFragment.this.iIQ != null) {
                        PbFragment.this.iIQ.showFloatingView();
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
    public final View.OnClickListener grn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
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
                    if (view == PbFragment.this.iJq.cqq()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.iFV.qb(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.iJq.cqc();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cph()) {
                        if (view == PbFragment.this.iJq.iPx.dGn) {
                            if (PbFragment.this.iJq.qu(PbFragment.this.iFV.coa())) {
                                PbFragment.this.bEu();
                                return;
                            }
                            PbFragment.this.iIS = false;
                            PbFragment.this.iIR = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.iIO, PbFragment.this.iJq.iPx.dGn);
                            PbFragment.this.iIO.finish();
                        } else if (view != PbFragment.this.iJq.cpZ() && (PbFragment.this.iJq.iPx.cry() == null || (view != PbFragment.this.iJq.iPx.cry().cpg() && view != PbFragment.this.iJq.iPx.cry().cpe()))) {
                            if (view == PbFragment.this.iJq.cqy()) {
                                if (PbFragment.this.iFV != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFV.getPbData().ckP().aCq().getLink());
                                }
                            } else if (view != PbFragment.this.iJq.iPx.iVA) {
                                if (view == PbFragment.this.iJq.iPx.iVB) {
                                    if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                        ArrayList<PostData> ckR = PbFragment.this.iFV.getPbData().ckR();
                                        if ((ckR == null || ckR.size() <= 0) && PbFragment.this.iFV.cnV()) {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").cx("tid", PbFragment.this.iFV.cnU()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fid", PbFragment.this.iFV.getForumId()));
                                        if (!PbFragment.this.iJq.cqN()) {
                                            PbFragment.this.iJq.cpG();
                                        }
                                        PbFragment.this.cnb();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbFragment.this.iJq.pL(true);
                                        PbFragment.this.iJq.cpG();
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.mIsLoading = true;
                                            PbFragment.this.iJq.bWL();
                                            PbFragment.this.bEu();
                                            PbFragment.this.iJq.cqb();
                                            PbFragment.this.iFV.FU(PbFragment.this.cnn());
                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbFragment.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpd()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbFragment.this.iJq.iPx.cry() != null && view == PbFragment.this.iJq.iPx.cry().cpc()) {
                                            PbFragment.this.iJq.iPx.arX();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpa()) {
                                                if ((PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpj()) && view.getId() != R.id.pb_sort) {
                                                    if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpb()) {
                                                        if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpk()) {
                                                            if (PbFragment.this.iJq.cqI() == view) {
                                                                if (PbFragment.this.iJq.cqI().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.e pbData2 = PbFragment.this.iFV.getPbData();
                                                                    if (pbData2 != null && pbData2.ckP() != null && pbData2.ckP().aBX() != null) {
                                                                        String aBO = pbData2.ckP().aBX().aBO();
                                                                        if (StringUtils.isNull(aBO)) {
                                                                            aBO = pbData2.ckP().aBX().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").cx("obj_id", aBO));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.eB("c10725", null);
                                                                }
                                                                PbFragment.this.cnu();
                                                            } else if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpi()) {
                                                                if (PbFragment.this.iJq.iPx.cry() != null && view == PbFragment.this.iJq.iPx.cry().cpf()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> b2 = PbFragment.this.iJq.b(PbFragment.this.iFV.getPbData(), PbFragment.this.iFV.cnV(), 1);
                                                                        if (b2 != null) {
                                                                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                PbFragment.this.iJq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbFragment.this.iJq.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbFragment.this.iJq.iPx.arX();
                                                                    } else {
                                                                        PbFragment.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.cx("tid", PbFragment.this.iFV.cnU());
                                                                        anVar.cx("fid", PbFragment.this.iFV.getForumId());
                                                                        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.X("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                        if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                            PbFragment.this.iJq.cqu();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cLH() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.kjg != null) {
                                                                                    com.baidu.tbadk.core.util.an aGC = postData.kjg.aGC();
                                                                                    aGC.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aGC.X("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aGC.X("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aGC);
                                                                                }
                                                                                String cnU = PbFragment.this.iFV.cnU();
                                                                                String id = postData.getId();
                                                                                int i3 = 0;
                                                                                if (PbFragment.this.iFV.getPbData() != null) {
                                                                                    i3 = PbFragment.this.iFV.getPbData().clb();
                                                                                }
                                                                                PbFragment.this.bEu();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    PbActivity.a FS = PbFragment.this.FS(id);
                                                                                    if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && FS != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnU, id, "pb", true, null, true, null, i3, postData.csv(), PbFragment.this.iFV.getPbData().getAnti(), false, postData.aCr().getIconInfo()).addBigImageData(FS.iGa, FS.iGb, FS.iGc, FS.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbFragment.this.iFV.coD());
                                                                                        addBigImageData.setFromFrsForumId(PbFragment.this.iFV.getFromForumId());
                                                                                        addBigImageData.setKeyFromForumId(PbFragment.this.iFV.getForumId());
                                                                                        addBigImageData.setBjhData(PbFragment.this.iFV.coc());
                                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    PbActivity.a FS2 = PbFragment.this.FS(id);
                                                                                    if (postData != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && FS2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnU, id, "pb", true, null, false, null, i3, postData.csv(), PbFragment.this.iFV.getPbData().getAnti(), false, postData.aCr().getIconInfo()).addBigImageData(FS2.iGa, FS2.iGb, FS2.iGc, FS2.index);
                                                                                        addBigImageData2.setKeyFromForumId(PbFragment.this.iFV.getForumId());
                                                                                        addBigImageData2.setBjhData(PbFragment.this.iFV.coc());
                                                                                        addBigImageData2.setKeyPageStartFrom(PbFragment.this.iFV.coD());
                                                                                        addBigImageData2.setFromFrsForumId(PbFragment.this.iFV.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 3).cx("fid", PbFragment.this.iFV.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbFragment.this.iFV != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.cx("tid", PbFragment.this.iFV.cnU());
                                                                        anVar2.cx("fid", PbFragment.this.iFV.getForumId());
                                                                        anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.X("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (postData2.kjg != null) {
                                                                                    com.baidu.tbadk.core.util.an aGC2 = postData2.kjg.aGC();
                                                                                    aGC2.delete("obj_locate");
                                                                                    aGC2.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGC2);
                                                                                }
                                                                                if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                                    String cnU2 = PbFragment.this.iFV.cnU();
                                                                                    String id2 = postData2.getId();
                                                                                    int i4 = 0;
                                                                                    if (PbFragment.this.iFV.getPbData() != null) {
                                                                                        i4 = PbFragment.this.iFV.getPbData().clb();
                                                                                    }
                                                                                    PbActivity.a FS3 = PbFragment.this.FS(id2);
                                                                                    if (FS3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cnU2, id2, "pb", true, null, false, null, i4, postData2.csv(), PbFragment.this.iFV.getPbData().getAnti(), false, postData2.aCr().getIconInfo()).addBigImageData(FS3.iGa, FS3.iGb, FS3.iGc, FS3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbFragment.this.iFV.coD());
                                                                                        addBigImageData3.setFromFrsForumId(PbFragment.this.iFV.getFromForumId());
                                                                                        addBigImageData3.setKeyFromForumId(PbFragment.this.iFV.getForumId());
                                                                                        addBigImageData3.setBjhData(PbFragment.this.iFV.coc());
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
                                                                    if (PbFragment.this.iFV != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.cx("tid", PbFragment.this.iFV.cnU());
                                                                        anVar3.cx("fid", PbFragment.this.iFV.getForumId());
                                                                        anVar3.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.X("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (postData3.kjg != null) {
                                                                                    com.baidu.tbadk.core.util.an aGC3 = postData3.kjg.aGC();
                                                                                    aGC3.delete("obj_locate");
                                                                                    aGC3.X("obj_locate", 8);
                                                                                    TiebaStatic.log(aGC3);
                                                                                }
                                                                                if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.cmP().cpD() != null && postData3.aCr() != null && postData3.cLv() != 1) {
                                                                                    if (PbFragment.this.cmP().cpE() != null) {
                                                                                        PbFragment.this.cmP().cpE().cmF();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                                                                    lVar.a(PbFragment.this.iFV.getPbData().getForum());
                                                                                    lVar.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                                                                                    lVar.f(postData3);
                                                                                    PbFragment.this.cmP().cpD().d(lVar);
                                                                                    PbFragment.this.cmP().cpD().setPostId(postData3.getId());
                                                                                    PbFragment.this.b(view, postData3.aCr().getUserId(), "");
                                                                                    if (PbFragment.this.iJD != null) {
                                                                                        PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
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
                                                                } else if (view != PbFragment.this.iJq.cmh()) {
                                                                    if (view == PbFragment.this.iJq.iPx.crz()) {
                                                                        PbFragment.this.iJq.cqi();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbFragment.this.checkUpIsLogin() && (boVar = (bo) view.getTag()) != null && !StringUtils.isNull(boVar.aEy())) {
                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aGK().b(PbFragment.this.getPageContext(), new String[]{boVar.aEy()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").cx("tid", PbFragment.this.iFV.iLJ));
                                                                                    }
                                                                                    if (PbFragment.this.iJw == null) {
                                                                                        PbFragment.this.iJw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                        PbFragment.this.iJw.a(PbFragment.this.iKy);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbFragment.this.cv(view);
                                                                                    if (!PbFragment.this.cv(view) || PbFragment.this.iJN == null || !PbFragment.this.iJN.isGif()) {
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
                                                                                        if (postData4.cLx() != null && postData4.cLx().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iJw);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar4.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar4);
                                                                                        }
                                                                                        PbFragment.this.hjm = postData4;
                                                                                    }
                                                                                    if (PbFragment.this.iFV.getPbData().ayO()) {
                                                                                        String ayN = PbFragment.this.iFV.getPbData().ayN();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ayN) && ayN.equals(postData4.getId())) {
                                                                                            z = true;
                                                                                            if (!z) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iJw);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iJw);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbFragment.this.hjm);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                                if (!z4 && z3) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iJw);
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
                                                                                                    if (PbFragment.this.pR(z2) && TbadkCoreApplication.isLogin()) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iJw);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iJw);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iJw);
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
                                                                                                    if (PbFragment.this.iFV.getPbData().clb() == 1002 && !z2) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iJw);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iJw);
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
                                                                                            PbFragment.this.iJw.az(arrayList);
                                                                                            PbFragment.this.iJv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iJw);
                                                                                            PbFragment.this.iJv.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (!z) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbFragment.this.hjm);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                    }
                                                                                    PbFragment.this.iJw.az(arrayList);
                                                                                    PbFragment.this.iJv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iJw);
                                                                                    PbFragment.this.iJv.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.iFV.getPbData().ckP().getActUrl());
                                                                                if (PbFragment.this.iFV.getPbData().ckP().aDb() != 1) {
                                                                                    if (PbFragment.this.iFV.getPbData().ckP().aDb() == 2) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str2 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").cx("fid", PbFragment.this.iFV.getPbData().getForumId()).cx("tid", PbFragment.this.iFV.getPbData().getThreadId()).cx("lotterytail", StringUtils.string(str2, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbFragment.this.iFV.getPbData().getThreadId().equals(str2)) {
                                                                                    PbFragment.this.iJq.setSelection(0);
                                                                                } else {
                                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.aFH().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbFragment.this.iJq.cpG();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbFragment.this.cmY() == 1 && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").cx("fid", PbFragment.this.iFV.getPbData().getForumId()).cx("tid", PbFragment.this.iFV.getPbData().getThreadId()).cx("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                if (PbFragment.this.cmY() == 1 && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").cx("fid", PbFragment.this.iFV.getPbData().getForumId()).cx("tid", PbFragment.this.iFV.getPbData().getThreadId()).cx("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbFragment.this.cnp();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbFragment.this.cnq();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().clh() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData3 = PbFragment.this.iFV.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").cx("fid", pbData3.getForumId()));
                                                                                ba.aGK().b(PbFragment.this.getPageContext(), new String[]{pbData3.clh().cls()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().clh() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData4 = PbFragment.this.iFV.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cx("fid", pbData4.getForumId()));
                                                                                ba.aGK().b(PbFragment.this.getPageContext(), new String[]{pbData4.clh().cls()});
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbFragment.this.iJQ >= 0) {
                                                                                if (PbFragment.this.iFV != null) {
                                                                                    PbFragment.this.iFV.coE();
                                                                                }
                                                                                if (PbFragment.this.iFV != null && PbFragment.this.iJq.cpX() != null) {
                                                                                    PbFragment.this.iJq.cpX().a(PbFragment.this.iFV.getPbData(), false);
                                                                                }
                                                                                PbFragment.this.iJQ = 0;
                                                                                if (PbFragment.this.iFV != null) {
                                                                                    PbFragment.this.iJq.getListView().setSelection(PbFragment.this.iFV.coH());
                                                                                    PbFragment.this.iFV.cs(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbFragment.this.cmV();
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
                                                                            if (PbFragment.this.iJq.getListView() != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                                int firstVisiblePosition = PbFragment.this.iJq.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbFragment.this.iJq.getListView().getChildAt(0);
                                                                                int top2 = childAt == null ? 0 : childAt.getTop();
                                                                                boolean aHP = PbFragment.this.iFV.getPbData().aHP();
                                                                                boolean z7 = PbFragment.this.iJq.cpF() != null && PbFragment.this.iJq.cpF().bis();
                                                                                boolean cqr = PbFragment.this.iJq.cqr();
                                                                                boolean z8 = firstVisiblePosition == 0 && top2 == 0;
                                                                                int i5 = 0;
                                                                                if (aHP && PbFragment.this.iJq.cpF() != null && PbFragment.this.iJq.cpF().bcP() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.iJq.cpF().cri();
                                                                                    z8 = firstVisiblePosition == 0 && (top2 == equipmentWidth || top2 == PbFragment.this.iJq.cpF().bcP().getHeight() - PbFragment.this.iJq.cpF().cri());
                                                                                    i5 = equipmentWidth;
                                                                                }
                                                                                PbFragment.this.FT("c13568");
                                                                                if ((PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCi() <= 0) || (cqr && z8)) {
                                                                                    if (PbFragment.this.checkUpIsLogin()) {
                                                                                        PbFragment.this.cmV();
                                                                                        if (PbFragment.this.iFV.getPbData().ckP().aCr() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cx("tid", PbFragment.this.iFV.iLJ).cx("fid", PbFragment.this.iFV.getPbData().getForumId()).X("obj_locate", 2).cx("uid", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z9 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                    if (aHP) {
                                                                                        if (PbFragment.this.iJq.iQE != null && PbFragment.this.iJq.iQE.iRI != null && PbFragment.this.iJq.iQE.iRI.getView() != null) {
                                                                                            if (PbFragment.this.iJq.iQE.iRI.getView().getParent() == null) {
                                                                                                z9 = firstVisiblePosition >= PbFragment.this.cnf();
                                                                                            } else {
                                                                                                int i6 = 0;
                                                                                                if (PbFragment.this.iJq.cpF() != null && PbFragment.this.iJq.cpF().bcP() != null) {
                                                                                                    i6 = PbFragment.this.iJq.cpF().bcP().getBottom();
                                                                                                }
                                                                                                z9 = PbFragment.this.iJq.iQE.iRI.getView().getTop() <= i6;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbFragment.this.iJq.cpO() != null) {
                                                                                        z9 = PbFragment.this.iJq.cpO().getVisibility() == 0;
                                                                                        if (!z9 && PbFragment.this.iJq.iQE != null && PbFragment.this.iJq.iQE.iRI != null && PbFragment.this.iJq.iQE.iRI.getView() != null && PbFragment.this.iJq.iQE.iRI.getView().getParent() != null && PbFragment.this.iJq.iPx != null && PbFragment.this.iJq.iPx.mNavigationBar != null) {
                                                                                            z9 = PbFragment.this.iJq.iQE.iRI.getView().getTop() - PbFragment.this.iJq.iPx.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (z9 || cqr) {
                                                                                        PbFragment.this.iJj = firstVisiblePosition;
                                                                                        PbFragment.this.iJk = top2;
                                                                                        if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top2 < (-equipmentHeight))) {
                                                                                            PbFragment.this.iJq.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                            PbFragment.this.iJq.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                        } else {
                                                                                            PbFragment.this.iJq.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                        }
                                                                                    } else if (PbFragment.this.iJj > 0) {
                                                                                        if (PbFragment.this.iJq.getListView().getChildAt(PbFragment.this.iJj) != null) {
                                                                                            PbFragment.this.iJq.getListView().smoothScrollToPosition(PbFragment.this.iJj, PbFragment.this.iJk, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iJq.getListView().setSelectionFromTop(PbFragment.this.iJj, PbFragment.this.iJk + equipmentHeight);
                                                                                            PbFragment.this.iJq.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        }
                                                                                    } else {
                                                                                        int cnf = PbFragment.this.cnf();
                                                                                        if (PbFragment.this.cne() != -1) {
                                                                                            cnf--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds116);
                                                                                        if (cnf < 0) {
                                                                                            i = PbFragment.this.iJq.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbFragment.this.iJq.getListView().getData()) - 1);
                                                                                            i2 = 0;
                                                                                        } else {
                                                                                            i = cnf;
                                                                                            i2 = dimens;
                                                                                        }
                                                                                        if (z7) {
                                                                                            i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                        } else if (!aHP || PbFragment.this.iJq.cpF() == null) {
                                                                                            if (PbFragment.this.iJq.iPx != null && PbFragment.this.iJq.iPx.mNavigationBar != null) {
                                                                                                i2 += PbFragment.this.iJq.iPx.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i2 += PbFragment.this.iJq.cpF().crh();
                                                                                        }
                                                                                        if (PbFragment.this.iJq.iQE == null || PbFragment.this.iJq.iQE.iRI == null || PbFragment.this.iJq.iQE.iRI.getView() == null || PbFragment.this.iJq.iQE.iRI.getView().getParent() == null) {
                                                                                            PbFragment.this.iJq.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                            PbFragment.this.iJq.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z7) {
                                                                                            PbFragment.this.iJq.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                        } else {
                                                                                            PbFragment.this.iJq.getListView().smoothScrollBy(PbFragment.this.iJq.iQE.iRI.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                if (PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cx("tid", PbFragment.this.iFV.iLJ).cx("fid", PbFragment.this.iFV.getPbData().getForumId()).X("obj_locate", 2).cx("uid", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbFragment.this.iFV.getPbData().getForum().getName())) {
                                                                                if (PbFragment.this.iFV.coD() == 3) {
                                                                                    PbFragment.this.iIO.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.iFV.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.cx("tid", PbFragment.this.iFV.cnU());
                                                                                anVar4.cx("fid", PbFragment.this.iFV.getForumId());
                                                                                anVar4.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar = (bj) view.getTag();
                                                                                if (PbFragment.this.iFV.coD() == 3 && PbFragment.this.clN() && PbFragment.this.iFV.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbFragment.this.iFV.getPbData().cli())) {
                                                                                    PbFragment.this.iIO.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar.aCw(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.cx("tid", bjVar.getId());
                                                                                anVar5.s("fid", bjVar.getFid());
                                                                                anVar5.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbFragment.this.iFV != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.cx("tid", PbFragment.this.iFV.cnU());
                                                                                anVar6.cx("fid", PbFragment.this.iFV.getForumId());
                                                                                anVar6.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.X("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.e pbData5 = PbFragment.this.iFV.getPbData();
                                                                                if (PbFragment.this.iJp == null) {
                                                                                    PbFragment.this.iJp = new com.baidu.tieba.pb.data.m(PbFragment.this.getPageContext());
                                                                                }
                                                                                long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").s("forum_id", j2).aGD();
                                                                                PbFragment.this.registerListener(PbFragment.this.iKo);
                                                                                PbFragment.this.iJp.D(j, j2);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").cx("fid", PbFragment.this.iFV.getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", smartApp.name).s("obj_id", smartApp.swan_app_id.longValue()).cx("obj_source", "PB_card").cx("tid", PbFragment.this.iFV.cnU()).X("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bj) {
                                                                                bj bjVar2 = (bj) view.getTag();
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bjVar2.aCw(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cx("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 9).X("obj_locate", 9).s("obj_id", bjVar2.getFid()).cx("tid", bjVar2.getId()).X("thread_type", bjVar2.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bj) && PbFragment.this.checkUpIsLogin()) {
                                                                                bj bjVar3 = (bj) view.getTag();
                                                                                if (PbFragment.this.dku != null) {
                                                                                    PbFragment.this.dku.eA(bjVar3.aCw(), String.valueOf(bjVar3.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").cx("page_type", PageStayDurationConstants.PageName.PB).X("obj_isad", 1).X("obj_floor", 1).X("obj_adlocate", 10).X("obj_locate", 11).s("obj_id", bjVar3.getFid()).cx("tid", bjVar3.getId()).X("thread_type", bjVar3.getThreadType()));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.iFV.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.iFV.cnU(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.iFV.getPbData().ckP().aCL())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbFragment.this.iJq.cqu();
                                                                SparseArray<Object> b3 = PbFragment.this.iJq.b(PbFragment.this.iFV.getPbData(), PbFragment.this.iFV.cnV(), 1);
                                                                if (b3 != null) {
                                                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFV.getPbData().getForum().getId(), PbFragment.this.iFV.getPbData().getForum().getName(), PbFragment.this.iFV.getPbData().ckP().getId(), String.valueOf(PbFragment.this.iFV.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.w(true, false);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 0).X("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                PbFragment.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).X("obj_type", 1).X("obj_source", 1));
                                                            }
                                                            PbFragment.this.iJq.iPx.crx();
                                                        }
                                                    } else if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null) {
                                                        PbFragment.this.iJq.iPx.arX();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbFragment.this.FP(PbFragment.this.iFV.getPbData().ckP().aCH());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbFragment.this.iJq.cqu();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbFragment.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbFragment.this.iFV.com()));
                                                            return;
                                                        }
                                                        PbFragment.this.bEu();
                                                        PbFragment.this.iJq.cqb();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                        if (PbFragment.this.iFV.getPbData().iDp == null || PbFragment.this.iFV.getPbData().iDp.size() <= 0) {
                                                            strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbFragment.this.iFV.getPbData().iDp.size()];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int i8 = i7;
                                                                if (i8 >= PbFragment.this.iFV.getPbData().iDp.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i8] = PbFragment.this.iFV.getPbData().iDp.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                i7 = i8 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                int i10 = 2;
                                                                iVar.dismiss();
                                                                if (PbFragment.this.iFV.getSortType() == 1 && i9 == 1) {
                                                                    i10 = 0;
                                                                } else if (PbFragment.this.iFV.getSortType() == 2 && i9 == 0) {
                                                                    i10 = 1;
                                                                } else if (PbFragment.this.iFV.getSortType() != 3 || i9 == 2) {
                                                                    i10 = (i9 != 2 || PbFragment.this.iFV.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i10));
                                                                if (PbFragment.this.iFV.getPbData().iDp != null && PbFragment.this.iFV.getPbData().iDp.size() > i9) {
                                                                    i9 = PbFragment.this.iFV.getPbData().iDp.get(i9).sort_type.intValue();
                                                                }
                                                                boolean ze = PbFragment.this.iFV.ze(i9);
                                                                view.setTag(Integer.valueOf(PbFragment.this.iFV.com()));
                                                                if (ze) {
                                                                    PbFragment.this.mIsLoading = true;
                                                                    PbFragment.this.iJq.ql(true);
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
                                                PbFragment.this.iJq.cqu();
                                                if (PbFragment.this.clX().getPbData().iDq != 2) {
                                                    if (PbFragment.this.iFV.getPageData() != null) {
                                                        PbFragment.this.iJq.a(PbFragment.this.iFV.getPageData(), PbFragment.this.iuG);
                                                    }
                                                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.iFV.getPbData()) != null) {
                                            bj ckP = pbData.ckP();
                                            if (ckP != null && ckP.aCr() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cx("tid", PbFragment.this.iFV.iLJ).cx("fid", pbData.getForumId()).X("obj_locate", 4).cx("uid", ckP.aCr().getUserId()));
                                            }
                                            int i9 = 1;
                                            if (ckP != null) {
                                                if (ckP.aBg()) {
                                                    i9 = 2;
                                                } else if (ckP.aBh()) {
                                                    i9 = 3;
                                                } else if (ckP.aEk()) {
                                                    i9 = 4;
                                                } else if (ckP.aEl()) {
                                                    i9 = 5;
                                                }
                                            }
                                            com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                            anVar7.cx("tid", PbFragment.this.iFV.cnU());
                                            anVar7.cx("uid", TbadkCoreApplication.getCurrentAccount());
                                            anVar7.cx("fid", PbFragment.this.iFV.getForumId());
                                            if (view.getId() == R.id.share_num_container) {
                                                anVar7.X("obj_locate", 5);
                                            } else {
                                                anVar7.X("obj_locate", 6);
                                            }
                                            anVar7.X("obj_name", i9);
                                            anVar7.X("obj_type", 1);
                                            if (ckP != null) {
                                                if (ckP.aBg()) {
                                                    anVar7.X("obj_type", 10);
                                                } else if (ckP.aBh()) {
                                                    anVar7.X("obj_type", 9);
                                                } else if (ckP.aEl()) {
                                                    anVar7.X("obj_type", 8);
                                                } else if (ckP.aEk()) {
                                                    anVar7.X("obj_type", 7);
                                                } else if (ckP.isShareThread) {
                                                    anVar7.X("obj_type", 6);
                                                } else if (ckP.threadType == 0) {
                                                    anVar7.X("obj_type", 1);
                                                } else if (ckP.threadType == 40) {
                                                    anVar7.X("obj_type", 2);
                                                } else if (ckP.threadType == 49) {
                                                    anVar7.X("obj_type", 3);
                                                } else if (ckP.threadType == 54) {
                                                    anVar7.X("obj_type", 4);
                                                } else {
                                                    anVar7.X("obj_type", 5);
                                                }
                                            }
                                            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                anVar7.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                            }
                                            TiebaStatic.log(anVar7);
                                            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                PbFragment.this.showToast(R.string.neterror);
                                                return;
                                            } else if (pbData != null) {
                                                ArrayList<PostData> ckR2 = PbFragment.this.iFV.getPbData().ckR();
                                                if ((ckR2 != null && ckR2.size() > 0) || !PbFragment.this.iFV.cnV()) {
                                                    PbFragment.this.iJq.cqu();
                                                    PbFragment.this.bEu();
                                                    if (pbData.clh() != null && !StringUtils.isNull(pbData.clh().aAJ(), true)) {
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").cx("fid", PbFragment.this.iFV.getPbData().getForumId()));
                                                    }
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                    if (!AntiHelper.d(PbFragment.this.getContext(), ckP)) {
                                                        if (PbFragment.this.iJq != null) {
                                                            PbFragment.this.iJq.cqx();
                                                            PbFragment.this.iJq.t(pbData);
                                                        }
                                                        int i10 = 6;
                                                        if (!ShareSwitch.isOn()) {
                                                            PbFragment.this.iJq.showLoadingDialog();
                                                            PbFragment.this.iFV.coy().t(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                        } else {
                                                            if (view.getId() == R.id.pb_editor_tool_share) {
                                                                i10 = 2;
                                                            } else if (view.getId() == R.id.share_num_container) {
                                                                i10 = 1;
                                                            }
                                                            PbFragment.this.yX(i10);
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
                                        PbFragment.this.iJq.cqu();
                                        if (PbFragment.this.iJq.iPx.cry() != null && view == PbFragment.this.iJq.iPx.cry().cpd() && !PbFragment.this.iJq.cqN()) {
                                            PbFragment.this.iJq.cpG();
                                        }
                                        if (!PbFragment.this.mIsLoading) {
                                            PbFragment.this.bEu();
                                            PbFragment.this.iJq.cqb();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                v = PbFragment.this.iFV.v(true, PbFragment.this.cnn());
                                            } else {
                                                v = view.getId() == R.id.reply_title ? PbFragment.this.iFV.v(false, PbFragment.this.cnn()) : PbFragment.this.iFV.FU(PbFragment.this.cnn());
                                            }
                                            view.setTag(Boolean.valueOf(v));
                                            if (v) {
                                                PbFragment.this.iJq.pL(true);
                                                PbFragment.this.iJq.bWL();
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.iJq.ql(true);
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
                                    PbFragment.this.iJq.cqu();
                                    if (PbFragment.this.yW(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.iFV.zf(PbFragment.this.iJq.cqg()) != null) {
                                        PbFragment.this.cni();
                                        if (PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cx("tid", PbFragment.this.iFV.iLJ).cx("fid", PbFragment.this.iFV.getPbData().getForumId()).X("obj_locate", 3).cx("uid", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()));
                                        }
                                        if (PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null && PbFragment.this.iFV.getPbData().ckP().aCr().getUserId() != null && PbFragment.this.iJo != null) {
                                            int g = PbFragment.this.g(PbFragment.this.iFV.getPbData());
                                            bj ckP2 = PbFragment.this.iFV.getPbData().ckP();
                                            int i11 = 1;
                                            if (ckP2.aBg()) {
                                                i11 = 2;
                                            } else if (ckP2.aBh()) {
                                                i11 = 3;
                                            } else if (ckP2.aEk()) {
                                                i11 = 4;
                                            } else if (ckP2.aEl()) {
                                                i11 = 5;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cx("tid", PbFragment.this.iFV.iLJ).X("obj_locate", 1).cx("obj_id", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()).X("obj_type", PbFragment.this.iJo.ayO() ? 0 : 1).X("obj_source", g).X("obj_param1", i11));
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
                                if (PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aBe() && PbFragment.this.iFV.getPbData().ckP().aCI() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbFragment.this.iFV.getErrorNo() == 4) {
                                    if (!StringUtils.isNull(PbFragment.this.iFV.clO()) || PbFragment.this.iFV.getAppealInfo() == null) {
                                        PbFragment.this.iIO.finish();
                                        return;
                                    }
                                    name = PbFragment.this.iFV.getAppealInfo().forumName;
                                } else {
                                    name = PbFragment.this.iFV.getPbData().getForum().getName();
                                }
                                if (StringUtils.isNull(name)) {
                                    PbFragment.this.iIO.finish();
                                    return;
                                }
                                String clO = PbFragment.this.iFV.clO();
                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                if (PbFragment.this.iFV.cnW() && clO != null && clO.equals(name)) {
                                    PbFragment.this.iIO.finish();
                                } else {
                                    PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbFragment.this.iFV.getPbData() != null) {
                                if ((PbFragment.this.iFV.getPbData().clb() == 1 || PbFragment.this.iFV.getPbData().clb() == 3) && !PbFragment.this.fLt.cMj()) {
                                    PbFragment.this.iJq.cqu();
                                    int i12 = 0;
                                    if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpe()) {
                                        if (PbFragment.this.iJq.iPx.cry() == null || view != PbFragment.this.iJq.iPx.cry().cpg()) {
                                            if (view == PbFragment.this.iJq.cpZ()) {
                                                i12 = 2;
                                            }
                                        } else if (PbFragment.this.iFV.getPbData().ckP().aCn() == 1) {
                                            i12 = 3;
                                        } else {
                                            i12 = 6;
                                        }
                                    } else if (PbFragment.this.iFV.getPbData().ckP().aCm() == 1) {
                                        i12 = 5;
                                    } else {
                                        i12 = 4;
                                    }
                                    ForumData forum = PbFragment.this.iFV.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbFragment.this.iFV.getPbData().ckP().getId();
                                    PbFragment.this.iJq.cpY();
                                    PbFragment.this.fLt.b(id4, name2, id5, i12, PbFragment.this.iJq.cqa());
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
                        PbFragment.this.iJq.cqu();
                        PbFragment.this.bEu();
                        PbFragment.this.iJq.cqb();
                        PbFragment.this.iJq.showLoadingDialog();
                        if (PbFragment.this.iJq.cpO() != null) {
                            PbFragment.this.iJq.cpO().setVisibility(8);
                        }
                        PbFragment.this.iFV.yZ(1);
                        if (PbFragment.this.iIQ != null) {
                            PbFragment.this.iIQ.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String cmW = PbFragment.this.cmW();
                        if (!TextUtils.isEmpty(cmW)) {
                            ba.aGK().b(PbFragment.this.getPageContext(), new String[]{cmW});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                anVar8.cx("tid", PbFragment.this.iFV.cnU());
                anVar8.cx("fid", PbFragment.this.iFV.getForumId());
                anVar8.cx("uid", TbadkCoreApplication.getCurrentAccount());
                anVar8.X("obj_locate", 1);
                TiebaStatic.log(anVar8);
                if (PbFragment.this.iIZ) {
                    PbFragment.this.iIZ = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.cmP().cpD() != null && postData5.aCr() != null && postData5.cLv() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.cmP().cpE() != null) {
                                PbFragment.this.cmP().cpE().cmF();
                            }
                            com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                            lVar2.a(PbFragment.this.iFV.getPbData().getForum());
                            lVar2.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                            lVar2.f(postData5);
                            PbFragment.this.cmP().cpD().d(lVar2);
                            PbFragment.this.cmP().cpD().setPostId(postData5.getId());
                            PbFragment.this.b(view, postData5.aCr().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iFV.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbFragment.this.iJD != null) {
                                PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iFV.getPbData() != null) {
                    anVar.cx("fid", PbFragment.this.iFV.getPbData().getForumId());
                }
                anVar.cx("tid", PbFragment.this.iFV.cnU());
                anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbFragment.this.bEu();
            PbFragment.this.iJq.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && PbFragment.this.clX() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbFragment.this.clX().FX(postWriteCallBackData.getPostId());
                    PbFragment.this.iJQ = PbFragment.this.iJq.cpK();
                    PbFragment.this.iFV.cs(PbFragment.this.iJQ, PbFragment.this.iJq.cpL());
                }
                PbFragment.this.iJq.cqu();
                PbFragment.this.iJu.cqS();
                if (PbFragment.this.iJD != null) {
                    PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                }
                PbFragment.this.iJq.cpC();
                PbFragment.this.iJq.qx(true);
                PbFragment.this.iFV.coo();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbFragment.this.iFV.getHostMode()) {
                            com.baidu.tieba.pb.data.e pbData = PbFragment.this.iFV.getPbData();
                            if (pbData != null && pbData.ckP() != null && pbData.ckP().aCr() != null && (userId = pbData.ckP().aCr().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.iFV.cof()) {
                                PbFragment.this.iJq.cqb();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.iFV.cof()) {
                            PbFragment.this.iJq.cqb();
                        }
                    } else if (floor != null) {
                        PbFragment.this.iJq.o(PbFragment.this.iFV.getPbData());
                    }
                    if (PbFragment.this.iFV.cnZ()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").cx("tid", PbFragment.this.iFV.cnU()));
                    }
                    PbFragment.this.cmZ();
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.iJD.aPl() || PbFragment.this.iJD.aPm()) {
                    PbFragment.this.iJD.a(false, postWriteCallBackData);
                }
                PbFragment.this.iJu.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.hRk != null) {
                    PbFragment.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d iKn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                    anVar.cx("fid", PbFragment.this.iFV.getPbData().getForumId());
                }
                if (PbFragment.this.iFV != null) {
                    anVar.cx("tid", PbFragment.this.iFV.cnU());
                }
                anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbFragment.this.iJu != null) {
                    PbFragment.this.iJu.cqR();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbFragment.this.hRk != null) {
                    PbFragment.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.iJu != null) {
                if (PbFragment.this.iJq != null && PbFragment.this.iJq.cpE() != null && PbFragment.this.iJq.cpE().cmJ() != null && PbFragment.this.iJq.cpE().cmJ().aPm()) {
                    PbFragment.this.iJq.cpE().cmJ().a(postWriteCallBackData);
                }
                PbFragment.this.iJu.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iKo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView cqQ;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.iIO.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbFragment.this.iJq != null && (cqQ = PbFragment.this.iJq.cqQ()) != null && PbFragment.this.iJq.getListView() != null) {
                            PbFragment.this.iJq.getListView().removeHeaderView(cqQ);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a iKp = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mo;
            if (!z || eVar == null || eVar.ckZ() != null || com.baidu.tbadk.core.util.v.getCount(eVar.ckR()) >= 1) {
                PbFragment.this.ijG = true;
                PbFragment.this.iJq.cqd();
                if (eVar == null || !eVar.ckV()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.iJq.getView());
                }
                PbFragment.this.iJq.bWK();
                if (PbFragment.this.isFullScreen || PbFragment.this.iJq.cqN()) {
                    PbFragment.this.iJq.cqE();
                } else if (!PbFragment.this.iJq.cqB()) {
                    PbFragment.this.iJq.qx(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && eVar != null) {
                    PbFragment.this.eep = true;
                }
                if (eVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.iJq.getView());
                    PbFragment.this.iJq.cqm();
                }
                if (z && eVar != null) {
                    bj ckP = eVar.ckP();
                    if (ckP == null || !ckP.aEm()) {
                        PbFragment.this.d(PbFragment.this.iJC);
                    } else {
                        cnG();
                    }
                    PbFragment.this.iJq.cpE().setPbData(eVar);
                    PbFragment.this.iJq.bgE();
                    if (ckP != null && ckP.aDz() != null) {
                        PbFragment.this.a(ckP.aDz());
                    }
                    if (PbFragment.this.iJD != null) {
                        PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                    if (eVar.ckR() != null && eVar.ckR().size() >= 1 && eVar.ckR().get(0) != null) {
                        PbFragment.this.iFV.FW(eVar.ckR().get(0).getId());
                    } else if (eVar.ckZ() != null) {
                        PbFragment.this.iFV.FW(eVar.ckZ().getId());
                    }
                    if (PbFragment.this.iJD != null) {
                        PbFragment.this.iJD.a(eVar.getAnti());
                        PbFragment.this.iJD.a(eVar.getForum(), eVar.getUserData());
                        PbFragment.this.iJD.setThreadData(ckP);
                        PbFragment.this.iJD.a(PbFragment.this.iFV.coj(), PbFragment.this.iFV.cnU(), PbFragment.this.iFV.coA());
                        if (ckP != null) {
                            PbFragment.this.iJD.gJ(ckP.aDK());
                        }
                    }
                    if (PbFragment.this.iJo != null) {
                        PbFragment.this.iJo.fn(eVar.ayO());
                    }
                    if (eVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (eVar.cln()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.iJq.qw(PbFragment.this.mIsFromCDN);
                    PbFragment.this.iJq.a(eVar, i2, i3, PbFragment.this.iFV.cnV(), i4, PbFragment.this.iFV.getIsFromMark());
                    PbFragment.this.iJq.d(eVar, PbFragment.this.iFV.cnV());
                    PbFragment.this.iJq.qt(PbFragment.this.iFV.getHostMode());
                    AntiData anti = eVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.dyQ = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.dyQ) && PbFragment.this.iJD != null && PbFragment.this.iJD.aOy() != null && (mo = PbFragment.this.iJD.aOy().mo(6)) != null && !TextUtils.isEmpty(PbFragment.this.dyQ)) {
                            ((View) mo).setOnClickListener(PbFragment.this.dzB);
                        }
                    }
                    if (PbFragment.this.iJy) {
                        PbFragment.this.iJy = false;
                        final int cne = PbFragment.this.cne();
                        if (!eVar.aHP()) {
                            PbFragment.this.iJq.zm(cne);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(cne, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.iJz) {
                        PbFragment.this.iJz = false;
                        final int cne2 = PbFragment.this.cne();
                        final boolean z2 = cne2 != -1;
                        if (!z2) {
                            cne2 = PbFragment.this.cnf();
                        }
                        if (PbFragment.this.iJq != null) {
                            if (!eVar.aHP()) {
                                PbFragment.this.iJq.zm(cne2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (cne2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.iJq.setSelectionFromTop(cne2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.iJq.setSelectionFromTop(cne2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.iJq.qy(true);
                                PbFragment.this.iJq.qx(false);
                            }
                        }
                    } else if (PbFragment.this.iJA) {
                        PbFragment.this.iJA = false;
                        PbFragment.this.iJq.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.iJq.cqh();
                    }
                    PbFragment.this.iFV.a(eVar.getForum(), PbFragment.this.iKd);
                    PbFragment.this.iFV.a(PbFragment.this.iKe);
                    if (PbFragment.this.hRk != null && ckP != null && ckP.aCr() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(ckP.aCr());
                        PbFragment.this.hRk.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.eep && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.iFV.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.iFV.getAppealInfo().iDi)) {
                                    PbFragment.this.iJq.a(PbFragment.this.iFV.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.iJq.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.iJq.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.iJq.cqE();
                            PbFragment.this.iJq.cql();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.iFV.cnU());
                            jSONObject.put("fid", PbFragment.this.iFV.getForumId());
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
                        PbFragment.this.iJq.Gc("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                            arrayList = PbFragment.this.iFV.getPbData().ckR();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cLv() != 1)) {
                            PbFragment.this.iJq.Gc(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbFragment.this.cny()) {
                            PbFragment.this.iJq.Gd(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbFragment.this.iJq.Gd(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbFragment.this.iJq.endLoadData();
                }
                if (eVar != null && eVar.iDw && PbFragment.this.dEh == 0) {
                    PbFragment.this.dEh = System.currentTimeMillis() - PbFragment.this.fWb;
                }
                if (!PbFragment.this.clX().cnV() || PbFragment.this.clX().getPbData().getPage().aBo() != 0 || PbFragment.this.clX().cov()) {
                    PbFragment.this.iJE = true;
                    return;
                }
                return;
            }
            PbFragment.this.iFV.yZ(1);
            if (PbFragment.this.iIQ != null) {
                PbFragment.this.iIQ.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void cnG() {
            if (PbFragment.this.iFV != null) {
                if (PbFragment.this.iJD == null || !PbFragment.this.iJD.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.iJD = (com.baidu.tbadk.editortools.pb.e) dVar.dU(PbFragment.this.getContext());
                    PbFragment.this.iJD.a(PbFragment.this.iIO.getPageContext());
                    PbFragment.this.iJD.a(PbFragment.this.dza);
                    PbFragment.this.iJD.a(PbFragment.this.dyT);
                    PbFragment.this.iJD.a(PbFragment.this.iIO.getPageContext(), PbFragment.this.iIO.getIntent() == null ? null : PbFragment.this.iIO.getIntent().getExtras());
                    PbFragment.this.iJD.aOy().gC(true);
                    PbFragment.this.iJq.setEditorTools(PbFragment.this.iJD.aOy());
                    if (!PbFragment.this.iFV.coa()) {
                        PbFragment.this.iJD.vl(PbFragment.this.iFV.cnU());
                    }
                    if (PbFragment.this.iFV.coB()) {
                        PbFragment.this.iJD.vk(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.iJq != null) {
                        PbFragment.this.iJD.vk(PbFragment.this.iJq.cpI());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
            PbFragment.this.iJq.o(eVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.aRq().aRr()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.fWb : j;
                if (PbFragment.this.dEh == 0) {
                    PbFragment.this.dEh = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.dDX, PbFragment.this.createTime, PbFragment.this.dEh, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.dDX = 0L;
                if (iVar != null) {
                    iVar.aRn();
                }
                if (z2) {
                    iVar.dEq = currentTimeMillis;
                    iVar.gU(true);
                }
                if (!z2 && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null) {
                    int threadType = PbFragment.this.iFV.getPbData().ckP().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iJc, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbFragment.this.iJc, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.dEs = currentTimeMillis;
                                iVar2.mN(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.dEs = currentTimeMillis;
                        dVar.mN(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener iKq = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.cna();
            }
        }
    };
    private final a.InterfaceC0374a iKr = new a.InterfaceC0374a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0374a
        public void c(boolean z, boolean z2, String str) {
            PbFragment.this.iJq.cqd();
            if (z) {
                if (PbFragment.this.iJo != null) {
                    PbFragment.this.iJo.fn(z2);
                }
                PbFragment.this.iFV.qd(z2);
                if (PbFragment.this.iFV.ayO()) {
                    PbFragment.this.cnj();
                } else {
                    PbFragment.this.iJq.o(PbFragment.this.iFV.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.iJo != null) {
                        if (PbFragment.this.iJo.ayR() != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null) {
                            MarkData ayR = PbFragment.this.iJo.ayR();
                            MetaData aCr = PbFragment.this.iFV.getPbData().ckP().aCr();
                            if (ayR != null && aCr != null) {
                                if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aCr.getUserId()) && !aCr.hadConcerned()) {
                                    PbFragment.this.b(aCr);
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
                    PbFragment.this.cng();
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
            if (!PbFragment.this.yM(PbFragment.this.mLastScrollState) && PbFragment.this.yM(i)) {
                if (PbFragment.this.iJq != null) {
                    PbFragment.this.iJq.cqu();
                    if (PbFragment.this.iJD != null && !PbFragment.this.iJq.cpH()) {
                        PbFragment.this.iJq.qv(PbFragment.this.iJD.aPe());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.iJq.cpG();
                    }
                }
                if (!PbFragment.this.iIW) {
                    PbFragment.this.iIW = true;
                    if (PbFragment.this.iJq != null) {
                        PbFragment.this.iJq.cqA();
                    }
                }
            }
            if (PbFragment.this.iJq != null) {
                PbFragment.this.iJq.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iIQ != null) {
                PbFragment.this.iIQ.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.iIX == null) {
                PbFragment.this.iIX = new com.baidu.tbadk.n.b();
                PbFragment.this.iIX.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.iIX.aRh();
            } else {
                PbFragment.this.iIX.aRg();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.cKv().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> ckR;
            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null && PbFragment.this.iJq != null && PbFragment.this.iJq.cpX() != null) {
                PbFragment.this.iJq.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.iIQ != null) {
                    PbFragment.this.iIQ.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.iFV.cor() && (ckR = PbFragment.this.iFV.getPbData().ckR()) != null && !ckR.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.iJq.cpX().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.e pbData = PbFragment.this.iFV.getPbData();
                    if (pbData != null) {
                        if (pbData.ckS() != null && pbData.ckS().hasData()) {
                            headerCount--;
                        }
                        if (pbData.ckT() != null && pbData.ckT().hasData()) {
                            headerCount--;
                        }
                        int size = ckR.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d fLy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.fLt.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.iFV.coo();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.iXu != 1002 || bVar.eMo) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.iJq.a(1, dVar.mSuccess, dVar.kkW, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.fLt.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.iJq.a(PbFragment.this.fLt.getLoadDataMode(), gVar.mSuccess, gVar.kkW, false);
                            PbFragment.this.iJq.aM(gVar.kkZ);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.iJq.a(PbFragment.this.fLt.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c iKs = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.51
    };
    private final g.c ecf = new g.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.cno()) {
                PbFragment.this.iIO.finish();
            }
            if (!PbFragment.this.iFV.qc(true)) {
                PbFragment.this.iJq.cqe();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e gKa = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.iKt && PbFragment.this.cno()) {
                PbFragment.this.cnq();
            }
            if (PbFragment.this.mIsLogin) {
                if (PbFragment.this.iFV.qb(false)) {
                    PbFragment.this.iJq.cqc();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.iFV.getPbData() != null) {
                    PbFragment.this.iJq.cqz();
                }
                PbFragment.this.iKt = true;
            }
        }
    };
    private int iKu = 0;
    private final TbRichTextView.i dNb = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f cpX;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.iJq.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                anVar.cx("tid", PbFragment.this.iFV.cnU());
                anVar.cx("fid", PbFragment.this.iFV.getForumId());
                anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.X("obj_locate", 3);
                anVar.X("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(anVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.iFV.iGO.cln()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().aTY() != null) {
                            ArrayList<TbRichTextImageInfo> aTY = tbRichTextView.getRichText().aTY();
                            int i4 = 0;
                            while (i4 < aTY.size()) {
                                if (aTY.get(i4) != null) {
                                    arrayList.add(aTY.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(aTY.get(i4).getSrc()) || str.equals(aTY.get(i4).aUq()) || str.equals(aTY.get(i4).aUn()) || str.equals(aTY.get(i4).aUp()) || str.equals(aTY.get(i4).aUt()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = aTY.get(i4).getSrc();
                                    imageUrlData.originalUrl = aTY.get(i4).getSrc();
                                    imageUrlData.isLongPic = aTY.get(i4).aUv();
                                    concurrentHashMap.put(aTY.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList, i3, "", "", "", false, "", PbFragment.this.iFV.col(), concurrentHashMap, true, false, z);
                        createConfig.getIntent().putExtra("from", "pb");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                            createConfig.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                        }
                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                        return;
                    }
                    PbActivity.a aVar = new PbActivity.a();
                    PbFragment.this.a(str, i, aVar);
                    if (aVar.iGd) {
                        TbRichText bj = PbFragment.this.bj(str, i);
                        if (bj != null && PbFragment.this.iKu >= 0 && PbFragment.this.iKu < bj.aTX().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.f.b(bj.aTX().get(PbFragment.this.iKu));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar.iGa.size()) {
                                    break;
                                } else if (!aVar.iGa.get(i6).equals(b2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar.index = i6;
                                    arrayList2.add(b2);
                                    break;
                                }
                            }
                            if (bj.getPostId() != 0 && (cpX = PbFragment.this.iJq.cpX()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = cpX.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bj.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bj.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.iFV.coA(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.iFV.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar.iGb.get(str2));
                            }
                            ImageViewerConfig createConfig2 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iGc, aVar.lastId, PbFragment.this.iFV.col(), concurrentHashMap2, true, false, z);
                            createConfig2.getIntent().putExtra("from", "pb");
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            createConfig2.setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            createConfig2.setPostId(aVar.postId);
                            if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                createConfig2.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                            }
                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(com.baidu.tbadk.core.util.v.getItem(aVar.iGa, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar.iGb.get(str3));
                    }
                    ImageViewerConfig createConfig3 = new ImageViewerConfig(PbFragment.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, aVar.forumName, aVar.forumId, aVar.threadId, aVar.iGc, aVar.iGa.get(0), PbFragment.this.iFV.col(), concurrentHashMap3, true, false, z);
                    createConfig3.getIntent().putExtra("from", "pb");
                    createConfig3.setIsCanDrag(false);
                    createConfig3.setPostId(aVar.postId);
                    if (PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                        createConfig3.setThreadData(PbFragment.this.iFV.getPbData().ckP());
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
                PbFragment.this.iJg = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean iKv = false;
    PostData hjm = null;
    private final b.a iKw = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.hjm != null) {
                if (i == 0) {
                    PbFragment.this.hjm.fu(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.hjm = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.k(PbFragment.this.hjm);
                }
            }
        }
    };
    private final b.a iKx = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.iJN != null && !TextUtils.isEmpty(PbFragment.this.iJO)) {
                if (i == 0) {
                    if (PbFragment.this.iJP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iJO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.iJO;
                        aVar.pkgId = PbFragment.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iJP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.gRU == null) {
                            PbFragment.this.gRU = new ar(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.gRU.j(PbFragment.this.iJO, PbFragment.this.iJN.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.iJN = null;
                PbFragment.this.iJO = null;
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
                        PbFragment.this.iJN = ((TbImageView) view).getBdImage();
                        PbFragment.this.iJO = ((TbImageView) view).getUrl();
                        if (PbFragment.this.iJN == null || TextUtils.isEmpty(PbFragment.this.iJO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iJP = null;
                        } else {
                            PbFragment.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbFragment.this.iJN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbFragment.this.iJO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.iJP = null;
                            } else {
                                PbFragment.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbFragment.this.iJN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbFragment.this.iJO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbFragment.this.iJP = null;
                        } else {
                            PbFragment.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbFragment.this.iJq.a(PbFragment.this.iKx, PbFragment.this.iJN.isGif());
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
            PbFragment.this.hjm = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbFragment.this.hjm == null) {
                return true;
            }
            if (PbFragment.this.hjm.cLv() != 1 || !PbFragment.this.cv(view)) {
                if (PbFragment.this.iJo != null) {
                    if (!PbFragment.this.iJo.ayO() || PbFragment.this.hjm.getId() == null || !PbFragment.this.hjm.getId().equals(PbFragment.this.iFV.aCA())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean z3 = PbFragment.this.clX().getPbData() != null && PbFragment.this.clX().getPbData().cln();
                    if (PbFragment.this.hjm.cLv() != 1) {
                        if (PbFragment.this.iJw == null) {
                            PbFragment.this.iJw = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                            PbFragment.this.iJw.a(PbFragment.this.iKy);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (view != null && sparseArray2 != null) {
                            boolean z4 = PbFragment.this.cv(view) && !z3;
                            boolean z5 = (!PbFragment.this.cv(view) || PbFragment.this.iJN == null || PbFragment.this.iJN.isGif()) ? false : true;
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
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.iJw));
                            }
                            if (z5) {
                                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.iJw));
                            }
                            if (!z4 && !z5) {
                                com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.iJw);
                                SparseArray sparseArray3 = new SparseArray();
                                sparseArray3.put(R.id.tag_clip_board, PbFragment.this.hjm);
                                gVar3.mTextView.setTag(sparseArray3);
                                arrayList.add(gVar3);
                            }
                            if (!z2 && !z3) {
                                if (z) {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.iJw);
                                } else {
                                    gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.iJw);
                                }
                                SparseArray sparseArray4 = new SparseArray();
                                sparseArray4.put(R.id.tag_clip_board, PbFragment.this.hjm);
                                sparseArray4.put(R.id.tag_is_subpb, false);
                                gVar2.mTextView.setTag(sparseArray4);
                                arrayList.add(gVar2);
                            }
                            if (PbFragment.this.mIsLogin) {
                                if (!z8 && z7) {
                                    com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.iJw);
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
                                    if ((PbFragment.this.pR(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                        com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.iJw);
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
                                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iJw);
                                        gVar6.mTextView.setTag(sparseArray6);
                                    } else {
                                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                                    }
                                    gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.iJw);
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
                                        if (PbFragment.this.iFV.getPbData().clb() == 1002 && !z6) {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.iJw);
                                        } else {
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.iJw);
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
                            PbFragment.this.iJw.az(arrayList);
                            PbFragment.this.iJv = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.iJw);
                            PbFragment.this.iJv.showDialog();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").cx("tid", PbFragment.this.iFV.iLJ).cx("fid", PbFragment.this.iFV.getForumId()).cx("uid", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()).cx("post_id", PbFragment.this.iFV.aOT()).X("obj_source", z2 ? 2 : 1));
                        }
                        return true;
                    }
                    if (!z3) {
                        PbFragment.this.iJq.a(PbFragment.this.iKw, z, false);
                    }
                    return true;
                }
                return true;
            }
            PbFragment.this.iJq.a(PbFragment.this.iKx, PbFragment.this.iJN.isGif());
            return true;
        }
    };
    private k.c iKy = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            int i2;
            if (PbFragment.this.iJv != null) {
                PbFragment.this.iJv.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.iJN != null && !TextUtils.isEmpty(PbFragment.this.iJO)) {
                        if (PbFragment.this.iJP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.iJO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.iJO;
                            aVar.pkgId = PbFragment.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.iJP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.iJN = null;
                        PbFragment.this.iJO = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.iJN != null && !TextUtils.isEmpty(PbFragment.this.iJO)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.gRU == null) {
                                PbFragment.this.gRU = new ar(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.gRU.j(PbFragment.this.iJO, PbFragment.this.iJN.getImageByte());
                            PbFragment.this.iJN = null;
                            PbFragment.this.iJO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.hjm != null) {
                        PbFragment.this.hjm.fu(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.hjm = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").X("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.cu(view);
                        if (PbFragment.this.iFV.getPbData().ckP() != null && PbFragment.this.iFV.getPbData().ckP().aCr() != null && PbFragment.this.iFV.getPbData().ckP().aCr().getUserId() != null && PbFragment.this.iJo != null) {
                            int g = PbFragment.this.g(PbFragment.this.iFV.getPbData());
                            bj ckP = PbFragment.this.iFV.getPbData().ckP();
                            if (ckP.aBg()) {
                                i2 = 2;
                            } else if (ckP.aBh()) {
                                i2 = 3;
                            } else if (ckP.aEk()) {
                                i2 = 4;
                            } else {
                                i2 = ckP.aEl() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").cx("tid", PbFragment.this.iFV.iLJ).X("obj_locate", 2).cx("obj_id", PbFragment.this.iFV.getPbData().ckP().aCr().getUserId()).X("obj_type", PbFragment.this.iJo.ayO() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
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
                        PbFragment.this.iJq.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.iJq.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.iJq.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a gmG = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.isPaused && z && !PbFragment.this.iFV.cob()) {
                PbFragment.this.cnl();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.72
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.gtf.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0499a fSv = new a.InterfaceC0499a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        final int eLR = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            if (av(i2) && PbFragment.this.iJq != null && PbFragment.this.iIQ != null) {
                PbFragment.this.iIQ.lH(true);
                if (Math.abs(i2) > this.eLR) {
                    PbFragment.this.iIQ.hideFloatingView();
                }
                if (PbFragment.this.cno()) {
                    PbFragment.this.iJq.cpU();
                    PbFragment.this.iJq.cpV();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            if (av(i2) && PbFragment.this.iJq != null && PbFragment.this.iIQ != null) {
                PbFragment.this.iJq.cqF();
                PbFragment.this.iIQ.lH(false);
                PbFragment.this.iIQ.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bB(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final n.a iHW = new n.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // com.baidu.tieba.pb.pb.main.n.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.iJq.Ge(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int iKA = -1;
    private int iKB = -1;

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

    public com.baidu.tbadk.editortools.pb.e cmK() {
        return this.iJD;
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (lVar.clB() != null) {
            String id = lVar.clB().getId();
            ArrayList<PostData> ckR = this.iFV.getPbData().ckR();
            int i = 0;
            while (true) {
                if (i >= ckR.size()) {
                    break;
                }
                PostData postData = ckR.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> clF = lVar.clF();
                    postData.CD(lVar.getTotalCount());
                    if (postData.cLs() != null && clF != null) {
                        Iterator<PostData> it = clF.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aCr() != null && (metaData = postData.getUserMap().get(next.aCr().getUserId())) != null) {
                                next.a(metaData);
                                next.sU(true);
                                next.a(getPageContext(), this.iFV.FV(metaData.getUserId()));
                            }
                        }
                        boolean z2 = clF.size() != postData.cLs().size();
                        postData.cLs().clear();
                        postData.cLs().addAll(clF);
                        z = z2;
                    }
                    if (postData.cLo() != null) {
                        postData.cLp();
                    }
                }
            }
            if (!this.iFV.getIsFromMark() && z) {
                this.iJq.o(this.iFV.getPbData());
            }
            if (z) {
                c(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m cle = this.iFV.getPbData().cle();
            if (cle != null && str.equals(cle.getAdId())) {
                if (cle.cLj() != null) {
                    cle.cLj().legoCard = null;
                }
                this.iFV.getPbData().clf();
            }
            com.baidu.tieba.tbadkCore.data.m coh = this.iFV.coh();
            if (coh != null && str.equals(coh.getAdId())) {
                this.iFV.coi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iJv != null && this.iJv.isShowing()) {
                this.iJv.dismiss();
                this.iJv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.iJv != null) {
                            PbFragment.this.iJv.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.iJq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.iJL);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.iJL);
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
                this.iJv = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.iJv.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(int i) {
        bj ckP;
        if (this.iFV != null && this.iFV.getPbData() != null && (ckP = this.iFV.getPbData().ckP()) != null) {
            if (i == 1) {
                PraiseData aCc = ckP.aCc();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aCc == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        ckP.a(praiseData);
                    } else {
                        ckP.aCc().getUser().add(0, metaData);
                        ckP.aCc().setNum(ckP.aCc().getNum() + 1);
                        ckP.aCc().setIsLike(i);
                    }
                }
                if (ckP.aCc() != null) {
                    if (ckP.aCc().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(ckP.aCc().getNum());
                    }
                }
            } else if (ckP.aCc() != null) {
                ckP.aCc().setIsLike(i);
                ckP.aCc().setNum(ckP.aCc().getNum() - 1);
                ArrayList<MetaData> user = ckP.aCc().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            ckP.aCc().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (ckP.aCc().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = ckP.aCc().getNum() + "";
                }
            }
            if (this.iFV.cnV()) {
                this.iJq.cpX().notifyDataSetChanged();
            } else {
                this.iJq.p(this.iFV.getPbData());
            }
        }
    }

    public static PbFragment cmL() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.iIO = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.iFV.au(bundle);
        if (this.gpi != null) {
            this.gpi.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.iJD.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.iIV = System.currentTimeMillis();
        this.iJJ = getPageContext();
        final Intent intent = this.iIO.getIntent();
        if (intent != null) {
            this.fWb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.iJc = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.iJc)) {
                    this.iJc = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.iJc)) {
                this.iIR = true;
            }
            this.iKA = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.iKB = intent.getIntExtra("key_manga_next_chapter", -1);
            this.iKC = intent.getStringExtra("key_manga_title");
            this.iJy = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.iJz = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.iJA = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (cno()) {
                this.iIO.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.iJR = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.iJl = new ax();
            this.iJl.R(intent);
            this.iJT = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.iJT == 0) {
                this.iJT = intent.getIntExtra("key_start_from", 0);
            }
            this.iJU = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.fWb = System.currentTimeMillis();
        }
        this.dDX = this.iIV - this.fWb;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.iIT = 0;
        at(bundle);
        if (this.iFV.getPbData() != null) {
            this.iFV.getPbData().FJ(this.source);
        }
        cmO();
        if (intent != null && this.iJq != null) {
            this.iJq.iPv = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.iJM == null) {
                    this.iJM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.iJq.Gg("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iJM, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.iFV.getPbData() != null) {
                this.iFV.FY(stringExtra);
            }
        }
        this.gpi = new VoiceManager();
        this.gpi.onCreate(getPageContext());
        initData(bundle);
        this.iJC = new com.baidu.tbadk.editortools.pb.g();
        d(this.iJC);
        this.iJD = (com.baidu.tbadk.editortools.pb.e) this.iJC.dU(getActivity());
        this.iJD.a(this.iIO.getPageContext());
        this.iJD.a(this.dza);
        this.iJD.a(this.dyT);
        this.iJD.a(this.iIO.getPageContext(), bundle);
        this.iJD.aOy().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.iJD.aOy().gC(true);
        pQ(true);
        this.iJD.a(this.iFV.coj(), this.iFV.cnU(), this.iFV.coA());
        registerListener(this.iJZ);
        if (!this.iFV.coa()) {
            this.iJD.vl(this.iFV.cnU());
        }
        if (this.iFV.coB()) {
            this.iJD.vk(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.iJq != null) {
            this.iJD.vk(this.iJq.cpI());
        }
        registerListener(this.iJY);
        registerListener(this.iKa);
        registerListener(this.iKb);
        registerListener(this.gqx);
        registerListener(this.iKm);
        registerListener(this.iJX);
        this.iJB = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.khH);
        this.iJB.cLc();
        registerListener(this.iKc);
        registerListener(this.dat);
        this.iFV.cot();
        registerListener(this.iKq);
        registerListener(this.gqE);
        if (this.iJq != null && this.iJq.cqJ() != null && this.iJq.cqK() != null) {
            this.iIQ = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.iJq.cqJ(), this.iJq.cqK(), this.iJq.cpO());
            this.iIQ.a(this.iKh);
        }
        if (this.iIP && this.iJq != null && this.iJq.cqK() != null) {
            this.iJq.cqK().setVisibility(8);
        }
        this.iJK = new com.baidu.tbadk.core.view.d();
        this.iJK.toastTime = 1000L;
        registerListener(this.iKl);
        registerListener(this.iKj);
        registerListener(this.iKk);
        registerListener(this.gGL);
        registerListener(this.gqu);
        registerResponsedEventListener(TipEvent.class, this.goq);
        this.iJL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.iJL;
        userMuteAddAndDelCustomMessage.setTag(this.iJL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.iJL;
        userMuteCheckCustomMessage.setTag(this.iJL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.iFV.coy().a(this.iKi);
        this.iJu = new ap();
        if (this.iJD.aOX() != null) {
            this.iJu.e(this.iJD.aOX().getInputView());
        }
        this.iJD.a(this.dyU);
        this.gFE = new ShareSuccessReplyToServerModel();
        a(this.iJV);
        this.hRk = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.hRk.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.dak) {
                        PbFragment.this.iJD.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.dal && PbFragment.this.iJq != null && PbFragment.this.iJq.cpE() != null && PbFragment.this.iJq.cpE().cmJ() != null) {
                        PbFragment.this.iJq.cpE().cmJ().aPt();
                    } else if (i == com.baidu.tbadk.core.util.aj.dam) {
                        PbFragment.this.c(PbFragment.this.iJG);
                    }
                }
            }
        });
        this.iJn = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.iJn.t(getUniqueId());
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        com.baidu.tbadk.core.business.a.aAd().cn("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.iIV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.iFV != null) {
            gVar.setForumName(this.iFV.clO());
            if (this.iFV.getPbData() != null && this.iFV.getPbData().getForum() != null) {
                gVar.a(this.iFV.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.iFV);
        }
    }

    public String cmM() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b cmN() {
        return this.iIQ;
    }

    private void pQ(boolean z) {
        this.iJD.gG(z);
        this.iJD.gH(z);
        this.iJD.gI(z);
    }

    private void cmO() {
        this.dku = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    public an cmP() {
        return this.iJq;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel clX() {
        return this.iFV;
    }

    public void FO(String str) {
        if (this.iFV != null && !StringUtils.isNull(str) && this.iJq != null) {
            this.iJq.qA(true);
            this.iFV.FO(str);
            this.iJb = true;
            this.iJq.cqu();
            this.iJq.cqE();
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
        this.iIT = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.iIT == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
        if (this.iJq != null) {
            this.iJq.onPause();
        }
        if (!this.iFV.coa()) {
            this.iJD.saveDraft(this.iFV.cnU());
        }
        if (this.iFV != null) {
            this.iFV.cou();
        }
        com.baidu.tbadk.BdToken.c.axC().axH();
        MessageManager.getInstance().unRegisterListener(this.hvk);
        bQp();
        MessageManager.getInstance().unRegisterListener(this.iKj);
        MessageManager.getInstance().unRegisterListener(this.iKk);
        MessageManager.getInstance().unRegisterListener(this.iKl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean cmQ() {
        PostData a2 = com.baidu.tieba.pb.data.f.a(this.iFV.getPbData(), this.iFV.cnV(), this.iFV.cos());
        return (a2 == null || a2.aCr() == null || a2.aCr().getGodUserData() == null || a2.aCr().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.isPaused = false;
        super.onResume();
        if (this.iJe) {
            this.iJe = false;
            cnu();
        }
        if (cmQ()) {
            this.iIY = System.currentTimeMillis();
        } else {
            this.iIY = -1L;
        }
        if (this.iJq != null && this.iJq.getView() != null) {
            if (!this.ijG) {
                cnm();
            } else {
                hideLoadingView(this.iJq.getView());
            }
            this.iJq.onResume();
        }
        if (this.iIT == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.iJq != null) {
            noNetworkView = this.iJq.cpB();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
        registerListener(this.hvk);
        this.iJx = false;
        cnt();
        registerListener(this.iKj);
        registerListener(this.iKk);
        registerListener(this.iKl);
        if (this.gpV) {
            cnl();
            this.gpV = false;
        }
        cnA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iJq.qp(z);
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
        if (z && this.iJx) {
            this.iJq.cqc();
            this.iFV.qb(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.iIY > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").cx("obj_duration", (System.currentTimeMillis() - this.iIY) + ""));
            this.iIY = 0L;
        }
        if (cmP().cpE() != null) {
            cmP().cpE().onStop();
        }
        if (this.iJq.iPx != null && !this.iJq.iPx.crA()) {
            this.iJq.iPx.releaseResources();
        }
        if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().getForum() != null && this.iFV.getPbData().ckP() != null) {
            com.baidu.tbadk.distribute.a.aOm().a(getPageContext().getPageActivity(), "pb", this.iFV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iFV.getPbData().ckP().getId(), 0L));
        }
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cx("fid", this.iFV.getPbData().getForumId());
            anVar.cx("tid", this.iFV.cnU());
            anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.iIW && this.iJq != null) {
            this.iIW = true;
            this.iJq.cqA();
            a(false, (PostData) null);
        }
        if (this.iFV != null) {
            this.iFV.cancelLoadData();
            this.iFV.destory();
            if (this.iFV.cox() != null) {
                this.iFV.cox().onDestroy();
            }
        }
        if (this.iJD != null) {
            this.iJD.onDestroy();
        }
        if (this.fLt != null) {
            this.fLt.cancelLoadData();
        }
        if (this.dku != null) {
            this.dku.cKP();
        }
        if (this.iJq != null) {
            this.iJq.onDestroy();
            if (this.iJq.iPx != null) {
                this.iJq.iPx.releaseResources();
            }
        }
        if (this.iIX != null) {
            this.iIX.aRi();
        }
        if (this.iIQ != null) {
            this.iIQ.aWN();
        }
        super.onDestroy();
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
        if (this.iJq != null) {
            this.iJq.cqu();
        }
        MessageManager.getInstance().unRegisterListener(this.iKj);
        MessageManager.getInstance().unRegisterListener(this.iKk);
        MessageManager.getInstance().unRegisterListener(this.iKl);
        MessageManager.getInstance().unRegisterListener(this.iJL);
        MessageManager.getInstance().unRegisterListener(this.iKm);
        MessageManager.getInstance().unRegisterListener(this.gqE);
        MessageManager.getInstance().unRegisterListener(this.gGL);
        MessageManager.getInstance().unRegisterListener(this.iKo);
        this.iJJ = null;
        this.iJK = null;
        com.baidu.tieba.recapp.d.a.cDF().cDH();
        if (this.iJM != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iJM);
        }
        if (this.iJf != null) {
            this.iJf.cancelLoadData();
        }
        if (this.iJq != null && this.iJq.iPx != null) {
            this.iJq.iPx.crD();
        }
        if (this.gFE != null) {
            this.gFE.cancelLoadData();
        }
        this.iJu.onDestroy();
        if (this.iFV != null && this.iFV.coz() != null) {
            this.iFV.coz().onDestroy();
        }
        if (this.hRk != null) {
            this.hRk.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f cpX;
        ArrayList<PostData> cmv;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aJi() && this.iJq != null && (cpX = this.iJq.cpX()) != null && (cmv = cpX.cmv()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = cmv.iterator();
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
                        bVar.fNo = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cSY == 1 && !TextUtils.isEmpty(id)) {
                    next.cSY = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.fNo = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.iFV == null || this.iFV.getPbData() == null || this.iFV.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.iFV.getPbData().getForum().getFirst_class();
                    str2 = this.iFV.getPbData().getForum().getSecond_class();
                    str = this.iFV.getPbData().getForum().getId();
                    str4 = this.iFV.cnU();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aJl());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.iJq.onChangeSkinType(i);
            if (this.iJD != null && this.iJD.aOy() != null) {
                this.iJD.aOy().onChangeSkinType(i);
            }
            if (this.iJq.cpB() != null) {
                this.iJq.cpB().onChangeSkinType(getPageContext(), i);
            }
            this.iJu.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iJq = new an(this, this.grn, this.drk);
        this.gtf = new com.baidu.tieba.f.b(getActivity());
        this.gtf.a(iKz);
        this.gtf.a(this.fSv);
        this.iJq.setOnScrollListener(this.mOnScrollListener);
        this.iJq.d(this.gKa);
        this.iJq.setListPullRefreshListener(this.ecf);
        this.iJq.pC(com.baidu.tbadk.core.i.azR().isShowImages());
        this.iJq.setOnImageClickListener(this.dNb);
        this.iJq.b(this.mOnLongClickListener);
        this.iJq.g(this.gmG);
        this.iJq.a(this.iKs);
        this.iJq.qp(this.mIsLogin);
        if (this.iIO.getIntent() != null) {
            this.iJq.qB(this.iIO.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.iJq.cpD().setFromForumId(this.iFV.getFromForumId());
        this.iJq.setEditorTools(this.iJD.aOy());
        this.iJD.vk(this.iJq.cpI());
        this.iJq.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.iFV.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFV.getPbData().getForum().getId(), PbFragment.this.iFV.getPbData().getForum().getName(), PbFragment.this.iFV.getPbData().ckP().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        return this.iJq.getView();
    }

    public void cmR() {
        if (this.iJq != null && this.iFV != null) {
            if ((this.iFV.getPbData() != null || this.iFV.getPbData().clk() != null) && checkUpIsLogin() && this.iJq.cpX() != null && this.iJq.cpX().cmA() != null) {
                this.iJq.cpX().cmA().tX(this.iFV.cnU());
            }
        }
    }

    public void cmS() {
        TiebaStatic.log("c12181");
        if (this.iJq != null && this.iFV != null) {
            if ((this.iJq == null || this.iJq.cpH()) && this.iFV.getPbData() != null && this.iFV.getPbData().clk() != null) {
                com.baidu.tieba.pb.data.k clk = this.iFV.getPbData().clk();
                if (checkUpIsLogin()) {
                    if ((!clk.cly() || clk.aDO() != 2) && this.iJq.cpX() != null && this.iJq.cpX().cmA() != null) {
                        this.iJq.cpX().cmA().tX(this.iFV.cnU());
                    }
                    if (System.currentTimeMillis() - this.iJa > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).rj(false);
                        this.iJa = System.currentTimeMillis();
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
                if (postData.getType() != PostData.kij && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.azR().isShowImages()) {
                    return FR(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.iFV == null || this.iFV.getPbData() == null) {
                        return true;
                    }
                    if (cmP().cpE() != null) {
                        cmP().cpE().cmF();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(this.iFV.getPbData().getForum());
                    lVar.setThreadData(this.iFV.getPbData().ckP());
                    lVar.f(postData);
                    cmP().cpD().d(lVar);
                    cmP().cpD().setPostId(postData.getId());
                    b(view, postData.aCr().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.iJD != null) {
                        this.iJq.qv(this.iJD.aPe());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void cmT() {
        if (this.iIU == null) {
            this.iIU = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.iIU.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.iFR = PbFragment.this.iFR.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFR);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iFV.cnU(), PbFragment.this.iFR, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.iFR = PbFragment.this.iFR.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFR);
                        new com.baidu.tieba.pb.pb.main.a(PbFragment.this.iFV.cnU(), PbFragment.this.iFR, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.iFR = PbFragment.this.iFR.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.iFR);
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
        this.iKp.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).ctA(), "", 1);
    }

    private void at(Bundle bundle) {
        this.iFV = this.iIO.clX();
        if (this.iFV.cow() != null) {
            this.iFV.cow().a(this.iHW);
        }
        if (this.iFV.cox() != null) {
            this.iFV.cox().b(this.iJW);
        }
        if (StringUtils.isNull(this.iFV.cnU())) {
            this.iIO.finish();
        } else if ("from_tieba_kuang".equals(this.iJc) && this.iJc != null) {
            this.iFV.zg(6);
        }
    }

    private void initData(Bundle bundle) {
        this.iJo = com.baidu.tbadk.baseEditMark.a.a(this.iIO);
        if (this.iJo != null) {
            this.iJo.a(this.iKr);
        }
        this.fLt = new ForumManageModel(this.iIO);
        this.fLt.setLoadDataCallBack(this.fLy);
        this.dap = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.iKg.setUniqueId(getUniqueId());
        this.iKg.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iJq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iJL;
        userMuteCheckCustomMessage.setTag(this.iJL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean cmU() {
        if (this.iFV == null || this.iFV.getPbData() == null) {
            return false;
        }
        bj ckP = this.iFV.getPbData().ckP();
        this.iFV.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), ckP);
    }

    public void cmV() {
        if (checkUpIsLogin() && this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().getForum() != null && !cmU()) {
            if (this.iFV.getPbData().cln()) {
                this.iJq.bPQ();
                return;
            }
            if (this.gsJ == null) {
                this.gsJ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.gsJ.tV(0);
                this.gsJ.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void t(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void lD(boolean z) {
                        if (z) {
                            PbFragment.this.iJq.bPQ();
                        }
                    }
                });
            }
            this.gsJ.C(this.iFV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iFV.cnU(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cmW() {
        com.baidu.tieba.pb.data.e pbData;
        if (this.iFV == null || (pbData = this.iFV.getPbData()) == null) {
            return null;
        }
        return pbData.cla().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            if (eVar.ckP().getThreadType() == 0) {
                return 1;
            }
            if (eVar.ckP().getThreadType() == 54) {
                return 2;
            }
            if (eVar.ckP().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cmU() && cmX()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.iJh);
                this.iJi = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.iFV.getPbData() != null && this.iFV.getPbData().cln()) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.iIO.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.cmP().getListView().smoothScrollBy((PbFragment.this.iJh[1] + PbFragment.this.iJi) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmP().cpE() != null) {
                            PbFragment.this.iJD.aOy().setVisibility(8);
                            PbFragment.this.cmP().cpE().g(str, str2, PbFragment.this.cmP().cpI(), (PbFragment.this.iFV == null || PbFragment.this.iFV.getPbData() == null || PbFragment.this.iFV.getPbData().ckP() == null || !PbFragment.this.iFV.getPbData().ckP().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmJ = PbFragment.this.cmP().cpE().cmJ();
                            if (cmJ != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                cmJ.a(PbFragment.this.iFV.getPbData().getAnti());
                                cmJ.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                            }
                            if (PbFragment.this.iJu.cqV() == null && PbFragment.this.cmP().cpE().cmJ().aPB() != null) {
                                PbFragment.this.cmP().cpE().cmJ().aPB().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iJu != null && PbFragment.this.iJu.cqU() != null) {
                                            if (!PbFragment.this.iJu.cqU().cUA()) {
                                                PbFragment.this.iJu.qD(false);
                                            }
                                            PbFragment.this.iJu.cqU().tO(false);
                                        }
                                    }
                                });
                                PbFragment.this.iJu.f(PbFragment.this.cmP().cpE().cmJ().aPB().getInputView());
                                PbFragment.this.cmP().cpE().cmJ().a(PbFragment.this.iJI);
                            }
                        }
                        PbFragment.this.cmP().cqE();
                    }
                }, 0L);
                return;
            }
            if (this.iJF == null) {
                this.iJF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iJF.tV(1);
                this.iJF.a(new AnonymousClass37(str, str2));
            }
            if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().getForum() != null) {
                this.iJF.C(this.iFV.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.iFV.cnU(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$37  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass37 implements c.a {
        final /* synthetic */ String iKL;
        final /* synthetic */ String iKM;

        AnonymousClass37(String str, String str2) {
            this.iKL = str;
            this.iKM = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lD(boolean z) {
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
                        PbFragment.this.cmP().getListView().smoothScrollBy((PbFragment.this.iJh[1] + PbFragment.this.iJi) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.cmP().cpE() != null) {
                            PbFragment.this.iJD.aOy().setVisibility(8);
                            PbFragment.this.cmP().cpE().g(AnonymousClass37.this.iKL, AnonymousClass37.this.iKM, PbFragment.this.cmP().cpI(), (PbFragment.this.iFV == null || PbFragment.this.iFV.getPbData() == null || PbFragment.this.iFV.getPbData().ckP() == null || !PbFragment.this.iFV.getPbData().ckP().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cmJ = PbFragment.this.cmP().cpE().cmJ();
                            if (cmJ != null && PbFragment.this.iFV != null && PbFragment.this.iFV.getPbData() != null) {
                                cmJ.a(PbFragment.this.iFV.getPbData().getAnti());
                                cmJ.setThreadData(PbFragment.this.iFV.getPbData().ckP());
                            }
                            if (PbFragment.this.iJu.cqV() == null && PbFragment.this.cmP().cpE().cmJ().aPB() != null) {
                                PbFragment.this.cmP().cpE().cmJ().aPB().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.iJu != null && PbFragment.this.iJu.cqU() != null) {
                                            if (!PbFragment.this.iJu.cqU().cUA()) {
                                                PbFragment.this.iJu.qD(false);
                                            }
                                            PbFragment.this.iJu.cqU().tO(false);
                                        }
                                    }
                                });
                                PbFragment.this.iJu.f(PbFragment.this.cmP().cpE().cmJ().aPB().getInputView());
                                PbFragment.this.cmP().cpE().cmJ().a(PbFragment.this.iJI);
                            }
                        }
                        PbFragment.this.cmP().cqE();
                    }
                }, 0L);
            }
        }
    }

    public boolean cmX() {
        if ((this.iFV.getPbData() != null && this.iFV.getPbData().cln()) || this.hRk == null || this.iFV.getPbData() == null || this.iFV.getPbData().getAnti() == null) {
            return true;
        }
        return this.hRk.ks(this.iFV.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean yV(int i) {
        if (this.hRk == null || this.iFV.getPbData() == null || this.iFV.getPbData().getAnti() == null) {
            return true;
        }
        return this.hRk.ax(this.iFV.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.iFV != null && this.iFV.getPbData() != null && postData.cLv() != 1) {
            String cnU = this.iFV.cnU();
            String id = postData.getId();
            int clb = this.iFV.getPbData() != null ? this.iFV.getPbData().clb() : 0;
            PbActivity.a FS = FS(id);
            if (FS != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(cnU, id, "pb", true, null, false, null, clb, postData.csv(), this.iFV.getPbData().getAnti(), false, postData.aCr() != null ? postData.aCr().getIconInfo() : null).addBigImageData(FS.iGa, FS.iGb, FS.iGc, FS.index);
                addBigImageData.setKeyPageStartFrom(this.iFV.coD());
                addBigImageData.setFromFrsForumId(this.iFV.getFromForumId());
                addBigImageData.setKeyFromForumId(this.iFV.getForumId());
                addBigImageData.setBjhData(this.iFV.coc());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmY() {
        if (this.iFV.getPbData() == null || this.iFV.getPbData().ckP() == null) {
            return -1;
        }
        return this.iFV.getPbData().ckP().aDb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmZ() {
        if (this.iFV != null && this.iFV.iGO != null && this.iFV.iGO.ckP() != null) {
            bj ckP = this.iFV.iGO.ckP();
            ckP.mRecomAbTag = this.iFV.coO();
            ckP.mRecomWeight = this.iFV.coM();
            ckP.mRecomSource = this.iFV.coN();
            ckP.mRecomExtra = this.iFV.coP();
            if (ckP.getFid() == 0) {
                ckP.setFid(com.baidu.adp.lib.f.b.toLong(this.iFV.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckP, "c13563");
            if (a2 != null) {
                a2.X("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cna() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Iw(this.iFV.getForumId()) && this.iFV.getPbData() != null && this.iFV.getPbData().getForum() != null) {
            if (this.iFV.getPbData().getForum().isLike() == 1) {
                this.iFV.coz().et(this.iFV.getForumId(), this.iFV.cnU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pR(boolean z) {
        if (this.iFV == null || this.iFV.getPbData() == null) {
            return false;
        }
        return ((this.iFV.getPbData().clb() != 0) || this.iFV.getPbData().ckP() == null || this.iFV.getPbData().ckP().aCr() == null || TextUtils.equals(this.iFV.getPbData().ckP().aCr().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean pS(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.w wVar;
        if (this.iFV == null || this.iFV.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.iFV.getPbData();
        bj ckP = pbData.ckP();
        if (ckP != null) {
            if (ckP.aBg() || ckP.aBh()) {
                return false;
            }
            if (ckP.aEk() || ckP.aEl()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.clb() != 0) {
                return pbData.clb() != 3;
            }
            List<bf> cli = pbData.cli();
            if (com.baidu.tbadk.core.util.v.getCount(cli) > 0) {
                for (bf bfVar : cli) {
                    if (bfVar != null && (wVar = bfVar.cRd) != null && wVar.cOX && !wVar.cOY && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pT(boolean z) {
        if (z || this.iFV == null || this.iFV.getPbData() == null) {
            return false;
        }
        return ((this.iFV.getPbData().getForum() != null && this.iFV.getPbData().getForum().isBlockBawuDelete) || this.iFV.getPbData().clb() == 0 || this.iFV.getPbData().clb() == 3) ? false : true;
    }

    public void cnb() {
        com.baidu.tieba.pb.data.e pbData;
        bj ckP;
        if (this.iFV != null && this.iFV.getPbData() != null && (ckP = (pbData = this.iFV.getPbData()).ckP()) != null && ckP.aCr() != null) {
            this.iJq.cpC();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ckP.aCr().getUserId());
            z zVar = new z();
            int clb = this.iFV.getPbData().clb();
            if (clb == 1 || clb == 3) {
                zVar.iNO = true;
                zVar.iNN = true;
                zVar.iNT = ckP.aCm() == 1;
                zVar.iNS = ckP.aCn() == 1;
            } else {
                zVar.iNO = false;
                zVar.iNN = false;
            }
            if (clb == 1002 && !equals) {
                zVar.iNU = true;
            }
            zVar.iNL = pS(equals);
            zVar.iNP = cnc();
            zVar.iNM = pT(equals);
            zVar.hV = this.iFV.cnV();
            zVar.iNI = true;
            zVar.iNH = pR(equals);
            zVar.iNG = equals && this.iJq.cqj();
            zVar.iNR = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iNQ = true;
            zVar.isHostOnly = this.iFV.getHostMode();
            zVar.iNK = true;
            if (ckP.aCI() == null) {
                zVar.iNJ = true;
            } else {
                zVar.iNJ = false;
            }
            if (pbData.cln()) {
                zVar.iNI = false;
                zVar.iNK = false;
                zVar.iNJ = false;
                zVar.iNN = false;
                zVar.iNO = false;
            }
            this.iJq.iPx.a(zVar);
        }
    }

    private boolean cnc() {
        if (this.iFV != null && this.iFV.cnV()) {
            return this.iFV.getPageData() == null || this.iFV.getPageData().aBo() != 0;
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
    public PbModel.a cnd() {
        return this.iKp;
    }

    public int cne() {
        if (cmP() == null || cmP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmP().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.j) && ((com.baidu.tieba.pb.data.j) mVar).Ag == com.baidu.tieba.pb.data.j.iEr) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cnf() {
        if (cmP() == null || cmP().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = cmP().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.kii) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        cnl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cng() {
        if (this.iFV != null && this.iFV.iGO != null && this.iFV.iGO.ckP() != null) {
            bj ckP = this.iFV.iGO.ckP();
            ckP.mRecomAbTag = this.iFV.coO();
            ckP.mRecomWeight = this.iFV.coM();
            ckP.mRecomSource = this.iFV.coN();
            ckP.mRecomExtra = this.iFV.coP();
            if (ckP.getFid() == 0) {
                ckP.setFid(com.baidu.adp.lib.f.b.toLong(this.iFV.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), ckP, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.sQ(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sR(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fH(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cx("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").cx("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.dap.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.iFV.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).aEG();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.iJq.cqd();
        this.iFV.qd(z);
        if (this.iJo != null) {
            this.iJo.fn(z);
            if (markData != null) {
                this.iJo.a(markData);
            }
        }
        if (this.iFV.ayO()) {
            cnj();
        } else {
            this.iJq.o(this.iFV.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yM(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(String str) {
        if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().cln()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iFV.cnU(), str);
            bj ckP = this.iFV.getPbData().ckP();
            if (ckP.aBg()) {
                format = format + "&channelid=33833";
            } else if (ckP.aEj()) {
                format = format + "&channelid=33842";
            } else if (ckP.aBh()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iJn.Gp(str);
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
                if (!this.iFV.coa()) {
                    antiData.setBlock_forum_name(this.iFV.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.iFV.getPbData().getForum().getId());
                    antiData.setUser_name(this.iFV.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.iFV.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (cmP() != null) {
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
            this.iJq.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.kkW) ? bVar.kkW : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.sR(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.fH(true);
                aVar.b(getPageContext());
                aVar.aEG();
            } else {
                this.iJq.a(0, bVar.mSuccess, bVar.kkW, z);
            }
            if (bVar.mSuccess) {
                if (bVar.fYS == 1) {
                    ArrayList<PostData> ckR = this.iFV.getPbData().ckR();
                    int size = ckR.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(ckR.get(i).getId())) {
                            i++;
                        } else {
                            ckR.remove(i);
                            break;
                        }
                    }
                    this.iFV.getPbData().ckP().jJ(this.iFV.getPbData().ckP().aCi() - 1);
                    this.iJq.o(this.iFV.getPbData());
                } else if (bVar.fYS == 0) {
                    cnh();
                } else if (bVar.fYS == 2) {
                    ArrayList<PostData> ckR2 = this.iFV.getPbData().ckR();
                    int size2 = ckR2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ckR2.get(i2).cLs().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(ckR2.get(i2).cLs().get(i3).getId())) {
                                i3++;
                            } else {
                                ckR2.get(i2).cLs().remove(i3);
                                ckR2.get(i2).cLu();
                                z2 = true;
                                break;
                            }
                        }
                        ckR2.get(i2).Jb(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.iJq.o(this.iFV.getPbData());
                    }
                    a(bVar, this.iJq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.iJq.a(this.fLt.getLoadDataMode(), gVar.mSuccess, gVar.kkW, false);
            if (gVar.mSuccess) {
                this.iJr = true;
                if (i == 2 || i == 3) {
                    this.iJs = true;
                    this.iJt = false;
                } else if (i == 4 || i == 5) {
                    this.iJs = false;
                    this.iJt = true;
                }
                if (i == 2) {
                    this.iFV.getPbData().ckP().jM(1);
                    this.iFV.setIsGood(1);
                } else if (i == 3) {
                    this.iFV.getPbData().ckP().jM(0);
                    this.iFV.setIsGood(0);
                } else if (i == 4) {
                    this.iFV.getPbData().ckP().jL(1);
                    this.iFV.yY(1);
                } else if (i == 5) {
                    this.iFV.getPbData().ckP().jL(0);
                    this.iFV.yY(0);
                }
                this.iJq.c(this.iFV.getPbData(), this.iFV.cnV());
            }
        }
    }

    private void cnh() {
        if (this.iFV.cnW() || this.iFV.cnY()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.iFV.cnU());
            PbActivity pbActivity = this.iIO;
            PbActivity pbActivity2 = this.iIO;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.iFV.cnU()));
        if (cnk()) {
            this.iIO.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmk() {
        this.iIO.cmk();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData ckY;
        boolean z = false;
        if (this.iJq != null) {
            this.iJq.cqu();
        }
        if (this.iFV != null && this.iFV.getPbData() != null && !this.iFV.getPbData().cln()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.iFV.getPbData().ckP().getId();
            if (this.iFV.isShareThread() && this.iFV.getPbData().ckP().cUe != null) {
                historyMessage.threadName = this.iFV.getPbData().ckP().cUe.showText;
            } else {
                historyMessage.threadName = this.iFV.getPbData().ckP().getTitle();
            }
            if (this.iFV.isShareThread() && !clN()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.iFV.getPbData().getForum().getName();
            }
            ArrayList<PostData> ckR = this.iFV.getPbData().ckR();
            int cqf = this.iJq != null ? this.iJq.cqf() : 0;
            if (ckR != null && cqf >= 0 && cqf < ckR.size()) {
                historyMessage.postID = ckR.get(cqf).getId();
            }
            historyMessage.isHostOnly = this.iFV.getHostMode();
            historyMessage.isSquence = this.iFV.cnV();
            historyMessage.isShareThread = this.iFV.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.iJD != null) {
            this.iJD.onDestroy();
        }
        if (this.iIS && cmP() != null) {
            cmP().cqO();
        }
        if (this.iFV != null && (this.iFV.cnW() || this.iFV.cnY())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.iFV.cnU());
            if (this.iJr) {
                if (this.iJt) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.iFV.bxW());
                }
                if (this.iJs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.iFV.getIsGood());
                }
            }
            if (this.iFV.getPbData() != null && System.currentTimeMillis() - this.iIV >= 40000 && (ckY = this.iFV.getPbData().ckY()) != null && !com.baidu.tbadk.core.util.v.isEmpty(ckY.getDataList())) {
                intent.putExtra("guess_like_data", ckY);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.iJR);
            }
            PbActivity pbActivity = this.iIO;
            PbActivity pbActivity2 = this.iIO;
            pbActivity.setResult(-1, intent);
        }
        if (cnk()) {
            if (this.iFV != null && this.iJq != null && this.iJq.getListView() != null) {
                com.baidu.tieba.pb.data.e pbData = this.iFV.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.ckV() && !this.iJb && pbData.iDr == null) {
                        ah cpm = ah.cpm();
                        com.baidu.tieba.pb.data.e cod = this.iFV.cod();
                        Parcelable onSaveInstanceState = this.iJq.getListView().onSaveInstanceState();
                        boolean cnV = this.iFV.cnV();
                        boolean hostMode = this.iFV.getHostMode();
                        if (this.iJq.cpO() != null && this.iJq.cpO().getVisibility() == 0) {
                            z = true;
                        }
                        cpm.a(cod, onSaveInstanceState, cnV, hostMode, z);
                        if (this.iJQ >= 0 || this.iFV.coF() != null) {
                            ah.cpm().n(this.iFV.coF());
                            ah.cpm().m(this.iFV.coG());
                            ah.cpm().zi(this.iFV.coH());
                        }
                    }
                }
            } else {
                ah.cpm().reset();
            }
            cmk();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.iJq == null || !this.iJq.zo(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yW(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.iIO;
        if (i == 0) {
            this.iJq.cpC();
            this.iJq.cpE().cmF();
            this.iJq.qx(false);
        }
        this.iJq.cpG();
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
                        this.iJD.resetData();
                        this.iJD.setVoiceModel(pbEditorData.getVoiceModel());
                        this.iJD.b(writeData);
                        com.baidu.tbadk.editortools.l mr = this.iJD.aOy().mr(6);
                        if (mr != null && mr.dxa != null) {
                            mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.iIO;
                        if (i == -1) {
                            this.iJD.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.iJq.cpE() != null && this.iJq.cpE().cmJ() != null) {
                            com.baidu.tbadk.editortools.pb.h cmJ = this.iJq.cpE().cmJ();
                            cmJ.setThreadData(this.iFV.getPbData().ckP());
                            cmJ.b(writeData);
                            cmJ.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mr2 = cmJ.aOy().mr(6);
                            if (mr2 != null && mr2.dxa != null) {
                                mr2.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.iIO;
                            if (i == -1) {
                                cmJ.aPt();
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
        this.iJD.onActivityResult(i, i2, intent);
        if (this.iJf != null) {
            this.iJf.onActivityResult(i, i2, intent);
        }
        if (cmP().cpE() != null) {
            cmP().cpE().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cni();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    ah.cpm().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.54
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.iFV != null) {
                                PbFragment.this.iFV.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCv().B(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.iFV != null) {
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
                        com.baidu.tieba.o.a.cCv().B(getPageContext());
                        cna();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.gFE != null && shareItem != null && shareItem.linkUrl != null) {
                            this.gFE.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aLP() {
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
                    this.iJq.pH(false);
                    if (this.iFV.getPbData() != null && this.iFV.getPbData().ckP() != null && this.iFV.getPbData().ckP().aCL() != null) {
                        this.iFV.getPbData().ckP().aCL().setStatus(2);
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
                        this.iJG = emotionImageData;
                        if (yV(com.baidu.tbadk.core.util.aj.dam)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.iJg != null) {
                        this.iJq.cB(this.iJg);
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
            if (this.iJf == null) {
                this.iJf = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.iIO);
                this.iJf.b(this.dyT);
                this.iJf.c(this.dza);
            }
            this.iJf.a(emotionImageData, clX(), clX().getPbData());
        }
    }

    private void aj(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        MarkData zf;
        if (this.iJo != null) {
            if (this.iFV.getPbData() != null && this.iFV.getPbData().cln()) {
                zf = this.iFV.zf(0);
            } else {
                zf = this.iFV.zf(this.iJq.cqg());
            }
            if (zf != null) {
                if (!zf.isApp() || (zf = this.iFV.zf(this.iJq.cqg() + 1)) != null) {
                    this.iJq.cqb();
                    this.iJo.a(zf);
                    if (!this.iJo.ayO()) {
                        this.iJo.ayQ();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.iJo.ayP();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        com.baidu.tieba.pb.data.e pbData = this.iFV.getPbData();
        this.iFV.qd(true);
        if (this.iJo != null) {
            pbData.FI(this.iJo.ayN());
        }
        this.iJq.o(pbData);
    }

    private boolean cnk() {
        if (this.iFV == null) {
            return true;
        }
        if (this.iFV.getPbData() == null || !this.iFV.getPbData().cln()) {
            if (this.iFV.ayO()) {
                final MarkData con = this.iFV.con();
                if (con == null || !this.iFV.getIsFromMark()) {
                    return true;
                }
                final MarkData zf = this.iFV.zf(this.iJq.cqf());
                if (zf == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", con);
                    this.iIO.setResult(-1, intent);
                    return true;
                } else if (zf.getPostId() == null || zf.getPostId().equals(con.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", con);
                    this.iIO.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.sR(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.iJo != null) {
                                if (PbFragment.this.iJo.ayO()) {
                                    PbFragment.this.iJo.ayP();
                                    PbFragment.this.iJo.fn(false);
                                }
                                PbFragment.this.iJo.a(zf);
                                PbFragment.this.iJo.fn(true);
                                PbFragment.this.iJo.ayQ();
                            }
                            con.setPostId(zf.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", con);
                            PbFragment.this.iIO.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cmk();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", con);
                            PbFragment.this.iIO.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.cmk();
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.iJq != null && PbFragment.this.iJq.getView() != null) {
                                PbFragment.this.iJq.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", con);
                                PbFragment.this.iIO.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.cmk();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.aEG();
                    return false;
                }
            } else if (this.iFV.getPbData() == null || this.iFV.getPbData().ckR() == null || this.iFV.getPbData().ckR().size() <= 0 || !this.iFV.getIsFromMark()) {
                return true;
            } else {
                this.iIO.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.h
    public BdListView getListView() {
        if (this.iJq == null) {
            return null;
        }
        return this.iJq.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int aUE() {
        if (this.iJq == null) {
            return 0;
        }
        return this.iJq.cqs();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> aUF() {
        if (this.dMQ == null) {
            this.dMQ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aUR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
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
                        if (com.baidu.tbadk.core.i.azR().isShowImages()) {
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
        return this.dMQ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> aUG() {
        if (this.dPF == null) {
            this.dPF = TbRichTextView.z(getPageContext().getPageActivity(), 8);
        }
        return this.dPF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> aUH() {
        if (this.dMR == null) {
            this.dMR = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bHp */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
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
                    if (com.baidu.tbadk.core.i.azR().isShowImages()) {
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
                    gifView.aPT();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.dMR;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> aUI() {
        if (this.dPG == null) {
            this.dPG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnH */
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
                    ((PlayVoiceBntNew) view).cMC();
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
        return this.dPG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> aUK() {
        this.dPI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cnI */
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
        return this.dPI;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIn() {
        if (this.djC == null) {
            this.djC = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aC(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.Gh(str) && this.iFV != null && this.iFV.cnU() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").X("obj_param1", 1).cx("post_id", this.iFV.cnU()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.dwd = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            as.cqX().c(getPageContext(), str);
        }
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aD(Context context, String str) {
        as.cqX().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.iIZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.iJq != null && this.iJq.cqJ() != null && rect.top <= this.iJq.cqJ().getHeight()) {
            rect.top += this.iJq.cqJ().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.e pbData = this.iFV.getPbData();
            TbRichText bj = bj(str, i);
            if (bj != null && (tbRichTextData = bj.aTX().get(this.iKu)) != null) {
                aVar.postId = String.valueOf(bj.getPostId());
                aVar.iGa = new ArrayList<>();
                aVar.iGb = new ConcurrentHashMap<>();
                if (!tbRichTextData.aUd().aUo()) {
                    aVar.iGd = false;
                    String b2 = com.baidu.tieba.pb.data.f.b(tbRichTextData);
                    aVar.iGa.add(b2);
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
                    imageUrlData.mIsReserver = this.iFV.col();
                    imageUrlData.mIsSeeHost = this.iFV.getHostMode();
                    aVar.iGb.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.ckP() != null) {
                            aVar.threadId = pbData.ckP().getId();
                        }
                        aVar.iGc = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.iGd = true;
                int size = pbData.ckR().size();
                this.iKv = false;
                aVar.index = -1;
                int a2 = pbData.ckW() != null ? a(pbData.ckW().cLx(), bj, i, i, aVar.iGa, aVar.iGb) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.ckR().get(i2);
                    if (postData.getId() == null || pbData.ckW() == null || pbData.ckW().getId() == null || !postData.getId().equals(pbData.ckW().getId())) {
                        a2 = a(postData.cLx(), bj, a2, i, aVar.iGa, aVar.iGb);
                    }
                }
                if (aVar.iGa.size() > 0) {
                    aVar.lastId = aVar.iGa.get(aVar.iGa.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.ckP() != null) {
                        aVar.threadId = pbData.ckP().getId();
                    }
                    aVar.iGc = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aUd() == null) {
            return null;
        }
        return tbRichTextData.aUd().aUt();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aUd() == null) {
            return 0L;
        }
        return tbRichTextData.aUd().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aUd() == null) {
            return false;
        }
        return tbRichTextData.aUd().aUu();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.aUd() == null) {
            return false;
        }
        return tbRichTextData.aUd().aUv();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo aUd;
        String str;
        if (tbRichText == tbRichText2) {
            this.iKv = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.aTX().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.aTX().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.aUd().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.aUd().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.aUd().aUo()) {
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
                            if (tbRichTextData != null && (aUd = tbRichTextData.aUd()) != null) {
                                String aUq = aUd.aUq();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = aUd.aUr();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = aUq;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.iFV.cnU(), -1L);
                                imageUrlData.mIsReserver = this.iFV.col();
                                imageUrlData.mIsSeeHost = this.iFV.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.iKv) {
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
        PostData ckW;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iFV.aCA())) {
                z = true;
            }
            MarkData l = this.iFV.l(postData);
            if (this.iFV.getPbData() != null && this.iFV.getPbData().cln() && (ckW = ckW()) != null) {
                l = this.iFV.l(ckW);
            }
            if (l != null) {
                this.iJq.cqb();
                if (this.iJo != null) {
                    this.iJo.a(l);
                    if (!z) {
                        this.iJo.ayQ();
                    } else {
                        this.iJo.ayP();
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
        if (this.iFV == null || this.iFV.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.e pbData = this.iFV.getPbData();
        if (pbData.ckW() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.ckW());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> ckR = pbData.ckR();
            c(pbData, ckR);
            return c(ckR, str, i);
        }
        return tbRichText;
    }

    private void c(com.baidu.tieba.pb.data.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar != null && eVar.cla() != null && eVar.cla().iEF != null && (list = eVar.cla().iEF) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> aTX;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cLx = arrayList.get(i2).cLx();
            if (cLx != null && (aTX = cLx.aTX()) != null) {
                int size = aTX.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (aTX.get(i4) != null && aTX.get(i4).getType() == 8) {
                        i3++;
                        if (aTX.get(i4).aUd().aUq().equals(str) || aTX.get(i4).aUd().aUr().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = aTX.get(i4).aUd().getWidth() * equipmentDensity;
                            int height = aTX.get(i4).aUd().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.iKu = i4;
                            return cLx;
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
            this.iFR = str;
            if (this.iIU == null) {
                cmT();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.iIU.getItemView(1).setVisibility(8);
            } else {
                this.iIU.getItemView(1).setVisibility(0);
            }
            this.iIU.aEH();
            this.iIZ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.gpi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnl() {
        hideNetRefreshView(this.iJq.getView());
        cnm();
        if (this.iFV.cog()) {
            this.iJq.cqb();
        }
        this.iJq.cqm();
    }

    private void cnm() {
        showLoadingView(this.iJq.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.iJq.cqJ().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        if (this.gpi != null) {
            this.gpi.stopPlay();
        }
        if (this.iIO != null) {
            this.iIO.bEu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, cmY(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> aUJ() {
        if (this.dPH == null) {
            this.dPH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnJ */
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
        return this.dPH;
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

    public void bEv() {
        if (this.iIO != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.iIO.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.iIO.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData bDg() {
        if (this.iFV == null || this.iFV.getPbData() == null) {
            return null;
        }
        return this.iFV.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(an.iQI)).intValue();
            if (intValue == an.iQJ) {
                if (!this.fLt.cMj()) {
                    this.iJq.cpY();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.fLt.Jg(com.baidu.tbadk.core.util.aq.O(jSONArray));
                    }
                    this.fLt.a(this.iFV.getPbData().getForum().getId(), this.iFV.getPbData().getForum().getName(), this.iFV.getPbData().ckP().getId(), str, intValue3, intValue2, booleanValue, this.iFV.getPbData().ckP().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == an.iQK || intValue == an.iQM) {
                if (this.iFV.cow() != null) {
                    this.iFV.cow().yQ(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == an.iQK) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iJL);
        userMuteAddAndDelCustomMessage.setTag(this.iJL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean FR(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0585a
    public void pU(boolean z) {
        this.iJx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cnn() {
        ArrayList<PostData> ckR;
        int count;
        if (this.iFV == null || this.iFV.getPbData() == null || this.iFV.getPbData().ckR() == null || (count = com.baidu.tbadk.core.util.v.getCount((ckR = this.iFV.getPbData().ckR()))) == 0) {
            return "";
        }
        if (this.iFV.col()) {
            Iterator<PostData> it = ckR.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cLv() == 1) {
                    return next.getId();
                }
            }
        }
        int cqf = this.iJq.cqf();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(ckR, cqf);
        if (postData == null || postData.aCr() == null) {
            return "";
        }
        if (this.iFV.FV(postData.aCr().getUserId())) {
            return postData.getId();
        }
        for (int i = cqf - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckR, i);
            if (postData2 == null || postData2.aCr() == null || postData2.aCr().getUserId() == null) {
                break;
            } else if (this.iFV.FV(postData2.aCr().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = cqf + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(ckR, i2);
            if (postData3 == null || postData3.aCr() == null || postData3.aCr().getUserId() == null) {
                return "";
            }
            if (this.iFV.FV(postData3.aCr().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
        this.iIZ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a FS(String str) {
        String str2;
        if (this.iFV.getPbData() == null || this.iFV.getPbData().ckR() == null || this.iFV.getPbData().ckR().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.iFV.getPbData().ckR().size()) {
                i = 0;
                break;
            } else if (str.equals(this.iFV.getPbData().ckR().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.iFV.getPbData().ckR().get(i);
        if (postData.cLx() == null || postData.cLx().aTX() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cLx().aTX().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.aUd() != null) {
                    str2 = next.aUd().aUq();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.f.a(postData, aVar);
        return aVar;
    }

    public boolean cno() {
        return (!this.iIP && this.iKA == -1 && this.iKB == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            this.iKD = pVar;
            this.iIP = true;
            this.iJq.cpP();
            this.iJq.Gf(this.iKC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnp() {
        if (this.iKD != null) {
            if (this.iKA == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iKD.getCartoonId(), this.iKA, 0)));
                this.iIO.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnq() {
        if (this.iKD != null) {
            if (this.iKB == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.iKD.getCartoonId(), this.iKB, 0)));
                this.iIO.finish();
            }
        }
    }

    public int cnr() {
        return this.iKA;
    }

    public int cns() {
        return this.iKB;
    }

    private void bQp() {
        if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().ckP() != null && this.iFV.getPbData().ckP().aBe()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void cnt() {
        if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().ckP() != null && this.iFV.getPbData().ckP().aBe()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void cnu() {
        if (this.isPaused) {
            this.iJe = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.iFV.getPbData() != null && this.iFV.getPbData().ckP() != null && this.iFV.getPbData().ckP().aBX() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.iFV.getPbData().ckP().aBX().getThreadId(), this.iFV.getPbData().ckP().aBX().getTaskId(), this.iFV.getPbData().ckP().aBX().getForumId(), this.iFV.getPbData().ckP().aBX().getForumName(), this.iFV.getPbData().ckP().aCm(), this.iFV.getPbData().ckP().aCn())));
            this.iIR = true;
            this.iIO.finish();
        }
    }

    public String cnv() {
        return this.iJc;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a cnw() {
        return this.iJm;
    }

    public void pV(boolean z) {
        this.iJd = z;
    }

    public boolean aEg() {
        if (this.iFV != null) {
            return this.iFV.cnW();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.sR(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.iJJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.iJJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.iJJ).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iJJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJJ.getPageActivity());
            aVar.sR(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iJJ).aEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.iJq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJJ.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.sR(this.iJJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sR(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.iJq.showLoadingDialog();
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
        aVar.b(this.iJJ).aEG();
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
        if (configuration.orientation != this.gPx) {
            this.gPx = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.iJq != null) {
                this.iJq.onConfigurationChanged(configuration);
            }
            if (this.iJv != null) {
                this.iJv.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean cny() {
        if (this.iFV != null) {
            return this.iFV.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, an anVar) {
        boolean z;
        List<PostData> list = this.iFV.getPbData().cla().iEF;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cLs().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cLs().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cLs().remove(i2);
                    list.get(i).cLu();
                    z = true;
                    break;
                }
            }
            list.get(i).Jb(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            anVar.o(this.iFV.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.l lVar) {
        String id = lVar.clB().getId();
        List<PostData> list = this.iFV.getPbData().cla().iEF;
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
                ArrayList<PostData> clF = lVar.clF();
                postData.CD(lVar.getTotalCount());
                if (postData.cLs() != null) {
                    postData.cLs().clear();
                    postData.cLs().addAll(clF);
                }
            }
        }
        if (!this.iFV.getIsFromMark()) {
            this.iJq.o(this.iFV.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a clM() {
        return this.iIO.clM();
    }

    public boolean clN() {
        if (this.iFV == null) {
            return false;
        }
        return this.iFV.clN();
    }

    public void cnz() {
        if (this.iJq != null) {
            this.iJq.cpC();
            bEv();
        }
    }

    public PostData ckW() {
        return this.iJq.b(this.iFV.iGO, this.iFV.cnV());
    }

    public void onBackPressed() {
        if (this.iJS != null && !this.iJS.isEmpty()) {
            int size = this.iJS.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.iJS.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.iJS == null) {
                this.iJS = new ArrayList();
            }
            if (!this.iJS.contains(aVar)) {
                this.iJS.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.iJS == null) {
                this.iJS = new ArrayList();
            }
            if (!this.iJS.contains(aVar)) {
                this.iJS.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.iJS != null) {
            this.iJS.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        if (this.iFV != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.iFV.cnU())) {
            com.baidu.tbadk.BdToken.c.axC().o(com.baidu.tbadk.BdToken.b.cGX, com.baidu.adp.lib.f.b.toLong(this.iFV.cnU(), 0L));
        }
    }

    public ax cnB() {
        return this.iJl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.iFV != null && this.iFV.getPbData() != null && this.iFV.getPbData().ckP() != null && this.iFV.getPbData().ckP().aEm()) {
            bj ckP = this.iFV.getPbData().ckP();
            int i = 0;
            if (ckP.aBg()) {
                i = 1;
            } else if (ckP.aBh()) {
                i = 2;
            } else if (ckP.aEk()) {
                i = 3;
            } else if (ckP.aEl()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str);
            anVar.X("obj_source", 4);
            anVar.X("obj_type", i);
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cnC() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cnD() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cnE() {
        return this.iIO;
    }
}
