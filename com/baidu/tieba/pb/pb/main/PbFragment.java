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
public class PbFragment extends BaseFragment implements View.OnTouchListener, TbPageContextSupport, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.pb.videopb.b, a.InterfaceC0822a {
    private com.baidu.tieba.tbadkCore.data.e eQR;
    private com.baidu.tbadk.core.message.a eRh;
    private com.baidu.adp.lib.d.b<TbImageView> eXS;
    private LikeModel eZA;
    private bd ewz;
    private com.baidu.adp.lib.d.b<ImageView> fFL;
    private com.baidu.adp.lib.d.b<GifView> fFM;
    private com.baidu.adp.lib.d.b<TextView> fJc;
    private com.baidu.adp.lib.d.b<View> fJd;
    private com.baidu.adp.lib.d.b<LinearLayout> fJe;
    private com.baidu.adp.lib.d.b<RelativeLayout> fJf;
    private com.baidu.tieba.callfans.a hYS;
    private VoiceManager iHo;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private com.baidu.tieba.f.b iMk;
    public com.baidu.tbadk.core.util.am kvy;
    public bb kzD;
    private String lpO;
    private com.baidu.tieba.pb.pb.main.emotion.model.a ltE;
    private View ltF;
    int ltH;
    private bf ltK;
    private com.baidu.tieba.pb.pb.report.a ltO;
    private com.baidu.tbadk.core.dialog.i ltV;
    private com.baidu.tbadk.core.dialog.k ltW;
    private boolean ltX;
    private PbActivity ltl;
    private com.baidu.tieba.pb.pb.main.b.b ltn;
    private boolean luX;
    private com.baidu.tieba.tbadkCore.data.f lub;
    private com.baidu.tbadk.editortools.pb.g luc;
    private com.baidu.tbadk.editortools.pb.e lud;
    private com.baidu.tieba.frs.profession.permission.c luf;
    private EmotionImageData lug;
    private com.baidu.adp.base.e luj;
    private com.baidu.tbadk.core.view.c luk;
    private BdUniqueId lul;
    private Runnable lum;
    private com.baidu.adp.widget.ImageView.a lun;
    private String luo;
    private TbRichTextMemeInfo lup;
    private List<a> lus;
    public String luu;
    private String lvg;
    private com.baidu.tbadk.core.data.r lvh;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a lvd = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.77
        @Override // com.baidu.tieba.f.b.a
        public void cG(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.djo();
            } else {
                com.baidu.tieba.pb.a.b.djn();
            }
        }
    };
    private boolean ltm = false;
    private boolean lto = false;
    private boolean bFd = false;
    private boolean kPp = false;
    private boolean ltp = true;
    private int ltq = 0;
    private com.baidu.tbadk.core.dialog.b lts = null;
    private long ijR = -1;
    private long fvq = 0;
    private long ltt = 0;
    private long createTime = 0;
    private long fvg = 0;
    private boolean ltu = false;
    private com.baidu.tbadk.n.b ltv = null;
    private long ltw = 0;
    private boolean ltx = false;
    private long lty = 0;
    private int jlj = 1;
    private String fpM = null;
    private boolean ltz = false;
    private boolean isFullScreen = false;
    private boolean ltA = false;
    private String ltB = "";
    private boolean ltC = true;
    private boolean ltD = false;
    private String source = "";
    private int mSkinType = 3;
    int[] ltG = new int[2];
    private int ltI = -1;
    private int ltJ = -1;
    public BdUniqueId ltL = BdUniqueId.gen();
    private boolean ltM = false;
    private boolean lrn = com.baidu.tbadk.a.d.bhV();
    private PbInterviewStatusView.a ltN = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbFragment.this.ltR.uL(!PbFragment.this.ltC);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.12
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.biv()) {
                        PbFragment.this.dkI();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel lpS = null;
    private com.baidu.tbadk.baseEditMark.a ltP = null;
    private ForumManageModel hYQ = null;
    private com.baidu.tbadk.coreExtra.model.a eNr = null;
    private com.baidu.tieba.pb.data.q ltQ = null;
    private ShareSuccessReplyToServerModel jaw = null;
    private az ltR = null;
    private boolean ltS = false;
    private boolean ltT = false;
    private boolean ltU = false;
    private boolean fWQ = false;
    private boolean ltY = false;
    private boolean ltZ = false;
    private boolean lua = false;
    private boolean lue = false;
    public boolean luh = false;
    private com.baidu.tbadk.editortools.pb.c fpP = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bAc() {
            PbFragment.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b fpQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.45
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (PbFragment.this.kzD == null || PbFragment.this.kzD.doC() == null || !PbFragment.this.kzD.doC().dSV()) {
                return !PbFragment.this.FP(com.baidu.tbadk.core.util.am.eNm);
            }
            PbFragment.this.showToast(PbFragment.this.kzD.doC().dSX());
            if (PbFragment.this.lud != null && (PbFragment.this.lud.bAs() || PbFragment.this.lud.bAt())) {
                PbFragment.this.lud.a(false, PbFragment.this.kzD.doF());
            }
            PbFragment.this.kzD.uY(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b lui = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.56
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (PbFragment.this.kzD == null || PbFragment.this.kzD.doD() == null || !PbFragment.this.kzD.doD().dSV()) {
                return !PbFragment.this.FP(com.baidu.tbadk.core.util.am.eNn);
            }
            PbFragment.this.showToast(PbFragment.this.kzD.doD().dSX());
            if (PbFragment.this.ltR != null && PbFragment.this.ltR.dnk() != null && PbFragment.this.ltR.dnk().dkj() != null && PbFragment.this.ltR.dnk().dkj().bAt()) {
                PbFragment.this.ltR.dnk().dkj().a(PbFragment.this.kzD.doF());
            }
            PbFragment.this.kzD.uZ(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean iId = false;
    private int luq = 0;
    private int lur = -1;
    public int lut = 0;
    private final a luv = new a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.67
        @Override // com.baidu.tieba.pb.pb.main.PbFragment.a
        public boolean onBackPressed() {
            if (PbFragment.this.ltR != null && PbFragment.this.ltR.dnk() != null) {
                v dnk = PbFragment.this.ltR.dnk();
                if (dnk.dkh()) {
                    dnk.dkg();
                    return true;
                }
            }
            if (PbFragment.this.ltR != null && PbFragment.this.ltR.doj()) {
                PbFragment.this.ltR.dok();
                return true;
            }
            return false;
        }
    };
    private final ai.a luw = new ai.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.78
        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void af(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.ai.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbFragment.this.ltR.showToast(str);
            }
        }
    };
    private final CustomMessageListener lux = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.87
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.lpS != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbFragment.this.lud != null) {
                    PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                }
                PbFragment.this.ltR.dnm();
                PbFragment.this.ltR.dob();
            }
        }
    };
    CustomMessageListener iIU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m)) {
                PbFragment.this.lpS.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                if (PbFragment.this.ltR != null && PbFragment.this.lpS != null) {
                    PbFragment.this.ltR.b(PbFragment.this.lpS.getPbData(), PbFragment.this.lpS.dlz(), PbFragment.this.lpS.dlW(), PbFragment.this.ltR.getSkinType());
                }
                if (PbFragment.this.ltR != null && PbFragment.this.ltR.dnE() != null) {
                    PbFragment.this.ltR.dnE().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener luy = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbFragment.this.ltR != null) {
                    if (booleanValue) {
                        PbFragment.this.ltR.cTu();
                    } else {
                        PbFragment.this.ltR.cTt();
                    }
                }
            }
        }
    };
    private CustomMessageListener luz = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbFragment.this.lud != null) {
                    PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                }
                PbFragment.this.ltR.uS(false);
            }
        }
    };
    private CustomMessageListener luA = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.5
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
    private CustomMessageListener luB = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.ltR != null && PbFragment.this.ltR.dnE() != null) {
                PbFragment.this.ltR.dnE().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener jWO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(PbFragment.this.getPageContext(), PbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener iIQ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbFragment.this.bFd) {
                PbFragment.this.dla();
            }
        }
    };
    private View.OnClickListener fqy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbFragment.this.showToast(PbFragment.this.fpM);
        }
    };
    private CustomMessageListener luC = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ag)) {
                com.baidu.tbadk.core.data.ag agVar = (com.baidu.tbadk.core.data.ag) customResponsedMessage.getData();
                ax.a aVar = new ax.a();
                aVar.giftId = agVar.id;
                aVar.giftName = agVar.name;
                aVar.thumbnailUrl = agVar.thumbnailUrl;
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lpS.getPbData();
                if (pbData != null) {
                    if (PbFragment.this.lpS.dlN() != null && PbFragment.this.lpS.dlN().getUserIdLong() == agVar.toUserId) {
                        PbFragment.this.ltR.a(agVar.sendCount, PbFragment.this.lpS.getPbData(), PbFragment.this.lpS.dlz(), PbFragment.this.lpS.dlW());
                    }
                    if (pbData.dim() != null && pbData.dim().size() >= 1 && pbData.dim().get(0) != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(pbData.dim().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(PbFragment.this.lpS.dlx(), 0L);
                        if (j == agVar.postId && j2 == agVar.threadId) {
                            com.baidu.tbadk.core.data.ax dKh = pbData.dim().get(0).dKh();
                            if (dKh == null) {
                                dKh = new com.baidu.tbadk.core.data.ax();
                            }
                            ArrayList<ax.a> bls = dKh.bls();
                            if (bls == null) {
                                bls = new ArrayList<>();
                            }
                            bls.add(0, aVar);
                            dKh.setTotal(agVar.sendCount + dKh.getTotal());
                            dKh.D(bls);
                            pbData.dim().get(0).a(dKh);
                            PbFragment.this.ltR.dnE().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener luD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                PbFragment.this.lpS.getPbData().diE();
                PbFragment.this.lpS.dlS();
                if (PbFragment.this.ltR.dnE() != null) {
                    PbFragment.this.ltR.s(PbFragment.this.lpS.getPbData());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.tbadkCore.data.n nVar;
            if (customResponsedMessage != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                String str = (String) customResponsedMessage.getData();
                PbFragment.this.Py(str);
                PbFragment.this.lpS.dlS();
                if (!TextUtils.isEmpty(str) && PbFragment.this.lpS.getPbData().dim() != null) {
                    ArrayList<PostData> dim = PbFragment.this.lpS.getPbData().dim();
                    Iterator<PostData> it = dim.iterator();
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
                        dim.remove(nVar);
                        if (PbFragment.this.ltR.dnE() != null && PbFragment.this.ltR.dnE().getDataList() != null) {
                            PbFragment.this.ltR.dnE().getDataList().remove(nVar);
                        }
                        if (PbFragment.this.ltR.getListView() != null && PbFragment.this.ltR.getListView().getData() != null) {
                            PbFragment.this.ltR.getListView().getData().remove(nVar);
                        }
                        if (PbFragment.this.ltR.dnE() != null) {
                            PbFragment.this.ltR.dnE().notifyDataSetChanged();
                            return;
                        }
                    }
                }
                if (PbFragment.this.ltR.dnE() != null) {
                    PbFragment.this.ltR.s(PbFragment.this.lpS.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a luE = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.14
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.doV()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a luF = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.15
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void af(List<String> list) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list) && PbFragment.this.ltR != null) {
                PbFragment.this.ltR.fe(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private boolean luG = false;
    private PraiseModel luH = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.16
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void FB(String str) {
            PbFragment.this.luG = false;
            if (PbFragment.this.luH != null) {
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lpS.getPbData();
                if (pbData.dik().bml().getIsLike() == 1) {
                    PbFragment.this.zT(0);
                } else {
                    PbFragment.this.zT(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.dik()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbFragment.this.luG = false;
            if (PbFragment.this.luH != null && str != null) {
                if (AntiHelper.bR(i, str)) {
                    AntiHelper.bm(PbFragment.this.getPageContext().getPageActivity(), str);
                } else {
                    PbFragment.this.showToast(str);
                }
            }
        }
    });
    private b.a luI = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.17
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void up(boolean z) {
            PbFragment.this.un(z);
            if (PbFragment.this.ltR.dop() != null && z) {
                PbFragment.this.ltR.uL(false);
            }
            PbFragment.this.ltR.uN(z);
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().feD != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbFragment.this.getUniqueId() && AntiHelper.a(PbFragment.this.getActivity(), updateAttentionMessage.getData().feD, PbFragment.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbFragment.this.dit().bmA() != null && PbFragment.this.dit().bmA().getGodUserData() != null) {
                            PbFragment.this.dit().bmA().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null) {
                            PbFragment.this.lpS.getPbData().dik().bmA().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h iGs = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && PbFragment.this.ltl.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(PbFragment.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private CheckRealNameModel.a luJ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.24
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbFragment.this.ltR.chg();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbFragment.this.FR(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.j.a.cIf();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbFragment.this.getResources().getString(R.string.neterror);
                    }
                    PbFragment.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c fhK = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.26
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            if (PbFragment.this.isAdded()) {
                PbFragment.this.dks();
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
                        if (PbFragment.this.di(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            PbFragment.this.d((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                        if (PbFragment.this.ltR.dkq() && view.getId() == R.id.pb_head_user_info_root) {
                            if (view.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10630").dR("obj_id", (String) view.getTag(R.id.tag_user_id)));
                            }
                            if (PbFragment.this.djp() != null && PbFragment.this.djp().iqL != null) {
                                PbFragment.this.djp().iqL.onClick(view);
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
                if (PbFragment.this.lud != null) {
                    PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                }
                PbFragment.this.ltR.dnm();
                PbFragment.this.ltR.dob();
                return true;
            }
            return true;
        }
    });
    private CustomMessageListener luK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lul) {
                PbFragment.this.ltR.chg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = PbFragment.this.lpS.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.diA().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.luk.showSuccessToast(PbFragment.this.luj.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbFragment.this.luj.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbFragment.this.DT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbFragment.this.dkW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = PbFragment.this.luj.getResources().getString(R.string.mute_fail);
                    }
                    PbFragment.this.luk.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener luL = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lul) {
                PbFragment.this.ltR.chg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbFragment.this.luk.showSuccessToast(PbFragment.this.luj.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = PbFragment.this.luj.getResources().getString(R.string.un_mute_fail);
                }
                PbFragment.this.luk.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener luM = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbFragment.this.lul) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbFragment.this.ltR.chg();
                SparseArray<Object> sparseArray = (SparseArray) PbFragment.this.mExtra;
                DataRes dataRes = aVar.nlA;
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
                    PbFragment.this.ltR.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener luN = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbFragment.this.ltR.dnn() && (customResponsedMessage.getData() instanceof Integer)) {
                PbFragment.this.dks();
            }
        }
    };
    private CustomMessageListener iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbFragment.this.iId = true;
                }
            }
        }
    };
    public a.b lax = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.33
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbFragment.this.cyL();
            com.baidu.tbadk.core.data.av pageData = PbFragment.this.lpS.getPageData();
            int pageNum = PbFragment.this.ltR.getPageNum();
            if (pageNum <= 0) {
                PbFragment.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.bll()) {
                PbFragment.this.ltR.dob();
                PbFragment.this.cyK();
                PbFragment.this.ltR.dnI();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.lpS.FV(PbFragment.this.ltR.getPageNum());
                    if (PbFragment.this.ltn != null) {
                        PbFragment.this.ltn.showFloatingView();
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
    private k.c luO = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.35
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (PbFragment.this.ltV != null) {
                PbFragment.this.ltV.dismiss();
            }
            switch (i) {
                case 1:
                    if (PbFragment.this.lun != null && !TextUtils.isEmpty(PbFragment.this.luo)) {
                        if (PbFragment.this.lup == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.luo));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbFragment.this.luo;
                            aVar.pkgId = PbFragment.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lup.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbFragment.this.lun = null;
                        PbFragment.this.luo = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbFragment.this.lun != null && !TextUtils.isEmpty(PbFragment.this.luo)) {
                        if (PbFragment.this.mPermissionJudgement == null) {
                            PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                        PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                            if (PbFragment.this.ewz == null) {
                                PbFragment.this.ewz = new bd(PbFragment.this.getPageContext());
                            }
                            PbFragment.this.ewz.j(PbFragment.this.luo, PbFragment.this.lun.getImageByte());
                            PbFragment.this.lun = null;
                            PbFragment.this.luo = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbFragment.this.jKP != null) {
                        PbFragment.this.jKP.fT(PbFragment.this.getPageContext().getPageActivity());
                        PbFragment.this.jKP = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").al("obj_locate", 2));
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.dj(view);
                        if (PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null && PbFragment.this.lpS.getPbData().dik().bmA().getUserId() != null && PbFragment.this.ltP != null) {
                            int h = PbFragment.this.h(PbFragment.this.lpS.getPbData());
                            bw dik = PbFragment.this.lpS.getPbData().dik();
                            if (dik.bli()) {
                                i2 = 2;
                            } else if (dik.blj()) {
                                i2 = 3;
                            } else if (dik.bov()) {
                                i2 = 4;
                            } else {
                                i2 = dik.bow() ? 5 : 1;
                            }
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dR("tid", PbFragment.this.lpS.lxd).al("obj_locate", 2).dR("obj_id", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()).al("obj_type", PbFragment.this.ltP.biv() ? 0 : 1).al("obj_source", h).al("obj_param1", i2));
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
                        PbFragment.this.PA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11739").al("obj_locate", 4));
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
                        PbFragment.this.ltR.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbFragment.this.ltR.dp(view);
                            return;
                        } else if (booleanValue2) {
                            PbFragment.this.ltR.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (PbFragment.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bor() != null) {
                            PbFragment.this.d(postData.bor());
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
    public SortSwitchButton.a luP = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.37
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zw(int i) {
            PbFragment.this.ltR.dob();
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (PbFragment.this.lpS == null || PbFragment.this.lpS.isLoading) {
                    return false;
                }
                PbFragment.this.cyK();
                PbFragment.this.ltR.dnI();
                if (PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().lmT != null && PbFragment.this.lpS.getPbData().lmT.size() > i) {
                    int intValue = PbFragment.this.lpS.getPbData().lmT.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13699").dR("tid", PbFragment.this.lpS.dly()).dR("fid", PbFragment.this.lpS.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_type", FT(intValue)));
                    if (PbFragment.this.lpS.Ga(intValue)) {
                        PbFragment.this.mIsLoading = true;
                        PbFragment.this.ltR.uG(true);
                    }
                }
                return true;
            }
            PbFragment.this.showToast(R.string.network_not_available);
            return false;
        }

        private int FT(int i) {
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
    public final View.OnClickListener iKb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40
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
            boolean B;
            String name2;
            if (view != null && PbFragment.this.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbFragment.this.ltR.dnX()) {
                        if (!PbFragment.this.mIsLoading) {
                            if (PbFragment.this.lpS.uv(true)) {
                                PbFragment.this.mIsLoading = true;
                                PbFragment.this.ltR.dnJ();
                            }
                        } else {
                            return;
                        }
                    } else if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmM()) {
                        if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmN()) {
                            if (view == PbFragment.this.ltR.lAX.fxJ) {
                                if (PbFragment.this.ltR.uP(PbFragment.this.lpS.dlE())) {
                                    PbFragment.this.cyK();
                                    return;
                                }
                                PbFragment.this.ltp = false;
                                PbFragment.this.lto = false;
                                com.baidu.adp.lib.util.l.hideSoftKeyPad(PbFragment.this.ltl, PbFragment.this.ltR.lAX.fxJ);
                                PbFragment.this.ltl.finish();
                            } else if (view != PbFragment.this.ltR.dnG() && (PbFragment.this.ltR.lAX.dpi() == null || (view != PbFragment.this.ltR.lAX.dpi().dmL() && view != PbFragment.this.ltR.lAX.dpi().dmJ()))) {
                                if (view == PbFragment.this.ltR.dof()) {
                                    if (PbFragment.this.lpS != null) {
                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpS.getPbData().dik().bmz().getLink());
                                    }
                                } else if (view != PbFragment.this.ltR.lAX.lHn) {
                                    if (view == PbFragment.this.ltR.lAX.lHo) {
                                        if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                            ArrayList<PostData> dim = PbFragment.this.lpS.getPbData().dim();
                                            if ((dim == null || dim.size() <= 0) && PbFragment.this.lpS.dlz()) {
                                                com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12378").dR("tid", PbFragment.this.lpS.dlx()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", PbFragment.this.lpS.getForumId()));
                                            if (!PbFragment.this.ltR.dou()) {
                                                PbFragment.this.ltR.dnm();
                                            }
                                            PbFragment.this.dkA();
                                        } else {
                                            com.baidu.adp.lib.util.l.showToast(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                            PbFragment.this.ltR.uc(true);
                                            PbFragment.this.ltR.dnm();
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.mIsLoading = true;
                                                PbFragment.this.ltR.cTu();
                                                PbFragment.this.cyK();
                                                PbFragment.this.ltR.dnI();
                                                PbFragment.this.lpS.PF(PbFragment.this.dkM());
                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            PbFragment.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmI()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (PbFragment.this.ltR.lAX.dpi() != null && view == PbFragment.this.ltR.lAX.dpi().dmH()) {
                                                PbFragment.this.ltR.lAX.aZC();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (PbFragment.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                    PbFragment.this.FS(3);
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmF()) {
                                                    if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmP()) {
                                                        if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmG()) {
                                                            if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmQ()) {
                                                                if (PbFragment.this.ltR.dop() == view) {
                                                                    if (PbFragment.this.ltR.dop().getIndicateStatus()) {
                                                                        com.baidu.tieba.pb.data.f pbData2 = PbFragment.this.lpS.getPbData();
                                                                        if (pbData2 != null && pbData2.dik() != null && pbData2.dik().bmg() != null) {
                                                                            String blW = pbData2.dik().bmg().blW();
                                                                            if (StringUtils.isNull(blW)) {
                                                                                blW = pbData2.dik().bmg().getTaskId();
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11107").dR("obj_id", blW));
                                                                        }
                                                                    } else {
                                                                        com.baidu.tieba.tbadkCore.d.a.gq("c10725", null);
                                                                    }
                                                                    PbFragment.this.dkT();
                                                                } else if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmO()) {
                                                                    if (PbFragment.this.ltR.lAX.dpi() != null && view == PbFragment.this.ltR.lAX.dpi().dmK()) {
                                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                            SparseArray<Object> b2 = PbFragment.this.ltR.b(PbFragment.this.lpS.getPbData(), PbFragment.this.lpS.dlz(), 1);
                                                                            if (b2 != null) {
                                                                                if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                                                                    PbFragment.this.ltR.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    PbFragment.this.ltR.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            PbFragment.this.ltR.lAX.aZC();
                                                                        } else {
                                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar.dR("tid", PbFragment.this.lpS.dlx());
                                                                            aqVar.dR("fid", PbFragment.this.lpS.getForumId());
                                                                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar.al("obj_locate", 4);
                                                                            TiebaStatic.log(aqVar);
                                                                        }
                                                                        if (PbFragment.this.checkUpIsLogin()) {
                                                                            if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                PbFragment.this.ltR.dob();
                                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                PostData postData = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                                                                                View view2 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                                if (postData != null && view2 != null) {
                                                                                    if (postData.dKl() == 1) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12630"));
                                                                                    }
                                                                                    if (postData.mXM != null) {
                                                                                        com.baidu.tbadk.core.util.aq brj = postData.mXM.brj();
                                                                                        brj.delete("obj_locate");
                                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                            brj.al("obj_locate", 6);
                                                                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                            brj.al("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(brj);
                                                                                    }
                                                                                    String dlx = PbFragment.this.lpS.dlx();
                                                                                    String id = postData.getId();
                                                                                    String str2 = "";
                                                                                    if (postData2 != null) {
                                                                                        str2 = postData2.getId();
                                                                                    }
                                                                                    int i3 = 0;
                                                                                    if (PbFragment.this.lpS.getPbData() != null) {
                                                                                        i3 = PbFragment.this.lpS.getPbData().diz();
                                                                                    }
                                                                                    PbFragment.this.cyK();
                                                                                    if (view.getId() == R.id.replybtn) {
                                                                                        PbActivity.a PD = PbFragment.this.PD(id);
                                                                                        if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PD != null) {
                                                                                            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dlx, id, "pb", true, null, true, null, i3, postData.dqh(), PbFragment.this.lpS.getPbData().getAnti(), false, postData.bmA().getIconInfo()).addBigImageData(PD.lqa, PD.exw, PD.exu, PD.index);
                                                                                            addBigImageData.setKeyPageStartFrom(PbFragment.this.lpS.dmh());
                                                                                            addBigImageData.setFromFrsForumId(PbFragment.this.lpS.getFromForumId());
                                                                                            addBigImageData.setKeyFromForumId(PbFragment.this.lpS.getForumId());
                                                                                            addBigImageData.setBjhData(PbFragment.this.lpS.dlG());
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        PbActivity.a PD2 = PbFragment.this.PD(id);
                                                                                        if (postData != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PD2 != null) {
                                                                                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dlx, id, "pb", true, null, false, str2, i3, postData.dqh(), PbFragment.this.lpS.getPbData().getAnti(), false, postData.bmA().getIconInfo()).addBigImageData(PD2.lqa, PD2.exw, PD2.exu, PD2.index);
                                                                                            if (!com.baidu.tbadk.core.util.at.isEmpty(str2)) {
                                                                                                addBigImageData2.setHighLightPostId(str2);
                                                                                                addBigImageData2.setKeyIsUseSpid(true);
                                                                                            }
                                                                                            addBigImageData2.setKeyFromForumId(PbFragment.this.lpS.getForumId());
                                                                                            addBigImageData2.setBjhData(PbFragment.this.lpS.dlG());
                                                                                            addBigImageData2.setKeyPageStartFrom(PbFragment.this.lpS.dmh());
                                                                                            addBigImageData2.setFromFrsForumId(PbFragment.this.lpS.getFromForumId());
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").al("obj_locate", 3).dR("fid", PbFragment.this.lpS.getPbData().getForumId()));
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                        if (PbFragment.this.lpS != null) {
                                                                            com.baidu.tbadk.core.util.aq aqVar2 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                            aqVar2.dR("tid", PbFragment.this.lpS.dlx());
                                                                            aqVar2.dR("fid", PbFragment.this.lpS.getForumId());
                                                                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            aqVar2.al("obj_locate", 5);
                                                                            TiebaStatic.log(aqVar2);
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                    if (postData3.mXM != null) {
                                                                                        com.baidu.tbadk.core.util.aq brj2 = postData3.mXM.brj();
                                                                                        brj2.delete("obj_locate");
                                                                                        brj2.al("obj_locate", 8);
                                                                                        TiebaStatic.log(brj2);
                                                                                    }
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                        String dlx2 = PbFragment.this.lpS.dlx();
                                                                                        String id2 = postData3.getId();
                                                                                        int i4 = 0;
                                                                                        if (PbFragment.this.lpS.getPbData() != null) {
                                                                                            i4 = PbFragment.this.lpS.getPbData().diz();
                                                                                        }
                                                                                        PbActivity.a PD3 = PbFragment.this.PD(id2);
                                                                                        if (PD3 != null) {
                                                                                            SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(dlx2, id2, "pb", true, null, false, null, i4, postData3.dqh(), PbFragment.this.lpS.getPbData().getAnti(), false, postData3.bmA().getIconInfo()).addBigImageData(PD3.lqa, PD3.exw, PD3.exu, PD3.index);
                                                                                            addBigImageData3.setKeyPageStartFrom(PbFragment.this.lpS.dmh());
                                                                                            addBigImageData3.setFromFrsForumId(PbFragment.this.lpS.getFromForumId());
                                                                                            addBigImageData3.setKeyFromForumId(PbFragment.this.lpS.getForumId());
                                                                                            addBigImageData3.setBjhData(PbFragment.this.lpS.dlG());
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
                                                                        if (PbFragment.this.lpS != null) {
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                com.baidu.tbadk.core.util.aq aqVar3 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                aqVar3.dR("tid", PbFragment.this.lpS.dlx());
                                                                                aqVar3.dR("fid", PbFragment.this.lpS.getForumId());
                                                                                aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                aqVar3.al("obj_locate", 6);
                                                                                TiebaStatic.log(aqVar3);
                                                                            }
                                                                            if (PbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                                SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                if (sparseArray4.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (view.getId() == R.id.pb_post_reply && postData4.mXM != null) {
                                                                                        com.baidu.tbadk.core.util.aq brj3 = postData4.mXM.brj();
                                                                                        brj3.delete("obj_locate");
                                                                                        brj3.al("obj_locate", 8);
                                                                                        TiebaStatic.log(brj3);
                                                                                    } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13700").dR("tid", PbFragment.this.lpS.dly()).dR("fid", PbFragment.this.lpS.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).al("obj_type", 3));
                                                                                    }
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.dkp().dnj() != null && postData4.bmA() != null && postData4.dJZ() != 1) {
                                                                                        if (PbFragment.this.dkp().dnk() != null) {
                                                                                            PbFragment.this.dkp().dnk().dkf();
                                                                                        }
                                                                                        if ((PbFragment.this.lrn || com.baidu.tbadk.a.d.bhL()) && postData4.dJW() != null && postData4.dJW().size() != 0) {
                                                                                            if (com.baidu.tbadk.a.d.bhM()) {
                                                                                                PbFragment.this.a(postData4, false);
                                                                                            } else {
                                                                                                PbFragment.this.a(postData4, true);
                                                                                            }
                                                                                        } else {
                                                                                            com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                                                                                            pVar.a(PbFragment.this.lpS.getPbData().getForum());
                                                                                            pVar.setThreadData(PbFragment.this.lpS.getPbData().dik());
                                                                                            pVar.g(postData4);
                                                                                            PbFragment.this.dkp().dnj().d(pVar);
                                                                                            PbFragment.this.dkp().dnj().setPostId(postData4.getId());
                                                                                            PbFragment.this.a(view, postData4.bmA().getUserId(), "", postData4);
                                                                                            if (PbFragment.this.lud != null) {
                                                                                                PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
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
                                                                        if (view != PbFragment.this.ltR.djJ()) {
                                                                            if (view == PbFragment.this.ltR.lAX.dpj()) {
                                                                                PbFragment.this.ltR.dnP();
                                                                            } else {
                                                                                int id3 = view.getId();
                                                                                if (id3 == R.id.pb_u9_text_view) {
                                                                                    if (PbFragment.this.checkUpIsLogin() && (cbVar = (cb) view.getTag()) != null && !StringUtils.isNull(cbVar.boQ())) {
                                                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                        com.baidu.tbadk.core.util.be.brr().b(PbFragment.this.getPageContext(), new String[]{cbVar.boQ()});
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
                                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12006").dR("tid", PbFragment.this.lpS.lxd));
                                                                                            }
                                                                                            if (PbFragment.this.ltW == null) {
                                                                                                PbFragment.this.ltW = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                                PbFragment.this.ltW.a(PbFragment.this.luO);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            PbFragment.this.dk(view);
                                                                                            if (!PbFragment.this.dk(view) || PbFragment.this.lun == null || !PbFragment.this.lun.isGif()) {
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
                                                                                                if (postData5.dKb() != null && postData5.dKb().toString().length() > 0) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.ltW);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData5);
                                                                                                    gVar5.mTextView.setTag(sparseArray6);
                                                                                                    arrayList.add(gVar5);
                                                                                                }
                                                                                                PbFragment.this.jKP = postData5;
                                                                                            }
                                                                                            if (PbFragment.this.lpS.getPbData().biv()) {
                                                                                                String biu = PbFragment.this.lpS.getPbData().biu();
                                                                                                if (postData5 != null && !com.baidu.adp.lib.util.k.isEmpty(biu) && biu.equals(postData5.getId())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.ltW);
                                                                                                    } else {
                                                                                                        gVar = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.ltW);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, PbFragment.this.jKP);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, false);
                                                                                                    gVar.mTextView.setTag(sparseArray7);
                                                                                                    arrayList.add(gVar);
                                                                                                    if (PbFragment.this.mIsLogin) {
                                                                                                        if (!z5 && z4) {
                                                                                                            com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.ltW);
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
                                                                                                            if (PbFragment.this.uj(z3) && TbadkCoreApplication.isLogin()) {
                                                                                                                com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
                                                                                                                gVar7.mTextView.setTag(str3);
                                                                                                                arrayList.add(gVar7);
                                                                                                            }
                                                                                                        }
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
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
                                                                                                                gVar2.mTextView.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, false);
                                                                                                                gVar2 = null;
                                                                                                            }
                                                                                                            gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.ltW);
                                                                                                            gVar3.mTextView.setTag(sparseArray9);
                                                                                                        } else if (!z7) {
                                                                                                            gVar2 = null;
                                                                                                            gVar3 = null;
                                                                                                        } else {
                                                                                                            SparseArray sparseArray10 = new SparseArray();
                                                                                                            sparseArray10.put(R.id.tag_should_manage_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_user_mute_visible, false);
                                                                                                            sparseArray10.put(R.id.tag_should_delete_visible, true);
                                                                                                            sparseArray10.put(R.id.tag_manage_user_identity, sparseArray5.get(R.id.tag_manage_user_identity));
                                                                                                            sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                            sparseArray10.put(R.id.tag_del_post_id, sparseArray5.get(R.id.tag_del_post_id));
                                                                                                            sparseArray10.put(R.id.tag_del_post_type, sparseArray5.get(R.id.tag_del_post_type));
                                                                                                            if (PbFragment.this.lpS.getPbData().diz() == 1002 && !z3) {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
                                                                                                            } else {
                                                                                                                gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
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
                                                                                                    PbFragment.this.ltW.br(arrayList);
                                                                                                    PbFragment.this.ltV = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.ltW);
                                                                                                    PbFragment.this.ltV.Qj();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, PbFragment.this.jKP);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray72);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbFragment.this.mIsLogin) {
                                                                                            }
                                                                                            PbFragment.this.ltW.br(arrayList);
                                                                                            PbFragment.this.ltV = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.ltW);
                                                                                            PbFragment.this.ltV.Qj();
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_act_btn) {
                                                                                    if (PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().getActUrl() != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), PbFragment.this.lpS.getPbData().dik().getActUrl());
                                                                                        if (PbFragment.this.lpS.getPbData().dik().bnn() != 1) {
                                                                                            if (PbFragment.this.lpS.getPbData().dik().bnn() == 2) {
                                                                                                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                            }
                                                                                        } else {
                                                                                            TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.lottery_tail) {
                                                                                    if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                        String str4 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10912").dR("fid", PbFragment.this.lpS.getPbData().getForumId()).dR("tid", PbFragment.this.lpS.getPbData().getThreadId()).dR("lotterytail", StringUtils.string(str4, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                        if (PbFragment.this.lpS.getPbData().getThreadId().equals(str4)) {
                                                                                            PbFragment.this.ltR.setSelection(0);
                                                                                        } else {
                                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbFragment.this.getActivity()).createNormalCfg(str4, (String) null, (String) null, (String) null)));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_item_tail_content) {
                                                                                    if (bg.checkUpIsLogin(PbFragment.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.bqh().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                        }
                                                                                        PbFragment.this.ltR.dnm();
                                                                                    }
                                                                                } else if (id3 == R.id.join_vote_tv) {
                                                                                    if (view != null) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                        if (PbFragment.this.dky() == 1 && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10397").dR("fid", PbFragment.this.lpS.getPbData().getForumId()).dR("tid", PbFragment.this.lpS.getPbData().getThreadId()).dR("uid", currentAccount));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.look_all_tv) {
                                                                                    if (view != null) {
                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbFragment.this.getActivity(), (String) view.getTag());
                                                                                        if (PbFragment.this.dky() == 1 && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10507").dR("fid", PbFragment.this.lpS.getPbData().getForumId()).dR("tid", PbFragment.this.lpS.getPbData().getThreadId()).dR("uid", currentAccount2));
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.manga_prev_btn) {
                                                                                    PbFragment.this.dkO();
                                                                                } else if (id3 == R.id.manga_next_btn) {
                                                                                    PbFragment.this.dkP();
                                                                                } else if (id3 == R.id.yule_head_img_img) {
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().diG() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData3 = PbFragment.this.lpS.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11679").dR("fid", pbData3.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.brr().b(PbFragment.this.getPageContext(), new String[]{pbData3.diG().diS()});
                                                                                    }
                                                                                } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().diG() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData4 = PbFragment.this.lpS.getPbData();
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dR("fid", pbData4.getForumId()));
                                                                                        com.baidu.tbadk.core.util.be.brr().b(PbFragment.this.getPageContext(), new String[]{pbData4.diG().diS()});
                                                                                    }
                                                                                } else if (id3 == R.id.tv_pb_reply_more) {
                                                                                    if (PbFragment.this.luq >= 0) {
                                                                                        if (PbFragment.this.lpS != null) {
                                                                                            PbFragment.this.lpS.dmi();
                                                                                        }
                                                                                        if (PbFragment.this.lpS != null && PbFragment.this.ltR.dnE() != null) {
                                                                                            PbFragment.this.ltR.dnE().a(PbFragment.this.lpS.getPbData(), false);
                                                                                        }
                                                                                        PbFragment.this.luq = 0;
                                                                                        if (PbFragment.this.lpS != null) {
                                                                                            PbFragment.this.ltR.getListView().setSelection(PbFragment.this.lpS.dml());
                                                                                            PbFragment.this.lpS.db(0, 0);
                                                                                        }
                                                                                    }
                                                                                } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                                    if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbFragment.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                        TiebaStatic.log("c12640");
                                                                                    }
                                                                                } else if (id3 == R.id.thread_info_commont_container) {
                                                                                    if (PbFragment.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                                                                                        PbFragment.this.FS(8);
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
                                                                                    if (PbFragment.this.ltR.getListView() != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                        int firstVisiblePosition = PbFragment.this.ltR.getListView().getFirstVisiblePosition();
                                                                                        View childAt = PbFragment.this.ltR.getListView().getChildAt(0);
                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                        boolean diK = PbFragment.this.lpS.getPbData().diK();
                                                                                        boolean z8 = PbFragment.this.ltR.dnl() != null && PbFragment.this.ltR.dnl().bXc();
                                                                                        boolean dnY = PbFragment.this.ltR.dnY();
                                                                                        boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                        int i5 = 0;
                                                                                        if (diK && PbFragment.this.ltR.dnl() != null && PbFragment.this.ltR.dnl().bPo() != null) {
                                                                                            int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)) - PbFragment.this.ltR.dnl().doS();
                                                                                            z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbFragment.this.ltR.dnl().bPo().getHeight() - PbFragment.this.ltR.dnl().doS());
                                                                                            i5 = equipmentWidth;
                                                                                        }
                                                                                        PbFragment.this.PE("c13568");
                                                                                        if ((PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmr() <= 0) || (dnY && z9)) {
                                                                                            if (PbFragment.this.checkUpIsLogin()) {
                                                                                                PbFragment.this.dkv();
                                                                                                if (PbFragment.this.lpS.getPbData().dik().bmA() != null) {
                                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.lpS.lxd).dR("fid", PbFragment.this.lpS.getPbData().getForumId()).al("obj_locate", 2).dR("uid", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            boolean z10 = false;
                                                                                            int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.getContext()) * 0.6d);
                                                                                            if (diK) {
                                                                                                if (PbFragment.this.ltR.lCh != null && PbFragment.this.ltR.lCh.lDm != null && PbFragment.this.ltR.lCh.lDm.getView() != null) {
                                                                                                    if (PbFragment.this.ltR.lCh.lDm.getView().getParent() == null) {
                                                                                                        z10 = firstVisiblePosition >= PbFragment.this.dkE();
                                                                                                    } else {
                                                                                                        int i6 = 0;
                                                                                                        if (PbFragment.this.ltR.dnl() != null && PbFragment.this.ltR.dnl().bPo() != null) {
                                                                                                            i6 = PbFragment.this.ltR.dnl().bPo().getBottom();
                                                                                                        }
                                                                                                        z10 = PbFragment.this.ltR.lCh.lDm.getView().getTop() <= i6;
                                                                                                    }
                                                                                                }
                                                                                            } else if (PbFragment.this.ltR.dnv() != null) {
                                                                                                z10 = PbFragment.this.ltR.dnv().getVisibility() == 0;
                                                                                                if (!z10 && PbFragment.this.ltR.lCh != null && PbFragment.this.ltR.lCh.lDm != null && PbFragment.this.ltR.lCh.lDm.getView() != null && PbFragment.this.ltR.lCh.lDm.getView().getParent() != null && PbFragment.this.ltR.lAX != null && PbFragment.this.ltR.lAX.mNavigationBar != null) {
                                                                                                    z10 = PbFragment.this.ltR.lCh.lDm.getView().getTop() - PbFragment.this.ltR.lAX.mNavigationBar.getBottom() < PbFragment.this.ltR.lCh.lDm.lAw.getHeight() + 10;
                                                                                                }
                                                                                            }
                                                                                            if (z10 || dnY) {
                                                                                                PbFragment.this.ltI = firstVisiblePosition;
                                                                                                PbFragment.this.ltJ = top;
                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                                    PbFragment.this.ltR.getListView().setSelectionFromTop(0, i5 - equipmentHeight);
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                                } else {
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollToPosition(0, i5, 500);
                                                                                                }
                                                                                            } else if (PbFragment.this.ltI > 0) {
                                                                                                if (PbFragment.this.ltR.getListView().getChildAt(PbFragment.this.ltI) != null) {
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollToPosition(PbFragment.this.ltI, PbFragment.this.ltJ, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.ltR.getListView().setSelectionFromTop(PbFragment.this.ltI, PbFragment.this.ltJ + equipmentHeight);
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                }
                                                                                            } else {
                                                                                                int dkE = PbFragment.this.dkE();
                                                                                                if (PbFragment.this.dkD() != -1) {
                                                                                                    dkE--;
                                                                                                }
                                                                                                int dimens = com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.tbds100);
                                                                                                if (dkE < 0) {
                                                                                                    i = PbFragment.this.ltR.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.y.getCount(PbFragment.this.ltR.getListView().getData()) - 1);
                                                                                                    i2 = 0;
                                                                                                } else {
                                                                                                    i = dkE;
                                                                                                    i2 = dimens;
                                                                                                }
                                                                                                if (z8) {
                                                                                                    i2 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                                                                                } else if (!diK || PbFragment.this.ltR.dnl() == null) {
                                                                                                    if (PbFragment.this.ltR.lAX != null && PbFragment.this.ltR.lAX.mNavigationBar != null) {
                                                                                                        i2 += PbFragment.this.ltR.lAX.mNavigationBar.getFixedNavHeight() - 10;
                                                                                                    }
                                                                                                } else {
                                                                                                    i2 += PbFragment.this.ltR.dnl().doR();
                                                                                                }
                                                                                                if (PbFragment.this.ltR.lCh == null || PbFragment.this.ltR.lCh.lDm == null || PbFragment.this.ltR.lCh.lDm.getView() == null || PbFragment.this.ltR.lCh.lDm.getView().getParent() == null) {
                                                                                                    PbFragment.this.ltR.getListView().setSelectionFromTop(i, i2 + equipmentHeight);
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                                } else if (!z8) {
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollToPosition(i, i2, 200);
                                                                                                } else {
                                                                                                    PbFragment.this.ltR.getListView().smoothScrollBy(PbFragment.this.ltR.lCh.lDm.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d)), 500);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.lpS.lxd).dR("fid", PbFragment.this.lpS.getPbData().getForumId()).al("obj_locate", 2).dR("uid", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(PbFragment.this.lpS.getPbData().getForum().getName())) {
                                                                                        if (PbFragment.this.lpS.getErrorNo() == 4) {
                                                                                            if (!StringUtils.isNull(PbFragment.this.lpS.djr()) || PbFragment.this.lpS.getAppealInfo() == null) {
                                                                                                PbFragment.this.ltl.finish();
                                                                                                return;
                                                                                            }
                                                                                            name = PbFragment.this.lpS.getAppealInfo().forumName;
                                                                                        } else {
                                                                                            name = PbFragment.this.lpS.getPbData().getForum().getName();
                                                                                        }
                                                                                        if (StringUtils.isNull(name)) {
                                                                                            PbFragment.this.ltl.finish();
                                                                                            return;
                                                                                        }
                                                                                        String djr = PbFragment.this.lpS.djr();
                                                                                        if (PbFragment.this.lpS.dlA() && djr != null && djr.equals(name)) {
                                                                                            PbFragment.this.ltl.finish();
                                                                                        } else {
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(PbFragment.this.lpS.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar4 = new com.baidu.tbadk.core.util.aq("c13401");
                                                                                        aqVar4.dR("tid", PbFragment.this.lpS.dlx());
                                                                                        aqVar4.dR("fid", PbFragment.this.lpS.getForumId());
                                                                                        aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        if (PbFragment.this.lpS.getPbData().dik() != null) {
                                                                                            aqVar4.dR("nid", PbFragment.this.lpS.getPbData().dik().getNid());
                                                                                        }
                                                                                        TiebaStatic.log(aqVar4);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.forum_name_text || id3 == R.id.forum_enter_button_one || id3 == R.id.forum_enter_button_two || id3 == R.id.forum_enter_button_three) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar = (bw) view.getTag();
                                                                                        if (PbFragment.this.lpS.dmh() == 3 && PbFragment.this.djq() && PbFragment.this.lpS.getPbData() != null && com.baidu.tbadk.core.util.y.isEmpty(PbFragment.this.lpS.getPbData().diH())) {
                                                                                            PbFragment.this.ltl.finish();
                                                                                        } else {
                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar.bmE(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                            createNormalCfg.setCallFrom(14);
                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                        }
                                                                                        com.baidu.tbadk.core.util.aq aqVar5 = new com.baidu.tbadk.core.util.aq("c13399");
                                                                                        aqVar5.dR("tid", bwVar.getId());
                                                                                        aqVar5.w("fid", bwVar.getFid());
                                                                                        aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar5.dR("nid", bwVar.getNid());
                                                                                        TiebaStatic.log(aqVar5);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                    if (PbFragment.this.lpS != null) {
                                                                                        com.baidu.tbadk.core.util.aq aqVar6 = new com.baidu.tbadk.core.util.aq("c13398");
                                                                                        aqVar6.dR("tid", PbFragment.this.lpS.dlx());
                                                                                        aqVar6.dR("fid", PbFragment.this.lpS.getForumId());
                                                                                        aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        aqVar6.al("obj_locate", 2);
                                                                                        TiebaStatic.log(aqVar6);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.pb_thread_post_button) {
                                                                                    if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                                                                        com.baidu.tieba.pb.data.f pbData5 = PbFragment.this.lpS.getPbData();
                                                                                        if (PbFragment.this.ltQ == null) {
                                                                                            PbFragment.this.ltQ = new com.baidu.tieba.pb.data.q(PbFragment.this.getPageContext());
                                                                                        }
                                                                                        long j = com.baidu.adp.lib.f.b.toLong(pbData5.getThreadId(), 0L);
                                                                                        long j2 = com.baidu.adp.lib.f.b.toLong(pbData5.getForumId(), 0L);
                                                                                        new com.baidu.tbadk.core.util.aq("c13446").w("forum_id", j2).brk();
                                                                                        PbFragment.this.registerListener(PbFragment.this.luS);
                                                                                        PbFragment.this.ltQ.G(j, j2);
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13274").dR("fid", PbFragment.this.lpS.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", smartApp.name).w("obj_id", smartApp.swan_app_id.longValue()).dR("obj_source", "PB_card").dR("tid", PbFragment.this.lpS.dlx()).al("obj_param1", smartApp.is_game.intValue()));
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                                    if (view.getTag() instanceof bw) {
                                                                                        bw bwVar2 = (bw) view.getTag();
                                                                                        FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbFragment.this.getActivity()).createNormalCfg(bwVar2.bmE(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                        createNormalCfg2.setCallFrom(14);
                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 9).al("obj_locate", 9).w("obj_id", bwVar2.getFid()).dR("tid", bwVar2.getId()).al("thread_type", bwVar2.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                                    if ((view.getTag() instanceof bw) && PbFragment.this.checkUpIsLogin()) {
                                                                                        bw bwVar3 = (bw) view.getTag();
                                                                                        if (PbFragment.this.eZA != null) {
                                                                                            PbFragment.this.eZA.gp(bwVar3.bmE(), String.valueOf(bwVar3.getFid()));
                                                                                        }
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).al("obj_isad", 1).al("obj_floor", 1).al("obj_adlocate", 10).al("obj_locate", 11).w("obj_id", bwVar3.getFid()).dR("tid", bwVar3.getId()).al("thread_type", bwVar3.getThreadType()));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                            PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbFragment.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.f.b.toLong(PbFragment.this.lpS.getPbData().getForumId(), 0L), com.baidu.adp.lib.f.b.toLong(PbFragment.this.lpS.dlx(), 0L), com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbFragment.this.lpS.getPbData().dik().bmV())));
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
                                                                            if (PbFragment.this.ltW == null) {
                                                                                PbFragment.this.ltW = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                                                                PbFragment.this.ltW.a(PbFragment.this.luO);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z11 = PbFragment.this.djz().getPbData() != null && PbFragment.this.djz().getPbData().diN();
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
                                                                                if (postData6.bor() != null) {
                                                                                    com.baidu.tbadk.core.dialog.g gVar8 = new com.baidu.tbadk.core.dialog.g(8, (postData6.bor().hasAgree && postData6.bob() == 5) ? PbFragment.this.getString(R.string.action_cancel_dislike) : PbFragment.this.getString(R.string.action_dislike), PbFragment.this.ltW);
                                                                                    SparseArray sparseArray12 = new SparseArray();
                                                                                    sparseArray12.put(R.id.tag_clip_board, postData6);
                                                                                    gVar8.mTextView.setTag(sparseArray12);
                                                                                    arrayList2.add(gVar8);
                                                                                }
                                                                                if (PbFragment.this.mIsLogin) {
                                                                                    if (!z13 && z12) {
                                                                                        com.baidu.tbadk.core.dialog.g gVar9 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.ltW);
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
                                                                                        if ((PbFragment.this.uj(z2) && TbadkCoreApplication.isLogin()) && !z11) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar10 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
                                                                                            gVar10.mTextView.setTag(str);
                                                                                            arrayList2.add(gVar10);
                                                                                        }
                                                                                    }
                                                                                    com.baidu.tbadk.core.dialog.g gVar11 = null;
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
                                                                                            gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
                                                                                            gVar11.mTextView.setTag(sparseArray14);
                                                                                        } else {
                                                                                            sparseArray14.put(R.id.tag_should_delete_visible, false);
                                                                                        }
                                                                                        gVar4 = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.ltW);
                                                                                        gVar4.mTextView.setTag(sparseArray14);
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
                                                                                            if (PbFragment.this.lpS.getPbData().diz() == 1002 && !z2) {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
                                                                                            } else {
                                                                                                gVar11 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
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
                                                                                PbFragment.this.ltW.br(arrayList2);
                                                                                PbFragment.this.ltV = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.ltW);
                                                                                PbFragment.this.ltV.Qj();
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                    PbFragment.this.ltR.dob();
                                                                    SparseArray<Object> b3 = PbFragment.this.ltR.b(PbFragment.this.lpS.getPbData(), PbFragment.this.lpS.dlz(), 1);
                                                                    if (b3 != null) {
                                                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpS.getPbData().getForum().getId(), PbFragment.this.lpS.getPbData().getForum().getName(), PbFragment.this.lpS.getPbData().dik().getId(), String.valueOf(PbFragment.this.lpS.getPbData().getUserData().getUserId()), (String) b3.get(R.id.tag_forbid_user_name), (String) b3.get(R.id.tag_forbid_user_name_show), (String) b3.get(R.id.tag_forbid_user_post_id), (String) b3.get(R.id.tag_forbid_user_portrait))));
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
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 0).al("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(PbFragment.this.getActivity());
                                                                    PbFragment.this.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(PbFragment.this.getActivity(), PbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).al("obj_type", 1).al("obj_source", 1));
                                                                }
                                                                PbFragment.this.ltR.lAX.dph();
                                                            }
                                                        } else if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null) {
                                                            PbFragment.this.ltR.lAX.aZC();
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13062"));
                                                            PbFragment.this.PA(PbFragment.this.lpS.getPbData().dik().bmR());
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        PbFragment.this.ltR.dob();
                                                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                            if (PbFragment.this.mIsLoading) {
                                                                view.setTag(Integer.valueOf(PbFragment.this.lpS.dlQ()));
                                                                return;
                                                            }
                                                            PbFragment.this.cyK();
                                                            PbFragment.this.ltR.dnI();
                                                            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext());
                                                            if (PbFragment.this.lpS.getPbData().lmT == null || PbFragment.this.lpS.getPbData().lmT.size() <= 0) {
                                                                strArr = new String[]{PbFragment.this.getResources().getString(R.string.sort_type_new), PbFragment.this.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                String[] strArr2 = new String[PbFragment.this.lpS.getPbData().lmT.size()];
                                                                int i7 = 0;
                                                                while (true) {
                                                                    int i8 = i7;
                                                                    if (i8 >= PbFragment.this.lpS.getPbData().lmT.size()) {
                                                                        break;
                                                                    }
                                                                    strArr2[i8] = PbFragment.this.lpS.getPbData().lmT.get(i8).sort_name + PbFragment.this.getResources().getString(R.string.sort_static);
                                                                    i7 = i8 + 1;
                                                                }
                                                                strArr = strArr2;
                                                            }
                                                            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.40.1
                                                                @Override // com.baidu.tbadk.core.dialog.k.c
                                                                public void a(com.baidu.tbadk.core.dialog.k kVar, int i9, View view3) {
                                                                    int i10 = 2;
                                                                    iVar.dismiss();
                                                                    if (PbFragment.this.lpS.getSortType() == 1 && i9 == 1) {
                                                                        i10 = 0;
                                                                    } else if (PbFragment.this.lpS.getSortType() == 2 && i9 == 0) {
                                                                        i10 = 1;
                                                                    } else if (PbFragment.this.lpS.getSortType() != 3 || i9 == 2) {
                                                                        i10 = (i9 != 2 || PbFragment.this.lpS.getSortType() == 3) ? 0 : 3;
                                                                    }
                                                                    TiebaStatic.log("c12097");
                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12097").al("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).al("obj_type", i10));
                                                                    if (PbFragment.this.lpS.getPbData().lmT != null && PbFragment.this.lpS.getPbData().lmT.size() > i9) {
                                                                        i9 = PbFragment.this.lpS.getPbData().lmT.get(i9).sort_type.intValue();
                                                                    }
                                                                    boolean Ga = PbFragment.this.lpS.Ga(i9);
                                                                    view.setTag(Integer.valueOf(PbFragment.this.lpS.dlQ()));
                                                                    if (Ga) {
                                                                        PbFragment.this.mIsLoading = true;
                                                                        PbFragment.this.ltR.uG(true);
                                                                    }
                                                                }
                                                            });
                                                            iVar.Qj();
                                                        } else {
                                                            PbFragment.this.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    PbFragment.this.ltR.dob();
                                                    if (PbFragment.this.djz().getPbData().lmU != 2) {
                                                        if (PbFragment.this.lpS.getPageData() != null) {
                                                            PbFragment.this.ltR.a(PbFragment.this.lpS.getPageData(), PbFragment.this.lax);
                                                        }
                                                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        PbFragment.this.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if ((ShareSwitch.isOn() || PbFragment.this.checkUpIsLogin()) && (pbData = PbFragment.this.lpS.getPbData()) != null) {
                                                bw dik = pbData.dik();
                                                if (dik != null && dik.bmA() != null) {
                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.lpS.lxd).dR("fid", pbData.getForumId()).al("obj_locate", 4).dR("uid", dik.bmA().getUserId()));
                                                }
                                                int i9 = 1;
                                                if (dik != null) {
                                                    if (dik.bli()) {
                                                        i9 = 2;
                                                    } else if (dik.blj()) {
                                                        i9 = 3;
                                                    } else if (dik.bov()) {
                                                        i9 = 4;
                                                    } else if (dik.bow()) {
                                                        i9 = 5;
                                                    }
                                                }
                                                com.baidu.tbadk.core.util.aq aqVar7 = new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                aqVar7.dR("tid", PbFragment.this.lpS.dlx());
                                                aqVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                                aqVar7.dR("fid", PbFragment.this.lpS.getForumId());
                                                if (view.getId() == R.id.share_num_container) {
                                                    aqVar7.al("obj_locate", 5);
                                                } else {
                                                    aqVar7.al("obj_locate", 6);
                                                }
                                                aqVar7.al("obj_name", i9);
                                                aqVar7.al("obj_type", 1);
                                                if (dik != null) {
                                                    if (dik.bli()) {
                                                        aqVar7.al("obj_type", 10);
                                                    } else if (dik.blj()) {
                                                        aqVar7.al("obj_type", 9);
                                                    } else if (dik.bow()) {
                                                        aqVar7.al("obj_type", 8);
                                                    } else if (dik.bov()) {
                                                        aqVar7.al("obj_type", 7);
                                                    } else if (dik.isShareThread) {
                                                        aqVar7.al("obj_type", 6);
                                                    } else if (dik.threadType == 0) {
                                                        aqVar7.al("obj_type", 1);
                                                    } else if (dik.threadType == 40) {
                                                        aqVar7.al("obj_type", 2);
                                                    } else if (dik.threadType == 49) {
                                                        aqVar7.al("obj_type", 3);
                                                    } else if (dik.threadType == 54) {
                                                        aqVar7.al("obj_type", 4);
                                                    } else {
                                                        aqVar7.al("obj_type", 5);
                                                    }
                                                    aqVar7.al(IntentConfig.CARD_TYPE, dik.boz());
                                                    aqVar7.dR(IntentConfig.RECOM_SOURCE, dik.mRecomSource);
                                                    aqVar7.dR("ab_tag", dik.mRecomAbTag);
                                                    aqVar7.dR("weight", dik.mRecomWeight);
                                                    aqVar7.dR("extra", dik.mRecomExtra);
                                                    aqVar7.dR("nid", dik.getNid());
                                                    if (dik.getBaijiahaoData() != null && !com.baidu.tbadk.core.util.at.isEmpty(dik.getBaijiahaoData().oriUgcVid)) {
                                                        aqVar7.dR("obj_param6", dik.getBaijiahaoData().oriUgcVid);
                                                    }
                                                }
                                                if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    aqVar7.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                if (PbFragment.this.dle() != null) {
                                                    com.baidu.tbadk.pageInfo.c.b(PbFragment.this.dle(), aqVar7);
                                                }
                                                TiebaStatic.log(aqVar7);
                                                if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                    PbFragment.this.showToast(R.string.neterror);
                                                    return;
                                                } else if (pbData != null) {
                                                    ArrayList<PostData> dim2 = PbFragment.this.lpS.getPbData().dim();
                                                    if ((dim2 != null && dim2.size() > 0) || !PbFragment.this.lpS.dlz()) {
                                                        PbFragment.this.ltR.dob();
                                                        PbFragment.this.cyK();
                                                        if (pbData.diG() != null && !StringUtils.isNull(pbData.diG().bkw(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11678").dR("fid", PbFragment.this.lpS.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11939"));
                                                        if (!AntiHelper.d(PbFragment.this.getContext(), dik)) {
                                                            if (PbFragment.this.ltR != null) {
                                                                PbFragment.this.ltR.doe();
                                                                PbFragment.this.ltR.x(pbData);
                                                            }
                                                            int i10 = 6;
                                                            if (!ShareSwitch.isOn()) {
                                                                PbFragment.this.ltR.showLoadingDialog();
                                                                PbFragment.this.lpS.dmc().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i10 = 2;
                                                                } else if (view.getId() == R.id.share_num_container) {
                                                                    i10 = 1;
                                                                }
                                                                PbFragment.this.FR(i10);
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
                                            PbFragment.this.ltR.dob();
                                            if (PbFragment.this.ltR.lAX.dpi() != null && view == PbFragment.this.ltR.lAX.dpi().dmI() && !PbFragment.this.ltR.dou()) {
                                                PbFragment.this.ltR.dnm();
                                            }
                                            if (!PbFragment.this.mIsLoading) {
                                                PbFragment.this.cyK();
                                                PbFragment.this.ltR.dnI();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    B = PbFragment.this.lpS.B(true, PbFragment.this.dkM());
                                                } else {
                                                    B = view.getId() == R.id.reply_title ? PbFragment.this.lpS.B(false, PbFragment.this.dkM()) : PbFragment.this.lpS.PF(PbFragment.this.dkM());
                                                }
                                                view.setTag(Boolean.valueOf(B));
                                                if (B) {
                                                    PbFragment.this.ltR.uc(true);
                                                    PbFragment.this.ltR.cTu();
                                                    PbFragment.this.mIsLoading = true;
                                                    PbFragment.this.ltR.uG(true);
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
                                        PbFragment.this.ltR.dob();
                                        if (PbFragment.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbFragment.this.lpS.Gb(PbFragment.this.ltR.dnN()) != null) {
                                            PbFragment.this.dkH();
                                            if (PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", PbFragment.this.lpS.lxd).dR("fid", PbFragment.this.lpS.getPbData().getForumId()).al("obj_locate", 3).dR("uid", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()));
                                            }
                                            if (PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null && PbFragment.this.lpS.getPbData().dik().bmA().getUserId() != null && PbFragment.this.ltP != null) {
                                                int h = PbFragment.this.h(PbFragment.this.lpS.getPbData());
                                                bw dik2 = PbFragment.this.lpS.getPbData().dik();
                                                int i11 = 1;
                                                if (dik2.bli()) {
                                                    i11 = 2;
                                                } else if (dik2.blj()) {
                                                    i11 = 3;
                                                } else if (dik2.bov()) {
                                                    i11 = 4;
                                                } else if (dik2.bow()) {
                                                    i11 = 5;
                                                }
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12526").dR("tid", PbFragment.this.lpS.lxd).al("obj_locate", 1).dR("obj_id", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()).al("obj_type", PbFragment.this.ltP.biv() ? 0 : 1).al("obj_source", h).al("obj_param1", i11));
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
                                    if (PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().blg() && PbFragment.this.lpS.getPbData().dik().bmS() != null) {
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11922"));
                                    }
                                    if (PbFragment.this.lpS.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(PbFragment.this.lpS.djr()) || PbFragment.this.lpS.getAppealInfo() == null) {
                                            PbFragment.this.ltl.finish();
                                            return;
                                        }
                                        name2 = PbFragment.this.lpS.getAppealInfo().forumName;
                                    } else {
                                        name2 = PbFragment.this.lpS.getPbData().getForum().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        PbFragment.this.ltl.finish();
                                        return;
                                    }
                                    String djr2 = PbFragment.this.lpS.djr();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbFragment.this.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbFragment.this.lpS.dlA() && djr2 != null && djr2.equals(name2)) {
                                        PbFragment.this.ltl.finish();
                                    } else {
                                        PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                }
                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                if (PbFragment.this.lpS.getPbData() != null) {
                                    if ((PbFragment.this.lpS.getPbData().diz() == 1 || PbFragment.this.lpS.getPbData().diz() == 3) && !PbFragment.this.hYQ.dKK()) {
                                        PbFragment.this.ltR.dob();
                                        int i12 = 0;
                                        if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmJ()) {
                                            if (PbFragment.this.ltR.lAX.dpi() == null || view != PbFragment.this.ltR.lAX.dpi().dmL()) {
                                                if (view == PbFragment.this.ltR.dnG()) {
                                                    i12 = 2;
                                                }
                                            } else if (PbFragment.this.lpS.getPbData().dik().bmw() == 1) {
                                                i12 = 3;
                                            } else {
                                                i12 = 6;
                                            }
                                        } else if (PbFragment.this.lpS.getPbData().dik().bmv() == 1) {
                                            i12 = 5;
                                        } else {
                                            i12 = 4;
                                        }
                                        ForumData forum = PbFragment.this.lpS.getPbData().getForum();
                                        String name3 = forum.getName();
                                        String id4 = forum.getId();
                                        String id5 = PbFragment.this.lpS.getPbData().dik().getId();
                                        PbFragment.this.ltR.dnF();
                                        PbFragment.this.hYQ.b(id4, name3, id5, i12, PbFragment.this.ltR.dnH());
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
                            PbFragment.this.ltR.lAX.dph();
                            if (PbFragment.this.lpS != null) {
                                PbFragment.this.hYS.setThreadId(PbFragment.this.lpS.dlx());
                            }
                            int i13 = 1;
                            if (PbFragment.this.lpS == null || !PbFragment.this.lpS.isPrivacy()) {
                                PbFragment.this.hYS.cnN();
                                if (!TbSingleton.getInstance().mCanCallFans && PbFragment.this.djz() != null && PbFragment.this.djz().getPbData() != null && PbFragment.this.djz().getPbData().getThreadId() != null && PbFragment.this.djz().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                                    i13 = 2;
                                }
                                if (PbFragment.this.djz() != null && PbFragment.this.djz().getPbData() != null) {
                                    PbFragment.this.hYS.l(3, i13, PbFragment.this.djz().getPbData().getThreadId());
                                }
                            } else {
                                PbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (PbFragment.this.djz() != null && PbFragment.this.djz().getPbData() != null) {
                                    PbFragment.this.hYS.l(3, 3, PbFragment.this.djz().getPbData().getThreadId());
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbFragment.this.ltR.dob();
                        PbFragment.this.cyK();
                        PbFragment.this.ltR.dnI();
                        PbFragment.this.ltR.showLoadingDialog();
                        if (PbFragment.this.ltR.dnv() != null) {
                            PbFragment.this.ltR.dnv().setVisibility(8);
                        }
                        PbFragment.this.lpS.FV(1);
                        if (PbFragment.this.ltn != null) {
                            PbFragment.this.ltn.showFloatingView();
                        }
                    } else {
                        PbFragment.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbFragment.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String dkw = PbFragment.this.dkw();
                        if (!TextUtils.isEmpty(dkw)) {
                            com.baidu.tbadk.core.util.be.brr().b(PbFragment.this.getPageContext(), new String[]{dkw});
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar8 = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar8.dR("tid", PbFragment.this.lpS.dlx());
                aqVar8.dR("fid", PbFragment.this.lpS.getForumId());
                aqVar8.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar8.al("obj_locate", 1);
                TiebaStatic.log(aqVar8);
                if (PbFragment.this.ltx) {
                    PbFragment.this.ltx = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.dkp().dnj() != null && postData7.bmA() != null && postData7.dJZ() != 1 && PbFragment.this.checkUpIsLogin()) {
                            if (PbFragment.this.dkp().dnk() != null) {
                                PbFragment.this.dkp().dnk().dkf();
                            }
                            com.baidu.tieba.pb.data.p pVar2 = new com.baidu.tieba.pb.data.p();
                            pVar2.a(PbFragment.this.lpS.getPbData().getForum());
                            pVar2.setThreadData(PbFragment.this.lpS.getPbData().dik());
                            pVar2.g(postData7);
                            PbFragment.this.dkp().dnj().d(pVar2);
                            PbFragment.this.dkp().dnj().setPostId(postData7.getId());
                            PbFragment.this.a(view, postData7.bmA().getUserId(), "", postData7);
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lpS.getPbData(), postData7, postData7.locate, 8, 1);
                            if (PbFragment.this.lud != null) {
                                PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener luQ = new CustomMessageListener(2921480) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbFragment.this.lpS != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), PbFragment.this.lpS.lxd)) {
                PbFragment.this.g((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lpS.getPbData() != null) {
                    aqVar.dR("fid", PbFragment.this.lpS.getPbData().getForumId());
                }
                aqVar.dR("tid", PbFragment.this.lpS.dlx());
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            PbFragment.this.cyK();
            PbFragment.this.ltR.b(z, postWriteCallBackData);
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
                        if (PbFragment.this.lpS.getHostMode()) {
                            com.baidu.tieba.pb.data.f pbData = PbFragment.this.lpS.getPbData();
                            if (pbData != null && pbData.dik() != null && pbData.dik().bmA() != null && (userId = pbData.dik().bmA().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && PbFragment.this.lpS.dlJ()) {
                                PbFragment.this.ltR.dnI();
                            }
                        } else if (!PbReplySwitch.getInOn() && PbFragment.this.lpS.dlJ()) {
                            PbFragment.this.ltR.dnI();
                        }
                    } else if (floor != null) {
                        PbFragment.this.ltR.s(PbFragment.this.lpS.getPbData());
                    }
                    if (PbFragment.this.lpS.dlD()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10369").dR("tid", PbFragment.this.lpS.dlx()));
                    }
                    PbFragment pbFragment = PbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    pbFragment.ui(z2);
                }
            } else if (i == 220015) {
                PbFragment.this.showToast(str);
                if (PbFragment.this.lud.bAs() || PbFragment.this.lud.bAt()) {
                    PbFragment.this.lud.a(false, postWriteCallBackData);
                }
                PbFragment.this.kzD.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbFragment.this.kvy != null) {
                    PbFragment.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bpc();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                PbFragment.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d luR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13268");
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                    aqVar.dR("fid", PbFragment.this.lpS.getPbData().getForumId());
                }
                if (PbFragment.this.lpS != null) {
                    aqVar.dR("tid", PbFragment.this.lpS.dlx());
                }
                aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (PbFragment.this.kzD != null) {
                    PbFragment.this.kzD.doA();
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
                if (PbFragment.this.kvy != null) {
                    PbFragment.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(PbFragment.this.getPageContext()).bpc();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbFragment.this.kzD != null) {
                if (PbFragment.this.ltR != null && PbFragment.this.ltR.dnk() != null && PbFragment.this.ltR.dnk().dkj() != null && PbFragment.this.ltR.dnk().dkj().bAt()) {
                    PbFragment.this.ltR.dnk().dkj().a(postWriteCallBackData);
                }
                PbFragment.this.kzD.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a luS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.44
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView dox;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbFragment.this.ltl.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (PbFragment.this.ltR != null && (dox = PbFragment.this.ltR.dox()) != null && PbFragment.this.ltR.getListView() != null) {
                            PbFragment.this.ltR.getListView().removeHeaderView(dox);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a luT = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h rh;
            if (!z || fVar == null || fVar.dix() != null || com.baidu.tbadk.core.util.y.getCount(fVar.dim()) >= 1) {
                PbFragment.this.kPp = true;
                PbFragment.this.ltR.dnK();
                if (fVar == null || !fVar.dis()) {
                    PbFragment.this.hideLoadingView(PbFragment.this.ltR.getView());
                }
                PbFragment.this.ltR.cTt();
                if (PbFragment.this.isFullScreen || PbFragment.this.ltR.dou()) {
                    PbFragment.this.ltR.dol();
                } else if (!PbFragment.this.ltR.doi()) {
                    PbFragment.this.ltR.uS(false);
                }
                if (PbFragment.this.mIsLoading) {
                    PbFragment.this.mIsLoading = false;
                }
                if (i4 == 0 && fVar != null) {
                    PbFragment.this.fWQ = true;
                }
                if (fVar != null) {
                    PbFragment.this.hideNetRefreshView(PbFragment.this.ltR.getView());
                    PbFragment.this.ltR.dnT();
                }
                if (z && fVar != null) {
                    bw dik = fVar.dik();
                    if (dik == null || !dik.blk()) {
                        PbFragment.this.d(PbFragment.this.luc);
                    } else {
                        dlg();
                    }
                    PbFragment.this.ltR.dnk().setPbData(fVar);
                    PbFragment.this.ltR.bVq();
                    if (dik != null && dik.bnL() != null) {
                        PbFragment.this.a(dik.bnL());
                    }
                    if (PbFragment.this.lud != null) {
                        PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                    if (fVar.dim() != null && fVar.dim().size() >= 1 && fVar.dim().get(0) != null) {
                        PbFragment.this.lpS.PH(fVar.dim().get(0).getId());
                    } else if (fVar.dix() != null) {
                        PbFragment.this.lpS.PH(fVar.dix().getId());
                    }
                    if (PbFragment.this.lud != null) {
                        PbFragment.this.lud.a(fVar.getAnti());
                        PbFragment.this.lud.a(fVar.getForum(), fVar.getUserData());
                        PbFragment.this.lud.setThreadData(dik);
                        PbFragment.this.lud.a(PbFragment.this.lpS.dlN(), PbFragment.this.lpS.dlx(), PbFragment.this.lpS.dme());
                        if (dik != null) {
                            PbFragment.this.lud.kl(dik.bnX());
                        }
                    }
                    if (PbFragment.this.ltP != null) {
                        PbFragment.this.ltP.iq(fVar.biv());
                    }
                    if (fVar.getIsNewUrl() == 1) {
                        PbFragment.this.mIsFromCDN = true;
                    } else {
                        PbFragment.this.mIsFromCDN = false;
                    }
                    if (fVar.diN()) {
                        PbFragment.this.mIsFromCDN = true;
                    }
                    PbFragment.this.ltR.uR(PbFragment.this.mIsFromCDN);
                    PbFragment.this.ltR.a(fVar, i2, i3, PbFragment.this.lpS.dlz(), i4, PbFragment.this.lpS.getIsFromMark());
                    PbFragment.this.ltR.d(fVar, PbFragment.this.lpS.dlz());
                    PbFragment.this.ltR.uO(PbFragment.this.lpS.getHostMode());
                    AntiData anti = fVar.getAnti();
                    if (anti != null) {
                        PbFragment.this.fpM = anti.getVoice_message();
                        if (!StringUtils.isNull(PbFragment.this.fpM) && PbFragment.this.lud != null && PbFragment.this.lud.bzx() != null && (rh = PbFragment.this.lud.bzx().rh(6)) != null && !TextUtils.isEmpty(PbFragment.this.fpM)) {
                            ((View) rh).setOnClickListener(PbFragment.this.fqy);
                        }
                    }
                    if (PbFragment.this.ltY) {
                        PbFragment.this.ltY = false;
                        final int dkD = PbFragment.this.dkD();
                        if (!fVar.diK()) {
                            PbFragment.this.ltR.Gi(dkD);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbFragment.this.getListView() != null) {
                                        PbFragment.this.getListView().setSelectionFromTop(dkD, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbFragment.this.ltZ) {
                        PbFragment.this.ltZ = false;
                        final int dkD2 = PbFragment.this.dkD();
                        final boolean z2 = dkD2 != -1;
                        if (!z2) {
                            dkD2 = PbFragment.this.dkE();
                        }
                        if (PbFragment.this.ltR != null) {
                            if (!fVar.diK()) {
                                PbFragment.this.ltR.Gi(dkD2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbFragment.this.getContext()) * 0.5625d);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.46.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (dkD2 != -1 && PbFragment.this.getListView() != null) {
                                            if (z2) {
                                                PbFragment.this.ltR.setSelectionFromTop(dkD2, equipmentWidth2);
                                            } else {
                                                PbFragment.this.ltR.setSelectionFromTop(dkD2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbFragment.this.ltR.uT(true);
                                PbFragment.this.ltR.uS(false);
                            }
                        }
                    } else if (PbFragment.this.lua) {
                        PbFragment.this.lua = false;
                        PbFragment.this.ltR.setSelectionFromTop(0, 0);
                    } else {
                        PbFragment.this.ltR.dnO();
                    }
                    PbFragment.this.lpS.a(fVar.getForum(), PbFragment.this.luE);
                    PbFragment.this.lpS.a(PbFragment.this.luF);
                    if (PbFragment.this.kvy != null && dik != null && dik.bmA() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dik.bmA());
                        PbFragment.this.kvy.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbFragment.this.fWQ && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbFragment.this.lpS.getAppealInfo() != null && !StringUtils.isNull(PbFragment.this.lpS.getAppealInfo().lmL)) {
                                    PbFragment.this.ltR.a(PbFragment.this.lpS.getAppealInfo());
                                } else {
                                    PbFragment.this.showNetRefreshView(PbFragment.this.ltR.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment.this.showNetRefreshView(PbFragment.this.ltR.getView(), PbFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
                            }
                            PbFragment.this.ltR.dol();
                            PbFragment.this.ltR.dnS();
                        }
                    } else {
                        PbFragment.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbFragment.this.lpS.dlx());
                            jSONObject.put("fid", PbFragment.this.lpS.getForumId());
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
                        PbFragment.this.ltR.PN("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                            arrayList = PbFragment.this.lpS.getPbData().dim();
                        }
                        if (com.baidu.tbadk.core.util.y.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.y.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).dJZ() != 1)) {
                            PbFragment.this.ltR.PN(PbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (PbFragment.this.dkX()) {
                                PbFragment.this.ltR.PO(PbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                PbFragment.this.ltR.PO(PbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                            PbFragment.this.ltR.s(PbFragment.this.lpS.getPbData());
                        }
                    }
                    PbFragment.this.ltR.endLoadData();
                }
                if (fVar != null && fVar.lna && PbFragment.this.fvq == 0) {
                    PbFragment.this.fvq = System.currentTimeMillis() - PbFragment.this.ijR;
                }
                if (!PbFragment.this.djz().dlz() || PbFragment.this.djz().getPbData().getPage().blr() != 0 || PbFragment.this.djz().dlZ()) {
                    PbFragment.this.lue = true;
                    return;
                }
                return;
            }
            PbFragment.this.lpS.FV(1);
            if (PbFragment.this.ltn != null) {
                PbFragment.this.ltn.showFloatingView();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        private void dlg() {
            if (PbFragment.this.lpS != null) {
                if (PbFragment.this.lud == null || !PbFragment.this.lud.isBJH) {
                    com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                    PbFragment.this.d(dVar);
                    PbFragment.this.lud = (com.baidu.tbadk.editortools.pb.e) dVar.ei(PbFragment.this.getContext());
                    PbFragment.this.lud.a(PbFragment.this.ltl.getPageContext());
                    PbFragment.this.lud.a(PbFragment.this.fpW);
                    PbFragment.this.lud.a(PbFragment.this.fpP);
                    PbFragment.this.lud.a(PbFragment.this.ltl.getPageContext(), PbFragment.this.ltl.getIntent() == null ? null : PbFragment.this.ltl.getIntent().getExtras());
                    PbFragment.this.lud.bzx().kb(true);
                    PbFragment.this.ltR.setEditorTools(PbFragment.this.lud.bzx());
                    if (!PbFragment.this.lpS.dlE()) {
                        PbFragment.this.lud.DO(PbFragment.this.lpS.dlx());
                    }
                    if (PbFragment.this.lpS.dmf()) {
                        PbFragment.this.lud.DM(PbFragment.this.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                    } else if (PbFragment.this.ltR != null) {
                        PbFragment.this.lud.DM(PbFragment.this.ltR.dno());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
            PbFragment.this.ltR.s(fVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.n.m.bCu().bCv()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbFragment.this.ijR : j;
                if (PbFragment.this.fvq == 0) {
                    PbFragment.this.fvq = currentTimeMillis;
                }
                com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, PbFragment.this.fvg, PbFragment.this.createTime, PbFragment.this.fvq, z2, 0L, 0L, currentTimeMillis);
                PbFragment.this.createTime = 0L;
                PbFragment.this.fvg = 0L;
                if (iVar != null) {
                    iVar.bCr();
                }
                if (z2) {
                    iVar.fvz = currentTimeMillis;
                    iVar.kx(true);
                }
                if (!z2 && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null) {
                    int threadType = PbFragment.this.lpS.getPbData().dik().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.at.equals(PbFragment.this.ltB, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.at.equals(PbFragment.this.ltB, "from_frs")) {
                                com.baidu.tbadk.n.i iVar2 = new com.baidu.tbadk.n.i();
                                iVar2.setSubType(1000);
                                iVar2.fvB = currentTimeMillis;
                                iVar2.rK(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.n.d dVar = new com.baidu.tbadk.n.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.fvB = currentTimeMillis;
                        dVar.rK(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener luU = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbFragment.this.dkz();
            }
        }
    };
    private final a.InterfaceC0573a luV = new a.InterfaceC0573a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.48
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0573a
        public void d(boolean z, boolean z2, String str) {
            PbFragment.this.ltR.dnK();
            if (z) {
                if (PbFragment.this.ltP != null) {
                    PbFragment.this.ltP.iq(z2);
                }
                PbFragment.this.lpS.ux(z2);
                if (PbFragment.this.lpS.biv()) {
                    PbFragment.this.dkI();
                } else {
                    PbFragment.this.ltR.s(PbFragment.this.lpS.getPbData());
                }
                if (z2) {
                    if (PbFragment.this.ltP != null) {
                        if (PbFragment.this.ltP.biy() != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.lpS.getPbData().dik() != null && PbFragment.this.lpS.getPbData().dik().bmA() != null) {
                            MarkData biy = PbFragment.this.ltP.biy();
                            MetaData bmA = PbFragment.this.lpS.getPbData().dik().bmA();
                            if (biy != null && bmA != null) {
                                if (!com.baidu.tbadk.core.util.at.equals(TbadkCoreApplication.getCurrentAccount(), bmA.getUserId()) && !bmA.hadConcerned()) {
                                    PbFragment.this.b(bmA);
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
                    PbFragment.this.dkF();
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
            if (!PbFragment.this.FG(PbFragment.this.mLastScrollState) && PbFragment.this.FG(i)) {
                if (PbFragment.this.ltR != null) {
                    PbFragment.this.ltR.dob();
                    if (PbFragment.this.lud != null && !PbFragment.this.ltR.dnn()) {
                        PbFragment.this.ltR.uQ(PbFragment.this.lud.bAl());
                    }
                    if (!PbFragment.this.isFullScreen) {
                        PbFragment.this.ltR.dnm();
                    }
                }
                if (!PbFragment.this.ltu) {
                    PbFragment.this.ltu = true;
                    if (PbFragment.this.ltR != null) {
                        PbFragment.this.ltR.doh();
                    }
                }
            }
            if (PbFragment.this.ltR != null) {
                PbFragment.this.ltR.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.ltn != null) {
                PbFragment.this.ltn.onScrollStateChanged(absListView, i);
            }
            if (PbFragment.this.ltv == null) {
                PbFragment.this.ltv = new com.baidu.tbadk.n.b();
                PbFragment.this.ltv.setSubType(1001);
            }
            if (i == 0) {
                PbFragment.this.ltv.bCl();
            } else {
                PbFragment.this.ltv.bCk();
            }
            PbFragment.this.mLastScrollState = i;
            if (i == 0) {
                PbFragment.this.a(false, (PostData) null);
                com.baidu.tieba.s.c.dIX().b(PbFragment.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> dim;
            if (PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null && PbFragment.this.ltR != null && PbFragment.this.ltR.dnE() != null) {
                PbFragment.this.ltR.onScroll(absListView, i, i2, i3);
                if (PbFragment.this.ltn != null) {
                    PbFragment.this.ltn.onScroll(absListView, i, i2, i3);
                }
                if (PbFragment.this.lpS.dlV() && (dim = PbFragment.this.lpS.getPbData().dim()) != null && !dim.isEmpty()) {
                    int headerCount = ((i + i2) - PbFragment.this.ltR.dnE().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.f pbData = PbFragment.this.lpS.getPbData();
                    if (pbData != null) {
                        if (pbData.din() != null && pbData.din().hasData()) {
                            headerCount--;
                        }
                        if (pbData.dio() != null && pbData.dio().hasData()) {
                            headerCount--;
                        }
                        int size = dim.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d hYX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.53
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (PbFragment.this.isAdded()) {
                if (obj != null) {
                    switch (PbFragment.this.hYQ.getLoadDataMode()) {
                        case 0:
                            PbFragment.this.lpS.dlS();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar.lJk != 1002 || bVar.gQx) {
                                z = true;
                            }
                            PbFragment.this.a(bVar, z);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            PbFragment.this.ltR.a(1, dVar.QP, dVar.mZE, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment.this.a(PbFragment.this.hYQ.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            PbFragment.this.ltR.a(PbFragment.this.hYQ.getLoadDataMode(), gVar.QP, gVar.mZE, false);
                            PbFragment.this.ltR.bc(gVar.mZH);
                            return;
                        default:
                            return;
                    }
                }
                PbFragment.this.ltR.a(PbFragment.this.hYQ.getLoadDataMode(), false, (String) null, false);
            }
        }
    };
    private final c luW = new c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.55
    };
    private final f.c fUz = new f.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.57
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (PbFragment.this.dkN()) {
                PbFragment.this.ltl.finish();
            }
            if (!PbFragment.this.lpS.uw(true)) {
                PbFragment.this.ltR.dnL();
            } else {
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e luY = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.58
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbFragment.this.luX && PbFragment.this.dkN()) {
                PbFragment.this.dkP();
            }
            if (PbFragment.this.mIsLogin) {
                if (!PbFragment.this.ltM && PbFragment.this.ltR != null && PbFragment.this.ltR.doz() && PbFragment.this.lpS != null) {
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13999");
                    aqVar.dR("tid", PbFragment.this.lpS.dlx());
                    aqVar.dR("fid", PbFragment.this.lpS.getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    PbFragment.this.ltM = true;
                }
                if (PbFragment.this.lpS.uv(false)) {
                    PbFragment.this.ltR.dnJ();
                    TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbFragment.this.lpS.getPbData() != null) {
                    PbFragment.this.ltR.dog();
                }
                PbFragment.this.luX = true;
            }
        }
    };
    private int luZ = 0;
    private final TbRichTextView.i fFW = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.69
        /* JADX DEBUG: Multi-variable search result rejected for r6v12, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
        public void a(View view, String str, int i, boolean z, boolean z2) {
            g dnE;
            int i2;
            try {
                if ((view.getTag() instanceof TbRichText) && str == null) {
                    if (PbFragment.this.checkUpIsLogin()) {
                        PbFragment.this.ltR.b((TbRichText) view.getTag());
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12490"));
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13398");
                aqVar.dR("tid", PbFragment.this.lpS.dlx());
                aqVar.dR("fid", PbFragment.this.lpS.getForumId());
                aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar.al("obj_locate", 3);
                aqVar.al("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(aqVar);
                TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pic_pb", "");
                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                    if (PbFragment.this.lpS.lqP.diN()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        TbRichTextView tbRichTextView = null;
                        if (view.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view.getParent();
                        } else if ((view.getParent() instanceof GridImageLayout) && (view.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view.getParent().getParent();
                        }
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().bFJ() != null) {
                            ArrayList<TbRichTextImageInfo> bFJ = tbRichTextView.getRichText().bFJ();
                            int i4 = 0;
                            while (i4 < bFJ.size()) {
                                if (bFJ.get(i4) != null) {
                                    arrayList.add(bFJ.get(i4).getSrc());
                                    if (i3 == -1 && str != null && (str.equals(bFJ.get(i4).getSrc()) || str.equals(bFJ.get(i4).bGe()) || str.equals(bFJ.get(i4).bGb()) || str.equals(bFJ.get(i4).bGd()) || str.equals(bFJ.get(i4).bGh()))) {
                                        i3 = i4;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = bFJ.get(i4).getSrc();
                                    imageUrlData.originalUrl = bFJ.get(i4).getSrc();
                                    imageUrlData.isLongPic = bFJ.get(i4).bGj();
                                    concurrentHashMap.put(bFJ.get(i4).getSrc(), imageUrlData);
                                }
                                i4++;
                                i3 = i3;
                            }
                        }
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        PbFragment.this.g(rect);
                        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                        aVar.x(arrayList).nP(i3).ix(false).iy(PbFragment.this.lpS.dlP()).a(concurrentHashMap).iz(true).iA(false).iB(PbFragment.this.dkX()).a(rect, UtilHelper.fixedDrawableRect(rect, view));
                        if (PbFragment.this.lpS != null) {
                            aVar.AJ(PbFragment.this.lpS.getFromForumId());
                            if (PbFragment.this.lpS.getPbData() != null) {
                                aVar.s(PbFragment.this.lpS.getPbData().dik());
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
                    if (aVar2.lqb) {
                        TbRichText bz = PbFragment.this.bz(str, i);
                        if (bz != null && PbFragment.this.luZ >= 0 && PbFragment.this.luZ < bz.bFI().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String c2 = com.baidu.tieba.pb.data.g.c(bz.bFI().get(PbFragment.this.luZ));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= aVar2.lqa.size()) {
                                    break;
                                } else if (!aVar2.lqa.get(i6).equals(c2)) {
                                    i5 = i6 + 1;
                                } else {
                                    aVar2.index = i6;
                                    arrayList2.add(c2);
                                    break;
                                }
                            }
                            if (bz.getPostId() != 0 && (dnE = PbFragment.this.ltR.dnE()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.q> dataList = dnE.getDataList();
                                if (com.baidu.tbadk.core.util.y.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.q> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.q next = it.next();
                                        if ((next instanceof PostData) && bz.getPostId() == com.baidu.adp.lib.f.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bz.getPostId() != com.baidu.adp.lib.f.b.toLong(PbFragment.this.lpS.dme(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbFragment.this.lpS.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, aVar2.exw.get(str2));
                            }
                            Rect rect2 = new Rect();
                            view.getGlobalVisibleRect(rect2);
                            PbFragment.this.g(rect2);
                            ImageViewerConfig.a aVar3 = new ImageViewerConfig.a();
                            aVar3.x(arrayList2).AE(aVar2.forumName).AF(aVar2.forumId).AG(aVar2.threadId).ix(aVar2.exu).iz(true).AH(aVar2.lastId).iy(PbFragment.this.lpS.dlP()).a(concurrentHashMap2).iA(false).iB(PbFragment.this.dkX()).AI(aVar2.postId).a(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                            if (PbFragment.this.lpS != null) {
                                aVar3.AJ(PbFragment.this.lpS.getFromForumId());
                                if (PbFragment.this.lpS.getPbData() != null) {
                                    aVar3.s(PbFragment.this.lpS.getPbData().dik());
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
                    arrayList3.add(com.baidu.tbadk.core.util.y.getItem(aVar2.lqa, 0));
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                    if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, aVar2.exw.get(str3));
                    }
                    ImageViewerConfig.a aVar4 = new ImageViewerConfig.a();
                    aVar4.x(arrayList3).AE(aVar2.forumName).AF(aVar2.forumId).AG(aVar2.threadId).ix(aVar2.exu).iz(true).AH(aVar2.lqa.get(0)).iy(PbFragment.this.lpS.dlP()).a(concurrentHashMap3).iA(false).iB(PbFragment.this.dkX()).AI(aVar2.postId).iC(false);
                    if (PbFragment.this.lpS != null) {
                        aVar4.AJ(PbFragment.this.lpS.getFromForumId());
                        if (PbFragment.this.lpS.getPbData() != null) {
                            aVar4.s(PbFragment.this.lpS.getPbData().dik());
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
                PbFragment.this.ltF = view;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean lva = false;
    PostData jKP = null;
    private final b.InterfaceC0576b lvb = new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.70
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.jKP != null) {
                if (i == 0) {
                    PbFragment.this.jKP.fT(PbFragment.this.getPageContext().getPageActivity());
                    PbFragment.this.jKP = null;
                } else if (i == 1 && PbFragment.this.checkUpIsLogin()) {
                    PbFragment.this.n(PbFragment.this.jKP);
                }
            }
        }
    };
    private final b.InterfaceC0576b lvc = new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.71
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbFragment.this.lun != null && !TextUtils.isEmpty(PbFragment.this.luo)) {
                if (i == 0) {
                    if (PbFragment.this.lup == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbFragment.this.luo));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbFragment.this.luo;
                        aVar.pkgId = PbFragment.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbFragment.this.lup.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbFragment.this.mPermissionJudgement == null) {
                        PbFragment.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    PbFragment.this.mPermissionJudgement.clearRequestPermissionList();
                    PbFragment.this.mPermissionJudgement.appendRequestPermission(PbFragment.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbFragment.this.mPermissionJudgement.startRequestPermission(PbFragment.this.getPageContext().getPageActivity())) {
                        if (PbFragment.this.ewz == null) {
                            PbFragment.this.ewz = new bd(PbFragment.this.getPageContext());
                        }
                        PbFragment.this.ewz.j(PbFragment.this.luo, PbFragment.this.lun.getImageByte());
                    } else {
                        return;
                    }
                }
                PbFragment.this.lun = null;
                PbFragment.this.luo = null;
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
                if (PbFragment.this.ltR != null) {
                    if (!PbFragment.this.ltR.dlp()) {
                        PbFragment.this.ltR.doy();
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
                    if (PbFragment.this.dk(view)) {
                        if (view instanceof TbImageView) {
                            PbFragment.this.lun = ((TbImageView) view).getBdImage();
                            PbFragment.this.luo = ((TbImageView) view).getUrl();
                            if (PbFragment.this.lun == null || TextUtils.isEmpty(PbFragment.this.luo)) {
                                return true;
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lup = null;
                            } else {
                                PbFragment.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else if (view instanceof GifView) {
                            if (((GifView) view).getBdImage() != null) {
                                PbFragment.this.lun = ((GifView) view).getBdImage();
                                if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                    PbFragment.this.luo = ((GifView) view).getBdImage().getUrl();
                                }
                                if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    PbFragment.this.lup = null;
                                } else {
                                    PbFragment.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                                }
                            } else {
                                return true;
                            }
                        } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                            PbFragment.this.lun = ((TbMemeImageView) view).getBdImage();
                            if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                                PbFragment.this.luo = ((TbMemeImageView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbFragment.this.lup = null;
                            } else {
                                PbFragment.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            PbFragment.this.ltR.a(PbFragment.this.lvc, PbFragment.this.lun.isGif());
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
                PbFragment.this.jKP = (PostData) sparseArray2.get(R.id.tag_clip_board);
                if (PbFragment.this.jKP == null) {
                    return true;
                }
                if (PbFragment.this.jKP.dJZ() != 1 || !PbFragment.this.dk(view)) {
                    if (PbFragment.this.ltP != null) {
                        if (!PbFragment.this.ltP.biv() || PbFragment.this.jKP.getId() == null || !PbFragment.this.jKP.getId().equals(PbFragment.this.lpS.bmI())) {
                            z = false;
                        } else {
                            z = true;
                        }
                        boolean z3 = PbFragment.this.djz().getPbData() != null && PbFragment.this.djz().getPbData().diN();
                        if (PbFragment.this.jKP.dJZ() != 1) {
                            if (PbFragment.this.ltW == null) {
                                PbFragment.this.ltW = new com.baidu.tbadk.core.dialog.k(PbFragment.this.getContext());
                                PbFragment.this.ltW.a(PbFragment.this.luO);
                            }
                            ArrayList arrayList = new ArrayList();
                            if (view != null && sparseArray2 != null) {
                                boolean z4 = PbFragment.this.dk(view) && !z3;
                                boolean z5 = (!PbFragment.this.dk(view) || PbFragment.this.lun == null || PbFragment.this.lun.isGif()) ? false : true;
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
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbFragment.this.getString(R.string.save_to_emotion), PbFragment.this.ltW));
                                }
                                if (z5) {
                                    arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbFragment.this.getString(R.string.save_to_local), PbFragment.this.ltW));
                                }
                                if (!z4 && !z5) {
                                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(3, PbFragment.this.getString(R.string.copy), PbFragment.this.ltW);
                                    SparseArray sparseArray3 = new SparseArray();
                                    sparseArray3.put(R.id.tag_clip_board, PbFragment.this.jKP);
                                    gVar3.mTextView.setTag(sparseArray3);
                                    arrayList.add(gVar3);
                                }
                                if (!z2 && !z3) {
                                    if (z) {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.remove_mark), PbFragment.this.ltW);
                                    } else {
                                        gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbFragment.this.getString(R.string.mark), PbFragment.this.ltW);
                                    }
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(R.id.tag_clip_board, PbFragment.this.jKP);
                                    sparseArray4.put(R.id.tag_is_subpb, false);
                                    gVar2.mTextView.setTag(sparseArray4);
                                    arrayList.add(gVar2);
                                }
                                if (PbFragment.this.mIsLogin && !PbFragment.this.lrn) {
                                    if (!z8 && z7) {
                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.mute_option), PbFragment.this.ltW);
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
                                        if ((PbFragment.this.uj(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
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
                                            gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
                                            gVar6.mTextView.setTag(sparseArray6);
                                        } else {
                                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                                        }
                                        gVar = new com.baidu.tbadk.core.dialog.g(7, PbFragment.this.getString(R.string.bar_manager), PbFragment.this.ltW);
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
                                            if (PbFragment.this.lpS.getPbData().diz() == 1002 && !z6) {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.report_text), PbFragment.this.ltW);
                                            } else {
                                                gVar6 = new com.baidu.tbadk.core.dialog.g(6, PbFragment.this.getString(R.string.delete), PbFragment.this.ltW);
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
                                PbFragment.this.ltW.br(arrayList);
                                PbFragment.this.ltV = new com.baidu.tbadk.core.dialog.i(PbFragment.this.getPageContext(), PbFragment.this.ltW);
                                PbFragment.this.ltV.Qj();
                                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13272").dR("tid", PbFragment.this.lpS.lxd).dR("fid", PbFragment.this.lpS.getForumId()).dR("uid", PbFragment.this.lpS.getPbData().dik().bmA().getUserId()).dR("post_id", PbFragment.this.lpS.bzZ()).al("obj_source", z2 ? 2 : 1));
                            }
                            return true;
                        }
                        if (!z3) {
                            PbFragment.this.ltR.a(PbFragment.this.lvb, z, false);
                        }
                        return true;
                    }
                    return true;
                }
                PbFragment.this.ltR.a(PbFragment.this.lvc, PbFragment.this.lun.isGif());
                return true;
            }
            return true;
        }
    };
    private final NoNetworkView.a iEz = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.73
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbFragment.this.bFd && z && !PbFragment.this.lpS.dlF()) {
                PbFragment.this.dkK();
            }
            PbFragment.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.75
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbFragment.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbFragment.this.iMk.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0719a igd = new a.InterfaceC0719a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.76
        final int gQd = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void H(int i, int i2) {
            if (av(i2) && PbFragment.this.ltR != null && PbFragment.this.ltn != null) {
                PbFragment.this.ltn.pN(true);
                if (Math.abs(i2) > this.gQd) {
                    PbFragment.this.ltn.hideFloatingView();
                }
                if (PbFragment.this.dkN()) {
                    PbFragment.this.ltR.dnB();
                    PbFragment.this.ltR.dnC();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void I(int i, int i2) {
            if (av(i2) && PbFragment.this.ltR != null && PbFragment.this.ltn != null) {
                PbFragment.this.ltR.dom();
                PbFragment.this.ltn.pN(false);
                PbFragment.this.ltn.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void J(int i, int i2) {
        }

        private boolean av(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private final q.a lsp = new q.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.79
        @Override // com.baidu.tieba.pb.pb.main.q.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbFragment.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbFragment.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbFragment.this.ltR.PP(str);
            } else {
                PbFragment.this.showToast(str);
            }
        }
    };
    private int lve = -1;
    private int lvf = -1;

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

    public com.baidu.tbadk.editortools.pb.e dkk() {
        return this.lud;
    }

    public void b(com.baidu.tieba.pb.data.p pVar) {
        boolean z;
        MetaData metaData;
        if (pVar.dja() != null) {
            String id = pVar.dja().getId();
            ArrayList<PostData> dim = this.lpS.getPbData().dim();
            int i = 0;
            while (true) {
                if (i >= dim.size()) {
                    z = true;
                    break;
                }
                PostData postData = dim.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dji = pVar.dji();
                    postData.JC(pVar.getTotalCount());
                    if (postData.dJW() == null || dji == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dji.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bmA() != null && (metaData = postData.getUserMap().get(next.bmA().getUserId())) != null) {
                                next.a(metaData);
                                next.xu(true);
                                next.a(getPageContext(), this.lpS.PG(metaData.getUserId()));
                            }
                        }
                        z = dji.size() != postData.dJW().size();
                        if (postData.dJW() != null && postData.dJW().size() < 2) {
                            postData.dJW().clear();
                            postData.dJW().addAll(dji);
                        }
                    }
                    if (postData.dJS() != null) {
                        postData.dJT();
                    }
                }
            }
            if (!this.lpS.getIsFromMark() && z) {
                this.ltR.s(this.lpS.getPbData());
            }
            if (z) {
                c(pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Py(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.n diC = this.lpS.getPbData().diC();
            if (diC != null && str.equals(diC.getAdId())) {
                if (diC.dJN() != null) {
                    diC.dJN().legoCard = null;
                }
                this.lpS.getPbData().diD();
            }
            com.baidu.tieba.tbadkCore.data.n dlL = this.lpS.dlL();
            if (dlL != null && str.equals(dlL.getAdId())) {
                this.lpS.dlM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.ltV != null && this.ltV.isShowing()) {
                this.ltV.dismiss();
                this.ltV = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(getContext());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbFragment.this.ltV != null) {
                            PbFragment.this.ltV.dismiss();
                        }
                        if (i == 0) {
                            PbFragment.this.ltR.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbFragment.this.lul);
                            userMuteAddAndDelCustomMessage.setTag(PbFragment.this.lul);
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
                kVar.br(arrayList);
                this.ltV = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.ltV.Qj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        bw dik;
        if (this.lpS != null && this.lpS.getPbData() != null && (dik = this.lpS.getPbData().dik()) != null) {
            if (i == 1) {
                PraiseData bml = dik.bml();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (bml == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        dik.a(praiseData);
                    } else {
                        dik.bml().getUser().add(0, metaData);
                        dik.bml().setNum(dik.bml().getNum() + 1);
                        dik.bml().setIsLike(i);
                    }
                }
                if (dik.bml() != null) {
                    if (dik.bml().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.at.numFormatOver10000(dik.bml().getNum());
                    }
                }
            } else if (dik.bml() != null) {
                dik.bml().setIsLike(i);
                dik.bml().setNum(dik.bml().getNum() - 1);
                ArrayList<MetaData> user = dik.bml().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            dik.bml().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (dik.bml().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = dik.bml().getNum() + "";
                }
            }
            if (this.lpS.dlz()) {
                this.ltR.dnE().notifyDataSetChanged();
            } else {
                this.ltR.t(this.lpS.getPbData());
            }
        }
    }

    public static PbFragment dkl() {
        return new PbFragment();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ltl = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.lpS.aC(bundle);
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.lud.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.ltt = System.currentTimeMillis();
        this.luj = getPageContext();
        final Intent intent = this.ltl.getIntent();
        if (intent != null) {
            this.ijR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.ltB = intent.getStringExtra("from");
            if (intent.getData() != null) {
                Uri data = intent.getData();
                if (StringUtils.isNull(this.ltB)) {
                    this.ltB = data.getQueryParameter("from");
                }
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.ltB)) {
                this.lto = true;
            }
            this.lve = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.lvf = intent.getIntExtra("key_manga_next_chapter", -1);
            this.lvg = intent.getStringExtra("key_manga_title");
            this.ltY = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.ltZ = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.lua = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (dkN()) {
                this.ltl.setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.at.isEmpty(this.source) ? "" : this.source;
            this.lur = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.ltK = new bf();
            this.ltK.C(intent);
            this.lut = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
            if (this.lut == 0) {
                this.lut = intent.getIntExtra("key_start_from", 0);
            }
            this.luu = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
        } else {
            this.ijR = System.currentTimeMillis();
        }
        this.fvg = this.ltt - this.ijR;
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        this.ltq = 0;
        aB(bundle);
        if (this.lpS.getPbData() != null) {
            this.lpS.getPbData().Ps(this.source);
        }
        dko();
        if (intent != null && this.ltR != null) {
            this.ltR.lAV = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.lum == null) {
                    this.lum = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            PbFragment.this.ltR.PR(UgcConstant.AT_RULE_TAG + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.lum, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.lpS.getPbData() != null) {
                this.lpS.PJ(stringExtra);
            }
        }
        this.iHo = new VoiceManager();
        this.iHo.onCreate(getPageContext());
        initData(bundle);
        this.luc = new com.baidu.tbadk.editortools.pb.g();
        d(this.luc);
        this.lud = (com.baidu.tbadk.editortools.pb.e) this.luc.ei(getActivity());
        this.lud.a(this.ltl.getPageContext());
        this.lud.a(this.fpW);
        this.lud.a(this.fpP);
        this.lud.setFrom(1);
        this.lud.a(this.ltl.getPageContext(), bundle);
        this.lud.bzx().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.lud.bzx().kb(true);
        uh(true);
        this.lud.a(this.lpS.dlN(), this.lpS.dlx(), this.lpS.dme());
        registerListener(this.luz);
        if (!this.lpS.dlE()) {
            this.lud.DO(this.lpS.dlx());
        }
        if (this.lpS.dmf()) {
            this.lud.DM(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.ltR != null) {
            this.lud.DM(this.ltR.dno());
        }
        registerListener(this.luy);
        registerListener(this.luA);
        registerListener(this.luB);
        registerListener(this.iIU);
        registerListener(this.luN);
        registerListener(this.lux);
        this.lub = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.mWq);
        this.lub.dJF();
        registerListener(this.luC);
        registerListener(this.eNv);
        this.lpS.dlX();
        registerListener(this.luU);
        registerListener(this.iJc);
        registerListener(this.luQ);
        if (this.ltR != null && this.ltR.doq() != null && this.ltR.dor() != null) {
            this.ltn = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.ltR.doq(), this.ltR.dor(), this.ltR.dnv());
            this.ltn.a(this.luI);
        }
        if (this.ltm && this.ltR != null && this.ltR.dor() != null) {
            this.ltR.dor().setVisibility(8);
        }
        this.luk = new com.baidu.tbadk.core.view.c();
        this.luk.toastTime = 1000L;
        registerListener(this.luM);
        registerListener(this.luK);
        registerListener(this.luL);
        registerListener(this.jbQ);
        registerListener(this.iIQ);
        this.luD.setSelfListener(true);
        this.luD.setTag(this.ltl.getUniqueId());
        this.luD.setPriority(-1);
        MessageManager.getInstance().registerListener(this.luD);
        registerResponsedEventListener(TipEvent.class, this.iGs);
        this.lul = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lul;
        userMuteAddAndDelCustomMessage.setTag(this.lul);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lul;
        userMuteCheckCustomMessage.setTag(this.lul);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.lpS.dmc().a(this.luJ);
        this.kzD = new bb();
        if (this.lud.bAd() != null) {
            this.kzD.e(this.lud.bAd().getInputView());
        }
        this.lud.a(this.fpQ);
        this.jaw = new ShareSuccessReplyToServerModel();
        a(this.luv);
        this.kvy = new com.baidu.tbadk.core.util.am(getPageContext());
        this.kvy.a(new am.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.22
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.am.eNm) {
                        PbFragment.this.lud.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.am.eNn && PbFragment.this.ltR != null && PbFragment.this.ltR.dnk() != null && PbFragment.this.ltR.dnk().dkj() != null) {
                        PbFragment.this.ltR.dnk().dkj().bAB();
                    } else if (i == com.baidu.tbadk.core.util.am.eNo) {
                        PbFragment.this.c(PbFragment.this.lug);
                    }
                }
            }
        });
        this.ltO = new com.baidu.tieba.pb.pb.report.a(getContext());
        this.ltO.w(getUniqueId());
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        com.baidu.tbadk.core.business.a.bjT().dF("3", "");
        this.hYS = new com.baidu.tieba.callfans.a(getPageContext());
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.ltt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.editortools.pb.g gVar) {
        if (gVar != null && this.lpS != null) {
            gVar.setForumName(this.lpS.djr());
            if (this.lpS.getPbData() != null && this.lpS.getPbData().getForum() != null) {
                gVar.a(this.lpS.getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(this.lpS);
        }
    }

    public String dkm() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b dkn() {
        return this.ltn;
    }

    private void uh(boolean z) {
        this.lud.ki(z);
        this.lud.kj(z);
        this.lud.kk(z);
    }

    private void dko() {
        this.eZA = new LikeModel(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    public az dkp() {
        return this.ltR;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel djz() {
        return this.lpS;
    }

    public void Pz(String str) {
        if (this.lpS != null && !StringUtils.isNull(str) && this.ltR != null) {
            this.ltR.uV(true);
            this.lpS.Pz(str);
            this.ltz = true;
            this.ltR.dob();
            this.ltR.dol();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.bFd = false;
        } else {
            this.bFd = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.ltq = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.ltq == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        if (this.ltR != null) {
            this.ltR.onPause();
        }
        if (!this.lpS.dlE()) {
            this.lud.DN(this.lpS.dlx());
        }
        if (this.lpS != null) {
            this.lpS.dlY();
        }
        com.baidu.tbadk.BdToken.c.bgf().bgq();
        MessageManager.getInstance().unRegisterListener(this.jWO);
        cMB();
        MessageManager.getInstance().unRegisterListener(this.luK);
        MessageManager.getInstance().unRegisterListener(this.luL);
        MessageManager.getInstance().unRegisterListener(this.luM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean dkq() {
        PostData a2 = com.baidu.tieba.pb.data.g.a(this.lpS.getPbData(), this.lpS.dlz(), this.lpS.dlW());
        return (a2 == null || a2.bmA() == null || a2.bmA().getGodUserData() == null || a2.bmA().getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        this.bFd = false;
        super.onResume();
        if (this.ltD) {
            this.ltD = false;
            dkT();
        }
        if (dkq()) {
            this.ltw = System.currentTimeMillis();
        } else {
            this.ltw = -1L;
        }
        if (this.ltR != null && this.ltR.getView() != null) {
            if (!this.kPp) {
                dkL();
            } else {
                hideLoadingView(this.ltR.getView());
            }
            this.ltR.onResume();
        }
        if (this.ltq == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.ltR != null) {
            noNetworkView = this.ltR.dnh();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        registerListener(this.jWO);
        this.ltX = false;
        dkS();
        registerListener(this.luK);
        registerListener(this.luL);
        registerListener(this.luM);
        if (this.iId) {
            dkK();
            this.iId = false;
        }
        dla();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ltR.uK(z);
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
        if (z && this.ltX) {
            this.ltR.dnJ();
            this.lpS.uv(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ltw > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10804").dR("obj_duration", (System.currentTimeMillis() - this.ltw) + ""));
            this.ltw = 0L;
        }
        if (dkp().dnk() != null) {
            dkp().dnk().onStop();
        }
        if (this.ltR.lAX != null && !this.ltR.lAX.dpk()) {
            this.ltR.lAX.releaseResources();
        }
        if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().getForum() != null && this.lpS.getPbData().dik() != null) {
            com.baidu.tbadk.distribute.a.bzk().b(getPageContext().getPageActivity(), "pb", this.lpS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lpS.getPbData().dik().getId(), 0L));
        }
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MessageManager.getInstance().unRegisterListener(this.ltL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13266");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("fid", this.lpS.getPbData().getForumId());
            aqVar.dR("tid", this.lpS.dlx());
            aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(aqVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.ltu && this.ltR != null) {
            this.ltu = true;
            this.ltR.doh();
            a(false, (PostData) null);
        }
        if (this.lpS != null) {
            this.lpS.cancelLoadData();
            this.lpS.destory();
            if (this.lpS.dmb() != null) {
                this.lpS.dmb().onDestroy();
            }
        }
        if (this.lud != null) {
            this.lud.onDestroy();
        }
        if (this.hYQ != null) {
            this.hYQ.cancelLoadData();
        }
        if (this.eZA != null) {
            this.eZA.dJs();
        }
        if (this.ltR != null) {
            this.ltR.onDestroy();
            if (this.ltR.lAX != null) {
                this.ltR.lAX.releaseResources();
            }
        }
        if (this.ltv != null) {
            this.ltv.bCm();
        }
        if (this.ltn != null) {
            this.ltn.cAC();
        }
        super.onDestroy();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        if (this.ltR != null) {
            this.ltR.dob();
        }
        MessageManager.getInstance().unRegisterListener(this.luK);
        MessageManager.getInstance().unRegisterListener(this.luL);
        MessageManager.getInstance().unRegisterListener(this.luM);
        MessageManager.getInstance().unRegisterListener(this.lul);
        MessageManager.getInstance().unRegisterListener(this.luN);
        MessageManager.getInstance().unRegisterListener(this.iJc);
        MessageManager.getInstance().unRegisterListener(this.jbQ);
        MessageManager.getInstance().unRegisterListener(this.luS);
        MessageManager.getInstance().unRegisterListener(this.luD);
        this.luj = null;
        this.luk = null;
        com.baidu.tieba.recapp.d.a.dBc().dBf();
        if (this.lum != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lum);
        }
        if (this.ltE != null) {
            this.ltE.cancelLoadData();
        }
        if (this.ltR != null && this.ltR.lAX != null) {
            this.ltR.lAX.dpn();
        }
        if (this.jaw != null) {
            this.jaw.cancelLoadData();
        }
        this.kzD.onDestroy();
        if (this.lpS != null && this.lpS.dmd() != null) {
            this.lpS.dmd().onDestroy();
        }
        if (this.kvy != null) {
            this.kvy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        g dnE;
        ArrayList<PostData> djV;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.bup() && this.ltR != null && (dnE = this.ltR.dnE()) != null && (djV = dnE.djV()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = djV.iterator();
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
                        bVar.iaT = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.eFh == 1 && !TextUtils.isEmpty(id)) {
                    next.eFh = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.iaT = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.lpS == null || this.lpS.getPbData() == null || this.lpS.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.lpS.getPbData().getForum().getFirst_class();
                    str2 = this.lpS.getPbData().getForum().getSecond_class();
                    str = this.lpS.getPbData().getForum().getId();
                    str4 = this.lpS.dlx();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.bus());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.ltR.onChangeSkinType(i);
            if (this.lud != null && this.lud.bzx() != null) {
                this.lud.bzx().onChangeSkinType(i);
            }
            if (this.ltR.dnh() != null) {
                this.ltR.dnh().onChangeSkinType(getPageContext(), i);
            }
            this.kzD.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.ap.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
            cyK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ltR = new az(this, this.iKb, this.fhK);
        this.iMk = new com.baidu.tieba.f.b(getActivity());
        this.iMk.a(lvd);
        this.iMk.a(this.igd);
        this.ltR.setOnScrollListener(this.mOnScrollListener);
        this.ltR.d(this.luY);
        this.ltR.setListPullRefreshListener(this.fUz);
        this.ltR.tT(com.baidu.tbadk.core.k.bjH().isShowImages());
        this.ltR.setOnImageClickListener(this.fFW);
        this.ltR.b(this.mOnLongClickListener);
        this.ltR.g(this.iEz);
        this.ltR.a(this.luW);
        this.ltR.uK(this.mIsLogin);
        if (this.ltl.getIntent() != null) {
            this.ltR.uW(this.ltl.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.ltR.dnj().setFromForumId(this.lpS.getFromForumId());
        this.ltR.setEditorTools(this.lud.bzx());
        this.lud.DM(this.ltR.dno());
        this.ltR.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.25
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbFragment.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbFragment.this.lpS.getPbData().getUserData().getUserId());
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
                PbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpS.getPbData().getForum().getId(), PbFragment.this.lpS.getPbData().getForum().getName(), PbFragment.this.lpS.getPbData().dik().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.ltR.uX(this.lpS.dlC());
        this.ltR.Gc(this.lpS.dmh());
        return this.ltR.getView();
    }

    public void dkr() {
        if (this.ltR != null && this.lpS != null) {
            if ((this.lpS.getPbData() != null || this.lpS.getPbData().diJ() != null) && checkUpIsLogin() && this.ltR.dnE() != null && this.ltR.dnE().dka() != null) {
                this.ltR.dnE().dka().Cu(this.lpS.dlx());
            }
        }
    }

    public void dks() {
        TiebaStatic.log("c12181");
        if (this.ltR != null && this.lpS != null) {
            if ((this.ltR == null || this.ltR.dnn()) && this.lpS.getPbData() != null && this.lpS.getPbData().diJ() != null) {
                com.baidu.tieba.pb.data.o diJ = this.lpS.getPbData().diJ();
                if (checkUpIsLogin()) {
                    if ((!diJ.djc() || diJ.bob() != 2) && this.ltR.dnE() != null && this.ltR.dnE().dka() != null) {
                        this.ltR.dnE().dka().Cu(this.lpS.dlx());
                    }
                    if (System.currentTimeMillis() - this.lty > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).vF(false);
                        this.lty = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean di(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.eDR && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bjH().isShowImages()) {
                    return PC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.lpS == null || this.lpS.getPbData() == null) {
                        return true;
                    }
                    if (dkp().dnk() != null) {
                        dkp().dnk().dkf();
                    }
                    com.baidu.tieba.pb.data.p pVar = new com.baidu.tieba.pb.data.p();
                    pVar.a(this.lpS.getPbData().getForum());
                    pVar.setThreadData(this.lpS.getPbData().dik());
                    pVar.g(postData);
                    dkp().dnj().d(pVar);
                    dkp().dnj().setPostId(postData.getId());
                    a(view, postData.bmA().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lud != null) {
                        this.ltR.uQ(this.lud.bAl());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private void dkt() {
        if (this.lts == null) {
            this.lts = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.lts.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.27
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbFragment.this.lpO = PbFragment.this.lpO.trim();
                        UtilHelper.callPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpO);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lpS.dlx(), PbFragment.this.lpO, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbFragment.this.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        PbFragment.this.lpO = PbFragment.this.lpO.trim();
                        UtilHelper.smsPhone(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpO);
                        new com.baidu.tieba.pb.pb.main.b(PbFragment.this.lpS.dlx(), PbFragment.this.lpO, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbFragment.this.lpO = PbFragment.this.lpO.trim();
                        UtilHelper.startBaiDuBar(PbFragment.this.getPageContext().getPageActivity(), PbFragment.this.lpO);
                        bVar.dismiss();
                    }
                }
            }).oC(b.a.BOTTOM_TO_TOP).oD(17).d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        this.luT.a(true, 0, 3, 0, ((com.baidu.tieba.pb.videopb.e) android.arch.lifecycle.y.b(getActivity()).l(com.baidu.tieba.pb.videopb.e.class)).drn(), "", 1);
    }

    private void aB(Bundle bundle) {
        this.lpS = this.ltl.djz();
        if (this.lpS.dma() != null) {
            this.lpS.dma().a(this.lsp);
        }
        if (this.lpS.dmb() != null) {
            this.lpS.dmb().b(this.luw);
        }
        if (StringUtils.isNull(this.lpS.dlx())) {
            this.ltl.finish();
        } else if ("from_tieba_kuang".equals(this.ltB) && this.ltB != null) {
            this.lpS.Gc(6);
        }
    }

    private void initData(Bundle bundle) {
        this.ltP = com.baidu.tbadk.baseEditMark.a.a(this.ltl);
        if (this.ltP != null) {
            this.ltP.a(this.luV);
        }
        this.hYQ = new ForumManageModel(this.ltl);
        this.hYQ.setLoadDataCallBack(this.hYX);
        this.eNr = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.luH.setUniqueId(getUniqueId());
        this.luH.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ltR.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lul;
        userMuteCheckCustomMessage.setTag(this.lul);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    private boolean dku() {
        if (this.lpS == null || this.lpS.getPbData() == null) {
            return false;
        }
        bw dik = this.lpS.getPbData().dik();
        this.lpS.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dik);
    }

    public void dkv() {
        if (checkUpIsLogin() && this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().getForum() != null && !dku()) {
            if (this.lpS.getPbData().diN()) {
                this.ltR.cMc();
                return;
            }
            if (this.iLK == null) {
                this.iLK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iLK.Ac(0);
                this.iLK.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.36
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pI(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void C(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void pJ(boolean z) {
                        if (z) {
                            if (PbFragment.this.lud != null && PbFragment.this.lud.bzx() != null) {
                                PbFragment.this.lud.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            PbFragment.this.ltR.cMc();
                        }
                    }
                });
            }
            this.iLK.G(this.lpS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lpS.dlx(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dkw() {
        com.baidu.tieba.pb.data.f pbData;
        if (this.lpS == null || (pbData = this.lpS.getPbData()) == null) {
            return null;
        }
        return pbData.diy().forum_top_list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dik() != null) {
            if (fVar.dik().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dik().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dik().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dku() && dkx()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.ltG);
                this.ltH = ((View) view.getParent()).getMeasuredHeight();
            }
            if (dkp().dnk() != null && postData != null) {
                String str3 = "";
                if (postData.dKb() != null) {
                    str3 = postData.dKb().toString();
                }
                dkp().dnk().Px(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bmA().getName_show(), str3));
            }
            if (this.lpS.getPbData() != null && this.lpS.getPbData().diN()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbFragment.this.ltl.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbFragment.this.dkp().getListView().smoothScrollBy((PbFragment.this.ltG[1] + PbFragment.this.ltH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dkp().dnk() != null) {
                            PbFragment.this.lud.bzx().setVisibility(8);
                            PbFragment.this.dkp().dnk().h(str, str2, PbFragment.this.dkp().dno(), (PbFragment.this.lpS == null || PbFragment.this.lpS.getPbData() == null || PbFragment.this.lpS.getPbData().dik() == null || !PbFragment.this.lpS.getPbData().dik().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkj = PbFragment.this.dkp().dnk().dkj();
                            if (dkj != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                dkj.a(PbFragment.this.lpS.getPbData().getAnti());
                                dkj.setThreadData(PbFragment.this.lpS.getPbData().dik());
                            }
                            if (PbFragment.this.kzD.doE() == null && PbFragment.this.dkp().dnk().dkj().bAJ() != null) {
                                PbFragment.this.dkp().dnk().dkj().bAJ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.38.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.doD() != null) {
                                            if (!PbFragment.this.kzD.doD().dSW()) {
                                                PbFragment.this.kzD.uZ(false);
                                            }
                                            PbFragment.this.kzD.doD().yq(false);
                                        }
                                    }
                                });
                                PbFragment.this.kzD.f(PbFragment.this.dkp().dnk().dkj().bAJ().getInputView());
                                PbFragment.this.dkp().dnk().dkj().a(PbFragment.this.lui);
                            }
                        }
                        PbFragment.this.dkp().dol();
                    }
                }, 0L);
                return;
            }
            if (this.luf == null) {
                this.luf = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.luf.Ac(1);
                this.luf.a(new AnonymousClass39(str, str2));
            }
            if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().getForum() != null) {
                this.luf.G(this.lpS.getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(this.lpS.dlx(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$39  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass39 implements c.a {
        final /* synthetic */ String lvn;
        final /* synthetic */ String lvo;

        AnonymousClass39(String str, String str2) {
            this.lvn = str;
            this.lvo = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pI(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pJ(boolean z) {
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
                        PbFragment.this.dkp().getListView().smoothScrollBy((PbFragment.this.ltG[1] + PbFragment.this.ltH) - (equipmentHeight - dimens), 50);
                        if (PbFragment.this.dkp().dnk() != null) {
                            PbFragment.this.lud.bzx().setVisibility(8);
                            PbFragment.this.dkp().dnk().h(AnonymousClass39.this.lvn, AnonymousClass39.this.lvo, PbFragment.this.dkp().dno(), (PbFragment.this.lpS == null || PbFragment.this.lpS.getPbData() == null || PbFragment.this.lpS.getPbData().dik() == null || !PbFragment.this.lpS.getPbData().dik().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dkj = PbFragment.this.dkp().dnk().dkj();
                            if (dkj != null && PbFragment.this.lpS != null && PbFragment.this.lpS.getPbData() != null) {
                                dkj.a(PbFragment.this.lpS.getPbData().getAnti());
                                dkj.setThreadData(PbFragment.this.lpS.getPbData().dik());
                            }
                            if (PbFragment.this.kzD.doE() == null && PbFragment.this.dkp().dnk().dkj().bAJ() != null) {
                                PbFragment.this.dkp().dnk().dkj().bAJ().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.39.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbFragment.this.kzD != null && PbFragment.this.kzD.doD() != null) {
                                            if (!PbFragment.this.kzD.doD().dSW()) {
                                                PbFragment.this.kzD.uZ(false);
                                            }
                                            PbFragment.this.kzD.doD().yq(false);
                                        }
                                    }
                                });
                                PbFragment.this.kzD.f(PbFragment.this.dkp().dnk().dkj().bAJ().getInputView());
                                PbFragment.this.dkp().dnk().dkj().a(PbFragment.this.lui);
                            }
                        }
                        PbFragment.this.dkp().dol();
                    }
                }, 0L);
            }
        }
    }

    public boolean dkx() {
        if ((this.lpS.getPbData() != null && this.lpS.getPbData().diN()) || this.kvy == null || this.lpS.getPbData() == null || this.lpS.getPbData().getAnti() == null) {
            return true;
        }
        return this.kvy.oT(this.lpS.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean FP(int i) {
        if (this.kvy == null || this.lpS.getPbData() == null || this.lpS.getPbData().getAnti() == null) {
            return true;
        }
        return this.kvy.aN(this.lpS.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, boolean z) {
        if (postData != null && this.lpS != null && this.lpS.getPbData() != null && postData.dJZ() != 1) {
            String dlx = this.lpS.dlx();
            String id = postData.getId();
            int i = 0;
            if (this.lpS.getPbData() != null) {
                i = this.lpS.getPbData().diz();
            }
            PbActivity.a PD = PD(id);
            if (PD != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dlx, id, "pb", true, null, false, null, i, postData.dqh(), this.lpS.getPbData().getAnti(), false, postData.bmA() != null ? postData.bmA().getIconInfo() : null).addBigImageData(PD.lqa, PD.exw, PD.exu, PD.index);
                addBigImageData.setKeyPageStartFrom(this.lpS.dmh());
                addBigImageData.setFromFrsForumId(this.lpS.getFromForumId());
                addBigImageData.setKeyFromForumId(this.lpS.getForumId());
                addBigImageData.setBjhData(this.lpS.dlG());
                addBigImageData.setIsOpenEditor(z);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dky() {
        if (this.lpS.getPbData() == null || this.lpS.getPbData().dik() == null) {
            return -1;
        }
        return this.lpS.getPbData().dik().bnn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (PbReplySwitch.getInOn() && djz() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
            djz().PI(postWriteCallBackData.getPostId());
            this.luq = this.ltR.dnq();
            this.lpS.db(this.luq, this.ltR.dnr());
        }
        this.ltR.dob();
        this.kzD.doB();
        if (this.lud != null) {
            this.ltR.uQ(this.lud.bAl());
        }
        this.ltR.dni();
        this.ltR.uS(true);
        this.lpS.dlS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(boolean z) {
        if (this.lpS != null && this.lpS.lqP != null && this.lpS.lqP.dik() != null) {
            bw dik = this.lpS.lqP.dik();
            dik.mRecomAbTag = this.lpS.dms();
            dik.mRecomWeight = this.lpS.dmq();
            dik.mRecomSource = this.lpS.dmr();
            dik.mRecomExtra = this.lpS.dmt();
            if (dik.getFid() == 0) {
                dik.setFid(com.baidu.adp.lib.f.b.toLong(this.lpS.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dik, "c13563");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
            }
            if (a2 != null) {
                a2.al("reply_type", 1);
                if (z) {
                    a2.al("obj_type", 2);
                } else {
                    a2.al("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkz() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Sb(this.lpS.getForumId()) && this.lpS.getPbData() != null && this.lpS.getPbData().getForum() != null) {
            if (this.lpS.getPbData().getForum().isLike() == 1) {
                this.lpS.dmd().gi(this.lpS.getForumId(), this.lpS.dlx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(boolean z) {
        if (this.lpS == null || this.lpS.getPbData() == null) {
            return false;
        }
        return ((this.lpS.getPbData().diz() != 0) || this.lpS.getPbData().dik() == null || this.lpS.getPbData().dik().bmA() == null || TextUtils.equals(this.lpS.getPbData().dik().bmA().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    private boolean uk(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ab abVar;
        if (this.lpS == null || this.lpS.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.lpS.getPbData();
        bw dik = pbData.dik();
        if (dik != null) {
            if (dik.bli() || dik.blj()) {
                return false;
            }
            if (dik.bov() || dik.bow()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.diz() != 0) {
                return pbData.diz() != 3;
            }
            List<bs> diH = pbData.diH();
            if (com.baidu.tbadk.core.util.y.getCount(diH) > 0) {
                for (bs bsVar : diH) {
                    if (bsVar != null && (abVar = bsVar.eDc) != null && abVar.eAP && !abVar.eAQ && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean ul(boolean z) {
        if (z || this.lpS == null || this.lpS.getPbData() == null) {
            return false;
        }
        return ((this.lpS.getPbData().getForum() != null && this.lpS.getPbData().getForum().isBlockBawuDelete) || this.lpS.getPbData().diz() == 0 || this.lpS.getPbData().diz() == 3) ? false : true;
    }

    public void dkA() {
        com.baidu.tieba.pb.data.f pbData;
        bw dik;
        boolean z = true;
        if (this.lpS != null && this.lpS.getPbData() != null && (dik = (pbData = this.lpS.getPbData()).dik()) != null && dik.bmA() != null) {
            this.ltR.dni();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dik.bmA().getUserId());
            ak akVar = new ak();
            int diz = this.lpS.getPbData().diz();
            if (diz == 1 || diz == 3) {
                akVar.lzl = true;
                akVar.lzk = true;
                akVar.lzq = dik.bmv() == 1;
                akVar.lzp = dik.bmw() == 1;
            } else {
                akVar.lzl = false;
                akVar.lzk = false;
            }
            if (diz == 1002 && !equals) {
                akVar.lzr = true;
            }
            akVar.lzi = uk(equals);
            akVar.lzm = dkB();
            akVar.lzj = ul(equals);
            akVar.Fc = this.lpS.dlz();
            akVar.lzf = true;
            akVar.lze = uj(equals);
            akVar.lzd = equals && this.ltR.dnQ();
            akVar.lzo = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lzn = true;
            akVar.isHostOnly = this.lpS.getHostMode();
            akVar.lzh = true;
            if (dik.bmS() == null) {
                akVar.lzg = true;
            } else {
                akVar.lzg = false;
            }
            if (pbData.diN()) {
                akVar.lzf = false;
                akVar.lzh = false;
                akVar.lzg = false;
                akVar.lzk = false;
                akVar.lzl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.diN()) {
                z = false;
            }
            akVar.lzs = z;
            this.ltR.lAX.a(akVar);
        }
    }

    private boolean dkB() {
        if (this.lpS != null && this.lpS.dlz()) {
            return this.lpS.getPageData() == null || this.lpS.getPageData().blr() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(View view) {
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
    public PbModel.a dkC() {
        return this.luT;
    }

    public int dkD() {
        if (dkp() == null || dkp().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dkp().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof com.baidu.tieba.pb.data.n) && ((com.baidu.tieba.pb.data.n) qVar).Vw == com.baidu.tieba.pb.data.n.lom) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dkE() {
        if (dkp() == null || dkp().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = dkp().getListView();
        List<com.baidu.adp.widget.ListView.q> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.q qVar = data.get(i);
            if ((qVar instanceof PostData) && qVar.getType() == PostData.mWR) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        dkK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkF() {
        if (this.lpS != null && this.lpS.lqP != null && this.lpS.lqP.dik() != null) {
            bw dik = this.lpS.lqP.dik();
            dik.mRecomAbTag = this.lpS.dms();
            dik.mRecomWeight = this.lpS.dmq();
            dik.mRecomSource = this.lpS.dmr();
            dik.mRecomExtra = this.lpS.dmt();
            if (dik.getFid() == 0) {
                dik.setFid(com.baidu.adp.lib.f.b.toLong(this.lpS.getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dik, "c13562");
            TbPageTag eu = com.baidu.tbadk.pageInfo.c.eu(getContext());
            if (eu != null && PageStayDurationConstants.PageName.BIGIMAGE.equals(eu.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.BIGIMAGE);
            }
            if (eu != null && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(eu.locatePage)) {
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
            aVar.Bn(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bo(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iV(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dR("obj_id", metaData.getUserId()).al("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.50
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12528").dR("obj_id", metaData.getUserId()).al("obj_locate", 1));
                    aVar2.dismiss();
                    PbFragment.this.eNr.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbFragment.this.getPageContext().getUniqueId(), PbFragment.this.lpS.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).bpc();
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.ltR.dnK();
        this.lpS.ux(z);
        if (this.ltP != null) {
            this.ltP.iq(z);
            if (markData != null) {
                this.ltP.a(markData);
            }
        }
        if (this.lpS.biv()) {
            dkI();
        } else {
            this.ltR.s(this.lpS.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FG(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PA(String str) {
        if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().diN()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lpS.dlx(), str);
            bw dik = this.lpS.getPbData().dik();
            if (dik.bli()) {
                format = format + "&channelid=33833";
            } else if (dik.bou()) {
                format = format + "&channelid=33842";
            } else if (dik.blj()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.ltO.Qb(str);
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
                if (!this.lpS.dlE()) {
                    antiData.setBlock_forum_name(this.lpS.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.lpS.getPbData().getForum().getId());
                    antiData.setUser_name(this.lpS.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.lpS.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (dkp() != null) {
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
        if (AntiHelper.bR(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.52
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            DT(str);
        } else {
            this.ltR.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.mZE) ? bVar.mZE : getString(R.string.delete_fail);
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
                aVar.iV(true);
                aVar.b(getPageContext());
                aVar.bpc();
            } else {
                this.ltR.a(0, bVar.QP, bVar.mZE, z);
            }
            if (bVar.QP) {
                if (bVar.ioi == 1) {
                    ArrayList<PostData> dim = this.lpS.getPbData().dim();
                    int size = dim.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dim.get(i).getId())) {
                            i++;
                        } else {
                            dim.remove(i);
                            break;
                        }
                    }
                    this.lpS.getPbData().dik().oj(this.lpS.getPbData().dik().bmr() - 1);
                    this.ltR.s(this.lpS.getPbData());
                } else if (bVar.ioi == 0) {
                    dkG();
                } else if (bVar.ioi == 2) {
                    ArrayList<PostData> dim2 = this.lpS.getPbData().dim();
                    int size2 = dim2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dim2.get(i2).dJW().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dim2.get(i2).dJW().get(i3).getId())) {
                                i3++;
                            } else {
                                dim2.get(i2).dJW().remove(i3);
                                dim2.get(i2).dJY();
                                z2 = true;
                                break;
                            }
                        }
                        dim2.get(i2).SR(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.ltR.s(this.lpS.getPbData());
                    }
                    a(bVar, this.ltR);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.ltR.a(this.hYQ.getLoadDataMode(), gVar.QP, gVar.mZE, false);
            if (gVar.QP) {
                this.ltS = true;
                if (i == 2 || i == 3) {
                    this.ltT = true;
                    this.ltU = false;
                } else if (i == 4 || i == 5) {
                    this.ltT = false;
                    this.ltU = true;
                }
                if (i == 2) {
                    this.lpS.getPbData().dik().om(1);
                    this.lpS.setIsGood(1);
                } else if (i == 3) {
                    this.lpS.getPbData().dik().om(0);
                    this.lpS.setIsGood(0);
                } else if (i == 4) {
                    this.lpS.getPbData().dik().ol(1);
                    this.lpS.FU(1);
                } else if (i == 5) {
                    this.lpS.getPbData().dik().ol(0);
                    this.lpS.FU(0);
                }
                this.ltR.c(this.lpS.getPbData(), this.lpS.dlz());
            }
        }
    }

    private void dkG() {
        if (this.lpS.dlA() || this.lpS.dlC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.lpS.dlx());
            PbActivity pbActivity = this.ltl;
            PbActivity pbActivity2 = this.ltl;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.lpS.dlx()));
        if (dkJ()) {
            this.ltl.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djM() {
        this.ltl.djM();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData diw;
        boolean z = false;
        if (this.ltR != null) {
            this.ltR.dob();
        }
        if (this.lpS != null && this.lpS.getPbData() != null && !this.lpS.getPbData().diN()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.lpS.getPbData().dik().getId();
            if (this.lpS.isShareThread() && this.lpS.getPbData().dik().eGn != null) {
                historyMessage.threadName = this.lpS.getPbData().dik().eGn.showText;
            } else {
                historyMessage.threadName = this.lpS.getPbData().dik().getTitle();
            }
            if (this.lpS.isShareThread() && !djq()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.lpS.getPbData().getForum().getName();
            }
            ArrayList<PostData> dim = this.lpS.getPbData().dim();
            int dnM = this.ltR != null ? this.ltR.dnM() : 0;
            if (dim != null && dnM >= 0 && dnM < dim.size()) {
                historyMessage.postID = dim.get(dnM).getId();
            }
            historyMessage.isHostOnly = this.lpS.getHostMode();
            historyMessage.isSquence = this.lpS.dlz();
            historyMessage.isShareThread = this.lpS.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lud != null) {
            this.lud.onDestroy();
        }
        if (this.ltp && dkp() != null) {
            dkp().dov();
        }
        if (this.lpS != null && (this.lpS.dlA() || this.lpS.dlC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.lpS.dlx());
            if (this.ltS) {
                if (this.ltU) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.lpS.crc());
                }
                if (this.ltT) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.lpS.getIsGood());
                }
            }
            if (this.lpS.getPbData() != null && System.currentTimeMillis() - this.ltt >= 40000 && (diw = this.lpS.getPbData().diw()) != null && !com.baidu.tbadk.core.util.y.isEmpty(diw.getDataList())) {
                intent.putExtra("guess_like_data", diw);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.lur);
            }
            PbActivity pbActivity = this.ltl;
            PbActivity pbActivity2 = this.ltl;
            pbActivity.setResult(-1, intent);
        }
        if (dkJ()) {
            if (this.lpS != null && this.ltR != null && this.ltR.getListView() != null) {
                com.baidu.tieba.pb.data.f pbData = this.lpS.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.dis() && !this.ltz && pbData.lmV == null) {
                        as dmS = as.dmS();
                        com.baidu.tieba.pb.data.f dlH = this.lpS.dlH();
                        Parcelable onSaveInstanceState = this.ltR.getListView().onSaveInstanceState();
                        boolean dlz = this.lpS.dlz();
                        boolean hostMode = this.lpS.getHostMode();
                        if (this.ltR.dnv() != null && this.ltR.dnv().getVisibility() == 0) {
                            z = true;
                        }
                        dmS.a(dlH, onSaveInstanceState, dlz, hostMode, z);
                        if (this.luq >= 0 || this.lpS.dmj() != null) {
                            as.dmS().q(this.lpS.dmj());
                            as.dmS().p(this.lpS.dmk());
                            as.dmS().Ge(this.lpS.dml());
                        }
                    }
                }
            } else {
                as.dmS().reset();
            }
            djM();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (keyEvent == null || this.ltR == null || !this.ltR.Gk(i)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FQ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.ltl;
        if (i == 0) {
            this.ltR.dni();
            this.ltR.dnk().dkf();
            this.ltR.uS(false);
        }
        this.ltR.dnm();
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
                        this.lud.resetData();
                        this.lud.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lud.b(writeData);
                        com.baidu.tbadk.editortools.m rk = this.lud.bzx().rk(6);
                        if (rk != null && rk.fnp != null) {
                            rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.ltl;
                        if (i == -1) {
                            this.lud.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.ltR.dnk() != null && this.ltR.dnk().dkj() != null) {
                            com.baidu.tbadk.editortools.pb.h dkj = this.ltR.dnk().dkj();
                            dkj.setThreadData(this.lpS.getPbData().dik());
                            dkj.b(writeData);
                            dkj.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.m rk2 = dkj.bzx().rk(6);
                            if (rk2 != null && rk2.fnp != null) {
                                rk2.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.ltl;
                            if (i == -1) {
                                dkj.bAB();
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
        this.lud.onActivityResult(i, i2, intent);
        if (this.ltE != null) {
            this.ltE.onActivityResult(i, i2, intent);
        }
        if (dkp().dnk() != null) {
            dkp().dnk().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dkH();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    as.dmS().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.59
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbFragment.this.lpS != null) {
                                PbFragment.this.lpS.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dzT().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.lpS != null) {
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
                        aqVar.dR("tid", intent.getStringExtra("tid"));
                        aqVar.dR("post_id", intent.getStringExtra("pid"));
                        aqVar.al("obj_locate", intent.getIntExtra("source", 0));
                        TiebaStatic.log(aqVar);
                    }
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.o.a.dzT().F(getPageContext());
                        dkz();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.jaw != null && shareItem != null && shareItem.linkUrl != null) {
                            this.jaw.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.60
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bwW() {
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
                    this.ltR.tY(false);
                    if (this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null && this.lpS.getPbData().dik().bmV() != null) {
                        this.lpS.getPbData().dik().bmV().setStatus(2);
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
                        this.lug = emotionImageData;
                        if (FP(com.baidu.tbadk.core.util.am.eNo)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.ltF != null) {
                        this.ltR.dq(this.ltF);
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
            if (this.ltE == null) {
                this.ltE = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.ltl);
                this.ltE.b(this.fpP);
                this.ltE.c(this.fpW);
            }
            this.ltE.a(emotionImageData, djz(), djz().getPbData());
        }
    }

    private void S(Intent intent) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, intent);
    }

    private void b(long j, String str, long j2) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, j, str, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkH() {
        MarkData Gb;
        if (this.ltP != null) {
            if (this.lpS.getPbData() != null && this.lpS.getPbData().diN()) {
                Gb = this.lpS.Gb(0);
            } else {
                Gb = this.lpS.Gb(this.ltR.dnN());
            }
            if (Gb != null) {
                if (!Gb.isApp() || (Gb = this.lpS.Gb(this.ltR.dnN() + 1)) != null) {
                    this.ltR.dnI();
                    this.ltP.a(Gb);
                    if (!this.ltP.biv()) {
                        this.ltP.bix();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.ltP.biw();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkI() {
        com.baidu.tieba.pb.data.f pbData = this.lpS.getPbData();
        this.lpS.ux(true);
        if (this.ltP != null) {
            pbData.Pr(this.ltP.biu());
        }
        this.ltR.s(pbData);
    }

    private boolean dkJ() {
        if (this.lpS == null) {
            return true;
        }
        if (this.lpS.getPbData() == null || !this.lpS.getPbData().diN()) {
            if (this.lpS.biv()) {
                final MarkData dlR = this.lpS.dlR();
                if (dlR == null || !this.lpS.getIsFromMark()) {
                    return true;
                }
                final MarkData Gb = this.lpS.Gb(this.ltR.dnM());
                if (Gb == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dlR);
                    this.ltl.setResult(-1, intent);
                    return true;
                } else if (Gb.getPostId() == null || Gb.getPostId().equals(dlR.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dlR);
                    this.ltl.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    aVar.Bo(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.61
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbFragment.this.ltP != null) {
                                if (PbFragment.this.ltP.biv()) {
                                    PbFragment.this.ltP.biw();
                                    PbFragment.this.ltP.iq(false);
                                }
                                PbFragment.this.ltP.a(Gb);
                                PbFragment.this.ltP.iq(true);
                                PbFragment.this.ltP.bix();
                            }
                            dlR.setPostId(Gb.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlR);
                            PbFragment.this.ltl.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.djM();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.62
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dlR);
                            PbFragment.this.ltl.setResult(-1, intent3);
                            aVar.dismiss();
                            PbFragment.this.djM();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.63
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            int[] iArr = new int[2];
                            if (PbFragment.this.ltR != null && PbFragment.this.ltR.getView() != null) {
                                PbFragment.this.ltR.getView().getLocationOnScreen(iArr);
                            }
                            if (iArr[0] > 0) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("mark", dlR);
                                PbFragment.this.ltl.setResult(-1, intent3);
                                aVar.dismiss();
                                PbFragment.this.djM();
                            }
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bpc();
                    return false;
                }
            } else if (this.lpS.getPbData() == null || this.lpS.getPbData().dim() == null || this.lpS.getPbData().dim().size() <= 0 || !this.lpS.getIsFromMark()) {
                return true;
            } else {
                this.ltl.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.i
    public BdListView getListView() {
        if (this.ltR == null) {
            return null;
        }
        return this.ltR.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bGt() {
        if (this.ltR == null) {
            return 0;
        }
        return this.ltR.dnZ();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bGu() {
        if (this.fFL == null) {
            this.fFL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.64
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bjH().isShowImages();
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
                        if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
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
        return this.fFL;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bGv() {
        if (this.fJc == null) {
            this.fJc = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fJc;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bGw() {
        if (this.fFM == null) {
            this.fFM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.65
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csS */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bjH().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
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
                    gifView.bBb();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fFM;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bGx() {
        if (this.fJd == null) {
            this.fJd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.66
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlh */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(PbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dl */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dm */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bZl();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dn */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fJd;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bGz() {
        this.fJf = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.68
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dli */
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
        return this.fJf;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (this.eXS == null) {
            this.eXS = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eXS;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (be.PS(str) && this.lpS != null && this.lpS.dlx() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11664").al("obj_param1", 1).dR("post_id", this.lpS.dlx()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.fmn = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            be.doG().f(getPageContext(), str);
        }
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
        be.doG().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.ltx = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Rect rect) {
        if (rect != null && this.ltR != null && this.ltR.doq() != null && rect.top <= this.ltR.doq().getHeight()) {
            rect.top += this.ltR.doq().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, PbActivity.a aVar) {
        TbRichTextData tbRichTextData;
        if (aVar != null) {
            com.baidu.tieba.pb.data.f pbData = this.lpS.getPbData();
            TbRichText bz = bz(str, i);
            if (bz != null && (tbRichTextData = bz.bFI().get(this.luZ)) != null) {
                aVar.postId = String.valueOf(bz.getPostId());
                aVar.lqa = new ArrayList<>();
                aVar.exw = new ConcurrentHashMap<>();
                if (!tbRichTextData.bFO().bGc()) {
                    aVar.lqb = false;
                    String c2 = com.baidu.tieba.pb.data.g.c(tbRichTextData);
                    aVar.lqa.add(c2);
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
                    imageUrlData.postId = bz.getPostId();
                    imageUrlData.mIsReserver = this.lpS.dlP();
                    imageUrlData.mIsSeeHost = this.lpS.getHostMode();
                    aVar.exw.put(c2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            aVar.forumName = pbData.getForum().getName();
                            aVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.dik() != null) {
                            aVar.threadId = pbData.dik().getId();
                        }
                        aVar.exu = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(aVar.threadId, -1L);
                    return;
                }
                aVar.lqb = true;
                int size = pbData.dim().size();
                this.lva = false;
                aVar.index = -1;
                int a2 = pbData.dit() != null ? a(pbData.dit().dKb(), bz, i, i, aVar.lqa, aVar.exw) : i;
                for (int i2 = 0; i2 < size; i2++) {
                    PostData postData = pbData.dim().get(i2);
                    if (postData.getId() == null || pbData.dit() == null || pbData.dit().getId() == null || !postData.getId().equals(pbData.dit().getId())) {
                        a2 = a(postData.dKb(), bz, a2, i, aVar.lqa, aVar.exw);
                    }
                }
                if (aVar.lqa.size() > 0) {
                    aVar.lastId = aVar.lqa.get(aVar.lqa.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        aVar.forumName = pbData.getForum().getName();
                        aVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.dik() != null) {
                        aVar.threadId = pbData.dik().getId();
                    }
                    aVar.exu = pbData.getIsNewUrl() == 1;
                }
                aVar.index = a2;
            }
        }
    }

    private String d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return null;
        }
        return tbRichTextData.bFO().bGh();
    }

    private long e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return 0L;
        }
        return tbRichTextData.bFO().getOriginalSize();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return false;
        }
        return tbRichTextData.bFO().bGi();
    }

    private boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.bFO() == null) {
            return false;
        }
        return tbRichTextData.bFO().bGj();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFO;
        String str;
        if (tbRichText == tbRichText2) {
            this.lva = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.bFI().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.bFI().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.bFO().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.bFO().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.bFO().bGc()) {
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
                            if (tbRichTextData != null && (bFO = tbRichTextData.bFO()) != null) {
                                String bGe = bFO.bGe();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = bFO.bGf();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = bGe;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = d(tbRichTextData);
                                imageUrlData.originalSize = e(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = f(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.lpS.dlx(), -1L);
                                imageUrlData.mIsReserver = this.lpS.dlP();
                                imageUrlData.mIsSeeHost = this.lpS.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(c2, imageUrlData);
                                }
                            }
                        }
                        if (!this.lva) {
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
        PostData dit;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lpS.bmI())) {
                z = true;
            }
            MarkData o = this.lpS.o(postData);
            if (this.lpS.getPbData() != null && this.lpS.getPbData().diN() && (dit = dit()) != null) {
                o = this.lpS.o(dit);
            }
            if (o != null) {
                this.ltR.dnI();
                if (this.ltP != null) {
                    this.ltP.a(o);
                    if (!z) {
                        this.ltP.bix();
                    } else {
                        this.ltP.biw();
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

    public boolean dk(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        TbRichText tbRichText = null;
        if (this.lpS == null || this.lpS.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.f pbData = this.lpS.getPbData();
        if (pbData.dit() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.dit());
            tbRichText = c(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> dim = pbData.dim();
            c(pbData, dim);
            return c(dim, str, i);
        }
        return tbRichText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eRh == null) {
                this.eRh = new com.baidu.tbadk.core.message.a();
            }
            if (this.eQR == null) {
                this.eQR = new com.baidu.tieba.tbadkCore.data.e();
                this.eQR.uniqueId = getUniqueId();
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ezt = 5;
            cVar.ezz = 8;
            cVar.ezy = 2;
            if (djz() != null) {
                cVar.ezx = djz().dmh();
            }
            cVar.type = 2;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.ezA = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.ezA = 1;
                        i = 0;
                    }
                }
                this.eRh.a(agreeData, i, getUniqueId(), false);
                this.eRh.a(agreeData, this.eQR);
                if (this.lpS == null && this.lpS.getPbData() != null) {
                    this.eRh.a(dle(), cVar, agreeData, this.lpS.getPbData().dik());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.ezA = 1;
            }
            i = 0;
            this.eRh.a(agreeData, i, getUniqueId(), false);
            this.eRh.a(agreeData, this.eQR);
            if (this.lpS == null) {
            }
        }
    }

    private void c(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (fVar != null && fVar.diy() != null && fVar.diy().loD != null && (list = fVar.diy().loD) != null && arrayList != null) {
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
        ArrayList<TbRichTextData> bFI;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText dKb = arrayList.get(i2).dKb();
            if (dKb != null && (bFI = dKb.bFI()) != null) {
                int size = bFI.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (bFI.get(i4) != null && bFI.get(i4).getType() == 8) {
                        i3++;
                        if (bFI.get(i4).bFO().bGe().equals(str) || bFI.get(i4).bFO().bGf().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = bFI.get(i4).bFO().getWidth() * equipmentDensity;
                            int height = bFI.get(i4).bFO().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.luZ = i4;
                            return dKb;
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
            this.lpO = str;
            if (this.lts == null) {
                dkt();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.lts.getItemView(1).setVisibility(8);
            } else {
                this.lts.getItemView(1).setVisibility(0);
            }
            this.lts.bpe();
            this.ltx = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkK() {
        hideNetRefreshView(this.ltR.getView());
        dkL();
        if (this.lpS.dlK()) {
            this.ltR.dnI();
        }
        this.ltR.dnT();
    }

    private void dkL() {
        showLoadingView(this.ltR.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.ltR.doq().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        if (this.iHo != null) {
            this.iHo.stopPlay();
        }
        if (this.ltl != null) {
            this.ltl.cyK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(int i) {
        com.baidu.tieba.pb.pb.main.d.a.a(this, dky(), i);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bGy() {
        if (this.fJe == null) {
            this.fJe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.74
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlj */
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
        return this.fJe;
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

    public void cyL() {
        if (this.ltl != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.ltl.getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), this.ltl.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData cxn() {
        if (this.lpS == null || this.lpS.getPbData() == null) {
            return null;
        }
        return this.lpS.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(az.lCl)).intValue();
            if (intValue == az.lCm) {
                if (!this.hYQ.dKK()) {
                    this.ltR.dnF();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.hYQ.ST(com.baidu.tbadk.core.util.at.R(jSONArray));
                    }
                    this.hYQ.a(this.lpS.getPbData().getForum().getId(), this.lpS.getPbData().getForum().getName(), this.lpS.getPbData().dik().getId(), str, intValue3, intValue2, booleanValue, this.lpS.getPbData().dik().getBaijiahaoData());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == az.lCn || intValue == az.lCp) {
                if (this.lpS.dma() != null) {
                    this.lpS.dma().FL(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == az.lCn) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lul);
        userMuteAddAndDelCustomMessage.setTag(this.lul);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean PC(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("bubble_link", "");
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

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0822a
    public void um(boolean z) {
        this.ltX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dkM() {
        ArrayList<PostData> dim;
        int count;
        if (this.lpS == null || this.lpS.getPbData() == null || this.lpS.getPbData().dim() == null || (count = com.baidu.tbadk.core.util.y.getCount((dim = this.lpS.getPbData().dim()))) == 0) {
            return "";
        }
        if (this.lpS.dlP()) {
            Iterator<PostData> it = dim.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dJZ() == 1) {
                    return next.getId();
                }
            }
        }
        int dnM = this.ltR.dnM();
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, dnM);
        if (postData == null || postData.bmA() == null) {
            return "";
        }
        if (this.lpS.PG(postData.bmA().getUserId())) {
            return postData.getId();
        }
        for (int i = dnM - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, i);
            if (postData2 == null || postData2.bmA() == null || postData2.bmA().getUserId() == null) {
                break;
            } else if (this.lpS.PG(postData2.bmA().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = dnM + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(dim, i2);
            if (postData3 == null || postData3.bmA() == null || postData3.bmA().getUserId() == null) {
                return "";
            }
            if (this.lpS.PG(postData3.bmA().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aB(Context context, String str) {
        this.ltx = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PbActivity.a PD(String str) {
        String str2;
        if (this.lpS.getPbData() == null || this.lpS.getPbData().dim() == null || this.lpS.getPbData().dim().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        PbActivity.a aVar = new PbActivity.a();
        int i = 0;
        while (true) {
            if (i >= this.lpS.getPbData().dim().size()) {
                i = 0;
                break;
            } else if (str.equals(this.lpS.getPbData().dim().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.lpS.getPbData().dim().get(i);
        if (postData.dKb() == null || postData.dKb().bFI() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.dKb().bFI().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.bFO() != null) {
                    str2 = next.bFO().bGe();
                }
            }
        }
        str2 = null;
        a(str2, 0, aVar);
        com.baidu.tieba.pb.data.g.a(postData, aVar);
        return aVar;
    }

    public boolean dkN() {
        return (!this.ltm && this.lve == -1 && this.lvf == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        if (rVar != null) {
            this.lvh = rVar;
            this.ltm = true;
            this.ltR.dnw();
            this.ltR.PQ(this.lvg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkO() {
        if (this.lvh != null) {
            if (this.lve == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lvh.getCartoonId(), this.lve, 0)));
                this.ltl.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkP() {
        if (this.lvh != null) {
            if (this.lvf == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.lvh.getCartoonId(), this.lvf, 0)));
                this.ltl.finish();
            }
        }
    }

    public int dkQ() {
        return this.lve;
    }

    public int dkR() {
        return this.lvf;
    }

    private void cMB() {
        if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null && this.lpS.getPbData().dik().blg()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void dkS() {
        if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null && this.lpS.getPbData().dik().blg()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void dkT() {
        if (this.bFd) {
            this.ltD = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null && this.lpS.getPbData().dik().bmg() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.lpS.getPbData().dik().bmg().getThreadId(), this.lpS.getPbData().dik().bmg().getTaskId(), this.lpS.getPbData().dik().bmg().getForumId(), this.lpS.getPbData().dik().bmg().getForumName(), this.lpS.getPbData().dik().bmv(), this.lpS.getPbData().dik().bmw())));
            this.lto = true;
            this.ltl.finish();
        }
    }

    public String dkU() {
        return this.ltB;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a dkV() {
        return this.ltN;
    }

    public void un(boolean z) {
        this.ltC = z;
    }

    public boolean bki() {
        if (this.lpS != null) {
            return this.lpS.dlA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bo(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.80
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbFragment.this.luj).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbFragment.this.luj.getPageActivity(), 2, true, 4);
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
        aVar.b(this.luj).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT(String str) {
        if (str == null) {
            str = "";
        }
        if (this.luj != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luj.getPageActivity());
            aVar.Bo(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.82
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.luj).bpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.ltR.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luj.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bo(this.luj.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bo(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.83
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbFragment.this.ltR.showLoadingDialog();
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
        aVar.b(this.luj).bpc();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (be.PS(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.jlj) {
            this.jlj = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.ltR != null) {
                this.ltR.onConfigurationChanged(configuration);
            }
            if (this.ltV != null) {
                this.ltV.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public boolean dkX() {
        if (this.lpS != null) {
            return this.lpS.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, az azVar) {
        boolean z;
        List<PostData> list = this.lpS.getPbData().diy().loD;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dJW().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dJW().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dJW().remove(i2);
                    list.get(i).dJY();
                    z = true;
                    break;
                }
            }
            list.get(i).SR(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            azVar.s(this.lpS.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.p pVar) {
        String id = pVar.dja().getId();
        List<PostData> list = this.lpS.getPbData().diy().loD;
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
                ArrayList<PostData> dji = pVar.dji();
                postData.JC(pVar.getTotalCount());
                if (postData.dJW() != null) {
                    postData.dJW().clear();
                    postData.dJW().addAll(dji);
                }
            }
        }
        if (!this.lpS.getIsFromMark()) {
            this.ltR.s(this.lpS.getPbData());
        }
    }

    public com.baidu.tieba.pb.pb.main.b.a djp() {
        return this.ltl.djp();
    }

    public boolean djq() {
        if (this.lpS == null) {
            return false;
        }
        return this.lpS.djq();
    }

    public void uo(boolean z) {
        this.ltA = z;
    }

    public boolean dkY() {
        return this.ltA;
    }

    public void dkZ() {
        if (this.ltR != null) {
            this.ltR.dni();
            cyL();
        }
    }

    public PostData dit() {
        return this.ltR.b(this.lpS.lqP, this.lpS.dlz());
    }

    public void onBackPressed() {
        if (this.lus != null && !this.lus.isEmpty()) {
            int size = this.lus.size() - 1;
            while (true) {
                int i = size;
                if (i > -1 && !this.lus.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.lus == null) {
                this.lus = new ArrayList();
            }
            if (!this.lus.contains(aVar)) {
                this.lus.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.lus == null) {
                this.lus = new ArrayList();
            }
            if (!this.lus.contains(aVar)) {
                this.lus.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.lus != null) {
            this.lus.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dla() {
        if (this.lpS != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lpS.dlx())) {
            com.baidu.tbadk.BdToken.c.bgf().p(com.baidu.tbadk.BdToken.b.eqd, com.baidu.adp.lib.f.b.toLong(this.lpS.dlx(), 0L));
        }
    }

    public bf dlb() {
        return this.ltK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PE(String str) {
        if (this.lpS != null && this.lpS.getPbData() != null && this.lpS.getPbData().dik() != null && this.lpS.getPbData().dik().blk()) {
            bw dik = this.lpS.getPbData().dik();
            int i = 0;
            if (dik.bli()) {
                i = 1;
            } else if (dik.blj()) {
                i = 2;
            } else if (dik.bov()) {
                i = 3;
            } else if (dik.bow()) {
                i = 4;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str);
            aqVar.al("obj_source", 4);
            aqVar.al("obj_type", i);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(final int i) {
        com.baidu.tbadk.util.ae.a(new com.baidu.tbadk.util.ad<ShareItem>() { // from class: com.baidu.tieba.pb.pb.main.PbFragment.85
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bjC */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(PbFragment.this.getContext(), PbFragment.this.dky(), i2, PbFragment.this.lpS);
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
        aqVar.al("obj_locate", 1);
        if (i == 3) {
            aqVar.al("obj_type", 1);
        } else if (i == 8) {
            aqVar.al("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dlc() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dld() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dle() {
        return this.ltl;
    }
}
