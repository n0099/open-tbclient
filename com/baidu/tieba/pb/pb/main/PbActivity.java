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
    private com.baidu.adp.lib.e.b<ImageView> cTE;
    private com.baidu.adp.lib.e.b<GifView> cTF;
    private com.baidu.adp.lib.e.b<TextView> cWl;
    private com.baidu.adp.lib.e.b<View> cWm;
    private com.baidu.adp.lib.e.b<LinearLayout> cWn;
    private com.baidu.adp.lib.e.b<RelativeLayout> cWo;
    private LikeModel crO;
    private com.baidu.adp.lib.e.b<TbImageView> crq;
    private au fWM;
    private VoiceManager fuw;
    private com.baidu.tieba.f.b fyF;
    private com.baidu.tieba.frs.profession.permission.c fyd;
    public com.baidu.tbadk.core.util.aj gVU;
    private String hKA;
    private com.baidu.tieba.pb.pb.main.b.b hKG;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hKV;
    private View hKW;
    int hKY;
    private com.baidu.tbadk.core.data.av hKZ;
    private com.baidu.adp.base.e hLA;
    private com.baidu.tbadk.core.view.e hLB;
    private BdUniqueId hLC;
    private Runnable hLD;
    private com.baidu.adp.widget.ImageView.a hLE;
    private String hLF;
    private TbRichTextMemeInfo hLG;
    private List<a> hLJ;
    private com.baidu.tieba.pb.pb.report.a hLc;
    public as hLk;
    private com.baidu.tbadk.core.dialog.i hLl;
    private com.baidu.tbadk.core.dialog.k hLm;
    private boolean hLo;
    private com.baidu.tieba.tbadkCore.data.f hLs;
    private com.baidu.tbadk.editortools.pb.f hLt;
    private com.baidu.tbadk.editortools.pb.d hLu;
    private com.baidu.tieba.frs.profession.permission.c hLw;
    private EmotionImageData hLx;
    private boolean hMn;
    private String hMy;
    private com.baidu.tbadk.core.data.o hMz;
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
    private static final b.a hMt = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void aH(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bRr();
            } else {
                com.baidu.tieba.pb.a.b.bRq();
            }
        }
    };
    private boolean hKF = false;
    private boolean hKH = false;
    private boolean aqk = false;
    private boolean hoj = false;
    private boolean hKI = true;
    private int hKJ = 0;
    private com.baidu.tbadk.core.dialog.b hKK = null;
    private long faW = -1;
    private long cLq = 0;
    private long hKL = 0;
    private long createTime = 0;
    private long cLi = 0;
    private boolean hKM = false;
    private com.baidu.tbadk.p.b hKN = null;
    private long hKO = 0;
    private boolean hKP = false;
    private long hKQ = 0;
    private int fUq = 1;
    private String cGe = null;
    private boolean hKR = false;
    private boolean isFullScreen = false;
    private String hKS = "";
    private boolean hKT = true;
    private boolean hKU = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hKX = new int[2];
    private PbInterviewStatusView.a hLa = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void callback(boolean z) {
            PbActivity.this.hLf.oE(!PbActivity.this.hKT);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hLb != null && PbActivity.this.hLb.afk()) {
                        PbActivity.this.bSo();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hLb = null;
    private com.baidu.tbadk.baseEditMark.a hLd = null;
    private ForumManageModel eNb = null;
    private com.baidu.tbadk.coreExtra.model.a cje = null;
    private com.baidu.tieba.pb.data.l hLe = null;
    private ShareSuccessReplyToServerModel fKT = null;
    private aq hLf = null;
    public final com.baidu.tieba.pb.pb.main.b.a hLg = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hLh = false;
    private boolean hLi = false;
    private boolean hLj = false;
    private boolean hLn = false;
    private boolean hLp = false;
    private boolean hLq = false;
    private boolean hLr = false;
    private boolean hLv = false;
    public boolean hLy = false;
    private com.baidu.tbadk.editortools.pb.c cGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void auv() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b cGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auu() {
            if (PbActivity.this.hLk == null || PbActivity.this.hLk.bWl() == null || !PbActivity.this.hLk.bWl().cxy()) {
                return !PbActivity.this.ws(com.baidu.tbadk.core.util.aj.ciZ);
            }
            PbActivity.this.showToast(PbActivity.this.hLk.bWl().cxA());
            if (PbActivity.this.hLu != null && (PbActivity.this.hLu.auJ() || PbActivity.this.hLu.auK())) {
                PbActivity.this.hLu.a(false, PbActivity.this.hLk.bWo());
            }
            PbActivity.this.hLk.oQ(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hLz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean auu() {
            if (PbActivity.this.hLk == null || PbActivity.this.hLk.bWm() == null || !PbActivity.this.hLk.bWm().cxy()) {
                return !PbActivity.this.ws(com.baidu.tbadk.core.util.aj.cja);
            }
            PbActivity.this.showToast(PbActivity.this.hLk.bWm().cxA());
            if (PbActivity.this.hLf != null && PbActivity.this.hLf.bUX() != null && PbActivity.this.hLf.bUX().bTp() != null && PbActivity.this.hLf.bUX().bTp().auK()) {
                PbActivity.this.hLf.bUX().bTp().a(PbActivity.this.hLk.bWo());
            }
            PbActivity.this.hLk.oR(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fvl = false;
    private int hLH = 0;
    private int hLI = -1;
    private final a hLK = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hLf != null && PbActivity.this.hLf.bUX() != null) {
                s bUX = PbActivity.this.hLf.bUX();
                if (bUX.bTn()) {
                    bUX.bTm();
                    return true;
                }
            }
            if (PbActivity.this.hLf != null && PbActivity.this.hLf.bVS()) {
                PbActivity.this.hLf.bVT();
                return true;
            }
            return false;
        }
    };
    private r.a hLL = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fvx = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bSs();
        }
    };
    private final z.a hLM = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aD(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void n(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hLf.showToast(str);
            }
        }
    };
    private final CustomMessageListener hLN = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLb != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hLu != null) {
                    PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                }
                PbActivity.this.hLf.bUY();
                PbActivity.this.hLf.bVL();
            }
        }
    };
    CustomMessageListener fvS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hLb.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hLf != null && PbActivity.this.hLb != null) {
                    PbActivity.this.hLf.d(PbActivity.this.hLb.getPbData(), PbActivity.this.hLb.bTz(), PbActivity.this.hLb.bTU());
                }
                if (PbActivity.this.hLf != null && PbActivity.this.hLf.bVp() != null) {
                    PbActivity.this.hLf.bVp().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hLO = new CustomMessageListener(CmdConfigCustom.CMD_LIGHT_APP_RUNTIME_INITED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hLf != null) {
                    if (booleanValue) {
                        PbActivity.this.hLf.bCt();
                    } else {
                        PbActivity.this.hLf.bCs();
                    }
                }
            }
        }
    };
    private CustomMessageListener hLP = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hLu != null) {
                    PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                }
                PbActivity.this.hLf.oL(false);
            }
        }
    };
    private CustomMessageListener hLQ = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hLR = new CustomMessageListener(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLf != null && PbActivity.this.hLf.bVp() != null) {
                PbActivity.this.hLf.bVp().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gzO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fvP = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.aqk) {
                PbActivity.this.bSI();
            }
        }
    };
    private h.a hLS = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void t(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.wu(2);
                aj.bUI().reset();
                PbActivity.this.hLb.bTV();
                boolean z2 = false;
                ArrayList<PostData> bQz = PbActivity.this.hLb.getPbData().bQz();
                if (bQz != null) {
                    Iterator<PostData> it = bQz.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cow().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hLf.m(PbActivity.this.hLb.getPbData());
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
    private View.OnClickListener cGS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.cGe);
        }
    };
    private CustomMessageListener hLT = new CustomMessageListener(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hLb.bTL() != null && PbActivity.this.hLb.bTL().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hLf.a(aaVar.sendCount, PbActivity.this.hLb.getPbData(), PbActivity.this.hLb.bTz(), PbActivity.this.hLb.bTU());
                    }
                    if (pbData.bQz() != null && pbData.bQz().size() >= 1 && pbData.bQz().get(0) != null) {
                        long j = com.baidu.adp.lib.g.b.toLong(pbData.bQz().get(0).getId(), 0L);
                        long j2 = com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLb.bTy(), 0L);
                        if (j == aaVar.postId && j2 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cov = pbData.bQz().get(0).cov();
                            if (cov == null) {
                                cov = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> ahA = cov.ahA();
                            if (ahA == null) {
                                ahA = new ArrayList<>();
                            }
                            ahA.add(0, aVar);
                            cov.setTotal(aaVar.sendCount + cov.getTotal());
                            cov.s(ahA);
                            pbData.bQz().get(0).a(cov);
                            PbActivity.this.hLf.bVp().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                PbActivity.this.AF((String) customResponsedMessage.getData());
                PbActivity.this.hLb.bTR();
                if (PbActivity.this.hLf.bVp() != null) {
                    PbActivity.this.hLf.m(PbActivity.this.hLb.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hLU = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SINGLE_BAR_EMOTION, aVar.bWv()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hLV = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aD(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list) && PbActivity.this.hLf != null) {
                PbActivity.this.hLf.dW(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hLW = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
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
    private boolean hLX = false;
    private PraiseModel hLY = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void rM(String str) {
            PbActivity.this.hLX = false;
            if (PbActivity.this.hLY != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                if (pbData.bQx().aiq().getIsLike() == 1) {
                    PbActivity.this.rr(0);
                } else {
                    PbActivity.this.rr(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ACTION_PRAISE, pbData.bQx()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hLX = false;
            if (PbActivity.this.hLY != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aS(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hLZ = 0;
    private boolean hMa = true;
    private b.a hMb = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void of(boolean z) {
            PbActivity.this.oe(z);
            if (PbActivity.this.hLf.bVY() != null && z) {
                PbActivity.this.hLf.oE(false);
            }
            PbActivity.this.hLf.oG(z);
        }
    };
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().cvM != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().cvM, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc) {
                        if (PbActivity.this.bQE().aiE() != null && PbActivity.this.bQE().aiE().getGodUserData() != null) {
                            PbActivity.this.bQE().aiE().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                            PbActivity.this.hLb.getPbData().bQx().aiE().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a hMc = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hLf.aVU();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.wv(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bsz();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c cyE = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            PbActivity.this.bRY();
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
                    if (PbActivity.this.hLf != null && PbActivity.this.hLf.bRW() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10630").bS("obj_id", (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hLg != null && PbActivity.this.hLg.fXf != null) {
                            PbActivity.this.hLg.fXf.onClick(view);
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
            if (PbActivity.this.hLu != null) {
                PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
            }
            PbActivity.this.hLf.bUY();
            PbActivity.this.hLf.bVL();
            return true;
        }
    });
    private CustomMessageListener hMd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLC) {
                PbActivity.this.hLf.aVU();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bQK().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hLB.showSuccessToast(PbActivity.this.hLA.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hLA.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.pP(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bSE();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.aq.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hLA.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hLB.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hMe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLC) {
                PbActivity.this.hLf.aVU();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hLB.showSuccessToast(PbActivity.this.hLA.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.aq.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hLA.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hLB.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener hMf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hLC) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hLf.aVU();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jvR;
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
                    PbActivity.this.hLf.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hMg = new CustomMessageListener(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hLf.bUZ() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bRY();
            }
        }
    };
    private CustomMessageListener fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fvl = true;
                }
            }
        }
    };
    public a.b hzp = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bkj();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hLb.getPageData();
            int pageNum = PbActivity.this.hLf.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.aht()) {
                PbActivity.this.hLf.bVL();
                PbActivity.this.wu(2);
                PbActivity.this.bki();
                PbActivity.this.hLf.bVt();
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbActivity.this.hLb.wD(PbActivity.this.hLf.getPageNum());
                    if (PbActivity.this.hKG != null) {
                        PbActivity.this.hKG.showFloatingView();
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
    public final View.OnClickListener fwH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
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
                    if (view == PbActivity.this.hLf.bVH()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hLb.op(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hLf.bVu();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUD()) {
                        if (view == PbActivity.this.hLf.hUe.cNA) {
                            if (PbActivity.this.hLf.oI(PbActivity.this.hLb.bTE())) {
                                PbActivity.this.bki();
                                return;
                            }
                            PbActivity.this.hKI = false;
                            PbActivity.this.hKH = false;
                            com.baidu.adp.lib.util.l.hideSoftKeyPad(PbActivity.this, PbActivity.this.hLf.hUe.cNA);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hLf.bVr() && (PbActivity.this.hLf.hUe.bWJ() == null || (view != PbActivity.this.hLf.hUe.bWJ().bUC() && view != PbActivity.this.hLf.hUe.bWJ().bUA()))) {
                            if (view == PbActivity.this.hLf.bVO()) {
                                if (PbActivity.this.hLb != null) {
                                    com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLb.getPbData().bQx().aiD().getLink());
                                }
                            } else if (view != PbActivity.this.hLf.hUe.hZy) {
                                if (view == PbActivity.this.hLf.hUe.hZz) {
                                    if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                        ArrayList<PostData> bQz = PbActivity.this.hLb.getPbData().bQz();
                                        if ((bQz == null || bQz.size() <= 0) && PbActivity.this.hLb.bTz()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12378").bS("tid", PbActivity.this.hLb.bTy()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", PbActivity.this.hLb.getForumId()));
                                        if (!PbActivity.this.hLf.bWd()) {
                                            PbActivity.this.hLf.bUY();
                                        }
                                        PbActivity.this.bSg();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                        PbActivity.this.hLf.oj(true);
                                        PbActivity.this.hLf.bUY();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hLf.bCt();
                                            PbActivity.this.bki();
                                            PbActivity.this.hLf.bVt();
                                            PbActivity.this.hLb.AM(PbActivity.this.bSt());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wu(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUz()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hLf.hUe.bWJ() != null && view == PbActivity.this.hLf.hUe.bWJ().getCancelView()) {
                                            PbActivity.this.hLf.hUe.ZD();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUx()) {
                                                if ((PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUF()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUy()) {
                                                        if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUG()) {
                                                            if (PbActivity.this.hLf.bVY() == view) {
                                                                if (PbActivity.this.hLf.bVY().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                                                                    if (pbData != null && pbData.bQx() != null && pbData.bQx().aik() != null) {
                                                                        String aib = pbData.bQx().aik().aib();
                                                                        if (StringUtils.isNull(aib)) {
                                                                            aib = pbData.bQx().aik().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11107").bS("obj_id", aib));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.dZ("c10725", null);
                                                                }
                                                                PbActivity.this.bSA();
                                                            } else if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUE()) {
                                                                if (PbActivity.this.hLf.hUe.bWJ() != null && view == PbActivity.this.hLf.hUe.bWJ().bUB()) {
                                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hLf.c(PbActivity.this.hLb.getPbData(), PbActivity.this.hLb.bTz(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hLf.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hLf.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hLf.hUe.ZD();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hLb != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar.bS("tid", PbActivity.this.hLb.bTy());
                                                                        anVar.bS("fid", PbActivity.this.hLb.getForumId());
                                                                        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar.O("obj_locate", 4);
                                                                        TiebaStatic.log(anVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hLb.getPbData() != null) {
                                                                            PbActivity.this.hLf.bVL();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.coz() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12630"));
                                                                                }
                                                                                if (postData.jit != null) {
                                                                                    com.baidu.tbadk.core.util.an amH = postData.jit.amH();
                                                                                    amH.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        amH.O("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        amH.O("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(amH);
                                                                                }
                                                                                String bTy = PbActivity.this.hLb.bTy();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hLb.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hLb.getPbData().bQJ();
                                                                                }
                                                                                PbActivity.this.bki();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c AK = PbActivity.this.AK(id);
                                                                                    if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && AK != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTy, id, "pb", true, null, true, null, i4, postData.bXD(), PbActivity.this.hLb.getPbData().getAnti(), false, postData.aiE().getIconInfo()).addBigImageData(AK.hNb, AK.hNc, AK.hNd, AK.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hLb.bUh());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hLb.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c AK2 = PbActivity.this.AK(id);
                                                                                    if (postData != null && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && AK2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTy, id, "pb", true, null, false, null, i4, postData.bXD(), PbActivity.this.hLb.getPbData().getAnti(), false, postData.aiE().getIconInfo()).addBigImageData(AK2.hNb, AK2.hNc, AK2.hNd, AK2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hLb.bUh());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hLb.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").O("obj_locate", 3).bS("fid", PbActivity.this.hLb.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hLb != null) {
                                                                        com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar2.bS("tid", PbActivity.this.hLb.bTy());
                                                                        anVar2.bS("fid", PbActivity.this.hLb.getForumId());
                                                                        anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar2.O("obj_locate", 5);
                                                                        TiebaStatic.log(anVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                                                                    String bTy2 = PbActivity.this.hLb.bTy();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hLb.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hLb.getPbData().bQJ();
                                                                                    }
                                                                                    c AK3 = PbActivity.this.AK(id2);
                                                                                    if (AK3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bTy2, id2, "pb", true, null, false, null, i5, postData2.bXD(), PbActivity.this.hLb.getPbData().getAnti(), false, postData2.aiE().getIconInfo()).addBigImageData(AK3.hNb, AK3.hNc, AK3.hNd, AK3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hLb.bUh());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hLb.getFromForumId());
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
                                                                    if (PbActivity.this.hLb != null) {
                                                                        com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13398");
                                                                        anVar3.bS("tid", PbActivity.this.hLb.bTy());
                                                                        anVar3.bS("fid", PbActivity.this.hLb.getForumId());
                                                                        anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        anVar3.O("obj_locate", 6);
                                                                        TiebaStatic.log(anVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.bRV().bUW() != null && postData3.aiE() != null && postData3.con() != 1) {
                                                                                    if (PbActivity.this.bRV().bUX() != null) {
                                                                                        PbActivity.this.bRV().bUX().bTl();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hLb.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hLb.getPbData().bQx());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bRV().bUW().d(kVar);
                                                                                    PbActivity.this.bRV().bUW().setPostId(postData3.getId());
                                                                                    PbActivity.this.b(view, postData3.aiE().getUserId(), "");
                                                                                    if (PbActivity.this.hLu != null) {
                                                                                        PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
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
                                                                } else if (view != PbActivity.this.hLf.bRP()) {
                                                                    if (view == PbActivity.this.hLf.hUe.bWK()) {
                                                                        PbActivity.this.hLf.bVA();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (bmVar = (bm) view.getTag()) != null && !StringUtils.isNull(bmVar.akE())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.amO().b(PbActivity.this.getPageContext(), new String[]{bmVar.akE()});
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12006").bS("tid", PbActivity.this.hLb.hQk));
                                                                                    }
                                                                                    if (PbActivity.this.hLm == null) {
                                                                                        PbActivity.this.hLm = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hLm.a(PbActivity.this.hMs);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cu(view);
                                                                                    if (!PbActivity.this.cu(view) || PbActivity.this.hLE == null || !PbActivity.this.hLE.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hLm);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cop() != null && postData4.cop().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hLm);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.got = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hLb.getPbData().afk()) {
                                                                                        String afj = PbActivity.this.hLb.getPbData().afj();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(afj) && afj.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hLm);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hLm);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.got);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hLm);
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
                                                                                                    if (!ap.m(PbActivity.this.got)) {
                                                                                                        oa = PbActivity.this.oa(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        oa = false;
                                                                                                    }
                                                                                                    if (oa) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLm);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLm);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hLm);
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
                                                                                                    if (PbActivity.this.hLb.getPbData().bQJ() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLm);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLm);
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
                                                                                            PbActivity.this.hLm.at(arrayList);
                                                                                            PbActivity.this.hLl = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLm);
                                                                                            PbActivity.this.hLl.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.got);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hLm.at(arrayList);
                                                                                    PbActivity.this.hLl = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLm);
                                                                                    PbActivity.this.hLl.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), PbActivity.this.hLb.getPbData().bQx().getActUrl());
                                                                                if (PbActivity.this.hLb.getPbData().bQx().ajo() != 1) {
                                                                                    if (PbActivity.this.hLb.getPbData().bQx().ajo() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10912").bS("fid", PbActivity.this.hLb.getPbData().getForumId()).bS("tid", PbActivity.this.hLb.getPbData().getThreadId()).bS("lotterytail", StringUtils.string(str3, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hLb.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hLf.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.checkUpIsLogin(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.alP().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hLf.bUY();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bSd() == 1 && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10397").bS("fid", PbActivity.this.hLb.getPbData().getForumId()).bS("tid", PbActivity.this.hLb.getPbData().getThreadId()).bS("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.startWebActivity(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bSd() == 1 && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10507").bS("fid", PbActivity.this.hLb.getPbData().getForumId()).bS("tid", PbActivity.this.hLb.getPbData().getThreadId()).bS("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bSv();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bSw();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQQ() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hLb.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11679").bS("fid", pbData2.getForumId()));
                                                                                ba.amO().b(PbActivity.this.getPageContext(), new String[]{pbData2.bQQ().bQX()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQQ() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hLb.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bS("fid", pbData3.getForumId()));
                                                                                ba.amO().b(PbActivity.this.getPageContext(), new String[]{pbData3.bQQ().bQX()});
                                                                            }
                                                                        } else if (PbActivity.this.hLf.hUe.bWJ() != null && view == PbActivity.this.hLf.hUe.bWJ().bUH()) {
                                                                            if (PbActivity.this.hLb == null || PbActivity.this.hLb.getPbData() == null || PbActivity.this.hLb.getPbData().bQx() == null) {
                                                                                PbActivity.this.hLf.hUe.ZD();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.isNetOk()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hLb.getPbData().bQx().ail() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLb.bTy(), RequestResponseCode.FANS_CALL_JUMP_BACK)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).akR();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12399").O("obj_locate", PbActivity.this.au(PbActivity.this.hLb.getPbData().bQx())).bS("tid", PbActivity.this.hLb.getPbData().bQx().getTid()).O("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hLH >= 0) {
                                                                                if (PbActivity.this.hLb != null) {
                                                                                    PbActivity.this.hLb.bUi();
                                                                                }
                                                                                if (PbActivity.this.hLf.bVp() != null) {
                                                                                    PbActivity.this.hLf.bVp().a(PbActivity.this.hLb.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hLf.getListView().setSelection(PbActivity.this.hLb.bUl());
                                                                                PbActivity.this.hLH = 0;
                                                                                if (PbActivity.this.hLb != null) {
                                                                                    PbActivity.this.hLb.bY(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), "pb_recommend_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bSa();
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
                                                                            if (PbActivity.this.hLf.getListView() != null && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hLf.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hLf.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bQV = PbActivity.this.hLb.getPbData().bQV();
                                                                                boolean z8 = PbActivity.this.hLf.hTY != null && PbActivity.this.hLf.hTY.aOf();
                                                                                boolean bVI = PbActivity.this.hLf.bVI();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bQV && PbActivity.this.hLf.hTY != null && PbActivity.this.hLf.hTY.aJw() != null) {
                                                                                    int equipmentWidth = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d)) - PbActivity.this.hLf.hTY.bXT();
                                                                                    z9 = firstVisiblePosition == 0 && (top == equipmentWidth || top == PbActivity.this.hLf.hTY.aJw().getHeight() - PbActivity.this.hLf.hTY.bXT());
                                                                                    i7 = equipmentWidth;
                                                                                }
                                                                                if ((PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiv() <= 0) || (bVI && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bSa();
                                                                                        if (PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLb.hQk).bS("fid", PbActivity.this.hLb.getPbData().getForumId()).O("obj_locate", 2).bS("uid", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int equipmentHeight = (int) (com.baidu.adp.lib.util.l.getEquipmentHeight(PbActivity.this) * 0.6d);
                                                                                    if (bQV) {
                                                                                        if (PbActivity.this.hLf.hVT != null && PbActivity.this.hLf.hVT.hXd != null && PbActivity.this.hLf.hVT.hXd.getView() != null) {
                                                                                            if (PbActivity.this.hLf.hVT.hXd.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bSj();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hLf.hTY.aJw() != null) {
                                                                                                    i8 = PbActivity.this.hLf.hTY.aJw().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hLf.hVT.hXd.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hLf.bVg() != null) {
                                                                                        z10 = PbActivity.this.hLf.bVg().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hLf.hVT != null && PbActivity.this.hLf.hVT.hXd != null && PbActivity.this.hLf.hVT.hXd.getView() != null && PbActivity.this.hLf.hVT.hXd.getView().getParent() != null && PbActivity.this.hLf.hUe != null && PbActivity.this.hLf.hUe.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hLf.hVT.hXd.getView().getTop() - PbActivity.this.hLf.hUe.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bVI) {
                                                                                        int bSj = PbActivity.this.bSj();
                                                                                        if (PbActivity.this.bSi() != -1) {
                                                                                            bSj--;
                                                                                        }
                                                                                        int dimens = com.baidu.adp.lib.util.l.getDimens(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bSj < 0) {
                                                                                            i2 = PbActivity.this.hLf.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.getCount(PbActivity.this.hLf.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bSj;
                                                                                            i3 = dimens;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bQV || PbActivity.this.hLf.hTY.aJw() == null) {
                                                                                            if (PbActivity.this.hLf.hUe != null && PbActivity.this.hLf.hUe.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hLf.hUe.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hLf.hTY.aJw().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hLf.hVT == null || PbActivity.this.hLf.hVT.hXd == null || PbActivity.this.hLf.hVT.hXd.getView() == null || PbActivity.this.hLf.hVT.hXd.getView().getParent() == null) {
                                                                                            PbActivity.this.hLf.getListView().setSelectionFromTop(i2, i3 + equipmentHeight);
                                                                                            PbActivity.this.hLf.getListView().smoothScrollBy(equipmentHeight, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hLf.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hLf.getListView().smoothScrollBy(PbActivity.this.hLf.hVT.hXd.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                                        PbActivity.this.hLf.getListView().setSelectionFromTop(0, i7 - equipmentHeight);
                                                                                        PbActivity.this.hLf.getListView().smoothScrollBy(-equipmentHeight, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hLf.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLb.hQk).bS("fid", PbActivity.this.hLb.getPbData().getForumId()).O("obj_locate", 2).bS("uid", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(PbActivity.this.hLb.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hLb.bUh() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hLb.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("c13401");
                                                                                anVar4.bS("tid", PbActivity.this.hLb.bTy());
                                                                                anVar4.bS("fid", PbActivity.this.hLb.getForumId());
                                                                                anVar4.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(anVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                bh bhVar = (bh) view.getTag();
                                                                                if (PbActivity.this.hLb.bUh() == 3 && PbActivity.this.bRt() && PbActivity.this.hLb.getPbData() != null && com.baidu.tbadk.core.util.v.isEmpty(PbActivity.this.hLb.getPbData().bQS())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bhVar.aiJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
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
                                                                            if (PbActivity.this.hLb != null) {
                                                                                com.baidu.tbadk.core.util.an anVar6 = new com.baidu.tbadk.core.util.an("c13398");
                                                                                anVar6.bS("tid", PbActivity.this.hLb.bTy());
                                                                                anVar6.bS("fid", PbActivity.this.hLb.getForumId());
                                                                                anVar6.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                anVar6.O("obj_locate", 2);
                                                                                TiebaStatic.log(anVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hLb.getPbData();
                                                                                if (PbActivity.this.hLe == null) {
                                                                                    PbActivity.this.hLe = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long j2 = com.baidu.adp.lib.g.b.toLong(pbData4.getThreadId(), 0L);
                                                                                long j3 = com.baidu.adp.lib.g.b.toLong(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.an("c13446").p("forum_id", j3).amI();
                                                                                PbActivity.this.registerListener(PbActivity.this.hMi);
                                                                                PbActivity.this.hLe.y(j2, j3);
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
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13274").bS("fid", PbActivity.this.hLb.getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", smartApp.name).p("obj_id", smartApp.swan_app_id.longValue()).bS("obj_source", "PB_card").bS("tid", PbActivity.this.hLb.bTy()).O("obj_param1", smartApp.is_game.intValue()));
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_wrapper) {
                                                                            if (view.getTag() instanceof bh) {
                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(((bh) view.getTag()).aiJ(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                createNormalCfg2.setCallFrom(14);
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 9));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.id_pb_business_promotion_attention) {
                                                                            if ((view.getTag() instanceof bh) && PbActivity.this.checkUpIsLogin()) {
                                                                                bh bhVar2 = (bh) view.getTag();
                                                                                if (PbActivity.this.crO != null) {
                                                                                    PbActivity.this.crO.dY(bhVar2.aiJ(), String.valueOf(bhVar2.getFid()));
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("common_click").bS("page_type", PageStayDurationConstants.PageName.PB).O("obj_isad", 1).O("obj_adlocate", 10));
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD, com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLb.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLb.bTy(), 0L), com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hLb.getPbData().bQx().aiY())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                                PbActivity.this.hLf.bVL();
                                                                SparseArray<Object> c3 = PbActivity.this.hLf.c(PbActivity.this.hLb.getPbData(), PbActivity.this.hLb.bTz(), 1);
                                                                if (c3 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLb.getPbData().getForum().getId(), PbActivity.this.hLb.getPbData().getForum().getName(), PbActivity.this.hLb.getPbData().bQx().getId(), String.valueOf(PbActivity.this.hLb.getPbData().getUserData().getUserId()), (String) c3.get(R.id.tag_forbid_user_name), (String) c3.get(R.id.tag_forbid_user_name_show), (String) c3.get(R.id.tag_forbid_user_post_id), (String) c3.get(R.id.tag_forbid_user_portrait))));
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
                                                                com.baidu.tbadk.core.util.am.amF();
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).O("obj_type", 0).O("obj_source", 1));
                                                            } else if (skinType == 0 || skinType == 4) {
                                                                UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.SET_NIGHT_MODE).O("obj_type", 1).O("obj_source", 1));
                                                            }
                                                            PbActivity.this.hLf.hUe.bWI();
                                                        }
                                                    } else if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null) {
                                                        PbActivity.this.hLf.hUe.ZD();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13062"));
                                                        PbActivity.this.AH(PbActivity.this.hLb.getPbData().bQx().aiU());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hLf.bVL();
                                                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hLb.bTP()));
                                                            return;
                                                        }
                                                        PbActivity.this.wu(2);
                                                        PbActivity.this.bki();
                                                        PbActivity.this.hLf.bVt();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hLb.getPbData().hIv == null || PbActivity.this.hLb.getPbData().hIv.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hLb.getPbData().hIv.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hLb.getPbData().hIv.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hLb.getPbData().hIv.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hLb.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hLb.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hLb.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hLb.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12097").O("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).O("obj_type", i12));
                                                                if (PbActivity.this.hLb.getPbData().hIv != null && PbActivity.this.hLb.getPbData().hIv.size() > i11) {
                                                                    i11 = PbActivity.this.hLb.getPbData().hIv.get(i11).sort_type.intValue();
                                                                }
                                                                boolean wI = PbActivity.this.hLb.wI(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hLb.bTP()));
                                                                if (wI) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hLf.oA(true);
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
                                                PbActivity.this.hLf.bVL();
                                                if (PbActivity.this.bRD().getPbData().hIw != 2) {
                                                    if (PbActivity.this.hLb.getPageData() != null) {
                                                        PbActivity.this.hLf.a(PbActivity.this.hLb.getPageData(), PbActivity.this.hzp);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.isOn() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLb.hQk).bS("fid", PbActivity.this.hLb.getPbData().getForumId()).O("obj_locate", 4).bS("uid", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()));
                                            }
                                            if (PbActivity.this.hLb != null) {
                                                com.baidu.tbadk.core.util.an anVar7 = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                anVar7.bS("tid", PbActivity.this.hLb.bTy());
                                                anVar7.bS("uid", TbadkCoreApplication.getCurrentAccount());
                                                anVar7.bS("fid", PbActivity.this.hLb.getForumId());
                                                anVar7.O("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    anVar7.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(anVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.isNetOk()) {
                                                if (PbActivity.this.hLb.getPbData() != null) {
                                                    ArrayList<PostData> bQz2 = PbActivity.this.hLb.getPbData().bQz();
                                                    if ((bQz2 != null && bQz2.size() > 0) || !PbActivity.this.hLb.bTz()) {
                                                        PbActivity.this.hLf.bVL();
                                                        PbActivity.this.bki();
                                                        PbActivity.this.wu(2);
                                                        if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQQ() != null && !StringUtils.isNull(PbActivity.this.hLb.getPbData().bQQ().ahd(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11678").bS("fid", PbActivity.this.hLb.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11939"));
                                                        if (bf.isOn()) {
                                                            PbActivity.this.wv(2);
                                                        } else {
                                                            PbActivity.this.hLf.showLoadingDialog();
                                                            PbActivity.this.hLb.bUc().m(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hLf.bVL();
                                        if (PbActivity.this.hLf.hUe.bWJ() != null && view == PbActivity.this.hLf.hUe.bWJ().bUz() && !PbActivity.this.hLf.bWd()) {
                                            PbActivity.this.hLf.bUY();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bki();
                                            PbActivity.this.hLf.bVt();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                u = PbActivity.this.hLb.u(true, PbActivity.this.bSt());
                                            } else {
                                                u = view.getId() == R.id.reply_title ? PbActivity.this.hLb.u(false, PbActivity.this.bSt()) : PbActivity.this.hLb.AM(PbActivity.this.bSt());
                                            }
                                            view.setTag(Boolean.valueOf(u));
                                            if (u) {
                                                PbActivity.this.hLf.oj(true);
                                                PbActivity.this.hLf.bCt();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hLf.oA(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.wu(2);
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
                                    PbActivity.this.hLf.bVL();
                                    if (PbActivity.this.wt(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && PbActivity.this.hLb.wJ(PbActivity.this.hLf.bVy()) != null) {
                                        PbActivity.this.bSn();
                                        if (PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").bS("tid", PbActivity.this.hLb.hQk).bS("fid", PbActivity.this.hLb.getPbData().getForumId()).O("obj_locate", 3).bS("uid", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()));
                                        }
                                        if (PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null && PbActivity.this.hLb.getPbData().bQx().aiE().getUserId() != null && PbActivity.this.hLd != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bS("tid", PbActivity.this.hLb.hQk).O("obj_locate", 1).bS("obj_id", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()).O("obj_type", PbActivity.this.hLd.afk() ? 0 : 1).O("obj_source", PbActivity.this.c(PbActivity.this.hLb.getPbData())));
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
                                if (PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().ajy() && PbActivity.this.hLb.getPbData().bQx().aiV() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11922"));
                                }
                                if (PbActivity.this.hLb.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hLb.bRu()) && PbActivity.this.hLb.getAppealInfo() != null) {
                                        name = PbActivity.this.hLb.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hLb.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bRu = PbActivity.this.hLb.bRu();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hLb.bTA() && bRu != null && bRu.equals(name)) {
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
                            if (PbActivity.this.hLb.getPbData() != null) {
                                if ((PbActivity.this.hLb.getPbData().bQJ() == 1 || PbActivity.this.hLb.getPbData().bQJ() == 3) && !PbActivity.this.eNb.cpc()) {
                                    PbActivity.this.hLf.bVL();
                                    int i11 = 0;
                                    if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUA()) {
                                        if (PbActivity.this.hLf.hUe.bWJ() == null || view != PbActivity.this.hLf.hUe.bWJ().bUC()) {
                                            if (view == PbActivity.this.hLf.bVr()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hLb.getPbData().bQx().aiA() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hLb.getPbData().bQx().aiz() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hLb.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hLb.getPbData().bQx().getId();
                                    PbActivity.this.hLf.bVq();
                                    PbActivity.this.eNb.b(id4, name2, id5, i11, PbActivity.this.hLf.bVs());
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
                        PbActivity.this.hLf.bVL();
                        PbActivity.this.bki();
                        PbActivity.this.hLf.bVt();
                        PbActivity.this.hLf.showLoadingDialog();
                        if (PbActivity.this.hLf.bVg() != null) {
                            PbActivity.this.hLf.bVg().setVisibility(8);
                        }
                        PbActivity.this.hLb.wD(1);
                        if (PbActivity.this.hKG != null) {
                            PbActivity.this.hKG.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bSb = PbActivity.this.bSb();
                        if (!TextUtils.isEmpty(bSb)) {
                            ba.amO().b(PbActivity.this.getPageContext(), new String[]{bSb});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hLb != null) {
                    com.baidu.tbadk.core.util.an anVar8 = new com.baidu.tbadk.core.util.an("c13398");
                    anVar8.bS("tid", PbActivity.this.hLb.bTy());
                    anVar8.bS("fid", PbActivity.this.hLb.getForumId());
                    anVar8.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar8.O("obj_locate", 1);
                    TiebaStatic.log(anVar8);
                }
                if (PbActivity.this.hKP) {
                    PbActivity.this.hKP = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.bRV().bUW() != null && postData5.aiE() != null && postData5.con() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bRV().bUX() != null) {
                                PbActivity.this.bRV().bUX().bTl();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hLb.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hLb.getPbData().bQx());
                            kVar2.e(postData5);
                            PbActivity.this.bRV().bUW().d(kVar2);
                            PbActivity.this.bRV().bUW().setPostId(postData5.getId());
                            PbActivity.this.b(view, postData5.aiE().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLb.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hLu != null) {
                                PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                    anVar.bS("fid", PbActivity.this.hLb.getPbData().getForumId());
                }
                if (PbActivity.this.hLb != null) {
                    anVar.bS("tid", PbActivity.this.hLb.bTy());
                }
                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            PbActivity.this.bki();
            PbActivity.this.hLf.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.axh() && PbActivity.this.bRD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bRD().AP(postWriteCallBackData.getPostId());
                    PbActivity.this.hLH = PbActivity.this.hLf.bVc();
                    if (PbActivity.this.hLb != null) {
                        PbActivity.this.hLb.bY(PbActivity.this.hLH, PbActivity.this.hLf.bVd());
                    }
                }
                PbActivity.this.hLf.bVL();
                PbActivity.this.hLk.bWk();
                if (PbActivity.this.hLu != null) {
                    PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                }
                PbActivity.this.hLf.bUV();
                PbActivity.this.hLf.oL(true);
                PbActivity.this.hLb.bTR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hLb.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                            if (pbData != null && pbData.bQx() != null && pbData.bQx().aiE() != null && (userId = pbData.bQx().aiE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.axh() && PbActivity.this.hLb.bTI()) {
                                PbActivity.this.hLf.bVt();
                            }
                        } else if (!com.baidu.tbadk.t.av.axh() && PbActivity.this.hLb.bTI()) {
                            PbActivity.this.hLf.bVt();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hLf.m(PbActivity.this.hLb.getPbData());
                    }
                    if (PbActivity.this.hLb.bTD()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10369").bS("tid", PbActivity.this.hLb.bTy()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hLu.auJ() || PbActivity.this.hLu.auK()) {
                    PbActivity.this.hLu.a(false, postWriteCallBackData);
                }
                PbActivity.this.hLk.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gVU != null) {
                    PbActivity.this.gVU.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (yVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hMh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.y yVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13268");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                    anVar.bS("fid", PbActivity.this.hLb.getPbData().getForumId());
                }
                if (PbActivity.this.hLb != null) {
                    anVar.bS("tid", PbActivity.this.hLb.bTy());
                }
                anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (PbActivity.this.hLk != null) {
                    PbActivity.this.hLk.bWj();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gVU != null) {
                    PbActivity.this.gVU.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hLk != null) {
                if (PbActivity.this.hLf != null && PbActivity.this.hLf.bUX() != null && PbActivity.this.hLf.bUX().bTp() != null && PbActivity.this.hLf.bUX().bTp().auK()) {
                    PbActivity.this.hLf.bUX().bTp().a(postWriteCallBackData);
                }
                PbActivity.this.hLk.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hMi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bWi;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hLf != null && (bWi = PbActivity.this.hLf.bWi()) != null && PbActivity.this.hLf.getListView() != null) {
                            PbActivity.this.hLf.getListView().removeHeaderView(bWi);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hMj = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g jH;
            if (!z || dVar == null || dVar.bQH() != null || com.baidu.tbadk.core.util.v.getCount(dVar.bQz()) >= 1) {
                PbActivity.this.hoj = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hLf.bVv();
                if (dVar == null || !dVar.bQD()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hLf.getView());
                }
                PbActivity.this.hLf.bCs();
                if (PbActivity.this.isFullScreen || PbActivity.this.hLf.bWd()) {
                    PbActivity.this.hLf.bVU();
                } else if (!PbActivity.this.hLf.bVR()) {
                    PbActivity.this.hLf.oL(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hLn = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hLf.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hLf.aMo();
                    if (dVar.bQx() != null && dVar.bQx().ajH() != null) {
                        PbActivity.this.a(dVar.bQx().ajH());
                    }
                    PbActivity.this.bRR();
                    if (PbActivity.this.hLu != null) {
                        PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bQz() != null && dVar.bQz().size() >= 1 && dVar.bQz().get(0) != null) {
                        PbActivity.this.hLb.AO(dVar.bQz().get(0).getId());
                    } else if (dVar.bQH() != null) {
                        PbActivity.this.hLb.AO(dVar.bQH().getId());
                    }
                    if (PbActivity.this.hLu != null) {
                        PbActivity.this.hLu.a(dVar.getAnti());
                        PbActivity.this.hLu.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hLu.a(PbActivity.this.hLb.bTL(), PbActivity.this.hLb.bTy(), PbActivity.this.hLb.bUe());
                        if (dVar.bQx() != null) {
                            PbActivity.this.hLu.fl(dVar.bQx().ajV());
                        }
                    }
                    if (PbActivity.this.hLd != null) {
                        PbActivity.this.hLd.dO(dVar.afk());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hLf.oK(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hLf.a(dVar, i2, i3, PbActivity.this.hLb.bTz(), i4, PbActivity.this.hLb.getIsFromMark());
                    PbActivity.this.hLf.e(dVar, PbActivity.this.hLb.bTz());
                    PbActivity.this.hLf.oH(PbActivity.this.hLb.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cGe = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cGe) && PbActivity.this.hLu != null && PbActivity.this.hLu.atX() != null && (jH = PbActivity.this.hLu.atX().jH(6)) != null && !TextUtils.isEmpty(PbActivity.this.cGe)) {
                            ((View) jH).setOnClickListener(PbActivity.this.cGS);
                        }
                    }
                    if (PbActivity.this.hLp) {
                        PbActivity.this.hLp = false;
                        final int bSi = PbActivity.this.bSi();
                        if (!dVar.bQV()) {
                            PbActivity.this.hLf.wP(bSi);
                        } else {
                            final int equipmentWidth = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bSi, equipmentWidth);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hLq) {
                        PbActivity.this.hLq = false;
                        final int bSi2 = PbActivity.this.bSi();
                        final boolean z2 = bSi2 != -1;
                        if (!z2) {
                            bSi2 = PbActivity.this.bSj();
                        }
                        if (PbActivity.this.hLf != null) {
                            if (!dVar.bQV()) {
                                PbActivity.this.hLf.wP(bSi2);
                            } else {
                                final int equipmentWidth2 = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bSi2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hLf.setSelectionFromTop(bSi2, equipmentWidth2);
                                            } else {
                                                PbActivity.this.hLf.setSelectionFromTop(bSi2 - 1, equipmentWidth2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hLf.oM(true);
                                PbActivity.this.hLf.oL(false);
                            }
                        }
                    } else if (PbActivity.this.hLr) {
                        PbActivity.this.hLr = false;
                        PbActivity.this.hLf.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hLf.bVz();
                    }
                    PbActivity.this.hLb.a(dVar.getForum(), PbActivity.this.hLU);
                    PbActivity.this.hLb.a(PbActivity.this.hLV);
                    if (PbActivity.this.gVU != null && dVar.bQx() != null && dVar.bQx().aiE() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bQx().aiE());
                        PbActivity.this.gVU.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hLn && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hLb != null && PbActivity.this.hLb.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hLb.getAppealInfo().hHP)) {
                                    PbActivity.this.hLf.a(PbActivity.this.hLb.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hLf.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hLf.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hLf.bVU();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hLb.bTy());
                            jSONObject.put("fid", PbActivity.this.hLb.getForumId());
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
                        PbActivity.this.hLf.AS("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                            arrayList = PbActivity.this.hLb.getPbData().bQz();
                        }
                        if (com.baidu.tbadk.core.util.v.getCount(arrayList) != 0 && (com.baidu.tbadk.core.util.v.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).con() != 1)) {
                            PbActivity.this.hLf.AS(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bSG()) {
                            PbActivity.this.hLf.AT(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hLf.AT(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hLf.endLoadData();
                }
                PbActivity.this.cLq = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bRD().bTz() || PbActivity.this.bRD().getPbData().getPage().ahz() != 0 || PbActivity.this.bRD().bTY()) {
                    PbActivity.this.hLv = true;
                    return;
                }
                return;
            }
            PbActivity.this.hLb.wD(1);
            if (PbActivity.this.hKG != null) {
                PbActivity.this.hKG.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hLf.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.awL().awM()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.faW : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.cLi, PbActivity.this.createTime, PbActivity.this.cLq, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cLi = 0L;
                if (iVar != null) {
                    iVar.awI();
                }
                if (z2) {
                    iVar.cLz = currentTimeMillis;
                    iVar.fw(true);
                }
                if (!z2 && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null) {
                    int threadType = PbActivity.this.hLb.getPbData().bQx().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.aq.equals(PbActivity.this.hKS, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.aq.equals(PbActivity.this.hKS, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.setSubType(1000);
                                iVar2.cLB = currentTimeMillis;
                                iVar2.kf(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.setSubType(1005);
                        dVar.cLB = currentTimeMillis;
                        dVar.kf(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hMk = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bSe();
            }
        }
    };
    private final a.InterfaceC0274a hMl = new a.InterfaceC0274a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0274a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hLf.bVv();
            if (z) {
                if (PbActivity.this.hLd != null) {
                    PbActivity.this.hLd.dO(z2);
                }
                PbActivity.this.hLb.or(z2);
                if (PbActivity.this.hLb.afk()) {
                    PbActivity.this.bSo();
                } else {
                    PbActivity.this.hLf.m(PbActivity.this.hLb.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hLd != null && PbActivity.this.hLd.afn() != null && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null) {
                        MarkData afn = PbActivity.this.hLd.afn();
                        MetaData aiE = PbActivity.this.hLb.getPbData().bQx().aiE();
                        if (afn != null && aiE != null) {
                            if (!com.baidu.tbadk.core.util.aq.equals(TbadkCoreApplication.getCurrentAccount(), aiE.getUserId()) && !aiE.hadConcerned()) {
                                PbActivity.this.b(aiE);
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
            if (!PbActivity.this.wq(PbActivity.this.mLastScrollState) && PbActivity.this.wq(i)) {
                if (PbActivity.this.hLf != null) {
                    PbActivity.this.hLf.bVL();
                    if (PbActivity.this.hLu != null && !PbActivity.this.hLf.bUZ()) {
                        PbActivity.this.hLf.oJ(PbActivity.this.hLu.auD());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hLf.bUY();
                    }
                }
                if (!PbActivity.this.hKM) {
                    PbActivity.this.hKM = true;
                    PbActivity.this.hLf.bVQ();
                }
            }
            PbActivity.this.hLf.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hKG != null) {
                PbActivity.this.hKG.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hKN == null) {
                PbActivity.this.hKN = new com.baidu.tbadk.p.b();
                PbActivity.this.hKN.setSubType(1001);
            }
            if (i == 0) {
                PbActivity.this.hKN.awC();
            } else {
                PbActivity.this.hKN.awB();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.cni().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bQz;
            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLf != null && PbActivity.this.hLf.bVp() != null) {
                PbActivity.this.hLf.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hKG != null) {
                    PbActivity.this.hKG.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hLb.bTT() && (bQz = PbActivity.this.hLb.getPbData().bQz()) != null && !bQz.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hLf.bVp().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
                    if (pbData != null) {
                        if (pbData.bQA() != null && pbData.bQA().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bQB() != null && pbData.bQB().hasData()) {
                            headerCount--;
                        }
                        int size = bQz.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eNf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eNb.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hLb.bTR();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.iby != 1002 || bVar.dQT) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hLf.a(1, dVar.sF, dVar.jkg, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eNb.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hLf.a(PbActivity.this.eNb.getLoadDataMode(), gVar.sF, gVar.jkg, false);
                        PbActivity.this.hLf.aB(gVar.jkj);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hLf.a(PbActivity.this.eNb.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hMm = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c djF = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (PbActivity.this.bSu()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hLb.oq(true)) {
                PbActivity.this.hLf.bVw();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fPg = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hMn && PbActivity.this.bSu()) {
                PbActivity.this.bSw();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hLb.op(false)) {
                    PbActivity.this.hLf.bVu();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hLb.getPbData() != null) {
                    PbActivity.this.hLf.bVP();
                }
                PbActivity.this.hMn = true;
            }
        }
    };
    private int hMo = 0;
    private final TbRichTextView.h cTN = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bVp;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hLb != null) {
                        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13398");
                        anVar.bS("tid", PbActivity.this.hLb.bTy());
                        anVar.bS("fid", PbActivity.this.hLb.getForumId());
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
                        PbActivity.this.hKW = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hNe) {
                        TbRichText bb = PbActivity.this.bb(str, i);
                        if (bb != null && PbActivity.this.hMo >= 0 && PbActivity.this.hMo < bb.azf().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bb.azf().get(PbActivity.this.hMo));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hNb.size()) {
                                    break;
                                } else if (!cVar.hNb.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bb.getPostId() != 0 && (bVp = PbActivity.this.hLf.bVp()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bVp.getDataList();
                                if (com.baidu.tbadk.core.util.v.getCount(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bb.getPostId() == com.baidu.adp.lib.g.b.toLong(((PostData) next).getId(), 0L)) {
                                            if (bb.getPostId() != com.baidu.adp.lib.g.b.toLong(PbActivity.this.hLb.bUe(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hLb.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hNc.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNd, cVar.lastId, PbActivity.this.hLb.bTO(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.i(rect);
                            createConfig.setIsHotSort(PbActivity.this.hLb.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.getItem(cVar.hNb, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hNc.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hNd, cVar.hNb.get(0), PbActivity.this.hLb.bTO(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hLb.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hLf.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hMp = false;
    PostData got = null;
    private final b.a hMq = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.got != null) {
                if (i == 0) {
                    PbActivity.this.got.ec(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.got = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.got);
                }
            }
        }
    };
    private final b.a hMr = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hLE != null && !TextUtils.isEmpty(PbActivity.this.hLF)) {
                if (i == 0) {
                    if (PbActivity.this.hLG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.hLF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hLF;
                        aVar.pkgId = PbActivity.this.hLG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    PbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    PbActivity.this.mPermissionJudgement.appendRequestPermission(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.startRequestPermission(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fWM == null) {
                            PbActivity.this.fWM = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fWM.g(PbActivity.this.hLF, PbActivity.this.hLE.getImageByte());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hLE = null;
                PbActivity.this.hLF = null;
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
                        PbActivity.this.hLE = ((TbImageView) view).getBdImage();
                        PbActivity.this.hLF = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hLE == null || TextUtils.isEmpty(PbActivity.this.hLF)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLG = null;
                        } else {
                            PbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hLE = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hLF = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hLG = null;
                            } else {
                                PbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hLE = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hLF = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hLG = null;
                        } else {
                            PbActivity.this.hLG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hLf.a(PbActivity.this.hMr, PbActivity.this.hLE.isGif());
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
            PbActivity.this.got = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.got == null) {
                return true;
            }
            if (PbActivity.this.got.con() != 1 || !PbActivity.this.cu(view)) {
                if (PbActivity.this.hLd != null) {
                    if (!PbActivity.this.hLd.afk() || PbActivity.this.got.getId() == null || !PbActivity.this.got.getId().equals(PbActivity.this.hLb.aiN())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.got.con() == 1) {
                        PbActivity.this.hLf.a(PbActivity.this.hMq, z, false);
                        return true;
                    }
                    if (PbActivity.this.hLm == null) {
                        PbActivity.this.hLm = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hLm.a(PbActivity.this.hMs);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cu = PbActivity.this.cu(view);
                        boolean z3 = (!PbActivity.this.cu(view) || PbActivity.this.hLE == null || PbActivity.this.hLE.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hLm);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cu) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hLm));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hLm));
                        }
                        if (!cu && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hLm);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.got);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hLm);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hLm);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.got);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hLm);
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
                                if (!ap.m(PbActivity.this.got)) {
                                    oa = PbActivity.this.oa(z5) & PbActivity.this.isLogin();
                                } else {
                                    oa = false;
                                }
                                if (oa) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLm);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLm);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hLm);
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
                                    if (PbActivity.this.hLb.getPbData().bQJ() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hLm);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hLm);
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
                        PbActivity.this.hLm.at(arrayList);
                        PbActivity.this.hLl = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hLm);
                        PbActivity.this.hLl.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13272").bS("tid", PbActivity.this.hLb.hQk).bS("fid", PbActivity.this.hLb.getForumId()).bS("uid", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()).bS("post_id", PbActivity.this.hLb.aus()).O("obj_source", z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hLf.a(PbActivity.this.hMr, PbActivity.this.hLE.isGif());
            return true;
        }
    };
    private k.c hMs = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hLl != null) {
                PbActivity.this.hLl.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hLb.getPbData();
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
                    if (PbActivity.this.hLE != null && !TextUtils.isEmpty(PbActivity.this.hLF)) {
                        if (PbActivity.this.hLG == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, PbActivity.this.hLF));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hLF;
                            aVar.pkgId = PbActivity.this.hLG.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hLG.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        PbActivity.this.hLE = null;
                        PbActivity.this.hLF = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hLE != null && !TextUtils.isEmpty(PbActivity.this.hLF)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                        }
                        PbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                        PbActivity.this.mPermissionJudgement.appendRequestPermission(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.startRequestPermission(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fWM == null) {
                                PbActivity.this.fWM = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fWM.g(PbActivity.this.hLF, PbActivity.this.hLE.getImageByte());
                            PbActivity.this.hLE = null;
                            PbActivity.this.hLF = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.got != null) {
                        PbActivity.this.got.ec(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.got = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11739").O("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ct(view);
                        if (PbActivity.this.hLb.getPbData().bQx() != null && PbActivity.this.hLb.getPbData().bQx().aiE() != null && PbActivity.this.hLb.getPbData().bQx().aiE().getUserId() != null && PbActivity.this.hLd != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12526").bS("tid", PbActivity.this.hLb.hQk).O("obj_locate", 2).bS("obj_id", PbActivity.this.hLb.getPbData().bQx().aiE().getUserId()).O("obj_type", PbActivity.this.hLd.afk() ? 0 : 1).O("obj_source", PbActivity.this.c(PbActivity.this.hLb.getPbData())));
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
                        PbActivity.this.hLf.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hLf.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hLf.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a fsc = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (!PbActivity.this.aqk && z && !PbActivity.this.hLb.bTF()) {
                PbActivity.this.bSq();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener czy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.fyF.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0400a eXk = new a.InterfaceC0400a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int dQA;

        {
            this.dQA = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void t(int i, int i2) {
            if (aj(i2) && PbActivity.this.hLf != null && PbActivity.this.hKG != null) {
                PbActivity.this.hLf.bVV();
                PbActivity.this.hKG.kc(false);
                PbActivity.this.hKG.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void u(int i, int i2) {
            if (aj(i2) && PbActivity.this.hLf != null && PbActivity.this.hKG != null) {
                PbActivity.this.hKG.kc(true);
                if (Math.abs(i2) > this.dQA) {
                    PbActivity.this.hKG.hideFloatingView();
                }
                if (PbActivity.this.bSu()) {
                    PbActivity.this.hLf.bVm();
                    PbActivity.this.hLf.bVn();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void v(int i, int i2) {
        }

        private boolean aj(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hMu = null;
    private final m.a hMv = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void o(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hMu = str2;
                PbActivity.this.hLf.AU(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hMw = -1;
    private int hMx = -1;
    private CustomMessageListener hMA = new CustomMessageListener(CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bVH == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0276a) {
                    if (aVar.bVI != null && !aVar.bVI.hasError() && aVar.bVI.getError() == 0) {
                        if (PbActivity.this.hLf != null) {
                            PbActivity.this.hLf.r(((a.C0276a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bSF();
                        }
                    } else if (z) {
                        if (aVar.bVI != null && aVar.bVI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bVI.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bVI != null && !aVar.bVI.hasError() && aVar.bVI.getError() == 0) {
                        if (PbActivity.this.hLf != null && PbActivity.this.hLf != null) {
                            PbActivity.this.hLf.r(((a.C0276a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bVI != null && aVar.bVI.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bVI.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bVI == null || aVar.bVI.hasError() || aVar.bVI.getError() != 0) {
                        if (z) {
                            if (aVar.bVI != null && aVar.bVI.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bVI.getErrorString());
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
        public ArrayList<String> hNb;
        public ConcurrentHashMap<String, ImageUrlData> hNc;
        public boolean hNe;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hNd = false;
        public boolean hNf = false;
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

    public com.baidu.tbadk.editortools.pb.d bRQ() {
        return this.hLu;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bRg() != null) {
            String id = kVar.bRg().getId();
            ArrayList<PostData> bQz = this.hLb.getPbData().bQz();
            int i = 0;
            while (true) {
                if (i >= bQz.size()) {
                    break;
                }
                PostData postData = bQz.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bRk = kVar.bRk();
                    postData.zP(kVar.getTotalCount());
                    if (postData.cok() != null && bRk != null) {
                        Iterator<PostData> it = bRk.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aiE() != null && (metaData = postData.getUserMap().get(next.aiE().getUserId())) != null) {
                                next.a(metaData);
                                next.qQ(true);
                                next.a(getPageContext(), this.hLb.AN(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bRk.size() != postData.cok().size();
                        postData.cok().clear();
                        postData.cok().addAll(bRk);
                        z = z2;
                    }
                    if (postData.cog() != null) {
                        postData.coh();
                    }
                }
            }
            if (!this.hLb.getIsFromMark() && z) {
                this.hLf.m(this.hLb.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bQM = this.hLb.getPbData().bQM();
            if (bQM != null && str.equals(bQM.getAdId())) {
                if (bQM.cob() != null) {
                    bQM.cob().legoCard = null;
                }
                this.hLb.getPbData().bQN();
            }
            com.baidu.tieba.tbadkCore.data.m bTJ = this.hLb.bTJ();
            if (bTJ != null && str.equals(bTJ.getAdId())) {
                this.hLb.bTK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hLl != null && this.hLl.isShowing()) {
                this.hLl.dismiss();
                this.hLl = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hLl != null) {
                            PbActivity.this.hLl.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hLf.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hLC);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hLC);
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
                this.hLl = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar);
                this.hLl.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(int i) {
        bh bQx;
        if (this.hLb != null && this.hLb.getPbData() != null && (bQx = this.hLb.getPbData().bQx()) != null) {
            if (i == 1) {
                PraiseData aiq = bQx.aiq();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (aiq == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bQx.a(praiseData);
                    } else {
                        bQx.aiq().getUser().add(0, metaData);
                        bQx.aiq().setNum(bQx.aiq().getNum() + 1);
                        bQx.aiq().setIsLike(i);
                    }
                }
                if (bQx.aiq() != null) {
                    if (bQx.aiq().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.aq.numFormatOver10000(bQx.aiq().getNum());
                    }
                }
            } else if (bQx.aiq() != null) {
                bQx.aiq().setIsLike(i);
                bQx.aiq().setNum(bQx.aiq().getNum() - 1);
                ArrayList<MetaData> user = bQx.aiq().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bQx.aiq().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bQx.aiq().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bQx.aiq().getNum() + "";
                }
            }
            if (this.hLb.bTz()) {
                this.hLf.bVp().notifyDataSetChanged();
            } else {
                this.hLf.n(this.hLb.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hLb.aa(bundle);
        if (this.fuw != null) {
            this.fuw.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hLu.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hKL = System.currentTimeMillis();
        this.hLA = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.faW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hKS = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hKS) && intent.getData() != null) {
                this.hKS = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hKS)) {
                this.hKH = true;
            }
            this.hMw = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hMx = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hMy = intent.getStringExtra("key_manga_title");
            this.hLp = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hLq = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hLr = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bSu()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.aq.isEmpty(this.source) ? "" : this.source;
            this.hLI = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            this.hKZ = new com.baidu.tbadk.core.data.av();
            this.hKZ.U(intent);
        } else {
            this.faW = System.currentTimeMillis();
        }
        this.cLi = this.hKL - this.faW;
        super.onCreate(bundle);
        this.hKJ = 0;
        Z(bundle);
        if (this.hLb != null && this.hLb.getPbData() != null) {
            this.hLb.getPbData().AD(this.source);
        }
        bRU();
        initUI();
        if (intent != null && this.hLf != null) {
            this.hLf.hTX = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hLD == null) {
                    this.hLD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hLf.AW("@" + intent.getStringExtra("big_pic_type") + HanziToPinyin.Token.SEPARATOR);
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hLD, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hLb != null && this.hLb.getPbData() != null) {
                this.hLb.AQ(stringExtra);
            }
        }
        this.fuw = new VoiceManager();
        this.fuw.onCreate(getPageContext());
        initData(bundle);
        this.hLt = new com.baidu.tbadk.editortools.pb.f();
        bRR();
        this.hLu = (com.baidu.tbadk.editortools.pb.d) this.hLt.cw(getActivity());
        this.hLu.b(this);
        this.hLu.a(this.cGo);
        this.hLu.a(this.cGh);
        this.hLu.a(this, bundle);
        this.hLu.atX().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hLu.atX().fe(true);
        nZ(true);
        this.hLf.setEditorTools(this.hLu.atX());
        this.hLu.a(this.hLb.bTL(), this.hLb.bTy(), this.hLb.bUe());
        registerListener(this.hLP);
        if (!this.hLb.bTE()) {
            this.hLu.pK(this.hLb.bTy());
        }
        if (this.hLb.bUf()) {
            this.hLu.pI(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hLf != null) {
            this.hLu.pI(this.hLf.bVa());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hLO);
        registerListener(this.hLQ);
        registerListener(this.hLR);
        registerListener(this.fvS);
        registerListener(this.hMg);
        registerListener(this.hLN);
        this.hLs = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.jgW);
        this.hLs.cnP();
        registerListener(this.hLT);
        registerListener(this.cji);
        if (this.hLb != null) {
            this.hLb.bTW();
        }
        registerListener(this.hMk);
        registerListener(this.hMA);
        registerListener(this.fvZ);
        if (this.hLf != null && this.hLf.bVZ() != null && this.hLf.bWa() != null) {
            this.hKG = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hLf.bVZ(), this.hLf.bWa(), this.hLf.bVg());
            this.hKG.a(this.hMb);
        }
        if (this.hKF && this.hLf != null && this.hLf.bWa() != null) {
            this.hLf.bWa().setVisibility(8);
        }
        this.hLB = new com.baidu.tbadk.core.view.e();
        this.hLB.toastTime = 1000L;
        registerListener(this.hMf);
        registerListener(this.hMd);
        registerListener(this.hMe);
        registerListener(this.fMd);
        registerListener(this.fvP);
        this.hLC = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hLC;
        userMuteAddAndDelCustomMessage.setTag(this.hLC);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.hLC;
        userMuteCheckCustomMessage.setTag(this.hLC);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hLb.bUc().a(this.hMc);
        this.hLk = new as();
        if (this.hLu.auw() != null) {
            this.hLk.g(this.hLu.auw().getInputView());
        }
        this.hLu.a(this.cGi);
        this.fKT = new ShareSuccessReplyToServerModel();
        a(this.hLK);
        this.gVU = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gVU.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.ciZ) {
                        PbActivity.this.hLu.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.cja && PbActivity.this.hLf != null && PbActivity.this.hLf.bUX() != null && PbActivity.this.hLf.bUX().bTp() != null) {
                        PbActivity.this.hLf.bUX().bTp().auP();
                    } else if (i == com.baidu.tbadk.core.util.aj.cjb) {
                        PbActivity.this.c(PbActivity.this.hLx);
                    }
                }
            }
        });
        this.hLc = new com.baidu.tieba.pb.pb.report.a(this);
        this.hLc.s(getUniqueId());
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        com.baidu.tbadk.core.business.a.agA().bH("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
        }
        this.createTime = System.currentTimeMillis() - this.hKL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        if (this.hLt != null && this.hLb != null) {
            this.hLt.setForumName(this.hLb.bRu());
            if (this.hLb.getPbData() != null && this.hLb.getPbData().getForum() != null) {
                this.hLt.a(this.hLb.getPbData().getForum());
            }
            this.hLt.setFrom("pb");
            this.hLt.a(this.hLb);
        }
    }

    public String bRS() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bRT() {
        return this.hKG;
    }

    private void nZ(boolean z) {
        this.hLu.fi(z);
        this.hLu.fj(z);
        this.hLu.fk(z);
    }

    private void bRU() {
        this.crO = new LikeModel(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQV() && !z && this.hLf != null && this.hLf.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hLf.getView().setSystemUiVisibility(4);
        }
        this.hLy = z;
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
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    public aq bRV() {
        return this.hLf;
    }

    public PbModel bRD() {
        return this.hLb;
    }

    public void AG(String str) {
        if (this.hLb != null && !StringUtils.isNull(str) && this.hLf != null) {
            this.hLf.oO(true);
            this.hLb.AG(str);
            this.hKR = true;
            this.hLf.bVL();
            this.hLf.bVU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.aqk = false;
        } else {
            this.aqk = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hKJ = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hKJ == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
        if (this.hLf != null) {
            this.hLf.onPause();
        }
        if (!this.hLb.bTE()) {
            this.hLu.pJ(this.hLb.bTy());
        }
        if (this.hLb != null) {
            this.hLb.bTX();
        }
        com.baidu.tbadk.BdToken.c.adX().aec();
        MessageManager.getInstance().unRegisterListener(this.gzO);
        bvS();
        MessageManager.getInstance().unRegisterListener(this.hMd);
        MessageManager.getInstance().unRegisterListener(this.hMe);
        MessageManager.getInstance().unRegisterListener(this.hMf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
    }

    private boolean bRW() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hLb.getPbData(), this.hLb.bTz(), this.hLb.bTU());
        return (a2 == null || a2.aiE() == null || a2.aiE().getGodUserData() == null || a2.aiE().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.aqk = false;
        super.onResume();
        if (this.hKU) {
            this.hKU = false;
            bSA();
        }
        if (bRW()) {
            this.hKO = System.currentTimeMillis();
        } else {
            this.hKO = -1L;
        }
        if (this.hLf != null && this.hLf.getView() != null) {
            if (!this.hoj) {
                bSr();
            } else {
                hideLoadingView(this.hLf.getView());
            }
            this.hLf.onResume();
        }
        if (this.hKJ == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hLf != null) {
            noNetworkView = this.hLf.bUU();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            noNetworkView.update(false);
        }
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
        registerListener(this.gzO);
        this.hLo = false;
        bSz();
        registerListener(this.hMd);
        registerListener(this.hMe);
        registerListener(this.hMf);
        if (this.fvl) {
            bSq();
            this.fvl = false;
        }
        bSI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hLf.oD(z);
        if (this.hLl != null) {
            this.hLl.dismiss();
        }
        if (z && this.hLo) {
            this.hLf.bVu();
            this.hLb.op(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hKO > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10804").bS("obj_duration", (System.currentTimeMillis() - this.hKO) + ""));
            this.hKO = 0L;
        }
        if (bRV().bUX() != null) {
            bRV().bUX().onStop();
        }
        if (this.hLf.hUe != null && !this.hLf.hUe.bbe()) {
            this.hLf.hUe.bHo();
        }
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().getForum() != null && this.hLb.getPbData().bQx() != null) {
            com.baidu.tbadk.distribute.a.atL().a(getPageContext().getPageActivity(), "pb", this.hLb.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLb.getPbData().bQx().getId(), 0L));
        }
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ACTIVITY_ON_DESTROY);
        customResponsedMessage.setOrginalMessage(new CustomMessage((int) CmdConfigCustom.PB_ACTIVITY_ON_DESTROY, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13266");
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("fid", this.hLb.getPbData().getForumId());
            anVar.bS("tid", this.hLb.bTy());
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(anVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hKM && this.hLf != null) {
            this.hKM = true;
            this.hLf.bVQ();
            a(false, (PostData) null);
        }
        if (this.hLb != null) {
            this.hLb.cancelLoadData();
            this.hLb.destory();
            if (this.hLb.bUb() != null) {
                this.hLb.bUb().onDestroy();
            }
        }
        if (this.hLu != null) {
            this.hLu.onDestroy();
        }
        if (this.eNb != null) {
            this.eNb.cancelLoadData();
        }
        if (this.crO != null) {
            this.crO.cnD();
        }
        if (this.hLf != null) {
            this.hLf.onDestroy();
            if (this.hLf.hUe != null) {
                this.hLf.hUe.bHo();
            }
        }
        if (this.hKN != null) {
            this.hKN.awD();
        }
        if (this.hKG != null) {
            this.hKG.axK();
        }
        super.onDestroy();
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
        this.hLf.bVL();
        MessageManager.getInstance().unRegisterListener(this.hMd);
        MessageManager.getInstance().unRegisterListener(this.hMe);
        MessageManager.getInstance().unRegisterListener(this.hMf);
        MessageManager.getInstance().unRegisterListener(this.hLC);
        MessageManager.getInstance().unRegisterListener(this.hMg);
        MessageManager.getInstance().unRegisterListener(this.fvZ);
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.hMi);
        this.hLA = null;
        this.hLB = null;
        com.baidu.tieba.recapp.d.a.cgB().cgD();
        if (this.hLD != null) {
            getSafeHandler().removeCallbacks(this.hLD);
        }
        if (this.hKV != null) {
            this.hKV.cancelLoadData();
        }
        if (this.hLf != null && this.hLf.hUe != null) {
            this.hLf.hUe.bWN();
        }
        if (this.fKT != null) {
            this.fKT.cancelLoadData();
        }
        this.hLk.onDestroy();
        if (this.hLb != null && this.hLb.bUd() != null) {
            this.hLb.bUd().onDestroy();
        }
        if (this.gVU != null) {
            this.gVU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bVp;
        ArrayList<PostData> bTa;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.aoS() && this.hLf != null && (bVp = this.hLf.bVp()) != null && (bTa = bVp.bTa()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bTa.iterator();
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
                        bVar.eOW = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.cbV == 1 && !TextUtils.isEmpty(id)) {
                    next.cbV = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eOW = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hLb == null || this.hLb.getPbData() == null || this.hLb.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hLb.getPbData().getForum().getFirst_class();
                    str2 = this.hLb.getPbData().getForum().getSecond_class();
                    str = this.hLb.getPbData().getForum().getId();
                    str4 = this.hLb.bTy();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.aoV());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hLf.onChangeSkinType(i);
            if (this.hLu != null && this.hLu.atX() != null) {
                this.hLu.atX().onChangeSkinType(i);
            }
            if (this.hLf.bUU() != null) {
                this.hLf.bUU().onChangeSkinType(getPageContext(), i);
            }
            this.hLk.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.am.getColor(i, getResources(), R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hLf = new aq(this, this.fwH, this.cyE);
        this.fyF = new com.baidu.tieba.f.b(getActivity());
        this.fyF.a(hMt);
        this.fyF.a(this.eXk);
        this.hLf.setOnScrollListener(this.mOnScrollListener);
        this.hLf.d(this.fPg);
        this.hLf.setListPullRefreshListener(this.djF);
        this.hLf.nT(com.baidu.tbadk.core.i.ago().isShowImages());
        this.hLf.setOnImageClickListener(this.cTN);
        this.hLf.b(this.mOnLongClickListener);
        this.hLf.h(this.fsc);
        this.hLf.a(this.hMm);
        this.hLf.oD(this.mIsLogin);
        if (getIntent() != null) {
            this.hLf.oP(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hLf.bUW().setFromForumId(this.hLb.getFromForumId());
    }

    public void bRX() {
        if (this.hLf != null && this.hLb != null) {
            if ((this.hLb.getPbData() != null || this.hLb.getPbData().bQU() != null) && checkUpIsLogin() && this.hLf.bVp() != null && this.hLf.bVp().bTf() != null) {
                this.hLf.bVp().bTf().oz(this.hLb.bTy());
            }
        }
    }

    public void bRY() {
        TiebaStatic.log("c12181");
        if (this.hLf != null && this.hLb != null) {
            if (this.hLf == null || this.hLf.bUZ()) {
                if (this.hLb.getPbData() != null || this.hLb.getPbData().bQU() != null) {
                    com.baidu.tieba.pb.data.j bQU = this.hLb.getPbData().bQU();
                    if (checkUpIsLogin()) {
                        if ((!bQU.bRd() || bQU.ajZ() != 2) && this.hLf.bVp() != null && this.hLf.bVp().bTf() != null) {
                            this.hLf.bVp().bTf().oz(this.hLb.bTy());
                        }
                        if (System.currentTimeMillis() - this.hKQ > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pj(false);
                            this.hKQ = System.currentTimeMillis();
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
                if (postData.getType() != PostData.jhx && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.ago().isShowImages()) {
                    return AJ(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hLb == null || this.hLb.getPbData() == null) {
                        return true;
                    }
                    if (bRV().bUX() != null) {
                        bRV().bUX().bTl();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hLb.getPbData().getForum());
                    kVar.ai(this.hLb.getPbData().bQx());
                    kVar.e(postData);
                    bRV().bUW().d(kVar);
                    bRV().bUW().setPostId(postData.getId());
                    b(view, postData.aiE().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hLu != null) {
                        this.hLf.oJ(this.hLu.auD());
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
        if (this.hLf != null) {
            if (z && !this.hoj) {
                bSr();
            } else {
                hideLoadingView(this.hLf.getView());
            }
            if (z && this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQV() && this.hLf.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hLf.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bRZ() {
        if (this.hKK == null) {
            this.hKK = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hKK.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hKA = PbActivity.this.hKA.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKA);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLb.bTy(), PbActivity.this.hKA, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hKA = PbActivity.this.hKA.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKA);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hLb.bTy(), PbActivity.this.hKA, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hKA = PbActivity.this.hKA.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hKA);
                        bVar.dismiss();
                    }
                }
            }).hY(R.style.dialog_ani_b2t).hZ(17).d(getPageContext());
        }
    }

    private void Z(Bundle bundle) {
        this.hLb = new PbModel(this);
        this.hLb.a(this.hMj);
        if (this.hLb.bUa() != null) {
            this.hLb.bUa().a(this.hMv);
        }
        if (this.hLb.bTZ() != null) {
            this.hLb.bTZ().a(this.hLS);
        }
        if (this.hLb.bUb() != null) {
            this.hLb.bUb().b(this.hLM);
        }
        if (bundle != null) {
            this.hLb.initWithBundle(bundle);
        } else {
            this.hLb.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra("request_code", -1) == 18003) {
            this.hLb.os(true);
        }
        aj.bUI().ap(this.hLb.bTw(), this.hLb.getIsFromMark());
        if (StringUtils.isNull(this.hLb.bTy())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hKS) && this.hKS != null) {
            this.hLb.wK(6);
        }
        this.hLb.loadData();
    }

    private void initData(Bundle bundle) {
        this.hLd = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hLd != null) {
            this.hLd.a(this.hMl);
        }
        this.eNb = new ForumManageModel(this);
        this.eNb.setLoadDataCallBack(this.eNf);
        this.cje = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hLf.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void callback(Object obj) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hLb.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hLb.getPbData().getForum().getId(), PbActivity.this.hLb.getPbData().getForum().getName(), PbActivity.this.hLb.getPbData().bQx().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hLY.setUniqueId(getUniqueId());
        this.hLY.registerListener();
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hLf.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hLC;
        userMuteCheckCustomMessage.setTag(this.hLC);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bSa() {
        if (checkUpIsLogin()) {
            if (this.fyd == null) {
                this.fyd = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fyd.ry(0);
                this.fyd.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jW(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void o(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jX(boolean z) {
                        if (z) {
                            PbActivity.this.hLf.bvx();
                        }
                    }
                });
            }
            if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().getForum() != null) {
                this.fyd.z(this.hLb.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bSb() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hLb != null && (pbData = this.hLb.getPbData()) != null) {
            return pbData.bQI().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQx() != null) {
            if (dVar.bQx().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bQx().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bQx().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bSc()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hKX);
                this.hKY = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hLw == null) {
                this.hLw = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hLw.ry(1);
                this.hLw.a(new AnonymousClass40(str, str2));
            }
            if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().getForum() != null) {
                this.hLw.z(this.hLb.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hMK;
        final /* synthetic */ String hML;

        AnonymousClass40(String str, String str2) {
            this.hMK = str;
            this.hML = str2;
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
                        PbActivity.this.bRV().getListView().smoothScrollBy((PbActivity.this.hKX[1] + PbActivity.this.hKY) - (equipmentHeight - dimens), 50);
                        if (PbActivity.this.bRV().bUX() != null) {
                            PbActivity.this.hLu.atX().setVisibility(8);
                            PbActivity.this.bRV().bUX().ab(AnonymousClass40.this.hMK, AnonymousClass40.this.hML, PbActivity.this.bRV().bVa());
                            com.baidu.tbadk.editortools.pb.g bTp = PbActivity.this.bRV().bUX().bTp();
                            if (bTp != null && PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                                bTp.a(PbActivity.this.hLb.getPbData().getAnti());
                            }
                            if (PbActivity.this.hLk.bWn() == null && PbActivity.this.bRV().bUX().bTp().auX() != null) {
                                PbActivity.this.bRV().bUX().bTp().auX().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hLk != null && PbActivity.this.hLk.bWm() != null) {
                                            if (!PbActivity.this.hLk.bWm().cxz()) {
                                                PbActivity.this.hLk.oR(false);
                                            }
                                            PbActivity.this.hLk.bWm().rL(false);
                                        }
                                    }
                                });
                                PbActivity.this.hLk.h(PbActivity.this.bRV().bUX().bTp().auX().getInputView());
                                PbActivity.this.bRV().bUX().bTp().a(PbActivity.this.hLz);
                            }
                        }
                        PbActivity.this.bRV().bVU();
                    }
                }, 0L);
            }
        }
    }

    public boolean bSc() {
        if (this.gVU == null || this.hLb.getPbData() == null || this.hLb.getPbData().getAnti() == null) {
            return true;
        }
        return this.gVU.ip(this.hLb.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean ws(int i) {
        if (this.gVU == null || this.hLb.getPbData() == null || this.hLb.getPbData().getAnti() == null) {
            return true;
        }
        return this.gVU.Y(this.hLb.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hLb != null && this.hLb.getPbData() != null && postData.con() != 1) {
            String bTy = this.hLb.bTy();
            String id = postData.getId();
            int bQJ = this.hLb.getPbData() != null ? this.hLb.getPbData().bQJ() : 0;
            c AK = AK(id);
            if (AK != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bTy, id, "pb", true, null, false, null, bQJ, postData.bXD(), this.hLb.getPbData().getAnti(), false, postData.aiE() != null ? postData.aiE().getIconInfo() : null).addBigImageData(AK.hNb, AK.hNc, AK.hNd, AK.index);
                addBigImageData.setKeyPageStartFrom(this.hLb.bUh());
                addBigImageData.setFromFrsForumId(this.hLb.getFromForumId());
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSd() {
        if (this.hLb.getPbData() == null || this.hLb.getPbData().bQx() == null) {
            return -1;
        }
        return this.hLb.getPbData().bQx().ajo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Dl(this.hLb.getForumId()) && this.hLb.getPbData() != null && this.hLb.getPbData().getForum() != null) {
            if (this.hLb.getPbData().getForum().isLike() == 1) {
                this.hLb.bUd().dR(this.hLb.getForumId(), this.hLb.bTy());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oa(boolean z) {
        if (this.hLb == null || this.hLb.getPbData() == null) {
            return false;
        }
        return ((this.hLb.getPbData().bQJ() != 0) || this.hLb.getPbData().bQx() == null || this.hLb.getPbData().bQx().aiE() == null || TextUtils.equals(this.hLb.getPbData().bQx().aiE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bSf() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.axi()) {
            return "";
        }
        PostData bQE = bQE();
        if (this.hLb == null || (pbData = this.hLb.getPbData()) == null || pbData.getUserData() == null || pbData.bQx() == null || bQE == null || bQE.aiE() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bQE.aiE().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bQx().ail() == 0) {
            return "";
        }
        if (pbData.bQx().ail() == 0) {
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
        if (this.hLb == null || this.hLb.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bQJ() != 0) {
                return pbData.bQJ() != 3;
            }
            List<bd> bQS = pbData.bQS();
            if (com.baidu.tbadk.core.util.v.getCount(bQS) > 0) {
                for (bd bdVar : bQS) {
                    if (bdVar != null && (vVar = bdVar.cak) != null && vVar.bYd && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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
        if (z || this.hLb == null || this.hLb.getPbData() == null) {
            return false;
        }
        return ((this.hLb.getPbData().getForum() != null && this.hLb.getPbData().getForum().isBlockBawuDelete) || this.hLb.getPbData().bQJ() == 0 || this.hLb.getPbData().bQJ() == 3) ? false : true;
    }

    public void bSg() {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().aiE() != null) {
            if (this.hLf != null) {
                this.hLf.bUV();
            }
            bh bQx = this.hLb.getPbData().bQx();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bQx.aiE().getUserId());
            ab abVar = new ab();
            int bQJ = this.hLb.getPbData().bQJ();
            if (bQJ == 1 || bQJ == 3) {
                abVar.hSo = true;
                abVar.hSn = true;
                abVar.hSv = bQx.aiz() == 1;
                abVar.hSu = bQx.aiA() == 1;
            } else {
                abVar.hSo = false;
                abVar.hSn = false;
            }
            if (bQJ == 1002 && !equals) {
                abVar.hSz = true;
            }
            abVar.hSp = ob(equals);
            abVar.hSq = bSh();
            abVar.hSr = oc(equals);
            abVar.gs = this.hLb.bTz();
            abVar.hSm = true;
            abVar.hSl = oa(equals);
            abVar.hSx = bSf();
            abVar.hSk = equals && this.hLf.bVB();
            abVar.hSs = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hSt = true;
            abVar.isHostOnly = this.hLb.getHostMode();
            abVar.hSw = true;
            if (bQx.aiV() == null) {
                abVar.hSy = true;
            } else {
                abVar.hSy = false;
            }
            this.hLf.hUe.a(abVar);
        }
    }

    private boolean bSh() {
        if (this.hLb != null && this.hLb.bTz()) {
            return this.hLb.getPageData() == null || this.hLb.getPageData().ahz() != 0;
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

    public int bSi() {
        if (bRV() == null || bRV().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRV().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).xl == com.baidu.tieba.pb.data.i.hIR) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSj() {
        if (bRV() == null || bRV().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRV().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.jhw) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bSq();
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
                    PbActivity.this.cje.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hLb.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).akM();
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hLf.bVv();
        this.hLb.or(z);
        if (this.hLd != null) {
            this.hLd.dO(z);
            if (markData != null) {
                this.hLd.a(markData);
            }
        }
        if (this.hLb.afk()) {
            bSo();
        } else {
            this.hLf.m(this.hLb.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wq(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(String str) {
        this.hLc.Bf(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hLb.bTE()) {
                    antiData.setBlock_forum_name(this.hLb.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hLb.getPbData().getForum().getId());
                    antiData.setUser_name(this.hLb.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hLb.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bRV() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aG(i, str)) {
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
            this.hLf.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jkg) ? bVar.jkg : getString(R.string.delete_fail);
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
                aVar.akM();
            } else {
                this.hLf.a(0, bVar.sF, bVar.jkg, z);
            }
            if (bVar.sF) {
                if (bVar.fei == 1) {
                    ArrayList<PostData> bQz = this.hLb.getPbData().bQz();
                    int size = bQz.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bQz.get(i).getId())) {
                            i++;
                        } else {
                            bQz.remove(i);
                            break;
                        }
                    }
                    this.hLb.getPbData().bQx().hH(this.hLb.getPbData().bQx().aiv() - 1);
                    this.hLf.m(this.hLb.getPbData());
                } else if (bVar.fei == 0) {
                    bSk();
                } else if (bVar.fei == 2) {
                    ArrayList<PostData> bQz2 = this.hLb.getPbData().bQz();
                    int size2 = bQz2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bQz2.get(i2).cok().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bQz2.get(i2).cok().get(i3).getId())) {
                                i3++;
                            } else {
                                bQz2.get(i2).cok().remove(i3);
                                bQz2.get(i2).com();
                                z2 = true;
                                break;
                            }
                        }
                        bQz2.get(i2).DO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hLf.m(this.hLb.getPbData());
                    }
                    a(bVar, this.hLf);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hLf.a(this.eNb.getLoadDataMode(), gVar.sF, gVar.jkg, false);
            if (gVar.sF) {
                this.hLh = true;
                if (i == 2 || i == 3) {
                    this.hLi = true;
                    this.hLj = false;
                } else if (i == 4 || i == 5) {
                    this.hLi = false;
                    this.hLj = true;
                }
                if (i == 2) {
                    this.hLb.getPbData().bQx().hK(1);
                    this.hLb.setIsGood(1);
                } else if (i == 3) {
                    this.hLb.getPbData().bQx().hK(0);
                    this.hLb.setIsGood(0);
                } else if (i == 4) {
                    this.hLb.getPbData().bQx().hJ(1);
                    this.hLb.pa(1);
                } else if (i == 5) {
                    this.hLb.getPbData().bQx().hJ(0);
                    this.hLb.pa(0);
                }
                this.hLf.d(this.hLb.getPbData(), this.hLb.bTz());
            }
        }
    }

    private void bSk() {
        if (this.hLb.bTA() || this.hLb.bTC()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hLb.bTy());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, this.hLb.bTy()));
        if (bSp()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSl() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bQG;
        boolean z = false;
        if (this.hLf != null) {
            this.hLf.bVL();
        }
        if (this.hLb != null && this.hLb.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hLb.getPbData().bQx().getId();
            if (this.hLb.isShareThread() && this.hLb.getPbData().bQx().cdl != null) {
                historyMessage.threadName = this.hLb.getPbData().bQx().cdl.showText;
            } else {
                historyMessage.threadName = this.hLb.getPbData().bQx().getTitle();
            }
            if (this.hLb.isShareThread() && !bRt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hLb.getPbData().getForum().getName();
            }
            ArrayList<PostData> bQz = this.hLb.getPbData().bQz();
            int bVx = this.hLf != null ? this.hLf.bVx() : 0;
            if (bQz != null && bVx >= 0 && bVx < bQz.size()) {
                historyMessage.postID = bQz.get(bVx).getId();
            }
            historyMessage.isHostOnly = this.hLb.getHostMode();
            historyMessage.isSquence = this.hLb.bTz();
            historyMessage.isShareThread = this.hLb.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hLu != null) {
            this.hLu.onDestroy();
        }
        if (this.hKI && bRV() != null) {
            bRV().bWe();
        }
        if (this.hLb != null && (this.hLb.bTA() || this.hLb.bTC())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hLb.bTy());
            if (this.hLh) {
                if (this.hLj) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hLb.bdN());
                }
                if (this.hLi) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hLb.getIsGood());
                }
            }
            if (this.hLb.getPbData() != null && System.currentTimeMillis() - this.hKL >= 40000 && (bQG = this.hLb.getPbData().bQG()) != null && !com.baidu.tbadk.core.util.v.isEmpty(bQG.getDataList())) {
                intent.putExtra("guess_like_data", bQG);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hLI);
            }
            setResult(-1, intent);
        }
        if (bSp()) {
            if (this.hLb != null && this.hLf != null && this.hLf.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bQD() && !this.hKR && pbData.hIx == null) {
                        aj bUI = aj.bUI();
                        com.baidu.tieba.pb.data.d bTG = this.hLb.bTG();
                        Parcelable onSaveInstanceState = this.hLf.getListView().onSaveInstanceState();
                        boolean bTz = this.hLb.bTz();
                        boolean hostMode = this.hLb.getHostMode();
                        if (this.hLf.bVg() != null && this.hLf.bVg().getVisibility() == 0) {
                            z = true;
                        }
                        bUI.a(bTG, onSaveInstanceState, bTz, hostMode, z);
                        if (this.hLH >= 0 || this.hLb.bUj() != null) {
                            aj.bUI().l(this.hLb.bUj());
                            aj.bUI().k(this.hLb.bUk());
                            aj.bUI().wM(this.hLb.bUl());
                        }
                    }
                }
            } else {
                aj.bUI().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hLf == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hLf.wR(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wt(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hLf.bUV();
            this.hLf.bUX().bTl();
            this.hLf.oL(false);
        }
        this.hLf.bUY();
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
                        this.hLu.resetData();
                        this.hLu.b(writeData);
                        this.hLu.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k jK = this.hLu.atX().jK(6);
                        if (jK != null && jK.cEn != null) {
                            jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hLu.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hLf.bUX() != null && this.hLf.bUX().bTp() != null) {
                            com.baidu.tbadk.editortools.pb.g bTp = this.hLf.bUX().bTp();
                            bTp.b(writeData);
                            bTp.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k jK2 = bTp.atX().jK(6);
                            if (jK2 != null && jK2.cEn != null) {
                                jK2.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bTp.auP();
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
        this.hLu.onActivityResult(i, i2, intent);
        if (this.hKV != null) {
            this.hKV.onActivityResult(i, i2, intent);
        }
        if (bRV().bUX() != null) {
            bRV().bUX().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    bSn();
                    return;
                case RequestResponseCode.REQUEST_WRITE_ADDITION /* 13008 */:
                    aj.bUI().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hLb != null) {
                                PbActivity.this.hLb.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.n.a.cfn().y(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                    if (intent != null && this.hLb != null) {
                        a(bSm(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aq(intent);
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cfn().y(getPageContext());
                        bSe();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fKT != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fKT.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void arw() {
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
                    this.hLf.nY(false);
                    if (this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().aiY() != null) {
                        this.hLb.getPbData().bQx().aiY().setStatus(2);
                        break;
                    }
                    break;
                case RequestResponseCode.REQUEST_SELECT_LIKE_FORUM /* 25012 */:
                    break;
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hLx = emotionImageData;
                        if (ws(com.baidu.tbadk.core.util.aj.cjb)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.FANS_CALL_JUMP_BACK /* 25028 */:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hLf != null && this.hLf.hUe != null) {
                        this.hLf.hUe.ZD();
                        this.hLf.hUe.bWG();
                        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null) {
                            this.hLb.getPbData().bQx().hE(1);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                    if (this.hKW != null) {
                        this.hLf.cB(this.hKW);
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
            if (this.hKV == null) {
                this.hKV = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hKV.b(this.cGh);
                this.hKV.c(this.cGo);
            }
            this.hKV.a(emotionImageData, bRD(), bRD().getPbData());
        }
    }

    private ShareFromPBMsgData bSm() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] dP = this.hLb.getPbData().dP(getPageContext().getPageActivity());
        PostData bVb = this.hLf.bVb();
        String str = "";
        if (bVb != null) {
            str = bVb.getId();
            String ed = bVb.ed(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(ed)) {
                dP[1] = ed;
            }
        }
        String aiU = this.hLb.getPbData().bQx().aiU();
        if (aiU != null && aiU.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(dP[1]);
        shareFromPBMsgData.setImageUrl(dP[0]);
        shareFromPBMsgData.setForumName(this.hLb.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hLb.getPbData().bQx().getId());
        shareFromPBMsgData.setTitle(this.hLb.getPbData().bQx().getTitle());
        return shareFromPBMsgData;
    }

    private void aq(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bSm(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hW(1);
            aVar.aM(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null) {
                        com.baidu.tbadk.core.util.an bS = new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).O("obj_source", 1).O("obj_param1", 3).bS("fid", PbActivity.this.hLb.getForumId()).bS("tid", PbActivity.this.hLb.bTy());
                        if (PbActivity.this.d(PbActivity.this.hLb.getPbData()) != 0) {
                            bS.O("obj_type", PbActivity.this.d(PbActivity.this.hLb.getPbData()));
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
            aVar.b(getPageContext()).akM();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hLb.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hW(1);
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
            aVar.b(getPageContext()).akM();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hLb.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSn() {
        MarkData wJ;
        if (this.hLd != null && (wJ = this.hLb.wJ(this.hLf.bVy())) != null) {
            if (!wJ.isApp() || (wJ = this.hLb.wJ(this.hLf.bVy() + 1)) != null) {
                this.hLf.bVt();
                this.hLd.a(wJ);
                if (!this.hLd.afk()) {
                    this.hLd.afm();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hLd.afl();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSo() {
        com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
        this.hLb.or(true);
        if (this.hLd != null) {
            pbData.AC(this.hLd.afj());
        }
        this.hLf.m(pbData);
    }

    private boolean bSp() {
        if (this.hLb == null) {
            return true;
        }
        if (this.hLb.afk()) {
            final MarkData bTQ = this.hLb.bTQ();
            if (bTQ == null || !this.hLb.getIsFromMark()) {
                return true;
            }
            final MarkData wJ = this.hLb.wJ(this.hLf.bVx());
            if (wJ == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bTQ);
                setResult(-1, intent);
                return true;
            } else if (wJ.getPostId() == null || wJ.getPostId().equals(bTQ.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bTQ);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nn(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hLd != null) {
                            if (PbActivity.this.hLd.afk()) {
                                PbActivity.this.hLd.afl();
                                PbActivity.this.hLd.dO(false);
                            }
                            PbActivity.this.hLd.a(wJ);
                            PbActivity.this.hLd.dO(true);
                            PbActivity.this.hLd.afm();
                        }
                        bTQ.setPostId(wJ.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bSl();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTQ);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bSl();
                    }
                });
                aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hLf != null && PbActivity.this.hLf.getView() != null) {
                            PbActivity.this.hLf.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bTQ);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bSl();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.akM();
                return false;
            }
        } else if (this.hLb.getPbData() == null || this.hLb.getPbData().bQz() == null || this.hLb.getPbData().bQz().size() <= 0 || !this.hLb.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hLf == null) {
            return null;
        }
        return this.hLf.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int azN() {
        if (this.hLf == null) {
            return 0;
        }
        return this.hLf.bVJ();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> azO() {
        if (this.cTE == null) {
            this.cTE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSL */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.ago().isShowImages();
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
                        if (com.baidu.tbadk.core.i.ago().isShowImages()) {
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
        return this.cTE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> azP() {
        if (this.cWl == null) {
            this.cWl = TbRichTextView.q(getPageContext().getPageActivity(), 8);
        }
        return this.cWl;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> azQ() {
        if (this.cTF == null) {
            this.cTF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSM */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.ago().isShowImages();
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
                    if (com.baidu.tbadk.core.i.ago().isShowImages()) {
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
                    gifView.avp();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cTF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> azR() {
        if (this.cWm == null) {
            this.cWm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSN */
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
                    ((PlayVoiceBntNew) view).cpA();
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
        return this.cWm;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> azT() {
        this.cWo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bSO */
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
        return this.cWo;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aoe() {
        if (this.crq == null) {
            this.crq = UserIconBox.o(getPageContext().getPageActivity(), 8);
        }
        return this.crq;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ai(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hKP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.AX(str) && this.hLb != null && this.hLb.bTy() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11664").O("obj_param1", 1).bS("post_id", this.hLb.bTy()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cDn = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
            }
        } else {
            av.bWp().c(getPageContext(), str);
        }
        this.hKP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aj(Context context, String str) {
        av.bWp().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hKP = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void al(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ak(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Rect rect) {
        if (rect != null && this.hLf != null && this.hLf.bVZ() != null && rect.top <= this.hLf.bVZ().getHeight()) {
            rect.top += this.hLf.bVZ().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
            TbRichText bb = bb(str, i);
            if (bb != null && (tbRichTextData = bb.azf().get(this.hMo)) != null) {
                cVar.hNb = new ArrayList<>();
                cVar.hNc = new ConcurrentHashMap<>();
                if (!tbRichTextData.azn().azz()) {
                    cVar.hNe = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hNb.add(b2);
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
                    imageUrlData.mIsReserver = this.hLb.bTO();
                    imageUrlData.mIsSeeHost = this.hLb.getHostMode();
                    cVar.hNc.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bQx() != null) {
                            cVar.threadId = pbData.bQx().getId();
                        }
                        cVar.hNd = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(cVar.threadId, -1L);
                    return;
                }
                cVar.hNe = true;
                int size = pbData.bQz().size();
                this.hMp = false;
                cVar.index = -1;
                if (pbData.bQE() != null) {
                    PostData bQE = pbData.bQE();
                    TbRichText cop = bQE.cop();
                    if (!ap.m(bQE)) {
                        i2 = a(cop, bb, i, i, cVar.hNb, cVar.hNc);
                    } else {
                        i2 = a(bQE, i, cVar.hNb, cVar.hNc);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bQz().get(i4);
                    if (postData.getId() == null || pbData.bQE() == null || pbData.bQE().getId() == null || !postData.getId().equals(pbData.bQE().getId())) {
                        TbRichText cop2 = postData.cop();
                        if (!ap.m(postData)) {
                            i3 = a(cop2, bb, i3, i, cVar.hNb, cVar.hNc);
                        } else {
                            i3 = a(postData, i3, cVar.hNb, cVar.hNc);
                        }
                    }
                }
                if (cVar.hNb.size() > 0) {
                    cVar.lastId = cVar.hNb.get(cVar.hNb.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bQx() != null) {
                        cVar.threadId = pbData.bQx().getId();
                    }
                    cVar.hNd = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azn() == null) {
            return null;
        }
        return tbRichTextData.azn().azE();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azn() == null) {
            return 0L;
        }
        return tbRichTextData.azn().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azn() == null) {
            return false;
        }
        return tbRichTextData.azn().azF();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.azn() == null) {
            return false;
        }
        return tbRichTextData.azn().azG();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo azn;
        String str;
        if (tbRichText == tbRichText2) {
            this.hMp = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.azf().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.azf().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.azn().getWidth() * equipmentDensity;
                    int height = equipmentDensity * tbRichTextData.azn().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.azn().azz()) {
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
                            if (tbRichTextData != null && (azn = tbRichTextData.azn()) != null) {
                                String azB = azn.azB();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = azn.azC();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = azB;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), -1L);
                                imageUrlData.mIsReserver = this.hLb.bTO();
                                imageUrlData.mIsSeeHost = this.hLb.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hMp) {
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
        com.baidu.tieba.tbadkCore.data.i cow;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cnS;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cnS = (cow = postData.cow()).cnS()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cnS.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cnS.get(i3);
                if (kVar != null) {
                    String cnW = kVar.cnW();
                    if (!com.baidu.tbadk.core.util.aq.isEmpty(cnW)) {
                        arrayList.add(cnW);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cnW;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cnV();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.toLong(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), -1L);
                        imageUrlData.mIsReserver = this.hLb.bTO();
                        imageUrlData.mIsSeeHost = this.hLb.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cow.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cnW, imageUrlData);
                        }
                        if (!this.hMp) {
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
            if (postData.getId() != null && postData.getId().equals(this.hLb.aiN())) {
                z = true;
            }
            MarkData j = this.hLb.j(postData);
            if (j != null) {
                this.hLf.bVt();
                if (this.hLd != null) {
                    this.hLd.a(j);
                    if (!z) {
                        this.hLd.afm();
                    } else {
                        this.hLd.afl();
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
        if (this.hLb == null || this.hLb.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
        if (pbData.bQE() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bQE());
            tbRichText = b(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bQz = pbData.bQz();
            a(pbData, bQz);
            return b(bQz, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bQI() != null && dVar.bQI().hJg != null && (list = dVar.bQI().hJg) != null && arrayList != null) {
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
        ArrayList<PostData> bQz;
        com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
        if (pbData != null && (bQz = pbData.bQz()) != null && !bQz.isEmpty()) {
            Iterator<PostData> it = bQz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cow = next.cow();
                if (cow != null && cow.jhd) {
                    Iterator<TbRichTextData> it2 = next.cop().azf().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.azw().getLink().equals(str)) {
                            return cow.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText b(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> azf;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cop = arrayList.get(i2).cop();
            if (cop != null && (azf = cop.azf()) != null) {
                int size = azf.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (azf.get(i4) != null && azf.get(i4).getType() == 8) {
                        i3++;
                        if (azf.get(i4).azn().azB().equals(str) || azf.get(i4).azn().azC().equals(str)) {
                            int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = azf.get(i4).azn().getWidth() * equipmentDensity;
                            int height = azf.get(i4).azn().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hMo = i4;
                            return cop;
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
            this.hKA = str;
            if (this.hKK == null) {
                bRZ();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hKK.getItemView(1).setVisibility(8);
            } else {
                this.hKK.getItemView(1).setVisibility(0);
            }
            this.hKK.akN();
            this.hKP = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.fuw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSq() {
        hideNetRefreshView(this.hLf.getView());
        bSr();
        if (this.hLb.loadData()) {
            this.hLf.bVt();
        }
    }

    private void bSr() {
        showLoadingView(this.hLf.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View attachedView = getLoadingView().getAttachedView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
        layoutParams.addRule(3, this.hLf.bVZ().getId());
        attachedView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bki() {
        if (this.fuw != null) {
            this.fuw.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(int i) {
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
    public void wv(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bh bQx;
        if (this.hLb.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hLb.getPbData();
            pbData.getForum().getName();
            String title = pbData.bQx().getTitle();
            int i2 = this.hLb.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Dl(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hLb.bTy() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] dP = pbData.dP(getPageContext().getPageActivity());
                    str = dP[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = dP[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bSd() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10399").bS("fid", pbData.getForumId()).bS("tid", pbData.getThreadId()).bS("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.cxD = true;
                    eVar.cxK = z;
                    eVar.extData = this.hLb.bTy();
                    eVar.cxW = 3;
                    eVar.cxV = i;
                    eVar.fid = this.hLb.getForumId();
                    eVar.tid = this.hLb.bTy();
                    eVar.cya = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bQx = this.hLb.getPbData().bQx();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bQx);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bQx != null) {
                        eVar.cyk = bQx.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.cxW);
                    bundle.putInt("obj_type", eVar.cya);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQV() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hLf.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.bch().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hLb.bTy() + "?share=9105&fr=share&see_lz=" + i2;
            String[] dP2 = pbData.dP(getPageContext().getPageActivity());
            str = dP2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = dP2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bSd() == 1) {
            }
            if (com.baidu.tbadk.core.util.aq.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cxD = true;
            eVar2.cxK = z;
            eVar2.extData = this.hLb.bTy();
            eVar2.cxW = 3;
            eVar2.cxV = i;
            eVar2.fid = this.hLb.getForumId();
            eVar2.tid = this.hLb.bTy();
            eVar2.cya = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bQx = this.hLb.getPbData().bQx();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bQx);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bQx != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cxW);
            bundle2.putInt("obj_type", eVar2.cya);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hLb != null && PbActivity.this.hLb.getPbData() != null && PbActivity.this.hLb.getPbData().bQV() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hLf.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.bch().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQx() != null) {
            if (dVar.bQx().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bQx().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSs() {
        com.baidu.tbadk.util.z.a(new com.baidu.tbadk.util.y<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Dm(PbActivity.this.hLb.getForumId()));
            }
        }, new com.baidu.tbadk.util.j<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hLf.bWf();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> azS() {
        if (this.cWn == null) {
            this.cWn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSP */
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
        return this.cWn;
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

    public void bkj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData biX() {
        if (this.hLb == null || this.hLb.getPbData() == null) {
            return null;
        }
        return this.hLb.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
        } else if (aVar.getYesButtonTag() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
            int intValue = ((Integer) sparseArray.get(aq.hVX)).intValue();
            if (intValue == aq.hVY) {
                if (!this.eNb.cpc()) {
                    this.hLf.bVq();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eNb.DU(com.baidu.tbadk.core.util.aq.G(jSONArray));
                    }
                    this.eNb.a(this.hLb.getPbData().getForum().getId(), this.hLb.getPbData().getForum().getName(), this.hLb.getPbData().bQx().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                }
            } else if (intValue == aq.hVZ || intValue == aq.hWb) {
                if (this.hLb.bUa() != null) {
                    this.hLb.bUa().wy(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hVZ) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hLC);
        userMuteAddAndDelCustomMessage.setTag(this.hLC);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean AJ(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("bubble_link", "");
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
        this.hLo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bSt() {
        ArrayList<PostData> bQz;
        int count;
        if (this.hLb == null || this.hLb.getPbData() == null || this.hLb.getPbData().bQz() == null || (count = com.baidu.tbadk.core.util.v.getCount((bQz = this.hLb.getPbData().bQz()))) == 0) {
            return "";
        }
        if (this.hLb.bTO()) {
            Iterator<PostData> it = bQz.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.con() == 1) {
                    return next.getId();
                }
            }
        }
        int bVx = this.hLf.bVx();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.getItem(bQz, bVx);
        if (postData == null || postData.aiE() == null) {
            return "";
        }
        if (this.hLb.AN(postData.aiE().getUserId())) {
            return postData.getId();
        }
        for (int i = bVx - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.getItem(bQz, i);
            if (postData2 == null || postData2.aiE() == null || postData2.aiE().getUserId() == null) {
                break;
            } else if (this.hLb.AN(postData2.aiE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bVx + 1; i2 < count; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.getItem(bQz, i2);
            if (postData3 == null || postData3.aiE() == null || postData3.aiE().getUserId() == null) {
                return "";
            }
            if (this.hLb.AN(postData3.aiE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.amO().b(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(AI(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hLb.getPbData().getForum().getId(), this.hLb.getPbData().getForum().getName(), this.hLb.getPbData().bQx().getTid());
            }
            this.hKP = true;
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
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hLb.bTZ() != null) {
                    PbActivity.this.hLb.bTZ().dI(j);
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
        aVar.akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c AK(String str) {
        String str2;
        if (this.hLb.getPbData() == null || this.hLb.getPbData().bQz() == null || this.hLb.getPbData().bQz().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hLb.getPbData().bQz().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hLb.getPbData().bQz().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hLb.getPbData().bQz().get(i);
        if (postData.cop() == null || postData.cop().azf() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cop().azf().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.azn() != null) {
                    str2 = next.azn().azB();
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
        if (this.hKH) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hKH = false;
        } else if (bSu()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hKH) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hKH = false;
        } else if (bSu()) {
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
            if (this.hLb != null) {
                if (this.hLb.getPbData() != null) {
                    pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.hLb.getPbData().getForumId(), 0L));
                }
                pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), 0L));
            }
            if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().ctT);
            }
        }
        return pageStayDurationItem;
    }

    public boolean bSu() {
        return (!this.hKF && this.hMw == -1 && this.hMx == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hMz = oVar;
            this.hKF = true;
            this.hLf.bVh();
            this.hLf.AV(this.hMy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSv() {
        if (this.hMz != null) {
            if (this.hMw == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hMz.getCartoonId(), this.hMw, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSw() {
        if (this.hMz != null) {
            if (this.hMx == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hMz.getCartoonId(), this.hMx, 0)));
                finish();
            }
        }
    }

    public int bSx() {
        return this.hMw;
    }

    public int bSy() {
        return this.hMx;
    }

    private void bvS() {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().ajy()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
        }
    }

    private void bSz() {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().ajy()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESTART_VIDEO));
        }
    }

    public void bSA() {
        if (this.aqk) {
            this.hKU = true;
        } else if (MessageManager.getInstance().findTask(1003200) != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().aik() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hLb.getPbData().bQx().aik().getThreadId(), this.hLb.getPbData().bQx().aik().getTaskId(), this.hLb.getPbData().bQx().aik().getForumId(), this.hLb.getPbData().bQx().aik().getForumName(), this.hLb.getPbData().bQx().aiz(), this.hLb.getPbData().bQx().aiA())));
            this.hKH = true;
            finish();
        }
    }

    public String bSB() {
        return this.hKS;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bSC() {
        return this.hLa;
    }

    public void oe(boolean z) {
        this.hKT = z;
    }

    public boolean bSD() {
        if (this.hLb != null) {
            return this.hLb.bTA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nn(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hLA).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hLA.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hLA).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hLA != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLA.getPageActivity());
            aVar.nn(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hLA).akM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hLf.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLA.getPageActivity());
        if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            aVar.nn(this.hLA.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.nn(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hLf.showLoadingDialog();
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
        aVar.b(this.hLA).akM();
    }

    public void bSF() {
        if (this.hLb != null && this.hLb.getPbData() != null && this.hLb.getPbData().bQx() != null && this.hLb.getPbData().bQx().ajN() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.hT(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CHANNEL_SEND_REQUEST, a.b.a(PbActivity.this.hLb.getPbData().bQx().ajN().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.akM();
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
        if (configuration.orientation != this.fUq) {
            this.fUq = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hLf != null) {
                this.hLf.onConfigurationChanged(configuration);
            }
            if (this.hLl != null) {
                this.hLl.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bSG() {
        if (this.hLb != null) {
            return this.hLb.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hLb.getPbData().bQI().hJg;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cok().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cok().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cok().remove(i2);
                    list.get(i).com();
                    z = true;
                    break;
                }
            }
            list.get(i).DO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hLb.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bRg().getId();
        List<PostData> list = this.hLb.getPbData().bQI().hJg;
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
                ArrayList<PostData> bRk = kVar.bRk();
                postData.zP(kVar.getTotalCount());
                if (postData.cok() != null) {
                    postData.cok().clear();
                    postData.cok().addAll(bRk);
                }
            }
        }
        if (!this.hLb.getIsFromMark()) {
            this.hLf.m(this.hLb.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bRs() {
        return this.hLg;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bRt() {
        if (this.hLb == null) {
            return false;
        }
        return this.hLb.bRt();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bRu() {
        if (this.hLb != null) {
            return this.hLb.bRu();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bRv() {
        if (this.hLb == null || this.hLb.getPbData() == null) {
            return 0;
        }
        return this.hLb.getPbData().bQJ();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AE(String str) {
        return this.hLb != null && this.hLb.AN(str);
    }

    public void bSH() {
        if (this.hLf != null) {
            this.hLf.bUV();
            bkj();
        }
    }

    public PostData bQE() {
        return this.hLf.c(this.hLb.hQG, this.hLb.bTz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int au(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.isLinkThread()) {
                return 3;
            }
            if (bhVar.ajP()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hLJ != null && !this.hLJ.isEmpty()) {
            int size = this.hLJ.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hLJ.get(i).onBackPressed()) {
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
            if (this.hLJ == null) {
                this.hLJ = new ArrayList();
            }
            if (!this.hLJ.contains(aVar)) {
                this.hLJ.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hLJ == null) {
                this.hLJ = new ArrayList();
            }
            if (!this.hLJ.contains(aVar)) {
                this.hLJ.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hLJ != null) {
            this.hLJ.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSI() {
        if (this.hLb != null && !com.baidu.tbadk.core.util.aq.isEmpty(this.hLb.bTy())) {
            com.baidu.tbadk.BdToken.c.adX().i(com.baidu.tbadk.BdToken.b.bQa, com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hLb == null || com.baidu.tbadk.core.util.aq.isEmpty(this.hLb.bTy())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.toLong(this.hLb.bTy(), 0L);
    }

    public com.baidu.tbadk.core.data.av bSJ() {
        return this.hKZ;
    }
}
