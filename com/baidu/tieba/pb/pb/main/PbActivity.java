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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.tencent.connect.common.Constants;
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
    private com.baidu.adp.lib.e.b<ImageView> cID;
    private com.baidu.adp.lib.e.b<GifView> cIE;
    private com.baidu.adp.lib.e.b<TextView> cLs;
    private com.baidu.adp.lib.e.b<View> cLt;
    private com.baidu.adp.lib.e.b<LinearLayout> cLu;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLv;
    private com.baidu.adp.lib.e.b<TbImageView> cbP;
    private com.baidu.tieba.f.b dWj;
    private au fQC;
    private VoiceManager foP;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    public com.baidu.tbadk.core.util.aj gPM;
    private String hDJ;
    private com.baidu.tieba.pb.pb.main.b.b hDP;
    private com.baidu.tieba.tbadkCore.data.f hEB;
    private com.baidu.tbadk.editortools.pb.f hEC;
    private com.baidu.tbadk.editortools.pb.d hED;
    private com.baidu.tieba.frs.profession.permission.c hEF;
    private EmotionImageData hEG;
    private com.baidu.adp.base.e hEJ;
    private com.baidu.tbadk.core.view.e hEK;
    private BdUniqueId hEL;
    private Runnable hEM;
    private com.baidu.adp.widget.ImageView.a hEN;
    private String hEO;
    private TbRichTextMemeInfo hEP;
    private List<a> hES;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hEf;
    private View hEg;
    int hEi;
    private com.baidu.tieba.pb.pb.report.a hEl;
    public as hEt;
    private com.baidu.tbadk.core.dialog.i hEu;
    private com.baidu.tbadk.core.dialog.k hEv;
    private boolean hEx;
    private String hFG;
    private com.baidu.tbadk.core.data.o hFH;
    private boolean hFv;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTc));
        }
    };
    private static final b.a hFB = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void iY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bQF();
            } else {
                com.baidu.tieba.pb.a.b.bQE();
            }
        }
    };
    private boolean hDO = false;
    private boolean hDQ = false;
    private boolean hDR = false;
    private boolean hhm = false;
    private boolean hDS = true;
    private int hDT = 0;
    private com.baidu.tbadk.core.dialog.b hDU = null;
    private long eSm = -1;
    private long cyE = 0;
    private long hDV = 0;
    private long createTime = 0;
    private long cyw = 0;
    private boolean hDW = false;
    private com.baidu.tbadk.p.b hDX = null;
    private long hDY = 0;
    private boolean hDZ = false;
    private long hEa = 0;
    private int fOh = 1;
    private String cst = null;
    private boolean hEb = false;
    private boolean isFullScreen = false;
    private String hEc = "";
    private boolean hEd = true;
    private boolean hEe = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hEh = new int[2];
    private PbInterviewStatusView.a hEj = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hEo.oC(!PbActivity.this.hEd);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hEk != null && PbActivity.this.hEk.ZC()) {
                        PbActivity.this.bRA();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hEk = null;
    private com.baidu.tbadk.baseEditMark.a hEm = null;
    private ForumManageModel eyy = null;
    private com.baidu.tbadk.coreExtra.model.a bSl = null;
    private com.baidu.tieba.pb.data.l hEn = null;
    private ShareSuccessReplyToServerModel fEP = null;
    private aq hEo = null;
    public final com.baidu.tieba.pb.pb.main.b.a hEp = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hEq = false;
    private boolean hEr = false;
    private boolean hEs = false;
    private boolean hEw = false;
    private boolean hEy = false;
    private boolean hEz = false;
    private boolean hEA = false;
    private boolean hEE = false;
    public boolean hEH = false;
    private com.baidu.tbadk.editortools.pb.c csw = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEt == null || PbActivity.this.hEt.bVs() == null || !PbActivity.this.hEt.bVs().cwg()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSg);
            }
            PbActivity.this.showToast(PbActivity.this.hEt.bVs().cwi());
            if (PbActivity.this.hED != null && (PbActivity.this.hED.arF() || PbActivity.this.hED.arG())) {
                PbActivity.this.hED.a(false, PbActivity.this.hEt.bVv());
            }
            PbActivity.this.hEt.oO(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hEI = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEt == null || PbActivity.this.hEt.bVt() == null || !PbActivity.this.hEt.bVt().cwg()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSh);
            }
            PbActivity.this.showToast(PbActivity.this.hEt.bVt().cwi());
            if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUf() != null && PbActivity.this.hEo.bUf().bSz() != null && PbActivity.this.hEo.bUf().bSz().arG()) {
                PbActivity.this.hEo.bUf().bSz().a(PbActivity.this.hEt.bVv());
            }
            PbActivity.this.hEt.oP(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fpF = false;
    private int hEQ = 0;
    private int hER = -1;
    private final a hET = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUf() != null) {
                s bUf = PbActivity.this.hEo.bUf();
                if (bUf.bSx()) {
                    bUf.bSw();
                    return true;
                }
            }
            if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUZ()) {
                PbActivity.this.hEo.bVa();
                return true;
            }
            return false;
        }
    };
    private r.a hEU = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fpR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bRE();
        }
    };
    private final z.a hEV = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hEo.showToast(str);
            }
        }
    };
    private final CustomMessageListener hEW = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEk != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hED != null) {
                    PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                }
                PbActivity.this.hEo.bUg();
                PbActivity.this.hEo.bUS();
            }
        }
    };
    CustomMessageListener fql = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hEk.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hEo != null && PbActivity.this.hEk != null) {
                    PbActivity.this.hEo.d(PbActivity.this.hEk.getPbData(), PbActivity.this.hEk.bSJ(), PbActivity.this.hEk.getRequestType());
                }
                if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUx() != null) {
                    PbActivity.this.hEo.bUx().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hEX = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hEo != null) {
                    if (booleanValue) {
                        PbActivity.this.hEo.bCa();
                    } else {
                        PbActivity.this.hEo.bBZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hED != null) {
                    PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                }
                PbActivity.this.hEo.oJ(false);
            }
        }
    };
    private CustomMessageListener hEZ = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hFa = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUx() != null) {
                PbActivity.this.hEo.bUx().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gtK = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(PbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final CustomMessageListener fqi = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!PbActivity.this.hDR) {
                PbActivity.this.bRU();
            }
        }
    };
    private h.a hFb = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xh(2);
                aj.bTR().reset();
                PbActivity.this.hEk.bTe();
                boolean z2 = false;
                ArrayList<PostData> bPN = PbActivity.this.hEk.getPbData().bPN();
                if (bPN != null) {
                    Iterator<PostData> it = bPN.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cmF().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hEo.m(PbActivity.this.hEk.getPbData());
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
    private View.OnClickListener cth = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.cst);
        }
    };
    private CustomMessageListener hFc = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hEk.bSV() != null && PbActivity.this.hEk.bSV().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hEo.a(aaVar.sendCount, PbActivity.this.hEk.getPbData(), PbActivity.this.hEk.bSJ(), PbActivity.this.hEk.getRequestType());
                    }
                    if (pbData.bPN() != null && pbData.bPN().size() >= 1 && pbData.bPN().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bPN().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.hEk.bSI(), 0L);
                        if (c2 == aaVar.postId && c3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cmE = pbData.bPN().get(0).cmE();
                            if (cmE == null) {
                                cmE = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> acr = cmE.acr();
                            if (acr == null) {
                                acr = new ArrayList<>();
                            }
                            acr.add(0, aVar);
                            cmE.setTotal(aaVar.sendCount + cmE.getTotal());
                            cmE.p(acr);
                            pbData.bPN().get(0).a(cmE);
                            PbActivity.this.hEo.bUx().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fHQ = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                PbActivity.this.AY((String) customResponsedMessage.getData());
                PbActivity.this.hEk.bTb();
                if (PbActivity.this.hEo.bUx() != null) {
                    PbActivity.this.hEo.m(PbActivity.this.hEk.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hFd = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bVC()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hFe = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hEo != null) {
                PbActivity.this.hEo.dI(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hFf = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cE(PbActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                com.baidu.adp.lib.f.c.iv().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbActivity.this.getUniqueId());
            } else {
                PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }
    };
    private boolean hFg = false;
    private PraiseModel hFh = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void sm(String str) {
            PbActivity.this.hFg = false;
            if (PbActivity.this.hFh != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                if (pbData.bPL().adh().getIsLike() == 1) {
                    PbActivity.this.sb(0);
                } else {
                    PbActivity.this.sb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bPL()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hFg = false;
            if (PbActivity.this.hFh != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aI(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hFi = 0;
    private boolean hFj = true;
    private b.a hFk = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void od(boolean z) {
            PbActivity.this.oc(z);
            if (PbActivity.this.hEo.bVf() != null && z) {
                PbActivity.this.hEo.oC(false);
            }
            PbActivity.this.hEo.oE(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().cgz != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().cgz, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTc));
                        }
                    } else if (updateAttentionMessage.getData().Hi) {
                        if (PbActivity.this.bPS().adv() != null && PbActivity.this.bPS().adv().getGodUserData() != null) {
                            PbActivity.this.bPS().adv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                            PbActivity.this.hEk.getPbData().bPL().adv().setHadConcerned(updateAttentionMessage.isAttention());
                        }
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a dVA = new CheckRealNameModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.27
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            Integer num;
            PbActivity.this.hEo.aSG();
            if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                if (i == 0) {
                    if (!(obj instanceof Integer)) {
                        num = 0;
                    } else {
                        num = (Integer) obj;
                    }
                    PbActivity.this.xi(num.intValue());
                } else if (i == 1990055) {
                    TiebaStatic.log("c12142");
                    com.baidu.tieba.i.a.bss();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ckg = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bRk();
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            if (view != null) {
                if (view.getId() == R.id.richText) {
                    if (PbActivity.this.cs(view)) {
                        return true;
                    }
                } else if (view.getId() == R.id.pb_floor_item_layout) {
                    if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                        PbActivity.this.d((SparseArray) view.getTag(R.id.tag_from));
                    }
                } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                    if (PbActivity.this.hEo != null && PbActivity.this.hEo.bRi() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hEp != null && PbActivity.this.hEp.fQV != null) {
                            PbActivity.this.hEp.fQV.onClick(view);
                        }
                    }
                } else {
                    SparseArray sparseArray = null;
                    if (view.getTag() instanceof SparseArray) {
                        sparseArray = (SparseArray) view.getTag();
                    }
                    if (sparseArray != null) {
                        PbActivity.this.d(sparseArray);
                    } else {
                        return false;
                    }
                }
            }
            if (PbActivity.this.hED != null) {
                PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
            }
            PbActivity.this.hEo.bUg();
            PbActivity.this.hEo.bUS();
            return true;
        }
    });
    private CustomMessageListener hFl = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEL) {
                PbActivity.this.hEo.aSG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bPY().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEK.i(PbActivity.this.hEJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hEJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qf(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bRQ();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hEJ.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hEK.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFm = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEL) {
                PbActivity.this.hEo.aSG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEK.i(PbActivity.this.hEJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hEJ.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hEK.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFn = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hEo.aSG();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jnc;
                if (aVar.error == 0 && dataRes != null) {
                    int f = com.baidu.adp.lib.g.b.f(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = f == 1;
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
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
                    PbActivity.this.hEo.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hFo = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEo.bUh() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bRk();
            }
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    PbActivity.this.fpF = true;
                }
            }
        }
    };
    public a.b hsw = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bki();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hEk.getPageData();
            int pageNum = PbActivity.this.hEo.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ack()) {
                PbActivity.this.hEo.bUS();
                PbActivity.this.xh(2);
                PbActivity.this.bkh();
                PbActivity.this.hEo.bUB();
                if (com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.hEk.xp(PbActivity.this.hEo.getPageNum());
                    if (PbActivity.this.hDP != null) {
                        PbActivity.this.hDP.showFloatingView();
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
    public final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38
        /* JADX DEBUG: Multi-variable search result rejected for r4v280, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v284, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v311, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r4v424, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:576:0x1c02  */
        /* JADX WARN: Removed duplicated region for block: B:579:0x1c4b  */
        /* JADX WARN: Removed duplicated region for block: B:596:0x1e65  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(final View view) {
            boolean z;
            String str;
            boolean z2;
            com.baidu.tbadk.core.dialog.g gVar;
            boolean nY;
            com.baidu.tbadk.core.dialog.g gVar2;
            com.baidu.tbadk.core.dialog.g gVar3;
            long j;
            String str2;
            int i;
            int i2;
            int i3;
            bl blVar;
            String[] strArr;
            boolean t;
            String name;
            if (view != null) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == PbActivity.this.hEo.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hEk.on(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hEo.bUC();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTM()) {
                        if (view == PbActivity.this.hEo.hNg.cAN) {
                            if (PbActivity.this.hEo.oG(PbActivity.this.hEk.bSO())) {
                                PbActivity.this.bkh();
                                return;
                            }
                            PbActivity.this.hDS = false;
                            PbActivity.this.hDQ = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hEo.hNg.cAN);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hEo.bUz() && (PbActivity.this.hEo.hNg.bVP() == null || (view != PbActivity.this.hEo.hNg.bVP().bTL() && view != PbActivity.this.hEo.hNg.bVP().bTJ()))) {
                            if (view == PbActivity.this.hEo.bUV()) {
                                if (PbActivity.this.hEk != null) {
                                    com.baidu.tbadk.browser.a.af(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEk.getPbData().bPL().adu().getLink());
                                }
                            } else if (view != PbActivity.this.hEo.hNg.hSB) {
                                if (view == PbActivity.this.hEo.hNg.hSC) {
                                    if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                        ArrayList<PostData> bPN = PbActivity.this.hEk.getPbData().bPN();
                                        if ((bPN == null || bPN.size() <= 0) && PbActivity.this.hEk.bSJ()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bT("tid", PbActivity.this.hEk.bSI()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hEk.getForumId()));
                                        if (!PbActivity.this.hEo.bVk()) {
                                            PbActivity.this.hEo.bUg();
                                        }
                                        PbActivity.this.bRs();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.jS()) {
                                        PbActivity.this.hEo.oh(true);
                                        PbActivity.this.hEo.bUg();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hEo.bCa();
                                            PbActivity.this.bkh();
                                            PbActivity.this.hEo.bUB();
                                            PbActivity.this.hEk.Bf(PbActivity.this.bRF());
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xh(2);
                                        } else {
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                    if ((PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTI()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hEo.hNg.bVP() != null && view == PbActivity.this.hEo.hNg.bVP().getCancelView()) {
                                            PbActivity.this.hEo.hNg.TU();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTG()) {
                                                if ((PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTO()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTH()) {
                                                        if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTP()) {
                                                            if (PbActivity.this.hEo.bVf() == view) {
                                                                if (PbActivity.this.hEo.bVf().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                                                                    if (pbData != null && pbData.bPL() != null && pbData.bPL().adb() != null) {
                                                                        String acS = pbData.bPL().adb().acS();
                                                                        if (StringUtils.isNull(acS)) {
                                                                            acS = pbData.bPL().adb().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bT(VideoPlayActivityConfig.OBJ_ID, acS));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.el("c10725", null);
                                                                }
                                                                PbActivity.this.bRM();
                                                            } else if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTN()) {
                                                                if (PbActivity.this.hEo.hNg.bVP() != null && view == PbActivity.this.hEo.hNg.bVP().bTK()) {
                                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hEo.c(PbActivity.this.hEk.getPbData(), PbActivity.this.hEk.bSJ(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hEo.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hEo.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hEo.hNg.TU();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hEk != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bT("tid", PbActivity.this.hEk.bSI());
                                                                        amVar.bT("fid", PbActivity.this.hEk.getForumId());
                                                                        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hEk.getPbData() != null) {
                                                                            PbActivity.this.hEo.bUS();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cmI() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iZy != null) {
                                                                                    com.baidu.tbadk.core.util.am aie = postData.iZy.aie();
                                                                                    aie.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aie.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aie.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aie);
                                                                                }
                                                                                String bSI = PbActivity.this.hEk.bSI();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hEk.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hEk.getPbData().bPX();
                                                                                }
                                                                                PbActivity.this.bkh();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c Bd = PbActivity.this.Bd(id);
                                                                                    if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && Bd != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSI, id, "pb", true, null, true, null, i4, postData.bWH(), PbActivity.this.hEk.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bd.hGj, Bd.hGk, Bd.hGl, Bd.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hEk.bTq());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hEk.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c Bd2 = PbActivity.this.Bd(id);
                                                                                    if (postData != null && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && Bd2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSI, id, "pb", true, null, false, null, i4, postData.bWH(), PbActivity.this.hEk.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bd2.hGj, Bd2.hGk, Bd2.hGl, Bd2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hEk.bTq());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hEk.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData2));
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hEk.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hEk != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bT("tid", PbActivity.this.hEk.bSI());
                                                                        amVar2.bT("fid", PbActivity.this.hEk.getForumId());
                                                                        amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                                                                    String bSI2 = PbActivity.this.hEk.bSI();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hEk.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hEk.getPbData().bPX();
                                                                                    }
                                                                                    c Bd3 = PbActivity.this.Bd(id2);
                                                                                    if (Bd3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSI2, id2, "pb", true, null, false, null, i5, postData2.bWH(), PbActivity.this.hEk.getPbData().getAnti(), false, postData2.adv().getIconInfo()).addBigImageData(Bd3.hGj, Bd3.hGk, Bd3.hGl, Bd3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hEk.bTq());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hEk.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData3));
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
                                                                    if (PbActivity.this.hEk != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bT("tid", PbActivity.this.hEk.bSI());
                                                                        amVar3.bT("fid", PbActivity.this.hEk.getForumId());
                                                                        amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.bRh().bUe() != null && postData3.adv() != null && postData3.cmw() != 1) {
                                                                                    if (PbActivity.this.bRh().bUf() != null) {
                                                                                        PbActivity.this.bRh().bUf().bSv();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hEk.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hEk.getPbData().bPL());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bRh().bUe().d(kVar);
                                                                                    PbActivity.this.bRh().bUe().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.adv().getUserId(), "");
                                                                                    if (PbActivity.this.hED != null) {
                                                                                        PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
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
                                                                } else if (view != PbActivity.this.hEo.bRc()) {
                                                                    if (view == PbActivity.this.hEo.hNg.bVQ()) {
                                                                        PbActivity.this.hEo.bUI();
                                                                    } else {
                                                                        int id3 = view.getId();
                                                                        if (id3 == R.id.pb_u9_text_view) {
                                                                            if (PbActivity.this.checkUpIsLogin() && (blVar = (bl) view.getTag()) != null && !StringUtils.isNull(blVar.afw())) {
                                                                                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{blVar.afw()});
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.replybtn || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right || id3 == R.id.image_more_tip) {
                                                                            if (PbActivity.this.checkUpIsLogin()) {
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11740"));
                                                                                if (view != null && view.getTag() != null) {
                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                                                    if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bT("tid", PbActivity.this.hEk.hJo));
                                                                                    }
                                                                                    if (PbActivity.this.hEv == null) {
                                                                                        PbActivity.this.hEv = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hEv.a(PbActivity.this.hFA);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cu(view);
                                                                                    if (!PbActivity.this.cu(view) || PbActivity.this.hEN == null || !PbActivity.this.hEN.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEv);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cmy() != null && postData4.cmy().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEv);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.ggN = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hEk.getPbData().ZC()) {
                                                                                        String ZB = PbActivity.this.hEk.getPbData().ZB();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ZB) && ZB.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEv);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEv);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.ggN);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEv);
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
                                                                                                    if (!ap.m(PbActivity.this.ggN)) {
                                                                                                        nY = PbActivity.this.nY(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nY = false;
                                                                                                    }
                                                                                                    if (nY) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEv);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEv);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEv);
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
                                                                                                    if (PbActivity.this.hEk.getPbData().bPX() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEv);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEv);
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
                                                                                            PbActivity.this.hEv.W(arrayList);
                                                                                            PbActivity.this.hEu = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEv.afZ());
                                                                                            PbActivity.this.hEu.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.ggN);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hEv.W(arrayList);
                                                                                    PbActivity.this.hEu = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEv.afZ());
                                                                                    PbActivity.this.hEu.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), PbActivity.this.hEk.getPbData().bPL().getActUrl());
                                                                                if (PbActivity.this.hEk.getPbData().bPL().aef() != 1) {
                                                                                    if (PbActivity.this.hEk.getPbData().bPL().aef() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bT("fid", PbActivity.this.hEk.getPbData().getForumId()).bT("tid", PbActivity.this.hEk.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hEk.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hEo.setSelection(0);
                                                                                } else {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PbActivity.this.getActivity()).createNormalCfg(str3, (String) null, (String) null, (String) null)));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_item_tail_content) {
                                                                            if (bc.cE(PbActivity.this.getPageContext().getPageActivity())) {
                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                String string2 = com.baidu.tbadk.core.sharedPref.b.agM().getString("tail_link", "");
                                                                                if (!StringUtils.isNull(string2)) {
                                                                                    TiebaStatic.log("c10056");
                                                                                    com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                }
                                                                                PbActivity.this.hEo.bUg();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bRp() == 1 && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bT("fid", PbActivity.this.hEk.getPbData().getForumId()).bT("tid", PbActivity.this.hEk.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bRp() == 1 && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bT("fid", PbActivity.this.hEk.getPbData().getForumId()).bT("tid", PbActivity.this.hEk.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bRH();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bRI();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bQe() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hEk.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bT("fid", pbData2.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData2.bQe().bQl()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bQe() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hEk.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", pbData3.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData3.bQe().bQl()});
                                                                            }
                                                                        } else if (PbActivity.this.hEo.hNg.bVP() != null && view == PbActivity.this.hEo.hNg.bVP().bTQ()) {
                                                                            if (PbActivity.this.hEk == null || PbActivity.this.hEk.getPbData() == null || PbActivity.this.hEk.getPbData().bPL() == null) {
                                                                                PbActivity.this.hEo.hNg.TU();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.ki()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hEk.getPbData().bPL().adc() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEk.bSI(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).afO();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").P("obj_locate", PbActivity.this.au(PbActivity.this.hEk.getPbData().bPL())).bT("tid", PbActivity.this.hEk.getPbData().bPL().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hEQ >= 0) {
                                                                                if (PbActivity.this.hEk != null) {
                                                                                    PbActivity.this.hEk.bTr();
                                                                                }
                                                                                if (PbActivity.this.hEo.bUx() != null) {
                                                                                    PbActivity.this.hEo.bUx().a(PbActivity.this.hEk.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hEo.getListView().setSelection(PbActivity.this.hEk.bTu());
                                                                                PbActivity.this.hEQ = 0;
                                                                                if (PbActivity.this.hEk != null) {
                                                                                    PbActivity.this.hEk.cb(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bRm();
                                                                        } else if (id3 == R.id.new_sub_pb_list_richText) {
                                                                            SparseArray sparseArray10 = null;
                                                                            if (view.getTag() instanceof SparseArray) {
                                                                                sparseArray10 = (SparseArray) view.getTag();
                                                                            }
                                                                            if (sparseArray10 != null) {
                                                                                PbActivity.this.d(sparseArray10);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_editor_tool_comment_icon) {
                                                                            if (PbActivity.this.hEo.getListView() != null && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hEo.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hEo.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bQj = PbActivity.this.hEk.getPbData().bQj();
                                                                                boolean z8 = PbActivity.this.hEo.hNa != null && PbActivity.this.hEo.hNa.bWX();
                                                                                boolean bUP = PbActivity.this.hEo.bUP();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bQj && PbActivity.this.hEo.hNa != null && PbActivity.this.hEo.hNa.aHS() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hEo.hNa.bWY();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hEo.hNa.aHS().getHeight() - PbActivity.this.hEo.hNa.bWY());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adm() <= 0) || (bUP && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bRm();
                                                                                        if (PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEk.hJo).bT("fid", PbActivity.this.hEk.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEk.getPbData().bPL().adv().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bQj) {
                                                                                        if (PbActivity.this.hEo.hOV != null && PbActivity.this.hEo.hOV.hQf != null && PbActivity.this.hEo.hOV.hQf.getView() != null) {
                                                                                            if (PbActivity.this.hEo.hOV.hQf.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bRv();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hEo.hNa.aHS() != null) {
                                                                                                    i8 = PbActivity.this.hEo.hNa.aHS().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hEo.hOV.hQf.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hEo.bUo() != null) {
                                                                                        z10 = PbActivity.this.hEo.bUo().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hEo.hOV != null && PbActivity.this.hEo.hOV.hQf != null && PbActivity.this.hEo.hOV.hQf.getView() != null && PbActivity.this.hEo.hOV.hQf.getView().getParent() != null && PbActivity.this.hEo.hNg != null && PbActivity.this.hEo.hNg.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hEo.hOV.hQf.getView().getTop() - PbActivity.this.hEo.hNg.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bUP) {
                                                                                        int bRv = PbActivity.this.bRv();
                                                                                        if (PbActivity.this.bRu() != -1) {
                                                                                            bRv--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bRv < 0) {
                                                                                            i2 = PbActivity.this.hEo.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hEo.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bRv;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bQj || PbActivity.this.hEo.hNa.aHS() == null) {
                                                                                            if (PbActivity.this.hEo.hNg != null && PbActivity.this.hEo.hNg.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hEo.hNg.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hEo.hNa.aHS().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hEo.hOV == null || PbActivity.this.hEo.hOV.hQf == null || PbActivity.this.hEo.hOV.hQf.getView() == null || PbActivity.this.hEo.hOV.hQf.getView().getParent() == null) {
                                                                                            PbActivity.this.hEo.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hEo.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hEo.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hEo.getListView().smoothScrollBy(PbActivity.this.hEo.hOV.hQf.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hEo.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hEo.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hEo.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEk.hJo).bT("fid", PbActivity.this.hEk.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEk.getPbData().bPL().adv().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hEk.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hEk.bTq() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hEk.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bT("tid", PbActivity.this.hEk.bSI());
                                                                                amVar4.bT("fid", PbActivity.this.hEk.getForumId());
                                                                                amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hEk.bTq() == 3 && PbActivity.this.bQH() && PbActivity.this.hEk.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hEk.getPbData().bQg())) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    FrsActivityConfig createNormalCfg = new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(bgVar.adA(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                    createNormalCfg.setCallFrom(14);
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar5 = new com.baidu.tbadk.core.util.am("c13399");
                                                                                amVar5.bT("tid", bgVar.getId());
                                                                                amVar5.l("fid", bgVar.getFid());
                                                                                amVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar5);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                            if (PbActivity.this.hEk != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bT("tid", PbActivity.this.hEk.bSI());
                                                                                amVar6.bT("fid", PbActivity.this.hEk.getForumId());
                                                                                amVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hEk.getPbData();
                                                                                if (PbActivity.this.hEn == null) {
                                                                                    PbActivity.this.hEn = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long c3 = com.baidu.adp.lib.g.b.c(pbData4.getThreadId(), 0L);
                                                                                long c4 = com.baidu.adp.lib.g.b.c(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.am("c13446").l("forum_id", c4).aif();
                                                                                PbActivity.this.registerListener(PbActivity.this.hFq);
                                                                                PbActivity.this.hEn.s(c3, c4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_video_thread_smart_app_layout && (view.getTag() instanceof SmartApp)) {
                                                                            SmartApp smartApp = (SmartApp) view.getTag();
                                                                            if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                if (!StringUtils.isNull(smartApp.h5_url)) {
                                                                                    com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), smartApp.h5_url);
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13274").bT("fid", PbActivity.this.hEk.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hEk.bSI()).P("obj_param1", smartApp.is_game.intValue()));
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.hEk.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.hEk.bSI(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hEk.getPbData().bPL().adP())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.jS()) {
                                                                PbActivity.this.hEo.bUS();
                                                                SparseArray<Object> c5 = PbActivity.this.hEo.c(PbActivity.this.hEk.getPbData(), PbActivity.this.hEk.bSJ(), 1);
                                                                if (c5 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEk.getPbData().getForum().getId(), PbActivity.this.hEk.getPbData().getForum().getName(), PbActivity.this.hEk.getPbData().bPL().getId(), String.valueOf(PbActivity.this.hEk.getPbData().getUserData().getUserId()), (String) c5.get(R.id.tag_forbid_user_name), (String) c5.get(R.id.tag_forbid_user_name_show), (String) c5.get(R.id.tag_forbid_user_post_id), (String) c5.get(R.id.tag_forbid_user_portrait))));
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                PbActivity.this.showToast(R.string.network_not_available);
                                                                return;
                                                            }
                                                        } else {
                                                            int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                            UtilHelper.showSkinChangeAnimation(PbActivity.this.getActivity());
                                                            if (skinType == 1) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d));
                                                                TbadkCoreApplication.getInst().setSkinType(0);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").P("obj_type", 0).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            } else if (skinType == 0) {
                                                                PbActivity.this.onChangeSkinType(skinType);
                                                                UtilHelper.setNavigationBarBackground(PbActivity.this.getActivity(), PbActivity.this.getResources().getColor(R.color.cp_bg_line_d_1));
                                                                TbadkCoreApplication.getInst().setSkinType(1);
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10647").P("obj_type", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                                                            }
                                                            PbActivity.this.hEo.hNg.bVO();
                                                        }
                                                    } else if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null) {
                                                        PbActivity.this.hEo.hNg.TU();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.Ba(PbActivity.this.hEk.getPbData().bPL().adL());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hEo.bUS();
                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hEk.bSZ()));
                                                            return;
                                                        }
                                                        PbActivity.this.xh(2);
                                                        PbActivity.this.bkh();
                                                        PbActivity.this.hEo.bUB();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hEk.getPbData().hBE == null || PbActivity.this.hEk.getPbData().hBE.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hEk.getPbData().hBE.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hEk.getPbData().hBE.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hEk.getPbData().hBE.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hEk.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hEk.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hEk.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hEk.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hEk.getPbData().hBE != null && PbActivity.this.hEk.getPbData().hBE.size() > i11) {
                                                                    i11 = PbActivity.this.hEk.getPbData().hBE.get(i11).sort_type.intValue();
                                                                }
                                                                boolean xu = PbActivity.this.hEk.xu(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hEk.bSZ()));
                                                                if (xu) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hEo.oy(true);
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
                                                PbActivity.this.hEo.bUS();
                                                if (PbActivity.this.bQR().getPbData().hBF != 2) {
                                                    if (PbActivity.this.hEk.getPageData() != null) {
                                                        PbActivity.this.hEo.a(PbActivity.this.hEk.getPageData(), PbActivity.this.hsw);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iE() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEk.hJo).bT("fid", PbActivity.this.hEk.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hEk.getPbData().bPL().adv().getUserId()));
                                            }
                                            if (PbActivity.this.hEk != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bT("tid", PbActivity.this.hEk.bSI());
                                                amVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bT("fid", PbActivity.this.hEk.getForumId());
                                                amVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.ki()) {
                                                if (PbActivity.this.hEk.getPbData() != null) {
                                                    ArrayList<PostData> bPN2 = PbActivity.this.hEk.getPbData().bPN();
                                                    if ((bPN2 != null && bPN2.size() > 0) || !PbActivity.this.hEk.bSJ()) {
                                                        PbActivity.this.hEo.bUS();
                                                        PbActivity.this.bkh();
                                                        PbActivity.this.xh(2);
                                                        if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bQe() != null && !StringUtils.isNull(PbActivity.this.hEk.getPbData().bQe().abS(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", PbActivity.this.hEk.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (bf.iE()) {
                                                            PbActivity.this.xi(2);
                                                        } else {
                                                            PbActivity.this.hEo.showLoadingDialog();
                                                            PbActivity.this.hEk.bTl().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                    } else if (com.baidu.adp.lib.util.j.jS()) {
                                        PbActivity.this.hEo.bUS();
                                        if (PbActivity.this.hEo.hNg.bVP() != null && view == PbActivity.this.hEo.hNg.bVP().bTI() && !PbActivity.this.hEo.bVk()) {
                                            PbActivity.this.hEo.bUg();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bkh();
                                            PbActivity.this.hEo.bUB();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                t = PbActivity.this.hEk.t(true, PbActivity.this.bRF());
                                            } else {
                                                t = view.getId() == R.id.reply_title ? PbActivity.this.hEk.t(false, PbActivity.this.bRF()) : PbActivity.this.hEk.Bf(PbActivity.this.bRF());
                                            }
                                            view.setTag(Boolean.valueOf(t));
                                            if (t) {
                                                PbActivity.this.hEo.oh(true);
                                                PbActivity.this.hEo.bCa();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hEo.oy(true);
                                            }
                                            TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            PbActivity.this.xh(2);
                                        } else {
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else {
                                        PbActivity.this.showToast(R.string.network_not_available);
                                        view.setTag(Boolean.FALSE);
                                        return;
                                    }
                                } else if (com.baidu.adp.lib.util.j.jS()) {
                                    PbActivity.this.hEo.bUS();
                                    if (PbActivity.this.xg(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hEk.xv(PbActivity.this.hEo.bUG()) != null) {
                                        PbActivity.this.bRz();
                                        if (PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEk.hJo).bT("fid", PbActivity.this.hEk.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hEk.getPbData().bPL().adv().getUserId()));
                                        }
                                        if (PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null && PbActivity.this.hEk.getPbData().bPL().adv().getUserId() != null && PbActivity.this.hEm != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEk.hJo).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEk.getPbData().bPL().adv().getUserId()).P("obj_type", PbActivity.this.hEm.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEk.getPbData())));
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
                                if (PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().aep() && PbActivity.this.hEk.getPbData().bPL().adM() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hEk.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hEk.bQI()) && PbActivity.this.hEk.getAppealInfo() != null) {
                                        name = PbActivity.this.hEk.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hEk.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bQI = PbActivity.this.hEk.bQI();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hEk.bSK() && bQI != null && bQI.equals(name)) {
                                        PbActivity.this.finish();
                                    } else {
                                        PbActivity.this.sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                    }
                                } else {
                                    PbActivity.this.finish();
                                    return;
                                }
                            }
                        } else if (com.baidu.adp.lib.util.j.jS()) {
                            if (PbActivity.this.hEk.getPbData() != null) {
                                if ((PbActivity.this.hEk.getPbData().bPX() == 1 || PbActivity.this.hEk.getPbData().bPX() == 3) && !PbActivity.this.eyy.cnh()) {
                                    PbActivity.this.hEo.bUS();
                                    int i11 = 0;
                                    if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTJ()) {
                                        if (PbActivity.this.hEo.hNg.bVP() == null || view != PbActivity.this.hEo.hNg.bVP().bTL()) {
                                            if (view == PbActivity.this.hEo.bUz()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hEk.getPbData().bPL().adr() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hEk.getPbData().bPL().adq() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hEk.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hEk.getPbData().bPL().getId();
                                    PbActivity.this.hEo.bUy();
                                    PbActivity.this.eyy.a(id4, name2, id5, i11, PbActivity.this.hEo.bUA());
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
                    } else if (com.baidu.adp.lib.util.j.jS()) {
                        PbActivity.this.hEo.bUS();
                        PbActivity.this.bkh();
                        PbActivity.this.hEo.bUB();
                        PbActivity.this.hEo.showLoadingDialog();
                        if (PbActivity.this.hEo.bUo() != null) {
                            PbActivity.this.hEo.bUo().setVisibility(8);
                        }
                        PbActivity.this.hEk.xp(1);
                        if (PbActivity.this.hDP != null) {
                            PbActivity.this.hDP.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bRn = PbActivity.this.bRn();
                        if (!TextUtils.isEmpty(bRn)) {
                            ba.aiz().c(PbActivity.this.getPageContext(), new String[]{bRn});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hEk != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bT("tid", PbActivity.this.hEk.bSI());
                    amVar8.bT("fid", PbActivity.this.hEk.getForumId());
                    amVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.P("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hDZ) {
                    PbActivity.this.hDZ = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.bRh().bUe() != null && postData5.adv() != null && postData5.cmw() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bRh().bUf() != null) {
                                PbActivity.this.bRh().bUf().bSv();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hEk.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hEk.getPbData().bPL());
                            kVar2.e(postData5);
                            PbActivity.this.bRh().bUe().d(kVar2);
                            PbActivity.this.bRh().bUe().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.adv().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEk.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hED != null) {
                                PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEk.getPbData().getForumId());
                }
                if (PbActivity.this.hEk != null) {
                    amVar.bT("tid", PbActivity.this.hEk.bSI());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bkh();
            PbActivity.this.hEo.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.auH() && PbActivity.this.bQR() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bQR().Bi(postWriteCallBackData.getPostId());
                    PbActivity.this.hEQ = PbActivity.this.hEo.bUk();
                    if (PbActivity.this.hEk != null) {
                        PbActivity.this.hEk.cb(PbActivity.this.hEQ, PbActivity.this.hEo.bUl());
                    }
                }
                PbActivity.this.hEo.bUS();
                PbActivity.this.hEt.bVr();
                if (PbActivity.this.hED != null) {
                    PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                }
                PbActivity.this.hEo.bUd();
                PbActivity.this.hEo.oJ(true);
                PbActivity.this.hEk.bTb();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hEk.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                            if (pbData != null && pbData.bPL() != null && pbData.bPL().adv() != null && (userId = pbData.bPL().adv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.auH() && PbActivity.this.hEk.bSS()) {
                                PbActivity.this.hEo.bUB();
                            }
                        } else if (!com.baidu.tbadk.t.av.auH() && PbActivity.this.hEk.bSS()) {
                            PbActivity.this.hEo.bUB();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hEo.m(PbActivity.this.hEk.getPbData());
                    }
                    if (PbActivity.this.hEk.bSN()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bT("tid", PbActivity.this.hEk.bSI()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hED.arF() || PbActivity.this.hED.arG()) {
                    PbActivity.this.hED.a(false, postWriteCallBackData);
                }
                PbActivity.this.hEt.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gPM != null) {
                    PbActivity.this.gPM.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hFp = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEk.getPbData().getForumId());
                }
                if (PbActivity.this.hEk != null) {
                    amVar.bT("tid", PbActivity.this.hEk.bSI());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hEt != null) {
                    PbActivity.this.hEt.bVq();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gPM != null) {
                    PbActivity.this.gPM.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hEt != null) {
                if (PbActivity.this.hEo != null && PbActivity.this.hEo.bUf() != null && PbActivity.this.hEo.bUf().bSz() != null && PbActivity.this.hEo.bUf().bSz().arG()) {
                    PbActivity.this.hEo.bUf().bSz().a(postWriteCallBackData);
                }
                PbActivity.this.hEt.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hFq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bVp;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hEo != null && (bVp = PbActivity.this.hEo.bVp()) != null && PbActivity.this.hEo.getListView() != null) {
                            PbActivity.this.hEo.getListView().removeHeaderView(bVp);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hFr = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g kg;
            if (!z || dVar == null || dVar.bPV() != null || com.baidu.tbadk.core.util.v.Z(dVar.bPN()) >= 1) {
                PbActivity.this.hhm = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hEo.bUD();
                if (dVar == null || !dVar.bPR()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hEo.getView());
                }
                PbActivity.this.hEo.bBZ();
                if (PbActivity.this.isFullScreen || PbActivity.this.hEo.bVk()) {
                    PbActivity.this.hEo.bVb();
                } else if (!PbActivity.this.hEo.bUY()) {
                    PbActivity.this.hEo.oJ(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hEw = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hEo.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hEo.aUH();
                    if (dVar.bPL() != null && dVar.bPL().aey() != null) {
                        PbActivity.this.a(dVar.bPL().aey());
                    }
                    PbActivity.this.bRe();
                    if (PbActivity.this.hED != null) {
                        PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bPN() != null && dVar.bPN().size() >= 1 && dVar.bPN().get(0) != null) {
                        PbActivity.this.hEk.Bh(dVar.bPN().get(0).getId());
                    } else if (dVar.bPV() != null) {
                        PbActivity.this.hEk.Bh(dVar.bPV().getId());
                    }
                    if (PbActivity.this.hED != null) {
                        PbActivity.this.hED.a(dVar.getAnti());
                        PbActivity.this.hED.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hED.a(PbActivity.this.hEk.bSV(), PbActivity.this.hEk.bSI(), PbActivity.this.hEk.bTn());
                        if (dVar.bPL() != null) {
                            PbActivity.this.hED.fk(dVar.bPL().aeN());
                        }
                    }
                    if (PbActivity.this.hEm != null) {
                        PbActivity.this.hEm.ds(dVar.ZC());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hEo.oI(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hEo.a(dVar, i2, i3, PbActivity.this.hEk.bSJ(), i4, PbActivity.this.hEk.getIsFromMark());
                    PbActivity.this.hEo.e(dVar, PbActivity.this.hEk.bSJ());
                    PbActivity.this.hEo.oF(PbActivity.this.hEk.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.cst = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.cst) && PbActivity.this.hED != null && PbActivity.this.hED.aqS() != null && (kg = PbActivity.this.hED.aqS().kg(6)) != null && !TextUtils.isEmpty(PbActivity.this.cst)) {
                            ((View) kg).setOnClickListener(PbActivity.this.cth);
                        }
                    }
                    if (PbActivity.this.hEy) {
                        PbActivity.this.hEy = false;
                        final int bRu = PbActivity.this.bRu();
                        if (!dVar.bQj()) {
                            PbActivity.this.hEo.xB(bRu);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bRu, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hEz) {
                        PbActivity.this.hEz = false;
                        final int bRu2 = PbActivity.this.bRu();
                        final boolean z2 = bRu2 != -1;
                        if (!z2) {
                            bRu2 = PbActivity.this.bRv();
                        }
                        if (PbActivity.this.hEo != null) {
                            if (!dVar.bQj()) {
                                PbActivity.this.hEo.xB(bRu2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bRu2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hEo.setSelectionFromTop(bRu2, af2);
                                            } else {
                                                PbActivity.this.hEo.setSelectionFromTop(bRu2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hEo.oK(true);
                                PbActivity.this.hEo.oJ(false);
                            }
                        }
                    } else if (PbActivity.this.hEA) {
                        PbActivity.this.hEA = false;
                        PbActivity.this.hEo.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hEo.bUH();
                    }
                    PbActivity.this.hEk.a(dVar.getForum(), PbActivity.this.hFd);
                    PbActivity.this.hEk.a(PbActivity.this.hFe);
                    if (PbActivity.this.gPM != null && dVar.bPL() != null && dVar.bPL().adv() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bPL().adv());
                        PbActivity.this.gPM.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hEw && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hEk != null && PbActivity.this.hEk.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hEk.getAppealInfo().hAY)) {
                                    PbActivity.this.hEo.a(PbActivity.this.hEk.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hEo.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hEo.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hEo.bVb();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hEk.bSI());
                            jSONObject.put("fid", PbActivity.this.hEk.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                        kVar.setOpType("2");
                        kVar.start();
                    }
                    if (i == -1) {
                        PbActivity.this.hEo.Bl("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                            arrayList = PbActivity.this.hEk.getPbData().bPN();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cmw() != 1)) {
                            PbActivity.this.hEo.Bl(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bRS()) {
                            PbActivity.this.hEo.Bm(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hEo.Bm(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hEo.ajz();
                }
                PbActivity.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bQR().bSJ() || PbActivity.this.bQR().getPbData().getPage().acq() != 0 || PbActivity.this.bQR().bTh()) {
                    PbActivity.this.hEE = true;
                    return;
                }
                return;
            }
            PbActivity.this.hEk.xp(1);
            if (PbActivity.this.hDP != null) {
                PbActivity.this.hDP.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hEo.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.auk().aul()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eSm : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.cyw, PbActivity.this.createTime, PbActivity.this.cyE, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cyw = 0L;
                if (iVar != null) {
                    iVar.auh();
                }
                if (z2) {
                    iVar.cyN = currentTimeMillis;
                    iVar.fA(true);
                }
                if (!z2 && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null) {
                    int threadType = PbActivity.this.hEk.getPbData().bPL().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hEc, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hEc, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.kK(1000);
                                iVar2.cyP = currentTimeMillis;
                                iVar2.kL(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.kK(1005);
                        dVar.cyP = currentTimeMillis;
                        dVar.kL(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hFs = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bRq();
            }
        }
    };
    private final a.InterfaceC0236a hFt = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hEo.bUD();
            if (z) {
                if (PbActivity.this.hEm != null) {
                    PbActivity.this.hEm.ds(z2);
                }
                PbActivity.this.hEk.op(z2);
                if (PbActivity.this.hEk.ZC()) {
                    PbActivity.this.bRA();
                } else {
                    PbActivity.this.hEo.m(PbActivity.this.hEk.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hEm != null && PbActivity.this.hEm.ZF() != null && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null) {
                        MarkData ZF = PbActivity.this.hEm.ZF();
                        MetaData adv = PbActivity.this.hEk.getPbData().bPL().adv();
                        if (ZF != null && adv != null) {
                            if (!com.baidu.tbadk.core.util.ap.equals(TbadkCoreApplication.getCurrentAccount(), adv.getUserId()) && !adv.hadConcerned()) {
                                PbActivity.this.b(adv);
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
            if (!PbActivity.this.xd(PbActivity.this.mLastScrollState) && PbActivity.this.xd(i)) {
                if (PbActivity.this.hEo != null) {
                    PbActivity.this.hEo.bUS();
                    if (PbActivity.this.hED != null && !PbActivity.this.hEo.bUh()) {
                        PbActivity.this.hEo.oH(PbActivity.this.hED.arz());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hEo.bUg();
                    }
                }
                if (!PbActivity.this.hDW) {
                    PbActivity.this.hDW = true;
                    PbActivity.this.hEo.bUX();
                }
            }
            PbActivity.this.hEo.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hDP != null) {
                PbActivity.this.hDP.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hDX == null) {
                PbActivity.this.hDX = new com.baidu.tbadk.p.b();
                PbActivity.this.hDX.kK(1001);
            }
            if (i == 0) {
                PbActivity.this.hDX.aub();
            } else {
                PbActivity.this.hDX.aua();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.clv().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bPN;
            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEo != null && PbActivity.this.hEo.bUx() != null) {
                PbActivity.this.hEo.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hDP != null) {
                    PbActivity.this.hDP.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hEk.bTd() && (bPN = PbActivity.this.hEk.getPbData().bPN()) != null && !bPN.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hEo.bUx().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
                    if (pbData != null) {
                        if (pbData.bPO() != null && pbData.bPO().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bPP() != null && pbData.bPP().hasData()) {
                            headerCount--;
                        }
                        int size = bPN.size();
                        if (headerCount < 0 || headerCount >= size) {
                        }
                    }
                }
            }
        }
    };
    private final com.baidu.adp.base.d eyC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.52
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            boolean z = false;
            if (obj != null) {
                switch (PbActivity.this.eyy.getLoadDataMode()) {
                    case 0:
                        PbActivity.this.hEk.bTb();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUx != 1002 || bVar.fTR) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hEo.a(1, dVar.FN, dVar.jbj, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eyy.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hEo.a(PbActivity.this.eyy.getLoadDataMode(), gVar.FN, gVar.jbj, false);
                        PbActivity.this.hEo.ax(gVar.jbm);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hEo.a(PbActivity.this.eyy.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hFu = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c cXJ = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (PbActivity.this.bRG()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hEk.oo(true)) {
                PbActivity.this.hEo.bUE();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fJa = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hFv && PbActivity.this.bRG()) {
                PbActivity.this.bRI();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hEk.on(false)) {
                    PbActivity.this.hEo.bUC();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hEk.getPbData() != null) {
                    PbActivity.this.hEo.bUW();
                }
                PbActivity.this.hFv = true;
            }
        }
    };
    private int hFw = 0;
    private final TbRichTextView.h cIM = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bUx;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hEk != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bT("tid", PbActivity.this.hEk.bSI());
                        amVar.bT("fid", PbActivity.this.hEk.getForumId());
                        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        amVar.P("obj_locate", 3);
                        amVar.P("obj_type", z2 ? 1 : 2);
                        TiebaStatic.log(amVar);
                    }
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            PbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(PbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                        }
                        PbActivity.this.hEg = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hGm) {
                        TbRichText bd = PbActivity.this.bd(str, i);
                        if (bd != null && PbActivity.this.hFw >= 0 && PbActivity.this.hFw < bd.axz().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bd.axz().get(PbActivity.this.hFw));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hGj.size()) {
                                    break;
                                } else if (!cVar.hGj.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bd.getPostId() != 0 && (bUx = PbActivity.this.hEo.bUx()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bUx.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bd.getPostId() == com.baidu.adp.lib.g.b.c(((PostData) next).getId(), 0L)) {
                                            if (bd.getPostId() != com.baidu.adp.lib.g.b.c(PbActivity.this.hEk.bTn(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEk.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hGk.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGl, cVar.lastId, PbActivity.this.hEk.bSY(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.n(rect);
                            createConfig.setIsHotSort(PbActivity.this.hEk.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hGj, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hGk.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGl, cVar.hGj.get(0), PbActivity.this.hEk.bSY(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hEk.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hEo.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hFx = false;
    PostData ggN = null;
    private final b.a hFy = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.ggN != null) {
                if (i == 0) {
                    PbActivity.this.ggN.ek(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.ggN = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.ggN);
                }
            }
        }
    };
    private final b.a hFz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hEN != null && !TextUtils.isEmpty(PbActivity.this.hEO)) {
                if (i == 0) {
                    if (PbActivity.this.hEP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hEO;
                        aVar.pkgId = PbActivity.this.hEP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.aiM();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fQC == null) {
                            PbActivity.this.fQC = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fQC.h(PbActivity.this.hEO, PbActivity.this.hEN.nv());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hEN = null;
                PbActivity.this.hEO = null;
            }
        }
    };
    private final View.OnLongClickListener clk = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean nY;
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
                        PbActivity.this.hEN = ((TbImageView) view).getBdImage();
                        PbActivity.this.hEO = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hEN == null || TextUtils.isEmpty(PbActivity.this.hEO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEP = null;
                        } else {
                            PbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hEN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hEO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hEP = null;
                            } else {
                                PbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hEN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hEO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEP = null;
                        } else {
                            PbActivity.this.hEP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hEo.a(PbActivity.this.hFz, PbActivity.this.hEN.isGif());
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
            PbActivity.this.ggN = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.ggN == null) {
                return true;
            }
            if (PbActivity.this.ggN.cmw() != 1 || !PbActivity.this.cu(view)) {
                if (PbActivity.this.hEm != null) {
                    if (!PbActivity.this.hEm.ZC() || PbActivity.this.ggN.getId() == null || !PbActivity.this.ggN.getId().equals(PbActivity.this.hEk.adE())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.ggN.cmw() == 1) {
                        PbActivity.this.hEo.a(PbActivity.this.hFy, z, false);
                        return true;
                    }
                    if (PbActivity.this.hEv == null) {
                        PbActivity.this.hEv = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hEv.a(PbActivity.this.hFA);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cu = PbActivity.this.cu(view);
                        boolean z3 = (!PbActivity.this.cu(view) || PbActivity.this.hEN == null || PbActivity.this.hEN.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEv);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cu) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hEv));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hEv));
                        }
                        if (!cu && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEv);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.ggN);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEv);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEv);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.ggN);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEv);
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
                                if (!ap.m(PbActivity.this.ggN)) {
                                    nY = PbActivity.this.nY(z5) & PbActivity.this.isLogin();
                                } else {
                                    nY = false;
                                }
                                if (nY) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEv);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEv);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEv);
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
                                    if (PbActivity.this.hEk.getPbData().bPX() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEv);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEv);
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
                        PbActivity.this.hEv.W(arrayList);
                        PbActivity.this.hEu = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEv.afZ());
                        PbActivity.this.hEu.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bT("tid", PbActivity.this.hEk.hJo).bT("fid", PbActivity.this.hEk.getForumId()).bT("uid", PbActivity.this.hEk.getPbData().bPL().adv().getUserId()).bT("post_id", PbActivity.this.hEk.aro()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hEo.a(PbActivity.this.hFz, PbActivity.this.hEN.isGif());
            return true;
        }
    };
    private k.c hFA = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hEu != null) {
                PbActivity.this.hEu.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEk.getPbData();
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
                    if (PbActivity.this.hEN != null && !TextUtils.isEmpty(PbActivity.this.hEO)) {
                        if (PbActivity.this.hEP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hEO;
                            aVar.pkgId = PbActivity.this.hEP.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hEN = null;
                        PbActivity.this.hEO = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hEN != null && !TextUtils.isEmpty(PbActivity.this.hEO)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.aiM();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fQC == null) {
                                PbActivity.this.fQC = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fQC.h(PbActivity.this.hEO, PbActivity.this.hEN.nv());
                            PbActivity.this.hEN = null;
                            PbActivity.this.hEO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.ggN != null) {
                        PbActivity.this.ggN.ek(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.ggN = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ct(view);
                        if (PbActivity.this.hEk.getPbData().bPL() != null && PbActivity.this.hEk.getPbData().bPL().adv() != null && PbActivity.this.hEk.getPbData().bPL().adv().getUserId() != null && PbActivity.this.hEm != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEk.hJo).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEk.getPbData().bPL().adv().getUserId()).P("obj_type", PbActivity.this.hEm.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEk.getPbData())));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!com.baidu.adp.lib.util.j.jS()) {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13079"));
                        PbActivity.this.Ba((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").P("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        PbActivity.this.hEo.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!com.baidu.adp.lib.util.j.jS()) {
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
                                PbActivity.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            PbActivity.this.hEo.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hEo.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
    private final NoNetworkView.a fmv = new NoNetworkView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.77
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (!PbActivity.this.hDR && z && !PbActivity.this.hEk.bSP()) {
                PbActivity.this.bRC();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FrameLayout frameLayout = (FrameLayout) PbActivity.this.getPageContext().getPageActivity().getWindow().getDecorView();
            for (int i = 0; i < frameLayout.getChildCount(); i++) {
                View childAt = frameLayout.getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                    break;
                }
            }
            PbActivity.this.dWj.onTouchEvent(motionEvent);
            return false;
        }
    };
    private a.InterfaceC0302a dWk = new a.InterfaceC0302a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.84
        final int egj;

        {
            this.egj = (int) PbActivity.this.getResources().getDimension(R.dimen.ds98);
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aT(int i, int i2) {
            if (ax(i2) && PbActivity.this.hEo != null && PbActivity.this.hDP != null) {
                PbActivity.this.hEo.bVc();
                PbActivity.this.hDP.kb(false);
                PbActivity.this.hDP.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (ax(i2) && PbActivity.this.hEo != null && PbActivity.this.hDP != null) {
                PbActivity.this.hDP.kb(true);
                if (Math.abs(i2) > this.egj) {
                    PbActivity.this.hDP.hideFloatingView();
                }
                if (PbActivity.this.bRG()) {
                    PbActivity.this.hEo.bUu();
                    PbActivity.this.hEo.bUv();
                }
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aV(int i, int i2) {
        }

        private boolean ax(float f) {
            return Math.abs(f) >= 1.0f;
        }
    };
    private String hFC = null;
    private final m.a hFD = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hFC = str2;
                PbActivity.this.hEo.Bn(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hFE = -1;
    private int hFF = -1;
    private CustomMessageListener hFI = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bDk == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0238a) {
                    if (aVar.bDl != null && !aVar.bDl.hasError() && aVar.bDl.getError() == 0) {
                        if (PbActivity.this.hEo != null) {
                            PbActivity.this.hEo.q(((a.C0238a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bRR();
                        }
                    } else if (z) {
                        if (aVar.bDl != null && aVar.bDl.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bDl.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bDl != null && !aVar.bDl.hasError() && aVar.bDl.getError() == 0) {
                        if (PbActivity.this.hEo != null && PbActivity.this.hEo != null) {
                            PbActivity.this.hEo.q(((a.C0238a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bDl != null && aVar.bDl.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bDl.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bDl == null || aVar.bDl.hasError() || aVar.bDl.getError() != 0) {
                        if (z) {
                            if (aVar.bDl != null && aVar.bDl.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bDl.getErrorString());
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
        void m(Object obj);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public ArrayList<String> hGj;
        public ConcurrentHashMap<String, ImageUrlData> hGk;
        public boolean hGm;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hGl = false;
        public boolean hGn = false;
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

    public com.baidu.tbadk.editortools.pb.d bRd() {
        return this.hED;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bQu() != null) {
            String id = kVar.bQu().getId();
            ArrayList<PostData> bPN = this.hEk.getPbData().bPN();
            int i = 0;
            while (true) {
                if (i >= bPN.size()) {
                    break;
                }
                PostData postData = bPN.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bQy = kVar.bQy();
                    postData.Ax(kVar.getTotalCount());
                    if (postData.cmt() != null && bQy != null) {
                        Iterator<PostData> it = bQy.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.adv() != null && (metaData = postData.getUserMap().get(next.adv().getUserId())) != null) {
                                next.a(metaData);
                                next.qN(true);
                                next.a(getPageContext(), this.hEk.Bg(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bQy.size() != postData.cmt().size();
                        postData.cmt().clear();
                        postData.cmt().addAll(bQy);
                        z = z2;
                    }
                    if (postData.cmp() != null) {
                        postData.cmq();
                    }
                }
            }
            if (!this.hEk.getIsFromMark() && z) {
                this.hEo.m(this.hEk.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bQa = this.hEk.getPbData().bQa();
            if (bQa != null && str.equals(bQa.getAdId())) {
                if (bQa.cmk() != null) {
                    bQa.cmk().legoCard = null;
                }
                this.hEk.getPbData().bQb();
            }
            com.baidu.tieba.tbadkCore.data.m bST = this.hEk.bST();
            if (bST != null && str.equals(bST.getAdId())) {
                this.hEk.bSU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hEu != null && this.hEu.isShowing()) {
                this.hEu.dismiss();
                this.hEu = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hEu != null) {
                            PbActivity.this.hEu.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hEo.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hEL);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hEL);
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
                kVar.W(arrayList);
                this.hEu = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar.afZ());
                this.hEu.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        bg bPL;
        if (this.hEk != null && this.hEk.getPbData() != null && (bPL = this.hEk.getPbData().bPL()) != null) {
            if (i == 1) {
                PraiseData adh = bPL.adh();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (adh == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        bPL.a(praiseData);
                    } else {
                        bPL.adh().getUser().add(0, metaData);
                        bPL.adh().setNum(bPL.adh().getNum() + 1);
                        bPL.adh().setIsLike(i);
                    }
                }
                if (bPL.adh() != null) {
                    if (bPL.adh().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.aL(bPL.adh().getNum());
                    }
                }
            } else if (bPL.adh() != null) {
                bPL.adh().setIsLike(i);
                bPL.adh().setNum(bPL.adh().getNum() - 1);
                ArrayList<MetaData> user = bPL.adh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bPL.adh().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bPL.adh().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bPL.adh().getNum() + "";
                }
            }
            if (this.hEk.bSJ()) {
                this.hEo.bUx().notifyDataSetChanged();
            } else {
                this.hEo.n(this.hEk.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hEk.ab(bundle);
        if (this.foP != null) {
            this.foP.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hED.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hDV = System.currentTimeMillis();
        this.hEJ = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eSm = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hEc = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hEc) && intent.getData() != null) {
                this.hEc = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hEc)) {
                this.hDQ = true;
            }
            this.hFE = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hFF = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hFG = intent.getStringExtra("key_manga_title");
            this.hEy = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hEz = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hEA = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bRG()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hER = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eSm = System.currentTimeMillis();
        }
        this.cyw = this.hDV - this.eSm;
        super.onCreate(bundle);
        this.hDT = 0;
        aa(bundle);
        if (this.hEk != null && this.hEk.getPbData() != null) {
            this.hEk.getPbData().AW(this.source);
        }
        initUI();
        if (intent != null && this.hEo != null) {
            this.hEo.hMZ = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hEM == null) {
                    this.hEM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hEo.Bp("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hEM, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hEk != null && this.hEk.getPbData() != null) {
                this.hEk.Bj(stringExtra);
            }
        }
        this.foP = new VoiceManager();
        this.foP.onCreate(getPageContext());
        initData(bundle);
        this.hEC = new com.baidu.tbadk.editortools.pb.f();
        bRe();
        this.hED = (com.baidu.tbadk.editortools.pb.d) this.hEC.cJ(getActivity());
        this.hED.b(this);
        this.hED.a(this.csD);
        this.hED.a(this.csw);
        this.hED.a(this, bundle);
        this.hED.aqS().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hED.aqS().fd(true);
        nX(true);
        this.hEo.setEditorTools(this.hED.aqS());
        this.hED.a(this.hEk.bSV(), this.hEk.bSI(), this.hEk.bTn());
        registerListener(this.hEY);
        if (!this.hEk.bSO()) {
            this.hED.qa(this.hEk.bSI());
        }
        if (this.hEk.bTo()) {
            this.hED.pY(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hEo != null) {
            this.hED.pY(this.hEo.bUi());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hEX);
        registerListener(this.hEZ);
        registerListener(this.hFa);
        registerListener(this.fql);
        registerListener(this.hFo);
        registerListener(this.hEW);
        this.hEB = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iYb);
        this.hEB.clX();
        registerListener(this.hFc);
        registerListener(this.mAttentionListener);
        if (this.hEk != null) {
            this.hEk.bTf();
        }
        registerListener(this.hFs);
        registerListener(this.hFI);
        registerListener(this.fqs);
        if (this.hEo != null && this.hEo.bVg() != null && this.hEo.bVh() != null) {
            this.hDP = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hEo.bVg(), this.hEo.bVh(), this.hEo.bUo());
            this.hDP.a(this.hFk);
        }
        if (this.hDO && this.hEo != null && this.hEo.bVh() != null) {
            this.hEo.bVh().setVisibility(8);
        }
        this.hEK = new com.baidu.tbadk.core.view.e();
        this.hEK.bXF = 1000L;
        registerListener(this.hFn);
        registerListener(this.hFl);
        registerListener(this.hFm);
        registerListener(this.fHQ);
        registerListener(this.fqi);
        this.hEL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hEL;
        userMuteAddAndDelCustomMessage.setTag(this.hEL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hEL;
        userMuteCheckCustomMessage.setTag(this.hEL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hEk.bTl().a(this.dVA);
        this.hEt = new as();
        if (this.hED.ars() != null) {
            this.hEt.k(this.hED.ars().getInputView());
        }
        this.hED.a(this.csx);
        this.fEP = new ShareSuccessReplyToServerModel();
        a(this.hET);
        this.gPM = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gPM.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bSg) {
                        PbActivity.this.hED.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bSh && PbActivity.this.hEo != null && PbActivity.this.hEo.bUf() != null && PbActivity.this.hEo.bUf().bSz() != null) {
                        PbActivity.this.hEo.bUf().bSz().arL();
                    } else if (i == com.baidu.tbadk.core.util.aj.bSi) {
                        PbActivity.this.c(PbActivity.this.hEG);
                    }
                }
            }
        });
        this.hEl = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEl.r(getUniqueId());
        com.baidu.tieba.q.c.clv().u(getUniqueId());
        com.baidu.tbadk.core.business.a.abt().bB("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.jT() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.hDV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRe() {
        if (this.hEC != null && this.hEk != null) {
            this.hEC.setForumName(this.hEk.bQI());
            if (this.hEk.getPbData() != null && this.hEk.getPbData().getForum() != null) {
                this.hEC.a(this.hEk.getPbData().getForum());
            }
            this.hEC.setFrom("pb");
            this.hEC.a(this.hEk);
        }
    }

    public String bRf() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bRg() {
        return this.hDP;
    }

    private void nX(boolean z) {
        this.hED.fh(z);
        this.hED.fi(z);
        this.hED.fj(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bQj() && !z && this.hEo != null && this.hEo.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hEo.getView().setSystemUiVisibility(4);
        }
        this.hEH = z;
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
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    public aq bRh() {
        return this.hEo;
    }

    public PbModel bQR() {
        return this.hEk;
    }

    public void AZ(String str) {
        if (this.hEk != null && !StringUtils.isNull(str) && this.hEo != null) {
            this.hEo.oM(true);
            this.hEk.AZ(str);
            this.hEb = true;
            this.hEo.bUS();
            this.hEo.bVb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hDR = false;
        } else {
            this.hDR = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hDT = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hDT == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        if (this.hEo != null) {
            this.hEo.onPause();
        }
        if (!this.hEk.bSO()) {
            this.hED.pZ(this.hEk.bSI());
        }
        if (this.hEk != null) {
            this.hEk.bTg();
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        MessageManager.getInstance().unRegisterListener(this.gtK);
        bvB();
        MessageManager.getInstance().unRegisterListener(this.hFl);
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bRi() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hEk.getPbData(), this.hEk.bSJ(), this.hEk.getRequestType());
        return (a2 == null || a2.adv() == null || a2.adv().getGodUserData() == null || a2.adv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hDR = false;
        super.onResume();
        if (this.hEe) {
            this.hEe = false;
            bRM();
        }
        if (bRi()) {
            this.hDY = System.currentTimeMillis();
        } else {
            this.hDY = -1L;
        }
        if (this.hEo != null && this.hEo.getView() != null) {
            if (!this.hhm) {
                bRD();
            } else {
                hideLoadingView(this.hEo.getView());
            }
            this.hEo.onResume();
        }
        if (this.hDT == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hEo != null) {
            noNetworkView = this.hEo.bUc();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jS()) {
            noNetworkView.ek(false);
        }
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        registerListener(this.gtK);
        this.hEx = false;
        bRL();
        registerListener(this.hFl);
        registerListener(this.hFm);
        registerListener(this.hFn);
        if (this.fpF) {
            bRC();
            this.fpF = false;
        }
        bRU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hEo.oB(z);
        if (this.hEu != null) {
            this.hEu.dismiss();
        }
        if (z && this.hEx) {
            this.hEo.bUC();
            this.hEk.on(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hDY > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hDY) + ""));
            this.hDY = 0L;
        }
        if (bRh().bUf() != null) {
            bRh().bUf().onStop();
        }
        if (this.hEo.hNg != null && !this.hEo.hNg.aYy()) {
            this.hEo.hNg.bGX();
        }
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().getForum() != null && this.hEk.getPbData().bPL() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "pb", this.hEk.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEk.getPbData().bPL().getId(), 0L));
        }
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.clv().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("fid", this.hEk.getPbData().getForumId());
            amVar.bT("tid", this.hEk.bSI());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hDW && this.hEo != null) {
            this.hDW = true;
            this.hEo.bUX();
            a(false, (PostData) null);
        }
        if (this.hEk != null) {
            this.hEk.cancelLoadData();
            this.hEk.destory();
            if (this.hEk.bTk() != null) {
                this.hEk.bTk().onDestroy();
            }
        }
        if (this.hED != null) {
            this.hED.onDestroy();
        }
        if (this.eyy != null) {
            this.eyy.cancelLoadData();
        }
        if (this.hEo != null) {
            this.hEo.onDestroy();
            if (this.hEo.hNg != null) {
                this.hEo.hNg.bGX();
            }
        }
        if (this.hDX != null) {
            this.hDX.auc();
        }
        if (this.hDP != null) {
            this.hDP.avm();
        }
        super.onDestroy();
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        this.hEo.bUS();
        MessageManager.getInstance().unRegisterListener(this.hFl);
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().unRegisterListener(this.hEL);
        MessageManager.getInstance().unRegisterListener(this.hFo);
        MessageManager.getInstance().unRegisterListener(this.fqs);
        MessageManager.getInstance().unRegisterListener(this.fHQ);
        MessageManager.getInstance().unRegisterListener(this.hFq);
        this.hEJ = null;
        this.hEK = null;
        com.baidu.tieba.recapp.d.a.cfB().cfD();
        if (this.hEM != null) {
            getSafeHandler().removeCallbacks(this.hEM);
        }
        if (this.hEf != null) {
            this.hEf.cancelLoadData();
        }
        if (this.hEo != null && this.hEo.hNg != null) {
            this.hEo.hNg.bVT();
        }
        if (this.fEP != null) {
            this.fEP.cancelLoadData();
        }
        this.hEt.onDestroy();
        if (this.hEk != null && this.hEk.bTm() != null) {
            this.hEk.bTm().onDestroy();
        }
        if (this.gPM != null) {
            this.gPM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bUx;
        ArrayList<PostData> bSk;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.akW() && this.hEo != null && (bUx = this.hEo.bUx()) != null && (bSk = bUx.bSk()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bSk.iterator();
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
                        bVar.eAv = i;
                        arrayList.add(bVar);
                        break;
                    }
                } else if (next.bJA == 1 && !TextUtils.isEmpty(id)) {
                    next.bJA = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eAv = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hEk == null || this.hEk.getPbData() == null || this.hEk.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hEk.getPbData().getForum().getFirst_class();
                    str2 = this.hEk.getPbData().getForum().getSecond_class();
                    str = this.hEk.getPbData().getForum().getId();
                    str4 = this.hEk.bSI();
                }
                com.baidu.tieba.recapp.s.sendPB(z, str3, str2, str, str4, arrayList, adAdSense.akZ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            super.onChangeSkinType(i);
            this.hEo.onChangeSkinType(i);
            if (this.hED != null && this.hED.aqS() != null) {
                this.hED.aqS().onChangeSkinType(i);
            }
            if (this.hEo.bUc() != null) {
                this.hEo.bUc().onChangeSkinType(getPageContext(), i);
            }
            this.hEt.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.al.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hEo = new aq(this, this.fra, this.ckg);
        this.dWj = new com.baidu.tieba.f.b(getActivity());
        this.dWj.a(hFB);
        this.dWj.a(this.dWk);
        this.hEo.setOnScrollListener(this.mOnScrollListener);
        this.hEo.e(this.fJa);
        this.hEo.setListPullRefreshListener(this.cXJ);
        this.hEo.nR(com.baidu.tbadk.core.i.abb().abf());
        this.hEo.setOnImageClickListener(this.cIM);
        this.hEo.b(this.clk);
        this.hEo.h(this.fmv);
        this.hEo.a(this.hFu);
        this.hEo.oB(this.mIsLogin);
        if (getIntent() != null) {
            this.hEo.oN(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hEo.bUe().setFromForumId(this.hEk.getFromForumId());
    }

    public void bRj() {
        if (this.hEo != null && this.hEk != null) {
            if ((this.hEk.getPbData() != null || this.hEk.getPbData().bQi() != null) && checkUpIsLogin() && this.hEo.bUx() != null && this.hEo.bUx().bSp() != null) {
                this.hEo.bUx().bSp().oC(this.hEk.bSI());
            }
        }
    }

    public void bRk() {
        TiebaStatic.log("c12181");
        if (this.hEo != null && this.hEk != null) {
            if (this.hEo == null || this.hEo.bUh()) {
                if (this.hEk.getPbData() != null || this.hEk.getPbData().bQi() != null) {
                    com.baidu.tieba.pb.data.j bQi = this.hEk.getPbData().bQi();
                    if (checkUpIsLogin()) {
                        if ((!bQi.bQr() || bQi.aeR() != 2) && this.hEo.bUx() != null && this.hEo.bUx().bSp() != null) {
                            this.hEo.bUx().bSp().oC(this.hEk.bSI());
                        }
                        if (System.currentTimeMillis() - this.hEa > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).pg(false);
                            this.hEa = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iYD && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.abb().abf()) {
                    return Bc(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hEk == null || this.hEk.getPbData() == null) {
                        return true;
                    }
                    if (bRh().bUf() != null) {
                        bRh().bUf().bSv();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hEk.getPbData().getForum());
                    kVar.ai(this.hEk.getPbData().bPL());
                    kVar.e(postData);
                    bRh().bUe().d(kVar);
                    bRh().bUe().setPostId(postData.getId());
                    a(view, postData.adv().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hED != null) {
                        this.hEo.oH(this.hED.arz());
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
        if (this.hEo != null) {
            if (z && !this.hhm) {
                bRD();
            } else {
                hideLoadingView(this.hEo.getView());
            }
            if (z && this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bQj() && this.hEo.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hEo.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bRl() {
        if (this.hDU == null) {
            this.hDU = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hDU.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hDJ = PbActivity.this.hDJ.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDJ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEk.bSI(), PbActivity.this.hDJ, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hDJ = PbActivity.this.hDJ.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDJ);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEk.bSI(), PbActivity.this.hDJ, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hDJ = PbActivity.this.hDJ.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDJ);
                        bVar.dismiss();
                    }
                }
            }).ht(R.style.dialog_ani_b2t).hu(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hEk = new PbModel(this);
        this.hEk.a(this.hFr);
        if (this.hEk.bTj() != null) {
            this.hEk.bTj().a(this.hFD);
        }
        if (this.hEk.bTi() != null) {
            this.hEk.bTi().a(this.hFb);
        }
        if (this.hEk.bTk() != null) {
            this.hEk.bTk().b(this.hEV);
        }
        if (bundle != null) {
            this.hEk.initWithBundle(bundle);
        } else {
            this.hEk.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hEk.oq(true);
        }
        aj.bTR().aq(this.hEk.bSG(), this.hEk.getIsFromMark());
        if (StringUtils.isNull(this.hEk.bSI())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hEc) && this.hEc != null) {
            this.hEk.xw(6);
        }
        this.hEk.atv();
    }

    private void initData(Bundle bundle) {
        this.hEm = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEm != null) {
            this.hEm.a(this.hFt);
        }
        this.eyy = new ForumManageModel(this);
        this.eyy.setLoadDataCallBack(this.eyC);
        this.bSl = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hEo.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hEk.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEk.getPbData().getForum().getId(), PbActivity.this.hEk.getPbData().getForum().getName(), PbActivity.this.hEk.getPbData().bPL().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hFh.setUniqueId(getUniqueId());
        this.hFh.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hEo.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hEL;
        userMuteCheckCustomMessage.setTag(this.hEL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bRm() {
        if (checkUpIsLogin()) {
            if (this.fsx == null) {
                this.fsx = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.fsx.si(0);
                this.fsx.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.39
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jV(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void n(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void jW(boolean z) {
                        if (z) {
                            PbActivity.this.hEo.buO();
                        }
                    }
                });
            }
            if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().getForum() != null) {
                this.fsx.t(this.hEk.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEk.bSI(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRn() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hEk != null && (pbData = this.hEk.getPbData()) != null) {
            return pbData.bPW().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPL() != null) {
            if (dVar.bPL().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPL().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bPL().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bRo()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hEh);
                this.hEi = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hEF == null) {
                this.hEF = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hEF.si(1);
                this.hEF.a(new AnonymousClass40(str, str2));
            }
            if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().getForum() != null) {
                this.hEF.t(this.hEk.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEk.bSI(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hFS;
        final /* synthetic */ String hFT;

        AnonymousClass40(String str, String str2) {
            this.hFS = str;
            this.hFT = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jV(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jW(boolean z) {
            if (z) {
                PbActivity.this.getSafeHandler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int g;
                        int ah = com.baidu.adp.lib.util.l.ah(PbActivity.this.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            g = TbadkCoreApplication.getInst().getKeyboardHeight() + com.baidu.adp.lib.util.l.g(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            g = (ah / 2) + com.baidu.adp.lib.util.l.g(PbActivity.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        PbActivity.this.bRh().getListView().smoothScrollBy((PbActivity.this.hEh[1] + PbActivity.this.hEi) - (ah - g), 50);
                        if (PbActivity.this.bRh().bUf() != null) {
                            PbActivity.this.hED.aqS().setVisibility(8);
                            PbActivity.this.bRh().bUf().Y(AnonymousClass40.this.hFS, AnonymousClass40.this.hFT, PbActivity.this.bRh().bUi());
                            com.baidu.tbadk.editortools.pb.g bSz = PbActivity.this.bRh().bUf().bSz();
                            if (bSz != null && PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                                bSz.a(PbActivity.this.hEk.getPbData().getAnti());
                            }
                            if (PbActivity.this.hEt.bVu() == null && PbActivity.this.bRh().bUf().bSz().arT() != null) {
                                PbActivity.this.bRh().bUf().bSz().arT().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hEt != null && PbActivity.this.hEt.bVt() != null) {
                                            if (!PbActivity.this.hEt.bVt().cwh()) {
                                                PbActivity.this.hEt.oP(false);
                                            }
                                            PbActivity.this.hEt.bVt().rK(false);
                                        }
                                    }
                                });
                                PbActivity.this.hEt.l(PbActivity.this.bRh().bUf().bSz().arT().getInputView());
                                PbActivity.this.bRh().bUf().bSz().a(PbActivity.this.hEI);
                            }
                        }
                        PbActivity.this.bRh().bVb();
                    }
                }, 0L);
            }
        }
    }

    public boolean bRo() {
        if (this.gPM == null || this.hEk.getPbData() == null || this.hEk.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPM.hZ(this.hEk.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xf(int i) {
        if (this.gPM == null || this.hEk.getPbData() == null || this.hEk.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPM.R(this.hEk.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hEk != null && this.hEk.getPbData() != null && postData.cmw() != 1) {
            String bSI = this.hEk.bSI();
            String id = postData.getId();
            int bPX = this.hEk.getPbData() != null ? this.hEk.getPbData().bPX() : 0;
            c Bd = Bd(id);
            if (Bd != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bSI, id, "pb", true, null, false, null, bPX, postData.bWH(), this.hEk.getPbData().getAnti(), false, postData.adv() != null ? postData.adv().getIconInfo() : null).addBigImageData(Bd.hGj, Bd.hGk, Bd.hGl, Bd.index);
                addBigImageData.setKeyPageStartFrom(this.hEk.bTq());
                addBigImageData.setFromFrsForumId(this.hEk.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRp() {
        if (this.hEk.getPbData() == null || this.hEk.getPbData().bPL() == null) {
            return -1;
        }
        return this.hEk.getPbData().bPL().aef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Dq(this.hEk.getForumId()) && this.hEk.getPbData() != null && this.hEk.getPbData().getForum() != null) {
            if (this.hEk.getPbData().getForum().isLike() == 1) {
                this.hEk.bTm().ed(this.hEk.getForumId(), this.hEk.bSI());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nY(boolean z) {
        if (this.hEk == null || this.hEk.getPbData() == null) {
            return false;
        }
        return ((this.hEk.getPbData().bPX() != 0) || this.hEk.getPbData().bPL() == null || this.hEk.getPbData().bPL().adv() == null || TextUtils.equals(this.hEk.getPbData().bPL().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bRr() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.auI()) {
            return "";
        }
        PostData bPS = bPS();
        if (this.hEk == null || (pbData = this.hEk.getPbData()) == null || pbData.getUserData() == null || pbData.bPL() == null || bPS == null || bPS.adv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bPS.adv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bPL().adc() == 0) {
            return "";
        }
        if (pbData.bPL().adc() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean nZ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hEk == null || this.hEk.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bPX() != 0) {
                return pbData.bPX() != 3;
            }
            List<com.baidu.tbadk.core.data.bc> bQg = pbData.bQg();
            if (com.baidu.tbadk.core.util.v.Z(bQg) > 0) {
                for (com.baidu.tbadk.core.data.bc bcVar : bQg) {
                    if (bcVar != null && (vVar = bcVar.bHQ) != null && vVar.bFI && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean oa(boolean z) {
        if (z || this.hEk == null || this.hEk.getPbData() == null) {
            return false;
        }
        return ((this.hEk.getPbData().getForum() != null && this.hEk.getPbData().getForum().isBlockBawuDelete) || this.hEk.getPbData().bPX() == 0 || this.hEk.getPbData().bPX() == 3) ? false : true;
    }

    public void bRs() {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().adv() != null) {
            if (this.hEo != null) {
                this.hEo.bUd();
            }
            bg bPL = this.hEk.getPbData().bPL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bPL.adv().getUserId());
            ab abVar = new ab();
            int bPX = this.hEk.getPbData().bPX();
            if (bPX == 1 || bPX == 3) {
                abVar.hLr = true;
                abVar.hLq = true;
                abVar.hLy = bPL.adq() == 1;
                abVar.hLx = bPL.adr() == 1;
            } else {
                abVar.hLr = false;
                abVar.hLq = false;
            }
            if (bPX == 1002 && !equals) {
                abVar.hLC = true;
            }
            abVar.hLs = nZ(equals);
            abVar.hLt = bRt();
            abVar.hLu = oa(equals);
            abVar.ox = this.hEk.bSJ();
            abVar.hLp = true;
            abVar.hLo = nY(equals);
            abVar.hLA = bRr();
            abVar.hLn = equals && this.hEo.bUJ();
            abVar.hLv = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hLw = true;
            abVar.isHostOnly = this.hEk.getHostMode();
            abVar.hLz = true;
            if (bPL.adM() == null) {
                abVar.hLB = true;
            } else {
                abVar.hLB = false;
            }
            this.hEo.hNg.a(abVar);
        }
    }

    private boolean bRt() {
        if (this.hEk != null && this.hEk.bSJ()) {
            return this.hEk.getPageData() == null || this.hEk.getPageData().acq() != 0;
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

    public int bRu() {
        if (bRh() == null || bRh().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRh().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hBY) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRv() {
        if (bRh() == null || bRh().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRh().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iYC) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bRC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.mD(getResources().getString(R.string.mark_done));
            aVar.dT(true);
            aVar.mE(getResources().getString(R.string.mark_like));
            aVar.dS(true);
            aVar.dM(false);
            aVar.b(getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.48
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).P("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.49
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12528").bT(VideoPlayActivityConfig.OBJ_ID, metaData.getUserId()).P("obj_locate", 1));
                    aVar2.dismiss();
                    PbActivity.this.bSl.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hEk.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).afG();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hEo.bUD();
        this.hEk.op(z);
        if (this.hEm != null) {
            this.hEm.ds(z);
            if (markData != null) {
                this.hEm.a(markData);
            }
        }
        if (this.hEk.ZC()) {
            bRA();
        } else {
            this.hEo.m(this.hEk.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xd(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba(String str) {
        this.hEl.By(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hEk.bSO()) {
                    antiData.setBlock_forum_name(this.hEk.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hEk.getPbData().getForum().getId());
                    antiData.setUser_name(this.hEk.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hEk.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bRh() != null) {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.51
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTa));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTa));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTa));
            }
        } else if (i == 230277) {
            qf(str);
        } else {
            this.hEo.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jbj) ? bVar.jbj : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mE(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.53
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.dM(true);
                aVar.b(getPageContext());
                aVar.afG();
            } else {
                this.hEo.a(0, bVar.FN, bVar.jbj, z);
            }
            if (bVar.FN) {
                if (bVar.eVt == 1) {
                    ArrayList<PostData> bPN = this.hEk.getPbData().bPN();
                    int size = bPN.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bPN.get(i).getId())) {
                            i++;
                        } else {
                            bPN.remove(i);
                            break;
                        }
                    }
                    this.hEk.getPbData().bPL().hc(this.hEk.getPbData().bPL().adm() - 1);
                    this.hEo.m(this.hEk.getPbData());
                } else if (bVar.eVt == 0) {
                    bRw();
                } else if (bVar.eVt == 2) {
                    ArrayList<PostData> bPN2 = this.hEk.getPbData().bPN();
                    int size2 = bPN2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bPN2.get(i2).cmt().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bPN2.get(i2).cmt().get(i3).getId())) {
                                i3++;
                            } else {
                                bPN2.get(i2).cmt().remove(i3);
                                bPN2.get(i2).cmv();
                                z2 = true;
                                break;
                            }
                        }
                        bPN2.get(i2).DU(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hEo.m(this.hEk.getPbData());
                    }
                    a(bVar, this.hEo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hEo.a(this.eyy.getLoadDataMode(), gVar.FN, gVar.jbj, false);
            if (gVar.FN) {
                this.hEq = true;
                if (i == 2 || i == 3) {
                    this.hEr = true;
                    this.hEs = false;
                } else if (i == 4 || i == 5) {
                    this.hEr = false;
                    this.hEs = true;
                }
                if (i == 2) {
                    this.hEk.getPbData().bPL().hf(1);
                    this.hEk.setIsGood(1);
                } else if (i == 3) {
                    this.hEk.getPbData().bPL().hf(0);
                    this.hEk.setIsGood(0);
                } else if (i == 4) {
                    this.hEk.getPbData().bPL().he(1);
                    this.hEk.pE(1);
                } else if (i == 5) {
                    this.hEk.getPbData().bPL().he(0);
                    this.hEk.pE(0);
                }
                this.hEo.d(this.hEk.getPbData(), this.hEk.bSJ());
            }
        }
    }

    private void bRw() {
        if (this.hEk.bSK() || this.hEk.bSM()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hEk.bSI());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hEk.bSI()));
        if (bRB()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bPU;
        boolean z = false;
        if (this.hEo != null) {
            this.hEo.bUS();
        }
        if (this.hEk != null && this.hEk.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hEk.getPbData().bPL().getId();
            if (this.hEk.isShareThread() && this.hEk.getPbData().bPL().bKP != null) {
                historyMessage.threadName = this.hEk.getPbData().bPL().bKP.showText;
            } else {
                historyMessage.threadName = this.hEk.getPbData().bPL().getTitle();
            }
            if (this.hEk.isShareThread() && !bQH()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hEk.getPbData().getForum().getName();
            }
            ArrayList<PostData> bPN = this.hEk.getPbData().bPN();
            int bUF = this.hEo != null ? this.hEo.bUF() : 0;
            if (bPN != null && bUF >= 0 && bUF < bPN.size()) {
                historyMessage.postID = bPN.get(bUF).getId();
            }
            historyMessage.isHostOnly = this.hEk.getHostMode();
            historyMessage.isSquence = this.hEk.bSJ();
            historyMessage.isShareThread = this.hEk.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hED != null) {
            this.hED.onDestroy();
        }
        if (this.hDS && bRh() != null) {
            bRh().bVl();
        }
        if (this.hEk != null && (this.hEk.bSK() || this.hEk.bSM())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hEk.bSI());
            if (this.hEq) {
                if (this.hEs) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hEk.bdn());
                }
                if (this.hEr) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hEk.getIsGood());
                }
            }
            if (this.hEk.getPbData() != null && System.currentTimeMillis() - this.hDV >= 40000 && (bPU = this.hEk.getPbData().bPU()) != null && !com.baidu.tbadk.core.util.v.aa(bPU.getDataList())) {
                intent.putExtra("guess_like_data", bPU);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hER);
            }
            setResult(-1, intent);
        }
        if (bRB()) {
            if (this.hEk != null && this.hEo != null && this.hEo.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bPR() && !this.hEb && pbData.hBG == null) {
                        aj bTR = aj.bTR();
                        com.baidu.tieba.pb.data.d bSQ = this.hEk.bSQ();
                        Parcelable onSaveInstanceState = this.hEo.getListView().onSaveInstanceState();
                        boolean bSJ = this.hEk.bSJ();
                        boolean hostMode = this.hEk.getHostMode();
                        if (this.hEo.bUo() != null && this.hEo.bUo().getVisibility() == 0) {
                            z = true;
                        }
                        bTR.a(bSQ, onSaveInstanceState, bSJ, hostMode, z);
                        if (this.hEQ >= 0 || this.hEk.bTs() != null) {
                            aj.bTR().l(this.hEk.bTs());
                            aj.bTR().k(this.hEk.bTt());
                            aj.bTR().xy(this.hEk.bTu());
                        }
                    }
                }
            } else {
                aj.bTR().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hEo == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hEo.xD(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xg(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    private void d(int i, Intent intent) {
        if (i == 0) {
            this.hEo.bUd();
            this.hEo.bUf().bSv();
            this.hEo.oJ(false);
        }
        this.hEo.bUg();
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
                        this.hED.resetData();
                        this.hED.b(writeData);
                        this.hED.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kj = this.hED.aqS().kj(6);
                        if (kj != null && kj.cqE != null) {
                            kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hED.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hEo.bUf() != null && this.hEo.bUf().bSz() != null) {
                            com.baidu.tbadk.editortools.pb.g bSz = this.hEo.bUf().bSz();
                            bSz.b(writeData);
                            bSz.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kj2 = bSz.aqS().kj(6);
                            if (kj2 != null && kj2.cqE != null) {
                                kj2.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bSz.arL();
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
        this.hED.onActivityResult(i, i2, intent);
        if (this.hEf != null) {
            this.hEf.onActivityResult(i, i2, intent);
        }
        if (bRh().bUf() != null) {
            bRh().bUf().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bRz();
                    return;
                case 13008:
                    aj.bTR().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hEk != null) {
                                PbActivity.this.hEk.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.cet().w(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hEk != null) {
                        a(bRy(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ag(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.cet().w(getPageContext());
                        bRq();
                        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (this.fEP != null && shareItem != null && shareItem.linkUrl != null) {
                            this.fEP.a(shareItem.linkUrl, intExtra, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void anI() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.59.1
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
                case 24008:
                    this.hEo.nW(false);
                    if (this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().adP() != null) {
                        this.hEk.getPbData().bPL().adP().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hEG = emotionImageData;
                        if (xf(com.baidu.tbadk.core.util.aj.bSi)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hEo != null && this.hEo.hNg != null) {
                        this.hEo.hNg.TU();
                        this.hEo.hNg.bVN();
                        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null) {
                            this.hEk.getPbData().bPL().ha(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hEg != null) {
                        this.hEo.cB(this.hEg);
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
            if (this.hEf == null) {
                this.hEf = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hEf.b(this.csw);
                this.hEf.c(this.csD);
            }
            this.hEf.a(emotionImageData, bQR(), bQR().getPbData());
        }
    }

    private ShareFromPBMsgData bRy() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ea = this.hEk.getPbData().ea(getPageContext().getPageActivity());
        PostData bUj = this.hEo.bUj();
        String str = "";
        if (bUj != null) {
            str = bUj.getId();
            String el = bUj.el(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(el)) {
                ea[1] = el;
            }
        }
        String adL = this.hEk.getPbData().bPL().adL();
        if (adL != null && adL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ea[1]);
        shareFromPBMsgData.setImageUrl(ea[0]);
        shareFromPBMsgData.setForumName(this.hEk.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hEk.getPbData().bPL().getId());
        shareFromPBMsgData.setTitle(this.hEk.getPbData().bPL().getTitle());
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bRy(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hr(1);
            aVar.aF(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bT = new com.baidu.tbadk.core.util.am("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hEk.getForumId()).bT("tid", PbActivity.this.hEk.bSI());
                        if (PbActivity.this.d(PbActivity.this.hEk.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hEk.getPbData()));
                        }
                        TiebaStatic.log(bT);
                    }
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
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
            aVar.dN(true);
            aVar.b(getPageContext()).afG();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEk.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hr(1);
            aVar.aF(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.62
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    PbActivity.this.HidenSoftKeyPad((InputMethodManager) PbActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(PbActivity.this.getPageContext().getPageActivity(), j, str, j2, "from_share", thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
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
            aVar.dN(true);
            aVar.b(getPageContext()).afG();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEk.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRz() {
        MarkData xv;
        if (this.hEm != null && (xv = this.hEk.xv(this.hEo.bUG())) != null) {
            if (!xv.isApp() || (xv = this.hEk.xv(this.hEo.bUG() + 1)) != null) {
                this.hEo.bUB();
                this.hEm.a(xv);
                if (!this.hEm.ZC()) {
                    this.hEm.ZE();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hEm.ZD();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRA() {
        com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
        this.hEk.op(true);
        if (this.hEm != null) {
            pbData.AV(this.hEm.ZB());
        }
        this.hEo.m(pbData);
    }

    private boolean bRB() {
        if (this.hEk == null) {
            return true;
        }
        if (this.hEk.ZC()) {
            final MarkData bTa = this.hEk.bTa();
            if (bTa == null || !this.hEk.getIsFromMark()) {
                return true;
            }
            final MarkData xv = this.hEk.xv(this.hEo.bUF());
            if (xv == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bTa);
                setResult(-1, intent);
                return true;
            } else if (xv.getPostId() == null || xv.getPostId().equals(bTa.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bTa);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mE(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hEm != null) {
                            if (PbActivity.this.hEm.ZC()) {
                                PbActivity.this.hEm.ZD();
                                PbActivity.this.hEm.ds(false);
                            }
                            PbActivity.this.hEm.a(xv);
                            PbActivity.this.hEm.ds(true);
                            PbActivity.this.hEm.ZE();
                        }
                        bTa.setPostId(xv.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTa);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRx();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTa);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRx();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hEo != null && PbActivity.this.hEo.getView() != null) {
                            PbActivity.this.hEo.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bTa);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bRx();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.afG();
                return false;
            }
        } else if (this.hEk.getPbData() == null || this.hEk.getPbData().bPN() == null || this.hEk.getPbData().bPN().size() <= 0 || !this.hEk.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hEo == null) {
            return null;
        }
        return this.hEo.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayg() {
        if (this.hEo == null) {
            return 0;
        }
        return this.hEo.bUQ();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ayh() {
        if (this.cID == null) {
            this.cID = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.adp.lib.e.c
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(PbActivity.this.getPageContext().getPageActivity());
                    boolean abf = com.baidu.tbadk.core.i.abb().abf();
                    foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(R.color.common_color_10220));
                    if (abf) {
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
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.abb().abf()) {
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
        return this.cID;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> ayi() {
        if (this.cLs == null) {
            this.cLs = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLs;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayj() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRW */
                public GifView makeObject() {
                    GifView gifView = new GifView(PbActivity.this.getPageContext().getPageActivity());
                    boolean abf = com.baidu.tbadk.core.i.abb().abf();
                    gifView.setDefaultBg(com.baidu.tbadk.core.util.al.getDrawable(R.color.common_color_10220));
                    if (abf) {
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
                    if (com.baidu.tbadk.core.i.abb().abf()) {
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
                    gifView.asm();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.cIE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ayk() {
        if (this.cLt == null) {
            this.cLt = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRX */
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
                    ((PlayVoiceBntNew) view).cnF();
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
        return this.cLt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> aym() {
        this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRY */
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
        return this.cLv;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ajZ() {
        if (this.cbP == null) {
            this.cbP = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cbP;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hDZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.Bq(str) && this.hEk != null && this.hEk.bSI() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").P("obj_param1", 1).bT("post_id", this.hEk.bSI()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cpF = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bVw().c(getPageContext(), str);
        }
        this.hDZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        av.bVw().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hDZ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Rect rect) {
        if (rect != null && this.hEo != null && this.hEo.bVg() != null && rect.top <= this.hEo.bVg().getHeight()) {
            rect.top += this.hEo.bVg().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
            TbRichText bd = bd(str, i);
            if (bd != null && (tbRichTextData = bd.axz().get(this.hFw)) != null) {
                cVar.hGj = new ArrayList<>();
                cVar.hGk = new ConcurrentHashMap<>();
                if (!tbRichTextData.axG().axS()) {
                    cVar.hGm = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hGj.add(b2);
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
                    imageUrlData.postId = bd.getPostId();
                    imageUrlData.mIsReserver = this.hEk.bSY();
                    imageUrlData.mIsSeeHost = this.hEk.getHostMode();
                    cVar.hGk.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bPL() != null) {
                            cVar.threadId = pbData.bPL().getId();
                        }
                        cVar.hGl = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.hGm = true;
                int size = pbData.bPN().size();
                this.hFx = false;
                cVar.index = -1;
                if (pbData.bPS() != null) {
                    PostData bPS = pbData.bPS();
                    TbRichText cmy = bPS.cmy();
                    if (!ap.m(bPS)) {
                        i2 = a(cmy, bd, i, i, cVar.hGj, cVar.hGk);
                    } else {
                        i2 = a(bPS, i, cVar.hGj, cVar.hGk);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bPN().get(i4);
                    if (postData.getId() == null || pbData.bPS() == null || pbData.bPS().getId() == null || !postData.getId().equals(pbData.bPS().getId())) {
                        TbRichText cmy2 = postData.cmy();
                        if (!ap.m(postData)) {
                            i3 = a(cmy2, bd, i3, i, cVar.hGj, cVar.hGk);
                        } else {
                            i3 = a(postData, i3, cVar.hGj, cVar.hGk);
                        }
                    }
                }
                if (cVar.hGj.size() > 0) {
                    cVar.lastId = cVar.hGj.get(cVar.hGj.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bPL() != null) {
                        cVar.threadId = pbData.bPL().getId();
                    }
                    cVar.hGl = pbData.getIsNewUrl() == 1;
                }
                cVar.index = i3;
            }
        }
    }

    private String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axG() == null) {
            return null;
        }
        return tbRichTextData.axG().axX();
    }

    private long d(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axG() == null) {
            return 0L;
        }
        return tbRichTextData.axG().getOriginalSize();
    }

    private boolean e(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axG() == null) {
            return false;
        }
        return tbRichTextData.axG().axY();
    }

    private boolean f(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.axG() == null) {
            return false;
        }
        return tbRichTextData.axG().axZ();
    }

    private int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo axG;
        String str;
        if (tbRichText == tbRichText2) {
            this.hFx = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.axz().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                TbRichTextData tbRichTextData = tbRichText.axz().get(i6);
                if (tbRichTextData != null && tbRichTextData.getType() == 20) {
                    i3 = i5;
                    i4 = i7;
                } else if (tbRichTextData == null || tbRichTextData.getType() != 8) {
                    i3 = i5;
                    i4 = i7;
                } else {
                    int i8 = i5 + 1;
                    int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.axG().getWidth() * ai;
                    int height = ai * tbRichTextData.axG().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichTextData.axG().axS()) {
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
                            if (tbRichTextData != null && (axG = tbRichTextData.axG()) != null) {
                                String axU = axG.axU();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    str = axG.axV();
                                } else {
                                    imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                    str = axU;
                                }
                                imageUrlData.imageUrl = str;
                                imageUrlData.originalUrl = c(tbRichTextData);
                                imageUrlData.originalSize = d(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = e(tbRichTextData);
                                imageUrlData.isLongPic = f(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEk.bSI(), -1L);
                                imageUrlData.mIsReserver = this.hEk.bSY();
                                imageUrlData.mIsSeeHost = this.hEk.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hFx) {
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
        com.baidu.tieba.tbadkCore.data.i cmF;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cmb;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cmb = (cmF = postData.cmF()).cmb()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cmb.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cmb.get(i3);
                if (kVar != null) {
                    String cmf = kVar.cmf();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cmf)) {
                        arrayList.add(cmf);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cmf;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cme();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEk.bSI(), -1L);
                        imageUrlData.mIsReserver = this.hEk.bSY();
                        imageUrlData.mIsSeeHost = this.hEk.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cmF.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cmf, imageUrlData);
                        }
                        if (!this.hFx) {
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
            if (postData.getId() != null && postData.getId().equals(this.hEk.adE())) {
                z = true;
            }
            MarkData j = this.hEk.j(postData);
            if (j != null) {
                this.hEo.bUB();
                if (this.hEm != null) {
                    this.hEm.a(j);
                    if (!z) {
                        this.hEm.ZE();
                    } else {
                        this.hEm.ZD();
                    }
                }
            }
        }
    }

    public boolean cu(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bd(String str, int i) {
        TbRichText tbRichText = null;
        if (this.hEk == null || this.hEk.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
        if (pbData.bPS() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bPS());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bPN = pbData.bPN();
            a(pbData, bPN);
            return a(bPN, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bPW() != null && dVar.bPW().hCn != null && (list = dVar.bPW().hCn) != null && arrayList != null) {
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

    private long Bb(String str) {
        ArrayList<PostData> bPN;
        com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
        if (pbData != null && (bPN = pbData.bPN()) != null && !bPN.isEmpty()) {
            Iterator<PostData> it = bPN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cmF = next.cmF();
                if (cmF != null && cmF.iYj) {
                    Iterator<TbRichTextData> it2 = next.cmy().axz().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.axP().getLink().equals(str)) {
                            return cmF.getTemplateId();
                        }
                    }
                    continue;
                }
            }
        }
        return 0L;
    }

    private TbRichText a(ArrayList<PostData> arrayList, String str, int i) {
        ArrayList<TbRichTextData> axz;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TbRichText cmy = arrayList.get(i2).cmy();
            if (cmy != null && (axz = cmy.axz()) != null) {
                int size = axz.size();
                int i3 = -1;
                int i4 = 0;
                while (i4 < size) {
                    if (axz.get(i4) != null && axz.get(i4).getType() == 8) {
                        i3++;
                        if (axz.get(i4).axG().axU().equals(str) || axz.get(i4).axG().axV().equals(str)) {
                            int ai = (int) com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
                            int width = axz.get(i4).axG().getWidth() * ai;
                            int height = axz.get(i4).axG().getHeight() * ai;
                            if (width < 80 || height < 80 || height * width < 10000) {
                                return null;
                            }
                            this.hFw = i4;
                            return cmy;
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
    public void n(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.hDJ = str;
            if (this.hDU == null) {
                bRl();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hDU.hw(1).setVisibility(8);
            } else {
                this.hDU.hw(1).setVisibility(0);
            }
            this.hDU.afJ();
            this.hDZ = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRC() {
        hideNetRefreshView(this.hEo.getView());
        bRD();
        if (this.hEk.atv()) {
            this.hEo.bUB();
        }
    }

    private void bRD() {
        showLoadingView(this.hEo.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View asC = getLoadingView().asC();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) asC.getLayoutParams();
        layoutParams.addRule(3, this.hEo.bVg().getId());
        asC.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkh() {
        if (this.foP != null) {
            this.foP.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004020, Integer.valueOf(i)));
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
    public void xi(int i) {
        boolean z;
        String str;
        Uri parse;
        String str2;
        bg bPL;
        if (this.hEk.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hEk.getPbData();
            pbData.getForum().getName();
            String title = pbData.bPL().getTitle();
            int i2 = this.hEk.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Dq(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hEk.bSI() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ea = pbData.ea(getPageContext().getPageActivity());
                    str = ea[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ea[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bRp() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").bT("fid", pbData.getForumId()).bT("tid", pbData.getThreadId()).bT("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.cjm = true;
                    eVar.cjt = z;
                    eVar.extData = this.hEk.bSI();
                    eVar.cjF = 3;
                    eVar.cjE = i;
                    eVar.fid = this.hEk.getForumId();
                    eVar.tid = this.hEk.bSI();
                    eVar.cjJ = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bPL = this.hEk.getPbData().bPL();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPL);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bPL != null) {
                        eVar.cjT = bPL.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.cjF);
                    bundle.putInt("obj_type", eVar.cjJ);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bQj() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hEo.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hEk.bSI() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ea2 = pbData.ea(getPageContext().getPageActivity());
            str = ea2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ea2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bRp() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cjm = true;
            eVar2.cjt = z;
            eVar2.extData = this.hEk.bSI();
            eVar2.cjF = 3;
            eVar2.cjE = i;
            eVar2.fid = this.hEk.getForumId();
            eVar2.tid = this.hEk.bSI();
            eVar2.cjJ = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bPL = this.hEk.getPbData().bPL();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPL);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bPL != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cjF);
            bundle2.putInt("obj_type", eVar2.cjJ);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hEk != null && PbActivity.this.hEk.getPbData() != null && PbActivity.this.hEk.getPbData().bQj() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hEo.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPL() != null) {
            if (dVar.bPL().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPL().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Dr(PbActivity.this.hEk.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hEo.bVm();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ayl() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRZ */
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
        return this.cLu;
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

    public void bki() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        a(aVar, (JSONArray) null);
    }

    public AntiData biZ() {
        if (this.hEk == null || this.hEk.getPbData() == null) {
            return null;
        }
        return this.hEk.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.afI() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.afI();
            int intValue = ((Integer) sparseArray.get(aq.hOZ)).intValue();
            if (intValue == aq.hPa) {
                if (!this.eyy.cnh()) {
                    this.hEo.bUy();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eyy.Ea(com.baidu.tbadk.core.util.ap.y(jSONArray));
                    }
                    this.eyy.a(this.hEk.getPbData().getForum().getId(), this.hEk.getPbData().getForum().getName(), this.hEk.getPbData().bPL().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hPb || intValue == aq.hPd) {
                if (this.hEk.bTj() != null) {
                    this.hEk.bTj().xl(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hPb) {
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hEL);
        userMuteAddAndDelCustomMessage.setTag(this.hEL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Bc(String str) {
        if (!StringUtils.isNull(str) && bc.cE(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void ob(boolean z) {
        this.hEx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRF() {
        ArrayList<PostData> bPN;
        int Z;
        if (this.hEk == null || this.hEk.getPbData() == null || this.hEk.getPbData().bPN() == null || (Z = com.baidu.tbadk.core.util.v.Z((bPN = this.hEk.getPbData().bPN()))) == 0) {
            return "";
        }
        if (this.hEk.bSY()) {
            Iterator<PostData> it = bPN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cmw() == 1) {
                    return next.getId();
                }
            }
        }
        int bUF = this.hEo.bUF();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bPN, bUF);
        if (postData == null || postData.adv() == null) {
            return "";
        }
        if (this.hEk.Bg(postData.adv().getUserId())) {
            return postData.getId();
        }
        for (int i = bUF - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bPN, i);
            if (postData2 == null || postData2.adv() == null || postData2.adv().getUserId() == null) {
                break;
            } else if (this.hEk.Bg(postData2.adv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bUF + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bPN, i2);
            if (postData3 == null || postData3.adv() == null || postData3.adv().getUserId() == null) {
                return "";
            }
            if (this.hEk.Bg(postData3.adv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.aiz().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(Bb(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hEk.getPbData().getForum().getId(), this.hEk.getPbData().getForum().getName(), this.hEk.getPbData().bPL().getTid());
            }
            this.hDZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.mE(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.mE(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hEk.bTi() != null) {
                    PbActivity.this.hEk.bTi().eb(j);
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
        aVar.dN(false);
        aVar.b(getPageContext());
        aVar.afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Bd(String str) {
        String str2;
        if (this.hEk.getPbData() == null || this.hEk.getPbData().bPN() == null || this.hEk.getPbData().bPN().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hEk.getPbData().bPN().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hEk.getPbData().bPN().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hEk.getPbData().bPN().get(i);
        if (postData.cmy() == null || postData.cmy().axz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cmy().axz().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                if (next.axG() != null) {
                    str2 = next.axG().axU();
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
        if (this.hDQ) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hDQ = false;
        } else if (bRG()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hDQ) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hDQ = false;
        } else if (bRG()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a005";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.hEk != null) {
            if (this.hEk.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hEk.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hEk.bSI(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bRG() {
        return (!this.hDO && this.hFE == -1 && this.hFF == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hFH = oVar;
            this.hDO = true;
            this.hEo.bUp();
            this.hEo.Bo(this.hFG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        if (this.hFH != null) {
            if (this.hFE == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFH.getCartoonId(), this.hFE, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        if (this.hFH != null) {
            if (this.hFF == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFH.getCartoonId(), this.hFF, 0)));
                finish();
            }
        }
    }

    public int bRJ() {
        return this.hFE;
    }

    public int bRK() {
        return this.hFF;
    }

    private void bvB() {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bRL() {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bRM() {
        if (this.hDR) {
            this.hEe = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().adb() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hEk.getPbData().bPL().adb().getThreadId(), this.hEk.getPbData().bPL().adb().getTaskId(), this.hEk.getPbData().bPL().adb().getForumId(), this.hEk.getPbData().bPL().adb().getForumName(), this.hEk.getPbData().bPL().adq(), this.hEk.getPbData().bPL().adr())));
            this.hDQ = true;
            finish();
        }
    }

    public String bRN() {
        return this.hEc;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bRO() {
        return this.hEj;
    }

    public void oc(boolean z) {
        this.hEd = z;
    }

    public boolean bRP() {
        if (this.hEk != null) {
            return this.hEk.bSK();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mE(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hEJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hEJ.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.91
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.hEJ).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hEJ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEJ.getPageActivity());
            aVar.mE(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hEJ).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hEo.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEJ.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.mE(this.hEJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mE(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hEo.showLoadingDialog();
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
        aVar.b(this.hEJ).afG();
    }

    public void bRR() {
        if (this.hEk != null && this.hEk.getPbData() != null && this.hEk.getPbData().bPL() != null && this.hEk.getPbData().bPL().aeF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ho(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hEk.getPbData().bPL().aeF().channelId, true, PbActivity.this.getUniqueId())));
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
            aVar.afG();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.c.class);
            for (int i = 0; i < objArr.length; i++) {
                if (av.Bq(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.fOh) {
            this.fOh = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hEo != null) {
                this.hEo.onConfigurationChanged(configuration);
            }
            if (this.hEu != null) {
                this.hEu.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bRS() {
        if (this.hEk != null) {
            return this.hEk.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hEk.getPbData().bPW().hCn;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cmt().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cmt().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cmt().remove(i2);
                    list.get(i).cmv();
                    z = true;
                    break;
                }
            }
            list.get(i).DU(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hEk.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bQu().getId();
        List<PostData> list = this.hEk.getPbData().bPW().hCn;
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
                ArrayList<PostData> bQy = kVar.bQy();
                postData.Ax(kVar.getTotalCount());
                if (postData.cmt() != null) {
                    postData.cmt().clear();
                    postData.cmt().addAll(bQy);
                }
            }
        }
        if (!this.hEk.getIsFromMark()) {
            this.hEo.m(this.hEk.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bQG() {
        return this.hEp;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQH() {
        if (this.hEk == null) {
            return false;
        }
        return this.hEk.bQH();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQI() {
        if (this.hEk != null) {
            return this.hEk.bQI();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQJ() {
        if (this.hEk == null || this.hEk.getPbData() == null) {
            return 0;
        }
        return this.hEk.getPbData().bPX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AX(String str) {
        return this.hEk != null && this.hEk.Bg(str);
    }

    public void bRT() {
        if (this.hEo != null) {
            this.hEo.bUd();
            bki();
        }
    }

    public PostData bPS() {
        return this.hEo.c(this.hEk.hJK, this.hEk.bSJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int au(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.isLinkThread()) {
                return 3;
            }
            if (bgVar.aeH()) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hES != null && !this.hES.isEmpty()) {
            int size = this.hES.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hES.get(i).onBackPressed()) {
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
            if (this.hES == null) {
                this.hES = new ArrayList();
            }
            if (!this.hES.contains(aVar)) {
                this.hES.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hES == null) {
                this.hES = new ArrayList();
            }
            if (!this.hES.contains(aVar)) {
                this.hES.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hES != null) {
            this.hES.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRU() {
        if (this.hEk != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hEk.bSI())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hEk.bSI(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hEk == null || com.baidu.tbadk.core.util.ap.isEmpty(this.hEk.bSI())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hEk.bSI(), 0L);
    }
}
