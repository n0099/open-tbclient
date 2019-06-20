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
    private com.baidu.adp.lib.e.b<ImageView> cIE;
    private com.baidu.adp.lib.e.b<GifView> cIF;
    private com.baidu.adp.lib.e.b<TextView> cLt;
    private com.baidu.adp.lib.e.b<View> cLu;
    private com.baidu.adp.lib.e.b<LinearLayout> cLv;
    private com.baidu.adp.lib.e.b<RelativeLayout> cLw;
    private com.baidu.adp.lib.e.b<TbImageView> cbQ;
    private com.baidu.tieba.f.b dWj;
    private au fQE;
    private VoiceManager foP;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    public com.baidu.tbadk.core.util.aj gPO;
    private String hDK;
    private com.baidu.tieba.pb.pb.main.b.b hDQ;
    private com.baidu.tieba.tbadkCore.data.f hEC;
    private com.baidu.tbadk.editortools.pb.f hED;
    private com.baidu.tbadk.editortools.pb.d hEE;
    private com.baidu.tieba.frs.profession.permission.c hEG;
    private EmotionImageData hEH;
    private com.baidu.adp.base.e hEK;
    private com.baidu.tbadk.core.view.e hEL;
    private BdUniqueId hEM;
    private Runnable hEN;
    private com.baidu.adp.widget.ImageView.a hEO;
    private String hEP;
    private TbRichTextMemeInfo hEQ;
    private List<a> hET;
    private com.baidu.tieba.pb.pb.main.emotion.model.a hEg;
    private View hEh;
    int hEj;
    private com.baidu.tieba.pb.pb.report.a hEm;
    public as hEu;
    private com.baidu.tbadk.core.dialog.i hEv;
    private com.baidu.tbadk.core.dialog.k hEw;
    private boolean hEy;
    private String hFH;
    private com.baidu.tbadk.core.data.o hFI;
    private boolean hFw;
    private Object mExtra;
    private boolean mIsFromCDN;
    private boolean mIsLoading;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private String mStType;
    private static final AntiHelper.a mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.24
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTd));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTd));
        }
    };
    private static final b.a hFC = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.85
        @Override // com.baidu.tieba.f.b.a
        public void iY(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.bQG();
            } else {
                com.baidu.tieba.pb.a.b.bQF();
            }
        }
    };
    private boolean hDP = false;
    private boolean hDR = false;
    private boolean hDS = false;
    private boolean hhn = false;
    private boolean hDT = true;
    private int hDU = 0;
    private com.baidu.tbadk.core.dialog.b hDV = null;
    private long eSm = -1;
    private long cyF = 0;
    private long hDW = 0;
    private long createTime = 0;
    private long cyx = 0;
    private boolean hDX = false;
    private com.baidu.tbadk.p.b hDY = null;
    private long hDZ = 0;
    private boolean hEa = false;
    private long hEb = 0;
    private int fOj = 1;
    private String csu = null;
    private boolean hEc = false;
    private boolean isFullScreen = false;
    private String hEd = "";
    private boolean hEe = true;
    private boolean hEf = false;
    private String source = "";
    private int mSkinType = 3;
    int[] hEi = new int[2];
    private PbInterviewStatusView.a hEk = new PbInterviewStatusView.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.1
        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.a
        public void G(boolean z) {
            PbActivity.this.hEp.oD(!PbActivity.this.hEe);
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.13
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.ZC()) {
                        PbActivity.this.bRB();
                        break;
                    }
                    break;
            }
            return false;
        }
    });
    private PbModel hEl = null;
    private com.baidu.tbadk.baseEditMark.a hEn = null;
    private ForumManageModel eyy = null;
    private com.baidu.tbadk.coreExtra.model.a bSm = null;
    private com.baidu.tieba.pb.data.l hEo = null;
    private ShareSuccessReplyToServerModel fEP = null;
    private aq hEp = null;
    public final com.baidu.tieba.pb.pb.main.b.a hEq = new com.baidu.tieba.pb.pb.main.b.a(this);
    private boolean hEr = false;
    private boolean hEs = false;
    private boolean hEt = false;
    private boolean hEx = false;
    private boolean hEz = false;
    private boolean hEA = false;
    private boolean hEB = false;
    private boolean hEF = false;
    public boolean hEI = false;
    private com.baidu.tbadk.editortools.pb.c csx = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.35
        @Override // com.baidu.tbadk.editortools.pb.c
        public void arr() {
            PbActivity.this.showProgressBar();
        }
    };
    private com.baidu.tbadk.editortools.pb.b csy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.46
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEu == null || PbActivity.this.hEu.bVt() == null || !PbActivity.this.hEu.bVt().cwf()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSh);
            }
            PbActivity.this.showToast(PbActivity.this.hEu.bVt().cwh());
            if (PbActivity.this.hEE != null && (PbActivity.this.hEE.arF() || PbActivity.this.hEE.arG())) {
                PbActivity.this.hEE.a(false, PbActivity.this.hEu.bVw());
            }
            PbActivity.this.hEu.oP(true);
            return true;
        }
    };
    private com.baidu.tbadk.editortools.pb.b hEJ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.57
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean arq() {
            if (PbActivity.this.hEu == null || PbActivity.this.hEu.bVu() == null || !PbActivity.this.hEu.bVu().cwf()) {
                return !PbActivity.this.xf(com.baidu.tbadk.core.util.aj.bSi);
            }
            PbActivity.this.showToast(PbActivity.this.hEu.bVu().cwh());
            if (PbActivity.this.hEp != null && PbActivity.this.hEp.bUg() != null && PbActivity.this.hEp.bUg().bSA() != null && PbActivity.this.hEp.bUg().bSA().arG()) {
                PbActivity.this.hEp.bUg().bSA().a(PbActivity.this.hEu.bVw());
            }
            PbActivity.this.hEu.oQ(true);
            return true;
        }
    };
    private int mLastScrollState = 0;
    private boolean fpF = false;
    private int hER = 0;
    private int hES = -1;
    private final a hEU = new a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.68
        @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
        public boolean onBackPressed() {
            if (PbActivity.this.hEp != null && PbActivity.this.hEp.bUg() != null) {
                s bUg = PbActivity.this.hEp.bUg();
                if (bUg.bSy()) {
                    bUg.bSx();
                    return true;
                }
            }
            if (PbActivity.this.hEp != null && PbActivity.this.hEp.bVa()) {
                PbActivity.this.hEp.bVb();
                return true;
            }
            return false;
        }
    };
    private r.a hEV = new r.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.79
    };
    private AddExperiencedModel.a fpR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.86
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
            PbActivity.this.bRF();
        }
    };
    private final z.a hEW = new z.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.2
        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void aj(List<PostData> list) {
        }

        @Override // com.baidu.tieba.pb.pb.main.z.a
        public void l(int i, String str, String str2) {
            if (!StringUtils.isNull(str)) {
                PbActivity.this.hEp.showToast(str);
            }
        }
    };
    private final CustomMessageListener hEX = new CustomMessageListener(2004016) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEl != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (PbActivity.this.hEE != null) {
                    PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                }
                PbActivity.this.hEp.bUh();
                PbActivity.this.hEp.bUT();
            }
        }
    };
    CustomMessageListener fql = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                PbActivity.this.hEl.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                if (PbActivity.this.hEp != null && PbActivity.this.hEl != null) {
                    PbActivity.this.hEp.d(PbActivity.this.hEl.getPbData(), PbActivity.this.hEl.bSK(), PbActivity.this.hEl.getRequestType());
                }
                if (PbActivity.this.hEp != null && PbActivity.this.hEp.bUy() != null) {
                    PbActivity.this.hEp.bUy().notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(2001269) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (PbActivity.this.hEp != null) {
                    if (booleanValue) {
                        PbActivity.this.hEp.bCb();
                    } else {
                        PbActivity.this.hEp.bCa();
                    }
                }
            }
        }
    };
    private CustomMessageListener hEZ = new CustomMessageListener(2004008) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (PbActivity.this.hEE != null) {
                    PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                }
                PbActivity.this.hEp.oK(false);
            }
        }
    };
    private CustomMessageListener hFa = new CustomMessageListener(2004007) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.8
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
    private CustomMessageListener hFb = new CustomMessageListener(2004005) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEp != null && PbActivity.this.hEp.bUy() != null) {
                PbActivity.this.hEp.bUy().notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener gtM = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.10
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
            if (!PbActivity.this.hDS) {
                PbActivity.this.bRV();
            }
        }
    };
    private h.a hFc = new h.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.12
        @Override // com.baidu.tieba.pb.pb.main.h.a
        public void v(int i, long j) {
            boolean z;
            if (i == 0) {
                PbActivity.this.xh(2);
                aj.bTS().reset();
                PbActivity.this.hEl.bTf();
                boolean z2 = false;
                ArrayList<PostData> bPO = PbActivity.this.hEl.getPbData().bPO();
                if (bPO != null) {
                    Iterator<PostData> it = bPO.iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        PostData next = it.next();
                        if (ap.m(next) && next.cmG().getTemplateId() == j) {
                            it.remove();
                            z = true;
                        }
                        z2 = z;
                    }
                    if (z) {
                        PbActivity.this.hEp.m(PbActivity.this.hEl.getPbData());
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
    private View.OnClickListener cti = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivity.this.showToast(PbActivity.this.csu);
        }
    };
    private CustomMessageListener hFd = new CustomMessageListener(2001369) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.aa)) {
                com.baidu.tbadk.core.data.aa aaVar = (com.baidu.tbadk.core.data.aa) customResponsedMessage.getData();
                ao.a aVar = new ao.a();
                aVar.giftId = aaVar.id;
                aVar.giftName = aaVar.name;
                aVar.thumbnailUrl = aaVar.thumbnailUrl;
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                if (pbData != null) {
                    if (PbActivity.this.hEl.bSW() != null && PbActivity.this.hEl.bSW().getUserIdLong() == aaVar.toUserId) {
                        PbActivity.this.hEp.a(aaVar.sendCount, PbActivity.this.hEl.getPbData(), PbActivity.this.hEl.bSK(), PbActivity.this.hEl.getRequestType());
                    }
                    if (pbData.bPO() != null && pbData.bPO().size() >= 1 && pbData.bPO().get(0) != null) {
                        long c2 = com.baidu.adp.lib.g.b.c(pbData.bPO().get(0).getId(), 0L);
                        long c3 = com.baidu.adp.lib.g.b.c(PbActivity.this.hEl.bSJ(), 0L);
                        if (c2 == aaVar.postId && c3 == aaVar.threadId) {
                            com.baidu.tbadk.core.data.ao cmF = pbData.bPO().get(0).cmF();
                            if (cmF == null) {
                                cmF = new com.baidu.tbadk.core.data.ao();
                            }
                            ArrayList<ao.a> acr = cmF.acr();
                            if (acr == null) {
                                acr = new ArrayList<>();
                            }
                            acr.add(0, aVar);
                            cmF.setTotal(aaVar.sendCount + cmF.getTotal());
                            cmF.p(acr);
                            pbData.bPO().get(0).a(cmF);
                            PbActivity.this.hEp.bUy().notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fGa = new CustomMessageListener(2016331) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                PbActivity.this.Ba((String) customResponsedMessage.getData());
                PbActivity.this.hEl.bTc();
                if (PbActivity.this.hEp.bUy() != null) {
                    PbActivity.this.hEp.m(PbActivity.this.hEl.getPbData());
                }
            }
        }
    };
    private SuggestEmotionModel.a hFe = new SuggestEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.17
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
            if (aVar != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, aVar.bVD()));
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private GetSugMatchWordsModel.a hFf = new GetSugMatchWordsModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.18
        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void aj(List<String> list) {
            if (!com.baidu.tbadk.core.util.v.aa(list) && PbActivity.this.hEp != null) {
                PbActivity.this.hEp.dI(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.a
        public void onFail(int i, String str) {
            BdLog.e(str);
        }
    };
    private com.baidu.tieba.pb.pb.main.emotion.a hFg = new com.baidu.tieba.pb.pb.main.emotion.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.19
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
    private boolean hFh = false;
    private PraiseModel hFi = new PraiseModel(getPageContext(), new PraiseModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.20
        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void sl(String str) {
            PbActivity.this.hFh = false;
            if (PbActivity.this.hFi != null) {
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                if (pbData.bPM().adh().getIsLike() == 1) {
                    PbActivity.this.sb(0);
                } else {
                    PbActivity.this.sb(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, pbData.bPM()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.a
        public void onLoadFailed(int i, String str) {
            PbActivity.this.hFh = false;
            if (PbActivity.this.hFi != null && str != null) {
                if (AntiHelper.aG(i, str)) {
                    AntiHelper.aI(PbActivity.this.getPageContext().getPageActivity(), str);
                } else {
                    PbActivity.this.showToast(str);
                }
            }
        }
    });
    private long hFj = 0;
    private boolean hFk = true;
    private b.a hFl = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.21
        @Override // com.baidu.tieba.pb.pb.main.b.b.a
        public void oe(boolean z) {
            PbActivity.this.od(z);
            if (PbActivity.this.hEp.bVg() != null && z) {
                PbActivity.this.hEp.oD(false);
            }
            PbActivity.this.hEp.oF(z);
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().cgA != null) {
                        if (updateAttentionMessage.getOrginalMessage().getTag() == PbActivity.this.getUniqueId() && AntiHelper.a(PbActivity.this.getActivity(), updateAttentionMessage.getData().cgA, PbActivity.mInjectListener) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTd));
                        }
                    } else if (updateAttentionMessage.getData().Hh) {
                        if (PbActivity.this.bPT().adv() != null && PbActivity.this.bPT().adv().getGodUserData() != null) {
                            PbActivity.this.bPT().adv().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                        }
                        if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                            PbActivity.this.hEl.getPbData().bPM().adv().setHadConcerned(updateAttentionMessage.isAttention());
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
            PbActivity.this.hEp.aSG();
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
                    com.baidu.tieba.i.a.bsu();
                } else {
                    if (StringUtils.isNull(str)) {
                        str = PbActivity.this.getResources().getString(R.string.neterror);
                    }
                    PbActivity.this.showToast(str);
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c ckh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.28
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            PbActivity.this.bRl();
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
                    if (PbActivity.this.hEp != null && PbActivity.this.hEp.bRj() && view.getId() == R.id.pb_head_user_info_root) {
                        if (view.getTag(R.id.tag_user_id) instanceof String) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10630").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.tag_user_id)));
                        }
                        if (PbActivity.this.hEq != null && PbActivity.this.hEq.fQX != null) {
                            PbActivity.this.hEq.fQX.onClick(view);
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
            if (PbActivity.this.hEE != null) {
                PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
            }
            PbActivity.this.hEp.bUh();
            PbActivity.this.hEp.bUT();
            return true;
        }
    });
    private CustomMessageListener hFm = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEM) {
                PbActivity.this.hEp.aSG();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.bPZ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEL.i(PbActivity.this.hEK.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = PbActivity.this.hEK.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    PbActivity.this.qe(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    PbActivity.this.bRR();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ap.isEmpty(errorString2)) {
                        errorString2 = PbActivity.this.hEK.getResources().getString(R.string.mute_fail);
                    }
                    PbActivity.this.hEL.j(errorString2);
                }
            }
        }
    };
    private CustomMessageListener hFn = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEM) {
                PbActivity.this.hEp.aSG();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    PbActivity.this.hEL.i(PbActivity.this.hEK.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.ap.isEmpty(muteMessage)) {
                    muteMessage = PbActivity.this.hEK.getResources().getString(R.string.un_mute_fail);
                }
                PbActivity.this.hEL.j(muteMessage);
            }
        }
    };
    private CustomMessageListener hFo = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == PbActivity.this.hEM) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                PbActivity.this.hEp.aSG();
                SparseArray<Object> sparseArray = (SparseArray) PbActivity.this.mExtra;
                DataRes dataRes = aVar.jng;
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
                    PbActivity.this.hEp.a(sparseArray, z);
                }
            }
        }
    };
    public CustomMessageListener hFp = new CustomMessageListener(2004021) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PbActivity.this.hEp.bUi() && (customResponsedMessage.getData() instanceof Integer)) {
                PbActivity.this.bRl();
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
    public a.b hsx = new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.37
        @Override // com.baidu.tbadk.core.dialog.a.b
        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
            PbActivity.this.bki();
            com.baidu.tbadk.core.data.an pageData = PbActivity.this.hEl.getPageData();
            int pageNum = PbActivity.this.hEp.getPageNum();
            if (pageNum <= 0) {
                PbActivity.this.showToast(R.string.pb_page_error);
            } else if (pageData == null || pageNum <= pageData.ack()) {
                PbActivity.this.hEp.bUT();
                PbActivity.this.xh(2);
                PbActivity.this.bkh();
                PbActivity.this.hEp.bUC();
                if (com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.hEl.xp(PbActivity.this.hEp.getPageNum());
                    if (PbActivity.this.hDQ != null) {
                        PbActivity.this.hDQ.showFloatingView();
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
            boolean nZ;
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
                    if (view == PbActivity.this.hEp.getNextView()) {
                        if (!PbActivity.this.mIsLoading) {
                            if (PbActivity.this.hEl.oo(true)) {
                                PbActivity.this.mIsLoading = true;
                                PbActivity.this.hEp.bUD();
                            }
                        } else {
                            return;
                        }
                    } else if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTN()) {
                        if (view == PbActivity.this.hEp.hNh.cAO) {
                            if (PbActivity.this.hEp.oH(PbActivity.this.hEl.bSP())) {
                                PbActivity.this.bkh();
                                return;
                            }
                            PbActivity.this.hDT = false;
                            PbActivity.this.hDR = false;
                            com.baidu.adp.lib.util.l.b(PbActivity.this, PbActivity.this.hEp.hNh.cAO);
                            PbActivity.this.finish();
                        } else if (view != PbActivity.this.hEp.bUA() && (PbActivity.this.hEp.hNh.bVQ() == null || (view != PbActivity.this.hEp.hNh.bVQ().bTM() && view != PbActivity.this.hEp.hNh.bVQ().bTK()))) {
                            if (view == PbActivity.this.hEp.bUW()) {
                                if (PbActivity.this.hEl != null) {
                                    com.baidu.tbadk.browser.a.af(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEl.getPbData().bPM().adu().getLink());
                                }
                            } else if (view != PbActivity.this.hEp.hNh.hSC) {
                                if (view == PbActivity.this.hEp.hNh.hSD) {
                                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                        ArrayList<PostData> bPO = PbActivity.this.hEl.getPbData().bPO();
                                        if ((bPO == null || bPO.size() <= 0) && PbActivity.this.hEl.bSK()) {
                                            com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12378").bT("tid", PbActivity.this.hEl.bSJ()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", PbActivity.this.hEl.getForumId()));
                                        if (!PbActivity.this.hEp.bVl()) {
                                            PbActivity.this.hEp.bUh();
                                        }
                                        PbActivity.this.bRt();
                                    } else {
                                        com.baidu.adp.lib.util.l.showToast(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.getPageContext().getString(R.string.pb_no_data_tips));
                                        return;
                                    }
                                } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                    if (com.baidu.adp.lib.util.j.jS()) {
                                        PbActivity.this.hEp.oi(true);
                                        PbActivity.this.hEp.bUh();
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.mIsLoading = true;
                                            PbActivity.this.hEp.bCb();
                                            PbActivity.this.bkh();
                                            PbActivity.this.hEp.bUC();
                                            PbActivity.this.hEl.Bh(PbActivity.this.bRG());
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
                                    if ((PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTJ()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                        if (PbActivity.this.hEp.hNh.bVQ() != null && view == PbActivity.this.hEp.hNh.bVQ().getCancelView()) {
                                            PbActivity.this.hEp.hNh.TU();
                                        } else if (view.getId() != R.id.pb_editor_tool_share && view.getId() != R.id.share_num_container) {
                                            if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTH()) {
                                                if ((PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTP()) && view.getId() != R.id.pb_sort) {
                                                    if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTI()) {
                                                        if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTQ()) {
                                                            if (PbActivity.this.hEp.bVg() == view) {
                                                                if (PbActivity.this.hEp.bVg().getIndicateStatus()) {
                                                                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                                                                    if (pbData != null && pbData.bPM() != null && pbData.bPM().adb() != null) {
                                                                        String acS = pbData.bPM().adb().acS();
                                                                        if (StringUtils.isNull(acS)) {
                                                                            acS = pbData.bPM().adb().getTaskId();
                                                                        }
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11107").bT(VideoPlayActivityConfig.OBJ_ID, acS));
                                                                    }
                                                                } else {
                                                                    com.baidu.tieba.tbadkCore.d.a.el("c10725", null);
                                                                }
                                                                PbActivity.this.bRN();
                                                            } else if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTO()) {
                                                                if (PbActivity.this.hEp.hNh.bVQ() != null && view == PbActivity.this.hEp.hNh.bVQ().bTL()) {
                                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                                        SparseArray<Object> c2 = PbActivity.this.hEp.c(PbActivity.this.hEl.getPbData(), PbActivity.this.hEl.bSK(), 1);
                                                                        if (c2 != null) {
                                                                            if (StringUtils.isNull((String) c2.get(R.id.tag_del_multi_forum))) {
                                                                                PbActivity.this.hEp.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                            } else {
                                                                                PbActivity.this.hEp.a(((Integer) c2.get(R.id.tag_del_post_type)).intValue(), (String) c2.get(R.id.tag_del_post_id), ((Integer) c2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c2.get(R.id.tag_del_multi_forum));
                                                                            }
                                                                        }
                                                                        PbActivity.this.hEp.hNh.TU();
                                                                    } else {
                                                                        PbActivity.this.showToast(R.string.network_not_available);
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText) {
                                                                    if (PbActivity.this.hEl != null && view.getId() == R.id.new_sub_pb_list_richText) {
                                                                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar.bT("tid", PbActivity.this.hEl.bSJ());
                                                                        amVar.bT("fid", PbActivity.this.hEl.getForumId());
                                                                        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar.P("obj_locate", 4);
                                                                        TiebaStatic.log(amVar);
                                                                    }
                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                        if (PbActivity.this.hEl.getPbData() != null) {
                                                                            PbActivity.this.hEp.bUT();
                                                                            SparseArray sparseArray = (SparseArray) view.getTag();
                                                                            PostData postData = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                                                            View view2 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                                                            if (postData != null && view2 != null) {
                                                                                if (postData.cmJ() == 1) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12630"));
                                                                                }
                                                                                if (postData.iZC != null) {
                                                                                    com.baidu.tbadk.core.util.am aie = postData.iZC.aie();
                                                                                    aie.delete("obj_locate");
                                                                                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                                        aie.P("obj_locate", 6);
                                                                                    } else if (view.getId() == R.id.pb_floor_reply_more) {
                                                                                        aie.P("obj_locate", 8);
                                                                                    }
                                                                                    TiebaStatic.log(aie);
                                                                                }
                                                                                String bSJ = PbActivity.this.hEl.bSJ();
                                                                                String id = postData.getId();
                                                                                int i4 = 0;
                                                                                if (PbActivity.this.hEl.getPbData() != null) {
                                                                                    i4 = PbActivity.this.hEl.getPbData().bPY();
                                                                                }
                                                                                PbActivity.this.bkh();
                                                                                if (view.getId() == R.id.replybtn) {
                                                                                    c Bf = PbActivity.this.Bf(id);
                                                                                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && Bf != null) {
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSJ, id, "pb", true, null, true, null, i4, postData.bWI(), PbActivity.this.hEl.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bf.hGk, Bf.hGl, Bf.hGm, Bf.index);
                                                                                        addBigImageData.setKeyPageStartFrom(PbActivity.this.hEl.bTr());
                                                                                        addBigImageData.setFromFrsForumId(PbActivity.this.hEl.getFromForumId());
                                                                                        PbActivity.this.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log("c11742");
                                                                                    c Bf2 = PbActivity.this.Bf(id);
                                                                                    if (postData != null && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && Bf2 != null) {
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSJ, id, "pb", true, null, false, null, i4, postData.bWI(), PbActivity.this.hEl.getPbData().getAnti(), false, postData.adv().getIconInfo()).addBigImageData(Bf2.hGk, Bf2.hGl, Bf2.hGm, Bf2.index);
                                                                                        addBigImageData2.setKeyPageStartFrom(PbActivity.this.hEl.bTr());
                                                                                        addBigImageData2.setFromFrsForumId(PbActivity.this.hEl.getFromForumId());
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
                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10517").P("obj_locate", 3).bT("fid", PbActivity.this.hEl.getPbData().getForumId()));
                                                                        return;
                                                                    }
                                                                } else if (view.getId() == R.id.pb_post_reply_count) {
                                                                    if (PbActivity.this.hEl != null) {
                                                                        com.baidu.tbadk.core.util.am amVar2 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar2.bT("tid", PbActivity.this.hEl.bSJ());
                                                                        amVar2.bT("fid", PbActivity.this.hEl.getForumId());
                                                                        amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar2.P("obj_locate", 5);
                                                                        TiebaStatic.log(amVar2);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                            if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                                                                    String bSJ2 = PbActivity.this.hEl.bSJ();
                                                                                    String id2 = postData2.getId();
                                                                                    int i5 = 0;
                                                                                    if (PbActivity.this.hEl.getPbData() != null) {
                                                                                        i5 = PbActivity.this.hEl.getPbData().bPY();
                                                                                    }
                                                                                    c Bf3 = PbActivity.this.Bf(id2);
                                                                                    if (Bf3 != null) {
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createSubPbActivityConfig(bSJ2, id2, "pb", true, null, false, null, i5, postData2.bWI(), PbActivity.this.hEl.getPbData().getAnti(), false, postData2.adv().getIconInfo()).addBigImageData(Bf3.hGk, Bf3.hGl, Bf3.hGm, Bf3.index);
                                                                                        addBigImageData3.setKeyPageStartFrom(PbActivity.this.hEl.bTr());
                                                                                        addBigImageData3.setFromFrsForumId(PbActivity.this.hEl.getFromForumId());
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
                                                                    if (PbActivity.this.hEl != null) {
                                                                        com.baidu.tbadk.core.util.am amVar3 = new com.baidu.tbadk.core.util.am("c13398");
                                                                        amVar3.bT("tid", PbActivity.this.hEl.bSJ());
                                                                        amVar3.bT("fid", PbActivity.this.hEl.getForumId());
                                                                        amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        amVar3.P("obj_locate", 6);
                                                                        TiebaStatic.log(amVar3);
                                                                        if (PbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                                                if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.bRi().bUf() != null && postData3.adv() != null && postData3.cmx() != 1) {
                                                                                    if (PbActivity.this.bRi().bUg() != null) {
                                                                                        PbActivity.this.bRi().bUg().bSw();
                                                                                    }
                                                                                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                                                                                    kVar.a(PbActivity.this.hEl.getPbData().getForum());
                                                                                    kVar.ai(PbActivity.this.hEl.getPbData().bPM());
                                                                                    kVar.e(postData3);
                                                                                    PbActivity.this.bRi().bUf().d(kVar);
                                                                                    PbActivity.this.bRi().bUf().setPostId(postData3.getId());
                                                                                    PbActivity.this.a(view, postData3.adv().getUserId(), "");
                                                                                    if (PbActivity.this.hEE != null) {
                                                                                        PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
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
                                                                } else if (view != PbActivity.this.hEp.bRd()) {
                                                                    if (view == PbActivity.this.hEp.hNh.bVR()) {
                                                                        PbActivity.this.hEp.bUJ();
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
                                                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12006").bT("tid", PbActivity.this.hEl.hJp));
                                                                                    }
                                                                                    if (PbActivity.this.hEw == null) {
                                                                                        PbActivity.this.hEw = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                                                                                        PbActivity.this.hEw.a(PbActivity.this.hFB);
                                                                                    }
                                                                                    ArrayList arrayList = new ArrayList();
                                                                                    PbActivity.this.cu(view);
                                                                                    if (!PbActivity.this.cu(view) || PbActivity.this.hEO == null || !PbActivity.this.hEO.isGif()) {
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
                                                                                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEw);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                                                                                        gVar4.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                                                                                        arrayList.add(gVar4);
                                                                                    }
                                                                                    if (postData4 != null) {
                                                                                        if (postData4.cmz() != null && postData4.cmz().toString().length() > 0) {
                                                                                            com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEw);
                                                                                            SparseArray sparseArray5 = new SparseArray();
                                                                                            sparseArray5.put(R.id.tag_clip_board, postData4);
                                                                                            gVar5.mTextView.setTag(sparseArray5);
                                                                                            arrayList.add(gVar5);
                                                                                        }
                                                                                        PbActivity.this.ggP = postData4;
                                                                                    }
                                                                                    if (PbActivity.this.hEl.getPbData().ZC()) {
                                                                                        String ZB = PbActivity.this.hEl.getPbData().ZB();
                                                                                        if (postData4 != null && !com.baidu.adp.lib.util.k.isEmpty(ZB) && ZB.equals(postData4.getId())) {
                                                                                            z2 = true;
                                                                                            if (!z2) {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEw);
                                                                                            } else {
                                                                                                gVar = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEw);
                                                                                            }
                                                                                            SparseArray sparseArray6 = new SparseArray();
                                                                                            sparseArray6.put(R.id.tag_clip_board, PbActivity.this.ggP);
                                                                                            sparseArray6.put(R.id.tag_is_subpb, false);
                                                                                            gVar.mTextView.setTag(sparseArray6);
                                                                                            arrayList.add(gVar);
                                                                                            if (PbActivity.this.mIsLogin) {
                                                                                                if (!z5 && z4) {
                                                                                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEw);
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
                                                                                                    if (!ap.m(PbActivity.this.ggP)) {
                                                                                                        nZ = PbActivity.this.nZ(z3) & PbActivity.this.isLogin();
                                                                                                    } else {
                                                                                                        nZ = false;
                                                                                                    }
                                                                                                    if (nZ) {
                                                                                                        com.baidu.tbadk.core.dialog.g gVar7 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEw);
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
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEw);
                                                                                                        gVar2.mTextView.setTag(sparseArray8);
                                                                                                    } else {
                                                                                                        sparseArray8.put(R.id.tag_should_delete_visible, false);
                                                                                                        gVar2 = null;
                                                                                                    }
                                                                                                    gVar3 = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEw);
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
                                                                                                    if (PbActivity.this.hEl.getPbData().bPY() == 1002 && !z3) {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEw);
                                                                                                    } else {
                                                                                                        gVar2 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEw);
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
                                                                                            PbActivity.this.hEw.W(arrayList);
                                                                                            PbActivity.this.hEv = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEw.afZ());
                                                                                            PbActivity.this.hEv.showDialog();
                                                                                        }
                                                                                    }
                                                                                    z2 = false;
                                                                                    if (!z2) {
                                                                                    }
                                                                                    SparseArray sparseArray62 = new SparseArray();
                                                                                    sparseArray62.put(R.id.tag_clip_board, PbActivity.this.ggP);
                                                                                    sparseArray62.put(R.id.tag_is_subpb, false);
                                                                                    gVar.mTextView.setTag(sparseArray62);
                                                                                    arrayList.add(gVar);
                                                                                    if (PbActivity.this.mIsLogin) {
                                                                                    }
                                                                                    PbActivity.this.hEw.W(arrayList);
                                                                                    PbActivity.this.hEv = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEw.afZ());
                                                                                    PbActivity.this.hEv.showDialog();
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_act_btn) {
                                                                            if (PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().getActUrl() != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), PbActivity.this.hEl.getPbData().bPM().getActUrl());
                                                                                if (PbActivity.this.hEl.getPbData().bPM().aef() != 1) {
                                                                                    if (PbActivity.this.hEl.getPbData().bPM().aef() == 2) {
                                                                                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.lottery_tail) {
                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                String str3 = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10912").bT("fid", PbActivity.this.hEl.getPbData().getForumId()).bT("tid", PbActivity.this.hEl.getPbData().getThreadId()).bT("lotterytail", StringUtils.string(str3, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                if (PbActivity.this.hEl.getPbData().getThreadId().equals(str3)) {
                                                                                    PbActivity.this.hEp.setSelection(0);
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
                                                                                PbActivity.this.hEp.bUh();
                                                                            }
                                                                        } else if (id3 == R.id.join_vote_tv) {
                                                                            if (view != null) {
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                if (PbActivity.this.bRq() == 1 && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10397").bT("fid", PbActivity.this.hEl.getPbData().getForumId()).bT("tid", PbActivity.this.hEl.getPbData().getThreadId()).bT("uid", currentAccount));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.look_all_tv) {
                                                                            if (view != null) {
                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                com.baidu.tbadk.browser.a.af(PbActivity.this.getActivity(), (String) view.getTag());
                                                                                if (PbActivity.this.bRq() == 1 && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10507").bT("fid", PbActivity.this.hEl.getPbData().getForumId()).bT("tid", PbActivity.this.hEl.getPbData().getThreadId()).bT("uid", currentAccount2));
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.manga_prev_btn) {
                                                                            PbActivity.this.bRI();
                                                                        } else if (id3 == R.id.manga_next_btn) {
                                                                            PbActivity.this.bRJ();
                                                                        } else if (id3 == R.id.yule_head_img_img) {
                                                                            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bQf() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData2 = PbActivity.this.hEl.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11679").bT("fid", pbData2.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData2.bQf().bQm()});
                                                                            }
                                                                        } else if (id3 == R.id.yule_head_img_all_rank) {
                                                                            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bQf() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData3 = PbActivity.this.hEl.getPbData();
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", pbData3.getForumId()));
                                                                                ba.aiz().c(PbActivity.this.getPageContext(), new String[]{pbData3.bQf().bQm()});
                                                                            }
                                                                        } else if (PbActivity.this.hEp.hNh.bVQ() != null && view == PbActivity.this.hEp.hNh.bVQ().bTR()) {
                                                                            if (PbActivity.this.hEl == null || PbActivity.this.hEl.getPbData() == null || PbActivity.this.hEl.getPbData().bPM() == null) {
                                                                                PbActivity.this.hEp.hNh.TU();
                                                                                return;
                                                                            } else if (!com.baidu.adp.lib.util.l.ki()) {
                                                                                PbActivity.this.showToast(R.string.neterror);
                                                                                return;
                                                                            } else {
                                                                                int i6 = 1;
                                                                                if (PbActivity.this.hEl.getPbData().bPM().adc() == 0) {
                                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new GodFansCallWebViewActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEl.bSJ(), 25028)));
                                                                                } else {
                                                                                    BdToast.b(PbActivity.this.getPageContext().getContext(), PbActivity.this.getPageContext().getContext().getString(R.string.haved_fans_called)).afO();
                                                                                    i6 = 2;
                                                                                }
                                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12399").P("obj_locate", PbActivity.this.au(PbActivity.this.hEl.getPbData().bPM())).bT("tid", PbActivity.this.hEl.getPbData().bPM().getTid()).P("obj_type", i6));
                                                                            }
                                                                        } else if (id3 == R.id.tv_pb_reply_more) {
                                                                            if (PbActivity.this.hER >= 0) {
                                                                                if (PbActivity.this.hEl != null) {
                                                                                    PbActivity.this.hEl.bTs();
                                                                                }
                                                                                if (PbActivity.this.hEp.bUy() != null) {
                                                                                    PbActivity.this.hEp.bUy().a(PbActivity.this.hEl.getPbData(), false);
                                                                                }
                                                                                PbActivity.this.hEp.getListView().setSelection(PbActivity.this.hEl.bTv());
                                                                                PbActivity.this.hER = 0;
                                                                                if (PbActivity.this.hEl != null) {
                                                                                    PbActivity.this.hEl.cb(0, 0);
                                                                                }
                                                                            }
                                                                        } else if (id3 == R.id.pb_post_recommend_live_layout) {
                                                                            if (view.getTag() instanceof AlaLiveInfoCoreData) {
                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(PbActivity.this.getActivity(), (AlaLiveInfoCoreData) view.getTag(), AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_PB_POST_RECOMMEND, TbadkCoreApplication.getCurrentAccount(), false, "")));
                                                                                TiebaStatic.log("c12640");
                                                                            }
                                                                        } else if (id3 == R.id.thread_info_commont_container) {
                                                                            PbActivity.this.bRn();
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
                                                                            if (PbActivity.this.hEp.getListView() != null && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                                                                int firstVisiblePosition = PbActivity.this.hEp.getListView().getFirstVisiblePosition();
                                                                                View childAt = PbActivity.this.hEp.getListView().getChildAt(0);
                                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                                boolean bQk = PbActivity.this.hEl.getPbData().bQk();
                                                                                boolean z8 = PbActivity.this.hEp.hNb != null && PbActivity.this.hEp.hNb.bWY();
                                                                                boolean bUQ = PbActivity.this.hEp.bUQ();
                                                                                boolean z9 = firstVisiblePosition == 0 && top == 0;
                                                                                int i7 = 0;
                                                                                if (bQk && PbActivity.this.hEp.hNb != null && PbActivity.this.hEp.hNb.aHS() != null) {
                                                                                    int af = ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)) - PbActivity.this.hEp.hNb.bWZ();
                                                                                    z9 = firstVisiblePosition == 0 && (top == af || top == PbActivity.this.hEp.hNb.aHS().getHeight() - PbActivity.this.hEp.hNb.bWZ());
                                                                                    i7 = af;
                                                                                }
                                                                                if ((PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adm() <= 0) || (bUQ && z9)) {
                                                                                    if (PbActivity.this.checkUpIsLogin()) {
                                                                                        PbActivity.this.bRn();
                                                                                        if (PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEl.hJp).bT("fid", PbActivity.this.hEl.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEl.getPbData().bPM().adv().getUserId()));
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    boolean z10 = false;
                                                                                    int ah = (int) (com.baidu.adp.lib.util.l.ah(PbActivity.this) * 0.6d);
                                                                                    if (bQk) {
                                                                                        if (PbActivity.this.hEp.hOW != null && PbActivity.this.hEp.hOW.hQg != null && PbActivity.this.hEp.hOW.hQg.getView() != null) {
                                                                                            if (PbActivity.this.hEp.hOW.hQg.getView().getParent() == null) {
                                                                                                z10 = firstVisiblePosition >= PbActivity.this.bRw();
                                                                                            } else {
                                                                                                int i8 = 0;
                                                                                                if (PbActivity.this.hEp.hNb.aHS() != null) {
                                                                                                    i8 = PbActivity.this.hEp.hNb.aHS().getBottom();
                                                                                                }
                                                                                                z10 = PbActivity.this.hEp.hOW.hQg.getView().getTop() <= i8;
                                                                                            }
                                                                                        }
                                                                                    } else if (PbActivity.this.hEp.bUp() != null) {
                                                                                        z10 = PbActivity.this.hEp.bUp().getVisibility() == 0;
                                                                                        if (!z10 && PbActivity.this.hEp.hOW != null && PbActivity.this.hEp.hOW.hQg != null && PbActivity.this.hEp.hOW.hQg.getView() != null && PbActivity.this.hEp.hOW.hQg.getView().getParent() != null && PbActivity.this.hEp.hNh != null && PbActivity.this.hEp.hNh.mNavigationBar != null) {
                                                                                            z10 = PbActivity.this.hEp.hOW.hQg.getView().getTop() - PbActivity.this.hEp.hNh.mNavigationBar.getBottom() < 10;
                                                                                        }
                                                                                    }
                                                                                    if (!z10 && !bUQ) {
                                                                                        int bRw = PbActivity.this.bRw();
                                                                                        if (PbActivity.this.bRv() != -1) {
                                                                                            bRw--;
                                                                                        }
                                                                                        int g = com.baidu.adp.lib.util.l.g(PbActivity.this, R.dimen.tbds116);
                                                                                        if (bRw < 0) {
                                                                                            i2 = PbActivity.this.hEp.getListView().getHeaderViewsCount() + (com.baidu.tbadk.core.util.v.Z(PbActivity.this.hEp.getListView().getData()) - 1);
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            i2 = bRw;
                                                                                            i3 = g;
                                                                                        }
                                                                                        if (z8) {
                                                                                            i3 += (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                                                                        } else if (!bQk || PbActivity.this.hEp.hNb.aHS() == null) {
                                                                                            if (PbActivity.this.hEp.hNh != null && PbActivity.this.hEp.hNh.mNavigationBar != null) {
                                                                                                i3 += PbActivity.this.hEp.hNh.mNavigationBar.getFixedNavHeight() - 10;
                                                                                            }
                                                                                        } else {
                                                                                            i3 += PbActivity.this.hEp.hNb.aHS().getHeight();
                                                                                        }
                                                                                        if (PbActivity.this.hEp.hOW == null || PbActivity.this.hEp.hOW.hQg == null || PbActivity.this.hEp.hOW.hQg.getView() == null || PbActivity.this.hEp.hOW.hQg.getView().getParent() == null) {
                                                                                            PbActivity.this.hEp.getListView().setSelectionFromTop(i2, i3 + ah);
                                                                                            PbActivity.this.hEp.getListView().smoothScrollBy(ah, 500);
                                                                                        } else if (!z8) {
                                                                                            PbActivity.this.hEp.getListView().smoothScrollToPosition(i2, i3, 200);
                                                                                        } else {
                                                                                            PbActivity.this.hEp.getListView().smoothScrollBy(PbActivity.this.hEp.hOW.hQg.getView().getTop() - ((int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d)), 500);
                                                                                        }
                                                                                    } else if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-ah))) {
                                                                                        PbActivity.this.hEp.getListView().setSelectionFromTop(0, i7 - ah);
                                                                                        PbActivity.this.hEp.getListView().smoothScrollBy(-ah, 500);
                                                                                    } else {
                                                                                        PbActivity.this.hEp.getListView().smoothScrollToPosition(0, i7, 500);
                                                                                    }
                                                                                }
                                                                                if (PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                                                                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEl.hJp).bT("fid", PbActivity.this.hEl.getPbData().getForumId()).P("obj_locate", 2).bT("uid", PbActivity.this.hEl.getPbData().bPM().adv().getUserId()));
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_nav_title_forum_image || id3 == R.id.pb_nav_title_forum_name) {
                                                                            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().getForum() != null && !com.baidu.tbadk.core.util.ap.isEmpty(PbActivity.this.hEl.getPbData().getForum().getName())) {
                                                                                if (PbActivity.this.hEl.bTr() == 3) {
                                                                                    PbActivity.this.finish();
                                                                                } else {
                                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(PbActivity.this.getActivity()).createNormalCfg(PbActivity.this.hEl.getPbData().getForum().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                }
                                                                                com.baidu.tbadk.core.util.am amVar4 = new com.baidu.tbadk.core.util.am("c13401");
                                                                                amVar4.bT("tid", PbActivity.this.hEl.bSJ());
                                                                                amVar4.bT("fid", PbActivity.this.hEl.getForumId());
                                                                                amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                TiebaStatic.log(amVar4);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.forum_name_text) {
                                                                            if (view.getTag() instanceof bg) {
                                                                                bg bgVar = (bg) view.getTag();
                                                                                if (PbActivity.this.hEl.bTr() == 3 && PbActivity.this.bQI() && PbActivity.this.hEl.getPbData() != null && com.baidu.tbadk.core.util.v.aa(PbActivity.this.hEl.getPbData().bQh())) {
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
                                                                            if (PbActivity.this.hEl != null) {
                                                                                com.baidu.tbadk.core.util.am amVar6 = new com.baidu.tbadk.core.util.am("c13398");
                                                                                amVar6.bT("tid", PbActivity.this.hEl.bSJ());
                                                                                amVar6.bT("fid", PbActivity.this.hEl.getForumId());
                                                                                amVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                amVar6.P("obj_locate", 2);
                                                                                TiebaStatic.log(amVar6);
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (id3 == R.id.pb_thread_post_button) {
                                                                            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                                                                com.baidu.tieba.pb.data.d pbData4 = PbActivity.this.hEl.getPbData();
                                                                                if (PbActivity.this.hEo == null) {
                                                                                    PbActivity.this.hEo = new com.baidu.tieba.pb.data.l(PbActivity.this.getPageContext());
                                                                                }
                                                                                long c3 = com.baidu.adp.lib.g.b.c(pbData4.getThreadId(), 0L);
                                                                                long c4 = com.baidu.adp.lib.g.b.c(pbData4.getForumId(), 0L);
                                                                                new com.baidu.tbadk.core.util.am("c13446").l("forum_id", c4).aif();
                                                                                PbActivity.this.registerListener(PbActivity.this.hFr);
                                                                                PbActivity.this.hEo.s(c3, c4);
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
                                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13274").bT("fid", PbActivity.this.hEl.getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "PB_card").bT("tid", PbActivity.this.hEl.bSJ()).P("obj_param1", smartApp.is_game.intValue()));
                                                                        }
                                                                    }
                                                                } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(PbActivity.this.getPageContext().getPageActivity(), 24008, com.baidu.adp.lib.g.b.c(PbActivity.this.hEl.getPbData().getForumId(), 0L), com.baidu.adp.lib.g.b.c(PbActivity.this.hEl.bSJ(), 0L), com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), PbActivity.this.hEl.getPbData().bPM().adP())));
                                                                }
                                                            } else if (com.baidu.adp.lib.util.j.jS()) {
                                                                PbActivity.this.hEp.bUT();
                                                                SparseArray<Object> c5 = PbActivity.this.hEp.c(PbActivity.this.hEl.getPbData(), PbActivity.this.hEl.bSK(), 1);
                                                                if (c5 != null) {
                                                                    PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEl.getPbData().getForum().getId(), PbActivity.this.hEl.getPbData().getForum().getName(), PbActivity.this.hEl.getPbData().bPM().getId(), String.valueOf(PbActivity.this.hEl.getPbData().getUserData().getUserId()), (String) c5.get(R.id.tag_forbid_user_name), (String) c5.get(R.id.tag_forbid_user_name_show), (String) c5.get(R.id.tag_forbid_user_post_id), (String) c5.get(R.id.tag_forbid_user_portrait))));
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
                                                            PbActivity.this.hEp.hNh.bVP();
                                                        }
                                                    } else if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null) {
                                                        PbActivity.this.hEp.hNh.TU();
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13062"));
                                                        PbActivity.this.Bc(PbActivity.this.hEl.getPbData().bPM().adL());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    PbActivity.this.hEp.bUT();
                                                    if (com.baidu.adp.lib.util.j.jS()) {
                                                        if (PbActivity.this.mIsLoading) {
                                                            view.setTag(Integer.valueOf(PbActivity.this.hEl.bTa()));
                                                            return;
                                                        }
                                                        PbActivity.this.xh(2);
                                                        PbActivity.this.bkh();
                                                        PbActivity.this.hEp.bUC();
                                                        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext());
                                                        if (PbActivity.this.hEl.getPbData().hBF == null || PbActivity.this.hEl.getPbData().hBF.size() <= 0) {
                                                            strArr = new String[]{PbActivity.this.getResources().getString(R.string.sort_type_new), PbActivity.this.getResources().getString(R.string.sort_type_old)};
                                                        } else {
                                                            String[] strArr2 = new String[PbActivity.this.hEl.getPbData().hBF.size()];
                                                            int i9 = 0;
                                                            while (true) {
                                                                int i10 = i9;
                                                                if (i10 >= PbActivity.this.hEl.getPbData().hBF.size()) {
                                                                    break;
                                                                }
                                                                strArr2[i10] = PbActivity.this.hEl.getPbData().hBF.get(i10).sort_name + PbActivity.this.getResources().getString(R.string.sort_static);
                                                                i9 = i10 + 1;
                                                            }
                                                            strArr = strArr2;
                                                        }
                                                        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.38.1
                                                            @Override // com.baidu.tbadk.core.dialog.k.c
                                                            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i11, View view3) {
                                                                int i12 = 2;
                                                                iVar.dismiss();
                                                                if (PbActivity.this.hEl.getSortType() == 1 && i11 == 1) {
                                                                    i12 = 0;
                                                                } else if (PbActivity.this.hEl.getSortType() == 2 && i11 == 0) {
                                                                    i12 = 1;
                                                                } else if (PbActivity.this.hEl.getSortType() != 3 || i11 == 2) {
                                                                    i12 = (i11 != 2 || PbActivity.this.hEl.getSortType() == 3) ? 0 : 3;
                                                                }
                                                                TiebaStatic.log("c12097");
                                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12097").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, view.getId() != R.id.pb_sort ? 1 : 0).P("obj_type", i12));
                                                                if (PbActivity.this.hEl.getPbData().hBF != null && PbActivity.this.hEl.getPbData().hBF.size() > i11) {
                                                                    i11 = PbActivity.this.hEl.getPbData().hBF.get(i11).sort_type.intValue();
                                                                }
                                                                boolean xu = PbActivity.this.hEl.xu(i11);
                                                                view.setTag(Integer.valueOf(PbActivity.this.hEl.bTa()));
                                                                if (xu) {
                                                                    PbActivity.this.mIsLoading = true;
                                                                    PbActivity.this.hEp.oz(true);
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
                                                PbActivity.this.hEp.bUT();
                                                if (PbActivity.this.bQS().getPbData().hBG != 2) {
                                                    if (PbActivity.this.hEl.getPageData() != null) {
                                                        PbActivity.this.hEp.a(PbActivity.this.hEl.getPageData(), PbActivity.this.hsx);
                                                    }
                                                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                } else {
                                                    PbActivity.this.showToast(R.string.hot_sort_jump_hint);
                                                    return;
                                                }
                                            }
                                        } else if (bf.iE() || PbActivity.this.checkUpIsLogin()) {
                                            if (PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                                                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEl.hJp).bT("fid", PbActivity.this.hEl.getPbData().getForumId()).P("obj_locate", 4).bT("uid", PbActivity.this.hEl.getPbData().bPM().adv().getUserId()));
                                            }
                                            if (PbActivity.this.hEl != null) {
                                                com.baidu.tbadk.core.util.am amVar7 = new com.baidu.tbadk.core.util.am("c12386");
                                                amVar7.bT("tid", PbActivity.this.hEl.bSJ());
                                                amVar7.bT("uid", TbadkCoreApplication.getCurrentAccount());
                                                amVar7.bT("fid", PbActivity.this.hEl.getForumId());
                                                amVar7.P("obj_locate", 6);
                                                if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    amVar7.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                                }
                                                TiebaStatic.log(amVar7);
                                            }
                                            if (com.baidu.adp.lib.util.l.ki()) {
                                                if (PbActivity.this.hEl.getPbData() != null) {
                                                    ArrayList<PostData> bPO2 = PbActivity.this.hEl.getPbData().bPO();
                                                    if ((bPO2 != null && bPO2.size() > 0) || !PbActivity.this.hEl.bSK()) {
                                                        PbActivity.this.hEp.bUT();
                                                        PbActivity.this.bkh();
                                                        PbActivity.this.xh(2);
                                                        if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bQf() != null && !StringUtils.isNull(PbActivity.this.hEl.getPbData().bQf().abS(), true)) {
                                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11678").bT("fid", PbActivity.this.hEl.getPbData().getForumId()));
                                                        }
                                                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11939"));
                                                        if (bf.iE()) {
                                                            PbActivity.this.xi(2);
                                                        } else {
                                                            PbActivity.this.hEp.showLoadingDialog();
                                                            PbActivity.this.hEl.bTm().p(CheckRealNameModel.TYPE_PB_SHARE, 2);
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
                                        PbActivity.this.hEp.bUT();
                                        if (PbActivity.this.hEp.hNh.bVQ() != null && view == PbActivity.this.hEp.hNh.bVQ().bTJ() && !PbActivity.this.hEp.bVl()) {
                                            PbActivity.this.hEp.bUh();
                                        }
                                        if (!PbActivity.this.mIsLoading) {
                                            PbActivity.this.bkh();
                                            PbActivity.this.hEp.bUC();
                                            if (view.getId() == R.id.floor_owner_reply) {
                                                t = PbActivity.this.hEl.t(true, PbActivity.this.bRG());
                                            } else {
                                                t = view.getId() == R.id.reply_title ? PbActivity.this.hEl.t(false, PbActivity.this.bRG()) : PbActivity.this.hEl.Bh(PbActivity.this.bRG());
                                            }
                                            view.setTag(Boolean.valueOf(t));
                                            if (t) {
                                                PbActivity.this.hEp.oi(true);
                                                PbActivity.this.hEp.bCb();
                                                PbActivity.this.mIsLoading = true;
                                                PbActivity.this.hEp.oz(true);
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
                                    PbActivity.this.hEp.bUT();
                                    if (PbActivity.this.xg(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN) && PbActivity.this.hEl.xv(PbActivity.this.hEp.bUH()) != null) {
                                        PbActivity.this.bRA();
                                        if (PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13402").bT("tid", PbActivity.this.hEl.hJp).bT("fid", PbActivity.this.hEl.getPbData().getForumId()).P("obj_locate", 3).bT("uid", PbActivity.this.hEl.getPbData().bPM().adv().getUserId()));
                                        }
                                        if (PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null && PbActivity.this.hEl.getPbData().bPM().adv().getUserId() != null && PbActivity.this.hEn != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEl.hJp).P("obj_locate", 1).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEl.getPbData().bPM().adv().getUserId()).P("obj_type", PbActivity.this.hEn.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEl.getPbData())));
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
                                if (PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().aep() && PbActivity.this.hEl.getPbData().bPM().adM() != null) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11922"));
                                }
                                if (PbActivity.this.hEl.getErrorNo() == 4) {
                                    if (StringUtils.isNull(PbActivity.this.hEl.bQJ()) && PbActivity.this.hEl.getAppealInfo() != null) {
                                        name = PbActivity.this.hEl.getAppealInfo().forumName;
                                    } else {
                                        PbActivity.this.finish();
                                        return;
                                    }
                                } else {
                                    name = PbActivity.this.hEl.getPbData().getForum().getName();
                                }
                                if (!StringUtils.isNull(name)) {
                                    String bQJ = PbActivity.this.hEl.bQJ();
                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(PbActivity.this.getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
                                    if (PbActivity.this.hEl.bSL() && bQJ != null && bQJ.equals(name)) {
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
                            if (PbActivity.this.hEl.getPbData() != null) {
                                if ((PbActivity.this.hEl.getPbData().bPY() == 1 || PbActivity.this.hEl.getPbData().bPY() == 3) && !PbActivity.this.eyy.cni()) {
                                    PbActivity.this.hEp.bUT();
                                    int i11 = 0;
                                    if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTK()) {
                                        if (PbActivity.this.hEp.hNh.bVQ() == null || view != PbActivity.this.hEp.hNh.bVQ().bTM()) {
                                            if (view == PbActivity.this.hEp.bUA()) {
                                                i11 = 2;
                                            }
                                        } else if (PbActivity.this.hEl.getPbData().bPM().adr() == 1) {
                                            i11 = 3;
                                        } else {
                                            i11 = 6;
                                        }
                                    } else if (PbActivity.this.hEl.getPbData().bPM().adq() == 1) {
                                        i11 = 5;
                                    } else {
                                        i11 = 4;
                                    }
                                    ForumData forum = PbActivity.this.hEl.getPbData().getForum();
                                    String name2 = forum.getName();
                                    String id4 = forum.getId();
                                    String id5 = PbActivity.this.hEl.getPbData().bPM().getId();
                                    PbActivity.this.hEp.bUz();
                                    PbActivity.this.eyy.a(id4, name2, id5, i11, PbActivity.this.hEp.bUB());
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
                        PbActivity.this.hEp.bUT();
                        PbActivity.this.bkh();
                        PbActivity.this.hEp.bUC();
                        PbActivity.this.hEp.showLoadingDialog();
                        if (PbActivity.this.hEp.bUp() != null) {
                            PbActivity.this.hEp.bUp().setVisibility(8);
                        }
                        PbActivity.this.hEl.xp(1);
                        if (PbActivity.this.hDQ != null) {
                            PbActivity.this.hDQ.showFloatingView();
                        }
                    } else {
                        PbActivity.this.showToast(R.string.network_not_available);
                        return;
                    }
                    if (PbActivity.this.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String bRo = PbActivity.this.bRo();
                        if (!TextUtils.isEmpty(bRo)) {
                            ba.aiz().c(PbActivity.this.getPageContext(), new String[]{bRo});
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (PbActivity.this.hEl != null) {
                    com.baidu.tbadk.core.util.am amVar8 = new com.baidu.tbadk.core.util.am("c13398");
                    amVar8.bT("tid", PbActivity.this.hEl.bSJ());
                    amVar8.bT("fid", PbActivity.this.hEl.getForumId());
                    amVar8.bT("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar8.P("obj_locate", 1);
                    TiebaStatic.log(amVar8);
                }
                if (PbActivity.this.hEa) {
                    PbActivity.this.hEa = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData5 = (PostData) obj;
                        if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.bRi().bUf() != null && postData5.adv() != null && postData5.cmx() != 1 && PbActivity.this.checkUpIsLogin()) {
                            if (PbActivity.this.bRi().bUg() != null) {
                                PbActivity.this.bRi().bUg().bSw();
                            }
                            com.baidu.tieba.pb.data.k kVar2 = new com.baidu.tieba.pb.data.k();
                            kVar2.a(PbActivity.this.hEl.getPbData().getForum());
                            kVar2.ai(PbActivity.this.hEl.getPbData().bPM());
                            kVar2.e(postData5);
                            PbActivity.this.bRi().bUf().d(kVar2);
                            PbActivity.this.bRi().bUf().setPostId(postData5.getId());
                            PbActivity.this.a(view, postData5.adv().getUserId(), "");
                            TiebaStatic.log("c11743");
                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEl.getPbData(), postData5, postData5.locate, 8, 1);
                            if (PbActivity.this.hEE != null) {
                                PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                            }
                        }
                    }
                }
            }
        }
    };
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.41
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEl.getPbData().getForumId());
                }
                if (PbActivity.this.hEl != null) {
                    amVar.bT("tid", PbActivity.this.hEl.bSJ());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            PbActivity.this.bkh();
            PbActivity.this.hEp.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (com.baidu.tbadk.t.av.auH() && PbActivity.this.bQS() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    PbActivity.this.bQS().Bk(postWriteCallBackData.getPostId());
                    PbActivity.this.hER = PbActivity.this.hEp.bUl();
                    if (PbActivity.this.hEl != null) {
                        PbActivity.this.hEl.cb(PbActivity.this.hER, PbActivity.this.hEp.bUm());
                    }
                }
                PbActivity.this.hEp.bUT();
                PbActivity.this.hEu.bVs();
                if (PbActivity.this.hEE != null) {
                    PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                }
                PbActivity.this.hEp.bUe();
                PbActivity.this.hEp.oK(true);
                PbActivity.this.hEl.bTc();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                PbActivity.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (PbActivity.this.hEl.getHostMode()) {
                            com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                            if (pbData != null && pbData.bPM() != null && pbData.bPM().adv() != null && (userId = pbData.bPM().adv().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !com.baidu.tbadk.t.av.auH() && PbActivity.this.hEl.bST()) {
                                PbActivity.this.hEp.bUC();
                            }
                        } else if (!com.baidu.tbadk.t.av.auH() && PbActivity.this.hEl.bST()) {
                            PbActivity.this.hEp.bUC();
                        }
                    } else if (floor != null) {
                        PbActivity.this.hEp.m(PbActivity.this.hEl.getPbData());
                    }
                    if (PbActivity.this.hEl.bSO()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10369").bT("tid", PbActivity.this.hEl.bSJ()));
                    }
                }
            } else if (i == 220015) {
                PbActivity.this.showToast(str);
                if (PbActivity.this.hEE.arF() || PbActivity.this.hEE.arG()) {
                    PbActivity.this.hEE.a(false, postWriteCallBackData);
                }
                PbActivity.this.hEu.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (PbActivity.this.gPO != null) {
                    PbActivity.this.gPO.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (xVar == null && i != 227001) {
                PbActivity.this.a(i, antiData, str);
            }
        }
    };
    public NewWriteModel.d hFq = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.42
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13268");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                    amVar.bT("fid", PbActivity.this.hEl.getPbData().getForumId());
                }
                if (PbActivity.this.hEl != null) {
                    amVar.bT("tid", PbActivity.this.hEl.bSJ());
                }
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(amVar);
            }
            if (z) {
                if (PbActivity.this.hEu != null) {
                    PbActivity.this.hEu.bVr();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (PbActivity.this.gPO != null) {
                    PbActivity.this.gPO.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && PbActivity.this.hEu != null) {
                if (PbActivity.this.hEp != null && PbActivity.this.hEp.bUg() != null && PbActivity.this.hEp.bUg().bSA() != null && PbActivity.this.hEp.bUg().bSA().arG()) {
                    PbActivity.this.hEp.bUg().bSA().a(postWriteCallBackData);
                }
                PbActivity.this.hEu.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hFr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.43
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView bVq;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == PbActivity.this.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (PbActivity.this.hEp != null && (bVq = PbActivity.this.hEp.bVq()) != null && PbActivity.this.hEp.getListView() != null) {
                            PbActivity.this.hEp.getListView().removeHeaderView(bVq);
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    };
    private final PbModel.a hFs = new PbModel.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4) {
            com.baidu.tbadk.editortools.g kg;
            if (!z || dVar == null || dVar.bPW() != null || com.baidu.tbadk.core.util.v.Z(dVar.bPO()) >= 1) {
                PbActivity.this.hhn = true;
                long currentTimeMillis = System.currentTimeMillis();
                PbActivity.this.hEp.bUE();
                if (dVar == null || !dVar.bPS()) {
                    PbActivity.this.hideLoadingView(PbActivity.this.hEp.getView());
                }
                PbActivity.this.hEp.bCa();
                if (PbActivity.this.isFullScreen || PbActivity.this.hEp.bVl()) {
                    PbActivity.this.hEp.bVc();
                } else if (!PbActivity.this.hEp.bUZ()) {
                    PbActivity.this.hEp.oK(false);
                }
                if (PbActivity.this.mIsLoading) {
                    PbActivity.this.mIsLoading = false;
                }
                if (i4 == 0 && dVar != null) {
                    PbActivity.this.hEx = true;
                }
                if (dVar != null) {
                    PbActivity.this.hideNetRefreshView(PbActivity.this.hEp.getView());
                }
                if (z && dVar != null) {
                    PbActivity.this.hEp.aUH();
                    if (dVar.bPM() != null && dVar.bPM().aey() != null) {
                        PbActivity.this.a(dVar.bPM().aey());
                    }
                    PbActivity.this.bRf();
                    if (PbActivity.this.hEE != null) {
                        PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(dVar.getUserData().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(dVar.getUserData().getBimg_end_time());
                    if (dVar.bPO() != null && dVar.bPO().size() >= 1 && dVar.bPO().get(0) != null) {
                        PbActivity.this.hEl.Bj(dVar.bPO().get(0).getId());
                    } else if (dVar.bPW() != null) {
                        PbActivity.this.hEl.Bj(dVar.bPW().getId());
                    }
                    if (PbActivity.this.hEE != null) {
                        PbActivity.this.hEE.a(dVar.getAnti());
                        PbActivity.this.hEE.a(dVar.getForum(), dVar.getUserData());
                        PbActivity.this.hEE.a(PbActivity.this.hEl.bSW(), PbActivity.this.hEl.bSJ(), PbActivity.this.hEl.bTo());
                        if (dVar.bPM() != null) {
                            PbActivity.this.hEE.fk(dVar.bPM().aeN());
                        }
                    }
                    if (PbActivity.this.hEn != null) {
                        PbActivity.this.hEn.ds(dVar.ZC());
                    }
                    if (dVar == null || dVar.getIsNewUrl() != 1) {
                        PbActivity.this.mIsFromCDN = false;
                    } else {
                        PbActivity.this.mIsFromCDN = true;
                    }
                    PbActivity.this.hEp.oJ(PbActivity.this.mIsFromCDN);
                    PbActivity.this.hEp.a(dVar, i2, i3, PbActivity.this.hEl.bSK(), i4, PbActivity.this.hEl.getIsFromMark());
                    PbActivity.this.hEp.e(dVar, PbActivity.this.hEl.bSK());
                    PbActivity.this.hEp.oG(PbActivity.this.hEl.getHostMode());
                    AntiData anti = dVar.getAnti();
                    if (anti != null) {
                        PbActivity.this.csu = anti.getVoice_message();
                        if (!StringUtils.isNull(PbActivity.this.csu) && PbActivity.this.hEE != null && PbActivity.this.hEE.aqS() != null && (kg = PbActivity.this.hEE.aqS().kg(6)) != null && !TextUtils.isEmpty(PbActivity.this.csu)) {
                            ((View) kg).setOnClickListener(PbActivity.this.cti);
                        }
                    }
                    if (PbActivity.this.hEz) {
                        PbActivity.this.hEz = false;
                        final int bRv = PbActivity.this.bRv();
                        if (!dVar.bQk()) {
                            PbActivity.this.hEp.xB(bRv);
                        } else {
                            final int af = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PbActivity.this.getListView() != null) {
                                        PbActivity.this.getListView().setSelectionFromTop(bRv, af);
                                    }
                                }
                            });
                        }
                    }
                    if (PbActivity.this.hEA) {
                        PbActivity.this.hEA = false;
                        final int bRv2 = PbActivity.this.bRv();
                        final boolean z2 = bRv2 != -1;
                        if (!z2) {
                            bRv2 = PbActivity.this.bRw();
                        }
                        if (PbActivity.this.hEp != null) {
                            if (!dVar.bQk()) {
                                PbActivity.this.hEp.xB(bRv2);
                            } else {
                                final int af2 = (int) (com.baidu.adp.lib.util.l.af(PbActivity.this) * 0.5625d);
                                com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.44.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (bRv2 != -1 && PbActivity.this.getListView() != null) {
                                            if (z2) {
                                                PbActivity.this.hEp.setSelectionFromTop(bRv2, af2);
                                            } else {
                                                PbActivity.this.hEp.setSelectionFromTop(bRv2 - 1, af2);
                                            }
                                        }
                                    }
                                });
                                PbActivity.this.hEp.oL(true);
                                PbActivity.this.hEp.oK(false);
                            }
                        }
                    } else if (PbActivity.this.hEB) {
                        PbActivity.this.hEB = false;
                        PbActivity.this.hEp.setSelectionFromTop(0, 0);
                    } else {
                        PbActivity.this.hEp.bUI();
                    }
                    PbActivity.this.hEl.a(dVar.getForum(), PbActivity.this.hFe);
                    PbActivity.this.hEl.a(PbActivity.this.hFf);
                    if (PbActivity.this.gPO != null && dVar.bPM() != null && dVar.bPM().adv() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(dVar.bPM().adv());
                        PbActivity.this.gPO.a(attentionHostData);
                    }
                } else if (str != null) {
                    if (!PbActivity.this.hEx && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (PbActivity.this.hEl != null && PbActivity.this.hEl.getAppealInfo() != null && !StringUtils.isNull(PbActivity.this.hEl.getAppealInfo().hAZ)) {
                                    PbActivity.this.hEp.a(PbActivity.this.hEl.getAppealInfo());
                                } else {
                                    PbActivity.this.showNetRefreshView(PbActivity.this.hEp.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                                }
                            } else {
                                PbActivity.this.showNetRefreshView(PbActivity.this.hEp.getView(), PbActivity.this.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
                            }
                            PbActivity.this.hEp.bVc();
                        }
                    } else {
                        PbActivity.this.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", PbActivity.this.hEl.bSJ());
                            jSONObject.put("fid", PbActivity.this.hEl.getForumId());
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
                        PbActivity.this.hEp.Bn("");
                    } else {
                        ArrayList<PostData> arrayList = null;
                        if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                            arrayList = PbActivity.this.hEl.getPbData().bPO();
                        }
                        if (com.baidu.tbadk.core.util.v.Z(arrayList) != 0 && (com.baidu.tbadk.core.util.v.Z(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).cmx() != 1)) {
                            PbActivity.this.hEp.Bn(PbActivity.this.getResources().getString(R.string.list_no_more_new));
                        } else if (PbActivity.this.bRT()) {
                            PbActivity.this.hEp.Bo(PbActivity.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            PbActivity.this.hEp.Bo(PbActivity.this.getResources().getString(R.string.pb_no_replay));
                        }
                    }
                    PbActivity.this.hEp.ajz();
                }
                PbActivity.this.cyF = System.currentTimeMillis() - currentTimeMillis;
                if (!PbActivity.this.bQS().bSK() || PbActivity.this.bQS().getPbData().getPage().acq() != 0 || PbActivity.this.bQS().bTi()) {
                    PbActivity.this.hEF = true;
                    return;
                }
                return;
            }
            PbActivity.this.hEl.xp(1);
            if (PbActivity.this.hDQ != null) {
                PbActivity.this.hDQ.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.d dVar) {
            PbActivity.this.hEp.m(dVar);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            if (com.baidu.tbadk.p.m.auk().aul()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - PbActivity.this.eSm : j;
                com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, PbActivity.this.cyx, PbActivity.this.createTime, PbActivity.this.cyF, z2, currentTimeMillis);
                PbActivity.this.createTime = 0L;
                PbActivity.this.cyx = 0L;
                if (iVar != null) {
                    iVar.auh();
                }
                if (z2) {
                    iVar.cyO = currentTimeMillis;
                    iVar.fA(true);
                }
                if (!z2 && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null) {
                    int threadType = PbActivity.this.hEl.getPbData().bPM().getThreadType();
                    if (threadType == 0 || threadType == 40) {
                        if (!com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hEd, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                            if (com.baidu.tbadk.core.util.ap.equals(PbActivity.this.hEd, "from_frs")) {
                                com.baidu.tbadk.p.i iVar2 = new com.baidu.tbadk.p.i();
                                iVar2.kK(1000);
                                iVar2.cyQ = currentTimeMillis;
                                iVar2.kL(threadType);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.p.d dVar = new com.baidu.tbadk.p.d();
                        dVar.pageType = 1;
                        dVar.kK(1005);
                        dVar.cyQ = currentTimeMillis;
                        dVar.kL(threadType);
                    }
                }
            }
        }
    };
    private CustomMessageListener hFt = new CustomMessageListener(2016450) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbActivity.this.bRr();
            }
        }
    };
    private final a.InterfaceC0236a hFu = new a.InterfaceC0236a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.47
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0236a
        public void c(boolean z, boolean z2, String str) {
            PbActivity.this.hEp.bUE();
            if (z) {
                if (PbActivity.this.hEn != null) {
                    PbActivity.this.hEn.ds(z2);
                }
                PbActivity.this.hEl.oq(z2);
                if (PbActivity.this.hEl.ZC()) {
                    PbActivity.this.bRB();
                } else {
                    PbActivity.this.hEp.m(PbActivity.this.hEl.getPbData());
                }
                if (z2) {
                    if (PbActivity.this.hEn != null && PbActivity.this.hEn.ZF() != null && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null) {
                        MarkData ZF = PbActivity.this.hEn.ZF();
                        MetaData adv = PbActivity.this.hEl.getPbData().bPM().adv();
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
                if (PbActivity.this.hEp != null) {
                    PbActivity.this.hEp.bUT();
                    if (PbActivity.this.hEE != null && !PbActivity.this.hEp.bUi()) {
                        PbActivity.this.hEp.oI(PbActivity.this.hEE.arz());
                    }
                    if (!PbActivity.this.isFullScreen) {
                        PbActivity.this.hEp.bUh();
                    }
                }
                if (!PbActivity.this.hDX) {
                    PbActivity.this.hDX = true;
                    PbActivity.this.hEp.bUY();
                }
            }
            PbActivity.this.hEp.onScrollStateChanged(absListView, i);
            if (PbActivity.this.hDQ != null) {
                PbActivity.this.hDQ.onScrollStateChanged(absListView, i);
            }
            if (PbActivity.this.hDY == null) {
                PbActivity.this.hDY = new com.baidu.tbadk.p.b();
                PbActivity.this.hDY.kK(1001);
            }
            if (i == 0) {
                PbActivity.this.hDY.aub();
            } else {
                PbActivity.this.hDY.aua();
            }
            PbActivity.this.mLastScrollState = i;
            if (i == 0) {
                PbActivity.this.a(false, (PostData) null);
                com.baidu.tieba.q.c.clw().b(PbActivity.this.getUniqueId(), true);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> bPO;
            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEp != null && PbActivity.this.hEp.bUy() != null) {
                PbActivity.this.hEp.onScroll(absListView, i, i2, i3);
                if (PbActivity.this.hDQ != null) {
                    PbActivity.this.hDQ.onScroll(absListView, i, i2, i3);
                }
                if (PbActivity.this.hEl.bTe() && (bPO = PbActivity.this.hEl.getPbData().bPO()) != null && !bPO.isEmpty()) {
                    int headerCount = ((i + i2) - PbActivity.this.hEp.bUy().getHeaderCount()) - 1;
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
                    if (pbData != null) {
                        if (pbData.bPP() != null && pbData.bPP().hasData()) {
                            headerCount--;
                        }
                        if (pbData.bPQ() != null && pbData.bPQ().hasData()) {
                            headerCount--;
                        }
                        int size = bPO.size();
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
                        PbActivity.this.hEl.bTc();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.hUy != 1002 || bVar.fTT) {
                            z = true;
                        }
                        PbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        PbActivity.this.hEp.a(1, dVar.FM, dVar.jbn, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbActivity.this.a(PbActivity.this.eyy.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        PbActivity.this.hEp.a(PbActivity.this.eyy.getLoadDataMode(), gVar.FM, gVar.jbn, false);
                        PbActivity.this.hEp.ax(gVar.jbq);
                        return;
                    default:
                        return;
                }
            }
            PbActivity.this.hEp.a(PbActivity.this.eyy.getLoadDataMode(), false, (String) null, false);
        }
    };
    private final d hFv = new d() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.54
    };
    private final h.c cXK = new h.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.55
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (PbActivity.this.bRH()) {
                PbActivity.this.finish();
            }
            if (!PbActivity.this.hEl.op(true)) {
                PbActivity.this.hEp.bUF();
            } else {
                TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            }
        }
    };
    private final BdListView.e fJc = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.56
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (PbActivity.this.hFw && PbActivity.this.bRH()) {
                PbActivity.this.bRJ();
            }
            if (PbActivity.this.mIsLogin) {
                if (PbActivity.this.hEl.oo(false)) {
                    PbActivity.this.hEp.bUD();
                    TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (PbActivity.this.hEl.getPbData() != null) {
                    PbActivity.this.hEp.bUX();
                }
                PbActivity.this.hFw = true;
            }
        }
    };
    private int hFx = 0;
    private final TbRichTextView.h cIN = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.72
        /* JADX DEBUG: Multi-variable search result rejected for r2v59, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
        public void a(View view, String str, int i, boolean z, boolean z2) {
            f bUy;
            int i2;
            try {
                if (!(view.getTag() instanceof TbRichText) || str != null) {
                    if (PbActivity.this.hEl != null) {
                        com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13398");
                        amVar.bT("tid", PbActivity.this.hEl.bSJ());
                        amVar.bT("fid", PbActivity.this.hEl.getForumId());
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
                        PbActivity.this.hEh = view;
                        return;
                    }
                    c cVar = new c();
                    PbActivity.this.a(str, i, cVar);
                    if (cVar.hGn) {
                        TbRichText bd = PbActivity.this.bd(str, i);
                        if (bd != null && PbActivity.this.hFx >= 0 && PbActivity.this.hFx < bd.axz().size()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            String b2 = com.baidu.tieba.pb.data.e.b(bd.axz().get(PbActivity.this.hFx));
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= cVar.hGk.size()) {
                                    break;
                                } else if (!cVar.hGk.get(i4).equals(b2)) {
                                    i3 = i4 + 1;
                                } else {
                                    cVar.index = i4;
                                    arrayList.add(b2);
                                    break;
                                }
                            }
                            if (bd.getPostId() != 0 && (bUy = PbActivity.this.hEp.bUy()) != null) {
                                ArrayList<com.baidu.adp.widget.ListView.m> dataList = bUy.getDataList();
                                if (com.baidu.tbadk.core.util.v.Z(dataList) > 0) {
                                    Iterator<com.baidu.adp.widget.ListView.m> it = dataList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        com.baidu.adp.widget.ListView.m next = it.next();
                                        if ((next instanceof PostData) && bd.getPostId() == com.baidu.adp.lib.g.b.c(((PostData) next).getId(), 0L)) {
                                            if (bd.getPostId() != com.baidu.adp.lib.g.b.c(PbActivity.this.hEl.bTo(), 0L)) {
                                                i2 = 8;
                                            } else {
                                                i2 = 1;
                                            }
                                            com.baidu.tieba.pb.c.a.a(PbActivity.this.hEl.getPbData(), (PostData) next, ((PostData) next).locate, i2, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!com.baidu.tbadk.core.util.v.aa(arrayList)) {
                                String str2 = arrayList.get(0);
                                concurrentHashMap.put(str2, cVar.hGl.get(str2));
                            }
                            ImageViewerConfig createConfig = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGm, cVar.lastId, PbActivity.this.hEl.bSZ(), concurrentHashMap, true, false, z);
                            createConfig.getIntent().putExtra("from", "pb");
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            PbActivity.this.n(rect);
                            createConfig.setIsHotSort(PbActivity.this.hEl.getSortType() == 2);
                            createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
                            PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.baidu.tbadk.core.util.v.c(cVar.hGk, 0));
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    if (!com.baidu.tbadk.core.util.v.aa(arrayList2)) {
                        String str3 = (String) arrayList2.get(0);
                        concurrentHashMap2.put(str3, cVar.hGl.get(str3));
                    }
                    ImageViewerConfig createConfig2 = new ImageViewerConfig(PbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList2, 0, cVar.forumName, cVar.forumId, cVar.threadId, cVar.hGm, cVar.hGk.get(0), PbActivity.this.hEl.bSZ(), concurrentHashMap2, true, false, z);
                    createConfig2.getIntent().putExtra("from", "pb");
                    createConfig2.setIsCanDrag(false);
                    createConfig2.setIsHotSort(PbActivity.this.hEl.getSortType() == 2);
                    PbActivity.this.sendMessage(new CustomMessage(2010000, createConfig2));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, false));
                } else if (PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.hEp.b((TbRichText) view.getTag());
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12490"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    };
    boolean hFy = false;
    PostData ggP = null;
    private final b.a hFz = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.73
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.ggP != null) {
                if (i == 0) {
                    PbActivity.this.ggP.ek(PbActivity.this.getPageContext().getPageActivity());
                    PbActivity.this.ggP = null;
                } else if (i == 1 && PbActivity.this.checkUpIsLogin()) {
                    PbActivity.this.f(PbActivity.this.ggP);
                }
            }
        }
    };
    private final b.a hFA = new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.74
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (PbActivity.this.hEO != null && !TextUtils.isEmpty(PbActivity.this.hEP)) {
                if (i == 0) {
                    if (PbActivity.this.hEQ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEP));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = PbActivity.this.hEP;
                        aVar.pkgId = PbActivity.this.hEQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEQ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (PbActivity.this.mPermissionJudgement == null) {
                        PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    PbActivity.this.mPermissionJudgement.aiM();
                    PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                        if (PbActivity.this.fQE == null) {
                            PbActivity.this.fQE = new au(PbActivity.this.getPageContext());
                        }
                        PbActivity.this.fQE.h(PbActivity.this.hEP, PbActivity.this.hEO.nv());
                    } else {
                        return;
                    }
                }
                PbActivity.this.hEO = null;
                PbActivity.this.hEP = null;
            }
        }
    };
    private final View.OnLongClickListener cll = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.75
        /* JADX WARN: Removed duplicated region for block: B:27:0x0099 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            String str;
            boolean nZ;
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
                        PbActivity.this.hEO = ((TbImageView) view).getBdImage();
                        PbActivity.this.hEP = ((TbImageView) view).getUrl();
                        if (PbActivity.this.hEO == null || TextUtils.isEmpty(PbActivity.this.hEP)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEQ = null;
                        } else {
                            PbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            PbActivity.this.hEO = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                PbActivity.this.hEP = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                PbActivity.this.hEQ = null;
                            } else {
                                PbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        PbActivity.this.hEO = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            PbActivity.this.hEP = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            PbActivity.this.hEQ = null;
                        } else {
                            PbActivity.this.hEQ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        PbActivity.this.hEp.a(PbActivity.this.hFA, PbActivity.this.hEO.isGif());
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
            PbActivity.this.ggP = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (PbActivity.this.ggP == null) {
                return true;
            }
            if (PbActivity.this.ggP.cmx() != 1 || !PbActivity.this.cu(view)) {
                if (PbActivity.this.hEn != null) {
                    if (!PbActivity.this.hEn.ZC() || PbActivity.this.ggP.getId() == null || !PbActivity.this.ggP.getId().equals(PbActivity.this.hEl.adE())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (PbActivity.this.ggP.cmx() == 1) {
                        PbActivity.this.hEp.a(PbActivity.this.hFz, z, false);
                        return true;
                    }
                    if (PbActivity.this.hEw == null) {
                        PbActivity.this.hEw = new com.baidu.tbadk.core.dialog.k(PbActivity.this);
                        PbActivity.this.hEw.a(PbActivity.this.hFB);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (view != null && sparseArray2 != null) {
                        boolean z2 = false;
                        boolean cu = PbActivity.this.cu(view);
                        boolean z3 = (!PbActivity.this.cu(view) || PbActivity.this.hEO == null || PbActivity.this.hEO.isGif()) ? false : true;
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
                            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(0, PbActivity.this.getString(R.string.no_interesting), PbActivity.this.hEw);
                            gVar3.mTextView.setTag(R.id.tag_chudian_template_id, Long.valueOf(j));
                            gVar3.mTextView.setTag(R.id.tag_chudian_monitor_id, str2);
                            gVar3.mTextView.setTag(R.id.tag_chudian_hide_day, Integer.valueOf(i));
                            arrayList.add(gVar3);
                        }
                        if (cu) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, PbActivity.this.getString(R.string.save_to_emotion), PbActivity.this.hEw));
                        }
                        if (z3) {
                            arrayList.add(new com.baidu.tbadk.core.dialog.g(2, PbActivity.this.getString(R.string.save_to_local), PbActivity.this.hEw));
                        }
                        if (!cu && !z3) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(3, PbActivity.this.getString(R.string.copy), PbActivity.this.hEw);
                            SparseArray sparseArray3 = new SparseArray();
                            sparseArray3.put(R.id.tag_clip_board, PbActivity.this.ggP);
                            gVar4.mTextView.setTag(sparseArray3);
                            arrayList.add(gVar4);
                        }
                        if (!z4) {
                            if (z) {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.remove_mark), PbActivity.this.hEw);
                            } else {
                                gVar2 = new com.baidu.tbadk.core.dialog.g(4, PbActivity.this.getString(R.string.mark), PbActivity.this.hEw);
                            }
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_clip_board, PbActivity.this.ggP);
                            sparseArray4.put(R.id.tag_is_subpb, false);
                            gVar2.mTextView.setTag(sparseArray4);
                            arrayList.add(gVar2);
                        }
                        if (PbActivity.this.mIsLogin) {
                            if (!z7 && z6) {
                                com.baidu.tbadk.core.dialog.g gVar5 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.mute_option), PbActivity.this.hEw);
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
                                if (!ap.m(PbActivity.this.ggP)) {
                                    nZ = PbActivity.this.nZ(z5) & PbActivity.this.isLogin();
                                } else {
                                    nZ = false;
                                }
                                if (nZ) {
                                    com.baidu.tbadk.core.dialog.g gVar6 = new com.baidu.tbadk.core.dialog.g(5, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEw);
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
                                    gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEw);
                                    gVar7.mTextView.setTag(sparseArray6);
                                } else {
                                    sparseArray6.put(R.id.tag_should_delete_visible, false);
                                }
                                gVar = new com.baidu.tbadk.core.dialog.g(7, PbActivity.this.getString(R.string.bar_manager), PbActivity.this.hEw);
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
                                    if (PbActivity.this.hEl.getPbData().bPY() == 1002 && !z5) {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.report_text), PbActivity.this.hEw);
                                    } else {
                                        gVar7 = new com.baidu.tbadk.core.dialog.g(6, PbActivity.this.getString(R.string.delete), PbActivity.this.hEw);
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
                        PbActivity.this.hEw.W(arrayList);
                        PbActivity.this.hEv = new com.baidu.tbadk.core.dialog.i(PbActivity.this.getPageContext(), PbActivity.this.hEw.afZ());
                        PbActivity.this.hEv.showDialog();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13272").bT("tid", PbActivity.this.hEl.hJp).bT("fid", PbActivity.this.hEl.getForumId()).bT("uid", PbActivity.this.hEl.getPbData().bPM().adv().getUserId()).bT("post_id", PbActivity.this.hEl.aro()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, z4 ? 2 : 1));
                    }
                    return true;
                }
                return true;
            }
            PbActivity.this.hEp.a(PbActivity.this.hFA, PbActivity.this.hEO.isGif());
            return true;
        }
    };
    private k.c hFB = new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.76
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
            if (PbActivity.this.hEv != null) {
                PbActivity.this.hEv.dismiss();
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
                    com.baidu.tieba.pb.data.d pbData = PbActivity.this.hEl.getPbData();
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
                    if (PbActivity.this.hEO != null && !TextUtils.isEmpty(PbActivity.this.hEP)) {
                        if (PbActivity.this.hEQ == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, PbActivity.this.hEP));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = PbActivity.this.hEP;
                            aVar.pkgId = PbActivity.this.hEQ.memeInfo.pck_id.intValue() < 0 ? "" : "" + PbActivity.this.hEQ.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        PbActivity.this.hEO = null;
                        PbActivity.this.hEP = null;
                        return;
                    }
                    return;
                case 2:
                    if (PbActivity.this.hEO != null && !TextUtils.isEmpty(PbActivity.this.hEP)) {
                        if (PbActivity.this.mPermissionJudgement == null) {
                            PbActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        PbActivity.this.mPermissionJudgement.aiM();
                        PbActivity.this.mPermissionJudgement.e(PbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!PbActivity.this.mPermissionJudgement.aa(PbActivity.this.getPageContext().getPageActivity())) {
                            if (PbActivity.this.fQE == null) {
                                PbActivity.this.fQE = new au(PbActivity.this.getPageContext());
                            }
                            PbActivity.this.fQE.h(PbActivity.this.hEP, PbActivity.this.hEO.nv());
                            PbActivity.this.hEO = null;
                            PbActivity.this.hEP = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (PbActivity.this.ggP != null) {
                        PbActivity.this.ggP.ek(PbActivity.this.getPageContext().getPageActivity());
                        PbActivity.this.ggP = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11739").P("obj_locate", 2));
                    if (PbActivity.this.checkUpIsLogin()) {
                        PbActivity.this.ct(view);
                        if (PbActivity.this.hEl.getPbData().bPM() != null && PbActivity.this.hEl.getPbData().bPM().adv() != null && PbActivity.this.hEl.getPbData().bPM().adv().getUserId() != null && PbActivity.this.hEn != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12526").bT("tid", PbActivity.this.hEl.hJp).P("obj_locate", 2).bT(VideoPlayActivityConfig.OBJ_ID, PbActivity.this.hEl.getPbData().bPM().adv().getUserId()).P("obj_type", PbActivity.this.hEn.ZC() ? 0 : 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, PbActivity.this.c(PbActivity.this.hEl.getPbData())));
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
                        PbActivity.this.Bc((String) tag);
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
                        PbActivity.this.hEp.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
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
                            PbActivity.this.hEp.cA(view);
                            return;
                        } else if (booleanValue2) {
                            PbActivity.this.hEp.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
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
            if (!PbActivity.this.hDS && z && !PbActivity.this.hEl.bSQ()) {
                PbActivity.this.bRD();
            }
            PbActivity.this.setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(PbActivity.this.getApplicationContext(), R.dimen.ds360));
        }
    };
    public View.OnTouchListener clc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.83
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
            if (ax(i2) && PbActivity.this.hEp != null && PbActivity.this.hDQ != null) {
                PbActivity.this.hEp.bVd();
                PbActivity.this.hDQ.kb(false);
                PbActivity.this.hDQ.showFloatingView();
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0302a
        public void aU(int i, int i2) {
            if (ax(i2) && PbActivity.this.hEp != null && PbActivity.this.hDQ != null) {
                PbActivity.this.hDQ.kb(true);
                if (Math.abs(i2) > this.egj) {
                    PbActivity.this.hDQ.hideFloatingView();
                }
                if (PbActivity.this.bRH()) {
                    PbActivity.this.hEp.bUv();
                    PbActivity.this.hEp.bUw();
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
    private String hFD = null;
    private final m.a hFE = new m.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.87
        @Override // com.baidu.tieba.pb.pb.main.m.a
        public void m(int i, String str, String str2) {
            if (StringUtils.isNull(str)) {
                if (i == 0) {
                    PbActivity.this.showToast(R.string.upgrage_toast_dialog);
                } else {
                    PbActivity.this.showToast(R.string.neterror);
                }
            } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                PbActivity.this.hFD = str2;
                PbActivity.this.hEp.Bp(str);
            } else {
                PbActivity.this.showToast(str);
            }
        }
    };
    private int hFF = -1;
    private int hFG = -1;
    private CustomMessageListener hFJ = new CustomMessageListener(2016513) { // from class: com.baidu.tieba.pb.pb.main.PbActivity.95
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.b.a)) {
                com.baidu.tbadk.core.b.a aVar = (com.baidu.tbadk.core.b.a) customResponsedMessage.getData();
                boolean z = aVar.bDl == PbActivity.this.getUniqueId();
                if (aVar instanceof a.C0238a) {
                    if (aVar.bDm != null && !aVar.bDm.hasError() && aVar.bDm.getError() == 0) {
                        if (PbActivity.this.hEp != null) {
                            PbActivity.this.hEp.q(((a.C0238a) aVar).channelId, 1);
                        }
                        if (z) {
                            PbActivity.this.bRS();
                        }
                    } else if (z) {
                        if (aVar.bDm != null && aVar.bDm.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bDm.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.c) {
                    if (aVar.bDm != null && !aVar.bDm.hasError() && aVar.bDm.getError() == 0) {
                        if (PbActivity.this.hEp != null && PbActivity.this.hEp != null) {
                            PbActivity.this.hEp.q(((a.C0238a) aVar).channelId, 2);
                        }
                    } else if (z) {
                        if (aVar.bDm != null && aVar.bDm.getErrorString() != null) {
                            PbActivity.this.showToast(aVar.bDm.getErrorString());
                        } else {
                            PbActivity.this.showToast(R.string.fail_cancle_order_video_channel);
                        }
                    }
                } else if (aVar instanceof a.b) {
                    if (aVar.bDm == null || aVar.bDm.hasError() || aVar.bDm.getError() != 0) {
                        if (z) {
                            if (aVar.bDm != null && aVar.bDm.getErrorString() != null) {
                                PbActivity.this.showToast(aVar.bDm.getErrorString());
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
        public ArrayList<String> hGk;
        public ConcurrentHashMap<String, ImageUrlData> hGl;
        public boolean hGn;
        public String forumName = null;
        public String forumId = null;
        public String threadId = null;
        public boolean hGm = false;
        public boolean hGo = false;
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

    public com.baidu.tbadk.editortools.pb.d bRe() {
        return this.hEE;
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        MetaData metaData;
        boolean z = true;
        if (kVar.bQv() != null) {
            String id = kVar.bQv().getId();
            ArrayList<PostData> bPO = this.hEl.getPbData().bPO();
            int i = 0;
            while (true) {
                if (i >= bPO.size()) {
                    break;
                }
                PostData postData = bPO.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> bQz = kVar.bQz();
                    postData.Ax(kVar.getTotalCount());
                    if (postData.cmu() != null && bQz != null) {
                        Iterator<PostData> it = bQz.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.adv() != null && (metaData = postData.getUserMap().get(next.adv().getUserId())) != null) {
                                next.a(metaData);
                                next.qO(true);
                                next.a(getPageContext(), this.hEl.Bi(metaData.getUserId()));
                            }
                        }
                        boolean z2 = bQz.size() != postData.cmu().size();
                        postData.cmu().clear();
                        postData.cmu().addAll(bQz);
                        z = z2;
                    }
                    if (postData.cmq() != null) {
                        postData.cmr();
                    }
                }
            }
            if (!this.hEl.getIsFromMark() && z) {
                this.hEp.m(this.hEl.getPbData());
            }
            if (z) {
                c(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.tbadkCore.data.m bQb = this.hEl.getPbData().bQb();
            if (bQb != null && str.equals(bQb.getAdId())) {
                if (bQb.cml() != null) {
                    bQb.cml().legoCard = null;
                }
                this.hEl.getPbData().bQc();
            }
            com.baidu.tieba.tbadkCore.data.m bSU = this.hEl.bSU();
            if (bSU != null && str.equals(bSU.getAdId())) {
                this.hEl.bSV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.hEv != null && this.hEv.isShowing()) {
                this.hEv.dismiss();
                this.hEv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this);
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.22
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                        if (PbActivity.this.hEv != null) {
                            PbActivity.this.hEv.dismiss();
                        }
                        if (i == 0) {
                            PbActivity.this.hEp.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, PbActivity.this.hEM);
                            userMuteAddAndDelCustomMessage.setTag(PbActivity.this.hEM);
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
                this.hEv = new com.baidu.tbadk.core.dialog.i(getPageContext(), kVar.afZ());
                this.hEv.showDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        bg bPM;
        if (this.hEl != null && this.hEl.getPbData() != null && (bPM = this.hEl.getPbData().bPM()) != null) {
            if (i == 1) {
                PraiseData adh = bPM.adh();
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
                        bPM.a(praiseData);
                    } else {
                        bPM.adh().getUser().add(0, metaData);
                        bPM.adh().setNum(bPM.adh().getNum() + 1);
                        bPM.adh().setIsLike(i);
                    }
                }
                if (bPM.adh() != null) {
                    if (bPM.adh().getNum() < 1) {
                        getResources().getString(R.string.zan);
                    } else {
                        com.baidu.tbadk.core.util.ap.aL(bPM.adh().getNum());
                    }
                }
            } else if (bPM.adh() != null) {
                bPM.adh().setIsLike(i);
                bPM.adh().setNum(bPM.adh().getNum() - 1);
                ArrayList<MetaData> user = bPM.adh().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            bPM.adh().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (bPM.adh().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    String str = bPM.adh().getNum() + "";
                }
            }
            if (this.hEl.bSK()) {
                this.hEp.bUy().notifyDataSetChanged();
            } else {
                this.hEp.n(this.hEl.getPbData());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.hEl.ab(bundle);
        if (this.foP != null) {
            this.foP.onSaveInstanceState(getPageContext().getPageActivity());
        }
        this.hEE.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.hDW = System.currentTimeMillis();
        this.hEK = getPageContext();
        final Intent intent = getIntent();
        if (intent != null) {
            this.eSm = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            this.hEd = intent.getStringExtra("from");
            if (StringUtils.isNull(this.hEd) && intent.getData() != null) {
                this.hEd = intent.getData().getQueryParameter("from");
            }
            this.mStType = intent.getStringExtra("st_type");
            if ("from_interview_live".equals(this.hEd)) {
                this.hDR = true;
            }
            this.hFF = intent.getIntExtra("key_manga_prev_chapter", -1);
            this.hFG = intent.getIntExtra("key_manga_next_chapter", -1);
            this.hFH = intent.getStringExtra("key_manga_title");
            this.hEz = intent.getBooleanExtra("key_jump_to_god_reply", false);
            this.hEA = intent.getBooleanExtra("key_jump_to_comment_area", false);
            this.hEB = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
            if (bRH()) {
                setUseStyleImmersiveSticky(false);
            }
            this.source = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
            this.source = com.baidu.tbadk.core.util.ap.isEmpty(this.source) ? "" : this.source;
            this.hES = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
        } else {
            this.eSm = System.currentTimeMillis();
        }
        this.cyx = this.hDW - this.eSm;
        super.onCreate(bundle);
        this.hDU = 0;
        aa(bundle);
        if (this.hEl != null && this.hEl.getPbData() != null) {
            this.hEl.getPbData().AY(this.source);
        }
        initUI();
        if (intent != null && this.hEp != null) {
            this.hEp.hNa = intent.getIntExtra("praise_data", -1);
            if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                if (this.hEN == null) {
                    this.hEN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.25
                        @Override // java.lang.Runnable
                        public void run() {
                            PbActivity.this.hEp.Br("@" + intent.getStringExtra("big_pic_type") + " ");
                        }
                    };
                }
                getSafeHandler().postDelayed(this.hEN, 1500L);
            }
            String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
            if (!TextUtils.isEmpty(stringExtra) && this.hEl != null && this.hEl.getPbData() != null) {
                this.hEl.Bl(stringExtra);
            }
        }
        this.foP = new VoiceManager();
        this.foP.onCreate(getPageContext());
        initData(bundle);
        this.hED = new com.baidu.tbadk.editortools.pb.f();
        bRf();
        this.hEE = (com.baidu.tbadk.editortools.pb.d) this.hED.cJ(getActivity());
        this.hEE.b(this);
        this.hEE.a(this.csE);
        this.hEE.a(this.csx);
        this.hEE.a(this, bundle);
        this.hEE.aqS().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.hEE.aqS().fd(true);
        nY(true);
        this.hEp.setEditorTools(this.hEE.aqS());
        this.hEE.a(this.hEl.bSW(), this.hEl.bSJ(), this.hEl.bTo());
        registerListener(this.hEZ);
        if (!this.hEl.bSP()) {
            this.hEE.pZ(this.hEl.bSJ());
        }
        if (this.hEl.bTp()) {
            this.hEE.pX(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else if (this.hEp != null) {
            this.hEE.pX(this.hEp.bUj());
        }
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        registerListener(this.hEY);
        registerListener(this.hFa);
        registerListener(this.hFb);
        registerListener(this.fql);
        registerListener(this.hFp);
        registerListener(this.hEX);
        this.hEC = new com.baidu.tieba.tbadkCore.data.f("pb", com.baidu.tieba.tbadkCore.data.f.iYf);
        this.hEC.clY();
        registerListener(this.hFd);
        registerListener(this.mAttentionListener);
        if (this.hEl != null) {
            this.hEl.bTg();
        }
        registerListener(this.hFt);
        registerListener(this.hFJ);
        registerListener(this.fqs);
        if (this.hEp != null && this.hEp.bVh() != null && this.hEp.bVi() != null) {
            this.hDQ = new com.baidu.tieba.pb.pb.main.b.b(getActivity(), this.hEp.bVh(), this.hEp.bVi(), this.hEp.bUp());
            this.hDQ.a(this.hFl);
        }
        if (this.hDP && this.hEp != null && this.hEp.bVi() != null) {
            this.hEp.bVi().setVisibility(8);
        }
        this.hEL = new com.baidu.tbadk.core.view.e();
        this.hEL.bXG = 1000L;
        registerListener(this.hFo);
        registerListener(this.hFm);
        registerListener(this.hFn);
        registerListener(this.fGa);
        registerListener(this.fqi);
        this.hEM = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.hEM;
        userMuteAddAndDelCustomMessage.setTag(this.hEM);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.hEM;
        userMuteCheckCustomMessage.setTag(this.hEM);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.hEl.bTm().a(this.dVA);
        this.hEu = new as();
        if (this.hEE.ars() != null) {
            this.hEu.k(this.hEE.ars().getInputView());
        }
        this.hEE.a(this.csy);
        this.fEP = new ShareSuccessReplyToServerModel();
        a(this.hEU);
        this.gPO = new com.baidu.tbadk.core.util.aj(getPageContext());
        this.gPO.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.26
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z) {
                    if (i == com.baidu.tbadk.core.util.aj.bSh) {
                        PbActivity.this.hEE.a((String) null, (WriteData) null);
                    } else if (i == com.baidu.tbadk.core.util.aj.bSi && PbActivity.this.hEp != null && PbActivity.this.hEp.bUg() != null && PbActivity.this.hEp.bUg().bSA() != null) {
                        PbActivity.this.hEp.bUg().bSA().arL();
                    } else if (i == com.baidu.tbadk.core.util.aj.bSj) {
                        PbActivity.this.c(PbActivity.this.hEH);
                    }
                }
            }
        });
        this.hEm = new com.baidu.tieba.pb.pb.report.a(this);
        this.hEm.r(getUniqueId());
        com.baidu.tieba.q.c.clw().u(getUniqueId());
        com.baidu.tbadk.core.business.a.abt().bB("3", "");
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.jT() && TbadkApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
        }
        this.createTime = System.currentTimeMillis() - this.hDW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRf() {
        if (this.hED != null && this.hEl != null) {
            this.hED.setForumName(this.hEl.bQJ());
            if (this.hEl.getPbData() != null && this.hEl.getPbData().getForum() != null) {
                this.hED.a(this.hEl.getPbData().getForum());
            }
            this.hED.setFrom("pb");
            this.hED.a(this.hEl);
        }
    }

    public String bRg() {
        return this.source;
    }

    public com.baidu.tieba.pb.pb.main.b.b bRh() {
        return this.hDQ;
    }

    private void nY(boolean z) {
        this.hEE.fh(z);
        this.hEE.fi(z);
        this.hEE.fj(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        View childAt;
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bQk() && !z && this.hEp != null && this.hEp.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
            this.hEp.getView().setSystemUiVisibility(4);
        }
        this.hEI = z;
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

    public aq bRi() {
        return this.hEp;
    }

    public PbModel bQS() {
        return this.hEl;
    }

    public void Bb(String str) {
        if (this.hEl != null && !StringUtils.isNull(str) && this.hEp != null) {
            this.hEp.oN(true);
            this.hEl.Bb(str);
            this.hEc = true;
            this.hEp.bUT();
            this.hEp.bVc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
            this.hDS = false;
        } else {
            this.hDS = true;
        }
        super.onPause();
        BdListView listView = getListView();
        this.hDU = CompatibleUtile.getInstance().getViewLayer(listView);
        if (this.hDU == 1) {
            CompatibleUtile.getInstance().noneViewGpu(listView);
        }
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        if (this.hEp != null) {
            this.hEp.onPause();
        }
        if (!this.hEl.bSP()) {
            this.hEE.pY(this.hEl.bSJ());
        }
        if (this.hEl != null) {
            this.hEl.bTh();
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
        MessageManager.getInstance().unRegisterListener(this.gtM);
        bvC();
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().unRegisterListener(this.hFo);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
    }

    private boolean bRj() {
        PostData a2 = com.baidu.tieba.pb.data.e.a(this.hEl.getPbData(), this.hEl.bSK(), this.hEl.getRequestType());
        return (a2 == null || a2.adv() == null || a2.adv().getGodUserData() == null || a2.adv().getGodUserData().getType() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.hDS = false;
        super.onResume();
        if (this.hEf) {
            this.hEf = false;
            bRN();
        }
        if (bRj()) {
            this.hDZ = System.currentTimeMillis();
        } else {
            this.hDZ = -1L;
        }
        if (this.hEp != null && this.hEp.getView() != null) {
            if (!this.hhn) {
                bRE();
            } else {
                hideLoadingView(this.hEp.getView());
            }
            this.hEp.onResume();
        }
        if (this.hDU == 1) {
            CompatibleUtile.getInstance().closeViewGpu(getListView());
        }
        NoNetworkView noNetworkView = null;
        if (this.hEp != null) {
            noNetworkView = this.hEp.bUd();
        }
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && com.baidu.adp.lib.util.j.jS()) {
            noNetworkView.ek(false);
        }
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        registerListener(this.gtM);
        this.hEy = false;
        bRM();
        registerListener(this.hFm);
        registerListener(this.hFn);
        registerListener(this.hFo);
        if (this.fpF) {
            bRD();
            this.fpF = false;
        }
        bRV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hEp.oC(z);
        if (this.hEv != null) {
            this.hEv.dismiss();
        }
        if (z && this.hEy) {
            this.hEp.bUD();
            this.hEl.oo(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hDZ > 0) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10804").bT("obj_duration", (System.currentTimeMillis() - this.hDZ) + ""));
            this.hDZ = 0L;
        }
        if (bRi().bUg() != null) {
            bRi().bUg().onStop();
        }
        if (this.hEp.hNh != null && !this.hEp.hNh.aYy()) {
            this.hEp.hNh.bGY();
        }
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().getForum() != null && this.hEl.getPbData().bPM() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "pb", this.hEl.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEl.getPbData().bPM().getId(), 0L));
        }
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
        com.baidu.tieba.q.c.clw().b(getUniqueId(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.q.c.clw().v(getUniqueId());
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
        customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c13266");
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("fid", this.hEl.getPbData().getForumId());
            amVar.bT("tid", this.hEl.bSJ());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(amVar);
            TbadkCoreApplication.getInst().setTaskId("");
        }
        if (!this.hDX && this.hEp != null) {
            this.hDX = true;
            this.hEp.bUY();
            a(false, (PostData) null);
        }
        if (this.hEl != null) {
            this.hEl.cancelLoadData();
            this.hEl.destory();
            if (this.hEl.bTl() != null) {
                this.hEl.bTl().onDestroy();
            }
        }
        if (this.hEE != null) {
            this.hEE.onDestroy();
        }
        if (this.eyy != null) {
            this.eyy.cancelLoadData();
        }
        if (this.hEp != null) {
            this.hEp.onDestroy();
            if (this.hEp.hNh != null) {
                this.hEp.hNh.bGY();
            }
        }
        if (this.hDY != null) {
            this.hDY.auc();
        }
        if (this.hDQ != null) {
            this.hDQ.avm();
        }
        super.onDestroy();
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        this.hEp.bUT();
        MessageManager.getInstance().unRegisterListener(this.hFm);
        MessageManager.getInstance().unRegisterListener(this.hFn);
        MessageManager.getInstance().unRegisterListener(this.hFo);
        MessageManager.getInstance().unRegisterListener(this.hEM);
        MessageManager.getInstance().unRegisterListener(this.hFp);
        MessageManager.getInstance().unRegisterListener(this.fqs);
        MessageManager.getInstance().unRegisterListener(this.fGa);
        MessageManager.getInstance().unRegisterListener(this.hFr);
        this.hEK = null;
        this.hEL = null;
        com.baidu.tieba.recapp.d.a.cfC().cfE();
        if (this.hEN != null) {
            getSafeHandler().removeCallbacks(this.hEN);
        }
        if (this.hEg != null) {
            this.hEg.cancelLoadData();
        }
        if (this.hEp != null && this.hEp.hNh != null) {
            this.hEp.hNh.bVU();
        }
        if (this.fEP != null) {
            this.fEP.cancelLoadData();
        }
        this.hEu.onDestroy();
        if (this.hEl != null && this.hEl.bTn() != null) {
            this.hEl.bTn().onDestroy();
        }
        if (this.gPO != null) {
            this.gPO.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostData postData) {
        f bUy;
        ArrayList<PostData> bSl;
        String str;
        String str2;
        String str3;
        String str4 = null;
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.akW() && this.hEp != null && (bUy = this.hEp.bUy()) != null && (bSl = bUy.bSl()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PostData> it = bSl.iterator();
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
                } else if (next.bJB == 1 && !TextUtils.isEmpty(id)) {
                    next.bJB = 2;
                    a.b bVar2 = new a.b();
                    bVar2.mPid = id;
                    bVar2.eAv = i;
                    arrayList.add(bVar2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.hEl == null || this.hEl.getPbData() == null || this.hEl.getPbData().getForum() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    str3 = this.hEl.getPbData().getForum().getFirst_class();
                    str2 = this.hEl.getPbData().getForum().getSecond_class();
                    str = this.hEl.getPbData().getForum().getId();
                    str4 = this.hEl.bSJ();
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
            this.hEp.onChangeSkinType(i);
            if (this.hEE != null && this.hEE.aqS() != null) {
                this.hEE.aqS().onChangeSkinType(i);
            }
            if (this.hEp.bUd() != null) {
                this.hEp.bUd().onChangeSkinType(getPageContext(), i);
            }
            this.hEu.onChangeSkinType();
            UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), com.baidu.tbadk.core.util.al.a(i, getResources(), (int) R.color.cp_bg_line_d));
            this.mSkinType = i;
        }
    }

    private void initUI() {
        this.hEp = new aq(this, this.fra, this.ckh);
        this.dWj = new com.baidu.tieba.f.b(getActivity());
        this.dWj.a(hFC);
        this.dWj.a(this.dWk);
        this.hEp.setOnScrollListener(this.mOnScrollListener);
        this.hEp.e(this.fJc);
        this.hEp.setListPullRefreshListener(this.cXK);
        this.hEp.nS(com.baidu.tbadk.core.i.abb().abf());
        this.hEp.setOnImageClickListener(this.cIN);
        this.hEp.b(this.cll);
        this.hEp.h(this.fmv);
        this.hEp.a(this.hFv);
        this.hEp.oC(this.mIsLogin);
        if (getIntent() != null) {
            this.hEp.oO(getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
        }
        this.hEp.bUf().setFromForumId(this.hEl.getFromForumId());
    }

    public void bRk() {
        if (this.hEp != null && this.hEl != null) {
            if ((this.hEl.getPbData() != null || this.hEl.getPbData().bQj() != null) && checkUpIsLogin() && this.hEp.bUy() != null && this.hEp.bUy().bSq() != null) {
                this.hEp.bUy().bSq().oB(this.hEl.bSJ());
            }
        }
    }

    public void bRl() {
        TiebaStatic.log("c12181");
        if (this.hEp != null && this.hEl != null) {
            if (this.hEp == null || this.hEp.bUi()) {
                if (this.hEl.getPbData() != null || this.hEl.getPbData().bQj() != null) {
                    com.baidu.tieba.pb.data.j bQj = this.hEl.getPbData().bQj();
                    if (checkUpIsLogin()) {
                        if ((!bQj.bQs() || bQj.aeR() != 2) && this.hEp.bUy() != null && this.hEp.bUy().bSq() != null) {
                            this.hEp.bUy().bSq().oB(this.hEl.bSJ());
                        }
                        if (System.currentTimeMillis() - this.hEb > 2000) {
                            new PbFullScreenFloatingHuajiAninationView(getActivity()).ph(false);
                            this.hEb = System.currentTimeMillis();
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
                if (postData.getType() != PostData.iYH && !TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.i.abb().abf()) {
                    return Be(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (this.hEl == null || this.hEl.getPbData() == null) {
                        return true;
                    }
                    if (bRi().bUg() != null) {
                        bRi().bUg().bSw();
                    }
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.a(this.hEl.getPbData().getForum());
                    kVar.ai(this.hEl.getPbData().bPM());
                    kVar.e(postData);
                    bRi().bUf().d(kVar);
                    bRi().bUf().setPostId(postData.getId());
                    a(view, postData.adv().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.hEE != null) {
                        this.hEp.oI(this.hEE.arz());
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
        if (this.hEp != null) {
            if (z && !this.hhn) {
                bRE();
            } else {
                hideLoadingView(this.hEp.getView());
            }
            if (z && this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bQk() && this.hEp.getView() != null && !TbSingleton.getInstance().isNotchScreen(this) && !TbSingleton.getInstance().isCutoutScreen(this)) {
                this.hEp.getView().setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    private void bRm() {
        if (this.hDV == null) {
            this.hDV = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hDV.a(new String[]{getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.29
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        PbActivity.this.hDK = PbActivity.this.hDK.trim();
                        UtilHelper.callPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDK);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEl.bSJ(), PbActivity.this.hDK, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(PbActivity.this.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                        PbActivity.this.hDK = PbActivity.this.hDK.trim();
                        UtilHelper.smsPhone(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDK);
                        new com.baidu.tieba.pb.pb.main.a(PbActivity.this.hEl.bSJ(), PbActivity.this.hDK, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        PbActivity.this.hDK = PbActivity.this.hDK.trim();
                        UtilHelper.startBaiDuBar(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hDK);
                        bVar.dismiss();
                    }
                }
            }).ht(R.style.dialog_ani_b2t).hu(17).d(getPageContext());
        }
    }

    private void aa(Bundle bundle) {
        this.hEl = new PbModel(this);
        this.hEl.a(this.hFs);
        if (this.hEl.bTk() != null) {
            this.hEl.bTk().a(this.hFE);
        }
        if (this.hEl.bTj() != null) {
            this.hEl.bTj().a(this.hFc);
        }
        if (this.hEl.bTl() != null) {
            this.hEl.bTl().b(this.hEW);
        }
        if (bundle != null) {
            this.hEl.initWithBundle(bundle);
        } else {
            this.hEl.initWithIntent(getIntent());
        }
        if (getIntent().getIntExtra(IntentConfig.REQUEST_CODE, -1) == 18003) {
            this.hEl.or(true);
        }
        aj.bTS().aq(this.hEl.bSH(), this.hEl.getIsFromMark());
        if (StringUtils.isNull(this.hEl.bSJ())) {
            finish();
            return;
        }
        if ("from_tieba_kuang".equals(this.hEd) && this.hEd != null) {
            this.hEl.xw(6);
        }
        this.hEl.atv();
    }

    private void initData(Bundle bundle) {
        this.hEn = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.hEn != null) {
            this.hEn.a(this.hFu);
        }
        this.eyy = new ForumManageModel(this);
        this.eyy.setLoadDataCallBack(this.eyC);
        this.bSm = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.hEp.a(new b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.30
            @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
            public void m(Object obj) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    PbActivity.this.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(PbActivity.this.hEl.getPbData().getUserData().getUserId());
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
                PbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(PbActivity.this.getPageContext().getPageActivity(), PbActivity.this.hEl.getPbData().getForum().getId(), PbActivity.this.hEl.getPbData().getForum().getName(), PbActivity.this.hEl.getPbData().bPM().getId(), valueOf, str, str3, str2, str4)));
            }
        });
        this.hFi.setUniqueId(getUniqueId());
        this.hFi.registerListener();
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.hEp.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.hEM;
        userMuteCheckCustomMessage.setTag(this.hEM);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void bRn() {
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
                            PbActivity.this.hEp.buP();
                        }
                    }
                });
            }
            if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().getForum() != null) {
                this.fsx.t(this.hEl.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRo() {
        com.baidu.tieba.pb.data.d pbData;
        if (this.hEl != null && (pbData = this.hEl.getPbData()) != null) {
            return pbData.bPX().forum_top_list;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPM() != null) {
            if (dVar.bPM().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPM().getThreadType() == 54) {
                return 2;
            }
            if (dVar.bPM().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, String str, String str2) {
        if (view != null && str != null && str2 != null && bRp()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.hEi);
                this.hEj = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.hEG == null) {
                this.hEG = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hEG.si(1);
                this.hEG.a(new AnonymousClass40(str, str2));
            }
            if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().getForum() != null) {
                this.hEG.t(this.hEl.getPbData().getForum().getId(), com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.pb.main.PbActivity$40  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass40 implements c.a {
        final /* synthetic */ String hFT;
        final /* synthetic */ String hFU;

        AnonymousClass40(String str, String str2) {
            this.hFT = str;
            this.hFU = str2;
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
                        PbActivity.this.bRi().getListView().smoothScrollBy((PbActivity.this.hEi[1] + PbActivity.this.hEj) - (ah - g), 50);
                        if (PbActivity.this.bRi().bUg() != null) {
                            PbActivity.this.hEE.aqS().setVisibility(8);
                            PbActivity.this.bRi().bUg().Y(AnonymousClass40.this.hFT, AnonymousClass40.this.hFU, PbActivity.this.bRi().bUj());
                            com.baidu.tbadk.editortools.pb.g bSA = PbActivity.this.bRi().bUg().bSA();
                            if (bSA != null && PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                                bSA.a(PbActivity.this.hEl.getPbData().getAnti());
                            }
                            if (PbActivity.this.hEu.bVv() == null && PbActivity.this.bRi().bUg().bSA().arT() != null) {
                                PbActivity.this.bRi().bUg().bSA().arT().c(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.40.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (PbActivity.this.hEu != null && PbActivity.this.hEu.bVu() != null) {
                                            if (!PbActivity.this.hEu.bVu().cwg()) {
                                                PbActivity.this.hEu.oQ(false);
                                            }
                                            PbActivity.this.hEu.bVu().rL(false);
                                        }
                                    }
                                });
                                PbActivity.this.hEu.l(PbActivity.this.bRi().bUg().bSA().arT().getInputView());
                                PbActivity.this.bRi().bUg().bSA().a(PbActivity.this.hEJ);
                            }
                        }
                        PbActivity.this.bRi().bVc();
                    }
                }, 0L);
            }
        }
    }

    public boolean bRp() {
        if (this.gPO == null || this.hEl.getPbData() == null || this.hEl.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPO.hZ(this.hEl.getPbData().getAnti().replyPrivateFlag);
    }

    public boolean xf(int i) {
        if (this.gPO == null || this.hEl.getPbData() == null || this.hEl.getPbData().getAnti() == null) {
            return true;
        }
        return this.gPO.R(this.hEl.getPbData().getAnti().replyPrivateFlag, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SparseArray<Object> sparseArray) {
        PostData postData;
        if (checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null && this.hEl != null && this.hEl.getPbData() != null && postData.cmx() != 1) {
            String bSJ = this.hEl.bSJ();
            String id = postData.getId();
            int bPY = this.hEl.getPbData() != null ? this.hEl.getPbData().bPY() : 0;
            c Bf = Bf(id);
            if (Bf != null) {
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(bSJ, id, "pb", true, null, false, null, bPY, postData.bWI(), this.hEl.getPbData().getAnti(), false, postData.adv() != null ? postData.adv().getIconInfo() : null).addBigImageData(Bf.hGk, Bf.hGl, Bf.hGm, Bf.index);
                addBigImageData.setKeyPageStartFrom(this.hEl.bTr());
                addBigImageData.setFromFrsForumId(this.hEl.getFromForumId());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRq() {
        if (this.hEl.getPbData() == null || this.hEl.getPbData().bPM() == null) {
            return -1;
        }
        return this.hEl.getPbData().bPM().aef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        if (TbadkCoreApplication.isLogin() && AddExperiencedModel.Ds(this.hEl.getForumId()) && this.hEl.getPbData() != null && this.hEl.getPbData().getForum() != null) {
            if (this.hEl.getPbData().getForum().isLike() == 1) {
                this.hEl.bTn().ed(this.hEl.getForumId(), this.hEl.bSJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nZ(boolean z) {
        if (this.hEl == null || this.hEl.getPbData() == null) {
            return false;
        }
        return ((this.hEl.getPbData().bPY() != 0) || this.hEl.getPbData().bPM() == null || this.hEl.getPbData().bPM().adv() == null || TextUtils.equals(this.hEl.getPbData().bPM().adv().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public String bRs() {
        com.baidu.tieba.pb.data.d pbData;
        if (!com.baidu.tbadk.t.y.auI()) {
            return "";
        }
        PostData bPT = bPT();
        if (this.hEl == null || (pbData = this.hEl.getPbData()) == null || pbData.getUserData() == null || pbData.bPM() == null || bPT == null || bPT.adv() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !bPT.adv().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.bPM().adc() == 0) {
            return "";
        }
        if (pbData.bPM().adc() == 0) {
            return getPageContext().getString(R.string.fans_call);
        }
        return getPageContext().getString(R.string.haved_fans_call);
    }

    private boolean oa(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.v vVar;
        if (z) {
            return true;
        }
        if (this.hEl == null || this.hEl.getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.bPY() != 0) {
                return pbData.bPY() != 3;
            }
            List<com.baidu.tbadk.core.data.bc> bQh = pbData.bQh();
            if (com.baidu.tbadk.core.util.v.Z(bQh) > 0) {
                for (com.baidu.tbadk.core.data.bc bcVar : bQh) {
                    if (bcVar != null && (vVar = bcVar.bHR) != null && vVar.bFJ && !vVar.isDeleted && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean ob(boolean z) {
        if (z || this.hEl == null || this.hEl.getPbData() == null) {
            return false;
        }
        return ((this.hEl.getPbData().getForum() != null && this.hEl.getPbData().getForum().isBlockBawuDelete) || this.hEl.getPbData().bPY() == 0 || this.hEl.getPbData().bPY() == 3) ? false : true;
    }

    public void bRt() {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().adv() != null) {
            if (this.hEp != null) {
                this.hEp.bUe();
            }
            bg bPM = this.hEl.getPbData().bPM();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bPM.adv().getUserId());
            ab abVar = new ab();
            int bPY = this.hEl.getPbData().bPY();
            if (bPY == 1 || bPY == 3) {
                abVar.hLs = true;
                abVar.hLr = true;
                abVar.hLz = bPM.adq() == 1;
                abVar.hLy = bPM.adr() == 1;
            } else {
                abVar.hLs = false;
                abVar.hLr = false;
            }
            if (bPY == 1002 && !equals) {
                abVar.hLD = true;
            }
            abVar.hLt = oa(equals);
            abVar.hLu = bRu();
            abVar.hLv = ob(equals);
            abVar.ox = this.hEl.bSK();
            abVar.hLq = true;
            abVar.hLp = nZ(equals);
            abVar.hLB = bRs();
            abVar.hLo = equals && this.hEp.bUK();
            abVar.hLw = TbadkCoreApplication.getInst().getSkinType() == 1;
            abVar.hLx = true;
            abVar.isHostOnly = this.hEl.getHostMode();
            abVar.hLA = true;
            if (bPM.adM() == null) {
                abVar.hLC = true;
            } else {
                abVar.hLC = false;
            }
            this.hEp.hNh.a(abVar);
        }
    }

    private boolean bRu() {
        if (this.hEl != null && this.hEl.bSK()) {
            return this.hEl.getPageData() == null || this.hEl.getPageData().acq() != 0;
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

    public int bRv() {
        if (bRi() == null || bRi().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRi().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof com.baidu.tieba.pb.data.i) && ((com.baidu.tieba.pb.data.i) mVar).mType == com.baidu.tieba.pb.data.i.hBZ) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bRw() {
        if (bRi() == null || bRi().getListView() == null) {
            return -1;
        }
        BdTypeListView listView = bRi().getListView();
        List<com.baidu.adp.widget.ListView.m> data = listView.getData();
        int headerViewsCount = listView.getHeaderViewsCount();
        if (data == null || data.size() <= 0) {
            return -1;
        }
        int size = data.size();
        for (int i = 0; i < size; i++) {
            com.baidu.adp.widget.ListView.m mVar = data.get(i);
            if ((mVar instanceof PostData) && mVar.getType() == PostData.iYG) {
                return i + headerViewsCount;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        bRD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.mC(getResources().getString(R.string.mark_done));
            aVar.dT(true);
            aVar.mD(getResources().getString(R.string.mark_like));
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
                    PbActivity.this.bSm.a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), Constants.VIA_SHARE_TYPE_INFO, PbActivity.this.getPageContext().getUniqueId(), PbActivity.this.hEl.getForumId(), "0");
                }
            });
            aVar.b(getPageContext()).afG();
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12527"));
        }
    }

    public void a(boolean z, MarkData markData) {
        this.hEp.bUE();
        this.hEl.oq(z);
        if (this.hEn != null) {
            this.hEn.ds(z);
            if (markData != null) {
                this.hEn.a(markData);
            }
        }
        if (this.hEl.ZC()) {
            bRB();
        } else {
            this.hEp.m(this.hEl.getPbData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xd(int i) {
        return i == 2 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc(String str) {
        this.hEm.BA(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (!this.hEl.bSP()) {
                    antiData.setBlock_forum_name(this.hEl.getPbData().getForum().getName());
                    antiData.setBlock_forum_id(this.hEl.getPbData().getForum().getId());
                    antiData.setUser_name(this.hEl.getPbData().getUserData().getUserName());
                    antiData.setUser_id(this.hEl.getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            } else if (bRi() != null) {
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTb));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTb));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTb));
            }
        } else if (i == 230277) {
            qe(str);
        } else {
            this.hEp.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.jbn) ? bVar.jbn : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mD(string);
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
                this.hEp.a(0, bVar.FM, bVar.jbn, z);
            }
            if (bVar.FM) {
                if (bVar.eVt == 1) {
                    ArrayList<PostData> bPO = this.hEl.getPbData().bPO();
                    int size = bPO.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(bPO.get(i).getId())) {
                            i++;
                        } else {
                            bPO.remove(i);
                            break;
                        }
                    }
                    this.hEl.getPbData().bPM().hc(this.hEl.getPbData().bPM().adm() - 1);
                    this.hEp.m(this.hEl.getPbData());
                } else if (bVar.eVt == 0) {
                    bRx();
                } else if (bVar.eVt == 2) {
                    ArrayList<PostData> bPO2 = this.hEl.getPbData().bPO();
                    int size2 = bPO2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= bPO2.get(i2).cmu().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(bPO2.get(i2).cmu().get(i3).getId())) {
                                i3++;
                            } else {
                                bPO2.get(i2).cmu().remove(i3);
                                bPO2.get(i2).cmw();
                                z2 = true;
                                break;
                            }
                        }
                        bPO2.get(i2).DW(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        this.hEp.m(this.hEl.getPbData());
                    }
                    a(bVar, this.hEp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null) {
            this.hEp.a(this.eyy.getLoadDataMode(), gVar.FM, gVar.jbn, false);
            if (gVar.FM) {
                this.hEr = true;
                if (i == 2 || i == 3) {
                    this.hEs = true;
                    this.hEt = false;
                } else if (i == 4 || i == 5) {
                    this.hEs = false;
                    this.hEt = true;
                }
                if (i == 2) {
                    this.hEl.getPbData().bPM().hf(1);
                    this.hEl.setIsGood(1);
                } else if (i == 3) {
                    this.hEl.getPbData().bPM().hf(0);
                    this.hEl.setIsGood(0);
                } else if (i == 4) {
                    this.hEl.getPbData().bPM().he(1);
                    this.hEl.pE(1);
                } else if (i == 5) {
                    this.hEl.getPbData().bPM().he(0);
                    this.hEl.pE(0);
                }
                this.hEp.d(this.hEl.getPbData(), this.hEl.bSK());
            }
        }
    }

    private void bRx() {
        if (this.hEl.bSL() || this.hEl.bSN()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.hEl.bSJ());
            setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.hEl.bSJ()));
        if (bRC()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        CardHListViewData bPV;
        boolean z = false;
        if (this.hEp != null) {
            this.hEp.bUT();
        }
        if (this.hEl != null && this.hEl.getPbData() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.hEl.getPbData().bPM().getId();
            if (this.hEl.isShareThread() && this.hEl.getPbData().bPM().bKQ != null) {
                historyMessage.threadName = this.hEl.getPbData().bPM().bKQ.showText;
            } else {
                historyMessage.threadName = this.hEl.getPbData().bPM().getTitle();
            }
            if (this.hEl.isShareThread() && !bQI()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = this.hEl.getPbData().getForum().getName();
            }
            ArrayList<PostData> bPO = this.hEl.getPbData().bPO();
            int bUG = this.hEp != null ? this.hEp.bUG() : 0;
            if (bPO != null && bUG >= 0 && bUG < bPO.size()) {
                historyMessage.postID = bPO.get(bUG).getId();
            }
            historyMessage.isHostOnly = this.hEl.getHostMode();
            historyMessage.isSquence = this.hEl.bSK();
            historyMessage.isShareThread = this.hEl.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.hEE != null) {
            this.hEE.onDestroy();
        }
        if (this.hDT && bRi() != null) {
            bRi().bVm();
        }
        if (this.hEl != null && (this.hEl.bSL() || this.hEl.bSN())) {
            Intent intent = new Intent();
            intent.putExtra("tid", this.hEl.bSJ());
            if (this.hEr) {
                if (this.hEt) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", this.hEl.bdn());
                }
                if (this.hEs) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", this.hEl.getIsGood());
                }
            }
            if (this.hEl.getPbData() != null && System.currentTimeMillis() - this.hDW >= 40000 && (bPV = this.hEl.getPbData().bPV()) != null && !com.baidu.tbadk.core.util.v.aa(bPV.getDataList())) {
                intent.putExtra("guess_like_data", bPV);
                intent.putExtra("KEY_SMART_FRS_POSITION", this.hES);
            }
            setResult(-1, intent);
        }
        if (bRC()) {
            if (this.hEl != null && this.hEp != null && this.hEp.getListView() != null) {
                com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!pbData.bPS() && !this.hEc && pbData.hBH == null) {
                        aj bTS = aj.bTS();
                        com.baidu.tieba.pb.data.d bSR = this.hEl.bSR();
                        Parcelable onSaveInstanceState = this.hEp.getListView().onSaveInstanceState();
                        boolean bSK = this.hEl.bSK();
                        boolean hostMode = this.hEl.getHostMode();
                        if (this.hEp.bUp() != null && this.hEp.bUp().getVisibility() == 0) {
                            z = true;
                        }
                        bTS.a(bSR, onSaveInstanceState, bSK, hostMode, z);
                        if (this.hER >= 0 || this.hEl.bTt() != null) {
                            aj.bTS().l(this.hEl.bTt());
                            aj.bTS().k(this.hEl.bTu());
                            aj.bTS().xy(this.hEl.bTv());
                        }
                    }
                }
            } else {
                aj.bTS().reset();
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || this.hEp == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hEp.xD(i)) {
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
            this.hEp.bUe();
            this.hEp.bUg().bSw();
            this.hEp.oK(false);
        }
        this.hEp.bUh();
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
                        this.hEE.resetData();
                        this.hEE.b(writeData);
                        this.hEE.setVoiceModel(pbEditorData.getVoiceModel());
                        com.baidu.tbadk.editortools.k kj = this.hEE.aqS().kj(6);
                        if (kj != null && kj.cqF != null) {
                            kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        if (i == -1) {
                            this.hEE.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.hEp.bUg() != null && this.hEp.bUg().bSA() != null) {
                            com.baidu.tbadk.editortools.pb.g bSA = this.hEp.bUg().bSA();
                            bSA.b(writeData);
                            bSA.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.k kj2 = bSA.aqS().kj(6);
                            if (kj2 != null && kj2.cqF != null) {
                                kj2.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                bSA.arL();
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
        this.hEE.onActivityResult(i, i2, intent);
        if (this.hEg != null) {
            this.hEg.onActivityResult(i, i2, intent);
        }
        if (bRi().bUg() != null) {
            bRi().bUg().onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN /* 11009 */:
                    bRA();
                    return;
                case 13008:
                    aj.bTS().reset();
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PbActivity.this.hEl != null) {
                                PbActivity.this.hEl.LoadData();
                            }
                        }
                    }, 1000L);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.ceu().w(getPageContext());
                    return;
                case 23003:
                    if (intent != null && this.hEl != null) {
                        a(bRz(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    ag(intent);
                    return;
                case 24007:
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        com.baidu.tieba.n.a.ceu().w(getPageContext());
                        bRr();
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
                    this.hEp.nX(false);
                    if (this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().adP() != null) {
                        this.hEl.getPbData().bPM().adP().setStatus(2);
                        break;
                    }
                    break;
                case 25012:
                    break;
                case 25016:
                case 25023:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.hEH = emotionImageData;
                        if (xf(com.baidu.tbadk.core.util.aj.bSj)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case 25028:
                    if (intent.getBooleanExtra(GodFansCallWebViewActivityConfig.IS_REFRESH, false) && this.hEp != null && this.hEp.hNh != null) {
                        this.hEp.hNh.TU();
                        this.hEp.hNh.bVO();
                        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null) {
                            this.hEl.getPbData().bPM().ha(1);
                            return;
                        }
                        return;
                    }
                    return;
                case 25033:
                    if (this.hEh != null) {
                        this.hEp.cB(this.hEh);
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
            if (this.hEg == null) {
                this.hEg = new com.baidu.tieba.pb.pb.main.emotion.model.a(this);
                this.hEg.b(this.csx);
                this.hEg.c(this.csE);
            }
            this.hEg.a(emotionImageData, bQS(), bQS().getPbData());
        }
    }

    private ShareFromPBMsgData bRz() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] ea = this.hEl.getPbData().ea(getPageContext().getPageActivity());
        PostData bUk = this.hEp.bUk();
        String str = "";
        if (bUk != null) {
            str = bUk.getId();
            String el = bUk.el(getPageContext().getPageActivity());
            if (!com.baidu.adp.lib.util.k.isEmpty(el)) {
                ea[1] = el;
            }
        }
        String adL = this.hEl.getPbData().bPM().adL();
        if (adL != null && adL.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(ea[1]);
        shareFromPBMsgData.setImageUrl(ea[0]);
        shareFromPBMsgData.setForumName(this.hEl.getPbData().getForum().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.hEl.getPbData().bPM().getId());
        shareFromPBMsgData.setTitle(this.hEl.getPbData().bPM().getTitle());
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bRz(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hr(1);
            aVar.aF(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.60
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null) {
                        com.baidu.tbadk.core.util.am bT = new com.baidu.tbadk.core.util.am("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_param1", 3).bT("fid", PbActivity.this.hEl.getForumId()).bT("tid", PbActivity.this.hEl.bSJ());
                        if (PbActivity.this.d(PbActivity.this.hEl.getPbData()) != 0) {
                            bT.P("obj_type", PbActivity.this.d(PbActivity.this.hEl.getPbData()));
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
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEl.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final long j2) {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null) {
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
                thread2GroupShareView.ai(shareFromPBMsgData.getImageUrl(), this.hEl.getPbData().getIsNewUrl() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRA() {
        MarkData xv;
        if (this.hEn != null && (xv = this.hEl.xv(this.hEp.bUH())) != null) {
            if (!xv.isApp() || (xv = this.hEl.xv(this.hEp.bUH() + 1)) != null) {
                this.hEp.bUC();
                this.hEn.a(xv);
                if (!this.hEn.ZC()) {
                    this.hEn.ZE();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                    return;
                }
                this.hEn.ZD();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
        this.hEl.oq(true);
        if (this.hEn != null) {
            pbData.AX(this.hEn.ZB());
        }
        this.hEp.m(pbData);
    }

    private boolean bRC() {
        if (this.hEl == null) {
            return true;
        }
        if (this.hEl.ZC()) {
            final MarkData bTb = this.hEl.bTb();
            if (bTb == null || !this.hEl.getIsFromMark()) {
                return true;
            }
            final MarkData xv = this.hEl.xv(this.hEp.bUG());
            if (xv == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", bTb);
                setResult(-1, intent);
                return true;
            } else if (xv.getPostId() == null || xv.getPostId().equals(bTb.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", bTb);
                setResult(-1, intent2);
                return true;
            } else {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.mD(getPageContext().getString(R.string.alert_update_mark));
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.64
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        if (PbActivity.this.hEn != null) {
                            if (PbActivity.this.hEn.ZC()) {
                                PbActivity.this.hEn.ZD();
                                PbActivity.this.hEn.ds(false);
                            }
                            PbActivity.this.hEn.a(xv);
                            PbActivity.this.hEn.ds(true);
                            PbActivity.this.hEn.ZE();
                        }
                        bTb.setPostId(xv.getPostId());
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTb);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRy();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.65
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        Intent intent3 = new Intent();
                        intent3.putExtra("mark", bTb);
                        PbActivity.this.setResult(-1, intent3);
                        aVar.dismiss();
                        PbActivity.this.bRy();
                    }
                });
                aVar.b(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.66
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        int[] iArr = new int[2];
                        if (PbActivity.this.hEp != null && PbActivity.this.hEp.getView() != null) {
                            PbActivity.this.hEp.getView().getLocationOnScreen(iArr);
                        }
                        if (iArr[0] > 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", bTb);
                            PbActivity.this.setResult(-1, intent3);
                            aVar.dismiss();
                            PbActivity.this.bRy();
                        }
                    }
                });
                aVar.b(getPageContext());
                aVar.afG();
                return false;
            }
        } else if (this.hEl.getPbData() == null || this.hEl.getPbData().bPO() == null || this.hEl.getPbData().bPO().size() <= 0 || !this.hEl.getIsFromMark()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.widget.richText.e
    public BdListView getListView() {
        if (this.hEp == null) {
            return null;
        }
        return this.hEp.getListView();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int ayg() {
        if (this.hEp == null) {
            return 0;
        }
        return this.hEp.bUR();
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> ayh() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.67
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
        return this.cIE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> ayi() {
        if (this.cLt == null) {
            this.cLt = TbRichTextView.s(getPageContext().getPageActivity(), 8);
        }
        return this.cLt;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> ayj() {
        if (this.cIF == null) {
            this.cIF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.69
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRX */
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
        return this.cIF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> ayk() {
        if (this.cLu == null) {
            this.cLu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.70
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bRY */
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
                    ((PlayVoiceBntNew) view).cnG();
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
        return this.cLu;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> aym() {
        this.cLw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.71
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bRZ */
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
        return this.cLw;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ajZ() {
        if (this.cbQ == null) {
            this.cbQ = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cbQ;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.hEa = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void d(Context context, String str, boolean z) {
        if (av.Bs(str) && this.hEl != null && this.hEl.bSJ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11664").P("obj_param1", 1).bT("post_id", this.hEl.bSJ()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                kVar.mLink = str;
                kVar.type = 3;
                kVar.cpG = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
            }
        } else {
            av.bVx().c(getPageContext(), str);
        }
        this.hEa = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        av.bVx().c(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.hEa = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Rect rect) {
        if (rect != null && this.hEp != null && this.hEp.bVh() != null && rect.top <= this.hEp.bVh().getHeight()) {
            rect.top += this.hEp.bVh().getHeight() - rect.top;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, c cVar) {
        TbRichTextData tbRichTextData;
        int i2;
        if (cVar != null) {
            com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
            TbRichText bd = bd(str, i);
            if (bd != null && (tbRichTextData = bd.axz().get(this.hFx)) != null) {
                cVar.hGk = new ArrayList<>();
                cVar.hGl = new ConcurrentHashMap<>();
                if (!tbRichTextData.axG().axS()) {
                    cVar.hGn = false;
                    String b2 = com.baidu.tieba.pb.data.e.b(tbRichTextData);
                    cVar.hGk.add(b2);
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
                    imageUrlData.mIsReserver = this.hEl.bSZ();
                    imageUrlData.mIsSeeHost = this.hEl.getHostMode();
                    cVar.hGl.put(b2, imageUrlData);
                    if (pbData != null) {
                        if (pbData.getForum() != null) {
                            cVar.forumName = pbData.getForum().getName();
                            cVar.forumId = pbData.getForum().getId();
                        }
                        if (pbData.bPM() != null) {
                            cVar.threadId = pbData.bPM().getId();
                        }
                        cVar.hGm = pbData.getIsNewUrl() == 1;
                    }
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(cVar.threadId, -1L);
                    return;
                }
                cVar.hGn = true;
                int size = pbData.bPO().size();
                this.hFy = false;
                cVar.index = -1;
                if (pbData.bPT() != null) {
                    PostData bPT = pbData.bPT();
                    TbRichText cmz = bPT.cmz();
                    if (!ap.m(bPT)) {
                        i2 = a(cmz, bd, i, i, cVar.hGk, cVar.hGl);
                    } else {
                        i2 = a(bPT, i, cVar.hGk, cVar.hGl);
                    }
                } else {
                    i2 = i;
                }
                int i3 = i2;
                for (int i4 = 0; i4 < size; i4++) {
                    PostData postData = pbData.bPO().get(i4);
                    if (postData.getId() == null || pbData.bPT() == null || pbData.bPT().getId() == null || !postData.getId().equals(pbData.bPT().getId())) {
                        TbRichText cmz2 = postData.cmz();
                        if (!ap.m(postData)) {
                            i3 = a(cmz2, bd, i3, i, cVar.hGk, cVar.hGl);
                        } else {
                            i3 = a(postData, i3, cVar.hGk, cVar.hGl);
                        }
                    }
                }
                if (cVar.hGk.size() > 0) {
                    cVar.lastId = cVar.hGk.get(cVar.hGk.size() - 1);
                }
                if (pbData != null) {
                    if (pbData.getForum() != null) {
                        cVar.forumName = pbData.getForum().getName();
                        cVar.forumId = pbData.getForum().getId();
                    }
                    if (pbData.bPM() != null) {
                        cVar.threadId = pbData.bPM().getId();
                    }
                    cVar.hGm = pbData.getIsNewUrl() == 1;
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
            this.hFy = true;
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
                                imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), -1L);
                                imageUrlData.mIsReserver = this.hEl.bSZ();
                                imageUrlData.mIsSeeHost = this.hEl.getHostMode();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(b2, imageUrlData);
                                }
                            }
                        }
                        if (!this.hFy) {
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
        com.baidu.tieba.tbadkCore.data.i cmG;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> cmc;
        if (postData != null && arrayList != null && concurrentHashMap != null && (cmc = (cmG = postData.cmG()).cmc()) != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 == cmc.size()) {
                    break;
                }
                com.baidu.tieba.tbadkCore.data.k kVar = cmc.get(i3);
                if (kVar != null) {
                    String cmg = kVar.cmg();
                    if (!com.baidu.tbadk.core.util.ap.isEmpty(cmg)) {
                        arrayList.add(cmg);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = cmg;
                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                            imageUrlData.urlType = 38;
                        } else {
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                        }
                        imageUrlData.originalUrl = kVar.cmf();
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(postData.getId(), -1L);
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), -1L);
                        imageUrlData.mIsReserver = this.hEl.bSZ();
                        imageUrlData.mIsSeeHost = this.hEl.getHostMode();
                        imageUrlData.mPicType = 1;
                        imageUrlData.mTagName = cmG.getTagName();
                        if (concurrentHashMap != null) {
                            concurrentHashMap.put(cmg, imageUrlData);
                        }
                        if (!this.hFy) {
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
            if (postData.getId() != null && postData.getId().equals(this.hEl.adE())) {
                z = true;
            }
            MarkData j = this.hEl.j(postData);
            if (j != null) {
                this.hEp.bUC();
                if (this.hEn != null) {
                    this.hEn.a(j);
                    if (!z) {
                        this.hEn.ZE();
                    } else {
                        this.hEn.ZD();
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
        if (this.hEl == null || this.hEl.getPbData() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
        if (pbData.bPT() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(pbData.bPT());
            tbRichText = a(arrayList, str, i);
        }
        if (tbRichText == null) {
            ArrayList<PostData> bPO = pbData.bPO();
            a(pbData, bPO);
            return a(bPO, str, i);
        }
        return tbRichText;
    }

    private void a(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (dVar != null && dVar.bPX() != null && dVar.bPX().hCo != null && (list = dVar.bPX().hCo) != null && arrayList != null) {
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

    private long Bd(String str) {
        ArrayList<PostData> bPO;
        com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
        if (pbData != null && (bPO = pbData.bPO()) != null && !bPO.isEmpty()) {
            Iterator<PostData> it = bPO.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                com.baidu.tieba.tbadkCore.data.i cmG = next.cmG();
                if (cmG != null && cmG.iYn) {
                    Iterator<TbRichTextData> it2 = next.cmz().axz().iterator();
                    while (it2.hasNext()) {
                        TbRichTextData next2 = it2.next();
                        if (next2 != null && next2.getType() == 1024 && next2.axP().getLink().equals(str)) {
                            return cmG.getTemplateId();
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
            TbRichText cmz = arrayList.get(i2).cmz();
            if (cmz != null && (axz = cmz.axz()) != null) {
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
                            this.hFx = i4;
                            return cmz;
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
            this.hDK = str;
            if (this.hDV == null) {
                bRm();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.hDV.hw(1).setVisibility(8);
            } else {
                this.hDV.hw(1).setVisibility(0);
            }
            this.hDV.afJ();
            this.hEa = true;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.foP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRD() {
        hideNetRefreshView(this.hEp.getView());
        bRE();
        if (this.hEl.atv()) {
            this.hEp.bUC();
        }
    }

    private void bRE() {
        showLoadingView(this.hEp.getView(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
        View asC = getLoadingView().asC();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) asC.getLayoutParams();
        layoutParams.addRule(3, this.hEp.bVh().getId());
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
        bg bPM;
        if (this.hEl.hasData()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            com.baidu.tieba.pb.data.d pbData = this.hEl.getPbData();
            pbData.getForum().getName();
            String title = pbData.bPM().getTitle();
            int i2 = this.hEl.getHostMode() ? 1 : 0;
            if (pbData != null && pbData.getForum() != null) {
                if ((pbData.getForum().isLike() == 1) && AddExperiencedModel.Ds(pbData.getForumId())) {
                    z = true;
                    String str3 = "http://tieba.baidu.com/p/" + this.hEl.bSJ() + "?share=9105&fr=share&see_lz=" + i2;
                    String[] ea = pbData.ea(getPageContext().getPageActivity());
                    str = ea[0];
                    if (!StringUtils.isNull(str) && str.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
                    }
                    parse = str != null ? null : Uri.parse(str);
                    str2 = ea[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (bRq() == 1) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10399").bT("fid", pbData.getForumId()).bT("tid", pbData.getThreadId()).bT("uid", currentAccount));
                    }
                    if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
                        str2 = title;
                    }
                    com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                    eVar.title = title;
                    eVar.content = str2;
                    eVar.linkUrl = str3;
                    eVar.cjn = true;
                    eVar.cju = z;
                    eVar.extData = this.hEl.bSJ();
                    eVar.cjG = 3;
                    eVar.cjF = i;
                    eVar.fid = this.hEl.getForumId();
                    eVar.tid = this.hEl.bSJ();
                    eVar.cjK = d(pbData);
                    eVar.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        eVar.imageUri = parse;
                    }
                    bPM = this.hEl.getPbData().bPM();
                    eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPM);
                    TbadkCoreApplication.getInst().setShareItem(eVar);
                    if (bPM != null) {
                        eVar.cjU = bPM.getShareImageUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", eVar.cjG);
                    bundle.putInt("obj_type", eVar.cjK);
                    bundle.putString("fid", eVar.fid);
                    bundle.putString("tid", eVar.tid);
                    bundle.putString("uid", eVar.uid);
                    eVar.E(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar, true, true);
                    shareDialogConfig.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bQk() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                                PbActivity.this.hEp.getView().setSystemUiVisibility(4);
                            }
                        }
                    });
                    com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
                }
            }
            z = false;
            String str32 = "http://tieba.baidu.com/p/" + this.hEl.bSJ() + "?share=9105&fr=share&see_lz=" + i2;
            String[] ea2 = pbData.ea(getPageContext().getPageActivity());
            str = ea2[0];
            if (!StringUtils.isNull(str)) {
                str = str.substring(TbConfig.URL_IMAGE_PREFIX.length());
            }
            if (str != null) {
            }
            str2 = ea2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (bRq() == 1) {
            }
            if (com.baidu.tbadk.core.util.ap.isEmpty(str2)) {
            }
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = str2;
            eVar2.linkUrl = str32;
            eVar2.cjn = true;
            eVar2.cju = z;
            eVar2.extData = this.hEl.bSJ();
            eVar2.cjG = 3;
            eVar2.cjF = i;
            eVar2.fid = this.hEl.getForumId();
            eVar2.tid = this.hEl.bSJ();
            eVar2.cjK = d(pbData);
            eVar2.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            bPM = this.hEl.getPbData().bPM();
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bPM);
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            if (bPM != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cjG);
            bundle2.putInt("obj_type", eVar2.cjK);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putString("uid", eVar2.uid);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) getPageContext().getPageActivity(), eVar2, true, true);
            shareDialogConfig2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.78
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PbActivity.this.hEl != null && PbActivity.this.hEl.getPbData() != null && PbActivity.this.hEl.getPbData().bQk() && !TbSingleton.getInstance().isNotchScreen(PbActivity.this) && !TbSingleton.getInstance().isCutoutScreen(PbActivity.this)) {
                        PbActivity.this.hEp.getView().setSystemUiVisibility(4);
                    }
                }
            });
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPM() != null) {
            if (dVar.bPM().getThreadType() == 0) {
                return 1;
            }
            if (dVar.bPM().getThreadType() == 40) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        com.baidu.tbadk.util.aa.a(new com.baidu.tbadk.util.z<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.80
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                return Boolean.valueOf(AddExperiencedModel.Dt(PbActivity.this.hEl.getForumId()));
            }
        }, new com.baidu.tbadk.util.k<Boolean>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.81
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    PbActivity.this.hEp.bVn();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> ayl() {
        if (this.cLv == null) {
            this.cLv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.82
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bSa */
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
        return this.cLv;
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
        if (this.hEl == null || this.hEl.getPbData() == null) {
            return null;
        }
        return this.hEl.getPbData().getAnti();
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        } else if (aVar.afI() instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) aVar.afI();
            int intValue = ((Integer) sparseArray.get(aq.hPa)).intValue();
            if (intValue == aq.hPb) {
                if (!this.eyy.cni()) {
                    this.hEp.bUz();
                    String str = (String) sparseArray.get(R.id.tag_del_post_id);
                    int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                    boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                    if (jSONArray != null) {
                        this.eyy.Ec(com.baidu.tbadk.core.util.ap.y(jSONArray));
                    }
                    this.eyy.a(this.hEl.getPbData().getForum().getId(), this.hEl.getPbData().getForum().getName(), this.hEl.getPbData().bPM().getId(), str, intValue3, intValue2, booleanValue);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, true));
                }
            } else if (intValue == aq.hPc || intValue == aq.hPe) {
                if (this.hEl.bTk() != null) {
                    this.hEl.bTk().xl(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == aq.hPc) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.hEM);
        userMuteAddAndDelCustomMessage.setTag(this.hEM);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    private boolean Be(String str) {
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

    public void oc(boolean z) {
        this.hEy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bRG() {
        ArrayList<PostData> bPO;
        int Z;
        if (this.hEl == null || this.hEl.getPbData() == null || this.hEl.getPbData().bPO() == null || (Z = com.baidu.tbadk.core.util.v.Z((bPO = this.hEl.getPbData().bPO()))) == 0) {
            return "";
        }
        if (this.hEl.bSZ()) {
            Iterator<PostData> it = bPO.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cmx() == 1) {
                    return next.getId();
                }
            }
        }
        int bUG = this.hEp.bUG();
        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bPO, bUG);
        if (postData == null || postData.adv() == null) {
            return "";
        }
        if (this.hEl.Bi(postData.adv().getUserId())) {
            return postData.getId();
        }
        for (int i = bUG - 1; i != 0; i--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(bPO, i);
            if (postData2 == null || postData2.adv() == null || postData2.adv().getUserId() == null) {
                break;
            } else if (this.hEl.Bi(postData2.adv().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i2 = bUG + 1; i2 < Z; i2++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(bPO, i2);
            if (postData3 == null || postData3.adv() == null || postData3.adv().getUserId() == null) {
                return "";
            }
            if (this.hEl.Bi(postData3.adv().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ba.aiz().c(getPageContext(), new String[]{str})) {
                com.baidu.tieba.pb.a.a(Bd(str), str, "PB", "BUTTON", "CLICK", "tpoint", this.hEl.getPbData().getForum().getId(), this.hEl.getPbData().getForum().getName(), this.hEl.getPbData().bPM().getTid());
            }
            this.hEa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j, final String str, final String str2, final String str3, final String str4, int i) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        if (i > 0) {
            aVar.mD(getResources().getString(R.string.make_sure_hide_n_day, Integer.valueOf(i)));
        } else {
            aVar.mD(getResources().getString(R.string.make_sure_hide));
        }
        aVar.a(getResources().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.88
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                com.baidu.tieba.pb.a.a(j, str, null, "PB", "BTN_FBOK", "CLICK_FEEDBACK", "tpoint", null, null, str2, str3, str4);
                aVar2.dismiss();
                if (PbActivity.this.checkUpIsLogin() && PbActivity.this.hEl.bTj() != null) {
                    PbActivity.this.hEl.bTj().eb(j);
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
    public c Bf(String str) {
        String str2;
        if (this.hEl.getPbData() == null || this.hEl.getPbData().bPO() == null || this.hEl.getPbData().bPO().size() == 0 || StringUtils.isNull(str)) {
            return null;
        }
        c cVar = new c();
        int i = 0;
        while (true) {
            if (i >= this.hEl.getPbData().bPO().size()) {
                i = 0;
                break;
            } else if (str.equals(this.hEl.getPbData().bPO().get(i).getId())) {
                break;
            } else {
                i++;
            }
        }
        PostData postData = this.hEl.getPbData().bPO().get(i);
        if (postData.cmz() == null || postData.cmz().axz() == null) {
            return null;
        }
        Iterator<TbRichTextData> it = postData.cmz().axz().iterator();
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
        if (this.hDR) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.hDR = false;
        } else if (bRH()) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.hDR) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            this.hDR = false;
        } else if (bRH()) {
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
        if (pageStayDurationItem != null && this.hEl != null) {
            if (this.hEl.getPbData() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.hEl.getPbData().getForumId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), 0L));
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                pageStayDurationItem.setTaskId(TbadkCoreApplication.getInst().getTaskId());
            }
        }
        return pageStayDurationItem;
    }

    public boolean bRH() {
        return (!this.hDP && this.hFF == -1 && this.hFG == -1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.o oVar) {
        if (oVar != null) {
            this.hFI = oVar;
            this.hDP = true;
            this.hEp.bUq();
            this.hEp.Bq(this.hFH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        if (this.hFI != null) {
            if (this.hFF == -1) {
                showToast(R.string.pb_manga_not_prev_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFI.getCartoonId(), this.hFF, 0)));
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRJ() {
        if (this.hFI != null) {
            if (this.hFG == -1) {
                showToast(R.string.pb_manga_not_next_exist);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.hFI.getCartoonId(), this.hFG, 0)));
                finish();
            }
        }
    }

    public int bRK() {
        return this.hFF;
    }

    public int bRL() {
        return this.hFG;
    }

    private void bvC() {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    private void bRM() {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().aep()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void bRN() {
        if (this.hDS) {
            this.hEf = true;
        } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().adb() != null) {
            sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.hEl.getPbData().bPM().adb().getThreadId(), this.hEl.getPbData().bPM().adb().getTaskId(), this.hEl.getPbData().bPM().adb().getForumId(), this.hEl.getPbData().bPM().adb().getForumName(), this.hEl.getPbData().bPM().adq(), this.hEl.getPbData().bPM().adr())));
            this.hDR = true;
            finish();
        }
    }

    public String bRO() {
        return this.hEd;
    }

    public String getStType() {
        return this.mStType;
    }

    public PbInterviewStatusView.a bRP() {
        return this.hEk;
    }

    public void od(boolean z) {
        this.hEe = z;
    }

    public boolean bRQ() {
        if (this.hEl != null) {
            return this.hEl.bSL();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.mD(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.90
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) PbActivity.this.hEK).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) PbActivity.this.hEK.getPageActivity(), 2, true, 4);
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
        aVar.b(this.hEK).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(String str) {
        if (str == null) {
            str = "";
        }
        if (this.hEK != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEK.getPageActivity());
            aVar.mD(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.92
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hEK).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.hEp.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEK.getPageActivity());
        if (com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            aVar.mD(this.hEK.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.mD(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.93
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                PbActivity.this.hEp.showLoadingDialog();
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
        aVar.b(this.hEK).afG();
    }

    public void bRS() {
        if (this.hEl != null && this.hEl.getPbData() != null && this.hEl.getPbData().bPM() != null && this.hEl.getPbData().bPM().aeF() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.ho(R.string.channel_open_push_message);
            aVar.a(R.string.need_channel_push, new a.b() { // from class: com.baidu.tieba.pb.pb.main.PbActivity.96
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2016513, a.b.a(PbActivity.this.hEl.getPbData().bPM().aeF().channelId, true, PbActivity.this.getUniqueId())));
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
                if (av.Bs(objArr[i].getLink()) && (drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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
        if (configuration.orientation != this.fOj) {
            this.fOj = configuration.orientation;
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
            } else {
                this.isFullScreen = false;
            }
            if (this.hEp != null) {
                this.hEp.onConfigurationChanged(configuration);
            }
            if (this.hEv != null) {
                this.hEv.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921419, configuration));
        }
    }

    public boolean bRT() {
        if (this.hEl != null) {
            return this.hEl.getHostMode();
        }
        return false;
    }

    public void a(ForumManageModel.b bVar, aq aqVar) {
        boolean z;
        List<PostData> list = this.hEl.getPbData().bPX().hCo;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cmu().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cmu().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cmu().remove(i2);
                    list.get(i).cmw();
                    z = true;
                    break;
                }
            }
            list.get(i).DW(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            aqVar.m(this.hEl.getPbData());
        }
    }

    public void c(com.baidu.tieba.pb.data.k kVar) {
        String id = kVar.bQv().getId();
        List<PostData> list = this.hEl.getPbData().bPX().hCo;
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
                ArrayList<PostData> bQz = kVar.bQz();
                postData.Ax(kVar.getTotalCount());
                if (postData.cmu() != null) {
                    postData.cmu().clear();
                    postData.cmu().addAll(bQz);
                }
            }
        }
        if (!this.hEl.getIsFromMark()) {
            this.hEp.m(this.hEl.getPbData());
        }
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bQH() {
        return this.hEq;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bQI() {
        if (this.hEl == null) {
            return false;
        }
        return this.hEl.bQI();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bQJ() {
        if (this.hEl != null) {
            return this.hEl.bQJ();
        }
        return null;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bQK() {
        if (this.hEl == null || this.hEl.getPbData() == null) {
            return 0;
        }
        return this.hEl.getPbData().bPY();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean AZ(String str) {
        return this.hEl != null && this.hEl.Bi(str);
    }

    public void bRU() {
        if (this.hEp != null) {
            this.hEp.bUe();
            bki();
        }
    }

    public PostData bPT() {
        return this.hEp.c(this.hEl.hJL, this.hEl.bSK());
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
        if (this.hET != null && !this.hET.isEmpty()) {
            int size = this.hET.size() - 1;
            while (true) {
                int i = size;
                if (i <= -1) {
                    break;
                } else if (!this.hET.get(i).onBackPressed()) {
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
            if (this.hET == null) {
                this.hET = new ArrayList();
            }
            if (!this.hET.contains(aVar)) {
                this.hET.add(aVar);
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            if (this.hET == null) {
                this.hET = new ArrayList();
            }
            if (!this.hET.contains(aVar)) {
                this.hET.add(0, aVar);
            }
        }
    }

    public void c(a aVar) {
        if (aVar != null && this.hET != null) {
            this.hET.remove(aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRV() {
        if (this.hEl != null && !com.baidu.tbadk.core.util.ap.isEmpty(this.hEl.bSJ())) {
            com.baidu.tbadk.BdToken.c.Yk().k(com.baidu.tbadk.BdToken.b.bwW, com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.hEl == null || com.baidu.tbadk.core.util.ap.isEmpty(this.hEl.bSJ())) {
            return 0L;
        }
        return com.baidu.adp.lib.g.b.c(this.hEl.bSJ(), 0L);
    }
}
