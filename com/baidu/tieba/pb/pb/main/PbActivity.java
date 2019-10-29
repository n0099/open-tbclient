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
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GodFansCallWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.BdToast;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.t.bf;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f.a;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.b.b;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.pb.main.r;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
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
import com.baidu.tieba.view.Thread2GroupShareView;
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
/* loaded from: classes4.dex */
public class PbActivity extends BaseActivity<PbActivity> implements View.OnTouchListener, a.b, UserIconBox.b, VoiceManager.c, TbRichTextView.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<PbActivity> {
    private com.baidu.adp.lib.e.b<ImageView> cUv;
    private com.baidu.adp.lib.e.b<GifView> cUw;
    private com.baidu.adp.lib.e.b<TextView> cXc;
    private com.baidu.adp.lib.e.b<View> cXd;
    private com.baidu.adp.lib.e.b<LinearLayout> cXe;
    private com.baidu.adp.lib.e.b<RelativeLayout> cXf;
    private LikeModel csF;
    private com.baidu.adp.lib.e.b<TbImageView> csh;
    private au fXD;
    private VoiceManager fvn;
    private com.baidu.tieba.frs.profession.permission.c fyU;
    private com.baidu.tieba.f.b fzw;
    public com.baidu.tbadk.core.util.aj gWL;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hLM;
    private View hLN;
    int hLP;
    private com.baidu.tbadk.core.data.av hLQ;
    private com.baidu.tieba.pb.pb.report.a hLT;
    private String hLr;
    private com.baidu.tieba.pb.pb.main.b.b hLx;
    private List<a> hMA;
    public as hMb;
    private com.baidu.tbadk.core.dialog.i hMc;
    private com.baidu.tbadk.core.dialog.k hMd;
    private boolean hMf;
    private com.baidu.tieba.tbadkCore.data.f hMj;
    private com.baidu.tbadk.editortools.pb.f hMk;
    private com.baidu.tbadk.editortools.pb.d hMl;
    private com.baidu.tieba.frs.profession.permission.c hMn;
    private EmotionImageData hMo;
    private com.baidu.adp.base.e hMr;
    private com.baidu.tbadk.core.view.e hMs;
    private BdUniqueId hMt;
    private Runnable hMu;
    private com.baidu.adp.widget.ImageView.a hMv;
    private String hMw;
    private TbRichTextMemeInfo hMx;
    private boolean hNe;
    private String hNp;
    private com.baidu.tbadk.core.data.o hNq;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private static final b.a hNk = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void aH(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bRt();
            } else {
                com.baidu.tieba.pb.a.b.bRs();
            }
        }
    };
    private boolean hLw = false;
    private boolean hLy = false;
    private boolean aqC = false;
    private boolean hpa = false;
    private boolean hLz = true;
    private int hLA = 0;
    private com.baidu.tbadk.core.dialog.b hLB = null;
    private long fbN = -1;
    private long cMh = 0;
    private long hLC = 0;
    private long createTime = 0;
    private long cLZ = 0;
    private boolean hLD = false;
    private com.baidu.tbadk.p.b hLE = null;
    private long hLF = 0;
    private boolean hLG = false;
    private long hLH = 0;
    private int fVh = 1;
    private String cGV = null;
    private boolean hLI = false;
    private boolean isFullScreen = false;
    private String hLJ = "";
    private boolean hLK = true;
    private boolean hLL = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hLO = new int[2];
    private PbInterviewStatusView.a hLR = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbActivity.this.hLW.oE(!PbActivity.this.hLK);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hLS != null && PbActivity.this.hLS.afm()) {
                        PbActivity.this.bSq();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hLS = null;
    private com.baidu.tbadk.baseEditMark.a hLU = null;
    private ForumManageModel eNS = null;
    private com.baidu.tbadk.coreExtra.model.a cjV = null;
    private com.baidu.tieba.pb.data.l hLV = null;
    private ShareSuccessReplyToServerModel fLK = null;
    private aq hLW = null;
    public final com.baidu.tieba.pb.pb.main.b.a hLX = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hLY = false;
    private boolean hLZ = false;
    private boolean hMa = false;
    private boolean hMe = false;
    private boolean hMg = false;
    private boolean hMh = false;
    private boolean hMi = false;
    private boolean hMm = false;
    public boolean hMp = false;
    private com.baidu.tbadk.editortools.pb.c cGY = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aux() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cGZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auw() {
            if (PbActivity.this.hMb == null || PbActivity.this.hMb.bWn() == null || !PbActivity.this.hMb.bWn().cxA()) {
                return !PbActivity.this.wt(com.baidu.tbadk.core.util.aj.cjQ);
            }
            PbActivity.this.showToast(PbActivity.this.hMb.bWn().cxC());
            if (PbActivity.this.hMl != null && (PbActivity.this.hMl.auL() || PbActivity.this.hMl.auM())) {
                PbActivity.this.hMl.a(false, PbActivity.this.hMb.bWq());
            }
            PbActivity.this.hMb.oQ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hMq = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auw() {
            if (PbActivity.this.hMb == null || PbActivity.this.hMb.bWo() == null || !PbActivity.this.hMb.bWo().cxA()) {
                return !PbActivity.this.wt(com.baidu.tbadk.core.util.aj.cjR);
            }
            PbActivity.this.showToast(PbActivity.this.hMb.bWo().cxC());
            if (PbActivity.this.hLW != null && PbActivity.this.hLW.bUZ() != null && PbActivity.this.hLW.bUZ().bTr() != null && PbActivity.this.hLW.bUZ().bTr().auM()) {
                PbActivity.this.hLW.bUZ().bTr().a(PbActivity.this.hMb.bWq());
            }
            PbActivity.this.hMb.oR(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fwc = false;
    private int hMy = 0;
    private int hMz = -1;
    private final a hMB = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hLW != null && PbActivity.this.hLW.bUZ() != null) {
                s bUZ = PbActivity.this.hLW.bUZ();
                if (bUZ.bTp()) {
                    bUZ.bTo();
                    return true;
                }
            }
            if (PbActivity.this.hLW != null && PbActivity.this.hLW.bVU()) {
                PbActivity.this.hLW.bVV();
                return true;
            }
            return false;
        }
    };
    private r.a hMC = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fwo = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bSu();
        }
    };
    private final z.a hMD = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aD(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hLW.showToast(str);
            }
        }
    };
    private final CustomMessageListener hME = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLS != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hMl != null) {
                    PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                }
                PbActivity.this.hLW.bVa();
                PbActivity.this.hLW.bVN();
            }
        }
    };
    CustomMessageListener fwJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hLS.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hLW != null && PbActivity.this.hLS != null) {
                    PbActivity.this.hLW.d(PbActivity.this.hLS.getPbData(), PbActivity.this.hLS.bTB(), PbActivity.this.hLS.bTW());
                }
                if (PbActivity.this.hLW != null && PbActivity.this.hLW.bVr() != null) {
                    PbActivity.this.hLW.bVr().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hMF = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hLW != null) {
                    if (booleanValue) {
                        PbActivity.this.hLW.bCv();
                    } else {
                        PbActivity.this.hLW.bCu();
                    }
                }
            }
        }
    };
    private CustomMessageListener hMG = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hMl != null) {
                    PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                }
                PbActivity.this.hLW.oL(false);
            }
        }
    };
    private CustomMessageListener hMH = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        PbActivity.this.b((com.baidu.tieba.pb.data.k) eVar.getData());
                        return;
                    case 1:
                        PbActivity.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            PbActivity.this.a(false, (MarkData) null);
                            return;
                        } else {
                            PbActivity.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener hMI = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLW != null && PbActivity.this.hLW.bVr() != null) {
                PbActivity.this.hLW.bVr().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gAF = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fwG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.aqC) {
                PbActivity.this.bSK();
            }
        }
    };
    private h.a hMJ = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wv(2);
                aj.bUK().reset();
                PbActivity.this.hLS.bTX();
                boolean z2 = false;
                ArrayList<PostData> bQB = PbActivity.this.hLS.getPbData().bQB();
                if (bQB != null) {
                    Iterator<PostData> it = bQB.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.coy().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hLW.m(PbActivity.this.hLS.getPbData());
                    }
                    PbActivity.this.showToast(R.string.operation_success);
                    return;
                }
                return;
            }
            PbActivity.this.showToast(R.string.operation_failed);
        }

        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void onError(int i, String str) {
            PbActivity.this.showToast(R.string.operation_failed);
        }
    };
    private View.OnClickListener cHJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.cGV);
        }
    };
    private CustomMessageListener hMK = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hLS.bTN() != null && PbActivity.this.hLS.bTN().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hLW.a(aaVar.sendCount, PbActivity.this.hLS.getPbData(), PbActivity.this.hLS.bTB(), PbActivity.this.hLS.bTW());
                    }
                    if (pbData.bQB() != null && pbData.bQB().size() >= 1 && pbData.bQB().get(0) != null) {
                        long j = com.baidu.adp.lib.g.b.toLong(pbData.bQB().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLS.bTA(), 0L);
                        if (j == aaVar.postId && j2 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cox = pbData.bQB().get(0).cox();
                            if (cox == null) {
                                cox = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> ahC = cox.ahC();
                            if (ahC == null) {
                                ahC = new ArrayList<>();
                            }
                            ahC.add(0, aVar);
                            cox.setTotal(aaVar.sendCount + cox.getTotal());
                            cox.s(ahC);
                            pbData.bQB().get(0).a(cox);
                            PbActivity.this.hLW.bVr().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fMU = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                PbActivity.this.AF((String) customResponsedMessage.getData());
                PbActivity.this.hLS.bTT();
                if (PbActivity.this.hLW.bVr() != null) {
                    PbActivity.this.hLW.m(PbActivity.this.hLS.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hML = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.bWx()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hMM = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aD(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbActivity.this.hLW != null) {
                PbActivity.this.hLW.dW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hMN = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.fT().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbActivity.this.getUniqueId());
            } else {
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }
    };
    private boolean hMO = false;
    private PraiseModel hMP = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rM(String str) {
            PbActivity.this.hMO = false;
            if (PbActivity.this.hMP != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                if (pbData.bQz().ais().getIsLike() == 1) {
                    PbActivity.this.rs(0);
                } else {
                    PbActivity.this.rs(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.bQz()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hMO = false;
            if (PbActivity.this.hMP != null && str != null) {
                if (AntiHelper.aH(i, str)) {
                    AntiHelper.aS(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hMQ = 0;
    private boolean hMR = true;
    private b.a hMS = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void of(boolean z) {
            PbActivity.this.oe(z);
            if (PbActivity.this.hLW.bWa() != null && z) {
                PbActivity.this.hLW.oE(false);
            }
            PbActivity.this.hLW.oG(z);
        }
    };
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().cwD != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().cwD, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbActivity.this.bQG().aiG() != null && PbActivity.this.bQG().aiG().getGodUserData() != null) {
                            PbActivity.this.bQG().aiG().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                            PbActivity.this.hLS.getPbData().bQz().aiG().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a hMT = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hLW.aVW();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.ww(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bsB();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c czv = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            PbActivity.this.bSa();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (PbActivity.this.cs(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        PbActivity.this.c((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                    if (PbActivity.this.hLW != null && PbActivity.this.hLW.bRY() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").bS("obj_id", (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hLX != null && PbActivity.this.hLX.fXW != null) {
                            PbActivity.this.hLX.fXW.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.c(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.hMl != null) {
                PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
            }
            PbActivity.this.hLW.bVa();
            PbActivity.this.hLW.bVN();
            return true;
        }
    });
    private CustomMessageListener hMU = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hMt) {
                PbActivity.this.hLW.aVW();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bQM().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hMs.showSuccessToast(PbActivity.this.hMr.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hMr.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.pP(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bSG();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hMr.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hMs.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMV = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hMt) {
                PbActivity.this.hLW.aVW();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hMs.showSuccessToast(PbActivity.this.hMr.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hMr.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hMs.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener hMW = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hMt) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hLW.aVW();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jwI;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.g.b.toInt(dataRes.is_mute, 0);
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
                    PbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    PbActivity.this.hLW.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hMX = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLW.bVb() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bSa();
            }
        }
    };
    private CustomMessageListener fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fwc = true;
                }
            }
        }
    };
    public a.b hAg = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bkl();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hLS.getPageData();
            int pageNum = PbActivity.this.hLW.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ahv()) {
                PbActivity.this.hLW.bVN();
                PbActivity.this.wv(2);
                PbActivity.this.bkk();
                PbActivity.this.hLW.bVv();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbActivity.this.hLS.wE(PbActivity.this.hLW.getPageNum());
                    if (PbActivity.this.hLx != null) {
                        PbActivity.this.hLx.showFloatingView();
                    }
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
                aVar.dismiss();
            } else {
                PbActivity.this.showToast(R.string.pb_page_error);
            }
        }
    };
    public final View.OnClickListener fxy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r4v291, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v295, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v322, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v434, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:578:0x1be6  */
        /* JADX WARN: Removed duplicated region for block: B:581:0x1c2f  */
        /* JADX WARN: Removed duplicated region for block: B:598:0x1e45  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean oa;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bm bmVar;
            String[] strArr;
            boolean u;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hLW.bVJ()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hLS.op(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hLW.bVw();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUF()) {
                        if (view == PbActivity.this.hLW.hUV.cOr) {
                            if (PbActivity.this.hLW.oI(PbActivity.this.hLS.bTG())) {
                                PbActivity.this.bkk();
                                return;
                            }
                            PbActivity.this.hLz = false;
                            PbActivity.this.hLy = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbActivity.this, PbActivity.this.hLW.hUV.cOr);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hLW.bVt() && (PbActivity.this.hLW.hUV.bWL() == null || (view != PbActivity.this.hLW.hUV.bWL().bUE() && view != PbActivity.this.hLW.hUV.bWL().bUC()))) {
                            if (view == PbActivity.this.hLW.bVQ()) {
                                if (PbActivity.this.hLS != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLS.getPbData().bQz().aiF().getLink());
                                }
                            } else if (view != PbActivity.this.hLW.hUV.iap) {
                                if (view == PbActivity.this.hLW.hUV.iaq) {
                                    if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                        ArrayList<PostData> bQB = PbActivity.this.hLS.getPbData().bQB();
                                        if ((bQB == null || bQB.size() <= 0) && PbActivity.this.hLS.bTB()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").bS("tid", PbActivity.this.hLS.bTA()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", PbActivity.this.hLS.getForumId()));
                                        if (!PbActivity.this.hLW.bWf()) {
                                            PbActivity.this.hLW.bVa();
                                        }
                                        PbActivity.this.bSi();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbActivity.this.hLW.oj(true);
                                        PbActivity.this.hLW.bVa();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hLW.bCv();
                                            PbActivity.this.bkk();
                                            PbActivity.this.hLW.bVv();
                                            PbActivity.this.hLS.AM(PbActivity.this.bSv());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wv(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUB()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hLW.hUV.bWL() != null && view == PbActivity.this.hLW.hUV.bWL().getCancelView()) {
                                            PbActivity.this.hLW.hUV.ZF();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUz()) {
                                                if ((PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUH()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUA()) {
                                                        if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUI()) {
                                                            if (PbActivity.this.hLW.bWa() == view) {
                                                                if (PbActivity.this.hLW.bWa().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                                                                    if (pbData != null && pbData.bQz() != null && pbData.bQz().aim() != null) {
                                                                        String aid = pbData.bQz().aim().aid();
                                                                        if (StringUtils.isNull(aid)) {
                                                                            aid = pbData.bQz().aim().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").bS("obj_id", aid));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dZ("c10725", null);
                                                                }
                                                                PbActivity.this.bSC();
                                                            } else if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUG()) {
                                                                if (PbActivity.this.hLW.hUV.bWL() != null && view == PbActivity.this.hLW.hUV.bWL().bUD()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hLW.c(PbActivity.this.hLS.getPbData(), PbActivity.this.hLS.bTB(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hLW.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hLW.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hLW.hUV.ZF();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hLS != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.bS("tid", PbActivity.this.hLS.bTA());
                                                                        anVar.bS("fid", PbActivity.this.hLS.getForumId());
                                                                        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.O("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hLS.getPbData() != null) {
                                                                            PbActivity.this.hLW.bVN();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.coB() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.jjk != null) {
                                                                                    com.baidu.tbadk.core.util.an amJ = postData.jjk.amJ();
                                                                                    amJ.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        amJ.O("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        amJ.O("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(amJ);
                                                                                }
                                                                                String bTA = PbActivity.this.hLS.bTA();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hLS.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hLS.getPbData().bQL();
                                                                                }
                                                                                PbActivity.this.bkk();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c AK = PbActivity.this.AK(id);
                                                                                    if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && AK != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTA, id, "pb", true, null, true, null, i4, postData.bXF(), PbActivity.this.hLS.getPbData().getAnti(), false, postData.aiG().getIconInfo()).addBigImageData(AK.hNS, AK.hNT, AK.hNU, AK.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hLS.bUj());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hLS.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c AK2 = PbActivity.this.AK(id);
                                                                                    if (postData != null && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && AK2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTA, id, "pb", true, null, false, null, i4, postData.bXF(), PbActivity.this.hLS.getPbData().getAnti(), false, postData.aiG().getIconInfo()).addBigImageData(AK2.hNS, AK2.hNT, AK2.hNU, AK2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hLS.bUj());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hLS.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData2));
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").O("obj_locate", 3).bS("fid", PbActivity.this.hLS.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hLS != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.bS("tid", PbActivity.this.hLS.bTA());
                                                                        anVar2.bS("fid", PbActivity.this.hLS.getForumId());
                                                                        anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.O("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                                                                    String bTA2 = PbActivity.this.hLS.bTA();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hLS.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hLS.getPbData().bQL();
                                                                                    }
                                                                                    c AK3 = PbActivity.this.AK(id2);
                                                                                    if (AK3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTA2, id2, "pb", true, null, false, null, i5, postData2.bXF(), PbActivity.this.hLS.getPbData().getAnti(), false, postData2.aiG().getIconInfo()).addBigImageData(AK3.hNS, AK3.hNT, AK3.hNU, AK3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hLS.bUj());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hLS.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData3));
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
                                                                    if (PbActivity.this.hLS != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.bS("tid", PbActivity.this.hLS.bTA());
                                                                        anVar3.bS("fid", PbActivity.this.hLS.getForumId());
                                                                        anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.O("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.bRX().bUY() != null && postData3.aiG() != null && postData3.cop() != 1) {
                                                                                    if (PbActivity.this.bRX().bUZ() != null) {
                                                                                        PbActivity.this.bRX().bUZ().bTn();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hLS.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hLS.getPbData().bQz());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bRX().bUY().d(kVar);
                                                                                    PbActivity.this.bRX().bUY().setPostId(postData3.getId());
                                                                                    PbActivity.this.b(view, postData3.aiG().getUserId(), "");
                                                                                    if (PbActivity.this.hMl != null) {
                                                                                        PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
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
                                                                } else if (view != PbActivity.this.hLW.bRR()) {
                                                                    if (view == PbActivity.this.hLW.hUV.bWM()) {
                                                                        PbActivity.this.hLW.bVC();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (bmVar = (bm) view.getTag()) != null && !StringUtils.isNull(bmVar.akG())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.amQ().b(PbActivity.this.getPageContext(), new String[]{bmVar.akG()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").bS("tid", PbActivity.this.hLS.hRb));
                                                                                    }
                                                                                    if (PbActivity.this.hMd == null) {
                                                                                        PbActivity.this.hMd = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hMd.a(PbActivity.this.hNj);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cu(view);
                                                                                    if (!PbActivity.this.cu(view) || PbActivity.this.hMv == null || !PbActivity.this.hMv.isGif()) {
                                                                                    }
                                                                                    boolean z3 = false;
                                                                                    boolean z4 = false;
                                                                                    boolean z5 = false;
                                                                                    boolean z6 = false;
                                                                                    boolean z7 = false;
                                                                                    if (!(sparseArray4.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean)) {
                                                                                        z = false;
                                                                                    } else {
                                                                                        z = ((Boolean) sparseArray4.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_is_subpb) instanceof Boolean) {
                                                                                        ((Boolean) sparseArray4.get(R.id.tag_is_subpb)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                                                                                        z3 = ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z4 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                                                                                        z5 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                                                                                        z6 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                    }
                                                                                    if (sparseArray4.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                                                                                        z7 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                    }
                                                                                    if (!(sparseArray4.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                                                                                        str = null;
                                                                                    } else {
                                                                                        str = (String) sparseArray4.get(R.id.tag_forbid_user_post_id);
                                                                                    }
                                                                                    if (z) {
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_template_id) instanceof Long)) {
                                                                                            j = 0;
                                                                                        } else {
                                                                                            j = ((Long) sparseArray4.get(R.id.tag_chudian_template_id)).longValue();
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_monitor_id) instanceof String)) {
                                                                                            str2 = "";
                                                                                        } else {
                                                                                            str2 = (String) sparseArray4.get(R.id.tag_chudian_monitor_id);
                                                                                        }
                                                                                        if (!(sparseArray4.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                                                                            i = 0;
                                                                                        } else {
                                                                                            i = ((Integer) sparseArray4.get(R.id.tag_chudian_hide_day)).intValue();
                                                                                        }
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hMd);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cor() != null && postData4.cor().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hMd);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.gpk = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hLS.getPbData().afm()) {
                                                                                        String afl = PbActivity.this.hLS.getPbData().afl();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(afl) && afl.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hMd);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hMd);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.gpk);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hMd);
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
                                                                                                    arrayList.add(gVar6);
                                                                                                } else {
                                                                                                    if (!ap.m(PbActivity.this.gpk)) {
                                                                                                        oa = PbActivity.this.oa(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        oa = false;
                                                                                                    }
                                                                                                    if (oa) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hMd);
                                                                                                        gVar7.mTextView.setTag(str);
                                                                                                        arrayList.add(gVar7);
                                                                                                    }
                                                                                                }
                                                                                                if (z5) {
                                                                                                    SparseArray sparseArray8 = new SparseArray();
                                                                                                    sparseArray8.put(R.id.tag_should_manage_visible, true);
                                                                                                    sparseArray8.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name, sparseArray4.get(R.id.tag_forbid_user_name));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_name_show, sparseArray4.get(R.id.tag_forbid_user_name_show));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_portrait, sparseArray4.get(R.id.tag_forbid_user_portrait));
                                                                                                    sparseArray8.put(R.id.tag_forbid_user_post_id, str);
                                                                                                    if (z6) {
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
                                                                                                    if (z7) {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, true);
                                                                                                        sparseArray8.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                        sparseArray8.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                        sparseArray8.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hMd);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hMd);
                                                                                                    gVar3.mTextView.setTag(sparseArray8);
                                                                                                } else if (!z7) {
                                                                                                    gVar2 = null;
                                                                                                    gVar3 = null;
                                                                                                } else {
                                                                                                    SparseArray sparseArray9 = new SparseArray();
                                                                                                    sparseArray9.put(R.id.tag_should_manage_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_user_mute_visible, false);
                                                                                                    sparseArray9.put(R.id.tag_should_delete_visible, true);
                                                                                                    sparseArray9.put(R.id.tag_manage_user_identity, sparseArray4.get(R.id.tag_manage_user_identity));
                                                                                                    sparseArray9.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                                                                                                    sparseArray9.put(R.id.tag_del_post_id, sparseArray4.get(R.id.tag_del_post_id));
                                                                                                    sparseArray9.put(R.id.tag_del_post_type, sparseArray4.get(R.id.tag_del_post_type));
                                                                                                    if (PbActivity.this.hLS.getPbData().bQL() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hMd);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hMd);
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
                                                                                            PbActivity.this.hMd.at(arrayList);
                                                                                            PbActivity.this.hMc = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hMd);
                                                                                            PbActivity.this.hMc.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.gpk);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hMd.at(arrayList);
                                                                                    PbActivity.this.hMc = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hMd);
                                                                                    PbActivity.this.hMc.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), PbActivity.this.hLS.getPbData().bQz().getActUrl());
                                                                                if (PbActivity.this.hLS.getPbData().bQz().ajq() != 1) {
                                                                                    if (PbActivity.this.hLS.getPbData().bQz().ajq() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").bS("fid", PbActivity.this.hLS.getPbData().getForumId()).bS("tid", PbActivity.this.hLS.getPbData().getThreadId()).bS("lotterytail", StringUtils.string(str3, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hLS.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hLW.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hLW.bVa();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bSf() == 1 && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").bS("fid", PbActivity.this.hLS.getPbData().getForumId()).bS("tid", PbActivity.this.hLS.getPbData().getThreadId()).bS("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bSf() == 1 && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").bS("fid", PbActivity.this.hLS.getPbData().getForumId()).bS("tid", PbActivity.this.hLS.getPbData().getThreadId()).bS("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bSx();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bSy();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQS() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hLS.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").bS("fid", pbData2.getForumId()));
                                                                                ba.amQ().b(PbActivity.this.getPageContext(), new String[]{pbData2.bQS().bQZ()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQS() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hLS.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bS("fid", pbData3.getForumId()));
                                                                                ba.amQ().b(PbActivity.this.getPageContext(), new String[]{pbData3.bQS().bQZ()});
                                                                            }
                                                                        } else if (PbActivity.this.hLW.hUV.bWL() != null && view == PbActivity.this.hLW.hUV.bWL().bUJ()) {
                                                                            if (PbActivity.this.hLS == null || PbActivity.this.hLS.getPbData() == null || PbActivity.this.hLS.getPbData().bQz() == null) {
                                                                                PbActivity.this.hLW.hUV.ZF();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hLS.getPbData().bQz().ain() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLS.bTA(), RequestResponseCode.FANS_CALL_JUMP_BACK)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).akT();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").O("obj_locate", PbActivity.this.au(PbActivity.this.hLS.getPbData().bQz())).bS("tid", PbActivity.this.hLS.getPbData().bQz().getTid()).O("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hMy >= 0) {
                                                                                if (PbActivity.this.hLS != null) {
                                                                                    PbActivity.this.hLS.bUk();
                                                                                }
                                                                                if (PbActivity.this.hLW.bVr() != null) {
                                                                                    PbActivity.this.hLW.bVr().a(PbActivity.this.hLS.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hLW.getListView().setSelection(PbActivity.this.hLS.bUn());
                                                                                PbActivity.this.hMy = 0;
                                                                                if (PbActivity.this.hLS != null) {
                                                                                    PbActivity.this.hLS.ca(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bSc();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbActivity.this.c(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbActivity.this.hLW.getListView() != null && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hLW.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hLW.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bQX = PbActivity.this.hLS.getPbData().bQX();
                                                                                boolean z8 = PbActivity.this.hLW.hUP != null && PbActivity.this.hLW.hUP.aOh();
                                                                                boolean bVK = PbActivity.this.hLW.bVK();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bQX && PbActivity.this.hLW.hUP != null && PbActivity.this.hLW.hUP.aJy() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d)) - PbActivity.this.hLW.hUP.bXV();
                                                                                    z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbActivity.this.hLW.hUP.aJy().getHeight() - PbActivity.this.hLW.hUP.bXV());
                                                                                    i7 = equipmentWidth;
                                                                                }
                                                                                if ((PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aix() <= 0) || (bVK && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bSc();
                                                                                        if (PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLS.hRb).bS("fid", PbActivity.this.hLS.getPbData().getForumId()).O("obj_locate", 2).bS("uid", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbActivity.this) * 0.6d);
                                                                                    if (bQX) {
                                                                                        if (PbActivity.this.hLW.hWK != null && PbActivity.this.hLW.hWK.hXU != null && PbActivity.this.hLW.hWK.hXU.getView() != null) {
                                                                                            if (PbActivity.this.hLW.hWK.hXU.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bSl();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hLW.hUP.aJy() != null) {
                                                                                                    i8 = PbActivity.this.hLW.hUP.aJy().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hLW.hWK.hXU.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hLW.bVi() != null) {
                                                                                        z10 = PbActivity.this.hLW.bVi().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hLW.hWK != null && PbActivity.this.hLW.hWK.hXU != null && PbActivity.this.hLW.hWK.hXU.getView() != null && PbActivity.this.hLW.hWK.hXU.getView().getParent() != null && PbActivity.this.hLW.hUV != null && PbActivity.this.hLW.hUV.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hLW.hWK.hXU.getView().getTop() - PbActivity.this.hLW.hUV.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bVK) {
                                                                                        int bSl = PbActivity.this.bSl();
                                                                                        if (PbActivity.this.bSk() != -1) {
                                                                                            bSl--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bSl < 0) {
                                                                                            i2 = PbActivity.this.hLW.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbActivity.this.hLW.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bSl;
                                                                                            i3 = dimens;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bQX || PbActivity.this.hLW.hUP.aJy() == null) {
                                                                                            if (PbActivity.this.hLW.hUV != null && PbActivity.this.hLW.hUV.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hLW.hUV.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hLW.hUP.aJy().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hLW.hWK == null || PbActivity.this.hLW.hWK.hXU == null || PbActivity.this.hLW.hWK.hXU.getView() == null || PbActivity.this.hLW.hWK.hXU.getView().getParent() == null) {
                                                                                            PbActivity.this.hLW.getListView().setSelectionFromTop(i2, i3 + equipmentHeight);
                                                                                            PbActivity.this.hLW.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hLW.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hLW.getListView().smoothScrollBy(PbActivity.this.hLW.hWK.hXU.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                        PbActivity.this.hLW.getListView().setSelectionFromTop(0, i7 - equipmentHeight);
                                                                                        PbActivity.this.hLW.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hLW.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLS.hRb).bS("fid", PbActivity.this.hLS.getPbData().getForumId()).O("obj_locate", 2).bS("uid", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbActivity.this.hLS.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hLS.bUj() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hLS.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.bS("tid", PbActivity.this.hLS.bTA());
                                                                                anVar4.bS("fid", PbActivity.this.hLS.getForumId());
                                                                                anVar4.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                bh bhVar = (bh) view.getTag();
                                                                                if (PbActivity.this.hLS.bUj() == 3 && PbActivity.this.bRv() && PbActivity.this.hLS.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbActivity.this.hLS.getPbData().bQU())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bhVar.aiL(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar5 = new com.baidu.tbadk.core.util.an("c13399");
                                                                                anVar5.bS("tid", bhVar.getId());
                                                                                anVar5.p("fid", bhVar.getFid());
                                                                                anVar5.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hLS != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.bS("tid", PbActivity.this.hLS.bTA());
                                                                                anVar6.bS("fid", PbActivity.this.hLS.getForumId());
                                                                                anVar6.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.O("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hLS.getPbData();
                                                                                if (PbActivity.this.hLV == null) {
                                                                                    PbActivity.this.hLV = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long j2 = com.baidu.adp.lib.g.b.toLong(pbData4.getThreadId(), 0L);
                                                                                long j3 = com.baidu.adp.lib.g.b.toLong(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").p("forum_id", j3).amK();
                                                                                PbActivity.this.registerListener(PbActivity.this.hMZ);
                                                                                PbActivity.this.hLV.y(j2, j3);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_video_thread_smart_app_layout) {
                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                    if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                        com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), smartApp.h5_url);
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").bS("fid", PbActivity.this.hLS.getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", smartApp.name).p("obj_id", smartApp.swan_app_id.longValue()).bS("obj_source", "PB_card").bS("tid", PbActivity.this.hLS.bTA()).O("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(((bh) view.getTag()).aiL(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 9));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bh) && PbActivity.this.checkUpIsLogin()) {
                                                                                bh bhVar2 = (bh) view.getTag();
                                                                                if (PbActivity.this.csF != null) {
                                                                                    PbActivity.this.csF.dY(bhVar2.aiL(), String.valueOf(bhVar2.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 10));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLS.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLS.bTA(), 0L), com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hLS.getPbData().bQz().aja())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbActivity.this.hLW.bVN();
                                                                SparseArray<Object> c3 = PbActivity.this.hLW.c(PbActivity.this.hLS.getPbData(), PbActivity.this.hLS.bTB(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLS.getPbData().getForum().getId(), PbActivity.this.hLS.getPbData().getForum().getName(), PbActivity.this.hLS.getPbData().bQz().getId(), String.valueOf(PbActivity.this.hLS.getPbData().getUserData().getUserId()), (String) c3.get(R.id.tag_forbid_user_name), (String) c3.get(R.id.tag_forbid_user_name_show), (String) c3.get(R.id.tag_forbid_user_post_id), (String) c3.get(R.id.tag_forbid_user_portrait))));
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        } else {
                                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                            if (skinType == 1) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                com.baidu.tbadk.core.util.am.amH();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).O("obj_type", 0).O("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).O("obj_type", 1).O("obj_source", 1));
                                                            }
                                                            PbActivity.this.hLW.hUV.bWK();
                                                        }
                                                    } else if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null) {
                                                        PbActivity.this.hLW.hUV.ZF();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbActivity.this.AH(PbActivity.this.hLS.getPbData().bQz().aiW());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hLW.bVN();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hLS.bTR()));
                                                            return;
                                                        }
                                                        PbActivity.this.wv(2);
                                                        PbActivity.this.bkk();
                                                        PbActivity.this.hLW.bVv();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hLS.getPbData().hJm == null || PbActivity.this.hLS.getPbData().hJm.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hLS.getPbData().hJm.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hLS.getPbData().hJm.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hLS.getPbData().hJm.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hLS.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hLS.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hLS.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hLS.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").O("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).O("obj_type", i12));
                                                                if (PbActivity.this.hLS.getPbData().hJm != null && PbActivity.this.hLS.getPbData().hJm.size() > i11) {
                                                                    i11 = PbActivity.this.hLS.getPbData().hJm.get(i11).sort_type.intValue();
                                                                }
                                                                boolean wJ = PbActivity.this.hLS.wJ(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hLS.bTR()));
                                                                if (wJ) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hLW.oA(true);
                                                                }
                                                            }
                                                        });
                                                        iVar.showDialog();
                                                    } else {
                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                PbActivity.this.hLW.bVN();
                                                if (PbActivity.this.bRF().getPbData().hJn != 2) {
                                                    if (PbActivity.this.hLS.getPageData() != null) {
                                                        PbActivity.this.hLW.a(PbActivity.this.hLS.getPageData(), PbActivity.this.hAg);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.isOn() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLS.hRb).bS("fid", PbActivity.this.hLS.getPbData().getForumId()).O("obj_locate", 4).bS("uid", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()));
                                            }
                                            if (PbActivity.this.hLS != null) {
                                                com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                anVar7.bS("tid", PbActivity.this.hLS.bTA());
                                                anVar7.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                anVar7.bS("fid", PbActivity.this.hLS.getForumId());
                                                anVar7.O("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    anVar7.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(anVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.isNetOk()) {
                                                if (PbActivity.this.hLS.getPbData() != null) {
                                                    ArrayList<PostData> bQB2 = PbActivity.this.hLS.getPbData().bQB();
                                                    if ((bQB2 != null && bQB2.size() > 0) || !PbActivity.this.hLS.bTB()) {
                                                        PbActivity.this.hLW.bVN();
                                                        PbActivity.this.bkk();
                                                        PbActivity.this.wv(2);
                                                        if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQS() != null && !StringUtils.isNull(PbActivity.this.hLS.getPbData().bQS().ahf(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bS("fid", PbActivity.this.hLS.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (bf.isOn()) {
                                                            PbActivity.this.ww(2);
                                                        } else {
                                                            PbActivity.this.hLW.showLoadingDialog();
                                                            PbActivity.this.hLS.bUe().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
                                                        }
                                                    } else {
                                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                } else {
                                                    com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                                    return;
                                                }
                                            } else {
                                                PbActivity.this.showToast(R.string.neterror);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbActivity.this.hLW.bVN();
                                        if (PbActivity.this.hLW.hUV.bWL() != null && view == PbActivity.this.hLW.hUV.bWL().bUB() && !PbActivity.this.hLW.bWf()) {
                                            PbActivity.this.hLW.bVa();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bkk();
                                            PbActivity.this.hLW.bVv();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbActivity.this.hLS.u(true, PbActivity.this.bSv());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbActivity.this.hLS.u(false, PbActivity.this.bSv()) : PbActivity.this.hLS.AM(PbActivity.this.bSv());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hLW.oj(true);
                                                PbActivity.this.hLW.bCv();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hLW.oA(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wv(2);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    PbActivity.this.hLW.bVN();
                                    if (PbActivity.this.wu(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbActivity.this.hLS.wK(PbActivity.this.hLW.bVA()) != null) {
                                        PbActivity.this.bSp();
                                        if (PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLS.hRb).bS("fid", PbActivity.this.hLS.getPbData().getForumId()).O("obj_locate", 3).bS("uid", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()));
                                        }
                                        if (PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null && PbActivity.this.hLS.getPbData().bQz().aiG().getUserId() != null && PbActivity.this.hLU != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bS("tid", PbActivity.this.hLS.hRb).O("obj_locate", 1).bS("obj_id", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()).O("obj_type", PbActivity.this.hLU.afm() ? 0 : 1).O("obj_source", PbActivity.this.c(PbActivity.this.hLS.getPbData())));
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    PbActivity.this.showToast(R.string.network_not_available);
                                    return;
                                }
                            } else {
                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                if (PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().ajA() && PbActivity.this.hLS.getPbData().bQz().aiX() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.hLS.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hLS.bRw()) && PbActivity.this.hLS.getAppealInfo() != null) {
                                        name = PbActivity.this.hLS.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hLS.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bRw = PbActivity.this.hLS.bRw();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hLS.bTC() && bRw != null && bRw.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg3));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            if (PbActivity.this.hLS.getPbData() != null) {
                                if ((PbActivity.this.hLS.getPbData().bQL() == 1 || PbActivity.this.hLS.getPbData().bQL() == 3) && !PbActivity.this.eNS.cpe()) {
                                    PbActivity.this.hLW.bVN();
                                    int i11 = 0;
                                    if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUC()) {
                                        if (PbActivity.this.hLW.hUV.bWL() == null || view != PbActivity.this.hLW.hUV.bWL().bUE()) {
                                            if (view == PbActivity.this.hLW.bVt()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hLS.getPbData().bQz().aiC() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hLS.getPbData().bQz().aiB() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hLS.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hLS.getPbData().bQz().getId();
                                    PbActivity.this.hLW.bVs();
                                    PbActivity.this.eNS.a(id4, name2, id5, i11, PbActivity.this.hLW.bVu());
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            PbActivity.this.showToast(R.string.network_not_available);
                            return;
                        }
                    } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbActivity.this.hLW.bVN();
                        PbActivity.this.bkk();
                        PbActivity.this.hLW.bVv();
                        PbActivity.this.hLW.showLoadingDialog();
                        if (PbActivity.this.hLW.bVi() != null) {
                            PbActivity.this.hLW.bVi().setVisibility(8);
                        }
                        PbActivity.this.hLS.wE(1);
                        if (PbActivity.this.hLx != null) {
                            PbActivity.this.hLx.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bSd = PbActivity.this.bSd();
                        if (!TextUtils.isEmpty(bSd)) {
                            ba.amQ().b(PbActivity.this.getPageContext(), new String[]{bSd});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hLS != null) {
                    com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                    anVar8.bS("tid", PbActivity.this.hLS.bTA());
                    anVar8.bS("fid", PbActivity.this.hLS.getForumId());
                    anVar8.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar8.O("obj_locate", 1);
                    TiebaStatic.log(anVar8);
                }
                if (PbActivity.this.hLG) {
                    PbActivity.this.hLG = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.bRX().bUY() != null && postData5.aiG() != null && postData5.cop() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bRX().bUZ() != null) {
                                PbActivity.this.bRX().bUZ().bTn();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hLS.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hLS.getPbData().bQz());
                            kVar2.e(postData5);
                            PbActivity.this.bRX().bUY().d(kVar2);
                            PbActivity.this.bRX().bUY().setPostId(postData5.getId());
                            PbActivity.this.b(view, postData5.aiG().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLS.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hMl != null) {
                                PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                    anVar.bS("fid", PbActivity.this.hLS.getPbData().getForumId());
                }
                if (PbActivity.this.hLS != null) {
                    anVar.bS("tid", PbActivity.this.hLS.bTA());
                }
                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.bkk();
            PbActivity.this.hLW.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.axj() && PbActivity.this.bRF() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bRF().AP(postWriteCallBackData.getPostId());
                    PbActivity.this.hMy = PbActivity.this.hLW.bVe();
                    if (PbActivity.this.hLS != null) {
                        PbActivity.this.hLS.ca(PbActivity.this.hMy, PbActivity.this.hLW.bVf());
                    }
                }
                PbActivity.this.hLW.bVN();
                PbActivity.this.hMb.bWm();
                if (PbActivity.this.hMl != null) {
                    PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                }
                PbActivity.this.hLW.bUX();
                PbActivity.this.hLW.oL(true);
                PbActivity.this.hLS.bTT();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hLS.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                            if (pbData != null && pbData.bQz() != null && pbData.bQz().aiG() != null && (userId = pbData.bQz().aiG().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.axj() && PbActivity.this.hLS.bTK()) {
                                PbActivity.this.hLW.bVv();
                            }
                        } else if (!com.baidu.tbadk.t.av.axj() && PbActivity.this.hLS.bTK()) {
                            PbActivity.this.hLW.bVv();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hLW.m(PbActivity.this.hLS.getPbData());
                    }
                    if (PbActivity.this.hLS.bTF()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").bS("tid", PbActivity.this.hLS.bTA()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hMl.auL() || PbActivity.this.hMl.auM()) {
                    PbActivity.this.hMl.a(false, postWriteCallBackData);
                }
                PbActivity.this.hMb.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gWL != null) {
                    PbActivity.this.gWL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (yVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hMY = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                    anVar.bS("fid", PbActivity.this.hLS.getPbData().getForumId());
                }
                if (PbActivity.this.hLS != null) {
                    anVar.bS("tid", PbActivity.this.hLS.bTA());
                }
                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbActivity.this.hMb != null) {
                    PbActivity.this.hMb.bWl();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gWL != null) {
                    PbActivity.this.gWL.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hMb != null) {
                if (PbActivity.this.hLW != null && PbActivity.this.hLW.bUZ() != null && PbActivity.this.hLW.bUZ().bTr() != null && PbActivity.this.hLW.bUZ().bTr().auM()) {
                    PbActivity.this.hLW.bUZ().bTr().a(postWriteCallBackData);
                }
                PbActivity.this.hMb.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hMZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bWk;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hLW != null && (bWk = PbActivity.this.hLW.bWk()) != null && PbActivity.this.hLW.getListView() != null) {
                            PbActivity.this.hLW.getListView().removeHeaderView(bWk);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hNa = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g jI;
            if (!z || dVar == null || dVar.bQJ() != null || com.baidu.tbadk.core.util.v.getCount(dVar.bQB()) >= 1) {
                PbActivity.this.hpa = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hLW.bVx();
                if (dVar == null || !dVar.bQF()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hLW.getView());
                }
                PbActivity.this.hLW.bCu();
                if (PbActivity.this.isFullScreen || PbActivity.this.hLW.bWf()) {
                    PbActivity.this.hLW.bVW();
                } else if (!PbActivity.this.hLW.bVT()) {
                    PbActivity.this.hLW.oL(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hMe = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hLW.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hLW.aMq();
                    if (dVar.bQz() != null && dVar.bQz().ajJ() != null) {
                        PbActivity.this.a(dVar.bQz().ajJ());
                    }
                    PbActivity.this.bRT();
                    if (PbActivity.this.hMl != null) {
                        PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bQB() != null && dVar.bQB().size() >= 1 && dVar.bQB().get(0) != null) {
                        PbActivity.this.hLS.AO(dVar.bQB().get(0).getId());
                    } else if (dVar.bQJ() != null) {
                        PbActivity.this.hLS.AO(dVar.bQJ().getId());
                    }
                    if (PbActivity.this.hMl != null) {
                        PbActivity.this.hMl.a(dVar.getAnti());
                        PbActivity.this.hMl.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hMl.a(PbActivity.this.hLS.bTN(), PbActivity.this.hLS.bTA(), PbActivity.this.hLS.bUg());
                        if (dVar.bQz() != null) {
                            PbActivity.this.hMl.fl(dVar.bQz().ajX());
                        }
                    }
                    if (PbActivity.this.hLU != null) {
                        PbActivity.this.hLU.dO(dVar.afm());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hLW.oK(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hLW.a(dVar, i2, i3, PbActivity.this.hLS.bTB(), i4, PbActivity.this.hLS.getIsFromMark());
                    PbActivity.this.hLW.e(dVar, PbActivity.this.hLS.bTB());
                    PbActivity.this.hLW.oH(PbActivity.this.hLS.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cGV = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cGV) && PbActivity.this.hMl != null && PbActivity.this.hMl.atZ() != null && (jI = PbActivity.this.hMl.atZ().jI(6)) != null && !TextUtils.isEmpty(PbActivity.this.cGV)) {
                            ((View) jI).setOnClickListener(PbActivity.this.cHJ);
                        }
                    }
                    if (PbActivity.this.hMg) {
                        PbActivity.this.hMg = false;
                        final int bSk = PbActivity.this.bSk();
                        if (!dVar.bQX()) {
                            PbActivity.this.hLW.wQ(bSk);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bSk, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hMh) {
                        PbActivity.this.hMh = false;
                        final int bSk2 = PbActivity.this.bSk();
                        final boolean z2 = bSk2 != -1;
                        if (!z2) {
                            bSk2 = PbActivity.this.bSl();
                        }
                        if (PbActivity.this.hLW != null) {
                            if (!dVar.bQX()) {
                                PbActivity.this.hLW.wQ(bSk2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bSk2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hLW.setSelectionFromTop(bSk2, equipmentWidth2);
                                            } else {
                                                PbActivity.this.hLW.setSelectionFromTop(bSk2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hLW.oM(true);
                                PbActivity.this.hLW.oL(false);
                            }
                        }
                    } else if (PbActivity.this.hMi) {
                        PbActivity.this.hMi = false;
                        PbActivity.this.hLW.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hLW.bVB();
                    }
                    PbActivity.this.hLS.a(dVar.getForum(), PbActivity.this.hML);
                    PbActivity.this.hLS.a(PbActivity.this.hMM);
                    if (PbActivity.this.gWL != null && dVar.bQz() != null && dVar.bQz().aiG() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bQz().aiG());
                        PbActivity.this.gWL.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hMe && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hLS != null && PbActivity.this.hLS.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hLS.getAppealInfo().hIG)) {
                                    PbActivity.this.hLW.a(PbActivity.this.hLS.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hLW.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hLW.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hLW.bVW();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hLS.bTA());
                            jSONObject.put("fid", PbActivity.this.hLS.getForumId());
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
                        PbActivity.this.hLW.AS("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                            arrayList = PbActivity.this.hLS.getPbData().bQB();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cop() != 1)) {
                            PbActivity.this.hLW.AS(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bSI()) {
                            PbActivity.this.hLW.AT(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hLW.AT(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hLW.endLoadData();
                }
                PbActivity.this.cMh = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bRF().bTB() || PbActivity.this.bRF().getPbData().getPage().ahB() != 0 || PbActivity.this.bRF().bUa()) {
                    PbActivity.this.hMm = true;
                    return;
                }
                return;
            }
            PbActivity.this.hLS.wE(1);
            if (PbActivity.this.hLx != null) {
                PbActivity.this.hLx.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hLW.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.awN().awO()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.fbN : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.cLZ, PbActivity.this.createTime, PbActivity.this.cMh, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cLZ = 0L;
                if (iVar != null) {
                    iVar.awK();
                }
                if (z2) {
                    iVar.cMq = currentTimeMillis;
                    iVar.fw(true);
                }
                if (!z2 && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null) {
                    int threadType = PbActivity.this.hLS.getPbData().bQz().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbActivity.this.hLJ, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbActivity.this.hLJ, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.setSubType(1000);
                                iVar2.cMs = currentTimeMillis;
                                iVar2.kg(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.cMs = currentTimeMillis;
                        dVar.kg(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hNb = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bSg();
            }
        }
    };
    private final a.InterfaceC0279a hNc = new a.InterfaceC0279a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0279a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hLW.bVx();
            if (z) {
                if (PbActivity.this.hLU != null) {
                    PbActivity.this.hLU.dO(z2);
                }
                PbActivity.this.hLS.or(z2);
                if (PbActivity.this.hLS.afm()) {
                    PbActivity.this.bSq();
                } else {
                    PbActivity.this.hLW.m(PbActivity.this.hLS.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hLU != null && PbActivity.this.hLU.afp() != null && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null) {
                        MarkData afp = PbActivity.this.hLU.afp();
                        MetaData aiG = PbActivity.this.hLS.getPbData().bQz().aiG();
                        if (afp != null && aiG != null) {
                            if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aiG.getUserId()) && !aiG.hadConcerned()) {
                                PbActivity.this.b(aiG);
                                return;
                            } else {
                                PbActivity.this.showToast(R.string.add_mark_on_pb);
                                return;
                            }
                        }
                        PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    return;
                }
                PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            PbActivity.this.showToast(PbActivity.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private final AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.50
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (!PbActivity.this.wr(PbActivity.this.mLastScrollState) && PbActivity.this.wr(i)) {
                if (PbActivity.this.hLW != null) {
                    PbActivity.this.hLW.bVN();
                    if (PbActivity.this.hMl != null && !PbActivity.this.hLW.bVb()) {
                        PbActivity.this.hLW.oJ(PbActivity.this.hMl.auF());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hLW.bVa();
                    }
                }
                if (!PbActivity.this.hLD) {
                    PbActivity.this.hLD = true;
                    PbActivity.this.hLW.bVS();
                }
            }
            PbActivity.this.hLW.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hLx != null) {
                PbActivity.this.hLx.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hLE == null) {
                PbActivity.this.hLE = new com.baidu.tbadk.p.b();
                PbActivity.this.hLE.setSubType(1001);
            }
            if (i == 0) {
                PbActivity.this.hLE.awE();
            } else {
                PbActivity.this.hLE.awD();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cnk().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bQB;
            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLW != null && PbActivity.this.hLW.bVr() != null) {
                PbActivity.this.hLW.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hLx != null) {
                    PbActivity.this.hLx.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hLS.bTV() && (bQB = PbActivity.this.hLS.getPbData().bQB()) != null && !bQB.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hLW.bVr().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                    if (pbData != null) {
                        if (pbData.bQC() != null && pbData.bQC().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bQD() != null && pbData.bQD().hasData()) {
                            headerCount--;
                        }
                        int size = bQB.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eNW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eNS.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hLS.bTT();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.icp != 1002 || bVar.dRK) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hLW.a(1, dVar.tf, dVar.jkX, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eNS.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hLW.a(PbActivity.this.eNS.getLoadDataMode(), gVar.tf, gVar.jkX, false);
                        PbActivity.this.hLW.aB(gVar.jla);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hLW.a(PbActivity.this.eNS.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hNd = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c dkw = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.bSw()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hLS.oq(true)) {
                PbActivity.this.hLW.bVy();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fPX = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hNe && PbActivity.this.bSw()) {
                PbActivity.this.bSy();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hLS.op(false)) {
                    PbActivity.this.hLW.bVw();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hLS.getPbData() != null) {
                    PbActivity.this.hLW.bVR();
                }
                PbActivity.this.hNe = true;
            }
        }
    };
    private int hNf = 0;
    private final TbRichTextView.h cUE = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bVr;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hLS != null) {
                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                        anVar.bS("tid", PbActivity.this.hLS.bTA());
                        anVar.bS("fid", PbActivity.this.hLS.getForumId());
                        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar.O("obj_locate", 3);
                        anVar.O("obj_type", z2 ? 1 : 2);
                        TiebaStatic.log(anVar);
                    }
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                        }
                        PbActivity.this.hLN = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hNV) {
                        TbRichText bb = PbActivity.this.bb(str, i);
                        if (bb != null && PbActivity.this.hNf >= 0 && PbActivity.this.hNf < bb.azh().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bb.azh().get(PbActivity.this.hNf));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hNS.size()) {
                                    break;
                                } else if (!cVar.hNS.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bb.getPostId() != 0 && (bVr = PbActivity.this.hLW.bVr()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bVr.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bb.getPostId() == com.baidu.adp.lib.g.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bb.getPostId() != com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLS.bUg(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLS.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hNT.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNU, cVar.lastId, PbActivity.this.hLS.bTQ(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.i(rect);
                            createConfig.setIsHotSort(PbActivity.this.hLS.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.getItem(cVar.hNS, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hNT.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNU, cVar.hNS.get(0), PbActivity.this.hLS.bTQ(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hLS.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hLW.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hNg = false;
    PostData gpk = null;
    private final b.a hNh = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.gpk != null) {
                if (i == 0) {
                    PbActivity.this.gpk.ec(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.gpk = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.gpk);
                }
            }
        }
    };
    private final b.a hNi = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hMv != null && !TextUtils.isEmpty(PbActivity.this.hMw)) {
                if (i == 0) {
                    if (PbActivity.this.hMx == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.hMw));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hMw;
                        aVar.pkgId = PbActivity.this.hMx.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hMx.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    PbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    PbActivity.this.mPermissionJudgement.appendRequestPermission(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.startRequestPermission(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fXD == null) {
                            PbActivity.this.fXD = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fXD.g(PbActivity.this.hMw, PbActivity.this.hMv.getImageByte());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hMv = null;
                PbActivity.this.hMw = null;
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean oa;
            com.baidu.tbadk.core.dialog.g gVar;
            com.baidu.tbadk.core.dialog.g gVar2;
            int i;
            SparseArray sparseArray;
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (PbActivity.this.cu(view)) {
                    if (view instanceof TbImageView) {
                        PbActivity.this.hMv = ((TbImageView) view).getBdImage();
                        PbActivity.this.hMw = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hMv == null || TextUtils.isEmpty(PbActivity.this.hMw)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hMx = null;
                        } else {
                            PbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hMv = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hMw = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hMx = null;
                            } else {
                                PbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hMv = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hMw = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hMx = null;
                        } else {
                            PbActivity.this.hMx = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hLW.a(PbActivity.this.hNi, PbActivity.this.hMv.isGif());
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
            PbActivity.this.gpk = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.gpk == null) {
                return true;
            }
            if (PbActivity.this.gpk.cop() != 1 || !PbActivity.this.cu(view)) {
                if (PbActivity.this.hLU != null) {
                    if (!PbActivity.this.hLU.afm() || PbActivity.this.gpk.getId() == null || !PbActivity.this.gpk.getId().equals(PbActivity.this.hLS.aiP())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.gpk.cop() == 1) {
                        PbActivity.this.hLW.a(PbActivity.this.hNh, z, false);
                        return true;
                    }
                    if (PbActivity.this.hMd == null) {
                        PbActivity.this.hMd = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hMd.a(PbActivity.this.hNj);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cu = PbActivity.this.cu(view);
                        boolean z3 = (!PbActivity.this.cu(view) || PbActivity.this.hMv == null || PbActivity.this.hMv.isGif()) ? false : true;
                        boolean z4 = false;
                        boolean z5 = false;
                        boolean z6 = false;
                        boolean z7 = false;
                        boolean z8 = false;
                        boolean z9 = false;
                        if (sparseArray2.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean) {
                            z2 = ((Boolean) sparseArray2.get(R.id.tag_should_hide_chudian_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean) {
                            z4 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                            z5 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                            z6 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                            z7 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                            z8 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                        }
                        if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                            z9 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                        }
                        if (!(sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                            str = null;
                        } else {
                            str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                        }
                        if (z2) {
                            long j = 0;
                            String str2 = "";
                            if (sparseArray2.get(R.id.tag_chudian_template_id) instanceof Long) {
                                j = ((Long) sparseArray2.get(R.id.tag_chudian_template_id)).longValue();
                            }
                            if (sparseArray2.get(R.id.tag_chudian_monitor_id) instanceof String) {
                                str2 = (String) sparseArray2.get(R.id.tag_chudian_monitor_id);
                            }
                            if (!(sparseArray2.get(R.id.tag_chudian_hide_day) instanceof Integer)) {
                                i = 0;
                            } else {
                                i = ((Integer) sparseArray2.get(R.id.tag_chudian_hide_day)).intValue();
                            }
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hMd);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cu) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hMd));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hMd));
                        }
                        if (!cu && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hMd);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.gpk);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hMd);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hMd);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.gpk);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hMd);
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
                                gVar5.mTextView.setTag(sparseArray5);
                                arrayList.add(gVar5);
                            } else {
                                if (!ap.m(PbActivity.this.gpk)) {
                                    oa = PbActivity.this.oa(z5) & PbActivity.this.isLogin();
                                } else {
                                    oa = false;
                                }
                                if (oa) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hMd);
                                    gVar6.mTextView.setTag(str);
                                    arrayList.add(gVar6);
                                }
                            }
                            com.baidu.tbadk.core.dialog.g gVar7 = null;
                            if (z7) {
                                SparseArray sparseArray6 = new SparseArray();
                                sparseArray6.put(R.id.tag_should_manage_visible, true);
                                sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                                sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                                sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                                sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                                if (z8) {
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
                                if (z9) {
                                    sparseArray6.put(R.id.tag_should_delete_visible, true);
                                    sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                    sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hMd);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hMd);
                                gVar.mTextView.setTag(sparseArray6);
                            } else {
                                if (z9) {
                                    SparseArray sparseArray7 = new SparseArray();
                                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                                    if (PbActivity.this.hLS.getPbData().bQL() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hMd);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hMd);
                                    }
                                    gVar7.mTextView.setTag(sparseArray7);
                                }
                                gVar = null;
                            }
                            if (gVar7 != null) {
                                arrayList.add(gVar7);
                            }
                            if (gVar != null) {
                                arrayList.add(gVar);
                            }
                        }
                        PbActivity.this.hMd.at(arrayList);
                        PbActivity.this.hMc = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hMd);
                        PbActivity.this.hMc.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").bS("tid", PbActivity.this.hLS.hRb).bS("fid", PbActivity.this.hLS.getForumId()).bS("uid", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()).bS("post_id", PbActivity.this.hLS.auu()).O("obj_source", z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hLW.a(PbActivity.this.hNi, PbActivity.this.hMv.isGif());
            return true;
        }
    };
    private k.c hNj = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hMc != null) {
                PbActivity.this.hMc.dismiss();
            }
            switch (i) {
                case 0:
                    long j = -1;
                    String str = "";
                    int i2 = 0;
                    if (view.getTag(R.id.tag_chudian_template_id) instanceof Long) {
                        j = ((Long) view.getTag(R.id.tag_chudian_template_id)).longValue();
                    }
                    if (view.getTag(R.id.tag_chudian_monitor_id) instanceof String) {
                        str = (String) view.getTag(R.id.tag_chudian_monitor_id);
                    }
                    if (view.getTag(R.id.tag_chudian_hide_day) instanceof Integer) {
                        i2 = ((Integer) view.getTag(R.id.tag_chudian_hide_day)).intValue();
                    }
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLS.getPbData();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    if (pbData != null && pbData.getForum() != null) {
                        str2 = pbData.getForum().getId();
                        str3 = pbData.getForum().getName();
                        str4 = pbData.getThreadId();
                    }
                    com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FB", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                    PbActivity.this.a(j, str, str2, str3, str4, i2);
                    return;
                case 1:
                    if (PbActivity.this.hMv != null && !TextUtils.isEmpty(PbActivity.this.hMw)) {
                        if (PbActivity.this.hMx == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.hMw));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hMw;
                            aVar.pkgId = PbActivity.this.hMx.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hMx.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbActivity.this.hMv = null;
                        PbActivity.this.hMw = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hMv != null && !TextUtils.isEmpty(PbActivity.this.hMw)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        PbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        PbActivity.this.mPermissionJudgement.appendRequestPermission(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.startRequestPermission(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fXD == null) {
                                PbActivity.this.fXD = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fXD.g(PbActivity.this.hMw, PbActivity.this.hMv.getImageByte());
                            PbActivity.this.hMv = null;
                            PbActivity.this.hMw = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.gpk != null) {
                        PbActivity.this.gpk.ec(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.gpk = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").O("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ct(view);
                        if (PbActivity.this.hLS.getPbData().bQz() != null && PbActivity.this.hLS.getPbData().bQz().aiG() != null && PbActivity.this.hLS.getPbData().bQz().aiG().getUserId() != null && PbActivity.this.hLU != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bS("tid", PbActivity.this.hLS.hRb).O("obj_locate", 2).bS("obj_id", PbActivity.this.hLS.getPbData().bQz().aiG().getUserId()).O("obj_type", PbActivity.this.hLU.afm() ? 0 : 1).O("obj_source", PbActivity.this.c(PbActivity.this.hLS.getPbData())));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13079"));
                        PbActivity.this.AH((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").O("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.b(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbActivity.this.hLW.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PbActivity.this.showToast(R.string.network_not_available);
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
                                PbActivity.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.hLW.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hLW.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a fsT = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbActivity.this.aqC && z && !PbActivity.this.hLS.bTH()) {
                PbActivity.this.bSs();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.fzw.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0405a eYb = new a.InterfaceC0405a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int dRr;

        {
            this.dRr = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
            if (aj(i2) && PbActivity.this.hLW != null && PbActivity.this.hLx != null) {
                PbActivity.this.hLW.bVX();
                PbActivity.this.hLx.kc(false);
                PbActivity.this.hLx.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
            if (aj(i2) && PbActivity.this.hLW != null && PbActivity.this.hLx != null) {
                PbActivity.this.hLx.kc(true);
                if (Math.abs(i2) > this.dRr) {
                    PbActivity.this.hLx.hideFloatingView();
                }
                if (PbActivity.this.bSw()) {
                    PbActivity.this.hLW.bVo();
                    PbActivity.this.hLW.bVp();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }

        private boolean aj(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hNl = null;
    private final m.a hNm = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hNl = str2;
                PbActivity.this.hLW.AU(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hNn = -1;
    private int hNo = -1;
    private CustomMessageListener hNr = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bWy == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0281a) {
                    if (aVar.bWz != null && !aVar.bWz.hasError() && aVar.bWz.getError() == 0) {
                        if (PbActivity.this.hLW != null) {
                            PbActivity.this.hLW.r(((a.C0281a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bSH();
                        }
                    } else if (z) {
                        if (aVar.bWz != null && aVar.bWz.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bWz.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bWz != null && !aVar.bWz.hasError() && aVar.bWz.getError() == 0) {
                        if (PbActivity.this.hLW != null && PbActivity.this.hLW != null) {
                            PbActivity.this.hLW.r(((a.C0281a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bWz != null && aVar.bWz.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bWz.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bWz == null || aVar.bWz.hasError() || aVar.bWz.getError() != 0) {
                        if (z) {
                            if (aVar.bWz != null && aVar.bWz.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bWz.getErrorString());
                            } else {
                                PbActivity.this.showToast(R.string.fail_open_channel_push);
                            }
                        }
                    } else if (z) {
                        Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(R.string.channel_need_push), 1).show();
                    }
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        boolean onBackPressed();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void callback(Object obj);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public ArrayList<String> hNS;
        public ConcurrentHashMap<String, ImageUrlData> hNT;
        public boolean hNV;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hNU = false;
        public boolean hNW = false;
        public String lastId = "";
        public int index = 0;
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    public com.baidu.tbadk.editortools.pb.d bRS() {
        return this.hMl;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bRi() != null) {
            String id = kVar.bRi().getId();
            ArrayList<PostData> bQB = this.hLS.getPbData().bQB();
            int i = 0;
            while (true) {
                if (i >= bQB.size()) {
                    break;
                }
                PostData postData = bQB.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bRm = kVar.bRm();
                    postData.zQ(kVar.getTotalCount());
                    if (postData.com() != null && bRm != null) {
                        Iterator<PostData> it = bRm.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aiG() != null && (metaData = postData.getUserMap().get(next.aiG().getUserId())) != null) {
                                next.a(metaData);
                                next.qQ(true);
                                next.a(getPageContext(), this.hLS.AN(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bRm.size() != postData.com().size();
                        postData.com().clear();
                        postData.com().addAll(bRm);
                        z = z2;
                    }
                    if (postData.coi() != null) {
                        postData.coj();
                    }
                }
            }
            if (!this.hLS.getIsFromMark() && z) {
                this.hLW.m(this.hLS.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bQO = this.hLS.getPbData().bQO();
            if (bQO != null && str.equals(bQO.getAdId())) {
                if (bQO.cod() != null) {
                    bQO.cod().legoCard = null;
                }
                this.hLS.getPbData().bQP();
            }
            com.baidu.tieba.tbadkCore.data.m bTL = this.hLS.bTL();
            if (bTL != null && str.equals(bTL.getAdId())) {
                this.hLS.bTM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hMc != null && this.hMc.isShowing()) {
                this.hMc.dismiss();
                this.hMc = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hMc != null) {
                            PbActivity.this.hMc.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hLW.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hMt);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hMt);
                            PbActivity.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
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
                kVar.at(arrayList);
                this.hMc = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.hMc.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
        bh bQz;
        if (this.hLS != null && this.hLS.getPbData() != null && (bQz = this.hLS.getPbData().bQz()) != null) {
            if (i == 1) {
                PraiseData ais = bQz.ais();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (ais == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bQz.a(praiseData);
                    } else {
                        bQz.ais().getUser().add(0, metaData);
                        bQz.ais().setNum(bQz.ais().getNum() + 1);
                        bQz.ais().setIsLike(i);
                    }
                }
                if (bQz.ais() != null) {
                    if (bQz.ais().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(bQz.ais().getNum());
                    }
                }
            } else if (bQz.ais() != null) {
                bQz.ais().setIsLike(i);
                bQz.ais().setNum(bQz.ais().getNum() - 1);
                ArrayList<MetaData> user = bQz.ais().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bQz.ais().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bQz.ais().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bQz.ais().getNum() + "";
                }
            }
            if (this.hLS.bTB()) {
                this.hLW.bVr().notifyDataSetChanged();
            } else {
                this.hLW.n(this.hLS.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hLS.aa(bundle);
        if (this.fvn != null) {
            this.fvn.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hMl.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hLC = System.currentTimeMillis();
        this.hMr = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.fbN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hLJ = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hLJ) && intent.getData() != null) {
                this.hLJ = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hLJ)) {
                this.hLy = true;
            }
            this.hNn = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hNo = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hNp = intent.getStringExtra("key_manga_title");
            this.hMg = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hMh = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hMi = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bSw()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.hMz = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.hLQ = new com.baidu.tbadk.core.data.av();
            this.hLQ.U(intent);
        } else {
            this.fbN = System.currentTimeMillis();
        }
        this.cLZ = this.hLC - this.fbN;
        super.onCreate(bundle);
        this.hLA = 0;
        Z(bundle);
        if (this.hLS != null && this.hLS.getPbData() != null) {
            this.hLS.getPbData().AD(this.source);
        }
        bRW();
        initUI();
        if (intent != null && this.hLW != null) {
            this.hLW.hUO = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hMu == null) {
                    this.hMu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hLW.AW("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hMu, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hLS != null && this.hLS.getPbData() != null) {
                this.hLS.AQ(stringExtra);
            }
        }
        this.fvn = new VoiceManager();
        this.fvn.onCreate(getPageContext());
        initData(bundle);
        this.hMk = new com.baidu.tbadk.editortools.pb.f();
        bRT();
        this.hMl = (com.baidu.tbadk.editortools.pb.d) this.hMk.cw(getActivity());
        this.hMl.b(this);
        this.hMl.a(this.cHf);
        this.hMl.a(this.cGY);
        this.hMl.a(this, bundle);
        this.hMl.atZ().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hMl.atZ().fe(true);
        nZ(true);
        this.hLW.setEditorTools(this.hMl.atZ());
        this.hMl.a(this.hLS.bTN(), this.hLS.bTA(), this.hLS.bUg());
        registerListener(this.hMG);
        if (!this.hLS.bTG()) {
            this.hMl.pK(this.hLS.bTA());
        }
        if (this.hLS.bUh()) {
            this.hMl.pI(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hLW != null) {
            this.hMl.pI(this.hLW.bVc());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hMF);
        registerListener(this.hMH);
        registerListener(this.hMI);
        registerListener(this.fwJ);
        registerListener(this.hMX);
        registerListener(this.hME);
        this.hMj = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.jhN);
        this.hMj.cnR();
        registerListener(this.hMK);
        registerListener(this.cjZ);
        if (this.hLS != null) {
            this.hLS.bTY();
        }
        registerListener(this.hNb);
        registerListener(this.hNr);
        registerListener(this.fwQ);
        if (this.hLW != null && this.hLW.bWb() != null && this.hLW.bWc() != null) {
            this.hLx = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hLW.bWb(), this.hLW.bWc(), this.hLW.bVi());
            this.hLx.a(this.hMS);
        }
        if (this.hLw && this.hLW != null && this.hLW.bWc() != null) {
            this.hLW.bWc().setVisibility(8);
        }
        this.hMs = new com.baidu.tbadk.core.view.e();
        this.hMs.toastTime = 1000L;
        registerListener(this.hMW);
        registerListener(this.hMU);
        registerListener(this.hMV);
        registerListener(this.fMU);
        registerListener(this.fwG);
        this.hMt = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hMt;
        userMuteAddAndDelCustomMessage.setTag(this.hMt);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.hMt;
        userMuteCheckCustomMessage.setTag(this.hMt);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hLS.bUe().a(this.hMT);
        this.hMb = new as();
        if (this.hMl.auy() != null) {
            this.hMb.g(this.hMl.auy().getInputView());
        }
        this.hMl.a(this.cGZ);
        this.fLK = new ShareSuccessReplyToServerModel();
        a(this.hMB);
        this.gWL = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gWL.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.cjQ) {
                        PbActivity.this.hMl.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cjR && PbActivity.this.hLW != null && PbActivity.this.hLW.bUZ() != null && PbActivity.this.hLW.bUZ().bTr() != null) {
                        PbActivity.this.hLW.bUZ().bTr().auR();
                    } else if (i == com.baidu.tbadk.core.util.aj.cjS) {
                        PbActivity.this.c(PbActivity.this.hMo);
                    }
                }
            }
        });
        this.hLT = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLT.s(getUniqueId());
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        com.baidu.tbadk.core.business.a.agC().bH("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.hLC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRT() {
        if (this.hMk != null && this.hLS != null) {
            this.hMk.setForumName(this.hLS.bRw());
            if (this.hLS.getPbData() != null && this.hLS.getPbData().getForum() != null) {
                this.hMk.a(this.hLS.getPbData().getForum());
            }
            this.hMk.setFrom("pb");
            this.hMk.a(this.hLS);
        }
    }

    public String bRU() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bRV() {
        return this.hLx;
    }

    private void nZ(boolean z) {
        this.hMl.fi(z);
        this.hMl.fj(z);
        this.hMl.fk(z);
    }

    private void bRW() {
        this.csF = new LikeModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQX() && !z && this.hLW != null && this.hLW.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hLW.getView().setSystemUiVisibility(4);
        }
        this.hMp = z;
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            Rect rect = new Rect();
            frameLayout.getWindowVisibleDisplayFrame(rect);
            ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
            childAt.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    public aq bRX() {
        return this.hLW;
    }

    public PbModel bRF() {
        return this.hLS;
    }

    public void AG(String str) {
        if (this.hLS != null && !StringUtils.isNull(str) && this.hLW != null) {
            this.hLW.oO(true);
            this.hLS.AG(str);
            this.hLI = true;
            this.hLW.bVN();
            this.hLW.bVW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.aqC = false;
        } else {
            this.aqC = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hLA = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hLA == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
        if (this.hLW != null) {
            this.hLW.onPause();
        }
        if (!this.hLS.bTG()) {
            this.hMl.pJ(this.hLS.bTA());
        }
        if (this.hLS != null) {
            this.hLS.bTZ();
        }
        com.baidu.tbadk.BdToken.c.adZ().aee();
        MessageManager.getInstance().unRegisterListener(this.gAF);
        bvU();
        MessageManager.getInstance().unRegisterListener(this.hMU);
        MessageManager.getInstance().unRegisterListener(this.hMV);
        MessageManager.getInstance().unRegisterListener(this.hMW);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean bRY() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hLS.getPbData(), this.hLS.bTB(), this.hLS.bTW());
        return (a2 == null || a2.aiG() == null || a2.aiG().getGodUserData() == null || a2.aiG().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.aqC = false;
        super.onResume();
        if (this.hLL) {
            this.hLL = false;
            bSC();
        }
        if (bRY()) {
            this.hLF = System.currentTimeMillis();
        } else {
            this.hLF = -1L;
        }
        if (this.hLW != null && this.hLW.getView() != null) {
            if (!this.hpa) {
                bSt();
            } else {
                hideLoadingView(this.hLW.getView());
            }
            this.hLW.onResume();
        }
        if (this.hLA == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hLW != null) {
            noNetworkView = this.hLW.bUW();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
        registerListener(this.gAF);
        this.hMf = false;
        bSB();
        registerListener(this.hMU);
        registerListener(this.hMV);
        registerListener(this.hMW);
        if (this.fwc) {
            bSs();
            this.fwc = false;
        }
        bSK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hLW.oD(z);
        if (this.hMc != null) {
            this.hMc.dismiss();
        }
        if (z && this.hMf) {
            this.hLW.bVw();
            this.hLS.op(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hLF > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").bS("obj_duration", (System.currentTimeMillis() - this.hLF) + ""));
            this.hLF = 0L;
        }
        if (bRX().bUZ() != null) {
            bRX().bUZ().onStop();
        }
        if (this.hLW.hUV != null && !this.hLW.hUV.bbg()) {
            this.hLW.hUV.bHq();
        }
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().getForum() != null && this.hLS.getPbData().bQz() != null) {
            com.baidu.tbadk.distribute.a.atN().a(getPageContext().getPageActivity(), "pb", this.hLS.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLS.getPbData().bQz().getId(), 0L));
        }
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("fid", this.hLS.getPbData().getForumId());
            anVar.bS("tid", this.hLS.bTA());
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hLD && this.hLW != null) {
            this.hLD = true;
            this.hLW.bVS();
            a(false, (PostData) null);
        }
        if (this.hLS != null) {
            this.hLS.cancelLoadData();
            this.hLS.destory();
            if (this.hLS.bUd() != null) {
                this.hLS.bUd().onDestroy();
            }
        }
        if (this.hMl != null) {
            this.hMl.onDestroy();
        }
        if (this.eNS != null) {
            this.eNS.cancelLoadData();
        }
        if (this.csF != null) {
            this.csF.cnF();
        }
        if (this.hLW != null) {
            this.hLW.onDestroy();
            if (this.hLW.hUV != null) {
                this.hLW.hUV.bHq();
            }
        }
        if (this.hLE != null) {
            this.hLE.awF();
        }
        if (this.hLx != null) {
            this.hLx.axM();
        }
        super.onDestroy();
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
        this.hLW.bVN();
        MessageManager.getInstance().unRegisterListener(this.hMU);
        MessageManager.getInstance().unRegisterListener(this.hMV);
        MessageManager.getInstance().unRegisterListener(this.hMW);
        MessageManager.getInstance().unRegisterListener(this.hMt);
        MessageManager.getInstance().unRegisterListener(this.hMX);
        MessageManager.getInstance().unRegisterListener(this.fwQ);
        MessageManager.getInstance().unRegisterListener(this.fMU);
        MessageManager.getInstance().unRegisterListener(this.hMZ);
        this.hMr = null;
        this.hMs = null;
        com.baidu.tieba.recapp.d.a.cgD().cgF();
        if (this.hMu != null) {
            getSafeHandler().removeCallbacks(this.hMu);
        }
        if (this.hLM != null) {
            this.hLM.cancelLoadData();
        }
        if (this.hLW != null && this.hLW.hUV != null) {
            this.hLW.hUV.bWP();
        }
        if (this.fLK != null) {
            this.fLK.cancelLoadData();
        }
        this.hMb.onDestroy();
        if (this.hLS != null && this.hLS.bUf() != null) {
            this.hLS.bUf().onDestroy();
        }
        if (this.gWL != null) {
            this.gWL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bVr;
        ArrayList<PostData> bTc;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aoU() && this.hLW != null && (bVr = this.hLW.bVr()) != null && (bTc = bVr.bTc()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bTc.iterator();
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
                        bVar.ePN = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.ccN == 1 && !TextUtils.isEmpty(id)) {
                    next.ccN = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.ePN = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hLS == null || this.hLS.getPbData() == null || this.hLS.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hLS.getPbData().getForum().getFirst_class();
                    str2 = this.hLS.getPbData().getForum().getSecond_class();
                    str = this.hLS.getPbData().getForum().getId();
                    str4 = this.hLS.bTA();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aoX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hLW.onChangeSkinType(i);
            if (this.hMl != null && this.hMl.atZ() != null) {
                this.hMl.atZ().onChangeSkinType(i);
            }
            if (this.hLW.bUW() != null) {
                this.hLW.bUW().onChangeSkinType(getPageContext(), i);
            }
            this.hMb.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hLW = new aq(this, this.fxy, this.czv);
        this.fzw = new com.baidu.tieba.f.b(getActivity());
        this.fzw.a(hNk);
        this.fzw.a(this.eYb);
        this.hLW.setOnScrollListener(this.mOnScrollListener);
        this.hLW.d(this.fPX);
        this.hLW.setListPullRefreshListener(this.dkw);
        this.hLW.nT(com.baidu.tbadk.core.i.agq().isShowImages());
        this.hLW.setOnImageClickListener(this.cUE);
        this.hLW.b(this.mOnLongClickListener);
        this.hLW.h(this.fsT);
        this.hLW.a(this.hNd);
        this.hLW.oD(this.mIsLogin);
        if (getIntent() != null) {
            this.hLW.oP(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hLW.bUY().setFromForumId(this.hLS.getFromForumId());
    }

    public void bRZ() {
        if (this.hLW != null && this.hLS != null) {
            if ((this.hLS.getPbData() != null || this.hLS.getPbData().bQW() != null) && checkUpIsLogin() && this.hLW.bVr() != null && this.hLW.bVr().bTh() != null) {
                this.hLW.bVr().bTh().oz(this.hLS.bTA());
            }
        }
    }

    public void bSa() {
        TiebaStatic.log("c12181");
        if (this.hLW != null && this.hLS != null) {
            if (this.hLW == null || this.hLW.bVb()) {
                if (this.hLS.getPbData() != null || this.hLS.getPbData().bQW() != null) {
                    com.baidu.tieba.pb.data.j bQW = this.hLS.getPbData().bQW();
                    if (checkUpIsLogin()) {
                        if ((!bQW.bRf() || bQW.akb() != 2) && this.hLW.bVr() != null && this.hLW.bVr().bTh() != null) {
                            this.hLW.bVr().bTh().oz(this.hLS.bTA());
                        }
                        if (System.currentTimeMillis() - this.hLH > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pj(false);
                            this.hLH = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cs(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (postData.getType() != PostData.jip && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.agq().isShowImages()) {
                    return AJ(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hLS == null || this.hLS.getPbData() == null) {
                        return true;
                    }
                    if (bRX().bUZ() != null) {
                        bRX().bUZ().bTn();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hLS.getPbData().getForum());
                    kVar.ai(this.hLS.getPbData().bQz());
                    kVar.e(postData);
                    bRX().bUY().d(kVar);
                    bRX().bUY().setPostId(postData.getId());
                    b(view, postData.aiG().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hMl != null) {
                        this.hLW.oJ(this.hMl.auF());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.hLW != null) {
            if (z && !this.hpa) {
                bSt();
            } else {
                hideLoadingView(this.hLW.getView());
            }
            if (z && this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQX() && this.hLW.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hLW.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bSb() {
        if (this.hLB == null) {
            this.hLB = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hLB.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hLr = PbActivity.this.hLr.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLr);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLS.bTA(), PbActivity.this.hLr, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hLr = PbActivity.this.hLr.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLr);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLS.bTA(), PbActivity.this.hLr, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hLr = PbActivity.this.hLr.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLr);
                        bVar.dismiss();
                    }
                }
            }).hZ(R.style.dialog_ani_b2t).ia(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hLS = new PbModel(this);
        this.hLS.a(this.hNa);
        if (this.hLS.bUc() != null) {
            this.hLS.bUc().a(this.hNm);
        }
        if (this.hLS.bUb() != null) {
            this.hLS.bUb().a(this.hMJ);
        }
        if (this.hLS.bUd() != null) {
            this.hLS.bUd().b(this.hMD);
        }
        if (bundle != null) {
            this.hLS.initWithBundle(bundle);
        } else {
            this.hLS.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.hLS.os(true);
        }
        aj.bUK().ap(this.hLS.bTy(), this.hLS.getIsFromMark());
        if (StringUtils.isNull(this.hLS.bTA())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hLJ) && this.hLJ != null) {
            this.hLS.wL(6);
        }
        this.hLS.loadData();
    }

    private void initData(Bundle bundle) {
        this.hLU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLU != null) {
            this.hLU.a(this.hNc);
        }
        this.eNS = new ForumManageModel(this);
        this.eNS.setLoadDataCallBack(this.eNW);
        this.cjV = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hLW.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hLS.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLS.getPbData().getForum().getId(), PbActivity.this.hLS.getPbData().getForum().getName(), PbActivity.this.hLS.getPbData().bQz().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hMP.setUniqueId(getUniqueId());
        this.hMP.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hLW.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hMt;
        userMuteCheckCustomMessage.setTag(this.hMt);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bSc() {
        if (checkUpIsLogin()) {
            if (this.fyU == null) {
                this.fyU = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fyU.rz(0);
                this.fyU.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jW(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void o(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jX(boolean z) {
                        if (z) {
                            PbActivity.this.hLW.bvz();
                        }
                    }
                });
            }
            if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().getForum() != null) {
                this.fyU.z(this.hLS.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bSd() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hLS != null && (pbData = this.hLS.getPbData()) != null) {
            return pbData.bQK().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQz() != null) {
            if (dVar.bQz().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bQz().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bQz().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bSe()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hLO);
                this.hLP = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hMn == null) {
                this.hMn = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hMn.rz(1);
                this.hMn.a(new AnonymousClass40(str, str2));
            }
            if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().getForum() != null) {
                this.hMn.z(this.hLS.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hNB;
        final /* synthetic */ String hNC;

        AnonymousClass40(String str, String str2) {
            this.hNB = str;
            this.hNC = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void o(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jX(boolean z) {
            if (z) {
                PbActivity.this.getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(PbActivity.this.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbActivity.this.bRX().getListView().smoothScrollBy((PbActivity.this.hLO[1] + PbActivity.this.hLP) - (equipmentHeight - dimens), 50);
                        if (PbActivity.this.bRX().bUZ() != null) {
                            PbActivity.this.hMl.atZ().setVisibility(8);
                            PbActivity.this.bRX().bUZ().ab(AnonymousClass40.this.hNB, AnonymousClass40.this.hNC, PbActivity.this.bRX().bVc());
                            com.baidu.tbadk.editortools.pb.g bTr = PbActivity.this.bRX().bUZ().bTr();
                            if (bTr != null && PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                                bTr.a(PbActivity.this.hLS.getPbData().getAnti());
                            }
                            if (PbActivity.this.hMb.bWp() == null && PbActivity.this.bRX().bUZ().bTr().auZ() != null) {
                                PbActivity.this.bRX().bUZ().bTr().auZ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hMb != null && PbActivity.this.hMb.bWo() != null) {
                                            if (!PbActivity.this.hMb.bWo().cxB()) {
                                                PbActivity.this.hMb.oR(false);
                                            }
                                            PbActivity.this.hMb.bWo().rL(false);
                                        }
                                    }
                                });
                                PbActivity.this.hMb.h(PbActivity.this.bRX().bUZ().bTr().auZ().getInputView());
                                PbActivity.this.bRX().bUZ().bTr().a(PbActivity.this.hMq);
                            }
                        }
                        PbActivity.this.bRX().bVW();
                    }
                }, 0L);
            }
        }
    }

    public boolean bSe() {
        if (this.gWL == null || this.hLS.getPbData() == null || this.hLS.getPbData().getAnti() == null) {
            return true;
        }
        return this.gWL.iq(this.hLS.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean wt(int i) {
        if (this.gWL == null || this.hLS.getPbData() == null || this.hLS.getPbData().getAnti() == null) {
            return true;
        }
        return this.gWL.aa(this.hLS.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hLS != null && this.hLS.getPbData() != null && postData.cop() != 1) {
            String bTA = this.hLS.bTA();
            String id = postData.getId();
            int bQL = this.hLS.getPbData() != null ? this.hLS.getPbData().bQL() : 0;
            c AK = AK(id);
            if (AK != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bTA, id, "pb", true, null, false, null, bQL, postData.bXF(), this.hLS.getPbData().getAnti(), false, postData.aiG() != null ? postData.aiG().getIconInfo() : null).addBigImageData(AK.hNS, AK.hNT, AK.hNU, AK.index);
                addBigImageData.setKeyPageStartFrom(this.hLS.bUj());
                addBigImageData.setFromFrsForumId(this.hLS.getFromForumId());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSf() {
        if (this.hLS.getPbData() == null || this.hLS.getPbData().bQz() == null) {
            return -1;
        }
        return this.hLS.getPbData().bQz().ajq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSg() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Dl(this.hLS.getForumId()) && this.hLS.getPbData() != null && this.hLS.getPbData().getForum() != null) {
            if (this.hLS.getPbData().getForum().isLike() == 1) {
                this.hLS.bUf().dR(this.hLS.getForumId(), this.hLS.bTA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.hLS == null || this.hLS.getPbData() == null) {
            return false;
        }
        return ((this.hLS.getPbData().bQL() != 0) || this.hLS.getPbData().bQz() == null || this.hLS.getPbData().bQz().aiG() == null || TextUtils.equals(this.hLS.getPbData().bQz().aiG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bSh() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.axk()) {
            return "";
        }
        PostData bQG = bQG();
        if (this.hLS == null || (pbData = this.hLS.getPbData()) == null || pbData.getUserData() == null || pbData.bQz() == null || bQG == null || bQG.aiG() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bQG.aiG().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bQz().ain() == 0) {
            return "";
        }
        if (pbData.bQz().ain() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean ob(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hLS == null || this.hLS.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bQL() != 0) {
                return pbData.bQL() != 3;
            }
            List<bd> bQU = pbData.bQU();
            if (com.baidu.tbadk.core.util.v.getCount(bQU) > 0) {
                for (bd bdVar : bQU) {
                    if (bdVar != null && (vVar = bdVar.cbb) != null && vVar.bYU && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean oc(boolean z) {
        if (z || this.hLS == null || this.hLS.getPbData() == null) {
            return false;
        }
        return ((this.hLS.getPbData().getForum() != null && this.hLS.getPbData().getForum().isBlockBawuDelete) || this.hLS.getPbData().bQL() == 0 || this.hLS.getPbData().bQL() == 3) ? false : true;
    }

    public void bSi() {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().aiG() != null) {
            if (this.hLW != null) {
                this.hLW.bUX();
            }
            bh bQz = this.hLS.getPbData().bQz();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bQz.aiG().getUserId());
            ab abVar = new ab();
            int bQL = this.hLS.getPbData().bQL();
            if (bQL == 1 || bQL == 3) {
                abVar.hTf = true;
                abVar.hTe = true;
                abVar.hTm = bQz.aiB() == 1;
                abVar.hTl = bQz.aiC() == 1;
            } else {
                abVar.hTf = false;
                abVar.hTe = false;
            }
            if (bQL == 1002 && !equals) {
                abVar.hTq = true;
            }
            abVar.hTg = ob(equals);
            abVar.hTh = bSj();
            abVar.hTi = oc(equals);
            abVar.gR = this.hLS.bTB();
            abVar.hTd = true;
            abVar.hTc = oa(equals);
            abVar.hTo = bSh();
            abVar.hTb = equals && this.hLW.bVD();
            abVar.hTj = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hTk = true;
            abVar.isHostOnly = this.hLS.getHostMode();
            abVar.hTn = true;
            if (bQz.aiX() == null) {
                abVar.hTp = true;
            } else {
                abVar.hTp = false;
            }
            this.hLW.hUV.a(abVar);
        }
    }

    private boolean bSj() {
        if (this.hLS != null && this.hLS.bTB()) {
            return this.hLS.getPageData() == null || this.hLS.getPageData().ahB() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            f(postData);
        }
    }

    public int bSk() {
        if (bRX() == null || bRX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRX().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).xL == com.baidu.tieba.pb.data.i.hJI) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSl() {
        if (bRX() == null || bRX().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRX().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.jio) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bSs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.nm(getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.nn(getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.eg(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").bS("obj_id", metaData.getUserId()).O("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12528").bS("obj_id", metaData.getUserId()).O("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.cjV.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hLS.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).akO();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hLW.bVx();
        this.hLS.or(z);
        if (this.hLU != null) {
            this.hLU.dO(z);
            if (markData != null) {
                this.hLU.a(markData);
            }
        }
        if (this.hLS.afm()) {
            bSq();
        } else {
            this.hLW.m(this.hLS.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wr(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(String str) {
        this.hLT.Bf(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hLS.bTG()) {
                    antiData.setBlock_forum_name(this.hLS.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hLS.getPbData().getForum().getId());
                    antiData.setUser_name(this.hLS.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hLS.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bRX() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aH(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            pP(str);
        } else {
            this.hLW.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jkX) ? bVar.jkX : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nn(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.eg(true);
                aVar.b(getPageContext());
                aVar.akO();
            } else {
                this.hLW.a(0, bVar.tf, bVar.jkX, z);
            }
            if (bVar.tf) {
                if (bVar.feZ == 1) {
                    ArrayList<PostData> bQB = this.hLS.getPbData().bQB();
                    int size = bQB.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bQB.get(i).getId())) {
                            i++;
                        } else {
                            bQB.remove(i);
                            break;
                        }
                    }
                    this.hLS.getPbData().bQz().hI(this.hLS.getPbData().bQz().aix() - 1);
                    this.hLW.m(this.hLS.getPbData());
                } else if (bVar.feZ == 0) {
                    bSm();
                } else if (bVar.feZ == 2) {
                    ArrayList<PostData> bQB2 = this.hLS.getPbData().bQB();
                    int size2 = bQB2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bQB2.get(i2).com().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bQB2.get(i2).com().get(i3).getId())) {
                                i3++;
                            } else {
                                bQB2.get(i2).com().remove(i3);
                                bQB2.get(i2).coo();
                                z2 = true;
                                break;
                            }
                        }
                        bQB2.get(i2).DO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hLW.m(this.hLS.getPbData());
                    }
                    a(bVar, this.hLW);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hLW.a(this.eNS.getLoadDataMode(), gVar.tf, gVar.jkX, false);
            if (gVar.tf) {
                this.hLY = true;
                if (i == 2 || i == 3) {
                    this.hLZ = true;
                    this.hMa = false;
                } else if (i == 4 || i == 5) {
                    this.hLZ = false;
                    this.hMa = true;
                }
                if (i == 2) {
                    this.hLS.getPbData().bQz().hL(1);
                    this.hLS.setIsGood(1);
                } else if (i == 3) {
                    this.hLS.getPbData().bQz().hL(0);
                    this.hLS.setIsGood(0);
                } else if (i == 4) {
                    this.hLS.getPbData().bQz().hK(1);
                    this.hLS.pb(1);
                } else if (i == 5) {
                    this.hLS.getPbData().bQz().hK(0);
                    this.hLS.pb(0);
                }
                this.hLW.d(this.hLS.getPbData(), this.hLS.bTB());
            }
        }
    }

    private void bSm() {
        if (this.hLS.bTC() || this.hLS.bTE()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hLS.bTA());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.hLS.bTA()));
        if (bSr()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSn() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bQI;
        boolean z = false;
        if (this.hLW != null) {
            this.hLW.bVN();
        }
        if (this.hLS != null && this.hLS.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hLS.getPbData().bQz().getId();
            if (this.hLS.isShareThread() && this.hLS.getPbData().bQz().cec != null) {
                historyMessage.threadName = this.hLS.getPbData().bQz().cec.showText;
            } else {
                historyMessage.threadName = this.hLS.getPbData().bQz().getTitle();
            }
            if (this.hLS.isShareThread() && !bRv()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hLS.getPbData().getForum().getName();
            }
            ArrayList<PostData> bQB = this.hLS.getPbData().bQB();
            int bVz = this.hLW != null ? this.hLW.bVz() : 0;
            if (bQB != null && bVz >= 0 && bVz < bQB.size()) {
                historyMessage.postID = bQB.get(bVz).getId();
            }
            historyMessage.isHostOnly = this.hLS.getHostMode();
            historyMessage.isSquence = this.hLS.bTB();
            historyMessage.isShareThread = this.hLS.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hMl != null) {
            this.hMl.onDestroy();
        }
        if (this.hLz && bRX() != null) {
            bRX().bWg();
        }
        if (this.hLS != null && (this.hLS.bTC() || this.hLS.bTE())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hLS.bTA());
            if (this.hLY) {
                if (this.hMa) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hLS.bdP());
                }
                if (this.hLZ) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hLS.getIsGood());
                }
            }
            if (this.hLS.getPbData() != null && System.currentTimeMillis() - this.hLC >= 40000 && (bQI = this.hLS.getPbData().bQI()) != null && !com.baidu.tbadk.core.util.v.isEmpty(bQI.getDataList())) {
                intent.putExtra("guess_like_data", bQI);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hMz);
            }
            setResult(-1, intent);
        }
        if (bSr()) {
            if (this.hLS != null && this.hLW != null && this.hLW.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bQF() && !this.hLI && pbData.hJo == null) {
                        aj bUK = aj.bUK();
                        com.baidu.tieba.pb.data.d bTI = this.hLS.bTI();
                        Parcelable onSaveInstanceState = this.hLW.getListView().onSaveInstanceState();
                        boolean bTB = this.hLS.bTB();
                        boolean hostMode = this.hLS.getHostMode();
                        if (this.hLW.bVi() != null && this.hLW.bVi().getVisibility() == 0) {
                            z = true;
                        }
                        bUK.a(bTI, onSaveInstanceState, bTB, hostMode, z);
                        if (this.hMy >= 0 || this.hLS.bUl() != null) {
                            aj.bUK().l(this.hLS.bUl());
                            aj.bUK().k(this.hLS.bUm());
                            aj.bUK().wN(this.hLS.bUn());
                        }
                    }
                }
            } else {
                aj.bUK().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hLW == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hLW.wS(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wu(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hLW.bUX();
            this.hLW.bUZ().bTn();
            this.hLW.oL(false);
        }
        this.hLW.bVa();
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
                        this.hMl.resetData();
                        this.hMl.b(writeData);
                        this.hMl.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jL = this.hMl.atZ().jL(6);
                        if (jL != null && jL.cFe != null) {
                            jL.cFe.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hMl.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hLW.bUZ() != null && this.hLW.bUZ().bTr() != null) {
                            com.baidu.tbadk.editortools.pb.g bTr = this.hLW.bUZ().bTr();
                            bTr.b(writeData);
                            bTr.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jL2 = bTr.atZ().jL(6);
                            if (jL2 != null && jL2.cFe != null) {
                                jL2.cFe.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bTr.auR();
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.hMl.onActivityResult(i, i2, intent);
        if (this.hLM != null) {
            this.hLM.onActivityResult(i, i2, intent);
        }
        if (bRX().bUZ() != null) {
            bRX().bUZ().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    bSp();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.bUK().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hLS != null) {
                                PbActivity.this.hLS.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.cfp().y(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.hLS != null) {
                        a(bSo(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aq(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cfp().y(getPageContext());
                        bSg();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fLK != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fLK.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void ary() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(PbActivity.this.getPageContext(), customDialogData).show();
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
                    this.hLW.nY(false);
                    if (this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().aja() != null) {
                        this.hLS.getPbData().bQz().aja().setStatus(2);
                        break;
                    }
                    break;
                case RequestResponseCode.REQUEST_SELECT_LIKE_FORUM /* 25012 */:
                    break;
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hMo = emotionImageData;
                        if (wt(com.baidu.tbadk.core.util.aj.cjS)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.FANS_CALL_JUMP_BACK /* 25028 */:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hLW != null && this.hLW.hUV != null) {
                        this.hLW.hUV.ZF();
                        this.hLW.hUV.bWI();
                        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null) {
                            this.hLS.getPbData().bQz().hF(1);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.hLN != null) {
                        this.hLW.cB(this.hLN);
                        return;
                    }
                    return;
                default:
                    return;
            }
            intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
            intent.getStringExtra("KEY_FORUM_NAME");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.hLM == null) {
                this.hLM = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hLM.b(this.cGY);
                this.hLM.c(this.cHf);
            }
            this.hLM.a(emotionImageData, bRF(), bRF().getPbData());
        }
    }

    private ShareFromPBMsgData bSo() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] dP = this.hLS.getPbData().dP(getPageContext().getPageActivity());
        PostData bVd = this.hLW.bVd();
        String str = "";
        if (bVd != null) {
            str = bVd.getId();
            String ed = bVd.ed(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ed)) {
                dP[1] = ed;
            }
        }
        String aiW = this.hLS.getPbData().bQz().aiW();
        if (aiW != null && aiW.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(dP[1]);
        shareFromPBMsgData.setImageUrl(dP[0]);
        shareFromPBMsgData.setForumName(this.hLS.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hLS.getPbData().bQz().getId());
        shareFromPBMsgData.setTitle(this.hLS.getPbData().bQz().getTitle());
        return shareFromPBMsgData;
    }

    private void aq(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bSo(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hX(1);
            aVar.aM(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null) {
                        com.baidu.tbadk.core.util.an bS = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).O("obj_source", 1).O("obj_param1", 3).bS("fid", PbActivity.this.hLS.getForumId()).bS("tid", PbActivity.this.hLS.bTA());
                        if (PbActivity.this.d(PbActivity.this.hLS.getPbData()) != 0) {
                            bS.O("obj_type", PbActivity.this.d(PbActivity.this.hLS.getPbData()));
                        }
                        TiebaStatic.log(bS);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.61
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.eh(true);
            aVar.b(getPageContext()).akO();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hLS.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hX(1);
            aVar.aM(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.63
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.eh(true);
            aVar.b(getPageContext()).akO();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hLS.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSp() {
        MarkData wK;
        if (this.hLU != null && (wK = this.hLS.wK(this.hLW.bVA())) != null) {
            if (!wK.isApp() || (wK = this.hLS.wK(this.hLW.bVA() + 1)) != null) {
                this.hLW.bVv();
                this.hLU.a(wK);
                if (!this.hLU.afm()) {
                    this.hLU.afo();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hLU.afn();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSq() {
        com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
        this.hLS.or(true);
        if (this.hLU != null) {
            pbData.AC(this.hLU.afl());
        }
        this.hLW.m(pbData);
    }

    private boolean bSr() {
        if (this.hLS == null) {
            return true;
        }
        if (this.hLS.afm()) {
            final MarkData bTS = this.hLS.bTS();
            if (bTS == null || !this.hLS.getIsFromMark()) {
                return true;
            }
            final MarkData wK = this.hLS.wK(this.hLW.bVz());
            if (wK == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bTS);
                setResult(-1, intent);
                return true;
            } else if (wK.getPostId() == null || wK.getPostId().equals(bTS.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bTS);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nn(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hLU != null) {
                            if (PbActivity.this.hLU.afm()) {
                                PbActivity.this.hLU.afn();
                                PbActivity.this.hLU.dO(false);
                            }
                            PbActivity.this.hLU.a(wK);
                            PbActivity.this.hLU.dO(true);
                            PbActivity.this.hLU.afo();
                        }
                        bTS.setPostId(wK.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTS);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bSn();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTS);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bSn();
                    }
                });
                aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hLW != null && PbActivity.this.hLW.getView() != null) {
                            PbActivity.this.hLW.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bTS);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bSn();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.akO();
                return false;
            }
        } else if (this.hLS.getPbData() == null || this.hLS.getPbData().bQB() == null || this.hLS.getPbData().bQB().size() <= 0 || !this.hLS.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hLW == null) {
            return null;
        }
        return this.hLW.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azP() {
        if (this.hLW == null) {
            return 0;
        }
        return this.hLW.bVL();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azQ() {
        if (this.cUv == null) {
            this.cUv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSN */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.agq().isShowImages();
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.agq().isShowImages()) {
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
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
        return this.cUv;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azR() {
        if (this.cXc == null) {
            this.cXc = TbRichTextView.q(getPageContext().getPageActivity(), 8);
        }
        return this.cXc;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azS() {
        if (this.cUw == null) {
            this.cUw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSO */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.agq().isShowImages();
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
                @Override // com.baidu.adp.lib.e.c
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (com.baidu.tbadk.core.i.agq().isShowImages()) {
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.avr();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cUw;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azT() {
        if (this.cXd == null) {
            this.cXd = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(PbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cv */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cw */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cpC();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: cx */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.cXd;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azV() {
        this.cXf = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bSQ */
            public RelativeLayout makeObject() {
                return new RelativeLayout(PbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.cXf;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aog() {
        if (this.csh == null) {
            this.csh = UserIconBox.o(getPageContext().getPageActivity(), 8);
        }
        return this.csh;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ai(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hLG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.AX(str) && this.hLS != null && this.hLS.bTA() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").O("obj_param1", 1).bS("post_id", this.hLS.bTA()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cEe = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            av.bWr().c(getPageContext(), str);
        }
        this.hLG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aj(Context context, String str) {
        av.bWr().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hLG = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Rect rect) {
        if (rect != null && this.hLW != null && this.hLW.bWb() != null && rect.top <= this.hLW.bWb().getHeight()) {
            rect.top += this.hLW.bWb().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
            TbRichText bb = bb(str, i);
            if (bb != null && (tbRichTextData = bb.azh().get(this.hNf)) != null) {
                cVar.hNS = new ArrayList<>();
                cVar.hNT = new ConcurrentHashMap<>();
                if (!tbRichTextData.azp().azB()) {
                    cVar.hNV = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hNS.add(b2);
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
                    imageUrlData.postId = bb.getPostId();
                    imageUrlData.mIsReserver = this.hLS.bTQ();
                    imageUrlData.mIsSeeHost = this.hLS.getHostMode();
                    cVar.hNT.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bQz() != null) {
                            cVar.threadId = pbData.bQz().getId();
                        }
                        cVar.hNU = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(cVar.threadId, -1L);
                    return;
                }
                cVar.hNV = true;
                int size = pbData.bQB().size();
                this.hNg = false;
                cVar.index = -1;
                if (pbData.bQG() != null) {
                    PostData bQG = pbData.bQG();
                    TbRichText cor = bQG.cor();
                    if (!ap.m(bQG)) {
                        i2 = a(cor, bb, i, i, cVar.hNS, cVar.hNT);
                    } else {
                        i2 = a(bQG, i, cVar.hNS, cVar.hNT);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bQB().get(i4);
                    if (postData.getId() == null || pbData.bQG() == null || pbData.bQG().getId() == null || !postData.getId().equals(pbData.bQG().getId())) {
                        TbRichText cor2 = postData.cor();
                        if (!ap.m(postData)) {
                            i3 = a(cor2, bb, i3, i, cVar.hNS, cVar.hNT);
                        } else {
                            i3 = a(postData, i3, cVar.hNS, cVar.hNT);
                        }
                    }
                }
                if (cVar.hNS.size() > 0) {
                    cVar.lastId = cVar.hNS.get(cVar.hNS.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bQz() != null) {
                        cVar.threadId = pbData.bQz().getId();
                    }
                    cVar.hNU = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azp() == null) {
            return null;
        }
        return tbRichTextData.azp().azG();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azp() == null) {
            return 0L;
        }
        return tbRichTextData.azp().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azp() == null) {
            return false;
        }
        return tbRichTextData.azp().azH();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azp() == null) {
            return false;
        }
        return tbRichTextData.azp().azI();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo azp;
        String str;
        if (tbRichText == tbRichText2) {
            this.hNg = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.azh().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.azh().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.azp().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.azp().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.azp().azB()) {
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
                        String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                            if (tbRichTextData != null && (azp = tbRichTextData.azp()) != null) {
                                String azD = azp.azD();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = azp.azE();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = azD;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), -1L);
                                imageUrlData.mIsReserver = this.hLS.bTQ();
                                imageUrlData.mIsSeeHost = this.hLS.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hNg) {
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

    private int a(PostData postData, int i, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        com.baidu.tieba.tbadkCore.data.i coy;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cnU;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cnU = (coy = postData.coy()).cnU()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cnU.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cnU.get(i3);
                if (kVar != null) {
                    String cnY = kVar.cnY();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cnY)) {
                        arrayList.add(cnY);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cnY;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cnX();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.toLong(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), -1L);
                        imageUrlData.mIsReserver = this.hLS.bTQ();
                        imageUrlData.mIsSeeHost = this.hLS.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = coy.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cnY, imageUrlData);
                        }
                        if (!this.hNg) {
                            i++;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    protected void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.hLS.aiP())) {
                z = true;
            }
            MarkData j = this.hLS.j(postData);
            if (j != null) {
                this.hLW.bVv();
                if (this.hLU != null) {
                    this.hLU.a(j);
                    if (!z) {
                        this.hLU.afo();
                    } else {
                        this.hLU.afn();
                    }
                }
            }
        }
    }

    public boolean cu(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bb(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hLS == null || this.hLS.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
        if (pbData.bQG() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bQG());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bQB = pbData.bQB();
            a(pbData, bQB);
            return a(bQB, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bQK() != null && dVar.bQK().hJX != null && (list = dVar.bQK().hJX) != null && arrayList != null) {
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

    private long AI(String str) {
        ArrayList<PostData> bQB;
        com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
        if (pbData != null && (bQB = pbData.bQB()) != null && !bQB.isEmpty()) {
            Iterator<PostData> it = bQB.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i coy = next.coy();
                if (coy != null && coy.jhU) {
                    Iterator<TbRichTextData> it2 = next.cor().azh().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.azy().getLink().equals(str)) {
                            return coy.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> azh;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cor = arrayList.get(i2).cor();
            if (cor != null && (azh = cor.azh()) != null) {
                int size = azh.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (azh.get(i4) != null && azh.get(i4).getType() == 8) {
                        i3++;
                        if (azh.get(i4).azp().azD().equals(str) || azh.get(i4).azp().azE().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = azh.get(i4).azp().getWidth() * equipmentDensity;
                            int height = azh.get(i4).azp().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hNf = i4;
                            return cor;
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

    @Override // com.baidu.tbadk.widget.richText.e
    public void o(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.hLr = str;
            if (this.hLB == null) {
                bSb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hLB.getItemView(1).setVisibility(8);
            } else {
                this.hLB.getItemView(1).setVisibility(0);
            }
            this.hLB.akP();
            this.hLG = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fvn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSs() {
        hideNetRefreshView(this.hLW.getView());
        bSt();
        if (this.hLS.loadData()) {
            this.hLW.bVv();
        }
    }

    private void bSt() {
        showLoadingView(this.hLW.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.hLW.bWb().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkk() {
        if (this.fvn != null) {
            this.fvn.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_CHUDIAN_VIDEO_PAUSE, Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ww(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bh bQz;
        if (this.hLS.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hLS.getPbData();
            pbData.getForum().getName();
            String title = pbData.bQz().getTitle();
            int i2 = this.hLS.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Dl(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hLS.bTA() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] dP = pbData.dP(getPageContext().getPageActivity());
                    str = dP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = dP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bSf() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").bS("fid", pbData.getForumId()).bS("tid", pbData.getThreadId()).bS("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.cyu = true;
                    eVar.cyB = z;
                    eVar.extData = this.hLS.bTA();
                    eVar.cyN = 3;
                    eVar.cyM = i;
                    eVar.fid = this.hLS.getForumId();
                    eVar.tid = this.hLS.bTA();
                    eVar.cyR = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bQz = this.hLS.getPbData().bQz();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bQz);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bQz != null) {
                        eVar.czb = bQz.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.cyN);
                    bundle.putInt("obj_type", eVar.cyR);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQX() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hLW.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.bcj().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hLS.bTA() + "?share=9105&fr=share&see_lz=" + i2;
            String[] dP2 = pbData.dP(getPageContext().getPageActivity());
            str = dP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = dP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bSf() == 1) {
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cyu = true;
            eVar2.cyB = z;
            eVar2.extData = this.hLS.bTA();
            eVar2.cyN = 3;
            eVar2.cyM = i;
            eVar2.fid = this.hLS.getForumId();
            eVar2.tid = this.hLS.bTA();
            eVar2.cyR = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bQz = this.hLS.getPbData().bQz();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bQz);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bQz != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cyN);
            bundle2.putInt("obj_type", eVar2.cyR);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hLS != null && PbActivity.this.hLS.getPbData() != null && PbActivity.this.hLS.getPbData().bQX() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hLW.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.bcj().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQz() != null) {
            if (dVar.bQz().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bQz().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSu() {
        com.baidu.tbadk.util.z.a(new com.baidu.tbadk.util.y<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Dm(PbActivity.this.hLS.getForumId()));
            }
        }, new com.baidu.tbadk.util.j<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hLW.bWh();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azU() {
        if (this.cXe == null) {
            this.cXe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSR */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(PbActivity.this.getPageContext().getPageActivity());
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.cXe;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        if (getListView() == null) {
            return null;
        }
        return getListView().getPreLoadHandle();
    }

    public void bkl() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData biZ() {
        if (this.hLS == null || this.hLS.getPbData() == null) {
            return null;
        }
        return this.hLS.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(aq.hWO)).intValue();
            if (intValue == aq.hWP) {
                if (!this.eNS.cpe()) {
                    this.hLW.bVs();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eNS.DU(com.baidu.tbadk.core.util.aq.G(jSONArray));
                    }
                    this.eNS.a(this.hLS.getPbData().getForum().getId(), this.hLS.getPbData().getForum().getName(), this.hLS.getPbData().bQz().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.hWQ || intValue == aq.hWS) {
                if (this.hLS.bUc() != null) {
                    this.hLS.bUc().wz(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hWQ) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hMt);
        userMuteAddAndDelCustomMessage.setTag(this.hMt);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean AJ(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("bubble_link", "");
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

    public void od(boolean z) {
        this.hMf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bSv() {
        ArrayList<PostData> bQB;
        int count;
        if (this.hLS == null || this.hLS.getPbData() == null || this.hLS.getPbData().bQB() == null || (count = com.baidu.tbadk.core.util.v.getCount((bQB = this.hLS.getPbData().bQB()))) == 0) {
            return "";
        }
        if (this.hLS.bTQ()) {
            Iterator<PostData> it = bQB.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cop() == 1) {
                    return next.getId();
                }
            }
        }
        int bVz = this.hLW.bVz();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(bQB, bVz);
        if (postData == null || postData.aiG() == null) {
            return "";
        }
        if (this.hLS.AN(postData.aiG().getUserId())) {
            return postData.getId();
        }
        for (int i = bVz - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(bQB, i);
            if (postData2 == null || postData2.aiG() == null || postData2.aiG().getUserId() == null) {
                break;
            } else if (this.hLS.AN(postData2.aiG().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bVz + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(bQB, i2);
            if (postData3 == null || postData3.aiG() == null || postData3.aiG().getUserId() == null) {
                return "";
            }
            if (this.hLS.AN(postData3.aiG().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.amQ().b(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(AI(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hLS.getPbData().getForum().getId(), this.hLS.getPbData().getForum().getName(), this.hLS.getPbData().bQz().getTid());
            }
            this.hLG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.nn(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.nn(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hLS.bUb() != null) {
                    PbActivity.this.hLS.bUb().dJ(j);
                }
            }
        });
        aVar.b(getResources().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.89
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBCANCEL", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
            }
        });
        aVar.eh(false);
        aVar.b(getPageContext());
        aVar.akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c AK(String str) {
        String str2;
        if (this.hLS.getPbData() == null || this.hLS.getPbData().bQB() == null || this.hLS.getPbData().bQB().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hLS.getPbData().bQB().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hLS.getPbData().bQB().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hLS.getPbData().bQB().get(i);
        if (postData.cor() == null || postData.cor().azh() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cor().azh().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.azp() != null) {
                    str2 = next.azp().azD();
                }
            }
        }
        str2 = null;
        a(str2, 0, cVar);
        com.baidu.tieba.pb.data.e.a(postData, cVar);
        return cVar;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.hLy) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hLy = false;
        } else if (bSw()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hLy) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hLy = false;
        } else if (bSw()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.hLS != null) {
                if (this.hLS.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.hLS.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().cuL);
            }
        }
        return pageStayDurationItem;
    }

    public boolean bSw() {
        return (!this.hLw && this.hNn == -1 && this.hNo == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hNq = oVar;
            this.hLw = true;
            this.hLW.bVj();
            this.hLW.AV(this.hNp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSx() {
        if (this.hNq != null) {
            if (this.hNn == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hNq.getCartoonId(), this.hNn, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        if (this.hNq != null) {
            if (this.hNo == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hNq.getCartoonId(), this.hNo, 0)));
                finish();
            }
        }
    }

    public int bSz() {
        return this.hNn;
    }

    public int bSA() {
        return this.hNo;
    }

    private void bvU() {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().ajA()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void bSB() {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().ajA()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void bSC() {
        if (this.aqC) {
            this.hLL = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().aim() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hLS.getPbData().bQz().aim().getThreadId(), this.hLS.getPbData().bQz().aim().getTaskId(), this.hLS.getPbData().bQz().aim().getForumId(), this.hLS.getPbData().bQz().aim().getForumName(), this.hLS.getPbData().bQz().aiB(), this.hLS.getPbData().bQz().aiC())));
            this.hLy = true;
            finish();
        }
    }

    public String bSD() {
        return this.hLJ;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bSE() {
        return this.hLR;
    }

    public void oe(boolean z) {
        this.hLK = z;
    }

    public boolean bSF() {
        if (this.hLS != null) {
            return this.hLS.bTC();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nn(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hMr).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hMr.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hMr).akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hMr != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMr.getPageActivity());
            aVar.nn(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hMr).akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hLW.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hMr.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.nn(this.hMr.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.nn(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hLW.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.94
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hMr).akO();
    }

    public void bSH() {
        if (this.hLS != null && this.hLS.getPbData() != null && this.hLS.getPbData().bQz() != null && this.hLS.getPbData().bQz().ajP() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.hU(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.hLS.getPbData().bQz().ajP().channelId, true, PbActivity.this.getUniqueId())));
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    Toast.makeText(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getResources().getString(R.string.channel_no_push), 1).show();
                }
            });
            aVar.b(getPageContext());
            aVar.akO();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.AX(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.fVh) {
            this.fVh = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hLW != null) {
                this.hLW.onConfigurationChanged(configuration);
            }
            if (this.hMc != null) {
                this.hMc.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bSI() {
        if (this.hLS != null) {
            return this.hLS.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hLS.getPbData().bQK().hJX;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).com().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).com().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).com().remove(i2);
                    list.get(i).coo();
                    z = true;
                    break;
                }
            }
            list.get(i).DO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hLS.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bRi().getId();
        List<PostData> list = this.hLS.getPbData().bQK().hJX;
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
                ArrayList<PostData> bRm = kVar.bRm();
                postData.zQ(kVar.getTotalCount());
                if (postData.com() != null) {
                    postData.com().clear();
                    postData.com().addAll(bRm);
                }
            }
        }
        if (!this.hLS.getIsFromMark()) {
            this.hLW.m(this.hLS.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bRu() {
        return this.hLX;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bRv() {
        if (this.hLS == null) {
            return false;
        }
        return this.hLS.bRv();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bRw() {
        if (this.hLS != null) {
            return this.hLS.bRw();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bRx() {
        if (this.hLS == null || this.hLS.getPbData() == null) {
            return 0;
        }
        return this.hLS.getPbData().bQL();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AE(String str) {
        return this.hLS != null && this.hLS.AN(str);
    }

    public void bSJ() {
        if (this.hLW != null) {
            this.hLW.bUX();
            bkl();
        }
    }

    public PostData bQG() {
        return this.hLW.c(this.hLS.hRx, this.hLS.bTB());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int au(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.ajR()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hMA != null && !this.hMA.isEmpty()) {
            int size = this.hMA.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hMA.get(i).onBackPressed()) {
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
        super.onBackPressed();
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.hMA == null) {
                this.hMA = new ArrayList();
            }
            if (!this.hMA.contains(aVar)) {
                this.hMA.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hMA == null) {
                this.hMA = new ArrayList();
            }
            if (!this.hMA.contains(aVar)) {
                this.hMA.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hMA != null) {
            this.hMA.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        if (this.hLS != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.hLS.bTA())) {
            com.baidu.tbadk.BdToken.c.adZ().k(com.baidu.tbadk.BdToken.b.bQR, com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hLS == null || com.baidu.tbadk.core.util.aq.isEmpty(this.hLS.bTA())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.hLS.bTA(), 0L);
    }

    public com.baidu.tbadk.core.data.av bSL() {
        return this.hLQ;
    }
}
